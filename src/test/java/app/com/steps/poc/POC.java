package app.com.steps.poc;

import app.pages.ppoc.Login;
import io.cucumber.java.en.Then;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
public class POC {

    Login login;
    @Then("aprobado")
    public void aprobado()throws URISyntaxException, IOException{
        Report.PASSED("Paso de ensayo - aprobado");
        //Objects.requireNonNull(Devices.getDriver()).quit();
    }

    @Then("reprobado")
    public void reprobado()throws URISyntaxException, IOException{
        Report.FAILED("Paso de ensayo - Fallido");
    }

    @Then("iniciar sesion")
    public void iniciarSesion() throws URISyntaxException, IOException {
        login = new Login();
        login.iniciarSession();
    }

    @Then("ingreso de rut")
    public void ingresoDeRut() throws URISyntaxException, IOException {
        login = new Login();
        login.ingresoDeRut();
    }


}
