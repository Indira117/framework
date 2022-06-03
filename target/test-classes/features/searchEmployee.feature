#Author: indirazhana@gmail.com
  @searchEmplyee
  Feature: Search an Employee
    Background:
      Given enter valid credentials
      And click on login button
      When click on PIM
      And click on employee list btn
    @regression
    Scenario: search employee job titles
      Given search for jpb titles
      Then get all job title from database #dbSteps
      And verify data is job title data is matched