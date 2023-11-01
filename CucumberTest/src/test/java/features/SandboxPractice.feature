Feature: Sandbox Example
  Sandbox Example

  Background:
    Given load data from excel
    Given user open sandbox

  @Test123
  Scenario Outline: Sandbox Example
  Sandbox Example
    Then user logs in
    And user create new customer
    And user register quote
    And user fill in policy information
    And user fill in location coverage
    And user binds quote


    Examples:
      | number | username         | password  |
      | 0      | nastasjadamjanac | oneshield |