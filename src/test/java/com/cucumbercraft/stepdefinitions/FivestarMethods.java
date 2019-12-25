package com.cucumbercraft.stepdefinitions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.cucumbercraft.pages.FivestarBookingPage;
import com.cucumbercraft.pages.Variables;

public class FivestarMethods extends MasterStepDefination{
	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	static BookFiveStarData BookFivestardata;
	
	public static String[] SortFieldHeaderAndReadFieldValue(By HeaderField,By SortAscending,By FieldValue)
	{
		String[] Time=null;
		try
		{
			driver.findElement(HeaderField).click();
			Thread.sleep(1000);
			driver.findElement(SortAscending).click();
			Thread.sleep(1000);
			Time=driver.findElement(FieldValue).getText().toString().split(" ", 2);
			Thread.sleep(2000);
			Reporter.addStepLog("Task Time "+Time[1]+" fetched successfully in task execution details.");
			
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Sorting Start Time and Reading Value.");
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
			
		}
		return Time;
	}
	
	protected static void javascriptClick(WebDriver ldriver, WebElement el) 
	{

		((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", el);
		ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

	}
	
	protected static void javascriptEdit(WebDriver ldriver, String ElementID,String colval) 
	{
		Actions act=new Actions(driver);
		((JavascriptExecutor) ldriver).executeScript("document.getElementById('"+ElementID+"').value='"+colval+"';");
		ClickTab(act);
	}
	
	
	public static void SearchRequestNumber(String input,By SearchButton,By Label,By TextBox,By GoButton)
	{
		try
		{
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(SearchButton)).click().perform();
			Thread.sleep(2000);
			driver.findElement(Label).click();
			Thread.sleep(1000);
			driver.findElement(TextBox).sendKeys(input);
			Thread.sleep(1000);
			driver.findElement(GoButton).click();
			Thread.sleep(4000);
			Reporter.addStepLog("Request details present for airport "+input);
				
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Searching Request details for Airport "+input);
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
			
		}
	}
	
	public static void ClickTabOrButton(By FieldObj)
	{
		try
		{
			
			driver.findElement(FieldObj).click();
			Thread.sleep(2000);
			Reporter.addStepLog("Successfully navigated to Required Element. ");
			
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Clicking Required element.");
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
			
		}
	}
	
		
	public static List<String> FetchListValue(By FieldObj,String AirportCode,List<String> SRNumberlist)
	{
		
		try
		{
			String SRNumber = driver.findElement(FieldObj).getText();
			if(SRNumber.equalsIgnoreCase(" "))
			{
				SRNumber="0";
			}
			SRNumberlist.add(SRNumber);
			
			Reporter.addStepLog("List Of Values for "+SRNumber+" present for:"+AirportCode);
			
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Searching fetching list value.");
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
			
		}
		return SRNumberlist;
	}
	
	
	
	
		
	public static void ClickSave(Actions act)
	{
		try
		{
			 act.sendKeys(Keys.CONTROL,"s").build().perform();
			 Thread.sleep(2000);
			 Reporter.addStepLog("Successfully saved details in table");
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Saving details");
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
			
		}
	}
	
	
	
		
	public static void ClickTab(Actions act)
	{
		try
		{
			act.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			 
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Clicking Tab");
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
		}
	}
	public static void SaveWebtable(By WebTable,Actions act)
	{
		try
		{
			ClickTabOrButton(WebTable);
			ClickSave(act);
			 
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Saving Webtable "+WebTable.toString());
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
		}
	}
	
	
	
	
	
	
	public static void SearchTextBoxApplet(String input,By SearchButton,By TextBox,By GoButton)
	{
		try
		{
			driver.findElement(SearchButton).click();
	   	 	((JavascriptExecutor) driver).executeScript("arguments[0].value='"+input+"'",driver.findElement(TextBox));
	   	 	driver.findElement(TextBox).click();
	   	 	driver.findElement(GoButton).click();
	   	 	Variables.popupstatus=BookingMethods.CheckForPopUp(Variables.popupstatus);
			 if(Variables.popupstatus==true)
			 {
				 driver.switchTo().alert().accept();
				 driver.findElement(GoButton).click();
				 Thread.sleep(5000);
			 }
			 Reporter.addStepLog("Input "+input+" Searched successfully.");
				
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Searching input."+input);
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
		}
	}
	
		
	public static void SelectCheckbox(By Label,By UncheckedCheckbox)
	{
		try
		{
			//driver.findElement(Label).click();
			javascriptClick(driver,driver.findElement(Label));
			
			
			try
			{
				
				if(driver.findElement(UncheckedCheckbox).isDisplayed())
				{
					javascriptClick(driver,driver.findElement(UncheckedCheckbox));
					
				}
				
			}
			catch(Exception e)
			{
				
			}
			
			Reporter.addStepLog("Successfully selected checkbox.");

		}
		catch(Exception e)
		{
			
		}
	}

	public static void SelectCKCheckBox(By Label,By UncheckedCheckbox)
	{
		try
		{
			
			javascriptClick(driver,driver.findElement(Label));
			try
			{
				if(driver.findElement(By.xpath("//input[@aria-checked='false']")).isDisplayed())
				{
					javascriptClick(driver,driver.findElement(By.xpath("//input[@aria-checked='false']")));
					
				}
			}
			catch(Exception e)
			{
				
			}
			Reporter.addStepLog("Successfully selected checkbox.");
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Selecting checkbox.");
			Reporter.addStepLog(e.toString());
			Assert.fail(e.toString());
		}
	}

	public static void CompareStartEndTimeWithDuration(String Starttime,String Endtime,String Duration)
	{
		try
		{
			SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
			Date startdate = format.parse(Starttime);
			Date enddate = format.parse(Endtime);
			double difference = enddate.getTime()-startdate.getTime();
			
			String differencetext = String.valueOf(difference).substring(0, Duration.length());
			Assert.assertEquals(Double.parseDouble(differencetext), Double.parseDouble(Duration), 0.01);
			Reporter.addStepLog("Duration "+Duration+" Compared successfully with difference of start time and end time "+difference);
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while comparing Start and End Time "+e.toString());
			Assert.fail(e.toString());
		}
		
	}
	public static String FetchTodayDate() throws Exception
	{
		String Date=null;
		try
		{
			String[] arrnewDateinterval = LocalDate.now().toString().split("-");
			
			if(arrnewDateinterval[1].substring(0, 1).equals("0"))
			{
				arrnewDateinterval[1]=arrnewDateinterval[1].substring(1, 2);
			}
			
			if(arrnewDateinterval[2].substring(0, 1).equals("0"))
			{
				arrnewDateinterval[2]=arrnewDateinterval[2].substring(1, 2);
			}
			Date=arrnewDateinterval[1]+"/"+arrnewDateinterval[2]+"/"+arrnewDateinterval[0];
			 
			
			Reporter.addStepLog("Created "+Date+" is same as today's date");
			
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while Validation Created Date "+e.toString());
			Assert.fail(e.toString());
		}
		return Date;
	}	
	
	
	
	
		
	public static void ValNetPrice_SelectProfilePgPg(double NetAmtPrice,String testcase) throws Exception
	{
		try
		{
			
			double CaptureNetAmtPrice = Double.parseDouble(driver.findElement(FivestarBookingPage.NetTotalPrice).getAttribute("value"));
			Assert.assertEquals(NetAmtPrice, CaptureNetAmtPrice, 0.01);
			Reporter.addStepLog("Net Total Price"+CaptureNetAmtPrice+"Captured successfully.");
		//	ComparePrice(NetAmtPrice,CaptureNetAmtPrice);
			
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while validating net total price:"+e.toString());
			Assert.fail(e.toString());
		}
		
	}
	public static void ValAdultPrice_SelectProfilePgPg(double NetAdultPrice,String testcase) throws Exception
	{
		try
		{
			double CaptureNetAdultPrice = Double.parseDouble(driver.findElement(FivestarBookingPage.NetAdultPrice).getAttribute("value"));
			Assert.assertEquals(NetAdultPrice, CaptureNetAdultPrice, 0.01);
			
			Reporter.addStepLog("Net Adult Price"+CaptureNetAdultPrice+"Captured successfully.");
			//ComparePrice(NetAdultPrice,CaptureNetAdultPrice);
			
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while validating Adult price:"+e.toString());
			Assert.fail(e.toString());
		}
		
	}
	
	public static void ValPromoAmt_SelectProfilePgPg(double PromoDiscount,String testcase) throws Exception
	{
			try
			{
				if(Variables.Promoflag==true)
				{
					double CapturePromoDiscount = Double.parseDouble(driver.findElement(FivestarBookingPage.PromotionDiscount).getAttribute("value"));
					Reporter.addStepLog("Promo Amount"+CapturePromoDiscount+"Captured successfully.");
					Assert.assertEquals(PromoDiscount, CapturePromoDiscount, 0.01);
				}			
			}
			catch(Exception e)
			{
				Reporter.addStepLog("Error while validating Promo Amount:"+e.toString());
				Assert.fail(e.toString());
			}
		
	}
	
	public static void ValAdditionalServices_SelectProfilePg(double TotalAdditionalServices,String testcase)
	{
		try
		{
			if(Variables.additionalserviceflag==true)
			{
				double CaptureAdditionalService = Double.parseDouble(driver.findElement(FivestarBookingPage.AdditionalServiceDiscount).getAttribute("value"));
				Reporter.addStepLog("Additional Service"+CaptureAdditionalService+"Captured successfully.");
				Assert.assertEquals(TotalAdditionalServices, CaptureAdditionalService, 0.01);
			}
		}
		catch(Exception e)
		{
			Reporter.addStepLog("Error while validating Additional Services:"+e.toString());
			Assert.fail(e.toString());
		}
	}
	
		
}
