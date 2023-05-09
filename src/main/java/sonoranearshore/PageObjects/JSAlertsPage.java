/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonoranearshore.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jesús Zárate <jesus_zarate_camargo@hotmail.com>
 */
public class JSAlertsPage {
    WebDriver driver;
    
    public JSAlertsPage(WebDriver driver) {
        // Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void GoTo(String url){
        driver.get(url);
    }
    
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement jsAlert;
    
    public void ClickJSAlert(){
        jsAlert.click();
    }
    
    public void AcceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    @FindBy(id="result")
    WebElement resultText;
    
    public String GetResultText(){
        return resultText.getText();
    }
    
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement jsPrompt;
    
    public void ClickJSPrompt(){
        jsPrompt.click();
    }
    
    public void SendTextToAcceptAlert(String text){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
}
