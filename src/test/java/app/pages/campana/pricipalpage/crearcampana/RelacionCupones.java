package app.pages.campana.pricipalpage.crearcampana;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import app.support.utils.Excel;
import app.support.utils.Paths;
import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

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

public class RelacionCupones {

    @FindBy(xpath = "//input[contains(@class,'checkbox-header')]")
    private WebElement checkSelecTodosDI;

    @FindBy(xpath = "//input[contains(@class,'checkbox')]")
    private List<WebElement> checkSelecDI;

    @FindBy(xpath = "//input[contains(@class,'textbox')]")
    private List<WebElement> inputDatosDI;

    @FindBy(xpath = "//button[contains(@type,'file')]")
    private WebElement btnSubirExcel;

    @FindBy(id = "file")
    private WebElement fileClients;

    @FindBy(xpath = "//div[contains(@class,'btn-table')]")
    private List<WebElement> btnAccionesDI;

    @FindBy(xpath = "//div[contains(@class,'btn-excel')]")
    private WebElement btnDescargarFormatoCarga;

    @FindBy(xpath = "//button[contains(@class,'btn btn')]")
    private List<WebElement> btnAtrasSiguiente;

    @FindBy(xpath = "//div[contains(@class,'row title-table col-12')]")
    private WebElement txtRelacionCupones;

    @FindBy(xpath = "//img[contains(@class,'iconPositionFixed')]")
    private WebElement txtAdvertencia;

    @FindBy(xpath = "//th[contains(@id,'distributor')]")
    private WebElement txtDistribuidor;

    @FindBy(xpath = "//th[contains(@id,'fantasyName')]")
    private WebElement txtNombreFantasia;

    @FindBy(xpath = "//th[contains(@id,'voucher')]")
    private WebElement txtNumeroCupones;

    @FindBy(xpath = "//th[contains(@id,'clientFile')]")
    private WebElement txtArchivoCliente;

    @FindBy(xpath = "//th[contains(@id,'phone')]")
    private WebElement txtNumeroTelefono;

    @FindBy(xpath = "//img[@src='assets/images/check.svg']")
    private WebElement cuponIcon;


    public RelacionCupones() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    WaitUtils wu;

