import Driver.DeviceName;
import Driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class RozetkaTests {

    public static AndroidDriver driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DriverFactory.setDriver(DeviceName.EMULATOR);
    }

    @AfterTest
    public void afterTest() {
        DriverFactory.quitDriver();
    }

    @Test
    public void launchBrowser() {
        Assert.assertTrue(new MainPage()
                .getCatalog()
                .hasToolBarText());
    }
}

