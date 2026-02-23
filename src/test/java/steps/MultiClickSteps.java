package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;

public class MultiClickSteps {
    private WebDriver driver;

    public MultiClickSteps(World world) {
        driver = world.driver;
    }


    @When("Verifico el contador debe ser {int}")
    public void verificoElContadorDebeSer(int contadorEsperado) {

        var contador = driver.findElement(By.id("counter"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(contador.isDisplayed()),
                () -> Assertions.assertEquals(String.valueOf(contadorEsperado), contador.getText())
        );
    }

    @Then("Los botones deben ser {int} y decir cada uno {string}")
    public void losBotonesDebenSerYDecirCadaUno(int cantidadEsperada, String textoEsperado) {

        var botones = driver.findElements(By.xpath("//button[text()='Hazme Click!']"));

        Logs.info("Verificar las cantidades");
        Assertions.assertEquals(cantidadEsperada, botones.size());
        //System.out.println("Cantidad Esperada: " + cantidadEsperada + " Cantidad existente: " + botones.size());

        Logs.info("Verificar que los textos sean iguales");
        for (var boton : botones) {
            Assertions.assertEquals(textoEsperado, boton.getText());
            System.out.println(textoEsperado + " + " + boton.getText());
        }

    }

    @Then("Hago click en todos los botones")
    public void hagoClickEnTodosLosBotones() {
        var location = By.xpath("//button[text()='Hazme Click!']");
        var botones = driver.findElements(location);

        for (var boton : botones) {
            boton.click();
        }
    }

    @And("Verifico que los botones digan {string}")
    public void verificoQueLosBotonesDigan(String mensajeEsperado) {
        var location = By.className("clickable-item");
        var botones = driver.findElements(location);

        for (var boton : botones) {
            Assertions.assertEquals(mensajeEsperado, boton.getText());
            System.out.println(mensajeEsperado + " + " + boton.getText());
        }


    }
}
