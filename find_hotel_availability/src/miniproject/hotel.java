package miniproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hotel {

	public static <WebElements> void main(String[] args) throws InterruptedException {
		String month="December 2022";
		int gday=1;
		int bday=4;
		int user=1;
		
		System.setProperty("webdriver.chrome.driver", "P:\\browserdrivers\\chromedriver.exe");
		
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.trivago.in/");//Open the application https://www.trivago.in/ in chrome 
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"input-auto-complete\"]")).sendKeys("M0u0m0b0a0i");
		//In search field, enter City “Mumbai” as destination.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Hotel')]")).click();
		Thread.sleep(3000);

		while(true)
		{
			String text = driver.findElement(By.xpath("//button[@class='cursor-auto font-bold']")).getText();
			if(text.equals(month)) 
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='inline-flex leading-none transform']")).click();
			}
		}
		driver.findElement(By.xpath("//table[@class='w-auto leading-none']//span[contains(text(),"+ gday+")]")).click();
		driver.findElement(By.xpath("//table[@class='w-auto leading-none']//span[contains(text(),"+ bday+")]")).click();

		Thread.sleep(2000);
		//Select Check-In Date for the next week (e.g. 27 July)
		//Select Check-Out Date for the next week (e.g.28 July)
			String adults=driver.findElement(By.xpath("//input[@class='hide-spinner w-10 h-9 border border-grey-500 rounded px-2 mx-4 text-center 2xl:rounded-sm']")).getText();
			if(adults.equals(user)) 
			{
				driver.findElement(By.xpath("//strong[contains(text(),'Apply')]")).click();
				
			}
			else
			{
				driver.findElement(By.xpath("//span[@class=\"inline-flex leading-none transform self-center\"]")).click();
			}
			//Select Adults 1
			//Select Rooms 1
			//driver.findElement(By.xpath("//span[contains(text(),' Room')]")).click();
			driver.findElement(By.xpath("//strong[contains(text(),'Apply')]")).click();
			Thread.sleep(3000);
			//Click on Apply.
		driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();//Click on Search.
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//option[contains(text(),'Rating only')]")).click();//Select Sort By “Rating only”
		Thread.sleep(3000);
//		List<WebElement> objlinks= driver.findElements(By.xpath("//li[@class='py-1']"));
//		for(WebElement objcurrentlinks :objlinks) {
//			String list=objcurrentlinks.getText();
//			System.out.println("list");
//		}
//		Get the list of Rent of the hotels displayed.
//		Check that the all the ratings of the hotels is in descending order (e.g. 10.0>9.8>9.6..)
		driver.close();//Close the browser
			
	
	}

}
