#language: en
#encoding: utf-8

  #Choose test by tags in RunnerTest
  #You can change "variables" of steps as you want
  #I added parallel config for parallel browser execution - use "mvn test". But site will pop-up a error (Session is Expired)

@AddBigQuantity @all
Feature: Check adding a big quantity of Exchange subscription of ETP Markets

  Background:
    Given open page
    And check page title
    And sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"

  Scenario: Add a big quantity of Exchange subscription
    #delete
    Then delete all Exchanges

    #add
    Then add 6 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions

    #pay
    Then pay for the Exchanges

    When close browser



