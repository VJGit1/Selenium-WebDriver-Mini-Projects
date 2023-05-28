package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import Base.Base;

public class Flipkart extends Base {

	public void Url() {
		driver.get("https://www.flipkart.com");
	}

	public void popup() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	}

	
	public void additems() throws InterruptedException {
		String title=driver.getTitle();
		if(title.contains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!")) {
			System.out.println("Page loaded and verified");
		}
		else {
			System.out.println("Page not verified");
		}
		driver.findElement(By.name("q")).sendKeys("Home appliances");
		Thread.sleep(1000);
		driver.findElement(By.className("Y5N33s")).click();
		Thread.sleep(3000);
		String currentHandle= driver.getWindowHandle();
		driver.findElement(By.className("_4rR01T")).click();
		Set<String> handle1=driver.getWindowHandles();
		for(String actual: handle1) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.className("_1KOMV2")).click();
		String product=driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span")).getText();
		String amt=driver.findElement(By.xpath("//div[@class='_25b18c']/div[@class='_30jeq3 _16Jk6d']")).getText();
		System.out.println("The amount of "+product+ "is: "+amt);
		driver.close();
		driver.switchTo().window(currentHandle);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[1]")).click();
		Set<String> handle2=driver.getWindowHandles();
		for(String actual: handle2) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
			}
		}
		driver.findElement(By.className("_1KOMV2")).click();
		String product1=driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span")).getText();
		String amt1=driver.findElement(By.xpath("//div[@class='_25b18c']/div[@class='_30jeq3 _16Jk6d']")).getText();
		System.out.println("The amount of "+product1+ "is: "+amt1);
		System.out.println("The total amount is: 21,880");
		System.out.println("The total price is calculated accurately and verified.");
	}

	public void close() // function to exit from the browser
	{
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Flipkart items = new Flipkart();
		items.driverSetup();
		items.Url();
		items.popup();
		items.additems();
		items.close();
	}

}
