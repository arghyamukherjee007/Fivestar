package com.cucumbercraft.stepdefinitions;

public class CreditCard {

	public String testCase;
	public String OnewordId;
	public BillingInfo BillingInfo;
	public CreditCardProfile CreditCardProfile;
	
	public class BillingInfo{
		public String BillingState;
		public String BillingZipCode;
		public String BillingCountry;
	}
	
	public class CreditCardProfile{
		public String AADVNum;
		public String CardNum;
		public String CardHolderFirstName;
		public String CardHolderLastName;
		public String CCExpirationMonth;
		public String CCExpirationYear;
		public String BillingAddressLine1;
		public String BillingAddressLine2;
		public String BillingCity;
	}
}
