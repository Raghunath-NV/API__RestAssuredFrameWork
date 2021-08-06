package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/features",
		glue={"stepDefinitions"},
		plugin="json:target/jsonReports/cucumber-report.json"
		//,tags="@AddPlace"
		)
public class TestRunner {
	
	//Reports are generated based on the json, so we need to create a json output of results and that will be passed for report generation purpose.
	//This can be done by adding plugin option.
	
	//To generate report you need to run through command prompt - mvn test verify  -> open overview-features.html from cucumber-html-reports folder

}
