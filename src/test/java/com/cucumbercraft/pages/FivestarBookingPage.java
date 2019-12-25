package com.cucumbercraft.pages;

import org.openqa.selenium.By;
import com.cucumbercraft.stepdefinitions.MasterStepDefination;

public class FivestarBookingPage extends MasterStepDefination {
	
	public final static By PassengersLabel =By.xpath("//*[text()='Passengers']");
	
	public final static By AirportLabel =By.xpath("//*[text()='Airport']");
	public final static By ItineraryLabel =By.xpath("//*[text()='Itinerary']");
	public final static By PaymentBreakdownLabel =By.xpath("//span[text()='Payment Breakdown']");
	public final static By SelectRefundsLabel = By.xpath("//*[text()='Select Refunds']");
	public final static By RefundSummaryLabel = By.xpath("(//*[contains(text(),'Refund Summary')])[2]");
	public final static By PaymentSummaryLabel =By.xpath("//*[text()='Payment Summary']");
	public final static By TaskbarRequestInitiation =By.xpath("(//*[text()='1 - Request Initiation'])[1]");
	public final static By AdhocTaskbarRequestInitiation =By.xpath("(//*[text()='1- Request Initiation'])[1]");
	public final static By ScreenBookRequestInitiation = By.xpath("(//*[text()='1 - Request Initiation'])[2]");
	public final static By AdhocScreenBookRequestInitiation = By.xpath("(//*[text()='1- Request Initiation'])[2]");
	public final static By TaskbarSelectDetails =By.xpath("//*[contains(text(),'Select Details')]");
	public final static By TaskbarSelectRefundDetails =By.xpath("//*[text()='2 - Select Refund Details']");
	public final static By TaskbarEditTransportationDetails = By.xpath("//*[contains(text(),'Edit Transportation Details')]");
	public final static By TaskbarAdditionalServices = By.xpath("(//*[contains(text(),'Additional Services')])[1]");
	public final static By ScreenAdditionalServices = By.xpath("(//*[contains(text(),'Additional Services')])[2]");
	public final static By TaskbarSelectNewBookingDetails =By.xpath("//*[contains(text(),'Select New Booking Details')]");
	public final static By TaskbarSelectProfile =By.xpath("//*[contains(text(),'Select Profile')]");
	public final static By TaskbarPaymentBreakdown =By.xpath("//*[contains(text(),'Payment Breakdown')]");
	public final static By ScreenFivestarConfirmation = By.xpath("(//*[text()='8 - Five Star Confirmation'])[2]");
	public final static By TaskbarFivestarConfirmation =By.xpath("(//*[text()='8 - Five Star Confirmation'])[1]");
	public final static By TaskVoidBooking=By.xpath("//*[text()='Void/Cancel']");
	public final static By TaskPastDateService=By.xpath("//*[text()='Past Date Service']");
	public final static By ScreenProceedToPay = By.xpath("(//*[text()='9 - Proceed to Pay'])[2]");
	public final static By TaskbarProceedToPay =By.xpath("(//*[text()='9 - Proceed to Pay'])[1]");
	public final static By TaskbarSelectRefund =By.xpath("(//*[text()='4 - Select Refunds'])[1]");
	public final static By TaskbarRefundBreakdown = By.xpath("(//*[contains(text(),'Refund Breakdown')])[1]");
	public final static By TaskbarPaymentSummary = By.xpath("//*[text()='6 - Payment Summary']");
	public final static By ProcessRefundButton = By.xpath("//*[text()='Process Refund']");
	public final static String PassengersTypeName = "_Adult_Child"; 
	public final static String ServiceDateName = "_Start_DtTime";
	public final static String PromoCodeName = "_Promo_Code";
	public final static String PromoCertName = "_Promo_Cert_Number";
	public final static By OverrideflagCheckBox = By.xpath("//*[@aria-label='Override Flag']");
	public final static By AddAditionalServiceCheckBox = By.xpath("//*[@aria-label='Add Additional Services']");
	public final static By SelectAdditionalServicesTabel = By.id("1_s_4_l_Select");
	public final static By AirportcodeAdditionalServicesTabel = By.id("1_s_4_l_Airport_Code");
	public final static By ServiceTypeAdditionalServicesTabel = By.id("1_s_4_l_Connection_Type");
	public final static By PricePerBookingAdditionalServicesTabel = By.id("1_s_4_l_Price_per_Booking");
	public final static By AdultPriceAdditionalServicesTabel = By.id("1_s_4_l_Adult_Price");
	public final static By ChildPriceAdditionalServicesTabel = By.id("1_s_4_l_Child_Price");
	
	
	public final static String AuthorizationName = "_AAKS_Auth_Name";
	public final static String AirportTableCheckBoxId = "_s_4_l_Checked";
	
