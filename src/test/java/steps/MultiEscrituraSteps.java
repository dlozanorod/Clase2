package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.function.Try;
import org.openqa.selenium.*;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logs;

import java.time.Duration;
import java.util.List;

public class MultiEscrituraSteps {
    private WebDriver driver;

    public MultiEscrituraSteps(World world) {
        driver = world.driver;
    }

    @When("Completo el formulario escribiendo en ambos inputs {string}")
    public void completoElFormularioEscribiendoEnAmbosInputs(String texto) {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //podría utilizat var en lugar de By, solamente me indica la ubicación, la ruta
        By botonSubmit = By.cssSelector("button[type='submit']");


        Logs.info("Escribiendo en el formulario");
        //var inputs = driver.findElements(By.cssSelector("input[type='text']"));
        List<WebElement> inputs = driver.findElements(By.cssSelector("input[type='text']"));

        for (var input : inputs) {
            input.clear();
            input.sendKeys(texto);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Logs.info("Haciendo click en el botón");
        driver.findElement(By.xpath("//button[text()='Validar']")).click();

    }

    @Then("Verifico que salga el mensaje {string}")
    public void verificoQueSalgaElMensaje(String mensajeEsperado) {
        final var texto = driver.findElement(By.className("lead"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(texto.isDisplayed()),
                () -> Assertions.assertEquals(mensajeEsperado, texto.getText())
        );

    }
}
