package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class base {
	public static WebDriver driver;
	public static Properties prop;

	public void driverSetup() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/java/Config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prop.getProperty("browserName").matches("chrome")) {
			driver = new ChromeDriver();
		}
		if (prop.getProperty("browserName").matches("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		Action mouse = action.moveToElement(element).build();
		mouse.perform();
	}

	public static String getUrl() {
		return prop.getProperty("url"); // gets propety with key url from properties file and returns it.
	}

	public static String getText() {
		return prop.getProperty("text");// gets propety named with key text properties file and returns it.
	}

	public void closeBrowser() {
		driver.quit();
	}

}
