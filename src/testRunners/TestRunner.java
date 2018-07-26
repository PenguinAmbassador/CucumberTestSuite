package testRunners;
  
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(features=  "src/features",//works better with /src
		glue= "stepDefinitions"//works best when you just list stepDefinitions. get rid last and of rac
		)
public class TestRunner {
 
}
