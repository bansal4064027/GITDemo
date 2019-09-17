package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.time.*;
import java.util.*;

@SuppressWarnings("deprecation")
public class AccountsSecurityPageEnh extends PageObject {
	@Steps
    private ReadWorkbook readWorkbook;
	
	@Steps
	private common Common;
	@Steps
	private SikuliUtility sikuliUtility;
	@Steps
	private commonEnh CommonEnh;
	
	
	@Steps
	private ReportMessege report; 
	  public static boolean isAlertPresent(WebDriver driver) {
          try{
                driver.switchTo().alert();
                return true;          }catch(NoAlertPresentException ex){
                return false;
          }
    }
	
	@FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
	WebElement ClockObj;
	
	@FindBy(xpath=".//*[translate(@aria-label,'SCPDPA','scpdpa')='select contact:perform dpa']")
	WebElementFacade PerformDPAButton;
	
	@FindBy(xpath=".//*[contains(@aria-label,'go to OTAC validation')]")
	WebElementFacade GotoOTACValidationLink;
	@FindBy(xpath=".//*[text()='What is your date of birth?']")
	WebElementFacade DOBValidationQuestion;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Installed_Id_Label']")
	WebElementFacade SelectTelphoneNumTextBox;
	@FindBy(xpath=".//*[@aria-label='DPA verification:Send OTAC']")
	WebElementFacade SendOTACButton;
	@FindBy(xpath=".//*[@data-display='Passed']")
	WebElementFacade DPAPassedButton;
	@FindBy(xpath=".//button[@data-display='Failed']")
	WebElementFacade DPAFailedButton;
	@FindBy(xpath=".//*[text()='DPA Verification']")
	WebElementFacade DPAverificationPopUP;
	@FindBy(xpath="(.//label[text()='Account'])[1]/preceding::div[2]/span/input")
	WebElementFacade MessageType;
	@FindBy(xpath="(.//label[text()='Account'])[1]/following::div[2]/input")
	WebElementFacade MessageStatus;
	@FindBy(xpath=".//*[@aria-label='Activities:Activities']")
	WebElementFacade ActivitiesPage;
	@FindBy(xpath=".//*[text()='Pay monthly']")
	WebElementFacade SecondaryDPAVerificationPage;
	
	@FindBy(xpath=".//*[contains(@aria-label,'go to Secondary DPA')]")
	WebElementFacade GotoSecondaryDPAValidationLink;
	@FindBy(xpath=".//*[text()='Pay as you go']")
	WebElementFacade PayAsGoTab;
	//@FindBy(xpath=".//*[@aria-label='Search Telephone Number']")
	//WebElementFacade SelectMSISDNPayGTextBox;
	@FindBy(xpath=".//*[contains(@aria-label,'Telephone Number')]")
	WebElementFacade SelectMSISDNPDPATextBox;
	
	
	//@FindBy(xpath=".//*[@aria-label='Secondary DPA:Pass DPA']")
		@FindBy(xpath=".//*[@aria-label='Secondary DPA:Passed']")
		WebElementFacade DPAPassButton;
		//@FindBy(xpath=".//*[@aria-label='Secondary DPA:Fail DPA']")
		@FindBy(xpath=".//*[@aria-label='Secondary DPA:Failed']")
		WebElementFacade DPAFailButton;
		@FindBy(xpath=".//*[contains(@aria-label,'Failed to provide correct information')]")
		WebElementFacade FailedToProvideCorrectInfoLink;
		@FindBy(xpath=".//*[text()='DPA Failed']")
		WebElementFacade DPAFailedPopUp;
		@FindBy(xpath=".//*[@aria-label='DPA verification:Save notes']")
		WebElementFacade SaveNotesButton;
		@FindBy(xpath=".//*[text()='Pay monthly']")
		WebElementFacade PayMonthlyTab;
		@FindBy(xpath=".//span[contains(@class,'color-correct')]")
		WebElementFacade RightSelection;
		@FindBy(xpath=".//span[contains(@class,'color-wrong')]")
		WebElementFacade WrongSelection;
		@FindBy(xpath="(.//span[text()='DPA'])/ancestor::td[1]/following-sibling::td[1]//label[text()='Passed']")
		WebElementFacade DPAPassedStatus;
		
		@FindBy(xpath="(.//a[text()='DPA PIN'])")
		WebElementFacade DPAPINTab;
		@FindBy(xpath="(.//span[text()='DPA PIN'])")
		WebElementFacade DPAPINText;
		@FindBy(xpath=".//*[@aria-label='DPA PIN Validation:Validate']")
		WebElementFacade DPAPINValidationButton;
		
		@FindBy(xpath=".//a[text()='Memorable word']")
		WebElementFacade MemorableWordTab;
		@FindBy(xpath=".//*[@aria-label='Memorable hint']")
		WebElementFacade MemorableHintTextBox;
		@FindBy(xpath=".//*[@ aria-label='Memorable Word:Reveal word']")
		WebElementFacade RevealMemWordButton;
		@FindBy(xpath=".//*[@aria-label='Memorable word']")
		WebElementFacade MemorableWordTextBox;
		@FindBy(xpath=".//*[@aria-label='Memorable Word:Passed']")
		WebElementFacade MemorableWordPassButton;
		
		@FindBy(xpath="(.//*[text()='DPA verification'])[1]")
		WebElementFacade DPAVerificationTab;
		
