@Regression @P1Scripts @TC_068ConceirgeKeyBooking
Feature: ConceirgeKey Booking
   Verify the error messages inside taskflow

  @TC_068ConceirgeKeyBookingScenario1
  Scenario Outline:  ConciergeKey booking should be initiated and Verify Error "Atleast 1 Passenger should have CK Flag selected since this is a ConciergeKey Booking"
  
    #Given the required inputs below for "1Pax1Seg" PNR Creation for <TestCase>
    #When user post the service request to create "PNR"
    #Then response should contain "PNR" data for <TestCase>
    Given Initiate a "Book" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Book Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Conceirge Key" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is clicking on "submit" button
    Then User ensures validating mandatory error message pop up "Atleast 1 Passenger should have CK Flag selected since this is a ConciergeKey Booking"
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_068_1         |
   
  @TC_068ConceirgeKeyBookingScenario2
  Scenario Outline:  ConciergeKey booking should be initiated and Verify Error "Select a Priority"
  
    #Given the required inputs below for "1Pax1Seg" PNR Creation for <TestCase>
    #When user post the service request to create "PNR"
    #Then response should contain "PNR" data for <TestCase>
    Given Initiate a "Book" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Book Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Conceirge Key" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is selecting CK flag for Conceirge Key booking for <TestCase>
    When User is clicking on "submit" button
    Then User is navigating to "Comments Requests" Screen
    When User is Providing Comments in Comments and Requests page for <TestCase>
    When User is selecting Service Indicators in Comments and Requests page for <TestCase>
    When User is Providing departure details in Comments and Requests page for <TestCase>
    When User is clicking on "Next" button	
    Then User ensures validating mandatory error message pop up "Select a Priority"
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_068_2         |
     
  @TC_068ConceirgeKeyBookingScenario3
  Scenario Outline:  ConciergeKey booking should be initiated and Verify Error "Comments are required since the Priority is High/Medium"
  
    #Given the required inputs below for "1Pax1Seg" PNR Creation for <TestCase>
    #When user post the service request to create "PNR"
    #Then response should contain "PNR" data for <TestCase>
    Given Initiate a "Book" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Book Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Conceirge Key" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is selecting CK flag for Conceirge Key booking for <TestCase>
    When User is clicking on "submit" button
    Then User is navigating to "Comments Requests" Screen
    When User is selecting Book Priority in Comments and Requests page  for <TestCase>
    When User is selecting Service Indicators in Comments and Requests page for <TestCase>
    When User is Providing departure details in Comments and Requests page for <TestCase>
    When User is clicking on "Next" button	
    Then User ensures validating mandatory error message pop up "Comments are required since the Priority is High/Medium"
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_068_3         |
      
  @TC_068ConceirgeKeyBookingScenario4
  Scenario Outline:  ConciergeKey booking should be initiated and Verify Error "Departure Day Phone # is a required field"
  
    #Given the required inputs below for "1Pax1Seg" PNR Creation for <TestCase>
    #When user post the service request to create "PNR"
    #Then response should contain "PNR" data for <TestCase>
    Given Initiate a "Book" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Booking" first level Tab
    When User is clicking on "Book Fivestar" link from taskbar
    Then User is navigating to "Request Initiation" Screen
    When User is able to perform a "Conceirge Key" booking using "PNR" details and submit for <TestCase>
    Then User is navigating to "Select Details" Screen
    When User is validatng adding passenger details and selecting airport for <TestCase>
    When User is selecting CK flag for Conceirge Key booking for <TestCase>
    When User is clicking on "submit" button
    Then User is navigating to "Comments Requests" Screen
    When User is selecting Book Priority in Comments and Requests page  for <TestCase>
    When User is Providing Comments in Comments and Requests page for <TestCase>
    When User is selecting Service Indicators in Comments and Requests page for <TestCase>
    When User is clicking on "Next" button	
    Then User ensures validating mandatory error message pop up "Departure Day Phone # is a required field"
    Then Logout and Close The Browser
    
   Examples: 
      | TestCase         |
      | TC_068_4         |