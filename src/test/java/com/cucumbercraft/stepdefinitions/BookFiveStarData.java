package com.cucumbercraft.stepdefinitions;


public class BookFiveStarData {
	public String testCase;
	public CERT CERT;
	public TSTS TSTS;
	public PreConditions preConditions;
	public Airport Airport;
	public RequestInitiation RequestInitiation;
	public PassengerDetails PassengerDetails;
	public Primary primary;
	public Payment Payment;
	public Email Email;
	public CreditCard creditCard;
	public TransferRefund TransferRefund;
	public ConceirgeKey ConceirgeKey;

	public Scenario1 Scenario1;
	public Promotions Promotions;
	public AdditionalServices AdditionalServices;
	
	public class AdditionalServices{
		public String AirportCode;
		public String ServiceType;
		public String PriceperBooking;
		public String AdultPrice;
		public String ChildPrice;
		public String TotalAdditionalServices;
	}
	
	public class Promotions{
		public String Discountdoller;
		public String Discountpercent;
	}
	public class CERT{
		public String pnrNumber;
		public String RequestNo;
		public String SRNumber;
	}
	public class TSTS{
		public String pnrNumber;
		public String RequestNo;
		public String SRNumber;
	}
	
	public class ConceirgeKey{
		public String CKFlag;
		public String BookPriority;
	}
	
	public class PreConditions {
		public String data;
		public String duration;
		public String tier;
		public String status;
		public String scenario;
		public String spouseData;
		public String spouseTier;
		public String paymentMode;
		public String autoRenew;
		public String twa;
		public String category;
	}
	public class Scenario1
	{
		public String RequestNo;
		public String AirportCode;
		public String timetoSet;
		public String AdultNo;
		public String ChildNo;
		public String AdultNames;
		public String ChildNames;
	}
	
	public class Email
	{
		public String EmailAddress;
		public String EmailCheckBox;
	}
	public class PassengerDetails{
		public String LastName;
		public String FirstName;
		public String PrimFlag;
		public String PsngrType;
	}
	public class RequestInitiation {
		public String ReqSource;
		public String BookingType;
		public String FivestarBookingStatus;
	}
	public class Airport {
		public String AirportCode;
		public String AirportPrice;
		public String SRBookingStatus;
		public String StartDay;
		public String StartTime_Airportcode;
		public String EndTime_AirportCode;
		public String CallFlag;
		public String ServiceType;
		public String DateInterval;
		public String TimeInterval;
		public String PromoCertificateID;
		public String Promocode;
		public String selectadd;
		public String Classofservice;
		public String OutboundorInbound;
		
		
	}
	public class Primary {
		public String aadv;
		public String firstName;
		public String lastName;
		public String ArrCity;
		public String depCity;
		public String flightNumb;
		public String DepDate;
		public String ArrDate;
		
		
	}
	
	public class Payment {
		public String NetTotalAmt;
		public String OutStandingAmt;
		public String ChildPrice;
		public String AdultPrice;
		public String PromoDiscount;
		
		
		
	}

	
	
	public class CreditCard {
		public String cardType;
		public String cardNumber;
		public String autoRenew;
		public String CardFirstName;
		public String CardLastName;
		public String CardNumber;
		public String CardExpMonth;
		public String CardExpYear;
		public String ProfileId;
	}
    public class TransferRefund{
    	public String Refundpnr;
		public String RefundReqNo;
		public String RefundAmt;
    }
}
