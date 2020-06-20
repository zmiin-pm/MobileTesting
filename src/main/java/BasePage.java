import Driver.DriverFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(
                DriverFactory.getDriver()), this);
    }
}
