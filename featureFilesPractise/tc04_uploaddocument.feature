
Feature: Verify the functionality of uploading the document
  
  Background: Common steps for uploading document
Given Launch the browser
    When Application URL is open
    And user is logged in successfully and redirected to Dashboard


  Scenario: Document Upload should work successfully
    Then user click on Upload docs from left panel
    Then document page is opened
    Then User click on upload a document button
    Then file selector option is displayed
    When user click on the block file explorer is open
    Then select the file 
    And click on open
    Then Success message can be seen
    And user adds comments
    And user clicks on Done button 
    And user is able to see the uploadded document
    

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
