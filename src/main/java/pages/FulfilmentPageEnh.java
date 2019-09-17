package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.SikuliUtility;
import utilities.common;
import utilities.commonEnh;

public class FulfilmentPageEnh extends PageObject {
	
	@Steps
    private ReadWorkbook readWorkbook;
	
	@Steps
	private commonEnh CommonEnh;
	@Steps
	private common Common;
	@Steps
	private SikuliUtility sikuliUtility;
	
	
	@Steps
	private ReportMessege report; 
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
	@FindBy(xpath=".//input[@value='Deliver to customer']")
	WebElementFacade deliveryToCustRadioButton;
	
	@FindBy(xpath=".//input[@value='Collect from store stock']")
	WebElementFacade CollectFromStoreStockRadioButton;
	
	@FindBy(xpath=".//input[@value='Deliver to store']")
	WebElementFacade DeliverToStoreRadioButton;
	
	@FindBy(xpath=".//*[@title='Line Items:Update reservation']")
	WebElementFacade UpdateReservationButton;
	
	@FindBy(xpath=".//*[@aria-label='Delivery method']")
	WebElementFacade DeliveryMethodList;
	
	@FindBy(xpath=".//input[@aria-label='Delivery date']")
	WebElementFacade DeliveryDate;	
	
	@FindBy(xpath=".//*[@title='Delivery information:Confirm delivery']")
	WebElementFacade DeliveryConfirmButton;
	
	@FindBy(xpath="(.//*[text()='Fulfilment'])[3]")
	WebElementFacade Fulfilment;
		
	@FindBy(xpath=".//*[@title='Basket:Next']")
	WebElementFacade FulfilmentNextButton;
	
	@FindBy(xpath=".//*[@aria-label='Store postcode']")
	WebElementFacade StorePostCode;
	
	@FindBy(xpath="(.//*[@aria-label='Store address'])[1]")
	WebElementFacade StoreAddress;
	
	@FindBy(xpath=".//*[@aria-label='Fulfilment:Check stock']")
	WebElementFacade CheckStockButton;
	@FindBy(xpath="(.//*[contains(@aria-labelledby,'Reserved_against')])[1]")
	WebElementFacade ReserveAgainstCell;
	@FindBy(xpath=".//*[contains(text(),'Halo - please read')]")
	WebElementFacade ErrorTitleBox;  
	@FindBy(xpath=".//div[contains(@class,'popup-info')]")
	WebElementFacade ErrorMsg; 
	@FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
	WebElementFacade ErrorOkButton;
	
/*	@FindBy(xpath="(.//*[@aria-label='Phone number'])[2]")
	WebElementFacade PhoneNumber;*/
	
	@FindBy(xpath="(.//*[@class='siebui-ctrl-input siebui-align-left siebui-input-align-left s_3_1_17_0 vfoui-fixedSer-margin-top-8px'])")
	WebElementFacade PhoneNumber;
	
	@FindBy(xpath="(.//*[contains(@id,'MRC_CxTotal') and contains(.,'Monthly') and contains(.,'incl. VAT')])[1]")
	WebElementFacade MonthlyInclVat;
	
	@FindBy(xpath="(.//*[contains(@id,'MRC_CxTotal') and contains(.,'Monthly') and contains(.,'excl. VAT')])[1]")
	WebElementFacade MonthlyExclVat;
	
	@FindBy(xpath="(.//*[contains(@id,'VF_Gross_Price_-_Display') and contains(.,'Up-front') and contains(.,'incl. VAT')])[1]")
	WebElementFacade UpfrontInclVat;
	
	@FindBy(xpath="(.//*[contains(@id,'VF_Gross_Price_-_Display') and contains(.,'Up-front') and contains(.,'excl. VAT')])[1]")
	WebElementFacade UpfrontExclVat;
	
	@FindBy(xpath=".//*[@rn='VF House Number']")
	WebElementFacade HouseNumber;
	@FindBy(xpath=".//*[@rn='Address line 1']")
	WebElementFacade AddressLine1;
	
	@FindBy(xpath=".//span[@rn='VF Postal Code']")
    WebElementFacade PostcodeLabel;
 	
	@FindBy(xpath="(.//*[@aria-label='Store address'])[1]/following-sibling::span")
    WebElementFacade AddressIcon;
	
	@FindBy(xpath=".//li[contains(text(),'Tonbridge')]")
    WebElementFacade AddressSelection;
	
	@FindBy(xpath=".//div[(text()='Return/Exchange info.')]")
	WebElementFacade ReturnExchangeInfo;
	
