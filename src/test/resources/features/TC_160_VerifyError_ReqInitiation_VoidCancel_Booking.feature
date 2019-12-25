@Regression @P1Scripts @TC_160VoidCancelCustomerBooking
Feature: Edit Customer Booking

	Initiate the Void taskflow and perform the validations in Request Initiation screen
	    
  @TC_160VoidCancelCustomerBookingScenario1
  Scenario Outline:  System should display the error message as "Enter one field - either PNR, Req # or Parent Booking #" if user enters more than one input
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Cancel Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Cancel" booking using "RequestNo,PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Enter one field - either PNR, Req # or Parent Booking #" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_160_1         |
   
   @TC_160VoidCancelCustomerBookingScenario2
  Scenario Outline:  System should display the error message as "Invalid PNR" if the user enters any invalid PNR
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Cancel Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Cancel" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Invalid PNR" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_160_2         |
     
     
  @TC_160VoidCancelCustomerBookingScenario3
  Scenario Outline:  System should display the error message as "Please enter 6 alpha characters only" if the user added any special character with PNR
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Cancel Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Cancel" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Please enter 6 alpha characters only" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_160_3         |
     
     
  @TC_160VoidCancelCustomerBookingScenario4
  Scenario Outline:  System should display the error message as "Booking not found" if user enters invalid or cancelled booking Req # in Req # or Parent Booking # fields
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Cancel Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Cancel" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Booking not found" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_160_4         |
     
     
  @TC_160VoidCancelCustomerBookingScenario5
  Scenario Outline:  System should display the error message as "Please select source" if user clicks on Next without entering Source
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Cancel Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Cancel" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Please select source" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_160_5         |
       