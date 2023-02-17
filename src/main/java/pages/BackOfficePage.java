package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class BackOfficePage {
    public static final String SIGN_IN_WITH_GOOGLE_LOCATOR = "//html/body/div[1]/div/div[2]/div[2]/button";
    public static final String LOGIN_BACKOFFICE_LOCATOR = "//html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/" +
            "div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input";

    public static final String MERCHANTS_LOCATOR = "//html/body/div[1]/div/section/div/main/div/div[2]/div/div/div[1]/" +
            "div[2]/div/div[2]/a[3]";
    public static final String MERCHANT_GUID_SEARCH_LOCATOR = "//input[@id='queryTransactions_params_0_input']";
    public static final String SEARCH_BUTTON_LOCATOR = "//button[contains(text(),'Search')]";
    public static final String FPF_SETTING_LOCATOR = "//html/body/div[1]/div/section/div/main/div/div[2]/div/div/div/" +
            "div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[9]/div/div[2]/div/span/svg";
    public static final String MERCHANTS_ON_TABLE_LOCATOR = "//*[@id='root']/div/section/div/main/div/div[2]/div/div/" +
            "div/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr";
    public static final String DECRYPT_BUTTON_LOCATOR = "//span[contains(text(),'Decrypt')]/parent::button";
    public static final String MAIN_SETTINGS_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/" +
            "div[1]/div/div[1]";
    public static final String BASE_CURRENCY_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/" +
            "div/div[1]/div[3]/div/div/div/div/div";
    public static final String OK_BUTTON_MAIN_SETTINGS_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[3]/" +
            "button[2]";
    public static final String LOGO_AND_COLORS_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/" +
            "div[1]/div[1]/div/div[2]";
    public static final String BACKGROUND_COLOR_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/" +
            "div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div";
    public static final String BACKGROUND_COLOR_INPUT_LOCATOR = "//input[@id='rc-editable-input-3']";
    public static final String TEXT_BLACK_COLOR_INPUT_LOCATOR = "//input[@id='rc-editable-input-4']";
    public static final String TEXT_GREY_COLOR_INPUT_LOCATOR = "//input[@id='rc-editable-input-6']";
    public static final String MAIN_COLOR_INPUT_LOCATOR = "//input[@id='rc-editable-input-7']";

    public static final String TEXT_BLACK_COLOR_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/" +
            "div[2]/div/div[2]/div[3]/div/div/div/div/div/div/div";
    public static final String TEXT_GREY_COLOR_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/" +
            "div[2]/div/div[2]/div[4]/div/div/div/div/div/div/div";
    public static final String MAIN_COLOR_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/" +
            "div/div[2]/div[5]/div/div/div/div/div/div/div";
    public static final String OK_BUTTON_LOGO_AND_COLORS_LOCATOR = "//button[contains(text(),'Ok')]";
    @Step("Login to BO")
    public void userLogin(String email, String password) {

    }
    @Step("Click to Merchants button")
    public void clickMerchants(){
        $x(MERCHANTS_LOCATOR).shouldBe(Condition.visible).click();
        $x(SEARCH_BUTTON_LOCATOR).shouldBe(Condition.visible);
    }
    @Step("Search merchant id")
    public void searchMerchantId(String id){
        $x(MERCHANT_GUID_SEARCH_LOCATOR).sendKeys(id);
        $x(SEARCH_BUTTON_LOCATOR).click();
        $$x(MERCHANTS_ON_TABLE_LOCATOR).shouldHave(CollectionCondition.size(1));
    }
    @Step("Click to icon fpf settings")
    public void clickToIconFPFSettings(){
        $x(FPF_SETTING_LOCATOR).click();
        $x(DECRYPT_BUTTON_LOCATOR).shouldBe(Condition.visible);
    }
    @Step("Change Base Currency")
    public void changeBaseCurrency(){

    }
    @Step("Switch between Main and Colors Settings")
    public void switchSettings(){
        if ($x(DECRYPT_BUTTON_LOCATOR).isDisplayed()) {
            $x(LOGO_AND_COLORS_LOCATOR).click();
        }
        else {
            $x(MAIN_SETTINGS_LOCATOR).click();
        }
    }
    @Step("Choosing colors")
    public void chooseColors(String backgroundColor, String textBlackColor,
                             String textGreyColor, String mainColor){
     $x(BACKGROUND_COLOR_LOCATOR).click();
     $x(BACKGROUND_COLOR_INPUT_LOCATOR).sendKeys(backgroundColor);
     $x(TEXT_BLACK_COLOR_LOCATOR).doubleClick();
     $x(TEXT_BLACK_COLOR_INPUT_LOCATOR).sendKeys(textBlackColor);
     $x(TEXT_GREY_COLOR_LOCATOR).doubleClick();
     $x(TEXT_GREY_COLOR_INPUT_LOCATOR).sendKeys(textGreyColor);
     $x(MAIN_COLOR_LOCATOR).doubleClick();
     $x(MAIN_COLOR_INPUT_LOCATOR).sendKeys(mainColor);
     $x(OK_BUTTON_LOGO_AND_COLORS_LOCATOR).doubleClick();
     $x(OK_BUTTON_LOGO_AND_COLORS_LOCATOR).shouldNotBe(Condition.visible);
    }
}