package app;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  private final By btnSent = By.xpath("//div[text()='Отправленные']");

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  @Step("Нажать в меню Отправленные")
  public void sentLetters() {
    click(btnSent);
  }
}
