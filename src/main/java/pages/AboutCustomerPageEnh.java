package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
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

import com.gargoylesoftware.htmlunit.javascript.host.Set;

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

public class AboutCustomerPageEnh extends PageObject {

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
	@FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
	WebElement ClockObj;

	@FindBy(xpath="//input[@aria-label='Title']")
	WebElementFacade TitleWebList;

	@FindBy(xpath="//input[@aria-label='First name']")
	WebElementFacade firstnameEditBox;

	@FindBy(xpath="//input[@aria-label='Email']")
	WebElementFacade emailEditBox;

	@FindBy(xpath="//input[@aria-label='Last name']")
	WebElementFacade lastNameEditBox;

	@FindBy(xpath=".//*[@aria-label='Gender (optional)']")
	WebElementFacade Gender;

	@FindBy(xpath=".//*[contains(@aria-labelledby,'PrimaryContactGender')][@value='M']")
	WebElementFacade GenderMaleRadioButton;



	@FindBy(xpath=".//*[@aria-labelledby='PrimaryContactDateofBirth_Label']")
	WebElementFacade DOBTextBox;

	@FindBy(xpath=".//*[@aria-labelledby='PrimaryContactMobilePhone_Label']")
	WebElementFacade ContactNum;

	@FindBy(xpath=".//*[@aria-label='VF_PIN_1']")
	WebElementFacade pin1;

	@FindBy(xpath=".//*[@aria-label='VF_PIN_2']")
	WebElementFacade pin2;

	@FindBy(xpath=".//*[@aria-label='VF_PIN_3']")
	WebElementFacade pin3;

	@FindBy(xpath=".//*[@aria-label='VF_PIN_4']")
	WebElementFacade pin4;

	@FindBy(xpath=".//*[@aria-label='Create online account']")
	WebElementFacade OnlineAccCheck;

	@FindBy(xpath=".//*[@aria-label='VF_Username']")
	WebElementFacade UserNameTextBox;

	@FindBy(xpath=".//*[contains(@aria-label,'Personal details:Save')]")
	WebElementFacade SaveInfoButton;

	@FindBy(xpath=".//*[contains(@aria-label,'do not wish to register')]")
	WebElementFacade AnonymousCheckBox;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Username_Label']")
	WebElementFacade UsernameLabelTextBox;

	@FindBy(xpath=".//*[@aria-label='Personal details:Remove email']")
	WebElementFacade RemoveEmailButton;



	@FindBy(xpath=".//*[@aria-label='Personal details:Update email']")
	WebElementFacade UpdateEmailButton;
	@FindBy(xpath=".//*[@aria-labelledby='VFEmailAddress_Label']")
	WebElementFacade EmailTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VFReTypeEmailAddress_Label']")
	WebElementFacade ConfirmEmailTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VFDomainAddress_Label']")
	WebElementFacade EmailDoamin;
	@FindBy(xpath=".//*[@aria-labelledby='VFReTypeDomainAddress_Label']")
	WebElementFacade ConfirmEmailDoamin;
	@FindBy(xpath=".//*[@aria-label='Siebel:OK']")
	WebElementFacade EmailOKButton;
	@FindBy(xpath=".//input[contains(@aria-labelledby,'EmailAddress')]")
	WebElementFacade EmailAddressCheckBox;

	@Step
	public void AddPersonalDetails(String accountType) throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreateNewAccount";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("First_Name").size();i++) {
			String FirstName = tableMap.get("First_Name").get(i);
			String LastName = tableMap.get("Last_Name").get(i);
			String PostCode = tableMap.get("Post_Code").get(i);
			// String Email = tableMap.get("Email").get(i);
			String Email1 = tableMap.get("Email1").get(i);
			String Email2 = tableMap.get("Email2").get(i);
			String Birth_Date = tableMap.get("Birth_Date").get(i);
			String Account_Type = tableMap.get("Account_Type").get(i);             
			String sNew = tableMap.get("New").get(i);
			String TradingAs = tableMap.get("TradingAs").get(i);
			String Online_Account = tableMap.get("OnlineAccount").get(i);
			String User_Name = tableMap.get("User_name").get(i);
			String isAnonymous = tableMap.get("Anonymous").get(i);
			String sRemoveEmail = tableMap.get("RemoveEmail").get(i);
			String sSave = tableMap.get("Save").get(i);

			TitleWebList.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();

			if (sSave.equals("PlaceHolderCheck")){
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);