	public final static By RefundableAmountTextBoxOverrideDetails = By.xpath("//*[@aria-label='Refundable Amount']");
	public final static By RefundAmountTextBoxRefundSummary = By.xpath("//*[@aria-label='Refund Amount']");
	public final static By TotalRefundableAmountRefundBreakdown = By.xpath("//*[@aria-label='Total Refundable Amount']");
	public final static By OverrideAmountTextBoxReadOnly = By.xpath("(//*[@aria-label='Override Amount'])[1]");
	public final static By TotalAmountTextBoxOverrideDetails = By.xpath("//*[@aria-label='Total Amount(New Booking)']");
	
	public final static By RequestNumberLink =By.name("Request");
	public final static By RequestDetailsApplet =By.xpath("//*[text()='AAKS Request Detail Applet']");
	public final static By SearchButtonAirportApplet =By.xpath("//*[@aria-label='Airport:Search']");
	public final static By GoButtonAirportApplet =By.xpath("//*[@aria-label='Airport:Go']");
	
	public final static By AirportCodeLabelAirportApplet =By.id("1_s_5_l_Airport_Code");
	public final static By TotalAirportPriceAirportApplet =By.id("1_s_5_l_Total_Airport_Price");
	
	public final static By SearchButtonPaymentApplet =By.xpath("//*[@aria-label='Payment:Search']");
	public final static By GoButtonPaymentApplet =By.xpath("//*[@aria-label='Payment:Go']");
	public final static By PaymentTypePaymentApplet =By.name("Payment_Type");
	public final static By PaymentRemarksPaymentApplet =By.id("1_s_2_l_Payment_Remarks");
	public final static String PaymentAmountPaymentApplet ="_s_2_l_Payment_Amount";
	public final static By TotalRefundAmountRefundBreakdown = By.xpath("//*[@aria-label='Total Refund Amount']");
	public final static By OutstandingAmountFivestarConfirmation = By.xpath("//*[@aria-label='Outstanding Amount']");
	public final static By OutstandingAmountSelectTransferRefund=By.xpath("//*[@aria-label='Outstanding Amt']");
	public final static By TimeDurationPaymentApplet =By.id("1_s_2_l_Txn_Duration");
	public final static By PrimaryFlagLabelPassengerWebtable =By.id("1_s_1_l_SSA_Primary_Field");
	public final static String PrimaryFlagLabelPassengerWebtableStr ="_l_SSA_Primary_Field";
	public final static String CKFlagLabelPassengerWebtableStr ="_s_2_l_CK_Flag";
	public final static By SelectLabelSelectRefunds =By.id("1_s_4_l_AAKS_Select_Transfer");
	public final static By TransferRefundsButton = By.xpath("//button[@aria-label='Transfer Refund']");
	public final static By TaskBarSelectTransferRefundProfile = By.xpath("//*[text()='5 - Select Transfer Refund Profile']");
//	public final static By FivestarSRdetailsTab =By.xpath("//*[text()='KeyStar SR Details']");
	
//	public final static By FivestarSRdetailsScreen =By.xpath("//*[text()='KeyStar Service Request List']");
	
	//public final static By SearchButtonSRdetails =By.xpath("//*[@aria-label='KeyStar Service Request List:Search']");
	
	public final static By AirportCodeLabelSRdetails =By.id("1_s_3_l_AAKS_Airport_Code");
	public final static By AirportCodeTextBoxSRdetails =By.name("AAKS_Airport_Code");
//	public final static By GoButtonSRdetails =By.xpath("//*[@aria-label='KeyStar Service Request List:Go']");
	
