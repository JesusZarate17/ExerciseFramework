/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.Tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sonoranearshore.BaseComponents.BaseTest;
import sonoranearshore.PageObjects.AddRemoveElementsPage;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class AddRemoveElementsTest extends BaseTest {
    
    private AddRemoveElementsPage addremPage;
    
    @Test
    public void testAddRemoveElements() {
        // Init Page Object
        addremPage = new AddRemoveElementsPage(driver);
        
        // Navigate to required page
        addremPage.GoTo(prop.getProperty("addRemElemURL"));

        // Add 20 elements
        for(int i=0; i<20;i++){
            addremPage.AddElements();
        }

        // Validate that the elements were added
        List<WebElement> elements = addremPage.getElementsAdded();
        Assert.assertEquals(elements.size(), 20);

        // Remove elements one by one
        addremPage.RemoveElements();

        // Validate that the elements were removed
        elements = addremPage.getElementsAdded();
        Assert.assertEquals(elements.size(), 0);
    }
}
