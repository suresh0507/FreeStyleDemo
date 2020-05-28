$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/sample.feature");
formatter.feature({
  "name": "Selenium Practice",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Upload file via Auto IT \u003chyperlink\u003e",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@autoIT"
    }
  ]
});
formatter.step({
  "name": "user launch the demo auto IT url",
  "keyword": "Given "
});
formatter.step({
  "name": "user click on Image and upload a file",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "hyperlink"
      ]
    },
    {
      "cells": [
        "HTML contact form"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Upload file via Auto IT HTML contact form",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@autoIT"
    }
  ]
});
formatter.step({
  "name": "user launch the demo auto IT url",
  "keyword": "Given "
});
formatter.match({
  "location": "io.cucumber.skeleton.stepdefinition.StepDefinitions.user_launch_the_demo_autoIT() in file:/C:/Users/pc/Downloads/PICNIC%20VAYU/cucumber-java-skeleton-master/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on Image and upload a file",
  "keyword": "When "
});
formatter.match({
  "location": "io.cucumber.skeleton.stepdefinition.StepDefinitions.user_click_Image_upload_file() in file:/C:/Users/pc/Downloads/PICNIC%20VAYU/cucumber-java-skeleton-master/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
});