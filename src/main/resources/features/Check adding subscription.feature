#language: en
#encoding: utf-8

@Test
  Feature: Check Subscription of ETP Markets

    Background:
      When open page
      Then check page title
      Given sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"
      And open Subscription page

    Scenario: add Exchange subscription

      #step1
      #When click on "Add Exchange" button
      Then add 2 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions
      Then check Final Account


      When wait 4 seconds
      When close browser


