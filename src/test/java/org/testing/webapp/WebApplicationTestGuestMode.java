package org.testing.webapp;

import org.Page.Base.BaseTest;
import org.Page.PageEvents.GetElement;
import org.Page.PageEvents.HomePageObjMethods;
import org.Page.PageEvents.ProductsObjMethods;
import org.Page.Utils.configPropFile;
import org.testng.annotations.Test;

public class WebApplicationTestGuestMode extends BaseTest {
	
	GetElement FindElement = new GetElement();
	HomePageObjMethods hpm = new HomePageObjMethods();
	ProductsObjMethods pm = new ProductsObjMethods();
	@Test
	public void DemoSiteLoginTest() throws InterruptedException
	{
		hpm.VerifyHomePageIsDisplayed();
		pm.GoToMenHoodie();
		pm.HoverOnAnyHoodie();
		pm.ClickOnHoodie();
		pm.ChooseSizeAndColor();
		pm.CheckOutProduct();
	}
	
}
