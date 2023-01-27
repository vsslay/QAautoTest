package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;
import static constants.constants.Urls.LOGIN_PAGE_MERCHANT_URL;

public class DashboardPage {
    public static final String LOG_OUT_BUTTON_LOCATOR = "//html/body/div[1]/div/div/div[1]/div/div[3]";
    public static final String MERCHANT_ID_LOCATOR = "//*[@class='sc-cOajty jAnegm']/div/div";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";

    @Step("Getting Merchant ID")
    public String getMerchantId(){
        return $x(MERCHANT_ID_LOCATOR).getText();
    }

    @Step("Checking Merchant ID")
    public void checkMerchantId(String expectedId){
        Assert.assertEquals(getMerchantId(), expectedId);
    }

    @Step("Logging out")
    public void logOut(){
        $x(LOG_OUT_BUTTON_LOCATOR).click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,LOGIN_PAGE_MERCHANT_URL , "Expected URL is: "
                + LOGIN_PAGE_MERCHANT_URL + ", actual URL is: " + currentUrl);
    }
}
