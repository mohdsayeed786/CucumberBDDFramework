package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

    WebDriver ldriver;

    public SearchCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }


    @FindBy(id="SearchEmail")
    WebElement EnterEmail;

    @FindBy(xpath = "//button[@id='search-customers']")
    WebElement SearchButton;

    @FindBy(xpath = "//td[normalize-space()='victoria_victoria@nopCommerce.com']")
    WebElement EmailFound;


    public void enterCustomerEmail(String Email){
        EnterEmail.sendKeys(Email);
    }

    public void clickSearchButton(){
        SearchButton.click();
    }

    public void foundEmailSearchTable(){
        EmailFound.getText();
    }


}
