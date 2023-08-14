package app.com.hook;

import app.support.browsers.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
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


    @Given("open Samsung")
    public void openSamsung() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.samsungGalaxyS22();
    }
    @Given("open Samsung note 8")
    public void openSamsungNote8() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.samsungGalaxyNote8();
    }
    @Given("open Samsung s20")
    public void openSamsungS20() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.samsungGalaxyS20();
    }
    @Given("open Samsung s21")
    public void openSamsungS21() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.samsungGalaxyS21();
    }
    @Given("open Samsung s23")
    public void openSamsungS23() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.samsungGalaxyS23();
    }

    @Given("open iphone")
    public void openIphone12Pro() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.iPhone12Pro();
    }
    @Given("open iphone X")
    public void openIphoneX() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.iPhoneX();
    }
    @Given("open iphone 12")
    public void openIphone12() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.iPhone12();
    }
    @Given("open iphone 11")
    public void openIphone11() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.iPhone11();
    }

    @Given("open iphone 11pro")
    public void openIphone11pro() throws Exception {
        System.out.println("Ejecutando: " + NAMEs.get());
        Browser.iPhone11Pro();
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
