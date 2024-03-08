package org.Page.PageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.Page.Base.*;


public class GetElement {
	
	public WebElement fetchElement(String XpathType, String XpathValue)
	{
		switch(XpathType) {
		
		case "XPATH": return BaseTest.driver.findElement(By.xpath(XpathValue));
		
		case "CSS": return BaseTest.driver.findElement(By.cssSelector(XpathValue));
		
		case "ID": return BaseTest.driver.findElement(By.id(XpathValue));
		
		default: return null;
		
		}
	}
	
	public List<WebElement> fetchElements(String XpathType, String XpathValue)
	{
		switch(XpathType) {
		
		case "XPATH": return BaseTest.driver.findElements(By.xpath(XpathValue));
		
		case "CSS": return BaseTest.driver.findElements(By.cssSelector(XpathValue));
		
		case "ID": return BaseTest.driver.findElements(By.id(XpathValue));
		
		default: return null;
		
		}
	}
	
}
