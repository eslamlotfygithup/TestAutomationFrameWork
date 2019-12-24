package runner;

import cucumber.api.CucumberOptions;
import tests.Testbase;

@CucumberOptions(features = "src\\test\\java\\features"
,glue = {"steps"}
,plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends Testbase{


	
}
