package pages;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.LoginLocators;

public class LoginPage extends BasePage{

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    @Given("Click button 'LOG IN'")
    public void setUserCredentials(String userName, String password)
    {
        LoginLocators.actionBar.click();
    }

    @When("Click button 'LOG IN'")
    public void clickLoginToApp()
    {
        LoginLocators.actionBar.click();
    }

    @Then("Click button 'LOG IN'")
    public void verifyErrorMessagePresence()
    {
        LoginLocators.actionBar.click();
    }
}
