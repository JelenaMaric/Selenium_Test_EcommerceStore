package com.automationtesting;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;
import pageObjects.Homepage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopProductPage;
import pageObjects.Shophomepage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)
public class OrderCompleteTest extends Hooks {

	public OrderCompleteTest() throws IOException {
		super();
	}

	@Test
	public void endToEndTest() throws IOException, InterruptedException {
		ExtentManager.log("OrderCompleteTest...");
		Homepage home = new Homepage();
		home.getTestStoreLink().click();
		ExtentManager.pass("Successfully reached store homepage");

		Shophomepage shopHome = new Shophomepage();
		shopHome.getProdOne().click();
		ExtentManager.pass("Successfully clicked on product");

		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Successfully reached shop product page");
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		ExtentManager.pass("Successfully selected product size");
		shopProd.getQuantityIncrease().click();
		ExtentManager.pass("Successfully increased quantity");
		shopProd.getAddToCartBtn().click();
		ExtentManager.pass("Successfully added item to cart");
		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getChechoutBtn().click();

		ShoppingCart cart = new ShoppingCart();
		ExtentManager.pass("Successfully reached shopping cart page");
		cart.getHavePromo().click();
		ExtentManager.pass("Successfully selected the promo button");
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		cart.getProceedCheckoutBtn().click();
		ExtentManager.pass("Successfully selected check out button");

		OrderFormPersInfo pInfo = new OrderFormPersInfo();
		pInfo.getGenderMr().click();
		pInfo.getFirstNameField().sendKeys("John");
		pInfo.getLastnameField().sendKeys("Smith");
		pInfo.getEmailField().sendKeys("johnsmith1111@test.com");
		pInfo.getTermsConditionsCheckbox().click();
		pInfo.getContinueBtn().click();
		ExtentManager.pass("Successfully entered customer details");

		OrderFormDelivery orderDelivery = new OrderFormDelivery();
		orderDelivery.getAddressField().sendKeys("123 Street");
		orderDelivery.getCityField().sendKeys("City");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderDelivery.getPostcodeField().sendKeys("77201");
		orderDelivery.getContinueBtn().click();
		ExtentManager.pass("Successfully entered delivery information");

		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch");
		shipMethod.getContinueBtn().click();
		ExtentManager.pass("Successfully selected shipping method");

		OrderFormPayment orderPay = new OrderFormPayment();
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();
		ExtentManager.pass("Successfully placed order");
	}
}
