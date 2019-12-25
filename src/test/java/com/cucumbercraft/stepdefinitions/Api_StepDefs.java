package com.cucumbercraft.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.json.simple.JSONObject;

import com.cucumber.listener.Reporter;
import com.cucumbercraft.framework.Util;
import com.cucumbercraft.framework.APIReusuableLibrary.ASSERT_RESPONSE;
import com.cucumbercraft.framework.APIReusuableLibrary.COMPARISON;
import com.cucumbercraft.framework.APIReusuableLibrary.SERVICEFORMAT;
import com.cucumbercraft.framework.APIReusuableLibrary.SERVICEMETHOD;
//import com.cucumbercraft.pages.ApiFunctions;
//import com.cucumbercraft.pages.PNRCreationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;

public class Api_StepDefs extends MasterStepDefination {

	ValidatableResponse response;
	Map<String, String> headersMap;
	String postBodyContentFlightDelay =null, postBodyContentFlightCancel = null;
	String postBodyContentPNRCreation = null;
	String postBodyContentPNRAddition = null;
	String postBodyContentPNRRemarkUpdate = null;
	String flightDelayResponse;
	String endPoint;
	String respXML = null;

	LocalDate today = LocalDate.now();
	LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
	String dateToday = today.toString();
	String dateTmrw = tomorrow.toString();
	BookFiveStarData BookFivestardata;
	public String airlineCode;
	
	//ApiFunctions apifunctions = new ApiFunctions();
	
	@Given("^the required inputs are ready to \"([^\"]*)\" flight$")
	public void the_required_inputs_are_ready_to_flight(String servAction) throws Throwable {
		headersMap = headers.getHeaders2();
		
		if (servAction.equalsIgnoreCase("Delay")) {		
			postBodyContentFlightDelay = apiDriver.readInput(properties.getProperty("FlightDelayInputTemplate"));
		} else if ((servAction.equalsIgnoreCase("Divert")) ||(servAction.equalsIgnoreCase("Cancel")) || (servAction.equalsIgnoreCase("Reset")) || (servAction.equalsIgnoreCase("GINT")) ) {
			postBodyContentFlightCancel = apiDriver.readInput(properties.getProperty("FlightCancelTemplate"));
		} else if ((servAction.equalsIgnoreCase("AIRINT")) || (servAction.equalsIgnoreCase("OFF")) || (servAction.equalsIgnoreCase("ResetAirint"))) {
			postBodyContentFlightCancel = apiDriver.readInput(properties.getProperty("FlightAIRINTTemplate"));
		} else if (servAction.equalsIgnoreCase("Delay2")) {
			postBodyContentFlightDelay = apiDriver.readInput(properties.getProperty("FlightDelayInput2Template"));
		} else if (servAction.equalsIgnoreCase("ResetOA")) {
			postBodyContentFlightCancel = apiDriver.readInput(properties.getProperty("FlightCancelInput2Template"));
		}
	}

    @When("^user post service request to delay flight \"([^\"]*)\" on \"([^\"]*)\" by \"([^\"]*)\" minutes$")
    public void user_post_service_request_to_delay_flight_on_by_minutes(String flightID, String delayType, String delayTime) throws Throwable {
    	//	String flightNumb = getAirportFlightData(flightID);
    	
		if (!(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("Test"))) {
			endPoint = properties.getProperty("AirlinesUpdate_Endpoint_Stage");
		}else {
			endPoint = properties.getProperty("AirlinesUpdate_Endpoint_Test");
		}

	//	postBodyContentFlightDelay = apiDriver.updateContent(postBodyContentFlightDelay, "flight_numb", flightNumb);
		
		postBodyContentFlightDelay = apiDriver.updateContent(postBodyContentFlightDelay, "date_today", dateToday);
		postBodyContentFlightDelay = apiDriver.updateContent(postBodyContentFlightDelay, "date_tomrw", dateTmrw);
		
	//postBodyContentFlightDelay = apifunctions.updateFlightDelay(delayType, delayTime, flightNumb, postBodyContentFlightDelay);
		
		System.out.println("Flight Delay Request is: "+postBodyContentFlightDelay);
		
		response = apiDriver.sendNReceive(endPoint, SERVICEMETHOD.POST, SERVICEFORMAT.XML, postBodyContentFlightDelay, headersMap, 200);
		response = apiDriver.sendNReceive(endPoint, SERVICEMETHOD.POST, SERVICEFORMAT.XML, postBodyContentFlightDelay, headersMap, 200);

	}