	public final static By SRNumber =By.id("1_s_3_l_SR_Number");
	
	public final static String SRNumberStr ="_s_3_l_SR_Number";
	public final static By SRStatus =By.id("1_s_3_l_Status");
	public final static String SRStatusStr ="_s_3_l_Status";
	public final static String SRCarCompany = "_s_3_l_AAKS_Limo_Car_Company";
	public final static String SRCarPhone = "_s_3_l_AAKS_Limo_Car_Company_Phone_";
	public final static String SRDriverName = "_s_3_l_AAKS_Limo_Driver_Name";
	public final static String SRDriverPhone = "_s_3_l_AAKS_Limo_Driver_Phone_";
	public final static String SRATOComments = "_s_3_l_ATO_Comments";
	
	
	
	
	//public final static By FivestarBookingTab = By.xpath("//*[text()='KeyStar Booking']");
	
	public final static By TaskLabel = By.xpath("//label[text()='Tasks']");
	public final static By TaskBookFivestar = By.xpath("//*[text()='Book KeyStar']");
	public final static By TaskRefundSummary = By.xpath("(//*[contains(text(),'Refund Summary')])[1]");
	public final static By TaskEditFivestar = By.xpath("//*[text()='Edit KeyStar']");
	public final static By TaskCancelFivestar = By.xpath("//*[text()='Cancel/Refund']");
	
	public final static By TaskCommentsRequests = By.xpath("//*[contains(text(),'Comments/Requests')]");
	public final static By TaskTransportationService = By.xpath("//*[contains(text(),'Transportation Service Details')]");
	public final static By BookingCommentsLabel = By.xpath("//*[text()='Booking Comments']");
	public final static By RequestAppletLabel = By.xpath("//*[text()='Requests']");
	public final static By NewRequestAppletLabel = By.xpath("//*[text()='New Request']");
	public final static String NewRequestAppletCheckBox = "_s_3_l_Checked";
	public final static By PNRTextBox = By.xpath("//*[@aria-label='PNR']");
	public final static By ReqNumberTextBoxReqInitiation = By.xpath("//*[@aria-label='Req #']");
	public final static By BookPriorityDropdownCommentsRequests = By.xpath("//*[@aria-label='Priority']");
	public final static By Comments1TextBoxCR=By.xpath("//*[@aria-label='Comments1']");
	public final static By Comments2TextBoxCR=By.xpath("//*[@aria-label='Comments2']");
	public final static By Comments3TextBoxCR=By.xpath("//*[@aria-label='Comments3']");
	public final static By Comments4TextBoxCR=By.xpath("//*[@aria-label='Comments4']");
	public final static By RelationshipGreetingCheckBoxCR=By.xpath("//*[@aria-label='Relationship Greeting']");
	public final static By MaasCheckBoxCR=By.xpath("//*[@aria-label='MAAS']");
	public final static By ElectricCartCheckBoxCR=By.xpath("//*[@aria-label='Electric Cart']");
	public final static By PreBoardCheckBoxCR=By.xpath("//*[@aria-label='Pre Board']");
	public final static By WheelchairCheckBoxCR=By.xpath("//*[@aria-label='Wheelchair']");
	public final static By ArmedCheckBoxCR=By.xpath("//*[@aria-label='Armed']");
	public final static By OAConnectionCheckBoxCR=By.xpath("//*[@aria-label='OA Connection']");
	public final static By OtherCheckBoxCR=By.xpath("//*[@aria-label='Other']");
	public final static By LanguageCheckBoxCR=By.xpath("//*[@aria-label='Language']");
	public final static By PetInCabinCheckBoxCR=By.xpath("//*[@aria-label='Pet In Cabin']");
	public final static By DepartureDayNameTextBoxCR=By.xpath("//*[@aria-label='Departure Day Name']");
	public final static By DepartureDayPhoneTextBoxCR=By.xpath("//*[@aria-label='Departure Day Phone #']");
	
