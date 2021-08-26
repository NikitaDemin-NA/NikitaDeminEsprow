import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:Report1", "json:target/cucumber.json"},
        features = "src/main/resources/features",
        glue = "steps",
        tags = "@PayTransactionErrorCard"
)
public class RunnerTest {
}