package app.com.steps.burncoupon;

import app.pages.burncoupon.burn.Burn;
import app.pages.burncoupon.login.LoginBurn;
import app.pages.campana.login.LoginCampana;
import app.pages.registerphone.principalpage.register.Register;
import app.support.utils.Excel;
import app.support.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class BurnCoupon {

    ScenarioContext scenarioContext = new ScenarioContext();

    @Given("Cargar Datos")
    public void iSetScenarioContextValue() throws InterruptedException {
        System.out.println("Cargando Datos...");
        scenarioContext.setContext(ScenarioContext.Context.ID, "UNO");
        Thread.sleep(20000);
    }

    @Then("Validar elementos login Quemar Cupon")
    public void validarElementosLoginMiCampana() throws URISyntaxException, IOException, InterruptedException {
        LoginBurn b = new LoginBurn();
        b.validateElementsLogin();
    }

    @When("Validar elementos Quemar Cupon")
    public void validarElementosQuemarCupon() throws URISyntaxException, IOException {
        String sharedValue = scenarioContext.getContext(ScenarioContext.Context.ID).toString();
        Burn b = new Burn();
        b.validateElements();
    }

    @And("Validar ingreso login Quemar Cupon")
    public void validarIngresoLoginQuemarCupon() throws URISyntaxException, IOException {
        LoginBurn b = new LoginBurn();
        b.ingresoLogin();
    }

    @And("Validar quema de cupon")
    public void validarQuemaDeCupon() throws URISyntaxException, IOException {

        /**
         * Obtener datos de excel
         */
        Excel e = new Excel();
        ArrayList<ArrayList<String>> data = e.readExcel("\\cupon\\" + "12273780-Solugas_coupon_file.xlsx");
        /**
         * Remover cabeceras
         */
        data.remove(0);
        /**
         * Obtener fila al azar
         */
        int totalRows = data.size();
        int randomKey = (int) (Math.random() * totalRows);

        String phone = data.get(randomKey).get(0);
        String cupon = data.get(randomKey).get(1);

        Burn b = new Burn();
        b.validarQuemaCupon(phone, cupon);
    }
}
