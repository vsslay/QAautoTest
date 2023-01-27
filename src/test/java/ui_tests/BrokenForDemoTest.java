package ui_tests;

import base.BaseTest;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constants.constants.Urls.LOGIN_PAGE_MERCHANT_URL;

@Owner("Yoana Smolka")
@Epic("TEST")
@Feature("Broken test (DEMO)")
@Description("Broken test (DEMO)")
public class BrokenForDemoTest extends BaseTest {

    @BeforeTest(description = "Navigating to URL")
    public void navigate(){
        open(LOGIN_PAGE_MERCHANT_URL);
    }

    @Test(groups = "Elements page", testName = "Fail test", description = "Failing test for DEMO")
    @Description("This test fails")
    @Severity(SeverityLevel.TRIVIAL)
    public void failureTest() {
        final String NO_SUCH_ELEMENT = "noSuchElementLocator";
        $(NO_SUCH_ELEMENT).click();

    }
}
