package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\sainath.dabhade\\eclipse-workspace\\TuturialNinjaProjBDDcucu\\src\\test\\resources\\features", glue = {
		"stepdefinitions", "hookspackage" }, monochrome = true,publish = true,  plugin = { "pretty", "html:target/HTMLreports/reports.html"})
public class TestRunner {

}
