package funcdef;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class courses {
	gen g;
	
	//Logger logger;
		
	String Pwindow;
	String childWindow;
	
	WebDriver driver;
	
	courses(WebDriver driver)
	{
		this.driver = driver;
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
	
}
