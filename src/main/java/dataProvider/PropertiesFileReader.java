package dataProvider;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    public static Properties proObj;

    public static Properties readPropertiesFile(String configFilePath) {
        BufferedReader fileObj;
        try {
            fileObj = new BufferedReader(new FileReader(configFilePath));
            proObj = new Properties();
            proObj.load(fileObj);

        } catch (IOException e) {
            throw new RuntimeException("Config.properties not found at " + configFilePath);
        }
        return proObj;

    /*public String readConfigFile(String variable) throws IOException {
        FileInputStream fileObj = new FileInputStream("C:\\Users\\MahfouzR\\OneDrive - Vodafone Group\\Documents\\WebAutomation\\VisualTesting_Example\\src\\main\\resources\\Config.properties");
        Properties proObj = new Properties();
        proObj.load(fileObj);

        String value = (String)proObj.getProperty(variable);
        System.out.println("Value of " + variable + " is " + value);

        return value;
    }
*/
    }}
