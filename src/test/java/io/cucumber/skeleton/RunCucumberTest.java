package io.cucumber.skeleton;



import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:output/cucumber/cucumber.json", "html:output/cucumber-report/cucumber.html"},
        tags = {"@crossBrowser"},
        features = "src/test/resources/")

public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Parameters({"browser"})
    @BeforeClass
    public static void initiate(String browser) {
        System.out.println("Browser::::"+browser);
        Hooks.openBrowser(browser);
    }

    @AfterClass
    public static void tearDown() {
        report.main(new String[]{});
    }
}