		 @FindBy(xpath=".//*[contains(text(),'Reason')]")
		  WebElementFacade ReasonTitleBox;
		  @FindBy(xpath=".//div[contains(@class,'dialog-content vf-check-retention')]")
		  WebElementFacade ReasonMsg; 
		  @FindBy(xpath=".//*[contains(text(),'Reason')]//following::div[6]//button[contains(@class,'ui-button-text-only')]")
		  WebElementFacade ReasonOkButton;
		
		
		@Step
		public void CheckDPA(String accountType) throws InterruptedException, IOException, AWTException{
			//Homepage.waitUntilPresent();
	 		Common.waitForPageLoad(getDriver());
			String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
	        String dataSheet = "DPAValidationEnh";
	        
	        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
	        readWorkbook.testData(tableMap);
	        
	        PerformDPAButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable(); 
	        sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	        PerformDPAButton.click();
	        
	        for (int i = 0;i < tableMap.get("Row").size();i++) {
	              String sDPA_Validation_for = tableMap.get("DPA Validation for").get(i);
	              String sDPA_Type = tableMap.get("DPA Type").get(i); 
	              String sSecurity_Questions = tableMap.get("Security Questions").get(i); 
	              String sValidation = tableMap.get("Validation").get(i); 
	              String sButtonValidation = tableMap.get("ButtonValidation").get(i); 
	              String sSecondaryDPA = tableMap.get("Secondary DPA").get(i);
	              
	              String ActualSecurityQuestions = ".//*[text()='"+sSecurity_Questions+"']";
	              String RightButton = ".//*[text()='"+sSecurity_Questions+"']/ancestor::div[1]/following-sibling::div[1]/span[text()='Right']";
	              String WrongButton = ".//*[text()='"+sSecurity_Questions+"']/ancestor::div[1]/following-sibling::div[1]/span[text()='Wrong']";
	              String DPAPassedStatus = "(.//span[text()='DPA'])/ancestor::td[1]/following-sibling::td[1]//label[text()='"+sValidation+"']";
	              String CheckAnswerButton = ".//*[text()='"+sSecurity_Questions+"']/ancestor::div[1]/following-sibling::div[2]/button";
	              String SecurityAnswer = ".//*[text()='"+sSecurity_Questions+"']/ancestor::div[1]/following-sibling::div[2]/span";
	              
	     //For DPA PIN       
	              if (sDPA_Validation_for.equalsIgnoreCase("DPAPIN")){
	            	  
	             	 DPAPINTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	             	 report.Info("DPA page displayed.");
	             	 
	 	            	 for(int j = 1;j < 5;j++){
	 	            		String PinTextBox =  ".//*[@rn='VF_PIN_"+j+"']";
	 	            		String Value = find(By.xpath(PinTextBox)).getAttribute("class");
	 	            		if (!Value.contains("readonly")){
	 	            			find(By.xpath(PinTextBox)).type("1");
	 	            		}
	 	            	 }
	 	             sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	 	             DPAPINText.click();
	 	             Common.WaitForClock(ClockObj);
	             	 DPAPINValidationButton.click();
	                 
	 	             ActivitiesPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	 	                	  
	 	         }
	        
	      //For DPA Memorable Word Hint
	              if (sDPA_Validation_for.equalsIgnoreCase("Memorable Word")){            	  
	              	DPAPINTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	              	MemorableWordTab.click();
	              	RevealMemWordButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();              	
	              	report.Info("Memorable Word page displayed.");
	              	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	              	
	              	/*Assert.assertTrue("FAIL, Memorable Hint not displayed",!MemorableHintTextBox.equals(""));
	              	report.Info("Memorable Hint is displayed.");*/
	              	
	              	RevealMemWordButton.click();
	              	Common.WaitForClock(ClockObj);
	              	String MemWord = MemorableWordTextBox.getTextValue();
	              	String ActualMemword = Serenity.sessionVariableCalled("MemorableWord").toString(); 
	              	//String ActualMemword = "Memword123";
	              	Assert.assertTrue("FAIL, Correct Memorable Word not displayed",MemWord.equals(ActualMemword));
	              	report.Info("Correct Memorable Word is displayed.");             	      	
	              	
	  	            sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	  	            MemorableWordPassButton.click();
	                  
	  	            ActivitiesPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	  	                	  
	  	         }
	              
	      //For DPA OTAC         
	              if (sDPA_Validation_for.equalsIgnoreCase("OTAC")){
	            	  String MSISDN = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
	            	  GotoOTACValidationLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	            	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	                  GotoOTACValidationLink.click();
	                  report.Info("OTAC Link clicked.");
	                  
	                  if (sSecondaryDPA.equalsIgnoreCase("Passed")){  
	                	  FailedToProvideCorrectInfoLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	                	  FailedToProvideCorrectInfoLink.click();
	                	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	                	  DPAPassButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	                	  DPAPassButton.click();
	                	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	                	  return;
	                  }
	                  
	                  DOBValidationQuestion.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	                  SelectTelphoneNumTextBox.typeAndTab(MSISDN);
	                  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	                  //DPAVerificationTab.click();
	                  SendOTACButton.click();
	                  report.Info("OTAC Button clicked.");
	                  
	                  DPAverificationPopUP.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	                  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		                  if (sDPA_Type.equalsIgnoreCase("Passed")){
		                	  DPAPassedButton.click();
		                	  Common.WaitForClock(ClockObj);
		                	  Thread.sleep(2000);
		                	}
		                  
		                  if (sDPA_Type.equalsIgnoreCase("Failed")){
		                	  DPAFailedButton.click();
		                	  Common.WaitForClock(ClockObj);
		                	  SecondaryDPAVerificationPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		                	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		                	  report.Info("DPA failed as expected");
		                  }
		              }
	              
	              
	        //For Secondary DPA Security Questions         
	              if (sDPA_Validation_for.equalsIgnoreCase("Security Question")){
	            	  
	            	  if (sValidation.equalsIgnoreCase("No")){
	            		  String MSISDN = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
	            		  GotoOTACValidationLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	                	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	                      GotoOTACValidationLink.click();
	                                    
	                      DOBValidationQuestion.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	                      GotoSecondaryDPAValidationLink.click();                     
	            		  
	                      PayMonthlyTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	                	  
	                	  if (sDPA_Type.contains("PAYG")){
	                		  PayAsGoTab.click();
	                		  
	                	  }
	                	  Common.WaitForClock(ClockObj);
	                	  SelectMSISDNPDPATextBox.type(MSISDN);
	            	  }   
	            	  else{
	            		// Assert.assertTrue("FAIL, Security Question not found/matched",ActualSecurityQuestions.contains(sSecurity_Questions));
	                	  Assert.assertTrue("FAIL, Security Question not found/matched",find(By.xpath(ActualSecurityQuestions)).isCurrentlyVisible() );
	                	  report.Info("Security question is found: "+sSecurity_Questions);
	            		  
	            	  }
	                	  
	                	  if (sValidation.equalsIgnoreCase("Right"))
	                	  {
		                	  find(By.xpath(RightButton)).click();
		                	  Assert.assertTrue("FAIL, Right Button Not Selected",RightSelection.isCurrentlyVisible());              	  
		                	  report.Info("Right Button clicked for : "+sSecurity_Questions);
	                	  }
	                	  if (sValidation.equalsIgnoreCase("Wrong"))
	                	  {
		                	  find(By.xpath(WrongButton)).click();
		                	  Assert.assertTrue("FAIL, Wrong Button Not Selected",WrongSelection.isCurrentlyVisible());              	  
		                	  report.Info("Wrong Button clicked for : "+sSecurity_Questions);
	                	  }
	                	
	                	  if (sButtonValidation.equalsIgnoreCase("Check Answer"))
	                	  {
		                	  find(By.xpath(CheckAnswerButton)).click();
		                	  Common.WaitForClock(ClockObj);
		                	  String ActualSecurityAnswer = find(By.xpath(SecurityAnswer)).getTextValue();
		                	  
		                	  report.Info("Check Answer button is clicked for Security Question : "+sSecurity_Questions);
		                	  Assert.assertTrue("FAIL, Answer is blank",!ActualSecurityAnswer.equals(""));              
		                	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		                	  report.Info("Security Answer is displayed : "+ActualSecurityAnswer);
	                	  }
	                	  
	 
	                	 
		                	  if (sValidation.equalsIgnoreCase("Passed"))
		                	  {
		                		  DPAPassButton.click();
		                		  Common.WaitForClock(ClockObj);
		                		  Thread.sleep(2000);
		                	}
		                	  if (sValidation.equalsIgnoreCase("Failed"))
		                	  {
		                		  DPAFailButton.click();
		                		  DPAFailedPopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		                		  SaveNotesButton.click();
		                		  
			                	  Common.WaitForClock(ClockObj);
		                		  SecondaryDPAVerificationPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();		                	 
			                	  report.Info("DPA failed as expected");
			                	  
			                	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		                	  }
		                	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	                  }
	        //Validation for Pass DPA for all above scenarios          
	              if (sValidation.equalsIgnoreCase("Passed")){
	            	  
	            	  Common.WaitForClock(ClockObj);
            		  Thread.sleep(2000);
	            	  if(ReasonOkButton.isCurrentlyVisible()){
	            			String ErrorInfo= ReasonMsg.getText();
	            			
	            				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	            				ReasonOkButton.click();
	            				report.Info("The alert meassage is:"+ErrorInfo);
	            				Thread.sleep(2000);
	            		}
	            	  
	            	  ActivitiesPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	            	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	            	  
		            	  if(sDPA_Validation_for.equalsIgnoreCase("OTAC")){
		            		  String Message_Type = MessageType.getTextValue();
			            	  Assert.assertTrue("FAIL, OTAC SMS not sent",Message_Type.equalsIgnoreCase("OTAC SMS Sent"));
			            	  report.Info("Message Type : "+Message_Type);
			            	  
			            	  String Message_Status = MessageStatus.getTextValue();
			            	  Assert.assertTrue("FAIL, OTAC SMS not Closed",Message_Status.equalsIgnoreCase("Closed"));      	  
			            	  report.Info("Mesage Status : "+Message_Status);
		            	  }
	            	  
			           //To check DPA status = Passed 	  
	            	  Assert.assertTrue("FAIL, DPA is not Passed",find(By.xpath(DPAPassedStatus)).isCurrentlyVisible());           
	            	  find(By.xpath(DPAPassedStatus)).click();
	            	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	            	  report.Info("DPA passed as expected");
	              }
	                  
	              
			  }
		  }
 	
 	
 	@FindBy(xpath=".//*[@title='DPA verification:Contact update']")
    WebElementFacade DPAContactUpdateButton;
 	
