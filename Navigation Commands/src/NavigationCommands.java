import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
/*
Launch the browser
Enter the URL, “https://google.com”
Enter the value in search or Edit box "Orange HRM demo"
Click on Search or press Enter
Search Result will be displayed
Click on Back arrow button and verify if the Google Page is appeared
Click on Forward arrow button and verify if it is redirected to the results page
Navigate to the page “https://opensource-demo.orangehrmlive.com”
Scroll down and click on the link “OrangeHRM, Inc”
Hover the cursor over the “Resources” menu click on “Forum” menu item
Scroll down and click on the link “Delete all board cookies”
In the prompt click on “No” button
Close the current tab and verify if it is navigating to previous tab
Close the browser
*/
public class NavigationCommands 
{
	public static void main(String ar[])
	{
	//Launch the browser
	System.setProperty("webdriver.gecko.driver","C:\\Users\\SAI MANOHAR\\eclipse-workspace\\2104457_Navigation Commands\\resources\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	
	//implicit wait
	driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
	//pageload
	driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
	
	//Maximize the browser
	driver.manage().window().maximize();
	
	//Enter the URL, “https://google.com”
	driver.get("https://google.com");
	
	//Enter the value in search or Edit box "Orange HRM demo"
    //Click on Search or press Enter
    driver.findElement(By.name("q")).sendKeys("Orange HRM demo");
    driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
	//Search Result will be displayed
    
	//Click on Back arrow button and verify if the Google Page is appeared
	driver.navigate().back();
	String title1=driver.getTitle();
	if(title1.equals("Google"))
	{
		System.out.println(title1);
		System.out.println("Google page title is valid");
	}
	else
	{
		System.out.println(title1);
		System.out.println("Google page title is not valid"); 
	}
	
	//Click on Forward arrow button and verify if it is redirected to the results page
	driver.navigate().forward();
	String title2=driver.getTitle();
	if(title2.equals("Orange HRM demo - Google Search"))
	{
		System.out.println(title2);
		System.out.println("Orange HRM demo - Google Search page title is valid");
	}
	else
	{
		System.out.println(title2);
		System.out.println("Orange HRM demo - Google Search page title is not valid");
	}

	//Navigate to the page “https://opensource-demo.orangehrmlive.com"
	driver.navigate().to("https://opensource-demo.orangehrmlive.com");
	
	//Scroll down and click on the link “OrangeHRM, Inc”
	driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/a")).click();
	
	//Hover the cursor over the “Resources” menu click on “Forum” menu item
	Set<String> alwh = driver.getWindowHandles();
	Iterator<String> it= alwh.iterator();
	String parent=it.next(); //parent is ""https://opensource-demo.orangehrmlive.com/" tab
	String child=it.next(); //child is "https://www.orangehrm.com/" tab
	driver.switchTo().window(child);	
	WebElement forum=driver.findElement(By.linkText("Resources"));
	Actions ac=new Actions(driver);
	ac.moveToElement(forum).build().perform();
	driver.findElement(By.linkText("Starter Forum (Open Source)")).click();
	
	//Scroll down and click on the link “Delete all board cookies”
	driver.findElement(By.xpath("//*[@id=\"nav-footer\"]/li[3]/a/span")).click();
	
	//In the prompt click on “No” button
	WebElement el = driver.findElement(By.name("cancel"));
    Actions builder = new Actions(driver);
    builder.moveToElement( el ).click( el ).build().perform();
    
	//Close the current tab and verify if it is navigating to previous tab
    driver.close();
	driver.switchTo().window(parent);
	String title3=driver.getTitle();
	//Assert.assertEquals("OrangeHRM",title3);
	if(title3.equals("OrangeHRM"))
	{
		System.out.println(title3);
		System.out.println("OrangeHRM page title is valid");
	}
	else
	{
		System.out.println(title3);
		System.out.println("OrangeHRM page title is not valid");
	}
	
	//Close the browser
	driver.close();
	

	}
}
