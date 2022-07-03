Feature: Centrilli app login functionality
  User Story :As a registered I should be able to login to my account so that I can use the modules.
  credentials.


  Scenario Outline: User should be able to see please fill out this field message
  when leaves empty password
    When User goes to centrilli login page
    And User enters password "<password>"
    And User clicks the login button
    Then User verifies that I got message if I leave empty username.
    Examples:
      | password         |
      | expensesmanager  |
      | posmanager       |
      | salesmanager     |
      | manufuser        |
      | inventorymanager |

  Scenario Outline: User should be able to see please fill out this field message
  when leaves empty username
    When User goes to centrilli login page
    And User enters username "<username>"
    And User clicks the login button
    Then User verifies that I got message if I leave empty password.

    Examples:
      | username                   |
      | imm10@info.com             |
      | expensesmanager10@info.com |
      | manuf_user10@info.com      |
      | posmanager6@info.com       |
      | salesmanager6@info.com     |



