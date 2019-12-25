package com.cucumbercraft.stepdefinitions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
public class JsonReaderBookFiveStarData extends MasterStepDefination {
	
		private List<BookFiveStarData> BookFiveStarDataList;
		
		public JsonReaderBookFiveStarData() throws Exception {
			BookFiveStarDataList = getDataList();
		}
		
		private List<BookFiveStarData> getDataList() throws Exception {
			
			
			
			Gson gson = new Gson();
			BufferedReader bufferedReader = null;
			try {
				LoadPropertiesFile();
			//	testName = getTestName(); 
			
				TestFilePath = System.getProperty("user.dir")+properties.getProperty("TestDataBookFivestarJsonFilePath");
				
				bufferedReader = new BufferedReader(new FileReader(TestFilePath));
				BookFiveStarData[] FivestarDataSet = gson.fromJson(bufferedReader, BookFiveStarData[].class);
				return Arrays.asList(FivestarDataSet);
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

		public final BookFiveStarData getDataListByTestCase(String testCase) {
			return BookFiveStarDataList.stream().filter(j -> j.testCase.equalsIgnoreCase(testCase)).findAny().get();
		}

		
		public final void setJsonData(String filterTestCase, String[] dataSet) throws Exception {
			LoadPropertiesFile();
			Gson gson = new Gson();
			Writer writer = null;
			;
			try {
				for (String data : dataSet) {
					String attribute = data.split("=")[0].trim();
					String value = data.split("=")[1].trim();
						switch (attribute.toLowerCase()) {
						case "pnr":
							if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
							{
								BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
									.get().CERT.pnrNumber = value.toUpperCase();}
							else
							{BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().TSTS.pnrNumber = value.toUpperCase();}
							
							break;
						case "requestno":
							if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
							{
								BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().CERT.RequestNo = value.toUpperCase();
							}
							else
							{
								BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().TSTS.RequestNo = value.toUpperCase();
								
							}
							
							break;
						case "srnumber":
							if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
							{
								BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().CERT.SRNumber = value.toUpperCase();
								
							}
							else
							{
								BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().TSTS.SRNumber = value.toUpperCase();
									
							}
							
							break;
						case "nettotalamt":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.NetTotalAmt = value.toUpperCase();
							break;
						case "promocode":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Airport.Promocode = value.toUpperCase();
							break;
						case "adultprice":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.AdultPrice = value.toUpperCase();
							break;
						case "outstandingamt":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.OutStandingAmt = value.toUpperCase();
							break;
						case "promodiscount":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.PromoDiscount = value.toUpperCase();
							break;
						case "airportprice":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Airport.AirportPrice = value.toUpperCase();
							break;
						case "transferrefundpnr":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().TransferRefund.Refundpnr = value.toUpperCase();
							break;
						case "transferrefundbookingref":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().TransferRefund.RefundReqNo = value.toUpperCase();
							break;
						case "transferrefundamount":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().TransferRefund.RefundAmt = value.toUpperCase();
							break;
						case "totaladditionalservices":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.TotalAdditionalServices = value.toUpperCase();
							break;
						case "discountdoller":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Promotions.Discountdoller = value.toUpperCase();
							break;
						case "discountpercent":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Promotions.Discountpercent = value.toUpperCase();
							break;
						case "airportcodeadditional":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.AirportCode = value.toUpperCase();
							break;
						case "servicetypeadditional":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.ServiceType = value.toUpperCase();
							break;
						case "priceperbooking":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.PriceperBooking = value.toUpperCase();
							break;
						case "adultpriceadditional":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.AdultPrice = value.toUpperCase();
							break;
						case "childpriceadditional":
							BookFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.ChildPrice = value.toUpperCase();
							break;	
						
						}
					
				}
				String jsonData = gson.toJson(BookFiveStarDataList).replaceAll("}},","}},"+System.getProperty("line.separator"));
				writer = new FileWriter(System.getProperty("user.dir")+properties.getProperty("TestDataBookFivestarJsonFilePath"));
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
