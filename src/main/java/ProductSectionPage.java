import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class ProductSectionPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/item_section_sections_tv_title")
    List<MobileElement> itemSubSectionList;

    public ItemSubSectionPage getItemSubSection(String items) {
        Optional<MobileElement> chosenBtn = itemSubSectionList.stream()
                .filter(mobileElement -> mobileElement
                        .getText()
                        .contains(items))
                .findFirst();
        chosenBtn.get().click();
        return new ItemSubSectionPage();

    }

}
