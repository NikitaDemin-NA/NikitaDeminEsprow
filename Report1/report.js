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
  "location": "steps.CustomSteps.startBrowserInMacOrWindows()"
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
formatter.step({
  "name": "sign in with login \u003d \"test.qa.3@esprow.com\" and password \u003d \"temporaryAccount\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CustomSteps.logIn(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "open Subscription page",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CustomSteps.openSubcirption()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "add Exchange subscription",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.step({
  "name": "click on \"Add Exchange\" button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CustomSteps.clickAddExchange()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add new Exchange",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.AddNewExchange()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "wait 4 seconds",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CustomSteps.waitSecond(long)"
});
formatter.result({
  "status": "passed"
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