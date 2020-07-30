package funcdef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestRunner {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
@BeforeSuite
	public void lauchApplication() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\mahendran.shanmugam\\eclipse-workspace\\collset\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		System.out.println("Bhuvana");
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("LetsKodeIt");
		
		
	
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("D:\\Users\\mahendran.shanmugam\\eclipse-workspace\\collset\\src\\main\\resources\\data.properties");
		p.load(file);
		driver.get(p.getProperty("url"));

		driver.manage().window().maximize();
	}
		
		@Test(priority =0)
		public void click_practice() throws IOException, InterruptedException
		{
			
			Practice p=new Practice(driver);
			try
			{
			p.clickPracticeButton();
			test.log(LogStatus.PASS, "Practice button clicked");
			}
			catch(Exception E)
			
			{
				test.log(LogStatus.FAIL, "Practice button not clicked");
			}
		}
		   // p.verify_practicePageLoad();
			
	
		
		@Test(priority =1)
		public void click_OpenTab() throws IOException, InterruptedException
		{
			Practice p=new Practice(driver);
			try
			{
			p.clickOpenTab();
			test.log(LogStatus.PASS, "Open tab button  clicked");			
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Open tab button not clicked");
			}
			
			p.courseCount();
		}
		
		
		@AfterSuite
		public void tearDown()
		{
			report.flush();
			driver.quit();
		}
		
		
		
	}

