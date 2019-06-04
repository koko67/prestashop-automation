@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  @Login
  Scenario: Login implementation
    Given I navigate to Prestashop page
    When I click on Sign In button
    And I click on Email area
#    And I type the text "<any.cespedes8@gmail.com>"
#    And I click on Password area
#    And I type the text "<p7915701-1D>"
#    And I click on the SIGN IN button
#    Then A search result with the name "<SearchCriteria>" should be displayed in search panel

#    Examples:
#      | SearchCriteria              |
#      | Hummingbird printed t-shirt |
#      | The best is yet to come     |

