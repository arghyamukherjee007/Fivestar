package com.cucumbercraft.stepdefinitions;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import com.cucumbercraft.framework.Browser;
import com.cucumbercraft.framework.WebDriverFactory;
import com.cucumbercraft.pages.LoginPage;
import com.cucumbercraft.pages.Variables;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class GeneralStepDefination extends MasterStepDefination {
	
	//WebDriver driver = new ChromeDriver();
	
	

	@Given("^Initiate a \"([^\"]*)\" for (.+)$")
    public void initiate_a_something_for(String Flowtype, String testcase) throws Throwable {
		Variables.InitializeValue(Flowtype, testcase);
		
    }

	
	@Given("^User is on the login page of the application$")
    public void user_is_on_the_login_page_of_the_application() throws Throwable {
		 	LoadPropertiesFile();
		 	Env = properties.getProperty("ENV");
		 	driver = WebDriverFactory.getWebDriver(Browser.CHROME);
			
			setDriver(driver);
		 	setURLForDifferentEnvironment();
			driver.get(EnvUrl);
			driver.manage().window().maximize();
			try
			{
				//driver.navigate().to("javascript:document.getElementById('overridelink').click()");	
			}
			catch(Exception e)
			{
				
			}
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.attributeContains(LoginPage.WelcomeSiteMinder, "class", "welcome"));
			
			//currentScenario.embed(Util.takeScreenshot(driver), "image/png");
			assertTrue(driver.getTitle().contains("American Airlines - Login") || driver.getTitle().contains("Sign-on"));
		
	    }
	 @Then("^Logout and Close The Browser$")
	    public void close_the_browser() throws Throwable {
		    LoginStepDefinarion.LogoutFormApplication();
		    LoginStepDefinarion.CloseBrowser();
	        
	    }
	
	public void setURLForDifferentEnvironment() {
		switch (Env.toUpperCase()) {
			case "TEST":
				EnvUrl = properties.getProperty("ApplicationUrlTestEnv");
				break;
			case "STAGE":
				EnvUrl = properties.getProperty("ApplicationUrlStageEnv");
				break;
			case "OCI-MDEV":
				EnvUrl = properties.getProperty("ApplicationUrlOCIMDevEnv");
				break;
		}
	}
	
}
