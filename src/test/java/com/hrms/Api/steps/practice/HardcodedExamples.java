package com.hrms.Api.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //printing result by order

public class HardcodedExamples {

    /**
     * REST Assured- Java library specifically developed to automate REST endpoints
     * Given- preparing your request
     * When- What action will perform, what type of call are you making
     * THen- Verification
     */
 public static   String empID;

  String baseURI= RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
   public String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTMwMTcxNjUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1MzA2MDM2NSwidXNlcklkIjoiMzc0MCJ9.swWRr2yPY41tS4K6IxjAeEjHwN0Q8HiUUmKYQCDa7Ts";
   // @Test
    public void sampletest(){
        // Base URI for all endpoints
       // RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
        //JWT
       // String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTI0Nzk5NDEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1MjUyMzE0MSwidXNlcklkIjoiMzc0MCJ9.HhGeSrQFqbMYfr7d-vUOoh4nQKjou8f_-jKIzhfUStk";
       //preparing request to get one employee
    RequestSpecification preparingGetOneEmployee= given().header("Authorization",token)
                .header("Content-Type","application/json")
                .queryParam("employee_id","24797936").log().all(); //log().all() to print all paramentrs to send with request
    //making call to endpoint /getOneEmployee
  Response getOneEmpResponse= preparingGetOneEmployee.when().get("/getOneEmployee.php");
  //one way to print response object
        System.out.println(getOneEmpResponse.asString());
//second way to print
        getOneEmpResponse.prettyPrint();

        //assertthat to verify status code
        getOneEmpResponse.then().assertThat().statusCode(200);





    }

@Test
    public void aPOSTcreateEmployee(){
//preparing request for creating  an employee
  RequestSpecification createEmplRequest=    given().header("Authorization",token)
              .header("Content-Type","application/json")
              .body("{\n" +
                      "  \"emp_firstname\": \"Elya\",\n" +
                      "  \"emp_lastname\": \"Satim\",\n" +
                      "  \"emp_middle_name\": \"\",\n" +
                      "  \"emp_gender\": \"F\",\n" +
                      "  \"emp_birthday\": \"1987-04-26\",\n" +
                      "  \"emp_status\": \"Freelance\",\n" +
                      "  \"emp_job_title\": \"Cloud Consultant\"\n" +
                      "}");
//making call to endpoint createEmp
   Response createEmployeeResponse= createEmplRequest.when().log().all().post("/createEmployee.php");
   //printing response
   createEmployeeResponse.prettyPrint();

//Using jsonPath() to view response body which lets us get the employee ID
    //and stored emp Id to static variable for able to use in next steps
   empID =createEmployeeResponse.jsonPath().getString("Employee.employee_id");



    System.out.println(empID);

    //verifying status code
    createEmployeeResponse.then().assertThat().statusCode(201);

//verifying response body "Message" is paired with "Entry Created"
    // equalto() method comes from static Hamcrest package - NEED TO IMPORT MANUALLY
    //import static org.hamcrest.Matchers.*;
    createEmployeeResponse.then().assertThat().body("Message",equalTo("Employee Created"));

// verifying firstname
    createEmployeeResponse.then().assertThat().body("Employee.emp_firstname", equalTo("Elya"));

//verifying server
    createEmployeeResponse.then().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");

    }
    @Test
    public void bGetCreatedEmployee(){
        RequestSpecification getEmpl= given().header("Authorization",token)
                .header("Content-Type","application/json")
                .queryParam("employee_id",empID);
        Response getEmplResponse= getEmpl.when().get("/getOneEmployee.php");
        getEmplResponse.prettyPrint();
        //Storing employee id into empIDcreated, to compare with static global variable
      String empIDcreated=  getEmplResponse.body().jsonPath().getString("employee.employee_id"); //1way

//comparing empIdCreated with empID
      boolean verifingEmpID=empIDcreated.equalsIgnoreCase(empID);
      //  boolean verifingEmpID1=empIDcreated.contentEquals(empID);

// Asserting to verify the above condition is true
        Assert.assertTrue(verifingEmpID);
      //  Assert.assertTrue(verifingEmpID1);
        //verifying status code is 200
        getEmplResponse.then().assertThat().statusCode(200);


//storing response as string
       String response=getEmplResponse.asString();
       //crested object JsonPath
        JsonPath js=new JsonPath(response);
        //Grabbing employeeID using js

        String employeeID1= js.getString("employee.employee_id");//2 way
        String empFirstname= js.getString("employee.emp_firstname");
        String empMiddle_name= js.getString("employee.emp_middle_name");
        String empLastname= js.getString("employee.emp_lastname");
        String empBirthday= js.getString("employee.emp_birthday");
        String empGender= js.getString("employee.emp_gender");
        String empJobTitle= js.getString("employee.emp_job_title");
        String empStatus= js.getString("employee.emp_status");

        Assert.assertEquals("MEssage",employeeID1,empID);
        Assert.assertTrue(employeeID1.contentEquals(empID));
        Assert.assertEquals(empFirstname,"Elya");




    }
    @Test
    public void cGetAllEmployee(){
        RequestSpecification requestGetAllEmp= given().header("Conten_Type","application/json")
                .header("Authorization",token);
        Response getAllempResponse= requestGetAllEmp.when().get("/getAllEmployees.php");
        //print all employees
        getAllempResponse.prettyPrint();

        //Storing response as a String
        String reponse=getAllempResponse.asString();

        JsonPath js=new JsonPath(reponse);
        //retrieving the size of array Employees
        int count= js.getInt("Employees.size()");
        System.out.println(count);

        for (int i = 0; i < count; i++) {
            String id= js.getString("Employees["+i+"].employee_id");
          //  System.out.println(id);
            if(id.contentEquals(empID)){
                System.out.println("Employee ID "+empID+" is present in body");
                String firstNameOfEmpID= js.getString("Employees["+i+"].emp_firstname");
                System.out.println(firstNameOfEmpID);
                break;
            }
        }

        for (int i = 0; i < count; i++) {

            String firstName= js.getString("Employees["+i+"].emp_firstname");
            //System.out.println(firstName);
        }
         }
         @Test
         public void dPUTupdateCreatedEmployee(){
        RequestSpecification requestUpdateEmp= given().header("Content-Type","application/json")
                .header("Authorization",token).body( "{\n" +
                        "  \"employee_id\": \""+ empID+"\",\n" +
                        "  \"emp_firstname\": \"Elya\",\n" +
                        "  \"emp_lastname\": \"Zhana\",\n" +
                        "  \"emp_middle_name\": \"\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1987-04-26\",\n" +
                        "  \"emp_status\": \"Freelance\",\n" +
                        "  \"emp_job_title\": \"Cloud Consultant\"\n" +
                        "}");

        Response responseUpdateEmp= requestUpdateEmp.when().put("/updateEmployee.php");
        responseUpdateEmp.prettyPrint();

             String empLastnameUpdate=  responseUpdateEmp.body().jsonPath().getString("Employee.emp_lastname"); //1way
        Assert.assertEquals("Message","Zhana",empLastnameUpdate);

         }



}
