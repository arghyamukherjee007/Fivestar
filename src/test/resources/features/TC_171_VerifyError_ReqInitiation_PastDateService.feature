@Regression @P1Scripts @TC_171PastDateServiceBooking
Feature: Edit Customer Booking

	Initiate an Edit booking and perform the validations in Request Initiation screen
	    
  @TC_171PastDateServiceBookingScenario1
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
      | TC_171_1         |
   
   @TC_171PastDateServiceBookingScenario2
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
      | TC_171_2         |
     
     
  @TC_171PastDateServiceBookingScenario3
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
      | TC_171_3         |
     
     
  @TC_171PastDateServiceBookingScenario4
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
      | TC_171_4         |
     
     
  @TC_171PastDateServiceBookingScenario5
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
      | TC_171_5         |
      
  @TC_171PastDateServiceBookingScenario6
  Scenario Outline:  System should display the error message as "Booking has a future date segment. Please select “Edit Key Star” task flow to edit." if user enters booking number with future dates (timezone should be considered)
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
		When User is clicking on "Cancel Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Cancel" booking using "PNR" details and submit for <TestCase>
    Then User ensures validating mandatory error message pop up "Booking has a future date segment" 
    Then Logout and Close The Browser
 
   Examples: 
      | TestCase         |
      | TC_171_6         |
       