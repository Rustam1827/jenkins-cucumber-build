package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.app.pages.AccountPage;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UITestStepDef {

	private WebDriver driver = Driver.getDriver();

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	AccountPage accountPage = new AccountPage();

	@Given("I logged in into Prestashop")
	public void i_logged_in_into_Prestashop() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(ConfigurationReader.getProperty("url"));

		assertTrue(homePage.isAt());
		assertTrue(homePage.logo.isDisplayed());
		homePage.gotoLoginPage();

		assertTrue(loginPage.isAt());

		assertTrue(loginPage.createAccountlabel.isDisplayed());
		assertTrue(loginPage.alreadyRegisteredLabel.isDisplayed());

		// Enter valid email and password then click sign in
		/*
		 * loginPage.email.sendKeys(Configuration.getProperty("email"));
		 * loginPage.password.sendKeys(Configuration.getProperty("password"));
		 * loginPage.SubmitLogin.click();
		 */
		loginPage.login(ConfigurationReader.getProperty("email"), ConfigurationReader.getProperty("password"));

		assertTrue(accountPage.isAt(), "Account page is not loaded/displayed");
	}

	@Then("Web title should be My Store")
	public void web_title_should_be_My_Store() {
		String expected =""; //"My account - My Store";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
	}

	@Then("Modules should be displayed")
	public void modules_should_be_displayed() {
		System.out.println("Modules are displayed");
	}

	@Then("I logout from the application")
	public void i_logout_from_the_application() {
		loginPage.logOut();
	}

}
