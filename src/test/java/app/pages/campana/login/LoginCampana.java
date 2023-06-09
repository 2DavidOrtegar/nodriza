package app.pages.campana.login;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;

public class LoginCampana {

    @FindBy(xpath = "//img[contains(@class, 'logo')]")
    private WebElement iconoMiCampana;

    @FindBy(xpath = "//div[contains(@class, 'welcome-title-container')]")
    private WebElement tituloLogin;

    @FindBy(id = "mat-input-0")
    private WebElement nombreUsuario;

    @FindBy(id = "mat-input-1")
    private WebElement contrasena;

    @FindBy(xpath = "//div[contains(@class, 'mat-form-field-suffix ng-tns-c56-1 ng-star-inserted')]")
    private WebElement verContrasena;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement btnIngresar;

    @FindBy(xpath = "//h2[contains(@id, 'swal2-title')]")
    private WebElement msjErrorLogin;

    private int timeSleep = 1500;

    WaitUtils wu;


    public LoginCampana() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void validateElements() throws URISyntaxException, IOException, InterruptedException {
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
             * Validar elemento titulo Login
             */
            if (!wu.waitForElementVisible(tituloLogin)) {
                Report.FAILED("No se visualiza el elemento " + tituloLogin.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento input usuario
             */
            if (!wu.waitForElementVisible(nombreUsuario)) {
                Report.FAILED("No se visualiza el elemento " + nombreUsuario.toString());
                errorFlag = true;
            }

            /**
             *Validar elemento input password
             */
            if (!wu.waitForElementVisible(contrasena)) {
                Report.FAILED("No se visualiza el elemento " + contrasena.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento ver contraseña
             */
            if (!wu.waitForElementVisible(verContrasena)) {
                Report.FAILED("No se visualiza el elemento " + verContrasena.toString());
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

    public void ingresoLogin() throws URISyntaxException, IOException {

        try {
            Thread.sleep(timeSleep);
            wu = new WaitUtils();
            if (wu.waitForElementVisible(nombreUsuario)) {
                Report.PASSED("Se visualiza formulario");
                String classButton = btnIngresar.getAttribute("class");

                if (classButton.equals("btn-login btn-disabled")) {
                    Report.PASSED("El boton se encuentra deshabilitado");
                } else {
                    Report.FAILED("El boton se encuentra habilitado");
                }

                nombreUsuario.sendKeys(LoadProperty.USER_CAMPANA.getProperty("user"));
                contrasena.sendKeys(LoadProperty.USER_CAMPANA.getProperty("password"));

                String classButton2 = btnIngresar.getAttribute("class");

                if (classButton2.equals("btn-login btn-primary-gasco")) {
                    Report.PASSED("El boton se encuentra habilitado");
                    btnIngresar.click();
                    Thread.sleep(timeSleep);
//                    WebElement a = Browser.getDriver().findElement(By.xpath("//span[text(), 'Cerrar sesión']"));
                    if (wu.waitForElementVisible(Browser.getDriver().findElement(By.xpath("//div[contains(@class, 'logout-container')]")))) {
                        Report.PASSED("Login exitoso");
                    } else {
                        Report.FAILED("No se pudo iniciar sesion");
                    }
                } else {
                    Report.FAILED("El boton se encuentra deshabilitado");
                }
            }
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de login " + e.getMessage());
        }
    }

    public void falloLogin() throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            if (wu.waitForElementVisible(nombreUsuario)) {
                Report.PASSED("Se visualiza formulario");
                String classButton = btnIngresar.getAttribute("class");
                if (classButton.equals("btn-login btn-disabled")) {
                    Report.PASSED("El boton se encuentra deshabilitado");
                } else {
                    Report.FAILED("El boton se encuentra habilitado");
                }
                nombreUsuario.sendKeys(LoadProperty.USER_CAMPANA.getProperty("userbad"));
                contrasena.sendKeys(LoadProperty.USER_CAMPANA.getProperty("passwordbad"));
                String classButton2 = btnIngresar.getAttribute("class");
                if (classButton2.equals("btn-login btn-primary-gasco")) {
                    Report.PASSED("El boton se encuentra habilitado");
                    btnIngresar.click();
                    Thread.sleep(timeSleep);
                    if (wu.waitForElementVisible(msjErrorLogin)) {
                        Report.PASSED("Las credenciales son incorrectas");
                    } else {
                        Report.FAILED("Se pudo iniciar sesion con credenciales no validas");
                    }
                } else {
                    Report.FAILED("El boton se encuentra deshabilitado");
                }
            }
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de login " + e.getMessage());
        }
    }


}
