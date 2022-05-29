@Login
Feature: As a user I should be able to login and logout with valid credentials

  @ValidLogin
  Scenario Outline: Login into the application with valid credentials
  	Given I am on the Login page URL "<url>"
    Then I click on Form Authendication and wait for login page
    Then I should see LogIn Page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then I am logged in
    And I Click on Sign out
	Then I got log out from the application and land on home page

    Examples:
      |             url                   | username |       password       |
      | http://the-internet.herokuapp.com | tomsmith | SuperSecretPassword! |


  @InvalidUsername
  Scenario Outline: Login into the application with invalid username
    Given I am on the Login page URL "<url>"
    Then I click on Form Authendication and wait for login page
    Then I should see LogIn Page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then I got error message

    Examples:
      |             url                   | username |       password       |
      | http://the-internet.herokuapp.com |  smith   | SuperSecretPassword! |

  @InvalidPassword
  Scenario Outline: Login into the application with invalid password
    Given I am on the Login page URL "<url>"
    Then I click on Form Authendication and wait for login page
    Then I should see LogIn Page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then I got error message

    Examples:
      |             url                   | username |  password   |
      | http://the-internet.herokuapp.com |  smith   | SuperSecret |
  
   
