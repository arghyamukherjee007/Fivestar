package com.cucumbercraft.stepdefinitions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.plexus.util.StringUtils;
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
import com.cucumbercraft.pages.FivestarBookingPage;
import com.cucumbercraft.pages.FixedValues;
import com.cucumbercraft.pages.Variables;

public class BookingMethods extends MasterStepDefination {

	static BookFiveStarData BookFivestardata;
	static EditFiveStarData Editfivestardata;
	static CommonMethods common = new CommonMethods();
	static Actions act=new Actions(driver);
	
	 public static void ValidateMessagePopUp(String ExpectedError,boolean popupstatus)
	  {
		  String ActualError=new String();
		  try
		  {
			  if(popupstatus==true)
			  {
				   	 ActualError = driver.switchTo().alert().getText().toString();
				   	 if(ActualError.contains(ExpectedError))
				   	 {
				   		 driver.switchTo().alert().accept();
				   		 Reporter.addStepLog("Error Message "+ExpectedError+ " validated Successfully");
				   		 

				   	 }
					
			  }
			
		  }
		  catch(Exception e)
		  {
			  Reporter.addStepLog("Error Message "+ExpectedError+ " in not matched with "+ActualError);
		  }
	  }
	 
	 
	   public static void Click_On_Button(String buttonval)
	      {
	    	    try
				{
	    	    	LoadPropertiesFile(); 
					switch(buttonval.toUpperCase())
					{
						case "PROCEED TO PAY":
							FivestarMethods.ClickTabOrButton(FivestarBookingPage.ProceedToPayButton);
							Reporter.addStepLog("User successfully Selected "+buttonval.toUpperCase()+" link.");
							break;
						case "SUBMIT":
							if(properties.getProperty("ENV").equalsIgnoreCase("TEST"))
							{
								FivestarMethods.ClickTabOrButton(By.xpath("//*[text()='Submit']"));
							}
							else
							{
								FivestarMethods.ClickTabOrButton(FivestarBookingPage.SubmitButton);
							}
							Reporter.addStepLog("User successfully Selected "+buttonval.toUpperCase()+" link.");
							break;
						case "FINISH":
							FivestarMethods.ClickTabOrButton(FivestarBookingPage.FinishButton);
							Reporter.addStepLog("User successfully Selected "+buttonval.toUpperCase()+" link.");
							break;
						case "NEXT":
							FivestarMethods.ClickTabOrButton(FivestarBookingPage.NextButtonBookRequestInitiation);
							Reporter.addStepLog("User successfully Selected "+buttonval.toUpperCase()+" link.");
							break;
						case "TRANSFER REFUNDS":
							FivestarMethods.ClickTabOrButton(FivestarBookingPage.TransferRefundsButton);
							Reporter.addStepLog("User successfully Selected "+buttonval.toUpperCase()+" link.");
							break;
						case "PROCESS REFUND":
							FivestarMethods.ClickTabOrButton(FivestarBookingPage.ProcessRefundButton);
							Reporter.addStepLog("User successfully Selected "+buttonval.toUpperCase()+" link.");
							break;
								
					}
					Thread.sleep(2000);	
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while clicking "+buttonval+" button");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
	      }
	   
	   
	   public static void BookSelectPriority_CommentsRequests(String BookPriority,String testcase)
		 {
			 try
			 {
				
				 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+BookPriority+"'",driver.findElement(FivestarBookingPage.BookPriorityDropdownCommentsRequests));
				 
				 
			 }
			 catch(Exception e)
			{
					Reporter.addStepLog("Error while Selecting priority ");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
			}
		 }
		 
