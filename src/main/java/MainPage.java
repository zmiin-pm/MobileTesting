import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/menu_item_header_ll_logo_rozetka")
    MobileElement logo;

    @FindBy(id = "ua.com.rozetka.shop:id/main_tv_to_catalog")
    MobileElement buttonCatalog;

    public CatalogPage getCatalog() {
        logo.click();           // to refresh main page (close auto menu)
        buttonCatalog.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CatalogPage();
    }
}
