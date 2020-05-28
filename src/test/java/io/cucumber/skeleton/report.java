package io.cucumber.skeleton;

import io.cucumber.java.Scenario;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class report {

    private static Scenario scenario;

    // get generated cucumber json reports names
    public static List<String> getfilenames(){
        File folder = new File("output/cucumber");
        File[] listOfFiles = folder.listFiles();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if(listOfFiles[i].getName().contains(".json"))
                    names.add(listOfFiles[i].getName());
            }
        }
        return names;
    }
    public static void robot() throws AWTException {
        Robot rb = new Robot();
        WebElement un = Hooks.driver.findElement(By.name("firstname"));
        int xaxis = un.getLocation().x;
        int yaxis = un.getLocation().y;
        System.out.println("XYaxis:"+xaxis + yaxis);
        int width = un.getSize().width;
        int height = un.getSize().height;
        rb.mouseMove(xaxis + width / 2, yaxis + height / 2 + 70);
        System.out.println("gggg");
//        rb.mousePress(KeyEvent.BUTTON1_MASK);//click function
//        rb.mouseRelease(KeyEvent.BUTTON1_MASK);
        un.click();
        rb.keyPress(KeyEvent.VK_A);
        rb.keyPress(KeyEvent.VK_D);
        rb.keyPress(KeyEvent.VK_M);
        rb.keyPress(KeyEvent.VK_I);
        rb.keyPress(KeyEvent.VK_N);
        System.out.println("wwww");
        rb.keyRelease(KeyEvent.VK_A);
        rb.keyRelease(KeyEvent.VK_D);
        rb.keyRelease(KeyEvent.VK_M);
        rb.keyRelease(KeyEvent.VK_I);
        rb.keyRelease(KeyEvent.VK_N);

    }
    public static void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) Hooks.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        Hooks.driver.quit();
    }

    // To generate HTML reports from the json files
    public static void main (String[]args){
        Hooks.driver.quit();
        File reportOutputDirectory = new File("output");
        List<String> jsonfiles = new ArrayList<>();
        List<String> names = getfilenames();
        for (String string : names) {
            jsonfiles.add("output\\cucumber\\" + string);
        }
        String projectName = "cucumberProject";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonfiles, configuration);
        Reportable result = reportBuilder.generateReports();

    }

}

