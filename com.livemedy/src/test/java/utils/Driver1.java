package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.time.Duration;

public class Driver1 {

    private static WebDriver driver1;

    public Driver1() {
    }

    public static WebDriver getDriver() {

        if (driver1 == null) {
            String browser = ConfigReader.getProperty("browser");
            String proxyHost = ConfigReader.getProperty("proxyHost");
            String proxyPort = ConfigReader.getProperty("proxyPort");
            String proxyUsername = ConfigReader.getProperty("proxyUsername");
            String proxyPassword = ConfigReader.getProperty("proxyPassword");

            switch (browser) {
                case "firefox" -> {
                    // Firefox için proxy ayarlarını ekleyelim
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("network.proxy.type", 1); // Manuel proxy kullan
                    profile.setPreference("network.proxy.http", proxyHost);
                    profile.setPreference("network.proxy.http_port", Integer.parseInt(proxyPort));
                    profile.setPreference("network.proxy.ssl", proxyHost);
                    profile.setPreference("network.proxy.ssl_port", Integer.parseInt(proxyPort));
                    profile.setPreference("network.proxy.socks", proxyHost);
                    profile.setPreference("network.proxy.socks_port", 1080); // SOCKS5 port
                    profile.setPreference("network.proxy.socks_version", 5); // SOCKS5
                    profile.setPreference("network.proxy.socks_remote_dns", true); // DNS proxy üzerinden yapılacak

                    FirefoxOptions options = new FirefoxOptions();
                    options.setProfile(profile);

                    // Proxy kimlik doğrulama scriptini çalıştırma (AutoIt)
                    if (proxyUsername != null && proxyPassword != null) {
                        try {
                            String autoItScriptPath = "C:\\Users\\Ercan\\Desktop\\Jenkins\\ProxyAuth.au3";
                            String command = "C:\\Users\\Ercan\\Desktop\\Jenkins\\ProxyAuth.exe " + autoItScriptPath;
                            Runtime.getRuntime().exec(command);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    WebDriverManager.firefoxdriver().setup();
                    driver1 = new FirefoxDriver(options);
                }

                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    driver1 = new SafariDriver();
                }

                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver1 = new EdgeDriver();
                }

                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver1 = new ChromeDriver();
                }

                default -> {
                    WebDriverManager.chromedriver().setup();
                    driver1 = new ChromeDriver();
                }
            }

            driver1.manage().window().maximize();
            driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver1;
    }

    public static void closeDriver() {
        if (driver1 != null) {
            driver1.close();
            driver1 = null;
        }
    }

    public static void quitDriver() {
        if (driver1 != null) {
            driver1.quit();
            driver1 = null;
        }
    }
}
