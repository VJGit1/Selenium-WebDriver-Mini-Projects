package Pages;

import Base.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

public class AlertConfirm extends base {
  WebElement values;

  public void navigation() {
    driver.get("http://demo.automationtesting.in/Alerts.html");
  }

  // Alert with OK
  public void alertWithOk() {
    System.out.println("Handling alert with ok started ");
    WebElement switchTo = driver.findElement(By.linkText("SwitchTo"));
    mouseHover(switchTo); // switchTo element is identified and mouse hovers to it

    WebElement alert = driver.findElement(By.linkText("Alerts"));
    mouseHover(alert);// Alert element is identified and mouse hovers to it
    alert.click();// Alert element is clicked
    WebElement alertOk = driver.findElement(By.id("OKTab"));
    mouseHover(alertOk);// alertOK element is identified and mouse hovers to it

    alertOk.click();// alertOk is clicked

    try {
      driver.switchTo().alert().accept();// accepts the alert if present
    } catch (NoAlertPresentException e) {
      System.out.println("No alert found"); // Displays message if alert is not found
    }

    System.out.println("Alert with ok Handled successfully ");
  }

  // Alert with OK & Cancel element
  public void alertWithCancel() {
    System.out.println("Handling alert with cancel started");

    (driver.findElement(By.linkText("Alert with OK & Cancel"))).click();

    WebElement alertWithCancel = driver.findElement(By.id("CancelTab"));
    mouseHover(alertWithCancel); // alertWithCancel element is identified and mouse hovers to it

    alertWithCancel.click();// alertWithCancel is clicked

    try {

      driver.switchTo().alert().dismiss();// dismisses the alert if present
    } catch (NoAlertPresentException e) {
      System.out.println("No alert found"); // Displays message if alert is not found
    }

    System.out.println("Alert with Cancel Handled successfully ");
  }

  // handles alert which is having textbox,OK and cancel
  public void alertWithText() {
    System.out.println("Handling alert with text started ");

    (driver.findElement(By.linkText("Alert with Textbox"))).click();// Alert with Textbox element is identified and
                                    // clicked

    WebElement alertWithTextbox = driver.findElement(By.cssSelector(".btn-info"));
    mouseHover(alertWithTextbox);// alertWithTextbox element is identified and mouse hovers to it

    alertWithTextbox.click();// alertWithTextbox is clicked

    try {

      driver.switchTo().alert().sendKeys("Maredla Omkar");
      driver.switchTo().alert().accept();
      values = driver.findElement(By.id("demo1"));

      // accepts the alert if present
    } catch (NoAlertPresentException e) {
      System.out.println("No alert found"); // Displays message if alert is not found
    }
    System.out.println("Alert with text Handled successfully ");
    System.out.println("Prompt return :" + values.getText());

  }
  public static void main(String[] args) throws InterruptedException{
    AlertConfirm obj = new AlertConfirm();
    obj.driverSetup();
    obj.navigation();
    obj.alertWithOk();
    obj.alertWithCancel();
    obj.alertWithText();
    obj.closeBrowser();
  }
  
}