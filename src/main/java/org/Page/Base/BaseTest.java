package org.Page.Base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.Page.Utils.*;
import org.apache.commons.exec.OS;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReport;
	public static ExtentTest reporter;
	
	
	@BeforeTest
	public void beforetest()
	{
		configPropFile.getproperties();
		
		//Below creating a spark reporter to capture things
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"ExtentReports"+File.separator+"TestReport.html");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Test Automation Report");
		sparkReporter.config().setReportName("Automation report by Sandeep");
		
		
		
		//Below creating extent report HTML file
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("UserName", "Sandeep");
		extentReport.setSystemInfo("HostName", "Client");
		extentReport.setSystemInfo("Browser",configPropFile.property.getProperty("browserName"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		
	}
	
	@BeforeMethod
	public void beforemethod(Method testMethod) throws IOException
	{
		configPropFile.getproperties();
		reporter = extentReport.createTest(testMethod.getName())
				  .assignAuthor("Sandeep")
				  .assignCategory("Smoke Test");
		
		createDriver(configPropFile.property.getProperty("browserName"));
		System.out.println("Driver Started");
		driver.get(configPropFile.property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		reporter.log(Status.INFO, MarkupHelper.createLabel("User Opened Url: "+configPropFile.property.getProperty("url"), ExtentColor.GREEN));
		reporter.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
	}
	
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			reporter.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test Case Completed and Failed", ExtentColor.RED));
			reporter.log(Status.FAIL,reporter.addScreenCaptureFromPath(capture(driver))+ "Test Method Failed");
			reporter.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" Test Case Failed", ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			reporter.log(Status.PASS, MarkupHelper.createLabel(" Test Case Completed and Passed", ExtentColor.GREEN));
			reporter.log(Status.PASS,reporter.addScreenCaptureFromPath(capture(driver))+ "Test Case Completed and Passed");
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			reporter.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case Completed and Skipped", ExtentColor.YELLOW));
			reporter.log(Status.SKIP,reporter.addScreenCaptureFromPath(capture(driver))+ "Test Case Skipped");
		}
		EndDriver();
	}
	
	
	@AfterTest
	public void aftertest()
	{
		extentReport.flush();
	}
	
	public void createDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//Uncomment below line to run in headless mode 
			//options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	
	public void EndDriver()
	{
		System.out.println("Driver Ended");
		driver.close();
		driver.quit();
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("Screenshots/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
		
	
}
