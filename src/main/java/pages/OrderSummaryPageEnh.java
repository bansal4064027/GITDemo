package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;

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

public class OrderSummaryPageEnh extends PageObject {

	@Steps
	private ReadWorkbook readWorkbook;

	@Steps
	private common Common;

	@Steps
	private commonEnh CommonEnh;

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

	@FindBy(xpath=".//*[@aria-label='Order number:']")
	WebElementFacade OrderNumberTextBox;

	@FindBy(xpath="//button[text()='Order summary'] | //button[text()='Plan order summary'] | //button[text()='Plan summary']")
	WebElementFacade OrderSummaryPage; 

	@FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
	WebElement ClockObj;

	@Step
	public void CaptureOrderNumber() throws InterruptedException, IOException, AWTException{
		Common.waitForPageLoad(getDriver());		
		OrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

		String OrderNumber = OrderNumberTextBox.getTextValue();
		report.Info("Order Number is:  "+OrderNumber);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		  
		Serenity.setSessionVariable("OrderNo").to(OrderNumber);
		Common.WaitForClock(ClockObj);
	}


	@FindBy(xpath=".//*[@aria-label='Your telephone number:']")
	WebElementFacade MSISDNTextBox;
	@FindBy(xpath=".//*[@aria-label='Order type:']")
	WebElementFacade OrderTypeTextBox;
	@FindBy(xpath=".//*[text()='Digital signature']")
	WebElementFacade DigitalSignatureTab;
	@FindBy(xpath=".//*[@aria-label='Skip signature capture']")
	WebElementFacade SkipSignatureButton;
	@FindBy(xpath="(.//*[text()='Skip digital signature'])[2]")
	WebElementFacade SkipDigitalSigPopUp;
	@FindBy(xpath=".//*[@aria-label='Reason']")
	WebElementFacade SignatureSkipReason;
	@FindBy(xpath=".//*[@aria-label='Skip digital signature:Ok']")
	WebElementFacade SignatureSkipOKButton;
	@FindBy(xpath="//div[contains(@class,'Basket')]/button[contains(@title,'Next')]")
	WebElementFacade NextButtonOrderSummaryPage;
	@FindBy(xpath=".//*[@aria-label='Basket:Discard order']")
	WebElementFacade DiscardOrderButtonOrderSummaryPage;
	@FindBy(xpath=".//*[@aria-label='VF_Terms_Conditions']")
	WebElementFacade TermsAndConditionCheckbox;
	@FindBy(xpath=".//*[@aria-label='Reason']//following-sibling::span")
	WebElementFacade SignatureSkipReasonDropDown;
	
	@FindBy(xpath=".//*[@aria-label='Do not email'][@aria-readonly='true']")
    WebElementFacade DoNotEmail;
 	@FindBy(xpath=".//*[@aria-label='Do not market research'][@aria-readonly='true']")
    WebElementFacade DoNotMarketresearch;
 	@FindBy(xpath=".//*[@aria-label='Do not mail'][@aria-readonly='true']")
    WebElementFacade DoNotMail;
 	@FindBy(xpath=".//*[@aria-label='Do not email']")
    WebElementFacade ClickDoNotEmail;
 	@FindBy(xpath=".//*[@aria-label='Do not market research']")
    WebElementFacade ClickDoNotMarketresearch;
 	@FindBy(xpath=".//*[@aria-label='Do not mail']")
    WebElementFacade ClickDoNotMail;
 	@FindBy(xpath=".//*[@aria-label='Do not email'][@value='N']")
 	WebElementFacade BlankDoNotEmail;
 	@FindBy(xpath=".//*[@aria-label='Do not market research'][@value='N']")
    WebElementFacade BlankDoNotMarketresearch;
 	@FindBy(xpath=".//*[@aria-label='Do not mail'][@value='N']")
    WebElementFacade BlankDoNotMail;
 	
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-email-info']")
 	WebElementFacade HoverDoNotEmail;
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-mail-info']")
 	WebElementFacade HoverDoNotMail;
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-market-info']")
 	WebElementFacade HoverDoNotMarketResearch;
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-sms-info']")
 	WebElementFacade HoverDoNotSMS;
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-call-info']")
 	WebElementFacade HoverDoNotOutboundCall;
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-mms-info']")
 	WebElementFacade HoverDoNotMMS;
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-billaccdata-info']")
 	WebElementFacade HoverDoNotUseBillingandData;
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-locdata-info']")
 	WebElementFacade HoverDoNotuseLocation;
 	@FindBy(xpath=".//*[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-oui-service-permi-locdata-info']")
 	WebElementFacade HoverDoNotUseNetworkData;

