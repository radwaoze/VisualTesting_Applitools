package websitePages;

import base.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClothingPage {

    static WebDriver driver;


    public ClothingPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnClothing(String Categories)
    {
        new BaseMethods(driver);
        BaseMethods.clickOnElement(By.xpath(Categories), "elementToBeClickable");
    }

    public void clickOnClothingItem(String LevisJeans)
    {
        new BaseMethods(driver);
        BaseMethods.clickOnElement(By.xpath(LevisJeans), "elementToBeClickable");
    }

}
