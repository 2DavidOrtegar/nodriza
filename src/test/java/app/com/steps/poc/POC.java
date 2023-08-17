package app.com.steps.poc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;

public class POC {

    @Then("aprobado")
    public void aprobado()throws URISyntaxException, IOException{
        Report.PASSED("Paso de ensayo - aprobado");
    }

    @Then("reprobado")
    public void reprobado()throws URISyntaxException, IOException{
        Report.FAILED("Paso de ensayo - Fallido");
    }
}
