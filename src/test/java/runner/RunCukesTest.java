package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import framework.selenium.DriverManager;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features"},
//        features = {"src/test/resources/features/filebroker"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {


    @AfterTest
    public void afterExecution() {
        try {

        } catch (Exception e) {
        } finally {
            DriverManager.getInstance().quitDriver();
        }
    }
}
