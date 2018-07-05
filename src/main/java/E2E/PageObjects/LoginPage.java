package E2E.PageObjects;

import E2E.DataProviders.LoginDataProvider;
import E2E.Libraries.ActionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ActionLibrary
{

  private WebDriver driver;

  // Locators should use the @FindBy annotation PageFactory gonna be looking for those
  // Always consider using id, name, className, linkText, css, in that priority order
  // leave xpath as last resource
  @FindBy(name = "login.username")
  private WebElement username;

  @FindBy(name = "login.password")
  private WebElement password;

  @FindBy(className = "button-login")
  private WebElement loginButton;

  @FindBy(id = "login-error-message")
  private WebElement loginAlert;

  // This is the constructor that PageFactory uses to send the driver reusing it
  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  // Each locator should have his own method for needed actions that could be done
  public void setUsername(String username) {
    // This method is from ActionLibrary extended in this class
    // is useful to wrap selenium interactions and add more logic if needed
    // in this case same driver is sent used by WebDriverWait, waiting before action happen
    // the WebElement and the text is also sent.
    // If some action is not on ActionLibrary
    // feel free to add new following same logic or a better one
    sendText(driver, this.username,username);
  }

  public boolean isLoginAlertDisplayed() {
    return isDisplayed(driver,loginAlert);
  }

  public void setPassword(String password) {
    sendText(driver, this.password,password);
  }

  public void clickLogin() {
    click(driver, loginButton);
  }

  // used to get the loginPage url no wrapping needed
  public void getLoginPage() {
    driver.get("http://testapp.galenframework.com/#");
  }

  // If steps are needed on other testClass this is a good practice.
  // Adding a new method with all the steps needed to reach a place inside a web page
  // so we can reuse it when needed without adding extra logic
  public void fullLogin() {
    Object[][] userPass = LoginDataProvider.validLoginProvider();

    getLoginPage();
    click(driver, loginButton);
    sendText(driver, username,userPass[0][0].toString());
    sendText(driver, password,userPass[0][1].toString());
    click(driver, loginButton);
  }

}
