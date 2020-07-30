package funcdef;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Practice{
	
	WebDriver driver;

	gen g;
	
	
		
	String Pwindow;
	String childWindow;
Practice(WebDriver driver)
{
this.driver= driver;

}
	




	public void clickPracticeButton() throws IOException, InterruptedException
	{
		
		//report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		//test = report.startTest("LetsKodeIt");
		
		
		gen g= new gen(driver);
		
		
g.findElement("practice","xpath").click();
		
	
//test.log(LogStatus.PASS,"Practice page navigated successfully from Pratice page");
	
	}
	
	public void verify_practicePageLoad() throws IOException
	{
		gen g= new gen(driver);
		g.explicitWait("PracticeHeading");
	   	
	String actaulUrl=	driver.getCurrentUrl();	
	System.out.println(actaulUrl);
   	String ExpectedUrl = "https://letskodeit.teachable.com/p/practice";
   	
   	if(ExpectedUrl.equals(actaulUrl))
   	{
   		 	
   		System.out.println("Practice URL verified");
   		//test.log(LogStatus.PASS,"Practice URL matched");
   	}
   	else
   	{
   		System.out.println("URL not matched");

	}
   	
   	
	}
	
	
	public void clickOpenTab() throws IOException, InterruptedException
	{
		
		gen g= new gen(driver);
	Thread.sleep(4000);
		Pwindow= driver.getWindowHandle();
		 System.out.println("Pwindow"+Pwindow);
		g.findElement("OpenTab","id").click();
		
	}
	
	public void courseCount()
	{
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		
		Iterator<String> itr = windows.iterator();
		
		
		while(itr.hasNext())
		{
			String childWindow = itr.next();
			if(!childWindow.equals(Pwindow))
			{
				driver.switchTo().window(childWindow);
				System.out.println("childWindow"+childWindow);
			break;
			}//if 
			}//while
	
		List<WebElement> count= 	driver.findElements(By.xpath("//div[@class='course-listing-title']"));
		int i;
		for(i=0;i<1;i++)
		{
		switch(i)
		{
		case 0:
		{
			if(count.get(i).getText().equals("Selenium WebDriver With Java"))
			{
				System.out.println("pass");
				//test.log(LogStatus.PASS,"Content matched");
				
			}
			else
			{
				System.out.println("Fail");
				
				//test.log(LogStatus.PASS,"Content not matched");
		
			}
		}
		}
			
			}//for loop
	
		
	} //function
	
	}// class
	
	


