$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/2%20-%20Add%20exchange.feature");
formatter.feature({
  "name": "Check adding Exchange subscription of ETP Markets",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Add"
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
  "name": "Add Exchange subscription",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Add"
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
  "name": "add 2 new Exchange with \"FIX 4.4\" Protocol Type and 2 Number of Sessions",
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
  "name": "pay for the Exchanges",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.payForTheExchange()"
});
formatter.result({
  "error_message": "java.lang.Exception: value of \"Pay Now\" button is not correct\n\tat steps.UICustomSteps.checkPayNowOrder(UICustomSteps.java:339)\n\tat steps.CustomSteps.payForTheExchange(CustomSteps.java:149)\n\tat ✽.pay for the Exchanges(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/2%20-%20Add%20exchange.feature:28)\n",
  "status": "failed"
});
formatter.step({
  "name": "add 3 new Exchange with \"FIX 5.0\" Protocol Type and 3 Number of Sessions",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.AddNewExchange(int,java.lang.String,int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "check Final Account",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.checkFinalAccount()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "pay for the Exchanges",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.payForTheExchange()"
});
formatter.result({
  "status": "skipped"
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