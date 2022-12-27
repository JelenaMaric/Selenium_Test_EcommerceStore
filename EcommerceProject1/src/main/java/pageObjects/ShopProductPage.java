package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShopProductPage extends BasePage {

	WebDriver driver;

	By sizeOption = By.cssSelector("[data-product-attribute='1']");
	By quantityIncrease = By.cssSelector(".touchspin-up");
	By quantityDecrease = By.cssSelector(".touchspin-down");
	By addToCartBtn = By.cssSelector(".add-to-cart.btn.btn-primary");
	By homepageLink = By.xpath("//span[text()='Home']");

	public ShopProductPage() throws IOException, InterruptedException {
		super();
		this.driver = getDriver();
	}

	public WebElement getSizeOption() throws IOException, InterruptedException {
		return driver.findElement(sizeOption);
	}

	public WebElement getQuantityIncrease() throws IOException, InterruptedException {
		return driver.findElement(quantityIncrease);
	}

	public WebElement getQuantityDecrease() throws IOException, InterruptedException {
		return driver.findElement(quantityDecrease);
	}

	public WebElement getAddToCartBtn() throws IOException, InterruptedException {
		return driver.findElement(addToCartBtn);
	}

	public WebElement getHomepageLink() throws IOException, InterruptedException {
		return driver.findElement(homepageLink);
	}
}
