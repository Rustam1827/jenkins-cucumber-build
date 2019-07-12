Feature: User Interface for Prestashop

  @smoke
  Scenario: Prestashop Name and Modules
    Given I logged in into Prestashop
    Then Web title should be My Store
    Then Modules should be displayed
    Then I logout from the application
