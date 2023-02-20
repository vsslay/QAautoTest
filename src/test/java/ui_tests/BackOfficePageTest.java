package ui_tests;

import base.BaseTest;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static constants.constants.Urls.BACK_OFFICE_URL;

@Owner("Peter Busko")
@Epic("Account")
@Feature("LoginAndRegister")
@Description("Login and registration page tests")
public class BackOfficePageTest extends BaseTest {
    @BeforeTest(description = "Navigating to URL")
    public void navigate(){
        open(BACK_OFFICE_URL);
        backOfficePage.waitForLogin();
    }
    @Test(testName = "", groups = "Back office",
            description = "")
    @AllureId("")
    @Tags({@Tag("Smoke"), @Tag("Web"), @Tag("TestUI")})
    @Story("")
    @Severity(SeverityLevel.CRITICAL)
    @Description("")
    public void loginWithValidCredentials(){
        backOfficePage.clickMerchants();
        backOfficePage.searchMerchantId("");
        backOfficePage.clickToIconFPFSettings();
        backOfficePage.changeBaseCurrency();
        backOfficePage.switchSettings();
        backOfficePage.chooseColors("","",
                                       "","",
                                   "","",
                                     "","");
    }
}
