package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class ResultsPage {
	private WebDriver driver;
	
	public ResultsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public WebElement result(String product){		
		return driver.findElement(By.cssSelector(
				"a.product-name[title='"+product+"']"));
	}

}







