Feature: View all trips

  Scenario: Navigate to the "all trips" page (EXPLORATORY SCENARIO - MUST BE DELETED)
    Given I am on the front page
    When I decide to see all existing trips
    Then I should see a list of all trips
    
  Scenario: Display another page that hangs off all trips page (EXPLORATORY SCENARIO - MUST BE DELETED)
    Given I am on the all trips page
    When I decide to see another page
    Then I should see another page
    
    
  Scenario: Add a trip
    Given I populate all my trip details
    When I save it
    Then I should see it displayed
    
#  Scenario: Display all trips
#    Given the Trips:
#    |Name                | Description                                                |
#    |British Countryside | Five days driving around the beautiful British countryside |
#    |European Holidays   | Great holidays where I visited France, Italy and Germany   |
#    When I want to see all the trips on The WorldWalkers
#    Then I should see a list containing all of them
    
        