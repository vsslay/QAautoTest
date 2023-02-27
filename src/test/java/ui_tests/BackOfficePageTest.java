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
        backOfficePage.waitForLogin("backoffice.admin@armenotech.com",
                                    "qlodYjqmJbF2kohua2dD4q0DBVIxOV");
    }
    @Test(testName = "choosing colors", groups = "Back office",
            description = "")
    @AllureId("8")
    @Tags({@Tag("Smoke"), @Tag("Web"), @Tag("TestUI")})
    @Story("BO")
    @Severity(SeverityLevel.CRITICAL)
    @Description("FPF setting color")
    public void choosingColors(){
        backOfficePage.clickMerchants();
        backOfficePage.searchMerchantId("94b9f3ed-ee84-4789-8c4b-41ee8c61ad41");
        backOfficePage.clickToIconFPFSettings();
//        backOfficePage.changeBaseCurrency();
        backOfficePage.switchToColors();
        backOfficePage.chooseColors("#FFFFFF","#2C2C2C",
                                       "#B1AEAE","#3530FD",
                                   "#4C4C4C","#FFFFFF",
                                     "#7FC103","#EF1E98");
    }
}
