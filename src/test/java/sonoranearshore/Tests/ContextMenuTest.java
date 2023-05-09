/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import sonoranearshore.BaseComponents.BaseTest;
import sonoranearshore.PageObjects.ContextMenuPage;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class ContextMenuTest extends BaseTest {

    private ContextMenuPage contextMenuPage;

    @Test
    public void testContextMenu() {
        // Init Page Object
        contextMenuPage = new ContextMenuPage(driver);

        // Navigate to the Context Menu page
        contextMenuPage.GoTo(prop.getProperty("contextURL"));

        // Right-click on the box element
        contextMenuPage.rightClickBox();

        // Validate the text on the alert
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(contextMenuPage.getAlertText(alert), "You selected a context menu");

        // Click on the accept button
        alert.accept();

        // Validate that the alert was closed
        try {
            contextMenuPage.getAlertText(alert);
            Assert.fail("Alert was not closed.");
        } catch (NoAlertPresentException e) {
            // Alert closed successfully
        }
    }
}
