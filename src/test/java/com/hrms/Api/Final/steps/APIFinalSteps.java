package com.hrms.Api.Final.steps;

import com.hrms.utils.APIConstants;
import com.hrms.utils.APIPayloadCommonMethods;
import com.hrms.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.hc.core5.http.ContentType;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class APIFinalSteps extends CommonMethods {
    RequestSpecification requestCreateEmp;
    Response responseCreateEmp;

 static   String emplID;
    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        //1 way
//     requestCreateEmp= given().header("Authorization",GenerateTokenSteps.token).header("Content-Type","application/json")
//                .body(APIPayloadCommonMethods.createEmployeePayload());
//2 way
//        requestCreateEmp=   given().header("Authorization",GenerateTokenSteps.token).header("Content-Type","application/json")
//                .body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));

        //3way is hardcode

/**
 * using createEmplRequest() common method which creates a request by passing expected parameters
 */
      requestCreateEmp=  apiCommonMethods.createEmplRequest(GenerateTokenSteps.token,
             readJson(APIConstants.CREATE_EMPLOYEE_JSON) );
// 4way
        /**
        The payload MUST be String, bellow line of code is doing the same as above
         */
// requestCreateEmp= apiCommonMethods.createEmplRequest(GenerateTokenSteps.token,APIPayloadCommonMethods.createEmployeeBody());


    }
    @When("a POST call is made to create an employee")
    public void a_POST_call_is_made_to_create_an_employee() {
     responseCreateEmp= requestCreateEmp.when().log().all().post(APIConstants.CREATE_EMPLOYEE_URI);
    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(int statusCode) {
        responseCreateEmp.then().assertThat().statusCode(statusCode);
    }
//    @Then("the employee is created")
//    public void the_employee_is_created() {
//
//        responseCreateEmp.then().assertThat().body("Message", equalTo("Employee Created"));
//    }

    @Then("the employee is created contains key {string} and value {string}")
    public void the_employee_is_created_contains_key_and_value(String key ,String value) {
        responseCreateEmp.then().assertThat().body(key, equalTo(value));
    }
    @Then("the employee ID {string} is stored as a global variable to be used for other calls")
    public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String value) {
   emplID=responseCreateEmp.jsonPath().getString(value);
    }
    @Given("a request is prepared to retrieve the created employee")
    public void a_request_is_prepared_to_retrieve_the_created_employee() {
//       requestCreateEmp= given().header("Content-Type", ContentType.APPLICATION_JSON).header("Authorization",GenerateTokenSteps.token)
//                .param("employee_id", emplID);  //ContentType.APPLICATION_JSON enum for restassured library
  requestCreateEmp= apiCommonMethods.getOneEmployeeRequest(GenerateTokenSteps.token,emplID);
    }

    @When("a GET call is made to retrieve the created employee")
    public void a_GET_call_is_made_to_retrieve_the_created_employee() {
      responseCreateEmp=  requestCreateEmp.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }

    @Then("the status code for retrieving the created employee {int}")
    public void the_status_code_for_retrieving_the_created_employee(int statusCodeEmp) {
        responseCreateEmp.then().assertThat().statusCode(statusCodeEmp);
    }



    @Then("the retrieved employee ID {string} matches the globally stored employee ID")
    public void the_retrieved_employee_ID_matches_the_globally_stored_employee_ID(String retrieveEmpID) {
        responseCreateEmp.then().assertThat().body(retrieveEmpID, equalTo(emplID));
    }
    @Then("the retrieved at {string} data matches the data used to create an employee with {string}")
    public void the_retrieved_at_data_matches_the_data_used_to_create_an_employee_with(String employeeObject, String responseEmployeeID, DataTable dataTable) {
        /**
         * We are validating expected data that we stored in feature file against actual
         * data that we are retrieving from the response We are retrieving the response
         * body by calling the object in feature
         */
//retrieving expected value from future file
        List<Map<String,String>>  expectedData = dataTable.asMaps(String.class, String.class);
        //Retrieving actual data from response object
        List<Map<String,String>>  actualData= Collections.singletonList((Map<String, String>) responseCreateEmp.body().jsonPath().get(employeeObject));
       //Starting at index 0 so we can iterate by one after each run
        int index=0;
        for (Map<String,String> map:expectedData
             ) {
            Set<String> keys= map.keySet();
            for (String key:keys
                 ) {
                String expectedValue=map.get(key);
                String actualValue=actualData.get(index).get(key);
                Assert.assertEquals(expectedValue,actualValue);
            }index++;

        }
String empIDdata=responseCreateEmp.body().jsonPath().getString(responseEmployeeID);
        Assert.assertTrue(empIDdata.contentEquals(emplID));
    }


//    @Then("the retrieved data matches the data used to create an employee")
//    public void the_retrieved_data_matches_the_data_used_to_create_an_employee() {
//
//
//    }

    @Given("a request is prepared to retrieve all employees")
    public void a_request_is_prepared_to_retrieve_all_employees() {
    }

    @When("a GET call is made to retrieve all employees")
    public void a_GET_call_is_made_to_retrieve_all_employees() {
    }

    @Then("the status code for retrieving all employees is {int}")
    public void the_status_code_for_retrieving_all_employees_is(Integer int1) {
    }

    @Then("the retrieved data contains the globally stored employee ID")
    public void the_retrieved_data_contains_the_globally_stored_employee_ID() {
    }

    @Then("the retrieved data matches the data that was used to create an employee")
    public void the_retrieved_data_matches_the_data_that_was_used_to_create_an_employee() {
    }

}
