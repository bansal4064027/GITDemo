package pages;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.SikuliUtility;
import utilities.common;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ContactsPage extends PageObject {
	
	@Steps
    private ReadWorkbook readWorkbook;
	@Steps
	private ReportMessege report; 
	@Steps
	private SikuliUtility sikuliUtility;
	
	@Steps
    private common common1;	
	@Steps
	private common Common;
	
	public static boolean isAlertPresent(WebDriver driver) {
        try{
              driver.switchTo().alert();
              return true;
        }catch(NoAlertPresentException ex){
              return false;
        }
  }
	@FindBy(xpath="(.//a[text()='Contacts'])[2]")
    WebElementFacade ContactsTab;
	@FindBy(xpath=".//*[@id='1_s_1_l_VF_Online_Id']")
    WebElementFacade OnlineID;	
	@FindBy(xpath=".//*[@id='1_VF_Online_Id']")
    WebElementFacade OnlineIDCheckedBoxnew;	
	/*@FindBy(xpath=".//*[@id='1_s_1_l_VF_Online_Id']/span[1]")
    WebElementFacade OnlineIDCheckedBox;	*/
	 @FindBy(xpath=".//*[@aria-label='Third Level View Bar']")
     WebElementFacade AccountTabsDRopDown;
	 @FindBy(xpath=".//*[@title='Contact:New']")
     WebElementFacade ContactsNew;
	 
	 @FindBy(xpath=".//*[@title='Account Permissions:New']")
     WebElementFacade AccountPermissionNewButton;
	 @FindBy(xpath=".//*[@title='Account Permissions:Delete']")
     WebElementFacade AccountPermissionDeleteButton;
	 @FindBy(xpath="(.//*[@aria-label='Multiple Selection Field'])[4]")
     WebElementFacade AccountIcon;
	 @FindBy(xpath=".//*[@title='Accounts:New']")
     WebElementFacade AcountsNewButton;
	 @FindBy(xpath=".//*[@title='Accounts:Delete']")
     WebElementFacade AcountsDeleteButton;
	 @FindBy(xpath=".//*[@title='Accounts:OK']")
     WebElementFacade AcountsOkButton;
	 @FindBy(xpath=".//*[@id='s_sctrl_tabScreen']/ul/li[3]/a")
     WebElementFacade MainContactsTab;
	 @FindBy(xpath="(.//*[@aria-label='Multiple Selection Field'])[2]")
     WebElementFacade AccountTabIcon;
	 @FindBy(xpath=".//*[@class='siebui-icon-dropdown']")
     WebElementFacade Dropdown;
     @FindBy(xpath="(.//*[@data-lovtype='VF Account Contact Affiliation:Account Permissions'])[1]")
     WebElementFacade SelectLevel;
     @FindBy(xpath=".//*[@title='Contacts:Update Email']")
     WebElementFacade UpdateEmailbutton;
       @FindBy(xpath=".//*[@aria-labelledby='VFEmailAddress_Label']")
       WebElementFacade EnterEmail1;
       @FindBy(xpath=".//*[@aria-labelledby='VFDomainAddress_Label']")
       WebElementFacade EnterEmail2;
       @FindBy(xpath=".//*[@aria-labelledby='VFReTypeEmailAddress_Label']")
       WebElementFacade EnterEmail3;
       @FindBy(xpath=".//*[@aria-labelledby='VFReTypeDomainAddress_Label']")
       WebElementFacade EnterEmail4;
       @FindBy(xpath=".//*[@title='Siebel:OK']")
       WebElementFacade Okbutton ;
       @FindBy(xpath="(.//*[text()='Update billing profile e-mail'])")
       WebElementFacade UpdateBillProfileEmail ;
       @FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
       WebElement Clockobj;
       @FindBy(xpath=".//*[@aria-label='Permission affirmation']")
       WebElement PermissionAffirmation;
       @FindBy(xpath=".//*[text()='Do not use my identity']")
       WebElementFacade Donotusemyidentity;
       @FindBy(xpath=".//*[@aria-label='Email']")
       WebElementFacade ChangedEmailAddress;
       
	 @Screenshots(forEachAction=true)
@Step
public void Contacts_LastName(String Validation) throws InterruptedException, IOException, AWTException{
	//Homepage.waitUntilPresent();
	
		  String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		   String filePath = "\\src\\test\\resources\\data\\Account.xls";
	      String dataSheet = "ContactsLastName";
	      String applet = "//*[@title='Contacts List Applet']";
	      String table = "//table[@summary='Admin Account Automatic Debit Details']";  
	      
	      Common.WaitForClock(Clockobj);
	      ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
			if (ContactsTab.isDisplayed()){
				ContactsTab.click();
			}
			else {
				AccountTabsDRopDown.selectByVisibleText("Contacts");
			}
			Common.WaitForClock(Clockobj);
			
	      Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Validation, filePath, dataSheet);
	      readWorkbook.testData(tableMap);
	      
	      for (int i = 0;i < tableMap.get("LocateCol").size();i++) { 	  
	   	
	   	  // String sIndex = tableMap.get("Index").get(i);		    	   
	   	   String sUIName = tableMap.get("UIName").get(i);
	   	   String sValue = tableMap.get("Value").get(i);
	   	String sNewButton = tableMap.get("NewButtoncheck").get(i);
	   	   String Online_Account_Validation = tableMap.get("OnlineAccountValidation").get(i);
	   	String sValidation = tableMap.get("Validation").get(i);
		String sEmailUpdate = tableMap.get("EmailUpdate").get(i);
		String UpdateEmailToBillingProfileButton = tableMap.get("UpdateEmailToBillingProfileButton").get(i);
		String CheckForIdentity = tableMap.get("CheckForIdentity").get(i);
	if (sEmailUpdate.equals("Y")) {
	   		
	   		UpdateEmailbutton.click();
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		Thread.sleep(3000);
	   		Common.WaitForClock(Clockobj);
	   		EnterEmail1.type("testing");
	   		EnterEmail2.type("test.london");
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		EnterEmail3.type("testing");
	   		EnterEmail4.type("test.london");
	   		Okbutton.click();
	   		Common.WaitForClock(Clockobj);
	   		
	   		if(UpdateEmailToBillingProfileButton.equals("Y"))
	   		{
	   		Common.WaitForClock(Clockobj);
	   		Thread.sleep(2000);
	   		UpdateBillProfileEmail.click();
	   		Thread.sleep(2000);
	   		Alert alert;
	   		if(isAlertPresent(getDriver())){
				  alert=getDriver().switchTo().alert();                    	
				  alert.accept();

			  }
	   		}
	   		Common.WaitForClock(Clockobj);
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		Thread.sleep(3000);
	   		Common.WaitForClock(Clockobj);
	   	}
	
	if(sValidation.equals("EmailChangedValidation"))
	{
		ChangedEmailAddress.isCurrentlyEnabled();
		ChangedEmailAddress.equals("testing@test.london");
		report.Info("Email Address is Updated Successfully");
   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		 common1.selectedRow = 1;
	   	   if (!sUIName.equals("")){
	   		common1.updateSiebList(applet,table, sUIName, sValue);   
	   	   }
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	}
	   	
	
	if (Online_Account_Validation.equals("Y")){
		OnlineID.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				
				OnlineID.click();
				Thread.sleep(3000);
	        	String OF = OnlineIDCheckedBoxnew.getAttribute("readonly");
	        	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if (OF.equals("readonly")){
					report.Info("Pass : Online Flag DISABLED as expected");	       			
					}
				else {report.Info("Fail : Online Flag Enabled");}	        	
    			Thread.sleep(5000);
	
	       }
            common1.selectedRow = 1;
	   	   if (!sUIName.equals("")){
	   		common1.updateSiebList(applet,table, sUIName, sValue);   
	   	   }
		   
		    if (CheckForIdentity.equals("Y")) {
	   		 Thread.sleep(5000);
	   		 Assert.assertTrue("Do Not Use My Identity is not present Under Identity", Donotusemyidentity.isCurrentlyVisible());
	   		 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		    	
			  }
	   	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   	   
	   	if (sNewButton.equals("Y")){
	    	 String ButtonCheck = AccountPermissionNewButton.getAttribute("disabled");//disabled
	    	 if(ButtonCheck.equalsIgnoreCase("disabled")){
	    		 report.Info("Pass : New Button is Disable as expected"); 
	    	 }
	    	 
	    	 else {report.Info("Fail : New Button is Enabled");}  
	    	 
	    	 if(sValue.equalsIgnoreCase("Account")){
	 	   		AccountIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	 	   		AccountIcon.click();
	 	   		if(sValidation.equalsIgnoreCase("LastNameValidation")){
	 		   		Thread.sleep(2000);
	 		   		Assert.assertFalse("Fail: Account permission New Button is enabled",AcountsNewButton.isEnabled());
	 		   		report.Info("Pass : Account permission New Button is GreyedOut");
	 		   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 		   		Assert.assertFalse("Fail: Account permission New Button is enabled",AcountsDeleteButton.isEnabled());
	 		   		report.Info("Pass : Account permission Delete Button is GreyedOut");
	 		   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 		   	} 
	 	   		AcountsOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	 	   		AcountsOkButton.click();
	 	   	   }
	 	   	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 	   	if(sValidation.equalsIgnoreCase("AccountValidation")){
	 	   		Thread.sleep(2000);
	 	   		Assert.assertFalse("Fail: Account permission New Button is enabled",AccountPermissionNewButton.isEnabled());
	 	   		report.Info("Pass : Account permission New Button is GreyedOut");
	 	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 	   		Assert.assertFalse("Fail: Account permission New Button is enabled",AccountPermissionDeleteButton.isEnabled());
	 	   		report.Info("Pass : Account permission Delete Button is GreyedOut");
	 	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 	   	} 
	      }
	if(sValidation.equalsIgnoreCase("AccountPermission")){
	   		
	   		Thread.sleep(2000);
	   		Assert.assertFalse("Fail: Account permission New Button is enabled",AccountPermissionNewButton.isEnabled());
	   		report.Info("Pass : Account permission New Button is GreyedOut");
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		
	   	}
	 	if(sValidation.equalsIgnoreCase("SelectLevel")){
	 		
	 		AccountPermissionNewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	 		AccountPermissionNewButton.click();
	 		//Dropdown.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	 		Thread.sleep(5000);
	 		Dropdown.click();
	 		Thread.sleep(3000);
	 		SelectLevel.click();
	 		Thread.sleep(2000);
	 		Assert.assertFalse("Fail: Account permission New Button is enabled",AccountPermissionNewButton.isEnabled());
	   		report.Info("Pass : Account permission New Button is GreyedOut");
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 		
	 		}
	   	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
	      
	}
	 
	 
	 @FindBy(xpath = ".//*[text()='Marketing Permissions']")
	WebElementFacade MarketingPermissionTab;
	 @FindBy(xpath = ".//*[@aria-labelledby='Date_of_Birth_Label' and @name='s_3_1_43_0']")
		WebElementFacade DateOfBirth;
	 @Step
	 public void Marketing_Permission(String Row) throws InterruptedException, IOException, AWTException{
		 //Homepage.waitUntilPresent();

		 String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		 String filePath = "\\src\\test\\resources\\data\\Account.xls";
		 String dataSheet = "ContactsLastName";
		 String applet = "//*[@title='Contacts List Applet']";
		 String table = "//table[@summary='Admin Account Automatic Debit Details']";  

		 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Row, filePath, dataSheet);
		 readWorkbook.testData(tableMap);

		 if (tableMap.get("LocateCol").size()==0){
			 report.Info(Row+" logical name not found in sheet.");
			 Assert.assertTrue(false);        	
		 }

		 for (int i = 0;i < tableMap.get("LocateCol").size();i++) {

			 // String sIndex = tableMap.get("Index").get(i);		    	   
			 String sUIName = tableMap.get("UIName").get(i);
			 String sValue = tableMap.get("Value").get(i);
			 String sValidation = tableMap.get("Validation").get(i);
			 String sEmailUpdate = tableMap.get("EmailUpdate").get(i);
			 String UpdateEmailToBillingProfileButton = tableMap.get("UpdateEmailToBillingProfileButton").get(i);
			 String sMarketingPermissionLable = tableMap.get("MarketingPermissionLable").get(i);
			 String sPermissionLevel = tableMap.get("PermissionLevel").get(i);
			 String MarketingPermissionCheckBoxPath = ".//*[@aria-label='"+sMarketingPermissionLable+"']";
			 String sMarketingPermissionText = tableMap.get("MarketingPermissionText").get(i);
			 String MarketingPermissionTextPath = ".//*[text()='"+sMarketingPermissionLable+"']/following-sibling::span ";
			 String MarketingPermissionText = ".//*[text()='"+sMarketingPermissionLable+"']";
			 String sMarketingPermissionTextMessage = tableMap.get("MarketingPermissionTextMessage").get(i);
			 String MarketingPermissionCheckBox=".//*[@aria-readonly='true' and @aria-label='"+sMarketingPermissionLable+"']";

			 if(sPermissionLevel.equalsIgnoreCase("AccountLevelPermission"))

			 {
				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
				 if (ContactsTab.isDisplayed()){
					 ContactsTab.click();
					 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 }
				 else {
					 AccountTabsDRopDown.selectByVisibleText("Contacts");
				 }
				 Common.selectedRow = 1;
				 if (!sUIName.equals("")){
					 Thread.sleep(5000);
					 Common.updateSiebList(applet,table, sUIName, sValue);   
				 }
				 if(sValidation.equalsIgnoreCase("Minor"))
				 {
					 DateOfBirth.clear();
					 DateOfBirth.typeAndEnter("25/06/2015");
					 if(isAlertPresent(getDriver())){
							Alert alert=getDriver().switchTo().alert();                        
							String ActAlertText=alert.getText();
							if (ActAlertText.contains("Attention please: age is under 18")){
								//sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
								alert.accept();
							}
							} 
				 }
				 
				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			 }
			 else {
				 if(sPermissionLevel.equalsIgnoreCase("ServiceLevelPermission"))
				 {
					 AccountDropDown.selectByVisibleText("Product / Services");
					 //MarketingPermissionTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 Common.WaitForObjectPresence(".//*[text()='Marketing Permissions']");
					 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 MarketingPermissionTab.click();
					 Common.WaitForObjectPresence(".//*[text()='Marketing Permissions']");
				 }

			 }

			 
			if(sValidation.equalsIgnoreCase("Not Present")) 
			 {   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString()); 	 
				 Assert.assertFalse("Fail: Marketing permission "+sMarketingPermissionLable+" is visible",findBy(MarketingPermissionCheckBoxPath).isCurrentlyVisible());  
				 report.Info("Pass : Marketing permission "+sMarketingPermissionLable+" is not visible");
			 }

			 /*if(sValidation.equalsIgnoreCase("Permission Text")) 
			 {
				 if(findBy(MarketingPermissionTextPath).isCurrentlyVisible())
				 {
					 findBy(MarketingPermissionTextPath).click();
					 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 String ActualMessage=findBy(".//*[contains(text(),'When ticked')]").getText();
					 if(ActualMessage.contains(sMarketingPermissionText)) { 	 				
						 report.Info("Actual Messege is" +ActualMessage);
						 Assert.assertTrue(true);
					 }
					 else {
						 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("Actual Messege is" +ActualMessage);
						 Assert.assertTrue(false);	 				
					 }



				 }
			 }*/
			 if(sValidation.equalsIgnoreCase("UpdatedPermissionText")) 
			 {
				 if(findBy(MarketingPermissionText).isCurrentlyVisible())
				 {
					 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					 if(MarketingPermissionText.contains(sMarketingPermissionLable)) { 	
						 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("Actual Messege is" +MarketingPermissionText);
						 Assert.assertTrue(true);
					 }
					 else {
						 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("Actual Messege is" +MarketingPermissionText);
						 Assert.assertTrue(false);	 				
					 }
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


				 }

			 }
			 
			 if(sValidation.equalsIgnoreCase("Permission Text")) 
			 {
				 if(findBy(MarketingPermissionTextPath).isCurrentlyVisible())
				 {
					 Thread.sleep(3000);
					 findBy(MarketingPermissionTextPath).click();
					 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 String ActualMessage=null;

					 if(sMarketingPermissionTextMessage.contains("Please confirm you have discussed all marketing permissions")) {
						 ActualMessage=findBy(".//*[contains(text(),'Please confirm you have discussed')]").getText(); 
						 PermissionAffirmation.click();
						 //AccountLabelInContacts.click();
					 }
					 else {

						 Actions actions = new Actions(getDriver());
						 actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
						 Thread.sleep(1000);
						 findBy(MarketingPermissionTextPath).click();
						 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 Thread.sleep(2000);
						 findBy(".//div[contains(text(),'When ticked')]").waitUntilPresent();
						 ActualMessage=findBy(".//div[contains(text(),'When ticked')]").getTextValue();
						 PermissionAffirmation.click();
						 //AccountLabelInContacts.click();
					 }

					 Assert.assertFalse("Fail: Marketing permission Text Info is not as expected. Actual is: "+ActualMessage,!ActualMessage.contains(sMarketingPermissionTextMessage));  
					 report.Info("Pass : Marketing permission Text Info is as expected: "+ActualMessage);

				 }
				 
			 }
			 if(sValidation.equalsIgnoreCase("Minor"))
			 {
					String MarketingPermissionBoxReadOnly = findBy(MarketingPermissionCheckBox).getAttribute("readonly");
					if(MarketingPermissionBoxReadOnly!=null){
						Assert.assertTrue("Fail:Marketing Permissions" +sMarketingPermissionLable+ "is editable.", MarketingPermissionBoxReadOnly.equalsIgnoreCase("true"));
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	
						report.Info("Pass - Marketing Permissions:" +sMarketingPermissionLable+ "is not editable..");

					}
			 }
			 
		 }
	 }
	 	      
	
	 @Step
		public void account_CustomerTab() throws InterruptedException, IOException, AWTException{
			
			MainContactsTab.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
	   		MainContactsTab.click();
	   		Thread.sleep(3000);
	   			AccountTabIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	   			AccountTabIcon.click();
	   			Thread.sleep(2000);
		   		Assert.assertFalse("Fail: Account permission New Button is enabled",AcountsNewButton.isEnabled());
		   		report.Info("Pass : Account permission New Button is GreyedOut");
		   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   		Assert.assertFalse("Fail: Account permission New Button is enabled",AcountsDeleteButton.isEnabled());
		   		report.Info("Pass : Account permission Delete Button is GreyedOut");
		   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   		AcountsOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		   		AcountsOkButton.click();
	   		}
	 
	 
	 @FindBy(xpath = ".//*[@aria-label='Third Level View Bar']")
     WebElementFacade AccountDropDown;
	 @FindBy(xpath=".//*[@title='Contacts:Add']")
     WebElementFacade CotactAddButton;
      @FindBy(xpath=".//*[@title='Add Contacts:New']")
     WebElementFacade AddContactNewButton;
      @FindBy(xpath="//*[contains(@title,'Contact') and contains(@title,'Save')]")
      WebElementFacade SaveButton;
      @FindBy(xpath="//table[@summary='Add Contacts']//tr[2]//td[2]")
      WebElementFacade CotactLastName;
      @FindBy(xpath=".//input[contains(@id,'Last_Name')]")
      WebElementFacade CotactLastNameTextBOx;
      @FindBy(xpath=".//*[@title='Contacts:Save']")
      WebElementFacade CotactsSaveButton;
      @FindBy(xpath="(.//td[contains(@aria-labelledby,'Job_Title')])[1]")
      WebElementFacade JObTitle;
      
      @FindBy(xpath=".//button[@title='Contacts:Delete'] | .//button[@title='Accounts:Delete']")
      WebElementFacade PopUpDeleteButton;
      
      @FindBy(xpath=".//*[@title='Accounts:OK']")
      WebElementFacade PopUpOKButton;
      
      @FindBy(xpath=".//*[@title='Contacts:Update Email']")
      WebElementFacade UpdateEmailButton;
      @FindBy(xpath=".//*[@aria-labelledby='VFEmailAddress_Label']")
      WebElementFacade EmailTextBox;
      @FindBy(xpath=".//*[@aria-labelledby='VFReTypeEmailAddress_Label']")
      WebElementFacade ReTypeEmailTextBox;
      @FindBy(xpath=".//*[@aria-labelledby='VFDomainAddress_Label']")
      WebElementFacade DomainTextBox;
      @FindBy(xpath=".//*[@aria-labelledby='VFReTypeDomainAddress_Label']")
      WebElementFacade ReTypeDomainTextBox;
      @FindBy(xpath=".//*[@title='Siebel:OK']")
      WebElementFacade EmailOKButton;
      @FindBy(xpath=".//a[text()='Voice Enrolment Status']")
      WebElementFacade VoiceEnrolmentStatusTab;
      
      @FindBy(xpath=".//*[@title='Contact:Save']")
      WebElementFacade MoreInfoSaveButton;
     

      @FindBy(xpath=".//*[@data-display='Lock Status']")
      WebElementFacade LockStatusButton;
      @FindBy(xpath=".//*[@data-display='Unlock Status']")
      WebElementFacade UnlockStatusButton;
      @FindBy(xpath=".//*[@data-display='Delete Status']")
      WebElementFacade DeleteStatusButton;
      @FindBy(xpath=".//*[@aria-label='Voice ID Status']")
      WebElementFacade VoiceIDStatusTextBox;
      
      @FindBy(xpath=".//a[text()='Voice Enrolment Status']")
      WebElementFacade VoiceEnrolmentStatuTab;
      @FindBy(xpath=".//*[@aria-labelledby='VFVoiceIDEnrolment_Label']")
      WebElementFacade VoiceIDEnrolmentTextBox;
      @FindBy(xpath=".//*[@title='Biometrics Status View:Delete Status']")
      WebElementFacade DeleteStatus;
      
      @FindBy(xpath=".//*[@title='Biometrics Status View:Lock Status']")
      WebElementFacade LockStatus;
      
      @FindBy(xpath=".//*[@aria-labelledby='VFLockReason_Label']")
      WebElementFacade LockStatusEnter;
     
      @FindBy(xpath=".//*[@title='Lock reason:Go']")
      WebElementFacade StatusGo;
      @FindBy(xpath=".//*[@title='Biometrics Status View:Unlock Status']")
      WebElementFacade UnLockStatus;
   
      @FindBy(xpath="//button[@title='Add Contacts:OK']")
      WebElementFacade ContactsOKButton;
      
      @Step
      public void AddContactTab(String row) throws IOException, InterruptedException, AWTException{


    	  String filePath = "\\src\\test\\resources\\data\\Account.xls";
    	  String dataSheet = "AddContact";

    	  String applet = "//*[@title='Contacts List Applet']";
    	  String table = "//table[@summary='Admin Account Automatic Debit Details']";


    	  Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
    	  readWorkbook.testData(tableMap);

    	  if (tableMap.get("RowNo").size()==0){
    		  report.Info(row+" logical name not found in sheet.");
    		  Assert.assertTrue(false);        	
    	  }

    	  Common.WaitForClock(Clockobj);
    	  if(ContactsTab.isDisplayed()){
    		  ContactsTab.click();
    	  }
    	  else{
    		  AccountDropDown.selectByVisibleText("Contacts");
    	  } 
    	  Common.WaitForClock(Clockobj);
    	  report.Info("Contacts Tab Clicked");
    	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

    	  for (int i = 0;i < tableMap.get("RowNo").size();i++) {   

    		  String sLocateCol = tableMap.get("LocateCol").get(i);
    		  String sLocateColValue = tableMap.get("LocateColValue").get(i);             
    		  String sIndex = tableMap.get("Index").get(i);
    		  String sUIName = tableMap.get("UIName").get(i);
    		  String sValue = tableMap.get("Value").get(i);
    		  String sPopup = tableMap.get("Popup").get(i);
    		  String sButton = tableMap.get("Button").get(i);
    		  String sPopup1 = tableMap.get("Popup1").get(i);
    		  String sValidation = tableMap.get("Validation").get(i);
    		  String sAction = tableMap.get("Action").get(i);
    		  String sCancelPopuP = tableMap.get("CancelPopuP").get(i);
    		  String sVoiceID = tableMap.get("VoiceID").get(i);
              String sStatus = tableMap.get("Status").get(i);
              String sVoiceEnrolmentTab = tableMap.get("VoiceEnrolmentTab").get(i);
              String sNewStatus = tableMap.get("NewStatus").get(i);
              String sDeleteStatus = tableMap.get("DeleteStatus").get(i);
              String sLockStatus = tableMap.get("LockStatus").get(i);
              String sType = tableMap.get("Type").get(i);
              String sUnlockStatus = tableMap.get("UnlockStatus").get(i);
    		  Alert alert;
    		  String ActAlertText="";
    		  
    		  if (sIndex.equals("")){
    			  sIndex = "0";
    		  }
    		  if (sPopup.equals("")){
    			  sPopup = "No";
    		  }
    		  if (sPopup1.equals("")){
    			  sPopup1 = "No";
    		  }
    		  if (sCancelPopuP.equals("")){
    			  sCancelPopuP = "No";
    		  }
    		  if(sButton.equalsIgnoreCase("Add")){
    			  CotactAddButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", getDriver().findElement(By.xpath(applet+table+"//tr[@id='1']")));
    			  CotactAddButton.click();
    			  Common.WaitForClock(Clockobj);
    			  CotactLastName.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  CotactLastName.click();
    			  CotactLastNameTextBOx.typeAndEnter("DNU");

    			  AddContactNewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  AddContactNewButton.click();
    			  Thread.sleep(2000);
    			  if(isAlertPresent(getDriver())){
    				  alert=getDriver().switchTo().alert();                    	
    				  alert.accept();

    			  }
    		  }
    		  if(sAction.equalsIgnoreCase("AddExistingContact")){
    			  CotactAddButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", getDriver().findElement(By.xpath(applet+table+"//tr[@id='1']")));
    			  CotactAddButton.click();
    			  CotactLastName.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  Common.WaitForClock(Clockobj);
    			  CotactLastName.click();
    			  CotactLastNameTextBOx.typeAndEnter(sValue);
    			  
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			  ContactsOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  ContactsOKButton.click();
    			  Thread.sleep(2000);
    			  Common.WaitForClock(Clockobj);
    			  if(isAlertPresent(getDriver())){
        			  alert=getDriver().switchTo().alert();
        			  ActAlertText=alert.getText();  
        			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

        			  if (ActAlertText.contains("Please ensure you've selected the correct contact")){                            
        				  alert.accept();
        				  report.Info("alert messsage is"+ActAlertText);
        			  }                        
        		  }
    			  Thread.sleep(2000);
    			  if(isAlertPresent(getDriver())){
        			  alert=getDriver().switchTo().alert();
        			  ActAlertText=alert.getText();  
        			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

        			  if (ActAlertText.contains("When adding a new Contact")){                            
        				  alert.accept();
        				  report.Info("alert messsage is"+ActAlertText);
        			  }                        
        		  }
    		  
    		  }
    		  Common.WaitForClock(Clockobj);
    		  if (!sLocateCol.equals("")){
    			  common1.selectedRow = -1;
    			  Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));
    			  report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
    		  }
    		  else{               
    			  common1.selectedRow = 1;
    		  }
    		  if (!sUIName.equals("")){         		 
    			  common1.updateSiebList(applet,table, sUIName, sValue); 
    			  Thread.sleep(2000);                       	              
    			  report.Info("Action : "+sUIName+" has perfomed "+sValue);                                                  
    		  }
    		  Common.WaitForClock(Clockobj);
    		  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    		  if(!sVoiceID.equals("")){
    	      		String ID = OfferVoiceID.getText();
    	      		Assert.assertTrue("Offer Voice ID Enrollment is not present", ID.equalsIgnoreCase("Offer Voice ID Enrolment"));
    	      		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	      		report.Info("Offer Voice ID Enrollment is present"); 
    	      		if(!sStatus.equalsIgnoreCase("")){
    	      			if(sStatus.equalsIgnoreCase("blank")){
    	      				sStatus="";
    	      			}
    	      			VoiceIDvalue.click();
    	      		String ActValue = VoiceIDvalue.getTextValue();
    	      		Assert.assertTrue("Value is not matched", ActValue.equals(sStatus));
    	      		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	      		report.Info("Actual Value is Matched with expected value");
    	      	 } 
    	      	 }
    	      	
    		  if(sButton.equalsIgnoreCase("Update Email")){
    			  UpdateEmailButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  UpdateEmailButton.click();
    			  Thread.sleep(2000);
    			  Common.WaitForClock(Clockobj);
    			  String[] sValues =sValue.split(Pattern.quote("@"));
    			  String email = sValues[0];
    			  String domain = sValues[1];

    			  EmailTextBox.type(email);
    			  DomainTextBox.type(domain);
    			  ReTypeEmailTextBox.type(email);
    			  ReTypeDomainTextBox.type(domain);
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			  EmailOKButton.click();
    			  Common.WaitForClock(Clockobj);
    			  Thread.sleep(3000);
    		  }

    		  if(sAction.equalsIgnoreCase("Delete Disabled")){
    			  String DeleteButtonStatus = PopUpDeleteButton.getAttribute("disabled");
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			  if(DeleteButtonStatus.equalsIgnoreCase("true")){
    				  report.Info("Delete Button is disabled in account applet in Contact Tab."); 
    			  }
    			  else{
    				  Assert.assertTrue("Delete Button is enabled in account applet in Contact Tab.", DeleteButtonStatus.equalsIgnoreCase("disabled"));
    			  }
    			  PopUpOKButton.click();
    			  Thread.sleep(2000);        		
    		  }

    		  if(sButton.equalsIgnoreCase("Save")){
    			  SaveButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  SaveButton.click();
    			  Thread.sleep(2000);  
    			  Common.WaitForClock(Clockobj);
    		  }
    		  if(sValidation.equalsIgnoreCase("Yes")){
    			  JObTitle.click();
    			  Common.WaitForClock(Clockobj);
    		  }
    		  if(sValidation.equalsIgnoreCase("Voice Enrolment Status")){
    			  if(!sStatus.equalsIgnoreCase("Present")){ 
    				  VoiceEnrolmentStatuTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    				  VoiceEnrolmentStatuTab.click();
    				  Thread.sleep(2000);
    				  Common.WaitForClock(Clockobj);
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				  report.Info("Voice Enrolment Status tab is clicked successfully"); 
    				  VoiceIDEnrolmentTextBox.click();
    				  Assert.assertTrue("Fail: Voice ID Enrolment is editable", VoiceIDEnrolmentTextBox.isEnabled());
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				  report.Info("PASS: Voice ID Enrolment is not editale"); 
    				  if(!sStatus.equalsIgnoreCase("")){
    					  if(sStatus.equalsIgnoreCase("blank")){
    						  sStatus="";
    					  }
    					  VoiceIDStatusTextBox.click();
    					  String ActValue = VoiceIDStatusTextBox.getTextValue();
    					  Assert.assertTrue("Value is not matched", ActValue.equals(sStatus));
    					  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    					  report.Info("Voice ID Status is Null as expected");
    				  } 
    			  }	
    		  }
    		  
    		  if(!sVoiceEnrolmentTab.equalsIgnoreCase("")){
    	       		VoiceEnrolmentStatuTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    	       		VoiceEnrolmentStatuTab.click();
    	       		Thread.sleep(2000);
    	       		Common.WaitForClock(Clockobj);
    	       		VoiceIDStatusTextBox.click();
    	       		String ActValue = VoiceIDStatusTextBox.getTextValue();
    	       		Assert.assertTrue("Value is not matched", ActValue.equals(sStatus));
    	       		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	       		report.Info("Voice ID Status is Unlocked as expected");
    	       		if(!sDeleteStatus.equalsIgnoreCase("")){
    	       			DeleteStatus.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    	       			DeleteStatus.click();
    	           		Thread.sleep(2000);
    	       		}
    	       		if(!sLockStatus.equalsIgnoreCase("")){
    	       			LockStatus.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    	       			LockStatus.click();
    	       			Thread.sleep(2000);
    	       			LockStatusEnter.click();
    	       			Thread.sleep(2000);
    	       			LockStatusEnter.type(sType);
    	       			Thread.sleep(2000);
    	       			StatusGo.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    	       			StatusGo.click();
    	       			Thread.sleep(2000);
    	       			Common.WaitForClock(Clockobj);
    	       		}
    	       		if(!sUnlockStatus.equalsIgnoreCase("")){
    	       			UnLockStatus.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    	       			UnLockStatus.click();
    	       			Thread.sleep(2000);
    	       			Common.WaitForClock(Clockobj);
    	       			
    	       		}
    	       		
    	       		if(isAlertPresent(getDriver())){
    	       			alert=getDriver().switchTo().alert();
    	                 ActAlertText=alert.getText();
    	                 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	                 alert.accept();
    	                 Thread.sleep(2000);
    	                 if(isAlertPresent(getDriver())){
    	           			alert=getDriver().switchTo().alert();
    	                     ActAlertText=alert.getText();
    	                     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	                     alert.accept();
    	                 }
    	       		}
    	       		
    	       		Thread.sleep(2000);
    	       		getDriver().navigate().refresh();
    	       		Thread.sleep(5000);
    	       		if(!sNewStatus.equalsIgnoreCase("")){
    	       			if(sNewStatus.equalsIgnoreCase("blank")){
    	       				sNewStatus="";
    	       			}
    	       			VoiceIDStatusTextBox.click();
    	       		String ActualValue = VoiceIDStatusTextBox.getTextValue();
    	       		Assert.assertTrue("Value is not matched", ActualValue.equals(sNewStatus));
    	       		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	       		report.Info("Voice ID Status is Null as expected");
    	       	 } 
    	       		
    	     	}
    		  Thread.sleep(2000);
    		  if(sCancelPopuP.equalsIgnoreCase("Yes")){
    			  if(isAlertPresent(getDriver())){
    				  alert=getDriver().switchTo().alert();
    				  ActAlertText=alert.getText();  
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
    				  if (ActAlertText.contains(sPopup1)){                                              
    					  alert.dismiss();
    					  report.Info("alert messsage is"+ActAlertText);
    					  Thread.sleep(2000);
    					  getDriver().navigate().refresh();
    					  int ContacsListSize= findAll(By.xpath("//table[@summary='Admin Account Automatic Debit Details']/tbody/tr")).size();

    					  Assert.assertTrue("Fail: New Contact is created", ContacsListSize<=2);
    					  report.Info("Pass: New contact is not created after click on cancel button");


    				  }
    			  }
    		  }
    		  Thread.sleep(2000);
    		  if(isAlertPresent(getDriver()) && (!sPopup1.equalsIgnoreCase("No"))){
    			  alert=getDriver().switchTo().alert();
    			  ActAlertText=alert.getText();  
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

    			  if (ActAlertText.contains(sPopup1)){                            
    				  alert.accept();
    				  report.Info("alert messsage is"+ActAlertText);
    			  }                        
    		  }
    		  Thread.sleep(2000);
    		  if(!sPopup.equalsIgnoreCase("No")){
    			  common1.HandleErrorPopUp(sPopup); 
    		  }

    		  if(sValidation.equalsIgnoreCase("Status Button")){
    			  VoiceEnrolmentStatusTab.click();
    			  Thread.sleep(5000);
    			  VoiceIDStatusTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		
    			  String selectedStatusValue= VoiceIDStatusTextBox.getTextValue();
    			  if(sButton.equalsIgnoreCase("Lock")){
    				  Assert.assertTrue("Fail:Voice Id status is "+selectedStatusValue+"and not Unlocked for this account",selectedStatusValue.equalsIgnoreCase("Unlocked")); 
    				  Assert.assertTrue("Fail:Lock Status Button is not enabled",LockStatusButton.isEnabled()); 
    				  report.Info("Lock Status Button is enabled");
    				  Assert.assertTrue("Fail:Delete Status Button is not enabled",DeleteStatusButton.isEnabled()); 
    				  report.Info("Delete Status Button is enabled");
    			  }

    			  if(sButton.equalsIgnoreCase("Unlock")){  
    				  Assert.assertTrue("Fail:Voice Id status is "+selectedStatusValue+"and not Locked for this account",selectedStatusValue.equalsIgnoreCase("Locked"));
    				  Assert.assertTrue("Fail:Unlock Status Button is not enabled",UnlockStatusButton.isEnabled()); 
    				  report.Info("Unlock Status Button is enabled");
    				  Assert.assertTrue("Fail:Delete Status Button is not enabled",DeleteStatusButton.isEnabled()); 
    				  report.Info("Delete Status Button is enabled");
    			  }

    			  if(sButton.equalsIgnoreCase("Delete")){     			
    				  Assert.assertTrue("Fail:Delete Status Button is not enabled",DeleteStatusButton.isEnabled()); 
    				  report.Info("Delete Status Button is enabled");
    			  }
    		  }

    		  if(sValidation.equalsIgnoreCase("Voice Enrolment Status")){
    			  if(sStatus.equalsIgnoreCase("Present")){     			
    				  Assert.assertTrue("Fail: Voice Enrolment Status Tab is not present",VoiceEnrolmentStatusTab.isCurrentlyVisible()); 
    				  report.Info("Voice Enrolment Status Tab is present");
    			  }
    		  }

    		  if(sValidation.equalsIgnoreCase("Offer Voice Id")){
    			  String ID = OfferVoiceID.getText();
    			  Assert.assertTrue("Offer Voice ID Enrollment TextBox is not present", ID.equalsIgnoreCase("Offer Voice ID Enrolment"));
    			  report.Info("Offer Voice ID Enrollment is present"); 


    			  if(sAction.equalsIgnoreCase("Change to Yes")){
    				  VoiceIDvalue.clear();
    				  VoiceIDvalue.type("Yes");
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				  MoreInfoSaveButton.click();
    				  Thread.sleep(2000); 
    			  }

    			  if(sAction.equalsIgnoreCase("Change to Never")){
    				  VoiceIDvalue.clear();
    				  VoiceIDvalue.type("Never");
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				  MoreInfoSaveButton.click();
    				  Thread.sleep(2000); 
    			  }
    			  if(sAction.equalsIgnoreCase("Change to Not Now")){
    				  VoiceIDvalue.clear();
    				  VoiceIDvalue.type("Not Now");
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				  MoreInfoSaveButton.click();
    				  Thread.sleep(2000); 
    			  }
    			  Thread.sleep(2000);
    			  if(isAlertPresent(getDriver())&& (!sCancelPopuP.equalsIgnoreCase("No"))){
    				  alert=getDriver().switchTo().alert();
    				  ActAlertText=alert.getText();  
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				  if (sCancelPopuP.contains("OPTIONAL:")){
    					  sCancelPopuP= sCancelPopuP.substring(9);
    				  }	                                                                              	
    				  if (ActAlertText.contains(sCancelPopuP)){  
    					  if(sButton.equalsIgnoreCase("Accept")){
    						  alert.accept();
    					  }
    					  if(sButton.equalsIgnoreCase("Cancel")){
    						  alert.dismiss();
    					  }      				
    					  report.Info("alert messsage is"+ActAlertText);
    				  }                        
    			  }
    			  else if (!isAlertPresent(getDriver())&& (sCancelPopuP.contains("OPTIONAL:"))){
    				  report.Info("OPTIONAL Pop did not occur");
    				  Assert.assertTrue(true);	              		    	
    			  }
    			  else if (!isAlertPresent(getDriver())&& (!sCancelPopuP.equalsIgnoreCase("No"))){
    				  report.Info("Expected Pop did not occur");
    				  Assert.assertTrue(false);	           		    	
    			  }
    			  else if (isAlertPresent(getDriver())&& (sCancelPopuP.equalsIgnoreCase("No"))){
    				  report.Info("UnExpected Pop occured");
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				  Assert.assertTrue(false);	           		    	
    			  }
    			  String OfferVoiceIDValue = VoiceIDvalue.getTextValue();
    			  if(!sStatus.equalsIgnoreCase("")){
    				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				  Assert.assertTrue("Fail: Offer Voice ID Enrolment is not "+sStatus+" after it is "+sAction,sStatus.equalsIgnoreCase(OfferVoiceIDValue)); 
    				  report.Info("Offer Voice ID Enrolment is "+sStatus+"as expected");
    			  }       		
    		  }


    	  }
    	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

      }
 	 
 	 @FindBy(xpath=".//*[@name='Account']")
      WebElementFacade AccountDrillDown;
 	 
      @FindBy(xpath="(.//div[text()='Account Permissions'])[1]")
      WebElementFacade AccountPermission;

      @FindBy(xpath=".//*[@title='Account Permissions:New']")
      WebElementFacade NewButton;
      
      @FindBy(xpath=".//*[@title='Account Permissions:Delete']")
      WebElementFacade DeleteButton;
      
 	 @Step
 		public void Contacts_AccountField() throws InterruptedException, IOException, AWTException{
 			//Homepage.waitUntilPresent();
 			
 				  String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
 				  ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
 					if (ContactsTab.isDisplayed()){
 						ContactsTab.click();
 					}
 					else {
 						AccountTabsDRopDown.selectByVisibleText("Contacts");
 					}
 					if (AccountDrillDown.isDisplayed()){
 						AccountDrillDown.click();
 						Thread.sleep(5000);
 						
 						if (AccountPermission.isDisplayed()){
 							Assert.assertFalse("New Button Greyed Out",NewButton.isEnabled());
 							report.Info("Pass: New Button Greyed Out");
 							Assert.assertFalse("Delete Button Greyed Out",DeleteButton.isEnabled());
 							report.Info("Pass: Delete Button Greyed Out");
 							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 							
 						}
 					else
 						{ 
 							report.Info("Account not found in contact tab");
 						}
 					}
 					
 				  }
 	 
 	 @Step
 		public void MainContacts_AccountField() throws InterruptedException, IOException, AWTException{
 			
 			
 				String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
 				
 				MainContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 			   	MainContactsTab.click();
 			   	AccountTabIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 	   			AccountTabIcon.click();
 	   			Thread.sleep(2000);
 		   		Assert.assertFalse("Fail: Account permission New Button is enabled",AcountsNewButton.isEnabled());
 		   		report.Info("Pass : Account permission New Button is GreyedOut");
 		   		Assert.assertFalse("Fail: Account permission New Button is enabled",AcountsDeleteButton.isEnabled());
 		   		report.Info("Pass : Account permission Delete Button is GreyedOut");
 		   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		   		AcountsOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 		   		AcountsOkButton.click();	
 	 }
 	 
 	 
      @FindBy(xpath="(.//*[@aria-label='Date of birth'])[2]")
      WebElementFacade DOBField;

      @FindBy(xpath="(.//*[@name='Last Name'])[1]")
      WebElementFacade LastName;
      @FindBy(xpath=".//*[@title='Account Details:Save']")
      WebElementFacade DOBSaveButton;
      
      @FindBy(xpath=".//div[@class='vf-oui-error-generic-popup-info']")
      WebElementFacade PopUp;
      @FindBy(xpath="//span/ul/li[6]/a")
      WebElementFacade Save;
      
      @FindBy(xpath="(.//*[@title='Contact Menu'])[1]")
      WebElementFacade MenuButton;
      
      @FindBy(xpath="(.//button/span[text()='OK'])[2]")
      WebElementFacade OKButton;
     		 
      @Step
      public void Contacts_DOBValidation() throws InterruptedException, IOException, AWTException{
     	 
          String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
          
     	 
     	 if (ContactsTab.isCurrentlyVisible())
  			ContactsTab.click();
     	 
     	 else {
     		MainContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
  		   	MainContactsTab.click();
     	 }
     	 
              
 		   	LastName.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 		   	LastName.click();
 			DOBField.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 			DOBField.clear();
 			MenuButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 			MenuButton.click();
 			Thread.sleep(2000);
 			//DOBSaveButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 			Save.click();
 			Thread.sleep(2000);
 			String s = PopUp.getTextValue();
 			Assert.assertTrue("Popup not found", s.contains("Date of Birth (D.O.B.) is a mandatory field; please ensure this is captured to continue."));
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 			report.Info("Expected Popup occured:- "+s);
 			//OKButton.click();
 			common1.HandleErrorPopUp(s);
 			Thread.sleep(2000);	
      }   
      
      
      @FindBy(xpath=".//*[text()='Accounts List']")
      WebElementFacade AccountList;
      @FindBy(xpath=".//*[@aria-label='Date of birth']")
      WebElementFacade DOB;
      @FindBy(xpath=".//*[@title='Account Details:Save']")
      WebElementFacade Savebutton;
      @FindBy(xpath=".//*[@aria-label='Account Details:Query']")
  	  WebElementFacade Query;
  	  @FindBy(xpath=".//*[@aria-labelledby='Customer_Code_Label']")
  	  WebElementFacade AccountNumber;
  	  @FindBy(xpath=".//*[@title='Account Details:Go']")
  	  WebElementFacade Go;
  	  @FindBy(xpath=".//*[@id='1_s_4_l_Name']/a")
  	  WebElementFacade CapturedBillProfNo;
  	  @FindBy(xpath=".//*[@data-tabindex='tabScreen1']")
 	  WebElementFacade AccountsTab;
  	  @FindBy(xpath="//*[@title='Accounts']/parent::a")
	  WebElement AccountsTabsync;
      
 @Step
 public void Account_DOBValidation(String AccountNo, String Rows) throws InterruptedException, IOException, AWTException{
 	 
     String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
     String table = "//table[@summary='Accounts']";
     String applet = "//*[@title='Accounts List Applet']";
     String filePath = "\\src\\test\\resources\\data\\Account.xls";
     String dataSheet = "AccountDOB";
     
     Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Rows, filePath, dataSheet);
     readWorkbook.testData(tableMap);
 	
     for (int i = 0;i < tableMap.get("Value").size();i++) {   
           String svalue = tableMap.get("Value").get(i);
           String sText = tableMap.get("Text").get(i);
           
         
     if (svalue.equals("Accountlist")){
     
    	 common1.waitForElement(AccountsTabsync);
 	//AccountsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();        		
 	AccountsTab.click();
 	
 	Thread.sleep(2000);
 	
 	Query.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();        		
 	Query.click();
 	
 	String sAccountNo = "";
 	//Serenity.setSessionVariable("AccountNo").to("");
 	if (AccountNo.equals("")){
 		sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString();            		
 	}
 	else{
 		sAccountNo = AccountNo;        			
 	}
 	 common1.selectedRow = 1;                                                           
     common1.updateSiebList(applet,table, "Text|Customer_Code", sAccountNo);
     
    Thread.sleep(1000);
 	Go.withTimeoutOf(120,TimeUnit.SECONDS).isEnabled();        		
 	Go.click();
 	 Thread.sleep(5000);
 	DOB.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 	DOB.clear();
 	Savebutton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 	Savebutton.click();
 	Thread.sleep(2000);
 	common1.HandleErrorPopUp("Date of Birth (D.O.B.) is a mandatory field");
     }
     
     if (sText.equals("searchAccount"))
     {
     	//Accountspage.Searchaccount(AccountNo);
     	AccountList.isPresent();
     	DOB.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     	DOB.clear();
     	Savebutton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     	Savebutton.click();
     	Thread.sleep(2000);
 		String s = PopUp.getTextValue();
 		Assert.assertTrue("Popup not found", s.contains("Date of Birth (D.O.B.) is a mandatory field; please ensure this is captured to continue."));
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		report.Info("Expected Popup occured:- "+s);
 		OKButton.click();
 		Thread.sleep(2000);
     	
     }
     else{
     	report.Info("Account List Not found");
     }
     }   
 }    

 
 @FindBy(xpath = ".//*[@class='siebui-button-toolbar siebui-closed']")
 WebElementFacade MainMenuButton;
 
 @FindBy(xpath=".//*[@name='SiteMap']")
 WebElementFacade SiteMapButton;
 
 @FindBy(xpath=".//*[@title=' List Applet']")
 WebElementFacade ListApplet;
 
 @FindBy(xpath=".//*[@id='1_Type']")
 WebElementFacade TypeTextBox;
 
 @FindBy(xpath=".//a[text()='Division Filter Monitoring']")
 WebElementFacade DivisionFilterButton;
 
 @FindBy(xpath="(.//div[text()='Screens']//following::*[text()='Administration NewCo'])[1]")
 WebElementFacade AdministrationNewCoButton;

 @FindBy(xpath = ".//*[@title='Contacts']/parent::a")
 WebElementFacade ContactScreenTab;
 
 @FindBy(xpath=".//*[@id='s_at_m_2']")
 WebElementFacade DivisionMenuButton;

 @FindBy(xpath="//span/ul/li[8]/a")
 WebElementFacade DivisionNewQueryButton;
 
 @Step
 public void DivisionFilterMonitoring(String row) throws IOException, InterruptedException, AWTException{


	 String filePath = "\\src\\test\\resources\\data\\Account.xls";
	 String dataSheet = "DivisionProvision";

	 String applet = ""; 
	 String table = "";


	 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
	 readWorkbook.testData(tableMap);

	 if (tableMap.get("RowNo").size()==0){
		 report.Info(row+" logical name not found in sheet.");
		 Assert.assertTrue(false);       	
	 }
	 if(ContactScreenTab.isVisible()){
		 MainMenuButton.click();
		 SiteMapButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 SiteMapButton.click();
		 AdministrationNewCoButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 AdministrationNewCoButton.click();
		 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 DivisionFilterButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 DivisionFilterButton.click();
		 report.Info("Division Filter Monitoring Screen displayed successfully");
	 }		      

	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 for (int i = 0;i < tableMap.get("RowNo").size();i++) {   

		 String sLocateCol = tableMap.get("LocateCol").get(i);
		 String sLocateColValue = tableMap.get("LocateColValue").get(i);             
		 String sIndex = tableMap.get("Index").get(i);
		 String sUIName = tableMap.get("UIName").get(i);
		 String sValue = tableMap.get("Value").get(i);
		 String sPopup = tableMap.get("Popup").get(i);
		 String sButton = tableMap.get("Button").get(i);
		 String sValidation = tableMap.get("Validation").get(i);


		 if(sButton.equalsIgnoreCase("Query")){
			 //	  ListApplet.sendKeys(Keys.chord(Keys.ALT, "q"));
			 DivisionMenuButton.click();
			 Thread.sleep(2000);
			 DivisionNewQueryButton.click(); 
			 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			 TypeTextBox.typeAndEnter(sValue);
			 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 }

		 if(sValidation.equalsIgnoreCase("Yes")){
			 applet = "//*[@title='Division Name List Applet']";
			 table = "//table[@summary='Division Name']";
		 }
		 else{
			 applet = "//*[@title=' List Applet']";
			 table = "//table[@id='s_2_l']";
			 //"(//*[@title=' List Applet']//child::table)[2]";
		 }

		 if (sIndex.equals("")){
			 sIndex = "0";
		 }

		 if (!sLocateCol.equals("")){
			 common1.selectedRow = -1;
			 Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));
			 report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);   
			 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 }
		 else{               
			 common1.selectedRow = 1;
		 }
	 }   
}
 
 @FindBy(xpath=".//*[@aria-label='Account']//following-sibling::span")
 WebElementFacade AccountPopUpIcon;
 @Step
 public void ContactListViewValidation(String row) throws IOException, InterruptedException, AWTException{
       
      
	  String filePath = "\\src\\test\\resources\\data\\Account.xls";
     String dataSheet = "AddContact";
     
     String applet = "//*[@title='Contacts List Applet']";
     String table = "//table[@summary='Admin Account Automatic Debit Details']";

     
     Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
     readWorkbook.testData(tableMap);
     
     if (tableMap.get("RowNo").size()==0){
           	report.Info(row+" logical name not found in sheet.");
           	Assert.assertTrue(false);        	
           }
     if(ContactsTab.isDisplayed()){
		   ContactsTab.click();
          }
          else{
                AccountDropDown.selectByVisibleText("Contacts");
          }     
      report.Info("Contacts Tab Clicked");
      sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     for (int i = 0;i < tableMap.get("RowNo").size();i++) {   

   	  String sLocateCol = tableMap.get("LocateCol").get(i);
         String sLocateColValue = tableMap.get("LocateColValue").get(i);             
         String sIndex = tableMap.get("Index").get(i);
         String sUIName = tableMap.get("UIName").get(i);
         String sValue = tableMap.get("Value").get(i);
         String sPopup = tableMap.get("Popup").get(i);
         String sButton = tableMap.get("Button").get(i);
         String sAction = tableMap.get("Action").get(i);
         Alert alert;
         String ActAlertText="";
         
         if (sIndex.equals("")){
         	sIndex = "0";
         }
         if (sPopup.equals("")){
         	sPopup = "No";
         }
        
         if (!sLocateCol.equals("")){
             common1.selectedRow = -1;
            Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));
            report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
             }
        else{               
   	  common1.selectedRow = 1;
        }
   	  if (!sUIName.equals("")){         		 
             common1.updateSiebList(applet,table, sUIName, sValue); 
             Thread.sleep(2000);                       	              
             report.Info("Action : "+sUIName+" has perfomed "+sValue);                                                  
   	  }
   	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
   	  
   	  if(sAction.equalsIgnoreCase("Delete Disabled")){
   		  AccountPopUpIcon.click();
   		  Thread.sleep(3000);  
   		  String DeleteButtonStatus = PopUpDeleteButton.getAttribute("disabled");
   		  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
   		 if(DeleteButtonStatus.equalsIgnoreCase("true")){
   			report.Info("Delete Button is disabled in account applet in Contact List."); 
   		 }
   		 else{
   			 Assert.assertTrue("Delete Button is enabled in account applet in Contact List.", DeleteButtonStatus.equalsIgnoreCase("disabled"));
   		 }
   		PopUpOKButton.click();
   		Thread.sleep(2000);        		
   	  }       	 
   	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString()); 
      }
 }
 

 
 @FindBy(xpath=".//*[@aria-label='First Level View Bar']")
 WebElementFacade HomepageTabDropdown;
 
 @FindBy(xpath=".//*[@aria-labelledby='Date_of_Birth_Label']")
 WebElementFacade DOBTextBox;
 @FindBy(xpath=".//*[@id='Offer_Voice_ID_Enrolment_Label']")
 WebElementFacade OfferVoiceID;
 
 @FindBy(xpath=".//*[@aria-label='Offer Voice ID Enrolment']")
 WebElementFacade VoiceIDvalue; 
 
 @FindBy(xpath=".//*[@title='Contact:New']")
 WebElementFacade contactNewButton; 
 

 @FindBy(xpath="//input[@aria-label='First name']")
 WebElementFacade ContactScreenFirstName; 
 
 @FindBy(xpath="//button[@title='Contacts:Delete']")
 WebElementFacade ContactScreenDeleteButton;

 @FindBy(xpath="//input[contains(@id,'M_M')]")
 WebElementFacade TitleTextBox; 
 
 @Step
 public void AddContactInContactScreen(String row) throws IOException, InterruptedException, AWTException{
     
     
	  String filePath = "\\src\\test\\resources\\data\\Account.xls";
   String dataSheet = "AddContact";
   
   String applet = "//*[@title='Contacts List Applet']";
   String table = "//table[@summary='Contacts']";

   
   Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
   readWorkbook.testData(tableMap);
   
   if (tableMap.get("RowNo").size()==0){
         	report.Info(row+" logical name not found in sheet.");
         	Assert.assertTrue(false);        	
         }
   if(ContactScreenTab.isVisible()){
 	  ContactScreenTab.click();
	    }
	   else{
	    		HomepageTabDropdown.selectByVisibleText("Contacts");
	    }    
    report.Info("Contacts Tab Clicked");
    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
   for (int i = 0;i < tableMap.get("RowNo").size();i++) {   

     String sLocateCol = tableMap.get("LocateCol").get(i);
     String sLocateColValue = tableMap.get("LocateColValue").get(i);             
     String sIndex = tableMap.get("Index").get(i);
     String sUIName = tableMap.get("UIName").get(i);
     String sValue = tableMap.get("Value").get(i);
     String sPopup = tableMap.get("Popup").get(i);
     String sButton = tableMap.get("Button").get(i);
     String sAction = tableMap.get("Action").get(i);
     String sVoiceID = tableMap.get("VoiceID").get(i);
     String sStatus = tableMap.get("Status").get(i);
     Alert alert;
     String ActAlertText="";
     String sCancelPopuP = tableMap.get("CancelPopuP").get(i);
     String sValidation = tableMap.get("Validation").get(i);
     if (sIndex.equals("")){
     	sIndex = "0";
     }
     if (sPopup.equals("")){
     	sPopup = "No";
     }
     if (sCancelPopuP.equals("")){
  	   sCancelPopuP = "No";
        }
     if(sButton.equalsIgnoreCase("New")){
  	   contactNewButton.click();
  		Thread.sleep(4000);  
  	  }
     if(sButton.equalsIgnoreCase("Esc")){
    	 TitleTextBox.sendKeys(Keys.ESCAPE);
    		Thread.sleep(2000);  
    	  }
    
     
     if(sAction.equalsIgnoreCase("Delete Disabled")){
    	 ContactScreenFirstName.sendKeys(Keys.ESCAPE);
     }
     if (!sLocateCol.equals("")){
         common1.selectedRow = -1;
        Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));
        report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
         }
    else{               
 	   common1.selectedRow = 1;
    	}
	  if (!sUIName.equals("")){         		 
         common1.updateSiebList(applet,table, sUIName, sValue); 
         sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
         Thread.sleep(2000);                       	              
         report.Info("Action : "+sUIName+" has perfomed "+sValue);                                                  
	  }
	 
	  
	 if(!sVoiceID.equals("")){
		String ID = OfferVoiceID.getText();
		Assert.assertTrue("Offer Voice ID Enrollment is not present", ID.equalsIgnoreCase("Offer Voice ID Enrolment"));
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		report.Info("Offer Voice ID Enrollment is present"); 
		if(!sStatus.equalsIgnoreCase("")){
			if(sStatus.equalsIgnoreCase("blank")){
				sStatus="";
			}
	VoiceIDvalue.click();
		String ActValue = VoiceIDvalue.getTextValue();
		Assert.assertTrue("Value is not matched", ActValue.equals(sStatus));
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		report.Info("Actual Value is Matched with expected value");
	 } 
	 }
	  if(sAction.equalsIgnoreCase("ClearDOB")){
		DOBTextBox.clear();
		 Thread.sleep(1000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	  }
	  
	 if(sAction.equalsIgnoreCase("Delete Disabled")){
		  String DeleteButtonStatus = ContactScreenDeleteButton.getAttribute("disabled");
		  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 if(DeleteButtonStatus.equalsIgnoreCase("true")){
			report.Info("Delete Button is disabled in account applet in Contact Screen."); 
		 }
		 else{
			 Assert.assertTrue("Delete Button is enabled in account applet in Contact Screen.", DeleteButtonStatus.equalsIgnoreCase("disabled"));
		 }
		
	  }
	  
	  
	  if(sButton.equalsIgnoreCase("Save")){
		SaveButton.click();
		Thread.sleep(2000);  
	  }
	  
	  if(!sPopup.equalsIgnoreCase("No")){
		common1.HandleErrorPopUp(sPopup); 
	  }
	  
		  if(sValidation.equalsIgnoreCase("Offer Voice Id")){
			  String ID = OfferVoiceID.getText();
			  Assert.assertTrue("Offer Voice ID Enrollment TextBox is not present", ID.equalsIgnoreCase("Offer Voice ID Enrolment"));
			  report.Info("Offer Voice ID Enrollment is present"); 


			  if(sAction.equalsIgnoreCase("Change to Yes")){
				  VoiceIDvalue.clear();
				  VoiceIDvalue.type("Yes");
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  MoreInfoSaveButton.click();
				  Thread.sleep(2000); 
			  }

			  if(sAction.equalsIgnoreCase("Change to Never")){
				  VoiceIDvalue.clear();
				  VoiceIDvalue.type("Never");
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  MoreInfoSaveButton.click();
				  Thread.sleep(2000); 
			  }
			  if(sAction.equalsIgnoreCase("Change to Not Now")){
				  VoiceIDvalue.clear();
				  VoiceIDvalue.type("Not Now");
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  MoreInfoSaveButton.click();
				  Thread.sleep(2000); 
			  }
			  if(sAction.equalsIgnoreCase("Change to Null")){
				  VoiceIDvalue.clear();				  
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  MoreInfoSaveButton.click();
				  Thread.sleep(2000); 
			  }
			  Thread.sleep(2000);
			  if(isAlertPresent(getDriver())&& (!sCancelPopuP.equalsIgnoreCase("No"))){
				  alert=getDriver().switchTo().alert();
				  ActAlertText=alert.getText();  
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  if (sCancelPopuP.contains("OPTIONAL:")){
					  sCancelPopuP= sCancelPopuP.substring(9);
				  }	                                                                              	
				  if (ActAlertText.contains(sCancelPopuP)){  
					  if(sButton.equalsIgnoreCase("Accept")){
						  alert.accept();
					  }
					  if(sButton.equalsIgnoreCase("Cancel")){
						  alert.dismiss();
					  }      				
					  report.Info("alert messsage is"+ActAlertText);
				  }                        
			  }
			  else if (!isAlertPresent(getDriver())&& (sCancelPopuP.contains("OPTIONAL:"))){
				  report.Info("OPTIONAL Pop did not occur");
				  Assert.assertTrue(true);	              		    	
			  }
			  else if (!isAlertPresent(getDriver())&& (!sCancelPopuP.equalsIgnoreCase("No"))){
				  report.Info("Expected Pop did not occur");
				  Assert.assertTrue(false);	           		    	
			  }
			  else if (isAlertPresent(getDriver())&& (sCancelPopuP.equalsIgnoreCase("No"))){
				  report.Info("UnExpected Pop occured");
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  Assert.assertTrue(false);	           		    	
			  }
			  String OfferVoiceIDValue = VoiceIDvalue.getTextValue();
			  if(!sStatus.equalsIgnoreCase("")){
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  Assert.assertTrue("Fail: Offer Voice ID Enrolment is not "+sStatus+" after it is "+sAction,sStatus.equalsIgnoreCase(OfferVoiceIDValue)); 
				  report.Info("Offer Voice ID Enrolment is "+sStatus+"as expected");
			  }       		
		  }
	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	  
	}              
}

	 
	 @FindBy(xpath=".//*[@title='Contacts:Add']")
	    WebElementFacade NewContactButton;	
	 @FindBy(xpath=".//*[@title='Add Contacts:OK']")
	    WebElementFacade ContactsOkbutton;
	 
	 @Screenshots(forEachAction=true)
