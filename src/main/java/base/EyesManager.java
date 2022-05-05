package base;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;

import static dataProvider.PropertiesFileReader.readPropertiesFile;
import static java.nio.charset.StandardCharsets.UTF_8;

public class EyesManager {
    protected static Eyes eyes;
    static WebDriver driver;
    static Properties readPropertiesFile = readPropertiesFile("src/main/resources/Config.properties");


    public EyesManager(WebDriver driver) {
        EyesManager.driver = driver;
    }

    public static void initializingEyes()  {
        eyes = new Eyes();
        eyes.setApiKey( System.getProperty("applitools.api.key", readPropertiesFile.getProperty("applitools.api.key")));
    }

    /*
        // if you want to write test name manually
        // eyes.open(driver , websiteName, testName);

        //eyes.setForceFullPageScreenshot(true); // if you want long screenshot

        // if you want to get test name automatically [ getMethodName , getClassName , getModuleName , ....]
        //eyes.open(driver , websiteName, Thread.currentThread().getStackTrace()[2].getMethodName());


        //eyes.setMatchLevel(MatchLevel.STRICT); // like human eyes used by default in selenium [avoid false positive failure]
        //eyes.setMatchLevel(MatchLevel.CONTENT); // ignore colors [same stricts with ignoring colors]
        //eyes.setMatchLevel(MatchLevel.EXACT);  // validate pixel by pixel [not recommended]
        eyes.setMatchLevel(MatchLevel.LAYOUT); // we used it incase of dynamic content [element positions]
     */
    public static void validateWindow(String websiteName, String testName)  {
        initializingEyes();

        // if you want to write test name manually
        eyes.open(driver , websiteName, testName);

        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.checkWindow();
        eyes.close();
    }
    public void validateWebElement(String websiteName, String testName , WebElement element) {

        initializingEyes();
        eyes.open(driver , websiteName, testName);

        // we can use any match level
        eyes.setMatchLevel(MatchLevel.STRICT);
        eyes.checkElement(element);
        eyes.close();
    }
    public void validateFrame(String websiteName, String testName , WebElement frame){

        initializingEyes();
        eyes.open(driver , websiteName, testName);
        eyes.setMatchLevel(MatchLevel.CONTENT);
        eyes.checkFrame(frame);
        eyes.close();
    }

    public void closeEyes()
    {
        eyes.abortIfNotClosed();
    }

    public static boolean validatePDF(String filepath) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        String command = String.format(
                "java -jar resources/ImageTester_2.3.3.jar -k '%s' -f '%s'",
                System.getProperty("applitools.api.key", readPropertiesFile.getProperty("applitools.api.key")),
                        filepath);


        Process process = rt.exec(command);
       // Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        String stream = IOUtils.toString(process.getInputStream(), UTF_8);
        System.out.println(stream);

        if(stream != null && stream.contains("Mismatch")){
            return false;
        }

        return true;
    }
}
