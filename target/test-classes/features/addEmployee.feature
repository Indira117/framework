@addEmployee
Feature: Add Employee Functionality
  Background:
    Given enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    And click on add employee btn

  @addEmplwithoutLogin
  Scenario: Add employee without login details

    Then enter first and last name
    And click on save btn
    Then verify employee is added successfully
@addEmplwithLogin
#  Scenario: Add employee with login details and with middle name
#
#    Then enter first and last name and middle name
#    When click on login details
#    Then enter login details
#    And click on save btn
#    Then verify employee is added successfully

  Scenario: Add employee without login details with middle name
    Then enter first "Pari" and middle name "Mary" and last name "Ostash"
    And click on save btn
    Then verify that "Pari Mary Ostash" is added successfuly
@examples
    Scenario Outline: Adding multiple employees without login credentials
      When enter "<FirstName>" , "<MiddleName>" and "<LastName>"
      And click on save btn
      Then verify "<FirstName>" , "<MiddleName>" and "<LastName>" is added successfully

      Examples:
        |FirstName|MiddleName|LastName|
      |Mark     |J         |Smith   |
      |John     |N         |Kb      |
      |A   |N         |J     |
@dtWithHeader
Scenario: Adding multiple employee at one execution
  When add multiple employees and verify they are added successfully

    |FirstName|MiddleName|LastName|
    |Markus     |J         |Smith   |
    |Johnathan     |N         |Kb      |
    |Ais  |N         |J     |

@excelTask
  Scenario: Adding multiple employee from excel
    When add multiple employee from excel "AddEmp" sheet and verify they are added

  @db @regression
    Scenario: Adding Employee and database validation
    When enter first "Pari" and middle name "Mary" and last name "Hayam"
    And capture employee ID
    And click on save btn
    Then collect employee data from hrms database
    And very data from db and ui is matched