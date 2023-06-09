package app.pages.campana.pricipalpage.crearcampana;

import app.support.browsers.Browser;
import app.support.capturerequest.CaptureRequest;
import app.support.loadproperties.LoadProperty;
import app.support.utils.PgSql;
import app.support.utils.SupportJsEvent;
import app.support.utils.WaitUtils;
import app.support.utils.WorkWithDates;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static app.support.utils.GetAlphaNumeric.getAlphaNumeric;

public class CrearCampana {

    @FindBy(xpath = "//li[contains(@class, 'navContainer ng-star-inserted')]")
    private List<WebElement> btnCrearCampana;

    @FindBy(id = "mat-input-2")
    private WebElement inputTituloCampana;

    @FindBy(xpath = "//button[contains(@class, 'mat-focus-indicator mat-icon-button mat-button-base')]")
    private WebElement divDate;

    @FindBy(xpath = "//span[contains(@class, 'mat-button-wrapper')]")
    private WebElement btnVigenciaCampana;

    @FindBy(xpath = "//textarea[contains(@class, 'mat-input-element')]")
    private WebElement inputMotivo;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-back mr-2')]")
    private WebElement btnVolver;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement btnContinuar;

    @FindBy(xpath = "//button[contains(text(),'Guardar Cambios')]")
    private WebElement btnGuardarCambios;

    @FindBy(xpath = "//div[contains(@class,'title')]")
    private List<WebElement> txtTituloCrearCampana;

    @FindBy(xpath = "//div[contains(@class,'title')]")
    private List<WebElement> txtSubtituloCrearCampana;

    @FindBy(xpath = "//div[contains(@class,'title')]")
    private List<WebElement> txtStep1Titulo;

    @FindBy(xpath = "//div[contains(@class,'title')]")
    private List<WebElement> txtStep1Subtitulo;

    @FindBy(xpath = "//mat-label[contains(@class,'ng-tns-c60-2 ng-star-inserted')]")
    private WebElement txtInputTituloCampana;

    @FindBy(xpath = "//mat-label[contains(@class,'ng-tns-c60-3 ng-star-inserted')]")
    private WebElement txtInputVigenciaCampana;

    @FindBy(xpath = "//mat-label[contains(@class,'ng-tns-c60-4 ng-star-inserted')]")
    private WebElement txtInputMotivoCampana;

    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[1]")
    private WebElement checkCN2kg;

    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[2]")
    private WebElement checkCN5kg;

    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[3]")
    private WebElement checkCS5kg;

    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[4]")
    private WebElement checkCN11kg;

    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[5]")
    private WebElement checkCS11kg;

    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[6]")
    private WebElement checkCN15kg;

    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[7]")
    private WebElement checkCS15kg;

    @FindBy(xpath = "(//span[@class='mat-checkbox-inner-container'])[8]")
    private WebElement checkCN45kg;

    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[9]")
    private WebElement checkCS45kg;

    @FindBy(xpath = "//div[contains(@class,'step-container')]")
    private WebElement contenedor;

    @FindBy(xpath = "(//span[contains(@class,'mat-radio-inner-circle')])[2]")
    private WebElement financiamiento;

    WaitUtils wu;

