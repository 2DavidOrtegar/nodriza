Feature: Promocion y Cupones

  Background: Ingresar a la url de mi campania y Login
    Given Mi Campania
    When open BrowserStack Chrome
    Then validar elementos login mi campana
    And validar las credenciales del login

  @RegressionMiddle
  Scenario: CMPN-TC-222 Busqueda QR DI, por codigo SAP
    Then Ingresar modulo QR
    And Ingresar codigo SAP y Click en Buscar

  @RegressionMiddle
  Scenario: CMPN-TC-235 Generar QR
    Then Ingresar modulo QR
    And Ingresar codigo SAP y Click en Buscar
    And Click en boton generar codigo QR

  @RegressionMiddle
  Scenario: CMPN-TC-232 - Descargar QR
    Then Ingresar modulo QR
    And Ingresar codigo SAP y Click en Buscar
    And Click en boton generar codigo QR
    And Click en boton Descargar
