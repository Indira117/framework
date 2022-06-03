package com.hrms.utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static   String baseURI= RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
    public static final String GENERATE_TOKEN_URI=baseURI+"/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI=baseURI+"/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URI=baseURI+"/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI=baseURI+"/updateEmployee.php";
    public static final String GET_ALL_EMPLOYEES_URI=baseURI+"/getAllEmployees.php";

    public static final String CREATE_EMPLOYEE_JSON=System.getProperty("user.dir")+"/src/test/resources/JSONFiles/createEmployee.json";
    public static final String GENERATE_TOKEN_JSON=System.getProperty("user.dir")+"/src/test/resources/JSONFiles/generateToken.json";

}
