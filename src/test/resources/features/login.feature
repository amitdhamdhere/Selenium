Feature: Login functionality

  Scenario Outline: Verify user can login with valid credentials
    Given User is on the practice login page
    When User enters valid username "<username>"
    And User enters valid password "<password>"
    And User clicks the login button
    Then Success message "Logged In Successfully" should be displayed

    Examples:
      | username | password     |
      | student  | Password123  |
      | student  | Password1234 |