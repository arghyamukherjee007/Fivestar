@Regression @P1Scripts @TC_141CancelCustomerBooking
Feature: Cancel Booking - Five Star

	Do a Five Star cancel booking and perform all the validations
	    
  @TC_141CancelCustomerBookingScenario1
  Scenario Outline:  Booking should contain less than 12 hours, less than 7 days and greater than 7 days airports,SR emails should be delivered already for less than 12 hours and less than 7 days airports, Promotion code and additional service should be used for all or few airports

	# Given the required inputs below for "1Pax1Seg" PNR Creation for <TestCase>
   # When user post the service request to create "PNR"
    #Then response should contain "PNR" data for <TestCase>
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
    When User is able to perform a "Five Star" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is Selecting Add Additional Services Option
    When User is clicking on "submit" button
    And User is validating Override flag if applicable and clicking submit for <TestCase>
    Then User is navigating to "Additional Services" Screen
    When User is capturing Additional Services for "Cancel" and calculating amount for <TestCase>
    When User is calculating Amount for "Cancel" Flow for <TestCase>
    When User is clicking on "Next" button
    Then User is navigating to "Select Profile" Screen
    When Validate net price,adult price and promo amount in payment breakdown page for <TestCase>
    When User is clicking on "proceed to pay" button
    Then User is navigating to "Fivestar Confirmation" Screen
    When User is entering email information for <TestCase>
    And User is entering caller details
    And User is entering Transport services details for "Cancel"
    When User is clicking on "proceed to pay" button
    Then User is navigating to "Proceed to pay" Screen
    And User is capturing request number for "Cancel" flow for <TestCase>
    And User is filling card details and proceed to finish the booking for <TestCase>
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
    When User is Validating Nonrefundable and refundable airport and selecting Refundable flag for <TestCase>
    When User is clicking on "Next" button
    Then User is navigating to "Refund Breakdown" Screen
   # When User is adding Override Amount for <TestCase>
   # When User is Validating Override amount and updating Refundable Amount in "Refund Breakdown" for <TestCase>
    When User is clicking on "Process Refund" button
    Then User is navigating to "Refund Summary" Screen
    #When User is Validating Override amount and updating Refundable Amount in "Refund Summary" for <TestCase>
    And User is capturing request number for "Cancel" flow for <TestCase>
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    Then User is navigating to "Five Star Booking" first level Tab
    When Booking completed User is validating "Fivestar" Request Number for "Cancel" for <TestCase>
    When Booking completed User is validating "Payment" details in payment for <TestCase>
    Then User is navigating to "Five Star SR Details" third level Tab
    And User Keep on checking for SR details if details are not present
    When Booking completed User is validating "Cancel" SR details at iteration "2" for <TestCase> 
    Then User is navigating to "Five Star Refund" first level Tab
    Then Refund record should be created properly With "Pending" Status for <TestCase>
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_141           |
   
   