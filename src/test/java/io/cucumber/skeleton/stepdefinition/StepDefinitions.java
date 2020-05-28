package io.cucumber.skeleton.stepdefinition;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.Hooks;
import io.cucumber.skeleton.pages.sample_page;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.*;
import java.util.Map;

public class StepDefinitions {
    sample_page samplepage = new sample_page();
    @Given("user launch the demo website")
    public void user_launch_the_demo_website() throws Exception {
        samplepage.launch_url();
    }
    @When("^user click on \"(.*)\" in automation practice form$")
    public void user_click_on_Automation_practice_form(String name) {
        samplepage.click_hyperlink(name);
    }
    @Then("the form should be displayed with webelements")
    public void the_form_should_be_displayed_with_webelements() throws Exception {
    	samplepage.stopRecording();
        samplepage.capture_screenshot();
    }
    @Then("the user selects date picker")
    public void the_user_selects_radio_button_and_checkbox() {
//        samplepage.radio_checkbox_selection();
        samplepage.wait_selection();
    }
    @Then("the user selects dropdown value")
    public void the_user_selects_dropdown_value() {
        samplepage.dropdown_selection();
    }
    @Then("the user selects via robot class")
    public void the_user_selects_via_robot_class()  {
        samplepage.robot_selection();
    }
    @Then("the user selects via action class")
    public void the_user_selects_via_action_class(){
        samplepage.action_selection();
    }
    
    @Then("the user uses datatable and selects via action class")
    public void the_user_selects_via_action_class_datatable(DataTable table){
    	System.out.println("dataTable is:"+table);
        samplepage.action_selection_dataTable(table);
    }

    @Given("^fill up the new account form with the following data$")
    public void fill_up_the_new_account_form_with_the_following_data(DataTable dt) {
        System.out.println("check");
        List<List<String>> list = dt.asLists(String.class);
        System.out.println(list.size());
        for (int i = 1; i < list.size(); i++) {
            Hooks.driver.findElement(By.name("firstname")).sendKeys(list.get(0).get(0));
            Hooks.driver.findElement(By.id("lastname")).sendKeys(list.get(0).get(0));
        }
    }
    
    @Given("user launch the demo auto IT url")
    public void user_launch_the_demo_autoIT() throws Exception {
        samplepage.auto_IT_launch_url();
    }
    
    @When("user click on Image and upload a file")
    public void user_click_Image_upload_file() throws Exception {
        samplepage.res_Upload();
    }


}
