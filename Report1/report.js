$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/Check%20adding%20subscription.feature");
formatter.feature({
  "name": "Check Subscription of ETP Markets",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "open page",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CustomSteps.getPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check page title",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.getTitle()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Open Browser",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.step({
  "name": "close browser",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CustomSteps.tearDown()"
});
formatter.result({
  "status": "passed"
});
});