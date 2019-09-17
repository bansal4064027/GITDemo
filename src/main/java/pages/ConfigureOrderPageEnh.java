package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.Serenity.SessionVariableSetter;

import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
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
import java.util.Calendar;
import java.util.Date;
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
import org.sikuli.script.Screen;

import pages.DatabasePage;

public class ConfigureOrderPageEnh extends PageObject {

	private static final TimeUnit SECONDS = null;
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
	
	@FindBy(xpath="//button[@title='Orders:New']")
    WebElementFacade NewOrder;
	
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
	 
	 @FindBy(xpath=".//*[@aria-labelledby='VF_Phone_number_Label']")
	 WebElementFacade PhoneNumberTextBox;

	 @FindBy(xpath=".//*[@aria-labelledby='SIM_number_Label']")
	 WebElementFacade ICCIDTextBox;

	 @FindBy(xpath=".//*[@aria-label='Row #']")
	 WebElementFacade rowId;

	 @FindBy(xpath=".//*[@aria-label='About Record:OK']")
	 WebElementFacade aboutRecordOkButton;
	 @FindBy(xpath=".//*[contains(@aria-label,'New limit')]")
	 WebElementFacade SpendManagerLimit;
	 
/* Zeba :
  		This Function is used to update MSISDN*/	
 
	 @Step
		public void UpdateMSISDN() throws InterruptedException, IOException, FindFailed, AWTException{

			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
			String applet = ".//*[@class='ui-jqgrid-view']";
 		String table = "//table[@summary='Select promotion']";
 		
 		Common.WaitForClock(ClockObj);
			
			String Index = "0";
 		
 			String	sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
 			String LocateColMessage = "Promotion"+" Not Found";
 			
 			try{
				//String sPromotionDD = Serenity.sessionVariableCalled("PromotionDD").toString();
				//if (sPromotionDD.contains("Postpaid")){
					if (SpendManagerLimit.isCurrentlyVisible()){
						SpendManagerLimit.type("off");
						Robot robot = new Robot();  
						robot.keyPress(KeyEvent.VK_CONTROL);    
						robot.keyPress(KeyEvent.VK_S);
						robot.keyRelease(KeyEvent.VK_CONTROL);   
						robot.keyRelease(KeyEvent.VK_S);
					}
				//}
					
			}
			catch(Exception e){
				
			}
 			if(sLocateColValue.equalsIgnoreCase("Phone and SIM package")) {
    			sLocateColValue="Phone and SIM*";
    		}
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(LocateColMessage, CommonEnh.locateColumn(applet,table, "Promotion", sLocateColValue, Index).equals("true"));
				report.Info(sLocateColValue+" found");
 			
			
				PhoneNumberTextBox.waitUntilClickable();
				PhoneNumberTextBox.click();
				Common.WaitForClock(ClockObj);
				
				PhoneNumberTextBox.sendKeys(Keys.chord(Keys.CONTROL,Keys.ALT, "k"));
	
			/*	Robot robot = new Robot();  
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ALT);    
				robot.keyPress(KeyEvent.VK_K);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_ALT);    
				robot.keyRelease(KeyEvent.VK_K);*/
	    	
				Common.WaitForClock(ClockObj);
				String sRowId = rowId.getTextValue();
				Serenity.setSessionVariable("RowId").to(sRowId);
				report.Info("About Record Row ID : "+sRowId);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				aboutRecordOkButton.click();
				Common.WaitForClock(ClockObj);
	
		
	}
/* Zeba :
This Function is used to update ICCID*/	
		
