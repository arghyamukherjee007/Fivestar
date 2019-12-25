@Regression @P1Scripts @TC_187EditCustomerBooking
Feature: Edit Customer Booking

	Initiate an Edit booking and perform the validations in Request Initiation screen
	
  @TC_187EditCustomerBookingScenario1
  Scenario Outline:  User should be able to initiate Edit taskflow using any of the three inputs PNR, Req No and Parent Booking No
  
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
    When User is validating Refundable and total amount and proceeding with "Dont Use" Payment for <TestCase>
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
      | TC_187_1         |
   
     
  @TC_187EditCustomerBookingScenario2
  Scenario Outline:  System should display the error message as "Enter one field - either PNR, Req # or Parent Booking #" if user enters more than one input
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Edit Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Edit" booking using "RequestNo,PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Enter one field - either PNR, Req # or Parent Booking #" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_187_2         |
   
   @TC_187EditCustomerBookingScenario3
  Scenario Outline:  System should display the error message as "Invalid PNR" if the user enters any invalid PNR
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Edit Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Edit" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Invalid PNR" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_187_3         |
     
     
  @TC_187EditCustomerBookingScenario4
  Scenario Outline:  System should display the error message as "Please enter 6 alpha characters only" if the user added any special character with PNR
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Edit Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Edit" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Please enter 6 alpha characters only" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_187_4         |
     
     
  @TC_187EditCustomerBookingScenario5
  Scenario Outline:  System should display the error message as "Booking not found" if user enters invalid or cancelled booking Req # in Req # or Parent Booking # fields
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Edit Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Edit" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Booking not found" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_187_5         |
     
     
  @TC_187EditCustomerBookingScenario6
  Scenario Outline:  System should display the error message as "Please select source" if user clicks on Next without entering Source
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Edit Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Edit" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Please select source" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_187_6         |
       