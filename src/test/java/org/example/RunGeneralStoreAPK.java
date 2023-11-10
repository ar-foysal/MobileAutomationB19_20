package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RunGeneralStoreAPK {
    public AndroidDriver driver;

    @BeforeTest
    public void startApp() throws MalformedURLException {
        File f = new File("src/test/resources");
        File fs = new File(f, "General-Store.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "local");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("app", fs.getAbsolutePath());
//        cap.setCapability("appPackage","com.androidsample.generalstore");
//        cap.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void runApp(){
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Bangladesh\"));");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TEST TEXT");
    }
    @AfterTest
    public void removeApp(){
        driver.removeApp("com.androidsample.generalstore");
    }
}
