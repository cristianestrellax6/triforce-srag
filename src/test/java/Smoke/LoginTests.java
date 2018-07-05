package Smoke;

import E2E.Base.BaseTest;
import E2E.DataProviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest
{

  // Tests should be independent for future parallel testing
  // they should have awesome readability so anyone can understand
  // all logic should be inside pageObject not on tests
  // only steps and assertions
  // only tests related to the test class name
  // if any data is needed create a DataProvider.
  @Test(dataProvider = "invalidLoginCredentials",dataProviderClass = LoginDataProvider.class)
  public void invalidLoginTest (String username,String password)  {
    loginPage.getLoginPage();
    loginPage.clickLogin();
    loginPage.setUsername(username);
    loginPage.setPassword(password);
    loginPage.clickLogin();

    Assert.assertTrue(loginPage.isLoginAlertDisplayed());
  }

  @Test
  public void validLoginTest() {
    loginPage.fullLogin();

    Assert.assertTrue(otherPage.isMyFormPageDisplayed());
  }

}
