package com.automationtesting;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopProductPage;
import pageObjects.Shophomepage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)
public class AddRemoveItemBasketTest extends Hooks {

	public AddRemoveItemBasketTest() throws IOException {
		super();
	}

	@Test
	public void addRemoveItem() throws IOException, InterruptedException {
		ExtentManager.log("Starting AddremoveItemBasketTest...");
		Homepage home = new Homepage();
		home.getTestStoreLink().click();

		Shophomepage shopHome = new Shophomepage();
		ExtentManager.pass("Successfully reached the shop homepage");
		shopHome.getProdOne().click();

		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Successfully reached the product page");
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		ExtentManager.pass("Successfully selected product size");
		shopProd.getQuantityIncrease().click();
		ExtentManager.pass("Successfully increased quantity");
		shopProd.getAddToCartBtn().click();

		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getContinueShoppingBtn().click();
		shopProd.getHomepageLink().click();
		shopHome.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getChechoutBtn().click();

		ShoppingCart cart = new ShoppingCart();
		cart.getDeleteItemTwo().click();
		WebDriverWait wait = new WebDriverWait(cart.driver, 120);
		wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));
		System.out.println(cart.getTotalAmount().getText());
		try {
			Assert.assertEquals(cart.getTotalAmount().getText(), "$45.24");
			ExtentManager.pass("The total amount matches the expected amount.");
		}catch(AssertionError e) {
			Assert.fail("Cart amount did not match the expected amount, it found"+cart.getTotalAmount().getText()+
					" expected $45.24");
			ExtentManager.fail("The total amount did not match the expected amount.");
		}	
	}
}
