@smokeTest
Feature: Google search page test

  Scenario: 01_Searching for Wikipedia website
    Given Google Website is opened in Chrome browser
    When User enters 'Wikipedia' in the Google Search Field
    And User select '1' Search result link
    Then Wikipedia Website is loaded
    And User can see Wikipedia Logo

  Scenario: 02_Searching for Youtube website
    Given Google Website is opened in Chrome browser
    When User enters 'Youtube' in the Google Search Field
    And User select '1' Search result link
    Then Youtube Website is loaded
    And User can see Youtube Logo