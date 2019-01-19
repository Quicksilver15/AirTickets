Feature: Ticket reservation
  Scenario: Ticket reservation testing
    Given departure airport RIX
    And arrival airport SFO

    And user data is:
    |name|Donald|
    |surname|Trump|
    |discountCode|abc|
    |travellerCount|1 |
    |children      |0 |
    |luggage       |1 |
    |nextFlight    |17-05-2018|

    And seat number is 15
    And we are on home page

    When we are selecting departure airport
    And we are selecting arrival airport
    And we are pressing Go Go Go button
    Then registration page appears

    When we are filling registration form
    And we are pressing Get Price button
    Then our price will be 700 euro

    When we are pressing Book button
    Then we are on select seats page

    When we are selecting our seats number
    And we are clicking Book button
    Then successful reservation page appears

    When we are requesting reservation list
    Then we see our reservation in the list

    When we are deleting our reservation
    And we are requesting our reservation list again
    Then our reservation disappears from the list







