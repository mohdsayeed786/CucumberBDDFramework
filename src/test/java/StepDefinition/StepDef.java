package StepDefinition;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

// child class of base class
public class StepDef extends BaseClass {

    @Before
    public void setup() {

        readConfig = new ReadConfig();

        log = LogManager.getLogger("StepDef");
        System.out.println("************ Setup Method called ***********");

        String browser = readConfig.getBrowser();
        if ("chrome".equals(browser.toLowerCase())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("edge".equals(browser.toLowerCase())) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            driver = null;
        }
        if (driver != null) {
            driver.manage().window().maximize();
        }
        log.info("Setup Executed");
    }

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {

        LoginPg = new LoginPage(driver);
        NewCustPg = new AddNewCustomerPage(driver);
        SearchCustPg = new SearchCustomerPage(driver);
        log.info("Chrome browser Launched");

    }

    ////////////// Add New customer //////////////////////////////////////

    @When("User open URL {string}")
    public void user_open_url(String URL) {
        driver.get(URL);
        log.info("URL opened");
    }

    @When("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String Email, String Password) {
        LoginPg.enterEmail(Email);
        log.info("Email entered");
        LoginPg.enterPassword(Password);
        log.info("Password Entered");
    }

    @When("user click on Login Button")
    public void user_click_on_login_button() {
        LoginPg.clickonLoginBtn();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String ExpectedTitle) {
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(ExpectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @When("User click on LogOut Link")
    public void user_click_on_log_out_link() {
        LoginPg.clickonLogoutBtn();
    }

    @Then("Login Page Title should be {string}")
    public void login_page_title_should_be(String ExpectedTitle1) {
        String actualTitle1 = driver.getTitle();

        if (actualTitle1.equals(ExpectedTitle1)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    ////////// Add New Customer Page ////////////////
    @When("User click on Customers main menu")
    public void user_click_on_customers_main_menu() {
        NewCustPg.clickOnCustomersMainMenu();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("click on customers sub menu item")
    public void click_on_customers_sub_menu_item() {
        NewCustPg.clickOnCustomersSubMenu();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @When("click on Add New button")
    public void click_on_add_new_button() {
        NewCustPg.click_on_add_new_button();
    }

    @Then("User can view Add new Customer page")
    public void user_can_view_add_new_customer_page() {
        NewCustPg.user_can_view_add_new_customer_page();
    }

    @When("User enter all required customer info")
    public void user_enter_all_required_customer_info() {
        // NewCustPg.enterEmail( "test11@test.com");
        NewCustPg.enterEmail(generateEmailId() + "@test.com");
        NewCustPg.enterPassword("test1");
        NewCustPg.enterfirstname("Mohd");
        NewCustPg.enterlastname("Sayeed");
        NewCustPg.enterGender();
        NewCustPg.enterDob("10/4/2022");
        NewCustPg.enterCompany("Provana");
    }

    @When("click on SAVE button")
    public void click_on_save_button() {
        NewCustPg.enterSaveBtn();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {

        String bodyTagText = driver.findElement(By.tagName("Body")).getText();
        if (bodyTagText.contains(exptectedConfirmationMsg)) {
            Assert.assertTrue(true);//pass

        } else {
            Assert.assertTrue(false);//fail

        }

    }

    ////////////// Search Customer ///////////////////////////

    @Then("Search page should be displayed whose title is {string}")
    public void search_page_should_be_displayed_whose_title_is(String expectedResult) {
        String actualResult = driver.getTitle();

        if (actualResult.contains(expectedResult)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Then("user enter customer email")
    public void user_enter_customer_email() {
        SearchCustPg.enterCustomerEmail("victoria_victoria@nopCommerce.com");
    }

    @Then("User click on SEARCH button")
    public void user_click_on_search_button() {
        SearchCustPg.clickSearchButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("User should found Email is the Search Table {string}")
    public void user_should_found_email_is_the_search_table(String expectedEmail) {

        String ActualEmail = driver.findElement(By.xpath("//td[normalize-space()='victoria_victoria@nopCommerce.com']")).getText();
        if (ActualEmail.contains(expectedEmail)) {
            Assert.assertTrue(true);//pass

        } else {
            Assert.assertTrue(false);//fail

        }

    }
    /////// Close Browser ////////////

    @Then("close browser")
    public void close_browser() {
        //driver.close();
    }

    @After
    public void tearDown(Scenario sc) {
        System.out.println("************ Tear Down Method called ***********");

        if(sc.isFailed()==true){

            //Convert webDriver object to screenshot
            String fileWithPath = ".//Screenshot/failedScreenShot.png";
            TakesScreenshot scrShot = ((TakesScreenshot)driver);

            //Call getScreenShot method to create image file
            File srcFile= scrShot.getScreenshotAs(OutputType.FILE);

            //Move srcFile image to designation file path
            File desFile = new File(fileWithPath);

            // Copy file at destination
            try {
                FileUtils.copyFile(srcFile, desFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        driver.close();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }


}
