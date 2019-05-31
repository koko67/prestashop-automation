@Search
Feature: Search
  Test successfully and unsuccessfully login and logout

  @Search
  Scenario: Search implementation for something
    Given I navigate to Prestashop page
    When I click the search area
     And I type the text "T-shirt"
     And I click the search button
    Then A search result should be displayed in search panel

