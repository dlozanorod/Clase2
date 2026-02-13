Feature: Login

  Scenario: Login erroneo
    Given un usuario intenta logearse
    When proporcione credenciales erroneas
    Then se le mostrara un mensaje de error