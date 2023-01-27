package base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import common.CommonActions;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import pages.*;

import static common.config.*;

public class BaseTest implements ITestListener {

    @SuppressWarnings("unused")
    WebDriver driver = CommonActions.createDriver();

//_____________________________________________ Initialization _________________________________________________________
    protected LoginAndRegistrationPage loginAndRegistrationPage = new LoginAndRegistrationPage();
    protected DashboardPage dashboardPage = new DashboardPage();
    protected QuestionnairePage questionnairePage = new QuestionnairePage();
    protected RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();

    @AfterClass(description = "Clearing cookies and storage")
    public void clearCookiesAndStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            Selenide.clearBrowserCookies();
            Selenide.clearBrowserLocalStorage();
        }
    }

    @AfterClass(alwaysRun = true, description = "Closing WebDriver")
    public void close() {
        if (CLOSE_BROWSER_AFTER_TESTS) {
            Selenide.closeWebDriver();
        }
    }

    @AfterMethod(description = "Taking screenshot and saving log")
    public void onTestFailure (ITestResult result) {
        ITestListener.super.onTestFailure(result);
        saveScreenshotOnFailure();
        saveLog(result.getMethod().getConstructorOrMethod().getName());
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshotOnFailure() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment (value = "TestLog", type = "text/plain")
    public static String saveLog(String message) {
        return message;
    }
}
