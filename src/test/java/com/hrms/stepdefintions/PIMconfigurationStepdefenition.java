package com.hrms.stepdefintions;

import com.hrms.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;

public class PIMconfigurationStepdefenition extends CommonMethods {
    @When("click on configuration DD")
    public void click_on_configuration_DD() {
        piMcongigurationPage.clickOnConfigurationDD();

    }

    @When("click on optional fields")
    public void click_on_optional_fields() {
piMcongigurationPage.clickOnOptionalFields();
    }

    @When("click on editBtn")
    public void click_on_editBtn() {
piMcongigurationPage.clickOnEditBtn();
    }

    @When("uncheck unnecessary checkboxes")
    public void uncheck_unnecessary_checkboxes(DataTable checkBoxOptions) throws InterruptedException {
        List<String> expectedCheckBoxes=checkBoxOptions.asList();
        for (int i = 0; i < expectedCheckBoxes.size(); i++) {
            clickRadioOrCheckboxByTEXT(piMcongigurationPage.checkboxes, expectedCheckBoxes.get(i));
        }
Thread.sleep(2000);


    }

}
