package com.cucumbercraft.stepdefinitions;

import com.cucumbercraft.pages.FivestarRefundPage;
import com.cucumbercraft.pages.Variables;

import cucumber.api.java.en.When;

public class FiveStarRefundStepDefination extends MasterStepDefination {

	
	  @When("^User is Searching for Pending Booking Ref and Update in sheet for (.+)$")
	  public void user_is_searching_for_pending_booking_ref_and_update_in_sheet_for(String testcase) throws Throwable {
	       FivestarMethods.SearchRequestNumber("Pending", FivestarRefundPage.SearchButtonFivestarRefund, FivestarRefundPage.RefundStatusLabelFivestarRefund, FivestarRefundPage.RefundStatusTextBoxFivestarRefund, FivestarRefundPage.GoButtonFivestarRefund);
	       String TransferRefundPnr = driver.findElement(FivestarRefundPage.PNRFivestarRefund).getAttribute("title");
	       String TransferRefundBookingRef = driver.findElement(FivestarRefundPage.BookingRefFivestarRefund).getAttribute("title");
	       String TransferRefundAmount = driver.findElement(FivestarRefundPage.RefundAmountFivestarRefund).getAttribute("title");
	       
	       	if(Variables.Editflag==true)
			{
				CommonMethods.SetEditFivestarData("TransferRefundPnr",TransferRefundPnr,testcase);
				CommonMethods.SetEditFivestarData("TransferRefundBookingRef",TransferRefundBookingRef,testcase);
				//CommonMethods.SetEditFivestarData("TransferRefundAmount",TransferRefundAmount,testcase);
				Variables.InitializeValue("Edit", testcase);
			}
			else
			{
				CommonMethods.SetFivestarData("TransferRefundPnr",TransferRefundPnr,testcase);
				CommonMethods.SetFivestarData("TransferRefundBookingRef",TransferRefundBookingRef,testcase);
				CommonMethods.SetFivestarData("TransferRefundAmount",TransferRefundAmount,testcase);
				Variables.InitializeValue("Book", testcase);
			}
			
	  }
	  
	 

}
