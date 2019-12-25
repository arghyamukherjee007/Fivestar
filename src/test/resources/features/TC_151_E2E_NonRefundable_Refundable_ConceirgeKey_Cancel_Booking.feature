@Regression @P1Scripts @TC_151CancelCustomerBooking
Feature: Cancel Booking - Conceirge Key

	Do a Conceirge Key cancel booking and perform all the validations
	    
  @TC_151CancelCustomerBookingScenario1
  Scenario Outline:  Booking should contain less than 12 hours, less than 7 days and greater than 7 days airports 
,SR emails should be delivered already for less than 12 hours and less than 7 days airports

		Given Initiate a "Cancel" for <TestCase>
		Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials 
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Airport List" second level Tab
    When User is checking for valid "Promo Code" for "Cancel" flow and update for <TestCase>
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Book Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Conceirge Key" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is selecting CK flag for Conceirge Key booking for <TestCase>
    When User is clicking on "submit" button
    And User is validating Override flag if applicable and clicking submit for <TestCase>
    Then User is navigating to "Comments Requests" Screen
    When User is selecting Book Priority in Comments and Requests page  for <TestCase>
    When User is Providing Comments in Comments and Requests page for <TestCase>
    When User is selecting Service Indicators in Comments and Requests page for <TestCase>
    When User is Providing departure details in Comments and Requests page for <TestCase>
    When User is clicking on "Next" button	
    Then User is navigating to "Transportation Service" Screen
    And User is capturing request number for "Cancel" flow for <TestCase>
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    Then User is navigating to "Five Star SR Details" third level Tab
    And User Keep on checking for SR details if details are not present
    When Booking completed User is validating "Cancel" SR details at iteration "1" for <TestCase> 
 
    When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Cancel Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Cancel" booking using "RequestNo" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is clicking on "Next" button
    Then User is navigating to "Refund Summary" Screen
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    Then User is navigating to "Five Star Booking" first level Tab
    When Booking completed User is validating "Fivestar" Request Number for "Cancel" for <TestCase>
    When Booking completed User is validating "Payment" details in payment for <TestCase>
    Then User is navigating to "Five Star SR Details" third level Tab
    And User Keep on checking for SR details if details are not present
    When Booking completed User is validating "Cancel" SR details at iteration "2" for <TestCase> 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_151           |
   
   