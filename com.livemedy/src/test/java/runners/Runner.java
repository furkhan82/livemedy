package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"html:target/cucumber-reports.html",
                "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                },
        monochrome = true,
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "",
        dryRun = false

)
public class Runner {
}
