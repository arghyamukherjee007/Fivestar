@Regression @P1Scripts @TC_077CommercialCustomerBooking
Feature: Commercial Customer Booking

	Initiate a Commercial Customer booking and perform all the validations
	
  @TC_077CommercialCustomerBookingScenario1
  Scenario Outline:  Two airports should be selected with service date less than 7 days and Transportation details (Domestic and International phone numbers) should be entered 

    #Given the required inputs below for "1Pax1Seg" PNR Creation for <TestCase>
    #When user post the service request to create "PNR"
    #Then response should contain "PNR" data for <TestCase>
    Given Initiate a "Book" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    When User is navigating to "Five Star Admin" first level Tab
		When User is navigating to "Airport List" second level Tab
    When Selected airport should be configured with schedule timings and correct timezone for <TestCase>
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Book Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Commercial Customer" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is clicking on "submit" button
    And User is validating Override flag if applicable and clicking submit for <TestCase>
    Then User is navigating to "Comments Requests" Screen
    When User is selecting Book Priority in Comments and Requests page  for <TestCase>
    When User is Providing Comments in Comments and Requests page for <TestCase>
    When User is selecting Service Indicators in Comments and Requests page for <TestCase>
    When User is Providing departure details in Comments and Requests page for <TestCase>
    When User is clicking on "Next" button		
    Then User is navigating to "Transportation Service" Screen
    And User is capturing request number for "Book" flow for <TestCase>
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    When Booking completed User is validating "Commercial Customer" Request Number for "Book" for <TestCase>
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
      | TC_077           |
     