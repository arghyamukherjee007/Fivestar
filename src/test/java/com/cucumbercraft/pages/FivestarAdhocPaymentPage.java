package com.cucumbercraft.pages;

import org.openqa.selenium.By;

import com.cucumbercraft.stepdefinitions.MasterStepDefination;

public class FivestarAdhocPaymentPage extends MasterStepDefination {
	
	
	public final static By TaskAdhocPayment = By.xpath("//*[text()='Ad Hoc Payment']");
	
	public final static By RequestAdhocPayment = By.xpath("//*[@aria-label='5S Request #']");
	public final static By AirportCodeAdhocPayment = By.xpath("//*[@aria-label='Airport Code']");
	public final static By ServiceDateAdhocPayment = By.xpath("//*[@aria-label='Service Date']");
	public final static By AdultNoAdhocPayment = By.xpath("//*[@aria-label='Adult #']");
	public final static By ChildNoAdhocPayment = By.xpath("//*[@aria-label='Child #']");
	public final static By AdultNameAdhocPayment = By.xpath("//*[@aria-label='Adult Passenger Names']");
	public final static By ChildNameAdhocPayment = By.xpath("//*[@aria-label='Child Passenger Names']");
	public final static By AdhocPassengerOkButton = By.xpath("(//*[text()='OK'])[2]");
}
