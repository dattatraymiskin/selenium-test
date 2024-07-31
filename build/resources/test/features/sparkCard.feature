Feature: Card Creation and Blocking

#  @Spark_Card_Creation
#  Scenario Outline: Spark Card Creation
#    Given Update details for card on boarding
#    When User updates following details for card booking with API <embosserName>,<firstName>,<panNumber>,<mobileNumber>,<dateOfBirth>,<ICIFNumber>,<BatchNumber>,<mailID>,<appRefNumber>
#    Then user validates the Response
#    Given user is on Login page
#    When user enters <username> in username field
#    And user enters <password> in password field
#    Then user should be able to login CMS Application By Clicking LoginButton
#    And verify user is logged into CMS Application
#    Then Click on Cards
#    And Click On card Search
#    And Click Enter cards Account Number and click on search
#    Then Logout from ARX
#    Examples:
#      |username|password| embosserName | firstName | panNumber | mobileNumber | dateOfBirth | ICIFNumber | mailID | appRefNumber | BatchNumber |
#      | DBS12 |Welcome@01| Kishan Kumar | Kishan | MVZIT8656L  | 5930892742 | 02-MAY-97 | 8547736557 | sample2@verite.com   | CD300100006427 |  75227886427|

  @Card_Block
  Scenario Outline: Card Block Request
    Given User is on the ARX Login Screen
    When user enters <username> in username field
    And user enters <password> in password field
    Then User Clicks on the Login Button
    Then Click on Cards
    When User selects the card block unblock and Reissue
    And Enter the Card Number  and  Click on Search
    Then User Selects the Account and clicks on Override and get CardNumber
    Then Click on the Menu Button
    And  selects the card block unblock and Reissue Again in Menu <requestType>
    And Logout from ARX Screen
    Then User is on the ARX Login Screen
    And user enters <username1> in username field
    And user enters <password> in password field
    Then User Clicks on the Login Button
    And User clicks on cards and selects the Temporary Block UnBlock
    Then Logout from ARX Screen
    Examples:
      | username | password| username1 | requestType |
      | DBS11 | Welcome@01 |   DBS12   |Temporary Block |

  @Card_UnBlock
  Scenario Outline: Card Block Request
    Given User is on the ARX Login Screen
    When user enters <username> in username field
    And user enters <password> in password field
    Then User Clicks on the Login Button
    Then Click on Cards
    When User selects the card block unblock and Reissue
    And Enter the Card Number  and  Click on Search
    Then User Selects the Account and clicks on Override and get CardNumber
    Then Click on the Menu Button
    And  selects the card block unblock and Reissue Again in Menu <requestType>
    And Logout from ARX Screen
    Then User is on the ARX Login Screen
    And user enters <username1> in username field
    And user enters <password> in password field
    Then User Clicks on the Login Button
    And User clicks on cards and selects the Temporary Block UnBlock
    Then Logout from ARX Screen
    Examples:
      | username | password| username1 | requestType |
      | DBS12 | Welcome@01 |   DBS11   | Temporary Unblock |