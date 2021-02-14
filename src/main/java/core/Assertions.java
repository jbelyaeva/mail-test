package core;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.AssertJUnit.assertTrue;

import app.HelperBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assertions extends HelperBase {

  public Assertions(WebDriver wd) {
    super(wd);
  }

  /* проверяет текст элемента с заданым значением
   * @locator - локатор элемента
   * @text - эталонный текст
   * */
  @Step("Проверка, что элемент имеет соответствующий текст")
  public void textElement(By locator, String text) {
    waitVisibleElement(4, locator);
    assertThat(wd.findElement(locator).getText(), is(text));
  }

  /* проверяет найден ли элемент по локатору
   * @locator - локатор элемента
   * */
  @Step("Проверка, что элемент найден")
  public void findElement(By locator) {
    assertTrue(isElementPresent(locator));
  }
}
