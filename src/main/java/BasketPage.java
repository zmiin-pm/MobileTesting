import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/item_cart_offer_cl_offer")
    List<MobileElement> addedItems;

    public int countAddedItems() {
        return addedItems.size();
    }
}
