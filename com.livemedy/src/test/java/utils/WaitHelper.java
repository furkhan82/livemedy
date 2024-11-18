package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    public static void waitForJQueryToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) wd ->
                (Boolean) ((JavascriptExecutor) wd).executeScript("return typeof jQuery != 'undefined' && jQuery.active == 0"));
    }
}