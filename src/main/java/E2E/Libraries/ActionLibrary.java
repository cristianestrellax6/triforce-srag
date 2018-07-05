package E2E.Libraries;

import E2E.Utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionLibrary extends Waits {

  // Those methods are the common iterations that Selenium use for WebElements
  // wrapped in this class for reusability
  protected void click (WebDriver driver, WebElement element){
    // this method is extended from Waits class that way we can
    // add a wait method just in one place.
    waitForElementToBeClickable(driver,element);
    element.click();
  }

  protected void sendText(WebDriver driver,WebElement element,String text){
    waitForElementToBeClickable(driver,element);
    element.clear();
    element.sendKeys(text);
  }

  protected boolean isDisplayed(WebDriver driver,WebElement element){
    waitForElementToBeDisplayed(driver,element);
    return element.isDisplayed();
  }

}
