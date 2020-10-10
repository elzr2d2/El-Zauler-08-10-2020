package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.buttonElements;
import pageElements.formElements;
import pageElements.functionalElements;
import pageElements.imageElements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LandingPageSteps {
    WebDriver driver = null;
    final String baseUrl = "https://automation.herolo.co.il/";

    formElements formElementsExe;
    buttonElements buttonExe;
    imageElements imageExe;
    functionalElements functionalExe;


    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(pageLoadCondition);
    }

    @Before
    public void beforeScenario() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Given("user goes to the landing page")
    public void login_page() {
        driver.get(baseUrl);

        waitForLoad(driver);
    }

    @When("^user inserts (.*), (.*), and (.*) in a (.*) form$")
    public void insert_form_values(String name, String email, String phone, String form) throws InterruptedException {
        formElementsExe = new formElements(driver);

        if (form.equals("footer")) {
            formElementsExe.insert_footer_name(name);
            Thread.sleep(2000);

            formElementsExe.insert_footer_email(email);
            Thread.sleep(2000);

            formElementsExe.insert_footer_phone(phone);
            Thread.sleep(2000);
        } else {
            fail();
            System.out.println("TEST FAILED at: insert_form_values");
        }

    }


    @When("^user inserts (.*), (.*), (.*), and (.*) in the section form$")
    public void insert_section_form_values(String name, String email, String phone, String company) throws InterruptedException {
        formElementsExe = new formElements(driver);

        formElementsExe.insert_section_name(name);
        Thread.sleep(2000);

        formElementsExe.insert_section_name(name);
        Thread.sleep(2000);

        formElementsExe.insert_section_company(company);
        Thread.sleep(2000);

        formElementsExe.insert_section_email(email);
        Thread.sleep(2000);

        formElementsExe.insert_section_phone(phone);
        Thread.sleep(2000);

    }

    @And("^user clicks on the (.*) Form send button$")
    public void click_form_send(String form) {
        formElementsExe = new formElements(driver);

        if ("footer".equals(form)) {
            formElementsExe.click_footer_send();
        } else if ("section".equals(form)) {
            formElementsExe.click_section_send();
        } else {
            fail();
            System.out.println("TEST FAILED at: click_form_send");
        }
    }

    @And("the popup form appears")
    public void popup_form_appears() {

    }

    @And("^scrolls (.*)$")
    public void scrollsDown(String element) {
        functionalExe = new functionalElements(driver);

        functionalExe.scroll_to_element(element);
    }

    @When("^click the (.*) button$")
    public void click_Link_button(String button) {
        buttonExe = new buttonElements(driver);


        switch (button) {
            case "wrapper_whatsapp":
                buttonExe.click_side_whatsapp();
                break;
            case "linkedin":
                buttonExe.click_contact_linkedin();
                break;
            case "whatsapp":
                buttonExe.click_contact_whatsapp();
                break;
            case "facebook":
                buttonExe.click_contact_facebook();
                break;
            case "herolo.co.il":
                buttonExe.click_contact_website();
                break;
            case "scroll_up":
                buttonExe.click_scroll_top();
                break;
            default:
                fail();
        }
    }

    @Then("user gets into the thank-you page")
    public void get_thank_you_page() throws InterruptedException {
        waitForLoad(driver);
        Thread.sleep(5000);


        assertTrue(driver.getPageSource().contains("תודה"));

        Thread.sleep(5000);

    }

    @Then("^user gets into a (.*) page$")
    public void Gets_into_Linked_page(String link_button) throws InterruptedException {
        waitForLoad(driver);
        Thread.sleep(5000);


        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);

        if (!driver.getCurrentUrl().equals(baseUrl))
            assertTrue(driver.getPageSource().contains(link_button) || driver.getCurrentUrl().equals("herolo.co.il"));
        else
            fail();

        Thread.sleep(5000);
    }

    @Then("user gets into the top of the page")
    public void check_if_top() throws InterruptedException {
        buttonExe = new buttonElements(driver);
        Thread.sleep(5000);

        assertFalse(buttonExe.is_scroll_top_visible());

    }

    @When("^user scrolls to the (.*) section$")
    public void scroll_to_image_section(String section) {
        functionalExe = new functionalElements(driver);

        if (section.equals("first")) {
            functionalExe.scroll_to_element(section);
        } else if (section.equals("second")) {
            functionalExe.scroll_to_element(section);
        }

    }


    @Then("^the (.*) section images should be swapped$")
    public void check_image_Swap(Boolean is_swapped) {

        assert(is_swapped);
    }


    @And("^clicks on the dots of the (.*) section$")
    public void clicks_dots(String section) throws InterruptedException {
        imageExe = new imageElements(driver);
        List<WebElement> dots = imageExe.get_list_dots(section);
        Thread.sleep(2000);

        for (WebElement dot : dots) {
            String source = imageExe.get_image_section_info(section);
            dot.click();
            String dest = imageExe.get_image_section_info(section);

            if (source.equals(dest)) {
                check_image_Swap(false);
            }

            Thread.sleep(1000);

        }

        check_image_Swap(true);
    }

    @And("dragging an image (.*)")
    public void dragging_image(String side) {

    }

    @And("^clicks on the (.*) arrow (.*) section$")
    public void clicks_on_arrow(String side, String section) throws InterruptedException {
        imageExe = new imageElements(driver);

        String source = imageExe.get_image_section_info(section);
        imageExe.click_on_arrow(side);

        driver.manage().wait(5000);
        String dest = imageExe.get_image_section_info(section);

        check_image_Swap(!source.equals(dest));
    }

    @And("^dragging an image (.*)$")
    public void draggingAnImageSide() {
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

}