	@FindBy(xpath="(.//*[contains(@class,'siebui-icon-dropdown applet-form-combo applet-list-combo')])")
	WebElementFacade SelectReturnExchangeListButton;
	
	@FindBy(xpath="(.//*[@data-lovtype='CARRIER_PRIORITY'])[2]")
    WebElementFacade RoyalMailReturnsPack;
	
	@FindBy(xpath="(.//*[@aria-labelledby='VF_Phone_No_Label'])[1]")
    WebElementFacade ContactTextBox;
	
	@FindBy(xpath=".//*[@aria-label='Return/Exchange method']")
	WebElementFacade SelectReturnExchangeTextBox;
	
	@FindBy(xpath="(.//*[@data-lovtype='CARRIER_PRIORITY'])[3]")
    WebElementFacade DPAVoxiSelfReturn;
	
	@FindBy(xpath=".//*[@aria-label='Choose either the primary contact']")
    WebElementFacade ReasonTextBox;
	
	@FindBy(xpath=".//*[@aria-label='DPD self-return label:OK']")
    WebElementFacade ReasonTextBoxokay;
	
	@FindBy(xpath="(.//*[@title='Return/Exchange info.:Confirm delivery'])")
    WebElementFacade ConfirmButton;
	
	@FindBy(xpath="//button[@title='Basket:Next']")
	WebElementFacade NextButton;
	
	
	@FindBy(xpath=".//*[@id='dtc']")
    WebElementFacade DeliverToCustomer;
 	@FindBy(xpath="(.//input[@aria-label='Phone number'])[3]")
    WebElementFacade PhoneNumber1;
 	@FindBy(xpath=".//*[@title='Delivery/collection details:Check stock']")
    WebElementFacade CheckStock;
 	@FindBy(xpath=".//*[@aria-label='Update reservation']")
    WebElementFacade UpdateReservation;
 	@FindBy(xpath=".//button[@title='Arrange delivery/collection options:Confirm']")
    WebElementFacade ConfirmButtonSplitDelivery;
 	@FindBy(xpath=".//*[@aria-label='Fulfilment summary:Go Back']")
    WebElementFacade FulfilmentSummaryBackButton;
	
	
	@Step
	public void ReturnExchangeInfo() throws InterruptedException, IOException, AWTException{
 		Common.WaitForClock(ClockObj);
 		
 		
        	if (ReturnExchangeInfo.isVisible()){
        		Thread.sleep(2000);
    			SelectReturnExchangeListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				RoyalMailReturnsPack.click();
				ContactTextBox.sendKeys("25212545454545");
				Thread.sleep(2000);
    	    	ConfirmButton.click();
				Thread.sleep(3000);
				NextButton.click();
        }}
 	
