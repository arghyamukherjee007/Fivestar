@Regression @P1Scripts @TC_003CreditCardProfile
Feature: Add Different CreditCards

	Verify adding different credit cards under Admin screen
	
  @TC_003CreditCardProfileScenario1
  Scenario Outline:  Verify adding "Visa" type credit card under Admin screen
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
     When User is Searching "Credit Cards" for <TestCase>
    And User is validating Credit Card Profile Details in Admin for <TestCase>
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_003_1         |
   
  @TC_003CreditCardProfileScenario2
  Scenario Outline:  Verify adding "Visa" type credit card under Admin screen
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
    When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
     When User is Searching "Credit Cards" for <TestCase>
    And User is validating Credit Card Profile Details in Admin for <TestCase>
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_003_2         |
      
  @TC_003CreditCardProfileScenario3
  Scenario Outline:  Verify adding "Visa" type credit card under Admin screen
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
     When User is Searching "Credit Cards" for <TestCase>
    And User is validating Credit Card Profile Details in Admin for <TestCase>
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_003_3         |
      
  @TC_003CreditCardProfileScenario4
  Scenario Outline:  Verify adding "Visa" type credit card under Admin screen
  
     Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
     When User is Searching "Credit Cards" for <TestCase>
    And User is validating Credit Card Profile Details in Admin for <TestCase>
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_003_4         |
      
  @TC_003CreditCardProfileScenario5
  Scenario Outline:  Verify adding "Visa" type credit card under Admin screen
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
     When User is Searching "Credit Cards" for <TestCase>
    And User is validating Credit Card Profile Details in Admin for <TestCase>
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_003_5         |
      
  @TC_003CreditCardProfileScenario6
  Scenario Outline:  Verify adding "Visa" type credit card under Admin screen
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
     When User is Searching "Credit Cards" for <TestCase>
    And User is validating Credit Card Profile Details in Admin for <TestCase>
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_003_6         |
      
  @TC_003CreditCardProfileScenario7
  Scenario Outline:  Verify adding "Visa" type credit card under Admin screen
  
    Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
     When User is Searching "Credit Cards" for <TestCase>
    And User is validating Credit Card Profile Details in Admin for <TestCase>
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_003_7         |
      
  @TC_003CreditCardProfileScenario8
  Scenario Outline:  Verify adding "Visa" type credit card under Admin screen
  
   Given User is on the login page of the application
    Given User login using the valid user credentials
    And User login using Sabre Credentials
    Then User ensures fivestar booking preconditions for <TestCase>
    When User is navigating to "Five Star Admin" first level Tab
    When User is navigating to "Credit Card Profile" second level Tab
      When User is Searching "Credit Cards" for <TestCase>
    And User is Reading Credit Card Profile Details present at index "1" and deleting in Admin for <TestCase>
    Then User is adding Credit Card Profile Details for <TestCase>
     When User is Searching "Credit Cards" for <TestCase>
    And User is validating Credit Card Profile Details in Admin for <TestCase>
    Then Logout and Close The Browser
   
   Examples: 
      | TestCase         |
      | TC_003_8         |  
 