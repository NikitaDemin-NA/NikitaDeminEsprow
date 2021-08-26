#language: en
#encoding: utf-8

@AddBigQuantity @all
Feature: Check adding Exchange subscription of ETP Markets

  Background:
    Given open page
    And check page title
    And sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"

  Scenario: Add Exchange subscription
    #delete
    Then delete all Exchanges

    #add
    Then add 6 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions

    #pay
    Then pay for the Exchanges

    When close browser



