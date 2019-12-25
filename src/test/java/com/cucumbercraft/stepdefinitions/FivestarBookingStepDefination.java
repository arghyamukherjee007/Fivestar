package com.cucumbercraft.stepdefinitions;



import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.listener.Reporter;


import com.cucumbercraft.framework.Util;
import com.cucumbercraft.pages.FivestarAdhocPaymentPage;
import com.cucumbercraft.pages.FivestarBookingPage;
import com.cucumbercraft.pages.FivestarRefundPage;
import com.cucumbercraft.pages.FixedValues;
import com.cucumbercraft.pages.LoginPage;
import com.cucumbercraft.pages.Variables;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FivestarBookingStepDefination extends MasterStepDefination {
	
	static CommonMethods common = new CommonMethods();
	static Actions act=new Actions(driver);
	
//	public String testName = getTestName(); 
	
	  @Then("^User ensures fivestar booking preconditions for (.+)$")
	  public void i_ensure_fivestar_booking_preconditions_for(String testcase) throws Throwable 
	  {
		 // BookingMethods.Navigate_To_Screen("Fivestar Booking");
	  }
	  
	  
	  @When("^User is able to perform a \"([^\"]*)\" booking using \"([^\"]*)\" details and submit for (.+)$")
	  public void user_is_able_to_perform_a_something_booking_using_something_details_and_submit_for(String ReqType, String input, String testcase) throws Throwable 
	  {	  
		  if(ReqType.equalsIgnoreCase("Conceirge Key"))
		  {
			  Variables.CKflag=true;
		  }
		   BookingMethods.EnterPNRDetailsAndClickNext(input,Variables.ReqSource,ReqType,Variables.pnrNumber,Variables.ReqNo,testcase);  
		    
	  }
	  
	  @When("^User is Selecting Add Additional Services Option$")
	    public void user_is_selecting_add_additional_services_option() throws Throwable {
	        FivestarMethods.SelectCheckbox(FivestarBookingPage.AddAditionalServiceCheckBox, FivestarBookingPage.SelectChekboxUnchecked);
	    }
	  
	  @When("^User is validatng adding passenger details and selecting airport for (.+)$")
	  public void user_is_validatng_adding_passenger_details_and_selecting_airport(String testcase) throws Throwable {
		  
		  
		  BookingMethods.BookFS_SelectPrimaryPassenger_SelectDetailsPg(Variables.arrFirstName,Variables.arrLastName,Variables.arrPsngrType,Variables.arrPrimFlag,testcase);
		  Variables.count=  common.getRecordCount(2);
		  BookingMethods.BookFS_SelectAirport_ServiceType_SelectDetailsPg(Variables.arrAirportCode,Variables.arrServiceType,Variables.arrPromoCertificateID,Variables.arrPromocode,Variables.arrselectadd,Variables.arrDateInterval,Variables.arrTimeInterval,
				  "Airport",FivestarBookingPage.ServiceDateName,FivestarBookingPage.SelectChekboxUnchecked,FivestarBookingPage.PromoCodeName,FivestarBookingPage.PromoCertName,Variables.count,2);
		
	  }
	  
	  @When("^User is calculating Amount for \"([^\"]*)\" Flow for (.+)$")
	  public void user_is_calculating_amount_for_something_flow_for(String FlowType, String testcase) throws Throwable 
	  {
		  if(Variables.CKflag!=true)
		  {
			  BookingMethods.CalculateAmountAndUpdate(FlowType,Variables.selectadd,Variables.PsngrType,Variables.Promocode,testcase);     
		  }
		  
	  }

	  
	  @Then("^User ensures validating mandatory error message pop up \"([^\"]*)\"$")
	  public void user_ensures_validating_mandatory_error_message_pop_up_something(String ExpectedError) throws Throwable {
		  Variables.popupstatus=BookingMethods.CheckForPopUp(Variables.popupstatus);
	        BookingMethods.ValidateMessagePopUp(ExpectedError,Variables.popupstatus);
	  }

	
	  
	  @When("^User is navigating to \"([^\"]*)\" first level Tab$")
	  public void user_navigates_to_something_tab(String TabName) throws Throwable {
		  
		  try
			{
			  LoadPropertiesFile();
			  System.out.println(properties.getProperty("ENV"));
				switch(TabName.toUpperCase())
				{
					case "FIVE STAR BOOKING":
						common.navigateFirstLevelViewbar(Variables.BookingTabName);
						Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
						break;
					case "FIVE STAR ADMIN":
						common.navigateFirstLevelViewbar(Variables.AdminTabName);
						Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
						break;
					case "FIVE STAR REFUND":
						common.navigateFirstLevelViewbar(Variables.RefundTabName);
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
	  @When("^User is navigating to \"([^\"]*)\" second level Tab$")
	  public void user_navigates_to_something_second_tab(String TabName) throws Throwable {
		  try
			{
				switch(TabName.toUpperCase())
				{
					case "AIRPORT LIST":
						common.navigateSecondLevelViewbar("Airport List");
						Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
						break;
					case "BOOKING ADMIN":
						common.navigateSecondLevelViewbar("Booking Admin");
						Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
						break;
					case "CREDIT CARD PROFILE":
						common.navigateSecondLevelViewbar("Credit Card Profile");
						Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
						break;
					case "KEYSTAR AGENCY":
						common.navigateSecondLevelViewbar("KeyStar Agency");
						Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
						break;
					case "PROMOTIONS":
						common.navigateSecondLevelViewbar("Promotions");
						Reporter.addStepLog("User is successfully navigated to "+TabName.toUpperCase()+" Tab.");
						break;
					case "TASK EXECUTION DETAILS":
						try
						{
							common.navigateSecondLevelViewbar("Task Execution Details");
						}
						catch(Exception e)
						{
							driver.findElement(By.xpath("//*[@aria-label='Second Level View Bar']/option[text()='Task Execution Details']")).click();
							common.navigateSecondLevelViewbar("Task Execution Details");
						}
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

      @When("^User is clicking on \"([^\"]*)\" link from taskbar$")
      public void user_is_clicking_on_something_link_from_taskbar(String Taskbarlink) throws Throwable {
    	  try
			{
    		  if(!driver.findElement(FivestarBookingPage.TaskLabel).isDisplayed())
		       {
		    	   driver.findElement(LoginPage.TaskIcon).click();
				   Thread.sleep(2000);
		       }		  
				switch(Taskbarlink.toUpperCase())
				{
					case "BOOK FIVESTAR":
						driver.findElement(FivestarBookingPage.TaskBookFivestar).click();
						Reporter.addStepLog("User successfully Selected "+Taskbarlink.toUpperCase()+" link.");
						break;
					case "EDIT FIVESTAR":
						driver.findElement(FivestarBookingPage.TaskEditFivestar).click();
						Reporter.addStepLog("User successfully Selected "+Taskbarlink.toUpperCase()+" link.");
						break;
					case "ADHOC PAYMENT":
						driver.findElement(FivestarAdhocPaymentPage.TaskAdhocPayment).click();
						Reporter.addStepLog("User successfully Selected "+Taskbarlink.toUpperCase()+" link.");
						break;
					case "CANCEL FIVESTAR":
						driver.findElement(FivestarBookingPage.TaskCancelFivestar).click();
						Reporter.addStepLog("User successfully Selected "+Taskbarlink.toUpperCase()+" link.");
						break;
					case "VOID BOOKING":
						driver.findElement(FivestarBookingPage.TaskVoidBooking).click();
						Reporter.addStepLog("User successfully Selected "+Taskbarlink.toUpperCase()+" link.");
						break;
					case "PAST DATE SERVICE":
						driver.findElement(FivestarBookingPage.TaskPastDateService).click();
						Reporter.addStepLog("User successfully Selected "+Taskbarlink.toUpperCase()+" link.");
						break;
								
				}
				Thread.sleep(2000);	
			}
			catch(Exception e)
			{
				Reporter.addStepLog("Error while Selecting "+Taskbarlink+" Item from taskbar");
				Reporter.addStepLog(e.toString());
				Assert.fail(e.toString());
			}
      }
      
      @And("^User is validating Override flag if applicable and clicking submit for (.+)$")
	  public void user_is_validating_override_flag_if_applicable_and_clicking_submit(String testcase) throws Throwable {
    	  	
			
		  if(Variables.popupstatus==true)
		  {
			  driver.switchTo().alert().accept();
			  Variables.count=  common.getRecordCount(2);
			  BookingMethods.BookFS_ClickSubmit_ValidateOverride_SelectDetailsPg(Variables.count,"Airport",FivestarBookingPage.AuthorizationName,Variables.arrAirportCode,Variables.arrServiceType,Variables.arrselectadd,2);
		  }
		  
		 
	  }


	@When("^User is clicking on \"([^\"]*)\" button$")
      public void user_is_clicking_on_something_button(String buttonval) throws Throwable {
    	  BookingMethods.Click_On_Button(buttonval); 
    	 
    	  Variables.popupstatus=BookingMethods.CheckForPopUp(Variables.popupstatus);
    	  if(buttonval.equalsIgnoreCase("FINISH")||buttonval.equalsIgnoreCase("NEXT"))
    	  {
    		  if(Variables.popupstatus==true)
    		  {
    			  driver.switchTo().alert().accept();
    			  BookingMethods.Click_On_Button(buttonval);
    			  Variables.popupstatus=false;
    		  }
    	  }
    	 
      }
	
	 @When("^User is validating Override details for editing flow for (.+)$")
	 public void user_is_validating_override_details_for_editing_flow(String testcase) throws Throwable {
		
		 
		 if(Variables.popupstatus==true)
		 {
			 driver.switchTo().alert().accept();
			 Variables.count=common.getRecordCount(4);
			 BookingMethods.BookFS_ClickSubmit_ValidateOverride_SelectDetailsPg(Variables.count,"New Airport",FivestarBookingPage.AuthorizationName,Variables.arrAirportCode,Variables.arrServiceType,Variables.arrselectadd,4);
			 
		 }
	  }
	 
	 
	  @When("^User is validating Refundable and total amount and proceeding with \"([^\"]*)\" Payment for (.+)$")
	    public void user_is_validating_refundable_and_total_amount_and_proceeding_with_something_payment_for(String PaymentMode, String testcase) throws Throwable {
	      	double AppRefundableAmt = Double.parseDouble(driver.findElement(FivestarBookingPage.RefundableAmountTextBoxOverrideDetails).getAttribute("value"));
	     	double AppTotalAmt = Double.parseDouble(driver.findElement(FivestarBookingPage.TotalAmountTextBoxOverrideDetails).getAttribute("value"));
	     	 	
			  
			 
	     	if(AppRefundableAmt>AppTotalAmt)
	     	{
	     		BookingMethods.Click_On_Button("Next");
	     		BookingMethods.Navigate_To_Screen("Refund Breakdown");
	     		String AppRefundAmt=driver.findElement(FivestarBookingPage.TotalRefundAmountRefundBreakdown).getAttribute("value");
	     		CommonMethods.SetEditFivestarData("RefundAmt",AppRefundAmt,testcase);
	     		CommonMethods.SetEditFivestarData("OutstandingAmt","0",testcase);
	     		Variables.InitializeValue("Edit", testcase);
	     		BookingMethods.Click_On_Button("Process Refund");
	     		BookingMethods.Navigate_To_Screen("Payment Summary");
	     		BookingMethods.BookFSFillCallerDetailsandComments_PaymentConfirmation("TestAuto","9836926929","CTS","9223456789","DEPDAY","9564976682","automation testing","c2","c3","c4");
	     		 BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("New Transportation Service","FORD","8637595580","AutoName","4789145604","4","Auto Test");
	     		BookingMethods.Click_On_Button("Next");
	     		BookingMethods.Navigate_To_Screen("Refund Summary");
	     		BookingMethods.BookFSCapReqNo_Proceedtopay("Edit",testcase,FivestarBookingPage.RequestNumber);
	     		Variables.Refundflag=true;
	     	}
	     	else if(AppRefundableAmt==AppTotalAmt)
	     	{
	     		BookingMethods.Click_On_Button("Next");
	     		BookingMethods.Navigate_To_Screen("Edit Transportation Details");
	     		 BookingMethods.BookFSFillEmailDetails_PaymentConfirmation(Variables.EmailCheckBox,Variables.EmailAddress,testcase);
	     		BookingMethods.BookFSFillCallerDetailsandComments_PaymentConfirmation("TestAuto","9836926929","CTS","9223456789","DEPDAY","9564976682","automation testing","c2","c3","c4");
	     		BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("New Transportation Service","FORD","8637595580","AutoName","4789145604","4","Auto Test");
	     		Variables.Transportationflag=true;
	     		CommonMethods.SetEditFivestarData("OutstandingAmt","0",testcase);
	     		BookingMethods.BookFSCapReqNo_Proceedtopay("Edit",testcase,FivestarBookingPage.BookingRefNumber);
	     	}
	     	else if(AppRefundableAmt<AppTotalAmt)
	     	{
	     		BookingMethods.Click_On_Button("Next");
	     		BookingMethods.Navigate_To_Screen("Select Profile");
	     		
	     		if(PaymentMode.equalsIgnoreCase("Agency Profile"))
	     		{
	     			BookingMethods.SelectPaymentMode(PaymentMode);
	     			BookingMethods.Click_On_Button("Proceed To Pay");
		     		BookingMethods.Navigate_To_Screen("Payment Breakdown");
		     		BookingMethods.BookFS_EnterAgencyId_PaymentBreakdownPg(Variables.ProfileID,testcase);
		     		BookingMethods.SelectPaymentMode("Dont Use");
		     		BookingMethods.Click_On_Button("Proceed To Pay");
		     		
			     	
	     		}
	     		if(PaymentMode.equalsIgnoreCase("Dont Use"))
	     		{
	     			BookingMethods.Click_On_Button("Proceed To Pay");
	     			
	     		}
	     		Variables.Paymentflag=true;
	     		BookingMethods.Navigate_To_Screen("Fivestar Confirmation");
     			BookingMethods.UpdateOutstandingAmount(FivestarBookingPage.OutstandingAmountFivestarConfirmation, testcase);
	     		BookingMethods.BookFSFillEmailDetails_PaymentConfirmation(Variables.EmailCheckBox,Variables.EmailAddress,testcase);
		     	BookingMethods.BookFSFillCallerDetailsandComments_PaymentConfirmation("TestAuto","9836926929","CTS","9223456789","DEPDAY","9564976682","automation testing","c2","c3","c4");
		     	BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("New Transportation Service","FORD","8637595580","AutoName","4789145604","4","Auto Test");
		     	BookingMethods.Click_On_Button("Proceed To Pay");
		     	BookingMethods.Navigate_To_Screen("Proceed To Pay");
		     	BookingMethods.BookFSCapReqNo_Proceedtopay("Edit",testcase,FivestarBookingPage.RequestNumber);
		     	BookingMethods.BookFSFillCarddetails_Proceedtopay(Variables.CardFirstName,Variables.CardLastName,Variables.CardNumber,Variables.CardExpMonth,Variables.CardExpYear,testcase);

	     		
	     		
		    	
	     	}
	    }
	  
	  @When("^User is updating Transportation details for (.+)$")
	    public void user_is_updating_transportation_details_for(String testcase) throws Throwable {
		  double AppRefundableAmt = Double.parseDouble(driver.findElement(FivestarBookingPage.RefundableAmountTextBoxOverrideDetails).getAttribute("value"));
	     	double AppTotalAmt = Double.parseDouble(driver.findElement(FivestarBookingPage.TotalAmountTextBoxOverrideDetails).getAttribute("value"));
	     	 
	       try
	       {
	    	   if(AppRefundableAmt==AppTotalAmt)
		       {
	    		   BookingMethods.Click_On_Button("Next");
		     		BookingMethods.Navigate_To_Screen("Edit Transportation Details");
		     		 BookingMethods.BookFSFillEmailDetails_PaymentConfirmation(Variables.EmailCheckBox,Variables.EmailAddress,testcase);
		     		BookingMethods.BookFSFillCallerDetailsandComments_PaymentConfirmation("TestAuto","9836926929","CTS","9223456789","DEPDAY","9564976682","automation testing","c2","c3","c4");
		     		BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("New Transportation Service",FixedValues.CarCompany,FixedValues.CarPhone,FixedValues.DriverName,FixedValues.DriverPhone,"4",FixedValues.ATOComments);
		     		Variables.Transportationflag=true;
		     		CommonMethods.SetEditFivestarData("OutstandingAmt","0",testcase);
		     		BookingMethods.BookFSCapReqNo_Proceedtopay("Edit",testcase,FivestarBookingPage.BookingRefNumber); 
		       }
	    	  
	       }
	       catch(Exception e)
	       {
	    	   Assert.fail(e.toString());
	       }
	    }

	  @When("^User is Validating Updated Transportation details for (.+)$")
	    public void user_is_validating_updated_transportation_details_for(String testcase) throws Throwable {
	       try
	       {
	    	   for(int i=0;i<common.getRecordCount(1);i++)
				{
	    		  
					Assert.assertEquals(driver.findElement(By.id((i+1)+FivestarBookingPage.SRCarCompany)).getText().toUpperCase(), FixedValues.CarCompany.toUpperCase());
					Reporter.addStepLog("Car Company "+FixedValues.CarCompany+" Validated Successfully.");
					Assert.assertEquals(driver.findElement(By.id((i+1)+FivestarBookingPage.SRCarPhone)).getText().toUpperCase(), FixedValues.CarPhone.toUpperCase());
					Reporter.addStepLog("Car Phone "+FixedValues.CarPhone+" Validated Successfully.");
					Assert.assertEquals(driver.findElement(By.id((i+1)+FivestarBookingPage.SRDriverName)).getText().toUpperCase(), FixedValues.DriverName.toUpperCase());
					Reporter.addStepLog("Driver Name "+FixedValues.DriverName+" Validated Successfully.");
					Assert.assertEquals(driver.findElement(By.id((i+1)+FivestarBookingPage.SRDriverPhone)).getText().toUpperCase(), FixedValues.DriverPhone.toUpperCase());
					Reporter.addStepLog("Driver Phone "+FixedValues.DriverPhone+" Validated Successfully.");
					Assert.assertEquals(driver.findElement(By.id((i+1)+FivestarBookingPage.SRATOComments)).getText().toUpperCase(), FixedValues.ATOComments.toUpperCase());
					Reporter.addStepLog("ATO Comments "+FixedValues.ATOComments+" Validated Successfully.");
				
					
				}
	       }
	       catch(Exception e)
	       {
	    	   Assert.fail(e.toString());
	       }
	    }
	  
		@When("^user is editing existing fivestar booking details for (.+)$")
	    public void user_is_editing_existing_fivestar_booking_details_for(String testcase) throws Throwable {
			try
			{
				
				Variables.count=common.getRecordCount(4);
				 BookingMethods.BookFS_SelectAirport_ServiceType_SelectDetailsPg(Variables.arrAirportCode,Variables.arrServiceType,Variables.arrPromoCertificateID,Variables.arrPromocode,Variables.arrselectadd,Variables.arrDateInterval,Variables.arrTimeInterval,
						  "New Airport",FivestarBookingPage.ServiceDateName,FivestarBookingPage.SelectChekboxUnchecked,FivestarBookingPage.PromoCodeName,FivestarBookingPage.PromoCertName,Variables.count,4);
				
				 
			}
			catch(Exception e)
			{
				
			}
			 
	        
	    }

	  @Then("^User is navigating to \"([^\"]*)\" Screen$")
	    public void user_is_navigating_to_something_screen(String ScreenName) throws Throwable {
		  BookingMethods.Navigate_To_Screen(ScreenName);
			
	    }
	  
	  @When("^User is adding Override Amount for (.+)$")
	    public void user_is_adding_override_amount_for(String testcase) throws Throwable {
	        try
	        {
	        	FivestarMethods.SelectCheckbox(FivestarBookingPage.OverrideflagCheckBox, FivestarBookingPage.SelectChekboxUnchecked);
	        	((JavascriptExecutor) driver).executeScript("arguments[0].value='"+FixedValues.OverrideAmount+"'",driver.findElement(FivestarBookingPage.OverrideAmountEditableTextBox));
				driver.findElement(FivestarBookingPage.OverrideAmountEditableTextBox).click();
				
				FivestarMethods.ClickTab(act);
				
	        }
	        catch(Exception e)
	        {
	        	Assert.fail(e.toString());
	        }	        
	    }
	  
	  @When("^User is Validating Override amount and updating Refundable Amount in \"([^\"]*)\" for (.+)$")
	    public void user_is_validating_override_amount_and_updating_refundable_amount_in_something_for(String Pagename, String testcase) throws Throwable {
	    
	        try
	        {
	        	Variables.Refundflag=true;
	        	switch(Pagename.toUpperCase())
	        	{
	        		case "REFUND BREAKDOWN":
	        			BookingMethods.CompareOverrideAmount(FivestarBookingPage.RefundableAmountTextBoxOverrideDetails,FivestarBookingPage.OverrideAmountTextBoxReadOnly,FivestarBookingPage.TotalRefundableAmountRefundBreakdown,testcase);
	        			break;
	        		case "REFUND SUMMARY":
	        			BookingMethods.CompareOverrideAmount(FivestarBookingPage.RefundAmountTextBoxRefundSummary,FivestarBookingPage.OverrideAmountTextBoxReadOnly,FivestarBookingPage.TotalRefundAmountRefundBreakdown,testcase);
	        			break;
	        	}
	        	
	        	
	        }
	        catch(Exception e)
	        {
	        	
	        }
	    }

	  
	  @When("^User is Validating Nonrefundable and refundable airport and selecting Refundable flag for (.+)$")
	   public void user_is_validating_nonrefundable_and_refundable_airport_and_selecting_refundable_flag_for(String testcase) throws Throwable {
	        try
	        {
	        	for(int i=0;i<common.getRecordCount(3);i++)
	        	{
	        		String AirportCodeVal = driver.findElement(By.xpath("//table[@summary='Airport']/tbody/tr["+(i+2)+"]/td[3]")).getText();
					 String ServiceTypeVal=new String();
					if(Variables.CKflag==true)
					 {
						 ServiceTypeVal = driver.findElement(By.xpath("//table[@summary='Airport']/tbody/tr["+(i+2)+"]/td[6]")).getText();
							
					 }
					 else
					 {
						 ServiceTypeVal = driver.findElement(By.xpath("//table[@summary='Airport']/tbody/tr["+(i+2)+"]/td[8]")).getText();
							
					 }
					if(Variables.arrselectadd[i].equalsIgnoreCase("ON"))
	        		{
	        			if(Variables.arrAirportCode[i].equalsIgnoreCase(AirportCodeVal) && Variables.arrServiceType[i].equalsIgnoreCase(ServiceTypeVal))
	        			{
	        				if(Double.parseDouble(Variables.arrDateInterval[i])==0 && Double.parseDouble(Variables.arrTimeInterval[i])<=12)
	        				{
	        					Assert.assertEquals(driver.findElement(By.xpath("//table[@summary='Airport']/tbody/tr["+(i+2)+"]/td[2]")).getText(), "Non-Refundable");
	        				}
	        				else
	        				{
	        					Assert.assertEquals(driver.findElement(By.xpath("//table[@summary='Airport']/tbody/tr["+(i+2)+"]/td[2]")).getText(), "Refundable");
	        				}
	        			}
	        		}
	        	}
	        }
	        catch(Exception e)
	        {
	        	
	        }
	    }
	  
	  @When("^User is capturing Additional Services for \"([^\"]*)\" and calculating amount for (.+)$")
	    public void user_is_capturing_additional_services_for_something_and_calculating_amount_for(String FlowType, String testcase) throws Throwable {       try
	        {
	        	if(common.getRecordCount(1)!=0)
	        	{
	        		Variables.additionalserviceflag=true;
	        		FivestarMethods.SelectCheckbox(FivestarBookingPage.SelectAdditionalServicesTabel, FivestarBookingPage.SelectChekboxUnchecked);
	        		String AirportCode=driver.findElement(FivestarBookingPage.AirportcodeAdditionalServicesTabel).getText();
	        		String ServiceType=driver.findElement(FivestarBookingPage.ServiceTypeAdditionalServicesTabel).getText();
	        		String PricePerBooking=driver.findElement(FivestarBookingPage.PricePerBookingAdditionalServicesTabel).getText();
	        		if(PricePerBooking.equalsIgnoreCase(" "))
	        		{
	        			PricePerBooking="0";
	        		}
	        		String AdultPrice=driver.findElement(FivestarBookingPage.AdultPriceAdditionalServicesTabel).getText();
	        		if(AdultPrice.equalsIgnoreCase(" "))
	        		{
	        			AdultPrice="0";
	        		}
	        		String ChildPrice=driver.findElement(FivestarBookingPage.ChildPriceAdditionalServicesTabel).getText();
	        		if(ChildPrice.equalsIgnoreCase(" "))
	        		{
	        			ChildPrice="0";
	        		}
	        		
	        		switch(FlowType.toUpperCase())
	        		{
	        			case "BOOK":
	        				CommonMethods.SetFivestarData("airportcodeadditional",AirportCode, testcase);			
	        				CommonMethods.SetFivestarData("servicetypeadditional",ServiceType, testcase);
	        				CommonMethods.SetFivestarData("PricePerBooking",PricePerBooking, testcase);
	        				CommonMethods.SetFivestarData("adultpriceadditional",AdultPrice, testcase);
	        				CommonMethods.SetFivestarData("childpriceadditional",ChildPrice, testcase);
	        				break;
	        			case "EDIT":
	        				CommonMethods.SetEditFivestarData("airportcodeadditional",AirportCode, testcase);			
	        				CommonMethods.SetEditFivestarData("servicetypeadditional",ServiceType, testcase);
	        				CommonMethods.SetEditFivestarData("PricePerBooking",PricePerBooking, testcase);
	        				CommonMethods.SetEditFivestarData("adultpriceadditional",AdultPrice, testcase);
	        				CommonMethods.SetEditFivestarData("childpriceadditional",ChildPrice, testcase);
	        				break;
	        			case "CANCEL":
	        				CommonMethods.SetCancelFivestarData("airportcodeadditional",AirportCode, testcase);			
	        				CommonMethods.SetCancelFivestarData("servicetypeadditional",ServiceType, testcase);
	        				CommonMethods.SetCancelFivestarData("PricePerBooking",PricePerBooking, testcase);
	        				CommonMethods.SetCancelFivestarData("adultpriceadditional",AdultPrice, testcase);
	        				CommonMethods.SetCancelFivestarData("childpriceadditional",ChildPrice, testcase);
	        				break;
	        		}
	        		Variables.InitializeValue(FlowType, testcase);
	        	}
	        }
	        catch(Exception e)
	        {
	        	
	        }
	    }
	  
	  @When("^User is Capturing selected Airport details and updating for (.+)$")
	    public void user_is_capturing_selected_airport_details_and_updating_for(String testcase) throws Throwable {
	        try
	        {
	        	List<String> AirportCode = new ArrayList<String>();
	        	List<String> Selectadd = new ArrayList<String>();
	        	List<String> ServiceType = new ArrayList<String>();
				for(int i=0;i<common.getRecordCount(3);i++)
				{
					AirportCode=FivestarMethods.FetchListValue(By.xpath("//table[@summary='Airport']/tbody/tr["+(i+2)+"]/td[3]"),Variables.arrAirportCode[i],AirportCode);
					ServiceType=FivestarMethods.FetchListValue(By.xpath("//table[@summary='Airport']/tbody/tr["+(i+2)+"]/td[8]"),Variables.arrServiceType[i],ServiceType);
					Selectadd.add("ON");
					
					
				}
				String allAirportCode = String.join(",", AirportCode);
				String allSelectadd = String.join(",", Selectadd);
				String allServiceType = String.join(",", ServiceType);
				CommonMethods.SetEditFivestarData("AirportCode",allAirportCode, testcase);			
				CommonMethods.SetEditFivestarData("ServiceType",allServiceType, testcase);			
				CommonMethods.SetEditFivestarData("selectadd",allSelectadd, testcase);			
				Variables.InitializeValue("Edit", testcase);
	        }
	        catch(Exception e)
	        {
	        	Assert.fail(e.toString());
	        }
	    }
	  
	  @When("^User is selecting Book Priority in Comments and Requests page  for (.+)$")
	    public void user_is_selecting_book_priority_in_comments_and_requests_page_for(String testcase) throws Throwable {
		  BookingMethods.BookSelectPriority_CommentsRequests(Variables.BookPriority,testcase);
		  FivestarMethods.ClickTab(act);
	    }

	    @When("^User is Providing Comments in Comments and Requests page for (.+)$")
	    public void user_is_providing_comments_in_comments_and_requests_page_for(String testcase) throws Throwable {
	    	BookingMethods.BookProvideComments_CommentsRequests("c1","c2","c3","c4");
	    }

	    @When("^User is selecting Service Indicators in Comments and Requests page for (.+)$")
	    public void user_is_selecting_service_indicators_in_comments_and_requests_page_for(String testcase) throws Throwable {
	    	BookingMethods.BookSelectServiceIndicators_CommentsRequests();
	    }

	    @When("^User is Providing departure details in Comments and Requests page for (.+)$")
	    public void user_is_providing_departure_details_in_comments_and_requests_page_for(String testcase) throws Throwable {
	    	BookingMethods.BookProvideDepartureDetails_CommentsRequests("abio","9855785652");
	    }
	    
	
	 @When("^User is entering Required details in \"([^\"]*)\" Screen for (.+)$")
	 public void user_is_entering_required_details_in_something_screen(String strArg1,String testcase) throws Throwable 
	 {
		 AdhocPaymentMethods.FillAdhocPaymentReqInitiation(testcase);
	 }

	
	
	  @When("^User is searching refund by entering \"([^\"]*)\" and \"([^\"]*)\" number for (.+)$")
	  public void user_is_searching_refund_by_entering_something_and_something_number_for(String pnr, String reqno, String testcase) throws Throwable {
		  
		  BookingMethods.SearchTransferRefundUsingPNR(Variables.TransferRefundPNRNo,Variables.TransferRefundReqNo,testcase);
		 
	  }
	  
	  @And("^User is selecting required transfer refund for (.+)$")
	  public void user_is_selecting_required_transfer_refund_for(String testcase) throws Throwable {
		  Variables.count=common.getRecordCount(2);
		  
		  if(Variables.count!=0)
		  {
			  FivestarMethods.SelectCheckbox(FivestarBookingPage.SelectLabelSelectRefunds, FivestarBookingPage.SelectChekboxUnchecked);
			  double CaptureNetAmtPrice = Double.parseDouble(driver.findElement(FivestarBookingPage.NetTotalPrice).getAttribute("value"));
			  double TransferRefundAmt  = Double.parseDouble(driver.findElement(FivestarBookingPage.TransferRefundPNRAmount).getText());
			  if(Double.compare(CaptureNetAmtPrice, TransferRefundAmt)!=0)
			  {
				  Variables.TRefundflag=true;
			  }
		  }
		  
		  
	  }
	  
	  @When("^User is entering Transport services details and perform payment if applicable for (.+)$")
	  public void user_is_entering_transport_services_details_and_perform_payment_if_applicable_for(String testcase) throws Throwable {
		  
	    	
		  if(Variables.Taxflag==true||Variables.TRefundflag==true)
		  {
			  BookingMethods.Navigate_To_Screen("Select Transfer Refund Profile");
			  BookingMethods.UpdateOutstandingAmount(FivestarBookingPage.OutstandingAmountSelectTransferRefund,testcase);
			  BookingMethods.Click_On_Button("Proceed To Pay");
		  }
		  BookingMethods.Navigate_To_Screen("Five Star Confirmation");
		  BookingMethods.BookFSFillEmailDetails_PaymentConfirmation(Variables.EmailCheckBox,Variables.EmailAddress,testcase);
		  BookingMethods.BookFSFillCallerDetailsandComments_PaymentConfirmation("TestAuto","9836926929","CTS","9223456789","DEPDAY","9564976682","automation testing","c2","c3","c4");
		  BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("Transportation Service","FORD","8637595580","AutoName","4789145604","4","Auto Test");
		  if(Variables.Taxflag==true||Variables.Refundflag==true)
		  {
			  BookingMethods.Click_On_Button("Proceed To Pay");
			  BookingMethods.Navigate_To_Screen("Proceed To Pay");
			 
			  BookingMethods.BookFSFillCarddetails_Proceedtopay(Variables.CardFirstName,Variables.CardLastName,Variables.CardNumber,Variables.CardExpMonth,Variables.CardExpYear,testcase);  
		  }
		  
	  }
	  
	  
	  @When("^User Selects \"([^\"]*)\" as payment option$")
	  public void user_selects_something_as_payment_option(String paymentoption) throws Throwable {
		 BookingMethods.SelectPaymentMode(paymentoption);

	    }
	  
	  	  
	  @When("^Validate net price,adult price and promo amount in payment breakdown page for (.+)$")
	    public void validate_net_priceadult_price_and_promo_amount_in_payment_breakdown_page_and_proceed_to_pay_for(String testcase) throws Throwable {
		  
		 FivestarMethods.ValNetPrice_SelectProfilePgPg(Variables.NetTotalAmt,testcase);
		 FivestarMethods.ValAdultPrice_SelectProfilePgPg(Variables.NetAdultPrice,testcase);
		 FivestarMethods.ValPromoAmt_SelectProfilePgPg(Variables.PromoDiscount,testcase);
		 FivestarMethods.ValAdditionalServices_SelectProfilePg(Double.parseDouble(Variables.TotalAdditionalServices), testcase);
	  }
	  
	  @Then("^User ensures fivestar booking completed for (.+)$")
	  public void i_ensure_fivestar_booking_completed_for(String testcase) throws Throwable {
		  BookingMethods.Navigate_To_Screen("Fivestar Booking");
	  }
	  
	  
	  @When("^Booking completed User is validating \"([^\"]*)\" Request Number for \"([^\"]*)\" for (.+)$")
	    public void booking_completed_user_is_validating_something_request_number_for_something_for(String ReqType, String Flowtype, String testcase) throws Throwable {
		  
		 if(Variables.Editflag==true)
		 {
			 FivestarMethods.SearchRequestNumber(Variables.OldReqNo, FivestarBookingPage.SearchButtonBookingList, FivestarBookingPage.ReqNumberLabel, FivestarBookingPage.ReqNumberTextBox, FivestarBookingPage.GoButtonBookingList);
			 FivestarMethods.ClickTab(act);
			 BookingMethods.ValBookingStatus(Variables.OldReqNo,Variables.UpdatedBookingStatus);
			 FivestarMethods.ClickTabOrButton(FivestarBookingPage.RequestNumberLink);
			 Thread.sleep(2000);
			 common.navigateThirdLevelViewbar(Variables.SRdetailsTabName);			
			 BookingMethods.CheckForCancelledStatus();
			 BookingMethods.ValSRDetails_FiveStarBookingPg(Variables.arrAirportCode,Variables.arrCancelledSRStatus,testcase,Flowtype);
			 common.navigateFirstLevelViewbar(Variables.BookingTabName);
			 
			
			
			  
		 }
		
		 FivestarMethods.SearchRequestNumber(Variables.ReqNo, FivestarBookingPage.SearchButtonBookingList, FivestarBookingPage.ReqNumberLabel, FivestarBookingPage.ReqNumberTextBox, FivestarBookingPage.GoButtonBookingList);
		 FivestarMethods.ClickTab(act);
		 BookingMethods.ValBookingStatus(Variables.ReqNo,Variables.BookingStatus);
		 if(Variables.CKflag!=true)
		 {
				 BookingMethods.ValPaidAmt(Variables.ReqNo,Variables.OutstandingAmt);
		 }	
	 
	  
		  FivestarMethods.ClickTabOrButton(FivestarBookingPage.RequestNumberLink);
		  
	    }
	  
	  @When("^Booking completed User is validating Airport details for (.+)$")
	    public void booking_completed_user_is_validating_airport_details_for(String testcase) throws Throwable {
		   BookingMethods.ValAirportDetails_FiveStarBookingPg(Variables.arrAirportCode,Variables.arrAirportPrice,Variables.arrServiceType,testcase);
	    }

	    @When("^Booking completed User is validating \"([^\"]*)\" details in payment for (.+)$")
	    public void booking_completed_user_is_validating_something_details_in_payment_for(List<String> payment,String testcase) throws Throwable {
	    	if(Variables.PromoAmountfulluse==true)
	    	{
	    		if(common.getRecordCount(4)==0)
	    		{
	    			Reporter.addStepLog("Promo Amount Exhausted whole amount.So No Need to Pay");
	    		}
	    		else
	    		{
	    			Reporter.addStepLog("Script failed as inspite of exhausing full amount with promocode,record present in payment tab.");
	    			Assert.fail();
	    		}
	    	}
	    	else
	    	{
	    		BookingMethods.ValPaymentTab_FivestarBookingPg(Variables.OutstandingAmt);
	    	}
	    }

	    @When("^Booking completed User is validating \"([^\"]*)\" SR details at iteration \"([^\"]*)\" for (.+)$")
	    public void booking_completed_user_is_validating_something_sr_details_at_iteration_something_for(String FlowType, int iteration, String testcase) throws Throwable {
	    	if(Variables.Cancelflag==true && iteration>1)
	    	{
	    		 BookingMethods.CheckForCancelledStatus();
	    		BookingMethods.ValSRDetails_FiveStarBookingPg(Variables.arrAirportCode,Variables.arrSRCancelledBookingStatus,testcase,FlowType);
	    	}
	    	else
	    	{
	    		BookingMethods.ValSRDetails_FiveStarBookingPg(Variables.arrAirportCode,Variables.arrSRBookingStatus,testcase,FlowType);
	    	}
	    	
	    }

	    @Then("^Refund record should be created properly With \"([^\"]*)\" Status for (.+)$")
	    public void refund_record_should_be_created_properly_with_something_status_for(String testcase, String strArg1) throws Throwable {
	    	try
	    	{
	    		FivestarMethods.SearchRequestNumber(Variables.ReqNo, FivestarRefundPage.SearchButtonFivestarRefund, FivestarRefundPage.BookingRefLabelFivestarRefund, FivestarRefundPage.BookingRefTextBoxFivestarRefund, FivestarRefundPage.GoButtonFivestarRefund);
	    		String RefundStatus = driver.findElement(FivestarRefundPage.RefundStatusLabelFivestarRefund).getText();
	    		Assert.assertEquals(RefundStatus, "Pending");
	    		String RefundAmount = driver.findElement(FivestarRefundPage.RefundAmountFivestarRefund).getText();
	    		Assert.assertEquals(RefundAmount, Variables.RefundAmt);
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		Assert.fail(e.toString());
	    	}
	    }
	    
	    @And("^User Keep on checking for SR details if details are not present$")
	    public void user_keep_on_checking_for_sr_details_if_details_are_not_present() throws Throwable {
	    	int count=0;
			
			while (count==0)
			{
				count=common.getRecordCount(1);
				if(count!=0)
				{
					break;
				}
				common.navigateThirdLevelViewbar(Variables.FlightdetailsTabName);
				common.navigateThirdLevelViewbar(Variables.SRdetailsTabName);
				
			}
			
	    }

	  @When("^User is entering email information for (.+)$")
	    public void user_is_entering_email_information_for(String testcase) throws Throwable {
		  BookingMethods.UpdateOutstandingAmount(FivestarBookingPage.OutstandingAmountFivestarConfirmation,testcase);
		  BookingMethods.BookFSFillEmailDetails_PaymentConfirmation(Variables.EmailCheckBox,Variables.EmailAddress,testcase);
	    }
	  
	   @When("^User has provided Agency profile information as payment for (.+)$")
	    public void user_has_provided_agency_profile_information_as_payment(String testcase) throws Throwable {
		  BookingMethods.BookFS_EnterAgencyId_PaymentBreakdownPg(Variables.ProfileID,testcase);
	   }

	    @And("^User is entering caller details$")
	    public void user_is_entering_caller_details() throws Throwable {
	    	BookingMethods.BookFSFillCallerDetailsandComments_PaymentConfirmation("TestAuto","9836926929","CTS","9223456789","DEPDAY","9564976682","automation testing","c2","c3","c4");
	    }

	   
	   
	    @And("^User is entering Transport services details for \"([^\"]*)\"$")
	    public void user_is_entering_transport_services_details_and_click_proceed_to_pay(String FlowType) throws Throwable {
	    //	(FlowType.equalsIgnoreCase("Edit"))?BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("New Transportation Service","FORD","8637595580","AutoName","4789145604","4","Auto Test")
	    	//		:BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("Transportation Service","FORD","8637595580","AutoName","4789145604","4","Auto Test");
			
	    	if(FlowType.equalsIgnoreCase("Edit"))
	    	{
	    		BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("New Transportation Service","FORD","8637595580","AutoName","4789145604","4","Auto Test");
	    	}
	    	else
	    	{
	    		BookingMethods.BookFSFillTransportServicedetails_PaymentConfirmation("Transportation Service","FORD","8637595580","AutoName","4789145604","4","Auto Test");
		    		
	    	}
	    	
	    }
	   
	    @When("^User is checking for Promotion Amount for \"([^\"]*)\" flow for (.+)$")
	    public void user_is_checking_for_promotion_amount_for_something_flow_for(String Flowtype, String testcase) throws Throwable {
	        if(Variables.OutstandingAmt==0.0)
	        {
	        	BookingMethods.BookFSCapReqNo_Proceedtopay(Flowtype,testcase,FivestarBookingPage.BookingRefNumber);
	        	Variables.PromoAmountfulluse=true;
	        }
	        else
	        {
	        	BookingMethods.Click_On_Button("Proceed To Pay");
	        	BookingMethods.Navigate_To_Screen("PROCEED TO PAY");
	        	BookingMethods.BookFSCapReqNo_Proceedtopay(Flowtype,testcase,FivestarBookingPage.RequestNumber);
	        	BookingMethods.BookFSFillCarddetails_Proceedtopay(Variables.CardFirstName,Variables.CardLastName,Variables.CardNumber,Variables.CardExpMonth,Variables.CardExpYear,testcase);
	        }
	    }
	    
	    @And("^User is capturing request number for \"([^\"]*)\" flow for (.+)$")
	    public void user_is_capturing_request_number_for_something_flow_for(String Flowtype, String testcase) throws Throwable {
	    	
	    	BookingMethods.BookFSCapReqNo_Proceedtopay(Flowtype,testcase,FivestarBookingPage.RequestNumber);
	    }

	    
	    @And("^User is filling card details and proceed to finish the booking for (.+)$")
	    public void user_is_filling_card_details_and_proceed_to_finish_the_booking_for(String testcase) throws Throwable {
	    	BookingMethods.BookFSFillCarddetails_Proceedtopay(Variables.CardFirstName,Variables.CardLastName,Variables.CardNumber,Variables.CardExpMonth,Variables.CardExpYear,testcase);
	    }
	    
		
		@When("^User is selecting CK flag for Conceirge Key booking for (.+)$")
	    public void user_is_selecting_ck_flag_for_conceirge_key_booking_for(String testcase) throws Throwable {
			BookingMethods.SelectCKFlag_ConceirgeKeyBooking();
	    }
		
		
		
}

