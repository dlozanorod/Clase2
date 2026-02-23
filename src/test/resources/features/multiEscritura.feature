Feature: Multiescritura

  Background: Precondicion
    Given Navego a la pagina de "multi-write"

  Scenario: Inputs iguales
    When Completo el formulario escribiendo en ambos inputs "David"
    Then Verifico que salga el mensaje "Son Iguales"