package steps;

import base.BaseMethods;
import base.BrowserSetup;
import base.EyesManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import websitePages.CategoriesPage;
import websitePages.ClothingPage;
import websitePages.HomePage;
import tests.TestBase;

import java.io.IOException;
import java.util.Properties;

import static dataProvider.PropertiesFileReader.readPropertiesFile;

public class ChooseClothingItemSteps extends TestBase {

    HomePage homePage;
    String ClothingCategory = "//a[@href='/clothing' and text()=' Clothing '] ";
    String LevisJeans = "//div[@class='picture']//a[@href='/levis-511-jeans']";


    @Given("The user in the Home page")
    public void the_user_in_the_home_page() throws IOException {
        Properties readPropertiesFile = readPropertiesFile("src/main/resources/Config.properties");

        new HomePage(driver).openTheWebsite(System.getProperty("WebsiteURL", readPropertiesFile.getProperty("WebsiteURL")));
        //Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce"));
    }

    @When("User clicks on Apparel in Home page")
    public void user_clicks_on_apparel_in_home_page() throws InterruptedException {
        new BrowserSetup().waitScreen();

        WebElement ApparelText = driver.findElement(By.xpath("//ul[@class= 'top-menu notmobile']//a[@href='/apparel' and text()='Apparel '] "));
        System.out.println(" Apparel hyperlink text is " + ApparelText.getText());

        Assert.assertEquals(ApparelText.getText(), "Apparel");
        homePage = new HomePage(driver);
        homePage.clickOnApparel();
    }

    @When("User clicks on Clothing from Categories")
    public void user_clicks_on_clothing_from_categories() throws InterruptedException {
        new BrowserSetup().waitScreen();
        new BaseMethods(driver).scrollUpDownPage();
        new BrowserSetup().waitScreen();
        WebElement ClothingText = driver.findElement(By.xpath(ClothingCategory));
        Assert.assertEquals(ClothingText.getText() , "Clothing");
        System.out.println(" Category Text is " + ClothingText.getText());
        new CategoriesPage(driver).clickOnClothing(ClothingCategory);
    }

    @When("User chooses a clothing item")
    public void user_chooses_a_clothing_item() {
        new BaseMethods(driver).scrollUpDownPage();
        WebElement LevisJeansText = driver.findElement(By.xpath("//h2[@class='product-title']//a[@href='/levis-511-jeans']"));
        Assert.assertEquals(LevisJeansText.getText() , "Levi's 511 Jeans");
        System.out.println(" LevisJeans Item Text is " + LevisJeansText.getText());
        new ClothingPage(driver).clickOnClothing(LevisJeans);
    }

    @Then("Clothing Item's details displayed")
    public void clothing_item_s_details_displayed() throws IOException {
        new BaseMethods(driver).scrollUpDownPage();

        new EyesManager(driver);
        EyesManager.validateWindow( "E-Commerce", "LevisJeansDetails");
    }
}
