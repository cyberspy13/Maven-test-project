package cucumberOptions;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;



//@RunWith(Cucumber.class)
@CucumberOptions	
(
		features = "src/test/java/features",
		glue = "stepDefinitions"
		)

public class testRunnerClass extends  AbstractTestNGCucumberTests  { //if we are not extends anything it is will be treating as JUNIT, but now we are using TestNG

}
