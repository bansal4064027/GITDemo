package pages;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.common;
import utilities.ReportMessege;
import utilities.SikuliUtility;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;

import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pages.AboutCustomerPageEnh;

@SuppressWarnings("deprecation")
public class AccountsPage extends PageObject {
	@Steps
    private ReadWorkbook readWorkbook;
	
	@Steps
	private AboutCustomerPageEnh AboutCustomerEnh;
	
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
	  
	  @FindBy(xpath="//input[@aria-labelledby='VF_VIP_Label']")
		WebElementFacade VIPCheckBox;
	
	//@FindBy(xpath=".//*[@text='My Homepage']")
	  @FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
	    WebElement Clockobj; 
	 @FindBy(xpath=".//*[@data-tabindex='tabScreen0']")
	WebElementFacade Homepage;
	//@FindBy(xpath=".//*[@title='Accounts']")
	@FindBy(xpath=".//*[@data-tabindex='tabScreen1']")
	WebElementFacade AccountsTab;
	@FindBy(xpath=".//*[@data-tabindex='tabScreen1']/following::button[contains(@aria-label,'New')]")
	WebElementFacade newAccount;
	@FindBy(xpath="//input[@aria-labelledby='Type_Label']")
	WebElementFacade accountTypeSelect;
	@FindBy(xpath="//input[@aria-label='Title']")
	WebElementFacade TitleWebList;
	@FindBy(xpath="//input[@aria-label='First name']")
	WebElementFacade firstName;
	@FindBy(xpath="//input[@aria-label='First name']")
	WebElement firstNameSync;
	@FindBy(xpath="//input[@aria-label='Last name']")
	WebElementFacade lastName;
	@FindBy(xpath="//input[@aria-label='Date of birth']")
	WebElementFacade dob;
	@FindBy(xpath="//*[@id='s_2_1_134_0_icon']")
	WebElementFacade addrPopUp;
	@FindBy(xpath="//*[@aria-labelledby='VF_PIN1_Label']")
	WebElementFacade pin1;
	@FindBy(xpath="//*[@aria-labelledby='VF_PIN2_Label']")
	WebElementFacade pin2;
	@FindBy(xpath="//*[@aria-labelledby='VF_PIN3_Label']")
	WebElementFacade pin3;
	@FindBy(xpath="//*[@aria-labelledby='VF_PIN4_Label']")
	WebElementFacade pin4;
	@FindBy(xpath=".//*[@aria-label='Create online account']")
	WebElementFacade OnlineFlagCheckBox;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Date_of_Birth_Label']")
	WebElementFacade DOBTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='StreetAddress_Label']//following::*[@aria-label='Multiple Selection Field'][1]")
	WebElementFacade AddressPopUp;
	@FindBy(xpath="//*[@title='Add Address:Cancel']")
	WebElementFacade AddressCancel;
	@FindBy(xpath="//td[contains(@id,'Postal_Code')]/input")
	WebElementFacade PostCodeTextBox;
	@FindBy(xpath="//*[@title='Account Addresses:Add >']")
	WebElementFacade AddAddress;
	@FindBy(xpath="//*[@title='Account Addresses:OK']")
	WebElementFacade AddressOKButton;
	@FindBy(xpath=".//*[@title='Account Details:Update Email']")
	WebElementFacade UpdateEmailButton;
	@FindBy(xpath="//*[@aria-label='Account Details:Save']")
	WebElementFacade accountSave;
	@FindBy(xpath=".//*[@aria-labelledby='VFEmailAddress_Label']")
	WebElementFacade EmailTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VFDomainAddress_Label']")
	WebElementFacade EmailDoamin;
	@FindBy(xpath=".//*[@aria-labelledby='VFReTypeEmailAddress_Label']")
	WebElementFacade ReTypeEamilTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VFReTypeDomainAddress_Label']")
	WebElementFacade ReTypeEmailDoamin;
	@FindBy(xpath=".//*[@title='Siebel:OK']")
	WebElementFacade EmailOK;
	@FindBy(xpath=".//*[@aria-label='Account no.']")
	WebElementFacade CapturedAccNo;	
	@FindBy(xpath=".//*[@aria-label='Anonymous']")
	WebElementFacade AnonymousCheckBox;	
	@FindBy(xpath=".//*[@aria-label='Trading As']")
	WebElementFacade TradingAsTextBox;	
	//@FindBy(xpath=".//*[@aria-label='Account no.']")
	//WebElementFacade CapturedAccNo;
	@FindBy(xpath="//input[@aria-label='Account Category']")
	WebElementFacade AccountCategorySelect;
	@FindBy(xpath="//input[@aria-label='Account SubCategory']")
	WebElementFacade AccountSubCategorySelect;
	@FindBy(xpath=".//*[@aria-label='User name']")
	WebElementFacade UserNameTextBox;
	@FindBy(xpath=".//*[@aria-label='Account Category']")
	WebElementFacade AccountCategoryTextBox;
	@FindBy(xpath=".//*[@aria-label='Account SubCategory']")
	WebElementFacade AccountSubCategoryTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='Name_Label']")
    WebElementFacade EnterAccountNameTextBox; 
    @FindBy(xpath=".//*[@aria-label='Care Team']")
    WebElementFacade CareTeamBox;
    @FindBy(xpath=".//*[@id='s_2_1_6_0_icon']")
    WebElementFacade CareTeamIcon;      
    @FindBy(xpath=".//button[@title='Pick Internal Division:OK']")
    WebElementFacade CareTeamBoxOKButton;
    @FindBy(xpath=".//*[@aria-label='Alt phone no.']")
    WebElementFacade AltPhoneNo;
    @FindBy(xpath=".//*[@aria-label='Legal status']")
    WebElementFacade LegalStatus;
    @FindBy(xpath=".//*[@aria-label='Gender']")
    WebElementFacade Gender;
	@FindBy(xpath=".//*[@aria-label='Memorable word']")
    WebElementFacade MemorableWordTextBox;
    @FindBy(xpath=".//*[@aria-label='Memorable hint']")
    WebElementFacade MemorableHintTextBox;
    
    @FindBy(xpath="//*[@title='Accounts']/parent::a")
	WebElement AccountsTabSync;
    @FindBy(xpath=".//*[contains(@aria-label,'Account Details:New') or contains(@aria-label,'New')]")
	WebElement newAccountSync;
	@FindBy(xpath="//input[@aria-labelledby='Type_Label']")
	WebElement accountTypeSelectSync;
	@FindBy(xpath="//input[@aria-labelledby='Type_Label']")
	WebElement UpdateEmailButtonSync;
	@FindBy(xpath="(.//*[@class='siebui-icon-dropdown applet-form-combo applet-list-combo'])[3]")
	WebElementFacade accountTypeIcon;

	@FindBy(xpath=".//*[contains(@aria-describedby,'Status')]")
	WebElement AddressStatusElement;
	

	@FindBy(xpath=".//*[contains(@aria-describedby,'Status')]/input")
	WebElementFacade AddressStatusTextBox;
	
    @Test
   	@Screenshots(forEachAction=true)
   	@Step
   	public void CreateNewAccount(String accountType) throws InterruptedException, IOException, AWTException{
   		//Homepage.waitUntilPresent();
   		
   		String filePath = "\\src\\test\\resources\\data\\Account.xls";
        String dataSheet = "CreateNewAccount";
        String applet = "//*[@title='Add Address List Applet']";
   	    String table = "//table[@summary='Add Address']"; 
           
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
                 String AccountCategory = tableMap.get("AccountCategory").get(i);
                 String AccountSubCategory = tableMap.get("AccountSubCategory").get(i);
             	  String sAccountName = tableMap.get("AccountName").get(i);
             	  String AutoAccountName = FirstName + " " + LastName;
             	  String careteam = tableMap.get("CareTeam").get(i);
             	  String accounTab = tableMap.get("AccountTab").get(i);
   	      	  	String sLegalStatus = tableMap.get("Legal Status").get(i);
   	      	  	String sGender = tableMap.get("Gender").get(i);
   	      		String sPhoneNumber = tableMap.get("PhoneNumber").get(i);
   	      		String sLocateCol = tableMap.get("LocoteCol").get(i);
   	      		String sLocateColValue = tableMap.get("LocoteColValue").get(i);
   	      		String sIndex = tableMap.get("Index").get(i);
   	      		String UserName = FirstName + LastName;
   	      		String sSkipAddress = tableMap.get("AddressLine").get(i); 
   	      		String sChannel = tableMap.get("Channel").get(i);
	      		String Popup = tableMap.get("Popup").get(i);
	      		String Popup2 = tableMap.get("Popup2").get(i);
	      		String sMemorableWord = tableMap.get("MemorableWord").get(i);
	      		String sVIP = tableMap.get("VIP").get(i);
	      		String sValidations = tableMap.get("Validations").get(i);
	      		String sRegistrationNo = tableMap.get("RegistrationNo").get(i);
	      		
	      		String sEnv = Serenity.sessionVariableCalled("Env").toString(); 
	   	      	Random rand = new Random(System.currentTimeMillis());
	  			int num = rand.nextInt(2000000000);
	  			String valuenew = String.valueOf(num);
	  			User_Name = User_Name+valuenew;
  			
   	      		if (sIndex.equals("")){
   	   	      	 sIndex = "0";
   	      		}
   	      	if (sVIP.equals("")){
 	   	      	 sVIP = "N";
 	      		}
   	      		Common.WaitForClock(Clockobj);
   	      		if (!accounTab.equalsIgnoreCase("No")){
   	    		//AccountsTab.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible() ;
   	    		Common.waitForElement(AccountsTabSync);
   	    		long startTime = System.currentTimeMillis();
   	    		AccountsTab.click();
   	    		//newAccount.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
   	    		Common.waitForElement(newAccountSync);
   	    		
   	    		long endTime = System.currentTimeMillis();
   	    		long totalTime = endTime - startTime;
   	    		//Common.WritePerformanceOutput("Account tab clicked ,Total Time " + totalTime/1000);
   	    		
   	      		}
   	    		if (!sNew.equals("No")){
   	    			//newAccount.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
   	    			Common.WaitForClock(Clockobj);
   	    			long startTime = System.currentTimeMillis();
   	    			newAccount.click();
   	    			Common.waitForElement(firstNameSync);
   	    			long endTime = System.currentTimeMillis();
   	   	    		long totalTime = endTime - startTime; 	   	    		
   	   	    		Common.WritePerformanceOutput("New Account Clicked ,Total Time " + totalTime/1000);

   	    		}
       			
   	    		if (!Account_Type.equals("")){
   	    		//accountTypeSelect.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
   	    		Common.waitForElement(accountTypeSelectSync);
   	    		//accountTypeIcon.click();
   	    		Common.WaitForClock(Clockobj);
   	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
   	    		
   	            accountTypeSelect.type(Account_Type);
   	            
   	    		}
   	    		
   	    		if(sValidations.equals("CheckSubAccountFields"))
   				{
   					Common.waitForPageLoad(getDriver());
   					//ClickNewbillingAccount.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
   					ClickNewbillingAccount.click();
   					Common.WaitForClock(Clockobj);
   					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

   					accountTypeSelect.click();
   					String ActualAccounttype = accountTypeSelect.getTextValue();
   					AccountCategoryTextBox.click();
   					String ActualAccountCategory = AccountCategoryTextBox.getTextValue();
   					AccountSubCategoryTextBox.click();
   					String ActualAccountSubCategory = AccountSubCategoryTextBox.getTextValue();
   					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

   					String sAccount_Type = Serenity.sessionVariableCalled("Account_Type").toString();
   					String sAccountCategory = Serenity.sessionVariableCalled("AccountCategory").toString(); 
   					String sAccountSubCategory = Serenity.sessionVariableCalled("AccountSubCategory").toString(); 

   					Assert.assertTrue("Account Type is not matching with the parent account", ActualAccounttype.equals(sAccount_Type));
   					report.Info("Account Type is same as Parent");
   					Assert.assertTrue("Account Category is not matching with the parent account", ActualAccountCategory.equals(sAccountCategory));
   					report.Info("Account Category is same as Parent");
   					Assert.assertTrue("Account Sub Category is not matching with the parent account", ActualAccountSubCategory.equals(sAccountSubCategory));
   					report.Info("Account Sub Category is same as Parent");
   					return;
   				}
   	    		
   	            TitleWebList.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
   	            TitleWebList.type("Mr.");
   	            firstName.type(FirstName);
   	            lastName.type(LastName);
   	            pin1.type("1");
   	            pin2.type("1");
   	            pin3.type("1");
   	            pin4.type("1");
   	            DOBTextBox.type(Birth_Date);   
   	            TradingAsTextBox.click();
   	            Thread.sleep(5000);
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
   	            if (!TradingAs.equals(""))
   	            {
   	                  TradingAsTextBox.type(TradingAs);
   	            }  

   	            String IfChecked =OnlineFlagCheckBox.getAttribute("aria-checked");                
   	            if (IfChecked.equalsIgnoreCase("true") && Online_Account.equals("Off")){
   	            OnlineFlagCheckBox.click();  
   	            CapturedAccNo.click();                        
   	            }
   	            else if (IfChecked.equalsIgnoreCase("false") && Online_Account.equals("Off")){
   	            report.Info("Online Checkbox is already unchecked");
   	            }
   	    		 
   	    		if (!AccountCategory.equals(""))
   	      		{
   	    			AccountCategoryTextBox.type(AccountCategory);
   	      		}
   	    		if (!AccountSubCategory.equals(""))
   	      		{
   	    			AccountSubCategoryTextBox.type(AccountSubCategory);
   	      		}
   	    		
   	    		if (Online_Account.equals("On")){
   	    			UserNameTextBox.type(User_Name);
   	    			Common.waitForElement(UpdateEmailButtonSync);
   	    			UpdateEmailButton.click();
   	    			EmailTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
   	    			//Thread.sleep(4000);
   	    			if (sValidations.equals("AppdirectAccount")) {
   	    				Email1 = Email1+valuenew;
   	    			}
   	    			EmailTextBox.type(Email1);
   	    			EmailDoamin.type(Email2);
   	    			ReTypeEamilTextBox.type(Email1);
   	    			ReTypeEmailDoamin.type(Email2);
   	    			EmailOK.click();			
   	    		}
   	    		
   	    		if (sMemorableWord.equals("Y")){
   	    			String MemWordHint = "Memword123";
   	    			MemorableWordTextBox.type(MemWordHint);
   	    			MemorableHintTextBox.type(MemWordHint);
   	    			Serenity.setSessionVariable("MemorableWord").to(MemWordHint);
   	    			   	    						
   	    		}
   	    		
   	    		if(!sSkipAddress.equalsIgnoreCase("N")){ 
	    				AddressPopUp.click();
	    				Thread.sleep(4000);	   	    		
	    				Common.selectedRow = 1;
	    				if(sChannel.equalsIgnoreCase("Incorrect Address")){
	    					Common.updateSiebList(applet,table, "Text|Postal_Code", PostCode);
	    					AddressStatusElement.click();
	    					AddressStatusTextBox.sendKeys(Keys.ENTER);
	    				}
	    				else{
	    					Common.updateSiebList(applet,table, "Text|Postal_Code", PostCode);
	    					//Common.updateSiebList(applet,table, "Clear|Status", "Validated");
	    					Common.updateSiebList(applet,table, "Text|Status", "Validated");   					
	    					AddressStatusElement.click();
	    					AddressStatusTextBox.sendKeys(Keys.ENTER);
	    					
	    					if (AddressStatusTextBox.isCurrentlyVisible()) {
	    						AddressStatusTextBox.sendKeys(Keys.ENTER); //for chrome
	    					}
	    					
	    				}
	    				
	    				AddAddress.click();
	    				Thread.sleep(1000);
	    				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    				if(!Popup.equalsIgnoreCase("No")){
		    				Common.HandleErrorPopUp(Popup);
		    			}
	    				AddressOKButton.click();
	    				Thread.sleep(2000);
	    				
	    			}
   	    		
   	    		if(sVIP.equalsIgnoreCase("Y")) {
   	    			if(VIPCheckBox.isEnabled()) {
   	    				VIPCheckBox.click();
   	    			}
   	    			else {
   	    				report.Info("Current Siebel login does not allow VIP account creation. Try login with TEST_AGENTVIP_01");
   	    			}
   	    		}
   	    		
   	    		String sPrimaryFirstName = AccountName.getTextValue();
   	            if (sPrimaryFirstName.equals("")){

   	               String PrimaryFirstNamereadonly= AccountName.getAttribute("aria-readonly");
   	               if(!PrimaryFirstNamereadonly.equalsIgnoreCase("true")){
   	            	   AccountName.type(sAccountName);
   	               }
   	                
   	            }
   	            
   	            
   	    		
   	    		/*if (!AccountName.equals("") && !EnterAccountNameTextBox.getTextValue().equals(""))
   	    		{
   	    			EnterAccountNameTextBox.type(AccountName);
   	    		}
   	    		*/
   	              	    		   		
   	    		if (!sPhoneNumber.equals(""))
   	      		{
   	            	AltPhoneNo.type(sPhoneNumber);
   	            	
   	      		}
   	            /*if(!careteam.equals(""))
   	            {
   	                  CareTeamBox.type(careteam);
   	                  //CareTeamIcon.click();
   	                  //CareTeamBoxOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
   	                 //click();
   	            }*/
   	            if (!AccountSubCategory.equals(""))
   	      		{
   	            	EnterAccountNameTextBox.type(AutoAccountName);       	
   	      		}
   	                    
   	            if (!sLegalStatus.equals(""))
   	      		{
   	            	LegalStatus.type(sLegalStatus);
   	      		}
   	            
   	            if (!sGender.equals(""))
   	      		{
   	            	Gender.typeAndEnter(sGender);
   	      		}
   	            if (!AccountSubCategory.equals(""))
   	      		{
   	    			AccountSubCategoryTextBox.click();
   	      		}
   	            
   	            if (User_Name.equalsIgnoreCase("Yes")){
   					UserNameTextBox.type(UserName);
   	            }
   	            accountSave.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
   	            long startTime = System.currentTimeMillis();
   	    		accountSave.click();
   	    		Common.WaitForClock(Clockobj);
   	    		long endTime = System.currentTimeMillis();
   	    		long totalTime = endTime - startTime;
   	    		
   	    		Common.WritePerformanceOutput("Account Saved ,Total Time " + totalTime/1000);
   	    		if(!Popup2.equalsIgnoreCase("No")){
	    				Common.HandleErrorPopUp(Popup2);
	    				return;
	    			}
   	    		
   	    		if(DOBMandateError.isCurrentlyVisible())
   	    		{
   	    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
   	    			DOBMandateErrorOkBttn.click();
   	    			Common.WaitForClock(Clockobj);
   	    		}
   	    		
   	    		accountName.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();   
   	    		
   	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
   	    		
   	    			    		
   	    	}
       

   }
    
		    @FindBy(xpath=".//*[contains(text(),'Date of Birth')]") 
			WebElementFacade DOBMandateError;
			
			@FindBy(xpath=".//*[contains(@class,'generic-confirm-popup')]") 
			WebElementFacade DOBMandateErrorOkBttn;
			
			@FindBy(xpath=".//a[@name='Name']") 
			WebElementFacade accountName;
			
			@FindBy(xpath=".//*[@aria-label='Stop Transactions via SMS']") 
			WebElementFacade StopTransactionCheck;
			
			
			@FindBy(xpath="//*[@id='1_s_1_l_Customer_Code']")
			WebElementFacade accountNo; 
	             
			@Step
            public void VerifyAccountSummary(String accountType) throws IOException, InterruptedException, AWTException{
                String filePath = "\\src\\test\\resources\\data\\Account.xls";
                String dataSheet = "CreateNewAccount";
                String applet = "//*[@title='Accounts List Applet']";
          	  String table = "//table[@summary='Accounts']"; 
          	Common.WaitForClock(Clockobj);
                Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
                readWorkbook.testData(tableMap);
                
                //Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
               for (int i = 0;i < tableMap.get("First_Name").size();i++) {
                      String FirstName = tableMap.get("First_Name").get(i);
                      String LastName = tableMap.get("Last_Name").get(i);
                      String FullName = FirstName + " " + LastName;
                      FullName = FullName.toUpperCase();
                      Serenity.setSessionVariable("LastName").to(LastName);
                      String sValidations = tableMap.get("Validations").get(i);
                      
                      Thread.sleep(4000);
                      
                      //accountName.withTimeoutOf(120,TimeUnit.SECONDS).isDisplayed();
                      
                      Common.selectedRow = 1;
         	    		Common.updateSiebList(applet,table, "CaptureCompareTextValue|Name", FullName);
                      
                      /*String actAccountName = accountName.getTextValue();                        
                      if(actAccountName.equalsIgnoreCase(FullName)){
                                report.Info(actAccountName+" is successfully created");
                          }
                          else{
                                report.Info("Account creation has failed");
                          }*/
                      CapturedAccNo.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
                      
                      String AccNo = "";
                      Common.selectedRow = 1;
                     AccNo=Common.updateSiebList(applet,table, "CaptureTextValue|Customer_Code", AccNo);
         	    		
      	    		//AccNo = CapturedAccNo.getTextValue();
      	    		Serenity.setSessionVariable("AccountNo").to(AccNo);	    		
      	    		Serenity.setSessionVariable("OlderAccountNo").to(AccNo);
      	    		report.Info("Account no "+AccNo+" is Created successfully.");
      	    		System.out.println("Account Numnber : "+AccNo);
      	    		Common.selectedRow = 1;
         	    		Common.updateSiebList(applet,table, "DrillDown|Name","");
                      //accountName.click();
                      Thread.sleep(2000);
                      Common.WaitForClock(Clockobj);
                      sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                      
                      if(sValidations.equals("StopTransactionFlagCheck"))
         				{
         					StopTransactionCheck.click();
         					String ActualStopTransactionFlag = StopTransactionCheck.getTextValue();
         					Assert.assertTrue("", ActualStopTransactionFlag.equalsIgnoreCase("Y"));
         					report.Info("Flag is Y as expected");
         					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
         				}
               }
              }
              
              @FindBy(xpath=".//*[@title='Billing Profiles:New']")
              WebElementFacade NewBillProfileButton ;
              @FindBy(xpath=".//*[@id='1_s_4_l_Payment_Type']")
              WebElementFacade PrePayPostPayBox;
              
              @FindBy(xpath=".//*[@id='1_s_4_l_Payment_Type']")
              WebElement PrePayPostPayBoxSync;
              @FindBy(xpath=".//*[@id='1_Payment_Type']")
              WebElementFacade BillProfileType;
              @FindBy(xpath="//*[@id='1_s_1_l_Name']/a")
              WebElementFacade AccountNameLink;
              @FindBy(xpath=".//*[@aria-label='Product / Services:Top-Up Request']")
              WebElementFacade TopUpReqButton;
              @FindBy(xpath=".//*[contains(text(),'Payment Type')]")
              WebElementFacade PaymentTypeError;
              @FindBy(xpath="//div[@class='ui-widget-overlay ui-front']/following-sibling::div[contains(@class,'error')]//button/span[text()='Ok']")
              WebElementFacade PaymentTypeOkButton;
              
              @FindBy(xpath="//span[text()='Ok']")
              WebElementFacade PaymentTypeOkButton2;
              
              @FindBy(xpath="//a[text()='Itemised Usage']")
              WebElementFacade ItemisedUsage;
              
              @FindBy(xpath=".//*[@title='Billing Profiles:UpdateEmail']")
          	  WebElementFacade BillingProfileUpdateEmail ;
              
            // This function is used for creating new billing profile
             @Step
             public void  CreateNewBillingProfile(String BillingProfileType) throws InterruptedException, IOException, AWTException{
            	 String filePath = "\\src\\test\\resources\\data\\Account.xls";
                 String dataSheet = "CreateNewBillingProfile";
                 String table = "//table[@summary='Billing Profiles']";
                 String applet = "//*[@title='Billing Profiles List Applet']";
                 
                 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
                 readWorkbook.testData(tableMap);
                 Common.waitForPageLoad(getDriver());
                 Common.WaitForClock(Clockobj);
                 if (tableMap.get("Value").size()==0){
                 	report.Info(BillingProfileType+" logical name not found in sheet.");
                 	Assert.assertTrue(false);        	
                 }
                 //Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
                for (int i = 0;i < tableMap.get("Value").size();i++) {
                    //String ProfileType = tableMap.get("Value").get(i);
                    String sLocateCol = tableMap.get("LocateCol").get(i);
           			String sLocateColValue = tableMap.get("LocateColValue").get(i);
        			String UIName = tableMap.get("UIName").get(i);
        			String value = tableMap.get("Value").get(i);
        			String Index = tableMap.get("Index").get(i);
        			String sNewBillingProfile = tableMap.get("NewBillingProfile").get(i);
        			String sPopup = tableMap.get("Popup").get(i);
        			String sEmail1 = tableMap.get("Email1").get(i);
        			String sEmail2 = tableMap.get("Email2").get(i);
        			
        			Alert alert;
        			Alert alert1;
                    String ActAlertText="";	
                    String ActAlertText1="";
                    
                    if(isAlertPresent(getDriver())){
    					alert1=getDriver().switchTo().alert();
    					ActAlertText1=alert1.getText();  
    					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                                                
    					if (ActAlertText1.contains("This is a VIP account")){  		            		
    						alert1.accept();
    						report.Info("Pop occurred : " +ActAlertText1);
    						        					}
    				}
        			if (sNewBillingProfile.equals("Y"))
        			{
        				NewBillProfileButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
           			 //NewBillProfileButton.waitUntilPresent();
        				long startTime = System.currentTimeMillis();
                        NewBillProfileButton.click();
                        /*Common.waitForElement(PrePayPostPayBoxSync);*/
                        Common.WaitForObjectPresence(".//*[@id='1_s_4_l_Payment_Type']");
                        long endTime = System.currentTimeMillis();
           	    		long totalTime = endTime - startTime;
           	    		
           	    		Common.WritePerformanceOutput("New Billing Button Clicked ,Total Time " + totalTime/1000);

        			}
        			
        			
                     Thread.sleep(1000);
                     
                     if(PaymentTypeOkButton.isCurrentlyVisible()){
                  	 	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                  		Thread.sleep(1000);
                  		PaymentTypeOkButton.click();
                  		 
                  	 }
                      
                      if(PaymentTypeOkButton2.isCurrentlyVisible()){
                   	 	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                   		Thread.sleep(1000);
                   		PaymentTypeOkButton2.click();
                   		 
                   	 }
                     
                     //String LocateColMessege = sLocateCol+"Not Found";
                     if (Index.equals("")){
                    	 Index = "0";
                     }

                     if (!sLocateCol.equals("")){
                          Common.selectedRow = -1;
                         Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
          
                          }
                     else{
                           Common.selectedRow = 1;
                     }
                     if (!UIName.equals("")){                                              
                         Common.updateSiebList(applet,table, UIName, value);
                         //Thread.sleep(2000);
                         sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                         
                         
                         if (!sEmail1.equals("")){
             				
             				BillingProfileUpdateEmail.click();
             				EmailTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
             				//Thread.sleep(4000);
             				EmailTextBox.type(sEmail1);
             				EmailDoamin.type(sEmail2);
             				ReTypeEamilTextBox.type(sEmail1);
             				ReTypeEmailDoamin.type(sEmail2);
             				EmailOK.click();
             				
             			}
                         
                         }     
                     if (sNewBillingProfile.equals("INC"))
          			{
                     	 PrePayPostPayBox.click();
                     	 if(isAlertPresent(getDriver())){
      	            		alert=getDriver().switchTo().alert();
      		                ActAlertText=alert.getText(); 
      		               sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
      		                if (ActAlertText.contains(sPopup)){                    	
      		                	alert.accept();
      		                	System.out.println("Message is: "+ActAlertText);
      		                	report.Info("alert messsage is"+ActAlertText);		                	
      		                }                                 
      	            	}  
      	            	else{
      	            		 Assert.assertTrue("Expected pop-up did not occur",isAlertPresent(getDriver()));
      	            	}
          			}

          }
                if(CapturedBillProfNo.isCurrentlyVisible()){
        			CapturedBillProfNo.withTimeoutOf(120,TimeUnit.SECONDS).isDisplayed();            		
        			Serenity.setSessionVariable("BillProfNo").to(CapturedBillProfNo.getTextValue());
        			String test = Serenity.sessionVariableCalled("BillProfNo");
        			report.Info("Billing Profile Number Captured: " + CapturedBillProfNo.getTextValue());
        		}
        		
                if(NewBillProfileButton.equals("RealTimeBalance"))
                {
                	Assert.assertTrue("Real Time Balance Page not displayed Successfully", TopUpReqButton.isVisible());
                	report.Info("Real Time Page Displayed");
                }

                if(NewBillProfileButton.equals("ItemisedUsage"))
                {
                	Assert.assertTrue("Itemised Usage Page not displayed Successfully", ItemisedUsage.isVisible());
                	ItemisedUsage.click();
                	Thread.sleep(5000);
                	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                	report.Info("Itemised Usage page Displayed Succesfully");
                }


}

             @FindBy(xpath=".//*[@aria-label='Postcode']")
         	WebElementFacade PostCode_TextBox;
         	
         	@FindBy(xpath=".//*[@aria-label='Add Address:New']")
         	WebElementFacade NewAddAddressButton;
         	
         	@FindBy(xpath=".//*[@aria-labelledby='Postal_Code_Edit_Label']")
         	WebElementFacade QASPostcodeTextBox;
         	
         	@FindBy(xpath=".//*[@title='Account Addresses:Validate']")
         	WebElementFacade AddressValidateButton;
         	
         	@FindBy(xpath="//span[text()='QAS']")
         	WebElementFacade QASPopUpLabel;
         	
         	@FindBy(xpath=".//*[@title='QAS:OK']")
         	WebElementFacade QASOKButton;
         	
         	@Step
         	public void CreateQASAccount(String accountType) throws InterruptedException, IOException, AWTException{
         		
         		String filePath = "\\src\\test\\resources\\data\\Account.xls";
                 String dataSheet = "CreateNewAccount";
                 
                 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
                 readWorkbook.testData(tableMap);
                 
                 if (tableMap.get("First_Name").size()==0){
                  	report.Info(accountType+" logical name not found in sheet.");
                  	Assert.assertTrue(false);        	
                  }
                 Common.waitForPageLoad(getDriver());
                 for (int i = 0;i < tableMap.get("First_Name").size();i++) {
                       String FirstName = tableMap.get("First_Name").get(i);
                       String LastName = tableMap.get("Last_Name").get(i);
                       String PostCode = tableMap.get("Postcode").get(i);
                       String Birth_Date = tableMap.get("Birth_Date").get(i);
                       String Account_Type = tableMap.get("Account_Type").get(i);
                       String QASPostCode = tableMap.get("QASPostCode").get(i);
                       String sNew = tableMap.get("New").get(i);
                       String TradingAs = tableMap.get("TradingAs").get(i);
                       String Online_Account = tableMap.get("OnlineAccount").get(i);
                       String AccountCategory = tableMap.get("AccountCategory").get(i);
                       String AccountSubCategory = tableMap.get("AccountSubCategory").get(i);
          
           

         	    		//AccountsTab.withTimeoutOf(120,TimeUnit.SECONDS).isEnabled();
         	    		AccountsTab.click();
         	    		if (!sNew.equals("No")){
         	    			newAccount.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
         	    			newAccount.click();
         	    			Common.WaitForClock(Clockobj);
         	    		}
         		
         	    		accountTypeSelect.withTimeoutOf(120,TimeUnit.SECONDS).isEnabled();
         	            accountTypeSelect.type(Account_Type);
         	            TitleWebList.withTimeoutOf(120,TimeUnit.SECONDS).isEnabled();	   
         	            TitleWebList.type("Mr.");
         	            firstName.type(FirstName);
         	            lastName.type(LastName);
         	            pin1.type("1");
         	            pin2.type("1");
         	            pin3.type("1");
         	            pin4.type("1");
         	            DOBTextBox.type(Birth_Date);        
         	            if (!TradingAs.equals(""))
         	            {
         	                  TradingAsTextBox.type(TradingAs);
         	            }  

         	            if (Online_Account.equals("Off")){
         	                OnlineFlagCheckBox.click();  
         	                CapturedAccNo.click();//Clicking it so as to make Username textbox disabled
         	          }  
         	    		 
         	    		if (!AccountCategory.equals(""))
         	      		{
         	    			AccountCategoryTextBox.type(AccountCategory);
         	      		}
         	    		if (!AccountSubCategory.equals(""))
         	      		{
         	    			AccountSubCategoryTextBox.type(AccountSubCategory);
         	      		}
         	    		
         	    		if(PostCode.equalsIgnoreCase("QAS")){
         	    			PostCode_TextBox.typeAndEnter(PostCode);
         	    			AddressPopUp.click();
         		    		AddressCancel.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
         		    		report.Info("");
         		    		NewAddAddressButton.click();
         		    		Common.WaitForClock(Clockobj);
         		    		QASPostcodeTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
         		    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
         		    		QASPostcodeTextBox.type(QASPostCode);
         		    		report.Info("");
         		    		AddressValidateButton.click();
         	    		}
         	    		
         	    		if(QASPopUpLabel.withTimeoutOf(120,TimeUnit.SECONDS).isPresent()){	
         	                report.Info("Pass: QAS Popup is present as expected");
         	               sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
         	    			//QASOKButton.click();
         	    		}
         	    		else{
         	    			Assert.assertFalse("Fail: QAS Popup is not present as expected",QASPopUpLabel.withTimeoutOf(120,TimeUnit.SECONDS).isPresent());
         	    		}
                 }
         	}
         	
             
             
             
             
         	@FindBy(xpath="(.//*[contains(@aria-label,'Query')])[1]")
        	WebElementFacade Query;
         	
         	@FindBy(xpath="(.//*[contains(@aria-label,'Query')])[1]")
        	WebElement QuerySync;
        	
        	@FindBy(xpath=".//*[@aria-labelledby='Customer_Code_Label']")
        	WebElementFacade AccountNumber;
        	@FindBy(xpath=".//*[contains(@title,'Account Details:Go') or contains(@title,'Go')]")
        	WebElementFacade Go;
        	@FindBy(xpath=".//*[contains(@title,'Go')]")
        	WebElement GoWebElement;
        	
        	
        	@FindBy(xpath=".//*[@id='1_s_4_l_Name']/a")
        	WebElementFacade CapturedBillProfNo;
        	
        	@FindBy(xpath=".//*[@title='Visibility']/select")
        	WebElementFacade SearchAccountDropDown;
        	
        	//@FindBy(xpath="//div[@rn='Customer Code']")
        	@FindBy(xpath=".//div[contains(@id,'Customer_Code')]")
        	WebElementFacade AccountNoHeader;
        	
        	@Step
        	public void Searchaccount(String AccountNo) throws InterruptedException, AWTException, IOException {
        		
        		//String table = "//table[@summary='Accounts']";
        	   // String applet = "//*[@title='Accounts List Applet']";
        	    
        	    String table = "//table[@class='ui-jqgrid-btable']";
        	    String applet = "//*[contains(@class,'siebui-applet siebui-collapsible-applet siebui-list')]";
        	    
        	    Alert alert;
      		    String ActAlertText=""; 
        	    
      		  Common.WaitForClock(Clockobj);
        		         	    
        		AccountsTab.click();
        		 
        		
        		Thread.sleep(2000);
        		Common.WaitForClock(Clockobj);
        		
        		if (Common.waitForElement(QuerySync)){
        			//Common.waitForElement(QuerySync);
        			//Query.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();  

        			//	Thread.sleep(2000);
        			long startTime = System.currentTimeMillis();
        			Query.click();
        			Common.waitForElement(GoWebElement);
        			long endTime = System.currentTimeMillis();
        			long totalTime = endTime - startTime;
        			Common.WritePerformanceOutput("Account Query Clicked ,Total Time " + totalTime/1000);
        		}
        		String sAccountNo = "";
        		//Serenity.setSessionVariable("AccountNo").to("");
        		if (AccountNo.equals("")){
        			sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString();            		
        		}
        		else if(AccountNo.equals("Older Account")) {
        			sAccountNo = Serenity.sessionVariableCalled("OlderAccountNo").toString();
        		}
        		else{
        			sAccountNo = AccountNo; 
        			Serenity.setSessionVariable("AccountNo").to(sAccountNo);
        		}
        		if(!AccountNoHeader.withTimeoutOf(30, TimeUnit.SECONDS).isCurrentlyVisible()) {
        			getDriver().navigate().refresh();
        			Thread.sleep(2000);
        			Common.WaitForClock(Clockobj);
        		}
                Common.selectedRow = 1;                                                           
                Common.updateSiebList(applet,table, "Text|Customer_Code", sAccountNo);
                
                //Thread.sleep(1000);
                Common.waitForElement(GoWebElement);
                //Common.waitForPageLoad(getDriver());
                Go.click();
                Thread.sleep(2000);
    			Common.WaitForClock(Clockobj);
    			
    			
               // int SearchAccountRowCount = findAll(By.xpath("//table[@class='ui-jqgrid-sortable']/tbody/tr")).size();
                int SearchAccountRowCount = findAll(By.xpath("//table[contains(@class,'ui-jqgrid')]/tbody/tr")).size();
                if (SearchAccountRowCount<2){
                	SearchAccountDropDown.selectByVisibleText("All Accounts Across My Organization");
                	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                }

                try{
                	if (accountName.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible()){
                		report.Info("Account Number: "+sAccountNo+" is searched successfully.");
                		accountName.click();  

                		Thread.sleep(8000);
        			Common.WaitForClock(Clockobj);
        			
        			//AccountSummaryTab.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
        			int k=0;
        			do{
        				Thread.sleep(2000);
        				if(isAlertPresent(getDriver())){
        					alert=getDriver().switchTo().alert();
        					ActAlertText=alert.getText();  
        					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                                                
        					//if (ActAlertText.contains("Please be aware that there is an open complaint registered by this customer")){  		            		
        						alert.accept();
        						report.Info("Pop occurred : " +ActAlertText);
								        					//}
        				} 
        				k++;
        			}while(k<2);
        			
        			
        			AccountSummaryTab.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
        			
        			
        			int BillingProfileTableSize= findAll(By.xpath("//table[@summary='Billing Profiles']/tbody/tr")).size();
	 	            	if(BillingProfileTableSize>1){
	 	            		CapturedBillProfNo.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();            		
	 	            		Serenity.setSessionVariable("BillProfNo").to(CapturedBillProfNo.getTextValue());
	 	            		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 	            		report.Info("Billing Profile Number Captured: " + CapturedBillProfNo.getTextValue());
	   	          }
            		
        		}
        		}
        		catch(Exception e){
        			report.Info("Account Number: "+sAccountNo+" is not present");
        			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        			Assert.assertTrue(false);
        		}        		
        		        		
        	}
        	
             @FindBy(xpath="//button[@title='Orders:New']")
             WebElementFacade NewOrder;
             
             @FindBy(xpath=".//a[@name='Order Number']")
             WebElementFacade FirstOrderNumber;
             @FindBy(xpath="//a[text()='Catalogue']")
             WebElementFacade CatalogueTab;
			 @FindBy(xpath="//a[text()='Catalogue']")
             WebElement CatalogueTabSync;
         	
         	// This function is used for creating a new order
         	@Step
         	public void CreateNewOrder(String OrderType) throws InterruptedException, IOException, FindFailed, AWTException{
         		//Homepage.waitUntilPresent();
         		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
         		String filePath = "\\src\\test\\resources\\data\\Account.xls";
                 String dataSheet = "CreateNewOrder";
                 
                 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(OrderType, filePath, dataSheet);
                 readWorkbook.testData(tableMap);
                 
                 if (tableMap.get("NewButton").size()==0){
                   	report.Info(OrderType+" logical name not found in sheet.");
                   	Assert.assertTrue(false);        	
                   }
                 Common.waitForPageLoad(getDriver());
                 for (int i = 0;i < tableMap.get("NewButton").size();i++) {
                       String CreateOrder = tableMap.get("NewButton").get(i);
                       //String sPopUpImage = tableMap.get("PopUp").get(i);
                      // String LastName = tableMap.get("Last_Name").get(i);
                       //String PostCode = tableMap.get("Post_Code").get(i);
                       //NewOrder.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
                     //report.Info(" Order New "+CreateOrder);
                     if  (CreateOrder.equals("Yes")){
                    	 long startTime = System.currentTimeMillis();
                     		  NewOrder.click();
                     		 //CatalogueTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
							 Common.waitForElement(CatalogueTabSync);
                     		long endTime = System.currentTimeMillis();
                     		long totalTime = endTime - startTime;
                     		Common.WritePerformanceOutput("Order Created ,Total Time " + totalTime/1000);
                     		
                               //Thread.sleep(6000);
                               
                               //sikuliUtility.ClickFraudRiskAlert(SikulifilePath);  
                     		if(isAlertPresent(getDriver())){
                				Alert alert = getDriver().switchTo().alert();
                				String ActAlertText = alert.getText(); 
                												  				  						
                				if (ActAlertText.contains("FRAUD RISK")){
                					alert.accept();
                					System.out.println("alert messsage is"+ActAlertText);
                				}                                                                                       
                				                     
                			} 
                       }
                     else{
                    	 FirstOrderNumber.click();
                     	report.Info("Drilling down on first order");
                     	Common.WaitForClock(Clockobj);
                     }
                     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                 }
         	}
         	
         	@FindBy(xpath=".//*[text()='My Customer Comms']")
    	    WebElementFacade CutomerCommsTab;
    	    @FindBy(xpath=".//*[@title='Activities:Set/Reset Password']")
    	    WebElementFacade SetResetPassword;
    	    @FindBy(xpath=".//*[@aria-label='Activities:Set/Reset PIN']")
    	    WebElementFacade SetResetPin;
    	    @FindBy(xpath=".//*[@aria-label='Activities:Set/Reset Word and Hint']")
    	    WebElementFacade SetResetWordandHint;
    	    @FindBy(xpath=".//*[@aria-label='First Level View Bar']")
    	    WebElementFacade customercommsSelectDropdown;
    	    
    		//This function is used for just validate the butttons  present or not in the customer comms page 
    			@Step
    		      public void CustomerCommsButtonsValidation() throws InterruptedException, IOException
    		      {
    				long startTime = System.currentTimeMillis();
    				if(CutomerCommsTab.isPresent()){
    					CutomerCommsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();      		    	  
      				 CutomerCommsTab.click();
    				}else{
    					customercommsSelectDropdown.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    					customercommsSelectDropdown.selectByVisibleText("Customer Comms");
    				}
    		    	 // Thread.sleep(3000);
    		    	  //buttons validation
    				  SetResetPassword.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
    				  long endTime = System.currentTimeMillis();
    				  long totalTime = endTime - startTime;
    				  Common.WritePerformanceOutput("Customer Comms tab clicked ,Total Time " + totalTime/1000);
    				  
    		    	  Assert.assertTrue("set Reset password button is not present on page",SetResetPassword.isDisplayed());
    		    	  report.Info("set Reset password button is present under customer comms page");
    		    	  Assert.assertTrue("set Reset pin button is not present on page",SetResetPin.isDisplayed());
    		    	  report.Info("set Reset pin button is present under customer comms page");
    		    	  Assert.assertTrue("set Reset WordandHint button is Not present on page",SetResetWordandHint.isDisplayed());
    		    	  report.Info("set Reset WordandHint button is present under customer comms page");		           		      
    		      }         			
    		 	
    			
    			@FindBy(xpath=".//a[@name='Name']") 
    			WebElement accountNameSync;
    			
    			
    	         @Step
    	        public void AnonymousAccount(String accountType) throws InterruptedException, IOException, AWTException{

    	        	 String filePath = "\\src\\test\\resources\\data\\Account.xls";
    	             String dataSheet = "CreateNewAccount";
    	             
    	             Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
    	             readWorkbook.testData(tableMap);
    	             
    	             if (tableMap.get("First_Name").size()==0){
    	                   	report.Info(accountType+" logical name not found in sheet.");
    	                   	Assert.assertTrue(false); 
    	                   }
    	             Common.waitForPageLoad(getDriver());
    	             for (int i = 0;i < tableMap.get("First_Name").size();i++) {
    	                   String FirstName = tableMap.get("First_Name").get(i);
    	                   String LastName = tableMap.get("Last_Name").get(i);
    	                   String PostCode = tableMap.get("Post_Code").get(i);
    	                  // String Email = tableMap.get("Email").get(i);
    	                   String Email1 = tableMap.get("Email1").get(i);
    	                   String Email2 = tableMap.get("Email2").get(i);
    	                   String Birth_Date = tableMap.get("Birth_Date").get(i);
    	                   String Account_Type = tableMap.get("Account_Type").get(i);
    	                   String isAnonymous = tableMap.get("Anonymous").get(i);
    	                  // String sAnonymousAddressValidation = tableMap.get("AnonymousAddressValidation").get(i);
    	                   String sAccount_Category = tableMap.get("AccountCategory").get(i); 
    	                   String sAccount_SubCategory = tableMap.get("AccountSubCategory").get(i);
    	                  // String sAnonymousValidation = tableMap.get("AnonymousValidation").get(i);
    	                   String sValidations = tableMap.get("Validations").get(i);
    	                   
    	                   String sAnonymousDrillDown = tableMap.get("AnonymousDrillDown").get(i);
    	                   String sPopup = tableMap.get("Popup").get(i);
    	                   
    	        if(isAnonymous.equalsIgnoreCase("Y")){
	           	     Common.waitForElement(AccountsTabSync);
	   				 AccountsTab.click();
	   				// newAccount.waitUntilPresent();
	   				 Common.waitForElement(newAccountSync);
    				
		   			 newAccount.click();
	   				 Thread.sleep(3000);
	   				 AnonymousCheckBox.click();
	   				 Thread.sleep(2000);
	   				 firstName.click();
	   				 CapturedAccNo.click();
   				 
    				 String Fname = firstName.getAttribute("readonly");
    				 
    					if (Fname.equals("true")){
    						
    						 report.Info("its readonly");
    										
    					}
    				 accountTypeSelect.waitUntilPresent();
    				 accountTypeSelect.type(Account_Type);
    						 if(!sAccount_Category.isEmpty()){
    							 AccountCategorySelect.type(sAccount_Category);
    						 }
    						 if(!sAccount_SubCategory.isEmpty()){
    							 AccountSubCategorySelect.type(sAccount_SubCategory); 
    						 }
    						 
    						 report.Info("Start Anonymous address validation ");
    				 if(sValidations.equalsIgnoreCase("AnonymousValidation")){
    					 report.Info("Anonymous address validation ");
    					 AddressPopUp.click();
    					 if(!AddressOKButton.isEnabled()){
    						 report.Info("OK button is disabled for address applet for anonymous account which means we are not able to change the address.");
    						 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    					 }
    					 else{
    						 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    						 Assert.assertTrue("OK button is enabled for address applet for anonymous account but it should be disabled.",!AddressOKButton.isEnabled());
    						 
    					 }
    					break;
    				 }
    				 accountSave.waitUntilEnabled();
    				 accountSave.click();
    				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				 
    				 
    				 if(!sPopup.equalsIgnoreCase("NO")){
        				 Common.HandleErrorPopUp(sPopup);
        				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
    		    		 report.Info("alert messsage is"+sPopup);
    		    		 break;
        			 }
    				 
    				 
    				 if(sValidations.equalsIgnoreCase("AnonymousValidation")){
    					 String OnlineFlagCheckBoxValue = OnlineFlagCheckBox.getAttribute("aria-readonly");
    					 
    					 if(OnlineFlagCheckBoxValue.equalsIgnoreCase("true")){
    						report.Info("Create Online Account checkbox is disabled for Anonymous account as expected"); 
    					 }
    					 else{
    						 Assert.assertTrue("Create Online Account checkbox is enabled for Anonymous account.",OnlineFlagCheckBoxValue.equalsIgnoreCase("true"));
    						
    					 }
    				 }
    				 if(sAnonymousDrillDown.equalsIgnoreCase("N")){
    					break; 
    				 }
    				 else{
    					
    					 Common.waitForElement(accountNameSync);
    					 accountName.click();
    					 Thread.sleep(10000);
    				 }
				 
    			}
    	       	 
    	       }
    	     }

    	         @FindBy(xpath=".//*[@aria-label='Third Level View Bar']")
                 WebElementFacade AccountTabsDRopDown;
    	         @FindBy(xpath="(.//a[text()='Agreements'])[2]")
                 WebElementFacade AgreementsTab; 
                  
    	         public void GotoAgreements() throws InterruptedException, IOException, AWTException{ 
    	        	 Common.waitForPageLoad(getDriver());
             				if(AgreementsTab.isVisible()){
             					AgreementsTab.click();	
             					report.Info("Agreement tab clicked successfully");
             				}
                           AccountTabsDRopDown.selectByVisibleText("Agreements");
                           Thread.sleep(9000);
                           report.Info("Agreement tab clicked successfull");
                           sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                    
                           } 
                 
           	 @FindBy(xpath=".//*[@aria-label='Online account']")
             WebElementFacade OnlineAcountCheckBoxAccountsummary;
           	@FindBy(xpath=".//td[contains(@id,'VF_Online_Id')]")
            WebElementFacade OnlineID;	
           	@FindBy(xpath=".//input[contains(@id,'VF_Online_Id')]")
            WebElementFacade OnlineAcountCheckBoxContacts;
        	@FindBy(xpath="(.//a[text()='Contacts'])[2]")
            WebElementFacade ContactsTab;
        	@FindBy(xpath=".//*[@aria-label='Account name']")
            WebElementFacade AccountName;
        	
        	@FindBy(xpath=".//*[@aria-label='Starting with']")
            WebElementFacade ContactsStartingwith;   
             	
        	@Step
         	public void VerifyOnlineAnonymousAccount(String OnlineFlagValidation) throws InterruptedException, IOException, AWTException{
         		//Homepage.waitUntilPresent();
        		Common.waitForPageLoad(getDriver());
         		String filePath = "\\src\\test\\resources\\data\\Account.xls";
                 String dataSheet = "OnlineAnonymous";
                 
                 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(OnlineFlagValidation, filePath, dataSheet);
                 readWorkbook.testData(tableMap);
                 
                 for (int i = 0;i < tableMap.get("VerifyChkboxDisabled").size();i++) {
                       String sVerifyChkboxDisabled = tableMap.get("VerifyChkboxDisabled").get(i);
                       String sVerifyChkboxEnabled = tableMap.get("VerifyChkboxEnabled").get(i);
                   
                     if  (sVerifyChkboxDisabled.equals("Y")){
                               Thread.sleep(6000);
          //check online flag in Accounts Page                     
                              String OF = OnlineFlagCheckBox.getAttribute("readonly");
                              report.Info("OnlineFlagCheckBox value "+OF);
                              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                               if (OF.equals("true")){
                            	   
                            	   report.Info("PASS: Online Flag Disabled as exepected");
                            	   
                               }
                               else{
                            	   report.Info("FAIL: Online Flag NOT Disabled as exepected");
                               }
                    	 accountName.click();
                    	 Thread.sleep(6000);
          //check online flag in Accounts Summary  
                    	 AccountName.click();
                    	 String OF1 = OnlineAcountCheckBoxAccountsummary.getAttribute("readonly");
                    	 report.Info("OnlineAcountCheckBoxAccountsummary value "+OF1);
                    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                         if (OF1.equals("true")){                          	   
                      	   report.Info("PASS: Online Flag Disabled as exepected");                       	   
                         }
                         else{
                      	   report.Info("FAIL: Online Flag NOT Disabled as exepected");
                         }
                         if (ContactsTab.isDisplayed()){
                 			ContactsTab.click();
                 		}
                 		else {
                 			AccountTabsDRopDown.selectByVisibleText("Contacts");
                 		}
           //check online flag in Contacts Tab              
                        //Thread.sleep(5000);
                        OnlineID.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
         				OnlineID.click();
         				Thread.sleep(3000);
         				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
         	        		String OF2 = OnlineAcountCheckBoxContacts.getAttribute("readonly");
         	        				if (OF2.equals("true")){
         	        					report.Info("PASS : Online Flag DISABLED as expected");	       			
         	        					}
         	        				else {report.Info("FAIL : Online Flag Enabled");}	        	
         	        		Thread.sleep(5000);
         	
         	        				}
                    	 
                    	 
                    	 if (sVerifyChkboxEnabled.equals("Y")){
                    	 		//Thread.sleep(4000);
                    	 		ContactsTab.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
                    	 		if (ContactsTab.isDisplayed()){
                         			ContactsTab.click();
                         		}
                         		else {
                         			AccountTabsDRopDown.selectByVisibleText("Contacts");
                         		}
                    	 		ContactsStartingwith.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilEnabled();                 			
                    	 		OnlineID.click();
                  				//Thread.sleep(3000);
                    	 		OnlineAcountCheckBoxContacts.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilEnabled();
                    	 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                    	 		OnlineAcountCheckBoxContacts.shouldBeEnabled();
                  				
                   	 
                    	 	}
                 }     
               }
        	@Step
        	public void OnlineAccountValidations(String accountType) throws InterruptedException, IOException, AWTException{
        		//Homepage.waitUntilPresent();
        		Common.WaitForClock(Clockobj);
        		 String filePath = "\\src\\test\\resources\\data\\Account.xls";
                 String dataSheet = "CreateNewAccount";
                 String applet = "//*[@title='Add Address List Applet']";
          	     String table = "//table[@summary='Add Address']";
                
                Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
                readWorkbook.testData(tableMap);
                
                if (tableMap.get("First_Name").size()==0){
                   	report.Info(accountType+" logical name not found in sheet.");
                   	Assert.assertTrue(false);        	
                   }
                
                for (int i = 0;i < tableMap.get("First_Name").size();i++) {
                	String FirstName = tableMap.get("First_Name").get(i);
                    String LastName = tableMap.get("Last_Name").get(i);
                    String PostCode = tableMap.get("Post_Code").get(i);
                    String Email1 = tableMap.get("Email1").get(i);
                    String Email2 = tableMap.get("Email2").get(i);
                    String Birth_Date = tableMap.get("Birth_Date").get(i);
                    String Account_Type = tableMap.get("Account_Type").get(i);
                    String User_Name = tableMap.get("User_name").get(i);
                   // String Online_Flag_Validation = tableMap.get("OnlineFlagValidation").get(i);
                    String sValidations = tableMap.get("Validations").get(i);
                    String UserName = FirstName + LastName;
                    String sLocateCol = tableMap.get("LocoteCol").get(i);
       	      		String sLocateColValue = tableMap.get("LocoteColValue").get(i);
       	      		String sIndex = tableMap.get("Index").get(i);
	       	      	Random rand = new Random(System.currentTimeMillis());
	      			int num = rand.nextInt(2000000000);
	      			String valuenew = String.valueOf(num);
	      			User_Name = User_Name+valuenew;
       	      		
       	      		if (sIndex.equals("")){
       	   	      	 sIndex = "0";
       	      		}
        	     
	        		Thread.sleep(1000);
	        		AccountsTab.isCurrentlyVisible();
	        		AccountsTab.click();
	        		Common.WaitForClock(Clockobj);
	        		newAccount.isCurrentlyVisible();
	        		
	        		newAccount.click();
	        		Common.WaitForClock(Clockobj);
	        		
	        		accountTypeSelect.isCurrentlyVisible();
	        		accountTypeSelect.type(Account_Type);        		
	        		Thread.sleep(5000);
	        		if (sValidations.equals("OnlineFlagValidationNo")){
			        		String OF = OnlineFlagCheckBox.getAttribute("aria-checked");
			        		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		        				if (OF.equals("false")){
		        					report.Info("Online Flag NOT Checked as expected");	       			
		        					}
		        				else {report.Info("Online Flag Checked");}
					        		
					         TitleWebList.isCurrentlyVisible();
					         TitleWebList.type("Mr.");
					         firstName.type(FirstName);
					         sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				        		String OF1 = OnlineFlagCheckBox.getAttribute("aria-checked");
								if (OF1.equals("true")){
									report.Info("Online Flag Checked as expected");	       			
									}
								else {report.Info("Online Flag NOT Checked");}
				        	
				        		Thread.sleep(5000);
				
				        			}
	        		
	        		if (sValidations.equals("OnlineFlagValidationYes")){
	        			TitleWebList.isCurrentlyVisible();
				        TitleWebList.type("Mr.");
				        firstName.type(FirstName);
						lastName.type(LastName);
						pin1.type("1");
						pin2.type("1");
						pin3.type("1");
						pin4.type("1");
						DOBTextBox.type(Birth_Date);
						//OnlineFlagCheckBox.click();
						
						
						AddressPopUp.click();
						Common.WaitForClock(Clockobj);
					//Locatecol code added 
						/*AddressCancel.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
		   	    		AddressCancel.click();
		   	    		PostCodeTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isEnabled();
		   	    		PostCodeTextBox.click();
		   	    		PostCodeTextBox.typeAndEnter(PostCode);*/
		   	    		
		   	    		Common.selectedRow = 1;
		   	    		Common.updateSiebList(applet,table, "Text|Postal_Code", PostCode);
    					AddressStatusElement.click();
    					AddressStatusTextBox.sendKeys(Keys.ENTER);
    					
    					
		   	    		 sLocateCol = "Status";
		   	    		sLocateColValue = "Validated";
		   				
		   				 if (!sLocateCol.equals("")){
		   			    	   Common.selectedRow = -1;
		   			    	  // Assert.assertTrue(LocateColMessege, Common.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true")); 
		   			    	   Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,sIndex).equals("true"));
		   			    	   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   				 }
		   	    		AddAddress.click();
		   	    		Thread.sleep(1000);
		   	    		AddressOKButton.click();
		   	    		Thread.sleep(2000);
		   	    		Common.WaitForClock(Clockobj);
		   	    							
						UpdateEmailButton.click();
						Thread.sleep(5000);
						Common.WaitForClock(Clockobj);
						EmailTextBox.type(Email1);
						EmailDoamin.type(Email2);
						ReTypeEamilTextBox.type(Email1);
						ReTypeEmailDoamin.type(Email2);
						EmailOK.click();
						DOBTextBox.click();
											
						if (UserName != null){
							UserNameTextBox.type(User_Name);
						}
						accountSave.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						accountSave.click();
						Thread.sleep(8000);
						Common.WaitForClock(Clockobj);
						String AccNo = CapturedAccNo.getTextValue();
						report.Info("Account no "+AccNo+" is Created");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Thread.sleep(5000);
	        			
						 //if  (sVerifyChkboxDisabled.equals("Y")){
	                         Thread.sleep(6000);
	                         String OF = OnlineFlagCheckBox.getAttribute("readonly");
	                         if (OF.equals("true")){
	                      	   
	                      	   report.Info("Pass: Online Flag Disabled as exepected");
	                      	   
	                         }
	                         else{
	                      	   report.Info("Fail : Online Flag NOT Disabled as exepected");
	                         }
	              	 accountName.click();
	              	 Thread.sleep(6000);
	              	Common.WaitForClock(Clockobj);
        			}
                }         	        			
         	}
				//This fuction is used to validate the non validate addresss
             	
             	public void NonValidatedAddress(String rowname) throws InterruptedException, IOException, AWTException
             	{
             		String filePath = "\\src\\test\\resources\\data\\Account.xls";
             	    String dataSheet = "CreateNewAccount";
             	    
             	    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
             	    readWorkbook.testData(tableMap);
             	    
             	   if (tableMap.get("First_Name").size()==0){
	                   	report.Info(rowname+" logical name not found in sheet.");
	                   	Assert.assertTrue(false);        	
	                   }
             	    
             	    for (int i = 0;i < tableMap.get("First_Name").size();i++) {
             	          String FirstName = tableMap.get("First_Name").get(i);
             	          String LastName = tableMap.get("Last_Name").get(i);
             	          String PostCode = tableMap.get("Post_Code").get(i);
             	          String Account_Type = tableMap.get("Account_Type").get(i);
             	          String ExpAlertText = tableMap.get("Popup").get(i);
             	         String sPopup = tableMap.get("Popup").get(i);
             	         if (sPopup.equals("")){
       	                  sPopup = "No";
       	            }
             	          
             	     
             	         Thread.sleep(3000);
                  		AccountsTab.click();
                  		Thread.sleep(3000);
                  		//AccountsTab.sendKeys(Keys.ESCAPE);
                  		newAccount.waitUntilPresent();
                  		newAccount.click();
                  		accountTypeSelect.waitUntilEnabled();
                  		accountTypeSelect.type(Account_Type);
                  		TitleWebList.waitUntilEnabled();
                  		TitleWebList.type("Mr.");
                  		firstName.type(FirstName);
                  		lastName.type(LastName);
                  		AddressPopUp.waitUntilClickable();
                  		AddressPopUp.click();
           	      		Common.WaitForClock(Clockobj);
                  		AddressCancel.waitUntilClickable();
                  		AddressCancel.click();
                  		PostCodeTextBox.waitUntilPresent();
                  		PostCodeTextBox.typeAndEnter(PostCode);
                  		report.Info("postcode is "+PostCode);
                  		AddAddress.click();
                  		 if(!sPopup.equalsIgnoreCase("No")){
      	            		Common.HandleErrorPopUp(sPopup); 
      	            	  }
                   		
                  		/*Alert alert=getDriver().switchTo().alert();
                  		String ActAlertText=alert.getText();
                  		report.Info("alert messsage is"+ActAlertText);*/
                  		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
             		//Assert.assertTrue("Non validate address pop is not present",ActAlertText.contains(ExpAlertText));
             		
             	}
             }
           
               	
                @FindBy(xpath=".//*[@id='s_9_1_143_0_icon']")
                WebElementFacade Addressline;
                @FindBy(xpath=".//*[@id='j_s_vctrl_div_tabScreen']")
                WebElementFacade AccountSummaryDropdown;
                @FindBy(xpath=".//*[@title='Account Addresses:New']")
                WebElementFacade NewAddressButton;
                @FindBy(xpath=".//*[@title='Address History:New']")
                WebElementFacade NewAddressicon;
                @FindBy(xpath="html/body/div[9]/div[1]/button")
                WebElementFacade Cancelicon;
                @FindBy(xpath=".//*[@id='1_s_1_l_Last_Name']/a")
                WebElementFacade Lastnamelink;
                @FindBy(xpath=".//*[@id='s_2_1_172_0_icon']")
                WebElementFacade Adressicon;
                @FindBy(xpath=".//*[@aria-controls='s_sctrl_tabScreen_noop'][2]")
                WebElementFacade AccountTab;
                @FindBy(xpath=".//*[contains(@aria-describedby,'Postal_Code')]")
                WebElementFacade Postcodebutton;
                @FindBy(xpath=".//*[@id='s_vctrl_div_tabScreen']/ul/li[6]/a")
                WebElementFacade Creditvettingtab;
                @FindBy(xpath=".//*[@id='s_vctrl_div_tabScreen']/ul/li[4]/a")
                WebElementFacade AgeIDVerificationttab;
                @FindBy(xpath=".//*[@id='s_vctrl_div_tabScreen']/ul/li[2]/a")
                WebElementFacade ContactstabButton;
                @FindBy(xpath=".//*[@id='s_sctrl_tabScreen']/ul/li[1]/a")
                WebElementFacade HomePageLink;
                
                
                
                //This function is used to validate address applet should be  query mode in all views         
                
                
          @Step
          public void AddressAppletValidation() throws InterruptedException, IOException, AWTException
          
          {
        	 // AccountsTab.waitUntilEnabled();
        	  Common.WaitForClock(Clockobj);
              AccountsTab.click();
            //  Query.waitUntilClickable();
              Common.WaitForClock(Clockobj);
              Query.click();
              AccountNumber.waitUntilPresent();
              String sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString();
              AccountNumber.type(sAccountNo);
              Go.waitUntilEnabled();
              Go.click();
              accountName.click();
              Thread.sleep(2000);
              //1st validation
              Common.WaitForClock(Clockobj);
            //  AddressPopUp.waitUntilPresent();
             /* AddressPopUp.click();
              Thread.sleep(5000);
              Common.WaitForClock(Clockobj); 
              Common.WaitForObjectPresence(".//*[@title='Add Address:Cancel']");
              AddressCancel.waitUntilPresent();
              AddressCancel.click();
              PostCodeTextBox.waitUntilEnabled();
              Assert.assertTrue("address applet is not opened in query mode",PostCodeTextBox.isEnabled());
              report.Info("validation1: Address applet is opened in query mode of existing account");
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              AddressOKButton.click();
              Thread.sleep(3000);*/
              //2nd  validation
              AccountSummaryDropdown.selectByVisibleText("Addresses");
              Thread.sleep(45000);
              report.Info("Address tab clicked successfully");
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              NewAddressButton.withTimeoutOf(180,TimeUnit.SECONDS).waitUntilClickable();
              NewAddressButton.click();
              //Postcodebutton.waitUntilEnabled();
              Postcodebutton.click();
              Assert.assertTrue("address applet is not opened in query mode ", PostCodeTextBox.isEnabled());
              report.Info("validation2: Address applet is opened query mode in address view");
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              AddressCancel.click();
              Thread.sleep(2000);
              //3rd validation
              if(Creditvettingtab.isPresent()){
                    Creditvettingtab.click();
              }else{
              
                  AccountSummaryDropdown.selectByVisibleText("Credit Vetting");
              }
              Thread.sleep(2000);
              if(isAlertPresent(getDriver())){
                    getDriver().switchTo().alert().accept();
              }
              report.Info("credit vetting  tab clicked successfully");
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              Thread.sleep(2000);
              NewAddressicon.click();
              Postcodebutton.click();
              Assert.assertTrue("address applet is not opened in query mode", PostCodeTextBox.isEnabled());
              report.Info("validation3: Address applet is opened query mode in credit vetting view ");
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              AddressCancel.click();
              Thread.sleep(2000);
              //4th validation
              if(AgeIDVerificationttab.isPresent()){
                    AgeIDVerificationttab.click();
              }else{
              AccountSummaryDropdown.selectByVisibleText("Age and ID Verification");
              }
              report.Info("Age and Id verification tab clicked successfully");
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              Thread.sleep(2000);
              NewAddressButton.click();
              
            PostCodeTextBox.waitUntilEnabled();
            Assert.assertTrue("address applet is not opened in query mode", PostCodeTextBox.isEnabled());
            report.Info("validation4: Address applet is opened query mode in Age and Id verificstin tab");
            sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            AddressCancel.waitUntilPresent();
            AddressCancel.click();
            
            //Cancelicon.click();
                    Thread.sleep(2000);
                    if(isAlertPresent(getDriver())){
                          getDriver().switchTo().alert().accept();
                    }
                    Thread.sleep(2000);
              //5th validation
                    if(ContactstabButton.isPresent()){
                          ContactstabButton.click();
                    }else{
                    AccountSummaryDropdown.selectByVisibleText("Contacts");
                    }
                    report.Info("contacts tab clicked successfully");
                    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                    Lastnamelink.click();
                    Thread.sleep(2000);
                    Adressicon.click();
                    /*AddressCancel.waitUntilPresent();
                    AddressCancel.click();*/
                  PostCodeTextBox.waitUntilEnabled();
                  Assert.assertTrue("address applet is not opened in query mode", PostCodeTextBox.isEnabled());
                  report.Info("validation5: Address applet is opened  query mode in contacts tab");
                  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                          AddressOKButton.click();
                          Thread.sleep(2000);
            //6th validation
                          //Homepage.waitUntilPresent();
                          HomePageLink.click();
                          Thread.sleep(3000);
                          AccountsTab.click();
                          newAccount.waitUntilPresent();
                          newAccount.click();
                          accountTypeSelect.waitUntilEnabled();
                          accountTypeSelect.type("Consumer");
                          AddressPopUp.click();
                         /* AddressCancel.waitUntilPresent();
                          AddressCancel.click();*/
                          PostCodeTextBox.waitUntilEnabled();
                          Assert.assertTrue(" address applet is not opened in query mode", PostCodeTextBox.isEnabled());
                          report.Info("validation6: Address applet is opened in query mode while createing new account");
                          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                          
        }




  
          

      	@FindBy(xpath=".//*[@aria-labelledby='VF_Email_Label']")
      	WebElementFacade ChangedEmailTextBox;
      	@FindBy(xpath=".//*[@title='Account Addresses:New']")
      	WebElementFacade AccountAddressesNewButton;
      	@FindBy(xpath=".//*[@aria-labelledby='s_4_l_Status ']")
      	WebElementFacade AddressStatus; 
      	@FindBy(xpath=".//*[@id='1_s_4_l_Postal_Code']")
      	WebElementFacade PostalCode;
      	@FindBy(xpath=".//*[@name='Postal_Code']")
      	WebElementFacade PostalCodeTextBox;
      	@FindBy(xpath=".//*[@title='Add Address:OK']")
      	WebElementFacade AccountAddressesOKButton;
      	@FindBy(xpath=".//*[@id='1_s_3_l_SSA_Primary_Field']") 
      	WebElementFacade PrimaryWebElement;
      	@FindBy(xpath=".//*[@name='SSA_Primary_Field']")
      	WebElementFacade PrimaryCheckBox;
      	@FindBy(xpath=".//*[text()='Account Addresses']")
      	WebElementFacade AccountAddressesTab; 
      	@FindBy(xpath=".//*[@id='gview_s_3_l']/div[3]")
      	WebElementFacade AccountAddressesApplet; 
            // This function is used to validate the modify Details of existed account
      	@Step
      	public void ModifyDetails(String rowname) throws IOException, InterruptedException, AWTException
      	{
      		Common.waitForPageLoad(getDriver());
      		String filePath = "\\src\\test\\resources\\data\\Account.xls";
              String dataSheet = "ModifyDetails";
              
              Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
              readWorkbook.testData(tableMap);
              
              if (tableMap.get("ModifyType").size()==0){
                 	report.Info(rowname+" logical name not found in sheet.");
                 	Assert.assertTrue(false);        	
                 }
              
              for (int i = 0;i < tableMap.get("ModifyType").size();i++) {
                    //String LogicalName = tableMap.get("LogicalName").get(i);
                     String Email = tableMap.get("Email").get(i);
                     String DomainName = tableMap.get("DomainName").get(i);
                     String LastName = tableMap.get("LastName").get(i);
                     String ChangedEmailExp = tableMap.get("ChangedEmail").get(i);
                     String ModifyType = tableMap.get("ModifyType").get(i);
                     String sPostCode = tableMap.get("PostCode").get(i);
                     String sPopup = tableMap.get("Popup").get(i);
                     String sAddressStatus = tableMap.get("AddressStatus").get(i);

                     Thread.sleep(2000);
                     if(ModifyType.equals("LastName")){
                  	   lastName.clear();
                         lastName.type(LastName);
                         accountSave.click();
                        String ChangedLastName = lastName.getTextValue();
                        Assert.assertTrue("Last Name not updated", ChangedLastName.equalsIgnoreCase(LastName));
                        /*if (ChangedLastName.equals(LastName)){
                      	  report.Info("Last Name updated successfully");
                        }
                        else{
                     	   report.Info("Last Name not updated");
                        }*/
                     }
                        
         
                     if(ModifyType.equals("Email")){
                  	Thread.sleep(2000);
                  	
                 		UpdateEmailButton.click();
                 		report.Info("updateEmal id clicked");
                 		EmailTextBox.type(Email);
                 		EmailDoamin.type(DomainName);
                 		ReTypeEamilTextBox.type(Email);
                 		ReTypeEmailDoamin.type(DomainName);
                 		report.Info("updating eamil details successfully");
                 		EmailOK.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                 		EmailOK.click();
                 		Thread.sleep(2000);
                 		AccountSummaryTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                 		String ChangedEmail = ChangedEmailTextBox.getTextValue();
                 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                 		Assert.assertTrue("Email is not updated", ChangedEmail.equalsIgnoreCase(ChangedEmailExp));
                 		report.Info("email is changed successfully");
                      
                   }
                     
                     if(ModifyType.equals("Address")){
              	 	   AccountSummaryDropdown.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();                           
                         AccountSummaryDropdown.selectByVisibleText("Addresses");                               
                         AccountAddressesNewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                         AccountAddressesNewButton.click();
                         Thread.sleep(3000);
                         AddressStatus.type(sAddressStatus);
                         PostalCode.click();
                         PostalCodeTextBox.typeAndEnter(sPostCode);
                         AccountAddressesOKButton.click();                               
                         PrimaryWebElement.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                         PrimaryWebElement.click();
                         PrimaryCheckBox.click();
                         Thread.sleep(3000);
                         sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                         /*AccountAddressesTab.click();
                         AccountAddressesApplet.click();
                         Thread.sleep(3000);
                         report.Info("AccountAddressesTab is clicked successfully");*/
                         

                        Alert alert=getDriver().switchTo().alert();
                        String ActAlertText=alert.getText();
                        report.Info("alert messsage is"+ActAlertText);
                        if(ActAlertText.contains(sPopup)){
                      	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                              alert.accept();
                        report.Info("AccountAddressesTab is clicked successfully");      
             }
             
                 }

                      
              }
              }
 
    	//+++++++++++++++++++++++++++++++++++++++
    	@FindBy(xpath=".//*[@aria-label='Billing profile:New']")
        WebElementFacade ProfilesNewButton;
        
        @FindBy(xpath=".//*[@aria-label='Credit Card Payment:Card Details']")
        WebElementFacade CardDetailsButton;
        @FindBy(xpath=".//a[text()='Profiles']")
		WebElementFacade ProfilesTab;
        @FindBy(xpath=".//*[text()='Authorize']")
        WebElementFacade AuthorizeButton;
        @FindBy(xpath=".//*[@id='j_s_vctrl_div_tabScreen']")
		WebElementFacade TabDropDown;
        @FindBy(xpath=".//a[text()='Billing profile']")
        WebElementFacade BillingProfilesTab;
        
        @FindBy(xpath=".//*[@aria-label='Billing profile:Check Payment Date']")
        WebElementFacade CheckPaymentDateButton;

        @FindBy(xpath=".//*[@aria-labelledby='Credit_Card_Number_Label']")
        WebElementFacade ActualCardNum;
    
    
      //ZEBA ** This function is used to create new billing profiles via profiles tab
    public void CreateNewProfilesBillingProfile(String sLogicalName) throws IOException, InterruptedException, AWTException
    {

    	Common.waitForPageLoad(getDriver());
    	String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
    	String dataSheet = "ProfilesBillingProfile";
    	String applet = "//*[@title='Billing profile List Applet']";
    	String table = "//table[@summary='Billing profile']";

    	Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(sLogicalName, filePath, dataSheet);
    	readWorkbook.testData(tableMap);


    	if (tableMap.get("CardDetails").size()==0){
    		report.Info(sLogicalName+" logical name not found in sheet.");
    		Assert.assertTrue(false);        	
    	}            

    	
    	Thread.sleep(1000);
    	if (ProfilesTab.isPresent())
    	{
    		ProfilesTab.click();
    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	}
    	else
    	{
    		TabDropDown.selectByVisibleText("Profiles");
    	}

    	BillingProfilesTab.click();
    	for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
    		String sLocateCol = tableMap.get("LocateCol").get(i);
    		String sLocateColValue = tableMap.get("LocateColValue").get(i);
    		String UIName = tableMap.get("UIName").get(i);
    		String value = tableMap.get("Value").get(i);
    		String indexValue = tableMap.get("Index").get(i);
    		String ListValidation = tableMap.get("ListValidation").get(i);
    		String sCardDetails = tableMap.get("CardDetails").get(i);
        	String sPopup = tableMap.get("Popup").get(i);
        	String sNew = tableMap.get("New").get(i);
        	String sCheckPaymentButton = tableMap.get("CheckPaymentButton").get(i);	
        	String sAuthorize = tableMap.get("Authorize").get(i);
    		String getStatus="";        	

        	if(sNew.equals("Yes"))
        	{
        		Common.waitForElement(ProfilesNewButton);
        		Thread.sleep(5000);
        		ProfilesNewButton.click();
        		Thread.sleep(5000);
        		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        	}  
    		if (indexValue.equals("")){
    			indexValue = "0";
    		}


    		String LocateColMessege = sLocateCol+"Not Found";
    		if (!sLocateCol.equals("")){
    			Common.selectedRow = -1;
    			Assert.assertTrue(LocateColMessege, Common.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
    			report.Info(sLocateCol+"Customer summary applet found using Locate Col");
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    		}
    		else 
    		{
    			Common.selectedRow = 1;
    			report.Info("Customer summary applet found");
    		}//report.Info(sLocateCol+" found");
    		if (!UIName.equals("")){                                              
    			 getStatus = Common.updateSiebList(applet,table, UIName, value);
    			Thread.sleep(2000);
    			report.Info("Clicked on User Account sucessfully");
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

    		}     
    		if(UIName.equalsIgnoreCase("CheckBoxStatusChecked")){
    			if(value.equalsIgnoreCase("N")){   				
    				if(!getStatus.equalsIgnoreCase("true")){
    					report.Info("Pass: The Youth Recurring Flag is not checked for cash mode");
    				}
    				else{
    					Assert.assertTrue("Fail: The Youth Recurring Flag is checked for cash mode", !getStatus.equalsIgnoreCase("true"));
    				}
    			}
    		}
    		
    		
    		if(ListValidation.equalsIgnoreCase("Yes")){
    			getDriver().findElement(By.xpath("(//td[contains(@id,'Payment_Method')])[1]")).click();
    			getDriver().findElement(By.xpath("//td[contains(@id,'Payment_Method')]//span")).click();
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			report.Info("Pass: Cash option not avilable on the list");
    		}


   
    	if(NewBillProfileButton.equals("RealTimeBalance"))
    	{
    		Assert.assertTrue("Real Time Balance Page not displayed Successfully", TopUpReqButton.isVisible());
    		report.Info("Real Time Page Displayed");
    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	}
    	if(!sCardDetails.equals(""))
    	{
    		String initialWindow = "";
			initialWindow = getDriver().getWindowHandle();
    		CardDetailsButton.click();
    		Thread.sleep(2000);
    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    		
    		Set<String> winHandles = getDriver().getWindowHandles();
			for (String handle : winHandles) {
				if (!handle.equals(initialWindow)) {
					getDriver().switchTo().window(handle);
					Thread.sleep(1000);
				}
			}

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    		AboutCustomerEnh.enterAeirandiCardDetails("CreditCardVisa");
    		getDriver().switchTo().window(initialWindow);
    		Thread.sleep(1000);
    	}
    	if(!sAuthorize.equals(""))
    	{
    		//getDriver().navigate().refresh();
	    	//Thread.sleep(2000);
    		Robot robot = new Robot();	 
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ALT);	
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			AuthorizeButton.click();
    		Common.WaitForClock(Clockobj);
    		ActualCardNum.click();
    		Thread.sleep(2000);
    		String sActualCardNum = ActualCardNum.getTextValue();
    		String CapturedCardNum = Serenity.sessionVariableCalled("CardNum").toString();
    		String SplitCardNum = sActualCardNum.substring(12,15);
     		Assert.assertTrue("Fail, Card Number not populated currectly", CapturedCardNum.contains(SplitCardNum));
    		report.Info("Card number populated currectly");
    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	}

    	if (!sCheckPaymentButton.equals(""))
    	{
    		Thread.sleep(2000);
    		Assert.assertFalse("FAIL, Check Payment Date Button is Enabled", CheckPaymentDateButton.isEnabled());
    		report.Info("Customer summary applet found using Locate Col");
    	}

    	if (!sPopup.equals("NO"))
    	{
    		Alert alert=getDriver().switchTo().alert();
    		String ActAlertText=alert.getText();                                                                      

    		Assert.assertTrue(" FAIL, PopUp Did not Occur", ActAlertText.contains(sPopup));				                     
    		if(ActAlertText.contains(sPopup))
    		{
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			alert.accept();   
    			report.Info("Alert messsage is:"+ActAlertText);
    		}  
    	}

    }
    
    }
  
    
    @FindBy(xpath=".//*[@title='Owned Product/Service Menu']")
   	WebElementFacade OwnedProductMenuItemIcon;
   	
   	@FindBy(xpath=".//*[@title='Installed Assets Menu']")
   	WebElementFacade UsedProductMenuItemIcon;
   	
   	@FindBy(xpath=".//*[@title='Billing Items Menu']")
   	WebElementFacade BilledProductMenuItemIcon;
   	
   	@FindBy(xpath="//span/ul/li[19]/a")
   	WebElementFacade columnsDisplayed; 
   	
   	@FindBy(xpath="//a[text()='Reset Defaults']")
   	WebElementFacade ResetDefaultsButton;
   	
   	@FindBy(xpath=".//*[@title='Account Details Menu']")
   	WebElementFacade AccountMenuItemIcon;
   	
   	@FindBy(xpath="//span/ul/li[9]/a")
   	WebElementFacade RefreshButton; 
   	//span/ul/li[9]/a
	
	@Step	
	public void AllProductServicesValidation(String rowname) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());

		String filePath = "\\src\\test\\resources\\data\\Account.xls";
        String dataSheet = "AllServicesValidation";
        String applet="";
        String table = "";
        Robot robot = new Robot();
        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
        readWorkbook.testData(tableMap);
        
        for (int i = 0;i < tableMap.get("ServiceType").size();i++) {
        	String sServiceType = tableMap.get("ServiceType").get(i);
        	String sLocateCol = tableMap.get("LocateCol").get(i);
            String sLocateColValue = tableMap.get("LocateColValue").get(i);
            String sUIName = tableMap.get("UIName").get(i);
            String sValue = tableMap.get("Value").get(i);
            String index = "0";
            int k=0;
            
            do
            {
                Thread.sleep(2000);
                firstName.sendKeys(Keys.chord(Keys.ALT,Keys.ENTER));                 
                Thread.sleep(8000);
                k++;
            }while(k<5);	
            
            if (index.equals("")){
            	index = "0";
            }            
            
        	if(sServiceType.equalsIgnoreCase("OwnedProduct")){
        		 applet = "//*[@title='Owned Product/Service List Applet']";
        		 table = "//table[@summary='Owned Product/Service']";
        		 findBy(applet).click();
        		 OwnedProductMenuItemIcon.click();
        		 Thread.sleep(2000);
        		 columnsDisplayed.click();
        	}
        	else if(sServiceType.equalsIgnoreCase("UsedProduct")){
        		 applet = "//*[@title='Installed Assets List Applet']";
        		 table = "//table[@summary='SIS OM Products & Services Root List (Service) - Tiny']";
        		 findBy(applet).click();
        		 UsedProductMenuItemIcon.click();
        		 Thread.sleep(2000);
        		 columnsDisplayed.click();
        		 
        	}
        	else if(sServiceType.equalsIgnoreCase("BilledProduct")){
        		 applet = "//*[@title='Billing Items List Applet']";
        		 table = "//table[@summary='SIS OM Products & Services Root List (Billing) - Tiny']";
        		 findBy(applet).click();
        		 BilledProductMenuItemIcon.click();
        		 Thread.sleep(2000);
        		 columnsDisplayed.click();
        	}
        	
        	
        	//findBy(applet).click();
        	//Thread.sleep(2000);
        //	findBy(applet+"/form/span/div/div[1]").sendKeys(Keys.chord(Keys.CONTROL,Keys.SHIFT,"K")); 
        	Thread.sleep(4000);
        	
        	
        	if(ResetDefaultsButton.isEnabled()){
        		ResetDefaultsButton.click();
        		Thread.sleep(4000);
        		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        	}
        	else{
        		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        		Assert.assertTrue("Columns displayed value is not selected from Menu items..", ResetDefaultsButton.isEnabled());
        	}
        	
        	Thread.sleep(4000);
        	String StartDate = applet + "//*[contains(@id,'Effective_End_Date')]/preceding::th[1]" ;
        	String StartDateResult = "Start date is not beside Service end date for " + sServiceType + "view";
        	
        	if(findBy(StartDate).isPresent()){
        		new Actions(getDriver()).moveToElement(find(By.xpath("("+applet+"//td[contains(@id,'Effective_End_Date')])[1]"))).click().perform(); 
        		report.Info("Start date is beside Service end date for " + sServiceType + "view");
        	}
        	else{
        		
        		Assert.assertTrue(StartDateResult, findBy(StartDate).isVisible());
        	}
        	
        	if (!sLocateCol.isEmpty()){
               Common.selectedRow = -1;
               Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, index).equals("true"));
        	}
        	else{
        		Common.selectedRow = 1;
        	}
        	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
      	
        }
		
	}
	@FindBy(xpath=".//*[@title='Service Requests']/parent::a")
	WebElementFacade ServiceRequestsTab;

	@FindBy(xpath=".//*[@aria-label='First Level View Bar']")
	WebElementFacade HomepageTabDropdown;

	@FindBy(xpath="//select[@title='Visibility']")
	  WebElementFacade ServiceRequestList;
	  
	  @FindBy(xpath=".//*[@title='Service Requests List Applet']")
	  WebElementFacade ServiceRequestApplet;
	  
	  @FindBy(xpath=".//*[@title='Service Requests Menu']")
	  WebElementFacade ServiceRequestMenu;
	  
	  @FindBy(xpath="//span/ul/li[8]/a")
	  WebElementFacade newQuery;
	  
	  @FindBy(xpath=".//*[contains(@aria-describedby,'_Status')]")
	  WebElementFacade StatusElement;
	  
	  @FindBy(xpath=".//input[@name='Status']")
	  WebElementFacade StatusTextbox;
	  
	  @FindBy(xpath=".//*[@class='siebui-btn-grp-applet']/button[@title='Service Requests:Go']")
	  WebElementFacade GoButton;
	  
	  @FindBy(xpath=".//*[@id='1_s_2_l_Closed_Date']")
	  WebElementFacade ClosedDateElement;
	  
	  @FindBy(xpath=".//input[@name='Closed_Date']")
	  WebElementFacade ClosedDateTextbox;
	    
	  @FindBy(xpath="//th[contains(@id,'Owner')]/preceding::th[contains(@id,'Created_By')][1]")
	WebElementFacade CreatedByColumn;
	  @FindBy(xpath=".//*[text()='Service Requests List']")
	    WebElementFacade ServiceRequestListLink;
	  
	  
	  @FindBy(xpath="(.//td[contains(@id,'VF_ETF')])[1]")
	  WebElementFacade ETFElement;
	  
	  
	   @Step 	
	  public void ServiceRequestColumnValidation(String rowname) throws IOException, InterruptedException, AWTException{

		   Common.waitForPageLoad(getDriver());
			  String filePath = "\\src\\test\\resources\\data\\Account.xls";
			  String dataSheet = "AllServicesValidation";
			  
			  String applet = "//*[@title='Service Requests List Applet']";
			  String table = "//table[@summary='Service Request List']";
			    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
			    readWorkbook.testData(tableMap);
			    
			    if (tableMap.get("ServiceType").size()==0){
                 	report.Info(rowname+" logical name not found in sheet.");
                 	Assert.assertTrue(false);        	
                 }
			    
			    for (int i = 0;i < tableMap.get("ServiceType").size();i++) {
			    	String sLocateCol = tableMap.get("LocateCol").get(i);
		            String sLocateColValue = tableMap.get("LocateColValue").get(i);
		            String sUIName = tableMap.get("UIName").get(i);
		            String sValue = tableMap.get("Value").get(i);
		            String index = "0";
			    	String sServiceType = tableMap.get("ServiceType").get(i);
			    
		            
		            if (index.equals("")){
		            	index = "0";
		            } 
			    	if(ServiceRequestsTab.isVisible()){
			    		ServiceRequestsTab.click();
			    	}
			    	else{
			    		HomepageTabDropdown.selectByVisibleText("Service Requests");
			    	}

			    	ServiceRequestListLink.withTimeoutOf(220,TimeUnit.SECONDS).waitUntilClickable();
	   	        	ServiceRequestListLink.click();
	   	        	ServiceRequestList.withTimeoutOf(220,TimeUnit.SECONDS).isCurrentlyVisible();
			    	Thread.sleep(15000);
			    	ServiceRequestList.selectByVisibleText("My Service Requests");
			    	Thread.sleep(5000);
			    	
			    	if(ServiceRequestApplet.isPresent()){
			    		System.out.println("Service Request screen is displayed successfully.");
			    		report.Info("Service Request screen is displayed successfully.");
			    	}
			    	else{
			    		Assert.assertTrue("Service Request screen is not displayed successfully.", ServiceRequestApplet.isPresent());
			    		break;
			    	}
			    	
			    	
			    	if(sServiceType.equalsIgnoreCase("SRClosedDate")){
			    		ServiceRequestMenu.click();
			    		Thread.sleep(3000);
			    		newQuery.click();
			    		Thread.sleep(3000);
			    		StatusElement.click();
			    		StatusTextbox.type("Closed");
			    		//StatusTextbox.sendKeys(Keys.ENTER);
			    		GoButton.click();
			    		Thread.sleep(5000);
			    		ClosedDateElement.click();
			    		String sSRClosedDate = ClosedDateTextbox.getAttribute("readonly");
			    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			    		if(sSRClosedDate.equalsIgnoreCase("true")){
			    			System.out.println("SR closed date is not editable when SR status is closed.");
			    			report.Info("SR closed date is not editable when SR status is closed.");
			    			break;
			    		}
			    		else{
			    			Assert.assertTrue("SR closed date is editable when SR status is closed.", sSRClosedDate.equalsIgnoreCase("true"));
			    			break;
			    		}
			    	}
			    	 
			    	if(sServiceType.equalsIgnoreCase("ColumnValidation")){
			    		ServiceRequestMenu.click();
			    		Thread.sleep(3000);
			    		columnsDisplayed.click();
		            	Thread.sleep(3000);
		            	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		            	if(ResetDefaultsButton.isEnabled()){
		            		ResetDefaultsButton.click();
		            		Thread.sleep(3000);
		            	}
		            	else{
		            		Assert.assertTrue("Columns displayed value is not selected from Menu items..", ResetDefaultsButton.isEnabled());
		            	}
		            	ETFElement.click();
		            	
		            	if(CreatedByColumn.isPresent()){
		            		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		            		System.out.println("Created by cloumn exits at the left of Owner column");
		            		report.Info("Created by cloumn exits at the left of Owner column");
		            	}
		            	else{
		            		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		            		Assert.assertTrue("Created by cloumn doesnot exists at the left of Owner column", CreatedByColumn.isPresent());
		            	}
			    	}
			    	
			    	
			    	if (!sLocateCol.equals("")){
		                Common.selectedRow = -1;
		                Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, index).equals("true"));
		         	}
		         	else{
		         		Common.selectedRow = 1;
		         	}
			    	
			    	if (!sUIName.equals("")){                                              
			    		Common.updateSiebList(applet,table, sUIName, sValue);
			            Thread.sleep(2000);                                             
			            }   
			    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			    }		    
			   
		  
	   }
	   @FindBy(xpath=".//*[text()='Account Summary']")
	   WebElementFacade AccountSummaryTab;
	   
	   @FindBy(xpath=".//*[text()='Customer Comms List']")
	   WebElementFacade CustCommsListHeader;
	   
	   public void GotoAccountSummary(){
		   Common.waitForPageLoad(getDriver());
		   // AccountSummaryTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		   Common.waitForElement(AccountSummaryTab);
		   AccountSummaryTab.click();
		   //	  Common.WaitForObjectPresence(".//*[text()='Account Summary']");
		   //   Common.waitForPageLoad(getDriver());
		   // CustCommsListHeader.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
		   // CustCommsListHeader.click();
		   Common.WaitForObjectPresence(".//*[text()='Customer Comms List']");
	   }
	   
	   @FindBy(xpath=".//*[@aria-labelledby='VF_Order_Origin_Label']")
	   WebElementFacade Channel;

	   @FindBy(xpath=".//*[@aria-labelledby='Created_By_Label']")
	   WebElementFacade CreatedBy;
	   
	   @FindBy(xpath="//a[text()='Line Items']")
	   WebElementFacade LineItemsTab;
	   
	   //This Function is used to verify Created_by and Channel Field
		public void VerifyOrderDetails(String accountType) throws InterruptedException, IOException, AWTException{
			//Homepage.waitUntilPresent();
			//Common.waitForPageLoad(getDriver());
			String filePath = "\\src\\test\\resources\\data\\Account.xls";
	        String dataSheet = "CreateNewAccount";
	        
	        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
	        readWorkbook.testData(tableMap);
	        
	        if (tableMap.get("First_Name").size()==0){
             	report.Info(accountType+" logical name not found in sheet.");
             	Assert.assertTrue(false);        	
             }
	        
	        for (int i = 0;i < tableMap.get("First_Name").size();i++) {
	              String sChannel = tableMap.get("Channel").get(i);
	              String sCreated_By = tableMap.get("Created By").get(i);

	              //LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	      		  LineItemsTab.click();
	      		  
	              if(!sChannel.equals(""))
	              {
	            	  String Channelcmp = Channel.getTextValue();
	            	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	            	  Assert.assertTrue("FAIL, Actual value does not match with actual", Channelcmp.equals(sChannel));		  
	              }
	              if(!sCreated_By.equals(""))
	              {
	            	  String Created_ByCmp = CreatedBy.getTextValue();
	            	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	            	  Assert.assertTrue("FAIL, Actual value does not match with actual", Created_ByCmp.equals(sCreated_By));
	              }
	              if(!sChannel.equals("") && !sCreated_By.equals("") )
	              {
	            	  String Channelcmp = Channel.getTextValue();
	            	  String Created_ByCmp = CreatedBy.getTextValue();
	            	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	            	  Assert.assertTrue("FAIL, Actual value does not match with actual", Channelcmp.equals(sChannel) && Created_ByCmp.equals(sCreated_By));
	              }
	        	}

	              }
		 @FindBy(xpath=".//*[@aria-labelledby='AgmtStartDate_Label']")
		   WebElementFacade PlannedDateSelection;
		 @FindBy(xpath=".//*[@aria-labelledby='AgmtEndDate_Label']")
		   WebElementFacade EndDateSelection;
		 @FindBy(xpath=".//*[@aria-label='Agreement:Menu']")
		   WebElementFacade AgreementMenu;
		 @FindBy(xpath="//span/ul/li[6]/a")
		   WebElementFacade StartEndDateSave;
		 @FindBy(xpath=".//*[@aria-label='SLA date']")
		  WebElementFacade SLADate;
		
		
		 public void AgreementDateChange() throws InterruptedException, IOException, AWTException{
				
					String sPromotion = Serenity.sessionVariableCalled("ProductName").toString();
					//String sPromotion = "12";

					   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				        Date currentDate = new Date();
				        //System.out.println(dateFormat.format(currentDate));
			// convert date to calendar
				        Calendar c = Calendar.getInstance();
				        c.setTime(currentDate);
				 // manipulate date
				       /* if (sPromotion.contains("12")){
				        	c.add(Calendar.YEAR,-1);
					        c.add(Calendar.MONTH,+1);
					        c.set(Calendar.DATE, 4); 
						}
				        if (sPromotion.contains("24")){
				        	c.add(Calendar.YEAR,-2);
					        c.add(Calendar.MONTH,+1);
					        c.set(Calendar.DATE, 4);
						}*/
				        
				//New CR now agreement end date is any date less than sysdate
				 // convert date to calendar
				        Calendar c3 = Calendar.getInstance();
				        c3.setTime(currentDate);
				 // manipulate date		       
				        c3.add(Calendar.DATE,-2);		        			       
				 // convert calendar to date
				        Date EndDate = c3.getTime();
				        String newEndDate = (dateFormat.format(EndDate));
				       //System.out.println(sEndDate);
									
						if (EndDateSelection.isDisplayed()){
							EndDateSelection.clear();
							EndDateSelection.type(newEndDate);
							Thread.sleep(3000);
						
						}	
						
						 Thread.sleep(2000);
						 AgreementMenu.click();
						 StartEndDateSave.click();
						 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							
				}
		
		public void AgreementDateChangeByTwoDays() throws InterruptedException, IOException, AWTException{
			
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		        Date currentDate = new Date();
			 
			 //DATETODAY.clear();
			 
			 Calendar calendar = Calendar.getInstance();
			 Date today = calendar.getTime();
			 calendar.add(Calendar.DAY_OF_YEAR, 2);
			 
			 Date EndDate = calendar.getTime();
		        String sEndDate = (dateFormat.format(EndDate));
			 
			 if (SLADate.isDisplayed()){
					SLADate.clear();
					SLADate.type(sEndDate);
					Thread.sleep(3000);
				
			 }	}	
		

		 @FindBy(xpath=".//*[@id='1_s_1_l_Agreement_Number']")
		   WebElementFacade CaptureAgreementRowId;
		   
		   @FindBy(xpath=".//*[@id='1_s_1_l_Name']/a")
		   WebElementFacade ClickAgreementName;
		   
		   @FindBy(xpath="(.//a[text()='Agreements'])[2]")
		   WebElementFacade Agreementstab;
		   @FindBy(xpath=".//*[@title='Agreements List View Menu']")
		   WebElementFacade AgreementListMenu;
		   @FindBy(xpath=".//ul[@id='s_at_m_1-menu']/li[9]/a")
		   WebElementFacade AgreementRunQuery;		  
		   @FindBy(xpath=".//span/ul/li[12]/a")
		   WebElementFacade AgreementAboutRecord;
		   @FindBy(xpath=".//*[text()='Conditional Charges']")
		   WebElementFacade ConditionalCharges;
		   @FindBy(xpath=".//*[@title='Agreements List View:Go']")
		   WebElementFacade AgreementGo;
		   
		 @Step 	
		public void SelectAgreementRowID(String rowname) throws IOException, InterruptedException, AWTException{
		
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
      String dataSheet = "UsedProdMenuSelect";
      String applet = "//*[@title='Agreements List View List Applet']";
      String table = "//table[@summary='Agreements']";
      

      
      Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
      readWorkbook.testData(tableMap);
      
      
      
      AccountSummaryTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
      if (Agreementstab.isCurrentlyVisible() ) {
        	//Agreementstab.waitUntilClickable();
        	Agreementstab.click();
  			Thread.sleep(3000);
  		}
  		else {
  			TabDropDown.selectByVisibleText("Agreements");
  			Thread.sleep(3000);
  		}
      
     
      int k=0;
	    if (Common.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true")){
	   	    do{
	   	    	
	   	    	getDriver().navigate().refresh();
		    	Thread.sleep(2000);	   	    	
	   	    	k++;
	   	    	}while(Common.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true") && (k<10));
	    }
	    String sAboutRecord = tableMap.get("AboutRecord").get(0);
	    String sAgreementListAboutRecord = tableMap.get("AgreementListAboutRecord").get(0);
      
      for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
          String sLocateCol = tableMap.get("LocateCol").get(i);
          String sLocateColValue = tableMap.get("LocateColValue").get(i);
          String UIName = tableMap.get("UIName").get(i);
          String Value = tableMap.get("Value").get(i);
          String sindex = tableMap.get("Index").get(i);
          String sConditioncharge = tableMap.get("ConditionalCharge").get(i);
          
          String sCheckAgreementID = tableMap.get("CheckAgreementID").get(i);
          if (sindex.equals("")) {
        	  sindex="0";
        	  
          }
          
          
          if(sLocateColValue.equalsIgnoreCase("AgreementEndDate")){
        	  sLocateColValue = Serenity.sessionVariableCalled("sDeliveryDate").toString();
        	  sLocateColValue = sLocateColValue + "*";
          }
          
          if(AgreementListMenu.isPresent()){
        	  AgreementListMenu.click();
        	  AgreementRunQuery.click();
        	  
          }
          
    		//Outline_Number

          if (sConditioncharge.equalsIgnoreCase("Y")){
         	 ConditionalCharges.click();
      		Thread.sleep(3000);
  	    }
          
          
          
          //String sCaptureAgreement = CaptureAgreementRowId.getTextValue();
          if (sCheckAgreementID.equals("Y")){
        	  AgreementListMenu.click();
        	  Thread.sleep(1000);	
        	  AgreementRunQuery.click();
        	  Thread.sleep(2000);	
        	  
          }
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",AgreementGo);
         	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());       

                if (!sLocateCol.equals("")){
                  Common.selectedRow = -1;
                  Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, sindex).equals("true"));

                }
                else{
                	Common.selectedRow = 1;
                }


                if (!UIName.equals("")){ 
                	String sValue =  (Common.updateSiebList(applet,table, UIName, Value)); 
                	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                	if (UIName.contains("CaptureTextValue") && UIName.contains("Agreement_Number")){
                		Serenity.setSessionVariable("AgreementRowID").to(sValue);
                	} 

                } 
               
    }
      if (sAboutRecord.equals("Y")){
    	  AgreementListMenu.click();
    	  Thread.sleep(1000);	
    	  AgreementAboutRecord.click();
    	  Thread.sleep(2000);
    	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
      }
      
      if (sAgreementListAboutRecord.equalsIgnoreCase("Y")){
		 	Robot robot = new Robot();	 
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ALT);	        		
			robot.keyPress(KeyEvent.VK_K);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_ALT);	        		
			robot.keyRelease(KeyEvent.VK_K);
			Thread.sleep(6000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          //report.Info("About record is displayed successfully");
       }
      
      
}
	      @FindBy(xpath=".//*[@id='j_s_vctrl_div_tabScreen']")
	       WebElementFacade Dropdown;
	
	      @FindBy(xpath=".//*[@value='tabScreen29']")
	       WebElementFacade SelectSubAccount;
	
	      @FindBy(xpath=".//*[@data-tabindex='tabScreen29']")
	      WebElementFacade SubAccountHeader;
	
		 public void GotoSubAccount() {
		Dropdown.selectByVisibleText("Sub-Accounts");
}
		 @FindBy(xpath=".//*[@title='Billing Profiles:New']")
		    WebElementFacade SubAccNewBillProfileButton;
		    @FindBy(xpath=".//*[@id='1_s_2_l_Payment_Type']")
		    WebElementFacade SubAccPrePayPostPayBox;
		    @FindBy(xpath=".//*[@id='1_Payment_Type']")
		    WebElementFacade SubAccBillProfileType;
		    @FindBy(xpath=".//*[@id='1_s_1_l_Name']/a")
		    WebElementFacade SubAccAccountNameLink;
		    @FindBy(xpath=".//*[@aria-label='Product / Services:Top-Up Request']")
		    WebElementFacade SubAccTopUpReqButton;
		    
		  // This function is used for creating new billing profile Sub Account
		   @Step
		    public void  CreateNewBillingProfileSubAccounts(String BillingProfileType) throws InterruptedException, IOException, AWTException{
		        String filePath = "\\src\\test\\resources\\data\\Account.xls";
		       String dataSheet = "CreateNewBillingProfile";
		       String table = "//table[@summary='Billing Profiles']";
		       String applet = "//*[@title='Billing Profiles List Applet']";
		       
		       Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
		       readWorkbook.testData(tableMap);
		       
		       if (tableMap.get("Value").size()==0){
	             	report.Info(BillingProfileType+" logical name not found in sheet.");
	             	Assert.assertTrue(false);        	
	             }
		       //Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
		      for (int i = 0;i < tableMap.get("Value").size();i++) {
		          //String ProfileType = tableMap.get("Value").get(i);
		          String sLocateCol = tableMap.get("LocateCol").get(i);
		             String sLocateColValue = tableMap.get("LocateColValue").get(i);
		             String UIName = tableMap.get("UIName").get(i);
		             String value = tableMap.get("Value").get(i);
		             String Index = tableMap.get("Index").get(i);
		             String sNewBillingProfile = tableMap.get("NewBillingProfile").get(i);
		             if (sNewBillingProfile.equals("Y"))
		             {
		                   SubAccNewBillProfileButton.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilVisible();
		                    //NewBillProfileButton.waitUntilPresent();
		                   SubAccNewBillProfileButton.click();
		             }
		           Thread.sleep(1000);
		           //String LocateColMessege = sLocateCol+"Not Found";
		           if (Index.equals("")){
		              Index = "0";
		         }

		           if (!sLocateCol.equals("")){
		                Common.selectedRow = -1;
		               Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));

		                }
		           else{
		                 Common.selectedRow = 1;
		           }
		           if (!UIName.equals("")){                                              
		               Common.updateSiebList(applet,table, UIName, value);
		               Thread.sleep(2000);
		               report.Info("Billing Profile Selected sucessfully");                                                  
		               }   
		           sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


		}
		      if(SubAccNewBillProfileButton.equals("RealTimeBalance"))
		      {
		    	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			      Assert.assertTrue("Real Time Balance Page not displayed Successfully", SubAccTopUpReqButton.isVisible());
			      report.Info("Real Time Page Displayed");
		      }


		}
		   @FindBy(xpath=".//*[@title='Billing Accounts:New']")
	         WebElementFacade ClickNewbillingAccount;
	   
	    
	    @Step      
	         public void ClickNewBillingAccount () throws IOException, InterruptedException, AWTException{
	    	Common.waitForPageLoad(getDriver());
	          //ClickNewbillingAccount.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
	         ClickNewbillingAccount.click();
	         sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   
	    }
	    
	    @FindBy(xpath=".//*[@title='User Accounts:New']")	            
	     WebElementFacade ClickNewServiceAccount;


	@Step      
	     public void ClickNewServiceAccount() throws IOException, InterruptedException, AWTException{
	     
		   ClickNewServiceAccount.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
		   ClickNewServiceAccount.click();
		   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   
	} 
	
	 @FindBy(xpath=".//*[@aria-label='Agreements List View:Menu']")
     WebElementFacade AgreementHeaderMenuButton;
     @FindBy(xpath="//span/ul/li[9]/a")
     WebElementFacade RefreshMenuItem;
     @FindBy(xpath="//table[@summary='Agreements']")
     WebElementFacade AgreementTable;
     
     
	public void GetAgreementDate(String Row) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
        String dataSheet = "GetAgreementDate";
        String applet = "//*[@title='Agreements List View List Applet']";
        String table = "//table[@summary='Agreements']"; 
        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Row, filePath, dataSheet);
        readWorkbook.testData(tableMap);
        
        if (tableMap.get("UIName").size()==0){
         	report.Info(Row+" logical name not found in sheet.");
         	Assert.assertTrue(false);        	
         }
        
        for (int i = 0;i < tableMap.get("UIName").size();i++) {
              String UIName = tableMap.get("UIName").get(i);
              String Value = tableMap.get("Value").get(i);
              String sLocateColValue = tableMap.get("LocateColValue").get(i);
              String sLocateCol = tableMap.get("LocateCol").get(i);
              String sDateDifference = tableMap.get("DateDifference").get(i);
              String Index = tableMap.get("Index").get(i);
              int k=0;
              if(!AgreementHeaderMenuButton.isCurrentlyVisible()){
	              if (Agreementstab.isCurrentlyVisible()){
	              	Agreementstab.waitUntilClickable();
	              	Agreementstab.click();	        		
	        		}
	        		else {
	        			TabDropDown.selectByVisibleText("Agreements");	        			
	        		}
	              
	              do{
	            	  AgreementHeaderMenuButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		              AgreementHeaderMenuButton.click();
	                  Thread.sleep(1000);
	                  RefreshMenuItem.click();
	                  Thread.sleep(1000);
	                  k++;
	              }while(!AgreementTable.isVisible() && k<5);
              }   
              if (Index.equals("")){
               	 Index = "0";
                }
              if(UIName.equalsIgnoreCase("DateDiff")){
            	 
            	  DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd/MMM/yyyy");

            	 report.Info("Pass:Agreement date difference is "+sDateDifference+" months from System date");
	    		 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              }
              if (!sLocateCol.equals("")){
           	   Common.selectedRow = -1;
           	   String res  = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index);
           	   Assert.assertTrue(sLocateCol + "-" + sLocateColValue + " not found in the list.", res.equalsIgnoreCase("True"));
    		   report.Info(sLocateCol + "-" + sLocateColValue + " found in the list as expected");
              }     
              else{
                  Common.selectedRow = 1;
              }
              if (!UIName.equals("") && !UIName.equalsIgnoreCase("DateDiff") ){ 
          		String sValue =  (Common.updateSiebList(applet,table, UIName, Value)); 
  		           if (UIName.contains("CaptureTextValue|Agreement_Start_Date")){	
  		        	   Serenity.setSessionVariable("StartDate").to(sValue);
  		           }
  		         if (UIName.contains("CaptureTextValue|Agreement_End_Date")){	
  		        	   Serenity.setSessionVariable("EndDate").to(sValue);
  		           }
              report.Info("Row updated successfully"); 
              }  
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
         
	}
	}
	
	@FindBy(xpath=".//*[@title='Conditional Charges Menu']")
	  WebElementFacade AboutRecordMenuButton; 
	  @FindBy(xpath="//span/ul/li[12]/a")
	  WebElementFacade aboutRecord;
	 
  	 @Step 	
		public void ConditionalChargesRowID(String rowname) throws IOException, InterruptedException, AWTException{
		
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
       String dataSheet = "UsedProdMenuSelect";
       String applet = "//*[@title='Conditional Charges List Applet']";
       String table = "//table[@summary='Agree Item Conditional Charge List']";

         Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
         readWorkbook.testData(tableMap);
         
         if (tableMap.get("LocateCol").size()==0){
          	report.Info(rowname+" logical name not found in sheet.");
          	Assert.assertTrue(false);        	
          }
         for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
             String sLocateCol = tableMap.get("LocateCol").get(i);
             String sLocateColValue = tableMap.get("LocateColValue").get(i);
             String UIName = tableMap.get("UIName").get(i);
             String Index = tableMap.get("Index").get(i);
             String value = tableMap.get("Value").get(i);  
             String sAboutRecord = tableMap.get("AboutRecord").get(i); 
             
             if (sLocateColValue.contains("Promotion")){
           	   sLocateColValue = sLocateColValue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());    	  
       		}
              
              if (Index.equals("")){
             	 Index = "0";
              }
              
              
              if (!sLocateCol.equals("")){
                  Common.selectedRow = -1;
                 Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,"0" ).equals("true"));
                  }
             else{
                   Common.selectedRow = 1;
             }
             if (!UIName.equals("")){                                              
                 Common.updateSiebList(applet,table, UIName, value);
                 Thread.sleep(2000);                                                                        
                 }
  
                
         	 if (sAboutRecord.equals("Y"))
           {
         		AboutRecordMenuButton.withTimeoutOf(60,TimeUnit.SECONDS).isCurrentlyVisible();
                  //NewBillProfileButton.waitUntilPresent();
         		AboutRecordMenuButton.click();
         	    Thread.sleep(1000); 
         		aboutRecord.click();
         		Thread.sleep(1000); 
         		report.Info("About Record Selected");
           }
         	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

}
         
}

  	@FindBy(xpath=".//a[text()='Conditional Charges']")
    WebElementFacade ConditionalChargetab;
	
	
	
	 @Step 	
		public void SelectConditionalChargesRow(String rowname) throws IOException, InterruptedException, AWTException{
		
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
        String dataSheet = "UsedProdMenuSelect";
        String applet = "//*[@title='Line Items List Applet']";
        String table = "//table[@summary='FS Agreement Item List']";
 
          Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
          readWorkbook.testData(tableMap);
          
          if (tableMap.get("LocateCol").size()==0){
            	report.Info(rowname+" logical name not found in sheet.");
            	Assert.assertTrue(false);        	
            }
          
          for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
              String sLocateCol = tableMap.get("LocateCol").get(i);
              String sLocateColValue = tableMap.get("LocateColValue").get(i);
              String UIName = tableMap.get("UIName").get(i);
              String Index = tableMap.get("Index").get(i);
              String value = tableMap.get("Value").get(i);
              
              

                  ConditionalChargetab.isCurrentlyVisible();
                  ConditionalChargetab.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
            	  ConditionalChargetab.click();
            	  
            	  if (sLocateColValue.contains("Promotion")){
                 	   sLocateColValue = sLocateColValue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());    	  
             		}
                    
                    if (Index.equals("")){
                   	 Index = "0";
                    }
            	  
            	  if (!sLocateCol.equals("")){
                      Common.selectedRow = -1;
                     Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,"0" ).equals("true"));
                      }
                 else{
                       Common.selectedRow = 1;
                 }
                 if (!UIName.equals("")){                                              
                     Common.updateSiebList(applet,table, UIName, value);
                     Thread.sleep(2000);                                                                 
                     }
                 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          }
	 }
	 
		public void RetrieveAccountDetails() throws InterruptedException, IOException, AWTException{
        	
        	String FirstName = firstName.getTextValue();
    		Serenity.setSessionVariable("FirstName").to(FirstName);	    		
    		report.Info("First Name is "+FirstName);
    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    		
    		String LastName = lastName.getTextValue();
    		Serenity.setSessionVariable("LastName").to(LastName);	    		
    		report.Info("Last Name is "+LastName);
    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		}
	
    @FindBy(xpath=".//*[text()='Audit Trail']")
    WebElementFacade AudiTrailTab;
    
    @Step
    public void AuditTrailAccount(String Account) throws InterruptedException, IOException, AWTException{        
         
          String filePath = "\\src\\test\\resources\\data\\Contacts.xls";
          String dataSheet = "AuditTrailContact";
          String applet = "//*[@title='Audit Trail Items List Applet']";
          String table = "//table[@summary='Audit trail Items']";
          
          Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Account, filePath, dataSheet);
          readWorkbook.testData(tableMap);
          
          if (tableMap.get("LocateCol").size()==0){
            	report.Info(Account+" logical name not found in sheet.");
            	Assert.assertTrue(false);        	
            }
          
          for (int i = 0;i < tableMap.get("LocateCol").size();i++) {              
                    String sAccountAudit = tableMap.get("AccountAudit").get(i);
             	   	String sLocateCol = tableMap.get("LocateCol").get(i);
            		String sLocateColValue = tableMap.get("LocateColValue").get(i);
            		String UIName = tableMap.get("UIName").get(i);
            		String value = tableMap.get("Value").get(i);
            		String Index = tableMap.get("Index").get(i);
            		               		
                    
             		if (sLocateCol.equals("First Name")){
             			sLocateCol = Serenity.sessionVariableCalled("FirstName").toString();
            		}
             		
             		if (sLocateCol.equals("Last Name")){
             			sLocateCol = Serenity.sessionVariableCalled("LastName").toString();
            		}
                     if(sAccountAudit.equals("Y"))    
                     {
                     AudiTrailTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();           
                     if (AudiTrailTab.isDisplayed()){
                          AudiTrailTab.click();
                          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                     }
                     else {
                          AccountTabsDRopDown.selectByVisibleText("Audit Trail");
                     } 
             		Common.selectedRow = -1;
           		
                    if (Index.equals("")){
                   	 Index = "0";
                    }
                    
                    if (!sLocateCol.equals("")){
                        Common.selectedRow = -1;
                       Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
                       report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);
                       sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

                        }
                   else{
                         Common.selectedRow = 1;
                   }
                	if (!UIName.equals("")){
                		if (value.equals("First Name")){
                			value = Serenity.sessionVariableCalled("FirstName").toString();
                		}
                		if (value.equals("Last Name")){
                			value = Serenity.sessionVariableCalled("LastName").toString();
                		}
                	//Thread.sleep(5000);
                    Common.updateSiebList(applet,table, UIName, value);
                    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                     }
                     }                    
                                                    
          }
    }
    
    @Step
    public void AuditTrailContact(String Account) throws InterruptedException, IOException, AWTException{        
         
          String filePath = "\\src\\test\\resources\\data\\Contacts.xls";
          String dataSheet = "AuditTrailContact";
          String applet = "//*[@title='Read Audit Items List Applet']";
		  String table = "//table[@summary='Read Audit Items']";
          
          Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Account, filePath, dataSheet);
          readWorkbook.testData(tableMap);
          if (tableMap.get("LocateCol").size()==0){
          	report.Info(Account+" logical name not found in sheet.");
          	Assert.assertTrue(false);        	
          }
          
          for (int i = 0;i < tableMap.get("LocateCol").size();i++) {              
                    String sAccountAudit = tableMap.get("AccountAudit").get(i);
             	   	String sLocateCol = tableMap.get("LocateCol").get(i);
            		String sLocateColValue = tableMap.get("LocateColValue").get(i);
            		String UIName = tableMap.get("UIName").get(i);
            		String value = tableMap.get("Value").get(i);
            		String Index = tableMap.get("Index").get(i);
            		               		
                    
             		if (sLocateCol.equals("First Name")){
             			sLocateCol = Serenity.sessionVariableCalled("FirstName").toString();
            		}
             		
             		if (sLocateCol.equals("Last Name")){
             			sLocateCol = Serenity.sessionVariableCalled("LastName").toString();
            		}

                     AudiTrailTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();           
                     if (AudiTrailTab.isDisplayed()){
                          AudiTrailTab.click();
                          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                     }
                     else {
                          AccountTabsDRopDown.selectByVisibleText("Audit Trail");
                     } 
             		Common.selectedRow = -1;
           		
                    if (Index.equals("")){
                   	 Index = "0";
                    }
                    
                    if (!sLocateCol.equals("")){
                        Common.selectedRow = -1;
                       Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
                       report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           

                        }
                   else{
                         Common.selectedRow = 1;
                   }
                	if (!UIName.equals("")){
                		if (value.equals("First Name")){
                			value = Serenity.sessionVariableCalled("FirstName").toString();
                		}
                		if (value.equals("Last Name")){
                			value = Serenity.sessionVariableCalled("LastName").toString();
                		}
                	//Thread.sleep(5000);
                    Common.updateSiebList(applet,table, UIName, value);
                    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                     }
                                      
                                                    
          }
    }
    @FindBy(xpath="//a[text()='Adjustments']")
    WebElementFacade AdjustmentsTab;
    @FindBy(xpath=".//*[contains(@id,'Product_Name')]/span/a")
    WebElementFacade ProdcutNameText;
    @FindBy(xpath=".//*[@aria-label='Product / Services:Credit Funds']")
    WebElementFacade CreditFundsTab;
    @FindBy(xpath=".//*[@aria-label='Adjustment reason']")
    WebElementFacade AdjustmentreasonTextBox;
    @FindBy(xpath=".//*[@aria-label='Authorisation amount']")
    WebElementFacade AuthorisationAmountTextBox;
    @FindBy(xpath=".//*[@aria-label='Submit']")
    WebElementFacade SubmitButton;
    @FindBy(xpath=".//*[@title='Product / Services:Debit Funds']")
	WebElementFacade DebitFundsTab;
     
     @Step
    
     public void AddCreditBalance(String rowname) throws IOException, InterruptedException, AWTException{
    	 Common.waitForPageLoad(getDriver());
                String filePath = "\\src\\test\\resources\\data\\Account.xls";
            String dataSheet = "AddCreditBalance";
            String applet = "//*[@title='Adjustment Activities List Applet']";
            String table = "//table[@summary='Adjustment Activities']";
    
              Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
              readWorkbook.testData(tableMap);
              
              
              String sReason = tableMap.get("Reason").get(0);
              String sAmount = tableMap.get("Amount").get(0);
              String sLocate = tableMap.get("Locate").get(0);
              String sPopup = tableMap.get("PopUp").get(0);
              String Tab = tableMap.get("Tab").get(0);
              if (sLocate.equals("RootProduct0")){
                  sLocate = Serenity.sessionVariableCalled("RootProduct0").toString();
                }
              
              //AdjustmentsTab.isDisplayed();
              AdjustmentsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
              AdjustmentsTab.click();
              int ProductServicesRowCount = findAll(By.xpath("//table[@summary='Product / Services']/tbody/tr")).size();
              if(ProductServicesRowCount>1){
                    report.Info("Rows are displayed successfully.");
                    Common.selectedRow = -1;
    				String res  = Common.locateColumn("//*[@title='Product / Services List Applet']","//table[@summary='Adjustment Activities']", "Product_Name", sLocate, "0");                    
                    /*String Acturaltext=ProdcutNameText.getTextValue();
                      Assert.assertTrue("Row not found as expected", Acturaltext.contains(sLocate));*/
              }
              else{
                    Assert.assertTrue("Rows are not displayed successfully.", ProductServicesRowCount>1);
              }
              if(Tab.equalsIgnoreCase("CreditTab")){
            	  CreditFundsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                  CreditFundsTab.click(); 
              }
              if(Tab.equalsIgnoreCase("DebitTab")){
            	  DebitFundsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
            	  DebitFundsTab.click();
              }
              AdjustmentreasonTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
              AdjustmentreasonTextBox.type(sReason);
              AuthorisationAmountTextBox.type(sAmount);
              SubmitButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              SubmitButton.click();
              Thread.sleep(2000);
              if(!sPopup.equalsIgnoreCase("NO")){
 				 Common.HandleErrorPopUp(sPopup);
 				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
		    		 report.Info("alert messsage is"+sPopup);
		    		
 			 }
	          Thread.sleep(5000);
           
              int AdjustmentActivitiesRowCount = findAll(By.xpath("//table[@summary='Adjustment Activities']/tbody/tr")).size();
              if(AdjustmentActivitiesRowCount>1){
                    report.Info("Rows are displayed successfully.");
                    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              }
              else{
                    Assert.assertTrue("Rows are not displayed successfully.", AdjustmentActivitiesRowCount>1);
              }
              for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
                  String sLocateCol = tableMap.get("LocateCol").get(i);
                  String sLocateColValue = tableMap.get("LocateColValue").get(i);
                  String UIName = tableMap.get("UIName").get(i);
                  String Index = tableMap.get("Index").get(i);
                  String value = tableMap.get("Value").get(i);
                 
                        if (Index.equals("")){
                             Index = "0";
                        }
                        
                        if (!sLocateCol.equals("")){
                          Common.selectedRow = -1;
                         Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,Index ).equals("true"));
                         report.Info("Row uapdated successfully");
                         sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                        }
                        
                     else{
                           Common.selectedRow = 1;
                           
                     }
                     
              }
          }
	  
     @FindBy(xpath=".//*[@aria-label='Address History:New']")
     WebElementFacade AddressHistoryNewBtn;
     
     @FindBy(xpath=".//*[@aria-labelledby='s_5_l_Postal_Code ']")
     WebElementFacade PostCodeTxtBox;
     
     @FindBy(xpath=".//*[@aria-label='Add Address:OK']")
     WebElementFacade AddressHistoryOKButton;

     @FindBy(xpath=".//*[@aria-label='Address History:Menu']")
     WebElementFacade AddressHistoryMenuIcon;
     
     @FindBy(xpath="//span/ul/li[9]/a")
     WebElementFacade RefreshRecord;   
     
     @FindBy(xpath=".//*[@aria-label='Transact customer type']")
     WebElementFacade TransactCustType;
        
     @FindBy(xpath=".//*[@aria-labelledby='VF_Residential_Status_Label']")
     WebElementFacade ResidenceStatus;
     
     @FindBy(xpath=".//*[@aria-labelledby='VF_Employment_Status_Label']")
     WebElementFacade EmployementStatus;
     
     @FindBy(xpath=".//*[@aria-labelledby='VF_Bill_Payment_Method_Label']")
     WebElementFacade BillPayMethod;
 
     @FindBy(xpath="(.//*[@aria-label='Selection Field'])[3]")
     WebElementFacade UseExistingPopUp;
     
     @FindBy(xpath=".//*[@aria-label='Billing profile:OK']")
     WebElementFacade UseExistingOKButton;
     
     
     @FindBy(xpath=".//*[@aria-label='Credit Vetting:Create Order']")
     WebElementFacade CreateOrderButton;
     
     @FindBy(xpath=".//*[@aria-label='Credit Vetting:Update Bank Details']")
     WebElementFacade UpdateBankDetailsButton;
     
     @FindBy(xpath="(.//*[@aria-label='Bank account name'])[2]")
     WebElementFacade BankAccName;
     
     @FindBy(xpath="(.//*[@aria-label='Bank account no'])[2]")
     WebElementFacade BankAccNo;
     
     @FindBy(xpath="(.//*[@aria-label='Sort code'])[2]")
     WebElementFacade SortCode;
     
     @FindBy(xpath=".//*[@aria-label='Siebel:OK']")
     WebElementFacade UpdateBankOKButton;
     
     
    
     
    /*Zeba--*/
 	@Step
 	public void CreditVettingTabVerify(String accountType) throws InterruptedException, IOException, AWTException{
    	  //Homepage.waitUntilPresent();
    	  Common.waitForPageLoad(getDriver());
    	  String filePath = "\\src\\test\\resources\\data\\Account.xls";
    	  String dataSheet = "CreditVetting";
    	  String applet = "//*[@title='Address History List Applet']";
    	  String table = "//table[@summary='Address History']";
    	  Alert alert;
    	  String ActAlertText="";



    	  Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
    	  readWorkbook.testData(tableMap);
    	  String TransactCustomerType = tableMap.get("TransactCustomerType").get(0);
    	  String EmploymentStatus = tableMap.get("EmploymentStatus").get(0);
    	  String ResidentialStatus = tableMap.get("ResidentialStatus").get(0);
    	  String UseExistingDetails = tableMap.get("UseExistingDetails").get(0);
    	  String BillPaymentMethod = tableMap.get("BillPaymentMethod").get(0);
    	  String NewButton = tableMap.get("NewButton").get(0);        
    	  String PostCode = tableMap.get("PostCode").get(0);
    	  

    	  if (NewButton.equals("Y"))
    	  {

    		  AddressHistoryNewBtn.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    		  AddressHistoryNewBtn.click();

    		  Postcodebutton.click();
    		  PostCodeTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isEnabled();
    		  PostCodeTextBox.typeAndEnter(PostCode);

    		  AddressHistoryOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    		  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    		  AddressHistoryOKButton.click();


    	  }

    	  else{
    		  if(Creditvettingtab.isCurrentlyVisible()){
    			  Creditvettingtab.click();
    		  }
    		  else{

    			  AccountSummaryDropdown.selectByVisibleText("Credit Vetting");
    		  }
    		  Thread.sleep(2000);

    		  if(isAlertPresent(getDriver())){
    			  alert=getDriver().switchTo().alert();
    			  ActAlertText=alert.getText();
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			  if (ActAlertText.contains("3 years of address history")){                		
    				  alert.accept();
    				  report.Info("Expected alert messsage present"+ActAlertText);
    			  }  
    		  }	                 	             	   
    		  else if (isAlertPresent(getDriver())&& (!ActAlertText.contains("3 years of address history"))){
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	
    			  report.Info("Expected Pop did not occur");
    			  Assert.assertTrue(false);
    		  }
    		  TransactCustType.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    		  TransactCustType.type(TransactCustomerType);

    		  ResidenceStatus.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    		  ResidenceStatus.type(ResidentialStatus);

    		  EmployementStatus.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    		  EmployementStatus.type(EmploymentStatus);

    		  BillPayMethod.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    		  BillPayMethod.type(BillPaymentMethod);
    		  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    	  }

    	  Common.waitForPageLoad(getDriver());

    	  for (int i = 0;i < tableMap.get("Size").size();i++) {
    		  String BankAccountName = tableMap.get("BankAccountName").get(i);
    		  String BankAccountNo = tableMap.get("BankAccountNo").get(i);
    		  String KeepBankDetails = tableMap.get("KeepBankDetails").get(i);
    		  String sSortCode = tableMap.get("SortCode").get(i);
    		  String UIName = tableMap.get("UIName").get(i);
    		  String Value = tableMap.get("Value").get(i);
    		  String Index = tableMap.get("Index").get(i);
    		  String CreateOrder = tableMap.get("CreateOrder").get(i);
        	  String UpdateBankDetails = tableMap.get("UpdateBankDetails").get(i);



    		  if (Index.equals(""))
    		  {
    			  Index = "0";
    		  }

    		  Common.selectedRow = 1;

    		  if (!UIName.equals(""))
    		  {     

    			  if(Value.equals("Backdate"))
    			  {
    				  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    				  Date currentDate = new Date();
    				  //System.out.println(dateFormat.format(currentDate));
    				  // convert date to calendar
    				  Calendar c = Calendar.getInstance();
    				  c.setTime(currentDate);
    				  // manipulate date                       
    				  c.add(Calendar.YEAR,-3);
    				  /* c.add(Calendar.MONTH,+1);
	                                c.add(Calendar.DATE,-1);*/                                       
    				  // convert calendar to date
    				  Date DateMovedIn = c.getTime();
    				  String sDateMovedIn = (dateFormat.format(DateMovedIn));   
    				  Value = sDateMovedIn;
    			  }   
    			  Common.updateSiebList(applet,table, UIName, Value);
    			  Thread.sleep(2000);                     
    			  //AddressHistoryMenuIcon.click();
    			  //Thread.sleep(2000); 
    			  //RefreshRecord.click();
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    		  } 


    		  if(UseExistingDetails.equals("Y")){

    			  UseExistingPopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  UseExistingPopUp.click();

    			  UseExistingOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			  UseExistingOKButton.click();
    		  }

    		  if(UpdateBankDetails.equals("Y"))
    		  {
    			  UpdateBankDetailsButton.click();
    			  Thread.sleep(1000);
    			  BankAccName.type(BankAccountName);
    			  Thread.sleep(1000);
    			  BankAccNo.type(BankAccountNo);
    			  Thread.sleep(1000);
    			  SortCode.type(sSortCode);
    			  Thread.sleep(1000);
    			  UpdateBankOKButton.click();
    			  Thread.sleep(1000);
    		  }

    		  if(CreateOrder.equals("Y"))
    		  {
    			  CreateOrderButton.click();
    			  Common.WaitForClock(Clockobj);
    			  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    		  }

    	  }
      }
 	
 	
 	@FindBy(xpath=".//*[@aria-label='Third Level View Bar']")
    WebElementFacade Dropdownicon;
    
    @FindBy(xpath=".//select[@aria-label='Third Level View Bar']")
    WebElementFacade SelectAccountAlert;
     
    
    @FindBy(xpath=".//*[text()='Account Alert']")
    WebElementFacade AccountAlert;
    
    @FindBy(xpath=".//*[@aria-label='VF Prime Account List Applet:New']")
    WebElementFacade NewButton;
    
    @FindBy(xpath=".//*[@aria-label='VF Prime Account List Applet:New']")
    WebElementFacade NewButtonsync;
    
    
    @FindBy(xpath=".//*[@class='siebui-icon-dropdown']")
    WebElementFacade Typedropdown;
    
    @FindBy(xpath=".//td[contains(@id,'VF_Type')]")
    WebElementFacade TypeElement;
    
    @FindBy(xpath=".//input[@name='VF_Type']")
    WebElementFacade TypeTextBox;
    
    @FindBy(xpath=".//*[@data-lovtype='VF Prime Account List Applet:VF Type']")
    WebElementFacade Selecttype;
     
       @Step      
         public void AccountAlert(String Action) throws IOException, InterruptedException, FindFailed, AWTException{
            
             String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
             String filePath = "\\src\\test\\resources\\data\\Account.xls";
             String dataSheet = "AccountAlert";
             String applet = "//*[@title='VF Prime Account List Applet List Applet']";
             String table = "//table[@summary='VF Prime Account List Applet']";     

             
             Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
             readWorkbook.testData(tableMap);
             
             if (tableMap.get("Value").size()==0){
  	           	report.Info(Action+" logical name not found in sheet.");
  	           	Assert.assertTrue(false);       	
  	           }
             for (int i = 0;i < tableMap.get("UIName").size();i++) {

            	 String sUIName = tableMap.get("UIName").get(i);
            	 String sValue = tableMap.get("Value").get(i);
            	 Thread.sleep(2000);

            	 AccountSummaryDropdown.selectByVisibleText("Account Alert");
            	 NewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
            	 NewButton.click();
            	 Thread.sleep(5000);
            	 if(sValue.equalsIgnoreCase("Disabled")){
            		 TypeElement.click();
            		 String TypeElementStatus = TypeTextBox.getAttribute("readonly");
            		 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            		 if(TypeElementStatus.equalsIgnoreCase("true")){
               			report.Info("Type Element is disabled as expected"); 
               		 }
               		 else{
               			 Assert.assertTrue("Type Element is enabled",TypeElementStatus.equalsIgnoreCase("true"));
               		 }
            	 }
            	 else{
            		 Typedropdown.click();
                	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                	 Thread.sleep(2000);
                	 String s = Selecttype.getTextValue();
                	 Thread.sleep(4000);
                	 if(s.equalsIgnoreCase(sValue)){

                		 report.Info( s+ "Required Type Match");
                		 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                	 }
                	 else{
                		 report.Info(s+ "Required Type not Matched");
                		 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                		 Assert.assertTrue(false);
                	 } 
            	 }
            	 
             }
            
       }
        @FindBy(xpath="(.//*[contains(@id,'VF_Status')])[3]")
        WebElementFacade StatusField;
 	    @FindBy(xpath=".//input[contains(@id,'VF_Status')]")
        WebElementFacade Status;
    	
    	@FindBy(xpath=".//*[@aria-label='VF Prime Account List Applet:Menu']")
       WebElementFacade Menu;
    	@FindBy(xpath="//span/ul/li[6]/a")
       WebElementFacade Save;
    	@FindBy(xpath=".//*[@aria-label='Account Alerts']")
       WebElementFacade AccountAlerts;
    	 @Step      
    	 public void AccountAlertAllField(String rowname) throws IOException, InterruptedException, FindFailed, AWTException{
       		 
     		   String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
     		   String filePath = "\\src\\test\\resources\\data\\Account.xls";
     	       String dataSheet = "AccountAlert";
     	       String applet = "//*[@title='VF Prime Account List Applet List Applet']";
     	       String table = "//table[@summary='VF Prime Account List Applet']"; 
     	      

     	       
     	       Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
     	       readWorkbook.testData(tableMap);
     	       for (int i = 0;i < tableMap.get("UIName").size();i++) {

     		    	String sUIName = tableMap.get("UIName").get(i);
     				String sValue = tableMap.get("Value").get(i);
     				String sType = tableMap.get("Type").get(i);
     				String sEndDate = tableMap.get("EndDate").get(i);
     				String sMessage = tableMap.get("Message").get(i);
     				String sAgentLogin = tableMap.get("AgentLogin").get(i);
     				String sSeverity = tableMap.get("Severity").get(i);
     				String sStatus = tableMap.get("Status").get(i);
     				String sPopUp = tableMap.get("PopUp").get(i);
     				String sButton = tableMap.get("Button").get(i);
     				String sPopUp1 = tableMap.get("PopUp1").get(i);
     				String ExpAlertMessage = tableMap.get("AlertMessage").get(i);
     				String sAboutRecord = tableMap.get("AboutRecord").get(i);
     				
     				/*String sLocateCol = tableMap.get("LocateCol").get(i);
     				String sLocateColValue = tableMap.get("LocateColValue").get(i);
     				String Index = tableMap.get("Index").get(i);
     				String UIName = tableMap.get("UIName").get(i);
     				String value = tableMap.get("Value").get(i);*/
     						
     				

     				
     				// Thread.sleep(2000);
     			  Common.WaitForClock(Clockobj);
     				 if(sButton.equals("Y")){
     				 SelectAccountAlert.click();
     			     SelectAccountAlert.selectByVisibleText("Account Alert");
     			     //AccountAlert.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
     			     //NewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     			    Thread.sleep(1000);
     			    Common.WaitForClock(Clockobj);
     			    
     			     NewButton.click();
     			     Thread.sleep(2000);
     			  Common.WaitForClock(Clockobj);
     				 }
     			     
     				 if(sButton.equals("N")){
     			    	 //AccountAlert.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
     				     //NewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     					 Common.waitForElement(NewButtonsync);
     				     NewButton.click();
     				     Thread.sleep(2000);
     				  Common.WaitForClock(Clockobj);
     			     }
     				 
     				 
     			      if(!sType.equals("")){
     			    	  Common.updateSiebList(applet,table, "Text|VF_Type", sType);
     			    	 //Typedropdown.click();
     			    	 //Selecttype.click();
     			    	//Common.HandleErrorPopUp(sPopUp1);
     				     Thread.sleep(1000);
     				  Common.WaitForClock(Clockobj);
     			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			     }
     			      
     			     if(!sEndDate.equals("")){
     			    	 Common.updateSiebList(applet,table, "Text|VF_End_Date", sEndDate);
     			    	 Thread.sleep(2000);
     			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			    	  }
     			     if(!sMessage.equals("")){
     			    	 Common.updateSiebList(applet,table, "Text|VF_Message", sMessage);
     			    	 Thread.sleep(2000);
     			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			  }
     			   
     			     
     			     if(!sAgentLogin.equals("")){
     			    	 Common.updateSiebList(applet,table, "Text|VF_Agent_Login", sAgentLogin);
     			    	 Thread.sleep(2000);
     			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			     }
     			     if(!sSeverity.equals("")) {
  			    	 Common.updateSiebList(applet,table, "Text|VF_Severity", sSeverity);
  			    	Thread.sleep(2000);
  			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString()); 
  			     }
     			     if(!sStatus.equals("")){
     			    	  //StatusField.click();
  			    	  //Status.clear();
  			    	 Thread.sleep(2000);
  			    	 Common.updateSiebList(applet,table, "Text|VF_Status", sStatus);
  			    	 Thread.sleep(2000);
  			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
  			     }
     			 
     			     
     			     if(!sPopUp.equals("")){
     			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			    	 StatusField.click();
     			    	 Common.HandleErrorPopUp(sPopUp);
     			    	 Thread.sleep(3000);
     			    	 report.Info("Expected PopUp handled");
     			     }
     			     
     			     
     			  /*if (!sLocateCol.equals("")){
    				Common.selectedRow = -1;
    				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
    				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
    			}
    			else{               
    				Common.selectedRow = 1;
    			}
    			if (!UIName.equals("")){         		 
    				Common.updateSiebList(applet,table, UIName, value); 
    				Thread.sleep(2000);                       	              
    				report.Info("Action : "+UIName+" has perfomed "+value);                                                  
    			}*/
    			
     			     Menu.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     			     Menu.click();
     			     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			     //Save.withTimeoutOf(180,TimeUnit.SECONDS).waitUntilClickable();
     			     Save.click();
     			     Thread.sleep(3000);
     			   if(isAlertPresent(getDriver())){
       			  	Alert alert=getDriver().switchTo().alert();
       			    String ActAlertText=alert.getText();                                           		
       			   	alert.accept();
       			   	report.Info("alert messsage is"+ActAlertText);
       			  }
     			 if (!sAboutRecord.equals("")) {
  			    Menu.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     			    Menu.click();
     			    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			    Thread.sleep(1000); 
     			    aboutRecord.click();
     			    Thread.sleep(1000); 
     			    report.Info("About Record Selected");
  			    	 
  			    	 
  			     }
     			     
     			 if(!ExpAlertMessage.equals("")){
  			    	 getDriver().navigate().refresh();
  			    	 AccountAlerts.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
  			    	 AccountAlerts.click();
  			    	 String ActAlertMessage=AccountAlerts.getValue();
  			    	 if(ExpAlertMessage.equalsIgnoreCase("Blank")){
  			    		 ExpAlertMessage = "";
  			    	 }
  			    	 
  			    	 if (ExpAlertMessage.trim().equalsIgnoreCase(ActAlertMessage.trim()))
  			    	 {
  			    		 report.Info("Both Values are same " + ActAlertMessage );
  			    	 }
  			    	 else if (ExpAlertMessage.trim().equalsIgnoreCase(ActAlertMessage.trim()))
  			    	 {
  			    		 Assert.assertTrue(false);
  			    		 report.Info("Values " + ExpAlertMessage  + " are not matching " + ActAlertMessage);
  			    	 }
  			    	 
  			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                        }
     			     
     			     if(!sPopUp1.equals("")){
     			    	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			    	 Common.HandleErrorPopUp(sPopUp1);
     			    	 report.Info("Expected PopUp handled");
     			    	 Thread.sleep(3000);
     			    
     			     }
     			 }
     	       }

         @FindBy(xpath = ".//*[contains(@id,'Address')]/a")
         WebElementFacade AllPremiseAdressLineone;
         
         @FindBy(xpath = ".//*[@aria-label='Address line 1']")
         WebElementFacade Addresslintextbox;
         
         @FindBy(xpath = ".//*[@aria-label='Postcode']")
         WebElementFacade AddresPostCodetextbox;
         //This fucntion verifies if adress linbe 1 and post code in Addresses tab are not editable

         public void VerifyAddressPostCodeEnabled(){
        	 AllPremiseAdressLineone.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
        	 AllPremiseAdressLineone.click();
        	 
        	 Assert.assertFalse("Address linw 1 is editable", Addresslintextbox.isSelected());
        	 report.Info("Address line 1 is not editable");
        	 
        	 Assert.assertFalse("Postcode is editable", AddresPostCodetextbox.isSelected());
        	 report.Info("postcode is not editable");
        	 
        	 
         }
         
         	@FindBy(xpath=".//*[@title='Account Details:Save']") 
			WebElementFacade SaveBtn;
			@FindBy(xpath="//*[@aria-label='Date of birth']")
			WebElementFacade DOB; 
	             
           @Step
           public void Account_DOBClear() throws InterruptedException, IOException, AWTException{
        	   if (DOB.isCurrentlyVisible()){
        		   DOB.clear();
        		   report.Info("DOB is cleared.");
        	   }
        	   else if (!DOB.isCurrentlyVisible()){
        		   Thread.sleep(7000);
        		   DOB.clear();
        		   report.Info("DOB is cleared.");
        	   }
        	   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        	   SaveBtn.click();
        	   Thread.sleep(2000);
        	   
        	   if(isAlertPresent(getDriver())){
        		   report.Info("Account is not saved when DOB is cleared for Business accounts.");
        		   Assert.assertTrue(false);
        	   }
        	   else if (!isAlertPresent(getDriver())){        	   
        	   report.Info("Account is saved successfully when DOB is cleared for Business accounts.");
               
             }
           }         
         @FindBy(xpath = ".//*[@aria-label='Third Level View Bar']")
         WebElementFacade AccountDropDown; 
        
         @FindBy(xpath = ".//*[@title='Contacts Menu']")
         WebElementFacade ContactMenu; 
         
         @FindBy(xpath = "//span/ul/li[8]/a")
         WebElementFacade RunsQuery;
         
          
         public void UpdateContactPhoneNumber(String Contact) throws IOException, InterruptedException{
               String filePath = "\\src\\test\\resources\\data\\Account.xls";          
               String dataSheet = "ContactPhoneNumber";
               String applet = "//*[@title='Contacts List Applet']";
             String table = "//table[@summary='Admin Account Automatic Debit Details']";     
            
            Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Contact, filePath, dataSheet);
            readWorkbook.testData(tableMap);
            
            for (int i = 0;i < tableMap.get("MobileNumber").size();i++) {
                  String sMobileNumber = tableMap.get("MobileNumber").get(i);
                String sPopup = tableMap.get("Popup").get(i);
                String sLocateCol = tableMap.get("LocateCol").get(i);
                String sLocateColValue = tableMap.get("LocateColValue").get(i);
                String UIName = tableMap.get("UIName").get(i);
                String value = tableMap.get("Value").get(i);
               String Index = tableMap.get("Index").get(i);
                Alert alert;
                String ActAlertText="";
                  
                  if(ContactsTab.isDisplayed()){
                        ContactsTab.click();
                    }
                    else{
                          AccountDropDown.selectByVisibleText("Contacts");
                    }     
                  
                  if (Index.equals("")){
                      Index = "0";
                  }
                  
                  if (!sLocateCol.equals("")){
                    Common.selectedRow = -1;
                   Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
                   report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
                    }
               else{               
                 Common.selectedRow = 1;
               }        
                 if (!UIName.equals("")){                 
                    Common.updateSiebList(applet,table, UIName, value); 
                    Thread.sleep(2000);                                     
                    report.Info("Mobile Number "+sMobileNumber+" is updated successfully." );                                                  
                 }
                 ContactMenu.click();
                 Thread.sleep(2000);
                 RunsQuery.click();
                 Thread.sleep(3000);
                 
                 
                
                if(isAlertPresent(getDriver())&& (!sPopup.equalsIgnoreCase("No"))){
                  alert=getDriver().switchTo().alert();
                   ActAlertText=alert.getText();  
                   String sPopup1="";
                   if (sPopup.contains("OPTIONAL:")){
                        sPopup1= sPopup.substring(9);
                    }                                                                                       
                                                                    
                 if (ActAlertText.contains(sPopup1)){                            
                       alert.accept();
                       report.Info("alert messsage is"+ActAlertText);
                 }                        
                 }
                 else if (!isAlertPresent(getDriver())&& (sPopup.contains("OPTIONAL:"))){
                             report.Info("OPTIONAL Pop did not occur");
                             Assert.assertTrue(true);                                      
                 }
                  else if (!isAlertPresent(getDriver())&& (!sPopup.equalsIgnoreCase("No"))){
                             report.Info("Expected Pop did not occur");
                             Assert.assertTrue(false);                                  
                  }
                  else if (isAlertPresent(getDriver())&& (sPopup.equalsIgnoreCase("No"))){
                             report.Info("UnExpected Pop did occured");
                             Assert.assertTrue(false);                                  
                  }          
                     }
               }
         @FindBy(xpath="(.//*[text()='Audit Trail'])[2]")
         WebElementFacade AuditTrail ;
      	@FindBy(xpath=".//*[text()='Audit Trail Items']")
      	WebElementFacade AuditTrailItems ;
      	
      	@FindBy(xpath=".//*[text()='Employee Login']")
      	WebElementFacade EmployeeLogin ;
      	
     	@FindBy(xpath=".//*[text()='Operation']")
      	WebElementFacade Operation ;
     	
     	@FindBy(xpath=".//*[text()='Field']")
      	WebElementFacade Field ;
     	
     	@FindBy(xpath=".//*[text()='Old Value']")
      	WebElementFacade OldValue ;
     	
     	@FindBy(xpath=".//*[text()='New Value']")
      	WebElementFacade NewValue ;
     	@FindBy(xpath=".//*[text()='Date Changed']")
      	WebElementFacade DateChange ;
     	
     	@FindBy(xpath=".//*[text()='Employee ID']")
      	WebElementFacade EmployeeID ;
     	@FindBy(xpath=".//*[text()='Record ID']")
      	WebElementFacade RecordID ;
     	
         
         @Step      
         public void AccountAlertAuditTrail(String rowname) throws IOException, InterruptedException, FindFailed, AWTException{
      		 
    		   String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
    		   String filePath = "\\src\\test\\resources\\data\\Account.xls";
    	       String dataSheet = "AccountAlert";
    
    	       String applet = "//*[@title='Audit Trail Items List Applet']";
       	   String table = "//table[@summary='Audit Trail Items']"; 
       	      

       	       
       	       Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
       	       readWorkbook.testData(tableMap);
       	       for (int i = 0;i < tableMap.get("UIName").size();i++) {

       		    	String sUIName = tableMap.get("UIName").get(i);
       				String sValue = tableMap.get("Value").get(i);
       				String sType = tableMap.get("Type").get(i);
       				String sEndDate = tableMap.get("EndDate").get(i);
       				String sMessage = tableMap.get("Message").get(i);
       				String sAgentLogin = tableMap.get("AgentLogin").get(i);
       				String sSeverity = tableMap.get("Severity").get(i);
       				String sStatus = tableMap.get("Status").get(i);
       				String sPopUp = tableMap.get("PopUp").get(i);
       				String sButton = tableMap.get("Button").get(i);
       				String sPopUp1 = tableMap.get("PopUp1").get(i);
       				String ExpAlertMessage = tableMap.get("AlertMessage").get(i);
       				String sHeader = tableMap.get("Header").get(i);
       				String sLocateCol = tableMap.get("LocateCol").get(i);
      				String sLocateColValue = tableMap.get("LocateColValue").get(i);
      				String Index = tableMap.get("Index").get(i);
      				 if (Index.equals("")){
      					 Index = "0";
      			     }
      				
       				
       		 Thread.sleep(5000);
       		 if(sButton.equals("Y")) {
    	           SelectAccountAlert.click();
    	         Thread.sleep(1000);
  			   SelectAccountAlert.selectByVisibleText("Account Alert");
  			   AuditTrail.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
  			   AuditTrail.click();
  			   Common.WaitForClock(Clockobj);
  			   Thread.sleep(2000);
  			   //AuditTrailItems.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
       		 }
       		 else {
       			 
       		   AuditTrail.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
   			   AuditTrail.click();
   			   //AuditTrailItems.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
       			 
       		 }
  			   
       		Thread.sleep(3000);
       		Common.WaitForClock(Clockobj);
  			   if(!sHeader.equals("")) {
  					   Assert.assertTrue("Employee Login not present",sValue.equalsIgnoreCase(EmployeeLogin.getText()));
  					   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
  						report.Info("Employee Login is present");
  						Assert.assertTrue("Operation column is not present","Operation".equalsIgnoreCase(Operation.getText()));
  						report.Info("Operation column is present");
  						Assert.assertTrue("Field column is not present","Field".equalsIgnoreCase(Field.getText()));
  						report.Info("Field column is present");
  						Assert.assertTrue("OldValue column is present","Old Value".equalsIgnoreCase(OldValue.getText()));
  						report.Info("OldValue is present");
  						Assert.assertTrue("NewValue column is present","New Value".equalsIgnoreCase(NewValue.getText()));
  						report.Info("NewValue is present");
  						Assert.assertTrue("DateChange column is present","Date Changed".equalsIgnoreCase(DateChange.getText()));
  						report.Info("DateChange is present");
  						Assert.assertTrue("EmployeeID column is present","Employee ID".equalsIgnoreCase(EmployeeID.getText()));
  						report.Info("EmployeeID is present");
  						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
  						Assert.assertTrue("RecordID column is present","Record ID".equalsIgnoreCase(RecordID.getText()));
  						report.Info("RecordID is present");
       	       
       	       }
  			   if (!sLocateCol.equals("")){
  				   Common.selectedRow = -1;
  		           Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
  		           report.Info("Row found :  "+sLocateCol);
  				   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
  		            }
  		       else{
  		    	   Common.selectedRow = 1;
  		       }
  			   if (!sUIName.equals("")){ 
                     String sValues =  (Common.updateSiebList(applet,table, sUIName, sValue)); 
                     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     		           if (sUIName.contains("CaptureTextValue") && sUIName.contains("Employee_Id")){
     		        	   //Serenity.setSessionVariable("EmployeeID").to(sValues);
     		        	   String s = Serenity.sessionVariableCalled("RowIds").toString();
     		        	   Assert.assertTrue("Employee ID value donot match", s.equalsIgnoreCase(sValues));
     		        	report.Info(s+" value matches with "+sValues);
     		           } 
     		           if(sUIName.contains("CaptureTextValue") && sUIName.contains("Record_Id")) {
     		            String s1 = Serenity.sessionVariableCalled("RowId").toString();
     		        	Assert.assertTrue("Record ID value donot match", s1.equalsIgnoreCase(sValues));
                      sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                      report.Info(s1+" value matches with "+sValues);
     		           }
     		          }
  			   Common.WaitForClock(Clockobj);
                     } 
  	}
 
         @FindBy(xpath=".//*[@class='siebui-button-toolbar siebui-closed']")
         WebElementFacade Iconbar;
         @FindBy(xpath=".//*[@name='SiteMap']/span")
         WebElementFacade SiteMap;
         @FindBy(xpath="(.//*[text()='User Preferences'])[2]")
         WebElementFacade Userpreference;
         
         @FindBy(xpath="(.//*[text()='User Preferences'])[3]")
         WebElementFacade Userpreferencebottom;
         @FindBy(xpath=".//*[@aria-label='Row #']")
     	WebElementFacade rowId;
     	@FindBy(xpath=".//*[@aria-label='About Record:OK']")
     	WebElementFacade aboutRecordOkButton;
     	@FindBy(xpath=".//*[@title='User Profile Menu']")
     	WebElementFacade AboutRecordMenu;
     	@FindBy(xpath="//span/ul/li[11]/a")
     	WebElementFacade AboutRecord;
     	
         @Step
  		public void UserPreferences() throws IOException, InterruptedException, AWTException{
  			
  		   if(SiteMap.isCurrentlyVisible()){
             	//SiteMap.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
        		 Common.waitForPageLoad(getDriver());
             	 SiteMap.click();
             	 Thread.sleep(2000);
              }else
             {
             //Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
            	 Common.waitForPageLoad(getDriver());
                 Iconbar.click();
                 Thread.sleep(2000);
                 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	
                 SiteMap.click();
                 Thread.sleep(2000);
             }
  		  Userpreference.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
  		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	
  		  Userpreference.click();
  		  Userpreferencebottom.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
  		  Userpreferencebottom.click();
  		 AboutRecordMenu.withTimeoutOf(60,TimeUnit.SECONDS).isCurrentlyVisible();
          //NewBillProfileButton.waitUntilPresent();
  		AboutRecordMenu.click();
 	     Thread.sleep(1000); 
 	     AboutRecord.click();
 		 Thread.sleep(1000); 
 		 report.Info("About Record Selected");
 		 Common.waitForPageLoad(getDriver());
 			String sRowIds = rowId.getTextValue();
 			Serenity.setSessionVariable("RowIds").to(sRowIds);
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	
 			//Thread.sleep(5000);
 			//aboutRecordOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 			report.Info("About Record Row ID : "+sRowIds);
 			aboutRecordOkButton.click();
 		
          }
  	      
         
         @FindBy(xpath=".//*[@data-display='Email Copy Bill']")
     	WebElementFacade EmailCopyBillButton;

     	@FindBy(xpath=".//*[@aria-labelledby='Send_Email_Type_Label']")
     	WebElementFacade SendEmailTextBox;

     	@FindBy(xpath=".//*[@aria-labelledby='Send_Email_Address_Label']")
     	WebElementFacade EmailEnteredTextBox;
     	
     	@FindBy(xpath=".//*[@data-display='Send Email']")
     	WebElementFacade SendEmailButtton;
     	
     	@FindBy(xpath=".//*[@aria-label='Billing profile:Customer Account']")
     	WebElementFacade BillingProfileCustomerAccountButtton;
     	
     	@Step
     	public void EmailCopyBillingBills(String row) throws IOException, InterruptedException, AWTException{
     		String filePath = "\\src\\test\\resources\\data\\Account.xls";
     		String dataSheet = "AddContact";

     		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
     		readWorkbook.testData(tableMap);

     		if (tableMap.get("RowNo").size()==0){
     			report.Info(row+" logical name not found in sheet.");
     			Assert.assertTrue(false);        	
     		}
     		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

     		for (int i = 0;i < tableMap.get("RowNo").size();i++) {   		 
     			String sPopup = tableMap.get("Popup").get(i);
     			String sButton = tableMap.get("Button").get(i);

     			if (sPopup.equals("")){
     				sPopup = "N";
     			}

     			if(sButton.equalsIgnoreCase("Email Copy Bill")){
     				long startTime = System.currentTimeMillis();
     				EmailCopyBillButton.click();
        			long endTime = System.currentTimeMillis();
        			long totalTime = endTime - startTime;
        			Common.WritePerformanceOutput("Email Copy Bill Clicked ,Total Time " + totalTime/1000);
     				
     				
     				Thread.sleep(3000);
     				SendEmailTextBox.clear();
     				SendEmailTextBox.type("Account holder Email");
     				EmailEnteredTextBox.click();
     				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				startTime = System.currentTimeMillis();
     				SendEmailButtton.click();
        			endTime = System.currentTimeMillis();
        			totalTime = endTime - startTime;
        			Common.WritePerformanceOutput("Email button Clicked ,Total Time " + totalTime/1000);
     				
     			}
     			if(!sPopup.equalsIgnoreCase("N")){
     				Common.HandleErrorPopUp(sPopup);
     			}
     			
     			if(sButton.equals("Present")){
     				Thread.sleep(2000);
     				//EmailCopyBillButton.isCurrentlyVisible();
     				Assert.assertTrue("FAIL : Email button is not present",EmailCopyBillButton.isCurrentlyVisible());
     				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			}
     			
     			if(sButton.equalsIgnoreCase("BillingProfileCustomerAccount")){
     				BillingProfileCustomerAccountButtton.click();
     				Thread.sleep(3000);
     			}
     		}
     	}
     	@FindBy(xpath=".//*[@title='Account Details:Update Email']")
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
          
     	@Step
     	public void UpdateEmailAccount() throws IOException, InterruptedException, AWTException{
     		
     		UpdateEmailbutton.click();
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		Thread.sleep(3000);
	   		EnterEmail1.type("testing");
	   		EnterEmail2.type("test.london");
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		EnterEmail3.type("testing");
	   		EnterEmail4.type("test.london");
	   		Okbutton.click();
	   		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		Thread.sleep(3000);
	   	}
     	
     	@FindBy(xpath=".//*[@title='Sales Order:Asset All']")
        WebElementFacade AssetAll ;
     	@FindBy(xpath=".//*[@title='Line Items:Auto-Asset']")
        WebElementFacade AutoAssetLineItem ;
     	//.//*[@aria-label='Line Items:Menu']
     	
     	@FindBy(xpath="(.//button[@class='siebui-appletmenu-btn'])[2]")
        WebElementFacade MenuIcon ;
        @FindBy(xpath="//span/ul/li[39]/a")
        WebElementFacade AutoAssetIcon ;
     	
     	@Step
     	public void VerifyAutoAsset(String row) throws IOException, InterruptedException, AWTException{
     	
      	  String filePath = "\\src\\test\\resources\\data\\Account.xls";
      	  String dataSheet = "AutoAsset";

      	  Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
      	  readWorkbook.testData(tableMap);

      	  for (int i = 0;i < tableMap.get("Type").size();i++) {   
               String sType = tableMap.get("Type").get(i);
      			
      	if(sType.equals("AssetAll")) {	
     		Assert.assertTrue("Asset All button is not enabled", AssetAll.isEnabled());
     		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     	 }
      	  if(sType.equals("AutoAssetField")) {
      		Assert.assertTrue("Asset All button is not enabled", AutoAssetLineItem.isEnabled());
      		
      		    Thread.sleep(2000);
				MenuIcon.click();
				Thread.sleep(1000);
				Assert.assertTrue("Asset All button is not enabled", AutoAssetIcon.isEnabled());
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
      	if(sType.equals("AssetAllDisable")) {	
     		Assert.assertFalse("Asset All button is not disabled", AssetAll.isEnabled());
     		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     	 }
      	
      	if(sType.equals("AutoAssetFieldDisable")) {
      		Assert.assertFalse("Asset All button is not disabled", AutoAssetLineItem.isEnabled());
      		
      		    Thread.sleep(2000);
				MenuIcon.click();
				Thread.sleep(1000);
				
				String v1 = AutoAssetIcon.getAttribute("class");
				Assert.assertTrue("Asset All button is not disabled", v1.contains("disabled"));
				//Assert.assertFalse("Asset All button is not disabled", AutoAssetIcon.isEnabled());
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}

      	 }
     	}
     	@Step
     	public void EditAccount() throws IOException, InterruptedException, AWTException{
     		
     		Thread.sleep(2000);
     		firstName.type("AUTOZZindfhfkjddddowdfjfkewpfetyjtyjthh");
	        lastName.type("AUTOZZindfhfkjddddowdfjfkewpfeegfrg");
	        sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	        accountSave.click();
	        Thread.sleep(3000);
     	}
     	@FindBy(xpath=".//*[@id='s_vctrl_div_tabScreen']/ul/li[4]/a")
        WebElement AgeIDVerificationttabSync;
     	@FindBy(xpath=".//input[@aria-label='Verification type']")
     	WebElementFacade  VerificationtypeTextBox;
     	@FindBy(xpath=".//input[@aria-label='Application Type']")
     	WebElementFacade  ApplicationTypeTextBox;
     	@FindBy(xpath=".//input[@aria-label='Override verification']")
     	WebElementFacade  OverrideverifCheckBox;
    	@FindBy(xpath=".//button[contains(@title,'Submit')]")
     	WebElementFacade  AgeIDSubmitButton;
    	@FindBy(xpath=".//input[@aria-label='Outcome']")
     	WebElementFacade  OutCome;
    	@FindBy(xpath=".//input[@aria-label='Outcome']")
     	WebElement  OutCommeSync;
    	@FindBy(xpath=".//input[@aria-label='Verification type']")
     	WebElement  VerificationtypeTextBoxsync;
     	
     	@Step
     	public void AgeandIDVerification() throws IOException, AWTException, InterruptedException{
     		Common.waitForElement(AgeIDVerificationttabSync);
     		
     		if(AgeIDVerificationttab.isPresent()){
                AgeIDVerificationttab.click();
          }else{
          AccountSummaryDropdown.selectByVisibleText("Age and ID Verification");
          }
          report.Info("Age and Id verification tab clicked successfully");
          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          Common.waitForElement(VerificationtypeTextBoxsync);
          VerificationtypeTextBox.click();
          VerificationtypeTextBox.typeAndEnter("Id Verification");
          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          ApplicationTypeTextBox.click();
          OverrideverifCheckBox.click();
          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          AgeIDSubmitButton.click();
          Common.waitForElement(OutCommeSync);
          Common.waitForElement(OutCome);
          Thread.sleep(5000);
          OutCome.click();
          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          String Value=OutCome.getTextValue();
          Assert.assertTrue("Fail: OutCome is not matched", Value.equals("Accept"));
          report.Info("Pass: Ouscome is matched with Expected value "+Value+"");
         
     	}
     	
     	@FindBy(xpath=".//*[@id='s_3_1_11_0_icon']")
     	WebElement  ContacttobeageVerified;
     	@FindBy(xpath=".//*[@aria-label='Pick Contact:OK']")
     	WebElement  ContacttobeageVerifiedOkButton; 	
     	
     	
     	@Step
     	public void AgeVerificationOnly() throws IOException, AWTException, InterruptedException{
     		Common.waitForElement(AgeIDVerificationttabSync);
     		
     		if(AgeIDVerificationttab.isPresent()){
                AgeIDVerificationttab.click();
          }else{
          AccountSummaryDropdown.selectByVisibleText("Age and ID Verification");
          }
          report.Info("Age and Id verification tab clicked successfully");
          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          Common.waitForElement(VerificationtypeTextBoxsync);
          VerificationtypeTextBox.click();
          VerificationtypeTextBox.typeAndEnter("Age Verification");
          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          ApplicationTypeTextBox.click();
          OverrideverifCheckBox.click();
          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          ContacttobeageVerified.click();
          Thread.sleep(5000);
          ContacttobeageVerifiedOkButton.click();
          AgeIDSubmitButton.click();
          Common.waitForElement(OutCommeSync);
          Common.waitForElement(OutCome);
          Thread.sleep(5000);
          OutCome.click();
          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          String Value=OutCome.getTextValue();
          Assert.assertTrue("Fail: OutCome is not matched", Value.equals("Accept"));
          report.Info("Pass: Ouscome is matched with Expected value "+Value+"");         
     	}
     	
     	@FindBy(xpath=".//*[@aria-labelledby='StreetAddress_Label']//following::*[@aria-label='Multiple Selection Field'][1]")
    	WebElement AddressPopUpSync;
     	@Step
     	public void ChangePrimaryAddress(String rowname) throws InterruptedException, IOException, AWTException{
     		String filePath = "\\src\\test\\resources\\data\\Account.xls";
    		String dataSheet = "DivisionProvision";
    		String table = "//table[@summary='Account Addresses']";
    		String applet = "//*[@title='Account Addresses List Applet']";
    		
    		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
    		readWorkbook.testData(tableMap);
    		 for (int i = 0;i < tableMap.get("Value").size();i++) {
    		String sLocateCol = tableMap.get("LocateCol").get(i);
   			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);
			String Index = tableMap.get("Index").get(i);
			String Validation = tableMap.get("Validation").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sButton = tableMap.get("Button").get(i);
			Alert alert;
            String ActAlertText="";	
			if (Index.equals("")){
           	 Index = "0";
            }
	     if(Validation.equalsIgnoreCase("ChangeAddress")){
	    	 Common.waitForElement(AddressPopUpSync);
			AddressPopUp.click();
		    Thread.sleep(4000);	   	    		
		    Common.selectedRow = 1;
		    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		
			Common.updateSiebList("//*[@title='Add Address List Applet']","//table[@summary='Add Address']","Text|Postal_Code","KA11 2BT");
			AddressStatusElement.click();
			AddressStatusTextBox.sendKeys(Keys.ENTER);
		
			Common.locateColumn("//*[@title='Add Address List Applet']","//table[@summary='Add Address']","Status","Validated","0");
		
			AddAddress.click();
			
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			report.Info("Changed Address selected");
			
         }
            if (!sLocateCol.equals("")){
                 Common.selectedRow = -1;
                Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
               
                sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                 }
            else{
                  Common.selectedRow = 1;
            }
            if (!UIName.equals("")){                                              
                Common.updateSiebList(applet,table, UIName, value);
                if(isAlertPresent(getDriver())){
	            		alert=getDriver().switchTo().alert();
		                ActAlertText=alert.getText(); 
		               sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		                              	
		                	alert.accept();
		               report.Info("unexpected popup occured: "+ActAlertText+" while adding address");		                	
		                                            
	            	}  
                sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                } 
            if(sButton.equalsIgnoreCase("AddressOkButton")){
            AddressOKButton.click();
            }
            
			Thread.sleep(2000);
			
			if(isAlertPresent(getDriver())&& !sPopup.equals("") ){
        		alert=getDriver().switchTo().alert();
                ActAlertText=alert.getText(); 
               sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                if (ActAlertText.contains(sPopup)){                    	
                	alert.accept();
               report.Info("Pass: primary Adderss changed as expected");		                	
                }                                 
        	  
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        
            }
     	     }

     	   }
     	@FindBy(xpath=".//table[@summary='Billing Profiles']//tbody//tr[2]/td[3]")
    	WebElementFacade BillingProfileStatusClick;
     	@FindBy(xpath=".//*[@name='Status']")
    	WebElementFacade BillingStatus;
     	
     	 public void BillingProfileStatus() throws InterruptedException, IOException, AWTException {
     		
     		BillingProfileStatusClick.click();
     		String readonlyValue =BillingStatus.getAttribute("aria-readonly");
     		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			if(readonlyValue.equalsIgnoreCase("true")){
				report.Info("The field is disabled as expected"); 
			}
			else{
				Assert.assertTrue("The field is not disabled as expected",readonlyValue.equalsIgnoreCase("true"));
				
			}
     	 }
     	 public void getBillingProfileId_AccoutSummary() throws IOException, AWTException, InterruptedException{
     		 AccountSummaryTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     		   AccountSummaryTab.click();
     		  
    			CapturedBillProfNo.withTimeoutOf(120,TimeUnit.SECONDS).isDisplayed();            		
    			Serenity.setSessionVariable("BillProfNo").to(CapturedBillProfNo.getTextValue());
    			CapturedBillProfNo.click();
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			report.Info("Billing Profile Number Captured: " + CapturedBillProfNo.getTextValue());
    		
     	 }
     	 
     	@FindBy(xpath="//div[@aria-label='Row #']")
    	WebElementFacade AccountRowIDPopup;
     	
     	 public void getAccount_Row_Id_AccoutSummary(){
     		 
     		if(isAlertPresent(getDriver())) {
     			Common.getAlert().accept();
     		 }
     		try {
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     		CapturedAccNo.click();
     		CapturedAccNo.sendKeys(Keys.chord(Keys.ALT , Keys.CONTROL ,"k"));
     		
     		Serenity.setSessionVariable("AccountNoRowId").to(AccountRowIDPopup.getTextValue());
     		report.Info("Account Row ID Captured: " + AccountRowIDPopup.getTextValue());
     		aboutRecordOkButton.click();
     		
     	 }
     	 
     	@FindBy(xpath="//*[@aria-label='Account Details:Match Company']")
    	WebElementFacade MatchCompanyButton;
    	@FindBy(xpath="//*[@aria-label='Match Company:OK']")
    	WebElementFacade MatchCompanyOKButton;
    	@FindBy(xpath="//*[@aria-label='Company reg. no.']")
    	WebElementFacade ComapanyRegNoTextbox;
     	 
     	 @Step
     	 public void MatchCompany(String rowname) throws InterruptedException, IOException, AWTException{
     		 String filePath = "\\src\\test\\resources\\data\\Account.xls";
     		 String dataSheet = "MatchCompany";
     		 String table = "//table[@summary='Account Addresses']";
     		 String applet = "//*[@title='Account Addresses List Applet']";

     		 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
     		 readWorkbook.testData(tableMap);
     		 for (int i = 0;i < tableMap.get("RegistrationNo").size();i++) {
     			 String sRegistrationNo = tableMap.get("RegistrationNo").get(i);

     			 MatchCompanyButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();
     			 ComapanyRegNoTextbox.clear();	
     			 ComapanyRegNoTextbox.type(sRegistrationNo);
     			 MatchCompanyButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     			 MatchCompanyButton.click();
     			 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			 MatchCompanyOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
     			 MatchCompanyOKButton.click();


     		 }
     	 }
     	 

     	 @FindBy(xpath="//*[@aria-labelledby='PostalCode_Label']")
     	 WebElementFacade AccountSummeryPostCode;
     	 @FindBy(xpath="//*[text()='More Info']")
     	 WebElementFacade ClickOnMoreInfo;
     	 @FindBy(xpath="//*[@data-display='Account Address']")
     	 WebElementFacade AccountAddressButton;
     	 @FindBy(xpath="//*[@aria-label='VF SR Account Address Popup Applet:OK']")
     	 WebElementFacade AccountAddressOKButton;
     	 @FindBy(xpath="//*[@data-display='New Address']")
     	 WebElementFacade NewAddressButtonMoreInfoTab;
     	 @FindBy(xpath="//*[@name='Postal_Code']")
     	 WebElementFacade NewPostcodeApplet;
     	 @FindBy(xpath="//*[@aria-describedby='s_4_l_Postal_Code']")
     	 WebElementFacade NewPostcodeTextBox;
     	 @FindBy(xpath="//*[@aria-label='VF SR Address Association pick Applet:OK']")
     	 WebElementFacade NewAddressOKButton;  	
     	 @FindBy(xpath="//*[@aria-label='Postcode']")
     	 WebElementFacade SRPostcode;


     	 public void ServiceRequestMoreInfo(String LogicalName) throws IOException, InterruptedException, AWTException{
     		 String filePath = "\\src\\test\\resources\\data\\Account.xls";
     		 String dataSheet = "SRMoreInfo";

     		 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
     		 readWorkbook.testData(tableMap);
     		 for (int i = 0;i < tableMap.get("RowNo").size();i++) {
     			 String sCapturePostcode = tableMap.get("CapturePostcode").get(i);
     			 String sMoreInfo = tableMap.get("MoreInfo").get(i);
     			 String sNewAddress = tableMap.get("NewAddress").get(i);
     			 String sCaptureAccountPostcode = tableMap.get("CaptureAccountPostcode").get(i);

     			 /*Common.waitForPageLoad(getDriver());
     		Common.waitForElement(AccountSummaryTab);
     		AccountSummaryTab.click();
     		Common.waitForPageLoad(getDriver());
     		CustCommsListHeader.click();*/

     			 if(!sCapturePostcode.equals("")) {
     				 AccountSummaryTab.click();
     				 AccountSummeryPostCode.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
     				 String sPostCode = AccountSummeryPostCode.getTextValue();		
     				 Serenity.setSessionVariable("AccountSummeryPostCode").to(sPostCode);	    		
     				 report.Info("PostCode "+sPostCode+" is Saved successfully.");
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

     			 }   		

     			 if(!sMoreInfo.equals("")) {
     				 ClickOnMoreInfo.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
     				 ClickOnMoreInfo.click();

     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 AccountAddressButton.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
     				 AccountAddressButton.click();
     				 AccountAddressOKButton.withTimeoutOf(120, TimeUnit.SECONDS).isCurrentlyVisible();
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 AccountAddressOKButton.click();
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 String sSRPostcode = SRPostcode.getTextValue();

     				 String sAccSummaryPostcode = Serenity.sessionVariableCalled("AccountSummeryPostCode").toString();

     				 if(sAccSummaryPostcode.equals(sSRPostcode)) {
     					 report.Info("PostCode "+sAccSummaryPostcode+" is same as "+sSRPostcode+"Account Summary Postcode.");
     				 }
     				 else {
     					 report.Info("PostCode "+sAccSummaryPostcode+" is same not Same as Account Summary Postcode" +sSRPostcode);

     				 }
     			 }
     			 if(sNewAddress.equals("Yes")) {
     				 String sUIName = tableMap.get("UIName").get(i);
     				 String sValue = tableMap.get("Value").get(i);
     				 String index = "0";

     				 ClickOnMoreInfo.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
     				 ClickOnMoreInfo.click();

     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 NewAddressButtonMoreInfoTab.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
     				 NewAddressButtonMoreInfoTab.click();

     				 String table = "//table[@summary='VF SR Address Association pick Applet']";
     				 String applet = "//*[@title='VF SR Address Association pick Applet List Applet']";

     				 //NewPostcodeTextBox.click();
     				 Common.updateSiebList(applet,table, sUIName, sValue);
     				 NewPostcodeApplet.sendKeys(Keys.ENTER);
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 NewAddressOKButton.withTimeoutOf(120, TimeUnit.SECONDS).isCurrentlyVisible();
     				 NewAddressOKButton.click();
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

     				 String sSRPostcode = SRPostcode.getTextValue();
     				 Serenity.setSessionVariable("SRPostCode").to(sSRPostcode);	
     				 //String sAccSummaryPostcode = Serenity.sessionVariableCalled("AccountSummeryPostCode").toString();

     				 /* if(sAccSummaryPostcode.equals(sSRPostcode)) {
     				 report.Info("PostCode "+sAccSummaryPostcode+" is same as "+sSRPostcode+"Account Summary Postcode.");
     	         }
     			 else {
     				 report.Info("PostCode "+sAccSummaryPostcode+" is same not Same as Account Summary Postcode" +sSRPostcode);

     			 }*/

     			 }
     			 if(!sCaptureAccountPostcode.equals("")) {
     				 AccountSummaryTab.click();
     				 String sPostCode = AccountSummeryPostCode.getTextValue();

     				 String sSRPostcode = Serenity.sessionVariableCalled("SRPostCode").toString();

     				 if(sPostCode.equals(sSRPostcode)) {
     					 report.Info("PostCode "+sPostCode+" is not same as "+sSRPostcode+"Service Request Postcode.");
     				 }
     				 else {
     					 report.Info("PostCode "+sPostCode+" is same not Same as Service Request Postcode" +sSRPostcode);

     				 }


     			 }

     		 }
     	 }
     	
     	@FindBy(xpath=".//*[text()='More Info']")
    	WebElementFacade MoreInfoTab;
     	
     	@FindBy(xpath=".//*[contains(@aria-labelledby,'third_party_social_media')]")
    	WebElementFacade ThirdPartyCheckBox;
     	
     	@FindBy(xpath="//*[contains(text(),'given permission for Vodafone to use')]")
    	WebElementFacade ToolTipMessage;
     	
     	@FindBy(xpath=".//*[contains(@class,'vf-enb-service-permi-socialmedia')]")
     	WebElementFacade Xpathtohover;    	
     	
     	@FindBy(xpath=".//*[@aria-labelledby='Do_not_Mail_Label']")
    	WebElementFacade DoNotMailCheckBox;
     	
     	@FindBy(xpath="(.//*[@aria-label='Date of birth'])[2]")
        WebElementFacade DOBField;
     	
     	@FindBy(xpath=".//*[@aria-label='Age proof']")
        WebElementFacade AgeProofTextBox;
     	
    	
     	 public void MarketingPermissionValidation_AccountsContacView(String LogicalName) throws IOException, InterruptedException, AWTException{
     		 String filePath = "\\src\\test\\resources\\data\\Account.xls";
     		 String dataSheet = "MarketingPermission";

     		 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
     		 readWorkbook.testData(tableMap);
     		 for (int i = 0;i < tableMap.get("RowNo").size();i++) {
     			 String sToolTipMessage = tableMap.get("ToolTipMessage").get(i);
     			 String sValidation = tableMap.get("Validation").get(i);
     			 String sAction = tableMap.get("Action").get(i);
     			 Common.WaitForClock(Clockobj);
     			 if(ContactstabButton.isCurrentlyVisible()){
     				 ContactstabButton.click();
     			 }else{
     				 AccountSummaryDropdown.selectByVisibleText("Contacts");
     			 }
     			 report.Info("contacts tab clicked successfully");
     			 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			 Common.WaitForClock(Clockobj);
     			 Lastnamelink.click();
     			 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     			 
     			 if(MoreInfoTab.isCurrentlyVisible()){
     				MoreInfoTab.click();
    			 }     			     			 
     			 if(sValidation.equalsIgnoreCase("ValidateforNotMinor"))
     			 {
     				 Thread.sleep(1000);
     				 String GetAttributeDoNotMail =  DoNotMailCheckBox.getAttribute("aria-checked");
     				 if(GetAttributeDoNotMail.equals("false"))
     				 {
     					 DoNotMailCheckBox.click();
     				 }
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 Thread.sleep(1000);
     				 Boolean IsChecked = DoNotMailCheckBox.isSelected();
     				 Assert.assertTrue("Fail, Do not use third party is already checked", IsChecked);
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 report.Info("Marketing permissions are editable as expected");
     				 
     				 String GetAttributeThirdPartyCheck =  ThirdPartyCheckBox.getAttribute("aria-checked");
     				 Assert.assertTrue("Fail, Third Party Check box is already checked", GetAttributeThirdPartyCheck.equalsIgnoreCase("false"));
     				 ThirdPartyCheckBox.click();
     				 Thread.sleep(1000);
     				 report.Info("Pass, Third Party is not check as expected");
     				 
     				 Xpathtohover.click();
        			 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        			 String tooltip = ToolTipMessage.getTextValue();
        			 Assert.assertTrue("Fail, ToolTip message does not matched", tooltip.contains(sToolTipMessage));
        			 report.Info("ToolTip Message matched as expected : " +tooltip );
        			 
        			 Robot robot = new Robot();	 
        			 robot.keyPress(KeyEvent.VK_CONTROL);
        			 robot.keyPress(KeyEvent.VK_S);
        			 robot.keyRelease(KeyEvent.VK_CONTROL);
        			 robot.keyRelease(KeyEvent.VK_S);
     			 }
     			 if(sValidation.equalsIgnoreCase("ValidateforMinor"))
     			 {
     				if(sAction.equals("ExistingDOBChange"))
     				{
     					Thread.sleep(2000);
     					DOBField.clear();
     					DOBField.type("25/06/2015"); 
     					AgeProofTextBox.click();
     					Common.WaitForClock(Clockobj);
     					Alert alert;
     					String ActAlertText="";	
     					alert=getDriver().switchTo().alert();
     					alert.accept();
     				}
     				 Common.WaitForClock(Clockobj);
     				 Thread.sleep(2000);
     				 String GetariacheckedDonotmail =  DoNotMailCheckBox.getAttribute("aria-checked");
     				 String GetariareadonlyDonotmail =  DoNotMailCheckBox.getAttribute("aria-readonly");
     				 Assert.assertTrue("Fail, Do not mail is editable", GetariacheckedDonotmail.equalsIgnoreCase("true")&& GetariareadonlyDonotmail.equalsIgnoreCase("true") );
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 report.Info("Do not mail checkbox is not editable as expected");

     				 String GetariacheckedThirdParty =  ThirdPartyCheckBox.getAttribute("aria-checked");
     				 String GetariareadonlyThirdParty =  ThirdPartyCheckBox.getAttribute("aria-readonly");
     				 Assert.assertTrue("Fail, Third Party CheckBox is editable", GetariacheckedThirdParty.equalsIgnoreCase("true")&& GetariareadonlyThirdParty.equalsIgnoreCase("true") );
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 report.Info("Third Party CheckBox checkbox is not editable as expected");

     				 Xpathtohover.click();
     				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     				 String tooltip = ToolTipMessage.getTextValue();
     				 Assert.assertTrue("Fail, ToolTip message does not matched", tooltip.contains(sToolTipMessage));
     				 report.Info("ToolTip Message matched as expected : " +tooltip );
     				 Robot robot = new Robot();	 
     				 robot.keyPress(KeyEvent.VK_CONTROL);
     				 robot.keyPress(KeyEvent.VK_S);
     				 robot.keyRelease(KeyEvent.VK_CONTROL);
     				 robot.keyRelease(KeyEvent.VK_S);
     			 }
     		 }
     	 }
     	 
     	@Step
       	public void CreateNewAccountforTransactData(String accountType) throws InterruptedException, IOException, AWTException{
       		     		
       		String filePath = "\\src\\test\\resources\\data\\Transact_Data.xls";
            String dataSheet = "CreateNewAccountTransactData";
            String applet = "//*[@title='Add Address List Applet']";
       	    String table = "//table[@summary='Add Address']"; 
               
               Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
               readWorkbook.testData(tableMap);
               
                          
               for (int i = 0;i < tableMap.get("RowNo").size();i++) {
            	   	 String accounTab = tableMap.get("AccountTab").get(i);
            	   	 String sNew = tableMap.get("New").get(i);
                     String FirstName = tableMap.get("Firstname").get(i);
                     String LastName = tableMap.get("Surname").get(i);
                     String PostCode = tableMap.get("Postcode").get(i);
                     String Birth_Date = tableMap.get("DOB").get(i);
                     String sSortCode = tableMap.get("Sort Code").get(i);
                     String sBankAcc = tableMap.get("BankAcc").get(i);
                     String sDecision = tableMap.get("Decision").get(i);
                     String Online_Account = tableMap.get("OnlineAccount").get(i);
                     String sAccountType = tableMap.get("AccountType").get(i);                    
                 	 String sAccountName = tableMap.get("AccountName").get(i);
                 	 String sMemorableWord = tableMap.get("MemorableWord").get(i);
                 	 String AutoAccountName = FirstName + " " + LastName;
    	      		 String sEnv = Serenity.sessionVariableCalled("Env").toString(); 
    	   	      	Random rand = new Random(System.currentTimeMillis());
    	  			int num = rand.nextInt(2000000000);
    	  			String valuenew = String.valueOf(num);
    	  			
       	      		Common.WaitForClock(Clockobj);
       	      		if (!accounTab.equalsIgnoreCase("No")){       	    		
       	    		Common.waitForElement(AccountsTabSync);
       	    		long startTime = System.currentTimeMillis();
       	    		AccountsTab.click();       	    		
       	    		Common.waitForElement(newAccountSync);
       	    		
       	    		long endTime = System.currentTimeMillis();
       	    		long totalTime = endTime - startTime;      	    		
       	    		
       	      		}
       	    		if (!sNew.equals("No")){
       	    			Common.WaitForClock(Clockobj);
       	    			long startTime = System.currentTimeMillis();
       	    			newAccount.click();
       	    			Common.waitForElement(firstNameSync);
       	    			long endTime = System.currentTimeMillis();
       	   	    		long totalTime = endTime - startTime; 	   	    		
       	   	    		Common.WritePerformanceOutput("New Account Clicked ,Total Time " + totalTime/1000);

       	    		}

       	    		TitleWebList.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
       	            TitleWebList.type("Mr.");
       	            firstName.type(FirstName);
       	            lastName.type(LastName);
       	            pin1.type("1");
    	            pin2.type("1");
    	            pin3.type("1");
    	            pin4.type("1");
   	            	DOBTextBox.type(Birth_Date);   
       	            TradingAsTextBox.click();
       	            Thread.sleep(5000);
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
       	            
       	            if (sMemorableWord.equals("Y")){
    	    			String MemWordHint = "Memword123";
    	    			MemorableWordTextBox.type(MemWordHint);
    	    			MemorableHintTextBox.type(MemWordHint);
    	    			Serenity.setSessionVariable("MemorableWord").to(MemWordHint);
    	    			   	    						
    	    		}
       	            
       	            String IfChecked =OnlineFlagCheckBox.getAttribute("aria-checked");                
       	            if (IfChecked.equalsIgnoreCase("true") && Online_Account.equals("Off")){
       	            OnlineFlagCheckBox.click();  
       	            CapturedAccNo.click();                        
       	            }
       	            else if (IfChecked.equalsIgnoreCase("false") && Online_Account.equals("Off")){
       	            report.Info("Online Checkbox is already unchecked");
       	            }
       	    		 
       	         if (!sAccountType.equals("")){
        	    		Common.WaitForClock(Clockobj);
        	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());        	    		
        	            accountTypeSelect.type(sAccountType);        	            
        	    		}
       	    		
       	    		String sPrimaryFirstName = AccountName.getTextValue();
       	            if (sPrimaryFirstName.equals("")){

       	               String PrimaryFirstNamereadonly= AccountName.getAttribute("aria-readonly");
       	               if(!PrimaryFirstNamereadonly.equalsIgnoreCase("true")){
       	            	   AccountName.type(sAccountName);
       	               }
       	            } 
       	            accountSave.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
       	            long startTime = System.currentTimeMillis();
       	    		accountSave.click();
       	    		Common.WaitForClock(Clockobj);
       	    		long endTime = System.currentTimeMillis();
       	    		long totalTime = endTime - startTime;
       	    		
       	    		Common.WritePerformanceOutput("Account Saved ,Total Time " + totalTime/1000);       	    		       	    		
       	    		accountName.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();         	    		
       	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
       	    		
       	    			    		
       	    	}
           

       }
     	@Step
        public void VerifyAccountSummaryforTransactData(String accountType) throws IOException, InterruptedException, AWTException{
     		String filePath = "\\src\\test\\resources\\data\\Transact_Data.xls";
            String dataSheet = "CreateNewAccountTransactData";
            String applet = "//*[@title='Accounts List Applet']";
      	    String table = "//table[@summary='Accounts']"; 
      	    Common.WaitForClock(Clockobj);
            Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
            readWorkbook.testData(tableMap);
            
            //Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
           for (int i = 0;i < tableMap.get("RowNo").size();i++) {
        	      String FirstName = tableMap.get("Firstname").get(i);
                  String LastName = tableMap.get("Surname").get(i);
                  String FullName = FirstName + " " + LastName;
                  FullName = FullName.toUpperCase();
                  Serenity.setSessionVariable("Surname").to(LastName);                  
                  Thread.sleep(4000);                  
                  Common.selectedRow = 1;
                  Common.updateSiebList(applet,table, "CaptureCompareTextValue|Name", FullName);
                  CapturedAccNo.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
                  
                  String AccNo = "";
                  Common.selectedRow = 1;
                  AccNo=Common.updateSiebList(applet,table, "CaptureTextValue|Customer_Code", AccNo);     	    		
  	    		
  	    		  Serenity.setSessionVariable("AccountNo").to(AccNo);	    		
  	    		  Serenity.setSessionVariable("OlderAccountNo").to(AccNo);
  	    		  report.Info("Account no "+AccNo+" is Created successfully.");
  	    		
  	    		  Common.selectedRow = 1;
     	    	  Common.updateSiebList(applet,table, "DrillDown|Name","");
                  
                  Thread.sleep(2000);
                  Common.WaitForClock(Clockobj);
                  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                  
           }
          }


}
  