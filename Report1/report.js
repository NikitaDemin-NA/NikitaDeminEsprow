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
  "name": "open Subscription page",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CustomSteps.openSubcirption()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add 3 new Exchange with \"FIX 4.2\" Protocol Type and 7 Number of Sessions",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.AddNewExchange(int,java.lang.String,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check Final Account",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.checkFinalAccount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add 3 extra Sessions for all Exchanges",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.addExtraSessions(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check Final Account",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.checkFinalAccount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "wait 8 seconds",
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