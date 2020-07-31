package funcdef;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Practice{
	
	WebDriver driver;

	gen g;
	
	Logger logger;
		
	String Pwindow;
	String childWindow;
Practice(WebDriver driver)
{
this.driver= driver;

}




	




	public void clickPracticeButton() throws IOException, InterruptedException
	{
		
	
		Logger logger = LogManager.getLogger(Practice.class);
		
		gen g= new gen(driver);
		
		
g.findElement("practice","xpath").click();
		
	

	
	}
	
	
	public void mouse_hover() throws IOException, InterruptedException
	{
		
		//WebElement f= g.findElement("mousehover", "xpath");
		
		Thread.sleep(5000);

		  JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,1000)");
		    
		    Thread.sleep(3000);
		
		WebElement f = driver.findElement(By.id("mousehover"));
		    
		    //WebElement f=  g.findElement("mousehover", "id");
		
				Actions action = new Actions(driver);
	
		action.moveToElement(f).perform();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Reload']")).click();
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
   		
   		logger.info("Expected URL matched");
   	}
   	else
   	{
   		System.out.println("URL not matched");

	}
   	
   	
	}
	
	
	
	
	
	}// class
	
	


