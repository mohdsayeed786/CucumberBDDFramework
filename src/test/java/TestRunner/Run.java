package TestRunner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//Features/LoginFeature.feature"},
        glue = "StepDefinition",
        dryRun = false,  //mapping of feature file with step definition in case of True
        monochrome = false,
        tags = " @Regression",
       // plugin = {"pretty", "html:Target/cucumber-reports/reports1.html"}
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)

// html format        plugin = {"pretty", "html:Target/cucumber-reports/reports1.html"}
// Json format       plugin = {"pretty", "json:Target/cucumber-reports/reports2.json"}
// XML format       plugin = {"pretty", "junit:Target/cucumber-reports/reports3.xml"}

// To run specific feature file: features = ".//Features/AddCustomer.feature",
// To run all feature file: features = ".//Features/",
// To run multiple feature file: features = {".//Features/AddCustomer.feature", ".//Features/LoginFeature.feature"},

public class Run extends AbstractTestNGCucumberTests {
    //This class will remain empty
}
