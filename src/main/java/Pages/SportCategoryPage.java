package Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class SportCategoryPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/item_section_btn_section")
    List<MobileElement> productSectionBtnList;

    public ProductSectionPage getProductSection(String sectionTitle) {
        List<MobileElement> categories = productSectionBtnList;
        Optional<MobileElement> btn = categories.stream()
                .filter(mobileElement -> mobileElement
                        .getText()
                        .contains(sectionTitle)).findFirst();
        btn.get().click();
        return new ProductSectionPage();
    }

}

