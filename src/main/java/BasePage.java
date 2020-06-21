import Driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    MobileElement burgerMenu;

    @FindBy(className = "android.widget.RelativeLayout")
    List<MobileElement> mainMenuItems;

    protected BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(
                DriverFactory.getDriver()), this);
    }

    public MainPage backToMainPage() {
        burgerMenu.click();
        mainMenuItems.get(0).click();
        return new MainPage();
    }

}
