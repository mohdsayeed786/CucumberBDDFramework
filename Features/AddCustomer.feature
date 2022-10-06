Feature: Add Customer

    Background: Steps common for all scenarios
    Given User launch chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And user click on Login Button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Customers main menu
    And click on customers sub menu item

  @Smoke @Sanity
  Scenario: Add new customer
    And click on Add New button
    Then User can view Add new Customer page
    When User enter all required customer info
    And click on SAVE button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

      @Regression
  Scenario: Search customer by Email
    Then Search page should be displayed whose title is "Customers / nopCommerce administration"
    And user enter customer email
    And User click on SEARCH button
    Then User should found Email is the Search Table "victoria_victoria@nopCommerce.com"
    And close browser
