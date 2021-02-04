#Author: your.email@your.domain.com

Feature: Validate the forgot password functionality
  Background: Common steps for Forgot password page
  Given Launch the browser
    When Application URL is open
     Then Click on Forgot password link
    And Forgot password page gets open

  @RecoverPasswordPage
  Scenario: Temparary Password is sent to entered email id
  Then Enter the email id
  And click on Next
  Then temparary password is sent to email id
  And User is redirected to Recover Password page
  Then User can see some instruction text
  And user click on Click Here link
  Then user is redirected to Login Page
  And Browser close
    

 @RedirectToLoginPage
 Scenario: NBack button navigates back to Login Page
 Then Enter the email id
 And Click on Back 
 Then user is redirected to Login Page
  And Browser close
 
