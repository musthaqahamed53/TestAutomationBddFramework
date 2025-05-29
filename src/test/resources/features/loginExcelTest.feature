Feature: Login

  Scenario Outline: Login using Excel data
    Given I login with "<username>" and "<password>"

    Examples:
      | username | password |
      | dummy    | dummy    |
      | dummy    | dummy    |
      | dummy    | dummy    |
