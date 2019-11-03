package com.discovery.go.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.discovery.go.common.utilities.PropertyHandler;
import com.discovery.go.report.factory.ExtentManager;

public class UserBaseTest {
	public PropertyHandler prop;
	public WebDriver driver;
	public ExtentTest parentReport;
	public ExtentTest report;

	public UserBaseTest() {
		try {
			prop=PropertyHandler.getInstance();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters({"browser"})
	@BeforeMethod
	public void testSetUp(@Optional("chrome")String browser, Method name) throws IOException {
		
		report = ExtentManager.getExtent().createTest(name.getName(),browser);
		//report = parentReport.createNode(name.getName(),"Launch Browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		Reporter.log("=========Browser Session started==========",true);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Reporter.log("=========Application Session started==========",true);
		// Enter URL
		driver.navigate().to(prop.getProperty("URL"));
		report.log(Status.PASS, "Launched Browser Successfully");
	}

	@AfterMethod
	protected void testTearDown(Method name, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
            report.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
        	report.log(Status.SKIP, "Test skipped " + "<td><tr>"+ result.getThrowable().getMessage()+"</tr></td>");
        }
		
		if(driver != null)
			driver.close();
		report.log(Status.PASS, "Closed Browser Successfully");
	}
	
	@AfterSuite
	public void closeResources() {
		ExtentManager.getExtent().flush();
	}
}
