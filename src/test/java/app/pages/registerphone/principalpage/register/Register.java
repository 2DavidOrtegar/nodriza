package app.pages.registerphone.principalpage.register;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import app.support.utils.WaitUtils;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;

public class Register {

    @FindBy(xpath = "//img[contains(@class, 'logo')]")
    private WebElement iconoMiCampana;

    @FindBy(id = "mat-input-0")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/form/div[2]/button")
    private WebElement btnIngresar;

    @FindBy(id = "mat-checkbox-1-input")
    private WebElement autorizarCheck;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/form/div[2]/div[3]/button[1]")
    private WebElement btnRegistrar;

    @FindBy(xpath = "//*[@id=\"fork\"]/div[3]/button")
    private WebElement btnRegistrar2;

    @FindBy(xpath = "//*[@id=\"fork\"]/div[3]/button")
    private WebElement btnContinuar;

    @FindBy(xpath = "//*[@id=\"card-no-discount\"]/button")
    private WebElement btnIrGasco;
    private int timeSleep = 1500;

    WaitUtils wu;

    public Register() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void validateElements() throws URISyntaxException, IOException {
        boolean errorFlag = false;

        try {
            wu = new WaitUtils();

            /**
             * Validar elemento icono logo
             */
            if (!wu.waitForElementVisible(iconoMiCampana)) {
                Report.FAILED("No se visualiza el elemento " + iconoMiCampana.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento input telefono
             */
            if (!wu.waitForElementVisible(phoneNumber)) {
                Report.FAILED("No se visualiza el elemento " + phoneNumber.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento button ingresar
             */
            String classButton = btnIngresar.getAttribute("class");

            if (!wu.waitForElementVisible(btnIngresar)) {
                Report.FAILED("No se visualiza el elemento " + btnIngresar.toString());
                errorFlag = true;
            }

            /**
             * Todos los elementos se encuentran ok
             */
            if (!errorFlag) {
                Report.PASSED("Se visualizan todos los elementos en el login");
            }

        } catch (Exception e) {
            Report.FAILED("Fallo metodo de validacion. " + e.getMessage());
        }
    }

    public void registerPhone(String phone) throws URISyntaxException, IOException {

        /**
         * Validar NUmero
         */
        Report.PASSED("Validando Numero");
        try {
            wu = new WaitUtils();
            if (wu.waitForElementVisible(phoneNumber)) {
                Report.PASSED("Se visualiza formulario");
                String classButton = btnIngresar.getAttribute("class");

                if (classButton.equals("btn-disabled-1")) {
                    Report.PASSED("El boton se encuentra deshabilitado");
                } else {
                    Report.FAILED("El boton se encuentra habilitado");
                }
                /**
                 * seleccionar numero de telefono de forma random
                 */
                int randomNumber = (int) (Math.random() * 3 + 1);
                //String phone = LoadProperty.DATA.getProperty("phonecliente." + randomNumber);
                phoneNumber.sendKeys(phone);

                String classButton2 = btnIngresar.getAttribute("class");

                if (classButton2.equals("btn-gasco-1")) {
                    Report.PASSED("El boton se encuentra habilitado");
                    btnIngresar.click();
                    Thread.sleep(timeSleep);
                } else {
                    Report.FAILED("El boton se encuentra deshabilitado");
                }
            }

        } catch (Exception e) {
            Report.FAILED("Fallo registrar numero " + e.getMessage());
        }

        Report.PASSED("Registrando Numero");

        try {
            /**
             * Validar si numero no está registrado true=no_registrado
             */
            if (wu.waitForElementVisible(autorizarCheck)) {
                int randomNumber = (int) (Math.random() * 5 + 0);//del 0 al 4
                int randomNumber2 = (int) (Math.random() * 5 + 0);//del 0 al 4
                int randomNumber3 = (int) (Math.random() * (10 - 5) + 5);//del 5 al 9

                /**
                 * Checkbox USO DEL GAS
                 */
                ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"checkbox-container\")[" + randomNumber + "].click();");
                ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"checkbox-container\")[" + randomNumber2 + "].click();");

                /**
                 * Checkbox DONDE ESTABA EL QR
                 */
                ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"checkbox-container\")[" + randomNumber3 + "].click();");

                /**
                 * Botón AUTORIZAR
                 */
                ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById(\"mat-checkbox-1-input\").click();");
                // autorizarCheck.click();
                Thread.sleep(timeSleep);

                /**
                 * Click Registrar
                 */
                btnRegistrar.click();

            }

        } catch (Exception e) {
            Report.FAILED("Fallo metodo de completar datos de registro:  " + e.getMessage());
        }

        try {
            /**
             * Validar si el numero ya tiene un cupon asociado
             */
            if (wu.waitForElementVisible(btnIrGasco)) {
                Report.FAILED("Ya se encuentra un cupon asociado al numero");
            }

            Thread.sleep(2000);
        } catch (Exception e) {
            Report.FAILED("Fallo validar si ya existe cupon asociado " + e.getMessage());
        }
    }

    public void selectDeliveryOption() throws InterruptedException, URISyntaxException, IOException {
        Thread.sleep(timeSleep);
        /**
         * Seleccionar opción de prueba
         */
        Report.PASSED("Seleccionar opciones de prueba");
        try {
            int randomNumber4 = (int) (Math.random() * 2 + 0);//del 0 al 1: 0=DESPACHO DOMICILIO 1=RETIRO LOCAL

            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"card-option-select\")[" + randomNumber4 + "].click();");
            Thread.sleep(timeSleep);
            /**
             * Click boton continuar
             */
            btnContinuar.click();
            Thread.sleep(timeSleep);
        } catch (Exception e) {
            Report.FAILED("Fallo al seleccionar opciones de prueba " + e.getMessage());
        }

    }

    public void selectShippingDiscounts() throws InterruptedException, URISyntaxException, IOException {
        /**
         * Descuentos para despacho
         */
        int randomNumber5 = (int) (Math.random() * 4 + 0);//del 0 al 1
        int amountOfClicks = (int) (Math.random() * 10 + 1);//del 1 al 10
        Report.PASSED("Seleccionar descuentos para despacho");

        try {
            for (int i = 1; i <= amountOfClicks; i++) {
                ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"sumar\")[" + randomNumber5 + "].click();");
            }
        } catch (Exception e) {
            Report.FAILED("Fallo al seleccionar descuentos para despacho: " + e.getMessage());
        }

        Thread.sleep(timeSleep);
    }

    public void generateCoupon() throws URISyntaxException, IOException {
        /**
         * Generar Cupon
         */
        Report.PASSED("Generando Cupon");

        try {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn-gasco\")[0].click();");
        } catch (Exception e) {
            Report.FAILED("Fallo al generar cupon: " + e.getMessage());
        }

    }
}


