package pages;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.common;
import utilities.commonEnh;
import utilities.SikuliUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import pages.DatabasePage;

public class BillingPageEnh extends PageObject {
	private static final TimeUnit SECONDS = null;
	private static final WebElementState ErrorTitleBox2 = null;
	@Steps
    private ReadWorkbook readWorkbook;
	@Steps
	private common Common;
	@Steps
	private commonEnh CommonEnh;
	@Steps
	private SikuliUtility sikuliUtility;
	@Steps
	private DatabasePage Database;	
	@Steps
	ReportMessege report;
	@Steps
	private BillingPageEnh BillingPage;	
	public static boolean isAlertPresent(WebDriver driver) {
	      try{
	            driver.switchTo().alert();
	            return true;
	      }catch(NoAlertPresentException ex){
	            return false;
	      }
	}
	
	@FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
	WebElement ClockObj;
	
	@FindBy(xpath=".//*[contains(text(),'Adjustments')]/following::div[1]/span/label")
	WebElement AdjustmentText;
	@FindBy(xpath=".//*[contains(text(),'Balance to pay')]/following::div[1]/span/label")
	WebElement BalancetoPayText;
	@FindBy(xpath=".//*[contains(text(),'Bill total')]/following::div[1]/span/label")
	WebElement BillTotalText;
	@FindBy(xpath=".//*[contains(text(),'Paid')]/following::div[1]/span/label")
	WebElement PaidText;
	@FindBy(xpath=".//*[contains(text(),'Bill creation date')]/following::div[1]/span/label")
	WebElement BillCreationDateText;
	@FindBy(xpath=".//*[contains(text(),'Payments')]")
	WebElement HaloPayments;
	@FindBy(xpath="(.//*[@title='Balance summary Form Applet']//*[@class='siebui-ctrl-text siebui-input-align-left'])[1]")
	WebElementFacade Capturedvalue;
	@FindBy(xpath=".//*[@class='vfoui-account-overview-billing-master vfoui_box_shadow']//*[@class='drilldown']")
	WebElementFacade DrilldownToBillingProfile;
	
	@Step
	public void BillingDetails(String LogicalName) throws InterruptedException, IOException, AWTException{

		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_Enh.xls";
		String dataSheet = "BillingDetails";
		String applet = "";
		String table = "";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      				
			String Index = tableMap.get("Index").get(i);				
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);	
			String sView = tableMap.get("View").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			String Balance = null;
			
			String	BillNumber = Serenity.sessionVariableCalled("BILLNUMBER0").toString();   
			
			if (sAction.contains("AMOUNT0")){
				sAction = sAction.replace("AMOUNT0", Serenity.sessionVariableCalled("AMOUNT0").toString());    	  
			}

			if (sAction.contains("BILLTOTAL0")){
				Balance = Serenity.sessionVariableCalled("BILL_TOTAL0").toString();
			}

			if (sAction.contains("BILL_CREATION0")){
				sAction = sAction.replace("BILL_CREATION0", Serenity.sessionVariableCalled("BILL_CREATION0").toString());    	  
			}
			
			if (sLocateColValue.contains("AMOUNT0")){
				sLocateColValue = sLocateColValue.replace("AMOUNT0", Serenity.sessionVariableCalled("AMOUNT0").toString());    	  
			}
			
			Thread.sleep(3000);
			Common.WaitForClock(ClockObj);

			
			if(sView.equalsIgnoreCase("Services")){
				applet = "//*[contains(@title,'Services List Applet')]";
				table = "//table[@summary='Services']";
				report.Info("Services View");
			}
			else if(sView.equalsIgnoreCase("SummaryCharges")){
				applet = "//*[contains(@title,'Summary charges List Applet')]";
				table = "//table[@summary='Summary charges']";
				report.Info("SummaryCharges View");
			}
			else if(sView.equalsIgnoreCase("BillingDetails")){
				String sBillingNumber = ".//*[@class='siebui-ctrl-text siebui-input-align-left vf-oui-bold']/label[text()='"+BillNumber+"']";
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Bill Number is not displayed in Billing Details applet", find(By.xpath(sBillingNumber)).isCurrentlyVisible());
				report.Info("Bill Number is displayed in Billing Details applet");
				return;
				
			}
			else if(sView.equalsIgnoreCase("HaloPayments")){
				applet = "//*[contains(@title,'Payments List Applet')]";
				table = "//table[@summary='Payments']";
				report.Info("HaloPayments View");
				HaloPayments.click();
				Thread.sleep(3000);
			}

