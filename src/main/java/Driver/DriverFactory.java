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
        switch (device) {
            case EMULATOR: {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                capabilities.setCapability(MobileCapabilityType.APP, new File("app/rozetka_4.5.1.apk").getAbsolutePath());
                capabilities.setCapability("appPackage", "ua.com.rozetka.shop");
                capabilities.setCapability("appActivity", "ua.com.rozetka.shop.ui.InitActivity");
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
                return driver;
            }
            case PHONE: {
                return null;
            }
        }
        return null;
    }

    public static void quitDriver() {
        driver.quit();
    }
}
