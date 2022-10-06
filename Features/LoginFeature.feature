Feature: Login

  @Smoke
  Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And user click on Login Button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on LogOut Link
    Then Login Page Title should be "Your store. Login"
    And close browser

    @Regression
    Scenario Outline: Successful login with valid and invalid login credentials using Data Driven Testing
      Given User launch chrome browser
      When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
      And User enter Email as "<email>" and Password as "<password>"
      And user click on Login Button
      Then Page title should be "Dashboard / nopCommerce administration"
      When User click on LogOut Link
      Then Login Page Title should be "Your store. Login"
      And close browser

      Examples:
      |email|password|
      |admin@yourstore.com|admin|
      |test@yourstore.com|admin|
