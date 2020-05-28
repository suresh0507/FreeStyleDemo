package io.cucumber.skeleton;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:output/cucumber/cucumber.json", "html:output/cucumber-report/cucumber.html"},
        tags = {"@autoIT"},
        features = "src/test/resources/")

public class RunCucumberTestSolo{
    @BeforeClass
    public static void initiate() {
        Hooks.openBrowser("chrome");
    }

    @AfterClass
    public static void tearDown() {
        report.main(new String[]{});
    }
}
