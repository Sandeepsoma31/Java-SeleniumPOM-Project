package org.Page.PageEvents;

import java.io.IOException;

import org.Page.Base.BaseTest;
import org.Page.Locators.DemoSiteLocaters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ProductsObjMethods extends BaseTest{
	
	WebDriver driver;
	GetElement FindElement = new GetElement();
	
	//Methods
	public void GoToMenHoodie()
	{
	
		try {
			
			Actions action = new Actions(BaseTest.driver);
			WebElement element = BaseTest.driver.findElement(By.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']/following::span[text()='Men']"));
			action.moveToElement(element).build().perform();
			action.moveToElement(FindElement.fetchElement("XPATH", DemoSiteLocaters.MenTop)).build().perform();
			FindElement.fetchElement("XPATH", DemoSiteLocaters.HoodieToggle).click();
			
			if(FindElement.fetchElement("XPATH", DemoSiteLocaters.HoodiesPage).isDisplayed())
			{
				System.out.println("Men Hoodies Page is Displayed");
				reporter.log(Status.INFO, MarkupHelper.createLabel("Men Hoodies Page is displayed", ExtentColor.TRANSPARENT));
				reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
			}else {
				reporter.log(Status.FAIL, MarkupHelper.createLabel("Men Hoodies Page is Not displayed", ExtentColor.ORANGE));
				reporter.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void HoverOnAnyHoodie()
	{
		
		try {
			Actions action = new Actions(BaseTest.driver);
			action.moveToElement(FindElement.fetchElement("XPATH", DemoSiteLocaters.HoodieTShirt)).build().perform(); 
			
			reporter.log(Status.INFO, MarkupHelper.createLabel("Hovers on Men Hoodies", ExtentColor.TRANSPARENT));
			reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ClickOnHoodie()
	{
		
		try {
			FindElement.fetchElement("XPATH", DemoSiteLocaters.HoodieTShirt)
			.click();
			reporter.log(Status.INFO, MarkupHelper.createLabel("User clicked on Hoodie", ExtentColor.TRANSPARENT));
			reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ChooseSizeAndColor() throws InterruptedException
	{
		Thread.sleep(5000);
		try {
			FindElement.fetchElement("XPATH", DemoSiteLocaters.SelectSize)
			.click();
			FindElement.fetchElement("XPATH", DemoSiteLocaters.SelectColor)
			.click();
			reporter.log(Status.INFO, MarkupHelper.createLabel("User selected size and color", ExtentColor.TRANSPARENT));
			reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
			FindElement.fetchElement("XPATH", DemoSiteLocaters.AddToCart)
			.click();
			Thread.sleep(5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void CheckOutProduct() throws InterruptedException
	{
		Thread.sleep(5000);
		FindElement.fetchElement("XPATH", DemoSiteLocaters.ShopingCart)
		.click();
	
		try {
			reporter.log(Status.INFO, MarkupHelper.createLabel("User Added product to cart", ExtentColor.TRANSPARENT));
			reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(5000);
		FindElement.fetchElement("XPATH", DemoSiteLocaters.proceedToCheck)
		.click();
		
		try {
			reporter.log(Status.INFO, MarkupHelper.createLabel("User Proceed to Check Out", ExtentColor.TRANSPARENT));
			reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FindElement.fetchElement("XPATH", DemoSiteLocaters.ShopingMethod)
		.click();
		
		Thread.sleep(5000);
		
		FindElement.fetchElement("XPATH", DemoSiteLocaters.NextBtn)
		.click();
	}
	
	
	public void Placeorder() throws InterruptedException
	{
		Thread.sleep(5000);
		try {
			FindElement.fetchElement("XPATH", DemoSiteLocaters.PlaceOrder)
			.click();
			if(FindElement.fetchElement("XPATH", DemoSiteLocaters.OrderConfirmation).isDisplayed())
			{
				System.out.println("User Ordered Product Succesfully");
				reporter.log(Status.INFO, MarkupHelper.createLabel("User Order Product Succesfully", ExtentColor.TRANSPARENT));
				reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
			}else
			{
				System.out.println("User unable to Order Product");
				reporter.log(Status.FAIL, MarkupHelper.createLabel("User unable to Order Product", ExtentColor.ORANGE));
				reporter.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
