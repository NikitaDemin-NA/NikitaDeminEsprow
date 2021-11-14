$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/1%20-%20E2E%20check%20Subscription.feature");
formatter.feature({
  "name": "E2E check Subscription of ETP Markets",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@E2E"
    },
    {
      "name": "@all"
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
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CustomSteps.startBrowserInMacOrWindows()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check page title",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CustomSteps.getTitle()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sign in with login \u003d \"test.qa.3@esprow.com\" and password \u003d \"temporaryAccount\"",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CustomSteps.logIn(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete, add, pay, modify Exchange subscription",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@E2E"
    },
    {
      "name": "@all"
    }
  ]
});
formatter.step({
  "name": "delete all Exchanges",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.deleteAllEchanges()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add 1 new Exchange with \"FIX 4.2\" Protocol Type and 1 Number of Sessions",
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
  "name": "add 2 extra Sessions for all Exchanges",
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
  "name": "pay for the Exchanges",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.payForTheExchange()"
});
formatter.result({
  "error_message": "java.lang.Exception: value of \"Pay Now\" button is not correct\n\tat steps.UICustomSteps.checkPayNowOrder(UICustomSteps.java:339)\n\tat steps.CustomSteps.payForTheExchange(CustomSteps.java:149)\n\tat ✽.pay for the Exchanges(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/1%20-%20E2E%20check%20Subscription.feature:30)\n",
  "status": "failed"
});
formatter.step({
  "name": "close browser",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CustomSteps.tearDown()"
});
formatter.result({
  "status": "skipped"
});
});