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

public class JsonReaderCreditCard extends MasterStepDefination {
	private List<CreditCard> CreditCardList;
	
	public JsonReaderCreditCard() throws Exception {
		CreditCardList = getDataList();
	}
	
	private List<CreditCard> getDataList() throws Exception {
		
		
		
		Gson gson = new Gson();
		BufferedReader bufferedReader = null;
		try {
			LoadPropertiesFile();
		//	testName = getTestName(); 
		
			TestFilePath = System.getProperty("user.dir")+properties.getProperty("TestDataCreditCardJsonFilePath");
			
			bufferedReader = new BufferedReader(new FileReader(TestFilePath));
			CreditCard[] CreditCardDataSet = gson.fromJson(bufferedReader, CreditCard[].class);
			return Arrays.asList(CreditCardDataSet);
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

	public final CreditCard getDataListByTestCase(String testCase) {
		return CreditCardList.stream().filter(j -> j.testCase.equalsIgnoreCase(testCase)).findAny().get();
	}

	
/*	public final void setJsonData(String filterTestCase, String[] dataSet) throws Exception {
		Gson gson = new Gson();
		Writer writer = null;
		;
		try {
			for (String data : dataSet) {
				String attribute = data.split("=")[0].trim();
				String value = data.split("=")[1].trim();
				if(properties.getProperty("EnvironmentUnderTest").equalsIgnoreCase("CERT"))
				{
					switch (attribute.toLowerCase()) {
					case "pnr":
						CreditCardList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().CERT.pnrNumber = value.toUpperCase();
						break;
					case "requestno":
						CreditCardList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
						.get().CERT.RequestNo = value.toUpperCase();
						break;
					case "srnumber":
						CreditCardList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
						.get().CERT.SRNumber = value.toUpperCase();
						break;
						}
				}
				else
				{
					switch (attribute.toLowerCase()) {
					case "pnr":
						CreditCardList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
								.get().TSTS.pnrNumber = value.toUpperCase();
						break;
					case "requestno":
						CreditCardList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
						.get().TSTS.RequestNo = value.toUpperCase();
						break;
					case "srnumber":
						CreditCardList.stream().filter(d -> d.testCase.equalsIgnoreCase(filterTestCase)).findAny()
						.get().TSTS.SRNumber = value.toUpperCase();
						break;
						}
				}
			}
			String jsonData = gson.toJson(BookCkList).replaceAll("}},","}},"+System.getProperty("line.separator"));
			writer = new FileWriter(System.getProperty("user.dir")+properties.getProperty("TestDataBookCKJsonFilePath"));
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
*/
}
