package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class QuestionnairePage {

    public static final String COMPANY_NAME_INPUT_LOCATOR = "#company_name";
    public static final String STELLAR_ADDRESS_INPUT_LOCATOR = "#stellar_address";
    public static final String CREATE_NEW_STELLAR_BUTTON_LOCATOR = "//*[@value='create']";
    public static final String USE_EXISTING_STELLAR_ADDRESS_BUTTON_LOCATOR = "//*[@value='use']";
    public static final String CONTINUE_BUTTON_LOCATOR = "//*[text()='Continue ']/parent::button";

    @Step("Creating new Stellar Address")
    public QuestionnairePage createNewStellarAddress(){
        if (!$(CREATE_NEW_STELLAR_BUTTON_LOCATOR).isSelected()) {
            $(CREATE_NEW_STELLAR_BUTTON_LOCATOR).click();
        }
        $(COMPANY_NAME_INPUT_LOCATOR).sendKeys("test_company_autotests");
        $(CONTINUE_BUTTON_LOCATOR).click();
        return this;
    }

    @Step("Using existing Stellar Address")
    public QuestionnairePage useExistingStellarAddress(){
        if (!$(USE_EXISTING_STELLAR_ADDRESS_BUTTON_LOCATOR).isSelected()){
            $(USE_EXISTING_STELLAR_ADDRESS_BUTTON_LOCATOR).click();
        }
        $(COMPANY_NAME_INPUT_LOCATOR).sendKeys("test_company_autotests");
        $(STELLAR_ADDRESS_INPUT_LOCATOR).sendKeys("test_stellar_address_autotests");
        $(CONTINUE_BUTTON_LOCATOR).click();
        return this;
    }

}