 	@FindBy(xpath=".//*[@aria-label='Do not SMS'][@value='N']")
 	WebElementFacade BlankDoNotSMS;
 	@FindBy(xpath=".//*[@aria-label='Do not outbound call'][@value='N']")
 	WebElementFacade BlankDoNotOutboundCall;
 	@FindBy(xpath=".//*[@aria-label='Do not MMS'][@value='N']")
 	WebElementFacade BlankDoNotMMS;
 	@FindBy(xpath=".//*[@aria-label='Do not use billing and account data'][@value='N']")
 	WebElementFacade BlankDoNotUseBillingandData;
 	@FindBy(xpath=".//*[@aria-label='Do not use location'][@value='N']")
 	WebElementFacade BlankDoNotuseLocation;
 	@FindBy(xpath=".//*[@aria-label='Do not use network data'][@value='N']")
 	WebElementFacade BlankDoNotUseNetworkData;

 	@FindBy(xpath=".//*[@aria-label='Do not SMS']")
 	WebElementFacade ClickDoNotSMS;
 	@FindBy(xpath=".//*[@aria-label='Do not outbound call']")
 	WebElementFacade ClickDoNotOutboundCall;
 	@FindBy(xpath=".//*[@aria-label='Do not MMS']")
 	WebElementFacade ClickDoNotMMS;
 	@FindBy(xpath=".//*[@aria-label='Do not use billing and account data']")
 	WebElementFacade ClickDoNotUseBillingandData;
 	@FindBy(xpath=".//*[@aria-label='Do not use location']")
 	WebElementFacade ClickDoNotuseLocation;
 	@FindBy(xpath=".//*[@aria-label='Do not use network data']")
 	WebElementFacade ClickDoNotUseNetworkData;

 	@FindBy(xpath=".//*[@aria-label='Do not SMS'][@aria-readonly='true']")
 	WebElementFacade DoNotSMS;
 	@FindBy(xpath=".//*[@aria-label='Do not outbound call'][@aria-readonly='true']")
 	WebElementFacade DoNotOutboundCall;
 	@FindBy(xpath=".//*[@aria-label='Do not MMS'][@aria-readonly='true']")
 	WebElementFacade DoNotMMS;
 	@FindBy(xpath=".//*[@aria-label='Do not use billing and account data'][@aria-readonly='true']")
 	WebElementFacade DoNotUseBillingandData;
 	@FindBy(xpath=".//*[@aria-label='Do not use location'][@aria-readonly='true']")
 	WebElementFacade DoNotuseLocation;
 	@FindBy(xpath=".//*[@aria-label='Do not use network data'][@aria-readonly='true']")
 	WebElementFacade DoNotUseNetworkData;


 	@FindBy(xpath=".//*[@class='vfoui-Order-Contact-Marketing-Permissions vfoui_box_shadow']//*[@aria-label='VF Under Age']")
 	WebElementFacade UnderageBoxPresent;
 	@FindBy(xpath=".//*[@class='vfoui-Order-Contact-Marketing-Permissions vfoui_box_shadow']//*[@aria-label='VF Under Age'][@value='Y']")
 	WebElementFacade UnderageBoxTicked;
 	@FindBy(xpath=".//*[@class='vfoui-Order-Contact-Marketing-Permissions vfoui_box_shadow']//*[@aria-label='VF Under Age'][@value='N']")
 	WebElementFacade UnderageBoxNotTicked;

 	

	@FindBy(xpath=".//span[text()='Marketing permissions']")
    WebElementFacade MarketPermissionLevelPopup;
	
	@FindBy(xpath=".//span[text()='Marketing permissions']/parent::div/following-sibling::div[2]//button")
    WebElementFacade MarketPermissionLevelPopupOKButton;
	

	@FindBy(xpath=".//*[text()='Please select a reason to proceed with the order']")
    WebElementFacade DisconnectionNoReasonPopup;
	
