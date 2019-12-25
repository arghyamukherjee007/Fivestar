package com.cucumbercraft.stepdefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.cucumbercraft.pages.FivestarAdhocPaymentPage;
import com.cucumbercraft.pages.FivestarBookingPage;

public class AdhocPaymentMethods extends MasterStepDefination {

	static AdhocPayment AdhocPaymentData;
	
	static CommonMethods common = new CommonMethods();
	static Actions act=new Actions(driver);
	
	 public static void FillAdhocPaymentReqInitiation(String testcase)
	 {
		 try
		 {
			 AdhocPaymentData = CommonMethods.getAdhocPaymentData(testcase);
			 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AdhocPaymentData.ReqInitiation.RequestNo+"'",driver.findElement(FivestarAdhocPaymentPage.RequestAdhocPayment));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AdhocPaymentData.ReqInitiation.AirportCode+"'",driver.findElement(FivestarAdhocPaymentPage.AirportCodeAdhocPayment));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AdhocPaymentData.ReqInitiation.timetoSet+"'",driver.findElement(FivestarAdhocPaymentPage.ServiceDateAdhocPayment));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AdhocPaymentData.ReqInitiation.AdultNo+"'",driver.findElement(FivestarAdhocPaymentPage.AdultNoAdhocPayment));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AdhocPaymentData.ReqInitiation.ChildNo+"'",driver.findElement(FivestarAdhocPaymentPage.ChildNoAdhocPayment));
			 FivestarMethods.javascriptClick(driver, driver.findElement(FivestarAdhocPaymentPage.AdultNameAdhocPayment));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AdhocPaymentData.ReqInitiation.AdultNames+"'",driver.findElement(FivestarAdhocPaymentPage.AdultNameAdhocPayment));
			 Thread.sleep(1000);
			 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AdhocPaymentData.ReqInitiation.AdultNames+"'",driver.findElement(FivestarBookingPage.ATOCommentsPopUpTextBox));
			 
			 driver.findElement(FivestarAdhocPaymentPage.AdhocPassengerOkButton).click();
			 FivestarMethods.javascriptClick(driver, driver.findElement(FivestarAdhocPaymentPage.ChildNameAdhocPayment));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+AdhocPaymentData.ReqInitiation.ChildNames+"'",driver.findElement(FivestarAdhocPaymentPage.ChildNameAdhocPayment));
			 Thread.sleep(1000);
			 driver.findElement(FivestarAdhocPaymentPage.AdhocPassengerOkButton).click();
			 
			 driver.findElement(FivestarAdhocPaymentPage.RequestAdhocPayment).click();
			 driver.findElement(FivestarAdhocPaymentPage.AirportCodeAdhocPayment).click();
			 driver.findElement(FivestarAdhocPaymentPage.ServiceDateAdhocPayment).click();
			 driver.findElement(FivestarAdhocPaymentPage.AdultNoAdhocPayment).click();
			 driver.findElement(FivestarAdhocPaymentPage.ChildNoAdhocPayment).click();
			// driver.findElement(FivestarBookingPage.AdultNameAdhocPayment).click();
		//	 driver.findElement(FivestarBookingPage.ChildNameAdhocPayment).click();
			 
		 }
		catch(Exception e)
		{
				Reporter.addStepLog("Error while providing input in Adhoc request initiation ");
				Reporter.addStepLog(e.toString());
				Assert.fail(e.toString());
		}   
	 }
}
