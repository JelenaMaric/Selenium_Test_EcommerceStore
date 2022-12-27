package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class Homepage extends BasePage {

	public WebDriver driver;

	By toggle = By.cssSelector(".toggle");
	By homepageLink = By.linkText("HOMEPAGE");
	By testStoreLink = By.linkText("TEST STORE");

	public Homepage() throws IOException, InterruptedException {
		super();
		this.driver = getDriver();
	}

	public WebElement getToggle() throws IOException, InterruptedException {
		return driver.findElement(toggle);
	}

	public WebElement getHomepageLink() throws IOException, InterruptedException {
		return driver.findElement(homepageLink);
	}

	public WebElement getTestStoreLink() {
		return driver.findElement(testStoreLink);
	}

}
