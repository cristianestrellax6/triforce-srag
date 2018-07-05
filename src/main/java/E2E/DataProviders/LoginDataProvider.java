package E2E.DataProviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

  // This is were your providers should live
  // all data should come from one place
  // if any external library is used
  // for data generation make sure is on mvn
  @DataProvider(name = "invalidLoginCredentials")
  public static Object[][] invalidLoginCredentialsProvider(){

    return new Object[][] {
        {"valid","invalid"},
        {"invalid","valid"},
        {"invalid","invalid"},
        {" ","valid"},         //empty - valid
        {"valid"," "},         //valid - empty
        {" "," "}              //empty - empty
    };
  }

  @DataProvider(name = "validLogin")
  public static Object[][] validLoginProvider(){
    return new Object[][] {{"testuser@example.com","test123"}};
  }

}
