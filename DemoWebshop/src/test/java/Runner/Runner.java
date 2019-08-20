package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "DemoWebshop/HomePage.feature"},
		glue = { "StepDefinition" },
		plugin= {"html:target/html", "json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
)

public class Runner {

}
