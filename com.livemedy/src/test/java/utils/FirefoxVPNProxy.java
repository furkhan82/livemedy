package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.IOException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class FirefoxVPNProxy {
    public static void main(String[] args) throws IOException, InterruptedException {
        String autoItScriptPath = "C:\\Users\\Ercan\\Desktop\\ProxyAuth.au3";
        String command = "C:\\Users\\Ercan\\Desktop\\ProxyAuth.exe " + autoItScriptPath;

        Thread.sleep(4000);
        String username = "furkan";  // Proxy username
        String password = "k6W'j{jZKqWaDAErevMyFrk82"; // Proxy password

        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("network.proxy.type", 1); // Manuel proxy kullan
        profile.setPreference("network.proxy.http", "37.148.210.124");
        profile.setPreference("network.proxy.http_port", 808);
        profile.setPreference("network.proxy.ssl", "37.148.210.124");
        profile.setPreference("network.proxy.ssl_port", 808);
        profile.setPreference("network.proxy.socks", "37.148.210.124");
        profile.setPreference("network.proxy.socks_port", 1080);
        profile.setPreference("network.proxy.socks_version", 5); // SOCKS5
        profile.setPreference("network.proxy.socks_remote_dns", true); // DNS proxy üzerinden yapılacak


        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);


        Runtime.getRuntime().exec(command);
        WebDriver driver = new FirefoxDriver(options);



        Thread.sleep(5000);


        driver.get("http://seo.livemedy.com");



        driver.quit();
    }
}
