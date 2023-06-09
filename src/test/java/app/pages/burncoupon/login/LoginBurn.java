package app.pages.burncoupon.login;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import app.support.utils.WaitUtils;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;

public class LoginBurn {
    WaitUtils wu;
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

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement btnIngresar;
    private int timeSleep = 1500;

    public LoginBurn() {
        PageFactory.initElements(Browser.getDriver(), this);
    }
    public void validateElementsLogin() throws URISyntaxException, IOException, InterruptedException {
        boolean errorFlag = false;

        //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById(\"mat-input-0\").value=\"Hola\"");

        System.out.println("Validando datos Login...");
        try {
            wu = new WaitUtils();

            /**
             * Validar elemento icono logo
             */
            if (!wu.waitForElementVisible(iconoMiCampana)) {
                System.out.println("Icono Login no encontrado!");
                Report.FAILED("No se visualiza el elemento " + iconoMiCampana.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento titulo Login
             */
            if (!wu.waitForElementVisible(tituloLogin)) {
                System.out.println("Titulo Login no encontrado!");
                Report.FAILED("No se visualiza el elemento " + tituloLogin.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento input usuario
             */
            if (!wu.waitForElementVisible(nombreUsuario)) {
                System.out.println("Campo Usuario no encontrado!");
                Report.FAILED("No se visualiza el elemento " + nombreUsuario.toString());
                errorFlag = true;
            }

            /**
             *Validar elemento input password
             */
            if (!wu.waitForElementVisible(contrasena)) {
                System.out.println("Campo Password no encontrado!");
                Report.FAILED("No se visualiza el elemento " + contrasena.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento ver contraseña
             */
            if (!wu.waitForElementVisible(verContrasena)) {
                System.out.println("Icono ver contrasena no encontrado!");
                Report.FAILED("No se visualiza el elemento " + verContrasena.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento button ingresar
             */
            String classButton = btnIngresar.getAttribute("class");

            if (!wu.waitForElementVisible(btnIngresar)) {
                System.out.println("Boton ingresar no encontrado!");
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

    public void ingresoLogin() throws URISyntaxException, IOException {

        try {
            Thread.sleep(1000);
            wu = new WaitUtils();
            if (wu.waitForElementVisible(nombreUsuario)) {
                Report.PASSED("Se visualiza formulario");
                String classButton = btnIngresar.getAttribute("class");

                if (classButton.equals("btn-login btn-disabled")) {
                    Report.PASSED("El boton se encuentra deshabilitado");
                } else {
                    Report.FAILED("El boton se encuentra habilitado");
                }

                nombreUsuario.sendKeys(LoadProperty.USER_CAMPANA.getProperty("userburn"));
                contrasena.sendKeys(LoadProperty.USER_CAMPANA.getProperty("passwordburn"));

                String classButton2 = btnIngresar.getAttribute("class");

                if (classButton2.equals("btn-login btn-primary-gasco")) {
                    Report.PASSED("El boton se encuentra habilitado");
                    btnIngresar.click();
                    Thread.sleep(timeSleep);
//                    WebElement a = Browser.getDriver().findElement(By.xpath("//span[text(), 'Cerrar sesión']"));

                } else {
                    Report.FAILED("El boton se encuentra deshabilitado");
                }
            }
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de login " + e.getMessage());
        }
    }
}
