@Regression @P1Scripts @TC_212EditCustomerBooking
Feature: Edit Customer Booking

	Do a Five Star edit booking and perform all the validations
	
  @TC_212EditCustomerBookingScenario1
  Scenario Outline: Selected airport should be booked in Coach class and Always call flag should be checked and Promo certificate should be changed after auto population
   
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Airport List" second level Tab
   # When Selected airport should be configured with schedule timings and correct timezone for <TestCase>
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Book Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Edit" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is calculating Amount for "Edit" Flow for <TestCase>
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
    And User is entering Transport services details for "Book Flow"
    When User is clicking on "proceed to pay" button
    Then User is navigating to "Proceed to pay" Screen
    And User is capturing request number for "Book flow" flow for <TestCase>
    And User is filling card details and proceed to finish the booking for <TestCase>
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    When Booking completed User is validating "Fivestar" Request Number for "Book Flow" for <TestCase>
    When Booking completed User is validating Airport details for <TestCase>
    When Booking completed User is validating "Payment" details in payment for <TestCase>
    When Booking completed User is validating "Book Flow" SR details for <TestCase> 
    When User is navigating to "Five Star Booking" first level Tab
 		When User is clicking on "Edit Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Edit" booking using "RequestNo" details and submit for <TestCase> 
    Then User is navigating to "Select Refund Details" Screen
    When User is clicking on "Next" button
    Then User is navigating to "SELECT NEW BOOKING DETAILS" Screen
    When user is editing existing fivestar booking details for <TestCase>
    When User is clicking on "Submit" button
    When User is validating Override details for editing flow
    Then User is navigating to "ENTER OVERRIDE DETAILS" Screen
    When User is clicking on "Next" button
    Then User is navigating to "Refund Breakdown" Screen
    When User is clicking on "Process Refund" button
    Then User is navigating to "Payment Summary" Screen   
    And User is entering caller details
    And User is entering Transport services details for "Edit"
    When User is clicking on "Next" button
    Then User is navigating to "Refund Summary" Screen
    And User is capturing request number for "Edit" flow for <TestCase>
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    Then User is navigating to "Five Star Booking" first level Tab
    When Booking completed User is validating "Fivestar" Request Number for "Edit" for <TestCase>
    When Booking completed User is validating "Refund,Payment" details in payment for <TestCase>
    When Booking completed User is validating "Edit" SR details at iteration "1" for <TestCase>
    Then User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Booking Admin" second level Tab
    And User is validating "Edit" SR details in Fivestar admin for <TestCase>
    When User is navigating to "Task Execution Details" second level Tab
    Then User ensures fivestar booking validated successfully for <TestCase>
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_212           |
  