package app;

import core.MyTestListener;
import io.qameta.allure.Step;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(MyTestListener.class)
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app =
      new ApplicationManager(System.getProperty("browser", BrowserType.GOOGLECHROME));

  @BeforeSuite(alwaysRun = true)
  @Step("Поднимается браузер")
  public void setUp(ITestContext context) throws Exception {
    app.init();
    context.setAttribute("app", app);
  }

  @AfterSuite(alwaysRun = true)
  @Step("Останавливается браузер")
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  @Step("Начало логирования")
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  @Step("Завершение логирования")
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }
}
