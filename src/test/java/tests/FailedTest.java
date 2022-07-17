package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt",glue = "stepDefinitions",dryRun = false,tags = "",
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber.html",
                "rerun:target/rerun.txt"})
public class FailedTest {
}
