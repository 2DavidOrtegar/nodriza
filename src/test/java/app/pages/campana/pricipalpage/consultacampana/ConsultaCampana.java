package app.pages.campana.pricipalpage.consultacampana;

import app.support.browsers.Browser;
import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

public class ConsultaCampana {

    @FindBy(xpath = "//li[contains(@class, 'navContainer ng-star-inserted')]")
    private List<WebElement> btnConsultaCampana;

    @FindBy(xpath = "//input[contains(@formcontrolname,'search')]")
    private WebElement inputNombreCampana;

    @FindBy(xpath = "//div[contains(@id, 'mat-select-value-1')]")
    private WebElement inputEstadoCampana;

    @FindBy(xpath = "//div[contains(@id, 'mat-select-value-3')]")
    private WebElement inputMesCampana;

    @FindBy(xpath = "//input[contains(@formcontrolname,'year')]")
    private WebElement inputAnoCampana;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement btnBuscar;


    public ConsultaCampana (){
        PageFactory.initElements(Browser.getDriver(), this);
    }

    WaitUtils wu;

    public void ingresoMenuConsultaCampana() throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            if (wu.waitForElementVisible(btnConsultaCampana.get(1))){
                btnConsultaCampana.get(1).click();
            }
            else {
                Report.PASSED("Se pudo hacer click en menu Consulta Campana" );
            }
        }
        catch (Exception e){
            Report.FAILED("No se pudo ingresar a seleccion de menu "+e.getMessage());
        }

    }

    public void validateElementsConsultaCampana() throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            int i = 0;
            if (wu.waitForElementVisible(inputNombreCampana)){
                i++;
            }
            else {
                Report.FAILED("No se visualiza el elemento "+inputNombreCampana.toString());
            }
            if (wu.waitForElementVisible(inputEstadoCampana)){
                i++;
            }
            else {
                Report.FAILED("No se visualiza el elemento "+inputEstadoCampana.toString());
            }
            if (wu.waitForElementVisible(inputMesCampana)){
                i++;
            }
            else {
                Report.FAILED("No se visualiza el elemento "+inputMesCampana.toString());
            }
            if (wu.waitForElementVisible(inputAnoCampana)){
                i++;
            }
            else {
                Report.FAILED("No se visualiza el elemento "+inputAnoCampana.toString());
            }
            if (wu.waitForElementVisible(btnBuscar)){
                i++;
            }
            else {
                Report.FAILED("No se visualiza el elemento "+btnBuscar.toString());
            }
            if (i == 5){
                Report.PASSED("Se visualizan todos los elementos en el menu Crear Campana");
            }
        }catch (Exception e){
            Report.FAILED("No se encontró el elemento "+btnConsultaCampana.toString());
        }
    }
    public void validateBuscarCampana(String NombreCamp) throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            if (wu.waitForElementVisible(inputNombreCampana)){
                inputNombreCampana.sendKeys(NombreCamp);
                btnBuscar.click();
                Thread.sleep(2000);
                WebElement nombreList = Browser.getDriver().findElement(By.xpath("//td[contains(@class,'mat-cell cdk-cell campaign')]"));
                if (nombreList.getText().contains(NombreCamp)){
                    Report.PASSED("Campana encontrada");
                }
                else {
                    Report.FAILED("No se encontro campana");
                }
            }
            else {
                Report.FAILED("No se encontro elemento Nombre Campana");
            }
        }catch (Exception e){
            Report.FAILED("No se pudo validar busqueda "+e.getMessage());
        }
    }
    public void validateCampanaVigente() throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            if (wu.waitForElementVisible(inputEstadoCampana)){
                inputEstadoCampana.click();
                Thread.sleep(500);
                List<WebElement> ListVigencia = Browser.getDriver().findElements(By.xpath("//span[contains(@class,'mat-option-text')]"));
                if (ListVigencia.get(3).getText().equals("Vigente")){
                    ListVigencia.get(3).click();
                    btnBuscar.click();
                    Thread.sleep(3000);
                    WebElement vigencia = Browser.getDriver().findElement(By.xpath("//td[contains(@class,'mat-cell cdk-cell cdk-column-status')]"));
                    if (vigencia.getText().equals("Vigente")){
                        Report.PASSED("Se encontraron campanas vigentes");
                    }
                    else {
                        Report.FAILED("No existen campanas vigentes");
                    }
                }
                else {
                    Report.FAILED("Lista de vigencias no pudo ser seleccionada");
                }
            }
            else {
                Report.FAILED("No se encontro elemento de Estado");
            }
        }catch (Exception e){
            Report.FAILED("No se pudo validar busqueda " + e.getMessage());
        }
    }
    public void validateOrdenarFechas() throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            List<WebElement> ListOrden = Browser.getDriver().findElements(By.xpath("//div[contains(@role,'button')]"));
            if (wu.waitForElementVisible(ListOrden.get(2))){
                ListOrden.get(2).click();
                Thread.sleep(2000);
                WebElement FlechaAsc = Browser.getDriver().findElement(By.xpath("//th[contains(@aria-sort,'ascending')]"));
                if (wu.waitForElementVisible(FlechaAsc)){
                    Report.PASSED("Las fechas se ordenaron de forma ascendente");
                }
                else {
                    Report.FAILED("No se pudieron ordenar fechas");
                }
            }
            else {
                Report.FAILED("No se pudo seleccionar lista de orden");
            }
        }catch (Exception e){
            Report.FAILED("No se pudo validar fechas "+e.getMessage());
        }
    }
    public void generateReport() throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            List<WebElement> ButtonGenerate = Browser.getDriver().findElements(By.xpath("//td[contains(@class,'mat-cell cdk-cell cdk-column-report mat-column-report')]"));
            if (wu.waitForElementVisible(ButtonGenerate.get(0))){
                ButtonGenerate.get(0).click();
                Thread.sleep(4000);
            }
            else {
                Report.FAILED("No se encontro boton generar");
            }

        }catch (Exception e){
            Report.FAILED("No se pudo iniciar el proceso de descarga de reporte "+e.getMessage());
        }
    }
    public void downloadReport() throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            List<WebElement> ButtonDownload = Browser.getDriver().findElements(By.xpath("//td[contains(@class,'mat-cell cdk-cell cdk-column-download')]"));
            if (wu.waitForElementVisible(ButtonDownload.get(0))){
                ButtonDownload.get(0).click();
                Thread.sleep(2000);
                Report.PASSED("Comenzo el proceso de descarga");
            }
            else {
                Report.FAILED("No se encontro boton descargar Excel");
            }
        }catch (Exception e){
            Report.FAILED("No se pudo iniciar con validacion de descarga "+e.getMessage());
        }
    }


}
