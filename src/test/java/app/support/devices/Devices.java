package app.support.devices;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import app.com.hook.Hoks;
import app.support.loadproperties.LoadProperty;

import java.net.URL;
import java.util.HashMap;

public class Devices {

    public static final String USERNAME = LoadProperty.BROWSERSTACK.getProperty("browserstack_name");
    public static final String AUTOMATE_KEY = LoadProperty.BROWSERSTACK.getProperty("browserstack_pass");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static String url;

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static RemoteWebDriver iPhone12Pro() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "16");
        caps.setCapability("deviceName", "iPhone 12 Pro");
        caps.setCapability("app", "bs://3dd555b755f7a255e57deeb3dc620e85dacaefca");

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
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }
    public static RemoteWebDriver iPhone12() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "14");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("app", "bs://3dd555b755f7a255e57deeb3dc620e85dacaefca");

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

        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }
    public static RemoteWebDriver iPhoneX() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        //Sistema operativo y su version
        caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "iPhone X");
        caps.setCapability("app", "bs://3dd555b755f7a255e57deeb3dc620e85dacaefca");


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
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver iPhone11Pro() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "iPhone 11 Pro");
        caps.setCapability("app", "bs://3dd555b755f7a255e57deeb3dc620e85dacaefca");

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
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }
    public static RemoteWebDriver iPhone11() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "iPhone 11");
        caps.setCapability("app", "bs://3dd555b755f7a255e57deeb3dc620e85dacaefca");

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
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }
    public static RemoteWebDriver samsungGalaxyS23() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Samsung Galaxy S23");
        caps.setCapability("app", "bs://95cbae4e589d1d4487792b19c423da5849574ce3");

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
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver samsungGalaxyS22() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "Samsung Galaxy S22");
        caps.setCapability("app", "bs://95cbae4e589d1d4487792b19c423da5849574ce3");

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
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver samsungGalaxyS21() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Samsung Galaxy S21");
        caps.setCapability("app", "bs://95cbae4e589d1d4487792b19c423da5849574ce3");

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
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver samsungGalaxyS20() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Samsung Galaxy S20");
        caps.setCapability("app", "bs://95cbae4e589d1d4487792b19c423da5849574ce3");

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
        driver.set(new AppiumDriver(new URL(URL), caps));
        waitThread();

        return driver.get();

    }

    public static RemoteWebDriver samsungGalaxyNote8() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("platformVersion", "7.1");
        caps.setCapability("deviceName", "Samsung Galaxy Note 8");
        caps.setCapability("app", "bs://95cbae4e589d1d4487792b19c423da5849574ce3");

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