    public CrearCampana() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void validateElementsCrearCampana() throws URISyntaxException, IOException {

        boolean errorFlag = false;

        try {
            wu = new WaitUtils();

            if (wu.waitForElementVisible(btnCrearCampana.get(0))) {

                btnCrearCampana.get(0).click();
                /**
                 * Validar titulo
                 */
                if (!wu.waitForElementVisible(inputTituloCampana)) {
                    Report.FAILED("No se visualiza el elemento " + inputTituloCampana.toString());
                    errorFlag = true;
                }

                /**
                 * Validar campo fecha
                 */
                if (!wu.waitForElementVisible(divDate)) {
                    Report.FAILED("No se visualiza el elemento " + divDate.toString());
                    errorFlag = true;
                }

                /**
                 * Validar vigencia campaña
                 */
                if (!wu.waitForElementVisible(btnVigenciaCampana)) {
                    Report.FAILED("No se visualiza el elemento " + btnVigenciaCampana.toString());
                    errorFlag = true;
                }

                /**
                 * Validar motivo
                 */
                if (!wu.waitForElementVisible(inputMotivo)) {
                    Report.FAILED("No se visualiza el elemento " + inputMotivo.toString());
                    errorFlag = true;
                }

                /**
                 * Validar botón volver
                 */
                if (!wu.waitForElementVisible(btnVolver)) {
                    Report.FAILED("No se visualiza el elemento " + btnVolver.toString());
                    errorFlag = true;
                }

                /**
                 * Validar botón continuar
                 */
                if (!wu.waitForElementVisible(btnContinuar)) {
                    Report.FAILED("No se visualiza el elemento " + btnContinuar.toString());
                    errorFlag = true;
                }

                /**
                 * Validar botón guardar cambios
                 */
                if (!wu.waitForElementVisible(btnGuardarCambios)) {
                    Report.FAILED("No se visualiza el elemento " + btnGuardarCambios.toString());
                    errorFlag = true;
                }

                /**
                 * Todos los campos OK
                 */
                if (!errorFlag) {
                    Report.PASSED("Se visualizan todos los elementos en el menu Crear Campana");
                }
            }
        } catch (Exception e) {
            Report.FAILED("No se encontro el elemento " + btnCrearCampana.toString());
        }
    }

    public void validateSelectionMenuCreateCampaign() throws URISyntaxException, IOException {
        try {
            wu = new WaitUtils();
            if (wu.waitForElementVisible(btnCrearCampana.get(0))) {
                btnCrearCampana.get(0).click();
            } else {
                Report.FAILED("No se pudo dar click en menu Crear Campana");
            }
        } catch (Exception e) {
            Report.FAILED("Fallo la selección de menu. " + e.getMessage());
        }
    }

    public void buildCampaign(String titleCampaign, String dayInit, String monthInit, String yearInit,
                              String dayEnd, String monthEnd, String yearEnd, String reasonCampaign) throws URISyntaxException, IOException {
        try {
            Thread.sleep(1000);
            System.out.println("Campana prueba: " + LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());
            inputTituloCampana.sendKeys(LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());

            divDate.click();
            /**
             * Existe una forma en como se mueve el componente.
             * Es por eso el orden de los metodos.
             * */
            WorkWithDates wd = new WorkWithDates();
            String yearI = wd.getYear();
            String monthI = wd.getShortNameMonthEsp();
            String dayI = wd.getDay();
            System.out.println(wd.getAuxDate());
            wd.addDays(10);
            String yearE = wd.getYear();
            String monthE = wd.getShortNameMonthEsp();
            String dayE = wd.getDay();
            System.out.println(wd.getAuxDate());
            seleccionDelAnio(yearI);
            seleccionDelMes(monthI);
            seleccionDelDia(dayI);
            seleccionDelAnio(yearE);
            seleccionDelMes(monthE);
            seleccionDelDia(dayE);

            inputMotivo.click();
            inputMotivo.sendKeys(reasonCampaign);

            btnContinuar.click();
            System.out.println();
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de creacion de campana. " + e.getMessage());
        }
    }

    public void ingresarTituloCalendario() throws URISyntaxException, IOException {
        try {
            Thread.sleep(1000);
            System.out.println("Campana prueba: " + LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());
            inputTituloCampana.sendKeys(LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());

            divDate.click();
            /**
             * Existe una forma en como se mueve el componente.
             * Es por eso el orden de los metodos.
             * */
            WorkWithDates wd = new WorkWithDates();
            String yearI = wd.getYear();
            String monthI = wd.getShortNameMonthEsp();
            String dayI = wd.getDay();
            System.out.println(wd.getAuxDate());
            wd.addDays(10);
            String yearE = wd.getYear();
            String monthE = wd.getShortNameMonthEsp();
            String dayE = wd.getDay();
            System.out.println(wd.getAuxDate());
            seleccionDelAnio(yearI);
            seleccionDelMes(monthI);
            seleccionDelDia(dayI);
            seleccionDelAnio(yearE);
            seleccionDelMes(monthE);
            seleccionDelDia(dayE);

            System.out.println();
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de creacion de campana. " + e.getMessage());
        }
    }

