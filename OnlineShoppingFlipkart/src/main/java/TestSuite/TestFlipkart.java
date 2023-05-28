package TestSuite;

import org.testng.annotations.Test;

import Pages.Flipkart;

public class TestFlipkart {

	@Test
	public void execute() throws InterruptedException{
		Flipkart items = new Flipkart();
		items.driverSetup();
		items.Url();
		items.popup();
		items.additems();
		items.close();
	}
}
