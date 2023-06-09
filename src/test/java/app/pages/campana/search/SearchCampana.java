package app.pages.campana.search;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import app.support.utils.WaitUtils;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Base64;

public class SearchCampana {
    @FindBy(xpath = "//span[contains(.,'Consulta de campa')]")
    private WebElement linkSearch;
    @FindBy(xpath = "//input[contains(@id,'mat-input-')]")
    private WebElement nombreCampana;
    @FindBy(xpath = "//div[contains(@id,'mat-select-value-1')]")
    private WebElement estadoCampana;
    @FindBy(xpath = "//div[contains(@id,'mat-select-value-3')]")
    private WebElement mesCampana;
    @FindBy(xpath = "//input[contains(@formcontrolname,'year')]")
    private WebElement anioCampana;
    @FindBy(xpath = "//button[@type='submit'][contains(.,'Buscar')]")
    private WebElement buscarButton;
    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div/app-query-campaign/div[3]/div/table/tbody/tr[1]/td[1]")
    private WebElement tdResult;
    @FindBy(xpath = "(//img[@src='assets/images/fragment.svg '])[1]")
    private WebElement generarImg;
    @FindBy(xpath = "/html/body/app-root/div/app-home/div/div/app-query-campaign/div[3]/div/table/tbody/tr[1]/td[7]/div/img")
    private WebElement descargaImg;
    WaitUtils wu;
    int timeSleep = 1500;
    public SearchCampana() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void validateElementConsultaCampana() throws URISyntaxException, IOException, InterruptedException {
        wu = new WaitUtils();
        boolean errorFlag = false;
        System.out.println("Ingresando a la vista Buscar Campana...");

        try {
            linkSearch.click();
        } catch (Exception e) {
            Report.FAILED("No se visualiza el elemento " + linkSearch.toString());
        }

        try {
            /**
             * Validar elemento nombre
             */
            System.out.println("Validando elemento nombre...");

            if (!wu.waitForElementVisible(nombreCampana)) {
                System.out.println("Campo nombre no encontrado!");
                Report.FAILED("No se visualiza el elemento " + nombreCampana.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento estado
             */
            System.out.println("Validando elemento estado...");

            if (!wu.waitForElementVisible(estadoCampana)) {
                System.out.println("Campo Estado no encontrado!");
                Report.FAILED("No se visualiza el elemento " + estadoCampana.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento mes
             */
            System.out.println("Validando elemento mes...");

            if (!wu.waitForElementVisible(mesCampana)) {
                System.out.println("Campo Mes no encontrado!");
                Report.FAILED("No se visualiza el elemento " + mesCampana.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento anio
             */
            System.out.println("Validando elemento anio...");

            if (!wu.waitForElementVisible(anioCampana)) {
                System.out.println("Campo Anio no encontrado!");
                Report.FAILED("No se visualiza el elemento " + anioCampana.toString());
                errorFlag = true;
            }

            /**
             * Validar elemento boton buscar
             */
            System.out.println("Validando elemento boton buscar...");

            if (!wu.waitForElementVisible(buscarButton)) {
                System.out.println("Boton Buscar no encontrado!");
                Report.FAILED("No se visualiza el elemento " + buscarButton.toString());
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

        Thread.sleep(timeSleep);
    }

    public void searchCampana() throws URISyntaxException, IOException, InterruptedException {
        wu = new WaitUtils();
        JavascriptExecutor jse = (JavascriptExecutor) Browser.getDriver();
        String campana = LoadProperty.DATA.getProperty("campananame");
        /**
         * Ingresar nombre de campana
         */
        System.out.println("Ingresando nombre de campana...");
        try {
            nombreCampana.sendKeys(campana);
        } catch (Exception e) {
            Report.FAILED("Problemas al asignar valor en nombre campana: " + e.getMessage());
        }

        /**
         * Click en buscar
         */
        System.out.println("Click en boton buscar...");
        try {
            buscarButton.click();
        } catch (Exception e) {
            Report.FAILED("Problemas al hacer click en buscar: " + e.getMessage());
        }

        /**
         * Validar resultado
         */
        Thread.sleep(timeSleep);
        System.out.println("Validando resultado busqueda...");

        if (wu.waitForElementVisible(tdResult)) {

            String nombreCampana = tdResult.getText().trim();

            if (nombreCampana.contains(campana)) {
                System.out.println("Busqueda camapana exitosa: " + nombreCampana);
                Report.PASSED("Busqueda campana exitosa: " + nombreCampana);
                try {
                    /**
                     * Click en Generar
                     */
                    generarImg.click();
                } catch (Exception e) {
                    Report.FAILED("Problemas al hacer click en generar: " + e.getMessage());
                }

                try {
                    /**
                     * Click en descarga
                     */
                    Thread.sleep(timeSleep);
                    System.out.println("Realizando click en descarga");

                    Thread.sleep(timeSleep);

                    descargaImg.click();

                    Thread.sleep(timeSleep);

                    Boolean validateFile;

                    /**
                     * Cuando sesionid != null corresponde a browserstack
                     */
                    if (Browser.getDriver().getCapabilities().getCapability("webdriver.remote.sessionid") != null) {
                        /**
                         * Validar Archivo en Browserstack
                         */
                        validateFile = (Boolean) jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"" + nombreCampana + "_report_file.xlsx\"}}");
                        System.out.println("RESULTADO ARCHIVO: " + validateFile);

                        System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"getFileProperties\", \"arguments\": {\"fileName\": \"" + nombreCampana + "_report_file.xlsx\"}}"));
                        // Get file content. The content is Base64 encoded
                        String base64EncodedFile = (String) jse.executeScript("browserstack_executor: {\"action\": \"getFileContent\", \"arguments\": {\"fileName\": \"" + nombreCampana + "_report_file.xlsx\"}}");
                        // Decode the content to Base64
                        byte[] data = Base64.getDecoder().decode(base64EncodedFile);
                        System.out.println(data);
                        OutputStream stream = new FileOutputStream("files/excel/campana/consulta/" + nombreCampana + "_report_file.xlsx");
                        stream.write(data);
                        stream.close();
                    } else {
                        File campanaFile = new File(LoadProperty.PATHS.getProperty("downloadpath") + nombreCampana + "_report_file.xlsx");
                        validateFile = campanaFile.exists();
                    }

                    if (validateFile) {
                        System.out.println("El Archivo descarga Existe: " + nombreCampana + "_report_file.xlsx");
                    } else {
                        Report.FAILED("Archivo descarga no encontrado: " + nombreCampana + "_report_file.xlsx");
                    }

                } catch (Exception e) {
                    Report.FAILED("Problemas al hacer click en descargar: " + e.getMessage());
                    ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"cdk-column-download\")[1].getElementsByTagName(\"div\")[0].click();");
                }

                /**
                 * Seleccionar estado
                 */
                //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"mat-select-arrow-wrapper\")[0].click();");
                //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"mat-option\")[3].click();");
            } else {
                System.out.println("Campana no encontrada: " + nombreCampana);
                Report.FAILED("Campana no encontrada: " + nombreCampana);
            }


        } else {
            System.out.println("Sin resultados...");
        }

    }
}
