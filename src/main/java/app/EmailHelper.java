package app;

import data.Email;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailHelper extends HelperBase {

  private final By inputRecipient = By.xpath("//div[@data-name='to']//input");
  private final By inputSubject = By.xpath("//input[@name='Subject']");
  private final By divTextEmail = By.xpath("(//div[contains(@class,'editable')]//div//div)[1]");
  private final By btnSent = By.xpath("//span[text()='Отправить']");
  private final By labelThatEmailSPosted =
      By.xpath("//div[contains(@class,'sent-page')]//a[contains(@href,'/sent/')]");
  private final String newEmail = "//span[text()='{pref}']";
  private final By btnWindowInfoClose = By.xpath("//span[@title='Закрыть']");
  private final By btnNewEmail = By.xpath("//a[@href='/compose/']");

  public EmailHelper(WebDriver wd) {
    super(wd);
  }

  public By getNewEmail(String pref) {
    return By.xpath(newEmail.replace("{pref}", pref));
  }

  public By getLabelThatEmailsPosted() {
    return labelThatEmailSPosted;
  }

  @Step("Заполнить необходимые поля")
  public void fillNewLetter(Email email, String pref) {
    clickWithOffset(inputRecipient);
    type(inputRecipient, email.getRecipient());
    type(inputSubject, email.getTopic() + pref);
    click(divTextEmail);
    JavascriptExecutor exe = (JavascriptExecutor) wd;
    WebElement element = wd.findElement(divTextEmail);
    exe.executeScript("arguments[0].innerHTML='" + email.getText() + "';", element);
  }

  @Step("Нажать кнопку Отправить")
  public void btnSend() {
    click(btnSent);
  }

  public void closeWindowInfo() {
    click(btnWindowInfoClose);
  }

  @Step("Нажать в меню Написать письмо")
  public void btnNewLetter() {
    click(btnNewEmail);
  }

}
