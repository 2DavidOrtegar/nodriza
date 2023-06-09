package app.support.browsers;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import app.com.hook.Hoks;
import app.support.loadproperties.LoadProperty;

import java.net.URL;

public class Browser {

    public static final String USERNAME = LoadProperty.BROWSERSTACK.getProperty("browserstack_name");
    public static final String AUTOMATE_KEY = LoadProperty.BROWSERSTACK.getProperty("browserstack_pass");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static String url;


    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static ChromeDriver localChrome() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    LoadProperty.BROWSER.getProperty("path_chrome"));
            System.setProperty("webdriver.chrome.silentOutput", "true");
            /**
             * Lineas 36 y 37 fix error chromedriver por actualización de chrome >=11
             */
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");

            driver.set(new ChromeDriver(chromeOptions));
            driver.get().manage().window().setSize(new Dimension(1920, 1080));
            driver.get().get(url);
            waitThread();
        } catch (Exception e) {
            System.out.println("Fallo ChromeDriver. " + e.getCause());
        }
        return (ChromeDriver) driver.get();
    }

    public static SafariDriver localSafari() {
        try {
            driver.set(new SafariDriver());
            driver.get().manage().window().setSize(new Dimension(1920, 1080));

            driver.get().get(LoadProperty.URLs.getProperty("gasco_pago_en_linea"));
            waitThread();
        } catch (Exception e) {
            System.out.println("Fallo SafariDriver. " + e.getCause());
        }
        return (SafariDriver) driver.get();
    }

    public static RemoteWebDriver latestChrome() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Sistema operativo y su version
        caps.setCapability("os", LoadProperty.OS.getProperty("os"));
        caps.setCapability("os_version", LoadProperty.OS.getProperty("os_version_10"));
        caps.setCapability("browserstack.idleTimeout", "300");
        //Navegador y su version
        caps.setCapability("browser", LoadProperty.BROWSER.getProperty("browser_chrome"));
        caps.setCapability("browser_version", LoadProperty.BROWSER.getProperty("browser_version_latest"));

        caps.setCapability("resolution", LoadProperty.BROWSER.getProperty("resolution"));

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
        driver.set(new RemoteWebDriver(new URL(URL), caps));
        driver.get().manage().window().maximize();
        driver.get().get(url);
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

    public static RemoteWebDriver getDriver() {
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
