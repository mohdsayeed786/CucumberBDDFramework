package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // Creating Webdriver object
    WebDriver lDriver;

    //Creating Constructor
    public LoginPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(lDriver, this);
    }

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginBtn;

    @FindBy(linkText = "Logout")
    WebElement LogOutBtn;

    public void enterEmail(String emailValue){
        email.clear();
        email.sendKeys(emailValue);
    }

    public void enterPassword(String PassValue){
        password.clear();
        password.sendKeys(PassValue);
    }

    public void clickonLoginBtn(){
        loginBtn.click();
    }

    public void clickonLogoutBtn(){
        LogOutBtn.click();
    }

}