	//ReturnExchangeInfoWith
 	public void ReturnExchangeInfoWith(String Action) throws InterruptedException, IOException, AWTException{
 		String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
		String dataSheet = "ReturnJourney";
		
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		  for (int i = 0;i < tableMap.get("Action").size();i++) {
			   String sAction = tableMap.get("Action").get(i);	

			
			if (ReturnExchangeInfo.isVisible()){
				
				if(sAction.equals("DPAVoxiSelfReturn")) {
					

					Thread.sleep(2000);
	    			//SelectReturnExchangeListButton.click();
					SelectReturnExchangeTextBox.waitUntilClickable();
					SelectReturnExchangeTextBox.clear();
					SelectReturnExchangeTextBox.sendKeys("DPD VOXI Self Return Label");
							
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(1000);
					//RoyalMailReturnsPack.click();
					//DPAVoxiSelfReturn.click();
					ContactTextBox.sendKeys("25212545454545");
					ConfirmButton.click();
					Thread.sleep(3000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					//if(ReasonTextBox.isPresent()){
						ReasonTextBox.sendKeys("Account holder Email");
						Thread.sleep(3000);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						ReasonTextBox.sendKeys(Keys.chord(Keys.CONTROL, "s"));
						ReasonTextBoxokay.click();
				//	}
					
				
					
				}
				
			}
			//
			NextButton.click();
			Common.WaitForClock(ClockObj);
		}
				
 	}
	
	
	
 	@Step
	public void Fulfilment_Status(String DeliveryMethod) throws InterruptedException, IOException, AWTException{
 		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
        String dataSheet = "FulfilmentStatus";
		String table = "//table[@summary='Line Items']";
		String applet = "//*[@title='Line Items List Applet']";
        
        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(DeliveryMethod, filePath, dataSheet);
        readWorkbook.testData(tableMap);
        
        for (int i = 0;i < tableMap.get("DeliveryMethod").size();i++) {
        	String sDeliveryMethod = tableMap.get("DeliveryMethod").get(i);
        	String sDeliveryOption = tableMap.get("DeliverOptions").get(i);
        	String sStorePostCode = tableMap.get("StorePostCode").get(i);
        	String sStoreAddress = tableMap.get("StoreAddress").get(i);
        	String sReservedAgainst = tableMap.get("ReservedAgainst").get(i);
        	String sValidation = tableMap.get("Validation").get(i);
        	

        	Thread.sleep(5000);
        	if(ErrorTitleBox.isCurrentlyVisible()){
    			String ErrorInfo= ErrorMsg.getText();
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				ErrorOkButton.click();
    				Common.WaitForClock(ClockObj);
    				report.Info("The alert meassage is:"+ErrorInfo);
    			}
       //Workaround as pop is not getting handled in one go
        	Thread.sleep(4000);
        	if(ErrorTitleBox.isCurrentlyVisible()){
    			String ErrorInfo= ErrorMsg.getText();
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				ErrorOkButton.click();
    				Common.WaitForClock(ClockObj);
    				report.Info("The alert meassage is:"+ErrorInfo);
    		}
        	
        	if (sValidation.equals("ConsumerValidation")) {
        		
        		if (MonthlyInclVat.isDisplayed()){
        			report.Info("Monthly Inc. Vat column is displayed");
        		}
        		else if (!MonthlyInclVat.isDisplayed()){
        			report.Info("Monthly Inc. Vat column is not displayed");
        			Assert.assertTrue(false);
        		}
        		
        		if (UpfrontInclVat.isDisplayed()){
        			report.Info("Upfront Inc. Vat column is displayed");
        		}
        		else if (!UpfrontInclVat.isDisplayed()){
        			report.Info("Upfront Inc. Vat column is not displayed");
        			Assert.assertTrue(false);
        		}
        		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        		break;
    		}
    		
    		if (sValidation.equalsIgnoreCase("BusinessValidation")) {
        		if (MonthlyExclVat.isDisplayed()){
        			report.Info("Monthly Exc. Vat column is displayed");
        		}
        		else if (!MonthlyExclVat.isDisplayed()){
        			report.Info("Monthly Exc. Vat column is not displayed");
        			Assert.assertTrue(false);
        		}
        		
        		if (UpfrontExclVat.isDisplayed()){
        			report.Info("Upfront Exc. Vat column is displayed");
        		}
        		else if (!UpfrontExclVat.isDisplayed()){
        			report.Info("Upfront Exc. Vat column is not displayed");
        			Assert.assertTrue(false);
        		}
        		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        		break;
    		}
    	//Code to handle Split Delivery view (only for DTC flow)	
    		if(UpdateReservation.isCurrentlyVisible()) {
    			Thread.sleep(5000);
            	if (DeliverToCustomer.isCurrentlyVisible()) {
            		DeliverToCustomer.click();
            	}
            	else if (!DeliverToCustomer.isCurrentlyVisible()) {
            		Thread.sleep(5000);
            		DeliverToCustomer.click();
            	}
            	Thread.sleep(1000);
            	
            	CheckStock.click();
            	report.Info("Check Stock button clicked");
            	Common.WaitForClock(ClockObj);
            	Common.HandleErrorPopUp("All selected product are available on");
            	
            	/*Thread.sleep(2000);
            	CommonEnh.selectedRow = -1;
    			CommonEnh.locateColumn(applet,table, "Reserved_against", "Warehouse", "0").equals("true");
    			Thread.sleep(1000);
    			PhoneNumber1.type("447123456789");
    			Thread.sleep(1000);
    			CommonEnh.selectedRow = -1;
    			CommonEnh.locateColumn(applet,table, "Reserved_against", "Warehouse", "1").equals("true");
    			Thread.sleep(1000);
    			PhoneNumber1.type("447123456789");*/
    			
            	int	AllPhoneNumber = findAll(By.xpath("//input[@aria-label='Phone number']")).size();
				for(int j=1;j<=AllPhoneNumber;j++){
					if(findBy("(//input[@aria-label='Phone number'])["+j+"]").isCurrentlyVisible()) {
						String sPhoneNumber=findBy("(//input[@aria-label='Phone number'])["+j+"]").getTextValue();
						if (sPhoneNumber.equals("")){
							findBy("(//input[@aria-label='Phone number'])["+j+"]").type("447891234657");
		            	}
						
						break;
					}
				}
				
    			UpdateReservation.click();
    			Common.WaitForClock(ClockObj);
    			report.Info("Update Reservation button clicked");
    			Thread.sleep(2000);
    			
    			//DeliveryMethodList.type(sDeliveryMethod);
    			Thread.sleep(2000);
    			
    			ConfirmButtonSplitDelivery.click();
    			Common.WaitForClock(ClockObj);
    			report.Info("Confirm button clicked");
    			Thread.sleep(6000);
    			FulfilmentSummaryBackButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			if (FulfilmentNextButton.isCurrentlyEnabled()){
    				FulfilmentNextButton.click();
    				report.Info("Fulfilment Next button clicked");
    			}
    			else if (!FulfilmentNextButton.isCurrentlyEnabled()){
    				Thread.sleep(5000);
    				FulfilmentNextButton.click();
    				report.Info("Fulfilment Next button clicked");
    			}
    			
    			return;
    		}
        	
    		UpdateReservationButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
        	
        	DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();	      
			@SuppressWarnings("deprecation")
			int Day=currentDate.getDay();
			if(Day>4){
				calendar.add(calendar.DAY_OF_MONTH, 3);			  
			}
			else{
				calendar.add(calendar.DAY_OF_MONTH, 1);			   
			}
			String sDeliveryDate=dateFormat.format(calendar.getTime());

        	if (sDeliveryOption.equalsIgnoreCase("DeliveryToCustomer")){
        		if (deliveryToCustRadioButton.isCurrentlyVisible()){
        			deliveryToCustRadioButton.click();
        			Thread.sleep(2000);
        			Common.WaitForClock(ClockObj);
        			
        			if(ErrorTitleBox.isCurrentlyVisible()){
		    			String ErrorInfo= ErrorMsg.getText();
		    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    			ErrorOkButton.click();
		    			Thread.sleep(2000);
		    			Common.WaitForClock(ClockObj);
		    			report.Info("The alert meaasage is:"+ErrorInfo);
		    			
		    			}
        			if(ErrorTitleBox.isCurrentlyVisible()){
		    			String ErrorInfo= ErrorMsg.getText();
		    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    			ErrorOkButton.click();
		    			Thread.sleep(2000);
		    			Common.WaitForClock(ClockObj);
		    			report.Info("The alert meaasage is:"+ErrorInfo);
		    			
		    			}
		           	
        			deliveryToCustRadioButton.click();//2 clicks workaround
        			Thread.sleep(2000);
        			Common.WaitForClock(ClockObj);
        			ReserveAgainstCell.click();
        			
        		}
        		else if (!deliveryToCustRadioButton.isCurrentlyVisible()){
        			report.Info("Delivery to Customer Radio buttion is not enabled.");
        			Assert.assertTrue(false);
        		}
        	}

        	if (sDeliveryOption.equalsIgnoreCase("CollectFromStoreStock")){		          
        		if (CollectFromStoreStockRadioButton.isCurrentlyVisible())
        			CollectFromStoreStockRadioButton.click();
	        		Thread.sleep(2000);
	        		Common.WaitForClock(ClockObj);
	        		if(ErrorTitleBox.isCurrentlyVisible()){
		    			String ErrorInfo= ErrorMsg.getText();
		    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    			ErrorOkButton.click();
		    			Common.WaitForClock(ClockObj);
		    			report.Info("The alert meaasage is:"+ErrorInfo);
		    			
		    			}
	        		CollectFromStoreStockRadioButton.click();
	        		StorePostCode.type(sStorePostCode);
	        		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	        		StoreAddress.click();
	        		StoreAddress.type(sStoreAddress);
	        		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	        		StorePostCode.click();
	        		AddressIcon.click();
	        		AddressSelection.click();
	        		CheckStockButton.click();
	        		Thread.sleep(3000);
	        		Common.WaitForClock(ClockObj);
	        		if(isAlertPresent(getDriver()))
	        		{
	        			getDriver().switchTo().alert().accept();
	        			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	        		}
	        		if(ErrorTitleBox.isCurrentlyVisible()){
		    			String ErrorInfo= ErrorMsg.getText();
		    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    			ErrorOkButton.click();
		    			Common.WaitForClock(ClockObj);
		    			report.Info("The alert meassage is:"+ErrorInfo);
		    			
		    			}
	        		
        		}

        	if (sDeliveryOption.equalsIgnoreCase("DeliveryToStore")){		          
        		if (DeliverToStoreRadioButton.isCurrentlyVisible())
        			DeliverToStoreRadioButton.click();
        			Common.WaitForClock(ClockObj);
        			Thread.sleep(2000);
        			if(ErrorTitleBox.isCurrentlyVisible()){
		    			String ErrorInfo= ErrorMsg.getText();
		    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    			ErrorOkButton.click();
		    			Common.WaitForClock(ClockObj);
		    			report.Info("The alert meaasage is:"+ErrorInfo);
		    			
		    			}
        			DeliverToStoreRadioButton.click();
        			StorePostCode.type(sStorePostCode);
        			StoreAddress.click();
        			StoreAddress.typeAndTab(sStoreAddress);
        			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        			StorePostCode.click();
        			CheckStockButton.click();
        			Common.WaitForClock(ClockObj);
        			
        			Thread.sleep(2000);
        			if(isAlertPresent(getDriver()))
        					{
        						getDriver().switchTo().alert().accept();	
        						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        					}		
        	}	        			          	        		                   	 
        
        	if(!sDeliveryOption.equalsIgnoreCase("No")){
        		UpdateReservationButton.click();
        		Common.WaitForClock(ClockObj);
    			Thread.sleep(10000);
    			 Common.WaitForClock(ClockObj);
    			 if(isAlertPresent(getDriver())){
  					Alert alert = getDriver().switchTo().alert();
  					String ActAlertText = alert.getText(); 
  													  				  						
  					if (ActAlertText.contains("back order")){
  						alert.accept();
  						System.out.println("alert messsage is"+ActAlertText);
  					}                                                                                       					                    
  				}
    			CommonEnh.selectedRow = -1;
    			Assert.assertTrue(CommonEnh.locateColumn(applet,table, "Reserved_against", sReservedAgainst, "0").equals("true"));
    			report.Info(sReservedAgainst+" details are updated successfully after clicking on Update Reserve Button.");
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	
    			if(!sDeliveryMethod.equals("") ){
    				DeliveryMethodList.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
    				DeliveryMethodList.type(sDeliveryMethod);
    			}
    			if(sDeliveryOption.equalsIgnoreCase("CollectFromStoreStock")){
    				DeliveryMethodList.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
    				String sDeliveryMethodList = DeliveryMethodList.getTextValue();
    				if(sDeliveryMethodList.equalsIgnoreCase("Collect in store")){
    					report.Info("Delivey Method is changed to: "+sDeliveryMethodList);
    				}
    				else{
    					report.Info("Delivery Method not changed. it is : "+sDeliveryMethodList);
		          		Assert.assertTrue(false);
    				}
    			}
    			
    			if (sValidation.equals("PostCodeValidation")) {
    				CheckStockButton.click();
    				PostcodeLabel.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();       		
            		PostcodeLabel.click();
    				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				String sCurrentAddress = PostcodeLabel.getTextValue();
    				Assert.assertTrue("Fail, Postcode populated is not in UpperCase",sCurrentAddress.contains(sStorePostCode.toUpperCase()));
    				report.Info("Postcode populated is in UpperCase");
        			
    			}
    			
    			if (sValidation.equals("AddressLineValdation")) {
    				HouseNumber.click();
    				String sHouseNumber = HouseNumber.getAttribute("aria-readonly");
    				Assert.assertTrue("FAIL, House Number is not readonly ", sHouseNumber.equals("true")  );
        			report.Info(sHouseNumber+"  : House Number is not editable");
        			
        			HouseNumber.click();
    				String sAddressLine1 = AddressLine1.getAttribute("aria-readonly");
    				Assert.assertTrue("FAIL, AddressLine1 is not readonly ", sAddressLine1.equals("true")  );
        			report.Info(sAddressLine1+" : Address Line 1 is not editable");
        			
        			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        	
    			}
    			
    	        DeliveryDate.clear();
    			DeliveryDate.type(sDeliveryDate);        			
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		
    			
        	}
        	
        	/*if(sDeliveryOption.equalsIgnoreCase("No")){
        		UpdateReservationButton.click();
				Thread.sleep(10000);
			}*/
        	PhoneNumber.click();
        	String sPhoneNumber = PhoneNumber.getTextValue();
        	if (sPhoneNumber.equals("")){
        		PhoneNumber.type("447891234657");
        	}
        	report.Info("PhoneNumber clicked");
	        sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        	DeliveryConfirmButton.click();
        	Common.WaitForClock(ClockObj);
	        FulfilmentNextButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
	        FulfilmentNextButton.click();
	        sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	        Common.WaitForClock(ClockObj);
 	}
 	}
 	
}