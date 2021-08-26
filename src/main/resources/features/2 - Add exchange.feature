#language: en
#encoding: utf-8

  #Choose test by tags in RunnerTest
  #You can change "variables" of steps as you want
  #I added parallel config for parallel browser execution - use "mvn test". But site will pop-up a error (Session is Expired)

@Add @all
Feature: Check adding Exchange subscription of ETP Markets

  Background:
    Given open page
    And check page title
    And sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"

  Scenario: Add Exchange subscription
    #delete
    Then delete all Exchanges

    #add
    Then add 1 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions
    Then check Final Account

    Then add 2 new Exchange with "FIX 4.4" Protocol Type and 2 Number of Sessions
    Then check Final Account

    #pay
    Then pay for the Exchanges

    #modify
    Then add 3 new Exchange with "FIX 5.0" Protocol Type and 3 Number of Sessions
    Then check Final Account

    #pay
    Then pay for the Exchanges

    When close browser




