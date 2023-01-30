package base;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Listeners implements ITestListener {
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
