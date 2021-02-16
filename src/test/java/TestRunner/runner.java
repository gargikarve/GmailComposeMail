package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/ComposeMail.feature", glue= {"StepDefinitions", "AppHooks"},
monochrome = true, plugin = {"pretty","html:target/HTMLReports/report"}
		)
public class runner {

}
