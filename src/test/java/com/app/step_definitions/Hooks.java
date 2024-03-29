package com.app.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.app.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void setUp(Scenario scenario) {
		WebDriver driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
		final byte[] screenshot = ((TakesScreenshot)
				Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");	
		}
		
		Driver.closeDriver();
	}
}
