Feature: Configure PIM -Optionals fields
@pim
  Scenario: Unchecking unnecessary checkbox
    Given enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    When click on configuration DD
    And click on optional fields
    And click on editBtn
    And uncheck unnecessary checkboxes
  |Show SSN field in Personal Details|
  |Show SIN field in Personal Details|

  And click on save btn