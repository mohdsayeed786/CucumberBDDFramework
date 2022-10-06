package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

    WebDriver ldriver;

    public AddNewCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    //Find elements on the webpage

    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    WebElement CustMainMenu;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
    WebElement CustSubMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Add new']")
    WebElement AddNewBtn;

    @FindBy(css = "#Email")
    WebElement Email;

    @FindBy(css = "#Password")
    WebElement Password;

    @FindBy(css = "#FirstName")
    WebElement FirstName;

    @FindBy(css = "#LastName")
    WebElement LastName;

    @FindBy(css = "#Gender_Male")
    WebElement Gender;

    @FindBy(xpath = "//input[@id='DateOfBirth']")
    WebElement DOB;

    @FindBy(css = "#Company")
    WebElement Company;

    @FindBy(xpath = "//button[@name='save']")
    WebElement saveBtn;

    //Actions Methods for web elements

    public void clickOnCustomersMainMenu(){
        CustMainMenu.click();
    }

    public void clickOnCustomersSubMenu(){
        CustSubMainMenu.click();
    }

    public void click_on_add_new_button(){
        AddNewBtn.click();
    }

    public void user_can_view_add_new_customer_page(){

    }

    public void enterEmail(String email){
        Email.sendKeys(email);
    }

    public void enterPassword(String pwd){
        Password.sendKeys(pwd);
    }

    public void enterfirstname(String firstname){
        FirstName.sendKeys(firstname);
    }

    public void enterlastname(String lastname){
        LastName.sendKeys(lastname);
    }

    public void enterGender(){
        Gender.click();
    }

    public void enterDob(String dob){
        DOB.sendKeys(dob);
    }

    public void enterCompany(String company){
        Company.sendKeys(company);
    }

    public void enterSaveBtn(){
        saveBtn.click();
    }

}
