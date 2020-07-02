package Driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public static AndroidDriver setDriver(DeviceName device) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (device) {
            case EMULATOR: {
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                break;
            }
            case PHONE: {
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "INPUT PHONE NAME");
                break;
            }
        }
        capabilities.setCapability(MobileCapabilityType.APP, new File("app/rozetka_4.5.1.apk").getAbsolutePath());
        capabilities.setCapability("appPackage", "ua.com.rozetka.shop");
        capabilities.setCapability("appActivity", "ua.com.rozetka.shop.ui.InitActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }
}
