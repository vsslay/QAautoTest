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

@Owner("Peter Busko")
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

    @Test(testName = "Choose Merchant ID and Check Balance", groups = "Dashboard Page", description = "Choose Merchant " +
            "ID and check Balance")
    @AllureId("6")
    @Tags({@Tag("Smoke"), @Tag("Web"), @Tag("TestUI")})
    @Story("Dashboard Page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Choosing Merchant ID ")
    public void chooseMerchantIdAndCheckBalance(){
        dashboardPage.selectMerchantId("94b9f3ed-ee84-4789-8c4b-41ee8c61ad41");
        dashboardPage.checkBalance("13,490");
    }

    @Test(testName = "Choose type", groups = "Dashboard Page", description = "Choose Type")
    @AllureId("7")
    @Tags({@Tag("Smoke"), @Tag("Web"), @Tag("TestUI")})
    @Story("Dashboard Page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Choosing Type ")
    public void chooseTypeInOut(){
        dashboardPage.selectTypeInOut("In");
    }
}
