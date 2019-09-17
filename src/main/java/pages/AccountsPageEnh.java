package pages ;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.validation.constraints.Pattern.Flag;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

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


@SuppressWarnings("deprecation")
public class AccountsPageEnh extends PageObject {
	@Steps
	private ReadWorkbook readWorkbook;

	@Steps
	private common Common;

	@Steps
	private DatabasePage Database;

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
	@FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
	WebElement ClockObj;
	@FindBy(xpath=".//*[@data-tabindex='tabScreen0']")
	WebElementFacade Homepage;
	//@FindBy(xpath=".//*[@title='Accounts']")
	@FindBy(xpath=".//*[@data-tabindex='tabScreen1']")
	WebElementFacade AccountsTab;
	@FindBy(xpath=".//*[@title='Account Details:New OUI Account']")
	WebElementFacade newOUIAccount;
	@FindBy(xpath="//*[@class='consumer-section-title' and text()='Consumer']")
	WebElementFacade consumerButton;
	@FindBy(xpath="//*[contains(@aria-labelledby,'Limited')]")
	WebElementFacade LtdCompanyButton;
	@FindBy(xpath="(//*[contains(@aria-label,'Trading')])[1]")
	WebElementFacade businessCompanyNameTextBox1;
	@FindBy(xpath="(//*[contains(@aria-label,'Trading')])[2]")
	WebElementFacade businessCompanyNameTextBox2;
	@FindBy(xpath="//*[@class='consumer-section-title' and text()='Small business']")
	WebElementFacade smallBusinessButton;
	@FindBy(xpath="//input[@aria-label='First name']")
	WebElementFacade firstnameEditBox;
	@FindBy(xpath="//input[@aria-label='Last name']")
	WebElementFacade lastNameEditBox;
	@FindBy(xpath="//input[@aria-label='Phone number']")
	WebElementFacade phoneNumberEditBox;
	@FindBy(xpath="//input[@aria-label='Email']")
	WebElementFacade emailEditBox;
	@FindBy(xpath="//input[@aria-label='Domain']")
	WebElementFacade domainEditBox;
	@FindBy(xpath=".//input[@aria-label='Confirm email address']")
	WebElementFacade email1EditBox;
	@FindBy(xpath="//input[@aria-label='ReType Domain']")
	WebElementFacade domain1EditBox;
	@FindBy(xpath="//input[@value='Sole Trader']")
	WebElementFacade soleTraderRadioButton;
	@FindBy(xpath="//input[@value='Ltd Company']")
	WebElementFacade ltdCompanyRadioButton;
	@FindBy(xpath="//input[@value='Partnership']")
	WebElementFacade partnershipRadioButton;
	@FindBy(xpath="//input[@value='Charity']")
	WebElementFacade charityRadioButton;
	@FindBy(xpath=".//*[contains(@aria-label,'Trading As')]")
	WebElementFacade businessCompanyNameTextBox;
	@FindBy(xpath=".//*[@aria-label='Customer information:Next']")
	WebElementFacade AccountNext;

	@FindBy(xpath=".//*[@aria-label='Customer information:Next']")
	WebElement AccountNext1;

	@FindBy(xpath=".//*[text()='Search by price plan']")
	WebElementFacade SearchByPricePlanButton;

	@FindBy(xpath=".//*[@aria-label='The customer does not wish to register']")
	WebElementFacade AnonymousChckBox;

	@FindBy(xpath=".//*[text()='Guided sales process']")
	WebElementFacade GuidedSalesProcessTab;

	@FindBy(xpath=".//*[@id='j_s_sctrl_tabScreen']")
	WebElementFacade FristLevelViewBar;

	@FindBy(xpath=".//*[text()='Customer Comm List']")
	WebElementFacade CustomerCommsList;

	@FindBy(xpath=".//*[@title='Visibility']/select")
	WebElementFacade SelectCustomerComms; 

	@FindBy(xpath=".//button[contains(@title,'Set/Reset')]/preceding::button[contains(@aria-label,'New')]")
	WebElementFacade NewCustCommsBttn;

	@FindBy(xpath="(.//*[@aria-labelledby='Type_Label'])[1]")
	WebElementFacade TypeTextBox;

	@FindBy(xpath="(.//*[@name='Activity UID Show'])[1]")
	WebElementFacade ID;

	@FindBy(xpath=".//*[@aria-label='Comm Status:New customer']")
	WebElementFacade NewCustomer;

	@FindBy(xpath=".//*[@aria-label='End']")
	WebElementFacade EndTextBox;

	@FindBy(xpath=".//*[text()='Customer Comms']")
	WebElementFacade CustomerCommsTab;



