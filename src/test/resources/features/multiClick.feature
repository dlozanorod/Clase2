Feature: Multi click

  Background: Precondicion
    Given Navego a la pagina de "multi-click"

  Scenario: Verificar textos
    When Verifico el contador debe ser 0
    Then Los botones deben ser 9 y decir cada uno "Hazme Click!"

  Scenario: Clickear todos los botones y verificar cantidad y textos
    Then Hago click en todos los botones
    And Verifico el contador debe ser 9
    And Verifico que los botones digan "Gracias!"