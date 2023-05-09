/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class FileDownloadPage {

    WebDriver driver;
    String downloadLocation;

    public FileDownloadPage(WebDriver driver) {
        // Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void GoTo(String url) {
        driver.get(url);
    }

    @FindBy(linkText = "some-file.txt")
    WebElement fileLink;

    public void DownloadFile() {
        setDownloadLocation();
        fileLink.click();
    }

    public void setDownloadLocation() {
        downloadLocation = System.getProperty("user.dir");
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }
}
