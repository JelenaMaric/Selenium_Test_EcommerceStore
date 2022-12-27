package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class Shophomepage extends BasePage {

	public WebDriver driver;

	By productOne = By.linkText("Hummingbird Printed T-Shirt");
	By productTwo = By.linkText("Hummingbird Printed Sweater");

	public Shophomepage() throws IOException, InterruptedException {
		super();
		this.driver = getDriver();
	}

	public WebElement getProdOne() throws IOException, InterruptedException {
		return driver.findElement(productOne);
	}

	public WebElement getProdTwo() throws IOException, InterruptedException {
		return driver.findElement(productTwo);
	}
}
