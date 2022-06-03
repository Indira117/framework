package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods{
    @FindBy(id="txtUsername")
    public WebElement username;

    @FindBy(id="txtPassword")
    public   WebElement passwordBox;

    @FindBy(id="btnLogin")
    public   WebElement loginBtn;

    @FindBy(id="spanMessage")
    public WebElement errorMsg;

//    public LoginPage(WebElement username, WebElement passwordBox, WebElement loginBtn) {
//        this.username = username;
//        this.passwordBox = passwordBox;
//        this.loginBtn = loginBtn;
//    }

    public  LoginPage(){
        PageFactory.initElements(CommonMethods.driver,this);  // constructor
    }

    public void login(String uname,String password){
        sendText(username,uname);
        sendText(passwordBox,password);

    }
    public void clickOnLoginButton(){
        click(loginBtn);
    }

    public  String getErrorMessegeText(){
        return errorMsg.getText();
    }
}
