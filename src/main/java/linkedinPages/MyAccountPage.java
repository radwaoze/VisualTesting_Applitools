package linkedinPages;

import base.BaseMethods;
import dataProvider.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    static WebDriver driver;
    String MoreButton = "(//div[@class= 'artdeco-dropdown artdeco-dropdown--placement-bottom artdeco-dropdown--justification-left ember-view'])[2]";
    String SaveToPDF = "(//div[@class= 'display-flex align-items-center  artdeco-dropdown__item artdeco-dropdown__item--is-dropdown ember-view'])[5]";

    public MyAccountPage (WebDriver driver)
    {
        MyAccountPage.driver = driver;
    }

    public void clickOnMoreButton()
    {
        BaseMethods.clickOnElement(By.xpath(MoreButton), "elementToBeClickable");
    }

    public void clickOnSaveToPDF()
    {
        BaseMethods.clickOnElement(By.xpath(SaveToPDF), "elementToBeClickable");
    }

}
