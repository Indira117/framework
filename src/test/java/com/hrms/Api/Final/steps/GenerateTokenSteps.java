package com.hrms.Api.Final.steps;

import com.hrms.utils.APICommonMethods;
import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class GenerateTokenSteps {
     public static String token;
    public static   String baseURI= RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
    @Given("a JWT is generated")
    public void a_JWT_is_generated() {

//      RequestSpecification requestToken= given().header("Content-Type","application/json").body("{\n" +
//                "  \"email\": \"nickKB17@gmail.com\",\n" +
//                "  \"password\": \"nickKB@gmail.com\"\n" +
//                "}");
        RequestSpecification requestToken= APICommonMethods.generateToken(CommonMethods.readJson(APIConstants.GENERATE_TOKEN_JSON));
        Response responseToken=requestToken.when().post(APIConstants.GENERATE_TOKEN_URI);
        responseToken.prettyPrint();

        token="Bearer "+responseToken.jsonPath().getString("token");


    }

}
