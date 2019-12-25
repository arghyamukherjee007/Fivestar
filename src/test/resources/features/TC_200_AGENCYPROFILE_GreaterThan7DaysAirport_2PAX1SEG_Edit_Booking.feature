@Regression @P1Scripts @TC_200EditCustomerBooking
Feature: Edit Customer Booking

	Do a Five Star edit booking and perform all the validations
	
  @TC_200EditCustomerBookingScenario1
  Scenario Outline:  Old booking should contain a greater than 7 days airport and should be deselected in edit booking,User should select two airports DFW and NRT. DFW falls outside hours of operation and NRT is less than 48 hours window,Always Call flag is checked for NRT

   	Given Initiate a "Edit" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Airport List" second level Tab
    When User is Checking for Tax Percentage if applicable for <TestCase>
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
 		When User is clicking on "Edit Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Edit" booking using "RequestNo" details and submit for <TestCase> 
    Then User is navigating to "Select Refund Details" Screen
    When User is clicking on "Next" button
    Then User is navigating to "SELECT NEW BOOKING DETAILS" Screen
    When user is editing existing fivestar booking details for <TestCase>
    When User is calculating Amount for "Edit" Flow for <TestCase>
    When User is clicking on "Submit" button
    When User is validating Override details for editing flow for <TestCase>
    Then User is navigating to "ENTER OVERRIDE DETAILS" Screen
    When User is validating Refundable and total amount and proceeding with "Agency Profile" Payment for <TestCase>
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    Then User is navigating to "Five Star Booking" first level Tab
    When Booking completed User is validating "Fivestar" Request Number for "Edit" for <TestCase>
    When Booking completed User is validating Airport details for <TestCase>
    When Booking completed User is validating "Refund,Payment" details in payment for <TestCase>
    Then User is navigating to "Five Star SR Details" third level Tab
    And User Keep on checking for SR details if details are not present
    When Booking completed User is validating "Edit" SR details at iteration "1" for <TestCase>
    Then User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Booking Admin" second level Tab
    And User is validating "Edit" SR details in Fivestar admin for <TestCase>
    When User is navigating to "Task Execution Details" second level Tab
    Then User ensures fivestar booking validated successfully for <TestCase>
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_200           |
  