package api;

import com.epam.locators.config.WaitConfiguration;
import com.epam.locators.config.WebDriverConfiguration;
import com.epam.locators.enumeration.SupportedDrivers;
import com.epam.locators.utils.PageStorage;
import com.epam.locators.utils.WaitUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;


@RunWith(JUnit4.class)
public class BaseTest {
    protected PageStorage storage;
    protected WebDriver driver;


    @Before
    public void initDriver() {
        driver = WebDriverConfiguration.setWebDriver(SupportedDrivers.CHROME);
        WebDriverConfiguration.maximizeWindow();
        storage = new PageStorage();
          }

    @After
    public void tearDown() {
        WebDriverConfiguration.clearCookies();
        WebDriverConfiguration.tearDown();
    }

}