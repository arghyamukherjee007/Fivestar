package com.cucumbercraft.pages;

import org.openqa.selenium.By;

import com.cucumbercraft.stepdefinitions.MasterStepDefination;

public class FivestarRefundPage extends MasterStepDefination {
public final static By SearchButtonFivestarRefund = By.xpath("//*[@aria-label='Refund List:Search']");
public final static By RefundStatusLabelFivestarRefund = By.id("1_s_3_l_Refund_Status");
public final static By RefundAmountLabelFivestarRefund = By.id("1_s_3_l_Refund_Amount");
public final static By BookingRefLabelFivestarRefund = By.id("1_s_3_l_Booking_Ref_Num");
public final static By BookingRefTextBoxFivestarRefund = By.name("Booking_Ref_Num");
public final static By RefundStatusTextBoxFivestarRefund = By.name("Refund_Status");
public final static By GoButtonFivestarRefund = By.xpath("//*[@aria-label='Refund List:Go']");
public final static By BookingRefFivestarRefund = By.id("1_s_3_l_Booking_Ref_Num");
public final static By RefundAmountFivestarRefund = By.id("1_s_3_l_Refund_Amount");
public final static By PNRFivestarRefund = By.id("1_s_3_l_AAKS_PNR");


}
