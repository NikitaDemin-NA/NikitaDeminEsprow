#language: en
#encoding: utf-8

@Test
  Feature: E2E check Subscription of ETP Markets

    Background:
      When open page
      Then check page title
      Given sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"
      And open Subscription page

    Scenario: Delete, add, pay, modify Exchange subscription
      #delete
      Then delete all Exchanges

      #add
      Then add 1 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions
      Then check Final Account

      #pay
      Then pay for the Exchanges

      #modify
      And open Subscription page
      Then add 3 new Exchange with "FIX 5.0" Protocol Type and 4 Number of Sessions
      Then check Final Account
      Then add 2 extra Sessions for all Exchanges
      Then check Final Account
      Then pay for the Exchanges


      When close browser


