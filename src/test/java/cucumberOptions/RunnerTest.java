package cucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/", glue = "stepDefination", plugin = {"json:target/cucumber-reports/cucumber.json",
        "pretty", "html:target/html-report/cucumber-html-reports.html"})
public class RunnerTest {

}
