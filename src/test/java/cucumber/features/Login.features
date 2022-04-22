Feature: User login

  Background:
    And I am user with password "secret_sauce"

  Scenario Outline: User sees 6 inventory items after login
    Given I am user with nickname "<User name>"
    When I try to log in
    Then I am on inventory page
    And I see "6" items on inventory page

    Examples:
      | User name     |
      | problem_user  |
      | standard_user |

  Scenario: User sees 6 inventory items after login
    Given I am user with nickname "user"
    And I try to log in
    Then I am on login page
    And I see error message