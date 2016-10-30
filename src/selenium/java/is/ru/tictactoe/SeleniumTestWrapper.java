package is.ru.tictactoe;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public abstract class SeleniumTestWrapper {
    static WebDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void openBrowser(){
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        port = System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }
        baseUrl = "http://localhost:" + port;
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
