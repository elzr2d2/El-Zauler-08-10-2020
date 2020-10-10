package pageElements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class functionalElements {

    WebDriver driver;

    public functionalElements(WebDriver driver) {
        this.driver = driver;
    }

    public void scroll_down() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
    }


}
