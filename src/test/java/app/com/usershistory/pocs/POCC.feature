Feature: Promocion y Cupones

 # Background: Ingresar a la url de mi campania y Login
 #   Given Mi Campania
  #  When open BrowserStack Chrome
   # Then validar elementos login mi campana
    #And validar las credenciales del login

  #Scenario: 00
    #Given open localDevice
    #Then aprobado


  Scenario: 01
    Given open iphone
    Then aprobado

  Scenario: 02
   Given open iphone 8
    Then aprobado

  Scenario: 03
   Given open iphone 11
    Then aprobado

  Scenario: 04
   Given open iphone 11pro
    Then aprobado

  Scenario: 05
   Given open iphone 12
    Then aprobado

  Scenario: 06
   Given open Samsung
    Then aprobado

  Scenario: 07
  Given open Samsung s20
    Then aprobado

  Scenario: 08
   Given open Samsung s21
    Then reprobado

  Scenario: 09
   Given open Samsung s23
    Then aprobado

  Scenario: 10
   Given open Samsung note 8
    Then iniciar sesion
    Then aprobado




