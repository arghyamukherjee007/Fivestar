@Regression @P1Scripts @TC_027FivestarBooking
Feature: FiveStar Booking
  User should select three airports LGA, DFW and NRT. LGA and DFW falls outside hours of operation and NRT is less than 48 hours window

  @TC_027FiveStarBookingScenario1
  Scenario Outline: User should select three airports LGA, DFW and NRT. LGA and DFW falls outside hours of operation and NRT is less than 48 hours window
  
    #Given the required inputs below for "1Pax3Seg" PNR Creation for <TestCase>
    #When user post the service request to create "PNR"
    #Then response should contain "PNR" data for <TestCase>
    Given Initiate a "Book" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    When User is navigating to "Five Star Admin" first level Tab
		When User is navigating to "Airport List" second level Tab
		When User is Checking for Tax Percentage if applicable for <TestCase>
    When User is navigating to "Airport List" second level Tab
    When Selected airport should be configured with schedule timings and correct timezone for <TestCase>
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Refund" first level Tab
    When User is Searching for Pending Booking Ref and Update in sheet for <TestCase> 
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Book Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Five Star" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is calculating Amount for "Book" Flow for <TestCase>
    When User is clicking on "submit" button
    And User is validating Override flag if applicable and clicking submit for <TestCase>
    Then User is navigating to "Select Profile" Screen
    When User Selects "Transfer refunds" as payment option
    When Validate net price,adult price and promo amount in payment breakdown page for <TestCase>
    When User is clicking on "proceed to pay" button 
    Then User is navigating to "Select Refunds" Screen
    When User is searching refund by entering "pnr" and "request" number for <TestCase>
    And User is selecting required transfer refund for <TestCase>
    When User is clicking on "Transfer Refunds" button 
    When User is entering Transport services details and perform payment if applicable for <TestCase>
    And User is capturing request number for "Book" flow for <TestCase>
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    When Booking completed User is validating "Fivestar" Request Number for "Book" for <TestCase>
    When Booking completed User is validating Airport details for <TestCase>
    When Booking completed User is validating "Payment,Transferred" details in payment for <TestCase>
    Then User is navigating to "Five Star SR Details" third level Tab
    And User Keep on checking for SR details if details are not present
    When Booking completed User is validating "Book" SR details at iteration "1" for <TestCase>
    Then User is navigating to "Five Star Admin" first level Tab
		When User is navigating to "Booking Admin" second level Tab
    And User is validating "Book" SR details in Fivestar admin for <TestCase>
    When User is navigating to "Task Execution Details" second level Tab
    Then User ensures fivestar booking validated successfully for <TestCase>
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_027 					 |
     