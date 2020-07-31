package funcdef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class gen {
	WebDriver driver;
Properties p;

	gen(WebDriver driver)
	
	{
		this.driver = driver;
	}
	

	
	
	
	public WebElement findElement(String elem, String locator) throws IOException
	{
		System.out.println("locator"+locator);
		switch(locator)
		{
		
	
		case "xpath":
		{
		p = new Properties();
		FileInputStream file = new FileInputStream("D:\\Users\\mahendran.shanmugam\\eclipse-workspace\\collset\\src\\main\\resources\\objectrepository.properties");
		System.out.print(file);
		p.load(file);							
	WebElement ele =  driver.findElement(By.xpath(p.getProperty(elem)));
return ele;
		}	
		case "id":
		{
			p = new Properties();
			FileInputStream file = new FileInputStream("D:\\Users\\mahendran.shanmugam\\eclipse-workspace\\collset\\src\\main\\resources\\objectrepository.properties");
			System.out.print(file);
			p.load(file);							
		WebElement ele =  driver.findElement(By.id(p.getProperty(elem)));
		return ele;
		}
}
		return null;
	}	
	
	public void  explicitWait(String ele) throws IOException
	{
		p = new Properties();
		FileInputStream file = new FileInputStream("D:\\Users\\mahendran.shanmugam\\eclipse-workspace\\collset\\src\\main\\resources\\objectrepository.properties");
		System.out.print(file);
		p.load(file);
		WebDriverWait wait = new WebDriverWait(driver,20);
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty(ele))));
	}
	
	


}
	

