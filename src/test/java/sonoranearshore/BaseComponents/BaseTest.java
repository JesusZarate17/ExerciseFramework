/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.BaseComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class BaseTest {

    public WebDriver driver;
    public Properties prop;

    @BeforeMethod
    public void setUp() throws IOException {
        // Properties class
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/main/java/sonoranearshore/resources/GlobalData.properties");
        prop.load(fis);
        
        // Initialize WebDriver
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Quit WebDriver 
        driver.quit();
    }
}
