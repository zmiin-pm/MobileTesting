import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemSubSectionPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/section_offer_cv_cart")
    List<MobileElement> itemAddToBasketBtnsList;

    @FindBy(id = "ua.com.rozetka.shop:id/action_cart")
    MobileElement basketBtn;

    public ItemSubSectionPage addItemToBasket(int numberOfItems) {
        for (int i = numberOfItems - 1; i >= 0; i--) {
            itemAddToBasketBtnsList.get(i).click();
        }
        return this;
    }

    public BasketPage getBasketPage() {
        basketBtn.click();
        return new BasketPage();
    }
}
