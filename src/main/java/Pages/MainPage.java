package Pages;

import Driver.DriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/menu_item_header_ll_logo_rozetka")
    MobileElement logo;

    @FindBy(id = "ua.com.rozetka.shop:id/main_tv_to_catalog")
    MobileElement buttonCatalog;

    @FindBy(id = "ua.com.rozetka.shop:id/btn_contact_us")
    MobileElement supportButton;



    public MainPage refresh() {
        logo.click();           // to refresh main page (close auto menu)
        return this;
    }

    public CatalogPage getCatalog() {
        buttonCatalog.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CatalogPage();
    }

    public SupportPage getSupport(){
        DriverFactory.getDriver()
                .findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector())" +
                                ".scrollIntoView(text(\"СЛУЖБА ПОДДЕРЖКИ\"))")
                .click();
        return new SupportPage();
    }
}
