@Regression @P1Scripts @TC_006CreditCardProfile
Feature: Credit Card Profile

	Verify the error scenarios
	
  @TC_006CreditCardProfileScenario1
  Scenario Outline:  System should display the error message as "Same card already exists" if the user try to enter already existing card for the same AADV 
  
  	Given Initiate a "CreditCard" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
    Then User ensures validating mandatory error message pop up "Same card already exists" 
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_006_1         |
   
  @TC_006CreditCardProfileScenario2
  Scenario Outline:  System should display the error message as "CC number missing or invalid" if the card number is incorrect
  
  	Given Initiate a "CreditCard" for <TestCase>
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
   	Then User ensures validating mandatory error message pop up "CC number missing or invalid" 
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_006_2         |
      
  @TC_006CreditCardProfileScenario3
  Scenario Outline:  System should display the error message as "AADV # not found" if AADV no is not valid or not available in Customer Hub
  
  	Given Initiate a "CreditCard" for <TestCase>
     Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
     When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
   	Then User ensures validating mandatory error message pop up "AADvantage Number Not Found" 
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_006_3         |
      
  @TC_006CreditCardProfileScenario4
  Scenario Outline:   System should display the error message as "Expiration date should be future date" if the date is past
  
  Given Initiate a "CreditCard" for <TestCase>
     Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
     When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
   	Then User ensures validating mandatory error message pop up "Expiration date should be future date" 
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_006_4         |
      
  @TC_006CreditCardProfileScenario5
  Scenario Outline:  System should display the error message as "Please enter all details Each field is mandatory except AddressLine2" if any of the field is kept blank except Address Line 2 and Zipcode
  
  Given Initiate a "CreditCard" for <TestCase>
     Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
     When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
   	Then User ensures validating mandatory error message pop up "Each field is mandatory except AddressLine2" 
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_006_5         |
      
 