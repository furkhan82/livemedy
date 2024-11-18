package stepdefinitions;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import utils.ScreenShotHelper;

import java.io.File;
import java.io.IOException;

public class Hooks {
    WebDriver driver = new ChromeDriver();


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Test başarısız olursa ekran resmini al
            takeScreenshot(scenario.getName());
        }
        if (driver != null) {
            driver.quit(); // WebDriver'ı kapat
        }
    }

    private void takeScreenshot(String scenarioName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile, new File("target/screenshots/" + scenarioName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

