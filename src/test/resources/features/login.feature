Feature: Sign up to application
  Scenario: Successful signup
    Given I am on the signup page
    When I fill out the form with my information
    Then I should see a confirmation message
  Scenario: Unsuccessful signup
    Given I am on the signup page
    When I fill out the form with my information
    Then I should see a confirmation message