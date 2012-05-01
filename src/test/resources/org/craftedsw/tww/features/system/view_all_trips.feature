Feature: View all trips

  Scenario: Display all trips
    Given I am on the front page
    When I decide to see all existing trips
    Then I should see a list of all trips