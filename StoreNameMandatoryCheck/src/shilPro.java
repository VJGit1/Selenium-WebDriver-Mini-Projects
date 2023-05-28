
//package declaration



//import statements

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//creating class

public class shilPro {

// elements declaration

static WebDriver driver;

//invoking chrome browser

public static void chromeBrowser()
{
System.setProperty("webdriver.chrome.driver","./abc/chromedriver.exe");
  driver = new ChromeDriver();
}

//invoking edge browser

public static void edgeBrowser()
{
System.setProperty("webdriver.edge.driver","C:\\Users\\Lenovo\\eclipse-workspace\\program\\driverrr\\msedgedriver.exe");
driver = new EdgeDriver();

}

//main function

public static void main (String[] arg) throws InterruptedException,
IOException {
System.out.println("select your browser 1.chrome 2.edge");
Scanner sc=new Scanner(System.in);

//selecting browser

int choice=sc.nextInt();
if(choice==1)
chromeBrowser();
else
edgeBrowser();

//navigating to the url

driver.get("https://www.shopify.in/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//locate and click start free trial

driver.findElement(By.xpath("/html/body/header/div[1]/nav/ul[3]/li[4]/form/input"));
driver.findElement(By.xpath("/html/body/header/div[1]/nav/ul[3]/li[4]/form/input")).click();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//enter email address

driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/div[1]/div/label/input")).sendKeys("ABC123@gmail.com");

//enter password

driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/label/input")).sendKeys("ABC12345");

//locate and click create store

driver.findElement(By.xpath("//button[@name='button']")).click();
Thread.sleep(2000);

//verifying error message

boolean Error =driver.getPageSource().contains("Please enter a store name");
boolean checkLogo = false;
if(!checkLogo)
{
System.out.println("Error message is displaying");
}
else
{
System.out.println("Error message is not displaying");

}

//quitting the browser

driver.quit();

}

}



