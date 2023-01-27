package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static constants.constants.Urls.PRIVACY_POLICY_MERCHANT_URL;

public class LoginAndRegistrationPage{

    public final String EMAIL_INPUT_LOCATOR = "#email";
    public final String PASSWORD_INPUT_LOCATOR = "#password";
    public final String LOGIN_BUTTON_LOCATOR = "//*[contains(text(), 'Login')]/parent::button";
    public final String REG_EMAIL_INPUT_LOCATOR = "#regEmail";
    public final String REG_PASSWORD_INPUT_LOCATOR = "#regPassword";
    public final String AGREEMENT_ON_POLICY_LOCATOR = "//*[contains(text(), 'I read and agree to')]/a";
    public final String POLICY_AGREEMENT_CHECKBOX = "//*[contains(text(), 'I read and agree to')]/parent::label//input";
    public final String REGISTER_BUTTON_LOCATOR = "//*[contains(text(), 'Register')]/parent::button";
    public final String LOGIN_IS_OPENED_LOCATOR = "//*[contains(text(),'Need to create an account?')]";
    public final String REGISTER_IS_OPENED_LOCATOR = "//*[contains(text(),'Already have an account?')]";
    public final String PAGE_IS_LOADED_LOCATOR = "//h1[contains(text(),'Privacy Policy & Personal Data')]";

    @Step("Logging into account")
    public void userLogin(String email, String password){
        $(EMAIL_INPUT_LOCATOR).sendKeys(email);
        $(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        $x(LOGIN_BUTTON_LOCATOR).click();
    }

    @Step("Starting new user registration")
    public void userRegistration(String email, String password){
        $(REG_EMAIL_INPUT_LOCATOR).sendKeys(email);
        $(REG_PASSWORD_INPUT_LOCATOR).sendKeys(password);
        $x(REGISTER_BUTTON_LOCATOR).click();
    }

    @Step("Switching between login and registration blocks")
    public LoginAndRegistrationPage switchBetweenLoginAndRegistration (){
        String whichPageIsOpenedNow = "";
        if ($x(LOGIN_IS_OPENED_LOCATOR).isDisplayed()){
            whichPageIsOpenedNow = "login";
        }
        else if ($x(REGISTER_IS_OPENED_LOCATOR).isDisplayed()) {
            whichPageIsOpenedNow = "register";
        }
        switch (whichPageIsOpenedNow){
            case "login" -> $x(REGISTER_BUTTON_LOCATOR).click();
            case  "register" -> $x(LOGIN_BUTTON_LOCATOR).click();
        }
        return this;
    }

    @Step("Open and check user Policy Agreement")
    public void checkPolicyAgreement(){
        $x(AGREEMENT_ON_POLICY_LOCATOR).click();
        Selenide.switchTo().window(1);
        $x(PAGE_IS_LOADED_LOCATOR).shouldBe(Condition.visible);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
        Assert.assertEquals(currentUrl, PRIVACY_POLICY_MERCHANT_URL, "Expected URL is: "
                                        + PRIVACY_POLICY_MERCHANT_URL + ", actual URL is: " + currentUrl);
    }

    @Step("Confirm Policy Agreement checkbox")
    public LoginAndRegistrationPage confirmPolicyAgreement(){
        $x(POLICY_AGREEMENT_CHECKBOX).click();
        $x(POLICY_AGREEMENT_CHECKBOX).isSelected();
        return this;
    }
}
