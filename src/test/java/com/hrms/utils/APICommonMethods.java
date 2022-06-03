package com.hrms.utils;

import com.hrms.Api.Final.steps.GenerateTokenSteps;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.hc.core5.http.ContentType;
import org.omg.CORBA.PUBLIC_MEMBER;

import static io.restassured.RestAssured.given;

public class APICommonMethods {
  /**
  Use this method to create an employee
   pass below parameters
   @param token
   @param  createEmplBody
   @return
   */

public static RequestSpecification createEmplRequest(String token, String createEmplBody){
  return     given().header("Authorization",token).header("Content-Type","application/json")
            .body((createEmplBody));
}

  /**
   * Use this method to GET and employee
   * @param token
   * @param employeeID
   * @return
   */
  public static RequestSpecification getOneEmployeeRequest(String token, String employeeID){
  return given().header("Content-Type", ContentType.APPLICATION_JSON).header("Authorization", token)
          .param("employee_id", employeeID);
}
/**
 Use this Method to generate a token
 */
  /**
   * Use
   * @param genarateTokenBody
   * @return
   */
public static RequestSpecification generateToken(String genarateTokenBody){
  return given().header("Content-Type","application/json").body(genarateTokenBody);
}
}
