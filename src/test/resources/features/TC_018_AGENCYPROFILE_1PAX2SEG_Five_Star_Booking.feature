@Regression @P1Scripts @TC_018FivestarBooking
Feature: FiveStar Booking
  Do a Five Star booking and perform all the validations Ticketed PNR with one AADV customers should be given as input and payment should be made with Agency Profile

  @TC_018FiveStarBookingScenario1
  Scenario Outline: Do a Five Star booking and perform all the validations Ticketed PNR with more than one AADV customers should be given as input and payment should be made with Agency Profile

    #Given the required inputs below for "1Pax1Seg" PNR Creation for <TestCase>
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
    When User Selects "Agency profile" as payment option
    When Validate net price,adult price and promo amount in payment breakdown page for <TestCase>
	  When User is clicking on "proceed to pay" button
	  Then User is navigating to "Payment Breakdown" Screen
	  When User has provided Agency profile information as payment for <TestCase>
	  When User Selects "Dont Use" as payment option
	  When User is clicking on "proceed to pay" button
    Then User is navigating to "Fivestar Confirmation" Screen
    When User is entering email information for <TestCase>
    And User is entering caller details
    And User is entering Transport services details for "Book"
    When User is clicking on "proceed to pay" button
    Then User is navigating to "Proceed to pay" Screen
    And User is capturing request number for "Book" flow for <TestCase>
    And User is filling card details and proceed to finish the booking for <TestCase>
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    When Booking completed User is validating "Fivestar" Request Number for "Book" for <TestCase>
    When Booking completed User is validating Airport details for <TestCase>
    When Booking completed User is validating "Payment" details in payment for <TestCase>
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
      | TC_018 					 |
     