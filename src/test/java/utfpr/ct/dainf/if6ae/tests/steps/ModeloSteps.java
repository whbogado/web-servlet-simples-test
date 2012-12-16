/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if6ae.tests.steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.runtime.PendingException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Wilson
 */
public class ModeloSteps {

    WebDriver driver; 
    
    private WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }
    
    @Given("^I am on the home page$")
    public void openHomePage() throws Throwable {
        getDriver().get("http://localhost:8080/servlet-simples-test");
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void shouldSee(String text) throws Throwable {
        getDriver().get("http://localhost:8080/servlet-simples-test");
        String source = getDriver().getPageSource();
        Assert.assertTrue("Source: " + source, source.contains(text));
        getDriver().close();
    }
}
