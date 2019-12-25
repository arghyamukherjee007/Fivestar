@Regression @P1Scripts @TC_102AdhocPaymentError
Feature: Verify Adhoc Payment Error

	Initiate an Ad Hoc Payment and perform the validations in Request Initiation screen 
	
  @TC_102AdhocPaymentErrorScenario1
  Scenario Outline:   System should display the error message as "Use the Edit KeyStar task flow when adding passengers for a future date" if the user enters future date in Service Date field
		  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "adhoc payment" link from taskbar
    Then User is navigating to "Adhoc Request Initiation" Screen
    When User is entering Required details in "Adhoc Payment" Screen for <TestCase>
    When User is clicking on "Next" button
    Then User ensures validating mandatory error message pop up "Use the Edit KeyStar task flow when adding passengers for a future date"
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_102_1         |
   
     
  @TC_102AdhocPaymentErrorScenario2
  Scenario Outline:   System should display the error message as "This is a ConciergeKey, Commercial Customer or Other booking. Ad Hoc Payment is only valid for Five Star Service bookings." if the user enters Non Five Star booking req number
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "adhoc payment" link from taskbar
    Then User is navigating to "Adhoc Request Initiation" Screen
    When User is entering Required details in "Adhoc Payment" Screen for <TestCase>
    When User is clicking on "Next" button
    When User ensures validating mandatory error message pop up "This is a ConciergeKey, Commercial Customer or Other booking. Ad Hoc Payment is only valid for Five Star Service bookings."
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_102_2         |
 
  @TC_102AdhocPaymentErrorScenario3
  Scenario Outline:   System should display the error message as "This is not a Valid Booking" if the user enters cancelled booking req number
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "adhoc payment" link from taskbar
    Then User is navigating to "Adhoc Request Initiation" Screen
    When User is entering Required details in "Adhoc Payment" Screen for <TestCase>
    When User is clicking on "Next" button
    When User ensures validating mandatory error message pop up "This is not a Valid Booking"
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_102_3         |
 
 
 @TC_102AdhocPaymentErrorScenario4
  Scenario Outline:   System should display the error message as "Invalid Booking Reference Number" if the user enters incorrect booking req number which is not there in system
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "adhoc payment" link from taskbar
    Then User is navigating to "Adhoc Request Initiation" Screen
    When User is entering Required details in "Adhoc Payment" Screen for <TestCase>
    When User is clicking on "Next" button
    When User ensures validating mandatory error message pop up "Invalid Booking Reference Number"
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_102_4         |
 
  @TC_102AdhocPaymentErrorScenario5
  Scenario Outline:   System should display the error message as "Child Passenger Names is a required field" if the Adult no/Child no is entered without name details
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "adhoc payment" link from taskbar
    Then User is navigating to "Adhoc Request Initiation" Screen
    When User is entering Required details in "Adhoc Payment" Screen for <TestCase>
    When User is clicking on "Next" button
    When User ensures validating mandatory error message pop up "Child Passenger Names is a required field"
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_102_5         |
 
  @TC_102AdhocPaymentErrorScenario6
  Scenario Outline:   System should display the error message as "Adult Passenger Names is a required field" if the Adult no/Child no is entered without name details
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "adhoc payment" link from taskbar
    Then User is navigating to "Adhoc Request Initiation" Screen
    When User is entering Required details in "Adhoc Payment" Screen for <TestCase>
    When User is clicking on "Next" button
    When User ensures validating mandatory error message pop up "Adult Passenger Names is a required field"
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_102_6         |
 