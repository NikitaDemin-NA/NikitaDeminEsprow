#language: en
#encoding: utf-8

  #Choose test by tags in RunnerTest
  #You can change "variables" of steps as you want
  #I added parallel config for parallel browser execution - use "mvn test". But site will pop-up a error (Session is Expired)

@PayVerificationErrorCard @all
Feature: Check payment verification error Exchange subscription of ETP Markets

  Background:
    Given open page
    And check page title
    And sign in with login = "test.qa.3@esprow.com" and password = "temporaryAccount"

  Scenario: Payment Verification Error Exchange subscription
    #delete
    Then delete all Exchanges

    #add
    Then add 1 new Exchange with "FIX 4.2" Protocol Type and 1 Number of Sessions
    Then check Final Account

    #pay
    Then pay for the Exchanges with "Verification Error Card"

    When close browser
