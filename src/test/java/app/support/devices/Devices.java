package app.support.devices;

import app.support.loadproperties.LoadProperty;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Devices {
    private static DesiredCapabilities caps;
    public static final String USERNAME = "davidortega_fRZrsF";
    public static final String AUTOMATE_KEY = "7oKYxXzQ2BjPVsQpMSkH";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static ThreadLocal<AppiumDriver> mDriver = new ThreadLocal<>();

    public static void iphone12Pro() throws InterruptedException, MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "16");
        caps.setCapability("deviceName", "iPhone 12 Pro");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        //caps.setCapability("browserstack.user", USERNAME);
        //caps.setCapability("browserstack.key", AUTOMATE_KEY);

        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);

    }
    public static void iphone12() throws InterruptedException, MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");



        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);

    }
    public static void iphoneX() throws InterruptedException, MalformedURLException {
        caps = new DesiredCapabilities();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "iPhone X");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");



        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);

    }
    public static void iphone11() throws InterruptedException, MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "iPhone 11");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");



        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);

    }
    public static void iphone11Pro() throws InterruptedException, MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "iPhone 11 Pro");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");



        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);

    }

    public static void samsungGalaxyS22() throws MalformedURLException, InterruptedException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "Samsung Galaxy S22");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);
    }
    public static void samsungGalaxyS21() throws MalformedURLException, InterruptedException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Samsung Galaxy S21");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);
    }
    public static void samsungGalaxyS23() throws MalformedURLException, InterruptedException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Samsung Galaxy S23");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);
    }
    public static void samsungGalaxyS20() throws MalformedURLException, InterruptedException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Samsung Galaxy S20");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);
    }
    public static void samsungGalaxyNote8() throws MalformedURLException, InterruptedException {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "7.1");
        caps.setCapability("deviceName", "Samsung Galaxy Note 8");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), caps));
        Thread.sleep(4000);
    }

}