	@Then("^user should get success response$")
	public void user_should_get_success_response() throws Throwable {

		flightDelayResponse = apiDriver.extractValue(response, "//Status");
		apiDriver.assertIt(endPoint, response, ASSERT_RESPONSE.TAG, "//Status/text()", "Success",
				COMPARISON.IS_EQUALS);

	}

	
	 @Given("^the required inputs below for \"([^\"]*)\" PNR Creation for (.+)$")
	 public void the_required_inputs_below_for_something_pnr_creation_for(String pnrType,String testcase) throws Throwable {
	   BookFivestardata = CommonMethods.getBookFivestarData(testcase);
		
		
	  if (properties.getProperty("RunSuiteWithNewData").equalsIgnoreCase("True")) {
    		
    		//clearTestDataRow(sheetName, testName);
    		
    		String[] psngrFName = BookFivestardata.primary.firstName.split(",");
    		String[] psngrLName = BookFivestardata.primary.lastName.split(",");
    		String[] aadv = BookFivestardata.primary.aadv.split(",");
    		
    		String[] arrCity = BookFivestardata.primary.ArrCity.split(",");
    		String[] depCity = BookFivestardata.primary.depCity.split(",");
    		String[] flightNumb = BookFivestardata.primary.flightNumb.split(",");
			String[] depDate = BookFivestardata.primary.DepDate.split(",");
			String[] arrDate = BookFivestardata.primary.ArrDate.split(",");
    		
			headersMap = headers.getHeaders5();
			
		//	airlineCode = pnrCreationData1.get("AirlineCode");
			if (pnrType.contentEquals("1Pax1Seg")) {
			postBodyContentPNRCreation = apiDriver.readInput(properties.getProperty("PNRCreation1Pax1SegTemplate"));
			} else if (pnrType.contentEquals("2Pax2Seg")) {
				postBodyContentPNRCreation = apiDriver.readInput(properties.getProperty("PNRCreation2Pax2SegTemplate"));
			}else if (pnrType.contentEquals("1Pax2Seg")) {
				postBodyContentPNRCreation = apiDriver.readInput(properties.getProperty("PNRCreation1Pax2SegTemplate"));
			}else if (pnrType.contentEquals("2Pax1Seg")) {
				postBodyContentPNRCreation = apiDriver.readInput(properties.getProperty("PNRCreation2Pax1SegTemplate"));
			}else if (pnrType.contentEquals("1Pax2SegOA")) {
				postBodyContentPNRCreation = apiDriver.readInput(properties.getProperty("PNRCreation1Pax2SegTemplateOA"));
			}else if (pnrType.contentEquals("1Pax3Seg")) {
				postBodyContentPNRCreation = apiDriver.readInput(properties.getProperty("PNRCreation1Pax3SegTemplate"));
			}
			
			
			postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "sabre_userId", properties.getProperty("UserNameSabre"));
			if (properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("TEST") ) {
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "envSabre", "TSTS");
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "sabrePwd", properties.getProperty("PasswordSabre"));
		   	} else {
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "envSabre", "CERT");
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "sabrePwd", properties.getProperty("PasswordSabre"));
		   	}
		   	
			postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "psngr1_fname", psngrFName[0]);
			postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "psngr1_lname", psngrLName[0]);
			
			if (BookFivestardata.primary.aadv.equalsIgnoreCase("NA")) {
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "aadv1", "");
			} else {
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "aadv1", aadv[0]);
				
			}
			
			if (depDate[0].equalsIgnoreCase("Today")) {
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_date1",  dateToday);
			
			} else if (depDate[0].contains("Today+")) {
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_date1", findDate(depDate[0]));
			}
			
			if (arrDate[0].equalsIgnoreCase("Today")) {
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_date1", dateToday);
			
			} else if (arrDate[0].contains("Today+")) {
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_date1", findDate(arrDate[0]));
			}

			postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_station1", arrCity[0]);
			postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_station1", depCity[0]);
			postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "flight_numb1", flightNumb[0]);
			
			if (pnrType.contains("2Pax")) {
				 
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "psngr2_fname", psngrFName[1]);
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "psngr2_lname", psngrLName[1]);
				
				
				if (aadv[1].equalsIgnoreCase("NA")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "aadv2", "");
				} else {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "aadv2", aadv[1]);
					
				}
			}
			if (pnrType.contains("2Seg") || pnrType.contains("3Seg")) {

				if (depDate[1].equalsIgnoreCase("Today")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_date2", dateToday);

				} else if (depDate[1].contains("Today+")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_date2", findDate(depDate[1]));
				}

				if (arrDate[1].equalsIgnoreCase("Today")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_date2", dateToday);

				} else if (arrDate[1].contains("Today+")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_date2", findDate(arrDate[1]));
				}

				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_station2", arrCity[1]);
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_station2", depCity[1]);
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "flight_numb2", flightNumb[1]);
			}
			if (pnrType.contains("3Seg")) {

				if (depDate[2].equalsIgnoreCase("Today")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_date3",  dateToday);

				} else if (depDate[2].contains("Today+")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_date3", findDate(depDate[2]));
				}

				if (arrDate[2].equalsIgnoreCase("Today")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_date3", dateToday);

				} else if (arrDate[2].contains("Today+")) {
					postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_date3", findDate(arrDate[2]));
				}
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "arr_station3", arrCity[2]);
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "dep_station3", depCity[2]);
				postBodyContentPNRCreation = apiDriver.updateContent(postBodyContentPNRCreation, "flight_numb3", flightNumb[2]);
			}
			
			System.out.println("Soap request is: "+postBodyContentPNRCreation);
			String pnrInputData = "<style>table {border-collapse !important  }td {border: 1px solid black !important;  white-space: normal; !important;}</style>"
			+ "<table><tr><td><b>PAX LAST NAME</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.lastName + "</td></tr>"
			+ "<tr><td><b>PAX FIRST NAME</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.firstName + "</td></tr>"
			+ "<tr><td><b>AADV</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.aadv + "</td></tr>"
			+ "<tr><td><b>DEP CITY</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.depCity + "</td></tr>"
			+ "<tr><td><b>ARR CITY</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.ArrCity + "</td></tr>"
			+ "<tr><td><b>DEP DATE</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.DepDate + "</td></tr>"
			+ "<tr><td><b>FLIGHT NUMBER</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><font color=green>"
			+ BookFivestardata.primary.flightNumb + "</font></td></tr></table>";
			
			//scenario.embed(pnrInputData.getBytes(), "text/html");
			Reporter.addStepLog(
					"<style>table {border-collapse !important  }td {border: 1px solid black !important;  white-space: normal; !important;}</style>"
						+ "<table><tr><td><b>PSNGR LAST NAME</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.lastName + "</td></tr>"
						+ "<tr><td><b>PSNGR FIRST NAME</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.firstName + "</td></tr>"
						+ "<tr><td><b>AADV</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.aadv + "</td></tr>"
						+ "<tr><td><b>DEP CITY</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.depCity + "</td></tr>"
						+ "<tr><td><b>ARR CITY</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.ArrCity + "</td></tr>"
						+ "<tr><td><b>DEP DATE</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>" + BookFivestardata.primary.DepDate + "</td></tr>"
						+ "<tr><td><b>FLIGHT NUMBER</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><font color=green>"
						+ BookFivestardata.primary.flightNumb + "</font></td></tr></table>");
			
    	}
    }

    @When("^user post the service request to create \"([^\"]*)\"$")
    public void user_post_the_service_request_to_create_something(String pnrID) throws Throwable { 
    	
    	try{
	    	if (properties.getProperty("RunSuiteWithNewData").equalsIgnoreCase("True")) {
		    		
	    		endPoint = properties.getProperty("PNRCreation_Endpoint");
		    	response = apiDriver.sendNReceive(endPoint, SERVICEMETHOD.POST, SERVICEFORMAT.XML, postBodyContentPNRCreation, headersMap, 200);
		    	respXML = response.extract().asString();
		    	//System.out.println("Soap response is: "+respXML);
	    	}
    	} catch (Exception e) {
    		assertTrue(false, "Failure to POST the PNR Creation Request. "+e.getMessage());
    	}

    }
    @SuppressWarnings("unchecked")
	@Then("^response should contain \"([^\"]*)\" data for (.+)$")
    public void response_should_contain_something_data_for(String pnrID, String testcase) throws Throwable {
    	String pnr = null;
    	
    	try {
    		
	    	if (properties.getProperty("RunSuiteWithNewData").equalsIgnoreCase("True") ) {
	    		
	    		pnr = StringUtils.substringBetween(respXML, "<a:PNR>", "</a:PNR>");
	    		Date today1 = new Date();
    			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMMyy");
    		    String traveldate = DATE_FORMAT.format(today1);
    		    traveldate=StringUtils.upperCase(traveldate);
    		    System.out.println(traveldate);
	    		if (pnr==null) {
	    			
	    			pnr = StringUtils.substringBetween(respXML, traveldate, "</a:Response>");
	    			pnr = StringUtils.strip(pnr);
	    		}
                if (pnr==null || pnr.isEmpty()) {
                    if (respXML.contains(traveldate)) {
                           String [] resp1=respXML.split(traveldate);
                           pnr = resp1[2].trim().substring(0, 6);
                           System.out.println("PNR created from Exceptional Case is : "+pnr);
                    }
                } 
                
                if (pnr==null || pnr.isEmpty()) {
                      System.out.println("***Could not find PNR from SOAP Response. Please check PNR generation Request*** ");
                      Reporter.addStepLog("***Could not find PNR from SOAP Response. Please check PNR generation Request*** ");
                      
                }

	    		System.out.println("Response is: "+respXML);
		    	System.out.println("PNR created from Service Call is : "+pnr);
				 
				 if (!(pnr.isEmpty() && !(pnr==null))) {
					 
					 if (pnrID.equalsIgnoreCase("PNR")) { 
						// JSONObject Fivestardetails = new JSONObject();
						 //Fivestardetails.put("pnrNumber", pnr);
							
						 CommonMethods.SetFivestarData("pnr",pnr,BookFivestardata.testCase);
					 }
				 assertTrue(true, "PNR Created succesfully"); 
				 }else {
					 printToTxt(respXML, testcase);
					 assertTrue(false, "Failed to create PNR Created through Service Call"); 
				 }
	    	}
    	} catch (Exception e){
			Reporter.addStepLog("PNR is not generated or Failed to retrive PNR value from Service Call response. "+e.getMessage()); 
			printToTxt(respXML, testcase);
			assertTrue(false, "PNR is not generated or Failed to retrive PNR value from Service Call response. "+e.getMessage());
    	}
    }

    
    @Then("^user post the service request to \"([^\"]*)\" flight \"([^\"]*)\"$")
    public void user_post_the_service_request_to_flight(String servAction, String flightID) throws Throwable {
    	
    /*	String flightNumb=null;
    	if (!(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("Test"))) {
			endPoint = properties.getProperty("AirlinesUpdate_Endpoint_Stage");
		}else {
			endPoint = properties.getProperty("AirlinesUpdate_Endpoint_Test");
		}
    	
   		flightNumb = getAirportFlightData(flightID);

		postBodyContentFlightCancel = apiDriver.updateContent(postBodyContentFlightCancel, "flight_numb", flightNumb);
		postBodyContentFlightCancel = apiDriver.updateContent(postBodyContentFlightCancel, "date_today", dateToday);
		postBodyContentFlightCancel = apiDriver.updateContent(postBodyContentFlightCancel, "date_tomrw", dateTmrw);
				
		postBodyContentFlightCancel = apifunctions.updateFlightStatus(servAction, flightNumb, postBodyContentFlightCancel);
		
		System.out.println("Request Body is: "+postBodyContentFlightCancel);
		response = apiDriver.sendNReceive(endPoint, SERVICEMETHOD.POST, SERVICEFORMAT.XML, postBodyContentFlightCancel, headersMap, 200);
		response = apiDriver.sendNReceive(endPoint, SERVICEMETHOD.POST, SERVICEFORMAT.XML, postBodyContentFlightCancel, headersMap, 200);*/

    }



    @Given("^the required inputs below for PNR \"([^\"]*)\"$")
    public void the_required_inputs_below_for_pnr_something(String segType, DataTable segmentCreationData) throws Throwable {
    /*	List<Map<String, String>> segmentCreation = segmentCreationData.asMaps(String.class, String.class);
		Map<String, String> segmentCreationData1 = segmentCreation.get(0);
		
		String traveldate = null;
		Date today1 = new Date();
		System.out.println("Date is: "+today1);
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMM");
		
    	if (properties.getProperty("RunSuiteWithNewData").equalsIgnoreCase("True") && readFromExcel(sheetName, "RunTCWithNewData", testName).equalsIgnoreCase("Yes")) {
    		
    		clearTestDataRow(sheetName, testName);
    		 		
			headersMap = headers.getHeaders6();
			postBodyContentPNRAddition = apiDriver.readInput(properties.getProperty("PNRAddSegmentInputTemplate"));
			
		    postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "sabre_userId", properties.getProperty("spotUsername"));
			if (properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("TEST") ) {
				postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "envSabre", "TSTS");
				postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "sabrePwd", properties.getProperty("pwdTSTS"));
		   	} else {
		   		postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "envSabre", "CERT");
		   		postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "sabrePwd", properties.getProperty("pwdCERT"));
		   	}
    					
			String[] PNR = readFromExcel(sheetName, "PNR1", testName).split(",");
			String[] noofpax = readFromExcel(sheetName, "NoOfPsngr", testName).split(",");
			String[] flightno = readFromExcel(sheetName, "flightNumb2", testName).split(",");
			
		    postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "PNR", PNR[0]);
			
			if(segType.toLowerCase().contentEquals("segment_removal_x1")) {
			
				postBodyContentPNRAddition = postBodyContentPNRAddition.replaceAll("0%%flight_no%%Y%%date%%%%depstation%%%%arrstation%%NN%%pax%%", "X1");
			
			} else if(segType.toLowerCase().contentEquals("segment_removal_x2")) {
			
				postBodyContentPNRAddition = postBodyContentPNRAddition.replaceAll("0%%flight_no%%Y%%date%%%%depstation%%%%arrstation%%NN%%pax%%", "X2");
			
			} else {
				
				postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "pax", noofpax[0]);
				postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "flight_no", flightno[0]);
			}
			
			if (segType.toLowerCase().contentEquals("segment_addition")) {
				
				String arrCity = segmentCreationData1.get("ArrCity");
				String depCity = segmentCreationData1.get("DepCity");
				String depDate = segmentCreationData1.get("DepDate");
				
				postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "arrstation", arrCity);
				postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "depstation", depCity);
				
				if (depDate.equalsIgnoreCase("Today")) {
				    traveldate = DATE_FORMAT.format(today1);
				
				} else if (depDate.contains("Today+")) {
					
					int dayCount = Integer.parseInt(StringUtils.substringAfter(depDate, "Today"));
					Date today = new Date();               
					SimpleDateFormat formattedDate = new SimpleDateFormat("ddMMM");            
					Calendar c = Calendar.getInstance();        
					c.add(Calendar.DATE, dayCount);       
					traveldate = (String)(formattedDate.format(c.getTime())).toUpperCase();
				
				}

				postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "date", traveldate);
				
			} else if (segType.toLowerCase().contentEquals("protecting_segment_addition")) {
					
					String[] arrCity = readFromExcel(sheetName, "ArrCity", testName).split(",");
		    		String[] depCity = readFromExcel(sheetName, "depCity", testName).split(",");
		    		//traveldate = DATE_FORMAT.format(today1);
		    		
		    		String[] depDate = readFromExcel(sheetName, "DepDate", testName).split(",");
					if (depDate[0].trim().equalsIgnoreCase("Today")) {
					    traveldate = DATE_FORMAT.format(today1);
					
					} else if (depDate[0].trim().contains("Today+")) {
						
						int dayCount = Integer.parseInt(StringUtils.substringAfter(depDate[0], "Today"));
						Date today = new Date();               
						SimpleDateFormat formattedDate = new SimpleDateFormat("ddMMM");            
						Calendar c = Calendar.getInstance();        
						c.add(Calendar.DATE, dayCount);       
						traveldate = (String)(formattedDate.format(c.getTime())).toUpperCase();
					
					}
		    		

					postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "arrstation", arrCity[0]);
					postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "depstation", depCity[0]);
					postBodyContentPNRAddition = apiDriver.updateContent(postBodyContentPNRAddition, "date",  traveldate);
			}
			
		System.out.println("Soap request is: "+postBodyContentPNRAddition);

    	String pnrInputData =  "<style>table {border-collapse !important  }td {border: 1px solid black !important;  white-space: normal; !important;}</style>"
    			+ "<tr><td><b>PNR NEW</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>"
    			+ readFromExcel(sheetName, "PNR1", testName) + "</font></td></tr></table>";	
    	
			scenario.embed(pnrInputData.getBytes(), "text/html");
			
			Reporter.addStepLog("<style>table {border-collapse !important  }td {border: 1px solid black !important;  white-space: normal; !important;}</style>"
	    			+ "<tr><td><b>PNR NEW</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>"
	    			+ readFromExcel(sheetName, "PNR1", testName) + "</font></td></tr></table>");
					
    	}*/
    }
    
    @When("^the user post the service request to update PNR$")
    public void the_user_post_the_service_request_to_update_pnr() throws Throwable {
    	
    /*	try{
	    	if (properties.getProperty("RunSuiteWithNewData").equalsIgnoreCase("True") && readFromExcel(sheetName, "RunTCWithNewData", testName).equalsIgnoreCase("Yes")) {
		    	
	    		System.out.println("Soap Request for PNR Segment Update is: "+postBodyContentPNRAddition);
	    		endPoint = properties.getProperty("PNRCreation_Endpoint");
		    	response = apiDriver.sendNReceive(endPoint, SERVICEMETHOD.POST, SERVICEFORMAT.XML, postBodyContentPNRAddition, headersMap, 200);
		    	respXML = response.extract().asString();
		    	System.out.println("Soap Response for PNR Addition is: "+respXML);
	    	}
    	} catch (Exception e) {
    		assertTrue(false, "Failure to POST the PNR Addition Request. "+e.getMessage());
    	}
    	
    }
    
    @When("^the required inputs are ready to \"([^\"]*)\" the \"([^\"]*)\" remarks$")
    public void the_required_inputs_are_ready_to_the_remarks(String action, String pnrID) throws Throwable {
        
    	
    	String pnr = getPNR(pnrID); 
		headersMap = headers.getHeaders6();
    	
		postBodyContentPNRRemarkUpdate = apiDriver.readInput(properties.getProperty("PNRRemarkUpdateTemplate"));
	
		postBodyContentPNRRemarkUpdate = apiDriver.updateContent(postBodyContentPNRRemarkUpdate, "sabre_userId", properties.getProperty("spotUsername"));
		if (properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("TEST") ) {
			postBodyContentPNRRemarkUpdate = apiDriver.updateContent(postBodyContentPNRRemarkUpdate, "envSabre", "TSTS");
			postBodyContentPNRRemarkUpdate = apiDriver.updateContent(postBodyContentPNRRemarkUpdate, "sabrePwd", properties.getProperty("pwdTSTS"));
		} else {
			postBodyContentPNRRemarkUpdate = apiDriver.updateContent(postBodyContentPNRRemarkUpdate, "envSabre", "CERT");
			postBodyContentPNRRemarkUpdate = apiDriver.updateContent(postBodyContentPNRRemarkUpdate, "sabrePwd", properties.getProperty("pwdCERT"));
		}
		
		postBodyContentPNRRemarkUpdate = apiDriver.updateContent(postBodyContentPNRRemarkUpdate, "pnr", pnr);
		
		System.out.println("PNR Update Req is: "+postBodyContentPNRRemarkUpdate);
    	*/
    }

    @Then("^user post service request for \"([^\"]*)\" update$")
    public void user_post_service_request_for_update(String pnrID) throws Throwable {
    	/*try{
	    	if (properties.getProperty("RunSuiteWithNewData").equalsIgnoreCase("True") && readFromExcel(sheetName, "RunTCWithNewData", testName).equalsIgnoreCase("Yes")) {

	    		endPoint = properties.getProperty("PNRCreation_Endpoint");
	    		response = apiDriver.sendNReceive(endPoint, SERVICEMETHOD.POST, SERVICEFORMAT.XML, postBodyContentPNRRemarkUpdate, headersMap, 200);
	    		respXML = response.extract().asString();
			}
		} catch (Exception e) {
			assertTrue(false, "Failure to POST the PNR Addition Request. "+e.getMessage());
}
*/
    }
    

}