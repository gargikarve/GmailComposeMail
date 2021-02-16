Feature: Compose mail

  Background: Compose menu displayed
    Given I have logged into the gmail acoount with valid credentials
      | username               | password    |
      | testauto2104@gmail.com | test@ut0123 |

  Scenario: Click on compose option
    Given User is on gmail page
    When User click on Plus icon
    Then new message window in shown

  Scenario: Compose email with valid emailid, subject, attachment
    Given new message window is displayed
    When User enters valid email id,subject, msgbody , attachment
    And clicks on send button    
    Then Message sent text is shown to user along with view messages label


  #Scenario: Sent mail under users sent mail folder
    #Given User has sent a mail
    #When user click on Sent folder
    #Then sent mail should be shown at the top with correct subject and recepient's name