	//public final static By FivestarBookingListLabel = By.xpath("//*[text()='KeyStar Booking List']");
	public final static By RadioButtonPhone = By.xpath("//*[@value='Phone']");
	public final static By RadioButtonConceirgeKey = By.xpath("//*[@value='ConciergeKey']");
	public final static By RadioButtonFiveStar = By.xpath("//*[@value='Five-Star']");
	public final static By RadioButtonCommercialCustomer = By.xpath("//*[@value='Commercial Customer']");
	public final static By RadioButtonOtherBooking = By.xpath("//*[@value='Other Request']");
	public final static By RadioButtonEmail = By.xpath("//*[@value='Email']");
	public final static By RadioButtonMODFIX = By.xpath("//*[@value='MOD Fix']");
	public final static By RadioButtonAgencyProfile = By.xpath("//*[@value='Agency Profile']");
	public final static By RadioButtonTransferRefund = By.xpath("//*[@value='Transfer Refunds']");
	
	public final static By RadioButtonAgencyId = By.xpath("(//table[@class='GridBack']/tbody/tr[11]/td[6]/div/input)[1]");
	public final static By AgencyIDTextBox = By.xpath("//*[@aria-label='Agency Id']");
	public final static By OverrideAmountEditableTextBox = By.xpath("(//*[@aria-label='Override Amount'])[2]");
	public final static By NextButtonBookRequestInitiation =By.xpath("//*[text()='Next']");
	public final static By PNRTextBoxSelectRefunds=By.xpath("//div[@id='s_S_A1_div']/form/div/span/div[2]/div/div/table/tbody/tr[4]/td[3]/div/input");
	public final static By BookingRefTextBoxSelectRefunds=By.xpath("//div[@id='s_S_A1_div']/form/div/span/div[2]/div/div/table/tbody/tr[4]/td[6]/div/input");
	public final static By SearchRefundsButton =By.xpath("//button[@title='Search Refund:Search Refunds']");
	public final static By ScreenSelectRefundLabel = By.xpath("(//*[text()='Search Refunds'])[1]");
	public final static By PassengersWebTable =By.xpath("//table[@summary='Passengers']");
	public final static By PassengersWebTableRow =By.xpath("//table[@summary='Passengers']/tbody/tr");
	public final static String PassengersWebTableRowStr ="//table[@summary='Passengers']/tbody/tr";
	public final static By LastNameLabel =By.id("1_s_1_l_Last_Name");
	public final static By LastNameTextBox =By.name("Last_Name");
	public final static By FirstNameLabel =By.id("1_s_1_l_First_Name");
	public final static By FirstNameTextBox =By.name("First_Name");
	public final static By PassengerTypeLabel =By.id("1_s_1_l_Adult_Child");
	public final static By PassengerTypeTextBox =By.name("Adult_Child");
	public final static By PrimaryFieldLabel =By.id("1_s_1_l_SSA_Primary_Field");
	
