package org.Page.PageEvents;

import org.Page.Locators.*;

import java.io.IOException;

import org.Page.Base.*;
import org.Page.PageEvents.GetElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class HomePageObjMethods extends BaseTest{
	WebDriver driver;
	GetElement FindElement = new GetElement();
		
		//Methods
		public void VerifyHomePageIsDisplayed()
		{
		
			try {
				if(FindElement.fetchElement("XPATH", DemoSiteLocaters.homePage).isDisplayed())
				{
					System.out.println("Home Page is Displayed");
					reporter.log(Status.INFO, MarkupHelper.createLabel("Home Page is displayed", ExtentColor.TRANSPARENT));
					reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
				}else {
					reporter.log(Status.FAIL, MarkupHelper.createLabel("Home Page is Not displayed", ExtentColor.ORANGE));
					reporter.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void ClickSignInLink()
		{
			
			try {
				System.out.println("User Clicked on Sign In");
				FindElement.fetchElement("XPATH", DemoSiteLocaters.signinbtn)
				.click();
				reporter.log(Status.INFO, MarkupHelper.createLabel("Clicked On Sign In Button", ExtentColor.TRANSPARENT));
				reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public void VerifyLoginPageDisplayed()
		{
			String ExpectedTitle = "Customer Login";
			String CurrentTitle = BaseTest.driver.getTitle();
			Assert.assertEquals(CurrentTitle, ExpectedTitle);
			try {
				if(CurrentTitle.equals(ExpectedTitle))
				{
					System.out.println("Login Page is displayed");
					reporter.log(Status.INFO, MarkupHelper.createLabel("Customer Login Page is Opened", ExtentColor.TRANSPARENT));
					reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
				}else
				{
					reporter.log(Status.FAIL, MarkupHelper.createLabel("Customer Login Page is not Opened", ExtentColor.ORANGE));
					reporter.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void EnterCredentialsAndLogin(String userName, String Password)
		{
			try {
				
				FindElement.fetchElement("XPATH", DemoSiteLocaters.username)
				.sendKeys(userName);
				
				FindElement.fetchElement("XPATH", DemoSiteLocaters.password)
				.sendKeys(Password);
				
				reporter.log(Status.INFO, MarkupHelper.createLabel("User entered details", ExtentColor.TRANSPARENT));
				reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
				
				FindElement.fetchElement("XPATH", DemoSiteLocaters.LoginInButton)
				.click();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		public void VerifyLoginSuccessfull() throws InterruptedException
		{
			Thread.sleep(3000);
				try {
					if(FindElement.fetchElement("XPATH", DemoSiteLocaters.LoggedAccountName).isDisplayed())
					{
						System.out.println("User logged Sucessfully");
						
						reporter.log(Status.INFO, MarkupHelper.createLabel("User Logged into application Successfully", ExtentColor.TRANSPARENT));
						reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
					}else
					{
						reporter.log(Status.FAIL, MarkupHelper.createLabel("User Failed to Login in", ExtentColor.ORANGE));
						reporter.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(capture(BaseTest.driver)).build());
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
		
		
}
