Feature: Homeowners
  Homeowners

  Background:
    Given user open sandbox

  @Homeowner @Smoke
  Scenario Outline: Smoke test example Homeowners <Row Num Homeowners>
  Smoke test example Homeowners
    Given load data from excel file "<File Name>", "<Row Num Homeowners>","<Row Num Customer>","<Row Num Home Page>"
    * user logs in
    * user create new customer
    * user register quote
    * user fill in policy information
    * user fill in location coverage
    * user binds quote


    Examples:
      | File Name                            | Row Num Homeowners | Row Num Customer | Row Num Home Page |
      | src/TestData/HomeownersTestData.xlsx | 0                  | 1                | 2                 |
      | src/TestData/HomeownersTestData.xlsx | 2                  | 1                | 2                 |


  @Homeowner @Regression
  Scenario Outline: Regression test example Homeowners <Row Num Homeowners>
  Regression test Example
    Given load data from excel file "<File Name>", "<Row Num Homeowners>","<Row Num Customer>","<Row Num Home Page>"
    * user logs in
    * user create new customer
    * user register quote
    * user fill in policy information
    * user fill in wind mitigation
    * user binds quote


    Examples:
      | File Name                            | Row Num Homeowners | Row Num Customer | Row Num Home Page |
      | src/TestData/HomeownersTestData.xlsx | 4                  | 1                | 2                 |
