package base;

import com.codeborne.selenide.Selenide;
import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import pages.*;

import static common.config.*;

public class BaseTest {

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
}
