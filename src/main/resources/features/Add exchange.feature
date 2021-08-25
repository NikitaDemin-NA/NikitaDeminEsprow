#language: en
#encoding: utf-8

@Test2 @Add
Feature: E2E check Subscription of ETP Markets

  Background:
    When open page
    Then check page title
    Given sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"
    And open Subscription page

  Scenario: Add Exchange subscription
    #delete
    Then delete all Exchanges

    #add
    Then add 1 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions
    Then check Final Account

    Then add 2 new Exchange with "FIX 4.4" Protocol Type and 2 Number of Sessions
    Then check Final Account

    Then pay for the Exchanges

    And open Subscription page
    Then add 3 new Exchange with "FIX 5.0" Protocol Type and 3 Number of Sessions
    Then check Final Account