			if (Index.equals("")){
				Index = "0";
			}      															

			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equalsIgnoreCase("true"));
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{               
				Common.selectedRow = 1;
			}

			if (!sUIName.equals("")){ 
				CommonEnh.updateSiebList(applet,table, sUIName, svalue); 
				report.Info("Row updated successfully"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				Common.WaitForClock(ClockObj);
			} 	
			if(sValidation.equalsIgnoreCase("Adjustments")){
				Common.WaitForClock(ClockObj);
				String actAdjustmentText= AdjustmentText.getText();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: Adjustment value doesn't match. Actual is : "+actAdjustmentText+"Expected is: "+sAction, actAdjustmentText.contains(sAction));
				report.Info("Adjustment matches. Actual is : "+actAdjustmentText+"Expected is: "+sAction);
			}
			if(sValidation.equalsIgnoreCase("BillTotal")){
				Common.WaitForClock(ClockObj);
				String actBillTotalText= BillTotalText.getText();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: BillTotalText value doesn't match. Actual is : "+actBillTotalText+"Expected is: "+sAction, actBillTotalText.contains(sAction));
				report.Info("BillTotalText matches. Actual is : "+actBillTotalText+"Expected is: "+sAction);
			}
			if(sValidation.equalsIgnoreCase("BalanceToPay")){
				Common.WaitForClock(ClockObj);
				String actBalancetoPayText= BalancetoPayText.getText();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: BalancetoPayText value doesn't match. Actual is : "+actBalancetoPayText+"Expected is: "+sAction, actBalancetoPayText.contains(sAction));
				report.Info("BalancetoPayText matches. Actual is : "+actBalancetoPayText+"Expected is: "+sAction);
			}
			if(sValidation.equalsIgnoreCase("Paid")){
				Common.WaitForClock(ClockObj);
				String actPaidText= PaidText.getText();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: Paid value doesn't match. Actual is : "+actPaidText+"Expected is: "+sAction, actPaidText.contains(sAction));
				report.Info("PaidText matches. Actual is : "+actPaidText+"Expected is: "+sAction);
			}
			if(sValidation.equalsIgnoreCase("BillCreation date")){
				Common.WaitForClock(ClockObj);
				String actBillCreationDateText= BillCreationDateText.getText();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: BillCreation date value doesn't match. Actual is : "+actBillCreationDateText+"Expected is: "+sAction, actBillCreationDateText.contains(sAction));
				report.Info("BillCreationDateText matches. Actual is : "+actBillCreationDateText+"Expected is: "+sAction);
			}
			
			if(sValidation.equals("CompareAmout"))
			{
				Common.WaitForClock(ClockObj);
				DrilldownToBillingProfile.click();
				Common.WaitForClock(ClockObj);
				String actBillTotalText= Capturedvalue.getText();
				actBillTotalText=actBillTotalText.replace("£", "");
				if(actBillTotalText.contains("."))
				{
					double d=Double.parseDouble(actBillTotalText);  
					double Result;
					Result=d*100;

					double d1=Double.parseDouble(Balance);
					double Result1;
					Result1=d1*100;

					String numberAsString = Double.toString(Result);
					String numberAsString1 = Double.toString(Result1);

					if (numberAsString.equals(numberAsString1)){	
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("BillTotalText matches. Actual is : "+actBillTotalText+"Expected is: "+Balance);	
					}
				}
				else {
					Assert.assertTrue(false);
				}
			}

		}
	}
	@Step
	public void  TopUpHistoryCheck(String BillingProfileType) throws InterruptedException, IOException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
		String dataSheet = "TopUpHistory";
		String table = "//table[@summary='Billing details']";
		String applet = "//*[@title='Billing details List Applet']";
		

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		Common.waitForPageLoad(getDriver());
		Thread.sleep(1000);

		for (int i = 0;i < tableMap.get("RowNo").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);
			String Index = tableMap.get("Index").get(i);

			if (Index.equals("")){
				Index = "0";
			}
			if (value.equals("TOPUP")){
				value = Serenity.sessionVariableCalled("RateGBP").toString();
				value = "£"+value+".00";

			}

			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{
				CommonEnh.selectedRow = 1;
			}
			if (!UIName.equals("")){   
				CommonEnh.updateSiebList(applet,table, UIName, value);
				Thread.sleep(2000);                                                                          
			}     


		}
	}
}