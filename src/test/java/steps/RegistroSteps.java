package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Logs;

import java.util.List;

public class RegistroSteps {
    private final WebDriver driver;
    private String frec;
    private List<WebElement> opciones;

    public RegistroSteps(World world) {
        driver = world.driver;
    }


    @Then("Verifico el estado inicial de la pagina de registro")
    public void verificoElEstadoInicialDeLaPaginaDeRegistro() {
        Logs.info("Verificando el estado inicial de la pagina ");

        final var checkboxDeportes = driver.findElement(By.id("deportes"));
        final var checkboxVideojuegos = driver.findElement(By.id("videojuegos"));
        final var checkboxPeliculas = driver.findElement(By.id("peliculas"));
        final var checkboxLibros = driver.findElement(By.id("libros"));

        final var radioDiario = driver.findElement(By.id("diario"));
        final var radioSemanal = driver.findElement(By.id("semanal"));
        final var radioMensual = driver.findElement(By.id("mensual"));

        final var botonRegistro = driver.findElement(By.cssSelector("button[type='submit']"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(checkboxDeportes.isDisplayed(), "Checkbox deportes correcto"),
                () -> Assertions.assertFalse(checkboxDeportes.isSelected(), "Checkbox deportes deseleccionado"),
                () -> Assertions.assertTrue(checkboxVideojuegos.isDisplayed()),
                () -> Assertions.assertFalse(checkboxVideojuegos.isSelected()),
                () -> Assertions.assertTrue(checkboxPeliculas.isDisplayed()),
                () -> Assertions.assertFalse(checkboxPeliculas.isSelected()),
                () -> Assertions.assertTrue(checkboxLibros.isDisplayed()),
                () -> Assertions.assertFalse(checkboxLibros.isSelected()),

                () -> Assertions.assertTrue(radioDiario.isDisplayed()),
                () -> Assertions.assertFalse(radioDiario.isSelected()),
                () -> Assertions.assertTrue(radioSemanal.isDisplayed()),
                () -> Assertions.assertFalse(radioSemanal.isSelected()),
                () -> Assertions.assertTrue(radioMensual.isDisplayed()),
                () -> Assertions.assertFalse(radioMensual.isSelected()),

                () -> Assertions.assertTrue(botonRegistro.isDisplayed()),
                () -> Assertions.assertFalse(botonRegistro.isEnabled()),
                () -> Assertions.assertEquals("Registrar", botonRegistro.getText())

        );

    }

    @When("Selecciono el boton {string}")
    public void seleccionoElBoton(String frecuencia) {
        Logs.info("Selecciono el radiobutton " + frecuencia);
        frec = frecuencia.toLowerCase();
        //final var opcion = frecuencia.toLowerCase();
        final var opcionEscogida = driver.findElement(By.id(frec));
        //frec = opcionEscogida;

        opcionEscogida.click();
    }

    @Then("Verifico que el boton este seleccionado")
    public void verificoQueElBotonEsteSeleccionado() {
        Logs.info("Verifico que el botón ha sido seleccionado");

        WebElement elemento = driver.findElement(By.id(frec));
        boolean seleccion = elemento.isSelected();
        ;


        Assertions.assertAll(
                () -> Assertions.assertTrue(seleccion, "opcion no seleccionada"),
                () -> Assertions.assertTrue(elemento.isDisplayed(), "Elemento no visible")
        );


        if (seleccion) {
            System.out.println("está seleccionado");
        } else {
            System.out.println("no está seleccionado");
        }

    }

    @When("Selecciono los botones de preferencias")
    public void seleccionoLosBotonesDePreferencias() {
        //var checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        opciones = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (var checkbox : opciones) {
            checkbox.click();
        }
    }

    @Then("Verifico que los botones esten seleccionados")
    public void verificoQueLosBotonesEstenSeleccionados() {
        //var checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        opciones = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (var checkbox : opciones) {
            Assertions.assertTrue(checkbox.isSelected());

        }
    }
}
