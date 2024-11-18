package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {

    private static WebDriver driver;
    public Driver() {

    }

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser=ConfigReader.getProperty("browser");
            switch (browser) {
                case "firefox" -> {



                   /*
                   FirefoxOptions options = new FirefoxOptions();
                    options.setHeadless(true);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver (options);
 */
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();



                }
                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();

                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();

                }
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                /*default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions option = new ChromeOptions().addArguments("incognito");
                    driver = new ChromeDriver(option);*/
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }


        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}