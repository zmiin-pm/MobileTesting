package Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SupportPage extends BasePage {

    @FindBy(className = "android.widget.TextView")
    MobileElement categoryName;

    public boolean checkCategoryName() {
        return categoryName.getText().contains("связь");
    }
}