    public void seleccionPromocion() throws URISyntaxException, IOException, InterruptedException {
        try {
            Thread.sleep(1000);

            inputTituloCampana.sendKeys(LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());

            divDate.click();
            /**
             * Existe una forma en como se mueve el componente.
             * Es por eso el orden de los metodos.
             * */
            WorkWithDates wd = new WorkWithDates();
            String yearI = wd.getYear();
            String monthI = wd.getShortNameMonthEsp();
            String dayI = wd.getDay();
            System.out.println(wd.getAuxDate());
            wd.addDays(10);
            String yearE = wd.getYear();
            String monthE = wd.getShortNameMonthEsp();
            String dayE = wd.getDay();
            System.out.println(wd.getAuxDate());
            seleccionDelAnio(yearI);
            seleccionDelMes(monthI);
            seleccionDelDia(dayI);
            seleccionDelAnio(yearE);
            seleccionDelMes(monthE);
            seleccionDelDia(dayE);

            String reasonCampaign = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891";
            inputMotivo.click();
            inputMotivo.sendKeys(reasonCampaign);

            btnContinuar.click();
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de creacion de campana. " + e.getMessage());
        }

        Thread.sleep(1500);

        try {
            wu = new WaitUtils();
            int[] kiloList = {2, 5, 11, 15, 45};
            String[] formatList = {"CN", "CS"};

            /**
             * Obtener opcion de kilo de forma aleatoria
             */
            int indiceAleatorio =  ThreadLocalRandom.current().nextInt(0, kiloList.length);
            int kilo = kiloList[indiceAleatorio];

            /**
             * Obtener opcion de formato de forma aleatoria
             */
            int indice =  ThreadLocalRandom.current().nextInt(0, formatList.length);
            String format = formatList[indice];

            int desc = (int) (Math.random() * 50000 + 1);//del 1 al 50.000

            switch (kilo) {
                case 2:
                    //2 kilos no tiene formato se utiliza la opcoon CN por default
                    checkCN2kg.click();
                    break;
                case 5:
                    if (format.toUpperCase().equals("CN")) {
                        SupportJsEvent.clickElement(checkCN5kg);
                        //completeForm(desc, kilo);
                    } else if (format.toUpperCase().equals("CS")) {
                        SupportJsEvent.clickElement(checkCS5kg);
                        //completeForm(desc, kilo);
                    }
                    break;
                case 11:
                    if (format.toUpperCase().equals("CN")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCN11kg);
                        //completeForm(desc, kilo);
                    } else if (format.toUpperCase().equals("CS")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCS11kg);
                        //completeForm(desc, kilo);
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
            Report.FAILED("Fallo al seleccionar la Promocion. " + e.getMessage());
        }

    }

