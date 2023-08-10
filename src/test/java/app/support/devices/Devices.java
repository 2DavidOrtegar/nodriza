package app.support.devices;

import app.support.loadproperties.LoadProperty;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Devices {
    private static DesiredCapabilities capabilities;
    public static final String USERNAME = "davidortega_fRZrsF";
    public static final String AUTOMATE_KEY = "7oKYxXzQ2BjPVsQpMSkH";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static ThreadLocal<AppiumDriver> mDriver = new ThreadLocal<>();

    public static void iphone12Pro() throws InterruptedException, MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("platformVersion", "16");
        capabilities.setCapability("deviceName", "iPhone 12 Pro");
        capabilities.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        //capabilities.setCapability("browserstack.user", USERNAME);
        //capabilities.setCapability("browserstack.key", AUTOMATE_KEY);

        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);

    }
    public static void iphone12() throws InterruptedException, MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "14");
        capabilities.setCapability("device", "iPhone 12");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");



        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);

    }
    public static void iphoneX() throws InterruptedException, MalformedURLException {
        capabilities = new DesiredCapabilities();
        DesiredCapabilities caps = new DesiredCapabilities();
        capabilities.setCapability("os_version", "11");
        capabilities.setCapability("device", "iPhone X");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");



        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);

    }
    public static void iphone11() throws InterruptedException, MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "14");
        capabilities.setCapability("device", "iPhone 11");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");



        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);

    }
    public static void iphone11Pro() throws InterruptedException, MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "13");
        capabilities.setCapability("device", "iPhone 11 Pro");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");



        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);

    }

    public static void samsungGalaxyS22() throws MalformedURLException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S22");
        capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);
    }
    public static void samsungGalaxyS21() throws MalformedURLException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "12.0");
        capabilities.setCapability("device", "Samsung Galaxy S21");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);
    }
    public static void samsungGalaxyS23() throws MalformedURLException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "13.0");
        capabilities.setCapability("device", "Samsung Galaxy S23");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);
    }
    public static void samsungGalaxyS20() throws MalformedURLException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "10.0");
        capabilities.setCapability("device", "Samsung Galaxy S20");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);
    }
    public static void samsungGalaxyNote8() throws MalformedURLException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "7.1");
        capabilities.setCapability("device", "Samsung Galaxy Note 8");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");


        mDriver.set(new AppiumDriver(new URL(URL), capabilities));
        Thread.sleep(4000);
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
       //samsungGalaxyS22();
      //iphone12Pro();
    //  huaweiP30();
    }
}
