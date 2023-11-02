package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
@CucumberOptions(
        features = "src/test/java/features/SandboxPractice.feature",
        glue= "steps",
        tags="@Homeowner"
)
public class RegresionTestNgRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
