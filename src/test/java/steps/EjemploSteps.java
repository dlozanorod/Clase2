package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class EjemploSteps {
    private WebDriver driver;
    private String urlActual;
    private String urlEsperado;

    public EjemploSteps (World world) {
        this.driver = world.driver;
    }

    @Given("Navego a la pagina {string}")
    public void navegoALaPagina(String url) {
        driver.get(url);
        urlEsperado = url;

    }

    @When("Obtengo la url con el driver")
    public void obtengoLaUrlConElDriver() {
        urlActual = driver.getCurrentUrl();
    }

    @Then("Verifico que la url obtenida sea la misma")
    public void verificoQueLaUrlObtenidaSeaLaMisma() {
        Assertions.assertEquals(urlActual, urlEsperado);
    }
}
