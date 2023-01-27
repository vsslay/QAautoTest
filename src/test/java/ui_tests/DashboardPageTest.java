package ui_tests;

import base.BaseTest;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static constants.constants.Urls.LOGIN_PAGE_MERCHANT_URL;

@Owner("Yoana Smolka")
@Epic("Account")
@Feature("Dashboard page")
@Description("Dashboard page tests")
public class DashboardPageTest extends BaseTest {

    @BeforeTest(description = "Navigating to URL")
    public void navigate() {
        open(LOGIN_PAGE_MERCHANT_URL);
        loginAndRegistrationPage.userLogin("test_user_abc@mail.ru", "SecretSauce123!@#");
    }

    @Test(testName = "Check Merchant ID", groups = "Dashboard Page", description = "Check Merchant ID")
    @AllureId("5")
    @Tags({@Tag("Smoke"), @Tag("Web"), @Tag("TestUI")})
    @Story("Dashboard Page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking equality of dashboard Merchant ID to expected ID")

    public void checkMerchantId() {
        dashboardPage.checkMerchantId("825424c4-872b-4e08-abd9-c42a043d11b5");
    }
}
