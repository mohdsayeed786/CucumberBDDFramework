package StepDefinition;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

//Parent class
public class BaseClass {

    public WebDriver driver;
    public LoginPage LoginPg;
    public AddNewCustomerPage NewCustPg;
    public SearchCustomerPage SearchCustPg;
    public ReadConfig readConfig;

    public static Logger log;

    //Generate Unique EMail ID
    public String generateEmailId() {
        return (RandomStringUtils.randomAlphabetic(5));
    }
}