    public void validateElementsRelacionCupones() throws URISyntaxException, IOException {
        boolean errorFlag = false;

        try {
            wu = new WaitUtils();
            int i = 0;

            if (!wu.waitForElementVisible(checkSelecTodosDI)) {
                Report.FAILED("No se visualiza el elemento " + checkSelecTodosDI.toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(checkSelecDI.get(1))) {
                Report.FAILED("No se visualiza el elemento " + checkSelecDI.get(1).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(inputDatosDI.get(0))) {
                Report.FAILED("No se visualiza el elemento " + inputDatosDI.get(0).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(inputDatosDI.get(1))) {
                Report.FAILED("No se visualiza el elemento " + inputDatosDI.get(1).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(inputDatosDI.get(2))) {
                Report.FAILED("No se visualiza el elemento " + inputDatosDI.get(2).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(inputDatosDI.get(3))) {
                Report.FAILED("No se visualiza el elemento " + inputDatosDI.get(3).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(btnSubirExcel)) {
                Report.FAILED("No se visualiza el elemento " + btnSubirExcel.toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(btnAccionesDI.get(0))) {
                Report.FAILED("No se visualiza el elemento " + btnAccionesDI.get(0).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(btnAccionesDI.get(1))) {
                Report.FAILED("No se visualiza el elemento " + btnAccionesDI.get(1).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(btnAccionesDI.get(2))) {
                Report.FAILED("No se visualiza el elemento " + btnAccionesDI.get(2).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(btnDescargarFormatoCarga)) {
                Report.FAILED("No se visualiza el elemento " + btnDescargarFormatoCarga.toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(btnAtrasSiguiente.get(0))) {
                Report.FAILED("No se visualiza el elemento " + btnAtrasSiguiente.get(0).toString());
                errorFlag = true;
            }

            if (!wu.waitForElementVisible(btnAtrasSiguiente.get(1))) {
                Report.FAILED("No se visualiza el elemento " + btnAtrasSiguiente.get(1).toString());
                errorFlag = true;
            }

            if (!errorFlag) {
                Report.PASSED("Se visualizan todos los elementos en el menu Relacion Cupones");
            }

        } catch (Exception e) {
            Report.FAILED("No se puede validar elementos de realacion de cupones " + e.getMessage());
        }
    }

    public void validateTextRelacionCupones() throws URISyntaxException, IOException {
        boolean errorFlag = false;

        try {
            Thread.sleep(2000);

            wu = new WaitUtils();
            int i = 0;

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_relation_cupon").equals(txtRelacionCupones.getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_relation_cupon") +
                        "\n y se visualiza: " + txtRelacionCupones.getText());

                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_remember").equals(txtAdvertencia.getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_remember") +
                        "\n y se visualiza: " + txtAdvertencia.getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_di").equals(txtDistribuidor.getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_di") +
                        "\n y se visualiza: " + txtDistribuidor.getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_name_fantasy").equals(txtNombreFantasia.getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_name_fantasy") +
                        "\n y se visualiza: " + txtNombreFantasia.getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_cupons").equals(txtNumeroCupones.getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_cupons") +
                        "\n y se visualiza: " + txtNumeroCupones.getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_excel_file").equals(txtArchivoCliente.getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_excel_file") +
                        "\n y se visualiza: " + txtArchivoCliente.getText());
                errorFlag = true;
            }

            if (!LoadProperty.TEXT_VALIDATION.getProperty("title_phone").equals(txtNumeroTelefono.getText())) {
                Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_phone") +
                        "\n y se visualiza: " + txtNumeroTelefono.getText());
                errorFlag = true;
            }

            if (!errorFlag) {
                Report.PASSED("Se visualizan todos los textos en el menu Relacion cupones");
            }
        } catch (Exception e) {
            Report.FAILED("No se pudo validar textos. " + e.getMessage());
        }
    }

    public void completeCouponRelation() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Browser.getDriver();

        try {
            /**
             * Ingresar nombre de distribuidor
             */
            inputDatosDI.get(0).sendKeys("Solugas");
            Thread.sleep(1500);

            /**
             * Agregar distribuidor
             */
            WebElement btnMore = Browser.getDriver().findElement(By.xpath("//button[contains(@class, 'buttonAdd')]"));
            Thread.sleep(500);
            btnMore.click();
            inputDatosDI.get(0).click();

            /**
             * Cantidad de cupones
             */

            System.out.println("Colocando cantidad de cupones...");
            String numberOfCoupons = String.valueOf((Math.random() * 10 + 1));//del 1 al 10
            inputDatosDI.get(2).click();
            inputDatosDI.get(2).sendKeys(numberOfCoupons);

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
            String path = p.cleanPathSo(System.getProperty("user.dir") + "/files/excel/sample_clients-2.xlsx");
            fileClients.sendKeys(path);

            //((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].setAttribute('value', 'excels/sample_clients-2.xlsx');", btnSubirExcel);
            Thread.sleep(2500);
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
            System.out.println("Click Descargar Cupon");
            //((JavascriptExecutor) Browser.getDriver()).executeScript("document.querySelector('img[_ngcontent-ivh-c109]').click();");
            if (wu.waitForElementVisible(cuponIcon)) {
                cuponIcon.click();
            } else {
                Report.FAILED("No se visualiza el elemento " + cuponIcon.toString());
            }

            Thread.sleep(2000);
            /**
             * Validar Archivo en Browserstack
             */
            if (Browser.getDriver().getCapabilities().getCapability("webdriver.remote.sessionid") != null) {
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

            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
