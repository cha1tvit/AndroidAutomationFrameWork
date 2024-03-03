@ui
Feature: Sign up to application
  Scenario: Successful signup
    Given Click button login
    When Verify presence block login form by condition {boolean}
    Then Verify presence message {boolean}