package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinitions"}, publish = true,
        monochrome = false,
        plugin = {"pretty",
                "junit:target/JUnityReports/report.xml",
                "json:target/JSONReports/report.json",
                "html:target/HtmlReports/report"},
                tags = "@FunctionalityTesting")
public class TestRunner {

}
