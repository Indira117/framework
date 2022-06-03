package com.hrms.stepdefintions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelReading;
import com.hrms.utils.GlobalVariables;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddEmployeeStepDefinition extends CommonMethods {

    @When("click on PIM")
    public void click_on_PIM() {
dashboardPage.clickOnPIM();
    }

    @When("click on add employee btn")
    public void click_on_add_employee_btn() {
dashboardPage.clickAddEmp();
    }

    @Then("enter first and last name")
    public void enter_first_and_last_name() {
addEmployeePage.enterFirstAndlastname("Xo","Ox");
    }

    @Then("click on save btn")
    public void click_on_save_btn() {
addEmployeePage.clickSaveBtn();
    }

    @Then("verify employee is added successfully")
    public void verify_employee_is_added_successfully() {
String actualValue=personalDetailPage.getUserProfileName();

        Assert.assertEquals("Veryfiyng profile name","Xo Ox",actualValue);
    }

    @Then("enter first {string} and middle name {string} and last name {string}")
    public void enter_first_and_middle_name_and_last_name(String firstName, String middleName, String lastName) {
       addEmployeePage.enterFirstMiddleNameAndlastname(firstName,middleName,lastName);
       GlobalVariables.employeeData=firstName+" "+middleName+" "+lastName;
    }

    @Then("verify that {string} is added successfuly")
    public void verify_that_is_added_successfuly(String fullName) {
        String actualValue=personalDetailPage.getUserProfileName();

        Assert.assertEquals("Veryfiyng profile name",fullName,actualValue);
    }
    @When("enter {string} , {string} and {string}")
    public void enter_and(String firstName, String middleName, String lastName) {
        addEmployeePage.enterFirstMiddleNameAndlastname(firstName,middleName,lastName);
    }

    @Then("verify {string} , {string} and {string} is added successfully")
    public void verify_and_is_added_successfully(String firstName, String middleName, String lastName) {
       String fullName= firstName+" "+middleName+" "+lastName;
        String actualValue=personalDetailPage.getUserProfileName();

        Assert.assertEquals("Verifiyng profile name",fullName,actualValue);
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) {
      List<Map<String,String>> employeeNames= employees.asMaps();
        for (Map<String,String> employeeName: employeeNames) {
         String firstName=   employeeName.get("FirstName");
         String middleName=employeeName.get("MiddleName");
         String lastName=employeeName.get("LastName");

         addEmployeePage.enterFirstMiddleNameAndlastname(firstName,middleName,lastName);
         addEmployeePage.clickSaveBtn();
       String actualFullName=  personalDetailPage.getUserProfileName();
       String expectedFullName=firstName+" "+middleName+" "+lastName;
            Assert.assertEquals("Verifiyng profile name",expectedFullName,actualFullName);
            dashboardPage.clickAddEmp();

        }
    }
    @When("add multiple employee from excel {string} sheet and verify they are added")
    public void add_multiple_employee_from_excel_sheet_and_verify_they_are_added(String sheetName) {

        List <Map<String,String>>excelData=ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetName);
        for (Map <String,String> excelEmpName:excelData    ) {
            String firstName=excelEmpName.get("FirstName");
            String lastName=excelEmpName.get("LastName");
            String middleName=excelEmpName.get("MiddleName");
            String empID=excelEmpName.get("Emp ID");

            addEmployeePage.enterFirstMiddleNameAndlastname(firstName,middleName,lastName);
          //  addEmployeePage.enterEmpID(empID);
            addEmployeePage.clickSaveBtn();
            String expectedFullName=firstName+" "+middleName+" "+lastName;
            String actualFullName=  personalDetailPage.getUserProfileName();
            Assert.assertEquals("Verifiyng profile name",expectedFullName,actualFullName);
            dashboardPage.clickAddEmp();
        }
    }
    @When("capture employee ID")
    public void capture_employee_ID() {
GlobalVariables.emp_ID =addEmployeePage.empIDTextbox.getAttribute("value");
    }
    @Then("very data from db and ui is matched")
    public void very_data_from_db_and_ui_is_matched() {
        String expectedEmpData=GlobalVariables.employeeData;
        String actualEmpData="";
        for (Map<String,String> actualDataemplMap:GlobalVariables.dbList ) {
            Set<String> keys=actualDataemplMap.keySet();
            for (String key:keys){
                actualEmpData+=actualDataemplMap.get(key)+" ";
            }
        }
        actualEmpData=(actualEmpData.trim());

       Assert.assertEquals("Verifying employee data", actualEmpData,expectedEmpData);

    }
}


