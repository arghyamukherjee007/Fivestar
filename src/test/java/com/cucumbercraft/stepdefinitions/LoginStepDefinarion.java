package com.cucumbercraft.stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.Util;
import com.cucumbercraft.pages.FivestarBookingPage;
import com.cucumbercraft.pages.LoginPage;
import com.cucumber.listener.Reporter;



import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginStepDefinarion extends MasterStepDefination {
	
	static Logger log = Logger.getLogger(LoginStepDefinarion.class);
	
	public static String Env = properties.getProperty("ENV");
	public static String userName,password;
	WebDriverWait wait = new WebDriverWait(driver, 90);
	

	 @Given("^User login using the valid user credentials$")
	    public void i_login_using_the_valid_user_credentials() throws Throwable {
		 setCredentialsForDifferentEnvironment();
		 driver.findElement(LoginPage.userName).sendKeys(userName);
			driver.findElement(LoginPage.password).sendKeys(password);
			Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
			//currentScenario.embed(Util.takeScreenshot(driver), "siteminderLogin/png");
			driver.findElement(By.name("submitButton")).click();
			Thread.sleep(20000);
			WebDriverWait wait = new WebDriverWait(driver, 180);
			if(properties.getProperty("ENV").equalsIgnoreCase("TEST"))
			{
				wait.until(ExpectedConditions.attributeContains(LoginPage.Welcome, "class", "Welcome"));
			}
			else
			{
				wait.until(ExpectedConditions.attributeContains(LoginPage.WelcomeOCI, "class", "siebui-salutation-applet-title"));
				
			}
	
			
	    }

	    @And("^User login using Sabre Credentials$")
	    public void i_login_using_sabre_credentials() throws Throwable {
	    	LoadPropertiesFile();
	    	userName = properties.getProperty("UserNameSabre");
			password = properties.getProperty("PasswordSabre");
			
			driver.findElement(LoginPage.SabreLoginLabel).click();
			Thread.sleep(5000);
		
			driver.findElement(LoginPage.SabreUserName).sendKeys(userName);
			driver.findElement(LoginPage.SabrePassword).sendKeys(password);
			Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
			
			driver.findElement(LoginPage.SabreSubmit).click();
			
		
			
			if(properties.getProperty("ENV").equalsIgnoreCase("TEST"))
			{
				wait.until(ExpectedConditions.attributeContains(FivestarBookingPage.FivestarBookingListLabeltest3, "class", "siebui-applet-title"));
				  
			}
			else
			{
				wait.until(ExpectedConditions.attributeContains(FivestarBookingPage.FivestarBookingListLabelOCItest, "class", "siebui-applet-title"));
				
			}
		
			driver.findElement(LoginPage.TaskIcon).click();
			Thread.sleep(2000);
		
	       }

	    public static void setCredentialsForDifferentEnvironment() {
			if (Env.equalsIgnoreCase("TEST")) {
				userName = properties.getProperty("UserNameTestEnv");
				password = properties.getProperty("PasswordTestEnv");
			} else if (Env.equalsIgnoreCase("STAGE")) {
				userName = properties.getProperty("UserNameStageEnv");
				password = properties.getProperty("PasswordStageEnv");
			} else if (Env.equalsIgnoreCase("OCI-MDEV")) {
				userName = properties.getProperty("UserNameOCIMDevEnv");
				password = properties.getProperty("PasswordOCIMDevEnv");
			}
	    }

			public static void LogoutFormApplication() throws Exception
			{
				driver.findElement(LoginPage.ApplicationMenuRightArrow).click();
				Thread.sleep(2000);
				driver.findElement(LoginPage.File).click();
				Thread.sleep(2000);
				Reporter.addScreenCaptureFromPath(Util.takeScreenshotFile(driver));
				
				driver.findElement(LoginPage.Logout).click();
				Thread.sleep(2000);
			}
			
			public static void CloseBrowser()
			{
				driver.close();
		       // driver.quit();
			}
		

}
