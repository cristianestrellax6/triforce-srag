package Smoke;

import E2E.Base.BaseTest;
import E2E.DataProviders.OtherDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FormPageTests extends BaseTest {

  @Test(dataProvider = "formData",dataProviderClass = OtherDataProvider.class)
  public void myNotesTest(String title,String description) {
    loginPage.fullLogin();
    otherPage.clickAddForm();
    otherPage.setFormTitle(title);
    otherPage.setFormDescription(description);
    otherPage.clickAddForm();

    Assert.assertTrue(otherPage.isMyFormDisplayed(title,description));
  }

}
