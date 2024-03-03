@ui
Feature: Sign up to application
  Scenario: Successful signup
    Given Click button 'LOG IN'
    When Verify presence block 'Login Form' by condition {string}
    Given Click button 'LOG IN'
    When Verify presence block 'Login Form' by condition {string}