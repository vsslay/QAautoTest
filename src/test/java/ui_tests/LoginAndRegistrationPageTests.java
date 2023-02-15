package ui_tests;

import base.BaseTest;
import base.RetryOnFail;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static constants.constants.Urls.LOGIN_PAGE_MERCHANT_URL;

@Owner("Peter Busko")
@Epic("Account")
@Feature("LoginAndRegister")
@Description("Login and registration page tests")
public class LoginAndRegistrationPageTests extends BaseTest {

    @BeforeTest(description = "Navigating to URL")
    public void navigate(){
        open(LOGIN_PAGE_MERCHANT_URL);
    }

    @Test(testName = "Login with valid credentials", groups = "Login and registration page",
            description = "Login with valid credentials")
    @AllureId("1")
    @Tags({@Tag("Smoke"), @Tag("Web"), @Tag("TestUI")})
    @Story("Login and register on login page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User opens browser, inputting valid credentials and getting to personal account")
    public void loginWithValidCredentials(){
        loginAndRegistrationPage.userLogin("test_user_abc@mail.ru", "SecretSauce123!@#");
        dashboardPage.logOut();
    }

    @Test(testName = "Switch between login and registration", groups = "Login and registration page",
            description = "Switch between login and registration")
    @AllureId("2")
    @Tags({@Tag("Web"), @Tag("TestUI")})
    @Story("Login and register on login page")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("User opens browser, switches between login and registration forms")
    public void switchBetweenLogAndReg(){
        loginAndRegistrationPage.switchBetweenLoginAndRegistration()
                                .switchBetweenLoginAndRegistration();
    }

    @Test(testName = "Check Privacy Agreement", groups = "Login and registration page",
            description = "Check Privacy Agreement")
    @AllureId("3")
    @Tags({@Tag("Web"), @Tag("TestUI")})
    @Story("Login and register on login page")
    @Severity(SeverityLevel.MINOR)
    @Description("User opens browser, switches to reg form and opens PA")
    public void checkPrivacyAgreement(){
        loginAndRegistrationPage.switchBetweenLoginAndRegistration()
                                .confirmPolicyAgreement()
                                .checkPolicyAgreement();
    }

    @Test(retryAnalyzer = RetryOnFail.class, testName = "Register new User", groups = "Login and registration page",
            description = "Register new User")
    @AllureId("4")
    @Tags({@Tag("Smoke"), @Tag("Web"), @Tag("TestUI"), @Tag("Flaky")})
    @Story("Login and register on login page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User opens browser, and proceeds to registration")
    public void createNewUser(){
        loginAndRegistrationPage.switchBetweenLoginAndRegistration()
                                .confirmPolicyAgreement()
                                .userRegistration("test_user_abc1241@mail.com", "SecretSauce12421@#");
    }
}
