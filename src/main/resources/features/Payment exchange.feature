#language: en
#encoding: utf-8

@Test2 @Pay
Feature: Check payment Exchange subscription of ETP Markets

  Background:
    When open page
    Then check page title
    Given sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"
    And open Subscription page

  Scenario: Payment Exchange subscription