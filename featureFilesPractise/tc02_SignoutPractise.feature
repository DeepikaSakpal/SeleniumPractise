#Author: your.email@your.domain.com
Feature: Logout functionality from consumer side

  Background: 
    Given Launch the browser
    When Application URL is open
    And user is logged in successfully and redirected to Dashboard

  @Singout
  Scenario: Validate the User is successfully logged out
    Then Profile icon should be shown to the top right corner
    When User click on profile icon
    And user click on Sign Out Link
    Then user is signed out from application successfully
    And Browser get close
