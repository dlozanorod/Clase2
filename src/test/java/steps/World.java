package steps;

import io.cucumber.java.*;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Logs;

public class World {
    WebDriver driver;

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

    }

    @After
    public void teardown() {
        Logs.debug("Matando el driver");
        driver.quit();

    }


}
