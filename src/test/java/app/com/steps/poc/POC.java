package app.com.steps.poc;

import app.pages.ppoc.Login;
import app.support.devices.Devices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class POC {

    Login login;
    @Then("aprobado")
    public void aprobado()throws URISyntaxException, IOException{
        Report.PASSED("Paso de ensayo - aprobado");
        Objects.requireNonNull(Devices.getDriver()).quit();
    }

    @Then("reprobado")
    public void reprobado()throws URISyntaxException, IOException{
        Report.FAILED("Paso de ensayo - Fallido");
    }

    @Then("iniciar sesion")
    public void iniciarSesion(){
        login = new Login();
        login.iniciarSession();
    }
}