				String check =TitleWebList.getAttribute("placeholder");
				Assert.assertTrue("FAIL, TitleWebList Text Box doesn't contain Hint", !check.equals(""));
				check =firstnameEditBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,firstnameEditBox Text Box doesn't contain Hint", !check.equals(""));
				check =lastNameEditBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,lastNameEditBox Text Box doesn't contain Hint", !check.equals(""));
				check =DOBTextBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,DOBTextBox Text Box doesn't contain Hint", !check.equals(""));
				check =emailEditBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,Confirm emailEditBox Text Box doesn't contain Hint", !check.equals(""));

			}


			if (isAnonymous.equals("Y")){
				TitleWebList.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
				/*TitleWebList.type("Mr.");
				firstnameEditBox.click();

				AnonymousCheckBox.click();
				firstnameEditBox.click();
				Common.WaitForClock(ClockObj);*/

				String AccountNumber = Serenity.sessionVariableCalled("AccountNo").toString();

				String Fname=firstnameEditBox.getTextValue();	
				Assert.assertTrue("Fail, First Name is not pre populated as expected",AccountNumber.contains(Fname));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				//SaveInfoButton.click();

				report.Info("Anonymous personal details created successfully");

				return;
			}


			String Fname=firstnameEditBox.getTextValue();	
			Assert.assertTrue("Fail, First Name is not pre populated as expected",!Fname.equals(""));
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			String Lname=lastNameEditBox.getTextValue();	
			Assert.assertTrue("Fail, Last Name is not pre populated as expected",!Lname.equals(""));
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			String Email=emailEditBox.getTextValue();	
			Assert.assertTrue("Fail, Email is not pre populated as expected",!Email.equals(""));
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if(	TitleWebList.isCurrentlyVisible()) {
				TitleWebList.type("Mr.");
			}
			
			if(	GenderMaleRadioButton.isCurrentlyVisible()) {
				GenderMaleRadioButton.click();
			}
			
			DOBTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			DOBTextBox.type(Birth_Date); 	
		
			DOBTextBox.sendKeys(Keys.chord(Keys.CONTROL, "s"));
			
			Alert alert;
			String ActAlertText="";	
			if(isAlertPresent(getDriver())){
				alert=getDriver().switchTo().alert();
				ActAlertText=alert.getText(); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if (ActAlertText.contains("age is under 18")){                     	
					alert.accept();
					System.out.println("Message is: "+ActAlertText);
					report.Info("alert messsage is"+ActAlertText);		                	
				}                                 
			}
	
			
			/* 	            if (!TradingAs.equals(""))
 	            {
 	                  TradingAsTextBox.type(TradingAs);
 	            } */ 
			ContactNum.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			String ContactNumber = ContactNum.getTextValue();
			if(!sSave.equals("ClearContactNum")){
			if(ContactNumber.equals("")){
				ContactNum.type("91234567890");
			}
			pin1.click();
			}
			
		
			if(isAlertPresent(getDriver())){
				alert=getDriver().switchTo().alert();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				alert.accept();
			}

			pin1.type("1");
			pin2.type("1");
			pin3.type("1");
			pin4.type("5");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			String IfChecked =OnlineAccCheck.getAttribute("aria-checked");
			if (IfChecked.equalsIgnoreCase("true") && Online_Account.equals("Off")){
				OnlineAccCheck.click(); 
			}
			if(Online_Account.equals("On"))
			{
				Random RandomNo = new Random(System.currentTimeMillis());
				int num = RandomNo.nextInt(2000000000);
				String orderNo = "AUTOMATION" + num ;

				UpdateEmailButton.click();
				Common.WaitForClock(ClockObj);
				EmailTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				EmailTextBox.type(orderNo);
				EmailDoamin.type(Email2);
				ConfirmEmailTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				ConfirmEmailTextBox.type(orderNo);
				ConfirmEmailDoamin.type(Email2);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				EmailOKButton.click();

				Common.WaitForClock(ClockObj);
				EmailAddressCheckBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				EmailAddressCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}
			if(sRemoveEmail.equalsIgnoreCase("Yes"))
			{
				EmailAddressCheckBox.isCurrentlyVisible();
				EmailAddressCheckBox.click();
				DOBTextBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				RemoveEmailButton.isCurrentlyVisible();
				RemoveEmailButton.click();
				Common.WaitForClock(ClockObj);
				report.Info("Remove Email Button Clicked successfully");

			}

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			SaveInfoButton.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyEnabled();
			SaveInfoButton.click();

			Common.WaitForClock(ClockObj);
			SaveInfoButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			String UsernameTB = UsernameLabelTextBox.getAttribute("readonly");
			Assert.assertTrue("Fail, Personal Details not added",!UsernameTB.equals(""));
			report.Info("Personal Details added successfully");
		}
	}


	@Step
	public void ValidatePostCodeCaseSensitive(String accountType) throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreateNewAccount";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("First_Name").size();i++) {
			String PostCode = tableMap.get("Post_Code").get(i);		
			if(AddressLabel.isCurrentlyVisible()){
				AddressLabel.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				String sCurrentAddress = AddressLabel.getTextValue();
				Assert.assertTrue("Fail, Postcode populated is not in UpperCase",sCurrentAddress.contains(PostCode.toUpperCase()));
				report.Info("Postcode populated is in UpperCase");
			}
		}
	}

	@FindBy(xpath=".//*[@value='SearchPostcode']")
	WebElementFacade AdressSearchbyPostCodeRadioButton;
	@FindBy(xpath=".//*[@value='ManualSearch']")
	WebElementFacade AdressSearchManuallyRadioButton;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Years_at_address_Label']")
	WebElementFacade YearAtAdressTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Months_at_address_Label']")
	WebElementFacade MonthAtAdressTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Postcode_Label']")
	WebElementFacade PostCodeTextBox;
	@FindBy(xpath=".//*[@aria-label='Enter new primary address:Search']")
	WebElementFacade PostCodeSearchButton;
	@FindBy(xpath="(.//*[@aria-labelledby='s_11_l_House_Name'])[1]")
	WebElementFacade SelectFirstHouseName;
	@FindBy(xpath=".//*[@aria-label='QAS:OK']")
	WebElementFacade AdressAppletOKButton;
	@FindBy(xpath=".//*[text()='Current address']/ancestor::div[1]/following-sibling::div[1]//label")
	WebElementFacade CurrentAdressValue;
	@FindBy(xpath=".//*[text()='Previous Address']/ancestor::div[1]/following-sibling::div[1]//label")
	WebElementFacade PreviousAdressValue;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Postcode_manual_Label']")
	WebElementFacade ManualPostCodeTextBox;
	@FindBy(xpath=".//*[@aria-label='Flat or sub-building']")
	WebElementFacade FlatTextBox;
	@FindBy(xpath=".//*[@aria-label='Home Number']")
	WebElementFacade HouseNoTextBox;
	@FindBy(xpath=".//*[@aria-label='Address line 1']")
	WebElementFacade AddressLine1TextBox;
	@FindBy(xpath=".//*[@aria-label='Town/City']")
	WebElementFacade CityTextBox;
	@FindBy(xpath=".//*[@aria-label='Country']")
	WebElementFacade CountryTextBox;
	@FindBy(xpath=".//*[@aria-label='Enter new primary address:Save information']")
	WebElementFacade AdressSaveButton;

	@FindBy(xpath=".//*[@aria-label='Address']")
	WebElementFacade Adress;
	@FindBy(xpath=".//*[@aria-label='Address']//following-sibling::span")
	WebElementFacade AdressDropDown;
	@FindBy(xpath="(.//*[@data-lovtype='VF OUI Enter Contact Address Applet:VF OUI Concat Address'])[1]")
	WebElementFacade SelectFirstAddress;

	@FindBy(xpath=".//*[contains(text(),'Error message')]")
	WebElementFacade ErrorTitleBox;  
	@FindBy(xpath=".//div[contains(@class,'popup-info')]")
	WebElementFacade ErrorMsg; 
	@FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
	WebElementFacade ErrorOkButton;

	@FindBy(xpath=".//*[@title='Addresses:Edit']")
	WebElementFacade AddressEditButton;
	@FindBy(xpath=".//*[text()='Current address']/ancestor::div[1]/following-sibling::div[2]//label")
	WebElementFacade YearMonthValue;

	@Step
	public void AddAdress(String accountType) throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreateNewAccount";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("First_Name").size();i++) {

			String PostCode = tableMap.get("Post_Code").get(i);	        	
			String sAddressLine = tableMap.get("AddressLine").get(i); 
			String sSave = tableMap.get("Save").get(i); 
			String sPopup = tableMap.get("Popup").get(i);


			Random rand = new Random(System.currentTimeMillis());
			int num = rand.nextInt(200000);
			String valuenew = String.valueOf(num);
			String Flat = "FLAT"+valuenew;
			String House = "HOUSE"+valuenew;
			String Address = "ADDRESS"+valuenew;
			Common.WaitForClock(ClockObj);

			//	AdressSearchbyPostCodeRadioButton.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();

			if (sSave.equals("PlaceHolderCheck")){
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);

				MonthAtAdressTextBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				String check =PostCodeTextBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL, PostCodeTextBox Text Box doesn't contain Hint", !check.equals(""));
				check =Adress.getAttribute("placeholder");
				Assert.assertTrue("FAIL,Adress Text Box doesn't contain Hint", !check.equals(""));
				check =YearAtAdressTextBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,YearAtAdressTextBox Text Box doesn't contain Hint", !check.equals(""));
				check =MonthAtAdressTextBox.getAttribute("placeholder");
				Assert.assertTrue("FAIL,MonthAtAdressTextBox Text Box doesn't contain Hint", !check.equals(""));

			}

			if (sAddressLine.equalsIgnoreCase("By manually")){
				AdressSearchManuallyRadioButton.click();
				ManualPostCodeTextBox.type(PostCode);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				FlatTextBox.type(Flat);	        	 	
				HouseNoTextBox.type(House);	        	 	
				AddressLine1TextBox.type(Address);	        	 	
				CityTextBox.type("London");	        	 	
				CountryTextBox.type("United Kingdom");	

				if(sSave.equalsIgnoreCase("Validation")) {
					AdressSaveButton.click();
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);

					Common.HandleErrorPopUp(sPopup);
				}

				YearAtAdressTextBox.type("2");
				MonthAtAdressTextBox.type("6");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				AdressSaveButton.click();
				Common.WaitForClock(ClockObj);
			}
			else{
				AdressSearchbyPostCodeRadioButton.click();

				if(sAddressLine.equalsIgnoreCase("PostCodeValidation")){
					PostCodeSearchButton.click();
					Thread.sleep(2000);
					if(ErrorTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ErrorMsg.getText();  

						if(ErrorInfo.contains(sPopup)){	
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							ErrorOkButton.click();
							report.Info("The alert meassage is: "+ErrorInfo);
						}
						else{
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							report.Info("UnExpected Pop did occured");
							Assert.assertTrue(false);   
						}
					}
					return;
				}

				PostCodeTextBox.type(PostCode);
				Common.WaitForClock(ClockObj);

				PostCodeSearchButton.click();
				Thread.sleep(2000);
				AdressDropDown.click();
				Thread.sleep(5000);
				SelectFirstAddress.click();

				/*if(PostCode.equalsIgnoreCase("E1W 2RL") ){
					Adress.type("The Wapping Group Practice,22,,Wapping Lane,,LONDON,,E1W 2RL,United Kingdom");
				}
				else if (PostCode.equalsIgnoreCase("B1 1BA")) {
					Adress.type("Apartment 1903,10,Beetham Tower,Holloway Circus Queensway,,BIRMINGHAM,,B1 1BA,United Kingdom");
				}*/

				if(sSave.equalsIgnoreCase("Validation")) {
					AdressSaveButton.click();
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);
					Common.HandleErrorPopUp(sPopup);
				}

				//Adress.type("The Wapping Group Practice,22,,Wapping Lane,,LONDON,,E1W 2RL,United Kingdom");
				if(YearAtAdressTextBox.isCurrentlyVisible()){
					YearAtAdressTextBox.type("3");
					MonthAtAdressTextBox.type("6");
				}


				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				AdressSaveButton.click();

			}
			Common.WaitForClock(ClockObj);
			//AdressSearchbyPostCodeRadioButton.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			Common.WaitForClock(ClockObj);
			Thread.sleep(2000);
			CurrentAdressValue.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if(sAddressLine.equalsIgnoreCase("Previous Address")){
				String AdressSaveValidate = PreviousAdressValue.getTextValue();
				Assert.assertTrue("Fail, Adress is not populated in Current Value as expected",AdressSaveValidate.contains(PostCode));
				report.Info("Previous Address populated successfully");
			}
			else if (sAddressLine.equalsIgnoreCase("AmendTime")){
				Common.WaitForClock(ClockObj);
				AddressEditButton.click();
				report.Info("Address Edit Button clicked");
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				PostCodeTextBox.type(PostCode);
				Common.WaitForClock(ClockObj);

				/*if(PostCode.equalsIgnoreCase("E1W 2RL") ){
					Adress.type("The Wapping Group Practice,22,,Wapping Lane,,LONDON,,E1W 2RL,United Kingdom");
				}
				else if (PostCode.equalsIgnoreCase("B1 1BA")) {
					Adress.type("Apartment 1903,10,Beetham Tower,Holloway Circus Queensway,,BIRMINGHAM,,B1 1BA,United Kingdom");
				}*/

				PostCodeSearchButton.click();
				Thread.sleep(1000);
				PostCodeSearchButton.click();
				Thread.sleep(1000);
				AdressDropDown.click();
				Thread.sleep(2000);
				SelectFirstAddress.click();
				Thread.sleep(1000);


				//Adress.type("The Wapping Group Practice,22,,Wapping Lane,,LONDON,,E1W 2RL,United Kingdom");
				Common.WaitForClock(ClockObj);
				if (YearAtAdressTextBox.isCurrentlyVisible()){
					YearAtAdressTextBox.type("5");
					MonthAtAdressTextBox.type("5");
					report.Info("Year and Month changed");
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				AdressSaveButton.click();


				Common.WaitForClock(ClockObj);
				//AdressSearchbyPostCodeRadioButton.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
				YearMonthValue.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				String MonthYearValidate = YearMonthValue.getTextValue();
				Assert.assertTrue("Fail, Year Month not populated in Current Value as expected",MonthYearValidate.contains("5"));
				report.Info("Year Month populated successfully");

			}
			else{
				String AdressSaveValidate = CurrentAdressValue.getTextValue();
				Assert.assertTrue("Fail, Adress is not populated in Current Value as expected",AdressSaveValidate.contains(PostCode.toUpperCase()));
				report.Info("Current Address populated successfully");
			}
			report.Info("Address created successfully");
		}
	}

	@FindBy(xpath=".//*[@aria-labelledby='VF_Override_CreditVet_Label']")
	WebElementFacade CreditVettingCheckBox;
	@FindBy(xpath=".//*[@aria-label='Credit vetting:Perform credit vetting']")
	WebElementFacade CreditVettingButton;

	@FindBy(xpath="//button/span[text()='Perform credit vetting']")
	WebElementFacade PerformCreditVettingButton;
	
	@FindBy(xpath="//button/span[text()='Ok']")
	WebElementFacade PerformCreditVettingOKPopUpButton;

	@FindBy(xpath=".//*[@aria-label='Billing profile:Save']")
	WebElementFacade SaveButton;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Override_CreditVet_Label']")
	WebElementFacade CreditVettingOverride;
	
	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_account_name_Label']")
	WebElementFacade BankAccountDetails;

	@FindBy(xpath=".//*[@class='vfoui-parent-container vfoui-order-biling-profile-parent vfoui_box_shadow']//*[@class='vfoui-inline-flex vfoui-order-billing-sortCode vfoui-bill-sort']//input[@placeholder='e.g. 000000']")
	WebElementFacade SortCode;

	@FindBy(xpath=".//*[@class='vfoui-parent-container vfoui-order-biling-profile-parent vfoui_box_shadow']//*[@class='vfoui-inline-flex vfoui-order-billing-sortCode vfoui-bill-sort']//input[@placeholder='e.g. 30830208']")
	WebElementFacade AccountNumber;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Payment_Method_Label']")
	WebElementFacade PaymentChange;

	@FindBy(xpath = ".//*[@aria-labelledby='VF_Payment_Method_Label']/following-sibling::span")
	WebElementFacade PaymentDropdown;

	@FindBy(xpath = ".//li[text()='Credit/Debit Card']")
	WebElementFacade CreditDebitOption;

	@FindBy(xpath=".//*[@title='Basket:Next' and contains(@class,'siebui-ctrl-btn siebui-icon-proceedwithproceed')]")
	WebElementFacade NextButton;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Payment_Method_Label']")
	WebElementFacade PaymentMethod;


	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Account_Name_Label']")
	WebElementFacade BankAccountName;
	
	@FindBy(xpath="//input[@aria-labelledby='VF_Employment_Status_Label']")
	WebElementFacade InputEmploymentStatus;
	
	@FindBy(xpath="//input[@aria-labelledby='VF_Residential_Status_Label']")
	WebElementFacade ResidentialStatusInput;
	
	@FindBy(xpath=".//*[text()='Ok']")
	WebElementFacade MissingContactPopup;
	@FindBy(xpath=".//*[@class='vf-chckbox-text-valign vfoui-admin-fee-checkbox']")
	WebElementFacade AddDamagedReturnCharge;
	
	@FindBy(xpath="(.//*[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])[2]")
	WebElementFacade AddDamagedReturnChargeOkButton;
	@SuppressWarnings("unlikely-arg-type")
	@Step
	public void CreditVettingResultsOUI(String Action) throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);

		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreditVet"; 

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("CreditVet").size();i++) {

			String sCreditVet = tableMap.get("CreditVet").get(i);
			String sNextButton = tableMap.get("NextButton").get(i);
			String sBankAccountNo = tableMap.get("BankAccountNo").get(i);
			String sSortCode = tableMap.get("SortCode").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			
			//Common.WaitForClock(ClockObj);

			if(sBankAccountNo.equalsIgnoreCase("") ){
				sBankAccountNo = "N";

			}
			
			if(sSortCode.equalsIgnoreCase("") ){
				sSortCode = "N";
			}

			//Common.WaitForClock(ClockObj);

			if(sCreditVet.equalsIgnoreCase("Yes") ){
				BankAccountName.sendKeys("ABC ABC");
				AccountNumber.sendKeys(sBankAccountNo);
				SortCode.sendKeys(sSortCode);
				InputEmploymentStatus.sendKeys("Employed Full Time");
				ResidentialStatusInput.sendKeys("Not Asked");

				PerformCreditVettingButton.click();
				Common.WaitForClock(ClockObj);
				PerformCreditVettingOKPopUpButton.click();
				report.Info("CreditVetting Button clicked");

			}
			else{
				if (CreditVettingCheckBox.isCurrentlyVisible()){
					CreditVettingCheckBox.click();
					Common.WaitForClock(ClockObj);
					report.Info("CreditVettingCheckBox clicked");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					Common.WaitForClock(ClockObj);

					String CreditVettingChecked = CreditVettingCheckBox.getAttribute("aria-checked");
					if (CreditVettingChecked.equals("false")){
						CreditVettingCheckBox.click();                                     
					}
					BankAccountName.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.WaitForClock(ClockObj);
				}
			}	

			if(sNextButton.equalsIgnoreCase("Yes") ){
				Thread.sleep(1000);
				CapturedAccNo.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				NextButton.click();
				Common.WaitForClock(ClockObj);

			}
			if(sValidation.equalsIgnoreCase("GigaCube"))
			{
			if (sPopUp.equals("For Gigacube/MBB, the primary contact"))
			{
				report.Info("Contact number is not updated. Pop up is : "+sPopUp);
				MissingContactPopup.waitUntilClickable();
				MissingContactPopup.click();
			}else
			{
				Assert.assertTrue("Fail, Expected PopUp did not occur",sPopUp.equals("For Gigacube/MBB, the primary contact"));
				report.Info("Contact number is updated. Pop up is : "+sPopUp);
			 

			}
			}
		}	  		  
	}

	@Step
	public void ClickNextButton() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if(AddDamagedReturnCharge.isCurrentlyVisible()) {
			AddDamagedReturnChargeOkButton.click();
		}
		//workaround for enabling Next button by clicking other element
		if(!NextButton.isCurrentlyEnabled()) {
			if(TitleWebList.isCurrentlyVisible()) {
				TitleWebList.click();
				Thread.sleep(1000);
			}
		}
		NextButton.click();
		Common.WaitForClock(ClockObj);
		if(AddDamagedReturnCharge.isCurrentlyVisible()) {
			AddDamagedReturnChargeOkButton.click();
		}
	}

	@FindBy(xpath=".//button[@title='Basket:Customise']")
	WebElementFacade customiseButtonEnh;

	@FindBy(xpath=".//button[@title='Basket:Add-ons']")
	WebElementFacade AddOnButtonEnh;

	@FindBy(xpath="//*[text()='Account no:']/parent::span")
	WebElementFacade CapturedAccNo;

	@FindBy(xpath=".//span[text()='Error message']")
	WebElementFacade ErrorMessagebox;

	@FindBy(xpath=".//div[@class='vf-oui-dialog-content']")
	WebElementFacade ErrorMessage;

	@FindBy(xpath=".//button/span[text()='Ok']")
	WebElementFacade ErrorMessageOKButton;

	@FindBy(xpath=".//*[contains(text(),'captured the required')]")
	WebElementFacade ErrorPopup;

	@FindBy(xpath=".//div[contains(text(),'The account owner cannot also be set as')]")
	WebElementFacade ConfigurationErrorMessage;

	@FindBy(xpath=".//*[@aria-label='Row #']")
	WebElementFacade rowId;
	@FindBy(xpath=".//*[@aria-label='About Record:OK']")
	WebElementFacade aboutRecordOkButton;

	@FindBy(xpath = "//button/span[text()='Add card details']")
	WebElementFacade AddcardDetails;

	@Step
	public void BillingProfileSelectionOUI(String Action) throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreateNewBillingProfile"; 

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Value").size();i++) {

			String sValue = tableMap.get("Value").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sClickNext = tableMap.get("ClickNext").get(i);
			String sExernaPaymentSystemWindow = tableMap.get("ExernaPaymentSystemWindow").get(i);
			if (sPopup.equals("")){
				sPopup = "No";
			}
			if (sExernaPaymentSystemWindow.equals("")) {
				sExernaPaymentSystemWindow = "No";
			}

			if (sValue.equals("DirectDebit")){

				PaymentChange.isVisible();
				PaymentChange.clear();
				PaymentChange.type("Direct Debit");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				SaveButton.click();
				Common.WaitForClock(ClockObj);
				BankAccountDetails.type("acc_vodafone");
				SortCode.type("301215");
				AccountNumber.type("12341234");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(ClockObj);
			}

			if (sValue.equals("AboutRecord")){
				PaymentMethod.sendKeys(Keys.chord(Keys.CONTROL,Keys.ALT, "k"));

				Common.WaitForClock(ClockObj);
				String sRowId = rowId.getTextValue();
				Serenity.setSessionVariable("RowId").to(sRowId);
				report.Info("About Record Row ID : "+sRowId);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				aboutRecordOkButton.click();
				Common.WaitForClock(ClockObj);
			}

			if (!sValue.equalsIgnoreCase("Cash")){
				SaveButton.click();
				Common.WaitForClock(ClockObj);

			}	

			//**************************************************************************************************************
			if (sValue.equals("Credit/Debit Card")){

				/*PaymentChange.isVisible();
                PaymentChange.clear();
                PaymentChange.type(sValue);*/
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				PaymentDropdown.click();	
				Thread.sleep(2000);
				CreditDebitOption.click();
				Thread.sleep(2000);

				if(sExernaPaymentSystemWindow.contains("N")) {
					SaveButton.click();
				}
				if(sExernaPaymentSystemWindow.contains("Y")){
					AddcardDetails.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					AddcardDetails.click();
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					WebDriver driver =getDriver();
					String title="";
					Thread.sleep(5000);
					String initialWindow = "";             
					initialWindow = driver.getWindowHandle();
					java.util.Set<String>winHandles = driver.getWindowHandles();
					for (String handle : winHandles) {
						if (!handle.equals(initialWindow)) {
							driver.switchTo().window(handle);
							Thread.sleep(1000);
							enterAeirandiCardDetails("CreditCardVisa");
						}
					}
					driver.switchTo().window(initialWindow);
				}
				Common.WaitForClock(ClockObj);

			}


			//**************************************************************************************************************

			if(ErrorPopup.isCurrentlyVisible())
			{
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ErrorMessageOKButton.click();
				Common.WaitForClock(ClockObj);
			}
			Common.WaitForClock(ClockObj);
			CapturedAccNo.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if(!sClickNext.equalsIgnoreCase("N")) {
				NextButton.click();
				Common.WaitForClock(ClockObj);
			}

			if(sPopup.equalsIgnoreCase("The account owner cannot also be set as")) {
				if(ConfigurationErrorMessage.isVisible()) {
					report.Info("Pass:Expected Popup did occur");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				else{
					report.Info("Expected Pop did not occur");
					Assert.assertTrue(false); 
				}
			}
			/*if(!sPopup.equalsIgnoreCase("No")){
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
			}*/
		}

	}    	


	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Account_Number_Label']")
	WebElementFacade BankAccountNumber;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Employment_Status_Label']")
	WebElementFacade EmploymentStatus;


	@FindBy(xpath=".//*[@aria-labelledby='VF_Residential_Status_Label']")
	WebElementFacade ResidentialStatus;


	@FindBy(xpath=".//*[contains(@class,'vfoui-credit-vet-labl-1')]/span")
	WebElementFacade CreditVettingResult;


	@FindBy(xpath=".//input[@aria-labelledby='VF_ID_Type_Label']")
	WebElementFacade IDCheck;
	
	
	@FindBy(xpath=".//button[@aria-label='Identification check:Save information']")
	WebElementFacade IDSave;

	
	@FindBy(xpath=".//span[text()='IDV Check Successful']")
	WebElementFacade IDSuccess;
	

	@FindBy(xpath=".//button[@title='Ok']")
	WebElementFacade SuccessOk;
	

	
	@FindBy(xpath=".//*[@aria-labelledby='VF_Sort_code_Label']")
	WebElementFacade BankSortCode;

	@Step
	public void CreditVettingWithIDVCheckAndResults (String Action) throws InterruptedException, IOException, AWTException{

		
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreditVet";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("RowNo").size();i++) {

			String sVaildation = tableMap.get("Validation").get(i);
			String sBankAccountNo = tableMap.get("BankAccountNo").get(i);
			String sSave = tableMap.get("Save").get(i);
			String sValue = tableMap.get("Value").get(i);

			

			if(sSave.equals("CreditVettingOverride")){
				
				CreditVettingOverride.click();
				Common.WaitForClock(ClockObj);
				
				if (!sValue.equalsIgnoreCase("Cash")){
					SaveButton.click();
					Common.WaitForClock(ClockObj);
				}
				break;
			}
			
			if(sSave.equalsIgnoreCase("CreditPerform")){
				   Common.WaitForObjectPresence("IDCheck");
					IDCheck.typeAndEnter("Call Validate");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					IDSave.click();
					Common.WaitForClock(ClockObj); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					
					
				}
				
				if(sSave.equalsIgnoreCase("ManualOverride")){
					IDCheck.typeAndEnter("Manual Override");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					IDSave.click();
					Common.WaitForClock(ClockObj); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					
					
					if(IDSuccess.isCurrentlyVisible()) {
						SuccessOk.click();
					}
					else {
						report.Info("IDV Check Succesful is not displayed");
					Assert.assertTrue("FAIL: IDV Check Succesful is not displayed",IDSuccess.isCurrentlyVisible());
					} 
							return;
				
				}
				
		
		Thread.sleep(1000);
		
		if(IDSuccess.isCurrentlyVisible()) {
			SuccessOk.click();
			report.Info("IDV Check Succesful is displayed");
		}
		else {	
			Assert.assertTrue("FAIL: IDV Check Succesful is not displayed",IDSuccess.isCurrentlyVisible());
		} 

		


			if( BankAccountName.isCurrentlyVisible()) {					
				BankAccountName.typeAndEnter("john");
				BankSortCode.typeAndEnter("400140");
				BankAccountNumber.typeAndEnter(sBankAccountNo);
				EmploymentStatus.typeAndEnter("Employed Full Time");
				Thread.sleep(1000);
				ResidentialStatus.typeAndEnter("Owner");
				CreditVettingButton.click();
				Common.WaitForClock(ClockObj); 

			}
			else {	
				report.Info("BankAccountName Edit box is not present on page.");

				Assert.assertTrue(false); }


			String sResult = CreditVettingResult.getTextValue();


			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			if (sResult.equalsIgnoreCase(sVaildation))
			{
				report.Info("Pass:Expected Popup did occur");
			}
			else{
				report.Info("Expected Pop did not occur");
				Assert.assertTrue(false); 
			}
		}

		Common.WaitForClock(ClockObj);
		NextButton.click();
		Common.WaitForClock(ClockObj);

	}

	@FindBy(xpath=".//td[contains(@title,'Vodafone Cloud Services Marketplace ADP')]/span")
	WebElementFacade ADPNumber;
	
	@Step
	public void CustomiseProductEnh(String Rownum) throws IOException, InterruptedException, AWTException{
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
		String dataSheet = "CustomiseProductEnh";
		String applet = ".//*[@class='ui-jqgrid-view']";
		String table = "//table[@summary='Basket']";	 


		//String table = "//table[@class='ui-jqgrid-btable']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Rownum, filePath, dataSheet);
		readWorkbook.testData(tableMap);


		for (int i = 0;i < tableMap.get("SelectItem").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sCustomise = tableMap.get("Customise").get(i);
			String sAddOn = tableMap.get("AddOn").get(i);
			//String SelectItem = tableMap.get("SelectItem").get(i);
			String Index = tableMap.get("Index").get(i);
			String sLocateColExpand = tableMap.get("LocateColExpand").get(i);
			String sLocateColExpandValue = tableMap.get("LocateColExpandValue").get(i);
			String ExpandIndex = tableMap.get("ExpandIndex").get(i);
			
			if (Index.equals("")){
				Index = "0";
			}
			if (ExpandIndex.equals("")){
				ExpandIndex = "0";
			}
			

			if (sLocateColExpandValue.equals("RootProduct0")){
				sLocateColExpandValue = Serenity.sessionVariableCalled("RootProduct0").toString();
			}
			if (sLocateColValue.equals("Promotion")){
				sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
			} 

			if (sLocateColValue.contains("RootProduct0")){
				sLocateColValue = sLocateColValue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}

			if(!sLocateColExpand.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateColExpand, sLocateColExpandValue, ExpandIndex).equals("true"));             
				CommonEnh.ExpandRow(applet,table);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else {
				CommonEnh.selectedRow = 1;
			}
			
			String LocateColMessage = sLocateCol+" Not Found";
			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(LocateColMessage, CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info(sLocateColValue+" found");
			}
			else 
			{
				CommonEnh.selectedRow = 1;
				report.Info(sLocateColValue+" found");
			}

			if(!sCustomise.equals("")) {

				customiseButtonEnh.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				customiseButtonEnh.click();
				Common.WaitForClock(ClockObj);

			}

			if(!sAddOn.equals("")) {

				AddOnButtonEnh.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				AddOnButtonEnh.click();
				Common.WaitForClock(ClockObj);

			}
			
			if(sLocateColValue.contains("Vodafone Cloud Services Marketplace")) {
				String ADP = ADPNumber.getTextValue();
				String[] arrSplit = ADP.split("Marketplace ");
				//String ADPNumber = arrSplit[1]; 
				String ADPNumber = arrSplit[1]; 
		        int count = ADPNumber.length();  
		        
		        report.Info(count+" : Number of characters in ADP Number");
		        Assert.assertTrue("ADP Number Doesn't conatin 15 characters but contains "+count+" characters.",count==15);
			}

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}

	}


	@FindBy(xpath=".//button[contains(@title,'New payer')]")
	WebElementFacade NewPayerButton;

	@FindBy(xpath=".//button[contains(@title,'New user')]")
	WebElementFacade NewUserButton;

	@FindBy(xpath=".//button[contains(@title,'Create new contact')]")
	WebElementFacade CreateNewContactButton;

	@FindBy(xpath=".//*[@value='M']")
	WebElementFacade MaleRadioButton;

	@FindBy(xpath=".//*[contains(@aria-label,'Add this contact to the owner')]")
	WebElementFacade AddContactToOwnersAccountRadioButton;

	@FindBy(xpath=".//*[@class='vfoui-service-hierarchy-address-save-btn']/button[@title='Addresses:Save']")
	WebElementFacade PayerAddressSaveButton;

	@FindBy(xpath=".//*[@title='Confirm account information:Confirm']")
	WebElementFacade ConfirmButton;

	@FindBy(xpath=".//*[text()='Alternative payer and/or user account']/following::span[@class='siebui-button-secondary siebui-btn-icon-expanded']")
	WebElementFacade ExpandUserPayerApplet;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Payer_Label']")
	WebElementFacade PayerTextBox;

	@FindBy(xpath=".//*[@aria-labelledby='VF_User_Label']")
	WebElementFacade UserTextBox;

	@FindBy(xpath=".//*[@title='Personal details:Search existing contact']")
	WebElementFacade SearchExistingContactButton;


	@FindBy(xpath=".//*[@aria-labelledby='First_Name_Label']")
	WebElementFacade FirstNameTextBoxForSearch;

	@FindBy(xpath=".//button[text()='Search']")
	WebElementFacade SearchButton;

	@FindBy(xpath=".//*[@title='Search for existing contact:Select']")
	WebElementFacade SelectButton;

	@FindBy(xpath=".//span[text()='Permission level']")
	WebElementFacade PermissionLevelPopup;

	@FindBy(xpath=".//span[text()='Permission level']/parent::div/following-sibling::div[2]//span[text()='Ok']")
	WebElementFacade PermissionLevelPopupOKButton;

	@FindBy(xpath=".//*[contains(@class,'credit-vet-address-address')]/span")
	WebElementFacade AddressLabel;

	@FindBy(xpath=".//*[@aria-labelledby='VF_User_Label']/following-sibling::span")
	WebElementFacade UserSelectIcon;


	@FindBy(xpath=".//*[@title='Pick Account:OK']")
	WebElementFacade UserSelectOKButton;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Payer_Label']/following-sibling::span")
	WebElementFacade PayerSelectIcon;

	@FindBy(xpath=".//span[text()='Marketing permissions']")
	WebElementFacade MarketPermissionLevelPopup;

	@FindBy(xpath=".//span[text()='Marketing permissions']/parent::div/following-sibling::div[2]//button/span[text()='Ok']")
	WebElementFacade MarketPermissionLevelPopupOKButton;

	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade PopupFirst;

	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElementFacade PopupSecond;

	@FindBy(xpath=".//*[contains(@aria-label,'Do not use third party')]")
	WebElementFacade ThirdPartySocialCheckBox;
	@FindBy(xpath=".//span[contains(@class,'vfoui-marketing-pref vfoui-Donotusethirdpartysocial')]")
	WebElementFacade ThirdPartySocialToolTip;
	@FindBy(xpath=".//div[contains(text(),'When ticked this means the customer has not given permission for Vodafone to use third party social media and apps data for marketing purposes')]")
	WebElementFacade ThirdPartySocialToolTipContent;
	@FindBy(xpath=".//*[text()='Marketing permissions history']")
	WebElementFacade MarketingPermissionHistoryButton;

	@FindBy(xpath="//*[@name='VFAccountName']")
	WebElementFacade AccName;
	
	@Step
	public void CreateServiceHierarchyAccount(String Rownum) throws IOException, InterruptedException, AWTException{

		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "CreateServiceHierarchy";
		Actions action = new Actions(getDriver());
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Rownum, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("First_Name").size();i++) {
			String Payer = tableMap.get("Payer").get(i);
			String User = tableMap.get("User").get(i);
			String isNew = tableMap.get("New/Existing").get(i);

			String FirstName = tableMap.get("First_Name").get(i);
			String LastName = tableMap.get("Last_Name").get(i);
			String PostCode = tableMap.get("Post_Code").get(i); 	        	
			String Birth_Date = tableMap.get("Birth_Date").get(i);
			String Validation = tableMap.get("Validation").get(i);
			String Action = tableMap.get("Action").get(i);
			String PopupBlock = tableMap.get("PopupBlock").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			Alert alert;
			String ActAlertText="";


			String applet = ".//*[@class='ui-jqgrid-view']";
			String table = "//table[@summary='Pick Account']";
			
			if(AccName.isCurrentlyVisible()) {
				String sAccName = AccName.getTextValue();
				String[] arr1 = sAccName.split(" ");
				String fullName = arr1[1] + " " + arr1[2];
				 Serenity.setSessionVariable("AccountName").to(fullName);
			}

			if(!NewPayerButton.isCurrentlyVisible()){
				ExpandUserPayerApplet.click();
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);
				UserTextBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}


			if(Payer.equalsIgnoreCase("Yes")){
				NewPayerButton.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(User.equalsIgnoreCase("Yes")){
				NewUserButton.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(isNew.equalsIgnoreCase("New")){
				CreateNewContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				CreateNewContactButton.click();			
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);

				if (Action.equals("PlaceHolderCheck")){
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);

					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					String check =TitleWebList.getAttribute("placeholder");
					Assert.assertTrue("FAIL, TitleWebList Text Box doesn't contain Hint", !check.equals(""));
					check =firstnameEditBox.getAttribute("placeholder");
					Assert.assertTrue("FAIL, firstnameEditBox Text Box doesn't contain Hint", !check.equals(""));
					check =lastNameEditBox.getAttribute("placeholder");
					Assert.assertTrue("FAIL,lastNameEditBox Text Box doesn't contain Hint", !check.equals(""));
					check =DOBTextBox.getAttribute("placeholder");
					Assert.assertTrue("FAIL,phoneNumberEditBox Text Box doesn't contain Hint", !check.equals(""));

					PostCodeTextBox.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					check =PostCodeTextBox.getAttribute("placeholder");
					Assert.assertTrue("FAIL,PostCodeTextBox Text Box doesn't contain Hint", !check.equals(""));
					check =Adress.getAttribute("placeholder");
					Assert.assertTrue("FAIL,Adress Text Box doesn't contain Hint", !check.equals(""));
					return;
				}

				TitleWebList.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				TitleWebList.type("Mr.");
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);
				firstnameEditBox.type(FirstName);
				Common.WaitForClock(ClockObj);
				Thread.sleep(1000);
				lastNameEditBox.type(LastName);
				Common.WaitForClock(ClockObj);
				Thread.sleep(1000);
				if(MaleRadioButton.isCurrentlyVisible()) {
					MaleRadioButton.click();
				}
				
				Thread.sleep(1000);
				DOBTextBox.type(Birth_Date); 
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ContactNum.click();
				if(isAlertPresent(getDriver())){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText(); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					alert.accept();
					report.Info("alert messsage is"+ActAlertText);		                	
				}	

				ContactNum.type("4412354621");
				pin1.type("2");
				pin2.type("2");
				pin3.type("2");
				pin4.type("2");
				Thread.sleep(1000);
				AddContactToOwnersAccountRadioButton.click();
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);

				if(PermissionLevelPopup.isCurrentlyVisible()){
					PermissionLevelPopupOKButton.click();
					Common.WaitForClock(ClockObj);
					Thread.sleep(2000);
				}
				//Common.HandleErrorPopUp("OPTIONAL:contact will be added");
				String IfChecked =OnlineAccCheck.getAttribute("aria-checked");
				if (IfChecked.equalsIgnoreCase("true")){
					OnlineAccCheck.click(); 
				}

				if(Action.equalsIgnoreCase("CheckEditable")) {
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


					Assert.assertTrue("Fail, Tool tip text is not as expected",ThirdPartySocialToolTipContent.isPresent() );
					//String ToolTip = ThirdPartySocialToolTipContent.getTextValue();
					report.Info("Tool Tip value for Third Party Social Marketing Permission CheckBox is :When ticked this means the customer has not given permission for Vodafone to use third party social media and apps data for marketing purposes ");

					Thread.sleep(2000);
					//ThirdPartySocialCheckBox.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					action.moveToElement(SaveInfoButton).perform();
					SaveInfoButton.click();
					report.Info("Save Button is clicked");
					Common.WaitForClock(ClockObj);

					if(MarketPermissionLevelPopup.isCurrentlyVisible()){
						MarketPermissionLevelPopupOKButton.click();
						Thread.sleep(2000);
					}
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					break;
				}

				if(Action.equalsIgnoreCase("CheckNotEditable")) {
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


				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				SaveInfoButton.click();
				Common.WaitForClock(ClockObj);

				if(MarketPermissionLevelPopup.isCurrentlyVisible()){
					MarketPermissionLevelPopupOKButton.click();
					Thread.sleep(2000);
				}
				Common.WaitForClock(ClockObj);

				AdressSearchbyPostCodeRadioButton.click();
				Thread.sleep(1000);
				PostCodeTextBox.type(PostCode);
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);

				Adress.type("The Wapping Group Practice,22,,Wapping Lane,,LONDON,,E1W 2RL,United Kingdom");
				/*
				PostCodeSearchButton.click();
				Thread.sleep(1000);
				PostCodeSearchButton.click();
				Thread.sleep(1000);
				AdressDropDown.click();
				Thread.sleep(2000);
				SelectFirstAddress.click();
				Thread.sleep(1000);
				 */

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				PayerAddressSaveButton.click(); 
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				AddressLabel.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				String sCurrentAddress = AddressLabel.getTextValue();
				Assert.assertTrue("Fail, Postcode populated is not in UpperCase",sCurrentAddress.contains(PostCode.toUpperCase()));
				report.Info("Postcode populated is in UpperCase");




				if(Payer.equalsIgnoreCase("Yes")){

					if (Action.equals("CreditAuthorise")){

						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						PaymentDropdown.click();	
						Thread.sleep(2000);
						CreditDebitOption.click();
						Thread.sleep(2000);


						AddcardDetails.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						AddcardDetails.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

						WebDriver driver =getDriver();
						String title="";
						Thread.sleep(5000);
						String initialWindow = "";
						initialWindow = driver.getWindowHandle();
						java.util.Set<String> winHandles = driver.getWindowHandles();
						for (String handle : winHandles) {
							if (!handle.equals(initialWindow)) {
								driver.switchTo().window(handle);
								Thread.sleep(1000);
								enterAeirandiCardDetails("CreditCardVisa");
							}
						}
						driver.switchTo().window(initialWindow);
						Common.WaitForClock(ClockObj);
					}

					else {
						SaveButton.click();//billing save
						Common.WaitForClock(ClockObj); 
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());        				
					}
				}

				ConfirmButton.click();
				Common.WaitForClock(ClockObj);  

			}

			if(isNew.equalsIgnoreCase("Existing")){
				SearchExistingContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				SearchExistingContactButton.click();
				Thread.sleep(1000);

				FirstNameTextBoxForSearch.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				FirstNameTextBoxForSearch.type(FirstName);
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				SearchButton.click();

				SelectButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				SelectButton.click();

				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				String actTitle=TitleWebList.getTextValue();	
				if(actTitle.equals("")){
					TitleWebList.type("Mr.");
				}

				String actDOB=DOBTextBox.getTextValue();	
				if(actDOB.equals("")){
					DOBTextBox.type(Birth_Date);
				}

				String actContactNum=ContactNum.getTextValue();	
				if(actContactNum.equals("")){
					ContactNum.type("4455662315");
				}

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				SaveInfoButton.click();
				Common.WaitForClock(ClockObj);

				if(MarketPermissionLevelPopup.isCurrentlyVisible()){
					MarketPermissionLevelPopupOKButton.click();
					Thread.sleep(2000);
				}
				Common.WaitForClock(ClockObj);

				AdressSearchbyPostCodeRadioButton.click();

				if(AddressLabel.isCurrentlyVisible()){
					String sCurrentAddress = AddressLabel.getTextValue();
					System.out.println("Current address: "+sCurrentAddress);
					if(sCurrentAddress.equalsIgnoreCase("THE WAPPING GROUP PRACTICE,22,WAPPING LANE, LONDON, E1W 2RL, UNITED KINGDOM")){
						PostCodeTextBox.type("RG14 5NJ");
						Common.WaitForClock(ClockObj);
						Adress.type("Flat 3,36,,Craven Road,,NEWBURY,Berkshire,RG14 5NJ,United Kingdom");
					}
					else{
						PostCodeTextBox.type(PostCode);
						Common.WaitForClock(ClockObj);
						Adress.type("The Wapping Group Practice,22,,Wapping Lane,,LONDON,,E1W 2RL,United Kingdom");
					}
				}
				else{
					PostCodeTextBox.type(PostCode);
					Common.WaitForClock(ClockObj);
					Adress.type("The Wapping Group Practice,22,,Wapping Lane,,LONDON,,E1W 2RL,United Kingdom");
				}

				/*PostCodeSearchButton.click();
				Thread.sleep(1000);
				PostCodeSearchButton.click();
				Thread.sleep(1000);
				AdressDropDown.click();
				Thread.sleep(2000);
				SelectFirstAddress.click();
				Thread.sleep(1000);*/

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				PayerAddressSaveButton.click(); 
				Common.WaitForClock(ClockObj);
				Common.HandleErrorPopUp("OPTIONAL:identical values");
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if(Payer.equalsIgnoreCase("Yes")){
					SaveButton.click();//billing save
					Common.WaitForClock(ClockObj); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());        				
				}

				ConfirmButton.click();
				Common.WaitForClock(ClockObj);  

			}

			if(Action.equalsIgnoreCase("SelectOwnerasUser")){
				UserSelectIcon.click();
				Common.WaitForClock(ClockObj);  
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}


			if(Action.equalsIgnoreCase("NoBillingProfilePopUp")){
				PayerSelectIcon.click();
				Thread.sleep(2000);
				PopupFirst.waitUntilClickable();
				PopupFirst.clear();
				PopupFirst.typeAndEnter("Account status");
				Common.WaitForClock(ClockObj);  
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				PopupSecond.waitUntilClickable();
				PopupSecond.clear();
				PopupSecond.typeAndEnter("Prospect");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(ClockObj); 
				Thread.sleep(2000);
				ConfirmPayerUserButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				if(ErrorMsgPayerPopUp.isPresent()){
					report.Info("Popup occured that Payer not valid");
					report.Info("The payer you have selected is not valid as either does not have a compatible billing profile associated to it or does not have billing profile associated to it at all. Please select an alternative from the list or create a new one to continue.");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				else {
					Assert.assertTrue("FAIL, Error Message is not occuring",ErrorMsgPayerPopUp.isVisible());

				}
			}


			if(Action.equalsIgnoreCase("Select Owner as User and blocked popup")){
				UserSelectIcon.click();
				Common.WaitForClock(ClockObj);  
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				UserSelectOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				UserSelectOKButton.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ConfirmPayerUserButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				ConfirmPayerUserButton.click();
				Common.WaitForClock(ClockObj);

				if(isAlertPresent(getDriver())){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText(); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if (ActAlertText.contains(sPopup)){                    	
						alert.accept();
						System.out.println("Message is: "+ActAlertText);
						report.Info("alert messsage is"+ActAlertText);
						System.out.println("Message is: "+ActAlertText);
					}                                 
				}  
			}

			if(Action.equalsIgnoreCase("Select Payer")){
				PayerSelectIcon.click();
				Common.WaitForClock(ClockObj);  
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(Action.equalsIgnoreCase("Select User")){
				UserSelectIcon.click();
				Common.WaitForClock(ClockObj);  
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			String Index = "0";
			String LocateColMessage = sLocateCol+" Not Found";
			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(LocateColMessage, CommonEnh.locateColumn1(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info(sLocateColValue+" found");

			}
			else 
			{
				CommonEnh.selectedRow = 1;
				report.Info(sLocateColValue+" found");
			}

			if(Action.equalsIgnoreCase("Select Owner as User")||Action.equalsIgnoreCase("Select Payer")||Action.equalsIgnoreCase("Select User")){
				UserSelectOKButton.click();
			}


			if(Validation.equalsIgnoreCase("Validate Payer")){
				if(!PayerTextBox.isCurrentlyVisible()){
					ExpandUserPayerApplet.click();
					UserTextBox.click();
				}

				PayerTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				String sFullPayerName="";
				if(!FirstName.equals("")){
					sFullPayerName = FirstName + " " + LastName;
					sFullPayerName=(sFullPayerName.trim()).toUpperCase();
				}
				else{
					sFullPayerName=Serenity.sessionVariableCalled("AccountName").toString();
					sFullPayerName=(sFullPayerName.trim()).toUpperCase();
				}

				String sActualPayerName = PayerTextBox.getTextValue();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL, Payer Account is not created successfully",sActualPayerName.contains(sFullPayerName));
				report.Info("Payer Account is created successfully");    				
			}


			if(Validation.equalsIgnoreCase("Validate User")){
				if(!UserTextBox.isCurrentlyVisible()){
					ExpandUserPayerApplet.click();
					UserTextBox.click();
				}

				UserTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

				String sFullUserName="";
				if(!FirstName.equals("")){
					sFullUserName = FirstName + " " + LastName;
					sFullUserName=(sFullUserName.trim()).toUpperCase();
				}
				else{
					sFullUserName=Serenity.sessionVariableCalled("AccountName").toString();
					sFullUserName=(sFullUserName.trim()).toUpperCase();
				}



				String sActualUserName = UserTextBox.getTextValue();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL, User Account is not created successfully",sActualUserName.contains(sFullUserName));
				report.Info("User Account is created successfully");    				
			}

		}

	}
	@FindBy(xpath="//input[@aria-label='Title']/following-sibling::span")
	WebElementFacade TitleDropdown;

	@FindBy(xpath="(.//*[@data-lovtype='MR_MS'])[1]")
	WebElementFacade FirstTitleElement;

	@FindBy(xpath="//input[@aria-labelledby='VF_Months_at_address_Label']/following-sibling::span")
	WebElementFacade Address_MonthDropdown;

	@FindBy(xpath="(//li[text()='1'])[2]")
	WebElementFacade FirstAddress_MonthElement;

	@FindBy(xpath="//input[@aria-labelledby='VF_Years_at_address_Label']/following-sibling::span")
	WebElementFacade Address_YearDropdown;

	@FindBy(xpath="(.//*[@data-lovtype='VF_OUI_TIME_AT_ADDRESS'])[1]")
	WebElementFacade FirstAddress_YearElement;

	@Step
	public void CheckLOVforDropdowns() throws IOException, InterruptedException, AWTException{

		TitleDropdown.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		TitleDropdown.click();
		Thread.sleep(2000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Assert.assertTrue("FAIL, Title LOVs are not displayed",FirstTitleElement.isVisible());
		report.Info("Title LOVs are displayed");

		PostCodeTextBox.type("E1W 2RL");
		PostCodeSearchButton.click();
		Thread.sleep(3000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		AdressDropDown.click();
		Thread.sleep(3000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Assert.assertTrue("FAIL, Address LOVs are not displayed",SelectFirstAddress.isVisible());
		report.Info("Address LOVs are displayed");
		SelectFirstAddress.click();


		Address_YearDropdown.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Address_YearDropdown.click();
		Thread.sleep(3000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		Assert.assertTrue("FAIL, Address Year LOVs are not displayed",FirstAddress_YearElement.isVisible());
		report.Info("Address Year LOVs are displayed");

		Address_MonthDropdown.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Address_MonthDropdown.click();
		Thread.sleep(3000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		Assert.assertTrue("FAIL, Address Month LOVs are not displayed",FirstAddress_MonthElement.isVisible());
		report.Info("Address Month LOVs are displayed");

	}
	@FindBy(xpath="(.//*[text()='Products & Services'])[2]")
	WebElementFacade ProductandServicesTab;

	@FindBy(xpath=".//*[@title='Basket:Next' and contains(@class,'siebui-ctrl-btn siebui-icon-proceedwithproceed')]")
	WebElementFacade ProductandServicesNextButton; 

	@FindBy(xpath=".//button[text()='About the customer'][contains(@class,'color-grey')]")
	WebElementFacade AboutTheCustomerTabGreyedOut;

	@Step
	public void NavigateToProductandServicesTab() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		ProductandServicesTab.click();
		Common.WaitForClock(ClockObj);
		ProductandServicesNextButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Assert.assertTrue("FAIL:About the Customer Tab is not greyed out after navigating backward",AboutTheCustomerTabGreyedOut.isVisible()); 

	}

	@FindBy(xpath=".//*[@aria-label='Confirm payer and/or user changes:Next']")
	WebElementFacade ConfirmPayerUserButton;

	@FindBy(xpath=".//*[text()='Payer not valid']")
	WebElementFacade ErrorMsgPayerPopUp;
	
	@Step
	public void ClickConfirmPayerUserButton() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		ConfirmPayerUserButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		ConfirmPayerUserButton.click();
		Common.WaitForClock(ClockObj);
	}

	@FindBy(xpath=".//*[contains(@aria-label,'Discard changes')]")
	WebElementFacade DiscardChangesButton;

	@FindBy(xpath=".//span[text()='Discard order']")
	WebElementFacade DiscardOrderPopup;
	@FindBy(xpath=".//*[contains(@aria-label,'Tell us a reason')]")
	WebElementFacade DiscardReason;
	@FindBy(xpath=".//*[@aria-label='Abandon order:Ok']")
	WebElementFacade DiscardOKButton;

	@FindBy(xpath=".//*[@aria-label='Email order customer summary']")
	WebElementFacade SendCustomerSummaryCheckbox;
	@Step
	public void DiscardChanges() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		DiscardChangesButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

		DiscardChangesButton.click();
		Common.WaitForClock(ClockObj);
		DiscardOrderPopup.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		DiscardReason.type("Call abandoned");

		if(SendCustomerSummaryCheckbox.isCurrentlyVisible()){
			SendCustomerSummaryCheckbox.click();
			Common.WaitForClock(ClockObj);
		}

		DiscardOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		DiscardOKButton.click();

		report.Info("Order is discarded ");
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	}	

	@FindBy(xpath = "//input[contains(@aria-labelledby,'VF_ID_Type_Label') or @name='s_6_1_4_0']")
	WebElementFacade IDCheckValue;

	@FindBy(xpath = "//button[@name='s_6_1_5_0']")
	WebElementFacade LaunchIDCheckButton;

	@FindBy(xpath = "//input[@placeholder='Card Number (PAN)']")
	WebElementFacade cardNumberInputField;

	@FindBy(xpath = "//input[@placeholder='MMYY']")
	WebElementFacade ExpiryDateInputField;

	@FindBy(xpath = "//input[@placeholder='CVV']")
	WebElementFacade CVVInputField;

	@FindBy(xpath = "//input[@placeholder='House Number']")
	WebElementFacade HouseNoInputField;

	@FindBy(xpath = "//input[@placeholder='House Number']//following::input")
	WebElementFacade PostCodeInputField;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElementFacade Submitbutton;

	@FindBy(xpath = ".//*[contains(text(),'Card successfully captured')]")
	WebElementFacade CardSavedMsg;

	@FindBy(xpath = "//button[text()='Reset']")
	WebElementFacade ResetButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElementFacade CancelButton;



	@Step
	public void identificationCheck(String Rownum) throws InterruptedException, IOException, AWTException {
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "IdentificationCheck";

		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(Rownum, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0; i < tableMap.get("RowNo").size(); i++) {
			String sCardType = tableMap.get("IdentificationType").get(i);
			String initialWindow = "";
			initialWindow = getDriver().getWindowHandle();
			IDCheckValue.typeAndEnter(sCardType);
			Thread.sleep(1000);
			LaunchIDCheckButton.click();

			java.util.Set<String> winHandles = getDriver().getWindowHandles();
			for (String handle : winHandles) {
				if (!handle.equals(initialWindow)) {
					getDriver().switchTo().window(handle);
				}
			}
			Thread.sleep(1000);
			enterAeirandiCardDetails("CreditCardVisa");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			getDriver().switchTo().window(initialWindow);
		}
	}

	public void enterAeirandiCardDetails(String CardType) throws IOException, AWTException, InterruptedException {

		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		String dataSheet = "EnterCardDetails";

		getDriver().manage().window().maximize();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Common.WaitForClock(ClockObj);
		String CardPaymentURL = getDriver().getCurrentUrl();
		;
		
		//getDriver().findElement(By.xpath("//td[contains(@id,'Payment_Method')]//span"))
		//Assert.assertTrue("FAIL, Aeriandi Page is not displayed.", getDriver().findElement(By.xpath("//input[@placeholder='Card Number (PAN)']")).isDisplayed());
		//Assert.assertTrue("FAIL, Aeriandi Page is not displayed.", cardNumberInputField.isPresent());

		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(CardType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0; i < tableMap.get("RowNo").size(); i++) {

			String sCardNo = tableMap.get("CardNumber").get(i);
			String sExpiryDate = tableMap.get("ExpiryDate").get(i);
			String sCVV = tableMap.get("CVV").get(i);
			String sHouseNo = tableMap.get("HouseNo").get(i);
			String sPostCode = tableMap.get("PostCode").get(i);
			String sNegativeJourney = tableMap.get("NegativeJourney").get(i);
			
			if(sNegativeJourney.equals("NonPCI")){
				
				Assert.assertTrue("FAIL, URL contains Aeirndai", !CardPaymentURL.contains("aeriandi.com"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				return;
			}
			
			if(sNegativeJourney.equals("Yes")){
				getDriver().findElement(By.xpath("//input[@placeholder='Card Number (PAN)']")).sendKeys(sCardNo);
				String sCardNumber = cardNumberInputField.getTextValue();
				Serenity.setSessionVariable("CardNum").to(sCardNumber);
				Thread.sleep(3000);
				ExpiryDateInputField.type(sExpiryDate);
				CVVInputField.type(sCVV);
				HouseNoInputField.type(sHouseNo);
				PostCodeInputField.type(sPostCode);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());				
				Submitbutton.click();
				Thread.sleep(5000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Pass, Card Details not saved successfully");							
				getDriver().close();
				Thread.sleep(2000);
				return;
			}
			if(sNegativeJourney.equals("Authorise")){
				CVVInputField.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				CVVInputField.type(sCVV);				
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());				
				Submitbutton.click();
				Thread.sleep(5000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Pass, CVV entered successfully");		
				getDriver().close();
				Thread.sleep(2000);
				return;
			}
			getDriver().findElement(By.xpath("//input[@placeholder='Card Number (PAN)']")).sendKeys(sCardNo);
			String sCardNumber = cardNumberInputField.getTextValue();
			
			Serenity.setSessionVariable("CardNum").to(sCardNumber);
			ExpiryDateInputField.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			ExpiryDateInputField.type(sExpiryDate);
			CVVInputField.type(sCVV);
			HouseNoInputField.type(sHouseNo);
			PostCodeInputField.type(sPostCode);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Submitbutton.click();
			Thread.sleep(5000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Assert.assertTrue("Fail, Card Details not saved successfully", CardSavedMsg.isCurrentlyVisible());
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			report.Info("Pass, Card Details Saved Successfully");
			getDriver().close();
			Thread.sleep(2000);	
		}
	}
}
