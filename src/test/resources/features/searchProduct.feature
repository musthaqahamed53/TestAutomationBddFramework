Feature: Search Functionality

  @SearchTest
  Scenario Outline: Search Experience for Product search in Home and Offers Page
    Given User is on GreenCart Landing Page
    When User Searched with Short name <shortname> and Extract the Actual Name
    Then User Searched for same shortname in offers page
    And Validate if products exists

    Examples: 
      | shortname |
      | toma      |
      | pota      |
      | Beet      |
