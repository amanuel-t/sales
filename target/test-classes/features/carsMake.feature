@test
Feature: books table

  Background:
    Given the user goes to cars.com page

  Scenario Outline: Test login as <Used>

    When the user goes to "<Used>" "<make>" "<model>""<price>" "<distance>"
    And the user enter "<zip>" click search
    Then user should see "<Filters>"

    Examples:
      | Used | make  | model | price   | distance  | zip   |
      | Used | Honda | Pilot | $50,000 | 100 miles | 60008 |


    When the user one the "Touring 8-Passemger" page
    And the "used" button is clicked
    Then user should be able to change the "Used" to "New"





