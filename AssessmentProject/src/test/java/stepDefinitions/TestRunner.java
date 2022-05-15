package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Features",
		glue= {"stepDefinitions"},
		plugin = {"pretty","html:target/reports.html"})


public class TestRunner {

}
