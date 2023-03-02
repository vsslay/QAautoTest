package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;
import static common.config.SET_WAIT_TIMEOUT;
import static constants.constants.Urls.BACK_OFFICE_LOGIN_URL;

@SuppressWarnings("unused")
public class BackOfficePage {

    public static final String LOGIN_BACKOFFICE_LOCATOR = "//html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/" +
            "div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input";

    public static final String MERCHANTS_LOCATOR = "//html/body/div[1]/div/section/div/main/div/div[2]/div/div/div[1]/" +
            "div[2]/div/div[2]/a[3]";
    public static final String MERCHANT_GUID_SEARCH_LOCATOR = "//input[@id='queryTransactions_params_0_input']";
    public static final String SEARCH_BUTTON_LOCATOR = "//button[contains(text(),'Search')]";
    public static final String FPF_SETTING_LOCATOR = "//*[@id='root']/div/section/div/main/div/div[2]/div/div/div/" +
            "div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[9]/div/div[2]/div/span";
    public static final String FPF_SETTINGS_WINDOW_LOCATOR = "//*[contains(text(),'FPF Settings')]";
    public static final String MERCHANTS_ON_TABLE_LOCATOR = "//*[@id='root']/div/section/div/main/div/div[2]/div/div/" +
            "div/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr";
    public static final String DECRYPT_BUTTON_LOCATOR = "//span[contains(text(),'Decrypt')]/parent::button";
    public static final String MAIN_SETTINGS_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/" +
            "div[1]/div/div[1]";
    public static final String BASE_CURRENCY_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/" +
            "div/div[1]/div[3]/div/div/div/div/div";
    public static final String OK_BUTTON_MAIN_SETTINGS_LOCATOR = "//html/body/div[8]/div/div[2]/div/div[2]/div[3]/" +
            "button[2]";
    public static final String LOGO_AND_COLORS_LOCATOR = "//*[contains(text(),'Logo and colors')]";
    public static final String BACKGROUND_COLOR_LOCATOR = "//*[contains(text(),'Background color')]/parent::div/div";
    public static final String COLOR_INPUT_LOCATOR = "//input[contains(@id,'rc-editable-input')]";


    public static final String TEXT_BLACK_COLOR_LOCATOR = "//*[contains(text(),'Text Black color')]/parent::div/div";
    public static final String TEXT_GREY_COLOR_LOCATOR = "//*[contains(text(),'Text Gray color')]/parent::div/div";
    public static final String MAIN_COLOR_LOCATOR = "//*[contains(text(),'Main color')]/parent::div/div";
    public static final String OK_BUTTON_LOGO_AND_COLORS_LOCATOR = "//button[contains(text(),'Ok')]";
    public static final String SIGN_IN_WITH_GOOGLE_BUTTON_LOCATOR = "//span[contains(text(),'Sign in with Google')]/parent::button";
    public static final String GOOGLE_EMAIL_INPUT_LOCATOR = "//input[@type='email']";
    public static final String GOOGLE_PASSWORD_INPUT_LOCATOR = "//input[@name='password']";
    public static final String GOOGLE_CONTINUE_BUTTON_LOCATOR = "//span[contains(text(),'Далее')]/parent::button";

    @Step("Switching to google auth and inputting credentials")
    public void switchToAuthAndInputCredentials(String googleEmail, String googlePassword){
        $x(SIGN_IN_WITH_GOOGLE_BUTTON_LOCATOR).click();
        Selenide.switchTo().window(1);
        $x(GOOGLE_EMAIL_INPUT_LOCATOR).sendKeys(googleEmail);
        $x(GOOGLE_CONTINUE_BUTTON_LOCATOR).click();
        $x(GOOGLE_PASSWORD_INPUT_LOCATOR).sendKeys(googlePassword);
        $x(GOOGLE_CONTINUE_BUTTON_LOCATOR).click();
        Selenide.switchTo().window(0);
    }

    @Step("Login to BO")
    @SuppressWarnings("ConstantConditions")
    public void waitForLogin(String googleEmail, String googlePassword) {
        Configuration.timeout = 300000;
        switchToAuthAndInputCredentials(googleEmail, googlePassword);
        webdriver().shouldHave(url(BACK_OFFICE_LOGIN_URL));
        switch (SET_WAIT_TIMEOUT) {
            case "fast" -> Configuration.timeout = 5000;
            case "middle" -> Configuration.timeout = 10000;
            case "slow" -> Configuration.timeout = 15000;
            default -> Assert.fail("Error while setting timeout: " + SET_WAIT_TIMEOUT);
        }
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
        Selenide.sleep(4000);
        $x(FPF_SETTING_LOCATOR).shouldBe(Condition.visible).click(ClickOptions.usingJavaScript());
    }

    @Step("Change Base Currency")
    public void changeBaseCurrency(){

    }
    @Step("Switch between Main and Colors Settings")
    public void switchSettings(){
        $x(FPF_SETTINGS_WINDOW_LOCATOR).shouldBe(Condition.visible);
        if ($x(DECRYPT_BUTTON_LOCATOR).isDisplayed()) {
            $x(LOGO_AND_COLORS_LOCATOR).click();
        }
        else {
            $x(MAIN_SETTINGS_LOCATOR).click();
        }
    }
    @Step("Switch between Main and Colors Settings")
    public void switchToColors(){
        $x(FPF_SETTINGS_WINDOW_LOCATOR).shouldBe(Condition.visible);
        $x(LOGO_AND_COLORS_LOCATOR).click();
    }
    @Step("Switch between Main and Colors Settings")
    public void switchToMainSettings(){
        $x(FPF_SETTINGS_WINDOW_LOCATOR).shouldBe(Condition.visible);
        $x(MAIN_SETTINGS_LOCATOR).click();
    }

    @Step("Checking current color")
    public void checkColor(String locatorOfColor, String color, String colorAlternative){
        if ($x(locatorOfColor).getText().equals(color)){
            $x(locatorOfColor).clear();
            $x(locatorOfColor).sendKeys(colorAlternative);
        } else
            {$x(locatorOfColor).clear();
            $x(locatorOfColor).sendKeys(color);}

    }

    @Step("Choosing colors")
    public void chooseColors(String backgroundColor, String textBlackColor,
                             String textGreyColor, String mainColor,
                             String altBackgroundColor, String altTextBlackColor,
                             String altTextGreyColor, String altMainColor){

         $x(BACKGROUND_COLOR_LOCATOR).click();
         checkColor(COLOR_INPUT_LOCATOR, backgroundColor, altBackgroundColor);

         $x(TEXT_BLACK_COLOR_LOCATOR).doubleClick();
         checkColor(COLOR_INPUT_LOCATOR, textBlackColor, altTextBlackColor);

         $x(TEXT_GREY_COLOR_LOCATOR).doubleClick();
         checkColor(COLOR_INPUT_LOCATOR, textGreyColor, altTextGreyColor);

         $x(MAIN_COLOR_LOCATOR).doubleClick();
         checkColor(COLOR_INPUT_LOCATOR, mainColor, altMainColor);

         $x(OK_BUTTON_LOGO_AND_COLORS_LOCATOR).doubleClick();
         $x(OK_BUTTON_LOGO_AND_COLORS_LOCATOR).shouldNotBe(Condition.visible);
    }
}
