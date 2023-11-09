Feature: PersonalAuto
  Personal Auto

  Background:
    Given user open sandbox

  @PersonalAuto @Smoke
  Scenario Outline: Smoke test example Personal Auto <Row Num Personal Auto>
  Smoke test example Personal Auto
    Given load data from Auto excel file "<File Name>", "<Row Num Personal Auto>","<Row Num Customer>","<Row Num Home Page>"
    * user logs in
    * user create new customer
    * user register quote
    * user fill in policy information Personal Auto
    * user fill in driver page
    * user fill in vehicle page
    * user fill in coverage page
    * user override underwriting referral
    * user binds quote


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
    * user logs in
    * user create new customer
    * user register quote
    * user fill in policy information Personal Auto
    * user fill in driver page with incidents
    * user fill in vehicle page with extra vehicle
    * user fill in coverage page
    * user override underwriting referral
    * user binds quote


    Examples:
      | File Name                      | Row Num Personal Auto | Row Num Customer | Row Num Home Page |
      | src/TestData/AutoTestData.xlsx | 0                     | 1                | 0                 |