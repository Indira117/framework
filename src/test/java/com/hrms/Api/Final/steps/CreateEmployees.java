package com.hrms.Api.Final.steps;

import com.hrms.utils.APICommonMethods;
import com.hrms.utils.APIConstants;
import com.hrms.utils.APIPayloadCommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmployees {
    RequestSpecification request;
    Response response;
    @Given("a request is prepared to create employees")
    public void a_request_is_prepared_to_create_employees() {

    }

    @When("employee data provided is {string},{string},{string},{string},{string},{string},{string}")
    public void employee_data_provided_is(String emplfirstName, String emplLastname, String emplMiddlename,String emplGEnder, String emplDOB,  String emplStatus, String emplJobTitle) {
 request= APICommonMethods.createEmplRequest(GenerateTokenSteps.token,
        APIPayloadCommonMethods.createEmployeePayloadMoreDynamic(emplfirstName,emplLastname,emplMiddlename,emplGEnder,emplDOB
                ,emplStatus,emplJobTitle));

    }

    @Then("employees created")
    public void employees_created() {
  response= request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
  response.prettyPrint();

    }


}
