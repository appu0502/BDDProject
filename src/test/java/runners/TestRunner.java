package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="/BDDProject/src/test/java/features/SampleFeature.feature",
		glue="stepdefinitions",
		monochrome = true,
		dryRun=true,
		strict = true,
		plugin= {"json:json-output/cucumberoutput.json"}
		)
public class TestRunner {

} 
