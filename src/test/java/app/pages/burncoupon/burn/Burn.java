package app.pages.burncoupon.burn;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import app.support.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;

public class Burn {

    public Burn() {
        PageFactory.initElements(Browser.getDriver(), this);
    }
    @FindBy(xpath = "/html/body/app-root/app-login/div/div/form/img")
    private WebElement iconoMiCampana;

    @FindBy(xpath = "//div[contains(@class, 'welcome-title-container')]")
    private WebElement tituloLogin;

    @FindBy(id = "mat-input-0")
    private WebElement nombreUsuario;

    @FindBy(id = "mat-input-1")
    private WebElement contrasena;

    @FindBy(xpath = "//mat-icon[contains(@aria-hidden,'true')]")
    private WebElement verContrasena;

    @FindBy(xpath = "//button[contains(@class,'btn-primary-gasco')]")
    private WebElement btnIngresar;

    @FindBy(xpath = "//h2[contains(@id, 'swal2-title')]")
    private WebElement msjErrorLogin;

    @FindBy(id = "max")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[contains(@formcontrolname,'voucherNum')]")
    private WebElement numCupon;

    @FindBy(xpath = "//div[contains(@class,'burning-voucher-container')]")
    private WebElement quemarButton;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Aceptar')]")
    private WebElement aceptarQuemarButton;

    @FindBy(xpath = "//*[@id=\"cdk-overlay-0\"]/snack-bar-container/div/div/simple-snack-bar/span")
    private WebElement quemarMessage;
    private int timeSleep = 1500;

    WaitUtils wu;
    public void validateElements() throws URISyntaxException, IOException {
        boolean errorFlag = false;

        try {
            wu = new WaitUtils();

            /**
             * Validar elemento numero de telefono
             */
            if (!wu.waitForElementVisible(phoneInput)) {
                Report.FAILED("No se visualiza el elemento " + phoneInput.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento numero de cupon
             */
            if (!wu.waitForElementVisible(numCupon)) {
                Report.FAILED("No se visualiza el elemento " + numCupon.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento numero de cupon
             */
            if (!wu.waitForElementVisible(quemarButton)) {
                Report.FAILED("No se visualiza el elemento " + quemarButton.toString());
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

    public void validarQuemaCupon(String phone, String cupon) throws URISyntaxException, IOException {
        try {
            Thread.sleep(timeSleep);
            wu = new WaitUtils();
            if (wu.waitForElementVisible(phoneInput)) {
                Report.PASSED("Se visualiza formulario");

                phoneInput.sendKeys(phone);
                numCupon.sendKeys(cupon);
                phoneInput.click();

                Thread.sleep(timeSleep);

                String classButton2 = btnIngresar.getAttribute("class");

                if (classButton2.equals("btn-primary-gasco")) {
                    Report.PASSED("El boton se encuentra habilitado");
                    btnIngresar.click();
                    Thread.sleep(timeSleep);
//                    WebElement a = Browser.getDriver().findElement(By.xpath("//span[text(), 'Cerrar sesión']"));

                } else {
                    Report.FAILED("El boton se encuentra deshabilitado");
                }

            }
        } catch (Exception e) {
            Report.FAILED("Fallo metodo quemar cupon " + e.getMessage());
        }

        /**
         * Aceptar Quemar Cupon
         */
        try {
            System.out.println("Click en aceptar quemar cupon");
            aceptarQuemarButton.click();
            Thread.sleep(timeSleep);

        } catch (Exception e) {
            Report.FAILED("Problemas al realizar click en Quemar Cupon: " + e.getMessage());
        }

        /**
         * Leer mensaje Mensaje Quemado con Exito
         */
        try {
            System.out.println("Leer mensaje cupon quemado ok");
            String message = quemarMessage.getText();
            Report.PASSED("Cupon quemado: " + message);
            Thread.sleep(timeSleep);

        } catch (Exception e) {
            Report.FAILED("Problemas al quemar cupon: " + e.getMessage());
        }
    }
}
