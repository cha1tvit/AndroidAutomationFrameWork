package steps;

import helpers.drivers.WebDriverHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

@Data
public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverHelper webDriverHelper = new WebDriverHelper();

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
}
