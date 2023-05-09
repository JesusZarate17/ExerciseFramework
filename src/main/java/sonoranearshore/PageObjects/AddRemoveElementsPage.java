/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class AddRemoveElementsPage {
    
    WebDriver driver;
    
    public AddRemoveElementsPage(WebDriver driver) {
        // Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void GoTo(String url){
        driver.get(url);
    }
    
    @FindBy(css="button[onclick='addElement()']")
    WebElement addButton;
    
    public void AddElements(){
        addButton.click();
    }
    
    @FindBy(className = "added-manually")
    List<WebElement> elements;
    
    public List<WebElement> getElementsAdded(){
        return elements;
    }
    
    public void RemoveElements(){
        for (WebElement element : elements) {
            element.click();
        }
    }
}
