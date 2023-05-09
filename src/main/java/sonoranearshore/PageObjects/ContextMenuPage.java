/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class ContextMenuPage {
    WebDriver driver;
    
    public ContextMenuPage(WebDriver driver) {
        // Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void GoTo(String url){
        driver.get(url);
    }
    
    @FindBy(id="hot-spot")
    WebElement box;
    
    public void rightClickBox(){
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }
    
    public String getAlertText(Alert alert){
        String alertText = alert.getText();
        return alertText;
    }
    
}
