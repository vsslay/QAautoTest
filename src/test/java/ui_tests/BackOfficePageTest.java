package ui_tests;

import base.BaseTest;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static constants.constants.Urls.BACK_OFFICE_URL;

@Owner("Peter Busko")
@Epic("Account")
@Feature("LoginAndRegister")
@Description("Login and registration page tests")
public class BackOfficePageTest extends BaseTest {
    @BeforeTest(description = "Navigating to URL")
    public void navigate(){
        open(BACK_OFFICE_URL);
        sleep(600000);
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
        backOfficePage.changeBaseCurrency();
    }
}
