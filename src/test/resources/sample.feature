Feature: Selenium Practice
#mvn clean test -P=VAYU -Dcucumber.options="--tags @autoIT" -o

@javaScript @screenshot @video
  Scenario Outline: Selenium practice scenario one with <hyperlink>
    Given user launch the demo website
    When user click on "<hyperlink>" in automation practice form
    Then the form should be displayed with webelements
    Examples:
    |hyperlink|
    |Automation practice form|
    
    @crossBrowser
  Scenario Outline: Selenium practice scenario one with <hyperlink>
    Given user launch the demo website
    When user click on "<hyperlink>" in automation practice form
    Examples:
    |hyperlink|
    |Automation practice form|

@datePicker @allWaits
  Scenario Outline: Selenium practice scenario one with <hyperlink>
    Given user launch the demo website
    When user click on "<hyperlink>" in automation practice form
    Then the user selects date picker
    Examples:
      |hyperlink|
      |Datepicker|
@robot
  Scenario Outline: Selenium practice scenario one with <hyperlink>
    Given user launch the demo website
    When user click on "<hyperlink>" in automation practice form
    Then the user selects via robot class
    Examples:
      |hyperlink|
      |Automation practice form|

@action
  Scenario Outline: Selenium practice scenario one with <hyperlink>
    Given user launch the demo website
    When user click on "<hyperlink>" in automation practice form
    Then the user selects via action class
    Examples:
      |hyperlink|
      |HTML contact form|
      
 @autoIT
  Scenario Outline: Upload file via Auto IT <hyperlink>
    Given user launch the demo auto IT url
    When user click on Image and upload a file
    Examples:
      |hyperlink| 
      |HTML contact form|     
      
@data_table
  Scenario Outline: Selenium practice scenario one with <hyperlink>
    Given user launch the demo website
    When user click on "<hyperlink>" in automation practice form
    Then the user uses datatable and selects via action class
    |First Name  | Last Name | Phone No|
    |Abc FN | Abc LN | 0123123123 |
    |Def FN | Def LN | 0456456456 |
    |Xyz FN | Xyz LN | 0789789789 |
    Examples:
      |hyperlink|
      |HTML contact form|

