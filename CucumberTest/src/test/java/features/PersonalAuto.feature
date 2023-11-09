Feature: PersonalAuto Example
  PersonalAuto Example

  Background:
    Given user open sandbox

  @PersonalAuto @Smoke
  Scenario Outline: Smoke test example Personal Auto <Row Num Personal Auto>
  Smoke test example Personal Auto
    Given load data from Auto excel file "<File Name>", "<Row Num Personal Auto>","<Row Num Customer>","<Row Num Home Page>"
    Then user logs in
    And user create new customer
    And user register quote
    And user fill in policy information Personal Auto
    And user fill in driver page
    And user fill in vehicle page
    And user fill in coverage page
    And user override underwriting referral
    And user binds quote


    Examples:
      | File Name                      | Row Num Personal Auto | Row Num Customer | Row Num Home Page |
      | src/TestData/AutoTestData.xlsx | 0                     | 1                | 0                 |
      | src/TestData/AutoTestData.xlsx | 2                     | 2                | 0                 |
      | src/TestData/AutoTestData.xlsx | 4                     | 3                | 14                |
      | src/TestData/AutoTestData.xlsx | 3                     | 4                | 0                 |
      | src/TestData/AutoTestData.xlsx | 0                     | 5                | 15                |
      | src/TestData/AutoTestData.xlsx | 6                     | 6                | 0                 |
      | src/TestData/AutoTestData.xlsx | 7                     | 7                | 18                |


  @Regression
  Scenario Outline: Smoke test example Personal Auto <Row Num Personal Auto>
  Smoke test example Personal Auto
    Given load data from Auto excel file "<File Name>", "<Row Num Personal Auto>","<Row Num Customer>","<Row Num Home Page>"
    Then user logs in
    And user create new customer
    And user register quote
    And user fill in policy information Personal Auto
    And user fill in driver page with incidents
    And user fill in vehicle page with extra vehicle
    And user fill in coverage page
    And user override underwriting referral
    And user binds quote


    Examples:
      | File Name                      | Row Num Personal Auto | Row Num Customer | Row Num Home Page |
      | src/TestData/AutoTestData.xlsx | 0                     | 1                | 0                 |