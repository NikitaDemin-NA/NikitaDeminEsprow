#language: en
#encoding: utf-8

@Test
  Feature: Check Subscription of ETP Markets

    Background:
      When open page
      Then check page title
      Given sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"
      And open Subscription page
    Scenario: Open Browser

    #step1
    When close browser



