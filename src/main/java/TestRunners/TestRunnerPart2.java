package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features/proje18Part2.feature",
        glue = "Project18",
        plugin = {"html:target/report/index.html"}
)
public class TestRunnerPart2 extends AbstractTestNGCucumberTests {
}
