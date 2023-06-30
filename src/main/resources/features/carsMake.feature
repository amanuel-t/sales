@test
Feature: books table
  Background:
    Given the user goes to cars.com page

  Scenario Outline: Test login as <Used>

    When the user goes to "<Used>" "<make>" "<model>""<price>" "<distance>"
    And the user enter "<zip>" click search
    Then verify user should see "<Used>" "<make>" "<model>""<price>" "<distance>"
    And the user select "New"
    Then user should see "New"
    And the user select "New"
    Then user should see "New"


    Examples:
      | Used  | make | model   | price  | distance   | zip |
      | Used  | Honda| Pilot   | $50,000| 100 miles  |60008|






