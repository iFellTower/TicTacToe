package is.ru.tictactoe;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public abstract class SeleniumTestWrapper {
    static FirefoxDriver driver;
    static String baseUrl;
    // static String port;

    @BeforeClass
    public static void openBrowser(){
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*
        port = System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }*/
        baseUrl = "https://ifelltowerttt.herokuapp.com/";
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
