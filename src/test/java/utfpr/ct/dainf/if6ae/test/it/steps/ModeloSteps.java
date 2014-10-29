package utfpr.ct.dainf.if6ae.test.it.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Executa os testes de intergração usando Cucumber e WebDriver.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class ModeloSteps {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String CONTEXT = "/servlet-simples-test";
    private static final String CONTEXT_URL = BASE_URL + CONTEXT;

    private static WebDriver driver;

    @Before
    public static void before() {
//         driver = new FirefoxDriver(); // necessita acesso ao Firefox
        driver = new HtmlUnitDriver();
    }

    @After
    public static void after() {
        driver.close();
    }

    /**
     * Navigates to a URL relative to the context path.
     * The URL must start with a slash (/).
     * Example: When I navigate to "/home/form"
     * @param relURL Relative URL to navegate to
     * @throws java.lang.Throwable
     */
    @When("^I navigate to \"([^\"]*)\"$")
    public void navigateTo(String relURL) throws Throwable {
        driver.get(CONTEXT_URL + relURL);
    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void fillIn(String fieldName, String value) throws Throwable {
        WebElement we = driver.findElement(By.name(fieldName));
        if (value.isEmpty()) {
            we.clear();
        } else {
            we.sendKeys(value);
        }
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
