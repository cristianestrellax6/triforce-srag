package E2E.Base;

import E2E.PageObjects.FormPage;
import E2E.PageObjects.LoginPage;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest
{

  // Private because webDriver is only used in this class
  private WebDriver driver;
  // Protected because pageObjects are going to be used in Test Classes when extended
  protected LoginPage loginPage;
  protected FormPage otherPage;

  private static final String ENV_URL = "http://testapp.galenframework.com";
  private static URL GRID_URL;

  static {
    try {
      GRID_URL = new URL("http://127.0.0.1:4444/wd/hub");
    }catch (MalformedURLException e){
      e.printStackTrace();
    }
  }

  @BeforeClass(alwaysRun = true)
  protected void setup() {
    // Desired Browser should be declared here
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    ChromeOptions chromeOptions = new ChromeOptions();

    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--disable-infobars");
    chromeOptions.addArguments("--disable-gpu");
    chromeOptions.addArguments("--test-type");
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--disable-dev-shm-usage");

    chromeOptions.merge(capabilities);

    driver = new RemoteWebDriver(GRID_URL, chromeOptions);

//    driver = new ChromeDriver(chromeOptions);


    // SetUp is the right place to initialize your pageObjects with PageFactory
    loginPage = PageFactory.initElements(driver, LoginPage.class);
    otherPage = PageFactory.initElements(driver, FormPage.class);
  }

  @Deprecated
  @AfterClass(alwaysRun = true)
  protected void tearDown() {
    // Always quit driver after each test class,
    // if any more steps are needed after test class is ran, tearDown is the right place
    driver.quit();
  }

}
