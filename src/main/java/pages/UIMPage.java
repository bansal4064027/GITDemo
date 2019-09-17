package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.SikuliUtility;
import utilities.common;

public class UIMPage extends PageObject{
	private static final TimeUnit SECONDS = null;
	@Steps
	private ReadWorkbook readWorkbook;
	@Steps
	private SikuliUtility SikuliUtility;

	@Steps
	private common Common;
	
	@Steps
	ReportMessege report;

	
	@FindBy(xpath = "//table/tbody/tr/td/span[text()='Communications Unified Inventory Management']")
	WebElementFacade UIMHomePageHeading;
	
	@FindBy(xpath = "//li/a[text()='Services']")
	WebElementFacade ServicesLink;
	
	@FindBy(xpath = "//span[text()='rch']")
	WebElementFacade SearchBtn;
	
	@FindBy(xpath = "(//td[@class='x51']/table/tbody/tr)[4]/td[4]//input")
	WebElementFacade MSISDNInputTB;
	
	@FindBy(xpath = "(//div[@aria-label='Table Displaying Search Results For Services']/div)[2]/div[text()='No data to display.']")
	WebElementFacade NoRowDisplayedOnMSISDNSearchPromptMessage;
	
	

	//clicks on services link in LHN , searches for MSISDN and validates if it is present in UIM
	@Step
	public void validateMSISDNisPresentInUIM(String MSISDN) throws IOException, InterruptedException, AWTException {
		
		if(UIMHomePageHeading.withTimeoutOf(10, TimeUnit.SECONDS).isCurrentlyVisible()) {
			ServicesLink.click();
			report.Info("Services link clicked");
		}
		
		else {
			report.Info("UIM Homepage not loaded");
			Assert.assertFalse("Failed: UIM homepage not loaded", false);
		}
		String sMSISDN;
		
		if(!MSISDN.equalsIgnoreCase("")) {
			sMSISDN = MSISDN;
			Serenity.setSessionVariable("MSISDN").to(MSISDN);
		}
		else {
			sMSISDN = Serenity.sessionVariableCalled("MSISDN").toString();
		}
	
		
		
		
		if(MSISDNInputTB.withTimeoutOf(10, TimeUnit.SECONDS).isCurrentlyVisible()) {
			if(MSISDNInputTB.withTimeoutOf(5, TimeUnit.SECONDS).isCurrentlyEnabled()) {
				MSISDNInputTB.sendKeys(sMSISDN);
			}
			
		}
		
		else {
			report.Info("MSISDN text box not visible");
		}
		
		//Clicking on Search Button
		SearchBtn.click();
		
		
		if(!NoRowDisplayedOnMSISDNSearchPromptMessage.withTimeoutOf(10, TimeUnit.SECONDS).isPresent()) {
			Assert.assertTrue("No search result for MSISDN " + sMSISDN, true);
			report.Info("MSISDN is present in UIM");
		}
		
		
	}
	
	
	@FindBy(xpath = "//li/a[text()='Logical Devices']")
	WebElementFacade LogicalDevicesLink;
	
	@FindBy(xpath = "((//table[@class='x1u'])[6]/tbody/tr/td)[2]/input")
	WebElementFacade ICCIDSearchTextBox;
	
	@FindBy(xpath = "//div/a/span[text()='Se']")
	WebElementFacade ICCIDSearchBtn;
	
	@FindBy(xpath = "(//div[@aria-label='Table Displaying Search Results For Logical Devices']/div)[2]//td/span/a/span")
	WebElementFacade LogicalDevicesSerachResultIDLink;
	
	@FindBy(xpath = "((//div[@aria-label='Table Listing Logical Device Accounts']/div)[2]//td)[2]/span")
	WebElementFacade IMSIcell;
	
	@Step
	public void captureIMSI(String ICCID) {
		
		String sICCID = "";
		
		if(!ICCID.equalsIgnoreCase("")) {
			sICCID = ICCID;
			Serenity.setSessionVariable("ICCID").to(sICCID);
		}
		else {
			sICCID = Serenity.sessionVariableCalled("ICCID").toString();
		}
		
		
		if(UIMHomePageHeading.withTimeoutOf(10, TimeUnit.SECONDS).isCurrentlyVisible()) {
			LogicalDevicesLink.click();
			report.Info("Logical Devices link clicked");
		}
		
		else {
			report.Info("UIM Homepage not loaded");
			Assert.assertFalse("Failed: UIM homepage not loaded", false);
		}
		
		ICCIDSearchTextBox.sendKeys(sICCID);
		
		ICCIDSearchBtn.click();
		
		LogicalDevicesSerachResultIDLink.click();
		String sIMSI = "";
		 sIMSI = IMSIcell.getText();
		 Serenity.setSessionVariable("IMSI").to(sIMSI);
		report.Info("IMSI: " + sIMSI );
		
	}
	

}
