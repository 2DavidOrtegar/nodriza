Feature: Promocion y Cupones

  Background: Ingresar a la url de mi campania y Login
    Given Mi Campania
    When open BrowserStack Chrome
    Then validar elementos login mi campana
    And validar las credenciales del login

  @RegressionMiddle
  Scenario: CMPN-TC-17 Tipo de Promocion
    And validar elementos del menu crear campana
    Then Validar seleccion de Promocion

  @RegressionMiddle
  Scenario: CMPN-TC-18 Tipo Financiamiento
    And validar elementos del menu crear campana
    Then Validar Tipo Financiamiento

  @RegressionMiddle
  Scenario: CMPN-TC-26 Descuento por cilindro
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido

  @RegressionMiddle
  Scenario: CMPN-TC-27 Restricción de Campaña
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido
    And Seleccionar una opcion del listbox
    And Hacer Click  en el boton continuar

  @RegressionMiddle
  Scenario: CMPN-TC-36 Busqueda de DI
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido
    And Seleccionar una opcion del listbox
    And Hacer Click  en el boton continuar
    And Hacer Click en el campo distribuidor
    And Ingresar un nombre de distribuidor valido

  @RegressionMiddle
  Scenario: CMPN-TC-37 Busqueda de DI
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido
    And Seleccionar una opcion del listbox
    And Hacer Click  en el boton continuar
    And Hacer Click en el campo distribuidor
    And Ingresar un sap de distribuidor valido

  @RegressionMiddle
  Scenario: CMPN-TC-255 Busqueda de DI
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido
    And Seleccionar una opcion del listbox
    And Hacer Click  en el boton continuar
    And Hacer Click en el campo distribuidor
    And Ingresar un nombre de distribuidor valido
    And Ingresar en numero de cupones
    And Subir archivo de distribuidor
    And Seleccionar un DI que ya esta ingresado en la campania
    And Hacer Click en el campo de DI

  @RegressionMiddle
  Scenario: CMPN-TC-43 Busqueda de DI
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido
    And Seleccionar una opcion del listbox
    And Hacer Click  en el boton continuar
    And Ingresar en el campo Nombre de fantasia menos de cincuenta caracteres

  @RegressionMiddle
  Scenario: CMPN-TC-46 N° Cupones
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido
    And Seleccionar una opcion del listbox
    And Hacer Click  en el boton continuar
    And Ingresar en el campo Nombre de fantasia caracteres especiales
    And Ingresar en numero de cupones

  @RegressionHigh
  Scenario: CMPN-TC-56 Subir Archivo
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido
    And Seleccionar una opcion del listbox
    And Hacer Click  en el boton continuar
    And Ingresar en el campo Nombre de fantasia caracteres especiales
    And Ingresar en numero de cupones
    And Subir archivo con clientes

  @RegressionHigh
  Scenario: CMPN-TC-66 Boton descargar archivo
    And validar elementos del menu crear campana
    And Seleccionar el Formato y tipo de combustible
    And En el campo Descuento Gasco x Cilindro, ingresar un valor permitido
    And Seleccionar una opcion del listbox
    And Hacer Click  en el boton continuar
    And Hacer Click en el campo distribuidor
    And Ingresar un nombre de distribuidor valido
    And Ingresar en el campo Nombre de fantasia caracteres especiales
    And Ingresar en numero de cupones
    And Subir archivo con clientes
    And Ingresar en el campo numero de telefono de distribuidor
    And Hacer click en boton aceptar
