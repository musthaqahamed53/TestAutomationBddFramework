Feature: Login Feature
  I want to use this template for my feature file


#Before -> Background -> Scenario -> After

Background:
Given Check Background Common



  @SmokeTest
  Scenario: Login Valid Scenario
    Given User is on Landing Page
    When Login in to application
    Then I validate the login "Login 1" and "Password1"
    And Home page is displayed

  @SmokeTest
  Scenario: Login Valid Scenario2
    Given User is on Landing Page
    When Login in to application
    Then I validate the login "Login 2" and "Password2"
    And Home page is displayed
    
  @SmokeTest
  Scenario Outline: Login Valid Scenario with capcha trying
    Given User is on Landing Page
    When Login in to application
    Then I validate the login "Login 3" and "Password3"
    And Try for capcha "<capcha>"
    And Home page is displayed
    
   Examples:
   | capcha |
   | capcha1 |
   | capcha2 |
   | capcha3 |
	
	@Regex @SmokeTest
  Scenario Outline: Login Valid Scenario with capcha trying regex
    Given User is on Landing Page
    When Login in to application
    Then I validate the login "Login 3" and "Password3"
    And Try for capcha <capcha> regex
    And Home page is displayed
    
   Examples:
   | capcha |
   | 1 |
   | capcha2 |
   | capcha3 |