 	@FindBy(xpath=".//*[@title='Select contact:Add new contact']")
    WebElementFacade NewContactButton;
 	
 	@FindBy(xpath=".//*[@aria-label='Title']")
    WebElementFacade TitleTextBox;
 	
 	@FindBy(xpath=".//*[@aria-label='First Name']")
    WebElementFacade FirstNameTextBox;
 	
 	@FindBy(xpath=".//*[@aria-label='Last Name']")
    WebElementFacade LastNameTextBox;
 	
 	@FindBy(xpath=".//*[@aria-label='Date of birth']")
    WebElementFacade DOBTextBox;
 	
 	@FindBy(xpath=".//*[@aria-label='VF PIN 1']")
    WebElementFacade PIN1;
 	
 	@FindBy(xpath=".//*[@aria-label='VF PIN 2']")
    WebElementFacade PIN2;
 	
 	@FindBy(xpath=".//*[@aria-label='VF PIN 3']")
    WebElementFacade PIN3;
 	
 	@FindBy(xpath=".//*[@aria-label='VF PIN 4']")
    WebElementFacade PIN4;
 	
 	@FindBy(xpath="(.//*[@title='Personal details:Save'])[2]")
    WebElementFacade SaveButton;
 	
 	@FindBy(xpath="(.//*[@title='Personal details:Save'])[1]")
    WebElementFacade PersonalDetailsSaveButton;
 	
 	@FindBy(xpath=".//*[@aria-label='VF_Online_ID_Flag']")
    WebElementFacade OnlineIDCheckBox;
 	
 	@FindBy(xpath=".//*[@aria-label='VF OUI Permission Calc']")
    WebElementFacade PermissionLevelTextBox;
 	
 	@FindBy(xpath=".//*[contains(text(),'A person who has been granted the responsibility')]")
    WebElementFacade ValidationText;
 	
 	@FindBy(xpath=".//*[@aria-label='Contact telephone number']")
    WebElementFacade ContactTextBox;
 	
 	@FindBy(xpath="(.//*[@aria-label='Personal details:Set/reset'])[1]")
    WebElementFacade SetResetPinButton;
 	@FindBy(xpath=".//*[@aria-label='Reset PIN:Ok']")
    WebElementFacade SetResetPinOKButton;
 	
 	@FindBy(xpath=".//*[@title='Select contact:Add existing contact']")
    WebElementFacade AddExistingContactButton;
 	
 	@FindBy(xpath=".//*[@aria-label='First name']")
    WebElementFacade ExistingContactFirstName;
 	
 	@FindBy(xpath=".//*[@aria-label='Last name']")
    WebElementFacade ExistingContactLastName;
 	
 	@FindBy(xpath=".//*[@title='Search for existing contact:Search']")
    WebElementFacade ExistingContactSearchButton;
 	
 	@FindBy(xpath=".//*[@title='Search for existing contact:Select']")
    WebElementFacade ExistingContactAddToContactsButton;
 	@FindBy(xpath=".//*[@aria-label='Contact number']")
    WebElementFacade ContactNumber;
 	@FindBy(xpath=".//*[@aria-label='Email']")
    WebElementFacade EmailSend;
 	@FindBy(xpath=".//*[@aria-label='D.O.B.']")
    WebElementFacade DateOfBirth;
 	@FindBy(xpath=".//*[text()='Contact marketing permissions']")
    WebElementFacade ContactMarketingpermission;
 	@FindBy(xpath=".//*[@aria-label='Do not email'][@aria-readonly='true']")
    WebElementFacade DoNotEmail;
 	@FindBy(xpath=".//*[@aria-label='Do not market research'][@aria-readonly='true']")
    WebElementFacade DoNotMarketresearch;
 	@FindBy(xpath=".//*[@aria-label='Do not mail'][@aria-readonly='true']")
    WebElementFacade DoNotMail;
 	@FindBy(xpath=".//*[@class='vfoui-align-center vfoui-padding-bottom-20px']//button[@aria-label='Personal details:Save']")
    WebElementFacade SaveMarketingPermission;
 	@FindBy(xpath=".//*[text()='Marketing permissions history']")
    WebElementFacade MarketingPermissionHistory;
 	@FindBy(xpath="(.//*[text()='Permission'])[2]")
    WebElementFacade Permission;
 	@FindBy(xpath=".//*[text()='08/Aug/2010']")
    WebElementFacade DOBAccountSelect;
 	@FindBy(xpath="//*[@aria-label='Marketing permissions history:Expand Applet']/parent::span")
    WebElementFacade MarketingPermissionHistoryDropdown;
 	@FindBy(xpath="//*[@class='vf-oui-error-generic-confirm-popup ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//*[@class='ui-button-text']")
    WebElementFacade RecordAlreadyExistedPopUpOk;
 	@FindBy(xpath=".//*[text()='Halo - please read']")
    WebElementFacade RecordAlreadyExisted;
 	@FindBy(xpath=".//*[@aria-label='Do not email']")
    WebElementFacade ClickDoNotEmail;
 	@FindBy(xpath=".//*[@aria-label='Do not market research']")
    WebElementFacade ClickDoNotMarketresearch;
 	@FindBy(xpath=".//*[@aria-label='Do not mail']")
    WebElementFacade ClickDoNotMail;
 	@FindBy(xpath=".//*[@aria-label='Search for existing contact:Cancel']")
    WebElementFacade CancelSearch;
 	@FindBy(xpath=".//*[@aria-label='Do not email'][@value='N'")
 	WebElementFacade BlankDoNotEmail;
 	@FindBy(xpath=".//*[@aria-label='Do not market research'][@value='N']")
    WebElementFacade BlankDoNotMarketresearch;
 	@FindBy(xpath=".//*[@aria-label='Do not mail'][@value='N']")
    WebElementFacade BlankDoNotMail;
 	@FindBy(xpath=".//*[@aria-label='Underage']")
    WebElementFacade Underage;
	@FindBy(xpath="(.//*[@aria-label='Personal details:Set/reset'])[2]")
    WebElementFacade SetResetMemorableWordButton;
 	@FindBy(xpath=".//*[text()='Reset Word']")
    WebElementFacade ResetMemorablePopUp;
 	@FindBy(xpath=".//*[@aria-label='Reset Word:Ok']")
    WebElementFacade SetResetMemorableWordOKButton;
 	
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
	WebElementFacade EmailAddressTextBox;
	
