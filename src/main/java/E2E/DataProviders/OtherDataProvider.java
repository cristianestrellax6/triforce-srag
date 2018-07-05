package E2E.DataProviders;

import org.testng.annotations.DataProvider;

public class OtherDataProvider {


  @DataProvider(name = "formData")
  public static Object[][] formDataProvider(){
    double randomNumber=(Math.random() * 99) + 1;

    return new Object[][] {
        {"title"+randomNumber,"description"+randomNumber}
    };
  }

}
