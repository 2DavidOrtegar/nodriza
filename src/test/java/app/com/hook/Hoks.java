package app.com.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;

import java.util.HashMap;

public class Hoks {
    WebDriver webDriver;

    private static HashMap<Integer, String> SCENARIOS;
    private static ThreadLocal<String> NAMESCENARIO = new ThreadLocal<>();
    public static ThreadLocal<String> NAMEs = new ThreadLocal<>();


    public Hoks() {
        if (SCENARIOS == null)
            SCENARIOS = new HashMap<Integer, String>();
    }

    @Before
    public void beforeHook(Scenario scenario) {
        LoadProperty.runProperties();
        addScenario(scenario.getName());
        NAMESCENARIO.set(scenario.getName());
        NAMEs.set(NAMESCENARIO.get());
    }

    private void addScenario(String scenario) {
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        SCENARIOS.put(threadID, scenario);
    }

    @Then("^open Local Chrome$")
    public void openLocalChromeBrowser() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        webDriver = Browser.localChrome();
    }

    @Given("open Local Safari")
    public void openLocalSafariBrowser() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        webDriver = Browser.localSafari();
    }

    @Given("open BrowserStack Chrome")
    public void openBrowserStackChromeBrowser() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        webDriver = Browser.latestChrome();
    }

    @Given("^Mi Campania$")
    public void setUrlMiCampania() throws Exception {
        Browser.setUrl("gasco_campania");
    }

    @Given("^Registrar Numero$")
    public void setUrlRegisterPhoneNumber() throws Exception {
        Browser.setUrl("gasco_registro");
    }

    @Given("^Quemar Cupon$")
    public void setUrlBurnCoupon() throws Exception {
        Browser.setUrl("gasco_quemarcupon");
    }

    @After
    public void quitDriver() {
        if (Browser.getDriver() != null) {
            Browser.quitDriver();
        } else {
            System.out.println("Navegador sin abrir");
        }
    }
}
