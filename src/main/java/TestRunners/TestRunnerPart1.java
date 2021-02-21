package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features/Proje18Part1.feature",
        glue = "Project18",
        plugin = {"html:target/report/index.html"}
)
public class TestRunnerPart1 extends AbstractTestNGCucumberTests {
}
