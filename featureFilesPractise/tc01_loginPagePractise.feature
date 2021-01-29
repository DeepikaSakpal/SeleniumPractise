#Author: your.email@your.domain.com
Feature: Login of consumer side

  Background: Common steps for login
    Given Launch the browser
    When Application URL is open

  @DisplayLogo
  Scenario: Validate Logo is displayed  after URL is open
    Then Logo is displayed on login page
    And Browser closes

  @DisplaySloganText
  Scenario: Validate the slogan text is displayed below the logo
    Then slogan text displayed
    And Browser closes

  @ValidLoginIdandpassword
  Scenario: Validate the login functioanlity with valid username and password
    Then Enter valid username and password
    And Click on Login button
    Then user navigates to dashboard screen
    And Browser closes

  @InvalidLoginIdandPassword
  Scenario Outline: Validate the login functionality with invalid username and password
    And User enters invalid "<username>" and "<password>"
    And Click on Login button
    Then Login "<error message>" displayed
    And Browser closes

    Examples: 
      | username              | password   | error message                           |
      | customer1@getnad.com  | Pass1234   | Incorrect Email Address and/or Password |
      | deepika@school.in     | Password23 | Incorrect Email Address and/or Password |
      | customer3@getnada.com | abc456     | Incorrect Email Address and Password    |

  @BlankEmailId
  Scenario: Validate blank email id and blank password
    And user enters blank email id and valid password
    And Click on Login button
    Then error message shown
    And Browser closes

  @BlankPassword
  Scenario: Validate blank email id and blank password
    And user enters valid email id and blank password
    And Click on Login button
    Then error message shown
    And Browser closes

  @ValidateForgotPassword
  Scenario: Forgot Password Link
    Then Click on forgot password link
    And Page redirects to recovery screen
    And Browser closes
