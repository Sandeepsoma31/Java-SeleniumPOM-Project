package org.Page.Locators;

public interface DemoSiteLocaters {
	
	public static final String homePage = "//a[@class='logo']";
	public static final String searchbox = "//input[@id='search']";
	public static final String searchboxbtn = "//button[@title='Search' and @type='submit']";
	public static final String signinbtn = "(//ul/li/a[contains(text(),'Sign In')])[1]";
	public static final String username="//input[@id='email']";
	public static final String password="//input[@id='pass']";
	public static final String LoginInButton = "(//div[@class='primary']//*[text()='Sign In'])[1]";
	public static final String LoggedAccountName = "(//span[@class='logged-in'])[1]";
	public static final String MenTop = "(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']/following::span[text()='Tops'])[2]";
	public static final String HoodieToggle = "(//a//span[text()='Hoodies & Sweatshirts'])[2]";
	public static final String HoodiesPage = "//h1//*[text()='Hoodies & Sweatshirts']";
	public static final String HoodieTShirt ="//*[@alt='Ajax Full-Zip Sweatshirt ']";
	public static final String SelectSize = "//*[@id='option-label-size-143-item-168']";
	public static final String SelectColor = "//*[@id='option-label-color-93-item-53']";
	public static final String AddToCart = "//button[@title='Add to Cart']";
	public static final String ShopingCart = "//a[text()='shopping cart']";
	public static final String proceedToCheck = "(//button[@title='Proceed to Checkout'])[2]";
	public static final String ShopingMethod = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input";
	public static final String PlaceOrder = "//span[text()='Place Order']";
	public static final String NextBtn = "//button//span[text()='Next']";
	public static final String OrderConfirmation = "//span[text()='Thank you for your purchase!']";
}
