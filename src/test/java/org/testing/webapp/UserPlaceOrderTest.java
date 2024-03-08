package org.testing.webapp;

import org.Page.Base.BaseTest;
import org.Page.PageEvents.GetElement;
import org.Page.PageEvents.HomePageObjMethods;
import org.Page.PageEvents.ProductsObjMethods;
import org.Page.Utils.configPropFile;
import org.testng.annotations.Test;

public class UserPlaceOrderTest extends BaseTest {
	
	GetElement FindElement = new GetElement();
	HomePageObjMethods hpm = new HomePageObjMethods();
	ProductsObjMethods pm = new ProductsObjMethods();
	
	@Test
	public void DemoSiteOrderPlacementTesting() throws InterruptedException
	{
		configPropFile.getproperties();
		
		hpm.VerifyHomePageIsDisplayed();
		hpm.ClickSignInLink();
		hpm.EnterCredentialsAndLogin(configPropFile.property.getProperty("email"),configPropFile.property.getProperty("password"));
		hpm.VerifyLoginSuccessfull();
		pm.GoToMenHoodie();
		pm.HoverOnAnyHoodie();
		pm.ClickOnHoodie();
		pm.ChooseSizeAndColor();
		pm.CheckOutProduct();
		pm.Placeorder();
	}
}
