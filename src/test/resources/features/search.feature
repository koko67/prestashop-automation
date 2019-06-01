@Search
Feature: Search
  Test successfully and unsuccessfully login and logout

  @Search
  Scenario Outline: Search implementation for something
    Given I navigate to Prestashop page
    When I click the search area
    And I type the text "<SearchCriteria>"
    And I click the search button
    Then A search result with the name "<SearchCriteria>" should be displayed in search panel

    Examples:
      | SearchCriteria              |
      | Hummingbird printed t-shirt |
      | The best is yet to come     |


  @Search
  Scenario Outline: Search implementation for something
    Given I navigate to Prestashop page
    When I click the search area
    And I type the text "<SearchCriteria>"
    And I click the search button
    Then the message

    Examples:
      | SearchCriteria              |
      | Hummingbird printed t-shirt |
      | The best is yet to come     |