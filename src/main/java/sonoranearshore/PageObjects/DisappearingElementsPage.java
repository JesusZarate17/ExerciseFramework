/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class DisappearingElementsPage {
    WebDriver driver;
    
    public DisappearingElementsPage(WebDriver driver) {
        // Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void GoTo(String url){
        driver.get(url);
    }
    
    WebElement galleryButton;
    
    public void findButton(){
        galleryButton = driver.findElement(By.linkText("Gallery"));
    }
    
    public boolean buttonDisplayed(){
        while (galleryButton == null) {
            driver.navigate().refresh();
            try {
                findButton();
            } catch (NoSuchElementException e) {
                
            }
        }
        return true;
    }
    
    public boolean buttonNotDisplayed(){
        while (galleryButton != null) {
            driver.navigate().refresh();
            try {
                findButton();
            } catch (NoSuchElementException e) {
                galleryButton = null;
            }
        }
        return false;
    }
}
