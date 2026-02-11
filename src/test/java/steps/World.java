package steps;

import io.cucumber.java.*;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        //driver = new EdgeDriver();

        Logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        /*Logs.debug("Eliminando las cookies");
        driver.manage().deleteAllCookies();*/

    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2500);

        }catch (InterruptedException interruptedException){

        }

        Logs.debug("Matando el driver");
        driver.quit();

    }


}
