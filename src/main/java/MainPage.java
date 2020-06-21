import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/menu_item_header_ll_logo_rozetka")
    MobileElement logo;

    @FindBy(id = "ua.com.rozetka.shop:id/main_tv_to_catalog")
    MobileElement buttonCatalog;

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
}
