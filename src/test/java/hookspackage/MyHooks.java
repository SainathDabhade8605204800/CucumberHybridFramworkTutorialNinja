package hookspackage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;
	private ConfigReader cfr;
	private DriverFactory driverfactory;

	@Before
	public void setup() throws IOException {

		cfr = new ConfigReader();
		Properties prop = cfr.intializePropertis();
		driverfactory = new DriverFactory();
		driver = driverfactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));	
	}

	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioname = scenario.getName().replace(" ", "_");
		
		if (scenario.isFailed()) {
			
		byte[] srcScreenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenshots, "image/png", scenarioname);
		}
		driver.quit();

	}
}
