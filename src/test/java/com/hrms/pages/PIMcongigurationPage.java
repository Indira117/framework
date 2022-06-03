package com.hrms.pages;

import com.hrms.testbase.PageInitializer;
import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMcongigurationPage extends CommonMethods {
    @FindBy(id = "menu_pim_Configuration")
    public WebElement configurationDropDown;

    @FindBy(id = "menu_pim_configurePim")
    public WebElement optionalFields;

    @FindBy(xpath = "//input[@value= 'Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "//li[@class= 'checkbox']")
    public List<WebElement> checkboxes;

    public void clickOnConfigurationDD(){
        jsClick(configurationDropDown);
    }
    public void clickOnOptionalFields(){
        jsClick(optionalFields);
    }
    public void clickOnEditBtn(){
        jsClick(editBtn);
    }

    public PIMcongigurationPage(){
        PageFactory.initElements(driver,this);
    }
}