	@Step
	public void CreateNewOUIAccount(String accountType) throws InterruptedException, IOException, AWTException{
		//Homepage.waitUntilPresent();
		Common.waitForPageLoad(getDriver());
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreateNewAccount";
		String applet = "//*[@title='Activities List Applet']";
		String table = "//table[@summary='Order Dashboard Details']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("First_Name").size();i++) {
			String sFirstName = tableMap.get("First_Name").get(i);
			String sLastName = tableMap.get("Last_Name").get(i);              
			String sEmail = tableMap.get("Email1").get(i);
			String sDomain = tableMap.get("Email2").get(i);
			String sCustomerType = tableMap.get("Account_Type").get(i);
			String sPhoneNumber = tableMap.get("PhoneNumber").get(i);
			String sBusinessTypeRadioButton = ".//input[@value='Sole-Trader']";
			String sTradingAs = tableMap.get("TradingAs").get(i);
			//String sBusinessTypePath = tableMap.get("CompanyName").get(i);
			String isAnonymous = tableMap.get("Anonymous").get(i);
			String sAccounTab = tableMap.get("AccountTab").get(i);
			String sSave = tableMap.get("Save").get(i);


			/*if (!sAccounTab.equalsIgnoreCase("No")){
	    		AccountsTab.withTimeoutOf(300,TimeUnit.SECONDS).isEnabled();
	    		AccountsTab.click();
	      		}
	      		newOUIAccount.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
	      		newOUIAccount.click();*/

			//GuidedSalesProcessTab.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
			//GuidedSalesProcessTab.click();
			AccountsTab.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
			if (!sAccounTab.equalsIgnoreCase("No")){
				if(CustomerCommsTab.isCurrentlyVisible())
				{
					CustomerCommsTab.click();
				}
				else
				{
					FristLevelViewBar.selectByVisibleText("Customer Comms");
				}
				Thread.sleep(7000);
				Common.WaitForClock(ClockObj);
				CustomerCommsList.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
				CustomerCommsList.click();

				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);
				SelectCustomerComms.selectByVisibleText("My Customer Comms");
				//SelectCustomerComms.selectByIndex(2);

				Thread.sleep(3000);
				Common.WaitForClock(ClockObj);
				//NewCustCommsBttn.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
				NewCustCommsBttn.click();
				Common.WaitForClock(ClockObj);

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.selectedRow = 1;
				Common.updateSiebList(applet,table, "DrillDown|Activity_UID_Show", ""); 
				Thread.sleep(5000); 
				Common.WaitForClock(ClockObj);

				NewCustomer.waitUntilVisible();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				NewCustomer.click();
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);
			}

			//consumerButton.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
			//Common.waitForElement(consumerButton); 
			//Thread.sleep(5000);
			//Common.waitForPageLoad(getDriver());
			Common.WaitForClock(ClockObj);
			Common.waitForElement(AccountNext1);
			//Thread.sleep(30000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if (sCustomerType.equals("Consumer")){
				consumerButton.click();
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);
			}
			if (sCustomerType.equals("Sole trader")||sCustomerType.equals("Ltd company")||sCustomerType.equals("Partnership")||sCustomerType.equals("Charity")){
				Common.WaitForClock(ClockObj);
				smallBusinessButton.click();
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);

				if(sCustomerType.equals("Ltd company")){
					LtdCompanyButton.click();
				}
				else {
					find(By.xpath(sBusinessTypeRadioButton)).click();	
				}

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				if(businessCompanyNameTextBox1.isCurrentlyVisible()) {
					businessCompanyNameTextBox1.type(sTradingAs);
				}
				else {
					businessCompanyNameTextBox2.type(sTradingAs);
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
			}


			if (sSave.equals("PlaceHolderCheck")){
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				String check =firstnameEditBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL, firstnameEditBox Text Box doesn't contain Hint", !check.equals(""));
				check =lastNameEditBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,lastNameEditBox Text Box doesn't contain Hint", !check.equals(""));

				email1EditBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				check =phoneNumberEditBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,phoneNumberEditBox Text Box doesn't contain Hint", !check.equals(""));
				check =emailEditBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,emailEditBox Text Box doesn't contain Hint", !check.equals(""));
				check =email1EditBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,Confirm emailEditBox Text Box doesn't contain Hint", !check.equals(""));

			}

			if(!isAnonymous.equalsIgnoreCase("Y")){
				Common.waitForElement(firstnameEditBox);
				firstnameEditBox.type(sFirstName);
				lastNameEditBox.type(sLastName);
				phoneNumberEditBox.type(sPhoneNumber);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				emailEditBox.type(sEmail);
				domainEditBox.type(sDomain);
				Common.waitForElement(email1EditBox);
				Thread.sleep(2000);

				email1EditBox.type(sEmail);
				domain1EditBox.type(sDomain);
				report.Info("Account Creation is done successfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(isAnonymous.equalsIgnoreCase("Y")){
				Thread.sleep(3000);
				//AccountsTab.click();
				Thread.sleep(3000);
				AnonymousChckBox.click();
				firstnameEditBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				String Fname = firstnameEditBox.getAttribute("readonly");

				if (Fname.equals("true")){

					report.Info("its readonly");

				}

			}
			AccountNext.click();    
			Thread.sleep(5000);
			Thread.sleep(2000);
			Common.WaitForClock(ClockObj);
			SearchByPricePlanButton.withTimeoutOf(120,TimeUnit.SECONDS).isEnabled();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			report.Info("Account Creation is done successfully");
		}
	}


	@FindBy(xpath=".//a[@name='Name']") 
	WebElementFacade accountName;
	@FindBy(xpath="//*[@id='1_s_1_l_Customer_Code']")
	WebElementFacade accountNo; 
	@FindBy(xpath="//*[text()='Account no:']/parent::span")
	WebElementFacade CapturedAccNo;
	@FindBy(xpath="//*[text()='Account no:']/parent::span/following-sibling::span")
	WebElementFacade GetAccNoValue;


	@Step
	public void VerifyOUIAccountSummary(String accountType) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreateNewAccount";
		String applet = "//*[@title='Accounts List Applet']";
		String table = "//table[@summary='Accounts']"; 
		Common.waitForPageLoad(getDriver());

		Common.WaitForClock(ClockObj);

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
		for (int i = 0;i < tableMap.get("First_Name").size();i++) {
			String FirstName = tableMap.get("First_Name").get(i);
			String LastName = tableMap.get("Last_Name").get(i);
			String FullName = FirstName + " " + LastName;
			String isAnonymous = tableMap.get("Anonymous").get(i);
			String sCustomerType = tableMap.get("Account_Type").get(i);
			String sAccountName ="";

			if (isAnonymous.equalsIgnoreCase("Y")){
				CapturedAccNo.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
				/*FirstName = CapturedAccNo.getTextValue();
          	  LastName = CapturedAccNo.getTextValue();
          	  FullName = FirstName + LastName;
          	  sAccountName = ".//*[contains(text(),'"+FullName+"')]";*/
				//sAccountName ="//*[@class='siebui-ctrl-text siebui-input-align-left']/following::label[contains(text(),'Anonymous')]";
				sAccountName =".//a[text()='Anonymous']";
				// find(By.xpath(sAccountName)).click();
			}
			else{
				FullName = FullName.toUpperCase();
				sAccountName = ".//*[contains(text(),'"+FullName+"')]";
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);
				// CapturedAccNo.click();
				Serenity.setSessionVariable("LastName").to(LastName);
			}
			Thread.sleep(4000);
        	if(!sCustomerType.equals("Ltd company")){
        		find(By.xpath(sAccountName)).withTimeoutOf(300,TimeUnit.SECONDS).isCurrentlyVisible();
        		if (find(By.xpath(sAccountName)).isCurrentlyVisible()){
        			report.Info(FullName+" is successfully created");            	  
        		}              
        		else
        		{            	  
        			report.Info("Account creation has failed");                
        		} 
        	}

			Common.WaitForClock(ClockObj);                            
			CapturedAccNo.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();

			String AccNo = "";
			AccNo = GetAccNoValue.getTextValue();
			Serenity.setSessionVariable("AccountNo").to(AccNo);	    		
			report.Info("Account no "+AccNo+" is Created successfully.");

			Thread.sleep(2000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
	}



	@FindBy(xpath=".//*[@title='Second Level View Bar']/ul/li/a[contains(text(),'Account Security')]")
	WebElementFacade AccountSecurityTab;

	@FindBy(xpath=".//*[@title='Comm Status:Search for an account']")
	WebElementFacade SearchCustomer;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Installed_Id_Label']")
	WebElementFacade SearchByField;

	@FindBy(xpath=".//*[@class='siebui-icon-bttns_more']")
	WebElementFacade AdvanceSearchOption;

	@FindBy(xpath=".//*[contains(@aria-label,'Account number')]")
	WebElementFacade AccountNumberField;	

	@FindBy(xpath=".//*[@aria-label='Search for an account:Search']")
	WebElementFacade SearchButton;

	@FindBy(xpath=".//*[translate(@aria-label,'ARS','ars')='search results for::select account']")
	WebElementFacade SelectAccountButton;

	@FindBy(xpath = ".//*[translate(@aria-label,'SCPDPA','scpdpa')='select contact:perform dpa']")
	WebElementFacade PerformDPAButton;
	@FindBy(xpath = "(.//*[text()='Ok']")
	WebElementFacade NoPinConfirm;
	@FindBy(xpath = "(.//*[text()='Contact does not have a PIN']")
	WebElementFacade PinNotPresent;
	@FindBy(xpath = "(//*[@class='siebui-icon-dropdown applet-form-combo applet-list-combo'])[1]")
	WebElementFacade PhoneNumberList;
	@FindBy(xpath = ".//*[@class='ui-menu-item ui-state-focus']")
	WebElementFacade SelectPhoneNumber;
	@FindBy(xpath=".//*[contains(@aria-label,'Failed to provide PIN or memorable word, go to OTAC validation')]")
	WebElementFacade DPAVerification;
	@FindBy(xpath=".//*[text()='Contact does not have a PIN']")
	WebElementFacade PINnotavailable;
	@FindBy(xpath=".//*[text()='Ok']")
	WebElementFacade PINOK;
	@FindBy(xpath = ".//button[@aria-label='DPA verification:Send OTAC']")
	WebElementFacade SendOATC;
	@FindBy(xpath = ".//*[@class='mceGridField siebui-value mceField vfoui-width-1 55px vfoui-top-15px vfoui-padding-left-12px']")
	WebElementFacade OATCDetails;
	@FindBy(xpath = ".//*[@aria-label='Id']")
	WebElementFacade OATCID;
	@FindBy(xpath = ".//button[@aria-label='DPA Verification:Passed']")
	WebElementFacade VerificatonPassed;
	@FindBy(xpath = "(.//*[@class='siebui-ctrl-input siebui-align-left siebui-input-align-left s_17_2_27_0 vfoui-ao-activities-value'])[1]")
	WebElementFacade SMSSent;
	@FindBy(xpath = "(.//*[@class='siebui-ctrl-drilldown siebui-anchor-readonly vfoui-ao-order-number'])[1]")
	WebElementFacade IDdrill;
	@FindBy(xpath = ".//*[text()='Account details']")
	WebElementFacade AccountDetails;
	@FindBy(xpath=".//*[@class='siebui-ctrl-textarea siebui-align-left siebui-input-align-left s_2_1_6_0 vfoui-padding-left-10px vfoui-color-black vfoui-resize-none']")
	WebElementFacade CapturedErrorMsg;
	@FindBy(xpath=".//*[text()='Comments']")
	WebElementFacade GetComment;
	@FindBy(xpath = "(.//*[text()='DPA'])[2]")
	WebElementFacade DPA;

	@FindBy(xpath = ".//*[contains(text(),'Error message')]")
	WebElementFacade ErrorTitleBox;
	@FindBy(xpath = ".//*[contains(text(),'Error')]//following::div[6]//button[contains(@class,'ui-button-text-only')]")
	WebElementFacade ErrorOkButton;

	@FindBy(xpath = ".//*[@aria-labelledby='s_5_l_Name s_5_l_altLink']")
	WebElementFacade BillingProfileCapture;
	@FindBy(xpath = ".//*[@rn='VFAccountName' and @class='siebui-ctrl-drilldown siebui-anchor-readonly']")
	WebElementFacade AccountName;
	@FindBy(xpath = ".//*[@class='siebui-icon-map']/following-sibling::div[contains(text(),'Account details')]")
	WebElementFacade AccountDetailsTitle;
	@FindBy(xpath = ".//*[@class='icon icon-info-circle vfoui-acnt-dtl-hvr vfoui-custval-tultip']")
	WebElementFacade CustomerValue;
	@FindBy(xpath = ".//*[@class='icon icon-info-circle vfoui-acnt-dtl-hvr vfoui-chrnind-tultip']")
	WebElementFacade ChurnIndicator;
	@FindBy(xpath = ".//*[@class='icon icon-info-circle vfoui-acnt-dtl-hvr vfoui-acntcrtd-by-tultip']")
	WebElementFacade AccountCreatedBy;

	@FindBy(xpath = ".//*[contains(text(),'In contract/commitment')]")
	WebElementFacade InContractCommitment;
	@FindBy(xpath = "(.//*[@class='siebui-button-secondary siebui-btn-icon-expanded']/following-sibling::span[@class='siebui-button-secondary siebui-btn-icon-collapsed'])[2]")
	WebElementFacade BusinessDetails;
	@FindBy(xpath = ".//*[@class='siebui-button-secondary siebui-btn-icon-expanded' and @style='display: inline-block;']")
	WebElementFacade AccountManager;
	@FindBy(xpath = "(.//*[@class='siebui-applet-container siebui-collapsible siebui-collapsible-applet-container']/span[@class='siebui-button-secondary siebui-btn-icon-expanded']/following-sibling::span[@class='siebui-button-secondary siebui-btn-icon-collapsed'])[1]")
	WebElementFacade AccountDetailsApplet;
	@FindBy(xpath=".//*[text()='Add new contact']")
	WebElementFacade NewContactButton;
	@FindBy(xpath=".//*[@aria-label='Personal details:Update email']")
	WebElementFacade UpdateEmailButton;
	@FindBy(xpath=".//*[@aria-labelledby='VFEmailAddress_Label']")
	WebElementFacade EmailTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VFDomainAddress_Label']")
	WebElementFacade EmailDomain;
	@FindBy(xpath=".//*[@aria-labelledby='VFReTypeEmailAddress_Label']")
	WebElementFacade ReTypeEamilTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VFReTypeDomainAddress_Label']")
	WebElementFacade ReTypeEmailDomain;
	@FindBy(xpath=".//*[@title='Siebel:OK']")
	WebElementFacade EmailOK;
	@FindBy(xpath=".//*[@aria-label='Email address']")
	WebElementFacade EmailAddressTextBoxExistingContact;
	@FindBy(xpath=".//*[contains(@class,'vfoui-contactform')]//button[@aria-label='Edit']")
	WebElementFacade EditContactButton;
	@FindBy(xpath="(.//*[@aria-label='Personal details:Save'])[2]")
	WebElementFacade SaveButton;
	@FindBy(xpath=".//*[contains(text(),'Please confirm you have discussed all marketing permissions')]")
	WebElementFacade MarketingPermissionPopUp;
	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade MarketingPermissionOk;
	@FindBy(xpath=".//*[text()='Account overview']")
	WebElementFacade AccountOverView;
	@FindBy(xpath=".//*[contains(text(),'Customer Not Yet in Eligibility Period of 180 Days')]")
	WebElementFacade ReasonPopUp;
	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade ReasonPopUpOk;

	@Step
	public void SearchaccountOUI(String Action, String AccountNo) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException {

		Common.waitForPageLoad(getDriver());
		Common.WaitForClock(ClockObj);

		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "SearchAccount"; 
		String applet = "";
		String table = "";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);



		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {	   			
			String sAction = tableMap.get("Action").get(i);
			String Index = tableMap.get("Index").get(i);
			String sGoToAccountLink = tableMap.get("GoToAccountLink").get(i);
			String sValidate = tableMap.get("Validate").get(i);
			String sCheckCustomerValue = tableMap.get("CheckCustomerValue").get(i);
			String sLevel = tableMap.get("Level").get(i);
			String sCheckPaymentDate = tableMap.get("CheckPaymentDate").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			String sOTAC = tableMap.get("OTAC").get(i);



			if(CustomerCommsTab.isCurrentlyVisible())
			{
				CustomerCommsTab.click();
			}
			else
			{
				FristLevelViewBar.selectByVisibleText("Customer Comms");
			}

			Thread.sleep(3000);
			Common.WaitForClock(ClockObj);

			CustomerCommsList.waitUntilVisible();
			CustomerCommsList.click();

			Thread.sleep(2000);
			Common.WaitForClock(ClockObj);
			SelectCustomerComms.selectByVisibleText("My Customer Comms");

			NewCustCommsBttn.click();
			Thread.sleep(2000);
			Common.WaitForClock(ClockObj);

			applet = "//*[@title='Activities List Applet']";
			table = "//table[@summary='Order Dashboard Details']";

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Common.selectedRow = 1;
			Common.updateSiebList(applet,table, "DrillDown|Activity_UID_Show", ""); 
			Thread.sleep(5000);       
			Common.WaitForClock(ClockObj);

			//SearchCustomer.waitUntilVisible();
			SearchCustomer.click();
			Common.WaitForClock(ClockObj);

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			String sAccountNo = "";
			if (AccountNo.equals("")){
				sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString(); 
				report.Info(sAccountNo);
			}
			else{
				sAccountNo = AccountNo; 
				Serenity.setSessionVariable("AccountNo").to(sAccountNo);
				Database.ExecuteBRMDBQuery("MSISDNFromAccount");
				String MSISDNFromAccount = Serenity.sessionVariableCalled("ACCNTMSISDN0").toString();
				Serenity.setSessionVariable("ACCNTMSISDN").to(MSISDNFromAccount);
			}


			if (sAction.equals("AdvanceSearch"))
			{
				AdvanceSearchOption.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
				AdvanceSearchOption.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				AccountNumberField.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				AccountNumberField.click();
				AccountNumberField.type(sAccountNo);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				SearchButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				SearchButton.click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if(!SelectAccountButton.isCurrentlyVisible() ){
					report.Info("No records found for Account"+sAccountNo);
					Assert.assertTrue(false); 
					return;
				}
				report.Info("Search successful for Account: "+sAccountNo);
				SelectAccountButton.click();
				Common.WaitForClock(ClockObj);

				PerformDPAButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if (sGoToAccountLink.equals("Yes")){
					applet = "//*[@title='Select contact List Applet']";
					table = "//table[@summary='Select contact']";


					if(sLevel.equals("")){
						CommonEnh.selectedRow = -1;
						String LocateColMessege = CommonEnh.locateColumn(applet,table, "Permission_Level", "Account Holder", "0");
						if(LocateColMessege.contains("False")) {
							/*CommonEnh.selectedRow = -1;
							 LocateColMessege = CommonEnh.locateColumn(applet,table, "Permission_Level", "Level 0", "0");*/
						}
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						/*Assert.assertTrue("Expected Row for Permission level = Account Holder not found", LocateColMessege.equals("true"));       
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());*/								  							 
					}
					else{
						CommonEnh.selectedRow = -1;
						String LocateColMessege = CommonEnh.locateColumn(applet,table, "Permission_Level", sLevel, "0");
						Assert.assertTrue("Expected Row for Permission level = "+sLevel+ " not found", LocateColMessege.equals("true"));       
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}

					GotoAccountLink.click();
					Common.WaitForClock(ClockObj);
					if(ReasonTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ReasonMsg.getText();	 	  			
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						ReasonOkButton.click();
						report.Info("The alert meassage is:"+ErrorInfo);
					}
					Common.WaitForClock(ClockObj);
					if(ErrorTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ErrorMsg.getText();  

						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						ErrorOkButton.click();
						report.Info("The alert meassage is: "+ErrorInfo);
						Common.WaitForClock(ClockObj);
					}

					if(sValidate.equals("AccountName"))
					{
						AccountName.click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Common.waitForElement(AccountDetailsTitle);
						Assert.assertTrue("AccountDetails page is not visible", AccountDetailsTitle.isCurrentlyVisible());
						report.Info("AccountDetails page is visible");
					}
					if(sCheckCustomerValue.equals("Yes"))
					{
						CustomerValue.click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						InContractCommitment.click();
						Thread.sleep(2000);
						ChurnIndicator.click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						InContractCommitment.click();
						Thread.sleep(2000);
						AccountCreatedBy.click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
					if(sCheckCustomerValue.equals("AccountManager"))
					{
						AccountDetailsApplet.click();
						//BusinessDetails.waitUntilClickable();
						BusinessDetails.click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Common.waitForElement(AccountManager);
						//Assert.assertTrue("AccountDetails page is not visible", AccountDetailsTitle.isCurrentlyVisible());
						//report.Info("AccountDetails page is visible");
						AccountManager.click();


					}

			if (sValidate.equalsIgnoreCase("UpdateEmailExistingAccount")){
		 	 			EditContactButton.click();
			 	 		report.Info("Update Contact Button clicked.");
		 		    	NewContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 		    	EmailAddressTextBoxExistingContact.click();
		 		    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 		    	UpdateEmailButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 		    	UpdateEmailButton.click();
		 	 	
		 		    	//String NewEmail = "newemail";
		 		    	EmailTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 		    	EmailTextBox.type("newemail");
		 		    	EmailDomain.type("gmail.com");
		 		    	ReTypeEamilTextBox.type("newemail");
		 		    	ReTypeEmailDomain.type("gmail.com");
		 	 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 	 			EmailOK.click();
		 		     	Common.WaitForClock(ClockObj);
		 		     	
		 		     	EmailAddressTextBoxExistingContact.click();
		 		     	String Email = EmailAddressTextBoxExistingContact.getTextValue();
		 		     	Assert.assertTrue("Email not updated", Email.equalsIgnoreCase("newemail@gmail.com") ); 
		 		     	report.Info("Email updated successfully");
		 		     	SaveButton.withTimeoutOf(120, TimeUnit.SECONDS).waitUntilClickable();
		 		     	SaveButton.click();
		 		     	
		 		     

		 		     	Assert.assertTrue("Expected popup did not occur", MarketingPermissionPopUp.containsText("Please confirm you have discussed all marketing permissions"));
						report.Info("Pass:Expected Popup did occur");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 					    MarketingPermissionOk.click();
					    AccountOverView.withTimeoutOf(120, TimeUnit.SECONDS).waitUntilClickable();
					    AccountOverView.click();
					    Common.WaitForClock(ClockObj);
		 		     	//Common.HandleErrorPopUp(sPopUp);	    
				
					    if(ReasonTitleBox.isCurrentlyVisible()){
			 				String ErrorInfo= ReasonMsg.getText();	 	  			
		 	  				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 	  				ReasonOkButton.click();
		 	  				report.Info("The alert meassage is:"+ErrorInfo);
			 	  		}
					}
		 		}
	 		




				if (sOTAC.equals("Yes")){

					applet = "//*[@title='Select contact List Applet']";
					table = "//table[@summary='Select contact']";


					if(sLevel.equals("")){
						CommonEnh.selectedRow = -1;
						String LocateColMessege = CommonEnh.locateColumn(applet,table, "Permission_Level", "Account Holder", "0");
						Assert.assertTrue("Expected Row for Permission level = Account Holder not found", LocateColMessege.equals("true"));       
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  							 
					}
					else{
						CommonEnh.selectedRow = -1;
						String LocateColMessege = CommonEnh.locateColumn(applet,table, "Permission_Level", sLevel, "0");
						Assert.assertTrue("Expected Row for Permission level = "+sLevel+ " not found", LocateColMessege.equals("true"));       
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}

					PerformDPAButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					PerformDPAButton.click();
					Thread.sleep(2000);


					if(PINnotavailable.isVisible())
					{
						PINOK.click();
					}
					DPAVerification.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					DPAVerification.click();
					Common.WaitForClock(ClockObj);
					PhoneNumberList.click();
					SelectPhoneNumber.click();		
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					SendOATC.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					SendOATC.click();
					Common.WaitForClock(ClockObj);

					String MSG = OATCDetails.getText();
					report.Info("PopUp MSG is"+MSG);
					String PIN = OATCID.getText();
					report.Info("PIN is"+PIN);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					VerificatonPassed.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();			    
					VerificatonPassed.click();
					Common.WaitForClock(ClockObj);
					Thread.sleep(3000);

					if(ReasonTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ReasonMsg.getText();	 	  			
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						ReasonOkButton.click();
						report.Info("The alert meassage is:"+ErrorInfo);
					}
					Common.WaitForClock(ClockObj);

					if(ErrorTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ErrorMsg.getText();  
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						ErrorOkButton.click();
						report.Info("The alert meassage is: "+ErrorInfo);
					}

					SMSSent.waitUntilClickable();
					SMSSent.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					DPA.click();
					IDdrill.click();
					Common.WaitForClock(ClockObj);
					AccountDetails.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				}




				if(BillingProfileCapture.isCurrentlyVisible()) {
					String BillingProfile = "";
					BillingProfile = BillingProfileCapture.getTextValue();
					Serenity.setSessionVariable("RowId").to(BillingProfile);	    		
					report.Info("Billing Profile "+BillingProfile+" is Captured successfully.");
					return;
				}
				return;
			}
			if (sAction.equals("SearchByTelNum"))
			{
				String sAccountMSISDN = "";
				sAccountMSISDN = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();  
				report.Info(sAccountMSISDN);
				SearchByField.click();
				SearchByField.type(sAccountMSISDN);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				SearchButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				SearchButton.click();
				Thread.sleep(10000);
			}
			if (sAction.equals("SearchByIMEI"))
			{
				SearchByField.click();
				SearchByField.type("123456789123456");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				SearchButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				SearchButton.click();
				Thread.sleep(10000);
			}
			if (sAction.equals("SearchBySIM"))
			{
				SearchByField.click();
				SearchByField.type("89441000303120852072");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				SearchButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				SearchButton.click();
				Thread.sleep(10000);
			}
			int RowCount = '0';
			// RowCount = findAll(By.xpath("//table[@summary='Search results for:']")).size();
			RowCount = findAll(By.xpath("//table[@summary='Select contact']")).size();
			Assert.assertTrue("FAIL, Rows not Displayed after clicking on search button",RowCount > 0);//dont change rowcount
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if (Index.equals("")){
				Index = "0";
			} 


		}

	}

	@FindBy(xpath=".//*[@aria-labelledby='VF_Payment_Method_Label']")
	WebElementFacade PaymentMethod;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_account_name_Label']")
	WebElementFacade BankAccName;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_account_name_Label']")
	WebElementFacade SortCode;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Account_number_Label']")
	WebElementFacade AccountNum; 	

	@Step 
	//This Function changes payment method
	//By Zeba
	public void ChangePaymentMethod(String logicalName) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());
		Thread.sleep(5000);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "ChangePaymentMethod";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(logicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		/*	  if (tableMap.get("Popup").size()==0){
			  report.Info(logicalName+" logical name not found in sheet.");
			  Assert.assertTrue(false); */
		Common.WaitForClock(ClockObj);
		for (int i = 0;i < tableMap.get("Popup").size();i++) {       
			String sNewPaymentMethod = tableMap.get("NewPaymentMethod").get(i);
			String sOldPaymentMethod = tableMap.get("OldPaymentMethod").get(i);
			String sAboutRecord = tableMap.get("AboutRecord").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String indexValue = tableMap.get("Index").get(i);
			String sBillingStatus = tableMap.get("BillingStatus").get(i);
			String sSortCode = tableMap.get("SortCode").get(i);
			String sAccountNumber = tableMap.get("AccountNumber").get(i);
			String sBankName = tableMap.get("BankName").get(i);

			if ((!sNewPaymentMethod.equals("")) && (!sOldPaymentMethod.equals(""))){
				String PM = PaymentMethod.getTextValue();
				if (PM.equals(sOldPaymentMethod)){
					PaymentMethod.click();
					PaymentMethod.typeAndEnter(sNewPaymentMethod);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if(sNewPaymentMethod.equals("Direct Debit"))
					{
						BankAccName.withTimeoutOf(300,TimeUnit.SECONDS).isCurrentlyVisible();
						BankAccName.type(sBankName);

						SortCode.withTimeoutOf(300,TimeUnit.SECONDS).isCurrentlyVisible();
						SortCode.type(sSortCode);

						AccountNum.withTimeoutOf(300,TimeUnit.SECONDS).isCurrentlyVisible();
						AccountNum.type(sAccountNumber);

					}
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				String PMnew = PaymentMethod.getTextValue();                              
				Assert.assertTrue("FAIL : Payment Method is not changed to "+sNewPaymentMethod, PMnew.equals(sNewPaymentMethod)); 
				// report.Info("Payment Method Changed from "+sOldPaymentMethod+" to "+sNewPaymentMethod); 
			}

		}
	}


	@FindBy(xpath=".//*[@aria-label='Select contact:DPA is not required for this action, go directly to account']")
	WebElementFacade DPAnotRequiredValidationLink; 

	@FindBy(xpath=".//*[@title='Select Contact:DPA is not required for this action, go directly to account']")
	WebElement DPAnotRequiredValidationLinkWeb;

	@FindBy(xpath=".//*[@title='Billing Profile:Expand']")
	WebElementFacade BillingExpandButton;

	// @FindBy(xpath="//button[@title='Expand']/span")
	//WebElementFacade BillingExpandButton;

	@FindBy(xpath="//button[@title='Expand']/span")
	WebElement BillingExpandButtonWeb;

	/*@FindBy(xpath=".//*[@title='VF OUI Bill Details Form Applet:Email Copy Bill']")
	WebElementFacade EmailBillCopyButton;*/

	@FindBy(xpath=".//*[@aria-label='Previous bills:Email copy bill']")
	WebElementFacade EmailBillCopyButton;
	
	@FindBy(xpath=".//*[@title='VF OUI Bill Details Form Applet:Email Copy Bill']")
	WebElement EmailBillCopyButtonWeb;
	
	@FindBy(xpath=".//*[@class='vfoui-account-overview-billing-master vfoui_box_shadow']//*[@class='drilldown']")
	WebElementFacade BillingExpandButton1;

	@FindBy(xpath=".//*[@aria-label='Select Email address']")
	WebElementFacade EmailAddressTextBox;

	@FindBy(xpath=".//*[@aria-label='Select Email address']")
	WebElement EmailAddressTextBoxWeb;
	@FindBy(xpath=".//*[@title='Select Email Address:Send Email']")
	WebElementFacade SendEmailButton;
	@FindBy(xpath=".//*[@title='Select Email Address:Send Email']")
	WebElement SendEmailButtonWeb;

	@FindBy(xpath=".//*[@title='VF OUI Bill Details Form Applet:PDF']")
	WebElementFacade PDFBillCopy;

	@FindBy(xpath=".//*[@title='VF OUI Bill Details Form Applet:PDF']")
	WebElement PDFBillCopyWeb;



	public void BillCopy(String logicalName) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());
		Thread.sleep(2000);
		Common.WaitForClock(ClockObj);

		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "BillCopy";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(logicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		/*	  if (tableMap.get("Popup").size()==0){
			  report.Info(logicalName+" logical name not found in sheet.");
			  Assert.assertTrue(false); */

		for (int i = 0;i < tableMap.get("Sample").size();i++) {       
			String sPerformAction = tableMap.get("PerformAction").get(i);
			String sEmailAddress = tableMap.get("EmailAddress").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);


			Common.waitForElement(DPAnotRequiredValidationLinkWeb);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			DPAnotRequiredValidationLink.click();
			report.Info("DPA Not Required Link Clicked.");
			Common.WaitForClock(ClockObj);
			
			if(ReasonTitleBox.isCurrentlyVisible()){
				String ErrorInfo= ReasonMsg.getText();	 	  			
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ReasonOkButton.click();
				report.Info("The alert meassage is:"+ErrorInfo);
			}
			Common.WaitForClock(ClockObj);
			if(ErrorTitleBox.isCurrentlyVisible()){
				String ErrorInfo= ErrorMsg.getText();  

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ErrorOkButton.click();
				report.Info("The alert meassage is: "+ErrorInfo);
				Common.WaitForClock(ClockObj);
			}	
			

			Common.waitForElement(BillingExpandButton1);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			BillingExpandButton1.click();
			Common.WaitForClock(ClockObj);

			if (sPerformAction.equalsIgnoreCase("EmailBillCopy")){

				Common.waitForElement(EmailBillCopyButton);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				EmailBillCopyButton.click();
				Alert alert;
				String ActAlertText="";	
				if(isAlertPresent(getDriver())){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText(); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if (ActAlertText.contains("It's not possible to email")){                    	
						alert.accept();
						System.out.println("Message is: "+ActAlertText);
						report.Info("alert messsage is"+ActAlertText);		                	
					}                                 
				}
				
			}

			if (sPerformAction.equalsIgnoreCase("PDFBillCopy")){

				Common.waitForElement(PDFBillCopyWeb);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				PDFBillCopy.click();
				Common.WaitForClock(ClockObj);

			}

			if (!sEmailAddress.equals("")) { 

				Common.waitForElement(EmailAddressTextBoxWeb);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				EmailAddressTextBox.type(sEmailAddress);

				Common.waitForElement(SendEmailButtonWeb);
				SendEmailButton.click();
				Common.WaitForClock(ClockObj);

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if(!sPopUp.equalsIgnoreCase("")){
					Common.HandleErrorPopUp(sPopUp); 
				}


			}
		}        
	}

	@FindBy(xpath=".//*[contains(@aria-label,'DPA is not required for this action')]")
	WebElementFacade GotoAccountLink;

	@FindBy(xpath=".//*[contains(text(),'Reason')]")
	WebElementFacade ReasonTitleBox;
	@FindBy(xpath=".//div[contains(@class,'dialog-content vf-check-retention')]")
	WebElementFacade ReasonMsg; 
	@FindBy(xpath=".//*[contains(text(),'Reason')]//following::div[6]//button[contains(@class,'ui-button-text-only')]")
	WebElementFacade ReasonOkButton;

	@FindBy(xpath=".//*[@class='vfoui-createnew-button']")
	WebElementFacade CreateNewButton;
	@FindBy(xpath=" .//button[contains(@class,'order-button')]")
	WebElementFacade CreateOrderButton;

	@FindBy(xpath="(.//button[contains(@class,'siebui-ctrl-btn siebui-icon-gridtoggle')][contains(@title,':Grid')])[3]")
	WebElementFacade GridViewButtonforBilledTab1;
	@FindBy(xpath="(.//button[contains(@class,'siebui-ctrl-btn siebui-icon-gridtoggle')][contains(@title,':Grid')])[4]")
	WebElementFacade GridViewButtonforBilledTab2;

	@Step
	public void CreateOrder() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);

		if(ReasonTitleBox.isCurrentlyVisible()){
			String ErrorInfo= ReasonMsg.getText();

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			ReasonOkButton.click();
			report.Info("The alert meassage is:"+ErrorInfo);
		}

		CreateNewButton.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Common.WaitForClock(ClockObj);

		CreateOrderButton.click();
		Thread.sleep(7000);
		Common.WaitForClock(ClockObj);

		if(FraudRiskTitleBox.isCurrentlyVisible()){
			FraudCheckbox.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			FraudRiskOKbutton.click();

		}
		Common.WaitForClock(ClockObj);


		report.Info("Create New Order Button clicked.");
		Common.WaitForClock(ClockObj);
		Thread.sleep(10000);
		Common.WaitForClock(ClockObj);
	}

	//@FindBy(xpath=".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-owned')]//button[contains(@title,'Menu')]")
	@FindBy(xpath="(.//*[@aria-label='Product & services:Menu'])[1]")
	WebElementFacade SelectActionListButton;
	@FindBy(xpath=".//*[@class='icon-tick-simple-activity vfoui-ao-activities-checkbox vfoui-order-checkbox']")
	WebElementFacade OrderscheckBox;
	@FindBy(xpath=".//*[@class='icon-tick-simple-activity vfoui-ao-activities-checkbox vfoui-comms-checkbox']")
	WebElementFacade CommsCheckBox;
	@FindBy(xpath=".//*[@class='icon-tick-simple-activity vfoui-ao-activities-checkbox vfoui-service-checkbox']")
	WebElementFacade SRCheckBox;

	@FindBy(xpath=".//li[contains(@data-caption,'Perform additional actions')]")
	WebElementFacade PerformAdditionalAction;
	@FindBy(xpath=".//a[text()='Audit trail']")
	WebElementFacade AuditTrail;
	@FindBy(xpath = "//*[@class='vfoui_audit_trail_list_applet vfoui-parent-container vf-oui-padding-bottom vf-oui-margin-bottom vf-oui-margin-top vfoui_box_shadow']//*[text()='Postpaid']")
	WebElementFacade Audittrailitems;
	@FindBy(xpath = ".//*[@summary='Bill format']")
	WebElementFacade BillingApplet;
	@FindBy(xpath=".//li[@data-caption='Customise']")
	WebElementFacade Customise;

	@FindBy(xpath = ".//*[@class='mceGridField siebui-value mceField vfoui-myAccountControl']//*[@name='checkbox']")
	WebElementFacade CheckBoxMyAccountControl;
	@FindBy(xpath = ".//*[text()='Notifications sent to Account Owner about end-users opted into My Account Controls will be sent to the phone number specified in the contacts tab. Please read this back to the customer and confirm it is the correct number.']")
	WebElementFacade ExpectedPopupCheckBox;
	@FindBy(xpath = ".//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons vfoui_box_shadow']//*[text()='Ok']")
	WebElementFacade ExpectedPopupCheckBoxOk;
	
	@FindBy(xpath=".//li[@data-caption='Disconnection/Fee calculator']")
	WebElementFacade DisconnectionFeeCalculator;
	@FindBy(xpath=".//*[@value='Port-out and keep number (provide PAC)']")
	WebElementFacade PortoutRequest;
	@FindBy(xpath="(//*[@class='ui-dialog-buttonset']//button[@type='button']//span)[3]")
	WebElementFacade OTACOKbutton;

	@FindBy(xpath=".//*[@value='Immediate disconnection']")
	WebElementFacade ImmediateDisconnection;

	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade FutureDiscPopUpOkButton;	

	@FindBy(xpath=".//*[contains(text(),'future disconnection')]")
	WebElementFacade FutureDiscPopUp;

	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade SecondaryDiscPopUpOkButton;	

	@FindBy(xpath=".//*[contains(text(),'Secondary devices connected')]")
	WebElementFacade SecondaryDiscPopUp;

	@FindBy(xpath=".//*[@aria-label='Customer details:Go to account']")
	WebElementFacade GoToAccount;

	@FindBy(xpath=".//*[text()='Terminations']/ancestor::div[contains(@class,'activities-heading')]/preceding-sibling::div[contains(@class,'-type')]//a")
	WebElementFacade DisconnectionRowId;

	@FindBy(xpath=".//*[@value='Future disconnection (raise service request)']")
	WebElementFacade FutureDisconnection;

	@FindBy(xpath="(//*[@class='vf-oui-pac-flds'])")
	WebElementFacade PACCODE;

	@FindBy(xpath="(//*[@class='vf-oui-pac-flds vf-oui-mrgin-38'])")
	WebElementFacade PacExpiryDate;

	@FindBy(xpath="(//*[@class='ui-dialog-buttonset']//button[@type='button']//span)[4]")
	WebElementFacade PACOKbutton;

	@FindBy(xpath="(.//*[@placeholder='Select category'])")
	WebElementFacade category;

	@FindBy(xpath="(.//*[@placeholder='Select sub-category'])")
	WebElementFacade SubCategory;

	@FindBy(xpath="(.//*[@placeholder='Select resolution'])")
	WebElementFacade SelectResolution;

	@FindBy(xpath="(.//button[@aria-label='Comm details:Get PAC'])")
	WebElementFacade GetPACcode;

	@FindBy(xpath=".//*[text()='OTAC not passed']")
	WebElementFacade OATCnotPassed;

	@FindBy(xpath=".//*[@aria-label='Disconnect service:Next']")
	WebElementFacade DisconnectNextButton;

	@FindBy(xpath=".//*[@aria-label='Disconnection date']")
	WebElementFacade DisconnectionDate;

	@FindBy(xpath=".//*[@aria-label='Disconnect service:Calculate']")
	WebElementFacade CalculateButton;

	@FindBy(xpath=".//*[@aria-label='Disconnect service:Go back']")
	WebElementFacade GoBackButton;

	@FindBy(xpath="(.//*[text()='Invalid date']")
	WebElementFacade InvalidDatePopup;

	@FindBy(xpath=".//*[text()='Include']")
	WebElementFacade IncludeButton;

	@FindBy(xpath=".//*[contains(text(),'open order in place')]")
	WebElementFacade OpenOrderPopUp;

	@FindBy(xpath=".//*[contains(text(),'does not have a high enough level of permission')]")
	WebElementFacade InsufficientLevelPopup;

	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade InsufficientLevelPopupOkButton;

	@FindBy(xpath=".//*[text()='Ok']")
	WebElementFacade OpenOrderPopUpPopUpOkButton;
	@FindBy(xpath=".//a[@name='VF Installed ID']")
	WebElementFacade InstalledIdClick;
	//@FindBy(xpath=".//li[@rn='VF OUI Upgrade']")
	@FindBy(xpath=".//li[contains(@data-caption,'Upgrade') and @aria-disabled= 'false']")
	WebElementFacade Upgrade;
	@FindBy(xpath=".//li[@rn='VF OUI Edit package']")
	WebElementFacade EditPackage;
	@FindBy(xpath=".//li[@data-caption='Top up request /eSwipe']")
	WebElementFacade Topup;
	@FindBy(xpath=".//li[@data-caption='SIM activities']")
	WebElementFacade SIMActivities;
	@FindBy(xpath=".//li[@data-caption='Check credit limit']")
	WebElementFacade CreditLimit;
	@FindBy(xpath=".//*[@aria-labelledby='Credit_Limit_Label']")
	WebElementFacade CreditLimitTextBox;
	@FindBy(xpath=".//*[@aria-label='Credit Limit Management:Set Credit Limit']")
	WebElementFacade CreditLimitSetLimitButton;
	@FindBy(xpath=".//*[@aria-label='Credit Limit Management:Close']")
	WebElementFacade CreditLimitCloseButton;
	@FindBy(xpath=".//*[contains(@placeholder,'Scan or type SIM number')]")
	WebElementFacade SIMNumber;
	@FindBy(xpath=".//*[contains(@class,'vf-oui-confirm-cncl')]")
	WebElementFacade SIMActivitiesCancelButton;
	@FindBy(xpath=".//*[contains(@title,'Asset:ESwipe')]")
	WebElementFacade TopupPage;
	@FindBy(xpath=".//*[contains(text(),'Fraud risk - please read')]")
	WebElementFacade FraudRiskTitleBox;  
	//@FindBy(xpath=".//div[contains(@class,'popup-info')]")
	@FindBy(xpath=".//*[text()='Apologizes is not possible to progress on Retention Sales, please contact System Administrator.']")
	WebElementFacade ErrorMsg; 
	@FindBy(xpath=".//label[@for='checkbox_fraud_id']")
	WebElementFacade FraudCheckbox;
	@FindBy(xpath=".//*[contains(text(),'address')]/ancestor::div[contains(@class,'ui-dialog ui-widget')]/div[contains(@class,'buttonpane')]//span[text()='Confirm']")
	WebElementFacade FraudRiskOKbutton;
	@FindBy(xpath="(.//button[contains(@class,'siebui-ctrl-btn siebui-icon-gridtoggle')][contains(@title,':Grid')])[1]")
	WebElementFacade GridViewButton1;
	@FindBy(xpath="(.//button[contains(@class,'siebui-ctrl-btn siebui-icon-gridtoggle')][contains(@title,':Grid')])[2]")
	WebElementFacade GridViewButton2;
	@FindBy(xpath = ".//*[@class='siebui-ctrl-btn siebui-icon-vfouiviewallbillprof s_5_1_2_0 vfoui-button-tertiaty vfoui-button-width-192 vfoui-billbuttonposition appletButton']")
	WebElementFacade ViewAllBills;
	@FindBy(xpath = ".//*[contains(text(),'Bill format')]")
	WebElementFacade Billformat;
	@FindBy(xpath = ".//*[contains(text(),'Billing contact details')]")
	WebElementFacade BillContactDetails;
	@FindBy(xpath=".//*[@title='Warning:OK']")
	WebElementFacade WarningOKButton;
	@FindBy(xpath=".//button[text()='Proceed']")
	WebElementFacade ProceedButton; 
	@FindBy(xpath=".//*[@class='siebui-ctrl-btn appletButton'][contains(text(),'Cancel')]")
	WebElementFacade CancelButton;
	@FindBy(xpath="(.//*[@aria-label='Billing:Latest bill details'])[2]")
	WebElementFacade ViewBillingDetailsButton;
	@FindBy(xpath=".//*[@title='Bill details:Ok']")
	WebElementFacade BillDetailsOKButton;
	@FindBy(xpath=".//*[@aria-label='Bill details:View PDF']")
	WebElementFacade ViewPDFButton;
	@FindBy(xpath="//*[@id=\"s_11_1_8_0_Label\"]")
	WebElementFacade MyAccountControl;
	@FindBy(xpath=".//*[@class='vf-oui-confirm-cncl ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']/preceding-sibling::button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	WebElementFacade MyAccountControlOkButton;
	String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
	String SikulifilePathForSavingFile = "";
	Screen  s=new Screen();
	@FindBy(xpath=".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-billed')]//button[contains(@title,'Menu')]")
	WebElementFacade BilledSelectActionListButton;

	@FindBy(xpath=".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-used')]//button[contains(@title,'Menu')]")
	WebElementFacade UsedSelectActionListButton;

	@FindBy(xpath=".//li[@data-caption='Return']")
	WebElementFacade Return;

	@FindBy(xpath=".//*[@aria-label='Return reason']")
	WebElementFacade ReturnReasonTextBox;

	@FindBy(xpath=".//input[@class='rtrn-keep-nmbr']")
	WebElementFacade RetuenAndKeepDevice;
	
	@FindBy(xpath="(.//*[contains(text(),'Return/Exchange')])")
	WebElementFacade ReturnExchangeOutsidePolicy;

	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade ExchangePolicyOkButton;

	@FindBy(xpath="//input[@value='Return & keep number']")
	WebElementFacade ReturnAndKeepRadioButton;
	
	@FindBy(xpath=".//span[text()='Return type']/parent::div/following-sibling::div[contains(@class,'ui-dialog-buttonpane')]//span[text()='Ok']")
	WebElementFacade ReturnTypeOkButton;

	@FindBy(xpath=".//span[text()='Damaged return charge']/parent::div/following-sibling::div[contains(@class,'ui-dialog-buttonpane')]//span[text()='Ok']")
	WebElementFacade DamagedReturnChargeOkButton;

	@FindBy(xpath=".//*[contains(text(),'service has an open return/exchange')]")
	WebElementFacade ReturnErrorMessagePopup;

	@FindBy(xpath=".//div//span[2][@class='icon icon-edit vfoui-icon-edit']")
	WebElementFacade PrimaryAddresseditbox;

	@FindBy(xpath=".//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable']")
	WebElementFacade PrimaryAddressApplet;
	@FindBy(xpath=".//*[@title='Account Addresses:OK']")
	WebElementFacade PrimaryAddressAppletOkbutton;
	@FindBy(xpath=".//*[contains(text(),'RG14 2FN, NEWBURY')]")
	WebElementFacade PrimaryAddressChangeValidation;
	@FindBy(xpath="(.//*[@title='Account Addresses:Go'])[2]")
	WebElementFacade PrimaryAddressAppletOk;
	@FindBy(xpath="//a[text()='Account overview']")
	WebElementFacade Accountoverviewlink;
	@FindBy(xpath="//*[@class='siebui-ctrl-text siebui-input-align-left vfoui-ao-mcd-text vfoui-street-address']")
	WebElementFacade PrimaryContactAddressChange;
	@FindBy(xpath=".//*[text()='9900884455']")
	WebElementFacade ChkContactNumber;
	@FindBy(xpath=".//*[text()='22/Apr/1980']")
	WebElementFacade ChkDOB;


	@Step
	public void OwnedProductServices(String LogicalName) throws InterruptedException, IOException, AWTException, FindFailed{
		Common.WaitForClock(ClockObj);
		Thread.sleep(2000);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "OwnedProductServices";
		String applet = "//*[@title='Billing profiles List Applet']";
		String table = "//table[@summary='Billing profiles']";



		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Action").size();i++) {       
			String sAction = tableMap.get("Action").get(i);
			String sValue = tableMap.get("Value").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			String sCheck = tableMap.get("Check").get(i);
			String sCreditValue = tableMap.get("CreditValue").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      				
			String Index = tableMap.get("Index").get(i);
			String sReturnReasone = tableMap.get("ReturnReasone").get(i);

			//String sReturnReasone = tableMap.get("ReturnReasone").get(i);


			if (Index.equals("")){
				Index = "0";
			} 

			if (sAction.equalsIgnoreCase("ChangePrimaryAddress")) {
				applet = "//*[@title='Account Addresses List Applet']";
				table = "//table[@summary='Account Addresses']";

				if ( PrimaryAddresseditbox.isVisible()){
					PrimaryAddresseditbox.click();
					Thread.sleep(1000);
					PrimaryAddressApplet.isVisible();
					PrimaryAddressAppletOk.click();

				}
				else {
					report.Info("PrimaryAddresseditbox is not visible");
					Assert.assertTrue(false);
				}


				if (!sLocateCol.equals("")){

					Common.selectedRow = -1;
					Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true")); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				else{
					CommonEnh.selectedRow = 1;
				} 
				Thread.sleep(1000);
				PrimaryAddressAppletOkbutton.click();

				if (PrimaryAddressChangeValidation.isVisible()) {
					String Address = PrimaryAddressChangeValidation.getTextValue();
					if (Address.contains("RG14 2FN, NEWBURY")) {
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						System.out.println("Primary added address is: "+Address);
					}
					else {
						Assert.assertTrue(false);
					}
				}
				break; 
			}

			if (sAction.equalsIgnoreCase("ChangePrimaryContact")) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", ChkContactNumber); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if(ChkContactNumber.isVisible()) {
					report.Info("Changed Contact Details,Number is Verified");
				}
				else {

					Assert.assertTrue(false);
				}
				if(ChkDOB.isVisible()) {
					report.Info("Changed Contact Details,Date Of Birth is Verified");

				}
				else
				{
					Assert.assertTrue(false);
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}


			if (sAction.equalsIgnoreCase("ChangePrimaryContactAddress")) {
				if (Accountoverviewlink.isVisible()) {
					Thread.sleep(2000);
					((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PrimaryContactAddressChange);

					String PrimaryContactAddress = PrimaryContactAddressChange.getTextValue();
					if (PrimaryContactAddress.contains(sValidation)) {
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						System.out.println("Primary added address is: "+PrimaryContactAddress);
						report.Info("Primary added address is: "+PrimaryContactAddress);
					}
					else {
						Assert.assertTrue(false);
					}
				}

				break;  
			}

			if (sValue.equals("Promotion")){
				sValue = Serenity.sessionVariableCalled("ProductName").toString();
			} 

			if (sValue.contains("RootProduct0")){
				sValue = sValue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}
			if (sValue.contains("ACCNTMSISDN")){
				sValue = sValue.replace("ACCNTMSISDN", Serenity.sessionVariableCalled("ACCNTMSISDN").toString());    	  
				//sValue= "447741772989";
			}

			if (sValue.equals("MSISDN")){
				sValue = sValue.replace("MSISDN", Serenity.sessionVariableCalled("MSISDN").toString());    	  
				//sValue= "447741757929";
			}


			if(ReasonTitleBox.isCurrentlyVisible()){
				String ErrorInfo= ReasonMsg.getText();

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ReasonOkButton.click();
				report.Info("The alert meassage is:"+ErrorInfo);
			}
			if(sCheck.equalsIgnoreCase("NewOrderDisabled")){
				CreateNewButton.click();
				Common.WaitForClock(ClockObj);
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", CreateOrderButton); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	    		
				Assert.assertTrue("FAIL: Create New Order Button is enabled for User",!CreateOrderButton.isEnabled()); 
				report.Info("PASS: Create New Order Button is disabled as expected for User");
				break;
			}
			
			if(sCheck.equalsIgnoreCase("NewOrderEnabled")){
				CreateNewButton.click();
				Common.WaitForClock(ClockObj);
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", CreateOrderButton); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	    		
				Assert.assertTrue("FAIL: Create New Order Button is enabled for User",CreateOrderButton.isEnabled()); 
				report.Info("PASS: Create New Order Button is disabled as expected for User");
				break;
			}
			
			if(sCheck.equalsIgnoreCase("CheckAccountControl")){
				if(!find(By.xpath("//*[@id='checkbox_mycontrols_id']")).isCurrentlyEnabled()) {
					report.Info("Pass: "+sValue+" does not have MyAccount Control");
				}
				else{
					//find(By.xpath("//*[@id='s_10_1_8_0_Label']")).click();
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					//Assert.assertTrue("Fail: "+sValue+" has MyAccount Control",false);
					find(By.xpath("//*[@id='checkbox_mycontrols_id']")).click();
					if(MyAccountControlOkButton.isVisible()) {
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						MyAccountControlOkButton.click();
					}
					return;
				}
				break;
			}


			int	AllOwnedTabLink = findAll(By.xpath("//div[contains(@id,'_owned') and contains(text(),'Owned')]")).size();
			for(int j=1;j<=AllOwnedTabLink;j++){
				if(findBy("(//div[contains(@id,'_owned') and contains(text(),'Owned')])["+j+"]").isCurrentlyVisible()) {
					findBy("(//div[contains(@id,'_owned') and contains(text(),'Owned')])["+j+"]").click();
					report.Info("Owned Tab Clicked");
					break;
				}
			}
			Common.WaitForClock(ClockObj);
			int AllGrid=0;

			AllGrid = findAll(By.xpath("//button[@title='Product & services:Grid']")).size();
			for(int j=1;j<=AllGrid;j++){
				if(findBy("(//button[@title='Product & services:Grid'])["+j+"]").isCurrentlyVisible()) {
					findBy("(//button[@title='Product & services:Grid'])["+j+"]").click();
					Common.WaitForClock(ClockObj);
					report.Info("Grid View Button clicked");
					break;
				}
			}
			Common.WaitForClock(ClockObj);



			/*String sSelectActionListButton = "((.//*[@title='PRODUCTS & SERVICES Menu'])[1])";
		          	report.Info("Select Action Button is : "+sSelectActionListButton);*/

			String sFlag = "N";
			String IDValue = "";
			int j=0;
			String ActValue="";

			if(findBy(".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-owned')]").isCurrentlyVisible()) {
				IDValue = find(By.xpath(".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-owned')]")).getAttribute("id");
			} 
			if (sAction.equals("DrilldownMSISDN"))
			{
				int totalRows = findAll(By.xpath("//*[contains(@id,'"+IDValue+"')and contains(@id,'tile') and contains(@class,'siebui-tile')]")).size();
				for(j=0;j<=totalRows;j++){

					if(find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).isCurrentlyVisible()) {
						ActValue = find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).getText();

					}

					//ActValue = find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).getText();

					if (sValue.contains(ActValue)){
						find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]/div/div[1]")).click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("Product found: "+sValue);
						sFlag = "Y";

						if (sAction.equals("DrilldownMSISDN")&& (sFlag.equals("Y"))){															  
							Thread.sleep(2000);
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							//InstalledIdClick.click();
							find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).click();
							report.Info("Installed ID is clicked");
							Thread.sleep(2000);
							Common.WaitForClock(ClockObj);
						}
						break;
					}
					if(sFlag.equals("N") && j>=totalRows ){
						report.Info("No records found for "+sValue);
						Assert.assertTrue(false); 
						return;

					}

				}
				if(sCheck.equalsIgnoreCase("CheckAccountControl")){
					if(!find(By.xpath("//*[@id=\"s_11_1_8_0_Label\"]")).isCurrentlyVisible()){
						report.Info("Pass: "+sValue+" does not have MyAccount Control");
					}
					else{
						find(By.xpath("//*[@id=\"s_11_1_8_0_Label\"]")).click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Assert.assertTrue("Fail: "+sValue+" has MyAccount Control",false);
						return;
					}
					break;
				}


				if(sValidation.equalsIgnoreCase("ValidateHyperlink")){
					if(!find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Product Name')]")).isCurrentlyVisible()){
						report.Info("Pass: "+sValue+" does not have hyperlink");
					}
					else{
						find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Product Name')]")).click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Assert.assertTrue("Fail: "+sValue+" has hyperlink",false);
						return;
					}
					break;
				}	
			}

			if(sAction.equals("CheckCommsordersandSR"))
			{
				Common.WaitForClock(ClockObj);

				if(OrderscheckBox.isSelected()) {
					report.Info("Order CheckBox is Selected");
				}
				else {
					OrderscheckBox.click();
					report.Info("Order CheckBox is Selected");
				}
				if(CommsCheckBox.isSelected()) {
					report.Info("Order CheckBox is Selected");
				}
				else {
					CommsCheckBox.click();
					report.Info("Order CheckBox is Selected");
				}
				if(SRCheckBox.isSelected()) {
					report.Info("Order CheckBox is Selected");
				}
				else {
					SRCheckBox.click();
					report.Info("Order CheckBox is Selected");
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				OrderscheckBox.click();
				CommsCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				OrderscheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				OrderscheckBox.click();
				CommsCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				SRCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (sAction.equals("ReturnOrder")){

				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Return.click();

				if(ReturnExchangeOutsidePolicy.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ExchangePolicyOkButton.click();
					Thread.sleep(2000);
				}

				if(sValidation.equals("RetuenAndDisconnect")){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ReturnTypeOkButton.click();
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);

				}
				if(sValidation.equals("RetuenAndKeepDevice")){

					RetuenAndKeepDevice.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ReturnTypeOkButton.click();
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);

				}
				if(DamagedReturnChargeOkButton.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					DamagedReturnChargeOkButton.click();
					Thread.sleep(2000);

				}  
				Common.WaitForClock(ClockObj);

				if (ReturnReasonTextBox.isCurrentlyVisible()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(1000);
					ReturnReasonTextBox.sendKeys(sReturnReasone);
					report.Info(sReturnReasone +"is selected from Owned product & services window");
					Thread.sleep(2000);

					if(sValidation.equalsIgnoreCase("ErroMsgPopUp"))
					{
						Assert.assertTrue("FAIL, Return Error message is not visible as expected", ReturnErrorMessagePopup.isCurrentlyVisible());
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("Return Error pop up message is displayed as expected");					  
					}
				}
			}

			if (sAction.equals("ReturnWithReason")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				ReturnReasonTextBox.sendKeys(sReturnReasone);
				report.Info(sReturnReasone +"is selected from Owned product & services window");
				Thread.sleep(2000);

				if(sValidation.equalsIgnoreCase("ErroMsgPopUp"))
				{
					Assert.assertTrue("FAIL, Return Error message is not visible as expected", ReturnErrorMessagePopup.isCurrentlyVisible());
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Return Error pop up message is displayed as expected");					  
				}
			}


			if (sAction.equals("PerformAdditionalAction")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				//find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				PerformAdditionalAction.click();
				report.Info("Perform Additional actions is selected from Owned product & services window");
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);

				Alert alert1;
				String ActAlertText1=""; 

				int z=0;
				do{
					Thread.sleep(2000);
					if(isAlertPresent(getDriver())){
						alert1=getDriver().switchTo().alert();
						ActAlertText1=alert1.getText();  
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                                                
						//if (ActAlertText.contains("Please be aware that there is an open complaint registered by this customer")){  		            		
						alert1.accept();
						report.Info("Pop occurred : " +ActAlertText1);
						//}
					} 
					z++;
				}while(z<2);



				Common.WaitForClock(ClockObj);
				if (AccountSummaryTab.isDisplayed()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Account Summary page is displayed after selecting Perform Additional Actions from Billed proodcut services window");    		   
				}

				if (!AccountSummaryTab.isDisplayed()){
					report.Info("Account Summary page is not displayed after selecting Perform Additional Actions from Billed proodcut services window");
					Assert.assertTrue(false);
				}
			}

			if (sAction.equals("Customise")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				//find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Customise.click();
				report.Info("Customise is selected from Owned product & services window");
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);

				if(sValidation.equals("Yes")){
					if (WarningOKButton.isCurrentlyVisible()){
						WarningOKButton.waitUntilClickable();  
						WarningOKButton.click();           
					}
					if (ProceedButton.isCurrentlyVisible()){
						ProceedButton.waitUntilClickable();
						ProceedButton.click();               
					}
					CancelButton.click();
					Common.WaitForClock(ClockObj);
				}
			}

			
			
			if (sAction.equals("Return")){	

				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Return.click();

				if(ReturnExchangeOutsidePolicy.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ExchangePolicyOkButton.click();
					Thread.sleep(2000);
				}
				if(sValidation.equalsIgnoreCase("ReturnAndKeep")) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ReturnAndKeepRadioButton.click();
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ReturnTypeOkButton.click();
					Thread.sleep(2000);
				}
				else {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ReturnTypeOkButton.click();
					Thread.sleep(2000);
				}
				if(DamagedReturnChargeOkButton.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					DamagedReturnChargeOkButton.click();
					Thread.sleep(2000);
				}
				if (ReturnReasonTextBox.isCurrentlyVisible()){
					//ReturnReasonTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					//SelectReasonListButton.click();
					Thread.sleep(1000);
					ReturnReasonTextBox.sendKeys("Damaged in Transit");
					report.Info("Damaged in Transit is selected from Owned product & services window");
					Thread.sleep(2000);

					if(sValidation.equalsIgnoreCase("ErroMsgPopUp"))
					{
						Assert.assertTrue("FAIL, Return Error message is not visible as expected", ReturnErrorMessagePopup.isCurrentlyVisible());
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("Return Error pop up message is displayed as expected");					  
					}
				}


			}
			
