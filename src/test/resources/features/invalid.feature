Feature: Centrilli app login functionality
  User Story :As a registered I should be able to login to my account so that I can use the modules.

  Scenario Outline: Verify that I can not login with invalid credentials
    When User goes to centrilli login page
    And User enters invalid  "<username>" and valid "<password>" and pushes the enter button
    Then Verify that error message

    Examples:
      | username                      | password         |
      | expensesmanager10000@info.com | expensesmanager  |
      | posmanager60000@info.com      | posmanager       |
      | salesmanager60000@info.com    | salesmanager     |
      | manuf_user50000@info.com      | manufuser        |
      | imm10000@info.com             | inventorymanager |

  Scenario Outline: Verify that I can not login with invalid credentials
    When User goes to centrilli login page
    And User enters valid  "<username>" and invalid "<password>" and pushes the enter button
    Then Verify that error message

    Examples:
      | username                   | password          |
      | expensesmanager10@info.com | expensesmanagerr  |
      | posmanager60@info.com      | posmanagerr       |
      | salesmanager60@info.com    | ssalesmanager     |
      | manuf_user50@info.com      | manufuser01       |
      | imm10@info.com             | inventor_ymanager |



