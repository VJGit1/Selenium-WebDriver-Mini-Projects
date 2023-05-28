package searchforschools;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class schoolsearch {

	static WebDriver driver;

	//Setup for Edge Browser
	public static void edgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","./driver/msedgedriver.exe");
		driver = new EdgeDriver();
	}

	//Setup for FireFox Browser
	public static void firefoxBrowser()
	{
	    System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	    driver=new FirefoxDriver();
	}
	public static void main(String[] args) throws InterruptedException
	{

	//select browser
	System.out.println("Select your browser 1.edge 2.Firefox");
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	int choice=sc.nextInt();
	if(choice==1)
	edgeBrowser();
	else
	firefoxBrowser();
	driver.get("https://www.eduvidya.com/");

	//Maximize the window of the website.
	driver.manage().window().maximize();

	//Wait for 2 seconds to load the page
	Thread.sleep(2000);
	
	

	//Clicking on Schools menu option.
	driver.findElement(By.xpath("(//a[normalize-space()='Schools'])[1]")).click();

	//Wait for 5 seconds to load the page.After this we have to close the Ad manually.
	Thread.sleep(5000);

	//click on "Course-type" dropdown and select "CBSE" from the list.
	Select category = new Select(driver.findElement(By.name("ctl00$cp_left$ddl_Category")));
	category.selectByVisibleText("CBSE");
	category.selectByIndex(3);

	//click on "City" dropdown and select "Pune" from the list.
	Select city = new Select(driver.findElement(By.name("ctl00$cp_left$ddl_City")));
	city.selectByValue("2");

	//click on "search" button.
	driver.findElement(By.xpath("(//input[@id='btnSearch'])[1]")).click();

	//Verify search results is displayed or not.
	driver.equals("Schools Search");
	System.out.println("Search for Schools is Verified and Displayed.");

	//close the browser.
	driver.quit();
	

}
}
	


