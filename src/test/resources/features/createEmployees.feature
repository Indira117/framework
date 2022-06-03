@createEmpl
Feature: Create Employees
  Description:this feature creates employees
  Background: Given a JWT is generated

  Scenario Outline: Creating employees
    Given a request is prepared to create employees
    When employee data provided is "<emplfirstName>","<emplLastname>","<emplMiddlename>","<emplGEnder>","<emplDOB>","<emplStatus>","<emplJobTitle>"
    Then employees created


    Examples:
      |emplfirstName|emplLastname|emplMiddlename|emplGEnder|emplDOB|emplStatus|emplJobTitle|
      |Nodir|Kobilov   |Fas     |M      | 1996-10-29| Cloud Consultant |  Freelance |
      |INdi|ZH        |Ugf      |F         |1986-05-17 |Independent contractor |  Freelance  |
