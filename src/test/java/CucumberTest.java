import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/features/",
        glue = { "cucumber/steps/" },
        format = {"pretty", "html:target/cucumber"}
)

public class CucumberTest {
}
