package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class imageElements {

    WebDriver driver;

    By left_arrow = By.className("slick-arrow slick-prev");
    By right_arrow = By.className("slick-arrow slick-next");


    public imageElements(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> get_first_list_dots() {

        return driver.findElements(By.className("slick_dots"));

    }

    public List<WebElement> get_second_list_dots() {

        return driver.findElements(By.className("slick_dots"));

    }

}