@Step
public void Contacts_LastNameFL(String Validation) throws InterruptedException, IOException{
	//Homepage.waitUntilPresent();
	
		 
		   String filePath = "\\src\\test\\resources\\data\\Account.xls";
	      String dataSheet = "ContactsLastName";
	      String applet = "//*[@title='Add Contacts List Applet']";
	      String table = "//table[@summary='Add Contacts']";  
 
 
	      Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Validation, filePath, dataSheet);
	      readWorkbook.testData(tableMap);
	      
	      for (int i = 0;i < tableMap.get("LocateCol").size();i++) { 	  
	   	
	   	  // String sIndex = tableMap.get("Index").get(i);		    	   
	   	   String sUIName = tableMap.get("UIName").get(i);
	   	   String sValue = tableMap.get("Value").get(i);
	   	   String Online_Account_Validation = tableMap.get("OnlineAccountValidation").get(i);
	   	   
	   	ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
		if (ContactsTab.isDisplayed()){
			ContactsTab.click();
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Contacts");
		}
		
		
	
	if (Online_Account_Validation.equals("Y")){
		OnlineID.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				
				OnlineID.click();
				Thread.sleep(3000);
	        		String OF = OnlineIDCheckedBoxnew.getAttribute("readonly");
	        				if (OF.equals("readonly")){
	        					report.Info("Pass : Online Flag DISABLED as expected");	       			
	        					}
	        				else {report.Info("Fail : Online Flag Enabled");}	        	
	        		Thread.sleep(5000);
	
	       }
	
	NewContactButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
	NewContactButton.click();
	
         common1.selectedRow = 1;
	   if (!sUIName.equals("")){
		common1.updateSiebList(applet,table, sUIName, sValue);   
	   }
	   report.Info(" "+sValue+" is updated successfully ");
	   
	   
	   Thread.sleep(4000);
	ContactsOkbutton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	ContactsOkbutton.click();
	Thread.sleep(3000);
	   if(isAlertPresent(getDriver())){
 	Alert alert=getDriver().switchTo().alert();
     String ActAlertText=alert.getText();                                           		
  		alert.accept();
  		report.Info("alert messsage is"+ActAlertText);
  	  }
	Thread.sleep(3000);
	if(isAlertPresent(getDriver())){
 	Alert alert=getDriver().switchTo().alert();
     String ActAlertText=alert.getText();                                           		
  		alert.accept();
  		report.Info("alert messsage is"+ActAlertText);
  	  }
	
	report.Info("new contact is added successfully");

		}
	}
	  @Step
	   public void Contacts_DOBClear() throws InterruptedException, IOException, AWTException{
		   String applet = "//*[@title='Contacts List Applet']";
	 	   String table = "//table[@summary='Admin Account Automatic Debit Details']";
	 	   
		    ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
			if (ContactsTab.isDisplayed()){
				ContactsTab.click();
			}
			else {
				AccountTabsDRopDown.selectByVisibleText("Contacts");
			}
			
			Thread.sleep(3000);
		   
		   //common1.selectedRow = 1;
		   common1.locateColumn(applet,table, "First_Name", "AUTOZZ", "0");
		   Thread.sleep(1000);
		   common1.updateSiebList(applet,table, "Clear|Date_of_Birth", "");
		   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   
		   Thread.sleep(3000);
		   	   
	 		SaveButton.click();
	 		
	 		Thread.sleep(3000);
	 		
	 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   
		   if(isAlertPresent(getDriver())){
			   report.Info("Contacts is not saved when DOB is cleared for Business accounts.");
			   Assert.assertTrue(false);
		   }
		   else if (!isAlertPresent(getDriver())){        	   
		   report.Info("Contacts is saved successfully when DOB is cleared for Business accounts.");
	       
	     }
	   } 	 
		
	  @FindBy(xpath = "//a[@data-tabindex='tabScreen2']")
		WebElementFacade OuterContactTab;

		@FindBy(xpath = "//input[@aria-label='User name']")
		WebElementFacade UserNameTF;

		@FindBy(xpath = "//input[@aria-label='Do not email']")
		WebElementFacade doNotEmailCheckBox;

		@FindBy(xpath = "//input[@aria-label='Do not mail']")
		WebElementFacade doNotmailCheckBox;

		@FindBy(xpath = "//input[@aria-label='Do not market research']")
		WebElementFacade DoNotMarketResearchCheckBox;

		@FindBy(xpath = "//input[@aria-label='Do not use third party social<br>media and apps data']")
		WebElementFacade DoNotUseThirdPartySocialMediaAndAppsDataCheckBox;

		@FindBy(xpath = "//input[@aria-label='Permission affirmation']")
		WebElementFacade PermissionAffirmationCheckBox;

		@FindBy(xpath = "//input[@aria-label='Do not use my identity']")
		WebElementFacade DoNotUseMyIdentityCheckBox;
		
		@FindBy(xpath = "//span[@class='vfoui-icon-info-circle vfoui-informatin-icon-position vf-enab-service-permi-socialmedia-info']")
		WebElementFacade DNUThirdPartySocialMediaToolTip;
		
		@FindBy(xpath = "//div[@class='vfoui-tooltip-content']")
		WebElementFacade DNUThirdPartySocialMediaToolTipContentDiv;
		
		

		@Step
		public void searchWithUsernameInContactsOuterTab(String Username) {
			OuterContactTab.click();
			UserNameTF.typeAndEnter(Username);

		}

		@Step
		public void clickCheckboxAndSave(WebElementFacade wb) throws Exception {
			wb.click();
			Actions builder = new Actions(getDriver());
			builder.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
			Thread.sleep(4000);

		}

		@Step
		public void checkUncheckGDPRPermission(String PermissionType) throws Exception {
			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if (PermissionType.equalsIgnoreCase("CheckDoNotUseThirdPartySocialMediaAndAppsData")) {
				if (DoNotUseThirdPartySocialMediaAndAppsDataCheckBox.isSelected()) {
					clickCheckboxAndSave(DoNotUseThirdPartySocialMediaAndAppsDataCheckBox);
					sikuliUtility
							.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					clickCheckboxAndSave(DoNotUseThirdPartySocialMediaAndAppsDataCheckBox);
					sikuliUtility
							.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				} else {
					clickCheckboxAndSave(DoNotUseThirdPartySocialMediaAndAppsDataCheckBox);
					sikuliUtility
							.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				Actions builder = new Actions(getDriver());
				builder.moveToElement(DNUThirdPartySocialMediaToolTip).perform();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Fail: Tool Tip text does not match", DNUThirdPartySocialMediaToolTipContentDiv.getText().contains("When ticked this means the customer has not given permission for Vodafone to use third party social media"));
				verifyAllAccountPermissionIsEditable(true);
			}
			if (PermissionType.equalsIgnoreCase("UpdateForMinor")) {
				verifyAllAccountPermissionIsEditable(false);
				}
		}

		@Step
		public void unCheckGDPRPermission(String PermissionType) {

		}

		@Step
		public void verifyAllAccountPermissionIsEditable(Boolean bFlag) {
			if(bFlag == true) 
			{
			Assert.assertTrue("Fail: Do Not Email is not editable", doNotEmailCheckBox.isEnabled());
			Assert.assertTrue("Fail: Do Not Mail is not editable", doNotmailCheckBox.isEnabled());
			Assert.assertTrue("Fail: Do Not Market Research is not editable", DoNotMarketResearchCheckBox.isEnabled());
			Assert.assertTrue("Fail: Do Not User Third Party Social Media and Data is not editable",
					DoNotUseThirdPartySocialMediaAndAppsDataCheckBox.isEnabled());
			}
			
			if(bFlag == false) 
			{
			Assert.assertFalse("Fail: Do Not Email is editable", doNotEmailCheckBox.isEnabled());
			Assert.assertFalse("Fail: Do Not Mail is editable", doNotmailCheckBox.isEnabled());
			Assert.assertFalse("Fail: Do Not Market Research is editable", DoNotMarketResearchCheckBox.isEnabled());
			Assert.assertFalse("Fail: Do Not User Third Party Social Media and Data is editable",
					DoNotUseThirdPartySocialMediaAndAppsDataCheckBox.isEnabled());
			}

		}
		@Step
	      public void DOBValidation(String row) throws IOException, InterruptedException, AWTException{


	    	  String filePath = "\\src\\test\\resources\\data\\Account.xls";
	    	  String dataSheet = "AddContact";

	    	  String applet = "//*[@title='Contacts List Applet']";
	    	  String table = "//table[@summary='Admin Account Automatic Debit Details']";


	    	  Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
	    	  readWorkbook.testData(tableMap);

	    	  if(ContactsTab.isDisplayed()){
	    		  ContactsTab.click();
	    	  }
	    	  else{
	    		  AccountDropDown.selectByVisibleText("Contacts");
	    	  }     
	    	  report.Info("Contacts Tab Clicked");
	    	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    	  for (int i = 0;i < tableMap.get("RowNo").size();i++) {   

	    		  String sLocateCol = tableMap.get("LocateCol").get(i);
	    		  String sLocateColValue = tableMap.get("LocateColValue").get(i);             
	    		  String sIndex = tableMap.get("Index").get(i);
	    		  String sUIName = tableMap.get("UIName").get(i);
	    		  String sValue = tableMap.get("Value").get(i);
	    		  String sPopup = tableMap.get("Popup").get(i);
	    		  String sButton = tableMap.get("Button").get(i);
	    		  String sPopup1 = tableMap.get("Popup1").get(i);
	    		  String sValidation = tableMap.get("Validation").get(i);
	    		  
	    		  Alert alert;
	    		  String ActAlertText="";
	    		  
	    		  if (sIndex.equals("")){
	    			  sIndex = "0";
	    		  }
	    		  if (sPopup.equals("")){
	    			  sPopup = "No";
	    		  }
	    		  if (sPopup1.equals("")){
	    			  sPopup1 = "No";
	    		  }
	    		  
	    		  if(sButton.equalsIgnoreCase("Add")){
	    			  CotactAddButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    			  ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", getDriver().findElement(By.xpath(applet+table+"//tr[@id='1']")));
	    			  CotactAddButton.click();
	    			  CotactLastName.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    			  CotactLastName.click();
	    			  CotactLastNameTextBOx.typeAndEnter("DNU");

	    			  AddContactNewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    			  AddContactNewButton.click();
	    			  Thread.sleep(2000);
	    			  if(isAlertPresent(getDriver())){
	    				  alert=getDriver().switchTo().alert();                    	
	    				  alert.accept();

	    			  }
	    		  }
	    		  if (!sLocateCol.equals("")){
	    			  common1.selectedRow = -1;
	    			  Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));
	    			  report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
	    		  }
	    		  else{               
	    			  common1.selectedRow = 1;
	    		  }
	    		  if (!sUIName.equals("")){         		 
	    			  common1.updateSiebList(applet,table, sUIName, sValue); 
	    			  Thread.sleep(2000);                       	              
	    			  report.Info("Action : "+sUIName+" has perfomed "+sValue);                                                  
	    		  }
	    		  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    		 
	  
	    		  /*if(sValidation.equalsIgnoreCase("Yes")){
	    			  JObTitle.click();
	    		  }*/
	    		  	    		  	    		 
	    	       		if(isAlertPresent(getDriver())){
	    	       			alert=getDriver().switchTo().alert();
	    	                 ActAlertText=alert.getText();
	    	                 
	    	                 if (ActAlertText.contains(sPopup1)){
	    	                	 report.Info("Popup : "+ActAlertText+" is displayed ");
	    	                 }
	    	                 else {
	    	                	 report.Info("Popup : "+ActAlertText+" is not displayed ");
	    	                	 Assert.assertTrue(false);
	    	                 }
	    	                	 
	    	                 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	                 alert.accept();
	    	                 Thread.sleep(2000);
	    	                 if(isAlertPresent(getDriver())){
	    	           			alert=getDriver().switchTo().alert();
	    	                     ActAlertText=alert.getText();
	    	                     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	                     alert.accept();
	    	                 }
	    	       		}	    	       			
	      }
		}		
 }
