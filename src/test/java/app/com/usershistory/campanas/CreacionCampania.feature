Feature: Creacion Campania

  Background: Ingresar a la url de mi campania y Login
    Given Mi Campania
    When open BrowserStack Chrome
    Then validar elementos login mi campana
    And validar las credenciales del login

  @RegressionMiddle
  Scenario: CMPN-TC-5 Titulo de Mi Campania
    And validar elementos del menu crear campana
    Then Validar ingreso de titulo y calendario

  @RegressionMiddle
  Scenario: CMPN-TC-9 Vigencia de campania
    And validar elementos del menu crear campana
    Then Validar ingreso de titulo y motivo

  @RegressionMiddle
  Scenario: CMPN-TC-13 Motivo de campania
    And validar elementos del menu crear campana
    And Validar ingreso motivo y continuar
