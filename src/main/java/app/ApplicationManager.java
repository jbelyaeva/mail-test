package app;

import core.Assertions;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {

  public WebDriver wd;
  private final String browser;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private Assertions assertions;
  private EmailHelper generalPageLetter;
  public static Properties properties;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(
        new FileReader(
            String.format("src/test/resources/%s.properties", target)));
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.GOOGLECHROME)) {
      wd = new ChromeDriver();
    }
    wd.get(properties.getProperty("web.baseUrl"));
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    wd.manage().window().maximize();

    sessionHelper = new SessionHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    assertions = new Assertions(wd);
    generalPageLetter = new EmailHelper(wd);
    sessionHelper.login(
        properties.getProperty("web.Login"),
        properties.getProperty("web.Domain"),
        properties.getProperty("web.Password"));
  }

  public void stop() {
    wd.quit();
  }

  public Assertions check() {
    return assertions;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public EmailHelper email() {
    return generalPageLetter;
  }

  public byte[] takeScreenshot() {
    return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
  }
}
