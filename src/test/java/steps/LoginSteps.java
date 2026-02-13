package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;

    public LoginSteps(World world) {
        this.driver = world.driver;
    }

    @Given("un usuario intenta logearse")
    public void unUsuarioIntentaLogearse() {
        driver.get("https://tutorials.blassacademy.com/login");

    }

    @When("proporcione credenciales erroneas")
    public void proporcioneCredencialesErroneas() {
        driver.findElement(By.id("username-input")).sendKeys("Hola");
        driver.findElement(By.id("password-input")).sendKeys("Chau");
        if (driver.findElement(By.cssSelector("button[type='submit']")).isEnabled()) {
            driver.findElement(By.cssSelector("button[type='submit']")).click();
        } else {
            System.out.println("Botón inhabilitado");
        }

    }

    @Then("se le mostrara un mensaje de error")
    public void seLeMostraraUnMensajeDeError() {

    }
}
