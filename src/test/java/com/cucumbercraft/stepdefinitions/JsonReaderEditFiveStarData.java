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
public class JsonReaderEditFiveStarData extends MasterStepDefination {
	
		private List<EditFiveStarData> EditFiveStarDataList;
		
		public JsonReaderEditFiveStarData() throws Exception {
			EditFiveStarDataList = getDataList();
		}
		
		private List<EditFiveStarData> getDataList() throws Exception {
			
			
			
			Gson gson = new Gson();
			BufferedReader bufferedReader = null;
			try {
				LoadPropertiesFile();
			//	testName = getTestName(); 
			
				TestFilePath = System.getProperty("user.dir")+properties.getProperty("TestDataEditFiveStarJsonFilePath");
				
				bufferedReader = new BufferedReader(new FileReader(TestFilePath));
				EditFiveStarData[] BookCKDataSet = gson.fromJson(bufferedReader, EditFiveStarData[].class);
				return Arrays.asList(BookCKDataSet);
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

		public final EditFiveStarData getDataListByTestCase(String testCase) {
			return EditFiveStarDataList.stream().filter(j -> j.testCase.equalsIgnoreCase(testCase)).findAny().get();
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
						case "oldrequestNo":
							if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
							{
								EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().CERT.OldRequestNo = value.toUpperCase();
							}
							else
							{
								EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().TSTS.OldRequestNo = value.toUpperCase();
							}				
							break;
						case "requestno":
							if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
							{
								EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().CERT.RequestNo = value.toUpperCase();
							}
							else
							{
								EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().TSTS.RequestNo = value.toUpperCase();
								
							}
							
							break;
						case "srnumber":
							if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
							{
								EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().CERT.SRNumber = value.toUpperCase();
								
							}
							else
							{
								EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().TSTS.SRNumber = value.toUpperCase();
									
							}
							
							break;
						case "cancelledsrnumber":
							if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
							{
								EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().CERT.CancelledSRNumber = value.toUpperCase();
								
							}
							else
							{
								EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().TSTS.CancelledSRNumber = value.toUpperCase();
									
							}
							
							break;
						case "nettotalamt":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.NetTotalAmt = value.toUpperCase();
							break;
						case "airportcode":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Airport.AirportCode = value.toUpperCase();
							break;
						case "totaladditionalservices":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.TotalAdditionalServices = value.toUpperCase();
							break;
						case "servicetype":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Airport.ServiceType = value.toUpperCase();
							break;
						case "selectadd":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Airport.selectadd = value.toUpperCase();
							break;
						case "promocode":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Airport.Promocode = value.toUpperCase();
							break;
						case "discountdoller":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Promotions.Discountdoller = value.toUpperCase();
							break;
						case "discountpercent":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Promotions.Discountpercent = value.toUpperCase();
							break;
						case "promodiscount":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.PromoDiscount = value.toUpperCase();
							break;
						case "adultprice":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.AdultPrice = value.toUpperCase();
							break;
						case "outstandingamt":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.OutStandingAmt = value.toUpperCase();
							break;
						case "airportprice":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Airport.AirportPrice = value.toUpperCase();
							break;
						case "transferrefundpnr":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().TransferRefund.Refundpnr = value.toUpperCase();
							break;
						case "transferrefundbookingref":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().TransferRefund.RefundReqNo = value.toUpperCase();
							break;
						case "refundamt":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().Payment.RefundAmt = value.toUpperCase();
							break;
						case "airportcodeadditional":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.AirportCode = value.toUpperCase();
							break;
						case "servicetypeadditional":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.ServiceType = value.toUpperCase();
							break;
						case "priceperbooking":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.PriceperBooking = value.toUpperCase();
							break;
						case "adultpriceadditional":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.AdultPrice = value.toUpperCase();
							break;
						case "childpriceadditional":
							EditFiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().AdditionalServices.ChildPrice = value.toUpperCase();
							break;	
						
						}
					
				}
				String jsonData = gson.toJson(EditFiveStarDataList).replaceAll("}},","}},"+System.getProperty("line.separator"));
				writer = new FileWriter(System.getProperty("user.dir")+properties.getProperty("TestDataEditFiveStarJsonFilePath"));
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
