package websitePages;

import base.BaseMethods;
import dataProvider.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage {

    static WebDriver driver;
    PropertiesFileReader readPropertiesFile;
    String Apparel = "//ul[@class= 'top-menu notmobile']//a[@href='/apparel' and text()='Apparel '] ";

    public HomePage (WebDriver driver)
    {
        HomePage.driver = driver;
    }

    public void openTheWebsite(String WebsiteURL) throws IOException {
        new BaseMethods(driver);
        BaseMethods.navigateToAnyWebsite(WebsiteURL);
    }
    public void clickOnApparel()
    {
        BaseMethods.clickOnElement(By.xpath(Apparel), "elementToBeClickable");
    }

}