	@FindBy(xpath=".//*[@aria-label='Personal details:Reset password']")
	WebElementFacade ResetPasswordButton;
	
	@FindBy(xpath=".//span[text()='Marketing permissions']")
    WebElementFacade MarketPermissionLevelPopup;
	
	@FindBy(xpath=".//span[text()='Marketing permissions']/parent::div/following-sibling::div[2]//button")
    WebElementFacade MarketPermissionLevelPopupOKButton;
	@FindBy(xpath=".//*[@aria-label='Date of birth']")
	WebElementFacade ChangedDOB;
	
	@FindBy(xpath=".//*[contains(@class,'vfoui-contactform')]//button[@aria-label='Edit']")
    WebElementFacade EditContactButton;
	@FindBy(xpath=".//*[contains(@aria-label,'DPA is not required for this action')]")
	WebElementFacade GotoAccountLink;
  
	 @FindBy(xpath=".//*[contains(text(),'Error message')]")
	WebElementFacade ErrorTitleBox; 
	@FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
	WebElementFacade ErrorOkButton;
	@FindBy(xpath=".//div[contains(@class,'popup-info')]")
	WebElementFacade ErrorMsg;
	@FindBy(xpath=".//*[@class='vf-oui-error-generic-popup-info']")
    WebElementFacade MandatoryDOBPopUp;
 	@FindBy(xpath="(.//*[text()='Ok'])[3]")
    WebElementFacade MandatoryDOBPopUpOk;
 	@FindBy(xpath=".//*[@aria-labelledby='Do_not_Market_research_Label']")
 	WebElementFacade DoNotMarketingResearch;
 	@FindBy(xpath="//a[text()='Account overview']")
	WebElementFacade Accountoverviewlink;
 	@FindBy(xpath="(.//*[text()='Address'])[2]")
    WebElementFacade AddressList;
 	@FindBy(xpath="//*[@aria-label='Address:Expand Applet']/parent::span")
    WebElementFacade AddresslistDropdown;
 	@FindBy(xpath=".//*[@class='vfoui-padding-16px']")
	WebElementFacade AddressTextCapture;
 	
 	@Step
 	public void ContactManagement(String iRow) throws InterruptedException, IOException, AWTException, ParseException{
 		Common.waitForPageLoad(getDriver());
 		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
 		String dataSheet = "ContactManagement";
 		String applet = "//*[@title='Select contact List Applet']";
	    String table = "//table[@summary='Select contact']";

 		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(iRow, filePath, dataSheet);
 		readWorkbook.testData(tableMap);

 		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

 		if(GotoAccountLink.isCurrentlyVisible()) {
 			GotoAccountLink.click();
 	 		Common.WaitForClock(ClockObj);	
 		}
 		
 		report.Info("GotoAccountLink Button clicked.");
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
 	if(EditContactButton.isCurrentlyVisible()) {
 		EditContactButton.click();
 		Common.WaitForClock(ClockObj);report.Info("Update Contact Button clicked.");
 	}
        
        for (int i = 0;i < tableMap.get("EX").size();i++) { 	  	    
	    String sDOB = tableMap.get("DOB").get(i);
	    String sPopUp = tableMap.get("PopUp").get(i);
	    String sLocateCol = tableMap.get("LocateCol").get(i);
	    String sLocateColValue = tableMap.get("LocateColValue").get(i);
	    String sIndex = tableMap.get("Index").get(i);
	    String sPermissionLevel = tableMap.get("PermissionLevel").get(i);
	    String UIName = tableMap.get("UIName").get(i);
	    String value = tableMap.get("Value").get(i);
	    String sUpdateContact = tableMap.get("UpdateContact").get(i);
	    String sPopUp2 = tableMap.get("PopUp2").get(i);
	    String sPerformAction = tableMap.get("PerformAction").get(i);
	    String sAccount = tableMap.get("Account").get(i);
	    String sValidation = tableMap.get("Validation").get(i);
	    String sDateOfBirth = tableMap.get("DateOfBirth").get(i);
	    String sEmail = tableMap.get("Email").get(i);
	    String sMarketingPermission = tableMap.get("MarketingPermission").get(i);
	    String sContactNum = tableMap.get("ContactNum").get(i);
	    
	    if (sIndex.equals("")){
 		   sIndex = "0";
         }
	    Alert alert;
        String ActAlertText="";
        
        Random rand = new Random(System.currentTimeMillis());
		int num = rand.nextInt(20000);
		String Firstname = String.valueOf(num);
		Firstname = "Enh"+Firstname;
	    
		
		
		if (sPerformAction.equalsIgnoreCase("MakeItPrimaryContact")){

			NewContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			NewContactButton.click();

			TitleTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
			TitleTextBox.type("Mr.");
			FirstNameTextBox.type(Firstname);
			LastNameTextBox.type("OUI");
			DOBTextBox.type(sDOB);
			PIN1.type("1");
			PIN2.type("1");
			PIN3.type("1");
			PIN4.type("1");
			OnlineIDCheckBox.click();
			ContactTextBox.clear();
			ContactTextBox.type(sUpdateContact);

			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				String LocateColMessege = CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  							 
			}
			else{
				CommonEnh.selectedRow = 1;
			}
			if (!UIName.equals("")){ 
				String Addressvalue= CommonEnh.updateSiebList(applet,table, UIName, value);           
				Serenity.setSessionVariable("Addressvalue").to(Addressvalue);
			}
			SaveButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			SaveButton.click();
			Common.WaitForClock(ClockObj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if(!sPopUp.equalsIgnoreCase("")){
				Common.HandleErrorPopUp(sPopUp); 
			}

			if(MarketPermissionLevelPopup.isCurrentlyVisible()){
				MarketPermissionLevelPopupOKButton.click();
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);
			}
			break;
		}
		
		
		
        
        if (sPerformAction.equalsIgnoreCase("AddNewContact")){
	    	NewContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	NewContactButton.click();
	    	
	    	TitleTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
	    	TitleTextBox.type("Mr.");
	    	FirstNameTextBox.type(Firstname);
	    	LastNameTextBox.type("OUI");
	    	DOBTextBox.type(sDOB);
	    	PIN1.type("1");
	    	PIN2.type("1");
	    	PIN3.type("1");
	    	PIN4.type("1");
	    	OnlineIDCheckBox.click();
	    	Calendar c = Calendar.getInstance();
	    	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	    	Date DOBdate = dateFormat.parse(sDOB);
	    	c.setTime(DOBdate);
	    	int birthYear = c.get(Calendar.YEAR);
	    	
	        Date currentDate = new Date();
	        c.setTime(currentDate);
	        int CurrentYear = c.get(Calendar.YEAR);
	    	int a=CurrentYear-birthYear;
	    	 if(a < 16)
	      {
	      DoNotEmail.click();
	      sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	      DoNotMarketingResearch.click();
	      sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	      DoNotMail.click();
	      sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	      
	      }
	    	SaveButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	SaveButton.click();
	    	Common.WaitForClock(ClockObj);
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	
	    	
	    	
	    	if(!sPopUp.equalsIgnoreCase("")){
				Common.HandleErrorPopUp(sPopUp); 
			}
	    	
			if(MarketPermissionLevelPopup.isCurrentlyVisible()){
				MarketPermissionLevelPopupOKButton.click();
				Thread.sleep(1000);
				Common.WaitForClock(ClockObj);
			}
	    	
	    	
	    	
	    	if (!sLocateCol.equals("")){
	    		CommonEnh.selectedRow = -1;
                String LocateColMessege = CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex);
                //Assert.assertTrue(LocateColMessege, LocateColMessege.equals("true"));       
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  							 
                }
           else{
        	   CommonEnh.selectedRow = 1;
           }
	    	
	    	PermissionLevelTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
	    	PermissionLevelTextBox.typeAndEnter(sPermissionLevel);
	    	PersonalDetailsSaveButton.click();
	    	
	    	
	    	//ValidationText.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
	    	report.Info("Permission is given for Account");
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    }
	    
