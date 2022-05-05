package linkedinPages;

import base.BaseMethods;
import dataProvider.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import websitePages.HomePage;

import java.io.IOException;

public class LinkedinHomePage {
    static WebDriver driver;
    PropertiesFileReader readPropertiesFile;
    String AccountPicture = "//img[@class= 'feed-identity-module__member-photo EntityPhoto-circle-5 lazy-image ember-view']";

    String SignIn = "//a[@class= 'nav__button-secondary' and @href = 'https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin'] ";
    String UserName = "//input[@id= 'username' and @name= 'session_key'] ";
    String Password = "//input[@id= 'password' and @type= 'password'] ";
    String SignInBtn = "//button[text()= 'Sign in' and @type= 'submit'] ";

    public LinkedinHomePage (WebDriver driver)
    {
        LinkedinHomePage.driver = driver;
    }

    public void openTheWebsite(String WebsiteURL) throws IOException {
        new BaseMethods(driver);
        BaseMethods.navigateToAnyWebsite(WebsiteURL);
    }

    public void clickOnSignIn()
    {
        BaseMethods.clickOnElement(By.xpath(SignIn), "elementToBeClickable");
    }

    public void LoginToLinkedinAccount(String UserNameTxt , String PasswordTxt) throws IOException {
        WebElement UserField =  driver.findElement(By.xpath(UserName));
        WebElement PasswordField =  driver.findElement(By.xpath(Password));
        new BaseMethods(driver);
        BaseMethods.enterText(UserField , UserNameTxt);
        BaseMethods.enterText(PasswordField , PasswordTxt);
        BaseMethods.clickOnElement(By.xpath(SignInBtn), "elementToBeClickable");
    }



    public void clickOnAccountPicture()
    {
        BaseMethods.clickOnElement(By.xpath(AccountPicture), "elementToBeClickable");
    }

}
