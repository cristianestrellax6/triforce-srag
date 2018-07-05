package UI.DataProviders;

import static java.util.Arrays.asList;

import org.openqa.selenium.Dimension;
import org.testng.annotations.DataProvider;

/**
 * Created by cristian on 5/21/18.
 */
public class TestDeviceProvider {

  @DataProvider(name = "devices", parallel = true)
  public static Object [][] devices () {
    return new Object[][] {
        {new TestDevice("desktop", new Dimension(1300, 800), asList("desktop"))},
        {new TestDevice("tablet", new Dimension(800, 800), asList("tablet"))},
        {new TestDevice("mobile", new Dimension(500, 800), asList("mobile"))}
    };
  }

}
