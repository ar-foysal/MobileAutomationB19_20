package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class RunGeneralStoreAPK {

    @Test
    public void runApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "local");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("appPackage","com.androidsample.generalstore");
        cap.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://172.20.10.5:4723/"), cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TEST TEXT");
        Thread.sleep(5000);
    }
}
