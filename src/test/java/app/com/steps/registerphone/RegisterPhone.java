package app.com.steps.registerphone;

import app.pages.campana.login.LoginCampana;
import app.pages.registerphone.principalpage.register.Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URISyntaxException;

public class RegisterPhone {
    @Then("Validar ingreso de Numero Telefonico {word}")
    public void validarIngresoNumeroTelefonico( String phone) throws URISyntaxException, IOException {
        Register r = new Register();
        r.registerPhone(phone);
    }

    @When("Validar elementos Registro Numero")
    public void validarElementosRegistroNumero() throws URISyntaxException, IOException {
        Register r = new Register();
        r.validateElements();
    }

    @And("Seleccionar opcion de entrega")
    public void seleccionarOpcionDeEntrega() throws InterruptedException, URISyntaxException, IOException {
        Register r = new Register();
        r.selectDeliveryOption();
    }

    @And("Seleccionar descuentos para despacho")
    public void seleccionarDescuentosParaDespacho() throws InterruptedException, URISyntaxException, IOException {
        Register r = new Register();
        r.selectShippingDiscounts();
    }

    @And("Generar Cupon")
    public void generarCupon() throws URISyntaxException, IOException {
        Register r = new Register();
        r.generateCoupon();
    }
}
