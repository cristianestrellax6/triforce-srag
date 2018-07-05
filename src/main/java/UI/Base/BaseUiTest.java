package UI.Base;

import E2E.PageObjects.FormPage;
import E2E.PageObjects.LoginPage;
import UI.DataProviders.TestDevice;
import com.galenframework.testng.GalenTestNgTestBase;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseUiTest extends GalenTestNgTestBase
{

  private static final String ENV_URL = "http://testapp.galenframework.com";
  private static URL GRID_URL;

  static {
    try {
      GRID_URL = new URL("http://127.0.0.1:4444/wd/hub");
    }catch (MalformedURLException e){
      e.printStackTrace();
    }
  }

  @Override
  public WebDriver createDriver(Object[] args)  {
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

    WebDriver driver = new RemoteWebDriver(GRID_URL, chromeOptions);
//    WebDriver driver =  new ChromeDriver(chromeOptions);

    if (args.length > 0) {
      if (args[0] != null && args[0] instanceof TestDevice) {
        TestDevice device = (TestDevice)args[0];
        if (device.getScreenSize() != null) {
          driver.manage().window().setSize(device.getScreenSize());
        }
      }
    }
    return driver;
  }

  public void load(String uri) {
    getDriver().get(ENV_URL + uri);
  }

}
