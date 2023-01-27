package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationConfirmationPage {

    public static final String CONTINUE_BUTTON_LOCATOR = "//*[text()='Continue ']/parent::button";
    public static final String PASSWORD_SET_SUCCESSFULLY = "//*[contains(text(),'set successfully')]";

    @Step("Checking password was confirmed")
    public void checkPasswordConfirmed(){

        $x(PASSWORD_SET_SUCCESSFULLY).shouldBe(Condition.visible);
        $x(CONTINUE_BUTTON_LOCATOR).click();
    }

}
