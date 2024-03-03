package tests;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import steps.LoginPage;
import steps.SampleListPage;

@Cucumber
@Suite
@SelectClasspathResource("tests")
public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage(androidDriver);
    SampleListPage sampleListPage = new SampleListPage(androidDriver);

    @Test
    public void loginFormNavigationTest()
    {
        loginPage.clickButtonLoginToApp();
        loginPage.verifyPresenceLoginForm(false);
        loginPage.clickButtonBack();
        loginPage.verifyPresenceLoginForm(true);
    }

    @Test
    public void successfulLoginTest()
    {
        loginPage.verifyPresenceLoginForm(true);
        loginPage.setUserName("admin");
        loginPage.setPassword("admin");
        loginPage.clickButtonLoginToApp();
        sampleListPage.waitForPageLoaded();
    }

    @Test
    public void unSuccessfulLoginTest()
    {
        loginPage.verifyPresenceLoginForm(true);
        loginPage.setUserCredentials("admin", "wrongPassword");
        loginPage.clickButtonLoginToApp();
        loginPage.waitForMessageDialogPresent();
        loginPage.verifyErrorMessagePresence(true);
    }
}
