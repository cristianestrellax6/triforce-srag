package E2E.PageObjects;

import E2E.Libraries.ActionLibrary;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends ActionLibrary {

  private WebDriver driver;

  @FindBy(className = "btn-primary")
  private WebElement addFormButton;

  @FindBy(name = "note.title")
  private WebElement formTitle;

  @FindBy(name = "note.description")
  private WebElement formDescription;

  @FindBy(className = "list-group-item-heading")
  private List<WebElement> titlelist;

  @FindBy(className = "list-group-item-text")
  private List<WebElement> descriptionList;

  @FindBy(id = "my-notes-page")
  private WebElement myFormPage;


  public FormPage(WebDriver driver) {
    this.driver =driver;
  }

  public void clickAddForm() {
    click(driver, addFormButton);
  }

  public void setFormTitle(String title) {
    sendText(driver, formTitle,title);
  }

  public void setFormDescription(String description) {
    sendText(driver, formDescription,description);
  }

  public boolean isMyFormPageDisplayed() {
    return isDisplayed(driver, myFormPage);
  }

  public boolean isMyFormDisplayed(String formTitle,String description) {
    boolean isDisplayed = false;

    for (int i = 0; i < titlelist.size(); i++) {
      if (titlelist.get(i).getText().equals(formTitle) &&
          descriptionList.get(i).getText().equals(description)){
          isDisplayed=true;
      }
    }

    return isDisplayed;
  }

}
