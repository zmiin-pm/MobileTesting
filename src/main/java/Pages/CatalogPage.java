package Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class CatalogPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/toolbar")
    MobileElement toolBar;

    @FindBy(id = "ua.com.rozetka.shop:id/item_sections_tv_title")
    List<MobileElement> categoriesBtnsList;

    public boolean hasToolBarText() {
        String title = toolBar
                .findElement(By.className("android.widget.TextView"))
                .getText().trim();
        return title.contains("Каталог товаров");
    }

    public SportCategoryPage getCategory(String categoryTitle) {
        List<MobileElement> categories = categoriesBtnsList;
        Optional<MobileElement> btn = categories.stream()
                .filter(mobileElement -> mobileElement
                        .getText()
                        .contains(categoryTitle)).findFirst();
        btn.get().click();
        return new SportCategoryPage();
    }

}
