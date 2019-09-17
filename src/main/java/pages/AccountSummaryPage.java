package pages;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.Serenity.SessionVariableSetter;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;


public class AccountSummaryPage extends PageObject {

	@Steps
	private ReadWorkbook readWorkbook;
	@Steps
	private SikuliUtility sikuliUtility;
	@Steps
	private SikuliUtility SikuliUtility;
	@Steps
	private common Common;

	@Steps
	private AboutCustomerPageEnh AboutCustomerEnh;

	@Steps
	ReportMessege report;

	@Steps
	private common common1;	
	
	@Steps	
	private commonEnh CommonEnh;
	
	public static boolean isAlertPresent(WebDriver driver) {
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException ex){
			return false;
		}
	}
	@FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
    WebElement Clockobj; 
	
	@FindBy(xpath=".//*[@aria-label='InstalledAssets:Modify']//following::*[@aria-label='Installed Assets:Fast Orders']")
	WebElementFacade FastOrdersAfterModifyButton;    
	@FindBy(xpath=".//*[@aria-label='Installed Assets:Fast Orders']")
	WebElementFacade FastOrdersButton; 
	@FindBy(xpath=".//*[@id='jqgh_s_1_l_Product_Name']")
	WebElementFacade ModifyButton;
	@FindBy(xpath=".//*[@aria-label='Account Details:Menu']")
	WebElementFacade AccountSummaryMenuButton;
	@FindBy(xpath="//span/ul/li[9]/a")
	WebElementFacade AccountSummaryRefreshMenuItem;

	@FindBy(xpath=".//*[@id='1_Product_Name']")
	WebElementFacade ProductName; 
	@FindBy(xpath=".//*[@aria-label='Installed Assets:Menu']")
	WebElementFacade UsedProductMenuButton; 
	@FindBy(xpath=".//*[@aria-label='Third Level View Bar']")
	WebElementFacade AccountTabsDRopDown;
	@FindBy(xpath=".//button[text()='Done']")
	WebElementFacade DoneButton;

	@FindBy(xpath=".//*[aria-label = 'starting with']")
	WebElementFacade TextBox;

	//Performs actions on Menu and Button in UsedProduct&Services Applet
	// By Payel

	@FindBy(xpath=".//*[@data-tabindex='tabScreen4']")
	WebElementFacade Ordertab;

	@FindBy(xpath=".//*[@title='Sales Orders:Query']")
	WebElementFacade OrderQuery;


	@FindBy(xpath=".//*[@id='s_2_1_1_0_icon']")
	WebElementFacade OrderListAplet;


	@FindBy(xpath=".//*[@name='Order_Number']")
	WebElementFacade ListAplet;

	@FindBy(xpath=".//*[@id='s_2_1_6_0_Ctrl']")
	WebElementFacade SalesOrderGo;


	@FindBy(xpath=".//*[@id='1_s_2_l_Account']/a")
	WebElementFacade ClickOnAccountname;


	@FindBy(xpath=".//*[@id='1_s_1_l_Order_Number']/a")
	WebElementFacade ClickOnOrderNumber;

	@FindBy(xpath=".//*[@aria-label='Messages:Accept']")
	WebElementFacade AcceptButton;
	
	@FindBy(xpath="//span[text()='Include']")
    WebElementFacade DisconnectPopupMsg;

	@FindBy(xpath=".//*[@name='popup']")
	WebElementFacade VerifyMessages;

	@FindBy(xpath=".//*[@class='siebui-ctrl-btn appletButton'][contains(text(),'Add')]")
	WebElement EconfigDoneButtonSync;
	@FindBy(xpath=".//*[@aria-label='Add Remove Products:Go']")
	 WebElement ProductTypeGoButtonSync;
	

	@Step      
	public void UsedProductServices(String action) throws IOException, InterruptedException, FindFailed, AWTException{
		Common.waitForPageLoad(getDriver());

		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "UsedProductServices";
		String applet = "//*[@title='Installed Assets List Applet']";
		String table = "//table[@summary='SIS OM Products & Services Root List (Service) - Tiny']";   	


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("LocateCol").size()==0){
			report.Info(action+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) { 	  
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			if (sLocateColValue.equals("Promotion")){
				sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
			}
			if (sLocateColValue.equals("InstalledId")){
				sLocateColValue = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
			} 
			String sIndex = tableMap.get("Index").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sEnableAction = tableMap.get("EnableAction").get(i);
			String sEnable = tableMap.get("Enable").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			
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
			
			

			long startTime = System.currentTimeMillis();
			if (AccountSummaryTab.isDisplayed()){
				AccountSummaryTab.click();	    		   
			}
			else {
				AccountTabsDRopDown.selectByVisibleText("Account Summary");	   			
			} 

			///Code to refresh Account summary page till Used product Service has rows in the applet

			int k=0;
			int RowCount = '0';
			do {
				/* ProductServicesMenuIcon.click();
			    	  Thread.sleep(1000);
			    	  RefreshMenuItem.click();
			    	  Thread.sleep(1000);*/
				//  getDriver().navigate().refresh();-- not working for chrome
				Robot robot = new Robot();	 
				robot.keyPress(KeyEvent.VK_F5);	
				robot.keyRelease(KeyEvent.VK_F5); 
				
				RowCount = findAll(By.xpath("//table[@summary='SIS OM Products & Services Root List (Service) - Tiny']/tbody/tr")).size();
				if (RowCount > 2){		        		  
					long endTime = System.currentTimeMillis();
					long totalTime = endTime - startTime;
					// Common.WritePerformanceOutput("Used Product Rows found successfully,Total Time " + totalTime/1000);

					break;
				}
				Common.waitForPageLoad(getDriver());
				k++;
			}while(RowCount<1 && k<20);

			if (RowCount < 1){
				report.Info("Used Product Rows is not added successfully.");
				Assert.assertTrue(false);
			}



			//ModifyButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());


			if(sAction.equalsIgnoreCase("FastOrder")){

				if(FastOrdersAfterModifyButton.isPresent()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Fast Order button is present on right side of Modify button as expected");
					break;
				}
				else{
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Fast Order button is not present on right side of Modify button.");
					break;
				} 

			}


			if (sIndex.equals("")){
				sIndex = "0";
			}

			// String LocateColMessege = sLocateColValue+" Not Found";             

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				String LocateColMessege = common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex);
				Assert.assertTrue(LocateColMessege, LocateColMessege.equals("true"));       
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  							 
			}
			else{
				common1.selectedRow = 1;
			}

			if (!sUIName.equals("")){
				if (sValue.equals("AgreementRowID")){
					sValue = Serenity.sessionVariableCalled("AgreementRowID").toString();
				}//do not delete
				common1.updateSiebList(applet,table, sUIName, sValue);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			String sActEnable = "" ;
			if  (!sEnableAction.equals("")) {
				String FO = FastOrdersButton.getAttribute("disabled");
				/*if (FO.equals("true")){
						sActEnable = "No";
						ProductName.click();
						//screenshot

					}*/
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

				if (FastOrdersButton.isEnabled()){
					sActEnable = "Yes";
					//ProductName.click();
				} 
				else {
					sActEnable = "No";
					//screenshot

				}	
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL : "+sEnableAction+" existence is "+sActEnable+"  but expected was "+sEnable , sActEnable.equalsIgnoreCase(sEnable));

				report.Info("PASS : "+sEnableAction+" existence is "+sActEnable+" as expected");
				break;									   				   			
			}

			if (!sAction.equals("")){
				//SessionVariableSetter UsedProdAction = Serenity.setSessionVariable(System.currentTimeMillis());
				Serenity.setSessionVariable("UsedProdAction").to(System.currentTimeMillis());
				if ((sAction.equals("Modify"))|| (sAction.equals("Fast Orders"))){
					//This will click on Modify or Fast Orders
					String Button = ".//*[@title='Installed Assets:"+sAction+"']" ;
					if(sAction.equals("Fast Orders")){
						startTime = System.currentTimeMillis();
						find(By.xpath(Button)).click();	 
						Common.waitForElement(ProductTypeGoButtonSync);

						long endTime = System.currentTimeMillis();
						long totalTime = endTime - startTime;

						Common.WritePerformanceOutput("Fast Orders Clicked "+sAction+" ,Total Time " + totalTime/1000);	
					}
					if(sAction.equals("Modify")){
						startTime = System.currentTimeMillis();
						find(By.xpath(Button)).click();	 
						if(isAlertPresent(getDriver())){
							Alert alert = getDriver().switchTo().alert();
							String ActAlertText = alert.getText(); 
															  				  						
							if (ActAlertText.contains("FRAUD RISK")){
								alert.accept();
								System.out.println("alert messsage is"+ActAlertText);
							}                                                                                       
							                     
						}
//						Common.waitForElement(EconfigDoneButtonSync);
						Common.WaitForClock(Clockobj);

						long endTime = System.currentTimeMillis();
						long totalTime = endTime - startTime;

						Common.WritePerformanceOutput("Modify Clicked "+sAction+" ,Total Time " + totalTime/1000);	
					}

					report.Info("Info : Clicked on Menu "+sAction);

					//Thread.sleep(5000);
					Common.waitForPageLoad(getDriver());

					//sPopUpImage = "FraudRiskConfirmButton";
					if (sAction.equals("Modify")){
						//sikuliUtility.ClickFraudRiskAlert(SikulifilePath);
						
						if (sPopUp.equals("Error running sub-process")){
							sikuliUtility.ErrorSubProcess(SikulifilePath);
							report.Info("Error running sub-process Pop-Up handled");
						}
					}
					if (sAction.equals("Modify Promo")){
						sikuliUtility.ClickModPromokAlert(SikulifilePath);
					}

				}	
				else{
					//Thread.sleep(3000);
					UsedProductMenuButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					UsedProductMenuButton.click();
					//String Menu = "//a[text()='"+sAction+"']" ;	   
					String Menu = "//a[contains(text(),'"+sAction+"')]" ;

					startTime = System.currentTimeMillis();
					getDriver().findElement(By.xpath(Menu)).click();
					if(sAction.equalsIgnoreCase("Transfer of Ownership")){
						Common.waitForElement(TOOContinueButtonWebElement);

						long endTime = System.currentTimeMillis();
						long totalTime = endTime - startTime;

						Common.WritePerformanceOutput("TOO Clicked ,Total Time " + totalTime/1000);

					}


					report.Info("Info : Clicked on Menu "+sAction);
					//Thread.sleep(3000);

					if (sAction.equals("Modify Promo")){
						if (sUIName.equals("Prepay")){
							break;
						}
						sikuliUtility.ClickModPromokAlert(SikulifilePath);
					}


				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if ((sAction.equals("Disconnect"))||(sAction.equals("Post to Pre Migration"))||(sAction.equals("Pre to Post Migration"))){
				Thread.sleep(3000);
				Common.WaitForClock(Clockobj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if (DisconnectPopupMsg.isVisible()){
					DisconnectPopupMsg.click();
					//Thread.sleep(3000);
					report.Info("Disconnection Pop button Clicked");
					Common.waitForElement(AcceptButton);
				}

				if (AcceptButton.isCurrentlyVisible()){
					AcceptButton.isCurrentlyVisible();
					AcceptButton.click();
					report.Info("Verify Message Accept button Clicked");

				}
			}				
		}		   
	}

	@FindBy(xpath=".//a[text()='Profiles']")
	WebElementFacade ProfilesTab;
	@FindBy(xpath=".//a[text()='Billing profile']")
	WebElementFacade BillingProfilesTab;
	@FindBy(xpath=".//*[@id='1_s_6_l_VF_Payment_Terms']")
	WebElementFacade ClickPaymentTermsElement;
	@FindBy(xpath=".//*[@id='1_VF_Payment_Terms']")
	WebElementFacade PaymentTermsTextBox;
	@FindBy(xpath=".//*[contains(@data-display,'New')]")
	WebElementFacade NewBillProfile;

	public void PaymentTerms() throws InterruptedException, IOException, AWTException{
		Common.waitForPageLoad(getDriver());

		if (ProfilesTab.isVisible())
		{
			ProfilesTab.click();
		}
		else
		{
			TabDropDown.selectByVisibleText("Profiles");
		} 

		BillingProfilesTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		BillingProfilesTab.click();
		NewBillProfile.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();			
		NewBillProfile.click();
		ClickPaymentTermsElement.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();		
		ClickPaymentTermsElement.click();
		PaymentTermsTextBox.type("10");
		report.Info("PASSED, Check Payment Terms is Editable");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@FindBy(xpath=".//*[@id='j_s_vctrl_div_tabScreen']")
	WebElementFacade TabDropDown;
	@FindBy(xpath="//button[@aria-label='Account Addresses:Update Contact Address']/following-sibling::div/input[@aria-label='Find']/following-sibling::span")
	WebElementFacade AccountAddressesList;
	@FindBy(xpath=".//li[text()='For the attention of']")
	WebElementFacade FortheAttention;
	public void AccountAddressesList() throws InterruptedException, IOException, AWTException{
		Common.waitForPageLoad(getDriver());

		TabDropDown.selectByVisibleText("Addresses");
		AccountAddressesList.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
		AccountAddressesList.click();

		if (FortheAttention.isCurrentlyVisible()){
			report.Info("FAIL, For the attention of Value is present");
		}
		else
		{
			report.Info("PASS, For the attention of Value is not present as expected");
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@FindBy(xpath="//*[text()='Account Summary']")
	WebElementFacade AccountSummaryTab;  
	@FindBy(xpath=".//*[@title='Customer Comms List:New']")
	WebElementFacade NewCustomerCommsButton; 
	@FindBy(xpath=".//table[@summary='Customer Comms List']/tbody/tr[2]/td[2]/a")
	WebElementFacade NewCustomerCommsID; 
	@FindBy(xpath=".//*[@title='Contacts:Set / Reset PIN']")
	WebElementFacade SetResetPINButton; 
	@FindBy(xpath=".//*[@aria-labelledby='VF_PIN_1_Label']")
	WebElementFacade PIN1; 
	@FindBy(xpath=".//*[@aria-labelledby='VF_PIN_2_Label']")
	WebElementFacade PIN2; 
	@FindBy(xpath=".//*[@aria-labelledby='VF_PIN_3_Label']")
	WebElementFacade PIN3; 
	@FindBy(xpath=".//*[@aria-labelledby='VF_PIN_4_Label']")
	WebElementFacade PIN4;
	@FindBy(xpath=".//*[@title='Reset PIN:Ok']")
	WebElementFacade ResetPINOKButton;
	@FindBy(xpath=".//*[@title='Contacts:Set/ Reset Word and Hint']")
	WebElementFacade SetResetWordHintButton; 
	@FindBy(xpath=".//*[@aria-labelledby='VF_Reset_Word_Label']")
	WebElementFacade SetResetWordTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Reset_Hint_Label']")
	WebElementFacade SetResetHintTextBox;
	@FindBy(xpath=".//*[@title='Reset Word:Ok']")
	WebElementFacade ResetHintTextOKButton;
	@FindBy(xpath=".//*[@title='Contacts:Set / Reset Password']")
	WebElementFacade ResetPasswordButton;

	@Step  
	//This Function Resets PIN/ Memorable Word Hint/ Password in Customer Comms Tab
	//By Payel
	public void ResetCustomerComms(String ResetAction) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());


		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "Reset";		       
		String applet = "//*[@title='Customer Comms List List Applet']";
		String table = "//table[@summary='Customer Comms List']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(ResetAction, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Reset").size()==0){
			report.Info(ResetAction+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("Reset").size();i++) { 	  
			String sReset = tableMap.get("Reset").get(i);
			String sCreateNewCustComms = tableMap.get("CreateNewCustComms").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);	   
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);

			String indexValue = "0";


			if (sCreateNewCustComms.equals("Y")){
				AccountSummaryTab.click();
				Thread.sleep(2000);
				NewCustomerCommsButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				NewCustomerCommsButton.click();
				Thread.sleep(2000);
				NewCustomerCommsButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

				if (!sLocateCol.equals("")){
					String LocateColMessage = sLocateCol+" Not Found";
					Common.selectedRow = -1;
					Assert.assertTrue(LocateColMessage, Common.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
					report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
				}
				else{               
					Common.selectedRow = 1;
				}
				if (!UIName.equals("")){         		 
					Common.updateSiebList(applet,table, UIName, value); 
					Thread.sleep(2000);                       	              
					report.Info("Action : "+UIName+" has perfomed "+value);                                                  
				}

				/*  String NewCustomerCommID = NewCustomerCommsID.getTextValue();
	          		   report.Info("New Customer Comms was created. ID is : "+NewCustomerCommID);
	          		   NewCustomerCommsID.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	          		 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	          		   NewCustomerCommsID.click();
	          		  Thread.sleep(4000);*/
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			} 

			//For PIN RESET   
			if(sReset.equalsIgnoreCase("Pin")){		    		   
				SetResetPINButton.click();

				Thread.sleep(4000);
				PIN1.type("4");
				PIN2.type("3");
				PIN3.type("2");
				PIN4.type("2");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ResetPINOKButton.click();

				Thread.sleep(2000);

				common1.HandleErrorPopUp(sPopup);

			} 

			//For Memorable Hint Word RESET   
			if(sReset.equalsIgnoreCase("Memorable")){
				Thread.sleep(2000);
				SetResetWordHintButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();		    		  
				SetResetWordHintButton.click();
				Thread.sleep(2000);
				SetResetWordTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();		    		   
				SetResetWordTextBox.type("Automation");
				SetResetHintTextBox.type("Automation");
				ResetHintTextOKButton.click();

				Thread.sleep(2000);

				//Alert alert=getDriver().switchTo().alert();
				//String ActAlertText=alert.getText();
				common1.HandleErrorPopUp(sPopup);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				report.Info("alert messsage is"+sPopup);
				if(sPopup.contains("Success"))
				{
					report.Info("Word/Hint Retest done successfully Pop up is : "+sPopup);

				}else{
					report.Info("Word/Hint did not reset. Pop up is : "+sPopup);

				} 

			} 

			//For Reset Password
			if(sReset.equalsIgnoreCase("Password")){
				ResetPasswordButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	                     
				ResetPasswordButton.click(); 
				Thread.sleep(3000);

				common1.HandleErrorPopUp(sPopup);
				/*Alert alert=getDriver().switchTo().alert();
	                   String ActAlertText=alert.getText();*/
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				report.Info("alert messsage is"+sPopup);

				// Assert.assertTrue("Password Reset not done Successfully",ActAlertText.contains("Succes"));

			}
			// for Account permission value
			if(sReset.equalsIgnoreCase("AccountPermission")){

				if (!sLocateCol.equals("")){
					Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info(sLocateCol+ "feild is displayed Full Access");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
			}	    	   
		}
	}

	@FindBy(xpath=".//a[text()='Owned Product/Service']")
	WebElementFacade OwnedProductService;
	@FindBy(xpath=".//*[@aria-label='Third Level View Bar']")
	WebElementFacade AccountSummaryDropdown;

	@FindBy(xpath=".//*[contains(text(),'Customer Summary')]")
	WebElementFacade Customersummary;
	@FindBy(xpath=".//*[@id='1_s_3_l_CmplxHierarchy']")
	WebElementFacade CustomerSummaryValueClick;
	@FindBy(xpath=".//*[@id='1_CmplxHierarchy']")
	WebElementFacade CustomerSummaryValueCheck;

	//This function is used for navigate to customer summary page and validate the fields under summary page  

	@Step
	public void CustomerSummary(String rowname) throws IOException, InterruptedException, AWTException
	{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "CustomerSummary";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Validation").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		String applet = "//*[@title='Customer Experience List Applet']";
		String table = "//table[@summary='Customer Experience']";

		for (int i = 0;i < tableMap.get("Validation").size();i++) {
			String ownedProduct = tableMap.get("ClickOnOwnedProduct").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			String sView = tableMap.get("View").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);
			String indexValue = tableMap.get("Index").get(i);
			if (indexValue.equals("")){
				indexValue = "0";
			}
			Customersummary.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();                                   
			if(Customersummary.isPresent()){                      
				Customersummary.click();
				Thread.sleep(2000);
			}else{
				AccountSummaryDropdown.selectByVisibleText("Customer Summary");
				Thread.sleep(6000);
			}
			//AccountSummaryDropdown.selectByVisibleText("Customer Summary");
			report.Info(" Customer Summary is selected successfully from dropdown");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Thread.sleep(8000);

			if(ownedProduct.equalsIgnoreCase("Yes"))
			{
				//validating owened product service button under customer summary
				Assert.assertTrue("Owned product/service is not present under customer summary",OwnedProductService.isDisplayed());

			}
			if(sValidation.equalsIgnoreCase("Y")){
				//for clicking check box 
				if(sView.equalsIgnoreCase("Customer Summary")){

					if (!sLocateCol.equals("")){
						common1.selectedRow = -1;
						Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));                                    
						//report.Info(sLocateCol+" found"); 
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
					else{
						common1.selectedRow = 1;
					}
					if (!UIName.equals("")){
						common1.updateSiebList(applet,table, UIName, value);  
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						//report.Info(sLocateCol+" found");                                      
					}
					//for drill down on user account
				}else if(sView.equalsIgnoreCase("User Account")){
					String LocateColMessege = sLocateCol+"Not Found";
					if (!sLocateCol.equals("")){
						common1.selectedRow = -1;
						Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
						report.Info(sLocateCol+"Customer summary applet found using Locate Col");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
					else 
					{
						common1.selectedRow = 1;
						report.Info("Customer summary applet found");
					}//report.Info(sLocateCol+" found");
					if (!UIName.equals("")){                                              
						common1.updateSiebList(applet,table, UIName, value);
						Thread.sleep(2000);
						report.Info("Clicked on User Account sucessfully");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


					}     
				}
			}
		}
	}
	@FindBy(xpath=".//*[@aria-label='Account Permissions:New']")
	WebElementFacade NewAccountPermissionButton;
	@FindBy(xpath=".//*[@aria-label='Account Permissions:New']")
	WebElement NewAccountPermissionButtonWebElement;

	public void AddVerifyContacts(String row) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AddVerifyContacts";

		String applet = "//*[@title='Account Permissions List Applet']";
		String table = "//table[@summary='Account Permissions']";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
		readWorkbook.testData(tableMap);


		for (int i = 0;i < tableMap.get("RowNo").size();i++) {   

			String sAddContact = tableMap.get("AddContact").get(i);
			String sNewPermission = tableMap.get("NewPermission").get(i);     
			String sContact = tableMap.get("Contact").get(i);
			String sPopup = tableMap.get("PopUp").get(i);         
			String sPopup2 = tableMap.get("PopUp2").get(i); 
			String sPopup3 = tableMap.get("PopUp3").get(i);

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);             
			String Index = tableMap.get("Index").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);
			Alert alert;
			String ActAlertText="";
			if(ContactsTab.isDisplayed()){
				ContactsTab.click();
			}
			else{
				AccountDropDown.selectByVisibleText("Contacts");
			}     
			report.Info("Contacts Tab Clicked");
			if (sPopup.equals("")){
				sPopup = "No";
			}
			if (sPopup2.equals("")){
				sPopup2 = "No";
			}
			if (sPopup3.equals("")){
				sPopup3 = "No";
			}

			if (!sPopup.equalsIgnoreCase("No")) {
			common1.HandleErrorPopUp(sPopup);
			}  

			if(sAddContact.equalsIgnoreCase("Y")){
				AddContact.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();				
				AddContact.click();			
				LastnameElement.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
				LastnameElement.click();		
				LastnameTextBox.waitUntilEnabled();
				LastnameTextBox.typeAndEnter(sContact);
				Thread.sleep(2000); 
				OKButton.click();
				Thread.sleep(2000);
				//PopUp 1
				if(isAlertPresent(getDriver())&& (!sPopup2.equalsIgnoreCase("No"))){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText(); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  				  
					String sPopup1=sPopup2;
					if (sPopup2.contains("OPTIONAL:")){
						sPopup1= sPopup2.substring(9);
					}                                                                                       

					if (ActAlertText.contains(sPopup1)){                            
						alert.accept();
						System.out.println("alert messsage is"+ActAlertText);
						//  report.Info("alert messsage is"+ActAlertText);
					}                        
				}
				else if (!isAlertPresent(getDriver())&& (sPopup2.contains("OPTIONAL:"))){
					report.Info("OPTIONAL Pop did not occur");
					Assert.assertTrue(true);                  
				}
				else if (!isAlertPresent(getDriver())&& (!sPopup2.equalsIgnoreCase("No"))){
					report.Info("Expected Pop did not occur");
					Assert.assertTrue(false);                                  
				}
				else if (isAlertPresent(getDriver())&& (sPopup2.equalsIgnoreCase("No"))){
					report.Info("UnExpected Pop did occured");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					Assert.assertTrue(false);                                  
				} 
				Thread.sleep(4000);
				//PopUp 2
				if(isAlertPresent(getDriver())&& (!sPopup3.equalsIgnoreCase("No"))){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText(); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  				  
					String sPopup1=sPopup3;
					if (sPopup3.contains("OPTIONAL:")){
						sPopup1= sPopup3.substring(9);
					}                                                                                       

					if (ActAlertText.contains(sPopup1)){                            
						alert.accept();
						report.Info("alert messsage is"+ActAlertText);
					}                        
				}
				else if (!isAlertPresent(getDriver())&& (sPopup3.contains("OPTIONAL:"))){
					report.Info("OPTIONAL Pop did not occur");
					Assert.assertTrue(true);                  
				}
				else if (!isAlertPresent(getDriver())&& (!sPopup3.equalsIgnoreCase("No"))){
					report.Info("Expected Pop did not occur");
					Assert.assertTrue(false);                                  
				}
				else if (isAlertPresent(getDriver())&& (sPopup3.equalsIgnoreCase("No"))){
					report.Info("UnExpected Pop did occured");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					Assert.assertTrue(false);                                  
				} 
			}

			if(sNewPermission.equalsIgnoreCase("Y")){
				//NewAccountPermissionButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			//	Common.waitForElement(NewAccountPermissionButtonWebElement);
				Thread.sleep(5000);
				NewAccountPermissionButton.click();
			}

			if(sNewPermission.equalsIgnoreCase("ValidateAccountPermissions")){
				//add code
			}

			if (Index.equals("")){
				Index = "0";
			}

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
			}
			else{               
				common1.selectedRow = 1;
			}

			if (!UIName.equals("")){         		 
				common1.updateSiebList(applet,table, UIName, value); 
				Thread.sleep(2000);

				if(value.equalsIgnoreCase("Level 0")){

					common1.HandleErrorPopUp(sPopup);         	             	  
				}
				report.Info("Row updated");
			}

			report.Info("");   
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

		}
	}

	@FindBy(xpath = ".//*[@aria-label='Address Line 1']/following-sibling::span")
	WebElementFacade addrPopUp;	  

	@FindBy(xpath = ".//*[@aria-label='Third Level View Bar']")
	WebElementFacade AccountTabsDropDown;

	@FindBy(xpath = "//button[@title='Account Addresses:Validate']")
	WebElementFacade addressValidateButton;

	@FindBy(xpath = ".//*[@title='Address History:Validate']")
	WebElementFacade CreditVettingValidateButton;

	@FindBy(xpath = ".//*[@title='Address History:New']")
	WebElementFacade AddressHistoryNewButton;

	@FindBy(xpath = ".//*[@title='Account Addresses:New']")
	WebElementFacade AcountAddressNew;

	@FindBy(xpath = ".//*[@title='Contacts:Add']")
	WebElementFacade AddContact;

	@FindBy(xpath = ".//*[contains(@aria-describedby,'Last_Name')]")
	WebElementFacade LastnameElement;

	@FindBy(xpath = ".//*[@ name='Last_Name']")
	WebElementFacade LastnameTextBox;	  

	@FindBy(xpath = ".//*[@title='Add Contacts:OK']")
	WebElementFacade OKButton;

	@FindBy(xpath = ".//*[@ title='Account Addresses:OK']")
	WebElementFacade AddressOKButton;

	@FindBy(xpath = "//*[text()='Account Addresses']/following-sibling::button[@title='Close']")
	WebElementFacade AddressCloseButton;

	@FindBy(xpath = ".//*[text()='Addresses']")
	WebElementFacade AddressesTab;

	@FindBy(xpath = "(.//a[text()='Contacts'])[2]")
	WebElementFacade ContactsTab;

	@FindBy(xpath = ".//*[text()='Age and ID Verification']")
	WebElementFacade AgeIDVerificationTab;

	@FindBy(xpath = ".//*[text()='Credit Vetting']")
	WebElementFacade CreditVettingTab;

	@FindBy(xpath = "//*[@name='Postal_Code']")
	WebElementFacade PostCodeTextBox;

	@FindBy(xpath = ".//*[contains(@aria-describedby,'Postal_Code')]")
	WebElementFacade PostCodeElement;

	@FindBy(xpath = ".//*[contains(@aria-describedby,'Postal_Code')]")
	WebElement PostCodeElementWebElement;


	@Step 
	public void AddressEditable(String logic) throws InterruptedException, IOException, AWTException{
		//Thread.sleep(9000);
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AddressUpdate";

		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(logic, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Editable").size()==0){
			report.Info(logic+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0; i < tableMap.get("Editable").size(); i++) {
			String sEditable = tableMap.get("Editable").get(i);
			String sLastName = tableMap.get("LastName").get(i);
			String sPost_Code = tableMap.get("Post_Code").get(i);

			if(sEditable.equalsIgnoreCase("Address Line 1")){
				addrPopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();					
				addrPopUp.click();
				Thread.sleep(4000);
				if(!addressValidateButton.isEnabled()){
					report.Info("Validate button is disabled for Anonymous customer at Address Line 1 under Account Address window");

				}
				else{
					Assert.assertTrue("Fail-Validate button is enabled for Anonymous customer at Address Line 1 under Account Address window.",addressValidateButton.isEnabled());

				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				AddressCloseButton.click();
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();	
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  					
				if(ActAlertText.contains("Click OK to discard unsaved"))
				{
					getDriver().switchTo().alert().accept();
					report.Info("Alert messsage is:"+ActAlertText);
				}
			}

			if(sEditable.equalsIgnoreCase("Address Line 1 NonAnonymous")){
				addrPopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();					
				addrPopUp.click();
				PostCodeElement.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				PostCodeElement.click();
				Thread.sleep(1000);
				report.Info("Postcode is: "+sPost_Code);
				PostCodeTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();				
				PostCodeTextBox.typeAndEnter(sPost_Code);
				Thread.sleep(1000);
				AddressOKButton.click();
				Thread.sleep(3000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}

			if(sEditable.equalsIgnoreCase("Addresses")){
				if(AddressesTab.isDisplayed()){
					AddressesTab.click();

				}
				else{
					AccountTabsDropDown.selectByVisibleText("Addresses");
				}
				Thread.sleep(60000);
				//addressValidateButton.waitUntilPresent();

				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", addressValidateButton);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(!addressValidateButton.isEnabled()){
					report.Info("Validate button is disabled for Anonymous customer at Addresses tab.");
				}
				else{
					Assert.assertTrue("Fail - Validate button is enabled for Anonymous customer at Addresses tab.",addressValidateButton.isEnabled());

				}
			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			if(sEditable.equalsIgnoreCase("Contacts NonAnonymous")){
				Thread.sleep(6000);

				if(ContactsTab.isDisplayed()){
					ContactsTab.click();
				}
				else{
					AccountTabsDropDown.selectByVisibleText("Contacts");
				}
				//Thread.sleep(40000);
				AddContact.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

				AddContact.click();
				Thread.sleep(4000);
				LastnameElement.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

				LastnameElement.click();
				Thread.sleep(1000);
				report.Info("Last Name is: "+sLastName);
				LastnameTextBox.waitUntilEnabled();
				LastnameTextBox.typeAndEnter(sLastName);
				Thread.sleep(3000);
				OKButton.click();
			}


			if(sEditable.equalsIgnoreCase("Age and Id Verification")){

				if(AgeIDVerificationTab.isDisplayed()){
					AgeIDVerificationTab.click();
				}
				else{
					AccountTabsDropDown.selectByVisibleText("Age and ID Verification");
				}
				Thread.sleep(4000);
				addressValidateButton.waitUntilPresent();

				if(!addressValidateButton.isEnabled()){
					report.Info("Validate button is disabled for Anonymous customer at Age and ID Verification tab under Account addresses.");
				}
				else{
					Assert.assertTrue("Fail - Validate button is enabled for Anonymous customer at Age and ID Verification tab under Account addresses.",addressValidateButton.isEnabled());

				}
			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			if(sEditable.equalsIgnoreCase("Age and Id Verification NonAnonymous")){
				if(AgeIDVerificationTab.isDisplayed()){
					AgeIDVerificationTab.click();
				}
				else{
					AccountTabsDropDown.selectByVisibleText("Age and ID Verification");
				}
				Thread.sleep(4000);
				AcountAddressNew.waitUntilPresent();
				if(AcountAddressNew.isEnabled()){
					report.Info("Pass - New Button is editable for Age and Id Verification NonAnonymous");
				}
				else{
					Assert.assertTrue("Fail - New Button is not editable for Age and Id Verification NonAnonymous",!AcountAddressNew.isEnabled());

				}
			}

			if(sEditable.equalsIgnoreCase("Credit Vetting")){
				if(CreditVettingTab.isDisplayed()){
					CreditVettingTab.click();

				}
				else{
					AccountTabsDropDown.selectByVisibleText("Credit Vetting");

				}

				Thread.sleep(5000);
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

				if(ActAlertText.contains("IF A CREDIT VET IS REQUIRED"))
				{
					getDriver().switchTo().alert().accept();
					report.Info("Alert messsage is:"+ActAlertText);
				}


				Thread.sleep(8000);
				CreditVettingValidateButton.waitUntilPresent();
				Thread.sleep(5000);
				if(!CreditVettingValidateButton.isEnabled()){
					report.Info("Validate button is disabled for Anonymous customer at Credit Vetting  tab under Address History.");
				}
				else{

					Assert.assertTrue("Fail - Validate button is enabled for Anonymous customer at Credit Vetting  tab under Address History.",CreditVettingValidateButton.isEnabled());
				}
			}

			if(sEditable.equalsIgnoreCase("CreditVetting_NonAnonymous")){
				if(CreditVettingTab.isDisplayed()){
					CreditVettingTab.click();
				}
				else{
					AccountTabsDropDown.selectByVisibleText("Credit Vetting");
				}
				Thread.sleep(5000);
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();

				if(ActAlertText.contains("IF A CREDIT VET IS REQUIRED"))
				{
					getDriver().switchTo().alert().accept();
					report.Info("Alert messsage is:"+ActAlertText);
				}
				Thread.sleep(8000);
				AddressHistoryNewButton.waitUntilPresent();
				Thread.sleep(5000);
				if(AddressHistoryNewButton.isEnabled()){
					report.Info("Pass - New Button is editable for CreditVetting_NonAnonymous");
				}
				else{
					Assert.assertTrue("Fail - New Button is not editable for CreditVetting_NonAnonymous",!AddressHistoryNewButton.isEnabled());

				}
			}
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}


	@FindBy(xpath="//*[@name='Postal_Code']")
	WebElementFacade PostCodeText;
	@FindBy(xpath=".//*[@title='Account Addresses:New']")
	WebElementFacade NewAddressButton;
	// This function is used to navigate to account summary page and select address then click on new button and verifies the applet is open in query mode.
	@Step
	public void gotoAddresss() throws InterruptedException, IOException, AWTException
	{
		Thread.sleep(2000);
		AccountSummaryDropdown.selectByVisibleText("Addresses");
		Common.waitForElement(PostCodeInAddressElement);
		Thread.sleep(2000);
		NewAddressButton.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Common.waitForElement(PostCodeElementWebElement);   	
		PostCodeElement.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Assert.assertTrue("Addresss applet is not opened in query mode", PostCodeText.isEnabled());

	}

	@FindBy(xpath=".//*[@aria-label='Verification type']")
	WebElementFacade VerificationTypeTextBox;

	@FindBy(xpath=".//*[@aria-label='Application Type']")
	WebElementFacade ApplicationTypeTextBox;

	@FindBy(xpath=".//*[@aria-label='Proof of ID type']")
	WebElementFacade IDTypeTextBox;

	@FindBy(xpath=".//*[@aria-label='Proof of address type']")
	WebElementFacade AddressTypeTextBox;

	@FindBy(xpath=".//*[@data-display='Submit']")
	WebElementFacade AgeIDSubmitButton;

	@FindBy(xpath=".//a[Text()='Age and ID Verification']")
	WebElementFacade AgeIDTab;

	@FindBy(xpath=".//*[@aria-label='Override verification']")
	WebElementFacade OverrideVerificationTextBox;

	//desc : This function is used to click on Age and ID verification tab and Enter details as required.

	@FindBy(xpath=".//*[@aria-label='Customer Comms List:New']")
	WebElementFacade CustCommsNewButton;
	@FindBy(xpath=".//*[@id='1_s_2_l_Id']/a")
	WebElementFacade IdDrillDown;
	@FindBy(xpath=".//*[@aria-label='Installed ID']/following::span[1]")
	WebElementFacade InstalledIdPickList;
	//@FindBy(xpath=" .//*[@id='1_s_9_l_Serial_Number']")
	//WebElementFacade InstalledIdTextBox;
	@FindBy(xpath=".//table[@summary='Pick Asset']/descendant::td[contains(@id,'Serial_Number')]")
	WebElementFacade InstalledIdElement;
	@FindBy(xpath="//input[contains(@id,'Serial_Number')]")
	WebElementFacade InstalledIdTextBox;
	@FindBy(xpath=".//span[text()='Pick Asset']/following::button[@title='Pick Asset:Go'][1]")
	WebElementFacade GoButton;
	@FindBy(xpath=".//*[@title='Pick Asset:OK']")
	WebElementFacade PickAssetOK;
	@FindBy(xpath=".//*[@aria-label='Category']")
	WebElementFacade CategoryTextBox;
	@FindBy(xpath=".//*[@aria-label='Sub-category']")
	WebElementFacade SubCategoryTextBox;
	@FindBy(xpath=".//*[@aria-label='Resolution']")
	WebElementFacade ResolutionTextBox;
	@FindBy(xpath=".//*[@aria-label='DPA validation']")
	WebElementFacade DPAValidationTextBox;
	@FindBy(xpath=".//*[@aria-label='Memorable word']/preceding::input[@aria-label='Type']")
	WebElementFacade TypeTextBox;
	@FindBy(xpath=".//*[@aria-label='Appointment Date']")
	WebElementFacade AppointmentDate;
	@FindBy(xpath=".//*[@data-handler='today']")
	WebElementFacade DateFieldNowButton;
	@FindBy(xpath=".//*[@data-handler='hide']")
	WebElementFacade DateFieldDoneButton;
	@FindBy(xpath=".//*[@aria-label='Appointment Slot']")
	WebElementFacade AppointmentSlotTextBox;
	@FindBy(xpath=".//*[@title='Customer Comms:Close']")
	WebElementFacade CustomerCommsCloseButton;
	@FindBy(xpath=".//*[@aria-label='Status']")
	WebElementFacade StatusVerify;
	@FindBy(xpath="//input[@aria-label='Order no.']/following-sibling::span")
	WebElementFacade OrderNumPickList;
	@FindBy(xpath=".//*[@title='Pick Order:OK']")
	WebElementFacade PickOrderOkButton;
	@FindBy(xpath=".//button[@title='Customer Comms:Send OTAC SMS']")
	WebElementFacade SendOTACSMSButton;
	@FindBy(xpath="//button[@title='Send OTAC:OK']")
	WebElementFacade SendOTACOKButton;
	@FindBy(xpath="//tr[@id='1']/td[3]/a[@name='Name']")
	WebElementFacade AccountDrillDownCustComms;
	@FindBy(xpath="//button[@title='Customer Comms:Check Eligibility']")
	WebElementFacade CheckEligibilityButton;
	@FindBy(xpath=".//*[@aria-labelledby='Comments_Label']")
	WebElementFacade CommentsTextBox;
	@FindBy(xpath=".//*[@id='1_s_2_l_Id']/a")
	WebElement IdDrillDownWebElement;
	@FindBy(xpath=".//input[contains(@class,'ui-autocomplete-input') and @aria-label='Type']")
	WebElementFacade TypeVerify;

	@FindBy(xpath=".//*[contains(@aria-label,'Customer Comms:Get PAC')]")
	WebElementFacade GetPACButton;
	@FindBy(xpath="//div[text()='PAC']/following-sibling::div")
	WebElementFacade PACCodeTextBox;
	
	@FindBy(xpath="//span[text()='Ok']")
	WebElementFacade PACCodeOKButton;
	
	
	//Description : This function is used to used to create new customer comms on account summary page
	@Step
	public void CreateCustComms(String CustomerComms ) throws IOException, InterruptedException, AWTException {
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "CreateNewCustComms";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(CustomerComms, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Category").size()==0){
			report.Info(CustomerComms+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("Category").size();i++) {
			String Category = tableMap.get("Category").get(i);
			String Subcategory = tableMap.get("Subcategory").get(i);
			String Resolution = tableMap.get("Resolution").get(i);
			String DPA_validation = tableMap.get("DPA_validation").get(i);
			String Type = tableMap.get("Type").get(i);
			String VerifyStatus = tableMap.get("VerifyStatus").get(i);
			String ClickAccount = tableMap.get("ClickAccount").get(i);
			String CheckEligibility = tableMap.get("CheckEligibility").get(i);
			String DPAValidationInLineItems = tableMap.get("DPAValidationInLineItems").get(i);
			String SendOTACSMS = tableMap.get("SendOTACSMS").get(i);
			String EnabledOTACSMS = tableMap.get("EnabledOTACSMS").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String Comments = tableMap.get("Comments").get(i);
			String CategoryValidation = tableMap.get("CategoryValidation").get(i);
			String VerifyStatusValidation = tableMap.get("VerifyStatusValidation").get(i);
			String ResolutionValidation = tableMap.get("ResolutionValidation").get(i);
			String TypeValidation = tableMap.get("TypeValidation").get(i);
			String CommentsValidation = tableMap.get("CommentsValidation").get(i);			             	
			String CreateNew = tableMap.get("CreateNew").get(i);
			String CustCommsvalidat = tableMap.get("CustCommsvalidat").get(i);
			String ButtonValidation = tableMap.get("ButtonValidation").get(i);;
			String ButtonValidationPath = ".//*[text()='"+ButtonValidation+"']";



			//String InstalledID = "447464575157"; 
			String InstalledID = "";

			try{
				InstalledID = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
				report.Info("ACCNTMSISDN : "+InstalledID);
			}
			catch(NullPointerException e){
				try {
					InstalledID = Serenity.sessionVariableCalled("MSISDN").toString();
					report.Info("MSISDN: "+InstalledID);
				}
				catch(NullPointerException c){
					InstalledID = "";
					report.Info("MSISDN: "+InstalledID);
				}
			}
			if(!CreateNew.equals("")) {
				CustCommsNewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				CustCommsNewButton.click();			             					
				//	IdDrillDown.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				Common.WaitForClock(Clockobj);
				IdDrillDown.click();
				report.Info("Customer Comms ID drilled down");
			} 
			else {

				Common.waitForElement(IdDrillDownWebElement);
				IdDrillDown.click();
				Common.WaitForClock(Clockobj);
				report.Info("Customer Comms ID drilled down");
			} 
			
			if(isAlertPresent(getDriver())){
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();                           
				if(ActAlertText.contains("Customer Not Yet in Eligibility Period"))
				{
					alert.accept();  
					Common.WaitForClock(Clockobj);
				} 
			}
			
			if(isAlertPresent(getDriver())){
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();                           
				if(ActAlertText.contains("Customer Not Yet in Eligibility Period"))
				{
					alert.accept();  
					Common.WaitForClock(Clockobj);
				} 
			}
	

			if(DPAValidationInLineItems.equalsIgnoreCase("Passed")){
				DPAValidationTextBox.typeAndEnter(DPAValidationInLineItems);
			}

			if(!ButtonValidation.equals("")){

				find(By.xpath(ButtonValidationPath)).isEnabled();
				report.Info("Button is Enabled");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				return;
			}

			if(!Category.isEmpty()){
				Thread.sleep(5000);
				CategoryTextBox.type(Category);
				Thread.sleep(1000);
				SubCategoryTextBox.type(Subcategory);
				Thread.sleep(1000);
				ResolutionTextBox.type(Resolution); 
				Thread.sleep(1000);
				if (Category.equals("Account Management")){

					OrderNumPickList.click();
					PickOrderOkButton.click();

				}
				DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
				Date date = new Date();
				String date1= dateFormat.format(date);
				AppointmentDate.type(date1);
				AppointmentSlotTextBox.type("AM");

				if(EnabledOTACSMS.equalsIgnoreCase("Y")){
					InstalledID = "";
				}
				
				if(!InstalledID.isEmpty()){
					Common.WaitForClock(Clockobj);
					InstalledIdPickList.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					InstalledIdPickList.click();
					Thread.sleep(2000);
					InstalledIdElement.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					InstalledIdElement.click();
					InstalledIdTextBox.type(InstalledID);
					report.Info("");
					GoButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					GoButton.click();			             
					PickAssetOK.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					PickAssetOK.click();
					report.Info("");
					Thread.sleep(2000);

				}

				/*if(!InstalledID.isEmpty()){
					             		InstalledIdPickList.click();
						             	Thread.sleep(2000);
						             	InstalledIdElement.click();
						             	InstalledIdTextBox.type(InstalledID);
						             	report.Info("");
						             	GoButton.click();
						             	report.Info("");
						             	PickAssetOK.click();
						             	Thread.sleep(2000);
				             	 	}*/

				if(!DPA_validation.isEmpty()){
					DPAValidationTextBox.type(DPA_validation);
				}

				if(!Comments.isEmpty()){
					CommentsTextBox.type(Comments);
				}

				if(!VerifyStatus.isEmpty()){
					if(VerifyStatus.equalsIgnoreCase("Closed")){
						//CustomerCommsCloseButton.click();
						CustomerCommsCloseButton.click();
						Thread.sleep(3000);
						Common.WaitForClock(Clockobj);
						//DPAValidationTextBox.sendKeys("F5");
					}
					String actVerify_Status=StatusVerify.getTextValue();
					if(actVerify_Status.equalsIgnoreCase(VerifyStatus)){
						report.Info("Pass - Customer Comms Status is "+actVerify_Status+" as expected");				              		 
					}
					else 
					{
						Assert.assertTrue("Customer Comms Status is not as expected", actVerify_Status.equalsIgnoreCase(VerifyStatus)); 			          
					}

				}

				if(!CustCommsvalidat.equals("")){
					if(!TypeValidation.equals("")){
						String actType_Status=TypeVerify.getTextValue();
						if(actType_Status.equalsIgnoreCase(TypeValidation)){
							report.Info("Pass - Customer Comms Status is "+actType_Status+" as expected");				              		 
						}
						else 
						{
							Assert.assertTrue("Customer Comms Status is not as expected", actType_Status.equalsIgnoreCase(TypeValidation)); 			          
						}
					}

					if(!CategoryValidation.equals("")){
						//Thread.sleep(5000);

						String actCategory_Status=CategoryTextBox.getTextValue(); 
						if(actCategory_Status.equalsIgnoreCase(CategoryValidation)){
							report.Info("Pass - Customer Comms Status is "+actCategory_Status+" as expected");				              		 
						}
						else 
						{
							Assert.assertTrue("Customer Comms Status is not as expected", actCategory_Status.equalsIgnoreCase(CategoryValidation)); 			          
						}
					}

					if(!ResolutionValidation.equals("")){
						//Thread.sleep(5000);

						String actResolution_Status=ResolutionTextBox.getTextValue(); 
						if(actResolution_Status.equalsIgnoreCase(ResolutionValidation)){
							report.Info("Pass - Customer Comms Status is "+actResolution_Status+" as expected");				              		 
						}
						else 
						{
							Assert.assertTrue("Customer Comms Status is not as expected", actResolution_Status.equalsIgnoreCase(ResolutionValidation)); 			          
						}
					}

					if(!CommentsValidation.equals("")){
						String actComments_Status=CommentsTextBox.getTextValue(); 
						if(actComments_Status.contains(CommentsValidation)){
							report.Info("Pass - Customer Comms Status is "+actComments_Status+" as expected");				              		 
						}
						else 
						{
							Assert.assertTrue("Customer Comms Status is not as expected", actComments_Status.equalsIgnoreCase(CommentsValidation)); 			          
						}
					}

					if(!VerifyStatusValidation.equals("")){
						//Thread.sleep(5000);

						String actStatusVerify_Status=StatusVerify.getTextValue(); 
						if(actStatusVerify_Status.contains(VerifyStatusValidation)){
							report.Info("Pass - Customer Comms Status is "+actStatusVerify_Status+" as expected");				              		 
						}
						else 
						{
							Assert.assertTrue("Customer Comms Status is not as expected", actStatusVerify_Status.equalsIgnoreCase(VerifyStatusValidation)); 			          
						}
					}

				}

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

				if(EnabledOTACSMS.equalsIgnoreCase("Y")){
					
					if(SendOTACSMSButton.isEnabled()){
						report.Info("Send OTAC SMS button is enabled when status is In-progress");
					}
					else{
						Assert.assertTrue("Send OTAC SMS button is not enabled when status is In-progress", SendOTACSMSButton.isEnabled());
					}

				}

				if(SendOTACSMS.equalsIgnoreCase("Y")){
					SendOTACSMSButton.click();
					Common.WaitForClock(Clockobj);
					Thread.sleep(5000);
					SendOTACOKButton.click();
					Thread.sleep(5000);
					Common.WaitForClock(Clockobj);
					
					/*Alert alert=getDriver().switchTo().alert();
	                                  String ActAlertText=alert.getText();                           
	                                        System.out.println("Alert messsage is:"+ActAlertText);
	                                        Assert.assertTrue(" FAIL, PopUp Did not Occur", ActAlertText.contains(sPopup));
	                                        if(ActAlertText.contains(sPopup))
	                                        {
	                                              alert.accept();                                        
	                                        } */ 

					Common.HandleErrorPopUp(sPopup);
					System.out.println("Alert messsage is:"+sPopup);

					AccountDrillDownCustComms.click();
					report.Info("");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					Thread.sleep(10000);
				}

			}

			/*if(!DPA_validation.isEmpty()){
				             		DPAValidationTextBox.typeAndEnter(DPA_validation);
				             		 Thread.sleep(6000);
				             		}*/

			if(CheckEligibility.equalsIgnoreCase("Y")){
				DPAValidationTextBox.typeAndEnter(DPA_validation);
				CheckEligibilityButton.click();
				Thread.sleep(4000);
				Common.WaitForClock(Clockobj);
			}

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if(ClickAccount.equalsIgnoreCase("Y")){
				AccountDrillDownCustComms.click();
				Thread.sleep(3000);
			}
			else if(ClickAccount.equalsIgnoreCase("GetPAC")){
				GetPACButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				GetPACButton.click();
				Thread.sleep(2000);
				Common.WaitForClock(Clockobj);

				String sPACCode = PACCodeTextBox.getTextValue();

				Assert.assertTrue("PAC Code not generated", !sPACCode.equals(""));
				Serenity.setSessionVariable("PACCode").to(sPACCode);
				report.Info("PAC code generated : "+sPACCode);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				PACCodeOKButton.click();
				Thread.sleep(2000);
				Common.WaitForClock(Clockobj);
			}

			Thread.sleep(2000);	
			Common.WaitForClock(Clockobj);

			if(isAlertPresent(getDriver())){
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();                           
				System.out.println("Alert messsage is:"+ActAlertText);
				Assert.assertTrue(" FAIL, PopUp Did not Occur", ActAlertText.contains(sPopup));
				if(ActAlertText.contains(sPopup))
				{
					alert.accept();                                        
				} 
			}

		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

	}




	/* @FindBy(xpath="//*[text()='Profiles']")
		  WebElementFacade ProfilesTab;*/
	@FindBy(xpath=".//td[contains(@id,'Payment_Method')]")
	WebElementFacade PaymentMethod;	  
	@FindBy(xpath=".//*[@name='Payment_Method']")
	WebElementFacade PaymentMethodDropDown;
	@FindBy(xpath=".//*[@title='Automatic Debit:Update Bank Details']")
	WebElementFacade UpdateBankDetailsButton;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Name_Label']")
	WebElementFacade BankNameinPopUp;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Branch_Label']")
	WebElementFacade BankBranchinPopUp;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Sort_Code_Label']")
	WebElementFacade BanksortCodeinPopUp;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Account_Name_Label']")
	WebElementFacade BankAccountNameinPopUp;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Account_Number_Label']")
	WebElementFacade BankAccNumberinPopUp;
	@FindBy(xpath=".//*[@ aria-label='Siebel:OK']")
	WebElementFacade OKButtoninPopUp;

	@FindBy(xpath=".//*[@aria-label='Automatic Debit:Validate Bank Details']")
	WebElementFacade ValidateBAnkDetailsButton;
	@FindBy(xpath=".//*[@aria-labelledby='Bank_Name_Label']")
	WebElementFacade BankName;
	@FindBy(xpath=".//*[@aria-labelledby='Bank_Branch_Label']")
	WebElementFacade BankBranch;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Sort_Code_Label']")
	WebElementFacade BanksortCode;
	@FindBy(xpath=".//*[@aria-labelledby='Account_Name_Label']")
	WebElementFacade BankAccountName;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Account_Status_Label']")
	WebElementFacade AccountStatus;
	@FindBy(xpath=".//*[@aria-labelledby='Acccount_#_Label']")
	WebElementFacade BankAccNumber;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Mandate_ID_Label']")
	WebElementFacade MandateID;
	@FindBy(xpath=".//*[@aria-labelledby='VF_Mandate_Status_Label']")
	WebElementFacade MandateStatus;
	@FindBy(xpath=".//*[@title='Next record set']")
	WebElementFacade NextRecordButton;
	@FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
	WebElement ErrorOkButtonSync;
	@FindBy(xpath=".//*[@aria-label='DD Amend Description']")
	WebElementFacade DDAmendDescriptionTextBox;
	@FindBy(xpath=".//input[@aria-label='DD Amend Code']")
	WebElementFacade DDAmendRCTextBox;
	/* @FindBy(xpath=".//*[@aria-labelledby='Acccount_#_Label']")
		  WebElementFacade BankAccNumber;
		  @FindBy(xpath=".//*[@aria-labelledby='Acccount_#_Label']")
		  WebElementFacade BankAccNumber;*/

	public void Wait() throws InterruptedException
	{
		Thread.sleep(120000);
	}


	@Step   
	//This Function creates/Re establishes/ Amends Direct Debit Profile,  Profiles Tab
	//By Payel
	public void DirectDebit(String DirectDebitAction) throws IOException, InterruptedException, AWTException{

		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "DirectDebit";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(DirectDebitAction, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		ProfilesTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		if (ProfilesTab.isCurrentlyVisible()){
			ProfilesTab.click();
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Profiles");
		}
		Thread.sleep(4000);
		BillingProfilesTab.click();


		for (int i = 0;i < tableMap.get("Dummy").size();i++) { 	  
			String sPaymentMethod = tableMap.get("PaymentMethod").get(i);
			String sSortCode = tableMap.get("SortCode").get(i);
			String sAccountNumber = tableMap.get("AccountNumber").get(i);
			String sAccountName = tableMap.get("AccountName").get(i);
			String sBranch = tableMap.get("Branch").get(i);
			String sBankName = tableMap.get("BankName").get(i);
			String sMandateID = tableMap.get("MandateID").get(i);
			String sMandateStatus = tableMap.get("MandateStatus").get(i);
			String sReEstablishment = tableMap.get("ReEstablishment").get(i);
			String sValidateButtonopup = tableMap.get("ValidateButton").get(i);
			String sNavigate = tableMap.get("Navigate").get(i);
			String sReadOnly = tableMap.get("ReadOnly").get(i);
			String ValidatePayMethod = tableMap.get("ValidatePayMethod").get(i);
			String DDAmendDescription = tableMap.get("DDAmendDescription").get(i);
			String DDAmendReasonCode = tableMap.get("DDAmendReasonCode").get(i);
			String Validation = tableMap.get("Validation").get(i);
			
			Thread.sleep(4000);
			//UpdateBankDetailsButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			if(ValidatePayMethod.equalsIgnoreCase("Yes")){
				String applet = "//*[@title='Billing profile List Applet']";
				String table = "//table[@summary='Billing profile']";
				Common.selectedRow = 1;

				if(!sPaymentMethod.equals("")){
					String PaymentMethod=Common.updateSiebList(applet,table,"CaptureTextValue|Payment_Method","");
					Assert.assertTrue("FAil: Payuement Method didn't match as expeted", PaymentMethod.equals(sPaymentMethod));
					report.Info("Pass: Payemnt Method "+PaymentMethod+" matched as expected..");
				}
				Common.updateSiebList(applet,table,"Click|Payment_Method","");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if(!DDAmendDescription.equals("")){
				DDAmendDescriptionTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				DDAmendDescriptionTextBox.click(); 
				String ExpDDVAlues=DDAmendDescriptionTextBox.getAttribute("value");
				
				
				if(DDAmendDescription.equalsIgnoreCase("Blank")){
					Assert.assertTrue("Fail: DD Amend Descriptio is not blank", ExpDDVAlues.equals(""));
					report.Info("Pass:DD Amend Descriptio is blank as expected");
				}
				if(!DDAmendDescription.equals("Blank")){
					Assert.assertTrue("Fail: DD Amend Descriptio"+ExpDDVAlues+"does not match with expected"+DDAmendDescription, ExpDDVAlues.contains(DDAmendDescription));
					report.Info("Pass:DD Amend Descriptio is as expected" +ExpDDVAlues);
				}
			}
			if(!DDAmendReasonCode.equals("")){
				DDAmendRCTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				DDAmendRCTextBox.click(); 
				String ExpDDVAlues=DDAmendRCTextBox.getTextValue();
				
				if(DDAmendReasonCode.equalsIgnoreCase("Blank")){
					Assert.assertTrue("Fail: DD Amend Descriptio is not blank", ExpDDVAlues.equals(""));
					report.Info("Pass:DD Amend Descriptio is blank as expected");
				}
				if(!DDAmendReasonCode.equals("Blank")){
					Assert.assertTrue("Fail: DD Amend Descriptio" +ExpDDVAlues+ "does not match with expected"+DDAmendReasonCode, ExpDDVAlues.equals(DDAmendReasonCode));
					report.Info("Pass:DD Amend Descriptio is as expected" +ExpDDVAlues);
				}
			}
			//For Re Establishment scenario 
			if(sReEstablishment.equalsIgnoreCase("No")){	
				//PaymentMethod.click();
				//PaymentMethodDropDown.type(sPaymentMethod);
				String applet = "//*[@title='Billing profile List Applet']";
				String table = "//table[@summary='Billing profile']";
				Common.selectedRow = 1;
				Common.updateSiebList(applet,table,"List2|Payment_Method",sPaymentMethod);
				Thread.sleep(2000);
				
				if (ErrorOkButton.isCurrentlyVisible()){
					ErrorOkButton.click();
				}

				/*boolean Visible = Common.waitForElement30(ErrorOkButtonSync);
				if(Visible == true){
					ErrorOkButton.click();	 
				}*/
				NextRecordButton.click();
				UpdateBankDetailsButton.click();
				Thread.sleep(2000);

				BankNameinPopUp.type(sBankName);
				BankBranchinPopUp.type(sBranch);
				BanksortCodeinPopUp.type(sSortCode);
				BankAccountNameinPopUp.type(sAccountName);
				BankAccNumberinPopUp.type(sAccountNumber);
				OKButtoninPopUp.click();
				UpdateBankDetailsButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				report.Info("PASS : BANK Details Populated");

			}  
			else{
				
				if(Validation.equals("MandateADDUIS")){
					String strMandateStatus = MandateStatus.getTextValue();
					if (!sMandateStatus.equals("")){
						MandateStatus.click();
						if (!strMandateStatus.equals("")){
							Assert.assertTrue("FAIL : Mandate Status is not same and it is "+strMandateStatus, strMandateStatus.equals(sMandateStatus)); 
							report.Info("PASS : Mandate Status is same and it is "+sMandateStatus);
						}	
						else{
							report.Info("FAIL : Mandate Status is null"); 
						}
					}
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  	 
					return;
				}
				
				String strAccountStatus = AccountStatus.getTextValue();

				if(!strAccountStatus.equals("Valid")){
					ValidateBAnkDetailsButton.click();
					Thread.sleep(2000);
					UpdateBankDetailsButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					strAccountStatus = AccountStatus.getTextValue();
					Assert.assertTrue("FAIL : Account is not Validated and it is "+strAccountStatus, strAccountStatus.equals("Valid"));	    		   		
					report.Info("PASS : Account is now Validated");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				}

				//Validate Bank Account Name
				String strBankName = BankName.getTextValue();
				if (!sBankName.equals("")){
					Assert.assertTrue("FAIL : Bank Name is not same and it is "+strBankName, strBankName.equals(sBankName)); 
					report.Info("PASS : Bank Name is same and it is "+sBankName);
				}
				//Validate Bank Branch
				String strBankBranch = BankBranch.getTextValue();
				if (!sBranch.equals("")){
					Assert.assertTrue("FAIL : Bank Branch is not same and it is "+strBankBranch, strBankBranch.equals(sBranch)); 
					report.Info("PASS : Bank Branch is same and it is "+sBranch);
				}
				//Validate Bank Sort Code
				/* String strBanksortCode = BanksortCode.getTextValue();
		    		   	  if (!sSortCode.equals("")){
		    		   		Assert.assertTrue("FAIL : Bank Sort Code is not same"+strBanksortCode, strBanksortCode.equals(sSortCode)); 
		    		   		report.Info("PASS : Bank Sort Code is same"+sSortCode);
		    		   	  }  */
				//Validate Bank Account Name
				String strBankAccountName = BankAccountName.getTextValue();
				if (!sAccountName.equals("")){
					Assert.assertTrue("FAIL : Bank Account Name is not same"+strBankAccountName, strBankAccountName.equals(sAccountName)); 
					report.Info("PASS : Bank Account Name is same and it is "+sAccountName);
				} 
				//Validate Bank Acc Number
				/*	  String strBankAccNumber = BankAccNumber.getTextValue();
		    		   	  if (!sAccountNumber.equals("")){
		    		   		Assert.assertTrue("FAIL : Bank Acc Number is not same"+strBankAccNumber, strBankAccNumber.equals(sAccountNumber)); 
		    		   		report.Info("PASS : Bank Acc Number  is same"+sAccountNumber);
		    		   	  }*/

				//Validate Mandate Status
				String strMandateStatus = MandateStatus.getTextValue();
				if (!sMandateStatus.equals("")){
					MandateStatus.click();
					if (!strMandateStatus.equals("")){
						Assert.assertTrue("FAIL : Mandate Status is not same and it is "+strMandateStatus, strMandateStatus.equals(sMandateStatus)); 
						report.Info("PASS : Mandate Status is same and it is "+sMandateStatus);
					}	
					else{
						report.Info("FAIL : Mandate Status is null"); 
					}
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  	 
				//Validate Mandate ID


				String strMandateID = MandateID.getTextValue();

				if (!sMandateID.equals("")){
					if (!strMandateID.equals("")){
						String[] arrSplit = strMandateID.split("-");
						String strMandateIDnew = arrSplit[1];
						Assert.assertTrue("FAIL : Mandate ID is not same and it is "+strMandateIDnew, strMandateIDnew.equals(sMandateID)); 
						report.Info("PASS : Mandate ID is same and it is "+sMandateID);
					}	
					else{
						report.Info("FAIL : Mandate ID is null"); 
					}
				}	  
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  							  
			}

			if (sReadOnly.equals("Y")){
				String v1 = BankAccountName.getAttribute("readonly");
				Assert.assertTrue("FAIL : Bank Account Name is not read only", v1.equals("true"));
				report.Info("PASS : Bank Account Name is read only");

				String v2 = BankAccNumber.getAttribute("readonly");
				Assert.assertTrue("FAIL : Bank Account Number is not read only", v2.equals("true"));
				report.Info("PASS : Bank Account Number is read only");

				String v3 = AccountStatus.getAttribute("readonly");
				Assert.assertTrue("FAIL : Account status is not read only", v3.equals("true"));
				report.Info("PASS : Bank Account Name is read only");

				String v4 = BankName.getAttribute("readonly");
				Assert.assertTrue("FAIL : Bank Name is not read only", v4.equals("true"));
				report.Info("PASS : Bank  Name is read only");

				String v5 = BankBranch.getAttribute("readonly");
				Assert.assertTrue("FAIL : Bank Branch is not read only", v5.equals("true"));
				report.Info("PASS : Bank Branch Name is read only");

				String v6 = BanksortCode.getAttribute("readonly");
				Assert.assertTrue("FAIL : Sort Code is not read only", v6.equals("true"));
				report.Info("PASS : Sort Code is read only");

			}

			/*if (sValidateButtonopup.equals("Yes")){
				ValidateBAnkDetailsButton.click();
				UpdateBankDetailsButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				String v7 = AccountStatus.getTextValue();
				Assert.assertTrue("FAIL : Account is not Validated", v7.equals("Valid"));	    		   		
				report.Info("PASS : Account is now Validated");
			}*/
			if (sNavigate.equals("Yes")){
				AccountSummaryTab.click();
				Thread.sleep(2000);

			}	
			
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  				
	}

	@FindBy(xpath=".//*[@aria-labelledby='s_6_l_Status s_6_l_altCombo']")
	WebElementFacade BillingProfileStatus;
	@FindBy(xpath=".//table[@summary='Billing profile']/tbody/tr")
	WebElementFacade BillingProfileTable;
	/*@FindBy(xpath=".//div[@title='Billing profile List Applet']")
		  WebElementFacade BillingProfileApplet;*/

	@FindBy(xpath=".//*[@aria-label='Row #']")
	WebElementFacade rowId;

	//@FindBy(xpath=".//*[@id='s_5_1_274_0_Ctrl']")
	@FindBy(xpath=".//*[@aria-label='About Record:OK']")
	WebElementFacade aboutRecordOkButton;

	@FindBy(xpath="//span/ul/li[11]/a")
	WebElementFacade aboutRecord;
	@FindBy(xpath=".//button[@title='Billing profile Menu']")
	WebElementFacade BillingPofilemenuItemIcon;
	@FindBy(xpath="(//tr[@id='1']//td[contains(@id,'Status')])[1]")
	WebElementFacade BillingPofilestatus;
	@FindBy(xpath="//span/ul/li[9]/a")
	WebElementFacade RefreshMenuItem;
	
	@FindBy(xpath="//span/ul/li[8]/a")
	WebElementFacade RefreshMenuItemNew;
	
	@FindBy(xpath="//button/span[text()='Card Details']")
	WebElementFacade cardDetailsButton;
	
	@FindBy(xpath="//button[@title='Credit Card Payment:Authorize']")
	WebElementFacade AuthoriseButton;
	
	@FindBy(xpath="//ul/li/a[text()='Billing profile']")
	WebElementFacade BillingProfileLinkRibbon;
	
	@FindBy(xpath="//div[@class='siebui-applet-title' and text()='Billing profile']")
	WebElementFacade BillingProfileHeading;
	
	@FindBy(xpath=".//*[contains(@aria-label,'Title')]")
	WebElementFacade AccountTitleTextBox;


	@Step 
	//This Function changes payment method in Profiles Tab
	//By Payel
	public void ChangePaymentMethod(String logicalName) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());
		Thread.sleep(5000);
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "ChangePaymentMethod";
		String table = "//table[@summary='Billing profile']";             
		String applet = "//*[@title='Billing profile List Applet']";            

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(logicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Popup").size()==0){
			report.Info(logicalName+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

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
			String sCardPaymentPage = tableMap.get("CardPaymentPage").get(i);
			
			if(sCardPaymentPage.equals("")) {
				sCardPaymentPage = "N";
			}
			
			if(indexValue.equals("")){
				indexValue="0";
			}


			if (ProfilesTab.isDisplayed()){
				ProfilesTab.click();
				Thread.sleep(10000);
			}
			else {
				AccountTabsDRopDown.selectByVisibleText("Profiles");
			}

			/*if (!sLocateCol.equals("")){
	                	 common1.selectedRow = -1;
	 		            Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
	 		            report.Info(sLocateCol+"Billing profile applet found using Locate Col");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	                 }
	                 else 
	                 {
	                  common1.selectedRow = 1;
	                  report.Info("Billing profle applet found");
	                 }
			 */

			if(sAboutRecord.equalsIgnoreCase("Yes")){
				BillingPofilemenuItemIcon.click();
				aboutRecord.click();
				report.Info("About Record displayed");

				String sRowId = rowId.getTextValue();
				report.Info("Row Id - "+sRowId);
				Serenity.setSessionVariable("RowId").to(sRowId);
				Thread.sleep(5000);
				aboutRecordOkButton.click();
				System.out.println(sRowId+" Row id");
				//return sRowId;


			}

			//checking billing status
			if(sBillingStatus.equalsIgnoreCase("Yes")){
				String Status=BillingPofilestatus.getTextValue();
				i = 0;
				do{
					Thread.sleep(7000);
					BillingPofilemenuItemIcon.click();
					RefreshMenuItemNew.click();
					Status = BillingPofilestatus.getTextValue();
					if(Status.equals("Inactive")){
						report.Info(" Billing Status is "+Status+ "");
						break;              					
					}

					i++;
				}while(!Status.equals("Inactive") && i <=40);
			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info(sLocateCol+"Billing profile applet found using Locate Col");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
			else 
			{
				common1.selectedRow = 1;
				report.Info("Billing profle applet found");

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

				int tablesize= findAll(By.xpath("//table[@summary='Billing profile']/tbody/tr")).size();
				report.Info("the number of rows:"+tablesize);
				Assert.assertTrue("FAIL : No Rows in Table ", tablesize>1 );
				//report
				for (int j =1;j <tablesize; j++ ){
					if ((!sNewPaymentMethod.equals("")) & (!sOldPaymentMethod.equals(""))){
						String PM = PaymentMethod.getTextValue();
						if (PM.equals(sOldPaymentMethod)){
							PaymentMethod.click();
							PaymentMethodDropDown.typeAndEnter(sNewPaymentMethod);
							
							/*Robot robot = new Robot();	 
		        			 robot.keyPress(KeyEvent.VK_CONTROL);
		        			 robot.keyPress(KeyEvent.VK_S);
		        			 robot.keyRelease(KeyEvent.VK_CONTROL);
		        			 robot.keyRelease(KeyEvent.VK_S);*/
		        			 
		        			 AccountTitleTextBox.sendKeys(Keys.chord(Keys.CONTROL,"s"));
							String PMnew = PaymentMethod.getTextValue();
							PaymentMethod.click();
							Assert.assertTrue("FAIL : Payment Method is not changed to "+sNewPaymentMethod +"Actual: " + PMnew, PMnew.equalsIgnoreCase(sNewPaymentMethod)); 
							// report.Info("Payment Method Changed from "+sOldPaymentMethod+" to "+sNewPaymentMethod); 
							
							if(sCardPaymentPage.equals("Y")) {
								cardDetailsButton.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable();
								cardDetailsButton.click();
								
								String initialWindow = "";
								initialWindow = getDriver().getWindowHandle();
								Thread.sleep(2000);
								sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

								Set<String> winHandles = getDriver().getWindowHandles();
								for (String handle : winHandles) {
									if (!handle.equals(initialWindow)) {
										getDriver().switchTo().window(handle);
										Thread.sleep(1000);
									}
								}
								
								AboutCustomerEnh.enterAeirandiCardDetails("CreditCardVisaAuthorise");
								getDriver().switchTo().window(initialWindow);
								
								Thread.sleep(2000);
								AuthoriseButton.click();
					    		Common.WaitForClock(Clockobj);
					    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
								

								
							}
							
						}
					}
					/*if ((!sNewBillingProfileStatus.equals("")) & (!sOldBillingProfileStatus.equals(""))){
	                              String BP = BillingProfileStatus.getText();
	                               if (BP.equals(sOldBillingProfileStatus)){
	                                         BillingProfileStatus.click();
	                                         //???PaymentMethodDropDown.typeAndEnter(sNewPaymentMethod);
	                                         String BPnew = BillingProfileStatus.getText();                             
	                                         Assert.assertTrue("FAIL : Billing Profile Status is not changed to "+sNewBillingProfileStatus, BPnew.equals(sNewBillingProfileStatus)); 
	                                         report.Info("Billing Profile Status Changed from "+sOldBillingProfileStatus+" to "+sNewBillingProfileStatus); 
	                                   } 

	                        }*/


				}

			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  


		}
	}

	@FindBy(xpath=".//*[@aria-label='Selection Field']")
	WebElementFacade AgeVerifiedPopUp;

	@FindBy(xpath=".//*[@aria-label='Pick Contact:OK']")
	WebElementFacade PickContactOKButton;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Outcome_Label']")
	WebElementFacade Outcome;

	public void AgeIDVerification(String sLogicalName) throws IOException, InterruptedException, AWTException
	{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AgeIDVerification";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(sLogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("VerificationType").size()==0){
			report.Info(sLogicalName+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("VerificationType").size();i++) {
			String sVerificationType = tableMap.get("VerificationType").get(i);
			String sApplicationType = tableMap.get("ApplicationType").get(i);
			String sOverrideVerification = tableMap.get("OverrideVerification").get(i);
			String sOutcome = tableMap.get("Outcome").get(i);
			String sAddressType = tableMap.get("AddressType").get(i);
			String sIDType = tableMap.get("IDType").get(i);
			String sAgeVerified = tableMap.get("AgeVerified").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			report.Info("sAddressType is"+sAddressType);
			Thread.sleep(2000);
			if (AgeIDTab.isPresent())
			{
				AgeIDTab.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else
			{   
				TabDropDown.selectByVisibleText("Age and ID Verification");
			}
			Thread.sleep(2000);
			if (!sVerificationType.equals(""))
			{
				VerificationTypeTextBox.type(sVerificationType);
			}
			if (!sApplicationType.equals(""))
			{
				ApplicationTypeTextBox.type(sApplicationType);
			}
			if (!sIDType.equals(""))
			{
				IDTypeTextBox.type(sIDType);
			}
			if (!sAddressType.equals(""))
			{
				AddressTypeTextBox.type(sAddressType);
			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			AgeIDSubmitButton.click();   
			Thread.sleep(5000);
			if(!sOverrideVerification.equals(""))
			{
				OverrideVerificationTextBox.click();
			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			if (!sPopup.equals("No"))
			{
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();	     				
				report.Info("Alert messsage is:"+ActAlertText);
				Assert.assertTrue(" FAIL, PopUp Did not Occur", ActAlertText.contains(sPopup));
				if(ActAlertText.contains(sPopup))
				{
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					alert.accept();       					   
				}  
			}
			if (sAgeVerified.equals("Yes"))
			{
				AgeVerifiedPopUp.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(5000);
				Assert.assertTrue("FAIL, Open Contact Applet Did not occur", PickContactOKButton.isVisible());
				PickContactOKButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if(!sOutcome.equals(""))
			{
				String sOutcomeActual = Outcome.getTextValue();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL, Outcome did not matched with expected",sOutcomeActual.equals(sOutcome));
			}   
		}
	}

	@FindBy(xpath=".//*[@name='Name']")
	WebElementFacade ProfileTabNameColumn;

	@FindBy(xpath=".//*[@aria-label='Bills:Email Copy Bill']")
	WebElementFacade EmailCopyBillButton;

	@FindBy(xpath=".//*[@aria-label='Select Email Address:Send Email']")
	WebElementFacade SendEmailButton;


	public void BillsEmail(String sLogicalName) throws IOException, InterruptedException, AWTException
	{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "BillsEmail";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(sLogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Action").size()==0){
			report.Info(sLogicalName+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}
		for (int i = 0;i < tableMap.get("Action").size();i++) {
			//String sLogicalName = tableMap.get("LogicalName").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sEmail = tableMap.get("Email").get(i);
			String sEmail1 = tableMap.get("Email1").get(i);
			String sEmail2 = tableMap.get("Email2").get(i);
			Thread.sleep(20000);
			if (ProfilesTab.isPresent())
			{
				ProfilesTab.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else
			{
				TabDropDown.selectByVisibleText("Profiles");
			}
			Thread.sleep(2000);
			BillingProfilesTab.click();
			Thread.sleep(2000);
			ProfileTabNameColumn.click();
			Thread.sleep(5000);
			EmailCopyBillButton.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Thread.sleep(3000);
			SendEmailButton.click();
			Thread.sleep(3000);
			if(isAlertPresent(getDriver())&& (!sPopup.equals("")))
			{
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();	     				
				Assert.assertTrue(" FAIL, PopUp Did not Occur", ActAlertText.contains(sPopup));
				if(ActAlertText.contains(sPopup))
				{
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					alert.accept();       					   
				}  
				report.Info("Alert messsage is:"+ActAlertText);
			}

		}  
	}
	@FindBy(xpath=".//*[@id='s_at_m_2']")
	WebElementFacade Button;
	@FindBy(xpath=".//span/ul/li[8]/a")
	WebElementFacade NewQuery;
	//@FindBy(xpath=".//*[@title='Accounts']")
	@FindBy(xpath=".//*[@data-tabindex='tabScreen1']")
	WebElementFacade AccountsTab;
	@FindBy(xpath=".//*[@aria-label='Letter Id']")
	WebElementFacade LetterID;


	public void AboutRecord() throws InterruptedException{

		Thread.sleep(3000);
		AccountsTab.click();
		Thread.sleep(3000);
		Button.click();
		NewQuery.click();
		report.Info("Yes");
		Thread.sleep(30000);

	}


	public void captureComments_CustComms(String rowname) throws IOException, InterruptedException, AWTException
	{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "CustCommsComments";
		String applet = "//*[@title='Customer Comms List List Applet']";
		String table = "//table[@summary='Customer Comms List']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Message").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		AccountSummaryTab.waitUntilPresent();
		if (AccountSummaryTab.isDisplayed()){
			AccountSummaryTab.click();
			Thread.sleep(2000);
		}
		else {
			AccountSummaryTab.selectByVisibleText("Account Summary");
			Thread.sleep(2000);
		}

		for (int i = 0;i < tableMap.get("Message").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName  = tableMap.get("UIName").get(i);
			String value  = tableMap.get("Value").get(i);
			String sExist  = tableMap.get("Exist").get(i);
			String indexValue = "0";
			String sLetterID = tableMap.get("LetterID").get(i);

			if (sLocateColValue.equals("PACCode")){
				sLocateColValue = Serenity.sessionVariableCalled("PACCode").toString();
				sLocateColValue = sLocateColValue+"*";
			}

			AccountSummaryTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			// validate the comments under customer comms

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				String res  = common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if(sExist.equals("")){    		 
					//Assert.assertTrue("The Product does Exist.", !sReturnVal.equalsIgnoreCase("True"));
					Assert.assertTrue(sLocateCol + "-" + sLocateColValue + " not found in the list.", res.equalsIgnoreCase("True"));
					report.Info(sLocateCol + "-" + sLocateColValue + " found in the list as expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				}
				else{
					if(sExist.equalsIgnoreCase("False")){
						sExist=  "False-Row Not Exist";
					}
					Assert.assertTrue(sLocateCol + "-" + sLocateColValue + " existence is " + res + " but expected is " + sExist, res.equalsIgnoreCase(sExist));
					report.Info(sLocateCol + "-" +  sLocateColValue + " existence is " + sExist + " as expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				}

			}
			else {
				common1.selectedRow = 1;
			}

			if (!UIName.equals("")){                                              
				String CapturedValue =   Common.updateSiebList(applet,table, UIName, value);
				Thread.sleep(2000);
				report.Info("Info in Comment col : "+CapturedValue);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(sLetterID.equals("No56Days"))
			{
				String CaptureLetterID = LetterID.getTextValue();
				Assert.assertTrue("FAIL, Letter ID Contains 56", !CaptureLetterID.contains("56"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

		}
	}

	@FindBy(xpath="(.//td[contains(@id,'Postal_Code')])[1]")
	WebElementFacade PostCodeInAddress;
	@FindBy(xpath="(.//td[contains(@id,'Postal_Code')])[1]")
	WebElement PostCodeInAddressElement;
	@Step
	public void getPostcodeFromAddresssTab() throws InterruptedException, IOException, AWTException
	{
		Thread.sleep(2000);
		AccountSummaryDropdown.selectByVisibleText("Addresses");
		Common.waitForElement(PostCodeInAddressElement);
		Thread.sleep(2000);
		String Postcode=PostCodeInAddress.getText();
		Serenity.setSessionVariable("PostCodefromAddressTab").to(Postcode);

		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}


	@FindBy(xpath=".//*[contains(@aria-label,'DD Transaction Type')]")
	WebElementFacade DDTransactionType;
	@Step
	public void Profiles_DirectDebit() throws InterruptedException, IOException, AWTException{
		Thread.sleep(2000);
		if(ProfilesTab.isPresent()){
			ProfilesTab.click();
		}else{
			AccountSummaryDropdown.selectByVisibleText("Profiles");
		}
		Thread.sleep(3000);
		BillingProfilesTab.click();
		DDTransactionType.waitUntilPresent();
		String sDDtransacionType=DDTransactionType.getTextValue();
		//report.Info(sDDtransacionType);
		report.Info(sDDtransacionType);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Assert.assertTrue("DD Transaction Type value is not changed to 0C after changing payment type fron DD to Bill Me",sDDtransacionType.contains("0C"));
		report.Info("DD Transaction Type value is changed to "+ sDDtransacionType +" after changing payment type fron DD to Bill Me.");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}
	@FindBy(xpath=".//*[text()='Used Product/Service']")
	WebElementFacade UsedProductService ;
	@FindBy(xpath=".//*[text()='Billed Product/Service']")
	WebElementFacade BilledProductServices;
	@FindBy(xpath="//table[@id=s_2_l]/tbody/tr/th")
	List<WebElementFacade> Colcount;
	@FindBy(xpath=".//*[contains(@title,'Email Equipment Invoice')]")
	WebElementFacade EmailEquipmentInvoiceButton;
	@Step
	public void VerifyCustomerSummary(String rowname) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "VerifyCustomerSummary";
		String applet = "";
		String table = "";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("HistoryCheck").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}
		for (int i = 0;i < tableMap.get("HistoryCheck").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName  = tableMap.get("UIName").get(i);
			String value  = tableMap.get("Value").get(i);
			String sGoToCustomerSummary = tableMap.get("GoToCustomerSummary").get(i);
			String sOwnedProdService = tableMap.get("OwnedProdService").get(i);
			String sUsedProdService = tableMap.get("UsedProdService").get(i);
			String sBilledProdService = tableMap.get("BilledProdService").get(i);
			String sHistoryCheck = tableMap.get("HistoryCheck").get(i);
			String sCustomercomms = tableMap.get("Customercomms").get(i);
			String sEmailEquipmentInvoice = tableMap.get("EmailEquipmentInvoice").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			Alert alert;
			String ActAlertText="";

			String indexValue = "0";

			if(sEmailEquipmentInvoice.equalsIgnoreCase("Yes")){
				LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				LineItemsTab.click();
				EmailEquipmentInvoiceButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				EmailEquipmentInvoiceButton.click();
				Thread.sleep(5000);
				if(!sPopUp.equalsIgnoreCase("No")){
					common1.HandleErrorPopUp(sPopUp); 
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}
			if(sCustomercomms.equalsIgnoreCase("Yes")){
				Thread.sleep(2000);
				AccountSummaryDropdown.selectByVisibleText("Customer Comms");

			}
			
			//Navigate to Customer summary page  
			if(sGoToCustomerSummary.equalsIgnoreCase("Y"))
			{
				Thread.sleep(3000);
				if(Customersummary.isPresent()){

					Customersummary.click();
					Thread.sleep(2000);
				}else{
					AccountSummaryDropdown.selectByVisibleText("Customer Summary");
				}
				report.Info(" Customer Summary is selected successfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(5000);
			}
			// click on Owned product Service
			if(sOwnedProdService.equalsIgnoreCase("Y"))
			{
				OwnedProductService.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				OwnedProductService.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 
				applet = "//*[@title='Customer Experience List Applet']";
				table = "//table[@summary='Customer Experience']";
				
			}
			//click on usedProduc service tab 
			if(sUsedProdService.equalsIgnoreCase("Y"))
			{
				UsedProductService.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				UsedProductService.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				applet = "//*[@title='Customer Experience List Applet']";
				table = "//table[@summary='Customer Experience']";
				
			}
			//click on Billed product service 
			if(sBilledProdService.equalsIgnoreCase("Y"))
			{
				BilledProductServices.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				BilledProductServices.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				applet = "//*[@title='Customer Experience List Applet']";
				table = "//table[@summary='Customer Experience']";
				
			}
			
			
			if(sHistoryCheck.equalsIgnoreCase("Y"))
			{
				applet = "//*[@title='History List Applet']";
				table = "//table[@summary='History']";
			}else if(sHistoryCheck.equalsIgnoreCase("customercommslist")){
				applet = "//*[@title='Activities List Applet']";
				table = "//table[@summary='Account Activities List']";
			}else {
				applet = "//*[@title='Customer Experience List Applet']";
				table = "//table[@summary='Customer Experience']";
			}
			
			//After navigate to particular tab perform the drill down on the particular fields

			String LocateColMessege = sLocateCol+"Not Found";
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info(sLocateCol+"Customer summary applet found using Locate Col");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else 
			{
				common1.selectedRow = 1;
				report.Info("Customer summary applet found");
			}//report.Info(sLocateCol+" found");
			if (!UIName.equals("")){                                              
				common1.updateSiebList(applet,table, UIName, value);
				Thread.sleep(10000);
				report.Info("Dilled Down on "+UIName+" successfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}     

			Thread.sleep(5000);


		}

	}
	/*@FindBy(xpath=".//*[@aria-label='Installed Assets:Modify']//following::*[@aria-label='Installed Assets:Fast Orders']")
 WebElementFacade FastOrdersAfterModifyButton;    
 @FindBy(xpath=".//*[@aria-label='Installed Assets:Fast Orders']")
 WebElementFacade FastOrdersButton; 
 @FindBy(xpath=".//*[@id='1_Product_Name']")
 WebElementFacade ProductName; */
	@FindBy(xpath=".//*[@aria-label='Owned Product/Service:Menu']")
	WebElementFacade OwnedProductMenuButton; 
	@FindBy(xpath="//a[contains(text(),'Reconnection')]")
	WebElementFacade ReconnectionMenuItem;




	//Performs actions on Menu and Button in OwnedProduct&Services Applet

	@Step      
	public void OwnedProductServices(String action) throws IOException, InterruptedException, AWTException{

		// Thread.sleep(5000);
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "UsedProductServices";
		String applet = "//*[@title='Owned Product/Service List Applet']";
		String table = "//table[@summary='Owned Product/Service']";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("LocateCol").size()==0){
			report.Info(action+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {   
			String Menu = "";
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			if (sLocateColValue.contains("Promotion")){
				sLocateColValue = sLocateColValue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());
			}
			if (sLocateColValue.equals("InstalledId")){
				sLocateColValue = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
			}         
			String sIndex = tableMap.get("Index").get(i);
			String sAction = tableMap.get("Action").get(i);
			//String sEnableAction = tableMap.get("EnableAction").get(i);
			String sEnable = tableMap.get("Enable").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			//String sPopUp = tableMap.get("PopUp").get(i);
			if (AccountSummaryTab.isPresent()){
				AccountSummaryTab.click();
				// Thread.sleep(5000);
				Common.waitForPageLoad(getDriver());
			}
			else {
				AccountTabsDRopDown.selectByVisibleText("Account Summary");
				//Thread.sleep(5000);
				Common.waitForPageLoad(getDriver());
			} 
			int k=0;
			if (common1.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true")){
				do{

					getDriver().navigate().refresh();
					Thread.sleep(2000);	   	    	
					k++;
				}while(common1.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true") && (k<10));
			}

			if (sIndex.equals("")){
				sIndex = "0";
			}

			Thread.sleep(3000);

			String LocateColMessege = sLocateCol+"Not Found";             

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));                     
				report.Info(sLocateCol+" found");                    
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
			else{
				common1.selectedRow = 1;
			}

			if (!sUIName.equals("")){
				if (sValue.equals("AgreementRowID")){
					sValue = Serenity.sessionVariableCalled("AgreementRowID").toString();
				}//do not delete
				common1.updateSiebList(applet,table, sUIName, sValue);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			//Check Reconnection is enable or disable
			if (sEnable.equals("Yes")&& sValue.equals("Reconnection") ){

				OwnedProductMenuButton.click();
				Thread.sleep(2000);
				Assert.assertTrue("FAIL : Reconnection is not enabled",ReconnectionMenuItem.isEnabled());
				report.Info("PASS : Reconnection is enabled");
				break;
			}

			//Check Reconnection is enable or disable               
			if (sEnable.equals("No")&& sValue.equals("Reconnection") ){

				OwnedProductMenuButton.click(); 
				Thread.sleep(2000);
				Assert.assertFalse("FAIL : Reconnection is not disabled",!ReconnectionMenuItem.isEnabled());
				report.Info("PASS : Reconnection is disabled");
				break;

			} 


			//Performs the action   
			if (!sAction.equals("")){
				if ((sAction.equals("Modify"))|| (sAction.equals("Modify Promo"))){
					//This will click on Modify or Modify Promo
					//String Button = ".//*[@title='Installed Assets:"+sAction+"']" ;  
					String Button = "(.//*[@title='Customer Account Portal']//button[@aria-label='Owned Product/Service:"+sAction+"'])";
					getDriver().findElement(By.xpath(Button)).click();
					System.out.println("INFO : Clicked on Menu "+sAction);
					Thread.sleep(3000);

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
					Thread.sleep(3000);
					OwnedProductMenuButton.click();
					//String Menu = "//a[text()='"+sAction+"']" ;      
					Menu = "//a[contains(text(),'"+sAction+"')]" ;
					//
					getDriver().findElement(By.xpath(Menu)).click();
					System.out.println("INFO : Clicked on Menu "+sAction);
					Thread.sleep(3000);

				}   
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				//Handles Recconection's PopUp after performing Reconnection
				if (sValue.equals("Reconnection") && sEnable.equals("")){

					//Thread.sleep(5000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					common1.HandleErrorPopUp("The MSISDN you are trying to reconnect is not available");
					/*Common.waitForPageLoad(getDriver());
					Alert alert=getDriver().switchTo().alert();
					String ActAlertText=alert.getText();
					System.out.println("alert messsage is"+ActAlertText);
					Assert.assertTrue("Expected pop is for 90days violation pop is not present", (ActAlertText.contains("The MSISDN you are trying")));*/

					report.Info("");       
					break;
				}                                                                                
			}



			if ((sAction.equals("Disconnect"))||(sAction.equals("Post to Pre Migration"))||(sAction.equals("Pre to Post Migration"))){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if (DisconnectPopupMsg.isVisible()){
					DisconnectPopupMsg.click();
					//Thread.sleep(3000);
					report.Info("Disconnection Pop button Clicked");
					Common.waitForElement(AcceptButton);
				}
				
				if (AcceptButton.isCurrentlyVisible()){
					AcceptButton.isCurrentlyVisible();
					AcceptButton.click();
					report.Info("Verify Message Accept button Clicked");                       	   				
				}
			}                       
		}  
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  	  
	}

	@FindBy(xpath="//*[text()='Account Summary']")
	WebElement AccountSummaryTabWebElement;  
	
	@FindBy(xpath="(//textarea[@aria-label='Comments'])[1]")
	WebElementFacade CommentElement; 

	public void CustCommsMsgVerify(String VeifyMessage) throws IOException, AWTException, InterruptedException {

		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AddVerifyContacts";
		String applet = "//*[@title='Customer Comms List List Applet']";
		String table = "//table[@summary='Customer Comms List']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(VeifyMessage, filePath, dataSheet);
		readWorkbook.testData(tableMap);    

		if (tableMap.get("RowNo").size()==0){
			report.Info(VeifyMessage+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}
		if (AccountSummaryTab.isDisplayed()){
			AccountSummaryTab.click();	    		   
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Account Summary");	   			
		} 
		Common.waitForPageLoad(getDriver());
		if(!findBy(table).isCurrentlyVisible()){
			if (AccountSummaryTab.isDisplayed()){
				AccountSummaryTab.click();	    		   
			}
			else {
				AccountTabsDRopDown.selectByVisibleText("Account Summary");	   			
			} 
		}
		Common.waitForPageLoad(getDriver());

		for (int i = 0;i < tableMap.get("RowNo").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String indexValue = tableMap.get("Index").get(i);
			String sRefresh = tableMap.get("Refresh").get(i);

			if (sLocateColValue.contains("TOTALUPFRONTCOST")){			
				sLocateColValue=sLocateColValue.replace("TOTALUPFRONTCOST", Serenity.sessionVariableCalled("TotalUpfrontCost").toString());
				System.out.println("Is:"+sLocateColValue);
			}
			
			if (sLocateColValue.contains("TOTALMONTHLYCOST")){			
				sLocateColValue=sLocateColValue.replace("TOTALMONTHLYCOST", Serenity.sessionVariableCalled("TotalMonthlyCost").toString());
				System.out.println("Is:"+sLocateColValue);
			}
			
			if (indexValue.equals("")){
				indexValue = "0";
			}

			if(sRefresh.equalsIgnoreCase("Y")){
				getDriver().navigate().refresh();

				Common.waitForElement(AccountSummaryTabWebElement);
			}
			Common.waitForPageLoad(getDriver());
			String LocateColMessege = sLocateCol+"Not Found";
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				if(sLocateColValue.contains("Device upfront cost:")) {
					sLocateColValue=sLocateColValue.replace("£", "");
				}				
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info(sLocateCol+"Customer summary applet found using Locate Col");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
			else 
			{
				common1.selectedRow = 1;
				report.Info("Customer summary applet found");
			}


			if (!sUIName.equals("")){                                              
				common1.updateSiebList(applet,table, sUIName, sValue);
				Thread.sleep(1000);			
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}  
			if(sUIName.equalsIgnoreCase("DrillDown|Id")) {
				Common.WaitForClock(Clockobj);
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",CommentElement);
			
				Common.WaitForClock(Clockobj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}


		}
	}
	@FindBy(xpath=".//*[@aria-label='Billing Profiles:Menu']")

	WebElementFacade MenuBillingProfile;

	@FindBy(xpath="//span/ul/li[11]/a")

	WebElementFacade MenuAboutRecord;

	@FindBy(xpath="//span/ul/li[8]/a")

	WebElementFacade MenuRunQuery;

	public void MenuBillingProfile(String MenuProfile) throws IOException, InterruptedException, AWTException{

		// Thread.sleep(5000);
		Common.waitForPageLoad(getDriver());

		String filePath = "\\src\\test\\resources\\data\\Account.xls";

		String dataSheet = "MenuBillingProfile";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(MenuProfile, filePath, dataSheet);

		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("MenuItem").size();i++) {   

			String sMenuItem = tableMap.get("MenuItem").get(i); 

			Thread.sleep(3000); 

			MenuBillingProfile.click();

			if(sMenuItem.equalsIgnoreCase("About Record")) {

				Thread.sleep(2000);

				MenuAboutRecord.click();

			}

			if(sMenuItem.equalsIgnoreCase("Run Query")) {

				Thread.sleep(2000); 

				MenuRunQuery.click();
			}
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}



	//By Payel
	//Verify Product and Services line items
	@FindBy(xpath="//*[text()='Product / Services']")
	WebElementFacade ProductAndServicesTab;
	@FindBy(xpath=".//*[@title='Products and Services:Show more']")
	WebElementFacade ProductandSeviceAppletShowMoreButton;
	@FindBy(xpath=".//*[@aria-label='Sales Order:Customer Account']")
	WebElementFacade CustomerAccountButton;
	@FindBy(xpath=".//*[@aria-label='Products and Services:Menu']")
	WebElementFacade ProductServicesMenuIcon;
	@FindBy(xpath=".//a[text()='Line Items']")
	WebElementFacade LineItemsTab;
	@FindBy(xpath="//span/ul/li[9]/a")
	WebElementFacade RefreshRecord;

	@FindBy(xpath="(.//*[contains(@id,'Product_Name')])[1]")
	WebElementFacade WaitforElement;
	@FindBy(xpath=".//*[@title='Products and Services Menu']")
	WebElementFacade ProductServiceMenuList;

	@FindBy(xpath=".//span/ul/li[12]/a")
	WebElementFacade MenulistAboutRecord;


	public void ProductServicesVerify(String Action) throws InterruptedException, IOException, AWTException, ParseException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "ProductServices";
		String applet = "//*[@title='Products and Services List Applet']";
		String table = "//table[@summary='Products & Services Root List (Service)']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("LocateCol").size()==0){
			report.Info(Action+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}


		/*LineItemsTab.click();
	    Thread.sleep(3000);

	    CustomerAccountButton.waitUntilClickable();
	    CustomerAccountButton.click();
		 */


		if (ProductAndServicesTab.isDisplayed()){
			ProductAndServicesTab.waitUntilClickable();
			ProductAndServicesTab.click();
			Thread.sleep(3000);
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Product / Services");
			Thread.sleep(2000);
		}
		Common.WaitForClock(Clockobj);
		Common.waitForPageLoad(getDriver());

		if (ProductandSeviceAppletShowMoreButton.isDisplayed()){
			ProductandSeviceAppletShowMoreButton.click();
			Thread.sleep(3000);

		}
		String sLocateColValue = tableMap.get("LocateColValue").get(0);
		int k=0;
		if (common1.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true")&& !sLocateColValue.equals("Null")){
			do{
				//ProductServicesMenuIcon.click();
				//Thread.sleep(1000);
				//RefreshMenuItem.click();
				getDriver().navigate().refresh();
				Thread.sleep(5000);	   	    	
				k++;
			}while(common1.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true") && (k<10));
		}


		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			sLocateColValue = tableMap.get("LocateColValue").get(i);
			// sLocateColValue = Replace(sLocateColValue,"InstalledId",DictionaryTest_G.Item("ACCNTMSISDN"))
			String sExist = tableMap.get("Exist").get(i);
			String sLocateColExpand = tableMap.get("LocateColExpand").get(i);
			String sLocateColExpandValue = tableMap.get("LocateColExpandValue").get(i);
			String sCollapse = tableMap.get("Collapse").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String sValidation = tableMap.get("Validation").get(i);

			String indexValue = "0";

			if (sLocateColValue.contains("Promotion")){
				sLocateColValue = sLocateColValue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());
				//sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
			}

			String LocateColMessege = sLocateCol+"Not Found";

			//Locate Col to Expand   
			if (!sLocateColExpand.equals("")){
				if (sLocateColExpandValue.equals("RootProduct0")){
					sLocateColExpandValue = Serenity.sessionVariableCalled("RootProduct0").toString();
				}

				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateColExpand, sLocateColExpandValue, indexValue).equals("true"));
				report.Info(sLocateColExpand+"found");
				common1.ExpandRow(applet,table);
				report.Info(sLocateColExpand+"found and expanded");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}

			//Local Col
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				String res  = common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue);
				//  Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info(sLocateCol+"found");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				if(sValue.equalsIgnoreCase("GetRecord")){

					ProductServiceMenuList.click();
					Thread.sleep(1000);	
					MenulistAboutRecord.click();
					Thread.sleep(2000);

				}
				if(!sUIName.equals("")){
					String Capturedvalue = common1.updateSiebList(applet,table, sUIName, sValue);
					report.Info("Row updated: "+sUIName);
					Serenity.setSessionVariable("AgreementId").to(sValue);
					report.Info("Agreement Id value captured from ProductServices view is : " +sValue);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					if(sValue.equalsIgnoreCase("CaptureServiceEndDate"))
					{
							Serenity.setSessionVariable("CaptureServiceEndDate").to(Capturedvalue);
					}

				}
				if(sValidation.equals("CaptureServiceEndDate"))
				{	
					String sCaptureServiceEndDate  = Serenity.sessionVariableCalled("CaptureServiceEndDate").toString();
			        Calendar c = Calendar.getInstance();
			    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    	Date DOBdate = dateFormat.parse(sCaptureServiceEndDate);
			    	c.setTime(DOBdate);			    	
			        Date currentDate = new Date();
			        c.setTime(currentDate);		   
			    	long diff = Math.abs(DOBdate.getTime() - currentDate.getTime());
			    	long diffdate= diff/(24*60*60*1000)+1;
			    	String DateDifference= Long.toString(diffdate);
			    	Assert.assertTrue("Fail, Service end date is not 719 back date", DateDifference.equals("719"));
					report.Info(DateDifference + "equals to 719  as expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());				
				
				}
				if(sExist.equals("")){            
					Assert.assertTrue(res+ " - " + sLocateCol + "-" + sLocateColValue + " not found in the list.", res.equalsIgnoreCase("True"));
					report.Info(sLocateCol + "-" + sLocateColValue + " found in the list as expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				}
				else{
					if(sExist.equalsIgnoreCase("False")){
						sExist=  "False-Row Not Exist";
					}
					Assert.assertTrue(sLocateCol + "-" + sLocateColValue + " existence is " + res + " but expected is " + sExist, res.equalsIgnoreCase(sExist));
					report.Info(sLocateCol + "-" +  sLocateColValue + " existence is " + sExist + " as expected");
				}
				//String sAction = "Run Query [Alt+ENTER]";
				if (!sCollapse.isEmpty()){
					ProductServicesMenuIcon.click();
					Thread.sleep(1000);
					RefreshRecord.click();
					report.Info("Info : Clicked on Menu Run Query Button.");
					Thread.sleep(1000);
				}

			}
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade PromotionList;
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")	  
	WebElementFacade PromotionSearchTextBox;	  

	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")	  
	WebElement PromotionSearchTextBoxWebElement;	

	@FindBy(xpath=".//*[@aria-labelledby='s_11_l_Target_Promotion_Name']")
	WebElementFacade TargetPromotion;
	@FindBy(xpath=".//input[@aria-labelledby='PopupQuerySrchspec_Label']/following::button[@aria-label='Promotion Upgrades:Go']")
	WebElementFacade PromotionUpgradeGoButton;
	@FindBy(xpath=".//button[contains(@title,':OK')]") 
	WebElementFacade PromotionUpgradeOKButton;


	@Step
	public void PromotionUpgrade() throws InterruptedException, IOException, AWTException{
		/*  Promotion Upgrades
    	  Promotion Upgrades List Applet*/
		String dataSheet = "ProductServices";
		/*String applet = "//*[@title='Promotion Upgrades List Applet']";
		String table = "//table[@summary='Promotion Upgrades']";*/
		
		String applet = "//*[contains(@class,'siebui-applet siebui-collapsible-applet siebui-list')]";
		String table = "//table[@class='ui-jqgrid-btable']";

		Common.WaitForClock(Clockobj);
		
		if(isAlertPresent(getDriver())){
			Alert alert=getDriver().switchTo().alert();
			String ActAlertText=alert.getText();  
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			                                                                              
			if (ActAlertText.contains("SIMO Flex")){ 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				alert.accept();
				report.Info("alert messsage is"+ActAlertText);
			}  
			if (ActAlertText.contains("Eligible  to Recommit")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				alert.accept();
				System.out.println("alert messsage is"+ActAlertText);
			}
		}
		Common.WaitForClock(Clockobj);
		String sStartingWith = Serenity.sessionVariableCalled("ProductName").toString();

		//Thread.sleep(45000);
		//PromotionSearchTextBox.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilPresent();
		Common.WaitForClock(Clockobj);
		Common.waitForElement(PromotionSearchTextBoxWebElement);
		try{
			if (!Serenity.sessionVariableCalled("UsedProdAction").equals("")){
				long UsedProdstartTime = Serenity.sessionVariableCalled("UsedProdAction");
				long UsedProdendTime = System.currentTimeMillis();
			long UsedProdtotalTime = UsedProdendTime - UsedProdstartTime;
				Common.WritePerformanceOutput("Promotion Upgrade Applet visible,Total Time " + UsedProdtotalTime/1000);

			}      
		}
		catch(Exception E){

		}
		long PromoUpgstartTime = System.currentTimeMillis();
		//PromotionList.type("Promotion Name");
            //PromotionSearchTextBox.type(sStartingWith);
            //PromotionUpgradeGoButton.click();
		
		 PromotionSearchTextBox.sendKeys(sStartingWith);
         PromotionUpgradeGoButton.click();
         Thread.sleep(1000);
         
    //Commented java script code     
		/*JavascriptExecutor JSE = (JavascriptExecutor)getDriver();
		JSE.executeScript("arguments[0].value = '"+sStartingWith+"';", PromotionSearchTextBox);
		JSE.executeScript("arguments[0].click()", PromotionUpgradeGoButton);*/
		//Thread.sleep(1000);

		Common.waitForPageLoad(getDriver());
		Common.WaitForObjectPresence("//table[@summary='Promotion Upgrades']/tbody/tr");

		int PromotionUpgardeTableSize= findAll(By.xpath("//table[@summary='Promotion Upgrades']/tbody/tr")).size();


		if(PromotionUpgardeTableSize>1){

			common1.selectedRow = -1;
	//UnCommenting this code as clash with CTR15 promotions is  there 
			Assert.assertTrue(common1.locateColumn(applet,table,"Target_Promotion_Name",sStartingWith, "0").equals("true"));
			report.Info("Promotions are available");
		}
		else{
			Assert.assertTrue("No rows displayed after clicking on Go button- Promotions not available", PromotionUpgradeOKButton.isVisible());
		}
		long startTime = System.currentTimeMillis();
		PromotionUpgradeOKButton.click();
		Common.waitForPageLoad(getDriver());

		//	Thread.sleep(20000);
		Common.WaitForClock(Clockobj);
		Common.waitForElement(LineItemsTabWebElement);
		Common.WaitForObjectPresence(".//a[text()='Line Items']");
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		Common.WritePerformanceOutput("Target promotion selected,Total Time " + totalTime/1000);
		//  	LineItemsTab.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilClickable(); 
		/*long PromoUpgendTime = System.currentTimeMillis();
    	   	long PromoUpgtotalTime = PromoUpgendTime - PromoUpgstartTime;
    	   	Common.WritePerformanceOutput("Target promotion selected,Total Time " + PromoUpgtotalTime/1000);*/


		//LineItemsTab.waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}
	
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']//following::*[@title,'Packages:Go']")//Promotion Upgrades:Go']")
	WebElementFacade PackagesGoButton;
	//td[contains(@aria-labelledby,'Payment_Method')]

	@FindBy(xpath=".//*[@title='Packages:OK']")//Promotion Upgrades:OK']")
	// @FindBy(xpath=".//*[Contains(@title='s:OK')]")	 
	WebElementFacade PackagesOKButton;

	@Step
	public void PackagesNLFL() throws InterruptedException, IOException, AWTException{
      
		String applet = "//*[@title='Packages List Applet']";
		String table = "//table[@summary='Packages']";

		//String sStartingWith = Serenity.sessionVariableCalled("ProductName").toString();
		String sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();

		Common.waitForPageLoad(getDriver());

		Common.waitForElement(PromotionSearchTextBoxWebElement);
		//Thread.sleep(45000); 
		//  PromotionSearchTextBox.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilClickable();
		try{
			if (!Serenity.sessionVariableCalled("UsedProdAction").equals("")){
				long UsedProdstartTime = Serenity.sessionVariableCalled("UsedProdAction");
				long UsedProdendTime = System.currentTimeMillis();
				long UsedProdtotalTime = UsedProdendTime - UsedProdstartTime;
				Common.WritePerformanceOutput("Promotion Upgrade Applet visible,Total Time " + UsedProdtotalTime/1000);

			}      
		}
		catch(Exception E){

		}
		long NLFLstartTime = System.currentTimeMillis();
		PromotionList.type("Promotion Name");
		PromotionSearchTextBox.typeAndEnter(sLocateColValue);
		//PromotionUpgradeGoButton.withTimeoutOf(20,TimeUnit.SECONDS).waitUntilClickable();
		// PromotionUpgradeGoButton.click();
		//Thread.sleep(1000);
		Common.waitForPageLoad(getDriver());


		int PromotionUpgardeTableSize= findAll(By.xpath("//table[@summary='Packages']/tbody/tr")).size();


		if(PromotionUpgardeTableSize>1){
			report.Info("Promotions are available");
			Common.selectedRow = -1;
			Common.locateColumn(applet,table, "Target_Promotion_Name", sLocateColValue, "0");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
		else{
			Assert.assertTrue("No rows displayed after clicking on Go button- Promotions not available", PromotionUpgardeTableSize>1);
		}

		PackagesOKButton.click();
		LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable(); 
		long NLFLendTime = System.currentTimeMillis();
		long NLFLtotalTime = NLFLendTime - NLFLstartTime;
		Common.WritePerformanceOutput("Target promotion selected,Total Time " + NLFLtotalTime/1000);


		//	LineItemsTab.waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

	}

	@FindBy(xpath="(.//*[@aria-label='Selection Field'])[12]")
	WebElementFacade OpenPopUpNewAccount;
	@FindBy(xpath=".//*[@title='Pick Account:Go']")
	WebElementFacade PickAccountGoButton;

	@FindBy(xpath=".//*[@aria-label='Pick Account:OK']")
	WebElementFacade PickAccountOkButton;
	@FindBy(xpath="(.//*[@aria-label='Selection Field'])[13]")
	WebElementFacade OpenPopUpNewBillingProfile;
	@FindBy(xpath=".//*[@aria-label='Pick Billing Profile:OK']")
	WebElementFacade BillingProfileOkButton;
	@FindBy(xpath=".//*[@title='Transfer of Ownership:Continue']")
	WebElementFacade TOOContinueButton;
	@FindBy(xpath=".//*[@title='Transfer of Ownership:Continue']")
	WebElement TOOContinueButtonWebElement;

	@FindBy(xpath="//input[@aria-label='Status']")
	WebElementFacade OrderStatus;

	@FindBy(xpath="//*[text()='Pick Account']")
	WebElementFacade TOONewAccount;
	
	@FindBy(xpath="//button[contains(@class,'confirm-popup')]")
	WebElementFacade PopUpOKButton;
	
	@FindBy(xpath=".//*[@title='Transfer of Ownership:Cancel']")
	WebElementFacade TOOCancelButton;
	

	//@Tarun
	public void TransferOfOwnerShip() throws InterruptedException, IOException, AWTException {

		String applet = "//*[@title='Pick Account List Applet']";
		String table = "//table[@summary='Pick Account']";


		String sAccountNumber = Serenity.sessionVariableCalled("AccountNo").toString();
		Common.waitForPageLoad(getDriver());
		//String sAccountNumber="7000289825";
		//Thread.sleep(10000);

		Common.waitForElement(TOOContinueButtonWebElement);
		//TOOContinueButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible(); 
		//TOOContinueButton.waitUntilVisible();
		OpenPopUpNewAccount.click();
		TOONewAccount.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible(); 
		//Thread.sleep(5000);
		common1.selectedRow = 1;

		common1.updateSiebList(applet,table,"Text|Account_Number", sAccountNumber);

		//Thread.sleep(1000);
		PickAccountGoButton.click();
		Thread.sleep(2000);

		int AccountTableSize= findAll(By.xpath("//table[@summary='Pick Account']/tbody/tr")).size();

		if(AccountTableSize>1){
			report.Info("Account Number is searched successfully "+sAccountNumber);
		}
		else{
			Assert.assertTrue("No rows displayed after clicking on Go button. ", AccountTableSize>1);
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
		PickAccountOkButton.click();
		Thread.sleep(1000);
		OpenPopUpNewBillingProfile.click();
		// BillingProfileOkButton.waitUntilVisible();
		Thread.sleep(4000);
		int BillingProfileTableSize= findAll(By.xpath("//table[@summary='Billing profile']/tbody/tr")).size();

		if(BillingProfileTableSize>1){
			report.Info("Blling Profile is displayed successfully for Account Number "+sAccountNumber);
		}
		else{
			Assert.assertTrue("No rows displayed after clicking on billing profile Go button. ", BillingProfileTableSize>1);
		}

		BillingProfileOkButton.click();
		//Thread.sleep(1000);
		Common.waitForElement(TOOContinueButtonWebElement);
		// TOOContinueButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		TOOContinueButton.click();
		
		Thread.sleep(5000);
		if (PopUpOKButton.isVisible()) {
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			common1.HandleErrorPopUp("OPTIONAL:This request is invalid as the account you are attempting");
			Thread.sleep(2000);
			TOOCancelButton.click();
			return;

		}
		
		OrderStatus.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilVisible();
		try{
			if (!Serenity.sessionVariableCalled("UsedProdAction").equals("")){
				long UsedProdstartTime = Serenity.sessionVariableCalled("UsedProdAction");
				long UsedProdendTime = System.currentTimeMillis();
				long UsedProdtotalTime = UsedProdendTime - UsedProdstartTime;
				Common.WritePerformanceOutput("TOO Done,Total Time " + UsedProdtotalTime/1000);

			}      
		}
		catch(Exception E){

		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}


	public void CustomerAccount() throws InterruptedException, IOException, AWTException{
		if (CustomerAccountButton.isCurrentlyVisible()){
			CustomerAccountButton.click();
		}
		else if (!CustomerAccountButton.isCurrentlyVisible()){
			Common.waitForPageLoad(getDriver());
			//LineItemsTab.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();        	 
			LineItemsTab.click();
			CustomerAccountButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();     	      
			CustomerAccountButton.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}        	   	  
	}


	@FindBy(xpath="(.//*[text()='Bulk Modify'])[1]")
	WebElementFacade BulkModifyTab;

	@FindBy(xpath=".//*[@id='jqgh_s_1_l_Product_Name']")
	WebElementFacade WaitForElement;
	@FindBy(xpath=".//button[@title='Bulk Modify Menu']")
	WebElementFacade BulkModMenu;
	@FindBy(xpath="(.//*[text()='Bulk Modify'])[2]")
	WebElementFacade BulkModifyText;
	@FindBy(xpath=".//div[text()='Bulk Modify']")
	WebElementFacade BulkModifypage;
	
	@FindBy(xpath="(.//span/ul/li[46]/a")
	WebElementFacade Clockbacks;
	
	@FindBy(xpath=".//*[@aria-label='Due date']")
	WebElementFacade BulkModifyDueDate; 
	
	@FindBy(xpath=".//*[@title='Import Dialog:OK']")
	WebElementFacade ImportDialogOKButton;
	
	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade TargetPromoAppletText;
	
	@FindBy(xpath=".//button[@title='Bulk Modify:Upgrade']")
	WebElementFacade UpgradeButton;
	
	@FindBy(xpath=".//span/ul/li[46]/a")
	WebElementFacade ClockbackLink;

	public void BulkMOdify(String rowname) throws InterruptedException, IOException, AWTException{

		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String applet = "//*[@title='Bulk Modify List Applet']";
		String table = "//table[@summary='Bulk Modify']";
		String dataSheet = "BulkModify";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
			String sUIName =  tableMap.get("UIName").get(i);
			String sValue =  tableMap.get("Value").get(i);		      
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sIndex = tableMap.get("Index").get(i);
			String sBulkModifyTabClick = tableMap.get("BulkModifyTabClick").get(i);
			String sClockbackCheck = tableMap.get("ClockbackCheck").get(i);
		
			

			if (sLocateColValue.equals("Promotion")){
				sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
			}

			if (sBulkModifyTabClick.equals("Y")) {
				if (BulkModifyTab.withTimeoutOf(60,TimeUnit.SECONDS).isCurrentlyVisible()&& !BulkModifyText.isCurrentlyVisible()) {
					BulkModifyTab.click();
					Thread.sleep(2000);
					WaitForElement.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
				}
				else if (!BulkModifyTab.withTimeoutOf(60,TimeUnit.SECONDS).isCurrentlyVisible()&& !BulkModifyText.isCurrentlyVisible()){
					AccountTabsDRopDown.click();
					Thread.sleep(2000);
					WaitForElement.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
				}
			}

			else 
				if (BulkModifypage.withTimeoutOf(60,TimeUnit.SECONDS).isCurrentlyVisible()) {
					Thread.sleep(2000);
					BulkModifypage.click();
					Thread.sleep(2000);

				}



			if ((common1.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true"))){
				int k=0;
				do{
					getDriver().navigate().refresh();
					//BulkModMenu.click();
					//Thread.sleep(1000);
					//RefreshMenuItem.click();	
					WaitForElement.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
					k++;
				}while(common1.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true") && (k<11));
			}



			if(sIndex.equals("")){
				sIndex="0";
			}
			if (sLocateColValue.equals("RootProduct0")){
				sLocateColValue = Serenity.sessionVariableCalled("RootProduct0").toString();
			}


			String LocateColMessege = sLocateCol+"Not Found";
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));                     
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								               
			}
			else{
				common1.selectedRow = 1;
			}

			if (!sUIName.equals("")){    	    		
				common1.updateSiebList(applet,table, sUIName, sValue);   
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
			
			if(sUIName.equalsIgnoreCase("OpenPopUp|l_Target_Promotion")) {
				boolean flag= false;
				int j=0;
				do {
					if(TargetPromoAppletText.isCurrentlyVisible()) {
						flag=true;
					}
					else {
						Thread.sleep(2000);
						j++;
					}
				}while(j<150 && flag==false);
			}
			
			
			if (sClockbackCheck.equals("Yes")){
				BulkModMenu.withTimeoutOf(60,TimeUnit.SECONDS).isVisible();
				BulkModMenu.click();
				//Clockbacks.withTimeoutOf(60,TimeUnit.SECONDS).isVisible();

				//String ClickOnClockBacks = ".//span/ul/li[46]/a";
				//JavascriptExecutor JSE = (JavascriptExecutor)getDriver(); 
				//((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",Clockbacks);
				Thread.sleep(3000);
				ClockbackLink.click();
				//((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()",Clockbacks);
				//Clockbacks.click();
				//getDriver().findElement(By.xpath("//*[text()='Clockbacks']")).click();
				Thread.sleep(2000);
				//((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()", getDriver().findElement(By.xpath("//*[text()='Clockbacks']")));

				//common1.WaitForObjectPresence("(.//span/ul/li[46]/a");
				//Clockbacks.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
				Date currentDate = new Date();
				Calendar calendar = Calendar.getInstance();	      
				@SuppressWarnings("deprecation")
				int Day=currentDate.getDay();

				calendar.add(calendar.DAY_OF_MONTH, 20);			   

				String sDeliveryDate=dateFormat.format(calendar.getTime());
				BulkModifyDueDate.clear();
				BulkModifyDueDate.type(sDeliveryDate);
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ImportDialogOKButton.click();
				Serenity.setSessionVariable("sDeliveryDate").to(sDeliveryDate);	
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


			}
		
		}
	}
	
	



	@FindBy(xpath="(.//div[contains(@title,'List Applet') and @class='siebui-applet siebui-collapsible-applet siebui-list Selected siebui-active siebui-applet-active siebui-hilight'])")
	WebElementFacade PickAccountlistApplet;

	@FindBy(xpath="(//button[contains(@aria-label,'Query') and contains(@class,'appletButton')])[2]")
	WebElementFacade PickAccountQueryButton;

	@FindBy(xpath=".//button[contains(@title,'OK') and contains(@class,'appletButton')]")
	WebElementFacade EnterSearchBoxGobutton;

	@FindBy(xpath=".//*[@title='Pick Contact:OK']")
	WebElementFacade PickContactOkButton;

	@FindBy(xpath=".//*[@title='Billing profile:OK']")
	WebElementFacade BulkBillingProfileOkButton;

	@FindBy(xpath=".//*[@title='Bulk Modify:Service Hierarchy Change']")
	WebElementFacade ServiceHierarchyButton;
	
	@FindBy(xpath=".//div[contains(text(),'You are unable to complete this request as you have not entered values in the Billing account, Billing Profile')]")
	WebElementFacade ServiceHeierarchyPopup;
	
	@FindBy(xpath=".//button[@aria-label='Import Dialog:OK']")
	WebElementFacade TargetPromotionProcessOkButton;
	
	@FindBy(xpath=".//button[@aria-label='Bulk Modify:Tariff Migration']")
	WebElementFacade TariffMigration;
	
	@FindBy(xpath=".//*[contains(text(),'Please ensure you have not attempted to change the Payer/User fields')]")
	WebElementFacade TariffMigPopUp;
	
	@FindBy(xpath=".//*[text()='Ok']")
	WebElementFacade TariffMigOkButton;
	
	@FindBy(xpath=".//a[@name='VF Order Number']")
	WebElementFacade GeneratedOrder;

	@FindBy(xpath=".//button[@aria-label='Bulk Modify:Transfer Of OwnerShip']")
	WebElementFacade TransferOfOwnership;
	
	@FindBy(xpath=".//*[contains(text(), 'Please select New Owner Account and New Billing Profile')]")
	WebElementFacade AccountIdField;
	
	@FindBy(xpath=".//*[text()='Ok']")
	WebElementFacade AccountIdPopupOk;
	
	@FindBy(xpath="//span/ul/li[31]/a")
	WebElementFacade CascadeLink;

	public void BulkModifyAccounthierarchy(String Account) throws InterruptedException, IOException, AWTException {		      
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "BulkModifyAccounthierarchy";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Account, filePath, dataSheet);
		readWorkbook.testData(tableMap);


		for (int i = 0  ;i < tableMap.get("AccountSelection").size();i++){
			String sAccountSelection = tableMap.get("AccountSelection").get(i);
			String sClickServiceHierarchy= tableMap.get("ClickServiceHierarchy").get(i); 
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);
			String sRefresh = tableMap.get("Refresh").get(i);
			String sCascade = tableMap.get("Cascade").get(i);
			String sOrderGenerate = tableMap.get("OrderGenerate").get(i);
			String applet ="" ;
			String table = "";
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String indexValue = tableMap.get("Index").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			

			if (indexValue.equals("")){
				indexValue = "0";
			}
			if (sAccountSelection.equals("NewServiceAccount")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				applet = "//*[@title='Pick Account List Applet']";
				table = "//table[@summary='Pick Account']";
				Thread.sleep(1000);
				PickAccountlistApplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
				if (PickAccountlistApplet.isCurrentlyVisible()){

					PickAccountQueryButton.click();
					common1.selectedRow = 1;
					if (!UIName.equals("")){ 
						Thread.sleep(2000);
						PickAccountGoButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
						common1.updateSiebList(applet,table, UIName, value);           
						Thread.sleep(1000);
						PickAccountGoButton.click();
						Thread.sleep(2000);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						EnterSearchBoxGobutton.click();
						Thread.sleep(1000);

					}

				}
			}

			if (sAccountSelection.equals("NewServiceContact")){

				applet = "//*[@title='Pick Account List Applet']";
				table = "//table[@summary='Pick Contact']";

				Thread.sleep(2000);
				PickContactOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				PickContactOkButton.click();

			}
			
			if (sAccountSelection.equals("TargetPromotionProcess")){
				
				 applet ="//*[@title='Import Dialog List Applet']";
				 table = "//table[@summary='Import Dialog']";
				 
					 if (!sLocateCol.equals("")){
			    			Common.selectedRow = -1;
			    			Common.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue);
			    			report.Info(sLocateCol+"Customer summary applet found using Locate Col");
			    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			    		}
			    		else {
			    			Common.selectedRow = 1;
			    			report.Info("Customer summary applet found");
			    		}
					  Thread.sleep(2000);
					  TargetPromotionProcessOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			          TargetPromotionProcessOkButton.click();
			}
				 
			if (sAccountSelection.equals("TargetPromotion")){
				Common.WaitForClock(Clockobj);
				Thread.sleep(2000);
				TariffMigration.click(); 
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(sPopUp.equalsIgnoreCase("Yes"))
				{
				Assert.assertTrue("Expected popup did not occur", TariffMigPopUp.containsText("Please ensure you have not attempted to change the Payer/User fields"));
				report.Info("Pass:Expected Popup did occur");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				TariffMigOkButton.click();
				}
			
			}

			if (sAccountSelection.equals("NewBillingAccount")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				applet = "//*[@title='Pick Account List Applet']";
				table = "//table[@summary='Pick Account']";
				Thread.sleep(1000);
				PickAccountlistApplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
				if (PickAccountlistApplet.isCurrentlyVisible()){

					PickAccountQueryButton.click();
					common1.selectedRow = 1;
					if (!UIName.equals("")){ 
						Thread.sleep(2000);
						PickAccountGoButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
						common1.updateSiebList(applet,table, UIName, value);           
						Thread.sleep(1000);
						PickAccountGoButton.click();
						Thread.sleep(2000);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						EnterSearchBoxGobutton.click();
						Thread.sleep(1000);

					}

				}
			}
			
			if (sAccountSelection.equals("NewOwnerAccount")){
				
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				applet = "//*[@title='Pick Account List Applet']";
				table = "//table[@summary='Pick Account']";
				
				if (!UIName.equals("")){ 
					common1.selectedRow = 1;
					Thread.sleep(2000);
					PickAccountGoButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
					common1.updateSiebList(applet,table, UIName, value);           
					Thread.sleep(1000);
					PickAccountGoButton.click();
					Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					EnterSearchBoxGobutton.click();
					Thread.sleep(1000);

				}
				
			}

			if (sAccountSelection.equals("NewBillingProfile")){

				applet = "//*[@title='Pick Account List Applet']";
				table = "//table[@summary='Billing profile']";

				Thread.sleep(2000);
				BulkBillingProfileOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				BulkBillingProfileOkButton.click();

			}
			
			if (sClickServiceHierarchy.equals("Yes")) {
				ServiceHierarchyButton.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilClickable();
				ServiceHierarchyButton.click();

				Alert alert1;
				String ActAlertText1="";
				if(isAlertPresent(getDriver())){
					alert1=getDriver().switchTo().alert();
					ActAlertText1=ServiceHeierarchyPopup.getText();  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Assert.assertTrue("Fail, expected popup did not occur", ActAlertText1.contains("You are unable to complete this request as you have not entered values in the Billing account, Billing Profile"));
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					alert1.accept();
					report.Info("Pop occurred : " +ActAlertText1);
				} 
			}
			
			
			if (sAccountSelection.equals("TOO")){
				
				TransferOfOwnership.click();
			
				Assert.assertTrue("Expected popup did not occur", AccountIdField.containsText("Please select New Owner Account and New Billing Profile"));
				report.Info("Pass:Expected Popup did occur");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				AccountIdPopupOk.click();
		
				}
			
			if (sAccountSelection.equals("TariffMigratClick")){
				Common.WaitForClock(Clockobj);
				Thread.sleep(2000);
				TariffMigration.click(); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				getDriver().navigate().refresh();
			
			}
			

			if (sAccountSelection.equals("NLFL")){
				Thread.sleep(2000);
				NLFLButton.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilClickable();
				NLFLButton.click();
				Thread.sleep(2000);
				getDriver().navigate().refresh();
			}
				
			if (sAccountSelection.equals("ModifyUpgradeClick")){
				Thread.sleep(2000);
				UpgradeButton.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilClickable();
				UpgradeButton.click();
				Thread.sleep(2000);
				getDriver().navigate().refresh();
			}
			
			if (sAccountSelection.equals("MultiplePromo")){
            	
            	getDriver().findElement(By.xpath(".//*[@aria-label='Bulk Modify:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
				Robot robot = new Robot();	 
				robot.keyPress(KeyEvent.VK_ALT);	
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ALT);	        		
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(4000);
				
				
				}
		

			if (sClickServiceHierarchy.equals("Y")){
				Thread.sleep(2000);
				ServiceHierarchyButton.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilClickable();
				ServiceHierarchyButton.click();

			}
			
			if(sCascade.equalsIgnoreCase("Yes")){
				BulkModifyMenuIcon.click();
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				CascadeLink.click();
				/*((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()", getDriver().findElement(By.xpath("//*[text()='Cascade']")));*/
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			
			if (sAccountSelection.equals("OrderGenerated")){
				
				ServiceHierarchyButton.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilClickable();
				ServiceHierarchyButton.click();
				getDriver().findElement(By.xpath(".//*[@aria-label='Bulk Modify:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
				Robot robot = new Robot();	 
				robot.keyPress(KeyEvent.VK_ALT);	
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ALT);	        		
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(4000);
			}

			if (sRefresh.equalsIgnoreCase("Y")){
				Robot robot = new Robot();	 
				robot.keyPress(KeyEvent.VK_ALT);	
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ALT);	        		
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(4000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				//report.Info("About record is displayed successfully");
			}
			if(sOrderGenerate.equalsIgnoreCase("Yes")){

			     GeneratedOrder.click();

		}
	}
		}


		
	


	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade BulkModProductNameList;

	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElementFacade SearchProductTextBox;

	@FindBy(xpath=".//*[@class='siebui-popup-button']/button[@title='Selected:Add >']")
	WebElementFacade AddProduct;

	@FindBy(xpath=".//*[@class='siebui-popup-button']/button[@title='Selected:OK']")
	WebElementFacade OkButton;

	@FindBy(xpath=".//*[@title='Bulk Modify:Modify']")
	WebElementFacade BulkModifyButton;

	@FindBy(xpath=".//*[@title='Bulk Modify:Transfer Of OwnerShip']")
	WebElementFacade BulkTOOButton;
	@FindBy(xpath=".//*[@title='Bulk Modify:LFL']")
	WebElementFacade LFLButton;


	public void BulkMOdifyAddProducts(String rowname) throws InterruptedException, IOException, FindFailed, AWTException{

		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
		String applet = "//*[@title='Bulk Modify List Applet']";
		String table = "//table[@summary='Bulk Modify']";
		String dataSheet = "BulkModifyAddProducts";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("PopUp").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("PopUp").size();i++) {

			String sModify = tableMap.get("Modify").get(i);
			String sProductName = tableMap.get("ProductName").get(i);
			String sTransferOfOwnership = tableMap.get("TransferOfOwnership").get(i);
			String sProcessStatus = tableMap.get("ProcessStatus").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			String sLFL = tableMap.get("LFL").get(i);
			/*   String sLocateCol = tableMap.get("LocateCol").get(i);
	    	  String sLocateColValue = tableMap.get("LocateColValue").get(i);
	    	  String sUIName = tableMap.get("UIName").get(i);
	    	  String sValue = tableMap.get("Value").get(i);
	    	  String sIndex = tableMap.get("Index").get(i);*/
			/*   if (sLocateColValue.equals("Promotion")){
	    		   sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
	    	   }*/

			/*    if (!sLocateCol.equals("")){
                      common1.selectedRow = -1;
                      Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));                                    
                      //report.Info(sLocateCol+" found");    
                      }
                  else{
                      common1.selectedRow = 1;
                  }
                  if (!sUIName.equals("")){
                      common1.updateSiebList(applet,table, sUIName, sValue);                                      
                      //report.Info(sLocateCol+" found");                                      
                      }*/

			if (sModify.equalsIgnoreCase("N")){
				BulkModProductNameList.type("Product Name");
				SearchProductTextBox.typeAndEnter(sProductName);
				AddProduct.click();
				Thread.sleep(1000);
				OkButton.click();
				Thread.sleep(2000);
			}
			if (sModify.equalsIgnoreCase("Y")){
				BulkModifyButton.click();
				Thread.sleep(2000);
				sikuliUtility.ClickFraudRiskAlert(SikulifilePath);
			}
			if (sTransferOfOwnership.equalsIgnoreCase("Y")){
				BulkTOOButton.click();
				Thread.sleep(2000);
				//sikuliUtility.ClickFraudRiskAlert(SikulifilePath);
			}
			if (sLFL.equalsIgnoreCase("Y")){
				LFLButton.waitUntilClickable();
				LFLButton.click();	
				Thread.sleep(2000);
			}
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}
	@FindBy(xpath="(.//*[@aria-labelledby='s_1_l_VF_Bulk_Process_Status'])[1]")
	WebElementFacade ProcessStatus;

	public void BulkViewProcessStatusValidation(String rowname) throws InterruptedException, IOException, AWTException{

		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String applet = "//*[@title='Bulk Modify List Applet']";
		String table = "//table[@summary='Bulk Modify']";
		String dataSheet = "BulkModify";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("LocateCol").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		if (BulkModifyTab.withTimeoutOf(60,TimeUnit.SECONDS).isCurrentlyVisible()){
			Thread.sleep(2000);
			BulkModifyTab.click();
			Thread.sleep(2000);
			WaitForElement.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
		}
		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sIndex = tableMap.get("Index").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String LocateColMessege = sLocateCol+"Not Found";
			if(sIndex.equals("")){
				sIndex="0";
			}

			if (sLocateColValue.equals("Promotion")){
				sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
			} 

			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				String sResult = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex);			         
				Assert.assertTrue(sResult,sResult.equals("true")); 
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
			}
			else{
				Common.selectedRow = 1;
			}			  	

			//Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));
			if (!UIName.equals("")){ 
				String returnvalue = Common.updateSiebList(applet,table, UIName, sValue);           
				Thread.sleep(1000);
				for (int t = 0;t < 8;t++) {
					if (!returnvalue.equals("Completed")) {
						common1.selectedRow = -1;
						Common.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex);
						Common.updateSiebList(applet,table, UIName, sValue);
						Thread.sleep(2000);
						if (BulkModMenu.isCurrentlyVisible()){
							BulkModMenu.click();
							Thread.sleep(1000);
							RefreshMenuItem.click();
						}
					}
					else {
						report.Info("Process status got changed to completed");
						break;
					}
				}   	    
			}

			/* int j = 0;
			      do {		    	 
				 if (!sLocateCol.equals("")){
	                 common1.selectedRow = -1;
	                 Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));                                                         
	                 }

				  	if (BulkModMenu.isCurrentlyVisible()){
				  		BulkModMenu.click();
			    		Thread.sleep(1000);
			    		RefreshMenuItem.click();
				  	}

				  	getDriver().navigate().refresh();
				  	Thread.sleep(2000);
				 	getProcessStatus = ProcessStatus.getTextValue();

				 	if (getProcessStatus.equals("Completed")){
				 		break;
				 	}
				 }while (getProcessStatus.equals("Completed")&&(j<10));*/

		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@FindBy(xpath=".//*[text()='Companies']")
	WebElementFacade CompaniesLabel;
	@FindBy(xpath=".//*[@title='Accounts:New']")
	WebElementFacade AccounstNewButon;
	@FindBy(xpath=".//*[@aria-label='Pick Resource:OK']")
	WebElementFacade PickMSISDNOKButton;		
	@FindBy(xpath=".//*[@title='Pick Promotion:OK']")
	WebElementFacade PickpromotionOKButton;
	@FindBy(xpath=".//*[contains(@aria-label,'More Info')]/following::*[text()='Accounts']")
	WebElementFacade ContactsAccountsTab;		
	@FindBy(xpath=".//*[@id='1_s_3_l_Account_Number']")
	WebElementFacade AccNoElement;		
	@FindBy(xpath=".//*[@name='Account_Number']")
	WebElementFacade AccNoTextBox;		
	@FindBy(xpath=".//*[@title='Pick Account:Cancel']")
	WebElementFacade AccNoCancelButton;
	@FindBy(xpath=".//*[@title ='Pick Account:OK']")
	WebElementFacade AccNoOKButton;		
	@FindBy(xpath=".//*[@id='s_at_m_1']")
	WebElementFacade MenuButton;

	@Step
	public void AccountsPrePost(String LineItemEntry) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AccountsPrePost";
		String applet = "//*[@title='Accounts List Applet']";
		String table = "//table[@summary='Query, Modify, Create Accounts related to Contacts']";   

		 Common.WaitForClock(Clockobj);
		 
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LineItemEntry, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		/*if (tableMap.get("LocateCol").size()==0){
		       	report.Info(LineItemEntry+" logical name not found in sheet.");
		       	Assert.assertTrue(false);        	
		       }*/

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
			String sClickNew = tableMap.get("ClickNew").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);
			String Index = tableMap.get("Index").get(i);
			if(Index.equals("")){
				Index="0";
			}

			String sParentAcountNo = Serenity.sessionVariableCalled("AccountNo").toString();

			if (sClickNew.equalsIgnoreCase("Yes")){
				ContactsAccountsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				ContactsAccountsTab.click();
				CompaniesLabel.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();	
				AccounstNewButon.click();	
				Thread.sleep(2000);
				 Common.WaitForClock(Clockobj);
			}
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info("Row explanded: "+sLocateCol);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
			else{
				common1.selectedRow = 1;
			}
			if (!UIName.equals("")){ 

				String sValue =  (common1.updateSiebList(applet,table, UIName, value)); 
				Thread.sleep(2000);
				 Common.WaitForClock(Clockobj);
				 
				if (UIName.contains("CaptureTextValue|Account_Number")){	
					Serenity.setSessionVariable("PrePostAccountNo").to(sValue);
				}


				if (UIName.contains("OpenPopUp|Parent")){
					//AccNoCancelButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					// Thread.sleep(3000);
					Thread.sleep(2000);
					 Common.WaitForClock(Clockobj);
					 
					AccNoElement.click();
					AccNoTextBox.typeAndEnter(sParentAcountNo);
					Thread.sleep(1000);
					AccNoOKButton.click();
					
					Thread.sleep(2000);
					 Common.WaitForClock(Clockobj);
					MenuButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					
					MenuButton.click();
					RefreshMenuItem.click();
					Thread.sleep(2000);
					 Common.WaitForClock(Clockobj);
				}	
				Thread.sleep(2000);
				report.Info("Row updated successfully"); 
				
				if (UIName.contains("OpenPopUp|StreetAddress")){
					applet = "//*[@title='Add Address List Applet']";
				   	table = "//table[@summary='Add Address']"; 
					
					//AddressPopUp.click();
    				Thread.sleep(4000);	   	    		
    				Common.selectedRow = 1;
    				
					Common.updateSiebList(applet,table, "Text|Status", "Validated");   					
					AddressStatusElement.click();
					AddressStatusTextBox.sendKeys(Keys.ENTER);
					
					if (AddressStatusTextBox.isCurrentlyVisible() ) {
						AddressStatusTextBox.sendKeys(Keys.ENTER); //for chrome
					}
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				AddAddress.click();
    				Thread.sleep(1000);
    				AddressOKButton.click();
    				Thread.sleep(2000);
    			}
			}
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Common.WaitForClock(Clockobj);
	}	

	public void VerifyAttributesTab(String Action) throws InterruptedException, IOException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "ProductServices";
		String applet = "//*[@title='Attributes List Applet']";
		String table = "//table[@summary='Asset Mgmt - Asset XA List']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("LocateCol").size()==0){
			report.Info(Action+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}


		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);

			String indexValue = "0";

			if (indexValue.equals("")){
				indexValue = "0";
			}

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info("Row explanded: "+sLocateCol);
				//common1.updateSiebList(applet,table, UIName, value);
				//report.Info("Row updated: "+UIName);
			}
			else{
				common1.selectedRow = 1;
			}
			if (!sUIName.equals("")){                                              
				common1.updateSiebList(applet,table, sUIName, sValue);
				Thread.sleep(1000);
				report.Info("Row updated successfully"); 
				//RefreshRecord.click();
				Thread.sleep(2000);
			}
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}
	@FindBy(xpath=".//*[@title='Bulk Modify Menu']")
	WebElementFacade BulkModifyMenuIcon;
	@FindBy(xpath=".//ul[@id='s_at_m_1-menu']/li[41]/a")
	WebElementFacade BulkModifyMenuModify;
	@FindBy(xpath=".//*[@title='Bulk Modify:Modify']")
	WebElementFacade BulkModifyModifyButon;
	@FindBy(xpath=".//ul[@id='s_at_m_1-menu']/li[9]/a")
	WebElementFacade BulkModifyRunQuery;
	@FindBy(xpath="//span/ul/li[9]/a")
	WebElementFacade BulkModifyRefreshMenuItem;
	@FindBy(xpath="//span/ul/li[31]/a")
	WebElementFacade Cascademenu;
	public void MenuBulkModify(String rowname) throws InterruptedException, IOException, FindFailed, AWTException{

		String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
		String applet = "//*[@title='Bulk Modify List Applet']";
		String table = "//table[@summary='Bulk Modify']";
		String dataSheet = "MenuBulkModify";
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("LocateCol").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}



		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {

			String sMenuItem =  tableMap.get("MenuItem").get(i);
			String sModify =  tableMap.get("Modify").get(i);                  
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sIndex = tableMap.get("Index").get(i);
			if(sIndex.equals("")){
				sIndex="0";
			}
			if (sLocateColValue.equals("RootProduct0")){
				sLocateColValue = Serenity.sessionVariableCalled("RootProduct0").toString();
			}

			String LocateColMessege = sLocateCol+"Not Found";
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));                     
				report.Info(sLocateCol+"Customer summary applet found using Locate Col");  
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
			else{
				common1.selectedRow = 1;
				report.Info("Customer summary applet found");
			}
			Common.waitForPageLoad(getDriver());
			BulkModifyMenuIcon.waitUntilClickable();
			BulkModifyMenuIcon.click();
			Thread.sleep(2000);
			BulkModifyRefreshMenuItem.click();
			Thread.sleep(2000);
			BulkModifyMenuIcon.click();
			Thread.sleep(2000);
			Cascademenu.click();
			Thread.sleep(2000);
			report.Info("Menu item selecteed successfully");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if(sModify.equalsIgnoreCase("yes")){
				BulkModifyModifyButon.isVisible();
				BulkModifyModifyButon.waitUntilClickable();
				BulkModifyModifyButon.click();
				Thread.sleep(2000);
				sikuliUtility.ClickFraudRiskAlert(SikulifilePath);
				report.Info("Modify done sesuccessfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			BulkModifyMenuIcon.waitUntilClickable();
			BulkModifyMenuIcon.click();
			Thread.sleep(2000);
			BulkModifyRunQuery.click();
			Thread.sleep(2000);
		}
	}

	
	@FindBy(xpath=".//*[@class='siebui-icon-pick']")
	WebElementFacade TargetPromotionIcon;
	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade AllpromotionPickList;
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElementFacade TargetPromotionTextBox;
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']/parent::span/following-sibling::*/button")
	WebElementFacade AllPromotionGobutton;
	@FindBy(xpath=".//*[@aria-label='All Promotions:OK']")
	WebElementFacade AllPromotionOKbutton;
	@FindBy(xpath=".//button[@aria-label='Bulk Modify:NLFL']")
	WebElementFacade NLFLButton;
	
	public void BulkModify_TargetPromotion_AllPromotions() throws IOException, AWTException, InterruptedException{

		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "BulkModify";
		
		/*Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0  ;i < tableMap.get("RowNo").size();i++){
			String sRefresh= tableMap.get("Refresh").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);*/
			String sIndex = "";
			
			String applet = "//*[@title='All Promotions List Applet']";
			String table = "//table[@summary='All Promotions']"; 
			
			String sPromotionName=Serenity.sessionVariableCalled("ProductName").toString();
			
			if(sIndex.equals("")){
				sIndex="0";
			}
		
		for (int i = 0;i<5;i++) {
				Thread.sleep(5000);
				
		if(AllpromotionPickList.isVisible()){
			
			TargetPromotionTextBox.click();
			TargetPromotionTextBox.sendKeys(sPromotionName);
			Thread.sleep(2000);
			AllPromotionGobutton.click();
			Thread.sleep(30000);
			break;
		}}
	
	
		if (TargetPromotionTextBox.isCurrentlyVisible()) {
			Thread.sleep(5000);
			
					
			int AppletListRowCount = findAll(By.xpath("//table[@class='ui-jqgrid-btable']/tbody/tr")).size();
			if (AppletListRowCount>1){
			
				common1.selectedRow = -1;    
				Common.locateColumn(applet,table, "Name", "sPromotionName", sIndex);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								               
			}
			else{
				common1.selectedRow = 1;
			}
			
			if (AllPromotionOKbutton.isCurrentlyVisible()){
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				AllPromotionOKbutton.click();
			}
			
      }
		else{
			report.Info("TargetPromotion TextBox is not visible");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    }
		
		
		}
	
	
	
	@FindBy(xpath=".//*[@aria-label='Account Details:Query']")
	WebElementFacade Query;       	
	@FindBy(xpath=".//*[@aria-labelledby='Customer_Code_Label']")
	WebElementFacade AccountNumber;
	@FindBy(xpath=".//*[@title='Account Details:Go']")
	WebElementFacade Go;
	@FindBy(xpath=".//a[@name='Name']") 
	WebElementFacade accountName;

	public void SearchAccountPrePost(String AccountNo) throws IOException, AWTException, InterruptedException{
		String sAccountNo = Serenity.sessionVariableCalled("PrePostAccountNo").toString();

		AccountsTab.waitUntilEnabled();
		AccountsTab.click();
		Query.waitUntilEnabled();
		Query.click();
		AccountNumber.waitUntilEnabled();
		if (sAccountNo.equals("")){
			sAccountNo = Serenity.sessionVariableCalled("PrePostAccountNo").toString();
			AccountNumber.type(sAccountNo);
		}
		else{
			AccountNumber.type(sAccountNo);
		}

		Go.waitUntilEnabled();
		Go.click();
		Common.waitForPageLoad(getDriver());
		//accountName.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
		//Thread.sleep(3000);
		accountName.click();
		//AccountSummaryTab.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@FindBy(xpath="(.//span[@aria-label='Multiple Selection Field'])[1]")
	WebElementFacade AddressPopUp;
	@FindBy(xpath="//*[@title='Add Address:Cancel']")
	WebElementFacade AddressCancel;           
	@FindBy(xpath="//*[@title='Account Addresses:Add >']")
	WebElementFacade AddAddress;          
	@FindBy(xpath="   .//*[@id='1_s_12_l_Postal_Code']")
	WebElementFacade PostCodeElemnt; 
	@FindBy(xpath="   .//*[@id='1_Postal_Code']")
	WebElementFacade PostCodeTxtBox; 
	@FindBy(xpath=".//span[@class='siebui-popup-button']/button[@title='Account Addresses:OK']")
	WebElementFacade AddrssOKButton;
	@FindBy(xpath="//input[@name='Status']")
	WebElement AddressStatus;
	@FindBy(xpath=".//*[contains(@aria-describedby,'Status')]")
	WebElement AddressStatusElement;
	@FindBy(xpath=".//*[contains(@aria-describedby,'Status')]/input")
	WebElementFacade AddressStatusTextBox;
	@FindBy(xpath=".//*[@aria-label='Validate']")
	WebElement Validate;
    @FindBy(xpath=".//*[@aria-label='Addresses']")
	WebElement Addresses;
	
	public void Accounts_AddressLine() throws InterruptedException{
		String applet = "//*[@title='Add Address List Applet']";
		String table = "//table[@summary='Add Address']"; 
		String sEnv = Serenity.sessionVariableCalled("Env").toString(); 
		
		AddressPopUp.click();
		Thread.sleep(4000);                       
		Common.selectedRow = 1;
		Common.updateSiebList(applet,table, "Clear|Status", "Validated");
		Common.updateSiebList(applet,table, "Text|Status", "Validated");   					
		AddressStatusElement.click();
		AddressStatusTextBox.sendKeys(Keys.ENTER);
		
		if (!sEnv.equalsIgnoreCase("SUP02")) {
			AddressStatusTextBox.sendKeys(Keys.ENTER); //for chrome
		}
		
		AddAddress.click();
		Thread.sleep(1000);
		AddressOKButton.click();

	}
	
	public void NotValidatedAccounts_AddressLine() throws InterruptedException{
		String applet = "//*[@title='Add Address List Applet']";
		String table = "//table[@summary='Add Address']"; 

		AddressPopUp.click();
		Thread.sleep(4000);                       
		Common.selectedRow = 1;
		Common.updateSiebList(applet,table, "Clear|Status", "Validated");
		Common.updateSiebList(applet,table, "Text|Status", "Not Validated");   					
		AddressStatusElement.click();
		AddressStatusTextBox.sendKeys(Keys.ENTER);
		AddressStatusTextBox.sendKeys(Keys.ENTER); //for chrome
		AddAddress.click();
		Thread.sleep(1000);
		AddressOKButton.click();

		if(isAlertPresent(getDriver())){
			Alert alert=getDriver().switchTo().alert();                        
			String ActAlertText=alert.getText();
			if (ActAlertText.contains("The address")){
				//sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				alert.accept();
			}
			}
		Thread.sleep(2000);
		Addresses.click();
		Thread.sleep(3000);
		Validate.click();
	}
	

	@FindBy(xpath="(.//*[@aria-label='Selection Field'])[12]")
	WebElementFacade NewBillAccountPopUp;
	@FindBy(xpath=".//button[@aria-label='Pre to Post Migration:OK']")
	WebElementFacade PromotionOKButton;
	@FindBy(xpath="(.//*[@aria-label='Selection Field'])[13]")
	WebElementFacade NewBillProfPopUp;      
	@FindBy(xpath="(.//*[@aria-label='Selection Field'])[13]")
	WebElement NewBillProfPopUpWebElement;     
	@FindBy(xpath="(.//*[@aria-label='Selection Field'])[14]")
	WebElementFacade TargetPromotionPopUp;   
	@FindBy(xpath=".//*[@id='1_Account_Number']")
	WebElementFacade AccountNoTextBox;          	
	@FindBy(xpath="//*[@title='Pick Account:OK']")
	WebElementFacade AccountNoOKButton;          	
	@FindBy(xpath="//*[@title='Pick Account:Cancel']")
	WebElementFacade AccountNoCancelButton;      
	@FindBy(xpath="//*[@title='Pick Account:Cancel']")
	WebElement AccountNoCancelButtonWebElement;  
	@FindBy(xpath=".//*[@title='Pick Billing Profile:OK']")
	WebElementFacade BillingProfOKButton;          	
	@FindBy(xpath="//*[text()='Billing profile']")
	WebElementFacade BillingProfileLabel;        	
	@FindBy(xpath="//*[@title='Next record']")
	WebElementFacade TargetPromNextRecordButton;        	
	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade PromotionNameList;     
	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElement PromotionNameListWebElement; 
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElementFacade PromotionNameTextBox;        	
	@FindBy(xpath="//*[contains(@title,'Continue')]")
	WebElementFacade ContinueButton;    	
	@FindBy(xpath=".//*[@id='1_s_12_l_Account_Number']")
	WebElementFacade AccountNoElement;  
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElement PromotionNameTextBoxWebElement; 
	@FindBy(xpath="//*[contains(@title,'Continue')]")
	WebElement ContinueButtonWebElement; 
	@FindBy(xpath="(//*[contains(@title,'Migration:Go')])[2]")
	WebElement GoButtonPrePost;
	@FindBy(xpath=".//a[text()='Line Items']")
	WebElement LineItemsTabWebElement;

	public void PrePost_Upgrade() throws InterruptedException, IOException, AWTException{
		String sStartingWith = Serenity.sessionVariableCalled("ProductName").toString();
		String sAccountNo = Serenity.sessionVariableCalled("PrePostAccountNo").toString();
		String applet = "//*[@title='Installed Assets List Applet']";
		String table = "//table[@summary='Pick Account']";
		String sUIName = "List|Account_Number";
		String sValue = sAccountNo;

		NewBillAccountPopUp.click();
		// AccountNoCancelButton.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable(); 
		Common.waitForElement(AccountNoCancelButtonWebElement);
		/*  common1.selectedRow = 1;

                 if (!sUIName.equals("")){               
                    common1.updateSiebList(applet,table, sUIName, sValue);   
                 }*/
		AccountNoElement.click();
		AccountNoTextBox.typeAndEnter(sAccountNo);
		AccountNoOKButton.click();
		Common.waitForElement(NewBillProfPopUpWebElement);            
		//  NewBillProfPopUp.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
		NewBillProfPopUp.click();
		//BillingProfOKButton.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		BillingProfOKButton.click();
		//TargetPromotionPopUp.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		TargetPromotionPopUp.click();
		//TargetPromNextRecordButton.withTimeoutOf(80,TimeUnit.SECONDS).waitUntilClickable();    
		Common.waitForPageLoad(getDriver());
		Thread.sleep(1000);
		Common.waitForElement(PromotionNameListWebElement); 
		Thread.sleep(2000);
		/*PromotionNameList.clear();
        		Thread.sleep(1000);
        		Common.waitForElement(PromotionNameListWebElement);

        		PromotionNameList.sendKeys("Promotion Name");
        		Thread.sleep(2000);
        		Common.waitForElement(PromotionNameTextBoxWebElement);
        		PromotionNameTextBox.sendKeys(sStartingWith);
        		Thread.sleep(2000);*/
		Common.waitForElement(PromotionNameTextBoxWebElement);
		JavascriptExecutor JSE = (JavascriptExecutor)getDriver();
		JSE.executeScript("arguments[0].value = '"+sStartingWith+"';", PromotionNameTextBox);
		Thread.sleep(1000);
		PromotionNameTextBox.click();
		GoButtonPrePost.click();
		Thread.sleep(5000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		
		int PromotionPrePostMigrationTableSize= findAll(By.xpath("//table[@summary='Pre to Post Migration']/tbody/tr")).size();


		if(!ContinueButton.isVisible()) {

			Common.selectedRow = -1;
			//Commenting this code as clash with CTR13 promotions 	is not there anymore
			Assert.assertTrue(Common.locateColumn(applet,table,"Target_Promotion_Name",sStartingWith, "0").equals("true"));
			report.Info("Promotions are available");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Thread.sleep(3000);
			PromotionOKButton.click();
		}
		else{
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Assert.assertTrue("No rows displayed after clicking on Go button- Promotions not available", ContinueButton.isVisible());
		}

		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


		//	ContinueButton.waitUntilClickable();
		Common.waitForElement(ContinueButtonWebElement);
		ContinueButton.click();
		Thread.sleep(2000);
		//PromotionOKButton.click();
		Thread.sleep(5000);
		Common.waitForElement(LineItemsTabWebElement);
		if(isAlertPresent(getDriver())){
			Alert alert=getDriver().switchTo().alert();                        
			String ActAlertText=alert.getText();
			if (ActAlertText.contains("A commitment has been broken")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				alert.accept();
			}
			/* else (!ActAlertText.contains("A commitment has been broken")){

                        }
			 */                                                            

		}   
		//ContinueButton.waitUntilClickable();
		//ContinueButton.click();

		//LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                  
		//Thread.sleep(30000);
		//LineItemsTab.waitUntilClickable();
		if (!LineItemsTab.isCurrentlyEnabled()){
			ContinueButton.click();
			// LineItemsTab.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());

		}

	}  

	@FindBy(xpath=".//*[@title='Import Dialog:OK']")
	WebElementFacade ImportDialogOkButton;

	public void BulkModify_TargetPromotionProcess_ImportDialog(String rowname) throws InterruptedException, IOException, AWTException{

		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String applet = "//*[@title='Import Dialog List Applet']";
		String table = "//table[@summary='Import Dialog']";
		String dataSheet = "BulkModify";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("LocateCol").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {


			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sIndex = tableMap.get("Index").get(i);
			if(sIndex.equals("")){
				sIndex="0";
			}
			String LocateColMessege = sLocateCol+"Not Found";
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));                     
				report.Info(sLocateCol+"Customer summary applet found using Locate Col"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{
				common1.selectedRow = 1;
			}  
			ImportDialogOkButton.waitUntilClickable();
			ImportDialogOkButton.click();
			report.Info("Target Promotion Process is done successfully");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}

	}  

	
	@FindBy(xpath=".//*[@class='siebui-icon-pick']")
	WebElementFacade TargetDeviceIcon;
	@FindBy(xpath=".//*[@aria-label='Products:OK']")
	WebElementFacade ProductOk;
	@FindBy(xpath=".//table[@summary='Products']")
	WebElementFacade ProductsApplet;
	@FindBy(xpath=".//*[@aria-label='Products:Query']")
	WebElementFacade ProductsQuery;

	
	
	

	public void BulkModify_TargetDevice_Handset() throws IOException, AWTException, InterruptedException{
		
		String applet = "//*[@title='Products List Applet']";
		String table = "//table[@summary='Products']"; 
		
		if(ProductsApplet.isVisible()){
			Thread.sleep(2000);
			ProductsQuery.click();
			Common.selectedRow = 1;
			Common.updateSiebList(applet,table, "List3|Product_Id", "080011");
			Thread.sleep(2000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            ProductOk.click();
			Thread.sleep(2000);
			report.Info(" Pass: Handset is selected successfully");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
		
		else{
			Assert.assertTrue("Fail: Products Applet is not visible",ProductsApplet.isVisible()); 
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}

	}
		

	@FindBy(xpath = ".//*[@aria-label='Third Level View Bar']")
	WebElementFacade AccountDropDown;
	@FindBy(xpath = ".//*[@aria-label='Media Type:New']")
	WebElementFacade CreateNewMediaType;
	@FindBy(xpath =".//input[@name='Media_Type']")
	WebElementFacade MediaTypeList;
	@FindBy(xpath =".//*[@aria-label='Media Type:Delete']")
	WebElementFacade DeleteMediaTypeButton;


	public void AddDeleteMedia(String LogicalName) throws InterruptedException, IOException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AddDeleteMedia";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("EX").size()==0){
			report.Info(LogicalName+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("EX").size();i++) {
			String sMediatype = tableMap.get("MediaType").get(i);

			String sAction = tableMap.get("Action").get(i);
			String sPopup = tableMap.get("Popup").get(i);

			Thread.sleep(30000);


			if(ProfilesTab.isDisplayed()){
				ProfilesTab.click();
			}
			else{
				AccountDropDown.selectByVisibleText("Profiles");
			} 
			Common.waitForPageLoad(getDriver());
			//Thread.sleep(6000);
			//    CreateNewMediaType.click();

			if(sAction.equalsIgnoreCase("Delete")){


				int RowCount = findAll(By.xpath("//table[@summary='Media Type']/tbody/tr")).size();


				for (int x=0;x<RowCount-1;x++) {

					CreateNewMediaType.click();
					Thread.sleep(3000);
					MediaTypeList.type(sMediatype);
					Thread.sleep(3000);

					if(RowCount>=1){

						Assert.assertTrue("Delete Button is not Enabled", DeleteMediaTypeButton.isEnabled()); 
						//DeleteMediaTypeButton.isEnabled();
						DeleteMediaTypeButton.click();      

					}


					Alert alert=getDriver().switchTo().alert();
					String ActAlertText=alert.getText();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					System.out.println("alert messsage is"+ActAlertText);
					if(ActAlertText.contains(sPopup)){
						alert.accept();
					}
				}

			}

		}    
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  			   

	}
	@FindBy(xpath="(.//*[@title='Customer Comms'])[1]/parent::a")
	WebElementFacade CustomerComms;
	@FindBy(xpath=".//*[@title='Visibility']/select")
	WebElementFacade CustomerCommsDropDown;
	@FindBy(xpath=".//*[@aria-label='Customer Comms List:Menu']")
	WebElementFacade AccountSummaryMenuIcon;
	@FindBy(xpath=".//*[text()='Customer Comm List']")
	WebElementFacade CustomerCommsList;


	@Step
	public void ValidateUpdatedByField(String rowname) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "ValidateUpdateByAllCustComms";
		String applet = "";
		String table = "";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("View").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("View").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			//String UIName  = tableMap.get("UIName").get(i);
			//String value  = tableMap.get("Value").get(i);
			String Apletview = tableMap.get("Apletview").get(i);
			String sView = tableMap.get("View").get(i);


			String indexValue = "0";

			if(Apletview.equalsIgnoreCase("Yes"))
			{
				applet = "//*[@title='Customer Comms List List Applet']";
				table = "//table[@summary='Customer Comms List']";
			}else if(Apletview.equalsIgnoreCase("activites")){
				applet = "//*[@title='Activities List Applet']";
				table = "//table[@summary='Activities']";
			}else{
				applet = "//*[@title='Activities List Applet']";
				table = "//table[@summary='Order Dashboard Details']";
			}

			if(!sView.equalsIgnoreCase("")){

				if(sView.equalsIgnoreCase("AccountSummaryCustComms")){
					//AccountSummaryTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();  
					Common.waitForPageLoad(getDriver());
					AccountSummaryTab.click();
					//AccountSummaryMenuIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					Common.waitForPageLoad(getDriver());
					report.Info("Customer comms List applet is present");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}else
				{

					if (CustomerComms.isCurrentlyVisible()){
						CustomerComms.click();  
					}
					else if (!CustomerComms.isCurrentlyVisible()){
						//Dropicon.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
						Common.waitForPageLoad(getDriver());
						Dropicon.selectByVisibleText("Customer Comms");
						// Thread.sleep(30000);
						//Common.waitForPageLoad(getDriver());

					}
					CustomerCommsList.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
					CustomerCommsDropDown.selectByVisibleText(sView);
					//Thread.sleep(4000);
					Common.waitForPageLoad(getDriver());

				}
			}
			Common.WaitForClock(Clockobj);
			String LocateColMessage = sLocateColValue+" Not Found";
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessage, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info("Updated By field is present on customer comms view");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

		}

	}

	@FindBy(xpath=".//*[@aria-label='First Level View Bar']")
	WebElementFacade Dropicon;
	@FindBy(xpath=".//*[text()='Customer Comm List']")
	WebElementFacade CustomerCommList;

	@Step
	public void ValidateCustComms(String rowname) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "ValidateCustComms";
		String applet = "";
		String table = "";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);


		if (tableMap.get("View").size()==0){
			report.Info(rowname+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}


		for (int i = 0;i < tableMap.get("View").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName  = tableMap.get("UIName").get(i);
			String value  = tableMap.get("Value").get(i);
			String Apletview = tableMap.get("Apletview").get(i);
			String sView = tableMap.get("View").get(i);


			String indexValue = "0";

			if(Apletview.equalsIgnoreCase("Yes"))
			{
				applet = "//*[@title='Customer Comms List List Applet']";
				table = "//table[@summary='Customer Comms List']";
			}else if(Apletview.equalsIgnoreCase("activites")){
				applet = "//*[@title='Activities List Applet']";
				table = "//table[@summary='Activities']";
			}else{
				applet = "//*[@title='Activities List Applet']";
				table = "//table[@summary='Order Dashboard Details']";
			}

			if(!sView.equalsIgnoreCase("")){

				if(sView.equalsIgnoreCase("AccountSummaryCustComms")){
					AccountSummaryTab.isDisplayed();
					AccountSummaryTab.click();
					report.Info("Customer comms List apllet is present");
				}else if(CustomerComms.isVisible())
				{
					//CustomerComms.isDisplayed();
					//CustomerComms.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
					Common.waitForPageLoad(getDriver());
					CustomerComms.click();
					Common.waitForPageLoad(getDriver());
					//Thread.sleep(10000);
					CustomerCommsDropDown.selectByVisibleText(sView);
					Common.waitForPageLoad(getDriver());
					//Thread.sleep(6000);

				}else{
					Common.waitForPageLoad(getDriver());
					// Dropicon.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
					Dropicon.selectByVisibleText("Customer Comms");
					//Thread.sleep(30000);
					Common.waitForPageLoad(getDriver());
					CustomerCommList.click();
					Common.waitForPageLoad(getDriver());
					CustomerCommsDropDown.selectByVisibleText(sView);
					Thread.sleep(6000);
				}
			}

			String LocateColMessege = sLocateCol+"Not Found";
			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info("Account Name is present on customer comms view");
			}

		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

	}


	@FindBy(xpath=".//*[@title='Account Details:SecureNet Care Portal']")
	WebElementFacade SecureNetCarePortalButton;
	@FindBy(xpath=".//*[@id='s_vctrl_div_tabScreen']/ul/li[10]/a")
	WebElementFacade OrdersTab;

	@Step
public void SecureNetPortalValidation() throws InterruptedException, IOException, AWTException{

		if (AccountSummaryTab.isCurrentlyVisible()){
			AccountSummaryTab.click();	    		   
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Account Summary");	   			
		} 
		report.Info("Navigated to Account Summary page");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		SecureNetCarePortalButton.isDisplayed();
		report.Info("SecreNet care Portal is present under Account summary page");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Common.waitForPageLoad(getDriver());
		//SecureNetCarePortalButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		//SecureNetCarePortalButton.click();
		//Thread.sleep(2000);
		//String winHandleBefore = getDriver().getWindowHandle();
		Thread.sleep(5000);	
	/*	for (String WinHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(WinHandle);				
		}
	Set<String> windowhadle =  getDriver().getWindowHandles();

		System.out.println("*****Handles are*******");
		String handle[]=new String[windowhadle.size()];
		int j=0;
		for(String s:windowhadle)
		{
			System.out.println(s);
			handle[j]=s;
			j++;

		}
		//switch driver focus from parent window to child window
		getDriver().switchTo().window(handle[1]);
		getDriver().close();
		getDriver().switchTo().window(handle[0]);*/


		report.Info("SecreNet care Portal clicked successfully");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Thread.sleep(2000);
		if(OrdersTab.isPresent()){
			OrdersTab.click();
		}else{
			AccountTabsDRopDown.selectByVisibleText("Orders");
		}
		report.Info("Navigated to Order Summary page");
		SecureNetCarePortalButton.isDisplayed();
		report.Info("SecreNet care Portal is present under Account summary page");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		SecureNetCarePortalButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		//SecureNetCarePortalButton.click();
		Thread.sleep(2000);

		/*for (String WinHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(WinHandle);				
		}
		
		Set<String> windows =  getDriver().getWindowHandles();

		String Windowhadles[]=new String [windows.size()];
		int k=0;
		for(String s:windows)
		{
			System.out.println(s);
			Windowhadles[k]=s;
			k++;

		}

		getDriver().switchTo().window(Windowhadles[1]);
		getDriver().close();
		getDriver().switchTo().window(Windowhadles[0]);*/
		report.Info("SecreNet care Portal clicked successfully");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	}

	//payel  
	@FindBy(xpath="(.//a[text()='Service Requests'])[2]")
	WebElementFacade ServiceRequestsTab;
	@FindBy(xpath=".//button[@aria-label='Service Requests:New']")
	WebElementFacade NewButtonSR;
	@FindBy(xpath=".//td[contains(@aria-labelledby,'SR_Type')]")
	WebElementFacade SRTypeTextBox;
	@FindBy(xpath=".//*[@class='siebui-icon-dropdown']")
	WebElementFacade SRTypeDropDown;
	@FindBy(xpath=".//*[@aria-label='Pick Asset:OK']")
	WebElementFacade OKButtonPickAssetApplet;
	@FindBy(xpath=".//*[@aria-label='Service Requests:Menu']")
	WebElementFacade MenuButtonSR;
	@FindBy(xpath="(.//td[contains(@id,'Status')])[1]")
	WebElementFacade SRStatusTextBox;
	@FindBy(xpath="//span/ul/li[1]/a")
	WebElementFacade SRUndo;  		
	@FindBy(xpath=".//*[contains(text(),'Halo - please read')]")
	WebElementFacade ErrorTitleBox;
	@FindBy(xpath=".//div[contains(@class,'popup-info')]  ")
	WebElementFacade ErrorMsg; 
	@FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
	WebElementFacade ErrorOkButton;

	@FindBy(xpath=".//*[@aria-label='Pick Service Request Owner:OK']")
	WebElementFacade OKButtoninPickOwner;
	@FindBy(xpath="(.//*[@aria-label='Pick Service Request Owner:Go'])[1]")
	WebElementFacade GoButtoninPickOwner;	    
	@FindBy(xpath=".//*[@aria-label='Pick Service Request Owner:Query']")
	WebElementFacade QueryButtoninPickOwner;
	@FindBy(xpath=".//*[@name='Last_Name']")
	WebElementFacade LastNameTextBox;
	@FindBy(xpath="(.//*[@aria-label='Pick Asset:OK'])")
	WebElementFacade SelectID;



	public void CreateServiceRequestviaAccount(String Action) throws InterruptedException, IOException, AWTException{

		ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.WaitForClock(Clockobj);
		//Common.waitForPageLoad(getDriver());
		if (ServiceRequestsTab.isCurrentlyVisible()){
			ServiceRequestsTab.click();
			Thread.sleep(1000);
			Common.WaitForClock(Clockobj);
			NewButtonSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Service Requests");
			Thread.sleep(1000);
			Common.WaitForClock(Clockobj);
			NewButtonSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		}
		Common.WaitForClock(Clockobj);
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "CreateNewServiceRequest";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Row").size()==0){
			report.Info(Action+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("Row").size();i++) {
			String sValue = tableMap.get("Value").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sSelectMenu = tableMap.get("SelectMenu").get(i);
			String sClickNew = tableMap.get("ClickNew").get(i);
			String Validate = tableMap.get("Validate").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sButton = tableMap.get("Button").get(i);
			Alert alert;
			String ActAlertText="";

			String applet = "//*[@title='Service Requests List Applet']";
			String table = "//table[@summary='Service Request List ( Account )']";

			if (sClickNew.equalsIgnoreCase("Yes")){
				NewButtonSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				NewButtonSR.click();
				Thread.sleep(1000);
				MenuButtonSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable(); 
				Thread.sleep(1000);
				SRStatusTextBox.click();
				//SRTypeTextBox.click();
				SRTypeDropDown.click();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Info, LOVs in SR Type drop down");
				SRStatusTextBox.click();

			}

			if(Validate.equalsIgnoreCase("Disabled")){
				String FieldtoValidate = tableMap.get("UIName").get(i);
				String ElementXpath = ".//table[@summary='Service Request List ( Account )']/tbody/tr/following::td[contains(@id,'"+sValue+"')][1]";

				String TextXpath = ".//table[@summary='Service Request List ( Account )']/tbody/tr/following::td[contains(@id,'"+sValue+"')][1]/input";


				getDriver().findElement(By.xpath(ElementXpath)).click();
				String readonlyValue =getDriver().findElement(By.xpath(TextXpath)).getAttribute("aria-readonly");
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(readonlyValue.equalsIgnoreCase("true")){
					report.Info("The field "+FieldtoValidate+"is disabled as expected"); 
					return;
				}
				else{
					Assert.assertTrue("The field "+FieldtoValidate+"is not disabled as expected",readonlyValue.equalsIgnoreCase("true"));
					return;
				}
			}

			if (sSelectMenu.equals("")){	 			             
				common1.selectedRow = 1;

				if (!sUIName.equals("")){
					if (sUIName.contains("Initial_Complaint_Date")){
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date currentDate = new Date();
						String scurrentDate = dateFormat.format(currentDate);
						// convert date to calendar
						Calendar cal = Calendar.getInstance();
						cal.add(Calendar.DATE,-56);
						Date BackDate = cal.getTime();
						sValue = dateFormat.format(BackDate);

					}

					common1.updateSiebList(applet,table, sUIName, sValue); 
					Thread.sleep(4000); 
					SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				if (sUIName.contains("CTN")){
					Thread.sleep(2000);
					OKButtonPickAssetApplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					OKButtonPickAssetApplet.click();

				} 
				
				if(sUIName.equalsIgnoreCase("OpenPopUp|Asset_Number")){
					SelectID.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();

					/*applet = "//*[@title='Pick Service Request Owner List Applet']";
					table = "//table[contains(@summary,'Pick Service Request Owner')]";*/
					Thread.sleep(2000);
					SelectID.click();	
					
				}
				
				
				if(sUIName.equalsIgnoreCase("OpenPopUp|Owner")){
					QueryButtoninPickOwner.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();

					applet = "//*[@title='Pick Service Request Owner List Applet']";
					table = "//table[contains(@summary,'Pick Service Request Owner')]";

					QueryButtoninPickOwner.click();	
					//LastNameTextBox.type(sValue);
					common1.updateSiebList(applet,table, "Text|Last_Name",sValue);
					GoButtoninPickOwner.click();

					int PickOwnerTableSize= findAll(By.xpath("//table[@summary='Pick Service Request Owner']/tbody/tr")).size();
					if(PickOwnerTableSize>1){
						report.Info("Owner available: "+sValue);
					}
					else{
						SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Assert.assertTrue("No rows displayed after clicking on Go button- Owner: "+sValue+ " not available", PickOwnerTableSize>1);
					}
					SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					OKButtoninPickOwner.click();
				}
				if (!sPopup.equals("")){
					Thread.sleep(1000);
					if(isAlertPresent(getDriver())){
						alert=getDriver().switchTo().alert();
						ActAlertText=alert.getText();  
						SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                                                
						if (ActAlertText.contains(sPopup)){   

							alert.accept();
							report.Info("Pop did occurred : " +ActAlertText);
						}
						else {
							report.Info("Pop did not occur");
							Assert.assertTrue(false);
						}


						if ((sValue.equalsIgnoreCase("Payments"))||(sValue.equalsIgnoreCase("Customer Relations"))){
							SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							report.Info("Info, Service Request created ");
						} 	    	 
					} 
					//Common.HandleErrorPopUp(sPopup);
					if(ErrorTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ErrorMsg.getText();
						if(ErrorInfo.contains(sPopup)){	
							SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							ErrorOkButton.click();
							report.Info("The alert message is:"+ErrorInfo);
						}
						else{
							report.Info("The alert message not found:"+ErrorInfo);
							Assert.assertTrue(false);
						}
					}
				}

				if (sButton.equalsIgnoreCase("Undo Button")){
					Thread.sleep(1000);
					MenuButtonSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					MenuButtonSR.click();
					Thread.sleep(1000);
					SRUndo.click();
					report.Info("Info, Service Request deleted ");	    		
				}
			}
			else{
				SRTypeDropDown.click();  
				List<WebElement> options = getDriver().findElements(By.xpath(".//div[@title='Service Account List']/ul[@role='combobox']/li")); 	        
				List<String> text = new ArrayList<String>();

				for(int j=0; j<options.size(); j++) {
					text.add(options.get(j).getText());

				} 
				Boolean  flag = false;
				Iterator<String> itr = text.iterator();
				while(itr.hasNext()) {

					String currentValue= itr.next();
					if (!currentValue.equalsIgnoreCase("Customer Relations")){ 
						flag = true;	
					}  					 	         
				}
				Assert.assertTrue("Customer Relations found in list",flag);
				report.Info("Info, Customer Relations not found in list");
			}

		}
	}

	@FindBy(xpath=".//button[@aria-label='Service Request:New']")
	WebElementFacade NewButtonSRinAccountSummary;
	@FindBy(xpath=".//*[@aria-labelledby='s_5_l_Type s_5_l_altCombo']")
	WebElementFacade SRTypeTextBoxinAccountSummary;
	@FindBy(xpath=".//*[@class='siebui-icon-dropdown']")
	WebElementFacade SRTypeDropDowninAccountSummary;
	@FindBy(xpath=".//*[text()='Pick Service Request Owner']//following::input[@aria-label='Find']")
	WebElementFacade OwnerPopupQueryTextBox;	
	@FindBy(xpath=".//*[text()='Pick Service Request Owner']//following::input[@aria-label='Starting with']")
	WebElementFacade OwnerPopupStartingTextBox;	
	@FindBy(xpath=".//*[@title='Pick Service Request Owner:OK']")
	WebElementFacade OwnerOKButton;
	@FindBy(xpath=".//*[@aria-label='Service Request:Menu']")
	WebElementFacade MenuButtonSRAccountSummary;
	@FindBy(xpath="(.//div[text()='Service Requests']/following::td[contains(@id,'Id')])[1]")
	WebElementFacade SRInstalledIDElement;
	@FindBy(xpath="//*[text()='Account Summary']")
	WebElement AccountSummaryTabsync; 
	@FindBy(xpath=".//*[text()='Pick Service Request Owner']//following::input[@aria-label='Find']/following-sibling::span")
	WebElement OwnerPopupDropdown; 

	@FindBy(xpath="//li[text()='User ID']")
	WebElement OwnerPopupUserID; 

	public void CreateServiceRequestviaAccountSummary(String Action) throws InterruptedException, IOException, AWTException{

		//ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable(); 
		Common.waitForElement(AccountSummaryTabsync);
		if (AccountSummaryTab.isCurrentlyVisible()){
			AccountSummaryTab.click();	    		   
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Account Summary");	   			
		} 
		Common.WaitForClock(Clockobj);
		
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "CreateNewServiceRequest";
		String applet = "//*[@title='Service Request List Applet']";
		String table = "//table[@summary='Service Requests']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("Row").size()==0){
			report.Info(Action+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("Row").size();i++) {
			String sValue = tableMap.get("Value").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sSelectMenu = tableMap.get("SelectMenu").get(i);
			String sClickNew = tableMap.get("ClickNew").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sButton = tableMap.get("Button").get(i);
			Alert alert;
			String ActAlertText="";

			if (sClickNew.equalsIgnoreCase("Yes")){
				NewButtonSRinAccountSummary.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				NewButtonSRinAccountSummary.click();
				//SRTypeTextBoxinAccountSummary.withTimeoutOf(120,TimeUnit.SECONDS).isDisplayed(); 
				Thread.sleep(4000);
				Common.WaitForClock(Clockobj);
				
				String InstalledId=SRInstalledIDElement.getAttribute("title");
				Serenity.setSessionVariable("SRInstalledID").to(InstalledId);
				report.Info("SR ID Created : "+InstalledId);

				SRTypeDropDowninAccountSummary.click();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Info, LOVs in SR Type drop down");	  
				Common.WaitForClock(Clockobj);
			}

			if (sSelectMenu.equals("")){
				Common.WaitForClock(Clockobj);
				common1.selectedRow = 1;		 	      
				if (!sUIName.equals("")){
					common1.updateSiebList(applet,table, sUIName, sValue); 
					Thread.sleep(4000);
					SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.WaitForClock(Clockobj);
				}
				if (sUIName.contains("Installed_Id")){
					Thread.sleep(1000);
					OKButtonPickAssetApplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					OKButtonPickAssetApplet.click();
					Common.WaitForClock(Clockobj);

				} 
				if (sUIName.contains("OpenPopUp|Owner")){
					Thread.sleep(1000);
					OwnerOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					OwnerPopupQueryTextBox.type("User ID");
					OwnerPopupStartingTextBox.typeAndEnter("test_agent_nba_04");
					report.Info("User login is changed from test_retail_1 to test_agent_nba_04"); 
					Common.WaitForClock(Clockobj);
				}
				
				if (sUIName.contains("OpenPopUpUsingTAB|Owner")){
					Thread.sleep(1000);
					Thread.sleep(1000);
					OwnerOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					OwnerPopupDropdown.click();
					Thread.sleep(1000);
					OwnerPopupUserID.click();
					Thread.sleep(1000);
					SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					OwnerPopupStartingTextBox.sendKeys("test_agent_nba_04");
					Thread.sleep(1000);
					OwnerPopupStartingTextBox.sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					//OwnerOKButton.click();
					SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("User login is changed from test_retail_1 to test_agent_nba_04"); 	
					Common.WaitForClock(Clockobj);
				}
				if (!sPopup.equals("")){

					if(isAlertPresent(getDriver())){
						alert=getDriver().switchTo().alert();
						ActAlertText=alert.getText();  
						SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                                                
						if (ActAlertText.contains(sPopup)){                            
							alert.accept();
							report.Info("Pop did occurred : " +ActAlertText);
						}
						else {
							report.Info("Pop did not occur");
							Assert.assertTrue(false);
						}
						Common.WaitForClock(Clockobj);
					}
					//Common.HandleErrorPopUp(sPopup);

					if(ErrorTitleBox.isCurrentlyVisible()){
						String ErrorInfo= ErrorMsg.getText();
						if(ErrorInfo.contains(sPopup)){	
							SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							ErrorOkButton.click();
							report.Info("The alert meaasage is:"+ErrorInfo);
						}
						else{
							report.Info("The alert meassage not found:"+ErrorInfo);
							Assert.assertTrue(false);
						}
						Common.WaitForClock(Clockobj);
					}

				}
				if ((sValue.equalsIgnoreCase("Payments"))||(sValue.equalsIgnoreCase("Customer Relations"))){
					report.Info("Info, Service Request created ");
					SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				if (sButton.equalsIgnoreCase("Undo Button")){
					Thread.sleep(1000);
					MenuButtonSRAccountSummary.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					MenuButtonSRAccountSummary.click();
					Thread.sleep(1000);
					SRUndo.click();
					report.Info("Info, Service Request deleted ");	    		
				}

			}     
		}

	}

	public void VerifyCustComContacts(String row) throws IOException, AWTException, InterruptedException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AddVerifyContacts";

		String applet = "//*[@title='Contacts List Applet']";
		String table = "//table[@summary='Contacts']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("RowNo").size();i++) {          
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);             
			String Index = tableMap.get("Index").get(i);

			if (Index.equals("")){
				Index = "0";
			}

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
			}
			else{               
				common1.selectedRow = 1;
			}

		}       

		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@Step      
	public void BilledProductServices(String action) throws IOException, InterruptedException, AWTException{

		Thread.sleep(5000);
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "UsedProductServices";
		String applet = "//*[@title='Installed Assets List Applet']";
		String table = "//table[@summary='SIS OM Products & Services Root List (Service) - Tiny']";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (tableMap.get("LocateCol").size()==0){
			report.Info(action+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {   

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);

			String sIndex = tableMap.get("Index").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			//String sPopUp = tableMap.get("PopUp").get(i);

			int k=0;
			if (common1.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true")){
				do{

					getDriver().navigate().refresh();
					Thread.sleep(2000);                 
					k++;
				}while(common1.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true") && (k<10));
			}

			if (sIndex.equals("")){
				sIndex = "0";
			}

			Thread.sleep(3000);

			String LocateColMessege = sLocateCol+"Not Found";             

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));                     
				report.Info(sLocateCol+" found"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}
			else{
				common1.selectedRow = 1;
			}

			if (!sUIName.equals("")){
				if (sValue.equals("AgreementRowID")){
					sValue = Serenity.sessionVariableCalled("AgreementRowID").toString();
				}//do not delete
				common1.updateSiebList(applet,table, sUIName, sValue);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
		}

	}
	@FindBy(xpath=".//*[@aria-label='Address Line 1']")
	WebElementFacade AddressLine1TextBox;
	@FindBy(xpath=".//a[text()='Billing profile']")
	WebElementFacade BillingProfileSubTab;
	public void AnonymousAddress(String action) throws IOException, AWTException, InterruptedException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AnonymousAddress";
		String applet = "";
		String table = "";
		String tab="";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Editable").size();i++) { 	  
			String sEditable = tableMap.get("Editable").get(i);
			String sExpectedAddressVal = tableMap.get("AddressValue").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);          
			String sIndex = tableMap.get("Index").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String ActualValue="";
			if(sEditable.equalsIgnoreCase("Address Line 1")){
				AddressLine1TextBox.click();
				String sAddressVal = AddressLine1TextBox.getTextValue();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(sAddressVal.equalsIgnoreCase(sExpectedAddressVal)){
					report.Info("Address Value is :"+sAddressVal+" for anonymous customer for Address Line 1 as expected.");
				}
				else{
					Assert.assertTrue("Address Value is :"+sAddressVal+" for anonymous customer but it should be :"+sExpectedAddressVal,sAddressVal.equalsIgnoreCase(sExpectedAddressVal));
				}
			}  

			if(sEditable.equalsIgnoreCase("Profiles")){
				if (ProfilesTab.isCurrentlyVisible())
				{
					ProfilesTab.click();
				}
				else
				{
					TabDropDown.selectByVisibleText("Profiles");
				} 
				BillingProfileSubTab.click();
				Thread.sleep(3000);
				applet = "//*[@title='Billing profile List Applet']";
				table = "//table[@summary='Billing profile']";
				tab="Profiles";
			}	

			if(sEditable.equalsIgnoreCase("Credit Vetting")){
				if(CreditVettingTab.isCurrentlyVisible()){
					CreditVettingTab.click();				
				}
				else{
					AccountTabsDropDown.selectByVisibleText("Credit Vetting");					
				} 
				Thread.sleep(5000);
				if(isAlertPresent(getDriver())){
					Alert alert=getDriver().switchTo().alert();
					String ActAlertText=alert.getText();

					if(ActAlertText.contains("IF A CREDIT VET IS REQUIRED"))
					{
						getDriver().switchTo().alert().accept();
						report.Info("Alert messsage is:"+ActAlertText);
					}
				}
				applet = "//*[@title='Address History List Applet']";
				table = "//table[@summary='Address History']";
				tab="Credit Vetting";
			}


			if(sEditable.equalsIgnoreCase("Addresses")){
				if(AddressesTab.isCurrentlyVisible()){
					AddressesTab.click();					
				}
				else{
					AccountTabsDropDown.selectByVisibleText("Addresses");
				}
				Common.waitForPageLoad(getDriver());
				//Thread.sleep(60000);
				applet = "//*[@title='Account Addresses List Applet']";
				table = "//table[@summary='Account Fraud Events List']";
				tab="Addresses";
			}

			if (sIndex.equals("")){
				sIndex = "0";
			}
			String LocateColMessege = sLocateCol+"Not Found";  
			if (!sLocateCol.equals("")){
				find(By.xpath(applet)).withTimeoutOf(350,TimeUnit.SECONDS).isCurrentlyVisible();
				common1.selectedRow = -1;
				Assert.assertTrue(LocateColMessege, common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));                     
				report.Info(sLocateCol+" found"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}
			else{
				common1.selectedRow = 1;
			}
			if (!sUIName.equals("")){
				ActualValue=  common1.updateSiebList(applet,table, sUIName, sValue); 
				Thread.sleep(4000); 	 
				if(sEditable.equalsIgnoreCase("Profiles")){
					String cellPath = applet+table+"//tr[@id='"+common1.selectedRow+"']//td[contains(@id,'Address')]"; 
					find(By.xpath(cellPath)).click();
				}
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(ActualValue.equalsIgnoreCase(sExpectedAddressVal)){
					report.Info("Address Value is :"+ActualValue+" for anonymous customer under "+tab+" tab.");
				}
				else{
					Assert.assertTrue("Address Value is :"+ActualValue+" for anonymous customer under "+tab+" tab but it should be :"+sExpectedAddressVal,ActualValue.equalsIgnoreCase(sExpectedAddressVal));
				}
			}

		}
	}

	@Step      
	public void validateJobDetails(String action) throws IOException, InterruptedException, FindFailed, AWTException{

		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "ValidateCustComms";
		String applet = "//*[@title='Customer Comms List List Applet']";
		String table = "//table[@summary='Customer Comms List']";   	


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(action, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		Common.waitForPageLoad(getDriver());

		if (tableMap.get("LocateCol").size()==0){
			report.Info(action+" logical name not found in sheet.");
			Assert.assertTrue(false);        	
		}

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) { 	  
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sIndex = tableMap.get("Index").get(i);

			if (sIndex.equals("")){
				sIndex = "0";
			}

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info(sLocateCol+ "feild is displayed as expeted");								  							 
			}
			else{
				common1.selectedRow = 1;
			}

		}

	}
	@FindBy(xpath=".//*[@title='Products and Services:Check Credit Limit']")
	WebElementFacade CheckCreditLimtButton;
	@FindBy(xpath=".//input[@aria-labelledby='Credit_Limit_Label']")
	WebElementFacade CreditLimitTextBox;
	@FindBy(xpath=".//*[@title='Credit Limit Management:Set Credit Limit']")
	WebElementFacade SetCreditLimitButton;

	@Step
	public void addCreditLimit() throws InterruptedException, IOException, AWTException
	{
		if (ProductAndServicesTab.isDisplayed()){
			ProductAndServicesTab.waitUntilClickable();
			ProductAndServicesTab.click();
			Thread.sleep(3000);
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Product / Services");
			Thread.sleep(2000);
		}
		CheckCreditLimtButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		CheckCreditLimtButton.click();
		Thread.sleep(10000);
		CreditLimitTextBox.waitUntilClickable();
		CreditLimitTextBox.clear();
		CreditLimitTextBox.type("270");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		SetCreditLimitButton.waitUntilClickable();
		SetCreditLimitButton.click();
		Thread.sleep(5000);
		if (AccountSummaryTab.isDisplayed()){
			AccountSummaryTab.click();	    		   
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Account Summary");	   			
		} 
		Thread.sleep(5000);

	}


	@FindBy(xpath="//*[text()='Secondary DPA']")
	WebElementFacade SecondaryDPATab;

	@FindBy(xpath="(.//a[text()='Agreements'])[2]")
	WebElementFacade Agreementstab;

	@FindBy(xpath=".//*[@aria-label='Billing profile:Check Payment Date']")
	WebElementFacade CheckPaymentDateButton;

	/*@FindBy(xpath=".//*[text()='Account Summary']")
			 WebElementFacade AccountSummaryTab;*/

	@FindBy(xpath=".//*[text()='Itemised Usage']")
	WebElementFacade ItemizedUsageTab;


	@Step
	public void Validations(String Rowno) throws InterruptedException, IOException, AWTException {

		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String applet = "";
		String table = "";	   		
		String dataSheet = "AllValidation";
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Rowno, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Sample").size();i++) {
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName =  tableMap.get("UIName").get(i);
			String value =  tableMap.get("Value").get(i);              
			String sSecondaryDPATab =  tableMap.get("SecondaryDPATab").get(i);
			String sAgreementstab = tableMap.get("Agreementstab").get(i);
			String sOrdersTab = tableMap.get("OrdersTab").get(i);
			String sProfilesTab = tableMap.get("ProfilesTab").get(i);
			String sAccountSummaryTab = tableMap.get("AccountSummaryTab").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			String Index = tableMap.get("Index").get(i);

			if (Index.equals("")){
				Index = "0";
			}

			if (!sSecondaryDPATab.equals("")){ 	
				if (SecondaryDPATab.isDisplayed()){
					SecondaryDPATab.waitUntilClickable();
					SecondaryDPATab.click();
					Thread.sleep(12000);
				}
				else {
					AccountTabsDRopDown.selectByVisibleText("Secondary DPA");
					Thread.sleep(2000);

				}
				applet = "//*[@title='Service Details List Applet']";
				table = "//table[@summary='Service Details']";

				if (!sLocateCol.equals("")){
					Common.selectedRow = -1;
					String sResult = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index);

					Assert.assertTrue(sResult,sResult.equals("true")); 
					report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           

				}
				else{
					Common.selectedRow = 1;
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}	

			if (!sAgreementstab.equals("")){      
				if (Agreementstab.isCurrentlyVisible()){
					Agreementstab.waitUntilClickable();
					Agreementstab.click();
					Thread.sleep(3000);
				}
				else {
					TabDropDown.selectByVisibleText("Agreements");
					Thread.sleep(3000);
				}	
				applet = "//*[@title='Agreements List View List Applet']";
				table = "//table[@summary='Account Details']";

				if (!sLocateCol.equals("")){
					Common.selectedRow = -1;
					String sResult = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index);

					Assert.assertTrue(sResult,sResult.equals("true")); 
					report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           

				}
				else{
					Common.selectedRow = 1;
				}

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (!sOrdersTab.equals("")){  
				if (OrdersTab.isCurrentlyVisible()){
					OrdersTab.waitUntilClickable();
					OrdersTab.click();
					Thread.sleep(3000);
				}
				else {
					TabDropDown.selectByVisibleText("Orders");
					Thread.sleep(3000);
				}	
				applet = "//*[@title='Orders List Applet']";
				table = "//table[@summary='Account Details']";

				if (!sLocateCol.equals("")){
					Common.selectedRow = -1;
					String sResult = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index);

					Assert.assertTrue(sResult,sResult.equals("true")); 
					report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           

				}
				else{
					Common.selectedRow = 1;
				}

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (!sProfilesTab.equals("")){ 
				if (ProfilesTab.isCurrentlyVisible()) {
					ProfilesTab.click();
				}
				else
				{
					TabDropDown.selectByVisibleText("Profiles");
					Thread.sleep(3000);

				}
				CheckPaymentDateButton.click();
				Thread.sleep(2000);
				common1.HandleErrorPopUp(sPopUp);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}

			if (!sAccountSummaryTab.equals("")){ 
				if (AccountSummaryTab.isCurrentlyVisible()){
					AccountSummaryTab.waitUntilClickable();
					AccountSummaryTab.click();
					Thread.sleep(3000);
				}
				else {
					AccountTabsDRopDown.selectByVisibleText("Account Summary");
					Thread.sleep(2000);
				}	
				applet = "//*[@title='Billing Profiles List Applet']";
				table = "//table[@summary='Billing Profiles']";

				if (!sLocateCol.equals("")){
					Common.selectedRow = -1;
					String sResult = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index);

					Assert.assertTrue(sResult,sResult.equals("true")); 
					report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           

				}
				else{
					Common.selectedRow = 1;
				}
				if (!UIName.equals("")){ 
					//Thread.sleep(5000);
					Common.updateSiebList(applet,table, UIName, value);           
					Thread.sleep(1000);
					//report.Info("Row updated successfully"); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				}	   

				ItemizedUsageTab.click();
				Thread.sleep(3000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}	     
		}
	}

	@FindBy(xpath=".//input[@aria-label='Sort code']")
	WebElementFacade SortCode;

	@FindBy(xpath="(.//input[@aria-label='Account name'])[2]")
	WebElementFacade DirectDebitAccountName;

	@FindBy(xpath="(.//input[@aria-label='Account no.'])[2]")
	WebElementFacade DirectDebitAccountNo;

	@FindBy(xpath="(.//input[@aria-label='Account status'])[2]")
	WebElementFacade DirectDebitAccountStatus;

	@FindBy(xpath=".//input[@aria-label='Mandate ID']")
	WebElementFacade DirectDebitMandateId;

	@FindBy(xpath=".//input[@aria-label='Mandate status']")
	WebElementFacade DirectDebitMandateStatus;

	@FindBy(xpath=".//input[@aria-label='DD Transaction Type']")
	WebElementFacade DirectDebitTransType;


	
	@Step
	public void DirectDebitCaptureAndValidation() throws IOException, InterruptedException, AWTException
	{
		ProfilesTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		if (ProfilesTab.isCurrentlyVisible()){
			ProfilesTab.click();
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Profiles");
		}
		Thread.sleep(2000);
		BillingProfilesTab.click();
		Thread.sleep(2000);

		Robot robot = new Robot();  // Robot class throws AWT Exception		  	      
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);

		Serenity.setSessionVariable("SortCode").to(SortCode.getTextValue());
		Serenity.setSessionVariable("DirectDebitAccountName").to(DirectDebitAccountName.getTextValue());
		Serenity.setSessionVariable("DirectDebitAccountNo").to(DirectDebitAccountNo.getTextValue());
		Serenity.setSessionVariable("DirectDebitAccountStatus").to(DirectDebitAccountStatus.getTextValue());
		Serenity.setSessionVariable("DirectDebitMandateId").to(DirectDebitMandateId.getTextValue());
		Serenity.setSessionVariable("DirectDebitMandateStatus").to(DirectDebitMandateStatus.getTextValue());
		Serenity.setSessionVariable("DirectDebitTransType").to(DirectDebitTransType.getTextValue());

		if (DirectDebitMandateStatus.getTextValue().equals("Processed")) {
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			report.Info("Mandate Status is changed to Processed.");
		}
		else {
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			report.Info("Mandate Status is pending after firing Shell script in Siebel putty.");
			Assert.assertTrue(false);
		}
	}

	@FindBy(xpath=".//a[text()='Audit Trail']")
	WebElementFacade AuditTrailLink;

	@Step
	public void ProfilesBillingProfileAuditTrail(String LocateCol) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());	              
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AddCreditBalance";
		String table = "";
		String applet = "";	                       

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LocateCol, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		if (ProfilesTab.isDisplayed()){
			ProfilesTab.click();
			Thread.sleep(4000);
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Profiles");
		}

		if (AuditTrailLink.isDisplayed()){
			AuditTrailLink.click();
			Thread.sleep(24000);
		}

		Robot robot = new Robot();  // Robot class throws AWT Exception		  	      
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {       	             
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String indexValue = tableMap.get("Index").get(i);
			String sScenario = tableMap.get("Scenario").get(i);

			if (sScenario.equalsIgnoreCase("BillingProfile")){
				table = "//table[@summary='Billing profile']";             
				applet = "//*[@title='Billing profile List Applet']"; 
			}

			else if (sScenario.equalsIgnoreCase("AuditTrail")){
				table = "//table[@summary='Audit Trail Items Com Invoice Profile']";             
				applet = "//*[@title='Audit Trail Items Com Invoice Profile List Applet']"; 
			}
			if(indexValue.equals("")){
				indexValue="0";
			}	              	              	                 

			if (!sLocateCol.equals("")){
				common1.selectedRow = -1;
				Assert.assertTrue(common1.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info(sLocateCol+"Billing profile applet found using Locate Col");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
			else 
			{
				common1.selectedRow = 1;		                  		             	    								 
			}
			if (!sUIName.equals("")){         		 
				Common.updateSiebList(applet,table, sUIName, sValue); 
				Thread.sleep(2000);                       	              
				report.Info("Action : "+sUIName+" has perfomed "+sValue);                                                  
			}

		}
	}
	@FindBy(xpath = ".//*[text()='Addresses']")
	WebElement AddressesTabSync;
	@FindBy(xpath = ".//*[@title='Account Addresses:New']")
	WebElementFacade AddressesNewButton;
	@FindBy(xpath = ".//*[@title='Add Address:OK']")
	WebElementFacade AddressAddOkButton;
	@FindBy(xpath = ".//*[@title='Account Addresses:New']")
	WebElement AddressesNewButtonSync;
	@FindBy(xpath = ".//*[contains(@title,'Update Contact Address')]")
	WebElementFacade UpdateContactAddressButton;
	@FindBy(xpath = ".//*[contains(@title,'Update Contact Address')]")
	WebElement UpdateContactAddressButtonSync;
	@FindBy(xpath = ".//*[contains(@title,'Update Billing Address')]")
	WebElementFacade UpdateBillingAddressButton;
	@FindBy(xpath = ".//*[contains(@title,'Update Billing Address')]")
	WebElement UpdateBillingAddressButtonSync;
	@FindBy(xpath = ".//div[@class='siebui-popup-btm']//button[@title='Add Address:Cancel']")
	WebElementFacade AddressAddCancelButton;
	
	@Step
	public void accountAddressChange(String rowname) throws InterruptedException, IOException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "DivisionProvision";
		String table = "//table[@summary='Account Fraud Events List']";
		String applet = "//*[@title='Account Addresses List Applet']";

		Common.waitForElement(AddressesTabSync);
		if(AddressesTab.isCurrentlyVisible()){
			AddressesTab.click();					
		}
		else{
			AccountTabsDropDown.selectByVisibleText("Addresses");
		}
		Common.waitForPageLoad(getDriver());

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
			if(sButton.equalsIgnoreCase("New")){
				Common.waitForElement(AddressesNewButtonSync);
				AddressesNewButton.click();
				Thread.sleep(2000);
				Common.selectedRow = 1;
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.updateSiebList("//*[@title='Add Address List Applet']","//table[@summary='Add Address']","Text|Postal_Code",sLocateColValue);
				
				AddressStatusElement.click();
				AddressStatusTextBox.sendKeys(Keys.ENTER);
				
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.locateColumn("//*[@title='Add Address List Applet']","//table[@summary='Add Address']","Status","Validated","0");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				AddressAddOkButton.click();
				report.Info("New Address selected");
				
				//workaround for popup
				if(ErrorTitleBox.isCurrentlyVisible()) {
					Common.HandleErrorPopUp("OPTIONAL:The selected record");
					if(AddressAddCancelButton.isCurrentlyEnabled()) {
						AddressAddCancelButton.click();
					}
				}
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
				String Fieldvalue = Common.updateSiebList(applet,table, UIName, value);
				Serenity.setSessionVariable("OldPostCode").to(Fieldvalue);	 
				report.Info("Old Post Code : "+Fieldvalue);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			} 
			if(Validation.equalsIgnoreCase("UpdateContactAdd")){
				Common.waitForElement(UpdateContactAddressButtonSync);
				UpdateContactAddressButton.click();
			}

			if(Validation.equalsIgnoreCase("UpdateBillingAdd")){
				Common.waitForElement(UpdateBillingAddressButtonSync);
				UpdateBillingAddressButton.click();
			}
			Thread.sleep(2000);
			if(isAlertPresent(getDriver())&& !sPopup.equals("") ){
				alert=getDriver().switchTo().alert();
				ActAlertText=alert.getText(); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if (ActAlertText.contains(sPopup)){  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					alert.accept();
					report.Info("Pass: primary Adderss changed as expected");		                	
				}                                 

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}
		}

	}

	public void ProductServiceDateChange(String rowname) throws InterruptedException, IOException, AWTException{

		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "DateChange";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		for (int i = 0;i < tableMap.get("Month").size();i++) {
			String sMonth = tableMap.get("Month").get(i);


			//		String sPromotion = Serenity.sessionVariableCalled("ProductName").toString();
			//String sPromotion = "12";

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date currentDate = new Date();
			//System.out.println(dateFormat.format(currentDate));
			// convert date to calendar
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			// manipulate date
			/*  if (sPromotion.contains("12")){
						        	c.add(Calendar.YEAR,-1);
							        c.add(Calendar.MONTH,+1);
							        c.set(Calendar.DATE, 4); 
								}*/
			// if (sPromotion.contains("24")){
			//	c.add(Calendar.YEAR,-2);

			if (sMonth.equals("1 Month")){     
				c.add(Calendar.MONTH,+1);
				//  c.set(Calendar.DATE, 4);
				//}

				// convert calendar to date
				Date startDate = c.getTime();
				String sStartDate = (dateFormat.format(startDate));
				Serenity.setSessionVariable("sStartDate").to(sStartDate);
			}	

			if (sMonth.equals("2 Month")){     
				c.add(Calendar.MONTH,+2);
				//  c.set(Calendar.DATE, 4);
				//}

				// convert calendar to date
				Date startDate = c.getTime();
				String sStartDate = (dateFormat.format(startDate));
				Serenity.setSessionVariable("sStartDate").to(sStartDate);
			}	

			if (sMonth.equals("8 Days")){     
				//c.add(Calendar.MONTH,+2);
				c.set(Calendar.DATE, 8);
				//}

				// convert calendar to date
				Date startDate = c.getTime();
				String sStartDate = (dateFormat.format(startDate));
				Serenity.setSessionVariable("sStartDate").to(sStartDate);
			}	

		}
	} 
	@FindBy(xpath = ".//*[@title='Products and Services Menu']")
	WebElement ProductServiceMenu;

	@FindBy(xpath="//span/ul/li[12]/a")
	WebElementFacade ProductServiceMenuAboutRecord;

	@FindBy(xpath="//span/ul/li[9]/a")
	WebElementFacade ProductServiceMenuRunQuery;


	public void ProductServiceTabMenuBillingProfile(String MenuProfile) throws IOException, InterruptedException, AWTException{

		// Thread.sleep(5000);
		Common.waitForPageLoad(getDriver());

		String filePath = "\\src\\test\\resources\\data\\Account.xls";

		String dataSheet = "MenuBillingProfile";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(MenuProfile, filePath, dataSheet);

		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("MenuItem").size();i++) {   

			String sMenuItem = tableMap.get("MenuItem").get(i); 

			Thread.sleep(3000); 

			ProductServiceMenu.click();

			if(sMenuItem.equalsIgnoreCase("About Record")) {

				Thread.sleep(2000);

				ProductServiceMenuAboutRecord.click();

			}

			if(sMenuItem.equalsIgnoreCase("Run Query")) {

				Thread.sleep(2000); 

				ProductServiceMenuRunQuery.click();
			}
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@FindBy(xpath="//input[@aria-labelledby='PostalCode_Label']")
	WebElementFacade PostCodeInAccountSummary; 

	@Step
	public void CheckPostcodeinAccountSummary(String rowname) throws InterruptedException, IOException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "DivisionProvision";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Value").size();i++) {
			String sValue = tableMap.get("Value").get(i);
			PostCodeInAccountSummary.click();
			String actualPostcode = PostCodeInAccountSummary.getTextValue();

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Assert.assertTrue("FAIL : The Postcode in account summary is not updated to "+sValue+" after updating in address as primary contact ", sValue.equalsIgnoreCase(actualPostcode));
			report.Info("The Postcode in account summary has sucessfully changed to "+actualPostcode+" as expected");	


		}	
	}
	
	@FindBy(xpath=".//*[@title='Add Contacts:Cancel']")
	WebElementFacade AddContactCancel;
	
	@FindBy(xpath=".//*[@title='Add Contacts:OK']")
	WebElementFacade AddContactOK;
	
	@FindBy(xpath=".//*[@name='Last_Name']")
	WebElementFacade LastName;
	
	@FindBy(xpath=".//*[@aria-label='Account Permissions:Menu']")
	WebElementFacade AccountPermissonMenu;
	
	@FindBy(xpath="//span/ul/li[6]/a")
	WebElementFacade SaveRecord;
			
	@Step
	public void Contacts_AccountPermission_fn(String rowname) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "AccountPermission";
		//String applet = "//*[@title='Contacts List Applet']";
		//String table = "//table[@summary='Admin Account Automatic Debit Details']"; 


		ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
		if (ContactsTab.isDisplayed()){
			ContactsTab.click();
		}
		else {
			AccountTabsDRopDown.selectByVisibleText("Contacts");
		}

		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
		for (int i = 0;i < tableMap.get("RowNo").size();i++) {
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			String sPopUp1 = tableMap.get("PopUp1").get(i);
			String sValueType = tableMap.get("ValueType").get(i);
			String Index = tableMap.get("Index").get(i);
			String sAccountPermissionSave = tableMap.get("AccountPermissionSave").get(i);

			String applet ="";
			String table ="";

			if (sValueType.equals("Contacts")){  

				applet = "//*[@title='Contacts List Applet']";
				table = "//table[@summary='Admin Account Automatic Debit Details']";
			}
			else if(sValueType.equalsIgnoreCase("AddContact")){

				applet = "//*[@title='Add Contacts List Applet']";
				table = "//table[@summary='Add Contacts']";

				AddContact.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				AddContact.click();

				AddContactCancel.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if (!sUIName.equals("")){ 
					Common.selectedRow = 1;
					Common.updateSiebList(applet,table, sUIName, sValue);
					//Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				}

				LastName.sendKeys(Keys.chord(Keys.ALT,Keys.ENTER));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				AddContactOK.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
				AddContactOK.click();
				
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				Alert alert;
		        String ActAlertText="";
				
		        if(isAlertPresent(getDriver())&& (!sPopUp.equalsIgnoreCase(""))){
	   		    	 alert=getDriver().switchTo().alert();
	                   ActAlertText=alert.getText();
	                   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	                   if (ActAlertText.contains(sPopUp)){                		
		              		alert.accept();
		              		report.Info("Expected alert messsage present"+ActAlertText);
		              	}  
	               }
		        Thread.sleep(5000);
		        sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		        
		        if(isAlertPresent(getDriver())&& (!sPopUp1.equalsIgnoreCase(""))){
	   		    	 alert=getDriver().switchTo().alert();
	                   ActAlertText=alert.getText();
	                   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	                   if (ActAlertText.contains(sPopUp1)){                		
		              		alert.accept();
		              		report.Info("Expected alert messsage present"+ActAlertText);
		              	}  
	               }
		        return;
			}
			
			else if(sValueType.equalsIgnoreCase("NewPremission")){

				applet = "//*[@title='Account Permissions List Applet']";
				table = "//table[@summary='Account Permissions']";

				NewAccountPermissionButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				NewAccountPermissionButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}

			if (Index.equals("")){
				Index = "0";
			}

			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));

			}
			if (!sUIName.equals("")){ 
				Common.selectedRow = 1;
				Common.updateSiebList(applet,table, sUIName, sValue);
				//Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}

			if (sAccountPermissionSave.equals("Yes")){ 

				AccountPermissonMenu.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				AccountPermissonMenu.click();
				SaveRecord.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


			}


		}      
	}
	
	
	@FindBy(xpath=".//*[@aria-label='Fourth Level View Bar']")
	WebElementFacade ProductServicesViewBar; 

	@FindBy(xpath=".//*[@aria-label='VF Subscriber Divert Applet:Modify']")
	WebElementFacade DivertsModifyButton; 

	@FindBy(xpath=".//*[@aria-label='Status']")
	WebElementFacade DivertsStatusTextBox;

	@FindBy(xpath="//*[text()='Diverts']")
	WebElementFacade DivertsTab; 

	@FindBy(xpath=".//*[@aria-label='VF Subscriber Divert Applet:New']")
	WebElementFacade DivertsNewButton; 


	@Step
	public void Diverts(String rowname) throws InterruptedException, IOException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "Diverts";

		Common.waitForPageLoad(getDriver());
		//Thread.sleep(6000);

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
		for (int i = 0;i < tableMap.get("RowNo").size();i++) {
			String sValidation = tableMap.get("Validation").get(i);


			if (sValidation.equals("DivertsDisable")){
				ProductServicesViewBar.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				ProductServicesViewBar.click();
				Thread.sleep(3000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: Diverts tab visible",!DivertsTab.isPresent());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (sValidation.equals("NewButtonDisable")){
				int DivertsRowCount = '0';

				if (DivertsTab.isVisible()) {
					DivertsTab.click();	    		   
				}
				else {
					ProductServicesViewBar.selectByVisibleText("Diverts");	   			
				} 				
				DivertsModifyButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				DivertsRowCount = findAll(By.xpath("//table[@summary='VF Subscriber Divert Applet']/tbody/tr")).size();
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", DivertsNewButton);
				if (DivertsRowCount > 1) {
					Assert.assertTrue("FAIL: Diverts tab new button is visible",!DivertsNewButton.isEnabled());
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				else
				{	
					report.Info("No rows found");
					Assert.assertTrue(false);
				}
			}	

			if (sValidation.equals("DivertsVisible")){  
				if (DivertsTab.isVisible()) {
					DivertsTab.click();	    		   
				}
				else {
					ProductServicesViewBar.selectByVisibleText("Diverts");	   			
				} 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				//DivertsModifyButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				if (DivertsModifyButton.isVisible()){


					DivertsModifyButton.click();
					report.Info("Diverts Modify Button clicked succedfully");
					DivertsStatusTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					DivertsStatusTextBox.clear();
					report.Info("Diverts Status Textbox clear succedfully");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					DivertsTab.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					String sPopup ="'Status' is a required field. Please enter a value for the field.";

					common1.HandleErrorPopUp(sPopup);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				else
				{
					Assert.assertTrue("Diverts page not loaded successfully",DivertsModifyButton.isVisible());
				}

			}
		}
	} 

}




