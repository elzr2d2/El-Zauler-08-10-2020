package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class functionalElements {

    WebDriver driver;

    public functionalElements(WebDriver driver) {
        this.driver = driver;
    }

    public void scroll_to_element(String element) {
        Actions actions = new Actions(driver);

        switch (element) {
            case "first":
                actions.moveToElement(driver.findElement(By.className("slick-list")));
                break;

            case "second":
                actions.moveToElement(driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/div/section[4]/div[2]")));
                break;

            case "down":
                actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
                break;
        }

        actions.perform();
    }


}