	 @Step
		public void UpdateICCID() throws InterruptedException, IOException, FindFailed, AWTException{

			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
			//Common.waitForPageLoad(getDriver());
			Common.WaitForClock(ClockObj);
			String ICCID = "";
			ICCID = Serenity.sessionVariableCalled("ICCID").toString();
			ICCIDTextBox.waitUntilClickable();
			ICCIDTextBox.type(ICCID);
			Common.WaitForClock(ClockObj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			ICCIDTextBox.sendKeys(Keys.chord(Keys.CONTROL, "s"));
			Common.WaitForClock(ClockObj);
		}
		
	 @FindBy(xpath=".//input[contains(@placeholder,'IMEI')]")
	 WebElementFacade IMEITextBox; 
		
		@FindBy(xpath="(.//*[@aria-labelledby='ServiceId_Label'])")
		 WebElementFacade ServiceIDTextBox;
		
		@Step
		public void UpdateIMEI(String Action) throws InterruptedException, IOException, FindFailed, AWTException{
			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
			String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
	        String dataSheet = "OrdersLineItemsEntry";
	        
	        String applet = ".//*[@class='ui-jqgrid-view']";
    		String table = "//table[@summary='Select promotion']";
    		
	        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
	        readWorkbook.testData(tableMap);
	        
	        for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
	        	  String sValue = tableMap.get("Value").get(i);
	        	  String sAction = tableMap.get("Action").get(i);
			
			//Common.waitForPageLoad(getDriver());
	        	  
	        	  if(sAction.equals("ServiceID"))
		  			{
		  				ServiceIDTextBox.waitUntilClickable();
		  				ServiceIDTextBox.type(sValue);
		  				Common.WaitForClock(ClockObj);
		  				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		  				ServiceIDTextBox.sendKeys(Keys.chord(Keys.CONTROL, "s"));
		  				Thread.sleep(2000);
		  				Common.WaitForClock(ClockObj);
		  				ServiceIDTextBox.click();
		  				Thread.sleep(2000);
		  				Common.WaitForClock(ClockObj);
		  				return;
		  			}
	        	  
	        	  String Index = "0";
	      		
	    			String	sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
	    			String LocateColMessage = "Promotion"+" Not Found";
	    			
	    			if(sLocateColValue.equalsIgnoreCase("Phone and SIM package")) {
		    			sLocateColValue="Phone and SIM*";
		    		}
	    			
					CommonEnh.selectedRow = -1;
					Assert.assertTrue(LocateColMessage, CommonEnh.locateColumn(applet,table, "Promotion", sLocateColValue, Index).equals("true"));
					report.Info(sLocateColValue+" found");
					
			Common.WaitForClock(ClockObj);
			
			IMEITextBox.waitUntilClickable();
			IMEITextBox.type(sValue);
			Common.WaitForClock(ClockObj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			IMEITextBox.sendKeys(Keys.chord(Keys.CONTROL, "s"));
			Thread.sleep(2000);
			Common.WaitForClock(ClockObj);
			IMEITextBox.click();
			Thread.sleep(2000);
			Common.WaitForClock(ClockObj);
	        }
	 }
		
		@FindBy(xpath="(.//*[@aria-label='Basket:Next'])")
		 WebElementFacade NextButtoninConfigureOrder;
		@FindBy(xpath="//button[text()='Order summary'] | //button[text()='Plan order summary'] | //button[text()='Plan summary']")
		WebElementFacade OrderSummaryPage;
		@Step
		public void ConfigureOrderNext() throws InterruptedException, IOException, FindFailed, AWTException{
			Common.WaitForClock(ClockObj);
			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
			Thread.sleep(2000);
			NextButtoninConfigureOrder.waitUntilClickable();
			NextButtoninConfigureOrder.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Common.WaitForClock(ClockObj);
			//OrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		}
		
		@FindBy(xpath="(.//*[@aria-labelledby = 'IMEI_Number_Label'])")
		WebElementFacade IMEINumberLabel;
		
		@FindBy(xpath="(.//*[@aria-labelledby = 'VF_Device_EID_Label'])")
		WebElementFacade DeviceEIDLabel;
		
		@FindBy(xpath="(.//*[@aria-labelledby = 'HTML_CheckBox_Label'])")
		WebElementFacade UseDeviceEIDCheckBox;
		
		@FindBy(xpath="(.//*[@aria-labelledby = 'VF_Sim_EID_Label'])")
		WebElementFacade ESIMLabel;
		
		@FindBy(xpath="(.//*[@aria-label='Primary Installed Id']/following-sibling::span)")
		WebElementFacade PrimaryInstalledIDSearchField;
		
		@FindBy(xpath="(.//*[@aria-label='Given name'])")
		WebElementFacade GivenNameLabel;
		
		@FindBy(xpath="(.//*[translate(@title,'OK','ok')='Primary Installed Id:ok'])")
		WebElementFacade PrimaryInstalledIDOkButton;
		
		@FindBy(xpath="((.//*[text()='OneNumber - Set up'])[1])")
		WebElementFacade OneNumberSetUppopUp;
		
		@FindBy(xpath="((.//*[text()='Ok'])[2])")
		WebElementFacade OneNumberSetUppopUpOkButton;
		
		@Step
		public void AddSerialNumberValidation(String Action) throws InterruptedException, IOException, FindFailed, AWTException{
			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
			String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
	        String dataSheet = "AddSerialNumber";
	        
	        String applet = ".//*[@class='ui-jqgrid-view']";
	 		String table = "//table[@summary='Select promotion']";
    		
	        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
	        readWorkbook.testData(tableMap);
	        
	        for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
	        	  String sValue = tableMap.get("Value").get(i);
	        	  String sAction = tableMap.get("Action").get(i);
	        	  String sValidation = tableMap.get("Validation").get(i);
	        	  
	        	  String Index = "0";
		      		
	    			String	sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
	    			String LocateColMessage = "Promotion"+" Not Found";
	    			
					CommonEnh.selectedRow = -1;
					Assert.assertTrue(LocateColMessage, CommonEnh.locateColumn(applet,table, "Promotion", sLocateColValue, Index).equals("true"));
					report.Info(sLocateColValue+" found");
					
	        	  if(sValidation.equalsIgnoreCase("IMEINumberDisabled"))
	        	  {
	        		  	String IMEINumberLabelReadOnly = IMEINumberLabel.getAttribute("readonly");
	  					if(IMEINumberLabelReadOnly!=null){
	  					Assert.assertTrue("Fail, IMEI Number field is Enabled", IMEINumberLabelReadOnly.equalsIgnoreCase("true"));
	  					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		        		report.Info("IMEI Number field is Disabled as Expected");
	  				}
	        	  }
	        	  if(sValidation.equalsIgnoreCase("DeviceEIDDisabled"))
	        	  {
	        		  	String DeviceEIDLabelReadOnly = DeviceEIDLabel.getAttribute("readonly");
	        		  	if(DeviceEIDLabelReadOnly!=null){
	        		  		Assert.assertTrue("Fail, Device EID field is Enabled", DeviceEIDLabelReadOnly.equalsIgnoreCase("true"));
	        		  		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		        			report.Info("Device EID field is Disabled as Expected");
	        		  	}
	        	  }
	        	  if(sValidation.equalsIgnoreCase("UseDeviceEIDCheckBoxChecked"))
	        	  {
	        		  String UseDeviceEIDCheckBoxReadOnly = UseDeviceEIDCheckBox.getAttribute("readonly");
	        		  	if(UseDeviceEIDCheckBoxReadOnly!=null){
	        		  		Assert.assertTrue("Fail, Use Device EID CheckBox is Enabled", UseDeviceEIDCheckBoxReadOnly.equalsIgnoreCase("true"));
	        		  		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	        		  		report.Info("Use Device EID is Checked as Expected");
	        		  	}
	        	  }
	        	  if(sValidation.equalsIgnoreCase("ESIMDisabled"))
	        	  {
	        		  String ESIMLabelReadOnly = ESIMLabel.getAttribute("readonly");
	        		  	if(ESIMLabelReadOnly!=null){
	        		  		Assert.assertTrue("Fail, ESIM Field is Enabled", ESIMLabelReadOnly.equalsIgnoreCase("true"));
	        		  		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	        		  		report.Info("ESIM field is Disabled as Expected");
	        		  	}
	        	  }
	        	  if(sValidation.equalsIgnoreCase("SpendManagerOFF")){
	        		  if (SpendManagerLimit.isCurrentlyVisible()){
	        			  SpendManagerLimit.type("off");
	        			  Robot robot = new Robot();  
	        			  robot.keyPress(KeyEvent.VK_CONTROL);    
	        			  robot.keyPress(KeyEvent.VK_S);
	        			  robot.keyRelease(KeyEvent.VK_CONTROL);   
	        			  robot.keyRelease(KeyEvent.VK_S);
	        		  }        		  
	        	  }       	  
	        }
		}
		
		@Step
		public void OneNumberValidation(String Action) throws InterruptedException, IOException, FindFailed, AWTException{
			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
			String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
	        String dataSheet = "AddSerialNumber";
	        
	        String applet = "//*[contains(@title,'Primary Installed Id List Applet')]";
	        String table = "//table[@summary='Primary Installed Id']";
    		
	        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
	        readWorkbook.testData(tableMap);
	        
	        for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
	        	  String sValue = tableMap.get("Value").get(i);
	        	  String sAction = tableMap.get("Action").get(i);
	        	  String sLocateCol = tableMap.get("LocateCol").get(i);
	        	  String sLocateColValue = tableMap.get("LocateColValue").get(i);
	        	  String Index = tableMap.get("Index").get(i);
	        	  
	        	  if (Index.equals("")){
	  				Index = "0";
	  			}    
	        	  if(sAction.equalsIgnoreCase("SelectActiveMSISDN"))
	        	  {
	        		  PrimaryInstalledIDSearchField.click();
	        		  Thread.sleep(2000);
	        	  }
	        	  if(sAction.equalsIgnoreCase("ValidateNoMSISDNPresent")) {
	        		  PrimaryInstalledIDSearchField.click();
	        		  Thread.sleep(2000);
		  				int TableRowCount = findAll(By.xpath("//table[@summary='Primary Installed Id']//tr")).size();
		  				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		  				Assert.assertTrue("Fail:Active Mobile No is Present.", TableRowCount==1); 
		  				report.Info("Pass: No Active Mobile no is present");
		  				Thread.sleep(2000);
		            break;
		  			}

	  			if (!sLocateCol.equals("")){
	  				CommonEnh.selectedRow = -1;
	  				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
	  				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
	  			}
	  			else{               
	  				Common.selectedRow = 1;
	  			}
	  			if(PrimaryInstalledIDOkButton.isCurrentlyVisible())
	        	  {
	  				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	  				PrimaryInstalledIDOkButton.click();
	  				Common.WaitForClock(ClockObj);
	        	  }
	  			if(GivenNameLabel.isCurrentlyVisible())
	        	  {
	  				GivenNameLabel.type("AUTOMATION");
	  				Common.WaitForClock(ClockObj);
	  				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	  				Thread.sleep(2000);
	        	  }
	  			
	        }
		}
}
