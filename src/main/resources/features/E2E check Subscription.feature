#language: en
#encoding: utf-8

@E2E @all
  Feature: E2E check Subscription of ETP Markets

    Background:
      Given open page
      And check page title
      And sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"

    Scenario: Delete, add, pay, modify Exchange subscription
      #delete
      Then delete all Exchanges

      #add
      Then add 1 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions
      Then check Final Account

      #modify
      Then add 2 extra Sessions for all Exchanges
      Then check Final Account

      #pay
      Then pay for the Exchanges


      When close browser


