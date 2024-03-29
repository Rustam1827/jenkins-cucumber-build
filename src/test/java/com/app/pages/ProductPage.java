package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class ProductPage {
	private WebDriver driver;
	
	public ProductPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	public WebElement name;
	
	
	@FindBy(css = "#add_to_cart button")
	public WebElement addToCart;
	
	@FindBy(xpath = "(//h2)[1]")
	public WebElement confirmation;
}




















