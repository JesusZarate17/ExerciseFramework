/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import sonoranearshore.BaseComponents.BaseTest;
import sonoranearshore.PageObjects.FileUploadPage;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class FileUploadTest extends BaseTest{
    
    private FileUploadPage fileUploadPage;
    
    @Test
    public void testFileUpload() throws IOException{
        // Init Page Object
        fileUploadPage = new FileUploadPage(driver);
        
        // Navigate to the upload page
        fileUploadPage.GoTo(prop.getProperty("fileULURL"));
        
        // Create file
        fileUploadPage.CreateTextFile();
        
        // Upload created file
        fileUploadPage.uploadFile();

        // Get the uploaded file name from the result message and
        // verify that the uploaded file name is correct
        Assert.assertEquals(fileUploadPage.getUploadedFileText(), "test.txt");
    }
}
