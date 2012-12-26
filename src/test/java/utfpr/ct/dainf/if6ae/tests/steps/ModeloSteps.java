package utfpr.ct.dainf.if6ae.tests.steps;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Wilson
 */
public class ModeloSteps {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String CONTEXT = "/servlet-simples-test";
    private static final String CONTEXT_URL = BASE_URL + CONTEXT;

    WebDriver driver;

    @Before
    public void before() {
        driver = new FirefoxDriver();
    }

    @After
    public void after() {
        driver.close();
    }

    /**
     * Navigates to a URL relative to the context path.
     * The URL must start with a slash (/).
     * Example: When I navigate to "/home/form"
     * @param url The relative URL.
     */
    @When("^I navigate to \"([^\"]*)\"$")
    public void navigateTo(String relURL) throws Throwable {
        driver.get(CONTEXT_URL + relURL);
    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void fillIn(String fieldName, String value) throws Throwable {
        WebElement we = driver.findElement(By.name(fieldName));
        we.sendKeys(value);
    }

    @When("^I click the \"([^\"]*)\" button$")
    public void click(String name) throws Throwable {
        WebElement we = driver.findElement(By.name(name));
        we.click();
    }

    @Given("^I am on the home page$")
    public void openHomePage() throws Throwable {
        navigateTo("");
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void shouldSee(String text) throws Throwable {
        String source = driver.getPageSource();
        Assert.assertTrue("Source: " + source, source.contains(text));
    }
}
