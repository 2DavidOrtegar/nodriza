package app.com.steps.searchcampana;

import app.pages.campana.search.SearchCampana;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.URISyntaxException;

public class Search {

    @And("Validar elementos menu consultar campana")
    public void validarElementosConsutaCampana() throws URISyntaxException, IOException, InterruptedException {
        SearchCampana s = new SearchCampana();
        s.validateElementConsultaCampana();
    }

    @Then("Validar consulta de campana por nombre")
    public void validarConsultaDeCampana() throws URISyntaxException, IOException, InterruptedException {
        SearchCampana s = new SearchCampana();
        s.searchCampana();
    }
}
