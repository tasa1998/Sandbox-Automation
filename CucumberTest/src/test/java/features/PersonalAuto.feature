Feature: PersonalAuto Example
  PersonalAuto Example

  Background:
    Given user open sandbox

  @PersonalAuto @Smoke
  Scenario Outline: Smoke test example <Row Num Homeowners>
  Smoke test example
    Given load data from excel file "<File Name>", "<Row Num Homeowners>","<Row Num Customer>","<Row Num Home Page>"
    Then user logs in
    And user create new customer
    And user register quote
    And user fill in policy information
    And user fill in location coverage
    And user binds quote


    Examples:
      | File Name                            | Row Num Homeowners | Row Num Customer | Row Num Home Page |
      | src/TestData/HomeownersTestData.xlsx | 0                  | 1                | 2                 |
      | src/TestData/HomeownersTestData.xlsx | 2                  | 1                | 2                 |