//
			
			
//
			if (sAction.equals("CheckPAC")){


				SMSSent.waitUntilClickable();
				SMSSent.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				DPA.click();
				IDdrill.click();
				Common.WaitForClock(ClockObj);
				AccountDetails.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				Actions actions = new Actions(getDriver());
				actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				GetComment.click();

				String DetailedErroMsg = CapturedErrorMsg.getText();
				report.Info("Error Msg Is"+DetailedErroMsg);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}


			if (sAction.equals("DisconnectionFeeCalculator")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				//find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				DisconnectionFeeCalculator.click();
				report.Info("Disconnection/ Fee Calculator is selected from Owned product & services window");
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);

				if(sValue.contains("PortoutRequest")){
					PortoutRequest.click();
					Thread.sleep(2000);
					DisconnectNextButton.click();
					Thread.sleep(5000);
					Common.WaitForClock(ClockObj);
					if(OATCnotPassed.isCurrentlyVisible()) {
						OATCnotPassed.waitUntilVisible();
						OTACOKbutton.click();
						Thread.sleep(5000);
					}
					Thread.sleep(5000);
					PACOKbutton.waitUntilClickable();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					String PACINFOCODE = PACCODE.getText();
					String PACINFODATE = PacExpiryDate.getText();
					report.Info("PAC & switching info has been sent via SMS to the customer");
					report.Info("PAC Code is:"+PACINFOCODE);
					report.Info("PAC Code Expiry Date Is:"+PACINFODATE);

					PACOKbutton.click();

				}			

				if(sValue.contains("ImmediateDisconnection")){
					ImmediateDisconnection.click();
					Thread.sleep(2000);
					DisconnectNextButton.click();
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);
				}

				if(sValue.contains("FutureDisconnection")){
					FutureDisconnection.click();
					Thread.sleep(2000);

					///


					if(sValidation.equalsIgnoreCase("ValidateDate"))
					{

						/*	 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						        Date currentDate = new Date();*/

						DisconnectionDate.clear();
						DisconnectionDate.typeAndEnter("01/01/2019");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Thread.sleep(2000);

						String handle= getDriver().getWindowHandle();
						System.out.println(handle);
						getDriver().switchTo().window(handle);
						String s = getDriver().findElement(By.xpath(".//*[text()='Invalid date']")).getText();
						report.Info(s);
						report.Info("You cannot choose a date which is today or earlier (service requests can't be backdated).");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

						Thread.sleep(2000);
						report.Info("Invalid Date Popup occurd successfully");
						//InvalidDatePopup
						//You cannot choose a date which is today or earlier (service requests can't be backdated).

						return;
					}

					//DisconnectionFeeCalculatorGoBack
					//CalculateFee
					else if(sValidation.equalsIgnoreCase("CalculateFee"))
					{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						CalculateButton.waitUntilClickable();
						CalculateButton.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

						GoBackButton.waitUntilClickable();
						GoBackButton.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

						report.Info("GO Back button clicked successfully");
					}



					////
					else {
						DisconnectNextButton.click();
						Thread.sleep(2000);
						Common.WaitForClock(ClockObj);

						if(SecondaryDiscPopUp.isCurrentlyVisible())
						{
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							if(SecondaryDiscPopUpOkButton.isCurrentlyVisible())
							{
								SecondaryDiscPopUpOkButton.click();    
								Common.WaitForClock(ClockObj);
								sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							}
						}
						Common.WaitForClock(ClockObj);

						if(FutureDiscPopUp.isCurrentlyVisible())
						{
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							FutureDiscPopUpOkButton.click();    
							Common.WaitForClock(ClockObj);
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						}
					}
				}

				if(IncludeButton.isCurrentlyVisible())
				{
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					IncludeButton.click();    
					Common.WaitForClock(ClockObj);
				}
				if(sValidation.equalsIgnoreCase("OpenOrderPopupValidation"))
				{
					if (OpenOrderPopUp.isCurrentlyVisible()){
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						OpenOrderPopUpPopUpOkButton.waitUntilClickable();  
						OpenOrderPopUpPopUpOkButton.click();    
						Common.WaitForClock(ClockObj);
					}
				}
				if(sValidation.equalsIgnoreCase("InsufficiantlevelPopupValidation"))
				{
					if (InsufficientLevelPopup.isCurrentlyVisible()){
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						InsufficientLevelPopupOkButton.waitUntilClickable();  
						InsufficientLevelPopupOkButton.click();    
						Common.WaitForClock(ClockObj);
					}
				}
				if(sCheck.equalsIgnoreCase("GoToAccount"))
				{
					GoToAccount.click();
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if(ReasonTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ReasonMsg.getText();	 	  			
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						ReasonOkButton.click();
						report.Info("The alert meassage is:"+ErrorInfo);
					}
					Common.WaitForClock(ClockObj);
					if(ErrorTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ErrorMsg.getText();  

						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						ErrorOkButton.click();
						report.Info("The alert meassage is: "+ErrorInfo);

					}

					if(DisconnectionRowId.isCurrentlyVisible())
					{
						DisconnectionRowId.click();
						//Thread.sleep(1000);
						//DisconnectionRowId.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
				}
			}
			if (sValidation.equals("ValidateDisconnectionInViews")){														  
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Disconnection/ Fee Calculator' option is not present for Owned view",DisconnectionFeeCalculator.isCurrentlyVisible());
				report.Info("The 'Disconnection/ Fee Calculator' option is present for Owned view");

				find(By.xpath("//*[@id='"+IDValue+"_billed']")).click();
				//BilledButton.click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				BilledSelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Disconnection/ Fee Calculator' option is present for Billed view",!DisconnectionFeeCalculator.isCurrentlyVisible());
				report.Info("The 'Disconnection/ Fee Calculator' option is not present for Billed view");

				Common.WaitForClock(ClockObj);
				IDValue = find(By.xpath(".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-billed')]")).getAttribute("id");
				find(By.xpath("//*[@id='"+IDValue+"_used']")).click();

				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				UsedSelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Disconnection/ Fee Calculator' option is present for Used view",!DisconnectionFeeCalculator.isCurrentlyVisible());
				report.Info("The 'Disconnection/ Fee Calculator' option is not present for Used view");

				IDValue = find(By.xpath(".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-used')]")).getAttribute("id");
				find(By.xpath("//*[@id='"+IDValue+"_owned']")).click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);

				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				DisconnectionFeeCalculator.click();
				Assert.assertTrue("FAIL: Disconnection applet is not displayed after selecting from menu",ImmediateDisconnection.isVisible());
				report.Info("Disconnection/ Fee Calculator is selected from Owned product & services window");
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (sAction.equals("CheckViewAllBills")){
				ViewAllBills.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				BillingApplet.isVisible();
				Billformat.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				BillContactDetails.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				AuditTrail.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Audittrailitems.isVisible();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (sAction.equals("CheckCheckBoxMyAccountControlOwnedAccount")) {
				CheckBoxMyAccountControl.isPresent();
				CheckBoxMyAccountControl.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(ExpectedPopupCheckBox.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ExpectedPopupCheckBoxOk.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				report.Info("CheckBox for My account Contol is Enabled for Owned Account");
				CheckBoxMyAccountControl.click();	
			}

			if (sAction.equals("CheckCheckBoxMyAccountControlLevel0")) {
				CheckBoxMyAccountControl.isPresent();
				CheckBoxMyAccountControl.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(ExpectedPopupCheckBox.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ExpectedPopupCheckBoxOk.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				report.Info("CheckBox for My account Contol is Enabled for Level 0");
				CheckBoxMyAccountControl.click();
			}

			if (sAction.equals("CheckCheckBoxMyAccountControlLevel1")) {
				CheckBoxMyAccountControl.waitUntilEnabled();
				CheckBoxMyAccountControl.isPresent();
				CheckBoxMyAccountControl.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(ExpectedPopupCheckBox.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ExpectedPopupCheckBoxOk.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				report.Info("CheckBox for My account Contol is Enabled for Level 1");
				CheckBoxMyAccountControl.click();
			}

			if (sAction.equals("CheckCheckBoxMyAccountControlLevel2")) {
				CheckBoxMyAccountControl.isPresent();
				if(!(CheckBoxMyAccountControl.isCurrentlyEnabled())) {
					report.Info("CheckBox for My account Contol is Disabled for Level 2");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				else
				{
					CheckBoxMyAccountControl.click();
					report.Info("CheckBox for My account Contol should be disbled");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Assert.assertTrue(false);
				}
			}

			if (sAction.equals("BillingList")) {
				Thread.sleep(2000);
				ViewAllBills.click();
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}
			if (!sLocateCol.equals("")) {
				CommonEnh.selectedRow = -1;
				CommonEnh.locateColumn(applet, table, sLocateCol, sLocateColValue, Index);
				report.Info("Row is selected successfully with column name: " + sLocateCol + " and value: "
						+ sLocateColValue);
			} else {
				CommonEnh.selectedRow = 1;
			}

			if (sAction.equals("Upgrade")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				//find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Upgrade.click();
				report.Info("Upgrade is selected from Owned product & services window");
				Thread.sleep(5000);

				if(FraudRiskTitleBox.isCurrentlyVisible()){
					FraudCheckbox.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					FraudRiskOKbutton.click();

				}
				Common.WaitForClock(ClockObj);
			}
			if (sAction.equals("Editpackage")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				//find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				EditPackage.click();
				report.Info("Upgrade is selected from Owned product & services window");
				Thread.sleep(5000);

				Common.WaitForClock(ClockObj);
			}

			if (sAction.equals("CheckCreditLimit")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				///find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				CreditLimit.click();
				report.Info("Check CreditLimit is selected from Owned product & services window");
				Thread.sleep(10000);

				Common.WaitForClock(ClockObj);

				if(sValidation.equals("Yes")){
					if (CreditLimitSetLimitButton.isCurrentlyVisible()){
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("CreditLimit page is displayed after selecting Check CreditLimit from Owned product services window");    		   
						//To compare credit limit value			
						if(!sCreditValue.equals("") ){
							String Creditvalue = CreditLimitTextBox.getTextValue();
							Assert.assertTrue("Fail, Credit Limit value is not same as" +sCreditValue+ " It is "+Creditvalue,Creditvalue.equals(sCreditValue));
							report.Info("Check CreditLimit matches");
						}
						if (CreditLimitCloseButton.isCurrentlyVisible()){
							CreditLimitCloseButton.click();
							Thread.sleep(2000);
						}
					}
					else {
						report.Info("CreditLimit page is not displayed after selecting Check CreditLimit from Owned product services window");
						Assert.assertTrue(false);
						return;
					}
				}

				if(!sValidation.equals("Yes")){
					if (CreditLimitSetLimitButton.isCurrentlyVisible()){
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("CreditLimit page is displayed after selecting Check CreditLimit from Owned product services window");    		   
						//to populate credit limit value			
						if(!sCreditValue.equals("") ){
							CreditLimitTextBox.type(sCreditValue);
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							CreditLimitSetLimitButton.click();
							Thread.sleep(30000);
							Common.WaitForClock(ClockObj);
							report.Info("CreditLimit set to : "+sCreditValue);
							if (CreditLimitCloseButton.isCurrentlyVisible()  ){
								CreditLimitCloseButton.click();
								Thread.sleep(2000);
							}
						}
					}
					else {
						report.Info("CreditLimit page is not displayed after selecting Check CreditLimit from Owned product services window");
						Assert.assertTrue(false);
						return;
					}
				}
			}

			if (sAction.equals("SIMActivities")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				SIMActivities.click();
				report.Info("SIM Activities is selected from Owned product & services window");
				Thread.sleep(2000);

				Common.WaitForClock(ClockObj);
				if (SIMNumber.isDisplayed()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("SIMActivities page is displayed after selecting SIM Activities Actions from Owned proodcut services window");    		   
					SIMActivitiesCancelButton.click();
					Thread.sleep(2000);
				}
				else {
					report.Info("SIMActivities page is not displayed after selecting SIM Activities Actions from Owned proodcut services window");
					Assert.assertTrue(false);
					return;
				}
			}

			if (sAction.equals("Topup")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Topup.click();
				report.Info("E swipe page is selected from Owned product & services window");
				Thread.sleep(2000);

				Common.WaitForClock(ClockObj);
				if (TopupPage.isDisplayed()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("E swipe page is displayed after selecting Topup Action from Owned proodcut services window");    		   
				}

				else {
					report.Info("E swipe page is not displayed after selecting Topup Action from Owned proodcut services window");
					Assert.assertTrue(false);
				}
			}

			if (sAction.equals("CheckViewBillingDetailsForPostpaid")){	
				Assert.assertTrue("View Billing Button is Disabled for Postpaid", ViewBillingDetailsButton.isCurrentlyEnabled());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("View Billing Button is Enabled as Expected for Postpaid");
			}
			if (sAction.equals("CheckViewBillingDetailsForPrepaid")){	
				Assert.assertTrue("View Billing Button is Enabled for Prepaid", !ViewBillingDetailsButton.isCurrentlyEnabled());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("View Billing Button is Disabled as Expected for Prepaid");
			}

		}
	}




	@FindBy (xpath="(.//div[@class='vfoui-billed-tab acc-ps-tabs acc-ps-tabs-inactive'][text()='Billed'])[1]")
	WebElementFacade BilledLink;
	@FindBy(xpath="(.//button[contains(@class,'siebui-ctrl-btn siebui-icon-gridtoggle')][contains(@title,':Grid')])[3]")
	WebElementFacade GridViewButtonforBilledTab;
	@FindBy(xpath="//*[text()='Account Summary']")
	WebElementFacade AccountSummaryTab;
	@FindBy(xpath="(.//a[@name='VF Installed ID'])[3]")
	WebElementFacade InstalledIdClickBilled;

	@Step
	public void BilledProductServices(String LogicalName) throws InterruptedException, IOException, AWTException{

		Thread.sleep(2000);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "OwnedProductServices";

		Common.WaitForClock(ClockObj);

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Action").size();i++) {       
			String sAction = tableMap.get("Action").get(i);
			String sValue = tableMap.get("Value").get(i);


			if (sValue.equals("Promotion")){
				sValue = Serenity.sessionVariableCalled("ProductName").toString();
			} 

			if (sValue.contains("RootProduct0")){
				sValue = sValue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}
			if (sValue.contains("ACCNTMSISDN")){
				sValue = sValue.replace("ACCNTMSISDN", Serenity.sessionVariableCalled("ACCNTMSISDN").toString());    	  
				//sValue= "447741772989";
			}

			if(ReasonTitleBox.isCurrentlyVisible()){
				String ErrorInfo= ReasonMsg.getText();

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ReasonOkButton.click();
				report.Info("The alert meassage is:"+ErrorInfo);
			}

			int	AllBilledTabLink = findAll(By.xpath("//div[contains(@id,'_billed') and contains(text(),'Billed')]")).size();
			for(int j=1;j<=AllBilledTabLink;j++){
				if(findBy("(//div[contains(@id,'_billed') and contains(text(),'Billed')])["+j+"]").isCurrentlyVisible()) {
					findBy("(//div[contains(@id,'_billed') and contains(text(),'Billed')])["+j+"]").click();
					report.Info("Billed Tab Clicked");
					break;
				}
			}
			Common.WaitForClock(ClockObj);
			int AllGrid=0;

			AllGrid = findAll(By.xpath("//button[@title='Product & services:Grid']")).size();
			for(int j=1;j<=AllGrid;j++){
				if(findBy("(//button[@title='Product & services:Grid'])["+j+"]").isCurrentlyVisible()) {
					findBy("(//button[@title='Product & services:Grid'])["+j+"]").click();
					break;
				}
			}

			Common.WaitForClock(ClockObj);
			if(ReasonTitleBox.isCurrentlyVisible()){
				String ErrorInfo= ReasonMsg.getText();

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ReasonOkButton.click();
				report.Info("The alert meassage is:"+ErrorInfo);
			}

			Common.WaitForClock(ClockObj);

			String sSelectActionListButton = "((.//*[@title='PRODUCTS & SERVICES Menu'])[3])";
			report.Info("Select Action Button property is : "+sSelectActionListButton);

			String sFlag = "N";
			String IDValue = "";

			if(findBy(".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-billed')]").isCurrentlyVisible()) {
				IDValue = find(By.xpath(".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-billed')]")).getAttribute("id");
			}
			if (sAction.equals("DrilldownMSISDN"))
			{
				int totalRows = findAll(By.xpath("//*[contains(@id,'"+IDValue+"')and contains(@id,'tile') and contains(@class,'siebui-tile')]")).size();
				for(int j=0;j<=totalRows;j++){

					String ActValue = find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).getText();

					if (ActValue.contains(sValue)){
						find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]")).click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("Product found: "+sValue);

						sFlag = "Y";

						if (sAction.equals("DrilldownMSISDN")&& (sFlag.equals("Y"))){															  
							Thread.sleep(2000);
							//InstalledIdClick.click();
							find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).click();
							report.Info("Installed ID is clicked");
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							Thread.sleep(2000);
							Common.WaitForClock(ClockObj);
						}
						break;
					}
					if(sFlag.equals("N") && j>=totalRows ){
						report.Info("No records found for "+sValue);
						Assert.assertTrue(false); 
						return;
					}
				}

			} 
			if (sAction.equals("PerformAdditionalAction")){															  
				Thread.sleep(2000);
			
				int	AllOwnedTabLink = findAll(By.xpath("//div[contains(@id,'_owned') and contains(text(),'Owned')]")).size();
				for(int j=1;j<=AllOwnedTabLink;j++){
					if(findBy("(//div[contains(@id,'_owned') and contains(text(),'Owned')])["+j+"]").isCurrentlyVisible()) {
						findBy("(//div[contains(@id,'_owned') and contains(text(),'Owned')])["+j+"]").click();
						report.Info("Owned Tab Clicked");
						break;
					}
				}
				
				SelectActionListButton.click();
				//find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				PerformAdditionalAction.click();
				report.Info("Perform Additional actions is selected from Billed product & services window");
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				if (AccountSummaryTab.isDisplayed()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Account Summary page is displayed after selecting Perform Additional Actions from Billed proodcut services window");    		   
				}

				if (!AccountSummaryTab.isDisplayed()){
					report.Info("Account Summary page is not displayed after selecting Perform Additional Actions from Billed proodcut services window");
					Assert.assertTrue(false);
				}
			}


		}
	}


	@FindBy (xpath="(.//div[contains(@class,'vfoui-used-tab acc-ps-tabs acc-ps-tabs-inactive')][text()='Used'])[1]")
	//@FindBy (xpath="(.//div[@class='vfoui-used-tab acc-ps-tabs acc-ps-tabs-inactive'][text()='Used'])")
	WebElementFacade UsedLink;
	@FindBy (xpath="(.//div[contains(@class,'vfoui-used-tab acc-ps-tabs acc-ps-tabs-inactive')][text()='Used'])[2]")
	WebElementFacade UsedLink2;
	@FindBy (xpath="(.//div[contains(@class,'vfoui-used-tab acc-ps-tabs acc-ps-tabs-inactive')][text()='Used'])[3]")
	WebElementFacade UsedLink3;
	@FindBy(xpath="(.//button[contains(@class,'siebui-ctrl-btn siebui-icon-gridtoggle')][contains(@title,':Grid')])[5]")
	WebElementFacade GridViewButtonforUsedTab;
	@FindBy(xpath="(.//a[@name='VF Installed ID'])[5]")
	WebElementFacade InstalledIdClickUsed;

	@Step
	public void UsedProductServices(String LogicalName) throws InterruptedException, IOException, AWTException{

		Thread.sleep(2000);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "OwnedProductServices";

		Common.WaitForClock(ClockObj);
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Action").size();i++) {       
			String sAction = tableMap.get("Action").get(i);
			String sValue = tableMap.get("Value").get(i);


			if (sValue.equals("Promotion")){
				sValue = Serenity.sessionVariableCalled("ProductName").toString();
			} 

			if (sValue.contains("RootProduct0")){
				sValue = sValue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}
			if (sValue.contains("ACCNTMSISDN")){
				sValue = sValue.replace("ACCNTMSISDN", Serenity.sessionVariableCalled("ACCNTMSISDN").toString());    	  

			}

			if(ReasonTitleBox.isCurrentlyVisible()){
				String ErrorInfo= ReasonMsg.getText();

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ReasonOkButton.click();
				report.Info("The alert meassage is:"+ErrorInfo);
			}

			int	AllUsedTabLink = findAll(By.xpath("//div[contains(@id,'_used') and contains(text(),'Used')]")).size();
			for(int j=1;j<=AllUsedTabLink;j++){
				if(findBy("(//div[contains(@id,'_used') and contains(text(),'Used')])["+j+"]").isCurrentlyVisible()) {
					findBy("(//div[contains(@id,'_used') and contains(text(),'Used')])["+j+"]").click();
					report.Info("Used Tab Clicked");
					break;
				}
			}
			Common.WaitForClock(ClockObj);
			int AllGrid=0;

			AllGrid = findAll(By.xpath("//button[@title='Product & services:Grid']")).size();
			for(int j=1;j<=AllGrid;j++){
				if(findBy("(//button[@title='Product & services:Grid'])["+j+"]").isCurrentlyVisible()) {
					findBy("(//button[@title='Product & services:Grid'])["+j+"]").click();
					break;
				}
			}
			Common.WaitForClock(ClockObj);
			if(ReasonTitleBox.isCurrentlyVisible()){
				String ErrorInfo= ReasonMsg.getText();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ReasonOkButton.click();
				report.Info("The alert meassage is:"+ErrorInfo);
			}


			String sSelectActionListButton = "(.//*[@title='PRODUCT & SERVICES Menu'])";
			report.Info("Select Action Button property is : "+sSelectActionListButton);

			String sFlag = "N";
			String IDValue = "";
			int j=0;
			String ActValue="";

			if(findBy(".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-used')]").isCurrentlyVisible()) {
				IDValue = find(By.xpath(".//*[contains(@class,'vfoui-product-grid vfoui-product-service-container vfoui-used')]")).getAttribute("id");
			} 
			if (sAction.equals("DrilldownMSISDN"))
			{
				int totalRows = findAll(By.xpath("//*[contains(@id,'"+IDValue+"')and contains(@id,'tile') and contains(@class,'siebui-tile')]")).size();
				for(j=0;j<=totalRows;j++){

					if(find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).isCurrentlyVisible()) {
						ActValue = find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).getText();

					}


					if (sValue.contains(ActValue)){
						find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]/div/div[1]")).click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("Product found: "+sValue);
						sFlag = "Y";

						if (sAction.equals("DrilldownMSISDN")&& (sFlag.equals("Y"))){															  
							Thread.sleep(2000);
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							//InstalledIdClick.click();
							find(By.xpath("//*[contains(@id,'"+IDValue+"') and contains(@id,'tile') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//a[contains(@name,'Installed')]")).click();
							report.Info("Installed ID is clicked");
							Thread.sleep(2000);
							Common.WaitForClock(ClockObj);
						}
						break;
					}
					if(sFlag.equals("N") && j>=totalRows ){
						report.Info("No records found for "+sValue);
						Assert.assertTrue(false); 
						return;

					}

				}
			}

			if (sAction.equals("PerformAdditionalAction")){															  
			
				int	AllOwnedTabLink = findAll(By.xpath("//div[contains(@id,'_owned') and contains(text(),'Owned')]")).size();
				for(j=1;j<=AllOwnedTabLink;j++){
					if(findBy("(//div[contains(@id,'_owned') and contains(text(),'Owned')])["+j+"]").isCurrentlyVisible()) {
						findBy("(//div[contains(@id,'_owned') and contains(text(),'Owned')])["+j+"]").click();
						report.Info("Owned Tab Clicked");
						break;
					}
				}
				
				Thread.sleep(2000);
				SelectActionListButton.click();
				find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				PerformAdditionalAction.click();
				report.Info("Perform Additional actions is selected from Billed product & services window");
				Common.WaitForClock(ClockObj);
				Thread.sleep(3000);

				Alert alert;
				String ActAlertText="";	
				if(isAlertPresent(getDriver())){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText(); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if (ActAlertText.contains("Please be aware")){                    	
						alert.accept();
						System.out.println("Message is: "+ActAlertText);
						report.Info("alert messsage is"+ActAlertText);		                	
					}                                 
				}

				Common.WaitForClock(ClockObj);
				Thread.sleep(3000);

				if (AccountSummaryTab.isDisplayed()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Account Summary page is displayed after selecting Perform Additional Actions from Billed proodcut services window");    		   
				}

				if (!AccountSummaryTab.isDisplayed()){
					report.Info("Account Summary page is not displayed after selecting Perform Additional Actions from Billed proodcut services window");
					Assert.assertTrue(false);
				}
			}


		}
	}

	@FindBy(xpath=".//*[@aria-label='Work Edit']")
	WebElementFacade CTIToolbarWorkEdit;
	@Step
	public void SearchForToolbar(String Action, String AccountNo) throws InterruptedException, AWTException, IOException {

		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "SearchAccount"; 
		String applet = "//*[@title='Activities List Applet']";
		String table = "//table[@summary='Order Dashboard Details']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);



		for (int i = 0;i < tableMap.get("Row").size();i++) {	   			
			String sAction = tableMap.get("Action").get(i);

			if(sAction.equals("SearchForCTIToolbar"))
			{
				CTIToolbarWorkEdit.isCurrentlyVisible();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("CTI Toolbar is Visible as Expected");
			}

			if(sAction.equals("DONotSearchForCTIToolbar"))
			{
				Assert.assertTrue("FAIL,CTI Toolbar is Visible ", !CTIToolbarWorkEdit.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("CTI Toolbar is not Visible as Expected");
			}
		}
	}

	@FindBy(xpath="//div[contains(@class,'customer-comm-refresh')]")
	WebElementFacade RefreshIcon;

	@FindBy(xpath="//button[@title='Activities:'][contains(@class,'gotonextset')]")
	WebElementFacade NextIcon;

	@Step
	public void CheckOrderInAccountOverview(String iRow) throws InterruptedException, IOException, AWTException{

		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CheckOrderStatus";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(iRow, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("OrderType").size();i++) {       
			String ExpectedStatus = tableMap.get("Status").get(i);
			String OrderType = tableMap.get("OrderType").get(i);

			String OrderNumber = "";
			String OrderStatus="";


			String SecondaryOrderNumber = "";

			String ActualStatus="";
			String ActualOrder="";
			String OrderStatusXpath="";

			int m=0;
			boolean flag = false;
			do {
				if(OrderType.equalsIgnoreCase("Secondary")) {
					OrderNumber = Serenity.sessionVariableCalled("OrderNo").toString();
					OrderStatus ="//a[text()='"+OrderNumber+"']/ancestor::div/following-sibling::div[contains(@class,'heading-status')]/input";
				}

				if(OrderType.equalsIgnoreCase("Modify")) {
					OrderNumber ="(//*[contains(@class,'vfoui-ao-activities-heading-desc')]//label[text()='Modify'])[1]/ancestor::div/preceding-sibling::div[contains(@class,'order')]/div[@class='vfoui-actvity-order-number']";
					OrderStatus ="(//*[contains(@class,'vfoui-ao-activities-heading-desc')]//label[text()='Modify'])[1]/ancestor::div/following-sibling::div[contains(@class,'heading-status')]/input";		
				}
				if(OrderType.equalsIgnoreCase("Disconnection")) {
					OrderNumber ="(//*[contains(@class,'vfoui-ao-activities-heading-desc')]//label[text()='Disconnection'])[1]/ancestor::div/preceding-sibling::div[contains(@class,'order')]/div[@class='vfoui-actvity-order-number']";
					OrderStatus ="(//*[contains(@class,'vfoui-ao-activities-heading-desc')]//label[text()='Disconnection'])[1]/ancestor::div/following-sibling::div[contains(@class,'heading-status')]/input";		
				}
				if(OrderType.equalsIgnoreCase("New Connection")) {
					OrderNumber ="(//*[contains(@class,'vfoui-ao-activities-heading-desc')]//label[text()='New Connection'])[1]/ancestor::div/preceding-sibling::div[contains(@class,'order')]/div[@class='vfoui-actvity-order-number']";
					OrderStatus ="(//*[contains(@class,'vfoui-ao-activities-heading-desc')]//label[text()='New Connection'])[1]/ancestor::div/following-sibling::div[contains(@class,'heading-status')]/input";		
				}
				OrderStatusXpath=OrderStatus;
				if(!find(By.xpath(OrderStatus)).isCurrentlyVisible()){
					if(NextIcon.isEnabled()) {
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						NextIcon.click();
						Thread.sleep(3000);
						Common.WaitForClock(ClockObj); 
					}
					else {
						Assert.assertTrue(false);
					}
				}
				else {

					OrderStatus=find(By.xpath(OrderStatus)).getTextValue();
					if(!OrderType.equalsIgnoreCase("Secondary")) {
						OrderNumber=find(By.xpath(OrderNumber)).getTextValue();
					}
					if(OrderType.equalsIgnoreCase("New Connection")) {
						Serenity.setSessionVariable("PrimaryOrderNo").to(OrderNumber);
					}
					flag=true;
				}
				m++;
				ActualOrder=OrderNumber;
			}while(flag==false);

			if(!ExpectedStatus.equals("")) {
				int k=0;
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				do{
					Thread.sleep(2000);

					Robot robot = new Robot();	 
					robot.keyPress(KeyEvent.VK_F5);	
					robot.keyRelease(KeyEvent.VK_F5);  

					Common.WaitForClock(ClockObj); 
					Thread.sleep(1000);

					ActualStatus = find(By.xpath(OrderStatusXpath)).getTextValue();

					if(ActualStatus.equalsIgnoreCase(ExpectedStatus)){

						break;                                          
					}
					k++;
				}while(!ActualStatus.equalsIgnoreCase(ExpectedStatus) && k <=60);                          
				Assert.assertTrue("Status of Order "+ActualOrder+" is "+ActualStatus,ActualStatus.equalsIgnoreCase(ExpectedStatus));
			}
		}
	}

	@FindBy(xpath="//input[contains(@aria-label,'Black Tariff')]")
	WebElementFacade BlackTariffCheckBox;

	@Step
	public void BlackTariffValidation_AccDetails(String iRow) throws InterruptedException, IOException, AWTException{

		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "BlackTariffValidation";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(iRow, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		AccountDetails.click();
		Common.WaitForClock(ClockObj);

		for (int i = 0;i < tableMap.get("RowNo").size();i++) {       
			String Validation = tableMap.get("Validation").get(i);

			if(Validation.equalsIgnoreCase("CheckBoxChecked")) {
				String CheckboxStatus =  BlackTariffCheckBox.getAttribute("aria-checked");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: Black Tariff CheckBox is not checked.",CheckboxStatus.equals("true"));
				report.Info("Black Tariff CheckBox is checked as expected.");
			}

			if(Validation.equalsIgnoreCase("CheckBoxUnChecked")) {
				String CheckboxStatus =  BlackTariffCheckBox.getAttribute("aria-checked");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: Black Tariff CheckBox is checked.",!CheckboxStatus.equals("true"));
				report.Info("Black Tariff CheckBox is unchecked as expected.");
			}

			if(Validation.equalsIgnoreCase("CheckBoxEditable")) {
				String CheckboxEditStatus =  BlackTariffCheckBox.getAttribute("aria-readonly");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: Black Tariff CheckBox is not editable.",CheckboxEditStatus.equals("false"));
				report.Info("Black Tariff CheckBox is editable as expected.");

				BlackTariffCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				BlackTariffCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}

			if(Validation.equalsIgnoreCase("CheckBoxNOTEditable")) {
				String CheckboxEditStatus =  BlackTariffCheckBox.getAttribute("aria-readonly");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: Black Tariff CheckBox is editable.",!CheckboxEditStatus.equals("false"));
				report.Info("Black Tariff CheckBox is not editable as expected.");

			}
		}
	}

	@FindBy(xpath="//div[@class='vfoui-background-blue vfoui-blue-alert vfoui vfoui-blck-tarif']")
	WebElementFacade VFBlackBannerDiv;

	@FindBy(xpath="//div[@class='vfoui-background-amber vfoui-inline-flex']")
	WebElementFacade VIPCustomerBannerDiv;


	@Step
	public void verifyVFBlackBannerHalo() {
		try {
			String VFBlackBannerText = VFBlackBannerDiv.getText();
			Assert.assertTrue("Black Tarif Banner is present as expected", VFBlackBannerText.contains("This is a Vodafone Black"));
		}
		catch(NoSuchElementException nse) {
			Assert.assertTrue("Black Tarif Banner is not present", false);
		}
	}

	@Step
	public void verifyVIPCustomerBannerHalo() {
		try {
			String VIPCustomerBannerText = VIPCustomerBannerDiv.getText();
			Assert.assertTrue("VIP Banner is present as expected", VIPCustomerBannerText.contains("This is a VIP account"));

		}
		catch(NoSuchElementException nse) {
			Assert.assertTrue("VIP Banner is not present", false);
		}

	}
}
