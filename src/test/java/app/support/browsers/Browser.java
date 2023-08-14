package app.support.browsers;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import app.com.hook.Hoks;
import app.support.loadproperties.LoadProperty;

import java.net.URL;

public class Browser {

    public static final String USERNAME = LoadProperty.BROWSERSTACK.getProperty("browserstack_name");
    public static final String AUTOMATE_KEY = LoadProperty.BROWSERSTACK.getProperty("browserstack_pass");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static String url;

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static RemoteWebDriver iPhone12Pro() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "16");
        caps.setCapability("deviceName", "iPhone 12 Pro");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }
    public static RemoteWebDriver iPhone12() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }
    public static RemoteWebDriver iPhoneX() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "iPhone X");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver iPhone11Pro() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "iPhone 11 Pro");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }
    public static RemoteWebDriver iPhone11() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "iPhone 11");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }
    public static RemoteWebDriver samsungGalaxyS23() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Samsung Galaxy S23");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver samsungGalaxyS22() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "Samsung Galaxy S22");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver samsungGalaxyS21() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Samsung Galaxy S21");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver samsungGalaxyS20() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Samsung Galaxy S20");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver samsungGalaxyNote8() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "7.1");
        caps.setCapability("deviceName", "Samsung Galaxy Note 8");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", LoadProperty.BUILD.getProperty("project"));
        caps.setCapability("name", Hoks.NAMEs.get());


        if (LoadProperty.BUILD.getProperty("name_task").equals("regressionLowTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_low")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionMiddleTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_middle")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else if (LoadProperty.BUILD.getProperty("name_task").equals("regressionVeryHighTag")) {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BUILD.getProperty("type_build_very_high")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        } else {
            caps.setCapability("build", LoadProperty.BUILD.getProperty("build")
                    + " " + LoadProperty.BUILD.getProperty("build_version")
                    + " " + LoadProperty.BROWSER.getProperty("browser_chrome")
                    + " " + LoadProperty.BROWSER.getProperty("browser_version_latest"));
        }


        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", LoadProperty.BROWSERSTACK.getProperty("browserstack_debug"));
        caps.setCapability("browserstack.console", LoadProperty.BROWSERSTACK.getProperty("browserstack_console"));
        caps.setCapability("browserstack.networkLogs", LoadProperty.BROWSERSTACK.getProperty("browserstack_networkLogs"));

        waitThread();
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

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
        return driver.get();
    }

    /**
     * Codigo para dar una tolerancia de tiempo entre test
     **/
    private static void waitThread() {
        try {
            double valor = Math.floor(Math.random() * 4000) + 1000;
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
        url = LoadProperty.URLs.getProperty("urls." + flag);
    }
}