import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverSetup {

	public static WebDriver getDriver() {
		WebDriver driver=null;
		boolean loop=true;
		System.out.println("Enter the browser to be tested in");
		Scanner sc=new Scanner(System.in);
		String browser=sc.nextLine();
		while(loop) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\workspace\\FindAndWorkWithDifferentTypesOfAlerts\\src\\Driver\\chromedriver.exe");
				 driver=new ChromeDriver();
				 loop=false;
				
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\lenovo\\workspace\\FindAndWorkWithDifferentTypesOfAlerts\\src\\Driver\\geckodriver.exe");
	    	    driver=new FirefoxDriver();
	    		loop=false;
			}else {
	    		   System.out.println("Enter a valid browser name \nOr press 0 to exit");
	    		   int exit=sc.nextInt();
	    		   if(exit==0) {
	    			   System.out.println("It is terminating now........");
	    			   System.exit(0);
	    		   }
		       }
	}
		return driver;
	}
}
