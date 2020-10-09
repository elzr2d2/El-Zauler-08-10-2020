package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class buttonElements {

    WebDriver driver;

    By link_wrapper_whatsapp = By.xpath("//*[@id='gatsby-focus-wrapper']/div/a[2]");
    By link_linkedin = By.xpath("//*[@id='section-contact']/section/div[2]/div/div[2]/div/a[1]");
    By link_whatsapp = By.xpath("//*[@id='section-contact']/section/div[2]/div/div[2]/div/a[2]");
    By link_facebook = By.xpath("//*[@id='section-contact']/section/div[2]/div/div[2]/div/a[3]");
    By link_website = By.xpath("//*[@id='section-contact']/section/div[2]/div/div[2]/div/a[4]");
    By link_email = By.xpath("//*[@id='section-contact']/section/div[2]/div/div[1]/div/a[1]");
    By btn_scroll_top = By.xpath("//*[@id='gatsby-focus-wrapper']/div/a[1]");

    public buttonElements(WebDriver driver) {
        this.driver = driver;
    }


   public void click_side_whatsapp() {
        driver.findElement(link_wrapper_whatsapp).click();

   }

    public void click_contact_linkedin() {
        driver.findElement(link_linkedin).click();

    }

    public void click_contact_whatsapp() {
        driver.findElement(link_whatsapp).click();

    }

    public void click_contact_facebook() {
        driver.findElement(link_facebook).click();

    }

    public void click_contact_website() {
        driver.findElement(link_website).click();

    }

    public void click_contact_email() {
        driver.findElement(link_email).click();

    }

    public void click_scroll_top() {
        driver.findElement(btn_scroll_top).click();
    }

    public boolean is_scroll_top_visible() {
       return driver.findElement(btn_scroll_top).isDisplayed();
    }

}
