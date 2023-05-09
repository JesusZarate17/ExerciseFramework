/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sonoranearshore.BaseComponents.BaseTest;
import sonoranearshore.PageObjects.JSAlertsPage;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class JSAlertsTest extends BaseTest{
    private JSAlertsPage jsAlertsPage;
    
    @Test
    public void testJSAlerts(){
        // Init Page Object
        jsAlertsPage = new JSAlertsPage(driver);
        
        // navigate to page
        jsAlertsPage.GoTo(prop.getProperty("jsAlertsURL"));

        // click on JS Alert button
        jsAlertsPage.ClickJSAlert();

        // switch to alert and accept
        jsAlertsPage.AcceptAlert();

        // validate result
        Assert.assertEquals(jsAlertsPage.GetResultText(), "You successfully clicked an alert");
        
        // click on JS Prompt button
        jsAlertsPage.ClickJSPrompt();

        // switch to alert send text and accept
        jsAlertsPage.SendTextToAcceptAlert("testing");
        
        // validate second result
        Assert.assertEquals(jsAlertsPage.GetResultText(), "You entered: testing");
        
    }
    
}
