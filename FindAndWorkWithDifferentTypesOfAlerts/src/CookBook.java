//Importing Support Libraries
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookBook {
	WebDriver driver;
	
	//Initiating Webdriver
	public void getDriver()  
	{
		driver=DriverSetup.getDriver();
	}
	//Launching URL
	public void openurl() 
	{
		driver.get("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	//Scenarios #1
	//Clicking Alert box
	public void showAlert() 
	{
		WebElement AlertBox= driver.findElement(By.id("simple"));
		AlertBox.click();
	}
	//Getting text from the Alert box 
	public void checkAlertBoxMsg() throws InterruptedException
	{
		Alert alert= driver.switchTo().alert();  //Switch Window
		System.out.println(alert.getText());
		
		if(alert.getText().contains("Hello! I am an alert box!"))
		{
			System.out.println("Yes, The Alert Box contains Hello! I am an alert box!");
		}
		else
		{		
			System.out.println("No The Alert Box does not contains Hello! I am an alert box!");
		}
		Thread.sleep(3000);
		alert.accept();
	}
	
	//Scenario #2
	//Getting text by clicking first try it button
	public void clickTryButton()
	{
		WebElement TryButton=driver.findElement(By.id("confirm"));
		TryButton.click();
	}
	public void checkTryBoxMsg() throws InterruptedException
	{
		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		
		if(alert.getText().contains("Press a button!"))
		{
			System.out.println("Yes, The Try Box contains Press a button!");
		}
		else
		{
			System.out.println("No, The Try Box does not contains Press a button!");
		}
		Thread.sleep(3000);
		alert.dismiss();
	}
	
	//Scenarios #3
	//Getting text from second try it button
	public void clickSecondTryButton()
	{
		WebElement SecondTryButton=driver.findElement(By.id("prompt"));
		SecondTryButton.click();
	}
	//Entering Name in the text box
	public void enterName() throws InterruptedException
	{
		Alert alert= driver.switchTo().alert(); //Switch Window
		alert.sendKeys("Sreehari");
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(4000);
	}
	
	//TearDown
	public void closeBrowser() {
		driver.quit();
	}
	
	//Main method
	//Calling all methods
public static void main(String[] args) throws InterruptedException, IOException {
		CookBook CB=new CookBook(); //Object Creation
		CB.getDriver();
		CB.openurl();
		CB.showAlert();
		CB.checkAlertBoxMsg();
		CB.clickTryButton();
		CB.checkTryBoxMsg();
		CB.clickSecondTryButton();
		CB.enterName();
		CB.closeBrowser();
	}
	

}

