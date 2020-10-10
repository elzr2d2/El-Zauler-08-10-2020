package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class formElements {

    WebDriver driver;


    By tb_footer_name = By.name("name");
    By tb_footer_email = By.name("email");
    By tb_footer_phone = By.name("phone");
    By btn_footer_send = By.xpath("//*[@id='footer']/form/button");

    By tb_section_name = By.id("name");
    By tb_section_company = By.id("company");
    By tb_section_email = By.id("email");
    By tb_section_phone = By.id("telephone");
    By btn_section_send = By.xpath("//*[@id='section-inputs']/div[3]/a");


    public formElements(WebDriver driver) {
        this.driver = driver;
    }


    //============FOOTER FORM============
    public void insert_footer_name(String name) {

        driver.findElement(tb_footer_name).sendKeys(name);
    }

    public void insert_footer_email(String email) {

        driver.findElement(tb_footer_email).sendKeys(email);
    }

    public void insert_footer_phone(String phone) {

        driver.findElement(tb_footer_phone).sendKeys(phone);
    }

    public void click_footer_send() {
        driver.findElement(btn_footer_send).click();
    }


    //============SECTION FORM============
    public void click_section_name() {
        driver.findElement(tb_section_name).click();
        driver.findElement(tb_section_name).clear();

    }

    public void insert_section_name(String name) {
        driver.findElement(tb_section_name).sendKeys(name);
    }

    public void insert_section_company(String company) {

        driver.findElement(tb_section_company).sendKeys(company);
    }

    public void insert_section_email(String email) {

        driver.findElement(tb_section_email).sendKeys(email);
    }

    public void insert_section_phone(String phone) {

        driver.findElement(tb_section_phone).sendKeys(phone);
    }

    public void click_section_send() {
        driver.findElement(btn_section_send).click();
    }
}
