package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.buttonElements;
import pageElements.formElements;
import pageElements.functionalElements;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LandingPageSteps {
    final String baseUrl = "https://automation.herolo.co.il/";
    WebDriver driver = null;
    formElements formElementsExe;
    buttonElements buttonExe;
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

    @And("scrolls down")
    public void scroll_down() throws InterruptedException {
        functionalExe = new functionalElements(driver);

        functionalExe.scroll_down();
        Thread.sleep(2000);
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
            case "Herolo":
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

        assertTrue(driver.getPageSource().contains("תודה"));

        Thread.sleep(2000);
    }

    @Then("^user gets into a (.*) page$")
    public void Gets_into_Linked_page(String link_button) throws InterruptedException {
        waitForLoad(driver);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);

        if (!driver.getCurrentUrl().equals(baseUrl))
            assertTrue(driver.getPageSource().contains(link_button));
        else
            fail();

        Thread.sleep(2000);
    }

    @Then("user gets into the top of the page")
    public void check_if_top() throws InterruptedException {
        buttonExe = new buttonElements(driver);
        Thread.sleep(2000);

        assertFalse(buttonExe.is_scroll_top_visible());

    }

    @After
    public void afterScenario() {
        driver.quit();
    }

}