        if (sPerformAction.equalsIgnoreCase("DeleteContact")){
        	
        	if (!sLocateCol.equals("")){
	    		CommonEnh.selectedRow = -1;
                String LocateColMessege = CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex);
                //Assert.assertTrue(LocateColMessege, LocateColMessege.equals("true"));       
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  							 
                }
           else{
        	   CommonEnh.selectedRow = 1;
           }
        		

	    	if (!UIName.equals("")){ 
	    		CommonEnh.updateSiebList(applet,table, UIName, value);           
	    		Common.WaitForClock(ClockObj);
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    		if(isAlertPresent(getDriver())){
	    			alert=getDriver().switchTo().alert();
	    			ActAlertText=alert.getText(); 
	    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    			if (ActAlertText.contains(sPopUp2)){                    	
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
	    
	    if (sPerformAction.equalsIgnoreCase("ChangeContact")){


	    	ContactTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
	    	ContactTextBox.clear();
	    	ContactTextBox.type(sUpdateContact);

	    	SaveButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	SaveButton.click();
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	
	    	Common.WaitForClock(ClockObj);
	    	if(MarketPermissionLevelPopup.isCurrentlyVisible()){
				MarketPermissionLevelPopupOKButton.click();
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);
			}
	    	
	    	if(!sPopUp.equalsIgnoreCase("")){
	    		Common.HandleErrorPopUp(sPopUp); 
	    	} 
	    	
	    }
	    
	    if (sPerformAction.equalsIgnoreCase("ChangeDOBandsave")){
	    	ChangedDOB.waitUntilPresent();
	    	ChangedDOB.clear();
	    	//ChangedDOB.typeAndEnter(value)
	    	ChangedDOB.sendKeys(sDateOfBirth);
	    	Thread.sleep(2000);
	    	SaveMarketingPermission.click();
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	report.Info("Date of Birth Changed to"+sDateOfBirth);
	    	if(MarketPermissionLevelPopup.isCurrentlyVisible()){
	    		MarketPermissionLevelPopupOKButton.click();
	    		Thread.sleep(2000);
	    		Common.WaitForClock(ClockObj);
	    	}
	     }	

	    if (sValidation.equalsIgnoreCase("Underage"))
	    {
	    	ChangedDOB.waitUntilPresent();
	    	ChangedDOB.clear();
	    	ChangedDOB.sendKeys(sDateOfBirth);
	    	Thread.sleep(2000);
	    	ContactMarketingpermission.click();
	    	Underage.waitUntilClickable();
	    	Underage.click();
	    	ContactMarketingpermission.click();
    		    		    		
    		DoNotEmail.isPresent();
    		DoNotMarketresearch.isPresent();
    		DoNotMail.isPresent();
    		report.Info("Marketing Permission 'DoNotMail','DoNotMarketresearch' & 'DoNotEmail' are Disabled");

    		SaveMarketingPermission.click();
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	
	    	if(MarketPermissionLevelPopup.isCurrentlyVisible()){
    			MarketPermissionLevelPopupOKButton.click();
    			Thread.sleep(2000);
    			Common.WaitForClock(ClockObj);
    		}
	    	if(MandatoryDOBPopUp.isCurrentlyVisible()){
	    		MandatoryDOBPopUpOk.click();
			    Common.WaitForClock(ClockObj);
	    	}
    	}
	    	
	    if (sPerformAction.equalsIgnoreCase("AddExistingContact")){

	    	AddExistingContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	AddExistingContactButton.click();
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    	ExistingContactFirstName.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
	    	
	    	
	    	if(sAccount.equals("Minor")) 
	    	{
	    		DateOfBirth.sendKeys(sDateOfBirth);
	    		EmailSend.sendKeys(sEmail);
	    		ExistingContactSearchButton.click();
	    	}
	    	else if(sAccount.equals("Major"))
	    	{
	    		DateOfBirth.sendKeys(sDateOfBirth);
	    		EmailSend.sendKeys(sEmail);	
	    		ExistingContactSearchButton.click();
	    	}
	    	else if(sAccount.equals("NODOB"))
	    	{
	    		ContactNumber.sendKeys(sContactNum);
	    		EmailSend.sendKeys(sEmail);	
	    		ExistingContactSearchButton.click();
	    	}
	    	else
	    	{
	    		ExistingContactFirstName.type("Postzz");
	    		ExistingContactLastName.type("Payzz");
	    		ExistingContactSearchButton.click();
	    	}

	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    	ExistingContactAddToContactsButton.click();

	    	if(isAlertPresent(getDriver())){
	    		alert=getDriver().switchTo().alert();
	    		ActAlertText=alert.getText(); 
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    		if (ActAlertText.contains(sPopUp)){                    	
	    			alert.accept();
	    			System.out.println("Message is: "+ActAlertText);
	    			report.Info("alert messsage is"+ActAlertText);		                	
	    		}                                 
	    	}

	    	if (!sLocateCol.equals("")){
	    		CommonEnh.selectedRow = -1;
	    		String LocateColMessege = CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex);
	    		//Assert.assertTrue(LocateColMessege, LocateColMessege.equals("true"));       
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  							 
	    	}
	    	else{
	    		CommonEnh.selectedRow = 1;
	    	}
	
	    	
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    	if(sValidation.equals("MarketingPermissionForMinor"))
	    	{
	    		ContactMarketingpermission.click();
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    		DoNotEmail.isPresent();
	    		report.Info("Marketing Permission 'DoNotEmail' Disabled");

	    		DoNotMarketresearch.isPresent();
	    		report.Info("Marketing Permission 'DoNotMarketresearch' Disabled");

	    		DoNotMail.isPresent();
	    		report.Info("Marketing Permission 'DoNotMail' Disabled");
	    	}

	    	if(sValidation.equals("MarketingPermissionForMajor"))
	    	{
	    		ClickDoNotEmail.waitUntilClickable();
	    		if(BlankDoNotEmail.isPresent()) {
	    			ClickDoNotEmail.click();
	    			}

	    		if(BlankDoNotMarketresearch.isPresent()){
	    			ClickDoNotMarketresearch.click();
	    			}

	    		if(BlankDoNotMail.isEnabled()){
	    			ClickDoNotMail.click();
	    			}

	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    		report.Info("Marketing Permissions are Enabled and selected");

	    	}
	    	if(sValidation.equals("MarketingPermissionForWithoutDOB"))
	    	{
	    		Underage.waitUntilClickable();
	    		Underage.click();
	    		ContactMarketingpermission.click();

	    		DoNotEmail.isPresent();
	    		DoNotMarketresearch.isPresent();
	    		DoNotMail.isPresent();
	    		report.Info("Marketing Permission 'DoNotMail','DoNotMarketresearch' & 'DoNotEmail' are Disabled");

	    		SaveMarketingPermission.click();
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    		if(MarketPermissionLevelPopup.isCurrentlyVisible()){
	    			MarketPermissionLevelPopupOKButton.click();
	    			Thread.sleep(2000);
	    			Common.WaitForClock(ClockObj);
	    		}

	    		RecordAlreadyExistedPopUpOk.waitUntilClickable();
	    		RecordAlreadyExistedPopUpOk.click();
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	}

	    	if(sMarketingPermission.equals("SaveAndValidate"))
	    	{
	    		SaveMarketingPermission.click();
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    		if(MarketPermissionLevelPopup.isCurrentlyVisible()){
	    			MarketPermissionLevelPopupOKButton.click();
	    			Thread.sleep(2000);
	    			Common.WaitForClock(ClockObj);
	    		}
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    		Actions actions = new Actions(getDriver());
	    		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

	    		MarketingPermissionHistoryDropdown.click();
	    		Permission.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    		Thread.sleep(5000);
	    		Permission.click();
	    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	    	}

	    }
	    
	    if (sPerformAction.equalsIgnoreCase("ResetPin")  ){
	    	NewContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	EmailAddressTextBox.click();
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	     	SetResetPinButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	     	SetResetPinButton.click();
 	
 			 for(int j = 1;j < 5;j++){
 				 
            		String PinTextBox =  ".//*[@rn='VF_PIN_"+j+"']";
            		//String Value = find(By.xpath(PinTextBox)).getAttribute("class");
            		//if (!Value.contains("readonly")){
            			find(By.xpath(PinTextBox)).type("2");
            		//}
            	 }
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	     	SetResetPinOKButton.click();
	     	Common.WaitForClock(ClockObj);
	     	
	     	Common.HandleErrorPopUp(sPopUp);
	     	report.Info("PIN updated successfully");
	    	}
	    
	    
	    if (sPerformAction.equalsIgnoreCase("Memorable word")){
	    	NewContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	SetResetMemorableWordButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	SetResetMemorableWordButton.click();
	    	EmailAddressTextBox.click();
	    	ResetMemorablePopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	MemorableWordTextBox.type("memorable123");
	    	MemorableHintTextBox.type("memorable123");
	    	
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 			SetResetMemorableWordOKButton.click();
	     	Common.WaitForClock(ClockObj);
	     	
	     	Common.HandleErrorPopUp(sPopUp);	    	
	     	report.Info("Memorable word updated successfully");	
	    	}
	    
	    if (sPerformAction.equalsIgnoreCase("UpdateEmail")){
	    	NewContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	EmailAddressTextBox.click();
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
	     	
	     	EmailAddressTextBox.click();
	     	String Email = EmailAddressTextBox.getTextValue();
	     	Assert.assertTrue("Email not updated", Email.equalsIgnoreCase("newemail@gmail.com") ); 
	     	report.Info("Email updated successfully");
	     	
	     	//Common.HandleErrorPopUp(sPopUp);	    	

	    	}
	    if (sPerformAction.equalsIgnoreCase("RemoveEmail")){
	    	RemoveEmailID.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", ChangedDOB); 
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			RemoveEmailID.click();
			Common.WaitForClock(ClockObj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			report.Info("Email ID Removed successfully");
	    }
	    
	    if (sPerformAction.equalsIgnoreCase("ResetPassword")){
	    	NewContactButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	EmailAddressTextBox.click();
	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    	ResetPasswordButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	    	ResetPasswordButton.click();
	    	
	    	Common.WaitForClock(ClockObj);
	     	Common.HandleErrorPopUp(sPopUp);
	     	
	    	report.Info("Email updated successfully");    	

	    	}
	    
	    if (sPerformAction.equalsIgnoreCase("Address")){
	    	if (AddressList.isVisible()) {
		    	AddresslistDropdown.click();
		    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    	
		    	String Adddressalidation = AddressTextCapture.getTextValue();
		    	
		    	if (Adddressalidation.contains(sValidation)){
		    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					System.out.println("Primary added address is: "+Adddressalidation);
				}
				else {
					Assert.assertTrue(false);
				}

	    	}
	   
	    	}
	    
        } 
 	}
 	@FindBy(xpath="(.//*[@aria-label='Edit'])[2]")
 	WebElementFacade ContactPencilElement;
 	
