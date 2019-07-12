
#@testing
Feature: Search on Dashboard

	Agile Story:
	As a user,
	I should be able to search for the item
	So that I can access the item information

@regression
  Scenario: Search for item
    Given I logged in into Prestashop
    When I search for "summer dress"
    Then Search result should be displayed
    Then I logout from the application

    
    
