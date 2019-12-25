package com.cucumbercraft.stepdefinitions;

import static com.cucumbercraft.stepdefinitions.CommonMethods.getBookFivestarData;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.listener.Reporter;


import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.Util;
import com.cucumbercraft.pages.FivestarAdminPage;
import com.cucumbercraft.pages.FivestarBookingPage;

public class CommonMethods extends MasterStepDefination {

	//static WebDriver driver = DriverManager.getWebDriver();
	//static WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	public static boolean runStatus = true;
	protected static String card1MSR = null;
	static BookFiveStarData BookFivestardata;
	
	protected CommonMethods() {
		// Constructor
	}

static public void SetCancelFivestarData(String caseVal,String update,String testCase) throws Exception {
		
		switch(caseVal.toLowerCase())
		{
			case "requestno":
				String[] updateJsonDataReqNo = { "RequestNo=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataReqNo);
				break;
			case "srnumber":
				String[] updateJsonDataSRNumber = { "SRNumber=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataSRNumber);
				break;
			case "refundamt":
				String[] updateJsonDataRefundAmt = { "RefundAmt=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataRefundAmt);
				break;
			case "promocode":
				String[] updateJsonDataPromoCode = { "Promocode=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataPromoCode);
				break;
			case "transferrefundamount":
				String[] updateJsonDataTransferAmt = { "TransferRefundAmount=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataTransferAmt);
				break;
			case "discountdoller":
				String[] updateJsonDataDiscountDoller = { "Discountdoller=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataDiscountDoller);
				break;
			case "discountpercent":
				String[] updateJsonDataDiscountPercent = { "Discountpercent=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataDiscountPercent);
				break;
			case "promodiscount":
				String[] updateJsonDataPromoDiscount = { "PromoDiscount=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataPromoDiscount);
				break;
			case "nettotalamt":
				String[] updateJsonDataNetTotalAmt = { "NetTotalAmt=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataNetTotalAmt);
				break;
			case "totaladditionalservices":
				String[] updateJsonDatatotaladditionalservices = { "totaladditionalservices=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDatatotaladditionalservices);
				break;
			case "airportcodeadditional":
				String[] updateJsonDataAirportCodeadd = { "airportcodeadditional=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataAirportCodeadd);
				break;
			case "servicetypeadditional":
				String[] updateJsonDataservicetype = { "servicetypeadditional=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataservicetype);
				break;
			case "priceperbooking":
				String[] updateJsonDatapriceperbooking = { "priceperbooking=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDatapriceperbooking);
				break;
			case "adultpriceadditional":
				String[] updateJsonDataadultprice = { "adultpriceadditional=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataadultprice);
				break;
			case "childpriceadditional":
				String[] updateJsonDatachildprice = { "childpriceadditional=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDatachildprice);
				break;
			case "outstandingamt":
				String[] updateJsonDataOutstandingAmt = { "OutstandingAmt=" + update };
				new JsonReaderCancelBooking().setJsonData(testCase, updateJsonDataOutstandingAmt);
				break;

		}
}

	static public void SetFivestarData(String caseVal,String update,String testCase) throws Exception {
		
		switch(caseVal.toLowerCase())
		{
			case "updatedrequestno":
				String[] updateJsonUpdatedDataReqNo = { "UpdatedRequestNo=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonUpdatedDataReqNo);
				break;
			case "pnr":
				String[] updateJsonDatapnr = { "pnr=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDatapnr);
				break;
			case "requestno":
				String[] updateJsonDataReqNo = { "RequestNo=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataReqNo);
				break;
			case "srnumber":
				String[] updateJsonDataSRNumber = { "SRNumber=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataSRNumber);
				break;
			case "nettotalamt":
				String[] updateJsonDataNetTotalAmt = { "NetTotalAmt=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataNetTotalAmt);
				break;
			case "promocode":
				String[] updateJsonDataPromoCode = { "Promocode=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataPromoCode);
				break;
			case "adultprice":
				String[] updateJsonDataAdultPrice = { "AdultPrice=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataAdultPrice);
				break;
			case "outstandingamt":
				String[] updateJsonDataOutstandingAmt = { "OutstandingAmt=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataOutstandingAmt);
				break;
			case "totaladditionalservices":
				String[] updateJsonDatatotaladditionalservices = { "totaladditionalservices=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDatatotaladditionalservices);
				break;
			case "discountdoller":
				String[] updateJsonDataDiscountDoller = { "Discountdoller=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataDiscountDoller);
				break;
			case "discountpercent":
				String[] updateJsonDataDiscountPercent = { "Discountpercent=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataDiscountPercent);
				break;
			case "promodiscount":
				String[] updateJsonDataPromoDiscount = { "PromoDiscount=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataPromoDiscount);
				break;
			case "airportprice":
				String[] updateJsonDataAirportPrice = { "AirportPrice=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataAirportPrice);
				break;
			case "transferrefundpnr":
				String[] updateJsonDataTransferpnr = { "TransferRefundPnr=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataTransferpnr);
				break;
			case "transferrefundbookingref":
				String[] updateJsonDataTransferbookingref = { "TransferRefundBookingRef=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataTransferbookingref);
				break;
			case "transferrefundamount":
				String[] updateJsonDataTransferAmt = { "TransferRefundAmount=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataTransferAmt);
				break;
			case "airportcodeadditional":
				String[] updateJsonDataAirportCodeadd = { "airportcodeadditional=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataAirportCodeadd);
				break;
			case "servicetypeadditional":
				String[] updateJsonDataservicetype = { "servicetypeadditional=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataservicetype);
				break;
			case "priceperbooking":
				String[] updateJsonDatapriceperbooking = { "priceperbooking=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDatapriceperbooking);
				break;
			case "adultpriceadditional":
				String[] updateJsonDataadultprice = { "adultpriceadditional=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDataadultprice);
				break;
			case "childpriceadditional":
				String[] updateJsonDatachildprice = { "childpriceadditional=" + update };
				new JsonReaderBookFiveStarData().setJsonData(testCase, updateJsonDatachildprice);
				break;

		}
		
	}
	
	
	static public void SetEditFivestarData(String caseVal,String update,String testCase) throws Exception {
		
		switch(caseVal.toLowerCase())
		{
			case "oldrequestno":
				String[] updateJsonUpdatedDataReqNo = { "oldrequestno=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonUpdatedDataReqNo);
				break;
			case "pnr":
				String[] updateJsonDatapnr = { "pnr=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDatapnr);
				break;
			case "requestno":
				String[] updateJsonDataReqNo = { "RequestNo=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataReqNo);
				break;
			case "airportcode":
				String[] updateJsonDataAirportCode = { "AirportCode=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataAirportCode);
				break;
			case "servicetype":
				String[] updateJsonDataServiceType = { "ServiceType=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataServiceType);
				break;
			case "selectadd":
				String[] updateJsonDataSelectadd = { "selectadd=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataSelectadd);
				break;
			case "srnumber":
				String[] updateJsonDataSRNumber = { "SRNumber=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataSRNumber);
				break;
			case "cancelledsrnumber":
				String[] updateJsonDataCancelledSRNumber = { "CancelledSRNumber=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataCancelledSRNumber);
				break;
			case "promocode":
				String[] updateJsonDataPromoCode = { "Promocode=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataPromoCode);
				break;
			case "totaladditionalservices":
				String[] updateJsonDatatotaladditionalservices = { "totaladditionalservices=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDatatotaladditionalservices);
				break;
			case "nettotalamt":
				String[] updateJsonDataNetTotalAmt = { "NetTotalAmt=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataNetTotalAmt);
				break;
			case "discountdoller":
				String[] updateJsonDataDiscountDoller = { "Discountdoller=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataDiscountDoller);
				break;
			case "promodiscount":
				String[] updateJsonDataPromoDiscount = { "PromoDiscount=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataPromoDiscount);
				break;
			case "discountpercent":
				String[] updateJsonDataDiscountPercent = { "Discountpercent=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataDiscountPercent);
				break;
			case "adultprice":
				String[] updateJsonDataAdultPrice = { "AdultPrice=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataAdultPrice);
				break;
			case "outstandingamt":
				String[] updateJsonDataOutstandingAmt = { "OutstandingAmt=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataOutstandingAmt);
				break;
			case "airportprice":
				String[] updateJsonDataAirportPrice = { "AirportPrice=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataAirportPrice);
				break;
			case "transferrefundpnr":
				String[] updateJsonDataTransferpnr = { "TransferRefundPnr=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataTransferpnr);
				break;
			case "transferrefundbookingref":
				String[] updateJsonDataTransferbookingref = { "TransferRefundBookingRef=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataTransferbookingref);
				break;
			case "transferrefundamount":
				String[] updateJsonDataTransferAmt = { "TransferRefundAmount=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataTransferAmt);
				break;
			case "refundamt":
				String[] updateJsonDataRefundAmt = { "RefundAmt=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataRefundAmt);
				break;
			case "airportcodeadditional":
				String[] updateJsonDataAirportCodeadd = { "airportcodeadditional=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataAirportCodeadd);
				break;
			case "servicetypeadditional":
				String[] updateJsonDataservicetype = { "servicetypeadditional=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataservicetype);
				break;
			case "priceperbooking":
				String[] updateJsonDatapriceperbooking = { "priceperbooking=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDatapriceperbooking);
				break;
			case "adultpriceadditional":
				String[] updateJsonDataadultprice = { "adultpriceadditional=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDataadultprice);
				break;
			case "childpriceadditional":
				String[] updateJsonDatachildprice = { "childpriceadditional=" + update };
				new JsonReaderEditFiveStarData().setJsonData(testCase, updateJsonDatachildprice);
				break;

		}
		
	}

	static public BookFiveStarData getBookFivestarData(String testCase) throws Exception {
		try {
			BookFiveStarData BookFivestarData = new JsonReaderBookFiveStarData().getDataListByTestCase(testCase);
			if (Boolean.valueOf(properties.getProperty("UseCsvRepo"))) {
				//setupFivestarData(FivestarData);
				BookFivestarData = new JsonReaderBookFiveStarData().getDataListByTestCase(testCase);
			}
			return BookFivestarData;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	static public CancelFivestarData getCancelBookingData(String testCase) throws Exception {
		try {
			CancelFivestarData CancelBookingData = new JsonReaderCancelBooking().getDataListByTestCase(testCase);
			if (Boolean.valueOf(properties.getProperty("UseCsvRepo"))) {
				//setupFivestarData(FivestarData);
				CancelBookingData = new JsonReaderCancelBooking().getDataListByTestCase(testCase);
			}
			return CancelBookingData;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	static public CreditCard getCreditcardData(String testCase) throws Exception {
		try {
			CreditCard CreditcardData = new JsonReaderCreditCard().getDataListByTestCase(testCase);
			if (Boolean.valueOf(properties.getProperty("UseCsvRepo"))) {
				//setupFivestarData(FivestarData);
				CreditcardData = new JsonReaderCreditCard().getDataListByTestCase(testCase);
			}
			return CreditcardData;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	static public EditFiveStarData getEditFiveStarData(String testCase) throws Exception {
		try {
			EditFiveStarData EditFivestarData = new JsonReaderEditFiveStarData().getDataListByTestCase(testCase);
			if (Boolean.valueOf(properties.getProperty("UseCsvRepo"))) {
			//	setupFivestarData(BookCKData);
				EditFivestarData = new JsonReaderEditFiveStarData().getDataListByTestCase(testCase);
			}
			return EditFivestarData;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	static public AdhocPayment getAdhocPaymentData(String testCase) throws Exception {
		try {
			AdhocPayment AdhocPaymentData = new JsonReaderAdhocPayment().getDataListByTestCase(testCase);
			if (Boolean.valueOf(properties.getProperty("UseCsvRepo"))) {
			//	setupFivestarData(BookCKData);
				AdhocPaymentData = new JsonReaderAdhocPayment().getDataListByTestCase(testCase);
			}
			return AdhocPaymentData;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public  void navigateFirstLevelViewbar(String ViewName) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			By firstLevelViewTab = By.xpath("//*[@title='First Level View Bar']//a");
			boolean linkFound = false;
			List<WebElement> tabLinks = driver.findElements(firstLevelViewTab);
			for (WebElement tabLink : tabLinks) {
				if (tabLink.getText().equalsIgnoreCase(ViewName)) {
					tabLink.click();
					linkFound = true;
					break;
				}
			}
			if (!linkFound) {
				By firstLevelViewList = By.id("j_s_sctrl_tabScreen");
				Select firstLevelViewSelect = new Select(driver.findElement(firstLevelViewList));
				firstLevelViewSelect.selectByVisibleText(ViewName);
			}
			switch (ViewName.trim().toLowerCase()) {
				case "five star booking":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+Detail+View"));
					break;
				case "five star service request":
					wait.until(ExpectedConditions.urlContains("AAKS+5S+Service+Request+View"));
					break;
				case "five star admin":
					wait.until(ExpectedConditions.urlContains("AAKS+Airport+Shift"));
					break;
				case "five star refund":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+Refunds+View"));
					break;
				case "keystar refund":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+Refunds+View"));
					break;
				case "keystar admin":
					wait.until(ExpectedConditions.urlContains("AAKS+Airport+Shift"));
					break;
				case "keystar booking":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+Detail+View"));
					break;
			}
			Thread.sleep(3000);
			WebDriverWait waitLocal = new WebDriverWait(driver, 10);
			waitLocal.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.cssSelector("html"), "class", "siebui-busy")));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public  void navigateSecondLevelViewbar(String ViewName) throws Exception {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			LoadPropertiesFile();
			System.out.println(properties.getProperty("ENV"));
			WebElement eleSecondLevelTab = driver.findElement(By.xpath("//*[@title='Second Level View Bar']//a[text()='" + ViewName + "']"));
			assertTrue(eleSecondLevelTab.isDisplayed(), ViewName + " view should exist");
			eleSecondLevelTab.click();
			switch (ViewName.trim().toLowerCase()) {
				case "airport list":
					if(properties.getProperty("ENV").equalsIgnoreCase("TEST"))
					{
						wait.until(ExpectedConditions.urlContains("AAKS+Airport+Shift"));
					}
					else
					{
						wait.until(ExpectedConditions.urlContains("AAKS+Airport+List"));
					}
					
					break;
				case "credit card profile":
					wait.until(ExpectedConditions.attributeContains(FivestarAdminPage.CreditCardProfileLabel, "class", "siebui-applet-title"));
					break;
				case "promotions":
					wait.until(ExpectedConditions.urlContains("AAKS+Promotions"));
					break;
				case "keystar agency":
					wait.until(ExpectedConditions.urlContains("AAKS+Agency+Detail+View"));
					break;
				case "booking admin":
					wait.until(ExpectedConditions.attributeContains(FivestarAdminPage.FiveStarBookingListLabel, "class", "siebui-applet-title"));
					break;
				case "task execution details":
					wait.until(ExpectedConditions.urlContains("AAKS+Task+Execution+Detail+View"));
					break;
			}
			Thread.sleep(2000);
			WebDriverWait waitLocal = new WebDriverWait(driver, 10);
			waitLocal.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.cssSelector("html"), "class", "siebui-busy")));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public  void navigateThirdLevelViewbar(String ViewName) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			LoadPropertiesFile();
			By thirdLevelViewTab = By.xpath("//*[@title='Third Level View Bar']//a");
			boolean linkFound = false;
			List<WebElement> tabLinks = driver.findElements(thirdLevelViewTab);
			for (WebElement tabLink : tabLinks) {
				if (tabLink.getText().equalsIgnoreCase(ViewName)) {
					tabLink.click();
					linkFound = true;
					break;
				}
			}
			if (!linkFound) {
				By thirdLevelViewList = By.id("j_s_vctrl_div_tabScreen");
				Select thirdLevelViewSelect = new Select(driver.findElement(thirdLevelViewList));
				thirdLevelViewSelect.selectByVisibleText(ViewName);
			}
			switch (ViewName.trim().toLowerCase()) {
				case "five star flight details":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+View"));
					break;
				case "promotion details":
					wait.until(ExpectedConditions.attributeContains(FivestarAdminPage.PromotionsThirdLevelLabel, "class", "siebui-applet-title"));
					break;
				case "credit card profile":
					wait.until(ExpectedConditions.urlContains("AAKS+Agency+Credit+Card+View"));
					break;
				case "keystar flight details":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+View"));
					break;
				case "five star sr details":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+SR+View"));					
					break;
				case "keystar sr details":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+SR+View"));					
					break;
				case "five star request details":
					wait.until(ExpectedConditions.urlContains("AAKS+Request+Detail+View+-+Admin"));
					break;
				case "pricing detail":
					wait.until(ExpectedConditions.urlContains("AAKS+Airport+Price+View"));
					break;
			}
			Thread.sleep(3000);
			WebDriverWait waitLocal = new WebDriverWait(driver, 10);
			waitLocal.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.cssSelector("html"), "class", "siebui-busy")));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void searchMemberData(String[] ColumnNames, String[] ColumnValues, int iExpectedRecords, String compareFlag) throws Exception {
		try {
			By valueTable = By.xpath("(//table[@class='ui-jqgrid-btable' and not(@summary='Search Results')])[1]");
			WebElement eleValueTable = driver.findElement(valueTable);
			eleValueTable.sendKeys(Keys.CONTROL, Keys.ALT, "q");
			WebDriverWait waitLocal = new WebDriverWait(driver, 5);
			waitLocal.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.cssSelector("html"), "class", "siebui-busy")));
			if (!(getRecordCount(1) == 1)) {
				throw new RuntimeException("Searchable record entry not found!");
			}
			if (!(ColumnNames.length == ColumnValues.length)) {
				throw new RuntimeException("Search member data column names and values count mismatch!");
			}
			int iCell = 0;
			List<WebElement> eleTValue = driver.findElements(By.xpath("((//*[@role='main']//table[@class='ui-jqgrid-btable'])[1]//tr)[2]//td"));
			for (int i = 0; i < ColumnNames.length; i++) {
				int iCol = getFieldColumn(ColumnNames[i]);
				eleTValue.get(iCol).click();
				eleTValue.get(iCol).findElement(By.tagName("input")).sendKeys(ColumnValues[i]);
				iCell = iCol;
			}

			Thread.sleep(1000);
			currentScenario.embed(Util.takeScreenshot(driver), "image/png");

			jse.executeScript("arguments[0].click();", eleTValue.get(iCell));
			eleValueTable = driver.findElement(valueTable);
			eleValueTable.sendKeys(Keys.CONTROL, Keys.ALT, Keys.ENTER);
			Thread.sleep(2000);
			waitLocal = new WebDriverWait(driver, 10);
			waitLocal.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.cssSelector("html"), "class", "siebui-busy")));

			reportStepLog("Search Header: " + String.join(" | ", ColumnNames), true);
			reportStepLog("Search Values: " + String.join(" | ", ColumnValues), true);
			List<WebElement> eleTRecords = driver.findElements(By.xpath("((//*[@role='main']//table[@class='ui-jqgrid-btable'])[1]//tr)"));
			switch (compareFlag.toUpperCase()) {
				case "EQ":
					reportStepLog("Record count should be equal for given search criteria!", String.valueOf(iExpectedRecords),
										String.valueOf(eleTRecords.size() - 1), (eleTRecords.size() == iExpectedRecords + 1));
					if (!(eleTRecords.size() == iExpectedRecords + 1)) {
						throw new RuntimeException("Search member data - Mismatch in expected no. of records!");
					}
					break;
				case "GE":
					reportStepLog("Record count should be >= for given search criteria!", String.valueOf(iExpectedRecords),
										String.valueOf(eleTRecords.size() - 1), (eleTRecords.size() >= iExpectedRecords + 1));
					if (!(eleTRecords.size() >= iExpectedRecords + 1)) {
						throw new RuntimeException("Search member data - Mismatch in expected no. of records!");
					}
					break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void searchMemberData(String appletTitle, String[] ColumnNames, String[] ColumnValues, int iExpectedRecords, String compareFlag)
						throws Exception {
		try {
			By applet = By.xpath("//*[@title='" + appletTitle + "']");
			WebElement eleApplet = driver.findElement(applet);
			jse.executeScript("arguments[0].click();", eleApplet);
			By valueTable = By.xpath("//*[@title='" + appletTitle + "']//table[@class='ui-jqgrid-btable' and not(@summary='Search Results')]");
			WebElement eleValueTable = driver.findElement(valueTable);
			eleValueTable.sendKeys(Keys.CONTROL, Keys.ALT, "q");
			Thread.sleep(1000);
			if (!(getRecordCount(1) == 1)) {
				throw new RuntimeException("Searchable record entry not found!");
			}
			if (!(ColumnNames.length == ColumnValues.length)) {
				throw new RuntimeException("Search member data column names and values count mismatch!");
			}
			int iCell = 0;
			List<WebElement> eleTValue = driver
								.findElements(By.xpath("(//*[@title='" + appletTitle + "']//table[@class='ui-jqgrid-btable']//tr[2]//td)"));
			for (int i = 0; i < ColumnNames.length; i++) {
				int iCol = getFieldColumn(appletTitle, ColumnNames[i]);
				eleTValue.get(iCol).click();
				eleTValue.get(iCol).findElement(By.tagName("input")).sendKeys(ColumnValues[i]);
				iCell = iCol;
			}
			Thread.sleep(1000);
			currentScenario.embed(Util.takeScreenshot(driver), "image/png");

			jse.executeScript("arguments[0].click();", eleTValue.get(iCell));
			eleValueTable = driver.findElement(valueTable);
			eleValueTable.sendKeys(Keys.CONTROL, Keys.ALT, Keys.ENTER);
			Thread.sleep(2000);

			reportStepLog("Search Header: " + String.join(" | ", ColumnNames), true);
			reportStepLog("Search Values: " + String.join(" | ", ColumnValues), true);
			List<WebElement> eleTRecords = driver.findElements(By.xpath("(//*[@title='" + appletTitle + "']//table[@class='ui-jqgrid-btable']//tr)"));
			switch (compareFlag.toUpperCase()) {
				case "EQ":
					reportStepLog("Record count should be equal for given search criteria!", String.valueOf(iExpectedRecords),
										String.valueOf(eleTRecords.size() - 1), (eleTRecords.size() == iExpectedRecords + 1));
					if (!(eleTRecords.size() == iExpectedRecords + 1)) {
						throw new RuntimeException("Search member data - Mismatch in expected no. of records!");
					}
					break;
				case "GE":
					reportStepLog("Record count should be >= for given search criteria!", String.valueOf(iExpectedRecords),
										String.valueOf(eleTRecords.size() - 1), (eleTRecords.size() >= iExpectedRecords + 1));
					if (!(eleTRecords.size() >= iExpectedRecords + 1)) {
						throw new RuntimeException("Search member data - Mismatch in expected no. of records!");
					}
					break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public int getRecordCount(int TableIndex) throws Exception {
		try {
			Thread.sleep(2000);
			List<WebElement> eleTRecords = driver.findElements(By.xpath("((//*[@role='main']//table[@class='ui-jqgrid-btable'])["+TableIndex+"]//tr)"));
			return (eleTRecords.size() - 1);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public int getRecordCountWTime(String columnName) throws Exception {
		try {
			LocalDateTime localDT = LocalDateTime.now().minusMinutes(10);
			String dtLocal = localDT.format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm:ss a"));
			String header[] = { columnName };
			String value[] = { "[Created] > '" + dtLocal + "'" };
			searchMemberData(header, value, 0, "GE");
			Thread.sleep(2000);
			List<WebElement> eleTRecords = driver.findElements(By.xpath("((//*[@role='main']//table[@class='ui-jqgrid-btable'])[1]//tr)"));
			return (eleTRecords.size() - 1);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public int getRecordCount(String appletTitle) throws Exception {
		try {
			Thread.sleep(2000);
			List<WebElement> eleTRecords = driver.findElements(By.xpath("(//*[@title='" + appletTitle + "']//table[@class='ui-jqgrid-btable']//tr)"));
			return (eleTRecords.size() - 1);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String getMemberData(String ColumnName, int RowIndex) throws Exception {
		try {
			List<WebElement> eleTValue = driver
								.findElements(By.xpath("((//*[@role='main']//table[@class='ui-jqgrid-btable'])[1]//tr)[" + (RowIndex + 1) + "]//td"));
			int iCol = getFieldColumn(ColumnName);
			jse.executeScript("arguments[0].click();", eleTValue.get(0));
			String text = null;
			if (eleTValue.get(iCol).getAttribute("title").equalsIgnoreCase("checked")) {
				text = "Y";
			} else {
				text = eleTValue.get(iCol).getText().trim();
			}
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String getMemberData(String appletTitle, String ColumnName, int RowIndex) throws Exception {
		try {
			List<WebElement> eleTValue = driver.findElements(
								By.xpath("(//*[@title='" + appletTitle + "']//table[@class='ui-jqgrid-btable']//tr[" + (RowIndex + 1) + "]//td)"));
			int iCol = getFieldColumn(ColumnName);
			jse.executeScript("arguments[0].click();", eleTValue.get(0));
			String text = null;
			if (eleTValue.get(iCol).getAttribute("title").equalsIgnoreCase("checked")) {
				text = "Y";
			} else {
				text = eleTValue.get(iCol).getText().trim();
			}
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyMemberData(String[] ColumnNames, String[] ColumnValues, int RowIndex) throws Exception {
		try {
			if (!(ColumnNames.length == ColumnValues.length)) {
				throw new RuntimeException("Verify member data column names and values count mismatch!");
			}
			for (int i = 0; i < ColumnNames.length; i++) {
				String memData = getMemberData(ColumnNames[i], RowIndex);
				boolean memDataStatus = memData.equalsIgnoreCase(ColumnValues[i]) ? true : false;
				reportStepLog(ColumnNames[i] + " should match!", ColumnValues[i], memData, memDataStatus);
				verifyTrue(memDataStatus, "Data mismatch for the column - " + ColumnNames[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyMemberData(String appletTitle, String[] ColumnNames, String[] ColumnValues, int RowIndex) throws Exception {
		try {
			if (!(ColumnNames.length == ColumnValues.length)) {
				throw new RuntimeException("Verify member data column names and values count mismatch!");
			}
			for (int i = 0; i < ColumnNames.length; i++) {
				String memData = getMemberData(appletTitle, ColumnNames[i], RowIndex);
				boolean memDataStatus = memData.equalsIgnoreCase(ColumnValues[i]) ? true : false;
				reportStepLog(ColumnNames[i] + " should match!", ColumnValues[i], memData, memDataStatus);
				verifyTrue(memDataStatus, "Data match for the column - " + ColumnNames[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyMemberDataNotEmpty(String[] ColumnNames, int RowIndex) throws Exception {
		try {
			for (int i = 0; i < ColumnNames.length; i++) {
				String memData = getMemberData(ColumnNames[i], RowIndex);
				boolean memDataStatus = !(memData.equalsIgnoreCase("")) ? true : false;
				reportStepLog(ColumnNames[i] + " should match!", "[Not Empty]", memData, memDataStatus);
				verifyTrue(memDataStatus, "Data mismatch for the column - " + ColumnNames[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void verifyMemberDataNotEmpty(String appletTitle, String[] ColumnNames, int RowIndex) throws Exception {
		try {
			for (int i = 0; i < ColumnNames.length; i++) {
				String memData = getMemberData(appletTitle, ColumnNames[i], RowIndex);
				boolean memDataStatus = !(memData.equalsIgnoreCase("")) ? true : false;
				reportStepLog(ColumnNames[i] + " should match!", "[Not Empty]", memData, memDataStatus);
				verifyTrue(memDataStatus, "Data mismatch for the column - " + ColumnNames[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setMemberData(String[] ColumnNames, String[] ColumnValues, int RowIndex, int TableIndex,String[] ElementId) throws Exception {
		try {
			if (!(ColumnNames.length == ColumnValues.length)) {
				throw new RuntimeException("Search member data column names and values count mismatch!");
			}
			List<WebElement> eleTValue = driver
								.findElements(By.xpath("((//*[@role='main']//table[@class='ui-jqgrid-btable'])[" + TableIndex + "]//tr)[" + (RowIndex + 1) + "]//td"));
			for (int i = 0; i < ColumnNames.length; i++) {
				int iCol = getFieldColumn(ColumnNames[i],TableIndex);
				
				FivestarMethods.javascriptClick(driver,eleTValue.get(iCol));
				
				FivestarMethods.javascriptEdit(driver,ElementId[i],ColumnValues[i]);
				
			}
			//String saveUpdate = Keys.chord(Keys.CONTROL, "s");
			//eleTValue.get(1).sendKeys(saveUpdate);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public int getFieldColumn(String fieldName,int TableIndex) throws Exception {
		try {
			List<WebElement> eleTHeader = driver.findElements(By.xpath("((//*[@role='main']//table[@class='ui-jqgrid-htable'])[" + TableIndex + "]//th)"));
			for (int i = 0; i < eleTHeader.size(); i++) {
				String header = eleTHeader.get(i).getAttribute("innerText").toString().replaceAll("\\n", "");
				if (header.length() > 0) {
					if (header.substring(1).equalsIgnoreCase(fieldName)) {
						return i;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return 0;
	}
	
	public int getFieldColumn(String fieldName) throws Exception {
		try {
			List<WebElement> eleTHeader = driver.findElements(By.xpath("((//*[@role='main']//table[@class='ui-jqgrid-htable'])[1]//th)"));
			for (int i = 0; i < eleTHeader.size(); i++) {
				String header = eleTHeader.get(i).getAttribute("innerText").toString().replaceAll("\\n", "");
				if (header.length() > 0) {
					if (header.substring(1).equalsIgnoreCase(fieldName)) {
						return i;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return 0;
	}

	public int getFieldColumn(String appletTitle, String fieldName) throws Exception {
		try {
			List<WebElement> eleTHeader = driver.findElements(By.xpath("//*[@title='" + appletTitle + "']//table[@class='ui-jqgrid-htable']//th"));
			for (int i = 0; i < eleTHeader.size(); i++) {
				String header = eleTHeader.get(i).getAttribute("innerText").toString().replaceAll("\\n", "");
				if (header.length() > 0) {
					if (header.substring(1).equalsIgnoreCase(fieldName)) {
						return i;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return 0;
	}

	

	public void waitForNumberOfWindowsToEqual(int numberOfWindows) {
		WebDriverWait waitLocal = new WebDriverWait(driver, 10);
		waitLocal.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (driver.getWindowHandles().size() == numberOfWindows);
			}
		});
	}

	static public void reportStepLog(String description, boolean isMerged) {
		try {
			if (!isMerged) {
				Reporter.addStepLog("<b><mark>" + description + "</mark></b>");
			} else {
				Reporter.addStepLog("<table style=\"table-layout:fixed;width:100%;\"><tbody><tr>" + "<td style=\"width:100%;white-space:pre-wrap;\">"
									+ description + "</td></tr></tbody></table>");
			}
		} catch (Exception e) {
		}
	}

	static public void reportStepLog(String description, String expected, String actual, boolean condition) {
		try {
			if (condition) {
				Reporter.addStepLog("<table style=\"table-layout:fixed;width:100%;\" bgcolor=\"#00cc66\"><tbody><tr>"
									+ "<td style=\"width:40%;white-space:pre-wrap;\">" + description + "</td>"
									+ "<td style=\"width:30%;white-space:pre-wrap;\"><b>Exp:</b> " + expected + "</td>"
									+ "<td style=\"width:30%;white-space:pre-wrap;\"><b>Act:</b> " + actual + "</td>" + "</tr></tbody></table>");
			} else {
				runStatus = false;
				Reporter.addStepLog("<table style=\"table-layout:fixed;width:100%;\" bgcolor=\"#ff4d4d\"><tbody><tr>"
									+ "<td style=\"width:40%;white-space:pre-wrap;\">" + description + "</td>"
									+ "<td style=\"width:30%;white-space:pre-wrap;\"><b>Exp:</b> " + expected + "</td>"
									+ "<td style=\"width:30%;white-space:pre-wrap;\"><b>Act:</b> " + actual + "</td>" + "</tr></tbody></table>");
			}
		} catch (Exception e) {
		}
	}

	static public void verifyTrue(boolean condition, String message) {
		if (!condition)
			runStatus = false;
	}

	static public void verifyTrue(boolean condition) {
		if (!condition)
			runStatus = false;
	}

	static public void verifyFalse(boolean condition, String message) {
		if (condition)
			runStatus = false;
	}

	static public void verifyFalse(boolean condition) {
		if (condition)
			runStatus = false;
	}

	static public void reportStatus() {
		if (!runStatus) {
			runStatus = true;
			Assert.fail("Check verification steps about failure!");
		}
	}


	

	
}
