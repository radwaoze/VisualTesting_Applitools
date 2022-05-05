package tests;

import base.BrowserSetup;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeClass
    @Parameters("browserName")
    public void setup(@Optional("Chrome") String browserName){
       driver = new BrowserSetup().BrowserName(browserName);
        BrowserSetup.maximizeScreen();
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screen = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screen , new File("./screenshots/" + result.getTestName()+ ".png"));
        }
    }

    @AfterClass
    public void afterSuite()
    {
        BrowserSetup.closeBrowser();
    }
}
