package TestSuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AlertConfirm;

public class AlertCases {
	AlertConfirm obj = new AlertConfirm();
	@BeforeTest
	public void invokeBrowser() {
		obj.driverSetup();
	}

	@Test(priority = 1)
	public void steps() throws InterruptedException {

		obj.navigation();
		obj.alertWithOk();
		obj.alertWithCancel();
		obj.alertWithText();
	}


	@AfterTest
	public void closeBrowser() {
		obj.closeBrowser();
	}
	

}
