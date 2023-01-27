package common;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static common.config.*;

@SuppressWarnings("ConstantConditions")
public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);

        switch (PLATFORM_AND_BROWSER) {


            case "win_chrome" -> {
                Configuration.browser = "chrome";
                Configuration.headless = false;
                Configuration.screenshots = true;
            }

            case "win_firefox" -> {
                Configuration.browser = "firefox";
                Configuration.headless = false;
                Configuration.screenshots = true;
            }
            case "win_edge" -> {
                Configuration.browser = "edge";
                Configuration.headless = false;
                Configuration.screenshots = true;
            }
            case "mac_safari" -> {
                Configuration.browser = "safari";
                Configuration.headless = false;
                Configuration.screenshots = true;
            }

//_____________________________________________________________________________

            case "win_chrome_headless" -> {
                Configuration.browser = "chrome";
                Configuration.headless = true;
                Configuration.screenshots = false;
            }
            case "win_firefox_headless" -> {
                Configuration.browser = "firefox";
                Configuration.headless = true;
                Configuration.screenshots = false;
            }
            case "win_edge_headless" -> {
                Configuration.browser = "edge";
                Configuration.headless = true;
                Configuration.screenshots = false;
            }
            case "mac_safari_headless" -> {
                Configuration.browser = "safari";
                Configuration.headless = true;
                Configuration.screenshots = false;
            }
            default -> Assert.fail("Error while webdriver: " + PLATFORM_AND_BROWSER);
        }
        switch (SET_WINDOW_SIZE) {
            case "default" -> Configuration.browserSize = "";
            case "maximize" -> Configuration.browserSize = "1920x1080";
            case "minimize" -> Configuration.browserSize = "600x400";
            default -> Assert.fail("Error while setting window size: " + SET_WINDOW_SIZE);
        }
        switch (SET_WAIT_TIMEOUT) {
            case "fast" -> Configuration.timeout = 5000;
            case "middle" -> Configuration.timeout = 10000;
            case "slow" -> Configuration.timeout = 15000;
            default -> Assert.fail("Error while setting timeout: " + SET_WINDOW_SIZE);
        }
        return driver;
    }
}
