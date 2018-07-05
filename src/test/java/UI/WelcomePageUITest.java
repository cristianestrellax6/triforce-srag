package UI;

import UI.Base.BaseUiTest;
import UI.DataProviders.TestDevice;
import UI.DataProviders.TestDeviceProvider;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by cristian on 5/21/18.
 */
public class WelcomePageUITest extends BaseUiTest {

  @Test(dataProvider = "devices", dataProviderClass = TestDeviceProvider.class)
  public void welcomeTests(TestDevice device) throws IOException {
    load("/");
    checkLayout("src/main/java/UI/GalenSpecs/tests/WelcomePage.gspec",device.getTags());
  }

  @Test(dataProvider = "devices", dataProviderClass = TestDeviceProvider.class)
  public void loginTests(TestDevice device) throws IOException {
    load("/");

    getDriver().findElement(By.className("button-login")).click();
    checkLayout("src/main/java/UI/GalenSpecs/tests/LoginPage.gspec",device.getTags());
  }

  @Test(dataProvider = "devices", dataProviderClass = TestDeviceProvider.class)
  public void myNotesTests(TestDevice device) throws IOException {
    load("/");

    getDriver().findElement(By.className("button-login")).click();
    getDriver().findElement(By.name("login.username")).sendKeys("testuser@example.com");
    getDriver().findElement(By.name("login.password")).sendKeys("test123");
    getDriver().findElement(By.className("button-login")).click();

    checkLayout("src/main/java/UI/GalenSpecs/tests/MyNotesPage.gspec",device.getTags());
  }

}