    public void descuentoPorCilindro(int kilo) throws URISyntaxException, IOException, InterruptedException {

        Thread.sleep(1500);

        /**
         * Formato y tipo Cilindro
         */
        try {
            wu = new WaitUtils();
            int[] kiloList = {2, 5, 11, 15, 45};
            String[] formatList = {"CN", "CS"};

            /**
             * Obtener opcion de kilo de forma aleatoria
             */
            int indiceAleatorio =  ThreadLocalRandom.current().nextInt(0, kiloList.length);


            /**
             * Obtener opcion de formato de forma aleatoria
             */
            int indice =  ThreadLocalRandom.current().nextInt(0, formatList.length);
            String format = formatList[indice];

            String desc = String.valueOf((int) (Math.random() * 50000 + 1));//del 1 al 50.000
            ConfigCampana confcam = new ConfigCampana();

            switch (kilo) {
                case 2:
                    //2 kilos no tiene formato se utiliza la opcoon CN por default
                    confcam.ingresoDescuento(desc, kilo);
                    break;
                case 5:
                    confcam.ingresoDescuento(desc, kilo);
                    break;
                case 11:
                    confcam.ingresoDescuento(desc, kilo);
                    break;
                case 15:
                    confcam.ingresoDescuento(desc, kilo);
                    break;
                case 45:
                    confcam.ingresoDescuento(desc, kilo);
                    break;
                default:
                    Report.FAILED("Seleccione las opciones correctas. CLASS: ConfigCampana. ");
            }

        } catch (Exception e) {
            Report.FAILED("Fallo al seleccionar la Promocion. " + e.getMessage());
        }

    }

    public void opcionRestriccion(int kilo) throws URISyntaxException, IOException, InterruptedException {

        Thread.sleep(1500);

        /**
         * Formato y tipo Cilindro
         */
        try {
            wu = new WaitUtils();

            ConfigCampana confcam = new ConfigCampana();

            switch (kilo) {
                case 2:
                    //2 kilos no tiene formato se utiliza la opcoon CN por default
                    confcam.ingresoRestriccion(kilo);
                    break;
                case 5:
                    confcam.ingresoRestriccion(kilo);
                    break;
                case 11:
                    confcam.ingresoRestriccion(kilo);
                    break;
                case 15:
                    confcam.ingresoRestriccion(kilo);
                    break;
                case 45:
                    confcam.ingresoRestriccion(kilo);
                    break;
                default:
                    Report.FAILED("Seleccione las opciones correctas. CLASS: ConfigCampana. ");
            }

        } catch (Exception e) {
            Report.FAILED("Fallo al seleccionar la Promocion. " + e.getMessage());
        }

    }

