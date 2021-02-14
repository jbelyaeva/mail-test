package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  private final By login = By.name("login");
  private final By domain = By.name("domain");
  private final By btnEnterPassword = By.xpath("//button[@data-testid='enter-password']");
  private final By password = By.name("password");
  private final By btnSingUpToMail = By.xpath("//button[@data-testid='login-to-mail']");
  private final String selectDomainInList = "//option[@value='{domainUser}']";

  public SessionHelper(WebDriver wd) {
    super(wd);
  }
  private  String getDomainByName(String domainUser){
    return selectDomainInList.replace("{domainUser}",domainUser);
  }

  public void login(String username, String domainUser, String passwordUser) {
    type(login, username);
    click(domain);
    click(By.xpath(getDomainByName(domainUser)));
    click(btnEnterPassword);
    type(password, passwordUser);
    click(btnSingUpToMail);
  }
}
