package pages;

import java.awt.AWTException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.SikuliUtility;
import utilities.common;

public class SBConsoleHomePage extends PageObject{
	
	private static final TimeUnit SECONDS = null;
	@Steps
	private ReadWorkbook readWorkbook;
	@Steps
	private SikuliUtility SikuliUtility;
	
	@Steps
	private common Common;
	
	
	
	
	
	@FindBy(xpath="//h1[contains(text(),'Resource')]")
	WebElementFacade ResourceBrowserLink;
	
	@FindBy(xpath="//input[@id='ProxyServicesPortletsrname_id']")
	WebElementFacade ServiceNameInputField;
	
	
	@FindBy(xpath="//input[@name='ProxyServicesPortletsearch']")
	WebElementFacade SearchButton;
	
	@FindBy(xpath="//img[@src='/sbconsole/images/sb/icon_debug.gif']")
	WebElementFacade invokerIcon;
	
	@FindBy(xpath="//textarea[@name='ServiceTestDialogPortletpayloadText']")
	WebElementFacade requestTextArea;
	
	@FindBy(xpath="(//input[@title='Run the test.'])[2]")
	WebElementFacade executeButton;
	
	
	
	
	@Step
	public void selectService() throws IOException, InterruptedException, AWTException {		
		String ServiceName = "FulfillmentOrderStatusReqABCSImplV1";
		

		ResourceBrowserLink.click();
		
		ServiceNameInputField.sendKeys(ServiceName);
		
		SearchButton.click();
		
		invokerIcon.click();
		
		WebDriver driver = getDriver();
		
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    driver.manage().window().maximize();
		 }

	}
	
	public String createBENInputXMLforESIM(String OrderID) throws IOException {
		String ShippingDate = Common.returnDispatchDate();
		String TodayDate = Common.returnTodaysDate();
		String EIDNumber = "97979797979797979797979797979701";
		String IMEINumber = Common.returnRandomIMEI();

		String FilePath = new String();
		FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BEN_ALLDESPForESIM.txt";
		File inputXMLFile = new File(FilePath);
		String firstPatternToBeReplaced = "<ns0:value>" + OrderID + "</ns0:value>";

		String stringRequestXML = FileUtils.readFileToString(inputXMLFile);
		StringBuffer updatedStringRequestXML = new StringBuffer(stringRequestXML);
		Pattern pattern1 = Pattern.compile("(<ns0:value>)(.*)(</ns0:value>)");
		Matcher matcher1 = pattern1.matcher(stringRequestXML);
		int count1 = 0;

		String secondPatternToBeReplaced = "<ns1:EarliestShipDateTime xmlns:ns1=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/FulfillmentOrder/V1\">"
				+ ShippingDate + "</ns1:EarliestShipDateTime>";
		Pattern pattern2 = Pattern.compile(
				"(<ns1:EarliestShipDateTime xmlns:ns1=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/FulfillmentOrder/V1\">)(.*)(</ns1:EarliestShipDateTime>)");
		Matcher matcher2 = pattern2.matcher(stringRequestXML);

		String thirdPatternToBeReplaced = "<ns1:EarliestShipDateTime>" + ShippingDate + "</ns1:EarliestShipDateTime>";
		Pattern pattern3 = Pattern.compile("(<ns1:EarliestShipDateTime>)(.*)(</ns1:EarliestShipDateTime>)");
		Matcher matcher3 = pattern3.matcher(stringRequestXML);

		String fourthPatternToBeReplaced = "<ns2:SerialNumber>" + IMEINumber + "</ns2:SerialNumber>";
		Pattern pattern4 = Pattern.compile("(<ns2:SerialNumber>)(.*)(</ns2:SerialNumber>)");
		Matcher matcher4 = pattern4.matcher(stringRequestXML);

		String fifthPatternToBeReplaced = "<ns3:ID>" + OrderID + "</ns3:ID>";
		Pattern pattern5 = Pattern.compile("(<ns3:ID>)(.*)(</ns3:ID>)");
		Matcher matcher5 = pattern5.matcher(stringRequestXML);

		String sixthPatternToBeReplaced = "<ns3:EID xmlns:ns3=\"http://xmlns.oracle.com/EnterpriseObjects/Core/Custom/Common/V2\">"
				+ EIDNumber + "</ns3:EID>";
		Pattern pattern6 = Pattern.compile(
				"(<ns3:EID xmlns:ns3=\\\"http://xmlns.oracle.com/EnterpriseObjects/Core/Custom/Common/V2\\\">)(.*)(</ns3:EID>)");
		Matcher matcher6 = pattern6.matcher(stringRequestXML);

		String seventhPatternToBeReplaced = "<ns2:EffectiveDateTime>" + TodayDate + "</ns2:EffectiveDateTime>";
		Pattern pattern7 = Pattern.compile("(<ns2:EffectiveDateTime>)(.*)(</ns2:EffectiveDateTime>)");
		Matcher matcher7 = pattern7.matcher(stringRequestXML);

		while (matcher1.find()) {
			if (count1 == 0) {
				updatedStringRequestXML = updatedStringRequestXML.replace(matcher1.start(), matcher1.end(),
						firstPatternToBeReplaced);
			}
			count1++;
		}

		while (matcher2.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher2.start(), matcher2.end(),
					secondPatternToBeReplaced);
		}

		while (matcher3.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher3.start(), matcher3.end(),
					thirdPatternToBeReplaced);
		}

		while (matcher4.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher4.start(), matcher4.end(),
					fourthPatternToBeReplaced);
		}

		while (matcher5.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher5.start(), matcher5.end(),
					fifthPatternToBeReplaced);
		}

		while (matcher6.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher6.start(), matcher6.end(),
					sixthPatternToBeReplaced);
		}

		while (matcher7.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher7.start(), matcher7.end(),
					seventhPatternToBeReplaced);
		}

		String toWriteInFile = new String(updatedStringRequestXML);

		String outputFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BEN_ALLDESPOutput.txt";
		File outputBENXML = new File(outputFilePath);

		outputBENXML.delete();

		outputBENXML.createNewFile();
		FileWriter fileWriter = new FileWriter(outputBENXML);
		fileWriter.write(toWriteInFile);
		fileWriter.close();

		return updatedStringRequestXML.toString();

	}

	public String createBENInputXMLforHandsetAndSIM(String OrderID) throws IOException, Exception, SQLException {
		String ShippingDate = Common.returnDispatchDate();
		String TodayDate = Common.returnTodaysDate();

		String IMEINumber = Common.returnRandomIMEI();
		String EIDNumber = "97979797979797979797979797979701";
		String UnusedICCID = "";
		DatabasePage databasePageObj = new DatabasePage();

		databasePageObj.TryReserveAvailableICCID();

		UnusedICCID = Serenity.sessionVariableCalled("ICCID").toString();

		String FilePath = new String();
		FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BEN_ALLDESPForHandsetAndSIM.txt";
		File inputXMLFile = new File(FilePath);
		String firstPatternToBeReplaced = "<ns0:value>" + OrderID + "</ns0:value>";

		String stringRequestXML = FileUtils.readFileToString(inputXMLFile);
		StringBuffer updatedStringRequestXML = new StringBuffer(stringRequestXML);
		Pattern pattern1 = Pattern.compile("(<ns0:value>)(.*)(</ns0:value>)");
		Matcher matcher1 = pattern1.matcher(stringRequestXML);
		int count1 = 0;

		String secondPatternToBeReplaced = "<ns1:EarliestShipDateTime xmlns:ns1=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/FulfillmentOrder/V1\">"
				+ ShippingDate + "</ns1:EarliestShipDateTime>";
		Pattern pattern2 = Pattern.compile(
				"(<ns1:EarliestShipDateTime xmlns:ns1=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/FulfillmentOrder/V1\">)(.*)(</ns1:EarliestShipDateTime>)");
		Matcher matcher2 = pattern2.matcher(stringRequestXML);

		String thirdPatternToBeReplaced = "<ns1:EarliestShipDateTime>" + ShippingDate + "</ns1:EarliestShipDateTime>";
		Pattern pattern3 = Pattern.compile("(<ns1:EarliestShipDateTime>)(.*)(</ns1:EarliestShipDateTime>)");
		Matcher matcher3 = pattern3.matcher(stringRequestXML);

		String fourthPatternToBeReplaced = "<ns2:SerialNumber>" + TodayDate + "</ns2:SerialNumber>";
		Pattern pattern4 = Pattern.compile("(<ns2:SerialNumber>)(.*)(</ns2:SerialNumber>)");
		Matcher matcher4 = pattern4.matcher(stringRequestXML);
		int count4 = 0;

		String eighthPatternToBeReplaced = "<ns2:SerialNumber>" + IMEINumber + "</ns2:SerialNumber>";
		Pattern pattern8 = Pattern.compile("(<ns2:SerialNumber>)(.*)(</ns2:SerialNumber>)");
		Matcher matcher8 = pattern4.matcher(stringRequestXML);

		String fifthPatternToBeReplaced = "<ns3:ID>" + OrderID + "</ns3:ID>";
		Pattern pattern5 = Pattern.compile("(<ns3:ID>)(.*)(</ns3:ID>)");
		Matcher matcher5 = pattern5.matcher(stringRequestXML);

		String sixthPatternToBeReplaced = "<ns3:EID xmlns:ns3=\"http://xmlns.oracle.com/EnterpriseObjects/Core/Custom/Common/V2\">"
				+ EIDNumber + "</ns3:EID>";
		Pattern pattern6 = Pattern.compile(
				"(<ns3:EID xmlns:ns3=\\\"http://xmlns.oracle.com/EnterpriseObjects/Core/Custom/Common/V2\\\">)(.*)(</ns3:EID>)");
		Matcher matcher6 = pattern6.matcher(stringRequestXML);

		String seventhPatternToBeReplaced = "<ns2:EffectiveDateTime>" + TodayDate + "</ns2:EffectiveDateTime>";
		Pattern pattern7 = Pattern.compile("(<ns2:EffectiveDateTime>)(.*)(</ns2:EffectiveDateTime>)");
		Matcher matcher7 = pattern7.matcher(stringRequestXML);
		int count7 = 0;

		while (matcher1.find()) {
			if (count1 == 0) {
				updatedStringRequestXML = updatedStringRequestXML.replace(matcher1.start(), matcher1.end(),
						firstPatternToBeReplaced);
			}
			count1++;
		}

		while (matcher2.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher2.start(), matcher2.end(),
					secondPatternToBeReplaced);
		}

		while (matcher3.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher3.start(), matcher3.end(),
					thirdPatternToBeReplaced);
		}

		while (matcher4.find()) {

			if (count4 == 0) {
				updatedStringRequestXML = updatedStringRequestXML.replace(matcher4.start(), matcher4.end(),
						fourthPatternToBeReplaced);
			}
			if (count4 == 1) {
				updatedStringRequestXML = updatedStringRequestXML.replace(matcher4.start(), matcher4.end(),
						eighthPatternToBeReplaced);
			}
			count4++;
		}

		while (matcher5.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher5.start(), matcher5.end(),
					fifthPatternToBeReplaced);
		}

		while (matcher6.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher6.start(), matcher6.end(),
					sixthPatternToBeReplaced);
		}

		while (matcher7.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher7.start(), matcher7.end(),
					seventhPatternToBeReplaced);
		}

		String toWriteInFile = new String(updatedStringRequestXML);

		String outputFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BEN_ALLDESPOutput.txt";
		File outputBENXML = new File(outputFilePath);

		outputBENXML.delete();

		outputBENXML.createNewFile();
		FileWriter fileWriter = new FileWriter(outputBENXML);
		fileWriter.write(toWriteInFile);
		fileWriter.close();

		return updatedStringRequestXML.toString();

	}
	
	public String createBENInputXMLforHandsetOrAccessory(String OrderID) {

		String ShippingDate = Common.returnDispatchDate();
		String TodayDate = Common.returnTodaysDate();
		String IMEINumber = Common.returnRandomIMEI();

		String FilePath = new String();
		FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BEN_ALLDESPForHandsetOrAcessory.txt";
		File inputXMLFile = new File(FilePath);
		
		String firstPatternToBeReplaced = "<ns0:value>" + OrderID + "</ns0:value>";

		String stringRequestXML = "";
		try {
			stringRequestXML = FileUtils.readFileToString(inputXMLFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuffer updatedStringRequestXML = new StringBuffer(stringRequestXML);
		Pattern pattern1 = Pattern.compile("(<ns0:value>)(.*)(</ns0:value>)");
		Matcher matcher1 = pattern1.matcher(stringRequestXML);
		int count1 = 0;

		String secondPatternToBeReplaced = "<ns1:EarliestShipDateTime xmlns:ns1=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/FulfillmentOrder/V1\">"
				+ ShippingDate + "</ns1:EarliestShipDateTime>";
		Pattern pattern2 = Pattern.compile(
				"(<ns1:EarliestShipDateTime xmlns:ns1=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/FulfillmentOrder/V1\">)(.*)(</ns1:EarliestShipDateTime>)");
		Matcher matcher2 = pattern2.matcher(stringRequestXML);

		String thirdPatternToBeReplaced = "<ns1:EarliestShipDateTime>" + ShippingDate + "</ns1:EarliestShipDateTime>";
		Pattern pattern3 = Pattern.compile("(<ns1:EarliestShipDateTime>)(.*)(</ns1:EarliestShipDateTime>)");
		Matcher matcher3 = pattern3.matcher(stringRequestXML);

		String fourthPatternToBeReplaced = "<ns2:SerialNumber>" + IMEINumber + "</ns2:SerialNumber>";
		Pattern pattern4 = Pattern.compile("(<ns2:SerialNumber>)(.*)(</ns2:SerialNumber>)");
		Matcher matcher4 = pattern4.matcher(stringRequestXML);

		String fifthPatternToBeReplaced = "<ns3:ID>" + OrderID + "</ns3:ID>";
		Pattern pattern5 = Pattern.compile("(<ns3:ID>)(.*)(</ns3:ID>)");
		Matcher matcher5 = pattern5.matcher(stringRequestXML);

		

		String seventhPatternToBeReplaced = "<ns2:EffectiveDateTime>" + TodayDate + "</ns2:EffectiveDateTime>";
		Pattern pattern7 = Pattern.compile("(<ns2:EffectiveDateTime>)(.*)(</ns2:EffectiveDateTime>)");
		Matcher matcher7 = pattern7.matcher(stringRequestXML);

		while (matcher1.find()) {
			if (count1 == 0) {
				updatedStringRequestXML = updatedStringRequestXML.replace(matcher1.start(), matcher1.end(),
						firstPatternToBeReplaced);
			}
			count1++;
		}

		while (matcher2.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher2.start(), matcher2.end(),
					secondPatternToBeReplaced);
		}

		while (matcher3.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher3.start(), matcher3.end(),
					thirdPatternToBeReplaced);
		}

		while (matcher4.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher4.start(), matcher4.end(),
					fourthPatternToBeReplaced);
		}

		while (matcher5.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher5.start(), matcher5.end(),
					fifthPatternToBeReplaced);
		}


		while (matcher7.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher7.start(), matcher7.end(),
					seventhPatternToBeReplaced);
		}

		String toWriteInFile = new String(updatedStringRequestXML);

		String outputFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BEN_ALLDESPOutput.txt";
		File outputBENXML = new File(outputFilePath);

		outputBENXML.delete();

		
		try {
			outputBENXML.createNewFile();
			FileWriter fileWriter = new FileWriter(outputBENXML);
			fileWriter.write(toWriteInFile);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return updatedStringRequestXML.toString();
	}
	
	
	public String createBENInputXMLforSIMOnly(String OrderID) throws IOException, Exception, SQLException {
		String ShippingDate = Common.returnDispatchDate();
		String TodayDate = Common.returnTodaysDate();

		String IMEINumber = Common.returnRandomIMEI();
		String EIDNumber = "97979797979797979797979797979701";
		String UnusedICCID = "";
		
		
		
		UnusedICCID = Serenity.sessionVariableCalled("ICCID").toString();
		
		if(OrderID.equalsIgnoreCase("")) {
			OrderID = Serenity.sessionVariableCalled("OrderNo").toString();
		}

		String FilePath = new String();
		FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BEN_ALLDESPForSIMOnly.txt";
		File inputXMLFile = new File(FilePath);
		

		String stringRequestXML = FileUtils.readFileToString(inputXMLFile);
		StringBuffer updatedStringRequestXML = new StringBuffer(stringRequestXML);
		
		String firstPatternToBeReplaced = "<ns0:value>" + OrderID + "</ns0:value>";
		Pattern pattern1 = Pattern.compile("(<ns0:value>)(.*)(</ns0:value>)");
		Matcher matcher1 = pattern1.matcher(stringRequestXML);
		int count1 = 0;

		
		String secondPatternToBeReplaced = "<ns1:EarliestShipDateTime xmlns:ns1=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/FulfillmentOrder/V1\">"
				+ ShippingDate + "</ns1:EarliestShipDateTime>";
		Pattern pattern2 = Pattern.compile(
				"(<ns1:EarliestShipDateTime xmlns:ns1=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/FulfillmentOrder/V1\">)(.*)(</ns1:EarliestShipDateTime>)");
		Matcher matcher2 = pattern2.matcher(stringRequestXML);

		String thirdPatternToBeReplaced = "<ns1:EarliestShipDateTime>" + ShippingDate + "</ns1:EarliestShipDateTime>";
		Pattern pattern3 = Pattern.compile("(<ns1:EarliestShipDateTime>)(.*)(</ns1:EarliestShipDateTime>)");
		Matcher matcher3 = pattern3.matcher(stringRequestXML);

		String fourthPatternToBeReplaced = "<ns2:SerialNumber>" + UnusedICCID + "</ns2:SerialNumber>";
		Pattern pattern4 = Pattern.compile("(<ns2:SerialNumber>)(.*)(</ns2:SerialNumber>)");
		Matcher matcher4 = pattern4.matcher(stringRequestXML);
		int count4 = 0;

		

		String fifthPatternToBeReplaced = "<ns3:ID>" + OrderID + "</ns3:ID>";
		Pattern pattern5 = Pattern.compile("(<ns3:ID>)(.*)(</ns3:ID>)");
		Matcher matcher5 = pattern5.matcher(stringRequestXML);


		String seventhPatternToBeReplaced = "<ns2:EffectiveDateTime>" + TodayDate + "</ns2:EffectiveDateTime>";
		Pattern pattern7 = Pattern.compile("(<ns2:EffectiveDateTime>)(.*)(</ns2:EffectiveDateTime>)");
		Matcher matcher7 = pattern7.matcher(stringRequestXML);
		int count7 = 0;

		while (matcher1.find()) {
			if (count1 == 0) {
				updatedStringRequestXML = updatedStringRequestXML.replace(matcher1.start(), matcher1.end(),
						firstPatternToBeReplaced);
			}
			count1++;
		}

		while (matcher2.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher2.start(), matcher2.end(),
					secondPatternToBeReplaced);
		}

		while (matcher3.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher3.start(), matcher3.end(),
					thirdPatternToBeReplaced);
		}

		while (matcher4.find()) {

			if (count4 == 0) {
				updatedStringRequestXML = updatedStringRequestXML.replace(matcher4.start(), matcher4.end(),
						fourthPatternToBeReplaced);
			}
			count4++;
		}

		while (matcher5.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher5.start(), matcher5.end(),
					fifthPatternToBeReplaced);
		}

		while (matcher7.find()) {
			updatedStringRequestXML = updatedStringRequestXML.replace(matcher7.start(), matcher7.end(),
					seventhPatternToBeReplaced);
		}

		String toWriteInFile = new String(updatedStringRequestXML);

		String outputFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\BEN_ALLDESPOutput.txt";
		File outputBENXML = new File(outputFilePath);

		outputBENXML.delete();

		outputBENXML.createNewFile();
		FileWriter fileWriter = new FileWriter(outputBENXML);
		fileWriter.write(toWriteInFile);
		fileWriter.close();

		return updatedStringRequestXML.toString();

	}
	
	
	public void invokeService(String OrderType,String OrderID) throws Exception, Exception {

		String filePath = "\\src\\test\\resources\\data\\SBConsole.xls";
		String dataSheet = "OrderDespatch";
		// ReadWorkbook readWorkbook = new ReadWorkbook();
		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(OrderType, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		
		if(OrderType.equalsIgnoreCase("")) {
			OrderID = Serenity.sessionVariableCalled("OrderNo").toString();
		}
		
		
		String inputXML = new String();
		for (int i = 0; i < tableMap.get("DispatchType").size(); i++) {
			OrderType = tableMap.get("DispatchType").get(i);
			if (OrderType.equalsIgnoreCase("ESIM")) {
				inputXML = this.createBENInputXMLforESIM(OrderID);
			}

			if (OrderType.equalsIgnoreCase("HandsetAndSIM")) {
				inputXML = this.createBENInputXMLforHandsetAndSIM(OrderID);
			}
			if (OrderType.equalsIgnoreCase("HandsetOrAccessoryOnly")) {
				inputXML = this.createBENInputXMLforHandsetOrAccessory(OrderID);
			}
			if (OrderType.equalsIgnoreCase("SIMOnly")) {
				inputXML = this.createBENInputXMLforSIMOnly(OrderID);
			}

			requestTextArea.clear();
			requestTextArea.sendKeys(inputXML);
			executeButton.click();
		}
	}
	
	
	
	
	//Service Name = FulfillmentOrderStatusReqABCSImplV1
	

}
