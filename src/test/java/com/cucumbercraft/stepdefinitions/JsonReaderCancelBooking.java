package com.cucumbercraft.stepdefinitions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class JsonReaderCancelBooking extends MasterStepDefination {
	private List<CancelFivestarData> CancelBookingList;
	
	public JsonReaderCancelBooking() throws Exception {
		CancelBookingList = getDataList();
	}
	
	private List<CancelFivestarData> getDataList() throws Exception {
		
		
		
		Gson gson = new Gson();
		BufferedReader bufferedReader = null;
		try {
			LoadPropertiesFile();
		//	testName = getTestName(); 
		
			TestFilePath = System.getProperty("user.dir")+properties.getProperty("TestDataCancelBookingJsonFilePath");
			
			bufferedReader = new BufferedReader(new FileReader(TestFilePath));
			CancelFivestarData[] CancelBookingDataSet = gson.fromJson(bufferedReader, CancelFivestarData[].class);
			return Arrays.asList(CancelBookingDataSet);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found!");
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException e) {
			}
		}
	}

	public final CancelFivestarData getDataListByTestCase(String testCase) {
		return CancelBookingList.stream().filter(j -> j.testCase.equalsIgnoreCase(testCase)).findAny().get();
	}

	
	public final void setJsonData(String filterTestCase, String[] dataSet) throws Exception {
		Gson gson = new Gson();
		Writer writer = null;
		;
		try {
			for (String data : dataSet) {
				String attribute = data.split("=")[0].trim();
				String value = data.split("=")[1].trim();
				switch (attribute.toLowerCase()) {
				case "requestno":
					if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
					{
						CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
						.get().CERT.RequestNo = value.toUpperCase();
					}
					else
					{
						CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
						.get().TSTS.RequestNo = value.toUpperCase();
						
					}
					
					break;
				case "srnumber":
					if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
					{
						CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
						.get().CERT.SRNumber = value.toUpperCase();
						
					}
					else
					{
						CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
						.get().TSTS.SRNumber = value.toUpperCase();
							
					}
					
					break;
				case "refundamt":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().Payment.RefundAmt = value.toUpperCase();
					break;
				case "promodiscount":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().Payment.PromoDiscount = value.toUpperCase();
					break;
				case "promocode":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().Airport.Promocode = value.toUpperCase();
					break;
				
				case "discountdoller":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().Promotions.Discountdoller = value.toUpperCase();
					break;
				case "outstandingamt":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().Payment.OutStandingAmt = value.toUpperCase();
					break;
				case "discountpercent":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().Promotions.Discountpercent = value.toUpperCase();
					break;
				case "nettotalamt":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().Payment.NetTotalAmt = value.toUpperCase();
					break;
				case "airportcodeadditional":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().AdditionalServices.AirportCode = value.toUpperCase();
					break;
				case "servicetypeadditional":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().AdditionalServices.ServiceType = value.toUpperCase();
					break;
				case "totaladditionalservices":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().AdditionalServices.TotalAdditionalServices = value.toUpperCase();
					break;
				case "priceperbooking":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().AdditionalServices.PriceperBooking = value.toUpperCase();
					break;
				case "adultpriceadditional":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().AdditionalServices.AdultPrice = value.toUpperCase();
					break;
				case "childpriceadditional":
					CancelBookingList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
					.get().AdditionalServices.ChildPrice = value.toUpperCase();
					break;
				}
		}
			String jsonData = gson.toJson(CancelBookingList).replaceAll("}},","}},"+System.getProperty("line.separator"));
			writer = new FileWriter(System.getProperty("user.dir")+properties.getProperty("TestDataCancelBookingJsonFilePath"));
			writer.write(jsonData);
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}

}
