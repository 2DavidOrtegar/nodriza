package app.support.devices;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import app.com.hook.Hoks;
import app.support.loadproperties.LoadProperty;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Devices {

    public static final String USERNAME = LoadProperty.BROWSERSTACK.getProperty("browserstack_name");
    public static final String AUTOMATE_KEY = LoadProperty.BROWSERSTACK.getProperty("browserstack_pass");
    //Android
    public static final String ANDROID_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    //IOS
    public static final String IOS_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<IOSDriver> driveriOS = new ThreadLocal<>();

    public static void iPhone12Pro() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "16");
        caps.setCapability("deviceName", "iPhone 12 Pro");
        caps.setCapability("app", "bs://8c250bac2394c603af3e6cf68ce6106f4047cf8c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }

        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();
        driveriOS.set(new IOSDriver(new URL(IOS_URL), caps));

        driveriOS.get();

    }
    public static void iPhone12() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "14");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("app", "bs://8c250bac2394c603af3e6cf68ce6106f4047cf8c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }

        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();

        driveriOS.set(new IOSDriver(new URL(IOS_URL), caps));

        driveriOS.get();

    }
    public static void iPhoneXR() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        //Sistema operativo y su version
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "iPhone XR");

        //caps.setCapability("os_version", "12");
        //caps.setCapability("deviceName", "iPhone XR");
        caps.setCapability("app", "bs://8c250bac2394c603af3e6cf68ce6106f4047cf8c");


        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);

        waitThread();
        driveriOS.set(new IOSDriver(new URL(IOS_URL), caps));


        driveriOS.get();

    }
    public static void iPhone8() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        //Sistema operativo y su version
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "iPhone 8");
        caps.setCapability("app", "bs://8c250bac2394c603af3e6cf68ce6106f4047cf8c");


        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);

        waitThread();
        driveriOS.set(new IOSDriver(new URL(IOS_URL), caps));


        driveriOS.get();

    }
    public static void iPhone11Pro() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "iPhone 11 Pro");
        caps.setCapability("app", "bs://8c250bac2394c603af3e6cf68ce6106f4047cf8c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }





        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();
        driveriOS.set(new IOSDriver(new URL(IOS_URL), caps));


        driveriOS.get();

    }
    public static void iPhone11() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "iPhone 11");
        caps.setCapability("app", "bs://8c250bac2394c603af3e6cf68ce6106f4047cf8c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();
        driveriOS.set(new IOSDriver(new URL(IOS_URL), caps));

        driveriOS.get();

    }

    public static void samsungGalaxyS23() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Samsung Galaxy S23");
        caps.setCapability("app", "bs://083dfa6ae8ad06b4460d8e330e455c79bf060896");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();
        driver.set(new AndroidDriver(new URL(ANDROID_URL), caps));


        driver.get();

    }

    public static void samsungGalaxyS22() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "Samsung Galaxy S22");
        caps.setCapability("app", "bs://083dfa6ae8ad06b4460d8e330e455c79bf060896");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }





        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();
        driver.set(new AndroidDriver(new URL(ANDROID_URL), caps));


        driver.get();

    }

    public static void samsungGalaxyS21() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Samsung Galaxy S21");
        caps.setCapability("app", "bs://083dfa6ae8ad06b4460d8e330e455c79bf060896");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }





        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();
        driver.set(new AndroidDriver(new URL(ANDROID_URL), caps));


        driver.get();

    }

    public static void samsungGalaxyS20() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Samsung Galaxy S20");
        caps.setCapability("app", "bs://083dfa6ae8ad06b4460d8e330e455c79bf060896");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }





        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();
        driver.set(new AndroidDriver(new URL(ANDROID_URL), caps));


        driver.get();

    }

    public static void samsungGalaxyS23Ultra() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Samsung Galaxy S23 Ultra");
        caps.setCapability("app", "bs://083dfa6ae8ad06b4460d8e330e455c79bf060896");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("idleTimeout", "120");
        browserstackOptions.put("networkLogs", "true");

        caps.setCapability("bstack:options", browserstackOptions);
        waitThread();
        driver.set(new AndroidDriver(new URL(ANDROID_URL), caps));
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get();

    }

    public static void localDevice() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:device_name", "pixel_3a");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723");

        driver.set(new AndroidDriver(remoteUrl, desiredCapabilities));
    }

    public static void quitDriver() {
        try {
            /**Agregar logica para actualizar el estado de la prueba que acaba de finalizar**/
            driver.get().quit();
            /**Agregar logica para actualizar el estado de la prueba que acaba de finalizar**/
        } catch (Exception e) {
            System.out.println("Fallo el driver al momento de cerrarse. Causa: " + e.getCause());
        }
    }

    public static AppiumDriver getDriver() {

        if (driveriOS.get() != null){
            return driveriOS.get();
        }
        if (driver.get() != null){
            return driver.get();
        }
        return null;
    }

    /**
     * Codigo para dar una tolerancia de tiempo entre test
     **/
    private static void waitThread() {
        try {
            double valor = Math.floor(Math.random() * 500) + 1000;
            int a = (int) valor;
            System.out.println("Tiempo de espera entre ejeucion: " + a);
            Thread.sleep(a);
        } catch (Exception e) {
            System.out.println("No se logro agregar Tiempo de espera. Excepcion: " + e.getMessage());
        }
    }

    /**
     * Setear variable url
     * @param flag
     */
    public static void setUrl(String flag) {
        String url = LoadProperty.URLs.getProperty("urls." + flag);
    }


}
