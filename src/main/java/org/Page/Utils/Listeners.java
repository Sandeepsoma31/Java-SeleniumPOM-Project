package org.Page.Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.Page.Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class Listeners implements ITestListener, IAnnotationTransformer {
	
	public void onTestFailure(ITestResult result) {
	    
		String filename = System.getProperty("user.dir")+File.separator+"FailedScreenshots"+File.separator+result.getMethod().getMethodName();
		File f = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(f, new File(filename+".jpg"));
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	  }
	
	public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		   annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
	
}
