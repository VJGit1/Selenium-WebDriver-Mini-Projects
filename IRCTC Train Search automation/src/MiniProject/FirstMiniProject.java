package MiniProject;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.FileHandler;

public class FirstMiniProject {
	
	private static final By dropdownBtn = null;
	public static WebDriver driver;

//verify the correct page opened.
	public void verify()
	{
		String expResult = "IRCTC Next Generation eTicketing System";
		String actResult=driver.getTitle();
		if(actResult.equalsIgnoreCase(expResult))
			System.out.println("Website launch is IRCTC Train");
		else
			System.out.println("Website launch is incorrect");
		
	}
	
//Accept the Alert messages, if no messages continue to next step.
	public void okbutton()
	{
		driver.findElement(By.xpath("//button[@type='submit' and @class=\"btn btn-primary\"]")).click();
	}
	
//Enter "Hyd" in “From city” field, in the auto search results, select the "HYDERABAD DECAN - HYB" station
	public void selectFrom() throws InterruptedException
	{
		WebElement from =driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input"));
		from.sendKeys("Hyd");
		Thread.sleep(3000);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
//Enter "Pune" in "To city” field, in the auto search results, select the "PUNE JN - PUNE" station
	public void selectTo() throws InterruptedException
	{
		WebElement to = driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input"));
		to.sendKeys("Pune");
		Thread.sleep(3000);
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

//Choose future date after 4days from today in the journey date field.
	public void choosedate() throws InterruptedException
	{
	By dropdownBtn;
	   driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/input"));
	   driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/input")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[2]/table/tbody/tr[4]/td[1]/a")).click();
	  
	}

//Select the checkbox "Divyaang concession"
	public void Divyaangcheckbox() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[4]/div/span[1]/label")).click();
	    Thread.sleep(3000);
	}
	
//clicking on ok button
	public void checkbutton() throws InterruptedException
	{
	    driver.findElement(By.xpath("//span[@class='ui-button-text ui-clickable']")).click();
	    Thread.sleep(3000);
	}

	                 
//Select "Sleeper Class" from all classes dropdown box.
	public void selectClass() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[@class='ng-tns-c66-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")).click();
	    Thread.sleep(2000);
	    //select class sleeper
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Sleeper (SL)')]")).click();
	    Thread.sleep(3000);
	}
	               
	               
//Click on "Find trains" button.
	public void search() throws InterruptedException
	{
		int count=0;
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[5]/div/button")).click();
		String beforeXpath="/html/body/app-root/app-home/div[3]/div/app-train-list/div[4]/div/div[5]/div[";
		String afterXpath="]/div[1]/app-train-avl-enq/div[1]/div[1]/div[1]";
		for(int i=1;i<=5;i++) {
		String actualXpath=beforeXpath+i+afterXpath;
		List<WebElement> results =driver.findElements(By.xpath(actualXpath));
		count+=results.size();
		
//Display the number of trains available and names on console
		for (WebElement webElement : results) {
			System.out.println("Name and Number of the available train is:-"+webElement.getText());
			}
		}
		System.out.println("Total number of Results-"+count);
		
	}

		
//Capture the results screenshot.
	public void screenshot()
	{
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File Src = srcShot.getScreenshotAs(OutputType.FILE);
		String filePath=".\\Screenshots\\screenshot.png";
		File Dest = new File(filePath);
		try {
			FileHandler.copy(Src, Dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
			driver.close();
			
			
	System.out.println("Screenshot successfully");

	}


//MAIN METHOD
	public static void main(String[] args) throws Exception {
        
driver=null;
while(true) {
	 System.out.println("Enter Browser Name or 0 to Exit");
	 @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	 String browser = sc.nextLine();
	 if(browser.equalsIgnoreCase("0")) {
		 System.out.println("Program terminatted");
		 System.exit(0);
	 }
	 else if(!(browser.equalsIgnoreCase("chrome")|| browser.equalsIgnoreCase("firefox"))) {
		 System.out.println("Invalid browser name, ");
		 continue;
	 }
	
	 else if(browser.equalsIgnoreCase("firefox")) 
	 	{
		System.setProperty("webdriver.gecko.driver","./Resources/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options); 
		}
	 
	 else if(browser.equalsIgnoreCase("chrome")) {
// To launch application in Chrome browser
	 	System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
	 	driver = new ChromeDriver();
		
	 	
	 	
	 	
	 }
//launching IRCTC Train website
		driver.get(" https://www.irctc.co.in");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		FirstMiniProject train=new FirstMiniProject();
		train.verify();
		train.okbutton();
		train.selectFrom();
		train.selectTo();
		train.choosedate();
		train.Divyaangcheckbox();
		train.checkbutton();
		train.selectClass();
		train.search();
		train.screenshot();     
   }

	}

}