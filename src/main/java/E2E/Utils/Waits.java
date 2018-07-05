package E2E.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

  // Those methods are wrapped from WebDriverWait class from selenium
  // if any other wait is needed please added following the same logic or a better one
  // this way we can reuse wait class on ActionLibrary level
  protected Waits waitForElementToBeClickable(WebDriver driver, WebElement element) {
    WebDriverWait wait =new WebDriverWait(driver,2);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    return this;
  }

  protected Waits waitForElementToBeDisplayed(WebDriver driver,final WebElement element) {
    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver d) {
        return element.isDisplayed();
      }
    });
    return this;
  }

}
