package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import pages.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features")
public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage(androidDriver);

    @Test
    public void login()
    {
        loginPage.loginToApp();
    }
}