	public final static By TransportationServiceWebTableRow =By.xpath("//table[@summary='Transportation Service']/tbody/tr");
	public final static By AirportWebTableClass =By.xpath("(//div[@class='ui-jqgrid-bdiv'])[3]");
	public final static By AirportWebTableRow =By.xpath("//table[@summary='Airport']/tbody/tr");
	public final static String AirportWebTableRowStr ="//table[@summary='Airport']/tbody/tr";
	public final static By AirportWebTable =By.xpath("//table[@summary='Airport']");
	public final static By AirportCodeLabel =By.id("1_s_4_l_Airport_Code");
	public final static By AirportWebtableLabel =By.xpath("//*[text()='Airport']");
	public final static By AirportCodeTextBox =By.name("Airport_Code");
	public final static By ServiceTypeLabel =By.id("1_s_4_l_Type");
	public final static By ServiceTypeTextBox =By.name("Type");
	public final static By ClassOfServiceLabel =By.id("1_s_4_l_AAKS_Class_Of_Service");
	public final static By ClassOfServiceTextBox =By.name("AAKS_Class_Of_Service");
	public final static By OkButtonPromotion=By.xpath("//*[@aria-label='Promotions:OK']");
	public final static By SelectChekboxLabelAirportWebTable =By.xpath("//table[@summary='Airport']/tbody/tr[2]/td[1]");
	public final static By ServiceDateLabel =By.id("1_s_4_l_Start_DtTime");
	public final static By ServiceDateTextBox =By.name("Start_DtTime");
	public final static By PromocodeLabel =By.id("1_s_4_l_Promo_Code");
	public final static By PromocodeTextBox =By.name("Promo_Code");
	public final static By PromocertLabel =By.id("1_s_4_l_Promo_Cert_Number");
	public final static By PromocertTextBox =By.id("Promo_Cert_Number");
	public final static By SubmitButton =By.xpath("(//*[text()='Submit'])[2]");
	public final static By OverrideflagLabel =By.id("1_s_4_l_AAKS_Override_Flag");
	public final static String OverrideflagLabelNewAirport = "_s_3_l_AAKS_Override_Flag";
	public final static String AuthNameCheckBox = "_AAKS_Auth_Name";
	public final static String AuthNameNewAirport = "_s_3_l_AAKS_Auth_Name";
	public final static By AuthNameLabel =By.id("1_s_4_l_AAKS_Auth_Name");
	public final static By AuthNameTextBox =By.name("AAKS_Auth_Name");
	public final static By TaskbarEnterOverridedetails = By.xpath("//*[text()='4 - Enter Override Details']");
	
	//General
	public final static By SelectChekboxUnchecked =By.xpath("//input[@value='N' and @aria-checked='false']");
	//input[@aria-checked='false']
	public final static By SelectChekboxChecked =By.xpath("//input[@value='Y' and @aria-checked='true']");
	//Payment
	
	public final static By NetTotalPrice =By.xpath("//*[@aria-label='Net']");
	public final static By TransferRefundPNRAmount=By.id("1_s_4_l_Refund_Amount");
	public final static By NetAdultPrice =By.xpath("//*[@aria-label='Net Adult Price']");
	public final static By PromotionDiscount =By.xpath("//*[@aria-label='Promotion Discount']");
	public final static By AdditionalServiceDiscount =By.xpath("//*[@aria-label='Additional Services Total']");
	public final static By ProceedToPayButton =By.xpath("//*[text()='Proceed To Pay']");
	
	public final static By EmailAddressTextBox =By.xpath("//*[@aria-label='Email Address']");
	public final static By CallerName =By.xpath("//input[@aria-labelledby='AAKS_Caller_Name_Label']");
	public final static By CallerPhone =By.xpath("//input[@aria-labelledby='AAKS_Caller_Ph_Num_Label']");
	
	public final static By CompanyName =By.xpath("//*[@aria-label='Company Name']");
	public final static By CompanyPhone =By.xpath("//*[@aria-label='Company Phone #']");
	public final static By DepartmentName =By.xpath("//input[@aria-labelledby='AAKS_Day_Dept_Name_Label']");
	public final static By DepartmentPhone =By.xpath("//input[@aria-labelledby='AAKS_Day_Dept_Ph_Num_Label']");
	 
	public final static By Comments1 =By.xpath("//*[@aria-label='Comments1']");
	public final static By Comments2 =By.xpath("//*[@aria-label='Comments2']");
	public final static By Comments3 =By.xpath("//*[@aria-label='Comments3']");
	public final static By Comments4 =By.xpath("//*[@aria-label='Comments4']");
	
	public final static By CarCompanyLabel =By.id("1_s_7_l_Car_Company");
	public final static By CarCompanyTextBox =By.name("Car_Company");
	public final static By CarPhoneNoLabel =By.id("1_s_7_l_Car_Ph_No");
	public final static By CarPhoneNoTextBox =By.name("Car_Ph_No");
	public final static By DriverNameLabel =By.id("1_s_7_l_Driver_Name");
	public final static By DriverNameTextBox =By.name("Driver_Name");
	public final static By DriverPhoneNoLabel =By.id("1_s_7_l_Driver_Ph_No");
	public final static By DriverPhoneNoTextBox =By.name("Driver_Ph_No");
	public final static By CheckedBagsLabel =By.id("1_s_7_l___Checked_Bags");
	public final static By CheckedBagsTextBox =By.name("__Checked_Bags");
	public final static By ATOCommentsLabel =By.id("1_s_7_l_AAKS_Limo_Comments");
	public final static By ATOCommentsPopUpTextBox =By.xpath("//*[@id='DescBoxExpandTxtBox']");
	public final static By OKButtonOCItest =By.xpath("(//button[text()='OK'])[2]");
	public final static By OKButtontest3 =By.xpath("(//button/span[text()='OK'])[2]");
	public final static By ATOCommentsTextBox =By.name("AAKS_Limo_Comments");
	
