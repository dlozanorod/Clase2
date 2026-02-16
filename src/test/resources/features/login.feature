Feature: Login

  Background: Precondicion
    Given Navego a la pagina de "login"

  Scenario: Credenciales incorrectas
    When Completo el formulario de login con el user "hola" y el password "chau"
    Then Verifico que el mensaje de error sea "Usuario o clave incorrectos. Intente de nuevo."


  Scenario: Verificar la UI
    Then Verifico la UI de la pagina de Login

  Scenario: Login exitoso
    When Completo el formulario de login con el user "blass_academy" y el password "web_blass"
    Then Verifico la UI de la pagina de Login exitoso

  Scenario: Logout
    Given Completo el formulario de login con el user "blass_academy" y el password "web_blass"
    When Hago click en el botón de logout
    Then Verifico la UI de la pagina de Login