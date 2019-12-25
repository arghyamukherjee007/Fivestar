package com.cucumbercraft.pages;



import org.openqa.selenium.By;
import com.cucumbercraft.stepdefinitions.MasterStepDefination;

public class FivestarAdminPage extends MasterStepDefination {
	
	//Fivestar Admin
	
	
		//Booking Admin
		public final static By BookingAdminTab = By.xpath("//*[text()='Booking Admin']");
		public final static By FiveStarBookingListLabel = By.xpath("//*[text()='Five Star Booking List']");
		public final static By RequestNumber = By.id("1_s_1_l_Request_Number");
		public final static By RequestNumberBookingAdmin = By.id("1_s_2_l_Request");
		public final static By RequestNumberTextBox = By.name("Request");
		
		//Promotions
		public final static By QueryButtonPromotions = By.xpath("//*[@aria-label='Promotions:Query']");
		public final static By PromotionsThirdLevelLabel = By.xpath("(//*[text()='Promotions'])[2]");
		public final static By PromotionsNameCell = By.id("1_s_2_l_Promotion_Name");
		public final static By DiscountDollerPromotions = By.id("1_s_2_l_Promotion_Discount");
		public final static By DiscountPercentPromotions = By.id("1_s_2_l_Promotion_Discount_Percent");
		
		//Pricing Detail
		public final static By CurrentTaxPercentPricingDetail = By.id("1_s_2_l_Tax_Percent");
		
				//Credit Card Profile
				public final static By CreditCardProfileButtonLabel = By.className("siebui-btn-grp-applet");
				public final static By CreditCardProfileLabel = By.xpath("(//*[text()='Credit Card Profile'])[2]");
				public final static By AddButtonCreditCard = By.xpath("//*[@aria-label='Credit Card Profile:Add']");
				public final static By AADVTextBoxCreditCard = By.xpath("//*[@aria-label='AADV #']");
				public final static By CardTextBoxCreditCard = By.xpath("//*[@aria-label='Card #']");
				public final static By FirstNameTextBoxCreditCard = By.xpath("//*[@aria-label='First Name']");
				public final static By FirstNameLabelCreditCard = By.xpath("//*[text()='First Name']");
				public final static By LastNameTextBoxCreditCard = By.xpath("//*[@aria-label='Last Name']");
				public final static By ExpMonthTextBoxCreditCard = By.xpath("//*[@aria-label='Expiration Month']");
				public final static By ExpYearTextBoxCreditCard = By.xpath("//*[@aria-label='Expiration Year']");
				public final static By AddrLine1TextBoxCreditCard = By.xpath("//*[@aria-label='Address Line 1']");
				public final static By AddrLine2TextBoxCreditCard = By.xpath("//*[@aria-label='Address Line 2']");
				public final static By CityTextBoxCreditCard = By.xpath("//*[@aria-label='City']");
				public final static By StateTextBoxCreditCard = By.xpath("//*[@aria-label='State']");
				public final static By ZipCodeTextBoxCreditCard = By.xpath("//*[@aria-label='Zip Code']");
				public final static By CountryTextBoxCreditCard = By.xpath("//*[@aria-label='Country']");
				public final static By SaveButtonCreditCard = By.xpath("//*[@aria-label='Credit Card Profile:Save']");
				public final static By SearchButtonCreditCard = By.xpath("//*[@aria-label='Credit Card Profile:Search']");
				public final static String CardNumberCellCreditCardTable = "_s_1_l_Account_Number_-_Display";
				public final static By GoButtonCreditCard = By.xpath("//*[@aria-label='Credit Card Profile:Go']");
				public final static By DeleteButtonCreditCard = By.xpath("//*[@aria-label='Credit Card Profile:Delete']");
				
				
				//Agency Profile
				public final static By SearchButtonAgencyProfile = By.xpath("//*[@aria-label='Agency/Company Name:Search']");
				public final static By OneWordIDTextBoxAgencyProfile = By.name("AAKS_Agency_Id");
				public final static By GoButtonAgencyProfile = By.xpath("//*[@aria-label='Agency/Company Name:Go']");
				
