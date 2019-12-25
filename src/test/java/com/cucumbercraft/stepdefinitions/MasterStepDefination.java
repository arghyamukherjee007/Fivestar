package com.cucumbercraft.stepdefinitions;

import static com.cucumbercraft.stepdefinitions.CommonMethods.getBookFivestarData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumbercraft.framework.APIReusuableLibrary;
import com.cucumbercraft.framework.Browser;
import com.cucumbercraft.framework.DriverFactory;
import com.cucumbercraft.framework.ExecutionMode;
import com.cucumbercraft.framework.HeadersForAPI;
import com.cucumbercraft.framework.WebDriverFactory;

import cucumber.api.Scenario;

public class MasterStepDefination {
	static Logger log = Logger.getLogger(DriverFactory.class);
	protected static WebDriver driver;
	protected static Scenario currentScenario;
	protected static Properties properties;
	protected APIReusuableLibrary apiDriver = new APIReusuableLibrary();
	protected HeadersForAPI headers = new HeadersForAPI();
	protected static String propertyFilePath=System.getProperty("user.dir")+"\\src\\test\\resources\\Global Settings.properties";
	static boolean launchflag = false;
	public static String Env ;
	public static String EnvUrl;
	public static String currrentWinHandle;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	public String testName;
	public String TestFilePath;

	
	private static HttpURLConnection httpURLConnect;
	int responseStatus;
	int responseCode;

	Scenario scenario;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void printToTxt(String pnrResp, String testCaseID){

		String idForTxtFile = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date());
		File file = new File("./src/test/resources/PnrReqRespLogs/" +testCaseID+"_" + idForTxtFile+".txt");

		try {
		  FileWriter fw = new FileWriter(file, true);
		  fw.write(pnrResp);
		  fw.flush();
		  fw.close();
		} catch (IOException e) {
		  e.printStackTrace();
		  System.out.println(e.getMessage());
		}
	}
	
   public String getTestName() {
		
      	scenario = currentScenario;
        String featureName = scenario.getId();
        String[] TC_ID = featureName.split(":");
        testName = TC_ID[1].replace("-", "_");
        testName = testName.toUpperCase().trim();
        
        return testName;
        
	}
	

    public static void LoadPropertiesFile() throws Exception
    {
    	BufferedReader reader=null;
		
		reader=new BufferedReader(new FileReader(propertyFilePath));
		properties=new Properties();
		properties.load(reader);
		reader.close();
    }
	public String findDate(String day) {
		
		String newDate;
		LocalDate today = LocalDate.now();
		if (!(day.equalsIgnoreCase("Today"))) {
			int dayCount = Integer.parseInt(StringUtils.substringAfter(day, "Today"));
			newDate = today.plus(dayCount, ChronoUnit.DAYS).toString();
		} else {
			newDate = today.toString();
		}
		System.out.println("Date is : "+newDate);
		return newDate;
	}
	
}