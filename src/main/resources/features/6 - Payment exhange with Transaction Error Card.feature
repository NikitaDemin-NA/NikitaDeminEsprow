#language: en
#encoding: utf-8

@PayTransactionErrorCard @all
Feature: Check payment transaction error Exchange subscription of ETP Markets

  Background:
    Given open page
    And check page title
    And sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"

  Scenario: Payment Transaction Error Exchange subscription
    #delete
    Then delete all Exchanges

    #add
    Then add 1 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions
    Then check Final Account

    #pay
    Then pay for the Exchanges with "Transaction Error Card"

    When close browser
