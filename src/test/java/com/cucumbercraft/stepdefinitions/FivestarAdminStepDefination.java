package com.cucumbercraft.stepdefinitions;



import org.testng.Assert;

import com.cucumber.listener.Reporter;


import com.cucumbercraft.pages.FivestarAdminPage;
import com.cucumbercraft.pages.Variables;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FivestarAdminStepDefination extends MasterStepDefination {
	static CommonMethods common = new CommonMethods();

	
    @When("^Selected airport should be configured with schedule timings and correct timezone for (.+)$")
    public void selected_airport_should_be_configured_with_schedule_timings_and_correct_timezone_for(String testcase) throws Throwable {
    	AdminMethods.ChkCallFlagAirportCode_FivestarAdminPg(Variables.arrAirportCode,testcase);
    	
    }
   
    
    @Then("^User ensures fivestar booking validated successfully for (.+)$")
    public void i_ensure_fivestar_booking_validated_successfully_for(String testcase) throws Throwable {
    	AdminMethods.ValTaskExecutionDetails_FivestarAdminPg(Variables.ReqNo,testcase);
    }

   
	
    @And("^User is validating \"([^\"]*)\" SR details in Fivestar admin for (.+)$")
    public void user_is_validating_something_sr_details_in_fivestar_admin_for(String Flowtype, String testcase) throws Throwable {
    	
    		AdminMethods.ValSRDetails_FivestarAdminPg(Variables.ReqNo,Variables.SRBookingStatus,testcase);
    	
    }

    @When("^User is Checking for Tax Percentage if applicable for (.+)$")
    public void user_is_checking_for_tax_percentage_if_applicable_for(String testcase) throws Throwable {
        AdminMethods.UpdateTaxPercentage(Variables.arrAirportCode);
    }
    
    @When("^User is checking for valid \"([^\"]*)\" for \"([^\"]*)\" flow and update for (.+)$")
    public void user_is_checking_for_valid_something_for_something_flow_and_update_for(String promotype, String FlowType, String testcase) throws Throwable {
    	
    	AdminMethods.UpdatePromocode(Variables.arrAirportCode,FlowType,testcase);
    }

    
    @And("^User is Reading Credit Card Profile Details present at index \"([^\"]*)\" and deleting in Admin for (.+)$")
    public void user_is_reading_credit_card_profile_details_present_at_index_something_and_deleting_in_admin_for(int index, String testcase) throws Throwable {
     	
  	 
  	 	Variables.count=common.getRecordCount(index);
  	 	
  	 	AdminMethods.ReadTableAndDeleteRecord(Variables.CardNum,Variables.count,FivestarAdminPage.CardNumberCellCreditCardTable,FivestarAdminPage.DeleteButtonCreditCard);
    }
    
  
    @When("^User is navigating to \"([^\"]*)\" third level Tab$")
    public void user_is_navigating_to_something_third_level_tab(String TabName) throws Throwable {
    	try
		{
			switch(TabName.toUpperCase())
			{
				case "CREDIT CARD PROFILE":
			    	common.navigateThirdLevelViewbar("Credit Card Profile");
			    	Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
					break;
				case "FIVE STAR SR DETAILS":
					common.navigateThirdLevelViewbar(Variables.SRdetailsTabName);
					Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
					break;
				case "FIVE STAR FLIGHT DETAILS":
					common.navigateSecondLevelViewbar(Variables.FlightdetailsTabName);
					Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
					break;
				
			}
			Thread.sleep(2000);	
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Selecting Navigating to "+TabName);
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
		}
		

    }
    
	@Then("^User is adding Credit Card Profile Details for (.+)$")
	public void user_is_adding_credit_card_profile_details(String testcase) throws Throwable {
    	
    	AdminMethods.FillCardDetails(testcase,Variables.Agencyflag);
    	 
	  }
	
	 @When("^User is Searching \"([^\"]*)\" for (.+)$")
	 public void user_is_searching_something_for(String idtype, String testcase) throws Throwable {
		 String IdNumber=new String();
		 	if(idtype.equalsIgnoreCase("Credit Cards"))
		 	{
		 		IdNumber = Variables.AADVNum;
		 		FivestarMethods.SearchTextBoxApplet(IdNumber,FivestarAdminPage.SearchButtonCreditCard,FivestarAdminPage.AADVTextBoxCreditCard,FivestarAdminPage.GoButtonCreditCard);
		 	}
		 	else
		 	{
		 		IdNumber = Variables.OnewordId;		 		
		 		FivestarMethods.SearchTextBoxApplet(IdNumber,FivestarAdminPage.SearchButtonAgencyProfile,FivestarAdminPage.OneWordIDTextBoxAgencyProfile,FivestarAdminPage.GoButtonAgencyProfile);
		 		Variables.Agencyflag=true;
		 	}	 		
	    	
	  }

  @And("^User is validating Credit Card Profile Details in Admin for (.+)$")
    public void user_is_validating_credit_card_profile_details_in_admin_for(String testcase) throws Throwable {
	 
	  AdminMethods.ValidateTable(testcase);
    }
    
   

}
