package steps;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;

import javax.swing.*;

public class LoginSteps {
    private final WebDriver driver;
    private final String tituloLogin = "Login";
    private final String tituloExitoso = "Login Exitoso";

    public LoginSteps(World world) {
        this.driver = world.driver;
    }


    @When("Completo el formulario de login con el user {string} y el password {string}")
    public void completoElFormularioDeLoginConElUserYElPassword(String user, String pass) {
        Logs.info("Escribo el username");
        driver.findElement(By.id("username-input")).sendKeys(user);
        Logs.info("Escribo el password");
        driver.findElement(By.id("password-input")).sendKeys(pass);
        Logs.info("Hago click en el botón de login");
        if (driver.findElement(By.cssSelector("Button[Type='submit']")).isEnabled()) {
            driver.findElement(By.cssSelector("Button[Type='submit']")).click();
        } else {
            System.out.println("Botón inhabilitado");
        }


    }

    @Then("Verifico que el mensaje de error sea {string}")
    public void verificoQueElMensajeDeErrorSea(String mensajeError) {

        final var mensaje = driver.findElement(By.cssSelector("div[role='alert']"));

        Logs.info("Verificando el mensaje de error");

        Assertions.assertAll(
                () -> Assertions.assertTrue(mensaje.isDisplayed()),
                () -> Assertions.assertEquals(mensajeError, mensaje.getText())
        );

    }

    @Then("Verifico la UI de la pagina de Login")
    public void verificoLaUIDeLaPaginaDeLogin() {

        final var inputUser = driver.findElement(By.id("username-input"));
        final var inputPass = driver.findElement(By.id("password-input"));
        final var btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        final var titulo = driver.findElement(By.className("blass-title"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(inputUser.isDisplayed()),
                () -> Assertions.assertTrue(inputUser.isEnabled()),
                () -> Assertions.assertTrue(inputPass.isDisplayed()),
                () -> Assertions.assertTrue(inputPass.isEnabled()),
                () -> Assertions.assertTrue(btnLogin.isDisplayed()),
                () -> Assertions.assertFalse(btnLogin.isEnabled()),
                () -> Assertions.assertTrue(titulo.isDisplayed()),
                () -> Assertions.assertEquals(tituloLogin, titulo.getText())

        );
    }

    @Then("Verifico la UI de la pagina de Login exitoso")
    public void verificoLaUIDeLaPaginaDeLoginExitoso() {

        final var titulo = driver.findElement(By.className("blass-title"));
        final var descripcion = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main/div/div/p"));
        final var btnLogout = driver.findElement(By.xpath("//button[text()='Logout']"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(titulo.isDisplayed()),
                () -> Assertions.assertEquals(tituloExitoso,titulo.getText()),
                () -> Assertions.assertTrue(descripcion.isDisplayed()),
                () -> Assertions.assertTrue(btnLogout.isEnabled()),
                () -> Assertions.assertTrue(btnLogout.isDisplayed())
        );

    }

    @When("Hago click en el botón de logout")
    public void hagoClickEnElBotónDeLogout() {
        Logs.info("Click en el botón de logout");
        driver.findElement(By.xpath("//button[text()='Logout']")).click();
    }
}
