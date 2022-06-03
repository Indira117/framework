package com.hrms.stepdefintions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods {

    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
        setUp();


    }

    @When("enter valid credentials")
    public void enter_valid_credentials() {
     loginPage.login("Admin","Hum@nhrm123");
    }

    @When("click on login button")
    public void click_on_login_button() {
loginPage.clickOnLoginButton();
    }

    @Then("verify dashboard is displayed")
    public void verify_dashboard_is_displayed() {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }


    @And("quit the browser")
    public void quitTheBrowser() {
        tearDown();
    }

    @When("enter invalid credentials")
    public void enterInvalidCredentials() {
        loginPage.login("Admi","Hum@nhrm23");
    }

    @Then("verify error message")
    public void verifyErrorMessage() {
       // Assert.assertTrue(loginPage.errorMsg.isDisplayed());
        Assert.assertEquals("Verifying error message","Invalid credentials",loginPage.getErrorMessegeText());
    }
}
