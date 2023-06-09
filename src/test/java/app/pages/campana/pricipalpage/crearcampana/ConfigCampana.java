package app.pages.campana.pricipalpage.crearcampana;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import app.support.utils.Excel;
import app.support.utils.Paths;
import app.support.utils.SupportJsEvent;
import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import report.Report;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ConfigCampana {

    @FindBy(xpath = "//input[contains(@name, 'mat-radio-group-0')]")
    private WebElement radioTipoPromocion;

    @FindBy(xpath = "//input[contains(@name, 'mat-radio-group-1')]")
    private WebElement radioFinanciamiento;

    @FindBy(xpath = "//span[contains(@class, 'header-2')]")
    private WebElement spanDctoGasco;

    @FindBy(xpath = "//input[contains(@id, 'check-0-0-input')]")
    private WebElement checkCN2kg;

    @FindBy(xpath = "//input[contains(@id, 'discount-0')]")
    private WebElement inputDcto2kg;

    @FindBy(xpath = "//mat-select[contains(@id, 'restrictions-0')]")
    private WebElement inputRestricciones2kg;

    @FindBy(xpath = "//input[contains(@id, 'check-1-0-input')]")
    private WebElement checkCN5kg;

    @FindBy(xpath = "//input[contains(@id, 'check-1-1-input')]")
    private WebElement checkCS5kg;

    @FindBy(xpath = "//input[contains(@id, 'discount-1')]")
    private WebElement inputDcto5kg;

    @FindBy(xpath = "//mat-select[contains(@id, 'restrictions-1')]")
    private WebElement inputRestricciones5kg;

    @FindBy(xpath = "//input[contains(@id, 'check-2-0-input')]")
    private WebElement checkCN11kg;

    @FindBy(xpath = "//input[contains(@id, 'check-2-1-input')]")
    private WebElement checkCS11kg;

    @FindBy(xpath = "//input[contains(@id, 'discount-2')]")
    private WebElement inputDcto11kg;

    @FindBy(xpath = "//mat-select[contains(@id, 'restrictions-2')]")
    private WebElement inputRestricciones11kg;

    @FindBy(xpath = "//input[contains(@id, 'check-3-0-input')]")
    private WebElement checkCN15kg;

    @FindBy(xpath = "//input[contains(@id, 'check-3-1-input')]")
    private WebElement checkCS15kg;

    @FindBy(xpath = "//input[contains(@id, 'discount-3')]")
    private WebElement inputDcto15kg;

    @FindBy(xpath = "//mat-select[contains(@id, 'restrictions-3')]")
    private WebElement inputRestricciones15kg;

    @FindBy(xpath = "//input[contains(@id, 'check-4-0-input')]")
    private WebElement checkCN45kg;

    @FindBy(xpath = "//input[contains(@id, 'check-4-1-input')]")
    private WebElement checkCS45kg;

    @FindBy(xpath = "//input[contains(@id, 'discount-4')]")
    private WebElement inputDcto45kg;

    @FindBy(xpath = "//mat-select[contains(@id, 'restrictions-4')]")
    private WebElement inputRestricciones45kg;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-back mr-2')]")
    private WebElement btnVolver;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-primary-gasco')]")
    private WebElement btnContinuar;

    @FindBy(xpath = "//div[contains(@class,'title')]")
    private List<WebElement> txtStep2Titulo;


    @FindBy(xpath = "//h3[contains(@class,'title')]")
    private List<WebElement> txtTipoPromocion;

    @FindBy(xpath = "//h3[contains(@class,'title')]")
    private List<WebElement> txtFinanciamiento;

    @FindBy(xpath = "//span[contains(@class,'mat-radio-label-content')]")
    private List<WebElement> txtRadioTipoPromocion;

    @FindBy(xpath = "//span[contains(@class,'mat-radio-label-content')]")
    private List<WebElement> txtRadioFinanciamiento;

    @FindBy(xpath = "//span[contains(@class,'header')]")
    private List<WebElement> txtFormato;

    @FindBy(xpath = "//span[contains(@class,'header')]")
    private List<WebElement> txtRestricciones;

    @FindBy(xpath = "//span[contains(@class,'product-name')]")
    private List<WebElement> txtCilindro2Kg;

    @FindBy(xpath = "//span[contains(@class,'product-name')]")
    private List<WebElement> txtCilindro5Kg;

    @FindBy(xpath = "//span[contains(@class,'product-name')]")
    private List<WebElement> txtCilindro11Kg;

    @FindBy(xpath = "//span[contains(@class,'product-name')]")
    private List<WebElement> txtCilindro15Kg;

    @FindBy(xpath = "//span[contains(@class,'product-name')]")
    private List<WebElement> txtCilindro45Kg;

    @FindBy(xpath = "//div[contains(@class,'step-container')]")
    private WebElement contenedor;

    @FindBy(xpath = "//input[contains(@class,'checkbox')]")
    private List<WebElement> checkSelecDI;

    @FindBy(xpath = "//input[contains(@class,'textbox')]")
    private List<WebElement> inputDatosDI;

    @FindBy(xpath = "(//input[@id='distributor-name'])[2]")
    private WebElement inputDatosDIB;

    @FindBy(xpath = "//div[@class='btn-table'][contains(.,'Agregar')]")
    private WebElement botonAgregar;

    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div/app-campaign-creation/div/div[2]/div/mat-card/div[2]/configuration/div/app-voucher-relation/div/app-campaign-coupon/div/div[3]/div/app-campaign-coupon-table/table/tbody/tr/td[7]/app-campaign-coupon-info/div/img")

    private WebElement cuponIcon;

    @FindBy(id = "file")
    private WebElement fileClients;

    private int timeSleep = 1500;


    public ConfigCampana() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    WaitUtils wu;

    public void validateElementTipePromotion() throws URISyntaxException, IOException {
        boolean errorFlag = false;

        try {
            wu = new WaitUtils();
            int i = 0;
            if (!wu.waitForElementVisible(radioTipoPromocion)) {
                Report.FAILED("No se visualiza RadioButton Tipo de Promocion ");
                errorFlag = true;
            }

            if (!errorFlag) {
                Report.PASSED("Se visualiza RadioButton Tipo de Promocion");
            }
        } catch (Exception e) {
            Report.FAILED("No se puede validar elemento " + e.getMessage());
        }
    }

    public void validateElementTipeFinan() throws URISyntaxException, IOException {
        boolean errorFlag = false;

        try {
            wu = new WaitUtils();
            int i = 0;
            if (!wu.waitForElementVisible(radioFinanciamiento)) {
                Report.FAILED("No se visualiza RadioButton Financiamiento");
                errorFlag = true;
            }

            if (!errorFlag) {
                Report.PASSED("Se visualiza RadioButton Financiamiento");
            }
        } catch (Exception e) {
            Report.FAILED("No se puede validar elemento " + e.getMessage());
        }
    }

    public void validateElementsConfigCampana() throws URISyntaxException, IOException {

        boolean errorFlag = false;

        try {
            wu = new WaitUtils();

            System.out.println("Validando radio Promocion...");

            if (!wu.waitForElementVisible(radioTipoPromocion)) {
                Report.FAILED("No se visualiza el elemento " + radioTipoPromocion.toString());
                errorFlag = true;
            }

            System.out.println("Validando radio Financiamiento...");
            if (!wu.waitForElementVisible(radioFinanciamiento)) {
                Report.FAILED("No se visualiza el elemento " + radioFinanciamiento.toString());
                errorFlag = true;
            }

            System.out.println("Validando span descuento...");
            if (!wu.waitForElementVisible(spanDctoGasco)) {
                Report.FAILED("No se visualiza el elemento " + spanDctoGasco.toString());
                errorFlag = true;
            }

            System.out.println("Validando check C2CKg...");
            if (!wu.waitForElementVisible(checkCN2kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCN2kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input Dcto2k...");
            if (!wu.waitForElementVisible(inputDcto2kg)) {
                Report.FAILED("No se visualiza el elemento " + inputDcto2kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input restricciones2Kg...");
            if (!wu.waitForElementVisible(inputRestricciones2kg)) {
                Report.FAILED("No se visualiza el elemento " + inputRestricciones2kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando check CN5kg...");
            if (!wu.waitForElementVisible(checkCN5kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCN5kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando check CS5kg...");
            if (!wu.waitForElementVisible(checkCS5kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCS5kg.toString());
            }

            System.out.println("Validando input Dcto5kg...");
            if (!wu.waitForElementVisible(inputDcto5kg)) {
                Report.FAILED("No se visualiza el elemento " + inputDcto5kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input restricciones 5kg...");
            if (!wu.waitForElementVisible(inputRestricciones5kg)) {
                Report.FAILED("No se visualiza el elemento " + inputRestricciones5kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando check CN11kg...");
            if (!wu.waitForElementVisible(checkCN11kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCN11kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando check CS11kg...");
            if (!wu.waitForElementVisible(checkCS11kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCS11kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input Dcto11kg...");
            if (!wu.waitForElementVisible(inputDcto11kg)) {
                Report.FAILED("No se visualiza el elemento " + inputDcto11kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input restricciones11kg...");
            if (!wu.waitForElementVisible(inputRestricciones11kg)) {
                Report.FAILED("No se visualiza el elemento " + inputRestricciones11kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando check CN15kg...");
            if (!wu.waitForElementVisible(checkCN15kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCN15kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando check CS15kg...");
            if (!wu.waitForElementVisible(checkCS15kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCS15kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input dcto 15Kg...");
            if (!wu.waitForElementVisible(inputDcto15kg)) {
                Report.FAILED("No se visualiza el elemento " + inputDcto15kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input restricciones 15 kg...");
            if (!wu.waitForElementVisible(inputRestricciones15kg)) {
                Report.FAILED("No se visualiza el elemento " + inputRestricciones15kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando checkCN45Kg restricciones 15 kg...");
            if (!wu.waitForElementVisible(checkCN45kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCN45kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando check CS45Kg...");
            if (!wu.waitForElementVisible(checkCS45kg)) {
                Report.FAILED("No se visualiza el elemento " + checkCS45kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input Dcto45kg...");
            if (!wu.waitForElementVisible(inputDcto45kg)) {
                Report.FAILED("No se visualiza el elemento " + inputDcto45kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input Restricciones45kg...");
            if (!wu.waitForElementVisible(inputRestricciones45kg)) {
                Report.FAILED("No se visualiza el elemento " + inputRestricciones45kg.toString());
                errorFlag = true;
            }

            System.out.println("Validando input boton volver...");
            if (!wu.waitForElementVisible(btnVolver)) {
                Report.FAILED("No se visualiza el elemento " + btnVolver.toString());
                errorFlag = true;
            }

            System.out.println("Validando input Restricciones45kg...");
            if (!wu.waitForElementVisible(btnContinuar)) {
                Report.FAILED("No se visualiza el elemento " + btnContinuar.toString());
                errorFlag = true;
            }

            if (!errorFlag) {
                Report.PASSED("Se visualizan todos los elementos en el menu Configurar Campana");
            }

        } catch (Exception e) {
            Report.FAILED("No se puede validar elementos ");
        }
    }

    public void configFormatDesc(int kilo, String format, String desc) throws URISyntaxException, IOException, InterruptedException {
        try {
            wu = new WaitUtils();
            switch (kilo) {
                case 2:
                    //2 kilos no tiene formato se utiliza la opcion CN por default
                    checkCN2kg.click();
                    inputDcto2kg.sendKeys(desc);
                    break;
                case 5:
                    if (format.toUpperCase().equals("CN")) {
                        SupportJsEvent.clickElement(checkCN5kg);
                        inputDcto5kg.sendKeys(desc);
                    } else if (format.toUpperCase().equals("CS")) {
                        SupportJsEvent.clickElement(checkCS5kg);
                        inputDcto5kg.sendKeys(desc);
                    }
                    break;
                case 11:
                    if (format.toUpperCase().equals("CN")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCN11kg);
                        inputDcto11kg.sendKeys(desc);
                    } else if (format.toUpperCase().equals("CS")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCS11kg);
                        inputDcto11kg.sendKeys(desc);
                    }
                    break;
                case 15:
                    if (format.toUpperCase().equals("CN")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCN15kg);
                        inputDcto15kg.sendKeys(desc);
                    } else if (format.toUpperCase().equals("CS")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCS15kg);
                        inputDcto15kg.sendKeys(desc);
                    }
                    break;
                case 45:
                    if (format.toUpperCase().equals("CN")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCN45kg);
                        inputDcto45kg.sendKeys(desc);
                    } else if (format.toUpperCase().equals("CS")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCS45kg);
                        inputDcto45kg.sendKeys(desc);
                    }
                    break;
                default:
                    Report.FAILED("Seleccione las opciones correctas. CLASS: ConfigCampana. ");
            }

        } catch (Exception e) {
            Report.FAILED("Fallo al configurar la campana. " + e.getMessage());
        }
    }

    /**
     * SE COMENTO LA CONFIGURACION DE FORMATO Y DESCUENTO PARA SEPARARLO DE LA RESTRICCION
     **/
    public void configurationFormatDescRestrictions(int kilo, String format, String desc) throws URISyntaxException, IOException, InterruptedException {
        try {
            wu = new WaitUtils();
            switch (kilo) {
                case 2:
                    //2 kilos no tiene formato se utiliza la opcoon CN por default
                    checkCN2kg.click();
                    break;
                case 5:
                    if (format.toUpperCase().equals("CN")) {
                        SupportJsEvent.clickElement(checkCN5kg);
                        completeForm(desc, kilo);
                    } else if (format.toUpperCase().equals("CS")) {
                        SupportJsEvent.clickElement(checkCS5kg);
                        completeForm(desc, kilo);
                    }
                    break;
                case 11:
                    if (format.toUpperCase().equals("CN")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCN11kg);
                        completeForm(desc, kilo);
                    } else if (format.toUpperCase().equals("CS")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCS11kg);
                        completeForm(desc, kilo);
                    }
                    break;
                case 15:
                    if (format.toUpperCase().equals("CN")) {
                        checkCN15kg.click();
                    } else if (format.toUpperCase().equals("CS")) {
                        checkCS15kg.click();
                    }
                    break;
                case 45:
                    if (format.toUpperCase().equals("CN")) {
                        checkCN45kg.click();
                    } else if (format.toUpperCase().equals("CS")) {
                        checkCS45kg.click();
                    }
                    break;
                default:
                    Report.FAILED("Seleccione las opciones correctas. CLASS: ConfigCampana. ");
            }

        } catch (Exception e) {
            Report.FAILED("Fallo al configurar la campana. " + e.getMessage());
        }
    }

    public void ContinuarCreacion() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");


        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView();", btnContinuar);
        Thread.sleep(1500);
        try {
            wu = new WaitUtils();
            System.out.println("Click en boton continuar...");
            btnContinuar.click();
        } catch (Exception e) {
            Report.FAILED("Fallo al intentar continuar: " + e.getMessage());
        }

    }

    public void clickCampoDistribuidor() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");
        Thread.sleep(1000);
        try {
            /**
             * Ingresar nombre de distribuidor
             */
            inputDatosDI.get(0).sendKeys("Solugas");
            Thread.sleep(1500);
        } catch (Exception e) {
            Report.FAILED("Fallo al realizar click en campo distribuidor! " + e.getMessage());
        }

    }

    public void validacionIngresoNombreFantasia() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");
        Thread.sleep(1000);
        try {
            /**
             * Ingresar nombre de distribuidor
             */
            String nombreFantasia = "01234567890123456789012345678901234567890123456789";
            inputDatosDI.get(1).sendKeys(nombreFantasia);
            Thread.sleep(1500);
        } catch (Exception e) {
            Report.FAILED("Fallo al ingresar nombre fantasia: " + e.getMessage());
        }

    }

    public void validacionIngresoNombreFantasiaCaracteresEspeciales() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");
        Thread.sleep(1000);
        try {
            /**
             * Ingresar nombre de distribuidor
             */
            inputDatosDI.get(1).sendKeys("/*#$%");
            inputDatosDI.get(1).sendKeys("&");

            String valor = inputDatosDI.get(1).getAttribute("value").trim();
            System.out.println("Valor es: " + valor);
            if (valor.indexOf("&") >= 0) {
                Report.PASSED("Nombre Fantasia: Permite ingresar caracter especial '&' OK");
            } else if (valor.equals("")) {
                Report.FAILED("Nombre Fantasia: No permite ingresar caracteres especiales");
            } else {
                Report.FAILED("Nombre Fantasia: Permite ingresar caracteres especiales");
            }

        } catch (Exception e) {
            Report.FAILED("Fallo al ingresar caracteres especiales en nombre fantasia: " + e.getMessage());
        }

    }

    public void validacionIngresoNumeroCupones() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");
        Thread.sleep(1000);
        wu = new WaitUtils();

        String numberOfCoupons = String.valueOf((int)(Math.random() * 10 + 1));//del 1 al 10
        System.out.println("Ingresando cantidad de cupones " + numberOfCoupons);

        inputDatosDI.get(2).click();
        inputDatosDI.get(2).sendKeys("ABCDE" + numberOfCoupons);

        try {

            String valor = inputDatosDI.get(2).getAttribute("value").trim();

            if (wu.isNumeric(valor)) {
                Report.PASSED("Numero Cupones: Permite ingresar solo numeros OK");
            } else if (valor.equals("")) {
                Report.FAILED("Numero Cupones: No permite ingresar numeros");
            } else {
                Report.FAILED("Numero Cupones: Permite ingresar todo tipo de caracteres");
            }

        } catch (Exception e) {
            Report.FAILED("Fallo al ingresar cantidad de cupones: " + e.getMessage());
        }


    }

    public void subirArchivoCliente() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");
        Thread.sleep(1000);
        try {
            System.out.println("Cargar archivo con telefonos...");
            /**
             * Cuando sesionid != null corresponde a browserstack (Permitir utilizar archivos locales)
             */
            if (Browser.getDriver().getCapabilities().getCapability("webdriver.remote.sessionid") != null) {
                Browser.getDriver().setFileDetector(new LocalFileDetector());

            }

            Paths p = new Paths();
            String path = p.cleanPathSo(System.getProperty("user.dir") + "/files/Excel/clientes/sample_clients-2.xlsx");
            fileClients.sendKeys(path);

        } catch (Exception e) {
            Report.FAILED("Fallo al subir archivo con telefonos de clientes: " + e.getMessage());
        }
        Thread.sleep(1500);
    }

    public void ingresarNumeroTelefonoDistribuidor() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");
        Thread.sleep(1000);
        System.out.println("Ingresar numero distribuidor...");
        try {
            inputDatosDI.get(3).sendKeys("99876543123");

        } catch (Exception e) {
            Report.FAILED("Fallo al ingresar numero de telefono distribuidor: " + e.getMessage());
        }
        Thread.sleep(1500);
    }

    public void clickbtnAceptar() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");
        JavascriptExecutor jse = (JavascriptExecutor) Browser.getDriver();
        Thread.sleep(1000);
        System.out.println("Click Boton continuar...");
        try {
            Paths p = new Paths();
            String path = p.cleanPathSo(System.getProperty("user.dir") + "/files/Excel/clientes/sample_clients-2.xlsx");
            fileClients.sendKeys(path);

            //((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].setAttribute('value', 'excels/sample_clients-2.xlsx');", btnSubirExcel);
            Thread.sleep(1500);
            inputDatosDI.get(2).click();

            /**
             * Click en continuar
             */
            System.out.println("Click Continuar");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn btn-primary-gasco\")[0].click();");
            Thread.sleep(1500);
            //_ngcontent-dkg-c109
            /**
             * Eliminar archivo cupones antes de descargarlo
             */
            System.out.println("Eliminando archivo antiguo...");
            File fichero = new File(p.cleanPathSo(LoadProperty.PATHS.getProperty("filecouponpath")));
            System.out.println(p.cleanPathSo(LoadProperty.PATHS.getProperty("filecouponpath")));

            if (fichero.exists()) {
                if (fichero.delete()) {
                    System.out.println("Archivo Eliminado con exito");
                } else {
                    System.out.print("Problemas al eliminar archivo: " + LoadProperty.PATHS.getProperty("filecouponpath"));
                }
            } else {
                System.out.println("Archivo No Existe...");
            }

            /**
             * Click en descargar archivo
             */
            Thread.sleep(1500);
            System.out.println("Click Descargar Cupon");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.querySelector('img[_ngcontent-nqj-c109]').click();");

            System.out.println("Pasa el click descargar");
            Thread.sleep(1500);
            /**
             * Validar Archivo en Browserstack
             */
            if (Browser.getDriver().getCapabilities().getCapability("webdriver.remote.sessionid") != null) {
                System.out.println("Validando archivo en Browserstack...");
                Boolean validateFile = (Boolean) jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"12273780-Solugas_coupon_file.xlsx\"}}");
                System.out.println("Validando Archivo descargado...");

                if (validateFile) {
                    System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"getFileProperties\", \"arguments\": {\"fileName\": \"12273780-Solugas_coupon_file.xlsx\"}}"));
                    // Get file content. The content is Base64 encoded
                    String base64EncodedFile = (String) jse.executeScript("browserstack_executor: {\"action\": \"getFileContent\", \"arguments\": {\"fileName\": \"12273780-Solugas_coupon_file.xlsx\"}}");
                    // Decode the content to Base64
                    byte[] data = Base64.getDecoder().decode(base64EncodedFile);
                    /**
                     * Cargar archivo descargado remoto en el proyecto local
                     */
                    String pathd = p.cleanPathSo(System.getProperty("user.dir") + "/files/excel/campana/crear/12273780-Solugas_coupon_file.xlsx");
                    OutputStream stream = new FileOutputStream(pathd);
                    stream.write(data);
                    stream.close();

                    /**
                     * Validar archivo creado
                     */
                } else {
                    Report.FAILED("Archivo descargado no encontrado: 12273780-Solugas_coupon_file.xlsx");
                }
            } else {
                /**
                 *CHROME LOCAL
                 */
                System.out.println("Validando archivo en Chrome...");
                File fileCampana = new File(p.cleanPathSo(LoadProperty.PATHS.getProperty("downloadpath") + "12273780-Solugas_coupon_file.xlsx"));

                System.out.println("Validando Archivo descargado...");

                if (fileCampana.exists()) {

                    //MOVER ARCHIVO A DIRECTORIO DEL PROYECTO
                    Path origenPath = FileSystems.getDefault().getPath(p.cleanPathSo(LoadProperty.PATHS.getProperty("downloadpath") + "12273780-Solugas_coupon_file.xlsx"));
                    Path destinoPath = FileSystems.getDefault().getPath(p.cleanPathSo(System.getProperty("user.dir") + "/files/excel/cupon/12273780-Solugas_coupon_file.xlsx"));
                    System.out.println("Moviendo archivo 12273780-Solugas_coupon_file.xlsx al proyecto...");
                    try {
                        Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.err.println(e);
                    }

                    Excel e = new Excel();
                    System.out.println("RUTA ARCHIVO: " + p.cleanPathSo(System.getProperty("user.dir") + "/files/excel/campana/crear/12273780-Solugas_coupon_file.xlsx"));
                    ArrayList<ArrayList<String>> dataFile = e.readExcel(p.cleanPathSo("cupon/12273780-Solugas_coupon_file.xlsx"));
                    System.out.println("CANTIDAD ARRAY: " + dataFile.size());
                    dataFile.forEach((dato) -> {
                        System.out.println("DATO: " + dato);
                    });
                } else {
                    Report.FAILED("Archivo descargado no encontrado: 12273780-Solugas_coupon_file.xlsx");
                }
            }

        } catch (Exception e) {
            Report.FAILED("Fallo al hacer click en boton continuar: " + e.getMessage());
        }
        Thread.sleep(1500);
    }

    public void ingresarNombreDistribuidor() throws URISyntaxException, IOException, InterruptedException {

        Thread.sleep(1000);
        try {
            /**
             * Agregar distribuidor
             */
            inputDatosDI.get(0).clear();
            inputDatosDI.get(0).sendKeys("Solugas");
            Thread.sleep(1500);

            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"buttonAdd\")[0].click();");
            Thread.sleep(500);
            //inputDatosDI.get(0).click();
            Thread.sleep(1500);
        } catch (Exception e) {
            Report.FAILED("Fallo al ingresar nombre distribuidor! " + e.getMessage());
        }

    }

    public void subirArchivoDi() throws URISyntaxException, IOException, InterruptedException {

        /**
         * Subir Excel con los datos
         */

        /**
         * Cuando sesionid != null corresponde a browserstack (Permitir utilizar archivos locales)
         */
        if (Browser.getDriver().getCapabilities().getCapability("webdriver.remote.sessionid") != null) {
            Browser.getDriver().setFileDetector(new LocalFileDetector());

        }

        System.out.println("Cargar archivo con telefonos...");

        Paths p = new Paths();
        String path = p.cleanPathSo(System.getProperty("user.dir") + "/files/Excel/clientes/sample_clients-2.xlsx");
        fileClients.sendKeys(path);

        //((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].setAttribute('value', 'excels/sample_clients-2.xlsx');", btnSubirExcel);
        Thread.sleep(1500);
        inputDatosDI.get(2).click();

    }

    public void seleccionarDiIngresado() throws URISyntaxException, IOException, InterruptedException {

        wu = new WaitUtils();
        System.out.println("Click en agregar distribuidor...");

        try {
            botonAgregar.click();
            inputDatosDIB.click();
            inputDatosDIB.sendKeys("Solugas");
        } catch (Exception e) {
            Report.FAILED("Fallo al ingresar DI ya ingresado: " + e.getMessage());
        }

    }

    public void clickCampoDi() throws URISyntaxException, IOException, InterruptedException {

        System.out.println("Click en agregar distribuidor...");
        botonAgregar.click();
        wu = new WaitUtils();
        try {
            inputDatosDI.get(0).click();
        } catch (Exception e) {
            Report.FAILED("Fallo al hacer click en campo DI: " + e.getMessage());
        }

    }

    public void ingresarSapDistribuidor() throws URISyntaxException, IOException, InterruptedException {
        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-primary-gasco\")[0].disabled =false;");
        Thread.sleep(1000);
        try {
            /**
             * Agregar distribuidor
             */
            inputDatosDI.get(0).clear();
            inputDatosDI.get(0).sendKeys("12273780");
            WebElement btnMore = Browser.getDriver().findElement(By.xpath("//button[contains(@class, 'buttonAdd')]"));
            Thread.sleep(500);
            btnMore.click();
            inputDatosDI.get(0).click();
            Thread.sleep(1500);
        } catch (Exception e) {
            Report.FAILED("Fallo al ingresar nombre distribuidor! " + e.getMessage());
        }

    }

    public void completeForm(String desc, int kilo) throws InterruptedException {
        if (kilo == 2) {
            inputDcto2kg.sendKeys(desc);
            inputRestricciones2kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-0-panel"));
            rst0Panel.click();
            Thread.sleep(1500);
        }
        if (kilo == 5) {
            inputDcto5kg.sendKeys(desc);
            inputRestricciones5kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-1-panel"));
            rst0Panel.click();
            Thread.sleep(1500);
        }
        if (kilo == 11) {
            inputDcto11kg.sendKeys(desc);
            inputRestricciones11kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-2-panel"));
            rst0Panel.click();
            Thread.sleep(1500);
        }
        if (kilo == 15) {
            inputDcto15kg.sendKeys(desc);
            inputRestricciones15kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-3-panel"));
            rst0Panel.click();
            Thread.sleep(1500);
        }
        if (kilo == 45) {
            inputDcto45kg.sendKeys(desc);
            inputRestricciones45kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-4-panel"));
            rst0Panel.click();
            Thread.sleep(1500);
        }
    }

    public void ingresoDescuento(String desc, int kilo) throws InterruptedException {
        if (kilo == 2) {
            inputDcto2kg.sendKeys(desc);
        }
        if (kilo == 5) {
            inputDcto5kg.sendKeys(desc);
        }
        if (kilo == 11) {
            inputDcto11kg.sendKeys(desc);
        }
        if (kilo == 15) {
            inputDcto15kg.sendKeys(desc);
        }
        if (kilo == 45) {
            inputDcto45kg.sendKeys(desc);
        }
    }

    public void ingresoRestriccion(int kilo) throws InterruptedException {

        if (kilo == 2) {
            inputRestricciones2kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-0-panel"));
            rst0Panel.click();
        }
        if (kilo == 5) {
            inputRestricciones5kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-1-panel"));
            rst0Panel.click();
        }
        if (kilo == 11) {
            inputRestricciones11kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-2-panel"));
            rst0Panel.click();
        }
        if (kilo == 15) {
            inputRestricciones15kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-3-panel"));
            rst0Panel.click();
        }
        if (kilo == 45) {
            inputRestricciones45kg.click();
            Thread.sleep(500);
            WebElement rst0Panel = Browser.getDriver().findElement(By.id("restrictions-4-panel"));
            rst0Panel.click();
        }
    }

    public void validateTextConfigCampana() throws URISyntaxException, IOException {
        boolean errorFlag = false;

        try {
            Thread.sleep(2000);

            wu = new WaitUtils();
            int i = 0;

            if (!LoadProperty.TEXT_VALIDATION.getProperty("step_two_title").equals(txtStep2Titulo.get(4).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("step_two_title") +
                        "\n y se visualiza: " + txtStep2Titulo.get(4).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("step_two_subtitle").equals(txtStep2Titulo.get(5).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("step_two_subtitle") +
                        "\n y se visualiza: " + txtStep2Titulo.get(5).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_promotion").equals(txtTipoPromocion.get(0).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_promotion") +
                        "\n y se visualiza: " + txtTipoPromocion.get(0).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_financing").equals(txtFinanciamiento.get(1).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_financing") +
                        "\n y se visualiza: " + txtFinanciamiento.get(1).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_radio_promotion").equals(txtRadioTipoPromocion.get(0).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_radio_promotion") +
                        "\n y se visualiza: " + txtRadioTipoPromocion.get(0).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_radio_financing").equals(txtRadioFinanciamiento.get(1).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_radio_financing") +
                        "\n y se visualiza: " + txtRadioFinanciamiento.get(1).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_format").equals(txtFormato.get(0).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_format") +
                        "\n y se visualiza: " + txtFormato.get(0).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_restriction").equals(txtRestricciones.get(2).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_restriction") +
                        "\n y se visualiza: " + txtRestricciones.get(2).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("format_2kg").equals(txtCilindro2Kg.get(0).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("format_2kg") +
                        "\n y se visualiza: " + txtCilindro2Kg.get(0).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("format_5kg").equals(txtCilindro5Kg.get(1).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("format_5kg") +
                        "\n y se visualiza: " + txtCilindro5Kg.get(1).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("format_11kg").equals(txtCilindro11Kg.get(2).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("format_11kg") +
                        "\n y se visualiza: " + txtCilindro11Kg.get(2).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("format_15kg").equals(txtCilindro15Kg.get(3).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("format_15kg") +
                        "\n y se visualiza: " + txtCilindro15Kg.get(3).getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("format_45kg").equals(txtCilindro45Kg.get(4).getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("format_45kg") +
                        "\n y se visualiza: " + txtCilindro45Kg.get(4).getText());
                errorFlag = true;
            }

            if (!errorFlag) {
                Report.PASSED("Se visualizan todos los textos en el menu Configurar Campana");
            }
        } catch (Exception e) {
            Report.FAILED("No se pudo validar textos. " + e.getMessage());
        }
    }


}

