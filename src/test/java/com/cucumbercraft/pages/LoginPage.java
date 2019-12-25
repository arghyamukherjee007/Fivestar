package com.cucumbercraft.pages;

import org.openqa.selenium.By;

public class LoginPage {
	public final static By userName = By.name("userID");
	public final static By password = By.name("password");
	public final static By submitBtn = By.name("submitButton");
	public final static By SabreLoginLabel = By.xpath("//*[@aria-label='Sabre Login Selected']");
	public final static By SabreUserName = By.xpath("//*[@aria-label='Sabre Login']");
	public final static By SabrePassword = By.xpath("//*[@aria-label='Sabre Password']");
	public final static By SabreSubmit = By.xpath("//*[@title='Agent Sabre Login:Sabre Submit']");
	
	
	public final static By FivestarServiceRequestTab = By.xpath("//*[text()='Five Star Service Request']");
	public final static By FivestarRefundTab = By.xpath("//*[text()='Five Star Refund']");
	public final static By FivestarReportsTab = By.xpath("//*[text()='Five Star Reports']");
	public final static By HomeTab=By.xpath("//*[text()='Home']");
	public final static By Welcome=By.xpath("//*[@class='Welcome']");
	public final static By WelcomeOCI=By.xpath("//*[text()='Welcome Back']");
	public final static By WelcomeSiteMinder=By.xpath("//*[text()='Welcome']");
	public final static By TaskIcon = By.xpath("//*[@title='Tasks']");
	public final static By ApplicationMenuRightArrow = By.xpath("//*[@title='Application Menu']/a");
	public final static By File = By.xpath("//*[text()='File']");
	public final static By Logout = By.xpath("//*[text()='Log Out              [Ctrl+Shift+X]']");
			
			
			
}
