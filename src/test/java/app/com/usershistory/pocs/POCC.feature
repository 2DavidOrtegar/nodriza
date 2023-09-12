Feature: POC Automatizacion

 # Background: Ejemplo del inicio del test repetitivo
 #   Given iniciar el flujo
  #  When ocurre algo
   # Then validamos el titulo
    #And corroboramos el color azul del link

  Scenario Outline: 01
    Given open iphone
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut      |
      | 74391028 |

  Scenario Outline: 02
    Given open iphone 8
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut       |
      | 243947154 |

  Scenario Outline: 03
    Given open iphone XR
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut       |
      | 172704743 |

  Scenario Outline: 04
    Given open iphone 11
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut       |
      | 290586550 |

  Scenario Outline: 05
    Given open iphone 11pro
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut       |
      | 141741926 |

  Scenario Outline: 06
    Given open iphone 12
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut       |
      | 12227649K |

  Scenario Outline: 07
    Given open Samsung
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut      |
      | 92969045 |

  Scenario Outline: 08
    Given open Samsung s20
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut       |
      | 252131299 |

  Scenario Outline: 09
    Given open Samsung s21
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut       |
      | 269861665 |

  Scenario Outline: 10
    Given open Samsung s23
    Then iniciar sesion
    Then ingreso de ruts <rut>
    And ingreso contrasenia

    Examples: Datos de prueba
      | rut      |
      | 94193567 |