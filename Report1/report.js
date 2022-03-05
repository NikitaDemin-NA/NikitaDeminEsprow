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
  "error_message": "java.lang.Exception: Log In is not correct\n\tat steps.UICustomSteps.authorizationButton(UICustomSteps.java:154)\n\tat steps.CustomSteps.logIn(CustomSteps.java:54)\n\tat ✽.sign in with login \u003d \"test.qa.3@esprow.com\" and password \u003d \"temporaryAccount\"(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/1%20-%20E2E%20check%20Subscription.feature:15)\n",
  "status": "failed"
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
  "status": "skipped"
});
formatter.step({
  "name": "add 1 new Exchange with \"FIX 4.2\" Protocol Type and 1 Number of Sessions",
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
  "name": "add 2 extra Sessions for all Exchanges",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.addExtraSessions(int)"
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
formatter.uri("file:src/main/resources/features/2%20-%20Add%20exchange.feature");
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
formatter.uri("file:src/main/resources/features/3%20-%20Modify%20exchange.feature");
formatter.feature({
  "name": "Check modifying Exchange subscription of ETP Markets",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Modify"
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
  "name": "Modify Exchange subscription",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Modify"
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
  "name": "add 3 new Exchange with \"FIX 5.0\" Protocol Type and 3 Number of Sessions",
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
  "error_message": "java.lang.Exception: value of \"Pay Now\" button is not correct\n\tat steps.UICustomSteps.checkPayNowOrder(UICustomSteps.java:339)\n\tat steps.CustomSteps.payForTheExchange(CustomSteps.java:149)\n\tat ✽.pay for the Exchanges(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/3%20-%20Modify%20exchange.feature:30)\n",
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
formatter.uri("file:src/main/resources/features/4%20-%20Payment%20exchange.feature");
formatter.feature({
  "name": "Check payment Exchange subscription of ETP Markets",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Pay"
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
      "name": "@Pay"
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
  "name": "pay for the Exchanges",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.payForTheExchange()"
});
formatter.result({
  "error_message": "java.lang.Exception: value of \"Pay Now\" button is not correct\n\tat steps.UICustomSteps.checkPayNowOrder(UICustomSteps.java:339)\n\tat steps.CustomSteps.payForTheExchange(CustomSteps.java:149)\n\tat ✽.pay for the Exchanges(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/4%20-%20Payment%20exchange.feature:25)\n",
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
formatter.uri("file:src/main/resources/features/5%20-%20Payment%20exhange%20with%20Verification%20Error%20Card.feature");
formatter.feature({
  "name": "Check payment verification error Exchange subscription of ETP Markets",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@PayVerificationErrorCard"
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
  "name": "Payment Verification Error Exchange subscription",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PayVerificationErrorCard"
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
  "name": "pay for the Exchanges with \"Verification Error Card\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.payForTheExchangeWith(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.Exception: value of \"Pay Now\" button is not correct\n\tat steps.UICustomSteps.checkPayNowOrder(UICustomSteps.java:339)\n\tat steps.CustomSteps.payForTheExchangeWith(CustomSteps.java:164)\n\tat ✽.pay for the Exchanges with \"Verification Error Card\"(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/5%20-%20Payment%20exhange%20with%20Verification%20Error%20Card.feature:25)\n",
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
formatter.uri("file:src/main/resources/features/6%20-%20Payment%20exhange%20with%20Transaction%20Error%20Card.feature");
formatter.feature({
  "name": "Check payment transaction error Exchange subscription of ETP Markets",
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
  "error_message": "java.lang.Exception: Log In is not correct\n\tat steps.UICustomSteps.authorizationButton(UICustomSteps.java:154)\n\tat steps.CustomSteps.logIn(CustomSteps.java:54)\n\tat ✽.sign in with login \u003d \"test.qa.3@esprow.com\" and password \u003d \"temporaryAccount\"(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/6%20-%20Payment%20exhange%20with%20Transaction%20Error%20Card.feature:14)\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Payment Transaction Error Exchange subscription",
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
  "status": "skipped"
});
formatter.step({
  "name": "add 1 new Exchange with \"FIX 4.2\" Protocol Type and 1 Number of Sessions",
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
  "name": "pay for the Exchanges with \"Transaction Error Card\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.payForTheExchangeWith(java.lang.String)"
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
formatter.uri("file:src/main/resources/features/7%20-%20Add%20big%20quantity%20of%20exchangs.feature");
formatter.feature({
  "name": "Check adding a big quantity of Exchange subscription of ETP Markets",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AddBigQuantity"
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
  "name": "Add a big quantity of Exchange subscription",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AddBigQuantity"
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
  "name": "add 6 new Exchange with \"FIX 4.2\" Protocol Type and 1 Number of Sessions",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CustomSteps.AddNewExchange(int,java.lang.String,int)"
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
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d99.0.4844.51)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027iMac-andrej.local\u0027, ip: \u0027192.168.1.153\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.13.6\u0027, java.version: \u002716.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 99.0.4844.51, chrome: {chromedriverVersion: 98.0.4758.102 (273bf7ac8c90..., userDataDir: /var/folders/7r/_mrhmvv52wq...}, goog:chromeOptions: {debuggerAddress: localhost:51697}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: 35a7af3bd825b0e46db6a52c380214ae\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:78)\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\n\tat steps.UICustomSteps.clickPayButton(UICustomSteps.java:274)\n\tat steps.CustomSteps.payForTheExchange(CustomSteps.java:146)\n\tat ✽.pay for the Exchanges(file:///Users/andrei/IdeaProjects/NikitaDeminEsprow/src/main/resources/features/7%20-%20Add%20big%20quantity%20of%20exchangs.feature:24)\n",
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