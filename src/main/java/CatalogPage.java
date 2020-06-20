import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {

    @FindBy(id = "ua.com.rozetka.shop:id/toolbar")
    MobileElement toolBar;

    public boolean hasToolBarText() {
        String title = toolBar
                .findElement(By.className("android.widget.TextView"))
                .getText().trim();
        System.out.println("Каталог товаров");
        System.out.println(title);
        return title.contains("Каталог товаров");
    }

}
