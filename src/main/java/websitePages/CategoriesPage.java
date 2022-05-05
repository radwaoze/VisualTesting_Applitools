package websitePages;

import base.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesPage {

    static WebDriver driver;
    String Clothing = "//a[@href='/clothing' and text()=' Clothing '] ";

    public CategoriesPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnClothing(String Category)
    {
        new BaseMethods(driver);
        BaseMethods.clickOnElement(By.xpath(Clothing), "elementToBeClickable");
    }
}
