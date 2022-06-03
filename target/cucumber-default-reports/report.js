$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/addEmployee.feature");
formatter.feature({
  "name": "Add Employee Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@addEmployee"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "enter valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.stepdefintions.LoginStepDefinition.enter_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefintions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify dashboard is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefintions.LoginStepDefinition.verify_dashboard_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on PIM",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefintions.AddEmployeeStepDefinition.click_on_PIM()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add employee btn",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefintions.AddEmployeeStepDefinition.click_on_add_employee_btn()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Adding Employee and database validation",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@addEmployee"
    },
    {
      "name": "@db"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "enter first \"Pari\" and middle name \"Mary\" and last name \"Hayam\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefintions.AddEmployeeStepDefinition.enter_first_and_middle_name_and_last_name(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "capture employee ID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefintions.AddEmployeeStepDefinition.capture_employee_ID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save btn",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefintions.AddEmployeeStepDefinition.click_on_save_btn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "collect employee data from hrms database",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefintions.DBsteps.collect_employee_data_from_hrms_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "very data from db and ui is matched",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefintions.AddEmployeeStepDefinition.very_data_from_db_and_ui_is_matched()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Adding Employee and database validation");
formatter.after({
  "status": "passed"
});
});