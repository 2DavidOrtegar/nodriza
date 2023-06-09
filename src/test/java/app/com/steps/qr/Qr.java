package app.com.steps.qr;

import app.pages.campana.qr.ModuloQr;
import app.pages.campana.search.SearchCampana;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.URISyntaxException;

public class Qr {
    @Then("^Ingresar modulo QR$")
    public void ingresarModuloQr() throws URISyntaxException, IOException, InterruptedException {
        ModuloQr m = new ModuloQr();
        m.ingresoModuloQr();
    }

    @And("^Ingresar codigo SAP y Click en Buscar$")
    public void ingresarCodigoSapClickBuscar() throws URISyntaxException, IOException, InterruptedException {
        ModuloQr m = new ModuloQr();
        m.ingresarSapClickBuscar();
    }

    @And("^Click en boton generar codigo QR$")
    public void clickBotonGenerarCodigoQr() throws URISyntaxException, IOException, InterruptedException {
        ModuloQr m = new ModuloQr();
        m.clickBtnGenerarCodQr();
    }

    @And("^Click en boton Descargar$")
    public void clickBotonDescargar() throws InterruptedException, URISyntaxException, IOException {
        ModuloQr m = new ModuloQr();
        m.clickBtnDescargar();
    }

}
