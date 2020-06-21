import Driver.DeviceName;
import Driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class RozetkaTests {

    public static AndroidDriver driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DriverFactory.setDriver(DeviceName.EMULATOR);
        new MainPage().refresh();
    }

    @AfterTest
    public void afterTest() {
        DriverFactory.quitDriver();
    }

    @Test(priority = 1)
    public void pushCatalogBtnAndCheckText() {
        Assert.assertTrue(new MainPage()
                .getCatalog()
                .hasToolBarText());
    }

    @AfterMethod
    public void afterMethod() {
        new BasePage().backToMainPage();
    }

    @Test(priority = 2)
    public void addItemsToBasketAndCheckNumber() {
        BasketPage basket = new MainPage()
                .getCatalog()
                .getCategory("Спорт")
                .getProductSection("Лодки")
                .getItemSubSection("Каяки")
                .addItemToBasket(3)
                .getBasketPage();
        Assert.assertEquals(basket.countAddedItems(), 3);
    }
}

