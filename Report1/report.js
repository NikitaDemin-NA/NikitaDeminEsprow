$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/Payment%20exhange%20with%20Transaction%20Error%20Card.feature");
formatter.feature({
  "name": "Check payment Exchange subscription of ETP Markets",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@PayTransactionErrorCard"
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
  "name": "Payment Exchange subscription",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PayTransactionErrorCard"
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
  "name": "pay for the Exchanges with \"Transaction Error Card\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.payForTheExchangeWith(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.Exception: Due to \"Transaction Error Card\"\n\tat steps.UICustomSteps.getErrorPayText(UICustomSteps.java:481)\n\tat steps.UICustomSteps.checkSuccessOfPay(UICustomSteps.java:443)\n\tat steps.CustomSteps.payForTheExchangeWith(CustomSteps.java:173)\n\tat ✽.pay for the Exchanges with \"Transaction Error Card\"(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/Payment%20exhange%20with%20Transaction%20Error%20Card.feature:21)\n",
  "status": "failed"
});
});