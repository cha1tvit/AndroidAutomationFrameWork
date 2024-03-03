package helpers.drivers;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class WebDriverHelper {

    public void setImplicitWait(AndroidDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    /**
     * @param driver  AndroidDriver - instance of driver
     * @param element WebElement - element to wait for
     * @param seconds Integer waiting interval
     */
    public void waitForElementDisplayed(AndroidDriver driver, WebElement element, int seconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(d -> element.isDisplayed());
    }

    /**
     * @param driver  AndroidDriver - instance of driver
     * @param element WebElement - element to wait for
     * @param seconds Integer waiting interval
     */
    public void waitForElementHidden(AndroidDriver driver, WebElement element, int seconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(d -> !element.isDisplayed());
    }

    /**
     * @param driver  AndroidDriver - instance of driver
     * @param element WebElement - element to wait for
     * @param seconds Integer waiting interval
     */
    public void awaitUntilElementBecomeVisible(AndroidDriver driver, WebElement element, int seconds) {
        Wait<WebDriver> wait =
                new FluentWait(driver)
                        .withTimeout(Duration.ofSeconds(seconds))
                        .pollingEvery(Duration.ofMillis(250))
                        .ignoring(ElementNotInteractableException.class);
        wait.until(d -> element.isDisplayed());
    }

    public void awaitUntilElementBecomeVisible(AndroidDriver driver, By locator, int seconds) {
        Wait<WebDriver> wait =
                new FluentWait(driver)
                        .withTimeout(Duration.ofSeconds(seconds))
                        .pollingEvery(Duration.ofMillis(250))
                        .ignoring(ElementNotInteractableException.class);
        wait.until(d -> driver.findElement(locator).isDisplayed());
    }

    public void awaitUntilElementBecomeVisible(AndroidDriver driver, By locator) {
        awaitUntilElementBecomeVisible(driver, locator, 3);
    }

    /**
     * @param driver  AndroidDriver - instance of driver
     * @param element WebElement - element to wait for
     * @param seconds Integer waiting interval
     */
    public void awaitUntilElementBecomeHidden(AndroidDriver driver, WebElement element, int seconds) {
        try {
            Wait<WebDriver> wait =
                    new FluentWait(driver)
                            .withTimeout(Duration.ofSeconds(seconds))
                            .pollingEvery(Duration.ofMillis(250))
                            .ignoring(ElementNotInteractableException.class);
            wait.until(d -> !element.isDisplayed());
        } catch (StaleElementReferenceException ex) {
            log.info("Element is not linked to the same object in DOM anymore - %s", ex);
        }
    }

    public void awaitUntilElementBecomeHidden(AndroidDriver driver, WebElement element) {
        this.awaitUntilElementBecomeHidden(driver, element, 5);
    }

    public boolean isElementVisible(AndroidDriver driver, By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