	@FindBy(xpath=".//a[translate(text(),'AO','ao')='account overview']")
 	WebElementFacade AccountOverviewTab;
 	
	@FindBy(xpath=".//*[contains(@aria-label,'Remove email')]")
	WebElementFacade RemoveEmailID;
 	
 	
 	@Step
 	public void NavigateToContactTab() throws InterruptedException, IOException, AWTException{
 		Common.WaitForClock(ClockObj);
 		
 		ContactPencilElement.click();
 		Thread.sleep(2000);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		Assert.assertTrue("Fail, Account Overview Tab is not Visible",AccountOverviewTab.isCurrentlyVisible());
 		AccountOverviewTab.click();
 		Thread.sleep(2000);
 		report.Info("Account Overview Tab is Present As Expected");
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 	 	}
 	
 	

 	@FindBy(xpath=".//div[contains(@class,'siebui-applet-title')][text()='NBA offers']")
 	WebElementFacade NBAOffersApplet;

 	@FindBy(xpath=".//*[@class='vfoui-createnew-button']")
 	WebElementFacade CreateNewButton;

 	@Step
 	public void ValidateNBAOffersApplet() throws InterruptedException, IOException, AWTException{
 		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		
 		if(ReasonTitleBox.isCurrentlyVisible()){
 			String ErrorInfo= ReasonMsg.getText();

 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 			ReasonOkButton.click();
 			report.Info("The alert meassage is:"+ErrorInfo);
 		}
 		CreateNewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		
 		Assert.assertTrue("NBA Offers Applet is not present for agent login",NBAOffersApplet.isVisible());
 		report.Info("NBA Offers Applet is present for agent login");    	
 	}
 	
