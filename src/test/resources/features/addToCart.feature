Feature: Feature for Add to Cart Functionality
  @AddToCart
  Scenario Outline: Add to Cart By Searching
    Given User is on GreenCart Landing Page
    When User Searched with Short name <shortName> and Extract the Actual Name
    And User adds Quantities <quantity> and adds to Cart
    Then User Proceeds to Cart Checkout
    And User Validates the Product Added with Quantity <quantity>
    And User Validate the Checkout page buttons

    Examples:
    | shortName | quantity |
    | toma      | 3        |
    | pota      | 4        |




