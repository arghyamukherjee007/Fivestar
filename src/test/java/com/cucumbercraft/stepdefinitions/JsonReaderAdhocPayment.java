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
public class JsonReaderAdhocPayment extends MasterStepDefination {
	
		private List<AdhocPayment> AdhocPaymentList;
		
		public JsonReaderAdhocPayment() throws Exception {
			AdhocPaymentList = getDataList();
		}
		
		private List<AdhocPayment> getDataList() throws Exception {
			
			
			
			Gson gson = new Gson();
			BufferedReader bufferedReader = null;
			try {
				LoadPropertiesFile();
			//	testName = getTestName(); 
			
				TestFilePath = System.getProperty("user.dir")+properties.getProperty("TestDataAdhocPaymentJsonFilePath");
				
				bufferedReader = new BufferedReader(new FileReader(TestFilePath));
				AdhocPayment[] AdhocPaymentDataSet = gson.fromJson(bufferedReader, AdhocPayment[].class);
				return Arrays.asList(AdhocPaymentDataSet);
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

		public final AdhocPayment getDataListByTestCase(String testCase) {
			return AdhocPaymentList.stream().filter(j -> j.testCase.equalsIgnoreCase(testCase)).findAny().get();
		}

		
		public final void setJsonData(String filterTestCase, String[] dataSet) throws Exception {
			Gson gson = new Gson();
			Writer writer = null;
			;
			try {
				for (String data : dataSet) {
					String attribute = data.split("=")[0].trim();
					String value = data.split("=")[1].trim();
					/*if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
					{
						switch (attribute.toLowerCase()) {
						case "pnr":
							AdhocPaymentList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
									.get().CERT.pnrNumber = value.toUpperCase();
							break;
						case "requestno":
							AdhocPaymentList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().CERT.RequestNo = value.toUpperCase();
							break;
						case "srnumber":
							AdhocPaymentList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().CERT.SRNumber = value.toUpperCase();
							break;
							}
					}
					else
					{
						switch (attribute.toLowerCase()) {
						case "pnr":
							FiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
									.get().TSTS.pnrNumber = value.toUpperCase();
							break;
						case "requestno":
							FiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().TSTS.RequestNo = value.toUpperCase();
							break;
						case "srnumber":
							FiveStarDataList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
							.get().TSTS.SRNumber = value.toUpperCase();
							break;
							}
					}*/
				}
				String jsonData = gson.toJson(AdhocPaymentList).replaceAll("}},","}},"+System.getProperty("line.separator"));
				writer = new FileWriter(System.getProperty("user.dir")+properties.getProperty("TestDataAdhocPaymentJsonFilePath"));
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
