Validate using assertions that 4 filters are displayed next to `Clear All`
 Max Price is 50000
 Selected Make is Honda
 Selected Model is Pilot
 Selected `Used`
3) Select `New` radio button from New/Used
4) Validate using assertion that the `New` filter is displayed and `Used` is NOT
displayed
5) Select Touring 8-Passemger from Trim
6) Validate using assertion that the `Touring 8-Passenger` filter is displayed
7) Select the second available car
8) Validate using assertions:
 Selected car title contains `Honda Pilot 8-Passenger For Sale`
 `Check Availability` button is displayed
9) In the Contact Seller section enter:
 First Name: Car
 Last Name: Owner
 Email: carowner@yahoo.com
10)Scroll down to `Payment Calculator` and take a screenshot
#Scenario Outline:
#Given the user is on cars search page
#When the user search using following filters
#| newOrUsed | <newOrUsed> |
#| make      | <make>      |
#| model     | <model>     |
#| price     | <price>     |
#| distance  | <distance>  |
#| zip       | zip         |
#Then the user should see following filters
#| Used     |
#| make     |
#| model    |
#| price    |
#Examples:
#
#| newOrUsed| make   | model  | price | distance |
#| used     |Honda   | Pilot  |50000  | 100000   |
#
#Scenario:
#Given the user making change for the "newOrUsed"