    public void formatoTipoCombustible(int kilo) throws URISyntaxException, IOException, InterruptedException {
        try {
            Thread.sleep(1000);
            inputTituloCampana.sendKeys(LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());

            divDate.click();
            /**
             * Existe una forma en como se mueve el componente.
             * Es por eso el orden de los metodos.
             * */
            WorkWithDates wd = new WorkWithDates();
            String yearI = wd.getYear();
            String monthI = wd.getShortNameMonthEsp();
            String dayI = wd.getDay();
            System.out.println(wd.getAuxDate());
            wd.addDays(10);
            String yearE = wd.getYear();
            String monthE = wd.getShortNameMonthEsp();
            String dayE = wd.getDay();
            System.out.println(wd.getAuxDate());
            seleccionDelAnio(yearI);
            seleccionDelMes(monthI);
            seleccionDelDia(dayI);
            seleccionDelAnio(yearE);
            seleccionDelMes(monthE);
            seleccionDelDia(dayE);

            String reasonCampaign = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891";
            inputMotivo.click();
            inputMotivo.sendKeys(reasonCampaign);

            btnContinuar.click();
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de creacion de campana. " + e.getMessage());
        }

        Thread.sleep(1500);

        try {
            wu = new WaitUtils();
            String[] formatList = {"CN", "CS"};

            /**
             * Obtener opcion de formato de forma aleatoria
             */
            int indice =  ThreadLocalRandom.current().nextInt(0, formatList.length);
            String format = formatList[indice];

            String desc = String.valueOf((int) (Math.random() * 50000 + 1));//del 1 al 50.000
            ConfigCampana confcam = new ConfigCampana();

            switch (kilo) {
                case 2:
                    //2 kilos no tiene formato se utiliza la opcoon CN por default
                    checkCN2kg.click();
                    break;
                case 5:
                    if (format.toUpperCase().equals("CN")) {
                        SupportJsEvent.clickElement(checkCN5kg);
                        confcam.completeForm(desc, kilo);
                    } else if (format.toUpperCase().equals("CS")) {
                        SupportJsEvent.clickElement(checkCS5kg);
                        //completeForm(desc, kilo);
                    }
                    break;
                case 11:
                    if (format.toUpperCase().equals("CN")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCN11kg);
                        //completeForm(desc, kilo);
                    } else if (format.toUpperCase().equals("CS")) {
                        wu.scrollDown(contenedor);
                        SupportJsEvent.clickElement(checkCS11kg);
                        //completeForm(desc, kilo);
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
            Report.FAILED("Fallo al seleccionar la Promocion. " + e.getMessage());
        }

    }

    public void ingresarTituloMotivo() throws URISyntaxException, IOException {
        try {
            Thread.sleep(1000);
            System.out.println("Campana prueba: " + LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());
            inputTituloCampana.sendKeys(LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());

            divDate.click();
            /**
             * Existe una forma en como se mueve el componente.
             * Es por eso el orden de los metodos.
             * */
            WorkWithDates wd = new WorkWithDates();
            String yearI = wd.getYear();
            String monthI = wd.getShortNameMonthEsp();
            String dayI = wd.getDay();
            System.out.println(wd.getAuxDate());
            wd.addDays(10);
            String yearE = wd.getYear();
            String monthE = wd.getShortNameMonthEsp();
            String dayE = wd.getDay();
            System.out.println(wd.getAuxDate());
            seleccionDelAnio(yearI);
            seleccionDelMes(monthI);
            seleccionDelDia(dayI);
            seleccionDelAnio(yearE);
            seleccionDelMes(monthE);
            seleccionDelDia(dayE);

            String reasonCampaign = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891";
            inputMotivo.click();
            inputMotivo.sendKeys(reasonCampaign);

            System.out.println();
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de creacion de campana. " + e.getMessage());
        }
    }

    public void ingresarMotivoContinuar() throws URISyntaxException, IOException {
        try {
            Thread.sleep(1000);
            System.out.println("Campana prueba: " + LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());
            inputTituloCampana.sendKeys(LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());

            divDate.click();
            /**
             * Existe una forma en como se mueve el componente.
             * Es por eso el orden de los metodos.
             * */
            WorkWithDates wd = new WorkWithDates();
            String yearI = wd.getYear();
            String monthI = wd.getShortNameMonthEsp();
            String dayI = wd.getDay();
            System.out.println(wd.getAuxDate());
            wd.addDays(10);
            String yearE = wd.getYear();
            String monthE = wd.getShortNameMonthEsp();
            String dayE = wd.getDay();
            System.out.println(wd.getAuxDate());
            seleccionDelAnio(yearI);
            seleccionDelMes(monthI);
            seleccionDelDia(dayI);
            seleccionDelAnio(yearE);
            seleccionDelMes(monthE);
            seleccionDelDia(dayE);

            String reasonCampaign = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891";
            inputMotivo.click();
            inputMotivo.sendKeys(reasonCampaign);

            btnContinuar.click();

            System.out.println();
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de creacion de campana. " + e.getMessage());
        }
    }

    public void seleccionarTipoFinanciemiento() throws URISyntaxException, IOException {
        try {
            Thread.sleep(1000);
            System.out.println("Campana prueba: " + LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());
            inputTituloCampana.sendKeys(LoadProperty.DATA.getProperty("campananame") + getAlphaNumeric());

            divDate.click();
            /**
             * Existe una forma en como se mueve el componente.
             * Es por eso el orden de los metodos.
             * */
            WorkWithDates wd = new WorkWithDates();
            String yearI = wd.getYear();
            String monthI = wd.getShortNameMonthEsp();
            String dayI = wd.getDay();
            System.out.println(wd.getAuxDate());
            wd.addDays(10);
            String yearE = wd.getYear();
            String monthE = wd.getShortNameMonthEsp();
            String dayE = wd.getDay();
            System.out.println(wd.getAuxDate());
            seleccionDelAnio(yearI);
            seleccionDelMes(monthI);
            seleccionDelDia(dayI);
            seleccionDelAnio(yearE);
            seleccionDelMes(monthE);
            seleccionDelDia(dayE);

            String reasonCampaign = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891";
            inputMotivo.click();
            inputMotivo.sendKeys(reasonCampaign);

            btnContinuar.click();

            Thread.sleep(1500);

            System.out.println("Click en Tipo Financiamiento...");
            financiamiento.click();

            System.out.println();
        } catch (Exception e) {
            Report.FAILED("Fallo metodo de creacion de campana. " + e.getMessage());
        }
    }

    public void validateTituloCampana() throws URISyntaxException, IOException {
        try {
            Thread.sleep(1000);
            inputTituloCampana.sendKeys("este es un titulo de ejemplo qa para 50 caracteres");
            Report.PASSED("El titulo soporta 50 caracteres");
        } catch (Exception e) {
            Report.FAILED("Fallo el ingreso de titulo. " + e.getMessage());
        }
    }

    public void validateFechasCampana(String dayInit, String monthInit, String yearInit,
                                      String dayEnd, String monthEnd, String yearEnd) throws URISyntaxException, IOException {
        try {
            Thread.sleep(1000);
            divDate.click();
            seleccionDelAnio(yearInit);
            seleccionDelMes(monthInit);
            seleccionDelDia(dayInit);
            seleccionDelAnio(yearEnd);
            seleccionDelMes(monthEnd);
            seleccionDelDia(dayEnd);
            Report.PASSED("Las fechas fueron ingresadas sin problemas");
        } catch (Exception e) {
            Report.FAILED("Fallo el ingreso de fechas. " + e.getMessage());
        }
    }

    public void validateMotivoCampana(String reasonCampaign) throws URISyntaxException, IOException {
        try {
            Thread.sleep(1000);
            inputMotivo.click();
            inputMotivo.sendKeys(reasonCampaign);
            Report.PASSED("El motivo fue ingresado sin problemas");
        } catch (Exception e) {
            Report.FAILED("Fallo el ingreso de motivo. " + e.getMessage());
        }
    }

    public void validateTextCrearCampana() throws URISyntaxException, IOException {

        boolean errorFlag = false;

        try {
            wu = new WaitUtils();
            int i = 0;
            if (!wu.waitForElementVisible(btnCrearCampana.get(0))) {

                btnCrearCampana.get(0).click();

                if (!LoadProperty.TEXT_VALIDATION.getProperty("title_build_campaign").equals(txtTituloCrearCampana.get(0).getText())) {
                    Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("title_build_campaign") +
                            "\n y se visualiza: " + txtTituloCrearCampana.get(0).getText());
                    errorFlag = true;
                }

                if (!LoadProperty.TEXT_VALIDATION.getProperty("subtitle_build_campaign").equals(txtSubtituloCrearCampana.get(1).getText())) {
                    Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("subtitle_build_campaign") +
                            "\n y se visualiza: " + txtSubtituloCrearCampana.get(1).getText());
                    errorFlag = true;
                }

                if (!LoadProperty.TEXT_VALIDATION.getProperty("step_one_title").equals(txtStep1Titulo.get(2).getText())) {
                    Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("step_one_title") +
                            "\n y se visualiza: " + txtStep1Titulo.get(2).getText());
                    errorFlag = true;
                }

                if (!LoadProperty.TEXT_VALIDATION.getProperty("step_one_subtitle").equals(txtStep1Subtitulo.get(3).getText())) {
                    Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("step_one_subtitle") +
                            "\n y se visualiza: " + txtStep1Subtitulo.get(3).getText());
                    errorFlag = true;
                }

