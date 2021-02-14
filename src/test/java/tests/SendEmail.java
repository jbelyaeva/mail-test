package tests;

import app.TestBase;
import data.Email;
import data.ProviderData;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SendEmail extends TestBase {

  @Description(value = "Тест проверяет отправку письма")
  @Test(dataProvider = "validEmailDataJson", dataProviderClass = ProviderData.class)
  public void testSendEmail(Email letter) {
    String pref = String.valueOf(Math.random());
    app.email().btnNewLetter();
    app.email().fillNewLetter(letter, pref);
    app.email().btnSend();
    app.check().textElement(app.email().getLabelThatEmailsPosted(), "Письмо отправлено");
    app.email().closeWindowInfo();
    app.goTo().sentLetters();
    app.check().findElement(app.email().getNewEmail(letter.getTopic() + pref));
  }
}