	@Step
	public void ValidateDisconnectionPopUp() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);		
		OrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

		NextButtonOrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		NextButtonOrderSummaryPage.click();
		
		Common.WaitForClock(ClockObj);
		
		if(DisconnectionNoReasonPopup.isCurrentlyVisible()){
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
		
	}
	
	@FindBy(xpath=".//*[@aria-label='Disconnection Reason']") 
	WebElementFacade DisconnectionReasonTextBox;
	
	@Step
	public void OrderSummaryPage() throws InterruptedException, IOException, AWTException{

		/*String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
        String dataSheet = "OrderSummary";
      //  String ProductNumber = Serenity.sessionVariableCalled("PartNo").toString();
        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
        readWorkbook.testData(tableMap);

        for (int i = 0;i < tableMap.get("Row").size();i++) {
        	  String sAction = tableMap.get("Action").get(i);*/

		Common.WaitForClock(ClockObj);		
		//OrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		if(DisconnectionReasonTextBox.isCurrentlyVisible()){
			DisconnectionReasonTextBox.typeAndEnter("Active Expired");
			Thread.sleep(1000);
			Common.WaitForClock(ClockObj);
			report.Info("Disconnection Reason given successfully");
			return;
		}

		//xpath of MSISDNTextBox changed need rework		
		/*String MSISDN = MSISDNTextBox.getTextValue();
				Assert.assertTrue("FAIL, MSISDN not populated",!MSISDN.equals(""));
				report.Info("MSISDN is:  "+MSISDN);*/

		String OrderType = OrderTypeTextBox.getTextValue();
		Assert.assertTrue("FAIL, Order Type not populated",!OrderType.equals(""));
		report.Info("Order Type is:  "+OrderType);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		if (SkipSignatureButton.isCurrentlyVisible()){
			SkipSignatureButton.click();
			Common.WaitForClock(ClockObj);
			SignatureSkipOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

			SignatureSkipReasonDropDown.click();
			Thread.sleep(2000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			SignatureSkipReason.type("Manual contingency");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


			SignatureSkipOKButton.click();
			Common.WaitForClock(ClockObj);
			OrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			report.Info("Digital Signature is skipped");
		}

		if(TermsAndConditionCheckbox.isCurrentlyVisible()){
			TermsAndConditionCheckbox.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			OrderTypeTextBox.click();
		}

		NextButtonOrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		NextButtonOrderSummaryPage.click();
		
		Common.WaitForClock(ClockObj);
		
		if(ErrorMessage.isCurrentlyVisible()){
			String sActErrorMessage = ErrorMessage.getTextValue();
			if(sActErrorMessage.contains("stolen bar")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ErrorMessageOKButton.click();
				Common.WaitForClock(ClockObj);
			}
		}
		
		if(MarketPermissionLevelPopup.isCurrentlyVisible()){
			MarketPermissionLevelPopupOKButton.click();
			Thread.sleep(2000);
		}
		Common.WaitForClock(ClockObj);
		
		
		report.Info("Next Button is clicked in Order Summary Page. ");
		Common.WaitForClock(ClockObj);

	}



	@FindBy(xpath=".//*[contains(@aria-label,'Discard order')]")
	WebElementFacade DiscardOrderButton;
	@FindBy(xpath="(.//span[text()='Discard order'])[2]")
	WebElementFacade DiscardOrderPopup;
	@FindBy(xpath=".//*[contains(@aria-label,'Tell us a reason')]")
	WebElementFacade DiscardReason;
	@FindBy(xpath=".//*[contains(@aria-label,'Tell us a reason')]//following-sibling::span")
	WebElementFacade DiscarReasonDropdownButton;
	@FindBy(xpath=".//*[@aria-label='Abandon order:Ok']")
	WebElementFacade DiscardOKButton;
	@FindBy(xpath=".//*[@aria-label='Email order customer summary']")
	WebElementFacade SendCustomerSummaryCheckbox;

	@FindBy(xpath=".//li[text()='Call abandoned']")
	WebElementFacade CallAbandonedReason;
	@Step
	public void CancelOrder() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		DiscardOrderButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		
		if(findBy(".//td[text()='Total']/following-sibling::td[contains(@aria-describedby,'Gross_Price')]").isCurrentlyVisible()){
			String sTotalUpfrontCost = findBy(".//td[text()='Total']/following-sibling::td[contains(@aria-describedby,'Gross_Price')]").getTextValue();
			Serenity.setSessionVariable("TotalUpfrontCost").to(sTotalUpfrontCost);			
		}
		
		if(findBy(".//td[text()='Total']/following-sibling::td[contains(@aria-describedby,'MRC_CxTotal')]").isCurrentlyVisible()){
			String sTotalMonthlyCost = findBy(".//td[text()='Total']/following-sibling::td[contains(@aria-describedby,'MRC_CxTotal')]").getTextValue();
			Serenity.setSessionVariable("TotalMonthlyCost").to(sTotalMonthlyCost);			
		}
		
		
		DiscardOrderButton.click();
		Common.WaitForClock(ClockObj);
		DiscardOrderPopup.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		///////DiscarReasonDropdownButton.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	//	DiscardReason.type("Call abandoned");
		DiscarReasonDropdownButton.click();
		Common.WaitForClock(ClockObj);
		Thread.sleep(1000);
		CallAbandonedReason.click();
		
		Thread.sleep(2000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(SendCustomerSummaryCheckbox.isCurrentlyEnabled()){
			SendCustomerSummaryCheckbox.click();
			Common.WaitForClock(ClockObj);
		}
		
		DiscardOKButton.click();

		DiscardOrderButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

		report.Info("Order is discarded ");
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	}	
	@FindBy(xpath="//button[text()='Show technical items']")
	WebElementFacade ShowTechnicalItemsButton;

	@FindBy(xpath="//*[@id='vf-cmp-addret-btn']")
	WebElementFacade AddRetainedLink;

	@FindBy(xpath="//*[@id='vf-cmp-del-btn']")
	WebElementFacade DeleteLink;

	@FindBy(xpath="//div[contains(@class,'Basket')]/button[contains(@title,'Next')]")
	WebElementFacade NextButton;

	@FindBy(xpath=".//span[text()='Error message']")
	WebElementFacade ErrorMessagebox;

	@FindBy(xpath="(.//div[@class='vf-oui-dialog-content'])[2]")
	WebElementFacade ErrorMessage;
	
	@FindBy(xpath="(.//button/span[text()='Ok'])[2]")
	WebElementFacade ErrorMessageOKButton;
	
	@FindBy(xpath=".//*[@aria-label='Basket:Restart']")
	WebElementFacade RestartButton;
	@FindBy(xpath=".//*[contains(text(),'Restart order')]")
	WebElementFacade RestartOrderPopUp;
	@FindBy(xpath=".//*[contains(@id,'confirm-dialog')]/div[2]/div[1]")
	WebElementFacade PopupMessage;
	@FindBy(xpath=".//*[contains(text(),'Restart order')]/parent::div/following-sibling::div[2]//span[contains(text(),'Ok')]")
	WebElementFacade RestartOrderPopUpOKButton;
	@FindBy(xpath="(.//*[@class='vfoui-select-options-div vfoui-ao-product-services-dropdown-enabled']//following-sibling::span)[1]") 
	WebElementFacade SelectActionListButton;
	
	@FindBy(xpath=".//*[@aria-describedby='s_5_l_Product']")
	WebElementFacade Totalicon;
	
	@FindBy(xpath="(.//*[text()='Red items in the basket are being returned, exchanged or disconnected; black items are the ones being added or retained.'])[3]")
	WebElementFacade HoveringTotalIcon;
	
	@FindBy(xpath=".//*[@placeholder='Select a reason']")
	WebElementFacade ReturnDropdown;
	@FindBy(xpath=".//*[text()='This order contains a device to be returned']")
	WebElementFacade ReturnDevicePopup;
	@Step
	public void CompareLineItems(String LogicalName) throws InterruptedException, IOException, AWTException{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
		String dataSheet = "CompareLineItems";
		String applet = "//*[contains(@title,'Compare line items List Applet')]";
		String table = "//table[@summary='Compare line items']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		
		Common.WaitForClock(ClockObj);
		if(ReturnDevicePopup.isCurrentlyVisible()){
			String Message = ReturnDevicePopup.getTextValue();
			if(Message.contains("This order contains a device to be returned")){
				ErrorMessageOKButton.click();
			}
			}
		//AddRetainedLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		if (ShowTechnicalItemsButton.isCurrentlyVisible() ){
			Common.WaitForClock(ClockObj);
			ShowTechnicalItemsButton.click();
			report.Info("ShowTechnicalItemsButton is clicked");
		}

		for (int i = 0;i < tableMap.get("Row").size();i++) {
						       
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      				
			String Index = tableMap.get("Index").get(i);				
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);
			String sReason = tableMap.get("Reason").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			
			String sHoveringMsg = tableMap.get("HoveringMsg").get(i);
			
			if (sPopup.equals("")){
				sPopup = "No";
			}
			Thread.sleep(1000);
			
			if (sLocateColValue.contains("Promotion")  ){
				sLocateColValue = sLocateColValue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());
			} 
			
			if (sLocateColValue.contains("RootProduct0")){
				sLocateColValue = sLocateColValue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());
			}
			
			if (sLocateColValue.contains("Handset")){
				sLocateColValue = sLocateColValue.replace("Handset", Serenity.sessionVariableCalled("Handset").toString());
			}
			
			if (sLocateColValue.contains("ACCNTMSISDN")){
				sLocateColValue = sLocateColValue.replace("ACCNTMSISDN", Serenity.sessionVariableCalled("ACCNTMSISDN").toString());    	  
				
			}
			
			if (sLocateColValue.equals("MSISDN")){
				sLocateColValue = sLocateColValue.replace("MSISDN", Serenity.sessionVariableCalled("MSISDN").toString());    	  
			}
			
			if (Index.equals("")){
				Index = "0";
			}      
			
			if (sAction.equals("Add")){
				AddRetainedLink.click();
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);
				report.Info("Add Button clicked successfully");
				
				if(sValidation.equalsIgnoreCase("TotaliconClick")){
					Totalicon.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					String CapturedMessage = HoveringTotalIcon.getTextValue();
					
					if(CapturedMessage.equals(sHoveringMsg))
					{
					report.Info("Captured Message is: "+CapturedMessage);
					}
					else {
	                      Assert.assertTrue("Hovering Total Icon is currently not visible after clicking onTotal icon..", HoveringTotalIcon.isVisible());
					}
					
				}
			}
			
			if (sAction.equals("Delete")){
				DeleteLink.click();
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);
				report.Info("Delete Button clicked successfully");
			}	
			
			if (sAction.equals("Restart")){
				RestartButton.click();
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);
				report.Info("RestartButton Button clicked successfully");
				
				if (RestartOrderPopUp.isCurrentlyVisible()){
					String ErrorInfo= PopupMessage.getText();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					
					report.Info("The alert meassage is:"+ErrorInfo);
					RestartOrderPopUpOKButton.waitUntilClickable();  
					RestartOrderPopUpOKButton.click();
					
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);
					
					SelectActionListButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					return;
				}
				else{
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 report.Info("RestartOrderPopUp did not occur");
					 Assert.assertTrue(false);              
				}
			
			}
			
			
			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{               
				CommonEnh.selectedRow = 1;
			}

			if (!sUIName.equals("")){ 
				CommonEnh.updateSiebList(applet,table, sUIName, svalue); 
				report.Info("Row updated successfully"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			} 
			if(sReason.equalsIgnoreCase("Financial reasons"))
			{
				Thread.sleep(2000);
				ReturnDropdown.typeAndEnter(sReason);
				Thread.sleep(3000);
			}
			if (sAction.equals("Next")){
				NextButton.click();
				Common.WaitForClock(ClockObj);
				report.Info("Next Button clicked successfully");
			}
			
			if(!sPopup.equalsIgnoreCase("No")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(ErrorMessagebox.isVisible()){
					String Message = ErrorMessage.getTextValue();
					if(Message.contains(sPopup)){
						ErrorMessageOKButton.click();
					}
					else{
						report.Info("Expected Pop did not occur");
						Assert.assertTrue(false); 
					}
				}
				else{
					report.Info("Expected Pop did not occur");
					Assert.assertTrue(false); 
				}
			}
			
			if(sValidation.equalsIgnoreCase("CompareLineItemsApplet")){
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Compare Line Items View is not present",findBy(applet).isVisible());
				report.Info("Compare Line Items View is present");
			}
			
		}
	}

	@Step
	public void ValidateDigitalSignatureApplet() throws InterruptedException, IOException, AWTException{
		// this function checks that digital signature applet should not be visible for call centre login 
		Common.WaitForClock(ClockObj);	
		OrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

		Assert.assertTrue("FAIL, Digital Signature Applet is present for Call Centre Agents.",!SkipSignatureButton.isCurrentlyVisible());
		report.Info("Digital Signature Applet is not present for Call Centre Agents.");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	

		if(TermsAndConditionCheckbox.isCurrentlyVisible()){
			TermsAndConditionCheckbox.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
	}

	
	@FindBy(xpath=".//button[@title='Basket:Override price']")
	WebElementFacade OverridePriceButton;
	
	@FindBy(xpath=".//*[@aria-labelledby='DiscountPercent_Label']")
	WebElementFacade DiscountPercentTextBox;
	
	@FindBy(xpath=".//button[@title='Override price:OK']")
	WebElementFacade OverridePriceOKButton;
	
	@Step
	public void OverridePriceDiscount(String Rownum) throws InterruptedException, IOException, AWTException{

		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
		String dataSheet = "OverridePriceDiscount";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Rownum, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		OverridePriceButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		OverridePriceButton.click();
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		for (int i = 0;i < tableMap.get("Action").size();i++) {
			String sAction = tableMap.get("Action").get(i);
			String sDiscountPercent = tableMap.get("DiscountPercent").get(i);
			String sPopup = tableMap.get("Popup").get(i);

			if(sAction.equalsIgnoreCase("EnterDiscount")){
				DiscountPercentTextBox.type(sDiscountPercent);
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	
			}

			OverridePriceOKButton.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Common.HandleErrorPopUp(sPopup);
		}


	}	
	
	@FindBy(xpath=".//button[text()='Compare line items']")
	WebElementFacade CompareLineItemsTab;
	
	@FindBy(xpath=".//button[text()='Fulfilment'][contains(@class,'color-grey')]")
	WebElementFacade FulfilmentTabGreyedOut;
	
	@Step
	public void NavigateToCompareLineItems() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		CompareLineItemsTab.click();
		Common.WaitForClock(ClockObj);
		NextButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Assert.assertTrue("FAIL:Fulfilment Tab is not greyed out after navigating backward",FulfilmentTabGreyedOut.isVisible()); 
		
	}

	
	@FindBy(xpath=".//button[@aria-label='Capture signature']")
	WebElementFacade CaptureSignatureButton;
	
	@FindBy(xpath=".//canvas[@class='siebui-ctrl-pad vfoui-digital-signature-canvas']")
	WebElementFacade SignatureCanvas;
	
	@FindBy(xpath=".//button[@aria-label='Save']")
	WebElementFacade SaveSignatureButton;
	
	@FindBy(xpath=".//button[contains(@class,'closesignature')]")
	WebElementFacade CloseSignatureButton;

	@FindBy(xpath=".//canvas[@class='siebui-ctrl-pad vfoui-digital-signature-canvas vf-oui-pointer-none']")
	WebElementFacade SignatureDoneCanvas;
	
	@Step
	public void DrawDigitalSignature() throws InterruptedException, IOException, AWTException{
		
		CaptureSignatureButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		CaptureSignatureButton.click();
		Thread.sleep(4000);
		SignatureCanvas.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Actions builder = new Actions(getDriver());
		builder.clickAndHold(SignatureCanvas).moveByOffset(10, 50).
		moveByOffset(50,10).
		moveByOffset(-10,-50).
		moveByOffset(-50,-10).release().perform();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		SaveSignatureButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		SaveSignatureButton.click();
		Common.WaitForClock(ClockObj);
		Thread.sleep(10000); //dont delete
       
		if(CloseSignatureButton.isCurrentlyVisible())
        {
		CloseSignatureButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		CloseSignatureButton.click();
		Common.WaitForClock(ClockObj);
        }
		SignatureDoneCanvas.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
		
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		
		if(TermsAndConditionCheckbox.isCurrentlyVisible()){
			TermsAndConditionCheckbox.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			OrderTypeTextBox.click();
		}

		NextButtonOrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		NextButtonOrderSummaryPage.click();
		
		Common.WaitForClock(ClockObj);
		if(MarketPermissionLevelPopup.isCurrentlyVisible()){
			MarketPermissionLevelPopupOKButton.click();
			Thread.sleep(5000);
		}
		Common.WaitForClock(ClockObj);
		
		report.Info("Next Button is clicked in Order Summary Page. ");
		Common.WaitForClock(ClockObj);
		
	}
	
	@FindBy(xpath=".//input[contains(@aria-labelledby,'Order_Status_Message_Calc2')]")
	WebElementFacade OrderStatus;
	
	@FindBy(xpath=".//*[@aria-label='Order status:Ok']")
	WebElementFacade OrderStatusOKButton;
	
	@FindBy(xpath=".//*[@aria-label='Summary:Submit changes']")
	WebElementFacade SubmitChangesButton;
	
	@Step
	public void SubmitChanges() throws InterruptedException, IOException, AWTException{
 		
		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		
 		SubmitChangesButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 		SubmitChangesButton.click();
 		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 	

 		OrderStatusOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 		
 
 		String Order_Status = OrderStatus.getTextValue();
 		report.Info("Order Status is : "+Order_Status);	
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		OrderStatusOKButton.click();
 		
 		report.Info("Order is  created");
 		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
 		
	
	
	
	@Step
	public void DisconnectionReasonAndNext() throws InterruptedException, IOException, AWTException{
 		
		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		DisconnectionReasonTextBox.type("No Reason ");
 		Common.WaitForClock(ClockObj);
 		
 		NextButtonOrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		NextButtonOrderSummaryPage.click();
		
		Common.WaitForClock(ClockObj);
	}
	
	@Step
	public void NotificationCheckForMinor() throws InterruptedException, IOException, AWTException{
	
		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		
 		if(UnderageBoxPresent.isPresent()) {

 			if(UnderageBoxNotTicked.isPresent()) {
 				UnderageBoxPresent.click();
 				report.Info("Underage is Clicked.");
 				HoverDoNotMail.click();
 				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 			}
 		}

		
 		HoverDoNotMail.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		DoNotMail.isCurrentlyVisible();
 		report.Info("DoNotMail Notification is Disabled");
 		
 		HoverDoNotMarketResearch.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		DoNotMarketresearch.isCurrentlyVisible();
 		report.Info("DoNotMarketresearch Notification is Disabled");
 		
 		HoverDoNotEmail.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		DoNotEmail.isCurrentlyVisible();
 		report.Info("DoNotEmail Notification is Disabled");
 		
		HoverDoNotSMS.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		DoNotSMS.isCurrentlyVisible();
 		report.Info("DoNotSMS Notification is Disabled");

		HoverDoNotOutboundCall.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		DoNotOutboundCall.isCurrentlyVisible();
 		report.Info("DoNotOutboundCall Notification is Disabled");

		HoverDoNotMMS.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		DoNotMMS.isCurrentlyVisible();
 		report.Info("DoNotMMS Notification is Disabled");

		HoverDoNotUseBillingandData.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		DoNotUseBillingandData.isCurrentlyVisible();
 		report.Info("DoNotUseBillingandData Notification is Disabled");

		HoverDoNotuseLocation.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		DoNotuseLocation.isCurrentlyVisible();
 		report.Info("DoNotuseLocation Notification is Disabled");

		HoverDoNotUseNetworkData.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		DoNotUseNetworkData.isCurrentlyVisible();
 		report.Info("DoNotMail Notification is Disabled");

	
	}
	
	
	@Step
	public void NotificationCheckForMajor() throws InterruptedException, IOException, AWTException{
		
		ClickDoNotEmail.waitUntilClickable();

		HoverDoNotEmail.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotEmail.isPresent()) {
			ClickDoNotEmail.click();}

		HoverDoNotMarketResearch.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotMarketresearch.isPresent()){
			ClickDoNotMarketresearch.click();
		}

		HoverDoNotMail.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotMail.isPresent()){
			ClickDoNotMail.click();}

		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		report.Info("Contact Marketing Permissions DONotMail , DONotMarketResearch and DONotEmail are Enabled and selected");

		HoverDoNotSMS.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotSMS.isPresent()) {
			ClickDoNotSMS.click();
		}

		HoverDoNotOutboundCall.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotOutboundCall.isPresent()) {
			ClickDoNotOutboundCall.click();
		}

		HoverDoNotMMS.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotMMS.isPresent()) {
			ClickDoNotMMS.click();
		}

		HoverDoNotUseBillingandData.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotUseBillingandData.isPresent()) {
			ClickDoNotUseBillingandData.click();
		}

		HoverDoNotuseLocation.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotuseLocation.isPresent()) {
			ClickDoNotuseLocation.click();
		}

		HoverDoNotUseNetworkData.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(BlankDoNotUseNetworkData.isPresent()) {
			ClickDoNotUseNetworkData.click();
		}

		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		report.Info("Service Marketing Permissions DoNotSMS , DoNotOutboundCall ,DoNotUseBillingandData , DoNotuseLocation, DoNotUseNetworkData and DoNotOutboundCall are Enabled and selected");	
	
		
	}
	
	@Step
	public void VoxiAccountLimit() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);		

		String OrderType = OrderTypeTextBox.getTextValue();
		Assert.assertTrue("FAIL, Order Type not populated",!OrderType.equals(""));
		report.Info("Order Type is:  "+OrderType);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		if(TermsAndConditionCheckbox.isCurrentlyVisible()){
			TermsAndConditionCheckbox.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			OrderTypeTextBox.click();
		}
		NextButtonOrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		NextButtonOrderSummaryPage.click();

		Common.WaitForClock(ClockObj);
		report.Info("Next Button is clicked in Order Summary Page. ");
		Common.WaitForClock(ClockObj);

		if(MarketPermissionLevelPopup.isCurrentlyVisible()){
			MarketPermissionLevelPopupOKButton.click();
			Thread.sleep(5000);
		}

		Alert alert;
		String ActAlertText="";	
		if(isAlertPresent(getDriver())){
			alert=getDriver().switchTo().alert();
			ActAlertText=alert.getText(); 
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			if (ActAlertText.contains("[114] Eligibility Rule Issue ---110405-VOXI SIM package")){                     	
				// alert.accept();
				System.out.println("Message is: "+ActAlertText);
				report.Info("alert messsage is"+ActAlertText);		 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}
			else
			{
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue(false);              
			}
		}
	}



	@FindBy(xpath=".//*[contains(@aria-label,'Do not use third party')]")
 	WebElementFacade ThirdPartySocialCheckBox;
 	@FindBy(xpath=".//span[contains(@class,'-permi-socialmedia-info')]")
 	WebElementFacade ThirdPartySocialToolTip;
 	@FindBy(xpath=".//div[contains(text(),'When ticked this means the customer has not given permission for Vodafone to use third party social media and apps data for marketing purposes')]")
 	WebElementFacade ThirdPartySocialToolTipContent;
 	@FindBy(xpath=".//*[text()='Marketing permissions history']")
 	WebElementFacade MarketingPermissionHistoryButton;
 	
	@Step
	public void OrderSummaryValidation(String LogicalName) throws IOException, InterruptedException, AWTException{

		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
		String dataSheet = "OrderSummaryValidation";
		Actions action = new Actions(getDriver());
		
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		for (int i = 0;i < tableMap.get("RowNo").size();i++) {
			
		//	String sToolTipMessage = tableMap.get("ToolTipMessage").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Common.WaitForClock(ClockObj);
			
			if(sValidation.equalsIgnoreCase("CheckEditable")) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", ThirdPartySocialCheckBox);
				String Readonly = ThirdPartySocialCheckBox.getAttribute("aria-readonly");
				String Checked = ThirdPartySocialCheckBox.getAttribute("aria-checked");

				Assert.assertTrue("Fail, Third Party Social Marketing Permission CheckBox is Checked",Checked.equalsIgnoreCase("false"));
				report.Info("Third Party Social Marketing Permission CheckBox is Not checked");

				Assert.assertTrue("Fail, Third Party Social Marketing Permission CheckBox is not Editable",Readonly.equalsIgnoreCase("false"));
				report.Info("Third Party Social Marketing Permission CheckBox is Editable");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			
				action.moveToElement(ThirdPartySocialToolTip).perform();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				Assert.assertTrue("Fail, Tool tip text is not as expected",ThirdPartySocialToolTipContent.isPresent());
				report.Info("Tool Tip value for Third Party Social Marketing Permission CheckBox is :When ticked this means the customer has not given permission for Vodafone to use third party social media and apps data for marketing purposes ");


				//ThirdPartySocialCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				break;
			}

			if(sValidation.equalsIgnoreCase("CheckNotEditable")) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", ThirdPartySocialCheckBox);
				String Readonly = ThirdPartySocialCheckBox.getAttribute("aria-readonly");
				String Checked = ThirdPartySocialCheckBox.getAttribute("aria-checked");

				Assert.assertTrue("Fail, Third Party Social Marketing Permission CheckBox is not Checked",Checked.equalsIgnoreCase("true"));
				report.Info("Third Party Social Marketing Permission CheckBox is  Checked");


				Assert.assertTrue("Fail, Third Party Social Marketing Permission CheckBox is Editable",Readonly.equalsIgnoreCase("true"));
				report.Info("Third Party Social Marketing Permission CheckBox is not Editable");

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			break;
			}		 
		
		}
	}
	
	@FindBy(xpath="(.//*[@class='siebui-icon-tb-reports ToolbarButtonOn'])[1]")	
	WebElementFacade ReportButton;
	
	@FindBy(xpath=".//*[@title='Run Report:Submit']")
	WebElementFacade SubmitButtonReports;

	@FindBy(xpath=".//*[@class='siebui-button-toolbar siebui-closed']")
	WebElementFacade Iconbar;
	
	@FindBy(xpath=".//*[@aria-labelledby='Report_Name_Label']")
	WebElementFacade ReportNameList;
	
	@Step
	public void HaloGenerateContractReportSave() throws InterruptedException, IOException, FindFailed, AWTException{
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		Common.WaitForClock(ClockObj);
		Thread.sleep(4000);
		Common.WaitForClock(ClockObj);
		
		if(ReportButton.isCurrentlyVisible()){                    
			ReportButton.click();
			Thread.sleep(2000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		}else
		{                     	
			Common.waitForPageLoad(getDriver());
			Iconbar.click();
			Thread.sleep(3000);
			ReportButton.click();
			Thread.sleep(1000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}

		report.Info("Report Button clicked");
		Common.waitForPageLoad(getDriver());

		ReportNameList.selectByVisibleText("Generate Contract");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Thread.sleep(1000);
		SubmitButtonReports.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Thread.sleep(30000);

		//Screen s=new Screen();

		sikuliUtility.HaloGenerateContractReport(SikulifilePath);
	}
	
	@FindBy(xpath="//*[text()='Equipment subsidy:']/ancestor::div/following-sibling::div[contains(@class,'tupl-field')]//label")
	WebElementFacade EquipmentSubsidyValue;

	@Step
	public void ValidateDecimalForEquipmentSubsidy () throws IOException, AWTException, InterruptedException{

		Common.WaitForClock(ClockObj);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", EquipmentSubsidyValue); 
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		
			String actualEquipmentSubsidyValue =EquipmentSubsidyValue.getText(); 	            	
			String[] arr1 = actualEquipmentSubsidyValue.split("\\.");
			String DecimalValues = arr1[1];
			int DecimalLength =DecimalValues.length();
			Assert.assertTrue("The Equipment Subsidy value"+actualEquipmentSubsidyValue+" has incorrect decimal place, expected is 2 decimal place", DecimalLength==2);
			report.Info("The Equipment Subsidy value "+actualEquipmentSubsidyValue+" has correct decimal place i.e. 2");
	
	}	
}

