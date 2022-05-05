package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {

    static WebDriver driver;


    public WebDriver BrowserName(String browser)
    {
       if(browser.equalsIgnoreCase("Chrome"))
       {
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           return driver;
       }
        else if(browser.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            return driver;
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            return driver;
        }
       /* else if(browser.equalsIgnoreCase("Chrome-Headless"))
       {
           WebDriverManager.chromedriver().setup();

           ChromeOptions options = new ChromeOptions();
           options.addArguments("--headless");
           options.addArguments("--window-size-1290,1080");
           driver = new ChromeDriver(options);
           return driver;
       }*/
        return driver;
    }

    public static void maximizeScreen()
    {
        driver.manage().window().maximize();
    }

    public static void waitScreen() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);

    }

    public static void closeBrowser()
    {
        driver.close();
    }
}
