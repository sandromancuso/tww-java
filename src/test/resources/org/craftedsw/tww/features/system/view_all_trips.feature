Feature: View all trips

  Scenario: Display all trips
    Given I am on the front page
    When I decide to see all existing trips
    Then I should see a list of all trips
    
  Scenario: Display another page that hangs off all trips page
    Given I am on the all trips page
    When I decide to see another page
    Then I should see another page    