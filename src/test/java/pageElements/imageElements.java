package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class imageElements {

    WebDriver driver;

    By left_arrow = By.xpath("//*[@id='gatsby-focus-wrapper']/div/section[3]/div/div[1]");
    By right_arrow = By.className("//*[@id='gatsby-focus-wrapper']/div/section[3]/div/div[3]");
    By first_image_section = By.xpath("//*[@id='gatsby-focus-wrapper']/div/section[3]/div/div[2]/div");
    By second_image_section = By.xpath("//*[@id='gatsby-focus-wrapper']/div/section[4]/div/div/div");
    By slick_dots = By.className("slick-dots");

    public imageElements(WebDriver driver) {
        this.driver = driver;
    }

    public void click_on_arrow(String side) {
        if(side.equals("left")) {
            driver.findElement(left_arrow).click();
        } else if(side.equals("right")){
            driver.findElement(right_arrow).click();
        }
    }

    public String get_image_section_info(String section) {

        return section.equals("first") ? driver.findElement(first_image_section).getAttribute("style")
                                       : driver.findElement(second_image_section).getAttribute("style");
    }

    public List<WebElement> get_list_dots(String section) {

        return driver.findElements(slick_dots);

    }
}

