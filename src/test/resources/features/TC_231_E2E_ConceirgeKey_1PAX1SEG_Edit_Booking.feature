@Regression @P1Scripts @TC_231EditCustomerBooking
Feature: Edit Booking - ConciergeKey

	Do a ConciergeKey edit booking and perform all the validations
	
  @TC_231EditCustomerBookingScenario1
  Scenario Outline:   Old Booking should contain a past date, two less than 7 days and one greater than 7 days airports 
, SR emails should be delivered already for past date and less than 7 days airports
, All the airports in old booking should have Authorizer name, Booking Comments and Transportation details
, There should be a change in airline code for second airport and no change for first (past), third and fourth airports 

  	Given Initiate a "Edit" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
		When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Edit Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Conceirge Key" booking using "RequestNo" details and submit for <TestCase>
    Then User is navigating to "Select Refund Details" Screen
    When User is clicking on "Next" button
    Then User is navigating to "SELECT NEW BOOKING DETAILS" Screen
    When user is editing existing fivestar booking details for <TestCase>
    When User is clicking on "Submit" button
    When User is validating Override details for editing flow for <TestCase>
     Then User is navigating to "Comments Requests" Screen
    When User is selecting Book Priority in Comments and Requests page  for <TestCase>
    When User is Providing Comments in Comments and Requests page for <TestCase>
    When User is selecting Service Indicators in Comments and Requests page for <TestCase>
    When User is Providing departure details in Comments and Requests page for <TestCase>
    When User is clicking on "Next" button	
    Then User is navigating to "Transportation Service" Screen
    And User is capturing request number for "Edit" flow for <TestCase>
    And User is entering Transport services details for "Edit" 
    When User is clicking on "Finish" button
    Then User ensures fivestar booking completed for <TestCase>
    Then User is navigating to "Five Star Booking" first level Tab
    When Booking completed User is validating "Fivestar" Request Number for "Edit" for <TestCase>
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
      | TC_231           |
   
   