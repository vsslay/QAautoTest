package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static constants.constants.Urls.LOGIN_PAGE_MERCHANT_URL;

public class DashboardPage {
    public static final String LOG_OUT_BUTTON_LOCATOR = "//html/body/div[1]/div/div/div[1]/div/div[3]";
    public static final String MERCHANT_ID_LOCATOR = "//*[@class='sc-cOajty jAnegm']/div/div";
    public static final String MERCHANT_ID_DROP_DOWN_LOCATOR = "//html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div[2]/div/span[2]";
    public static final String BALANCE_LOCATOR = "//html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[4]/div/div//*";
//    public static final String TYPE_IN_OUT_LOCATOR = "//input[@id='type']";
    public static final String TYPE_IN_BUTTON_LOCATOR = "//div[@class='rc-virtual-list-holder-inner']//*[contains(text(),'";
    public static final String TYPE_IN_OUT_LOCATOR = "//html/body/div[1]/div/div/div[2]/div[2]/div/div[1]/form/div/div[2]/div/div/div/div/div/div[2]/div/span[1]";//    public static final String = "";
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

    @Step("Selecting merchant id")
    public void selectMerchantId(String merchantId){
        $x(MERCHANT_ID_DROP_DOWN_LOCATOR).click();
        $(byText(merchantId)).scrollTo().click();
    }

    @Step("Check balance")
    public void checkBalance(String balance){
        $x(BALANCE_LOCATOR).shouldBe(Condition.visible);
        $x(BALANCE_LOCATOR).shouldHave(Condition.text(balance));
    }
    @Step("Selecting type_in_out")
    public void selectTypeInOut(String typeInOut){
        $x(TYPE_IN_OUT_LOCATOR).click(ClickOptions.usingJavaScript());
        $x(TYPE_IN_BUTTON_LOCATOR + typeInOut + "')]").shouldBe(Condition.visible).click();
    }
}
