package steps;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.Logs;

import java.time.Duration;

public class World {
    WebDriver driver;
    private final String mainUrl = "https://tutorials.blassacademy.com";

    @BeforeAll
    public static void BeforeAll() {

    }

    @AfterAll
    public static void AfterAll() {
        Logs.info("After all");
    }

    @Before
    public void setup() {
        Logs.debug("Inicializando el driver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        //driver = new EdgeDriver();

        Logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        /*Logs.debug("Eliminando las cookies");
        driver.manage().deleteAllCookies();*/

        Logs.debug("Agregando implicitWait");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(500);

        }catch (InterruptedException interruptedException){

        }

        Logs.debug("Matando el driver");
        driver.quit();

    }

    @Given("Navego a la pagina de {string}")
    public void navegoALaPaginaDe(String path) {
        //https://tutorials.blassacademy.com/ + login
        final var url = String.format("%s/%s",mainUrl,path);
        driver.get(url);

    }
}