		 public static void BookProvideComments_CommentsRequests(String com1,String com2,String com3,String com4)
		 {
			 try
			 {
				
				 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+com1+"'",driver.findElement(FivestarBookingPage.Comments1TextBoxCR));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+com2+"'",driver.findElement(FivestarBookingPage.Comments2TextBoxCR));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+com3+"'",driver.findElement(FivestarBookingPage.Comments3TextBoxCR));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+com4+"'",driver.findElement(FivestarBookingPage.Comments4TextBoxCR));
				 
				 
			 }
			 catch(Exception e)
			{
					Reporter.addStepLog("Error while providing comments ");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
			}
		 }
		 
		 public static void BookSelectServiceIndicators_CommentsRequests()
		 {
			 try
			 {
				
				driver.findElement(FivestarBookingPage.RelationshipGreetingCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.MaasCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.ElectricCartCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.PreBoardCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.WheelchairCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.ArmedCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.OAConnectionCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.OtherCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.LanguageCheckBoxCR).click();
				driver.findElement(FivestarBookingPage.PetInCabinCheckBoxCR).click();
				
				 
			 }
			 catch(Exception e)
			{
					Reporter.addStepLog("Error while selecting service indicators ");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
			}
		 }
		 
		 public static void BookProvideDepartureDetails_CommentsRequests(String DepdayName,String DepdayPhone)
		 {
			 try
			 {
				
				 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+DepdayName+"'",driver.findElement(FivestarBookingPage.DepartureDayNameTextBoxCR));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+DepdayPhone+"'",driver.findElement(FivestarBookingPage.DepartureDayPhoneTextBoxCR));
				 driver.findElement(FivestarBookingPage.DepartureDayPhoneTextBoxCR).click();
				 driver.findElement(FivestarBookingPage.BookPriorityDropdownCommentsRequests).click();
				 driver.findElement(FivestarBookingPage.Comments1TextBoxCR).click();
				 driver.findElement(FivestarBookingPage.Comments2TextBoxCR).click();
				 driver.findElement(FivestarBookingPage.Comments3TextBoxCR).click();
				 driver.findElement(FivestarBookingPage.Comments4TextBoxCR).click();
			 }
			 catch(Exception e)
			{
					Reporter.addStepLog("Error while providing departure details ");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
			}
		 }
		 
		 public static void Navigate_To_Screen(String ScreenName) throws Exception
		 {
			
			 try
				{
				 	LoadPropertiesFile();
					switch(ScreenName.toUpperCase())
					{
						case "FIVESTAR BOOKING":
							if(properties.getProperty("ENV").equalsIgnoreCase("TEST"))
							{
								NavigateTo_NextScreen(FivestarBookingPage.TaskBookFivestar,FivestarBookingPage.FivestarBookingListLabeltest3, "class", "fancytree-title","class", "siebui-applet-title");
								
							}
							else
							{
								NavigateTo_NextScreen(FivestarBookingPage.TaskBookFivestar,FivestarBookingPage.FivestarBookingListLabelOCItest, "class", "fancytree-title","class", "siebui-applet-title");
								
							}
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "EDIT TRANSPORTATION DETAILS":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarEditTransportationDetails,FivestarBookingPage.PaymentSummaryLabel, "class", "fancytree-title","id", "Summary_Label");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "ADDITIONAL SERVICES":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarAdditionalServices,FivestarBookingPage.ScreenAdditionalServices, "class", "fancytree-title","class", "siebui-applet-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "SELECT REFUND DETAILS":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarSelectRefundDetails,FivestarBookingPage.RequestAppletLabel, "class", "fancytree-title","class", "siebui-applet-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "SELECT NEW BOOKING DETAILS":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarSelectNewBookingDetails,FivestarBookingPage.NewRequestAppletLabel, "class", "fancytree-title","class", "siebui-applet-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "ENTER OVERRIDE DETAILS":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarEnterOverridedetails,FivestarBookingPage.PassengersLabel, "class", "fancytree-title","class", "siebui-applet-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "REFUND BREAKDOWN":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarRefundBreakdown,FivestarBookingPage.PassengersLabel, "class", "fancytree-title","class", "siebui-applet-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "PAYMENT SUMMARY":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarPaymentSummary,FivestarBookingPage.PaymentSummaryLabel, "class", "fancytree-title","id", "Summary_Label");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						
						case "COMMENTS REQUESTS":
							NavigateTo_NextScreen(FivestarBookingPage.TaskCommentsRequests,FivestarBookingPage.BookingCommentsLabel, "class", "fancytree-title","id", "AAKS_Comments_Label");
							Variables.CKflag=true;
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;	
						case "ADHOC REQUEST INITIATION":
							NavigateTo_NextScreen(FivestarBookingPage.AdhocTaskbarRequestInitiation,FivestarBookingPage.AdhocScreenBookRequestInitiation, "class", "fancytree-title","class", "siebui-taskui-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						
						case "REQUEST INITIATION":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarRequestInitiation,FivestarBookingPage.ScreenBookRequestInitiation, "class", "fancytree-title","class", "siebui-taskui-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "SELECT DETAILS":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarSelectDetails,FivestarBookingPage.PassengersLabel, "class", "fancytree-title","class", "siebui-applet-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "SELECT PROFILE":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarSelectProfile,FivestarBookingPage.PaymentBreakdownLabel, "class", "fancytree-title","id", "FormSection1_Label");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "FIVESTAR CONFIRMATION":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarFivestarConfirmation,FivestarBookingPage.PaymentSummaryLabel, "class", "fancytree-title","id", "Summary_Label");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "PROCEED TO PAY":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarProceedToPay,FivestarBookingPage.ScreenProceedToPay, "class", "fancytree-title","class", "siebui-taskui-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "SELECT REFUNDS":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarSelectRefund,FivestarBookingPage.SelectRefundsLabel, "class", "fancytree-title","class", "siebui-applet-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "REFUND SUMMARY":
							NavigateTo_NextScreen(FivestarBookingPage.TaskRefundSummary,FivestarBookingPage.RefundSummaryLabel, "class", "fancytree-title","class", "siebui-taskui-title");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "PAYMENT BREAKDOWN":
							NavigateTo_NextScreen(FivestarBookingPage.TaskbarPaymentBreakdown,FivestarBookingPage.PaymentBreakdownLabel, "class", "fancytree-title","id", "FormSection1_Label");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "SELECT TRANSFER REFUND PROFILE":
							NavigateTo_NextScreen(FivestarBookingPage.TaskBarSelectTransferRefundProfile,FivestarBookingPage.PaymentBreakdownLabel, "class", "fancytree-title","id", "FormSection1_Label");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
						case "TRANSPORTATION SERVICE":
							NavigateTo_NextScreen(FivestarBookingPage.TaskTransportationService,FivestarBookingPage.BookingCommentsLabel, "class", "fancytree-title","id", "AAKS_Comments_Label");
							Reporter.addStepLog("User is successfully navigated to "+ScreenName.toUpperCase()+" Screen.");
							break;
					}
					Thread.sleep(2000);	
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while Selecting Navigating to "+ScreenName);
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
		 }
		 
		 public static void SelectPaymentMode(String paymentoption)
		 {
			 try
				{
			  		  
					switch(paymentoption.toUpperCase())
					{
						case "TRANSFER REFUNDS":
							driver.findElement(FivestarBookingPage.RadioButtonTransferRefund).click();
							
							Reporter.addStepLog("User successfully Selected "+paymentoption.toUpperCase()+" radio button.");
							break;
						case "AGENCY PROFILE":
							driver.findElement(FivestarBookingPage.RadioButtonAgencyProfile).click();
							Reporter.addStepLog("User successfully Selected "+paymentoption.toUpperCase()+" radio button.");
							break;
						case "DONT USE":
							driver.findElement(FivestarBookingPage.RadioButtonAgencyId).click();
							Reporter.addStepLog("User successfully Selected "+paymentoption.toUpperCase()+" radio button.");
							break;
									
					}
					Thread.sleep(2000);	
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while selecing "+paymentoption+" radio button");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
		 }
		 public static void SearchTransferRefundUsingPNR(String PNRNo,String ReqNo,String testcase) throws Exception
		  {
			  try
			  {
				 Variables.TransferRefundflag=true;
				  driver.findElement(FivestarBookingPage.ScreenSelectRefundLabel).click();
				  driver.findElement(FivestarBookingPage.PNRTextBoxSelectRefunds).click();
				  FivestarMethods.javascriptClick(driver, driver.findElement(FivestarBookingPage.PNRTextBoxSelectRefunds));
				  ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+PNRNo+"'",driver.findElement(FivestarBookingPage.PNRTextBoxSelectRefunds));
				  Thread.sleep(1000);
				  FivestarMethods.javascriptClick(driver, driver.findElement(FivestarBookingPage.BookingRefTextBoxSelectRefunds));
				  ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+ReqNo+"'",driver.findElement(FivestarBookingPage.BookingRefTextBoxSelectRefunds));
				
				  FivestarMethods.ClickTabOrButton(FivestarBookingPage.SearchRefundsButton);
				  Thread.sleep(2000);
			  }
			  catch(Exception e)
			  {
				  Thread.sleep(2000);
			  }
			 
		  }    
		 public static void ValBookingStatus(String ReqNo,String BookingStatus)
		 {
		    	try
		    	{
		    		String AppBookingStatus=driver.findElement(FivestarBookingPage.BookingStatus).getText();
		    		Assert.assertEquals(BookingStatus.toUpperCase(), AppBookingStatus.toUpperCase());
					
		    		Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					
					
		    	}
		    	catch(Exception e)
		    	{
		    		Assert.fail(e.toString());
		    	}

		 }
		 public static void ValPaidAmt(String ReqNo,double PaidAmt)
		    {
		    	try
		    	{
		    		if(Variables.CKflag!=true)
					{
						String AppPaidAmount = driver.findElement(FivestarBookingPage.PaidAmount).getText();
						if(Variables.TransferRefundflag==true)
						{
							PaidAmt+=Double.parseDouble(Variables.TransferRefundAmt);
						}
						Assert.assertEquals(PaidAmt, Double.parseDouble(AppPaidAmount), 0.01);
					
					}
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					
					
		    	}
		    	catch(Exception e)
		    	{
		    		Assert.fail(e.toString());
		    	}
		    }
			
			
			public static void ValAirportDetails_FiveStarBookingPg(String[] arrAirportCode,String[] arrAirportPrice,String[] arrServiceType,String testcase)
			{
				
				try
				{
					 int count=  common.getRecordCount(3);
					 int j=0;
					 int k=0;
					 for(int i=0;i<count;i++)
					 {	
						    String AirportCodeVal = driver.findElement(By.xpath(FivestarBookingPage.AirportWebTableRowStr+"["+(i+2)+"]/td[2]")).getText();
							String ServiceTypeVal = driver.findElement(By.xpath(FivestarBookingPage.AirportWebTableRowStr+"["+(i+2)+"]/td[13]")).getText();
							 boolean inputMatched=false;
							 while(j!=arrAirportCode.length)
							 {
								 if(AirportCodeVal.equalsIgnoreCase(arrAirportCode[j]) && ServiceTypeVal.equalsIgnoreCase(arrServiceType[j]))
								 {
									 inputMatched=true;
									 break;
								 }
								 j++;
							 }
							if(inputMatched==true && Variables.CKflag!=true)
							{
								if(Variables.arrselectadd[j].equalsIgnoreCase("ON"))
								{
									
									String AppAirportPrice = driver.findElement(By.xpath(FivestarBookingPage.AirportWebTableRowStr+"["+(i+2)+"]/td[29]")).getText();
									Assert.assertEquals(Double.parseDouble(arrAirportPrice[k]),Double.parseDouble(AppAirportPrice), 0.01);
									k++;
								}
								 j=0;
							}
							
					 }
					
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while validating booking details after booking.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
					//throw new RuntimeException("");
				}
				
			}
			
			public static void ValPaymentTab_FivestarBookingPg(double arrNetTotalAmt)
			{
				try
				{
					if(Variables.CKflag==true||Variables.Transportationflag==true)
					{
						
					}
					else
					{
							if(Variables.Refundflag==true)
							{
								FivestarMethods.SearchTextBoxApplet("Refund",FivestarBookingPage.SearchButtonPaymentApplet,FivestarBookingPage.PaymentTypePaymentApplet,FivestarBookingPage.GoButtonPaymentApplet);
								Thread.sleep(2000);
								String AppPaymentRemarks = driver.findElement(FivestarBookingPage.PaymentRemarksPaymentApplet).getText();	
								Assert.assertEquals("Refund Initiated".toUpperCase(), AppPaymentRemarks.toUpperCase());
								
								for(int i=0;i<common.getRecordCount(4);i++)
								{
									String AppPaymentAmount = driver.findElement(By.id((i+1)+FivestarBookingPage.PaymentAmountPaymentApplet)).getText();	
									Assert.assertEquals(Double.parseDouble(Variables.RefundAmt),Double.parseDouble(AppPaymentAmount), 0.01);
									break;	
								}
								
								
					     		
							}
							if(Variables.Paymentflag==true)
							{
								FivestarMethods.SearchTextBoxApplet("Payment",FivestarBookingPage.SearchButtonPaymentApplet,FivestarBookingPage.PaymentTypePaymentApplet,FivestarBookingPage.GoButtonPaymentApplet);
								Thread.sleep(2000);
								String AppPaymentRemarks = driver.findElement(FivestarBookingPage.PaymentRemarksPaymentApplet).getText();	
								Assert.assertEquals("Payment Success".toUpperCase(), AppPaymentRemarks.toUpperCase());
								
								for(int i=0;i<common.getRecordCount(4);i++)
								{
									String AppPaymentAmount = driver.findElement(By.id((i+1)+FivestarBookingPage.PaymentAmountPaymentApplet)).getText();	
									Assert.assertEquals(arrNetTotalAmt,Double.parseDouble(AppPaymentAmount), 0.01);
									break;
								}	
																
								
							}
							if(Variables.TransferRefundflag==true)
							{
								FivestarMethods.SearchTextBoxApplet("Transferred",FivestarBookingPage.SearchButtonPaymentApplet,FivestarBookingPage.PaymentTypePaymentApplet,FivestarBookingPage.GoButtonPaymentApplet);
								Thread.sleep(2000);
								String AppPaymentRemarks = driver.findElement(FivestarBookingPage.PaymentRemarksPaymentApplet).getText();	
								
								Assert.assertEquals("Transfer Success".toUpperCase(), AppPaymentRemarks.toUpperCase());
								
								for(int i=0;i<common.getRecordCount(4);i++)
								{
									String AppPaymentAmount = driver.findElement(By.id((i+1)+FivestarBookingPage.PaymentAmountPaymentApplet)).getText();	
									Assert.assertEquals(Double.parseDouble(Variables.TransferRefundAmt),Double.parseDouble(AppPaymentAmount), 0.01);
											
								}
								
								
							}
					}	
				}
				catch(Exception e)
				{
					
				}
			}
			
			public static void CheckForCancelledStatus() throws Exception
			{
				 if(common.getRecordCount(1)!=0)
				 {
					 String SRStatus =driver.findElement(By.id((0+1)+FivestarBookingPage.SRStatusStr)).getText();
					 while (SRStatus.equalsIgnoreCase("Open"))
					 {
						 SRStatus =driver.findElement(By.id((0+1)+FivestarBookingPage.SRStatusStr)).getText();
							if(!SRStatus.equalsIgnoreCase("Open"))
							{
								break;
							}
							common.navigateThirdLevelViewbar(Variables.FlightdetailsTabName);
							common.navigateThirdLevelViewbar(Variables.SRdetailsTabName);
							
					 }
					
				 }
			}
			@SuppressWarnings("unchecked")
			public static void ValSRDetails_FiveStarBookingPg(String[] arrAirportCode,String[] SRBookingStatus,String testcase,String Flowtype) throws Exception
			{
				try
				{
					List<String> SRNumberlist = new ArrayList<String>();
					for(int i=0;i<common.getRecordCount(1);i++)
					{
						SRNumberlist=FivestarMethods.FetchListValue(By.id((i+1)+FivestarBookingPage.SRNumberStr),arrAirportCode[i],SRNumberlist);
						String SRStatus =driver.findElement(By.id((i+1)+FivestarBookingPage.SRStatusStr)).getText();
						Assert.assertEquals(SRStatus, SRBookingStatus[i]);
						
						Reporter.addStepLog("SR Status "+SRBookingStatus[i]+" Validated Successfully.");
					
						
					}
					String allSRNumber = String.join(",", SRNumberlist);
					
					switch(Flowtype.toUpperCase())
					{
						case "EDIT":
							if(SRBookingStatus[0].equalsIgnoreCase("Cancelled"))
							{
								CommonMethods.SetEditFivestarData("CancelledSRNumber",allSRNumber,testcase);
							}
							else
							{
								CommonMethods.SetEditFivestarData("SRnumber",allSRNumber,testcase);
							}		
							Variables.InitializeValue("Edit", testcase);
							break;
						case "CANCEL":
							CommonMethods.SetCancelFivestarData("SRnumber",allSRNumber,testcase);
							Variables.InitializeValue("Cancel", testcase);
							break;
						case "BOOK":
							CommonMethods.SetFivestarData("SRnumber",allSRNumber,testcase);
							Variables.InitializeValue("Book", testcase);
							break;
							
					}
					
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					Reporter.addStepLog("SR Numbers "+allSRNumber+" Updated successfully.");
					
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while validating SR details. "+e.toString());
					Assert.fail(e.toString());
				}
						
				
			}
			

			
			
			public static void EnterPNRDetailsAndClickNext(String input,String ReqSource,String ReqType,String pnrNumber,String ReqNo,String testcase) throws Exception
			{
				try
				{
					if(input.contains("PNR"))
					{
						driver.findElement(FivestarBookingPage.PNRTextBox).sendKeys(pnrNumber);	
					}
					if(input.contains("RequestNo"))
					{
						driver.findElement(FivestarBookingPage.ReqNumberTextBoxReqInitiation).sendKeys(ReqNo);	
					}
					
					Thread.sleep(2000);
					if(Variables.Editflag!=true)
					{
						selectRequestType(ReqType);
					}
					
					selectSourceRadioButton(ReqSource);
					BookingMethods.Click_On_Button("Next");
					Variables.popupstatus=CheckForPopUp(Variables.popupstatus);
					if(Variables.popupstatus==true)
					{
						driver.switchTo().alert().accept();
						BookingMethods.Click_On_Button("Next");
						Variables.popupstatus=false;
					}
					
					Reporter.addStepLog("PNR details and all other mandatory options entered successfully.");
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error While filling PNR details for fivestar booking.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
					  
			}
			
			public static void selectRequestType(String ReqType)
			{
				try
				{
					switch(ReqType.toUpperCase())
					{
						case "CONCEIRGE KEY":
							driver.findElement(FivestarBookingPage.RadioButtonConceirgeKey).click();
							
							Reporter.addStepLog("Request Type Radio button "+ReqType.toUpperCase()+" Selected successfully.");
							break;
						case "FIVE STAR":
							driver.findElement(FivestarBookingPage.RadioButtonFiveStar).click();
							Reporter.addStepLog("Request Type Radio button "+ReqType.toUpperCase()+" Selected successfully.");
							break;
						case "COMMERCIAL CUSTOMER":
							driver.findElement(FivestarBookingPage.RadioButtonCommercialCustomer).click();
							Variables.CKflag=true;
							Reporter.addStepLog("Request Type Radio button "+ReqType.toUpperCase()+" Selected successfully.");
							break;
						case "OTHER BOOKING":
							driver.findElement(FivestarBookingPage.RadioButtonOtherBooking).click();
							Reporter.addStepLog("Request Type Radio button "+ReqType.toUpperCase()+" Selected successfully.");
							break;
							
					}
					Thread.sleep(2000);	
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while Selecting Source Radio button");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
			}
			
			public static boolean CheckForPopUp(boolean popupstatus)
			{
				
				try
				{
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					if(!driver.switchTo().alert().getText().equals(null))
					{
						popupstatus=true;
					}
					
						
				}
				catch(Exception e)
				{
					popupstatus=false;
					//Reporter.addStepLog(e.toString());
				}
				return popupstatus;
			}
			
			public static void BookFS_SelectPrimaryPassenger_SelectDetailsPg(String[] arrFirstName,String[] arrLastName,String[] arrPsngrType,String[] arrPrimFlag,String testcase) throws Exception
			{
				String[] headers = null, values = null, ID=null;
				try
				{
				//	 Robot KeyboardInput = new Robot();
					Actions act = new Actions(driver);
					
					 
					 int j=0;
					
					 int count=  common.getRecordCount(1);
					 
					 for(int i=0;i<count;i++)
					 {
						 String FirstNameVal = driver.findElement(By.xpath(FivestarBookingPage.PassengersWebTableRowStr+"["+(i+2)+"]/td[6]")).getAttribute("title");
						 String LastNameVal = driver.findElement(By.xpath(FivestarBookingPage.PassengersWebTableRowStr+"["+(i+2)+"]/td[5]")).getAttribute("title");
						 boolean inputMatched=false;
						 while(j!=arrFirstName.length)
						 {
							 if(FirstNameVal.equalsIgnoreCase(arrFirstName[j]) && LastNameVal.equalsIgnoreCase(arrLastName[j]))
							 {
								 inputMatched=true;
								
								 break;
							 }
							 j++;
						 }
						 
						 if(inputMatched==true)
						 {
							 headers = new String[] { "Adult/Child" };
							 values = new String[] { arrPsngrType[j] };
							 ID=new String[] {(i+1)+FivestarBookingPage.PassengersTypeName};
							 common.setMemberData(headers, values, (i+1),1,ID);
							
							 if(arrPrimFlag[j].equalsIgnoreCase("ON"))
							 {
								 if(Variables.CKflag==true)
								 {
									 FivestarMethods.SelectCheckbox(By.id((i+1)+"_s_2"+FivestarBookingPage.PrimaryFlagLabelPassengerWebtableStr),FivestarBookingPage.SelectChekboxUnchecked);
										
								 }
								 else
								 {
									 FivestarMethods.SelectCheckbox(By.id((i+1)+"_s_1"+FivestarBookingPage.PrimaryFlagLabelPassengerWebtableStr),FivestarBookingPage.SelectChekboxUnchecked);
										
								 }
							
							 }
								
							 
							
							 Reporter.addStepLog("Passenger details validated for "+arrFirstName[j]);
							 j=0;
						 }
						
					 }
					 FivestarMethods.SaveWebtable(FivestarBookingPage.PassengersWebTable,act);
					 Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while validating Passenger details"); 
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				 
				 
			}
			
			public static void SelectCKFlag_ConceirgeKeyBooking()
			{
				try
				{
					int count=  common.getRecordCount(1);
					 
					 for(int i=0;i<count;i++)
					 {
						 if(Variables.CKflag==true)
						 {
							 FivestarMethods.SelectCKCheckBox(By.id((i+1)+FivestarBookingPage.CKFlagLabelPassengerWebtableStr),FivestarBookingPage.SelectChekboxUnchecked);
						 }
					 }	 
				}
				catch(Exception e)
				{
					
				}
			}
			
			public static void BookFS_SelectOverrideDetails_NewAirportPg(boolean popupstatus,int count,String[] arrNewselectadd)
			{
				try
				{
					
						
						
						 for(int i=0;i<count;i++)
						 {
							 if(arrNewselectadd[i].equalsIgnoreCase("ON"))
							 {
								FivestarMethods.SelectCheckbox(By.id((i+1)+FivestarBookingPage.OverrideflagLabelNewAirport), FivestarBookingPage.SelectChekboxUnchecked);
								FivestarMethods.javascriptClick(driver,driver.findElement(By.id((i+1)+FivestarBookingPage.AuthNameNewAirport)));
								
								FivestarMethods.javascriptEdit(driver,(i+1)+FivestarBookingPage.AuthNameCheckBox,"Override Airport");
								
							 }
						 }
						 BookingMethods.Click_On_Button("Submit");
						 popupstatus=false;
				
					
				}
				catch(Exception e)
				{
					
				}
			}
			
			public static void BookFS_SelectAirport_ServiceType_SelectDetailsPg(String[] arrAirportCode,String[] arrServiceType,String[] arrPromoCertificateID,String[] arrPromocode,
					String[] arrselectadd,String[] arrDateInterval,String[] arrTimeInterval,String tableName,String ServiceDateid,By CheckBox,String PromoCode,
					String PromoCert,int count,int TableIndex) throws Exception
			{
				try
				{
					// Robot KeyboardInput = new Robot();
					Actions act = new Actions(driver);
					String[] headers = null, values = null, ID=null;
					  
					 
					 int j=0;
					 for(int i=0;i<count;i++)
					 {	
						 driver.findElement(By.xpath("//*[text()='"+tableName+"']")).click();
							
						try
						{
							String AirportCodeVal = driver.findElement(By.xpath("//table[@summary='"+tableName+"']/tbody/tr["+(i+2)+"]/td[2]")).getText();
							 String ServiceTypeVal=new String();
							if(Variables.CKflag==true)
							 {
								 ServiceTypeVal = driver.findElement(By.xpath("//table[@summary='"+tableName+"']/tbody/tr["+(i+2)+"]/td[5]")).getText();
									
							 }
							 else
							 {
								 ServiceTypeVal = driver.findElement(By.xpath("//table[@summary='"+tableName+"']/tbody/tr["+(i+2)+"]/td[7]")).getText();
									
							 }
							 boolean inputMatched=false;
							 while(j!=arrAirportCode.length)
							 {
								 if(AirportCodeVal.equalsIgnoreCase(arrAirportCode[j]) && ServiceTypeVal.equalsIgnoreCase(arrServiceType[j]))
								 {
									 inputMatched=true;
									 
									 break;
								 }
								 j++;
							 }
							if(inputMatched==true)
							{
								if(arrselectadd[j].equalsIgnoreCase("ON"))	
								{
									if(arrAirportCode[j].equalsIgnoreCase("NRT")||arrAirportCode[j].equalsIgnoreCase("LHR"))
									{
										Variables.Taxflag=true;
									}
									
									String ServiceDate=getServiceDate(arrDateInterval[j],arrTimeInterval[j]);
									Thread.sleep(1);
									
									headers = new String[] {"Service Date"};
									values = new String[] {ServiceDate};
								    ID=new String[] {(i+1)+ServiceDateid };
									 common.setMemberData(headers, values, (i+1),TableIndex,ID);
									 
									 FivestarMethods.SelectCheckbox(By.xpath("//table[@summary='"+tableName+"']/tbody/tr["+(i+2)+"]/td[1]"),CheckBox);
									 if(Variables.CKflag!=true)
									 {	
										    if(!arrPromocode[j].equals("0")&&!arrPromocode[j].equals(""))
											{
												headers = new String[] {"Promo Code" };
												values = new String[] { arrPromocode[j]};
											    ID=new String[] {(i+1)+PromoCode};
												 common.setMemberData(headers, values, (i+1),TableIndex,ID);
												
												 
											}
											if(!arrPromoCertificateID[j].equals("0")&&!arrPromoCertificateID[j].equals(""))
											{
												headers = new String[] {"Promo Certificate" };
												values = new String[] {arrPromoCertificateID[j]};
											    ID=new String[] {(i+1)+PromoCert};
												 common.setMemberData(headers, values, (i+1),TableIndex,ID);
											}
									 }
									
									
										
									Reporter.addStepLog("Airport "+arrAirportCode[j]+" Selected successfully. ");
										
								}
							}
							j=0;
							
							
							
						}
						catch(Exception e)
						{
							Reporter.addStepLog("Error while filling details for Airport "+arrAirportCode[i]+" and Service Type "+arrServiceType[i]);
							Reporter.addStepLog(e.toString());
							Assert.fail(e.toString());
						}
							 
					 }
					 FivestarMethods.SaveWebtable(By.xpath("//table[@summary='"+tableName+"']"),act);
					 Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
				}
				catch(Exception e)
				{
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				 
					 
			}
			
			public static void CalculateAmountAndUpdate(String FlowType,String SelectAirport,String PassengerType,String Promocode,String testcase)
			{
				try
				{
					//int NumberOfAirportsSelected = StringUtils.countMatches(SelectAirport.toUpperCase(), "ON");
					int NumberOfAdultPassengers = StringUtils.countMatches(PassengerType.toUpperCase(), "ADULT");
					int NumberOfChildPassengers = StringUtils.countMatches(PassengerType.toUpperCase(), "CHILD");
					double TotalAmt=0;
					double AdultAmt=0;
					double promoAmount=0;
					double EachAirportAmount=0;
					double AdditionalserviceAmt=0;
					if(Variables.additionalserviceflag==true)
					{
						AdditionalserviceAmt=Double.parseDouble(Variables.PriceperBookingAdditionService)+
												(NumberOfAdultPassengers*Double.parseDouble(Variables.AdultPriceAdditionService))+
													(NumberOfChildPassengers*Double.parseDouble(Variables.ChildPriceAdditionService));
					}
					String AirportPriceVal=new String();
					
					
					
					for(int i=0;i<Variables.arrAirportCode.length;i++)
					{
						EachAirportAmount=((NumberOfAdultPassengers+NumberOfChildPassengers)>1)?(350+100*(NumberOfAdultPassengers-1)+50*NumberOfChildPassengers):350;
						
						if(Variables.arrselectadd[i].equalsIgnoreCase("ON"))
						{	
							
							
							TotalAmt+=EachAirportAmount;
							AdultAmt+=EachAirportAmount;
							if(Variables.Promoflag==true)
							{
								if(!Variables.arrDiscountdoller[i].equalsIgnoreCase("0")&&!Variables.arrDiscountdoller[i].equalsIgnoreCase(""))
								{
									EachAirportAmount -= Double.parseDouble(Variables.arrDiscountdoller[i]);
									promoAmount += Double.parseDouble(Variables.arrDiscountdoller[i]);
								}
								if(!Variables.arrDiscountpercent[i].equalsIgnoreCase("0")&&!Variables.arrDiscountpercent[i].equalsIgnoreCase(""))
								{
									promoAmount += (EachAirportAmount*(Double.parseDouble(Variables.arrDiscountpercent[i])/100));
									EachAirportAmount -= (EachAirportAmount*(Double.parseDouble(Variables.arrDiscountpercent[i])/100));									
								}
							}
							if(Variables.arrAirportCode[i].equalsIgnoreCase("NRT"))
							{
								EachAirportAmount+=(EachAirportAmount*(FixedValues.NRTTaxValue/100));
							}
							if(Variables.arrAirportCode[i].equalsIgnoreCase("LHR"))
							{
								EachAirportAmount+=(EachAirportAmount*(FixedValues.LHRTaxValue/100));
							}
							if(Variables.additionalserviceflag==true)
							{
								if(Variables.AirportCodeAdditionService.equalsIgnoreCase(Variables.arrAirportCode[i]) && Variables.ServiceTypeAdditionService.equalsIgnoreCase(Variables.arrServiceType[i]))
								{
									EachAirportAmount +=AdditionalserviceAmt;
								}
							}
							AirportPriceVal += String.valueOf(EachAirportAmount)+",";						
						}
					}
					
					TotalAmt+=AdditionalserviceAmt;
					switch(FlowType.toUpperCase())
					{
						case "EDIT":
							CommonMethods.SetEditFivestarData("NetTotalAmt", String.valueOf(TotalAmt), testcase);
							CommonMethods.SetEditFivestarData("AdultPrice", String.valueOf(AdultAmt), testcase);
							CommonMethods.SetEditFivestarData("PromoDiscount", String.valueOf(promoAmount), testcase);
							CommonMethods.SetEditFivestarData("TotalAdditionalServices", String.valueOf(AdditionalserviceAmt), testcase);
							CommonMethods.SetEditFivestarData("AirportPrice",AirportPriceVal.substring(0, AirportPriceVal.length()-1) , testcase);			
							Variables.InitializeValue("Edit", testcase);
							break;
						case "CANCEL":
							CommonMethods.SetCancelFivestarData("NetTotalAmt", String.valueOf(TotalAmt), testcase);
							CommonMethods.SetCancelFivestarData("AdultPrice", String.valueOf(AdultAmt), testcase);
							CommonMethods.SetCancelFivestarData("PromoDiscount", String.valueOf(promoAmount), testcase);
							CommonMethods.SetCancelFivestarData("TotalAdditionalServices", String.valueOf(AdditionalserviceAmt), testcase);
							CommonMethods.SetCancelFivestarData("AirportPrice",AirportPriceVal.substring(0, AirportPriceVal.length()-1) , testcase);	
							Variables.InitializeValue("Cancel", testcase);
							break;
						case "BOOK":
							CommonMethods.SetFivestarData("NetTotalAmt", String.valueOf(TotalAmt), testcase);
							CommonMethods.SetFivestarData("AdultPrice", String.valueOf(AdultAmt), testcase);
							CommonMethods.SetFivestarData("PromoDiscount", String.valueOf(promoAmount), testcase);
							CommonMethods.SetFivestarData("TotalAdditionalServices", String.valueOf(AdditionalserviceAmt), testcase);
							CommonMethods.SetFivestarData("AirportPrice",AirportPriceVal.substring(0, AirportPriceVal.length()-1) , testcase);
							Variables.InitializeValue("Book", testcase);
							break;
					}
				}
				catch(Exception e)
				{
					Assert.fail(e.toString());
				}
			}
			
			public static void UpdateOutstandingAmount(By OutstandAmt,String testcase)
			{
				try
				{
					double CaturedOutstandingAmt = Double.parseDouble(driver.findElement(OutstandAmt).getAttribute("value"));
					if(Variables.Editflag==true)
					{
						CommonMethods.SetEditFivestarData("OutstandingAmt", String.valueOf(CaturedOutstandingAmt), testcase);
						Variables.InitializeValue("Edit", testcase);
					}
					if(Variables.Cancelflag==true)
					{
						CommonMethods.SetCancelFivestarData("OutstandingAmt", String.valueOf(CaturedOutstandingAmt), testcase);
						Variables.InitializeValue("Cancel", testcase);
					}
					else
					{
						CommonMethods.SetFivestarData("OutstandingAmt", String.valueOf(CaturedOutstandingAmt), testcase);
						Variables.InitializeValue("Book", testcase);
					}
				
				}
				catch(Exception e)
				{
					
				}
			}
			public static void BookFS_ClickSubmit_ValidateOverride_SelectDetailsPg(int count,String tableName,String AuthName,String[] arrAirportCode,String[] arrServiceType,String[] arrselectadd,int TableIndex) throws Exception
			{
				Actions act = new Actions(driver);
				String[] headers = null, values = null, ID=null;
				try
				{ 
						try
						{
									int j=0;
									
									for(int i=0;i<count;i++)
									{	
										String AirportCodeVal = driver.findElement(By.xpath("//table[@summary='"+tableName+"']/tbody/tr["+(i+2)+"]/td[2]")).getText();
										String ServiceTypeVal = driver.findElement(By.xpath("//table[@summary='"+tableName+"']/tbody/tr["+(i+2)+"]/td[7]")).getText();
										boolean inputMatched=false;
										while(j!=arrAirportCode.length)
										{
											if(AirportCodeVal.equalsIgnoreCase(arrAirportCode[j]) && ServiceTypeVal.equalsIgnoreCase(arrServiceType[j]))
											{
												inputMatched=true;
												
												break;
											}
											j++;
										}
										if(inputMatched==true)
										{
											if(arrselectadd[j].equalsIgnoreCase("ON"))
											{
												Reporter.addStepLog("Override flag message popup Exists.");
												
												headers = new String[] {"Authorizer Name"};
												values = new String[] {"Override Airport"};
											    ID=new String[] {(i+1)+AuthName };
												common.setMemberData(headers, values, (i+1),TableIndex,ID);
												
												FivestarMethods.SelectCheckbox(By.xpath("//table[@summary='"+tableName+"']/tbody/tr["+(i+2)+"]/td[8]"),FivestarBookingPage.SelectChekboxUnchecked);
												
												
											}
										}
										j=0;
										
									}
									//FivestarMethods.SaveWebtable(By.xpath("//table[@summary='"+tableName+"']"),act);
									Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
									BookingMethods.Click_On_Button("Submit");
								
									Reporter.addStepLog("Submit button clicked successfully with override details.");
					    	  
								
							
						}
						catch(Exception e)
						{
							//Assert.fail(e.toString());
						}
							
				
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while clicking submit button.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
					
			}
			
			
			
			public static void NavigateTo_NextScreen(By TaskLabel,By Label,String TaskAttribute,String Taskvalue,String LabelAttribute,String LabelValue)
			{
				try
				{
					WebDriverWait wait = new WebDriverWait(driver, 120);
					wait.until(ExpectedConditions.attributeContains(TaskLabel, TaskAttribute, Taskvalue));
					wait.until(ExpectedConditions.attributeContains(Label, LabelAttribute, LabelValue));
					Reporter.addStepLog("User is successfully navigated to Next Screen.");
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while navigating to next page payment");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
			}
			
			
			
			public static void BookFS_EnterAgencyId_PaymentBreakdownPg(String ProfileId,String testcase) throws Exception
			{
				try
				{
					
					Thread.sleep(1000);
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+ProfileId+"'",driver.findElement(FivestarBookingPage.AgencyIDTextBox));
					driver.findElement(FivestarBookingPage.AgencyIDTextBox).click();
					
					FivestarMethods.ClickTab(act);
					Reporter.addStepLog("Agency Id "+ProfileId+" entered successfully.");
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
				}
				catch(Exception e)
				{
					
				}
				
			}
			
			
			public static void CompareOverrideAmount(By RefundAmount,By OverrideAmount,By TotalRefundAmount ,String testcase)
			{
				try
				{
					
					String RefundableAmount = driver.findElement(RefundAmount).getAttribute("value");
		        	String OverrideAmountTxtBox = driver.findElement(OverrideAmount).getAttribute("value");
		        	String TotalRefundableAmount = driver.findElement(TotalRefundAmount).getAttribute("value");
		        	Assert.assertEquals(Double.parseDouble(TotalRefundableAmount), Double.parseDouble(RefundableAmount)+Double.parseDouble(OverrideAmountTxtBox), 0.01);
		        	Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
		        	CommonMethods.SetCancelFivestarData("RefundAmt",TotalRefundableAmount,testcase);
		     		Variables.InitializeValue("Cancel", testcase);
				}
				catch(Exception e)
				{
					Assert.fail(e.toString());
				}
				
			}
			
			
			
			
			public static void BookFSFillEmailDetails_PaymentConfirmation(String EmailCheckBox,String EmailAddress,String testcase) throws Exception
			{
				try
				{
					
					if(EmailCheckBox.equalsIgnoreCase("ON"))
					{
						driver.findElement(FivestarBookingPage.EmailAddressTextBox).click();
						((JavascriptExecutor) driver).executeScript("arguments[0].value='"+EmailAddress+"'",driver.findElement(FivestarBookingPage.EmailAddressTextBox));
						driver.findElement(FivestarBookingPage.EmailAddressTextBox).click();
						Reporter.addStepLog("As Per Requirement Receipt Email Email id "+EmailAddress+" provided.");
						
					}
					else
					{
						driver.findElement(FivestarBookingPage.SelectChekboxChecked).click();
						Reporter.addStepLog("As Per Requirement Receipt Email Checkbox Unchecked Successfully and Email id not provided.");
					}
					Thread.sleep(2000);
					
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while adding receipt email details.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				
			}
			
			public static void BookFSFillCallerDetailsandComments_PaymentConfirmation(String Caller_Name,String Caller_Phone,String Company_Name,String Company_PhoneNo,String Departure_Day_Name,String Departure_Day_PhoneNo,String Comments1,String Comments2,String Comments3,String Comments4) throws Exception
			{
				try
				{
					Thread.sleep(2000);
					
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Caller_Name+"'",driver.findElement(FivestarBookingPage.CallerName));
					//driver.findElement(FivestarBookingPage.CallerName).sendKeys(Caller_Name);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Caller's Name "+Caller_Name+" added successfully.");
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Caller_Phone+"'",driver.findElement(FivestarBookingPage.CallerPhone));
					//driver.findElement(FivestarBookingPage.CallerPhone).sendKeys(Caller_Phone);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Caller's phoneNo "+Caller_Phone+" added successfully.");
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Company_Name+"'",driver.findElement(FivestarBookingPage.CompanyName));
					//driver.findElement(FivestarBookingPage.CompanyName).sendKeys(Company_Name);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Company name "+Company_Name+" added successfully.");
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Company_PhoneNo+"'",driver.findElement(FivestarBookingPage.CompanyPhone));
				//	driver.findElement(FivestarBookingPage.CompanyPhone).sendKeys(Company_PhoneNo);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Company phoneNo "+Company_PhoneNo+" added successfully.");
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Departure_Day_Name+"'",driver.findElement(FivestarBookingPage.DepartmentName));
					//driver.findElement(FivestarBookingPage.DepartmentName).sendKeys(Departure_Day_Name);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Departure day name "+Departure_Day_Name+" added successfully.");
					driver.findElement(FivestarBookingPage.DepartmentPhone).click();
					//driver.findElement(FivestarBookingPage.DepartmentPhone).sendKeys(Departure_Day_PhoneNo);
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Departure_Day_PhoneNo+"'",driver.findElement(FivestarBookingPage.DepartmentPhone));
					
			//		driver.findElement(FivestarBookingPage.DepartmentPhone).sendKeys(Departure_Day_PhoneNo);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Departure day phoneNo "+Departure_Day_PhoneNo+" added successfully.");
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Comments1+"'",driver.findElement(FivestarBookingPage.Comments1));
				//	driver.findElement(FivestarBookingPage.Comments1).sendKeys(Comments1);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Comments1 "+Comments1+" added successfully.");
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Comments2+"'",driver.findElement(FivestarBookingPage.Comments2));
				//	driver.findElement(FivestarBookingPage.Comments2).sendKeys(Comments2);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Comments2 "+Comments2+" added successfully.");
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Comments3+"'",driver.findElement(FivestarBookingPage.Comments3));
				//	driver.findElement(FivestarBookingPage.Comments3).sendKeys(Comments3);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Comments3 "+Comments3+" added successfully.");
					((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Comments4+"'",driver.findElement(FivestarBookingPage.Comments4));
					//driver.findElement(FivestarBookingPage.Comments4).sendKeys(Comments4);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Comments4 "+Comments4+" added successfully.");
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					//currentScenario.embed(Util.takeScreenshot(driver), "CallerDetails/png");
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while filling caller details.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				//"TestAuto","9083878987","TCS","9820398989","turs","8373878978","automation testing","","",""
					
			}
			public static void BookFSFillTransportServicedetails_PaymentConfirmation(String TableName,String Car_Company,String Car_PhoneNo,String Driver_Name,String Driver_PhoneNo,String NoOfCheckedBags,String ATO_Comments) throws Exception
			{
				
				LoadPropertiesFile();
				List<WebElement> rows = driver.findElements(By.xpath("//table[@summary='"+TableName+"']/tbody/tr"));						
				int count=rows.size();

				try
				{
					for(int i=0;i<(count-1);i++)
					{
						//table[@summary='Transportation Service']/tbody/tr[2]/td[5]
						FivestarMethods.javascriptClick(driver,driver.findElement(By.xpath("//table[@summary='"+TableName+"']/tbody/tr["+(i+2)+"]/td[5]")));
						((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Car_Company+"'",driver.findElement(FivestarBookingPage.CarCompanyTextBox));
						//driver.findElement(By.xpath("//table[@summary='Transportation Service']/tbody/tr["+(i+2)+"]/td[5]")).click();
						Thread.sleep(1000);
						//driver.findElement(FivestarBookingPage.CarCompanyTextBox).sendKeys(Car_Company);
						//Thread.sleep(2000);
						driver.findElement(FivestarBookingPage.CarCompanyTextBox).sendKeys(Keys.TAB);
						//Thread.sleep(2000);
						Reporter.addStepLog("Company car name "+Car_Company+" added successfully.");
						FivestarMethods.javascriptClick(driver, driver.findElement(By.xpath("//table[@summary='"+TableName+"']/tbody/tr["+(i+2)+"]/td[6]")));
						((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Car_PhoneNo+"'",driver.findElement(FivestarBookingPage.CarPhoneNoTextBox));
					//	driver.findElement(By.xpath("//table[@summary='Transportation Service']/tbody/tr["+(i+2)+"]/td[6]")).click();
						//Thread.sleep(2000);
						//driver.findElement(FivestarBookingPage.CarPhoneNoTextBox).sendKeys(Car_PhoneNo);
						//Thread.sleep(2000);
						driver.findElement(FivestarBookingPage.CarPhoneNoTextBox).sendKeys(Keys.TAB);
						//Thread.sleep(2000);
						Reporter.addStepLog("Company car phoneno "+Car_PhoneNo+" added successfully.");
						FivestarMethods.javascriptClick(driver, driver.findElement(By.xpath("//table[@summary='"+TableName+"']/tbody/tr["+(i+2)+"]/td[7]")));
					    ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Driver_Name+"'",driver.findElement(FivestarBookingPage.DriverNameTextBox));
					//	driver.findElement(By.xpath("//table[@summary='Transportation Service']/tbody/tr["+(i+2)+"]/td[7]")).click();
						//Thread.sleep(2000);
						//driver.findElement(FivestarBookingPage.DriverNameTextBox).sendKeys(Driver_Name);
						//Thread.sleep(2000);
						driver.findElement(FivestarBookingPage.DriverNameTextBox).sendKeys(Keys.TAB);
						//Thread.sleep(2000);
						Reporter.addStepLog("Company Driver Name "+Driver_Name+" added successfully.");
						FivestarMethods.javascriptClick(driver, driver.findElement(By.xpath("//table[@summary='"+TableName+"']/tbody/tr["+(i+2)+"]/td[8]")));
						((JavascriptExecutor) driver).executeScript("arguments[0].value='"+Driver_PhoneNo+"'",driver.findElement(FivestarBookingPage.DriverPhoneNoTextBox));
					//	driver.findElement(By.xpath("//table[@summary='Transportation Service']/tbody/tr["+(i+2)+"]/td[8]")).click();
						//Thread.sleep(2000);
						//driver.findElement(FivestarBookingPage.DriverPhoneNoTextBox).sendKeys(Driver_PhoneNo);
						//Thread.sleep(2000);
						driver.findElement(FivestarBookingPage.DriverPhoneNoTextBox).sendKeys(Keys.TAB);
						//Thread.sleep(2000);
						Reporter.addStepLog("Company Driver phoneno "+Driver_PhoneNo+" added successfully.");
						FivestarMethods.javascriptClick(driver, driver.findElement(By.xpath("//table[@summary='"+TableName+"']/tbody/tr["+(i+2)+"]/td[12]")));
						((JavascriptExecutor) driver).executeScript("arguments[0].value='"+NoOfCheckedBags+"'",driver.findElement(FivestarBookingPage.CheckedBagsTextBox));
					//	driver.findElement(By.xpath("//table[@summary='Transportation Service']/tbody/tr["+(i+2)+"]/td[12]")).click();
						//Thread.sleep(2000);
					//	driver.findElement(FivestarBookingPage.CheckedBagsTextBox).sendKeys(NoOfCheckedBags);
						//Thread.sleep(2000);
						//driver.findElement(FivestarBookingPage.CheckedBagsTextBox).sendKeys(Keys.TAB);
						//Thread.sleep(2000);
						Reporter.addStepLog("No of Checked Bags "+NoOfCheckedBags+" added successfully.");
						
						FivestarMethods.javascriptClick(driver, driver.findElement(By.xpath("//table[@summary='"+TableName+"']/tbody/tr["+(i+2)+"]/td[13]")));
						driver.findElement(By.xpath("//table[@summary='"+TableName+"']/tbody/tr["+(i+2)+"]/td[13]")).click();
						//Thread.sleep(2000);
						((JavascriptExecutor) driver).executeScript("arguments[0].value='"+ATO_Comments+"'",driver.findElement(FivestarBookingPage.ATOCommentsPopUpTextBox));
					//	driver.findElement(FivestarBookingPage.ATOCommentsPopUpTextBox).sendKeys(ATO_Comments);
						//Thread.sleep(2000);
						if(properties.getProperty("ENV").equalsIgnoreCase("OCI-MDEV"))
						{
							//FivestarMethods.javascriptClick(driver, driver.findElement(FivestarBookingPage.ATOCommentsPopUpOKButton));
							driver.findElement(FivestarBookingPage.OKButtonOCItest).click();
						}
						else
						{
							//FivestarMethods.javascriptClick(driver, driver.findElement(By.xpath("(//button/span[text()='OK'])[2]")));
							driver.findElement(FivestarBookingPage.OKButtontest3).click();
						}
						
						//Thread.sleep(2000);
						driver.findElement(FivestarBookingPage.ATOCommentsTextBox).sendKeys(Keys.TAB);
						//Thread.sleep(2000);	
						Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
						
						//currentScenario.embed(Util.takeScreenshot(driver), "TransportationDetails/png");
						Reporter.addStepLog("ATO Comments Details "+ATO_Comments+"added successfully.");
					}
					if(Variables.CKflag!=true)
					{
						driver.findElement(FivestarBookingPage.DepartmentPhone).click();
						Thread.sleep(1000);
						driver.findElement(FivestarBookingPage.EmailAddressTextBox).click();
					}
				

				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while filling transport details.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				
				
				
			}
			
			@SuppressWarnings("unchecked")
			public static void BookFSCapReqNo_Proceedtopay(String Flowtype,String testcase,By ReqNoXpath) throws Exception
			{
				try
				{
					
					Thread.sleep(2000);
					String CapturedRequestNumber = driver.findElement(ReqNoXpath).getAttribute("value");
					Reporter.addStepLog("Request Number "+CapturedRequestNumber+" Captured successfully from application.");
					switch(Flowtype.toUpperCase())
					{
						case "EDIT":
							CommonMethods.SetEditFivestarData("RequestNo",CapturedRequestNumber,testcase);
							CommonMethods.SetEditFivestarData("OldRequestNo",Variables.ReqNo,testcase);
							Variables.InitializeValue("Edit", testcase);
							break;
						case "BOOK":
							CommonMethods.SetFivestarData("RequestNo",CapturedRequestNumber,testcase);
							Variables.InitializeValue("Book", testcase);
							break;
						case "CANCEL":
							CommonMethods.SetCancelFivestarData("RequestNo",CapturedRequestNumber,testcase);
							Variables.InitializeValue("Cancel", testcase);
							break;
					}
										
					Reporter.addStepLog("Request Number "+CapturedRequestNumber+" Updated to Input Sheet.");	
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while capturing Request Number from Application.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				
			}
			
			public static void BookFSFillCarddetails_Proceedtopay(String CardFirstName,String CardLastName,String CardNumber,String CardExpMonth,String CardExpYear,String testcase) throws Exception
			{
				try
				{
					Variables.Paymentflag=true;
					driver.findElement(FivestarBookingPage.CardHolderFirstName).click();
					driver.findElement(FivestarBookingPage.CardHolderFirstName).sendKeys(CardFirstName);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Card Holder First Name "+CardFirstName+" entered successfully.");
					driver.findElement(FivestarBookingPage.CardHolderLastName).click();
					driver.findElement(FivestarBookingPage.CardHolderLastName).sendKeys(CardLastName);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Card Holder Last Name "+CardLastName+" entered successfully.");
					driver.findElement(FivestarBookingPage.CreditCardNumber).click();
					driver.findElement(FivestarBookingPage.CreditCardNumber).sendKeys(CardNumber);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Card Number "+CardNumber+" entered successfully.");
					driver.findElement(FivestarBookingPage.ExpirationMonth).sendKeys(CardExpMonth);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Expiration Month "+CardExpMonth+" entered successfully.");
					driver.findElement(FivestarBookingPage.ExpirationYear).sendKeys(CardExpYear);
				//	Thread.sleep(2000);
					Reporter.addStepLog("Expiration Year "+CardExpYear+" entered successfully.");
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					//currentScenario.embed(Util.takeScreenshot(driver), "FillCardDetails/png");
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while adding Credit card details.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				
			}
			
			
			public static String getServiceDate(String DateInterval,String TimeInterval)
			{
				String Date = null;
				try
				{
					 String newDateinterval=null,newTimeinterval = null;
					
					 if(DateInterval.equals("0") || DateInterval.equals(""))
					 {
						
						  newDateinterval= LocalDate.now().plusDays(0).toString();  
					 }
					 else
					 {
						  newDateinterval= LocalDate.now().plusDays(Integer.parseInt(DateInterval)).toString();
						 
					 }
					 
					 String[] arrnewDateinterval = newDateinterval.split("-");
					 newDateinterval=arrnewDateinterval[1]+"/"+arrnewDateinterval[2]+"/"+arrnewDateinterval[0];
					 
					 if(TimeInterval.equals("0") || TimeInterval.equals(""))
					 {
						
						  newTimeinterval= LocalTime.now().plusHours(0).toString();  
					 }
					 else
					 {
						  newTimeinterval= LocalTime.now().plusHours(Integer.parseInt(TimeInterval)).toString();  
					 }
					 
					 String[] arrnewTimeinterval = newTimeinterval.split(":");
					 newTimeinterval=arrnewTimeinterval[0]+":"+arrnewTimeinterval[1]+":"+arrnewTimeinterval[2].substring(0, 2);
					 
					 if(Integer.parseInt(newTimeinterval.substring(0, 2))>=12)
					 {
						 String[] arrAMPMTimeinterval = newTimeinterval.split(":");
						 int NewTimeVal = (Integer.parseInt(arrAMPMTimeinterval[0]))-12;
						 String HoursVal=new String();
						 if(String.valueOf(NewTimeVal).length()==1)
						 {
							 HoursVal= "0"+String.valueOf(NewTimeVal);
						 }
						 else
						 {
							 HoursVal= String.valueOf(NewTimeVal);
						 }
						 newTimeinterval=HoursVal +":"+ arrAMPMTimeinterval[1]+":"+arrAMPMTimeinterval[2]+" PM";
					 }
					 else
					 {
						 newTimeinterval=arrnewTimeinterval[0] +":"+ arrnewTimeinterval[1]+":"+arrnewTimeinterval[2].substring(0, 2)+" AM";
					 }
					 Date = newDateinterval+" "+newTimeinterval;
					 Reporter.addStepLog("Service date "+Date+" retrieved successfully.");
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while retrieving Service date.");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				return Date;
			}
			public static void selectSourceRadioButton(String ReqSource) throws Exception
			{
				try
				{
					switch(ReqSource.toUpperCase())
					{
						case "PHONE":
							driver.findElement(FivestarBookingPage.RadioButtonPhone).click();
							Reporter.addStepLog("Source Radio button "+ReqSource.toUpperCase()+" Selected successfully.");
							break;
						case "EMAIL":
							driver.findElement(FivestarBookingPage.RadioButtonEmail).click();
							Reporter.addStepLog("Source Radio button "+ReqSource.toUpperCase()+" Selected successfully.");
							break;
						case "MOD FIX":
							driver.findElement(FivestarBookingPage.RadioButtonMODFIX).click();
							Reporter.addStepLog("Source Radio button "+ReqSource.toUpperCase()+" Selected successfully.");
							break;
							
					}
					Thread.sleep(2000);	
				}
				catch(Exception e)
				{
					Reporter.addStepLog("Error while Selecting Source Radio button");
					Reporter.addStepLog(e.toString());
					Assert.fail(e.toString());
				}
				
			}
			

}
