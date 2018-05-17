package automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

public class BaseTest {
    @BeforeClass
    public void initialize() {
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.startMaximized = true;
    }

    @AfterClass
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}
