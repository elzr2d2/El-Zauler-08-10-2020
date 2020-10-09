package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.buttonElements;
import pageElements.formElements;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LandingPageSteps {
    WebDriver driver = null;
    final String baseUrl = "https://automation.herolo.co.il/";
    formElements formElementsExe;
    buttonElements buttonExe;


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

        if ("footer".equals(form)) {
            formElementsExe.insert_footer_name(name);
            Thread.sleep(2000);

            formElementsExe.insert_footer_email(email);
            Thread.sleep(2000);

            formElementsExe.insert_footer_phone(phone);
            Thread.sleep(2000);

        } else if ("popup".equals(form)) {
            formElementsExe.insert_popup_name(name);
            Thread.sleep(2000);

            formElementsExe.insert_popup_email(email);
            Thread.sleep(2000);

            formElementsExe.insert_popup_phone(phone);
            Thread.sleep(2000);

        } else {
            fail();
            System.out.println("TEST FAILED!");

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
        } else if ("popup".equals(form)) {
            formElementsExe.click_popup_send();
        } else {
            fail();
            System.out.println("TEST FAILED!");

        }

    }

    @And("the popup form appears")
    public void popup_form_appears() {

    }

    @And("scrolls down")
    public void scrollsDown() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
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

//    @Then("a popup should appears")
//    public void check_if_popup_appears() {
//        String mwh = driver.getWindowHandle();
//        Set s = driver.getWindowHandles(); //this method will gives you the handles of all opened windows
//
//        for (Object o : s) {
//            String popupHandle = o.toString();
//            assertFalse(popupHandle.contains(mwh));
//        }
//    }

    @Then("user gets into the top of the page")
    public void check_if_top() throws InterruptedException {
        buttonExe = new buttonElements(driver);
        Thread.sleep(5000);

        assertFalse(buttonExe.is_scroll_top_visible());

    }

    @When("^user scrolls to the (.*) image section$")
    public void userScrollsToTheFirstImageSection() {

    }


    @Then("^the (.*) section images should be swapped$")
    public void theImagesShouldBeSwapped() {
    }

    @And("clicks on the dots")
    public void clicks_dots() {

    }

    @And("dragging an image {string}")
    public void dragging_image(String side) {

    }

    @And("wait")
    public void wait_on_image_section() throws InterruptedException {
        Thread.sleep(5000);
    }

    @And("^clicks on the (.*) arrow$")
    public void clicksOnTheArrowArrow() {
    }

    @And("^dragging an image (.*)$")
    public void draggingAnImageSide() {
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

}
