/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sonoranearshore.BaseComponents.BaseTest;
import sonoranearshore.PageObjects.DisappearingElementsPage;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class DisappearingElementsTest extends BaseTest{
    private DisappearingElementsPage disElementPage;
    
    @Test
    public void testDisappearingElements(){
        // Init Page Object
        disElementPage = new DisappearingElementsPage(driver);
        
        // Navigate to the Disappearing Elements page
        disElementPage.GoTo(prop.getProperty("disappearURL"));

        // Validate that the Gallery button exists
        Assert.assertTrue(disElementPage.buttonDisplayed());
        
        // Validate that the Gallery button does not exist
        Assert.assertFalse(disElementPage.buttonNotDisplayed());
    }
}
