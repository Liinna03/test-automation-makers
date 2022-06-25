import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/dejanos_un_mensaje_form.feature"
        ,plugin = {"pretty", "junit:cucumber-reports/Cucumber.xml"}
        ,monochrome = true

)
public class TestRunner {

}

