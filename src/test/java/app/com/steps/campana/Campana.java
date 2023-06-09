package app.com.steps.campana;

import app.pages.campana.login.LoginCampana;
import app.pages.campana.pricipalpage.consultacampana.ConsultaCampana;
import app.pages.campana.pricipalpage.crearcampana.ConfigCampana;
import app.pages.campana.pricipalpage.crearcampana.CrearCampana;
import app.pages.campana.pricipalpage.crearcampana.RelacionCupones;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class Campana {

    LoginCampana lc;
    CrearCampana cc;
    ConsultaCampana cons;
    ConfigCampana confcam;
    RelacionCupones recu;

    public static int formatoCilindro;
    @Then("^validar elementos login mi campana$")
    public void validarElementosLoginMiCampana() throws URISyntaxException, IOException, InterruptedException {
        lc = new LoginCampana();
        lc.validateElements();
    }
    @And("^validar las credenciales del login$")
    public void validarLasCredencialesDelLogin() throws URISyntaxException, IOException {
        lc = new LoginCampana();
        lc.ingresoLogin();
    }
    @When("^validar malas credenciales del login$")
    public void validarMalasCredencialesDelLogin() throws URISyntaxException, IOException {
        lc = new LoginCampana();
        lc.falloLogin();
    }
    @And("^validar elementos del menu crear campana$")
    public void validarElementosDelMenuCrearCampana() throws URISyntaxException, IOException, InterruptedException {
        cc = new CrearCampana();
        Thread.sleep(1000);
        cc.validateElementsCrearCampana();
    }
    @Then("^validar textos del menu crear campana$")
    public void validarTextosDelMenuCrearCampana() throws URISyntaxException, IOException {
        cc = new CrearCampana();
        cc.validateTextCrearCampana();
    }
    @Then("^validar textos del menu configurar campana$")
    public void validarTextosDelMenuConfigurarCampana() throws URISyntaxException, IOException {
        confcam = new ConfigCampana();
        confcam.validateTextConfigCampana();
    }
    @And("^validar textos del menu relacion de cupones$")
    public void validarTextosDelMenuRelacionDeCupones() throws URISyntaxException, IOException {
        recu = new RelacionCupones();
        recu.validateTextRelacionCupones();
    }
    @Then("build Campaign {word} {word} {word} {word} {word} {word} {word}")
    public void buildCampaign(String titleCampaign, String dayInit, String monthInit, String yearInit,
                              String dayEnd, String monthEnd, String yearEnd) throws URISyntaxException, IOException {
        cc = new CrearCampana();
        String reasonCampaign = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891";
        cc.buildCampaign(titleCampaign, dayInit, monthInit, yearInit, dayEnd, monthEnd, yearEnd, reasonCampaign);
    }

    @Then("^Validar ingreso de titulo y calendario$")
    public void validarIngresoTituloyCalendario() throws URISyntaxException, IOException {
        cc = new CrearCampana();
        cc.ingresarTituloCalendario();
    }

    @And("Prueba DataDriven {string}")
    public void pruebaDataDriven(String flag) throws URISyntaxException, IOException, SQLException {
        cc = new CrearCampana();
        cc.getDataDriven(flag);
    }

    @Then("^Validar seleccion de Promocion$")
    public void validarSeleccionPromocion() throws URISyntaxException, IOException, InterruptedException {
        cc = new CrearCampana();
        cc.seleccionPromocion();
    }

    @And("^En el campo Descuento Gasco x Cilindro, ingresar un valor permitido$")
    public void validarDescuentoCilindro() throws URISyntaxException, IOException, InterruptedException {
        cc = new CrearCampana();
        cc.descuentoPorCilindro(formatoCilindro);
    }

    @And("^Seleccionar una opcion del listbox$")
    public void seleccionarOpcionRestriccion() throws URISyntaxException, IOException, InterruptedException {
        cc = new CrearCampana();
        cc.opcionRestriccion(formatoCilindro);
    }

    @And("^Hacer Click  en el boton continuar$")
    public void clickContinuar() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.ContinuarCreacion();
    }

    @And("^Hacer Click en el campo distribuidor$")
    public void clickEnCampoDistribuidor() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.clickCampoDistribuidor();
    }

    @And("^Ingresar en el campo Nombre de fantasia menos de cincuenta caracteres$")
    public void ingresarCampoNombreFantasia() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.validacionIngresoNombreFantasia();
    }

    @And("^Ingresar en el campo Nombre de fantasia caracteres especiales$")
    public void ingresarCampoNombreFantasiaCaracteresEspeciales() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.validacionIngresoNombreFantasiaCaracteresEspeciales();
    }

    @And("^Ingresar en numero de cupones$")
    public void ingresarNumeroCuponesDistribuidor() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.validacionIngresoNumeroCupones();
    }

    @And("^Subir archivo con clientes$")
    public void subirArchivoConClientes() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.subirArchivoCliente();
    }

    @And("^Ingresar en el campo numero de telefono de distribuidor$")
    public void ingresarNumeroTelefono() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.ingresarNumeroTelefonoDistribuidor();
    }

    @And("^Hacer click en boton aceptar$")
    public void clickBotonAceptar() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.clickbtnAceptar();
    }

    @And("^Ingresar un nombre de distribuidor valido$")
    public void ingresarNombreDistribuidorValido() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.ingresarNombreDistribuidor();
    }

    @And("^Subir archivo de distribuidor$")
    public void subirArchivoDistribuidor() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.subirArchivoDi();
    }

    @And("^Hacer Click en el campo de DI$")
    public void hacerClickCampoDi() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.clickCampoDi();
    }

    @And("^Ingresar un sap de distribuidor valido$")
    public void ingresarSapDistribuidorValido() throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.ingresarSapDistribuidor();
    }

    @Then("^Seleccionar el Formato y tipo de combustible$")
    public void seleccionarFormatoTipoCombustible() throws URISyntaxException, IOException, InterruptedException {
        int[] kiloList = {2, 5, 11, 15};

        /**
         * Obtener opcion de kilo de forma aleatoria
         */
        int indiceAleatorio =  ThreadLocalRandom.current().nextInt(0, kiloList.length);
        int kilo = kiloList[indiceAleatorio];
        formatoCilindro = kilo;
        System.out.println("Kilo seleccionado: " + kilo);
        cc = new CrearCampana();
        cc.formatoTipoCombustible(formatoCilindro);
    }

    @Then("^Validar ingreso de titulo y motivo$")
    public void validarIngresoTituloyMotivo() throws URISyntaxException, IOException {
        cc = new CrearCampana();
        cc.ingresarTituloMotivo();
    }

    @And("^Validar ingreso motivo y continuar$")
    public void validarIngresoMotivoContinuar() throws URISyntaxException, IOException {
        cc = new CrearCampana();
        cc.ingresarMotivoContinuar();
    }

    @And("^Validar Tipo Financiamiento$")
    public void validarTipoFinanciamiento() throws URISyntaxException, IOException {
        cc = new CrearCampana();
        cc.seleccionarTipoFinanciemiento();
    }
    @Then("^validar el largo maximo del titulo campana$")
    public void validarElLargoMaximoDelTituloCampana() throws URISyntaxException, IOException {
        cc = new CrearCampana();
        cc.validateTituloCampana();
    }
    @Then("^validar elementos del menu consulta campana$")
    public  void validarElementosDelMenuConsultaCampana() throws URISyntaxException, IOException {
        cons = new ConsultaCampana();
        cons.validateElementsConsultaCampana();
    }
    @Then("^validar elementos del menu configurar campana$")
    public void validarElementosDelMenuConfigurarCampana() throws URISyntaxException, IOException {
        confcam = new ConfigCampana();
        confcam.validateElementsConfigCampana();
    }
    @And("^validar elementos del menu relacion de cupones$")
    public void validarElementosDelMenuRelacionDeCupones() throws URISyntaxException, IOException, InterruptedException {
        recu = new RelacionCupones();
        recu.validateElementsRelacionCupones();
        recu.completeCouponRelation();
    }

    @And("select Format Cylinder {int} {word} {word}")
    public void selectFormatCylinderKiloFormatAmountDesc(int kilo, String format, String desc) throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.configurationFormatDescRestrictions(kilo, format, desc);
        confcam.ContinuarCreacion();
    }

    @Then("validar ingreso de fechas para campana {word} {word} {word} {word} {word} {word}")
    public void validarIngresoDeFechasParaCampana(String dayInit, String monthInit, String yearInit,
                                                  String dayEnd, String monthEnd, String yearEnd) throws URISyntaxException, IOException {
        cc = new CrearCampana();
        cc.validateFechasCampana(dayInit, monthInit, yearInit, dayEnd, monthEnd, yearEnd);

    }
    @Then("validar ingreso permitido de caracteres para motivo")
    public void validarIngresoPermitidoDeCaracteresParaMotivo() throws URISyntaxException, IOException {
        cc = new CrearCampana();
        String reasonCampaign = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891";
        cc.validateMotivoCampana(reasonCampaign);
    }
    @And("Seleccionar menu crear campana")
    public void seleccionarMenuCrearCampana() throws URISyntaxException, IOException {
        cc = new CrearCampana();
        cc.validateSelectionMenuCreateCampaign();
    }
    @Then("validar seleccion del tipo de promocion")
    public void validarSeleccionDelTipoDePromocion() throws URISyntaxException, IOException {
        confcam = new ConfigCampana();
        confcam.validateElementTipePromotion();
    }
    @Then("validar seleccion del tipo de financiamiento")
    public void validarSeleccionDelTipoDeFinanciamiento() throws URISyntaxException, IOException {
        confcam = new ConfigCampana();
        confcam.validateElementTipeFinan();
    }

    @And("seleccionar formato y descuento {int} {word} {word}")
    public void seleccionarFormatoYDescuentoKiloFormatAmountDesc(int kilo, String format, String desc) throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.configFormatDesc(kilo, format, desc);
    }
    @And("validar seleccion de restriccion al descuento ingresado")
    public void validarSeleccionDeRestriccionAlDescuentoIngresado(int kilo, String format, String desc) throws URISyntaxException, IOException, InterruptedException {
        confcam = new ConfigCampana();
        confcam.completeForm(desc, kilo);
        confcam.ContinuarCreacion();
    }

    @And("Seleccionar menu consulta campana")
    public void seleccionarMenuConsultaCampana() throws URISyntaxException, IOException {
        cons = new ConsultaCampana();
        cons.ingresoMenuConsultaCampana();
    }

    @Then("Validar ingreso de caracteres en minuscula para buscar campana {word}")
    public void validarIngresoDeCaracteresEnMinusculaParaBuscarCampana(String NomCamp) throws URISyntaxException, IOException {
        cons = new ConsultaCampana();
        cons.validateBuscarCampana(NomCamp);
    }

    @Then("Validar busqueda de DI por estado vigente")
    public void validarBusquedaDeDIPorEstadoVigente() throws URISyntaxException, IOException {
        cons = new ConsultaCampana();
        cons.validateCampanaVigente();
    }

    @Then("Validar seleccion de flecha up en el ordenamiento por fecha termino")
    public void validarSeleccionDeFlechaUpEnElOrdenamientoPorFechaTermino() throws URISyntaxException, IOException {
        cons = new ConsultaCampana();
        cons.validateOrdenarFechas();
    }

    @Then("Validar seleccion de boton generar")
    public void validarSeleccionDeBotonGenerar() throws URISyntaxException, IOException {
        cons = new ConsultaCampana();
        cons.generateReport();
    }

    @Then("Validar descarga de excel en reporte generado")
    public void validarDescargaDeExcelEnReporteGenerado() throws URISyntaxException, IOException {
        cons = new ConsultaCampana();
        cons.downloadReport();
    }
}
