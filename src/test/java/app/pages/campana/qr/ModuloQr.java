package app.pages.campana.qr;

import app.support.browsers.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ThreadLocalRandom;

public class ModuloQr {//*[@id="xpath-content"]
    @FindBy(xpath = "/html/body/app-root/div/app-home/div/sidebar/div/ul/li[4]/span")
    private WebElement linkDescuentos;

    @FindBy(xpath = "/html/body/app-root/div/app-home/div/sidebar/div/ul/li[5]/span")
    private WebElement linkQr;

    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div/app-qr-module/div[3]/div[1]/form/div/div/div/mat-form-field/div/div[1]/div[3]/input")
    private WebElement textboxBuscador;

    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div/app-qr-module/div[3]/div[1]/form/div/div/div/button")
    private WebElement botonBuscar;

    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div/app-qr-module/div[3]/div[2]/div[2]/table/tbody/tr/td[3]/button")
    private WebElement generarQr;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/button[1]")
    private WebElement btnDescargar;

    public ModuloQr() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void ingresoModuloQr() throws URISyntaxException, IOException, InterruptedException {

        System.out.println("Click en link Descuentos...");

        try {
            linkDescuentos.click();
        } catch (Exception e) {
            Report.FAILED("No se visualiza el elemento " + linkDescuentos.toString());
        }

        System.out.println("Click en QR-Distribuidor...");

        try {
            linkQr.click();
        } catch (Exception e) {
            Report.FAILED("No se visualiza el elemento " + linkQr.toString());
        }

    }

    public void ingresarSapClickBuscar() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Ingresando codigo SAP...");

        String[] sapList = {"12325682", "12523890", "12070427"};
        int indice =  ThreadLocalRandom.current().nextInt(0, sapList.length);
        String sap = sapList[indice];
        /**
         * Ingresando SAP en buscador
         */
        try {
            textboxBuscador.sendKeys(sap);
        } catch (Exception e) {
            Report.FAILED("No se visualiza el elemento " + textboxBuscador.toString());
        }

        /**
         * Click en boton Buscar
         */
        System.out.println("Click en Buscar...");
        try {
            botonBuscar.click();
        } catch (Exception e) {
            Report.FAILED("No se visualiza el elemento " + botonBuscar.toString());
        }

    }

    public void clickBtnGenerarCodQr() throws URISyntaxException, IOException, InterruptedException {
        /**
         * Click en boton generar codigo QR
         */
        System.out.println("Click boton generar codigo QR...");
        Thread.sleep(3000);
        try {
            generarQr.click();
        } catch (Exception e) {
            Report.FAILED("No se visualiza el elemento " + generarQr.toString());
        }
        Thread.sleep(2000);
    }

    public void clickBtnDescargar() throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Click en boton Descargar...");
        Thread.sleep(2000);
        try {
            btnDescargar.click();
        } catch (Exception e) {
            Report.FAILED("No se visualiza el elemento " + generarQr.toString());
        }
    }
}
