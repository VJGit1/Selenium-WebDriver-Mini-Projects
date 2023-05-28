package com.firstpro;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//selenium-sever-4.1.2.jar

public class AddEditEmployeeDetail
{
	public static WebDriver driver;
	private Scanner sc;
	
// Method to launch the chrome browser
	public static void chromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
// Method to launch the Edge browser
	public static void edgeBrowser()
	{
		System.setProperty("webdriver.edge.driver",".\\driver\\msedgedriver.exe");
		driver =new EdgeDriver();
	}
	
//Method to launch the firefox browser
	public static void fireFox()
	{
		System.setProperty("webdriver.gecko.driver",".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	public void launchUrl()
	{
		
// Launching The URL
		driver.manage().window().maximize();	
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	public void loginPage()
	{
// Log In Page
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		driver.findElement(By.name("Submit")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	public void navPimPage()
	{
		
// Navigates to PIM page
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	public void addEmp()
	{
		
//Adds Employee Details
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("firstName")).sendKeys("Varun"); 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("middleName")).sendKeys("Raj"); 
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("lastName")).sendKeys("Sharma");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("employeeId")).clear(); 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
//Saves The Details
		driver.findElement(By.id("btnSave")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	}
	public void editEmp()
	{
		
//Clicks edit button
		driver.findElement(By.id("btnSave")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//Selects marital status as single
		Select maritalStatus=new Select(driver.findElement(By.id("personal_cmbMarital")));
		maritalStatus.selectByVisibleText("Single");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//Selects Gender as Female
		driver.findElement(By.id("personal_optGender_2")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//Selects Nationality as Indian
		Select nation=new Select(driver.findElement(By.id("personal_cmbNation")));
		nation.selectByVisibleText("Indian");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("btnSave")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	}
	public void quitBrowser()
	{
		
//close the Browser     
		System.out.println("Added and Edited the details succesfully...");
		driver.quit();

	}
	public void browserSelect()
	{
		
//Option to choose the browser
		System.out.println("Select your Browser\n 1.Chrome\n 2.Firefox\n 3.Edge");
		sc = new Scanner(System.in);
		int choice=sc.nextInt();
		
//selecting the required browser with variable
		if(choice==1)
		{
			chromeBrowser();
		}
		else if(choice==2){
			fireFox();
		}
		else {
			edgeBrowser();
		}


	}
	public static void main(String[] args) throws InterruptedException
	{
		
//Creating object to call methods
		AddEditEmployeeDetail ae=new AddEditEmployeeDetail();
		
//Method calling
		ae.browserSelect();
		ae.launchUrl();
		ae.loginPage();
		ae.navPimPage();
		ae.addEmp();
		ae.editEmp();
		ae.quitBrowser();

	}
}