	public final static By RequestNumber =By.xpath("//*[@aria-label='Request #']");
	public final static By BookingRefNumber = By.xpath("//*[@aria-label='Booking Ref Number']");
	public final static By CreditCardNumber =By.xpath("//*[@aria-label='CreditCardNumber']");
	public final static By CardHolderFirstName =By.xpath("//*[@aria-label='Card Holder First Name']");
	public final static By CardHolderLastName =By.xpath("//*[@aria-label='Card Holder Last Name']");
	public final static By ExpirationMonth =By.xpath("//*[@aria-label='Expiration Month']");
	public final static By ExpirationYear =By.xpath("//*[@aria-label='Expiration Year']");
	public final static By FinishButton =By.xpath("//*[@aria-label='Finish']");
	
	//Fivestar Booking List
	
	public final static By SearchButtonBookingList =By.xpath("//*[text()='Search']");
	public final static By ReqNumberLabel =By.id("1_s_1_l_Request");
	public final static By ReqNumberTextBox =By.name("Request");
	public final static By GoButtonBookingList =By.xpath("//*[text()='Go']");
	public final static By BookingStatus =By.id("1_s_1_l_Status");
	public final static By PaidAmount =By.id("1_s_1_l_Paid_Amt");
	
	/*public static final By FivestarSRdetailsTab =By.xpath("//*[text()='Five Star SR Details']");
	public static final By FivestarSRdetailsScreen =By.xpath("//*[text()='Five Star Service Request List']");
	public static final By SearchButtonSRdetails =By.xpath("//*[@aria-label='Five Star Service Request List:Search']");
	public static final By GoButtonSRdetails =By.xpath("//*[@aria-label='Five Star Service Request List:Go']");
	public static final By FivestarBookingTab = By.xpath("//*[text()='Five Star Booking']");
	
	*/
	
	public static final By FivestarBookingListLabelOCItest = By.xpath("//*[text()='Five Star Booking List']");
	public static final By FivestarBookingListLabeltest3 = By.xpath("//*[text()='KeyStar Booking List']");
	
	/*public static void HandleDifferentEnv()
	{
		if(properties.getProperty("ENV")=="OCI-MDEV")
		{
			final By FivestarSRdetailsTab =By.xpath("//*[text()='Five Star SR Details']");
			final By FivestarSRdetailsScreen =By.xpath("//*[text()='Five Star Service Request List']");
			final By SearchButtonSRdetails =By.xpath("//*[@aria-label='Five Star Service Request List:Search']");
			final By GoButtonSRdetails =By.xpath("//*[@aria-label='Five Star Service Request List:Go']");
			final By FivestarBookingTab = By.xpath("//*[text()='Five Star Booking']");
			final By FivestarBookingListLabel = By.xpath("//*[text()='Five Star Booking List']");
		}
		else
		{
			final By FivestarSRdetailsTab =By.xpath("//*[text()='KeyStar SR Details']");
			final By FivestarSRdetailsScreen =By.xpath("//*[text()='KeyStar Service Request List']");
			final By SearchButtonSRdetails =By.xpath("//*[@aria-label='KeyStar Service Request List:Search']");
			final By GoButtonSRdetails =By.xpath("//*[@aria-label='KeyStar Service Request List:Go']");
			final By FivestarBookingTab = By.xpath("//*[text()='KeyStar Booking']");
			
			final By FivestarBookingListLabel = By.xpath("//*[text()='KeyStar Booking List']");

		}
	}*/
}
