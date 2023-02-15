package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.concurrent.ThreadLocalRandom;
import static com.codeborne.selenide.Selenide.$$x;

public class BasePage {

    /**
     * Pick random item from list of elements
     * Usable for different dropdowns for better coverage
     *
     * @param locator is a 'By' locator of element on web-page
     * @return element to click
     */
    @Step("Picking random item from provided table")
    public WebElement pickRandomItemFromTable(String locator) {
        ElementsCollection itemsInDropdown = $$x(locator);
        int listSize = itemsInDropdown.size();
        int randNumber = ThreadLocalRandom.current().nextInt(0, listSize);
        return itemsInDropdown.get(randNumber);
    }
}
