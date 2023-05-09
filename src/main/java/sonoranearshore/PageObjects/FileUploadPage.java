/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.PageObjects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class FileUploadPage {
    WebDriver driver;
    File file;
    
    public FileUploadPage(WebDriver driver) {
        // Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void GoTo(String url){
        driver.get(url);
    }
    
    public void CreateTextFile(){
        String fileName = "test.txt";
        String fileContent = "testing";

        try {
            file = new File(fileName);

            // create new file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            // create file writer and buffered writer
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // write content to file
            bw.write(fileContent);

            // close writers
            bw.close();
            fw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FindBy(id = "file-upload")
    WebElement fileInput;
    
    @FindBy(id = "file-submit")
    WebElement uploadButton;
    
    public void uploadFile(){
        fileInput.sendKeys(file.getAbsolutePath());
        uploadButton.click();
    }
    
    @FindBy(id = "uploaded-files")
    WebElement uploadedFile;
    
    public String getUploadedFileText(){
        return uploadedFile.getText();
    }
}
