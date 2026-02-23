Feature: Registro

  Background: Precondicion
    Given Navego a la pagina de "register"

  Scenario: Verificar UI registro
    Then Verifico el estado inicial de la pagina de registro

  Scenario: Checkboxes
    When Selecciono los botones de preferencias
    Then Verifico que los botones esten seleccionados


  Scenario Outline: Verificar seleccion semanal
    When Selecciono el boton "<nombre>"
    Then Verifico que el boton este seleccionado
    Examples:
      | nombre      |
      | Diario      |
      | semanal     |
      | Mensual     |
      | videojuegos |