 	@FindBy(xpath="(.//a[text()='Contacts'])[2]")
 	WebElementFacade ContactButton;
 	@FindBy(xpath=".//*[contains(@aria-label,'Do not use third party social')]")
 	WebElementFacade ThirdPartySocialCheckBox;
 	@FindBy(xpath=".//span[contains(@class,'vfoui-marketing-pref vfoui-donotusethirdpartysocial')]")
 	WebElementFacade ThirdPartySocialToolTip;
 	@FindBy(xpath=".//*[@class='vfoui-tooltip-content']")
 	WebElementFacade ThirdPartySocialToolTipContentOLD;
 	@FindBy(xpath=".//div[contains(text(),'When ticked this means the customer has not given permission for Vodafone to use third party social media and apps data for marketing purposes')]")
 	WebElementFacade ThirdPartySocialToolTipContent;
 	@FindBy(xpath=".//*[text()='Marketing permissions history']")
 	WebElementFacade MarketingPermissionHistoryButton;
 
 	
 	@Step
 	public void MarketingPermissionContactsTabCheck(String iRow) throws InterruptedException, IOException, AWTException{
 		Common.WaitForClock(ClockObj);
 		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
 		String dataSheet = "ContactManagement";
 		String applet = "";
	    String table = "";

 		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(iRow, filePath, dataSheet);
 		readWorkbook.testData(tableMap);
 		
 		Thread.sleep(2000);
 		Assert.assertTrue("Fail, Account Overview Tab is not Visible",AccountOverviewTab.isCurrentlyVisible());
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		
 		ContactButton.click();
 		report.Info("ContactButton is clicked");
 		Common.WaitForClock(ClockObj);
 		Thread.sleep(2000);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		
 		
 		for (int i = 0;i < tableMap.get("EX").size();i++) { 	  	    
	    String sPerformAction = tableMap.get("PerformAction").get(i);
	    String sDateOfBirth = tableMap.get("DateOfBirth").get(i);
	    String sLocateCol = tableMap.get("LocateCol").get(i);
	    String sLocateColValue = tableMap.get("LocateColValue").get(i);
	    String sIndex = tableMap.get("Index").get(i);
	    
	    Alert alert;
        String ActAlertText="";
        
        Actions action = new Actions(getDriver());
    	
 		 if (sPerformAction.equalsIgnoreCase("ChangeDOBandsave")){
 	    	ChangedDOB.waitUntilPresent();
 	    	
 	    	applet = "//*[@title='Select contact List Applet']";
 		    table = "//table[@summary='Select contact']";
 	    	
	 	    	if (!sLocateCol.equals("")){
		    		CommonEnh.selectedRow = -1;
	                String LocateColMessege = CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex);
	                //Assert.assertTrue(LocateColMessege, LocateColMessege.equals("true"));       
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  							 
	                }
	           else{
	        	   CommonEnh.selectedRow = 1;
	           }
	 	    ChangedDOB.click();
 	    	ChangedDOB.clear();
 	    	//ChangedDOB.typeAndEnter(value)
 	    	ChangedDOB.sendKeys(sDateOfBirth);
 	    	Thread.sleep(2000);
 	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 	    	SaveMarketingPermission.click();
 	    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 	    	report.Info("Date of Birth Changed to "+sDateOfBirth);
 	    	if(MarketPermissionLevelPopup.isCurrentlyVisible()){
 	    		MarketPermissionLevelPopupOKButton.click();
 	    		Thread.sleep(2000);
 	    		Common.WaitForClock(ClockObj);
 	    	}
 	     }	
 		 
 		if(sPerformAction.equalsIgnoreCase("CheckEditable")) {
 			String Readonly = ThirdPartySocialCheckBox.getAttribute("aria-readonly");
 			String Checked = ThirdPartySocialCheckBox.getAttribute("aria-checked");
 			
 			MarketingPermissionHistoryButton.click();
 			
 			Assert.assertTrue("Fail, Third Party Social Marketing Permission CheckBox is Checked",Checked.equalsIgnoreCase("false"));
 			report.Info("Third Party Social Marketing Permission CheckBox is Not checked");
 			 			
 			Assert.assertTrue("Fail, Third Party Social Marketing Permission CheckBox is not Editable",Readonly.equalsIgnoreCase("false"));
 			report.Info("Third Party Social Marketing Permission CheckBox is Editable");
 			
 			MarketingPermissionHistoryButton.click();
 			action.moveToElement(ThirdPartySocialToolTip).perform();

 			
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 			
 			
 			Assert.assertTrue("Fail, Tool tip text is not as expected",ThirdPartySocialToolTipContent.isPresent() );
 			//String ToolTip = ThirdPartySocialToolTipContent.getTextValue();
 			report.Info("Tool Tip value for Third Party Social Marketing Permission CheckBox is :When ticked this means the customer has not given permission for Vodafone to use third party social media and apps data for marketing purposes ");
 			
 			
 			//ThirdPartySocialCheckBox.click();
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 			SaveButton.click();
 			report.Info("Save Button is clicked");
 	 		Common.WaitForClock(ClockObj);
 	 		
 	 		if(isAlertPresent(getDriver())){
    			alert=getDriver().switchTo().alert();
    			ActAlertText=alert.getText(); 
    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			alert.accept();
    			report.Info("alert messsage is"+ActAlertText);		                	
    		}
 		}
 		
 		if(sPerformAction.equalsIgnoreCase("CheckNotEditable")) {
 			String Readonly = ThirdPartySocialCheckBox.getAttribute("aria-readonly");
 			String Checked = ThirdPartySocialCheckBox.getAttribute("aria-checked");
 			
 			MarketingPermissionHistoryButton.click();
 			
 			Assert.assertTrue("Fail, Third Party Social Marketing Permission CheckBox is not Checked",Checked.equalsIgnoreCase("true"));
 			report.Info("Third Party Social Marketing Permission CheckBox is Checked");
 						
 			
 			Assert.assertTrue("Fail, Third Party Social Marketing Permission CheckBox is Editable",Readonly.equalsIgnoreCase("true"));
 			report.Info("Third Party Social Marketing Permission CheckBox is not Editable");
 			
 			
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		}
 		
 	 	}
 	}
 	
		 	@FindBy(xpath=".//li[@rn='VF OUI Addresses View']")
		 	WebElementFacade AddressTab;
		 	@FindBy(xpath="//input[@rn='VF OUI Concat Address']")
		 	WebElementFacade AddressTextBox;
		 	
			@FindBy(xpath=".//input[@aria-labelledby='VF_Postcode_Label']")
		 	WebElementFacade PostCodeTextbox;
			@FindBy(xpath=".//li[@rn='VF OUI Addresses View']")
		 	WebElementFacade PostCodesearch;
			@FindBy(xpath=".//li[@rn='VF OUI Addresses View']")
		 	WebElementFacade AddressDropdown;
			@FindBy(xpath="//button[@aria-label='Add new address to account:Add address']")
		 	WebElementFacade Addaddressbutton;
			@FindBy(xpath="(.//td[@class='vf_oui_primary_align'])[1]")
		 	WebElementFacade ClickforCheckboxdisplay;
			@FindBy(xpath=".//input[@name='SSA_Primary_Field']")
		 	WebElementFacade ClickCheckbox;
			@FindBy(xpath=".//input[@rn='Billing address']")
		 	WebElementFacade CheckboxUpdatebillProfAddress;
			@FindBy(xpath=".//input[@aria-labelledby='Contact_address_Label']")
		 	WebElementFacade CheckboxUpdateContactAddress;
			
			@FindBy(xpath="(//td[contains(@id,'Primary_Field')])[1]")
		 	WebElementFacade PrimaryFirst;
			@FindBy(xpath="(//td[contains(@id,'Primary_Field')])[2]")
		 	WebElementFacade PrimarySecond;
			@FindBy(xpath=".//*[@id='1_s_3_l_SSA_Primary_Field'][@title='Checked']")
		 	WebElementFacade CheckPrimaryChecked;
			@FindBy(xpath=".//*[@id='2_s_3_l_SSA_Primary_Field'][@title='Checked']")
		 	WebElementFacade CheckSecondaryChecked;
			@FindBy(xpath=".//*[text()='Add new address to account']")
		 	WebElementFacade ClickNewAddressText;
			@FindBy(xpath=".//*[@id='2_SSA_Primary_Field']")
		 	WebElementFacade SecondaryCheckBox;
			@FindBy(xpath=".//*[@id='1_SSA_Primary_Field']")
		 	WebElementFacade PrimaryCheckBox;
			
		
		 	@Step
		 	public void AddressChange(String LogicalName) throws InterruptedException, IOException, AWTException{
		 		Common.WaitForClock(ClockObj);
		 		String filePath = "\\src\\test\\resources\\data\\Account_ENH.xls";
		 		String dataSheet = "AddressManagement";
		 		String applet = "//*[@title='Addresses List Applet']";
			    String table = "//table[@summary='Addresses']";
			    
			    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
				readWorkbook.testData(tableMap);
		
				for (int i = 0;i < tableMap.get("RowNo").size();i++) {
					String sLocateCol = tableMap.get("LocateCol").get(i);
					String sLocateColValue = tableMap.get("LocateColValue").get(i); 
					String Index = tableMap.get("Index").get(i);
					String sPostCode = tableMap.get("PostCode").get(i);
					String UIName = tableMap.get("UIName").get(i);
					String value = tableMap.get("value").get(i);
					String sUpdatePostcode = tableMap.get("UpdatePostcode").get(i);
					String sCheckboxckeck = tableMap.get("Checkboxckeck").get(i);
					String sPostCodeAddress = tableMap.get("PostCodeAddress").get(i);
					String sCheckUpdatebillProfileAddress = tableMap.get("CheckUpdatebillProfileAddress").get(i);
					String sCheckUpdateContactAddress = tableMap.get("CheckUpdateContactAddress").get(i);
			    
			    if (AddressTab.isVisible()) {
			    	AddressTab.click();
			    }
			    
			    if (Index.equals("")){
					Index = "0";
				} 
		
			    if (sUpdatePostcode.equalsIgnoreCase("Yes")) 
			    {
		    	int RowCount = findAll(By.xpath("//table[@summary='Addresses']/tbody/tr")).size(); 

		    	if(RowCount==2)
		    	{
		    		if (PostCodeTextbox.isVisible()) {
		    			PostCodeTextbox.sendKeys(sPostCode);
		    			Thread.sleep(1000);
		    			PostCodesearch.click();
		    			Thread.sleep(1000);
		    			AddressTextBox.sendKeys(sPostCodeAddress);
		    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    			if (sCheckUpdatebillProfileAddress.equals("Yes")) {
		    				CheckboxUpdatebillProfAddress.isVisible();
		    				CheckboxUpdatebillProfAddress.click();
		    			}
		    			if (sCheckUpdateContactAddress.equals("Yes")) {
		    				CheckboxUpdateContactAddress.isVisible();
		    				CheckboxUpdateContactAddress.click();
		    			}
		    			Addaddressbutton.click();	

		    			if (!sLocateCol.equals("")){
		    				CommonEnh.selectedRow = -1;
		    				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equalsIgnoreCase("true"));
		    				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
		    				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    			}
		    			else{               
		    				Common.selectedRow = 1;
		    			}

		    			if (!UIName.equals("")){ 
		    				String Addressvalue= CommonEnh.updateSiebList(applet,table, UIName, value);           
		    				Serenity.setSessionVariable("Addressvalue").to(Addressvalue);
		    			}
		    		}
		    		else 
		    		{
		    			Assert.assertTrue(false);
		    		}
		    	}
		    	else{
		    		report.Info("More than one address is already present");
		    	}
		    	if(RowCount>=2)
		    	{
		    		if(CheckPrimaryChecked.isPresent()) {
		    			PrimarySecond.click();
		    			Thread.sleep(5000);
		    			SecondaryCheckBox.click();
		    			Thread.sleep(2000);
		    			ClickNewAddressText.click();
		    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    		}
		    		//if(CheckSecondaryChecked.isPresent()) {
		    		else{
		    			PrimaryFirst.click();
		    			Thread.sleep(5000);
		    			PrimaryCheckBox.click();
		    			Thread.sleep(2000);
		    			ClickNewAddressText.click();
		    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    		}
		    	}
		    	else
		    	{
		    		Assert.assertTrue(false);
		    	}
		    
			    }
			    
			    /* if (sUpdatePostcode.equalsIgnoreCase("Yes")) {
				    if (PostCodeTextbox.isVisible()) {
				    	PostCodeTextbox.sendKeys(sPostCode);
				    	Thread.sleep(1000);
				    	PostCodesearch.click();
				    	Thread.sleep(1000);
				    	AddressTextBox.sendKeys(sPostCodeAddress);
				    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				    	if (sCheckUpdatebillProfileAddress.equals("Yes")) {
				    		CheckboxUpdatebillProfAddress.isVisible();
				    		CheckboxUpdatebillProfAddress.click();
				    	}
				    	if (sCheckUpdateContactAddress.equals("Yes")) {
				    		CheckboxUpdateContactAddress.isVisible();
				    		CheckboxUpdateContactAddress.click();
				    	}
				    	Addaddressbutton.click();	
				    }
				    else {
				    	Assert.assertTrue(false);
				    }
			    }*/
			    
			    if (!sLocateCol.equals("")){
					CommonEnh.selectedRow = -1;
					Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equalsIgnoreCase("true"));
					report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				else{               
					Common.selectedRow = 1;
				}
			    
			    if (!UIName.equals("")){ 
		    		String Addressvalue= CommonEnh.updateSiebList(applet,table, UIName, value);           
		    		Common.WaitForClock(ClockObj);
		    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    		Serenity.setSessionVariable("Addressvalue").to(Addressvalue);
			    }
			    
			    if (sCheckboxckeck.equalsIgnoreCase("Yes")) {
				    if (ClickforCheckboxdisplay.isVisible()) {
				    	Thread.sleep(1000);
				    	ClickforCheckboxdisplay.click();
				    	Thread.sleep(1000);
				    	ClickCheckbox.waitUntilClickable();
				    	ClickCheckbox.click();
				    	Thread.sleep(1000);
				    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				    	Actions action = new Actions(getDriver());
				    	action.sendKeys(Keys.chord(Keys.CONTROL + "s")).perform();
				    	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				    }
				    else {
				    	Assert.assertTrue(false);
			    }
			    }
			    
		 		
		 	
		 	}
		 		
		 }
		 	 
		 	    
 	
 	
}
