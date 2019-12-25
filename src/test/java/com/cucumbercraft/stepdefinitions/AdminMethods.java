package com.cucumbercraft.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.cucumbercraft.framework.Util;
import com.cucumbercraft.pages.FivestarAdminPage;
import com.cucumbercraft.pages.FivestarBookingPage;
import com.cucumbercraft.pages.FixedValues;
import com.cucumbercraft.pages.LoginPage;
import com.cucumbercraft.pages.Variables;

public class AdminMethods extends MasterStepDefination {

	static CreditCard Creditcarddata;
	static CommonMethods common = new CommonMethods();
	
	 public static void FillCardDetails(String testcase,boolean Agencyflag) throws Exception
	    {
	    	Creditcarddata = CommonMethods.getCreditcardData(testcase);
	   	 String AADVNum = Creditcarddata.CreditCardProfile.AADVNum;
	   	 String CardNum = Creditcarddata.CreditCardProfile.CardNum;
	   	 String CardHolderFirstName = Creditcarddata.CreditCardProfile.CardHolderFirstName;
	   	 String CardHolderLastName = Creditcarddata.CreditCardProfile.CardHolderLastName;
	   	 String CCExpirationMonth = Creditcarddata.CreditCardProfile.CCExpirationMonth;
	   	 String CCExpirationYear = Creditcarddata.CreditCardProfile.CCExpirationYear;
	   	 String BillingAddressLine1 = Creditcarddata.CreditCardProfile.BillingAddressLine1;
	   	 String BillingCity = Creditcarddata.CreditCardProfile.BillingCity;
	   	 String BillingState = Creditcarddata.BillingInfo.BillingState;
	   	 String BillingZipCode = Creditcarddata.BillingInfo.BillingZipCode;
	   	 String BillingCountry = Creditcarddata.BillingInfo.BillingCountry;
	   	 //Thread.sleep(3000);
	   	 driver.findElement(FivestarAdminPage.AddButtonCreditCard).click();
	 	 WebDriverWait wait = new WebDriverWait(driver, 180);
	 	 wait.until(ExpectedConditions.attributeContains(FivestarAdminPage.FirstNameLabelCreditCard, "id", "Account_Holder_Label"));
	   	 if(Agencyflag!=true)
	   	 {
	   	  ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AADVNum+"'",driver.findElement(FivestarAdminPage.AADVTextBoxCreditCard));
	   	 }
	   
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+CardNum+"'",driver.findElement(FivestarAdminPage.CardTextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+CardHolderFirstName+"'",driver.findElement(FivestarAdminPage.FirstNameTextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+CardHolderLastName+"'",driver.findElement(FivestarAdminPage.LastNameTextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+CCExpirationMonth+"'",driver.findElement(FivestarAdminPage.ExpMonthTextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+CCExpirationYear+"'",driver.findElement(FivestarAdminPage.ExpYearTextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+BillingAddressLine1+"'",driver.findElement(FivestarAdminPage.AddrLine1TextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+BillingCity+"'",driver.findElement(FivestarAdminPage.CityTextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+BillingState+"'",driver.findElement(FivestarAdminPage.StateTextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+BillingZipCode+"'",driver.findElement(FivestarAdminPage.ZipCodeTextBoxCreditCard));
	   	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+BillingCountry+"'",driver.findElement(FivestarAdminPage.CountryTextBoxCreditCard));
	 	 if(Agencyflag!=true)
	   	 {
	 		driver.findElement(FivestarAdminPage.AADVTextBoxCreditCard).click();
	   	 }
			 
			 driver.findElement(FivestarAdminPage.CardTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.FirstNameTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.LastNameTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.ExpMonthTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.ExpYearTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.AddrLine1TextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.CityTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.StateTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.ZipCodeTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.CountryTextBoxCreditCard).click();
			 driver.findElement(FivestarAdminPage.SaveButtonCreditCard).click();
				
			 Variables.popupstatus=BookingMethods.CheckForPopUp(Variables.popupstatus);
			 if(Variables.popupstatus==true)
			 {
				 driver.switchTo().alert().accept();
				 driver.findElement(FivestarAdminPage.SaveButtonCreditCard).click();
				 
			 }
			 wait.until(ExpectedConditions.attributeContains(FivestarAdminPage.AddButtonCreditCard, "class", "siebui-ctrl-btn appletButton siebui-icon-newrecord s_1_1_8_0"));
				
	   	 
	    }
	    
	   
	    public static void ReadTableAndDeleteRecord(String CardNum,int count,String CardNumberCell,By DeleteButton) throws Exception
	    {
	    	
	    	for(int i=0;i<count;i++)
	    	{
	    		String AppCardNumber = driver.findElement(By.id((i+1)+CardNumberCell)).getText();
	    		
	    		if(AppCardNumber.equalsIgnoreCase("xxxxxxxxxxxx"+CardNum.substring(CardNum.length()-4, CardNum.length())))
				{
	    			DeleteRecord(i,DeleteButton);
	    			break;
				}
	    	}
	    }
	    
	    public static void ValidateTable(String testcase) throws Exception
	    {
	    	Creditcarddata = CommonMethods.getCreditcardData(testcase);
	    	 String CardHolderFirstName = Creditcarddata.CreditCardProfile.CardHolderFirstName;
	    	 String CardHolderLastName = Creditcarddata.CreditCardProfile.CardHolderLastName;
	    	 String CCExpirationMonth = Creditcarddata.CreditCardProfile.CCExpirationMonth;
	    	 String CCExpirationYear = Creditcarddata.CreditCardProfile.CCExpirationYear;
	    	 String CardNum = Creditcarddata.CreditCardProfile.CardNum;
	    	int count=common.getRecordCount(1);
	    	for(int i=0;i<count;i++)
	    	{
	    		String AppLastName = driver.findElement(By.id((i+1)+"_s_1_l_AAKS_Account_Holder_Last_Name")).getText();
	    		String AppFirstName = driver.findElement(By.id((i+1)+"_s_1_l_Account_Holder")).getText();
	    		String[] arrExpDate = driver.findElement(By.id((i+1)+"_s_1_l_Expiration_Date")).getText().split("/");
	    		String AppCardNumber = driver.findElement(By.id((i+1)+"_s_1_l_Account_Number_-_Display")).getText();
	    		if(CardHolderFirstName.equalsIgnoreCase(AppFirstName) && CardHolderLastName.equalsIgnoreCase(AppLastName) && CCExpirationMonth.equalsIgnoreCase(arrExpDate[0]) && CCExpirationYear.equalsIgnoreCase(arrExpDate[1]))
	    		{
	    			driver.findElement(By.id((i+1)+"_s_1_l_AAKS_Account_Holder_Last_Name")).click();
	    			Assert.assertEquals(AppCardNumber, "xxxxxxxxxxxx"+CardNum.substring(CardNum.length()-4, CardNum.length()));
	    			Assert.assertEquals(AppLastName, CardHolderLastName.toUpperCase());
	        		Assert.assertEquals(AppFirstName, CardHolderFirstName.toUpperCase());
	        		Assert.assertEquals(arrExpDate[0], CCExpirationMonth);
	        		Assert.assertEquals(arrExpDate[1], CCExpirationYear);
	    			break;
	    		}
	    		
	    		
	    	}
	    }
	    
	    public static void DeleteRecord(int index,By DeleteButton)
	    {
	    	try
	    	{
	    		driver.findElement(By.id((index+1)+"_s_1_l_AAKS_Account_Holder_Last_Name")).click();
				driver.findElement(FivestarAdminPage.DeleteButtonCreditCard).click();
				Variables.popupstatus=BookingMethods.CheckForPopUp(Variables.popupstatus);
				 if(Variables.popupstatus==true)
				 {
					
					 driver.switchTo().alert().accept();
					 WebDriverWait wait = new WebDriverWait(driver, 120);
					 wait.until(ExpectedConditions.alertIsPresent());
					 if(driver.switchTo().alert().getText().equalsIgnoreCase("Credit Card deleted successfully"))
					 {
						 driver.switchTo().alert().accept();
						 Thread.sleep(4000);
					 }
					
				 }
	    	}
	    	catch(Exception e)
	    	{
	    		
	    	}
	    }
		public static void ValSRDetails_FivestarAdminPg(String ReqNo,String SRBookingStatus,String testcase) throws Exception
		{
			try
			{
				FivestarMethods.SearchRequestNumber(ReqNo,FivestarAdminPage.SearchButtonBookingAdmin,FivestarAdminPage.RequestNumberBookingAdmin,FivestarAdminPage.RequestNumberTextBox,FivestarAdminPage.GoButtonBookingAdmin);			
				common.navigateThirdLevelViewbar("Five Star SR Details");
				
				int count=common.getRecordCount(1);
				for(int i=0;i<count;i++)
				{
					String SRStatus =driver.findElement(By.id((i+1)+FivestarAdminPage.BookingStatusSRStr)).getText();
					Assert.assertEquals(SRStatus, SRBookingStatus);
					Reporter.addStepLog("SR Status "+SRBookingStatus+" Validated Successfully.");
						
					if(Variables.Bookingflag==true)
					{
						String CreatedDate =driver.findElement(By.id((i+1)+FivestarAdminPage.CreatedDateSRStr)).getText();
						String Date=FivestarMethods.FetchTodayDate();
						//Assert.assertEquals(Date,CreatedDate.substring(0, Date.length()));
					}
					
					Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					
				}
				
			}
			catch(Exception e)
			{
				Reporter.addStepLog("Error while fetching SR details in fivestar admin.");
				Reporter.addStepLog(e.toString());
				Assert.fail(e.toString());
			}
				
			
		}
		
		public static void ValTaskExecutionDetails_FivestarAdminPg(String ReqNo,String testcase) throws Exception
		{
			try
			{
				
				FivestarMethods.SearchRequestNumber(ReqNo,FivestarAdminPage.SearchButtonTaskExecution,FivestarAdminPage.RequestNumber,FivestarAdminPage.RequestNumberTaskExecution,FivestarAdminPage.GoButtonTaskExecution);
					
				
				String[] TaskStarttime=FivestarMethods.SortFieldHeaderAndReadFieldValue(FivestarAdminPage.HeaderStartDateTime,FivestarAdminPage.SortAscending,FivestarAdminPage.StartDateTime);
				String[] TaskEndtime=FivestarMethods.SortFieldHeaderAndReadFieldValue(FivestarAdminPage.HeaderEndDateTime,FivestarAdminPage.SortAscending,FivestarAdminPage.EndDateTime);
				String Duration=driver.findElement(FivestarAdminPage.TimeDuration).getText();
				FivestarMethods.CompareStartEndTimeWithDuration(TaskStarttime[1], TaskEndtime[1], Duration);
				Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
				//currentScenario.embed(Util.takeScreenshot(driver), "ValTaskExecutionDetails/png");
			}
			catch(Exception e)
			{
				Reporter.addStepLog("Error while adding task execution details.");
				Reporter.addStepLog(e.toString());
				Assert.fail(e.toString());
			}
					
		}
		
		public static void UpdateTaxPercentage(String[] arrAirportCode)
		{
			try
			{
				for(int i=0;i<arrAirportCode.length;i++)
				{
					FivestarMethods.SearchRequestNumber(arrAirportCode[i],FivestarAdminPage.SearchButtonAirportList,FivestarAdminPage.AirportCodeLabel,FivestarAdminPage.AirportCodeTextbox,FivestarAdminPage.GoButtonAirportList);		
					common.navigateThirdLevelViewbar("Pricing Detail");
					 if(arrAirportCode[i].equalsIgnoreCase("NRT"))
					 {
						 FixedValues.NRTTaxValue=Integer.parseInt(driver.findElement(FivestarAdminPage.CurrentTaxPercentPricingDetail).getText());
					 }
					 if(arrAirportCode[i].equalsIgnoreCase("LHR"))
					 {
						 FixedValues.LHRTaxValue=Integer.parseInt(driver.findElement(FivestarAdminPage.CurrentTaxPercentPricingDetail).getText());
					 }
				}
				 
			}
			catch(Exception e)
			{
				Reporter.addStepLog("Error while Updating Tax Amount");
				Reporter.addStepLog(e.toString());
				Assert.fail(e.toString());
			}
			
		}
		public static void UpdatePromocode(String[] arrAirportCode,String FlowType,String testcase)
		{
			try
			{
				Variables.Promoflag=true;
				List<String> Promocodename = new ArrayList<String>();
				List<String> DiscountDoller=new ArrayList<String>();
				List<String> DiscountPercent=new ArrayList<String>();
				 for(int i=0;i<arrAirportCode.length;i++)
				 {
					 FivestarMethods.SearchRequestNumber(arrAirportCode[i],FivestarAdminPage.SearchButtonAirportList,FivestarAdminPage.AirportCodeLabel,FivestarAdminPage.AirportCodeTextbox,FivestarAdminPage.GoButtonAirportList);		
					 common.navigateThirdLevelViewbar("Promotion Details");
					 Promocodename=FivestarMethods.FetchListValue(FivestarAdminPage.PromotionsNameCell,arrAirportCode[i],Promocodename);
					 DiscountDoller=FivestarMethods.FetchListValue(FivestarAdminPage.DiscountDollerPromotions,arrAirportCode[i],DiscountDoller);
					 DiscountPercent=FivestarMethods.FetchListValue(FivestarAdminPage.DiscountPercentPromotions,arrAirportCode[i],DiscountPercent);
					 Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
					 common.navigateThirdLevelViewbar("Pricing Detail");
					 if(arrAirportCode[i].equalsIgnoreCase("NRT"))
					 {
						 FixedValues.NRTTaxValue=Integer.parseInt(driver.findElement(FivestarAdminPage.CurrentTaxPercentPricingDetail).getText());
					 }
					 if(arrAirportCode[i].equalsIgnoreCase("LHR"))
					 {
						 FixedValues.LHRTaxValue=Integer.parseInt(driver.findElement(FivestarAdminPage.CurrentTaxPercentPricingDetail).getText());
					 }
					
				 }
				 String allPromocodename = String.join(",", Promocodename);
				 String allDiscountDoller = String.join(",", DiscountDoller);
				 String allDiscountPercent = String.join(",", DiscountPercent);
				 
				 switch(FlowType.toUpperCase())
				 {
					case "EDIT":
						CommonMethods.SetEditFivestarData("Promocode",allPromocodename,testcase);
						CommonMethods.SetEditFivestarData("Discountdoller",allDiscountDoller,testcase);
						CommonMethods.SetEditFivestarData("Discountpercent",allDiscountPercent,testcase);
						Variables.InitializeValue("Edit", testcase);
						break;
					case "CANCEL":
						CommonMethods.SetCancelFivestarData("Promocode",allPromocodename,testcase);
						CommonMethods.SetCancelFivestarData("Discountdoller",allDiscountDoller,testcase);
						CommonMethods.SetCancelFivestarData("Discountpercent",allDiscountPercent,testcase);
						Variables.InitializeValue("Cancel", testcase);
						break;
					case "BOOK":
						CommonMethods.SetFivestarData("Promocode",allPromocodename,testcase);
						CommonMethods.SetFivestarData("Discountdoller",allDiscountDoller,testcase);
						CommonMethods.SetFivestarData("Discountpercent",allDiscountPercent,testcase);
						Variables.InitializeValue("Book", testcase);
						break;
					
				 }
				
			}
			catch(Exception e)
			{
				Reporter.addStepLog("Error while Searching Promocode");
				Reporter.addStepLog(e.toString());
				Assert.fail(e.toString());
			}
		}
		public static void ChkCallFlagAirportCode_FivestarAdminPg(String[] arrAirportCode,String testcase) throws Exception
		{
			try
			{
				 
				 
				 for(int i=0;i<arrAirportCode.length;i++)
				 {
					 FivestarMethods.SearchRequestNumber(arrAirportCode[i],FivestarAdminPage.SearchButtonAirportList,FivestarAdminPage.AirportCodeLabel,FivestarAdminPage.AirportCodeTextbox,FivestarAdminPage.GoButtonAirportList);		
					 
					 FivestarMethods.SelectCheckbox(FivestarAdminPage.AlwaysCallLabel, FivestarAdminPage.AlwaysCallCheckBoxUncheked);
					 Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
								
				 }

			}
			catch(Exception e)
			{
				Reporter.addStepLog("Error while ensuring selected airport should be configured with schedule timings and correct timezone");
				Reporter.addStepLog(e.toString());
				Assert.fail(e.toString());
			}
			
		}


}
