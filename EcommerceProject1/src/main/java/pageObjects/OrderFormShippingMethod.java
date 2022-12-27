package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class OrderFormShippingMethod extends BasePage {

	public WebDriver driver;

	By deliveryMsgTextbox = By.cssSelector("textarea#delivery_message");
	By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

	public OrderFormShippingMethod() throws IOException, InterruptedException {
		super();
		this.driver = getDriver();
	}

	public WebElement getDeliveryMsgTextbox() throws IOException, InterruptedException {
		return driver.findElement(deliveryMsgTextbox);
	}

	public WebElement getContinueBtn() throws IOException, InterruptedException {
		return driver.findElement(continueBtn);
	}
}
