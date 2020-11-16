package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format  = {"pretty","json:test-output/cucumber.json","html:test-output/"},
		
features = { "Features/" },
		glue = "stepdefinitions",
		dryRun=false
        )

public class TestRunner {

}