		//Task Execution Details
		public final static By RequestNumberTaskExecution = By.name("Request_Number");
		public final static By SearchButtonTaskExecution = By.xpath("//*[@aria-label='Task Execution Details:Search']");
		public final static By GoButtonTaskExecution = By.xpath("//*[@aria-label='Task Execution Details:Go']");
		public final static By HeaderStartDateTime = By.id("jqgh_s_1_l_Start_Date_Time");	
		public final static By HeaderEndDateTime = By.id("jqgh_s_1_l_End_Date_Time");		
		public final static By SortAscending = By.xpath("(//*[@title='Sort ascending'])[2]/a");		
		public final static By SortDescending = By.xpath("(//*[@title='Sort descending'])[2]/a");			
		public final static By StartDateTime = By.id("1_s_1_l_Start_Date_Time");	
		public final static By EndDateTime = By.id("1_s_1_l_End_Date_Time");	
		public final static By TimeDuration = By.id("1_s_1_l_Duration_Calc");		
		public final static By TaskExecutionDetailsTab = By.xpath("//*[text()='Task Execution Details']");	
		public final static By TaskExecutionDetailsLabel = By.xpath("(//*[text()='Task Execution Details'])[2]");	
		public final static By SecondLevelViewBarDownArrow = By.xpath("//*[@aria-label='Second Level View Bar']");
		public final static By TaskExecutionDetailsDownBar = By.xpath("//*[@aria-label='Second Level View Bar']/option[text()='Task Execution Details']");
		public final static By StartDayLabel = By.id("1_s_2_l_Start_Day");
		public final static By StartDayTextBox = By.name("Start_Day");
		public final static By StartDaydownArrow = By.id("s_2_2_24_0_icon");
		public final static By StartTimeLabel = By.id("1_s_2_l_Start_Time");
		public final static By StartTimeTextBox = By.name("Start_Time");
		public final static By EndTimeLabel = By.id("1_s_2_l_End_Time");
		public final static By EndTimeTextBox = By.name("End_Time");
		
		
		//SR Details
		
		
		public final static By AirportCodeLabelSR = By.id("1_s_2_l_AAKS_Airport_Code");	
		public final static By AirportCodeTextBoxSR = By.name("AAKS_Airport_Code");		
		public final static By CreatedDateSR = By.id("1_s_2_l_AAKS_Created");
		public final static String CreatedDateSRStr = "_s_2_l_AAKS_Created";		
		
		public final static By BookingStatusSR = By.id("1_s_2_l_Status");			
		public final static String BookingStatusSRStr = "_s_2_l_Status";
		//Airport List
		public final static By AirportListTab = By.xpath("//*[text()='Airport List']");
		public final static By AirportLabel = By.xpath("//*[text()='Airport']");
		public final static By SearchButtonAirportList = By.xpath("//*[@title='Airport:Search']");
		public final static By AirportCodeLabel = By.id("1_s_1_l_Code");
		public final static By AirportCodeTextbox = By.name("Code");
		public final static By BookingType = By.id("1_s_2_l_Booking_Type");	
		public final static By BookingStatus = By.id("1_s_2_l_Status");		
		public final static By GoButtonAirportList = By.xpath("//*[@title='Airport:Go']");
		public final static By AlwaysCallCheckBoxUncheked = By.xpath("//input[@value='N' and @aria-checked='false']");
		public final static By AlwaysCallCheckBoxChecked = By.xpath("//input[@value='Y' and @aria-checked='true']");
		public final static By AlwaysCallLabel = By.id("1_s_2_l_Shift_Start_Flag");
		public final static By GoButtonAirportSchedule = By.xpath("//button[@title='Schedule Hours:Go']");
		public final static By SearchButtonAirportSchedule = By.xpath("//button[@title='Schedule Hours:Search']");
		
		public static final By SearchButtonBookingAdmin = By.xpath("//*[@aria-label='Five Star Booking List:Search']");
		public static final By GoButtonBookingAdmin = By.xpath("//*[@aria-label='Five Star Booking List:Go']");

	/*	public static final By FivestarAdminTab = By.xpath("//*[text()='Five Star Admin']");
		public static final By FivestarSRDetails = By.xpath("//*[text()='Five Star SR Details']");	
		public static final By SearchButtonServiceRequest = By.xpath("//*[@aria-label='Five Star Service Request List:Search']");	
		public static final By GoButtonServiceRequest = By.xpath("(//*[@aria-label='Five Star Service Request List:Go'])[1]");	
		
		
		*/
		
		
	
	
		/*public static void HandleDifferentEnv()
		{
			if(properties.getProperty("ENV")=="OCI-MDEV")
			{
				final By FivestarAdminTab = By.xpath("//*[text()='Five Star Admin']");
				final By FivestarSRDetails = By.xpath("//*[text()='Five Star SR Details']");	
				final By SearchButtonServiceRequest = By.xpath("//*[@aria-label='Five Star Service Request List:Search']");	
				final By GoButtonServiceRequest = By.xpath("(//*[@aria-label='Five Star Service Request List:Go'])[1]");	
				final By SearchButtonBookingAdmin = By.xpath("//*[@aria-label='Five Star Booking List:Search']");
				final By GoButtonBookingAdmin = By.xpath("//*[@aria-label='Five Star Booking List:Go']");
			}
			else
			{
				final By FivestarAdminTab = By.xpath("//*[text()='KeyStar Admin']");
				final By FivestarSRDetails = By.xpath("//*[text()='KeyStar SR Details']");	
				final By SearchButtonServiceRequest = By.xpath("//*[@aria-label='KeyStar Service Request List:Search']");	
				final By GoButtonServiceRequest = By.xpath("(//*[@aria-label='KeyStar Service Request List:Go'])[1]");	
				final By SearchButtonBookingAdmin = By.xpath("//*[@aria-label='KeyStar Booking List:Search']");
				final By GoButtonBookingAdmin = By.xpath("//*[@aria-label='KeyStar Booking List:Go']");
			}
		}*/

}
