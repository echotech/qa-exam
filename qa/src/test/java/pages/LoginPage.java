package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

public class LoginPage {
    private WebDriver driver;
    private Helpers h;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        h=new Helpers(driver);
    }

    @FindBy(id="input_0")
    WebElement loginField;
    @FindBy(id="input_1")
    WebElement passwordField;
    @FindBy(id="submit")
    WebElement submitBtn;
    @FindBy(xpath="//div[contains(@class,'md-whiteframe-1dp')]")
    WebElement alertPanel;


    public boolean testLogin(String user, String pass){
        driver.navigate().to("http://localhost:8080");
        h.waitForElement(loginField);
        loginField.sendKeys(user);
        passwordField.sendKeys(pass);
        h.scrollToAndClickElement(submitBtn, 0);
        h.waitForElement(alertPanel);
        if (alertPanel.getText().contains("Failed!")){
            //System.out.println(alertPanel.getText());
            return false;
        } else if(alertPanel.getText().contains("Success!")){
            //System.out.println(alertPanel.getText());
            return true;
        } else {
            //System.out.println("Couldn't find failed or success.");
            return false;
        }
    }
}
