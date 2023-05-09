/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.Tests;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Test;
import sonoranearshore.BaseComponents.BaseTest;
import sonoranearshore.PageObjects.FileDownloadPage;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class FileDownloadTest extends BaseTest{
    private FileDownloadPage fileDLPage;
    
    @Test
    public void testFileDownload() throws InterruptedException {
        // Init Page Object
        fileDLPage = new FileDownloadPage(driver);
        
        // Navigate to the corresponding URL
        fileDLPage.GoTo(prop.getProperty("fileDLURL"));
        
        // Download corresponding file
        fileDLPage.DownloadFile();

        Thread.sleep(5000); // Wait for download to complete
        
        // Validate that the file has been downloaded
        File downloadedFile = new File(fileDLPage.getDownloadLocation() + "/some-file.txt");
        Assert.assertTrue(downloadedFile.exists());
    }
    
}
