package steps;

import base.BaseMethods;
import base.BrowserSetup;
import base.EyesManager;
import base.FileUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import linkedinPages.LinkedinHomePage;
import linkedinPages.MyAccountPage;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import static base.EyesManager.validatePDF;
import static dataProvider.PropertiesFileReader.readPropertiesFile;
import static tests.TestBase.driver;

public class SaveLinkedinCvSteps {

    Properties readPropertiesFile = readPropertiesFile("src/main/resources/Config.properties");


    @Given("The user in Linkedin website")
    public void the_user_in_linkedin_website() throws IOException {

        new LinkedinHomePage(driver).openTheWebsite(System.getProperty("LinkedinURL", readPropertiesFile.getProperty("LinkedinURL")));

    }
    @When("User clicks on Sign in button")
    public void user_clicks_on_sign_in_button() throws InterruptedException {
        new BrowserSetup().waitScreen();
       new LinkedinHomePage(driver).clickOnSignIn();
    }
    @When("User login with  email and password")
    public void user_login_with_email_and_password() throws IOException, InterruptedException {
        new BrowserSetup().waitScreen();
        new LinkedinHomePage(driver).LoginToLinkedinAccount(System.getProperty("Email", readPropertiesFile.getProperty("Email")) ,
                System.getProperty("Password", readPropertiesFile.getProperty("Password")));

    }
    @When("User clicks on account picture")
    public void user_clicks_on_account_picture() throws InterruptedException {
        new BrowserSetup();
        BrowserSetup.waitScreen();
        new LinkedinHomePage(driver).clickOnAccountPicture();
    }
    @When("User clicks on More button from account page")
    public void user_clicks_on_more_button_from_account_page() throws InterruptedException {
        new BrowserSetup().waitScreen();
        new BaseMethods(driver).scrollUpDownPage();
        new MyAccountPage(driver).clickOnMoreButton();
        new BrowserSetup().waitScreen();
    }
    @When("User clicks on Save to Pdf from dropdown list")
    public void user_clicks_on_save_to_pdf_from_dropdown_list() {

        new MyAccountPage(driver).clickOnSaveToPDF();
    }

    @Then("File is downloaded successfully")
    public void file_is_downloaded_successfully() throws  InterruptedException {
        File downloadedPDF = new File("C:\\Users\\Lap Smart\\Downloads\\ProfileValidate" + ".pdf");
        String destination =  "validatePDF/ProfileValidate" + ".pdf";
        FileUtils.moveFile(downloadedPDF, destination);


        /*String filePath = "G:\\ITI\\Automation\\NewProjects\\VisualTesting-Applitools\\validatePDF\\";
        new EyesManager(driver);
        EyesManager.validatePDF(filePath);*/

    }

}
