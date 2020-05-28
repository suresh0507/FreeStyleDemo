package io.cucumber.skeleton.pages;

import io.cucumber.datatable.DataTable; 
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Function;

import io.cucumber.skeleton.Hooks;
import io.cucumber.skeleton.SpecializeScreenRecorder;


public class sample_page {

    private SpecializeScreenRecorder screenRecorder;

    public void launch_url() throws Exception {
        startRecording();
        Hooks.driver.get("https://demoqa.com/");
        Hooks.driver.manage().window().maximize();

    }
    
    public void auto_IT_launch_url() throws Exception {
        Hooks.driver.get("https://www.google.com/imghp?hl=en&tab=wi");
        Hooks.driver.manage().window().maximize();

    }

    public void click_hyperlink(String name) {
        try {
            Thread.sleep(5000);
            Hooks.scrollElement(Hooks.driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]")));
            Hooks.driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]")).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void res_Upload() {
        try {
            Thread.sleep(5000);
            Hooks.driver.findElement(By.xpath("//span[@class='BwoPOe']")).click();
            Hooks.driver.findElement(By.xpath("//a[contains(text(),'Upload an image')]")).click();
//            Hooks.driver.findElement(By.xpath("//input[@name='encoded_image']")).click();
            WebElement elem = Hooks.driver.findElement(By.xpath("//input[@name='encoded_image']"));
            JavascriptExecutor executor = ((JavascriptExecutor)Hooks.driver);
            executor.executeScript("arguments[0].click();", elem);
            System.out.println("nice");
            Thread.sleep(5000);
            
            Runtime.getRuntime().exec("C:\\Users\\pc\\Pictures\\autoIT\\uploadFile.exe");
            Thread.sleep(30000);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void stopRecording() throws Exception {
       this.screenRecorder.stop();

    }
    
    public void capture_screenshot() throws IOException {
        WebElement elem = Hooks.driver.findElement(By.xpath("//input[@name='firstname']"));
        Hooks.highlight(elem);
        TakesScreenshot scrShot = ((TakesScreenshot) Hooks.driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        File DestFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\myname" + dateFormat.format(new Date()) + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }


    public void startRecording() throws Exception {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\videos");
        System.out.println("Dir Path:"+System.getProperty("user.dir") + "\\src\\main\\java\\videos");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        this.screenRecorder = new SpecializeScreenRecorder(gc, captureSize, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)), null, file, "MyVideo");
        this.screenRecorder.start();

    }

    public void radio_checkbox_selection() {
        Hooks.waitVisible(Hooks.driver.findElement(By.xpath("//label[@for='radio-1']")));
        WebElement locationRadioBtn = Hooks.driver.findElement(By.xpath("//label[@for='radio-1']"));
        locationRadioBtn.click();

    }

    public void dropdown_selection() {
        WebElement speed = Hooks.driver.findElement(By.id("speed-button"));
        speed.click();
        WebElement speed_dropdown = Hooks.driver.findElement(By.id("speed"));
        Select selection = new Select(speed_dropdown);
        selection.selectByVisibleText("Faster");

    }

    public void robot_selection() {
        try {
Hooks.robot();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void action_selection() {
        try {
            Actions action = new Actions(Hooks.driver);
            action.moveToElement(Hooks.driver.findElement(By.className("firstname"))).click().perform();
            action.moveToElement(Hooks.driver.findElement(By.className("firstname"))).sendKeys("KERALA").perform();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void action_selection_dataTable(DataTable table) {
        try {
//        	dataTable
        	System.out.println("dataTable inside class  is:"+table);
        	
//        	way1
        	List<List<String>> list = table.asLists(String.class);
        	for (int i=1;i<list.size();i++) { //i=0 represent header so i starts from 1
        		System.out.println("List First Column:"+list.get(i).get(0));
        		System.out.println("List Second Column:"+list.get(i).get(1));

        	}
        	
//        	way2
        	List<Map<String, String>> list2 = table.asMaps(String.class, String.class);
        	for (int i=0;i<list.size()-1;i++) {
        		System.out.println("Map First Column:"+list2.get(i).get("First Name"));
        		System.out.println("Map Second Column:"+list2.get(i).get("Last Name"));

        	}
        	
        	
        	
            Actions action = new Actions(Hooks.driver);
            action.moveToElement(Hooks.driver.findElement(By.className("firstname"))).click().perform();
            action.moveToElement(Hooks.driver.findElement(By.className("firstname"))).sendKeys("KERALA").perform();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    

    public void wait_selection() {
        WebElement datepicker = Hooks.driver.findElement(By.id("datepicker"));
    //Explicit wait (already added)
    Hooks.waitVisible(datepicker);
    //implicit wait (use after url loading)
    Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //fluent wait (use after form loading)
    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Hooks.driver);
    wait.pollingEvery(250, TimeUnit.MILLISECONDS);
    wait.withTimeout(2, TimeUnit.SECONDS);
    System.out.println("The button text has color try 1");
    Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                System.out.println("The button text has color try 1");
    WebElement element = arg0.findElement(By.id("datepicker"));
    String color = element.getCssValue("color");
    System.out.println("The button text has color try 1"+color);
                if (color.equals("rgba(102, 102, 102, 1)")) {
                    return true;
    }
                System.out.println("The button text has color try 1");
                return false;
    }
        };
    wait.until(function);
    datepicker.click();
    }


    
}