                String txtInput1 = txtInputTituloCampana.getText();
                if (!LoadProperty.TEXT_VALIDATION.getProperty("input_title_campaign").equals(txtInput1)) {
                    Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("input_title_campaign") +
                            "\n y se visualiza: " + txtInput1);
                    errorFlag = true;
                }

                String txtInput2 = txtInputVigenciaCampana.getText();
                if (!LoadProperty.TEXT_VALIDATION.getProperty("input_vigency_campaign").equals(txtInput2)) {
                    Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("input_vigency_campaign") +
                            "\n y se visualiza: " + txtInput2);
                    errorFlag = true;
                }

                String txtInput3 = txtInputMotivoCampana.getText();
                if (!LoadProperty.TEXT_VALIDATION.getProperty("input_reason_campaign").equals(txtInput3)) {
                    Report.FAILED("Se esperaba: " + LoadProperty.TEXT_VALIDATION.getProperty("input_reason_campaign") +
                            "\n y se visualiza: " + txtInput3);
                    errorFlag = true;
                }

                if (!errorFlag) {
                    Report.PASSED("Se visualizan todos los textos en el menu Crear Campana");
                }
            }
        } catch (Exception e) {
            Report.FAILED("No se encontró el elemento " + btnCrearCampana.toString());
        }
    }


    /**
     * La seleccion del dia va desde el 1 al 31, dependiendo del mes que se escoja.
     * El dia que se escoja, debe ser igual o mayor al dia de la fecha en que se realiza la prueba
     */
    private void seleccionDelDia(String dia) {
        List<WebElement> listTr = Browser.getDriver().findElements(By.xpath("//tr[contains(@class, 'ng-star-inserted')]"));
        //Por cada tr, tenemos una lista de tds
        List<WebElement> listTd;
        for (WebElement element : listTr) {
            listTd = element.findElements(By.tagName("td"));
            for (WebElement webElement : listTd) {
                if (webElement.getText().equals(dia)) {
                    webElement.click();
                    return;
                }
            }
        }
    }

    /**
     * El mes posee un formato que es por las 3 primeras letras del mes.
     * Del mismo modo se utilizara.
     * El mes debe ser ingresado con sus 3 primeras letras.
     */
    private void seleccionDelMes(String mes) {
        if (!mes.contains(".")) {
            mes = mes + ".";
        }

        List<WebElement> listTr = Browser.getDriver().findElements(By.xpath("//tr[contains(@class, 'ng-star-inserted')]"));
        //Por cada tr, tenemos una lista de tds
        List<WebElement> listTd;
        for (WebElement element : listTr) {
            listTd = element.findElements(By.tagName("td"));
            for (WebElement webElement : listTd) {
                if (webElement.getText().equals(mes.toUpperCase())) {
                    webElement.click();
                    return;
                }
            }
        }


    }

    /**
     * El año posee una lista de años disponibles.
     * Idealmente siempre hay que escojer hacia adelante.
     * Hay desde el 2022 ah 2045 disponible para utilizar.
     * Los años se ingresan con sus 4 caracteres.
     */
    private void seleccionDelAnio(String anio) {
        WebElement btnAnio = Browser.getDriver().findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-calendar-period-button mat-button mat-button-base')]"));
        btnAnio.click();

        List<WebElement> listTr = Browser.getDriver().findElements(By.xpath("//tr[contains(@class, 'ng-star-inserted')]"));
        //Por cada tr, tenemos una lista de tds
        List<WebElement> listTd;
        for (WebElement element : listTr) {
            listTd = element.findElements(By.tagName("td"));
            for (WebElement webElement : listTd) {
                if (webElement.getText().equals(anio)) {
                    webElement.click();
                    return;
                }
            }
        }

    }

    public void getDataDriven(String flag) throws SQLException {

        PgSql pg = new PgSql();
        System.out.println("Obtener Sap de Usuario Random...");
        String sap = pg.getRandomSapUser();
        System.out.println("El SAP encontrado es: " + sap);
    }
}
