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
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import pages.DatabasePage;
import pages.AboutCustomerPageEnh;

public class OrdersPage extends PageObject {

	private static final TimeUnit SECONDS = null;
	@Steps
	private ReadWorkbook readWorkbook;
	@Steps
	private AboutCustomerPageEnh AboutCustomerEnh;
	@Steps
	private common Common;
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
    WebElement Clockobj; 
	@Step
	public void CreateNewOrder(String Order) throws InterruptedException, IOException, FindFailed, AWTException{
		//Homepage.waitUntilPresent();
		 Common.WaitForClock(Clockobj);
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String applet = "//*[@title='Orders List Applet']";
		String table = "//table[@summary='Order Entry - Orders List - Tiny']";	   		
		String dataSheet = "CreateNewOrder";
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Order, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("NewButton").size();i++) {
			String CreateOrder = tableMap.get("NewButton").get(i);
			String sPopUp = tableMap.get("PopUp").get(i);
			String UIName =  tableMap.get("UIName").get(i);
			String value =  tableMap.get("Value").get(i);              
			String sNewButton =  tableMap.get("NewButton").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String Index = tableMap.get("Index").get(i);

			if (sPopUp.equals("")){
				sPopUp = "No";
			}                         

			if (Index.equals("")){
				Index = "0";
			}

			report.Info(" Order New "+CreateOrder);
			if  (CreateOrder.equals("Yes")){
				report.Info("Creating New Order");
				NewOrder.click();
				Thread.sleep(2000); 
				 Common.WaitForClock(Clockobj);
				if(isAlertPresent(getDriver())){
					Alert alert = getDriver().switchTo().alert();
					String ActAlertText = alert.getText(); 
													  				  						
					if (ActAlertText.contains("FRAUD RISK")){
						alert.accept();
						System.out.println("alert messsage is"+ActAlertText);
					}                                                                                       					                    
				}

				 Common.WaitForClock(Clockobj);
				Thread.sleep(1000);                      
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
				report.Info("Action : "+UIName+" has perfomed "+value);                                                  
			}
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 Common.WaitForClock(Clockobj);
	}

	@FindBy(xpath="//input[@aria-label='Order no.']")
	WebElementFacade OrderNo;

	@FindBy(xpath="//input[@aria-label='Status']")
	WebElementFacade OrderStatus;


	@Step
	public void CaptureOrderDetails() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(Clockobj);
		Common.waitForPageLoad(getDriver());
		LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete
		LineItemsTab.click();
		Thread.sleep(2000);//don't delete
		menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete
		OrderStatus.withTimeoutOf(60,TimeUnit.SECONDS).isCurrentlyVisible();
		String sOrderNo,sStatus;
		sOrderNo=OrderNo.getTextValue();
		sStatus =OrderStatus.getTextValue();		 
		report.Info("Order Number is:  "+sOrderNo);
		report.Info("Status is:  "+sStatus); 
		System.out.println("Order Number : "+sOrderNo+" Status is : "+sStatus);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		  
		Serenity.setSessionVariable("OrderNo").to(sOrderNo);
		Thread.sleep(2000);

	}


	@FindBy(xpath=".//a[text()='Orders']")
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

	@FindBy(xpath=".//*[@title='Sales Order:Show more']")
	WebElementFacade SalesOrderShowMore;

	@FindBy(xpath=".//*[@title='Sales Order:Show less']")
	WebElementFacade SalesOrderShowless;

	@FindBy(xpath=".//*[@aria-labelledby='Back_Office_Error_Text_Label']")
	WebElementFacade BackOfficeText;


	@Step
	public void SearchOrder(String OrderNum) throws InterruptedException, IOException, AWTException {
		Common.waitForPageLoad(getDriver());
		 Common.WaitForClock(Clockobj);
		 
		//Ordertab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		//Thread.sleep(5000);
		Ordertab.click();
		 Common.WaitForClock(Clockobj);
		OrderQuery.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		
		OrderQuery.click();
		 Common.WaitForClock(Clockobj);
		//OrderListAplet.waitUntilPresent();
		
		//OrderListAplet.click();
		 Common.WaitForClock(Clockobj);
		ListAplet.waitUntilPresent();
		
		ListAplet.type(OrderNum);
		SalesOrderGo.waitUntilPresent();
		SalesOrderGo.click();
		 Common.WaitForClock(Clockobj);
		ClickOnAccountname.waitUntilPresent();

		ClickOnAccountname.click();
		 Common.WaitForClock(Clockobj);
		 
		ClickOnOrderNumber.waitUntilPresent();
		ClickOnOrderNumber.click();
		 Common.WaitForClock(Clockobj);

		report.Info("Order Number clicked ");
		report.Info("Order Number is:  "+OrderNum);	
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

	}
	@Step

	public void backOfficeAgent() throws InterruptedException, IOException, AWTException {
		Common.waitForPageLoad(getDriver());
		//SalesOrderShowless.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilPresent();
		if (SalesOrderShowless.isDisplayed()){
			report.Info("Do Not Expand");
		}
		else{
			SalesOrderShowMore.click();	
			report.Info("Expand to show more about order ");
		}


		BackOfficeText.waitUntilPresent();
		//BackOfficeText.getText();
		String BackOfficeTextvalue = BackOfficeText.getTextValue();
		report.Info("Getting Back Office text ");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


		if (BackOfficeTextvalue != null){
			report.Info("The value is null");
		}
		else {
			report.Info("Back Office Value is :   "+BackOfficeTextvalue);
		}

	}
	@FindBy(xpath="//input[@aria-label='Terms and conditions']")
	WebElementFacade TermsandConditionsCheckBox;

	@FindBy(xpath="//a[text()='Payments']")
	WebElementFacade PaymentsTab;

	@FindBy(xpath="//a[text()='Payments']")
	WebElement PaymentsTabWebElement;

	@FindBy(xpath="//button[@aria-label='Payment Lines:New']")
	WebElementFacade NewPaymentButton;

	@FindBy(xpath="//td[contains(@aria-labelledby,'Payment_Method')]")
	WebElementFacade PaymentMethodElement;

	@FindBy(xpath="//input[@name='Payment_Method']")
	WebElementFacade PaymentMethodTextBox;


	@FindBy(xpath="//td[contains(@aria-labelledby,'Billing_Profile')]")
	WebElementFacade BillingProfileElement;

	@FindBy(xpath=".//*[@id='s_3_2_22_0_icon']")
	WebElementFacade BillingProfilePopup;

	@FindBy(xpath="//input[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade BillingProfilePickListTextBox;

	@FindBy(xpath="//input[@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElementFacade BillingProfileOptionTextBox;

	@FindBy(xpath="//td[@class='siebui-popup-filter']//button[@title='Billing profile:Go']")
	WebElementFacade BillingProfileGoButton;

	@FindBy(xpath="//button[@title='Billing profile:OK']")
	WebElementFacade BillingProfileOKButton;

	@FindBy(xpath="//button[@title='Payment Detail - Credit Card:Card Details'] ")
	WebElementFacade CardDetailsButton;

	@FindBy(xpath="//td[contains(@aria-labelledby,'Transaction_Amount')]")
	WebElementFacade TransactionAmountElement;

	@FindBy(xpath="//input[@name='Transaction_Amount']")
	WebElementFacade TransactionAmountTextBox;

	@FindBy(xpath="//td[contains(@aria-labelledby,'Transaction_Type')]")
	WebElementFacade TransactionTypeElement;

	@FindBy(xpath="//input[@name='VF_Transaction_Type']")
	WebElementFacade TransactionTypeTextBox;

	@FindBy(xpath="//button[@data-display='Authorise']")
	WebElementFacade AuthoriseButton;

	@FindBy(xpath=".//*[@aria-label='CV2']")
	WebElementFacade CV2;

	@FindBy(xpath=".//*[@aria-label='CV2:Go']")
	WebElementFacade CV2GoButton;

	@FindBy(xpath=".//*[@aria-label='Payment Lines:Delete']")
	WebElementFacade PaymentsDeleteButton;

	@FindBy(xpath=".//*[@aria-label='Payment Lines:Menu']")
	WebElementFacade PaymentMenuIcon;

	@FindBy(xpath=".//*[@aria-label='Payment Lines:Menu']")
	WebElement PaymentMenuIconSync;
	
	@FindBy(xpath="//span[text()='Messages']")
	WebElementFacade PaymentMessageMBB;

	@FindBy(xpath=".//*[@title='Messages:Accept']")
	WebElementFacade MessageCloseButtonAccept;

	@FindBy(xpath="//*[@aria-label='Mobile no.']/following-sibling::span")
	WebElementFacade PickMobNoInBalPayment;

	@FindBy(xpath=".//*[@aria-label='Pick Asset:OK']")
	WebElementFacade PickMobNoOKButton;

	@FindBy(xpath=".//*[@aria-label='Payment Detail - Balance:Reserve Funds']")
	WebElementFacade ReserveFundButton;
	
	@FindBy(xpath=".//button[@title='Billing profile:OK']")
	WebElementFacade BillingProfileOKButton1;
	
	@FindBy(xpath=".//button[@aria-label='CV2:Cancel']")
	WebElementFacade CancelButton;
	
	@FindBy(xpath=".//*[@aria-label='One-off cost']")
	WebElementFacade OneoffCost;

	@FindBy(xpath = "//input[@placeholder='CVV']")
	WebElementFacade CVVInputField;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElementFacade Submitbutton;

	public void OrdersPayment(String sPaymentMethod) throws IOException, InterruptedException, FindFailed, AWTException{
		Common.waitForPageLoad(getDriver());
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String applet = "//*[@title='Payment Lines List Applet']";
		String table = "//table[@summary='Payment List']";
		String dataSheet = "Order_Payment";



		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(sPaymentMethod, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		PaymentsTab.click();
		/*if (!findBy(applet).isCurrentlyVisible()){
		
			Common.waitForElement(PaymentsTabWebElement);	  
			PaymentsTab.click();
			Thread.sleep(2000);
		}*///To check Payment Applet is already in View, then don't re click on Payment tab.Code takes time but this works.

		//Thread.sleep(2000);
		for (int i = 0;i < tableMap.get("PaymentMethod").size();i++) {

			// TermsandConditionsCheckBox.click();    	     
			String PaymentMethod =  tableMap.get("PaymentMethod").get(i);
			String JourneyType =  tableMap.get("JourneyType").get(i);
			String Authorize =  tableMap.get("Authorize").get(i);
			String CVV =  tableMap.get("CVV").get(i);
			String DeletePayment =  tableMap.get("DeletePayment").get(i);
			String ClickCardDetails =  tableMap.get("ClickCardDetails").get(i);
			String ClickCardDetails1 =  tableMap.get("ClickCardDetails1").get(i);      
			String sPopup =  tableMap.get("Popup").get(i);
			String UIName =  tableMap.get("UIName").get(i);
			String value =  tableMap.get("Value").get(i);
			String sPopup1 =  tableMap.get("Popup1").get(i);
			String sNewButton =  tableMap.get("NewButton").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String Index = tableMap.get("Index").get(i);
			String sClickOnRefresh = tableMap.get("ClickOnRefresh").get(i);
			String sPopUp2 =  tableMap.get("PopUp2").get(i);
			String sCVVCancel =  tableMap.get("CVVCancel").get(i);
			String sTransactionType =  tableMap.get("TransactionType").get(i);

			if (sPopup.equals("")){
				sPopup = "No";
			}

			if (sPopup1.equals("")){
				sPopup1 = "No";
			}

			if (Index.equals("")){
				Index = "0";
			}
			
			Common.waitForPageLoad(getDriver());
			Common.WaitForClock(Clockobj);
			String sOneoffcost = OneoffCost.getTextValue();
			Serenity.setSessionVariable("OneofCost").to(sOneoffcost);
			report.Info("One off Cost: "+sOneoffcost);
			
			if(sOneoffcost.equals("£0.00")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				return;				
			}
			
			Alert alert;
			String ActAlertText="";
			if(NewPaymentButton.isEnabled()&& (!sNewButton.equals(""))){  
				long startTime = System.currentTimeMillis();
				NewPaymentButton.click();
				
				Thread.sleep(3000);

				if(isAlertPresent(getDriver())&& (!sPopup.equalsIgnoreCase("No"))){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText();  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if (sPopup.contains("OPTIONAL:")){
						sPopup= sPopup.substring(9);
					}	                                                                              	
					if (ActAlertText.contains(sPopup)){                		
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
					report.Info("UnExpected Pop occured");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Assert.assertTrue(false);	           		    	
				}  
				
				if(JourneyType.equals("MaxAmount")) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.HandleErrorPopUp("The maximum amount"); 
					break;
				}
				
				Common.waitForElement(PaymentMenuIconSync);

				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;

				Common.WritePerformanceOutput("New Button-Payment Clicked ,Total Time " + totalTime/1000);

			}
			else{
				Assert.assertTrue("Payments tab is not clicked successfully.", NewPaymentButton.isEnabled()); 
			}

			Thread.sleep(3000);	 
			Common.waitForElement(PaymentsTabWebElement);	  
			PaymentsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			int tablesize= findAll(By.xpath("//table[@summary='Payment List']/tbody/tr")).size();

			if(tablesize>1){

				if (!sLocateCol.equals("")){
					Common.selectedRow = -1;
					Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
					report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
				}
				else{               
					Common.selectedRow = 1;
				}
				if (!UIName.equals("")){   
					if (value.contains("BillingProfile")){
						value = Serenity.sessionVariableCalled("BillProfNo").toString();
					}
					Common.updateSiebList(applet,table, UIName, value); 
					Thread.sleep(3000);	
					if(isAlertPresent(getDriver())&& (!sPopup1.equalsIgnoreCase("No"))){
						alert=getDriver().switchTo().alert();
						ActAlertText=alert.getText();  
						if (sPopup1.contains("OPTIONAL:")){
							sPopup1= sPopup1.substring(9);
						}	                                                                              	
						if (ActAlertText.contains(sPopup1)){                		
							alert.accept();
							report.Info("alert messsage is"+ActAlertText);
						}                        
					}
					else if (!isAlertPresent(getDriver())&& (sPopup1.contains("OPTIONAL:"))){
						report.Info("OPTIONAL Pop did not occur");
						Assert.assertTrue(true);	              		    	
					}
					else if (!isAlertPresent(getDriver())&& (!sPopup1.equalsIgnoreCase("No"))){
						report.Info("Expected Pop did not occur");
						Assert.assertTrue(false);	           		    	
					}
					else if (isAlertPresent(getDriver())&& (sPopup1.equalsIgnoreCase("No"))){
						report.Info("UnExpected Pop did occured");
						Assert.assertTrue(false);	           		    	
					} 
					//if (UIName.equalsIgnoreCase("Transaction_Amount")){            	              
					//if u dont want to click refresh button
					if(!sClickOnRefresh.equals("No"))
					{
						PaymentMenuIcon.click();
						PaymentMenuIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						Thread.sleep(1000);
						RefreshRecord.click();

						if (JourneyType.equals("INC")||JourneyType.equals("MaxAmount") ){						
							if(isAlertPresent(getDriver())){
								alert=getDriver().switchTo().alert();
								ActAlertText=alert.getText();  
								sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                                                
								if (ActAlertText.contains(sPopUp2)){  		            		
									alert.accept();
									report.Info("Pop did occurred : " +ActAlertText);
								}
								else {
									report.Info("Pop did not occur");
									Assert.assertTrue(false);
								}
							}

							if(!sPopUp2.equalsIgnoreCase("No")){
								Common.HandleErrorPopUp(sPopUp2); 
							}
						}
					}
					// }
					report.Info("Action : "+UIName+" has perfomed "+value);                                                  
				}

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if(UIName.equalsIgnoreCase("OpenPopUp|Billing_Profile")){
					Thread.sleep(3000);
					
					if (BillingProfileOKButton1.isCurrentlyVisible()){
						BillingProfileOKButton1.click();
						report.Info("Billing profile is selected.");
					}
	                               
	               else{
	                      Assert.assertTrue("Billing Profile window is not displayed after clicking onPop up button..", BillingProfileOKButton1.isVisible());
	                }                 
	          }


				if(ClickCardDetails.equalsIgnoreCase("yes")){
					CardDetailsButton.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if(isAlertPresent(getDriver())&& (!sPopUp2.equalsIgnoreCase("No"))){
						alert=getDriver().switchTo().alert();
						ActAlertText=alert.getText();  
						if (sPopUp2.contains("OPTIONAL:")){
							sPopUp2= sPopUp2.substring(9);
						}	                                                                              	
						if (ActAlertText.contains(sPopUp2)){                		
							alert.accept();
							report.Info("alert messsage is"+ActAlertText);
						}                        
					}
					else if (!isAlertPresent(getDriver())&& (sPopUp2.contains("OPTIONAL:"))){
						report.Info("OPTIONAL Pop did not occur");
						Assert.assertTrue(true);	              		    	
					}
					else if (!isAlertPresent(getDriver())&& (!sPopUp2.equalsIgnoreCase("No"))){
						report.Info("Expected Pop did not occur");
						Assert.assertTrue(false);	           		    	
					}
					else if (isAlertPresent(getDriver())&& (sPopUp2.equalsIgnoreCase("No"))){
						report.Info("UnExpected Pop did occured");
						Assert.assertTrue(false);	           		    	
					} 
				}
				if(ClickCardDetails1.equalsIgnoreCase("yes")){

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
					if(JourneyType.equals("Negative")){
						AboutCustomerEnh.enterAeirandiCardDetails("CreditCardVisaWrongCVV");	
						return;
					}
					
					if(JourneyType.equals("NegativeNonPCI")){
						AboutCustomerEnh.enterAeirandiCardDetails("VerifyAeriandiPageNotOpening");	
						return;
					}
					
					if(JourneyType.equals("Authorise")){
						AboutCustomerEnh.enterAeirandiCardDetails("CreditCardVisaAuthorise");
						Thread.sleep(5000);
						return;
					}
					AboutCustomerEnh.enterAeirandiCardDetails("CreditCardVisa");
					getDriver().switchTo().window(initialWindow);
					Thread.sleep(1000);
				}			

				if(Authorize.equalsIgnoreCase("yes")){
					String initialWindow = "";
					initialWindow = getDriver().getWindowHandle();
					CardDetailsButton.click();
					Thread.sleep(3000);
					Common.WaitForClock(Clockobj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	
					Set<String> winHandles = getDriver().getWindowHandles();
					for (String handle : winHandles) {
						if (!handle.equals(initialWindow)) {
							getDriver().switchTo().window(handle);
							Thread.sleep(1000);
						}
					}
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					
					CVVInputField.type(CVV);
	
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());				
					Submitbutton.click();
					Thread.sleep(5000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Pass, Card Details not saved successfully");		
					getDriver().switchTo().window(initialWindow);
	//				getDriver().close();
					Common.WaitForClock(Clockobj);
					AuthoriseButton.click();
					Common.WaitForClock(Clockobj);
				/*if(AuthoriseButton.isEnabled()){
					AuthoriseButton.click();
					CV2.type(CVV);
					CV2GoButton.click();                                                
					}*/
				}
				if(sTransactionType.equalsIgnoreCase("Authorise payment"))
				{
					Robot robot = new Robot();	 
					robot.keyPress(KeyEvent.VK_ALT);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ALT);	
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(2000);
					AuthoriseButton.click();
		    		Common.WaitForClock(Clockobj);
		    		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					
				
				}
				
				
				if(sCVVCancel.equalsIgnoreCase("Yes"))
				{
					Common.HandleErrorPopUp(sPopup1);
					CancelButton.click();					
				}

				if(DeletePayment.equalsIgnoreCase("Y")){

					if(PaymentsDeleteButton.isEnabled()){
						PaymentsDeleteButton.click();
						//Thread.sleep(10000);
						Common.waitForPageLoad(getDriver());
					}                                    
				}

				if(JourneyType.equals("ReserveFund"))
				{
					PickMobNoInBalPayment.click();
					Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					PickMobNoOKButton.click();
					Thread.sleep(2000);
					ReserveFundButton.click();
					Common.WaitForClock(Clockobj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}

			}

		} 
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}


	@FindBy(xpath=".//button[@aria-label='Line Items:Customise']]")
	WebElementFacade CustomiseButton;

	@FindBy(xpath="//span/ul/li[9]/a")
	WebElementFacade RefreshRecord;

	@FindBy(xpath=".//*[@aria-label='Pick Resource:OK']")
	WebElementFacade PickMSISDNOKButton;
	@FindBy(xpath=".//*[@title='Pick Promotion:OK']")
	WebElementFacade PickpromotionOKButton;
	@FindBy(xpath=".//table[@summary='Pick Promotion']/tbody/tr[2]/td[contains(@aria-labelledby, 'Name')]")	
	WebElementFacade PickpromotionFirstRow;
	@FindBy(xpath="(.//*[@title='Close'])[3]")
	WebElementFacade PickMSISDNCloseButton;
	@FindBy(xpath=".//*[@id='1_Service_Id']")
	WebElementFacade ReadOnlyEdiatbleElement;
	
	@FindBy(xpath="(.//*[@title='Primary ID:OK'])")
	WebElementFacade PrimaryIDOKButton;
	@FindBy(xpath="(.//*[@aria-label='Add Address:OK'])")
	WebElementFacade AddAddressOkButton;
	@FindBy(xpath="(.//*[@aria-label='Primary Installed Id:OK'])")
	WebElementFacade AddPrimaryAddressOkButton;

	@Step
	public void OrderLineItemEntry(String LineItemEntry) throws IOException, InterruptedException, FindFailed, AWTException{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "OrdersLineItemsEntry";
		String applet = "//*[contains(@class,'siebui-applet siebui-collapsible-applet siebui-list')]";
		String table = "//table[@class='ui-jqgrid-btable']";

		// String applet = "//*[@title='Line Items List Applet']";
		// String table = "//table[@summary='Order Entry - Line Item List (Sales)']";   
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LineItemEntry, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		Common.WaitForClock(Clockobj);
		LineItemsTab.click();
		Thread.sleep(3000);//don't delete
		menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete
		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
			String sLocateColExpand = tableMap.get("LocateColExpand").get(i);
			String sLocateColExpandValue = tableMap.get("LocateColExpandValue").get(i);
			String sCollapse = tableMap.get("Collapse").get(i);

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);
			String Index = tableMap.get("Index").get(i);
			String ExpandIndex = tableMap.get("ExpandIndex").get(i);
			String ChangeMSISDN = tableMap.get("ChangeMSISDN").get(i);
			String sPickPromotion = tableMap.get("PickPromotion").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sPrimaryID = tableMap.get("PrimaryID").get(i);

			if (sLocateColExpandValue.equals("RootProduct0")){
				sLocateColExpandValue = Serenity.sessionVariableCalled("RootProduct0").toString();
			}

			if (value.equals("ICCID")){
				value = Serenity.sessionVariableCalled("ICCID").toString();
			}			

			if (value.equals("RECONNECTIONICCID")){
				value = Serenity.sessionVariableCalled("RECONNECTIONICCID").toString();
			}

			if (sLocateColValue.equals("RootProduct0")){
				sLocateColValue = Serenity.sessionVariableCalled("RootProduct0").toString();
			}

			if (sLocateColValue.equals("MSISDN")){
				sLocateColValue = Serenity.sessionVariableCalled("MSISDN").toString();
			}

			if (value.equals("MSISDNNEW")){
				value = Serenity.sessionVariableCalled("MSISDN").toString();
			}

			if (value.equals("MSISDN")){
				value = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
			} 
			
			if (value.equals("ACCNTMSISDN")){
				value = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
			}
			
			
			if (value.equals("NEWACCNTMSISDN")){
				value = Serenity.sessionVariableCalled("NEWACCNTMSISDN").toString();
			} 
			
			if (value.equals("RECONNECTIONMSISDN")){
				value = Serenity.sessionVariableCalled("RECONNECTIONMSISDN").toString();
			} 

			if (value.equals("RandomIMEI")){
				value = Serenity.sessionVariableCalled("RandomIMEI").toString();
			} 
	 

			if (value.equals("BBIPNUM")){	
				Random rand = new Random(System.currentTimeMillis());
				int num = rand.nextInt(2000000000);
				String valuenew = String.valueOf(num);
				value = "BBIP"+valuenew;

			}
			
			if (value.equals("IMEI15Digit")){	
				long RandomNUM = 0; 
        		RandomNUM = (long)(Math.random() * 100000 +3333300000L); 
        		String StringRandomNumber1 = new Long(RandomNUM).toString();

        		RandomNUM = (long)(Math.random() * 100000 +33000L); 
        		String StringRandomNumber2 = new Long(RandomNUM).toString();

        		value = StringRandomNumber1 + StringRandomNumber2;
        		report.Info("Random BBIP Number : "+value);

			}
			
			
			if (value.equals("ROUTER NUMBER")){
				value = Serenity.sessionVariableCalled("ROUTERNUMBER").toString();
			} 
			if (value.equals("Fixed Broadband Service")){
				value = Serenity.sessionVariableCalled("FixedBroadbandService").toString();
			} 

			//Thread.sleep(4000);
			Common.waitForElement(LineItemsTabWebElement);			
			Common.selectedRow = -1;
			if (Index.equals("")){
				Index = "0";
			}
			if (ExpandIndex.equals("")){
				ExpandIndex = "0";
			}

					
			try{				
				String sPromotionDD = Serenity.sessionVariableCalled("PromotionDD").toString();
				
				if (sPromotionDD.contains("Postpaid")){
			//Error in VF Spend Manager input is handled with this code		
					if (!sLocateColExpand.equals("")){
						String sResult = Common.locateColumn(applet,table, sLocateColExpand, sLocateColExpandValue, ExpandIndex);
						Assert.assertTrue(sResult,sResult.equals("true"));        	
						report.Info("Row found: "+sLocateColExpand);
						Common.ExpandRow(applet,table);
						report.Info(sLocateColExpandValue+" is expanded successfully.");
					}
					
					String sResult = Common.locateColumn(applet,table, "Product", "Vodafone Spend*", Index);
					if (sResult.equalsIgnoreCase("true")){
						Common.updateSiebList(applet,table, "List|VBC_Setting", "off"); 
					
					}
					getDriver().findElement(By.xpath(".//*[@aria-label='Line Items:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
					Thread.sleep(2000);
				}
			}
			catch(Exception e){
				
			}
			
			if (!sLocateColExpand.equals("")){
				//Thread.sleep(7000);
				String sResult = Common.locateColumn(applet,table, sLocateColExpand, sLocateColExpandValue, ExpandIndex);
				Assert.assertTrue(sResult,sResult.equals("true"));        	
				report.Info("Row found: "+sLocateColExpand);
				Common.ExpandRow(applet,table);
				report.Info(sLocateColExpandValue+" is expanded successfully.");
			}

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
				
				String sValue =  Common.updateSiebList(applet,table, UIName, value); 
				if (UIName.contains("CaptureTextValue|Net_Price")){	
					sValue = sValue.substring(1);
					Double dValue = Double.valueOf(sValue);
					int intValue = (int) Math.floor(dValue);
					sValue = String.valueOf(intValue);
					Serenity.setSessionVariable("MONTHLYCOST").to(sValue);
					
					
				}
				
				Thread.sleep(1000);
				
				if(sAction.equalsIgnoreCase("ValidateManualPopUp")){
					Common.WaitForClock(Clockobj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.HandleErrorPopUp("The MSISDN you have entered is not available for manual connection");
					Common.WaitForClock(Clockobj);
				}
				
				if(sPrimaryID.equalsIgnoreCase("Y")) {
					Thread.sleep(5000);
					Assert.assertTrue("Fail OK button does not exist", PrimaryIDOKButton.isVisible());
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					PrimaryIDOKButton.click();
				
					
				}
				if(UIName.equalsIgnoreCase("OpenPopUp|Parent_Serial_Num")) {
					Thread.sleep(5000);
					Assert.assertTrue("Fail OK button does not exist", AddPrimaryAddressOkButton.isVisible());
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					AddPrimaryAddressOkButton.click();
					
					
				}
				if(UIName.equalsIgnoreCase("OpenPopUp|Used_Location")) {
					Thread.sleep(5000);
					Assert.assertTrue("Fail OK button does not exist", AddAddressOkButton.isVisible());
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					AddAddressOkButton.click();
					
					
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(value.contains("NOTEDITABLE"))
				{
					String UserAccountTextBoxReadOnly = ReadOnlyEdiatbleElement.getAttribute("readonly");
					if(UserAccountTextBoxReadOnly!="false"){
						report.Info("installed id is not editable as expected");
						Assert.assertTrue(true);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				        break;
					}
					else{
						report.Info("installed id is editable. It sohould not be editable.");					
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Assert.assertTrue(false);
				        break;
					}
				}
				else if(value.contains("EDITABLE"))
				{
				
				   report.Info("installed id is editable as expected");
				   sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					//Assert.assertFalse(false);
				}
				Alert alert;
	      		String ActAlertText=""; 	
				
				//report.Info("Row updated successfully"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(sAction.equals("Reconnection"))
				{
					Common.waitForPageLoad(getDriver());
					//LineItemsMenuIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					LineItemsMenuIcon.click();
					//sikuliUtility.ClickReconnectionPopUp(SikulifilePath);
					/*LineItemsMenuIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					LineItemsMenuIcon.click();
					RefreshRecord.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();*/
					//RefreshRecord.click();
					
					Thread.sleep(3000);
					 if(isAlertPresent(getDriver())){
 	            		alert=getDriver().switchTo().alert();
 		                ActAlertText=alert.getText(); 
 		               sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		                if (ActAlertText.contains("Please credit Early Termination Fees")){                    	
 		                	alert.accept();
 		                	System.out.println("Message is: "+ActAlertText);
 		                	report.Info("alert messsage is"+ActAlertText);		                	
 		                }                                 
 	            	}  
 	            	else{
 	            		 Assert.assertTrue("Expected pop-up did not occur",isAlertPresent(getDriver()));
 	            	}
					 
					 LineItemsMenuIcon.click();
					 RefreshRecord.click();

				}

			}

			if(sPickPromotion.equalsIgnoreCase("Yes")){
				PickpromotionFirstRow.withTimeoutOf(240,TimeUnit.SECONDS).waitUntilPresent();
				//Thread.sleep(20000);
				int PickPromotionTableSize= findAll(By.xpath("//table[@summary='Pick Promotion']/tbody/tr")).size();


				if(PickPromotionTableSize>1){
					report.Info("Promotions are available");
				}
				else{
					Assert.assertTrue("No rows displayed after clicking on Go button- Promotions not available", PickPromotionTableSize>1);
				}

				PickpromotionFirstRow.click();
				//Thread.sleep(3000);
				PickpromotionOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				report.Info("Pick Promotion ok button is present successfully");
				PickpromotionOKButton.click();
				Thread.sleep(10000);
				report.Info("ok button clicked successfully");        		   		
			}

			//String sAction = "Run Query [Alt+ENTER]";
			if (!sCollapse.equals("")){
				getDriver().findElement(By.xpath(".//*[@aria-label='Line Items:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				//Thread.sleep(5000);
				/*LineItemsMenuIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
        		LineItemsMenuIcon.click();	
        		//Thread.sleep(5000);
        		RefreshRecord.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				RefreshRecord.click();		
				report.Info("Info : Clicked on Run Query.");
				Thread.sleep(5000);*/
				Thread.sleep(1000);
			}
			if (ChangeMSISDN.equals("Y"))
			{
				Assert.assertTrue("Fail OK button does not exist", PickMSISDNOKButton.isVisible());
				PickMSISDNOKButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (ChangeMSISDN.equals("N"))
			{
				Assert.assertTrue("Fail OK button is Enabled", !PickMSISDNOKButton.isEnabled());
				report.Info("Pick MSISDN Applet");
				PickMSISDNCloseButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				getDriver().switchTo().alert().accept();
			}


		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}

	@FindBy(xpath=".//*[@id='s_at_m_4']")
	WebElementFacade menuItemIcon;

	@FindBy(xpath="//span/ul/li[12]/a")
	WebElementFacade aboutRecord;

	@FindBy(xpath="//span/ul/li[38]/a")
	WebElementFacade editPackage;

	@FindBy(xpath="//span/ul/li[2]/a")
	WebElementFacade DeleteButton;

	@Step
	public void MenuLineItems(String MenuLineItem) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "MenuLineItems";
		//String applet = "//*[@title='Line Items List Applet']";
		// String table = "//table[@summary='Order Entry - Line Item List (Sales)']";

		String applet = "//*[contains(@class,'siebui-applet siebui-collapsible-applet siebui-list')]";
		String table = "//table[@class='ui-jqgrid-btable']";
		// String table1 = "//table[@summary='Order Entry - Line Item List (Sales)']";
		// String applet1 = "//*[@title='Billing Profiles List Applet']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(MenuLineItem, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("RowNo").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String menuItem = tableMap.get("MenuItem").get(i);
			String indexValue = tableMap.get("Index").get(i);

			if (indexValue.equals("")){
				indexValue = "0";
			}

			if (sLocateColValue.equals("RootProduct0")){
				sLocateColValue = Serenity.sessionVariableCalled("RootProduct0").toString();
			}
			if (sLocateColValue.equals("Promotion")){
				sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
			} 

			Common.selectedRow = -1;

			Thread.sleep(3000); 
			LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			LineItemsTab.click();//don't delete
			Thread.sleep(3000);//don't delete
			menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if (!sLocateCol.equals("")){
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));     	     	
			}
			//menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();


			if (!menuItem.equals("")){
				menuItemIcon.click();
				Thread.sleep(2000);
				//aboutRecord.click();
			}
			

			if (menuItem.equalsIgnoreCase("About Record")){
				aboutRecord.click();
				report.Info("About Record Selected");
			}
			if (menuItem.equalsIgnoreCase("Edit Package")){
				
				editPackage.click();
				report.Info("Edit Package Selected");
			}
			if (menuItem.equalsIgnoreCase("Delete Record")){
				DeleteButton.click();

				if(isAlertPresent(getDriver())){
					Alert alert=getDriver().switchTo().alert();
					String ActAlertText=alert.getText();                                           		
					alert.accept();
					report.Info("alert messsage is"+ActAlertText);
				}
			}


			Thread.sleep(5000);

		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}

	//@FindBy(xpath=".//*[contains(@name,'s_5_1_273_0')]")
	@FindBy(xpath=".//*[@aria-label='Row #']")
	WebElementFacade rowId;

	//@FindBy(xpath=".//*[@id='s_5_1_274_0_Ctrl']")
	@FindBy(xpath=".//*[@aria-label='About Record:OK']")
	WebElementFacade aboutRecordOkButton;

	@Step	
	public void getAboutRecord() throws IOException, InterruptedException{
		//System.out.println("About Record displayed");
		Common.waitForPageLoad(getDriver());
		String sRowId = rowId.getTextValue();
		Serenity.setSessionVariable("RowId").to(sRowId);
		//Thread.sleep(5000);
		//aboutRecordOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		report.Info("About Record Row ID : "+sRowId);
		aboutRecordOkButton.click();

	}

	@FindBy(xpath="//span[text()='Delivery Address']")
	WebElementFacade DeliveryAddressApplet;     

	@FindBy(xpath="//a[text()='Delivery']")
	WebElementFacade DeliveryTab;

	@FindBy(xpath=".//*[@aria-label='Address line 1']/following-sibling::span")
	WebElementFacade DeliveryAddressLinePopUp;

	@FindBy(xpath="//button[@title='VF Delivery Address Pick Applet:OK']")
	WebElementFacade DeliveryAddressOKButton;


	@FindBy(xpath="//td[7]//input[@aria-label='Postcode']")
	WebElementFacade DeliveryPostcode;

	@Step
	public void Delivery_Postcode() throws InterruptedException, IOException, AWTException{
		String sPostCode= null;
		DeliveryTab.click();
		//Thread.sleep(6000);
		Common.waitForPageLoad(getDriver());
		if(DeliveryAddressApplet.isVisible()){
			DeliveryAddressLinePopUp.click();
			// Thread.sleep(4000);
			Common.waitForPageLoad(getDriver());
			if(DeliveryAddressOKButton.isVisible()){
				DeliveryAddressOKButton.click();
				report.Info("Address is successfully selected");
			}
			else{
				Assert.assertTrue("Open Pop up is not clicked for Addressline 1.",DeliveryAddressOKButton.isVisible());

			}
		}
		else{
			Assert.assertTrue("Delivery tab is not clicked successfully.",DeliveryAddressApplet.isVisible());

		}

		if(DeliveryPostcode.isVisible()){
			sPostCode = DeliveryPostcode.getTextValue();
		}
		else{
			Assert.assertTrue("Delivery Page is not displayed successfully.",DeliveryPostcode.isVisible());

		}

		if(!sPostCode.equals("")){
			report.Info("Post code is populated automatically after selecting address from address line 1 and is : "+sPostCode);
		}
		else{
			Assert.assertTrue("Post code is not populated automatically after selecting address from address line.",!sPostCode.equals(""));

		}
		//Thread.sleep(5000);
		Common.waitForPageLoad(getDriver());
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


	}

	@FindBy(xpath=".//*[text()='SIM card'][@class='siebui-ecfg-header-label siebui-button-secondary icon-chevron-down']")
	WebElementFacade SIMCardDown;      
	@FindBy(xpath=".//*[@id='s_4_1_32_0_Ctrl']")
	WebElementFacade Customise;   
	@FindBy(xpath=".//a[text()='Orders']")
	WebElementFacade OrdersTab;
	@FindBy(xpath=".//*[@aria-label='Find']")
	WebElementFacade OrderFindDropDown;
	@FindBy(xpath=".//*[@aria-labelledby='QuerySrchSpec_Label']")
	WebElementFacade OrderSearchTestBox;
	@FindBy(xpath=".//*[@id='s_2_1_0_0_Ctrl']")
	WebElementFacade OrderSearchGoButton;
	@FindBy(xpath=".//*[@name='Order Number']")
	WebElementFacade OrderNumber;
	@FindBy(xpath="//*[text()='Line Items']")
	WebElementFacade ClickonLineItems;      
	@FindBy(xpath=".//*[@title='Warning:OK']")
	WebElementFacade WarningOKButton;
	@FindBy(xpath=".//button[text()='Proceed']")
	WebElementFacade ProceedButton;      
	//@FindBy(xpath=".//button[text()='Add to plan']")
	@FindBy(xpath=".//*[@class='siebui-ctrl-btn appletButton'][contains(text(),'Ok')]")
	WebElementFacade DoneButton;      
	@FindBy(xpath=".//*[text()='Grouped bars']//following::*[text()='Barring Reason']")
	WebElementFacade BarsList;
	@FindBy(xpath=".//*[text()='Group Barring Set']//preceding::*[@id='GRPITEM[~^`grpItemId6`^~[LINK']")
	WebElementFacade GroupedBarsLink;

	/* @FindBy(xpath=".//*[@id='1-3IEHDNK`^~[PORT[~^`1-60O5T`^~[DOMAINSELECT']")
    WebElementFacade BarsList;*/

	@FindBy(xpath="//*[contains(text(),'You have exceeded the maximum quantity of 1 for SIM card.')]")
	WebElementFacade SIMCardExceededError;    
	/*@FindBy(xpath=".//input[@value='1' and @class='siebui-ctrl-input siebui-ecfg-editfield']")
    WebElementFacade EconfigTextboxClear;*/
	@FindBy(xpath=".//a[text()='Virtual Landline Call Forward']")
	WebElementFacade VirtualLandCustomiseBtn;
	@FindBy(xpath=".//*[text()='Done']")
	WebElementFacade MSISDNDoneBtn;
	@FindBy(xpath="(.//*[@type='text'][contains(@id,'GRPITEM')])[1]")
	WebElementFacade MSISDNTextBox;
	
	@FindBy(xpath=".//*[text()='Big Value Bundle 10GBP']")
	WebElementFacade BVB10GBP;
	
	@FindBy(xpath=".//*[text()='VOXI 4GB Plan']")
	WebElementFacade VOXI4GBPlan;

	@Step
	public void Econfig(String EconfigItem) throws IOException, InterruptedException, AWTException, FindFailed{
		Common.waitForPageLoad(getDriver());
		Common.WaitForClock(Clockobj);

		try{
			if (!Serenity.sessionVariableCalled("UsedProdAction").equals("")){
				long UsedProdstartTime = Serenity.sessionVariableCalled("UsedProdAction");
				long UsedProdendTime = System.currentTimeMillis();
				long UsedProdtotalTime = UsedProdendTime - UsedProdstartTime;
			//	Common.WritePerformanceOutput("Econfig via modify,Total Time " + UsedProdtotalTime/1000);

			}      
		}
		catch(Exception E){

		}

		try{
			if (!Serenity.sessionVariableCalled("CustomisestartTime").equals("")){
				long CustomisestartTime = Serenity.sessionVariableCalled("CustomisestartTime");
				long CustomiseendTime = System.currentTimeMillis();
				long CustomisetotalTime = CustomiseendTime - CustomisestartTime;
				//Common.WritePerformanceOutput("Econfig via Customise,Total Time " + CustomisetotalTime/1000);

			}
		}
		catch(Exception E){

		}

		String filePath = "\\src\\test\\resources\\data\\Econfig.xls";
		String dataSheet = "Econfig";
		String applet = "//*[@title='Line Items List Applet']";
		String table = "//table[@summary='Order Entry - Line Item List (Sales)']";
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";

		
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(EconfigItem, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		String sPopup = tableMap.get("Popup").get(0);
				
		long EconfigstartTime = 0l;

		for (int i = 0;i < tableMap.get("RowName").size();i++) {

			String sLink = tableMap.get("Link").get(i);
			String sItem = tableMap.get("Item").get(i);
			String sCheckBox = tableMap.get("Check").get(i);
			String sList = tableMap.get("List").get(i);
			String sCustomise= tableMap.get("Customise").get(i);
			String sTextValue= tableMap.get("TextValue").get(i);
			String sAddItem= tableMap.get("AddItem").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sCatalog = tableMap.get("Catalog").get(i);
			//String LinkPath = ".//a[text()='"+sLink+"']";
			String CheckBoxPath = ".//*[@value='"+sItem+"']";
			String sExist = tableMap.get("Exist").get(i);
			String sCascadeLink = tableMap.get("CascadeLink").get(i); 
			String sCondition = tableMap.get("Condition").get(i);
			String sCustomisePath ="*//a[text()='"+sItem+"']";
			// "//parent::div//following-sibling::div[contains(@id,'Customize')]/a";
			//String sCustomiseListPath = ".//*[text()='"+sLink+"']";
			//String sListPath = ".//*[text()='"+sList+"']//following::*[contains(@class,'siebui-ctrl-select')][1]";
			String sListPath = ".//select/option[text()='"+sList+"']/..";
			String sListPathClickItem = "//a[contains(@name,'"+sCascadeLink+"')]/..//select";
			String TextBoxPath = ".//select/option[text()='"+sList+"']/..//following::*[contains(@class,'siebui-ctrl-input')][1]";
			String AddItemButton = ".//select/option[text()='"+sList+"']/..//following::*[@title='Add Item'][1]";
			String AddedItem = ".//a[text()='"+sItem+"']";
			               
			String sCascadeLinkPath = ".//*[text()='"+sCascadeLink+"'][@class='siebui-ecfg-header-label siebui-button-secondary icon-chevron-down']";
			String EconfigTextboxClear = "*//a[text()='"+sItem+"']//parent::div//preceding-sibling::div/input";
			String sClickOnItem = tableMap.get("ClickOnItem").get(i);
			String sClickItemList = tableMap.get("ClickItemList").get(i);

			
			Common.WaitForClock(Clockobj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString()); 
			EconfigstartTime = System.currentTimeMillis();
			if (WarningOKButton.isCurrentlyVisible()){
				WarningOKButton.waitUntilClickable();  
				WarningOKButton.click();  
				Common.WaitForClock(Clockobj);
			}
			if (ProceedButton.isCurrentlyVisible()){
				ProceedButton.waitUntilClickable();
				ProceedButton.click(); 
				Common.WaitForClock(Clockobj);
			}


			if (!sLink.equals("")){   
				if (sLink.contains("RootProduct0")){
					sLink = sLink.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());


				}
				if (sLink.contains("Mobile phone service")){
					sLink = sLink.replace("Mobile phone service", "Mobile Phone Services");

				} 

				if (sLink.contains("Mobile broadband service")){
					sLink = sLink.replace("Mobile broadband service", "Mobile broadband Services");

				} 

				boolean ChkFlag = false; 
				//boolean CheckedFlag = true;
				if (sCheckBox.equals("")){
					ChkFlag = true;
				}
				String[] sLink1 = sLink.split(Pattern.quote("|"));
				for (int k=0; k< sLink1.length; k++)
				{
					String LinkPath = ".//a[text()='"+sLink1[k]+"']";


					//Thread.sleep(5000);
					Common.waitForPageLoad(getDriver());
					//find(By.xpath(LinkPath)).waitUntilClickable(); 

					if (!sLink.equals("Blank")){
						Common.waitForElement(By.xpath(LinkPath));						
						find(By.xpath(LinkPath)).click();
						Common.waitForPageLoad(getDriver());
						Common.WaitForClock(Clockobj);
					} 
					find(By.xpath(sCascadeLinkPath)).withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
					Thread.sleep(5000);
					if (!sCascadeLink.equals("")&& find(By.xpath(sCascadeLinkPath)).isPresent()){
						find(By.xpath(sCascadeLinkPath)).click();
						Thread.sleep(1000);        
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Common.WaitForClock(Clockobj);
					}

					if (!CheckBoxPath.equals("")){
						boolean Checkbox = (find(By.xpath(CheckBoxPath)).isVisible());                                                                     
						if ((!sCheckBox.equals("")) && (Checkbox)){                              
							report.Info(sItem+" is found in"+sLink1);
							ChkFlag = true;

							String IfChecked =find(By.xpath(CheckBoxPath)).getAttribute("aria-checked");
							//report.Info(IfChecked+" is chekced ");
							if (IfChecked.equalsIgnoreCase("true") && sCheckBox.equalsIgnoreCase("On")){
								Assert.assertTrue(sItem+" is already checked", false);                        
							}
							else if (IfChecked.equalsIgnoreCase("false") && sCheckBox.equalsIgnoreCase("On")){
								find(By.xpath(CheckBoxPath)).click();
								report.Info("Clicking checkbox");
								report.Info(sItem+" is Selected");
								if ((sCondition.equals("Check2SIMsCannotBeAdded")) && (SIMCardExceededError.isDisplayed())){
									Assert.assertTrue(true);
									report.Info("Two SIM cards cannot be added occured");

								}
								else if ((sCondition.equals("Check2SIMsCannotBeAdded")) && (!SIMCardExceededError.isDisplayed())){
									report.Info("Two SIM cards cannot be added error did not occur");  
									Assert.assertTrue(false);                                                                                                                               
								}

							}

							if (IfChecked.equalsIgnoreCase("false") && sCheckBox.equalsIgnoreCase("Off")){
								Assert.assertTrue(sItem+" is already Un-checked", false);
								report.Info(sItem+" is Un-Checked");
							}
							else if(IfChecked.equalsIgnoreCase("true") && sCheckBox.equalsIgnoreCase("off")){
								find(By.xpath(CheckBoxPath)).click();
								report.Info("Unchecking checkbox");
								Common.WaitForClock(Clockobj);
							}
							//}
						}//sCheckBox
					}//sCheckBoxPath
					else if (!sExist.equals("")){
						boolean sCheckExist = find(By.xpath(CheckBoxPath)).isCurrentlyVisible();
						if ((sExist.equalsIgnoreCase("Y")) && (sCheckExist)){
							Assert.assertTrue(true);
							report.Info(sItem+ " is present as expected");
						}
						else if ((sExist.equalsIgnoreCase("Y")) && (!sCheckExist)){
							report.Info(sItem+ " is not present");
							Assert.assertTrue(false);                                                                                                    
						}
						if ((sExist.equalsIgnoreCase("N")) && (sCheckExist)){
							report.Info(sItem+ " is present");
							Assert.assertTrue(false);                                                  
						}
						else if((sExist.equalsIgnoreCase("N")) && (!sCheckExist)){
							Assert.assertTrue(true);
							report.Info(sItem+ " is not present as expected");
						}

					}                                                                                                         

					if (!sList.equals("")){
						if(sList.equalsIgnoreCase("AreaCode")){
							find(By.xpath("//select/option[text()='01229  MILLOM']/..")).selectByVisibleText("01229 MILLOM");
						}									
						else if(!sItem.equalsIgnoreCase("AreaCode")){
							find(By.xpath(sListPath)).selectByVisibleText(sList);
							Common.WaitForClock(Clockobj);
						}
						else if(!sClickItemList.equalsIgnoreCase("")){
							find(By.xpath(sListPathClickItem)).selectByVisibleText(sList);
							Common.WaitForClock(Clockobj);
						}

						report.Info(sList+ " is Selected");
					}  
					if (!sAddItem.equals("")&& !sAddItem.equals("blank")){
						find(By.xpath(TextBoxPath)).type(sAddItem);
						find(By.xpath(AddItemButton)).click();

						Thread.sleep(7000);
						Common.WaitForClock(Clockobj);
						//find(By.xpath(AddedItem)).waitUntilVisible();                                    
					} 

					if (sAddItem.equals("blank")){
						find(By.xpath(EconfigTextboxClear)).clear();
						Thread.sleep(1000);
						//find(By.xpath(AddedItem)).waitUntilVisible();                                    
					} 

					
					if(!sClickOnItem.equals(""))
					{
						String ClickOnElementXPath = ".//*[text()='"+sClickOnItem+"']";
						getDriver().findElement(By.xpath(ClickOnElementXPath)).click();
						Thread.sleep(2000);
						Common.WaitForClock(Clockobj);
					}
					

					if(!sCatalog.equals("")){
						Thread.sleep(2000);
						Assert.assertTrue("Fail: Pop up message is not displayed successfully",  getDriver().findElement(By.xpath(".//*[text()='There is a conflict with your last request.']")).isDisplayed());
						getDriver().findElement(By.xpath(".//*[text()='There is a conflict with your last request.']")).click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("PASS: Pop up message is displayed successfully.");
						Common.WaitForClock(Clockobj);

					}
					 if(sCondition.equalsIgnoreCase("ProceedButton")){
                     	if (ProceedButton.isCurrentlyVisible()){
                             ProceedButton.waitUntilClickable();
                             ProceedButton.click();   
                             Common.WaitForClock(Clockobj);
                         }
                     }

					if (!sCustomise.equals("")){                                
						find(By.xpath(sCustomisePath)).click(); 
						//Thread.sleep(5000);
						Common.waitForPageLoad(getDriver());
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}

					if (!ChkFlag){
						report.Info(sItem+ " is not present");
						Assert.assertTrue(false);                                        
					}
					else if (ChkFlag){
						break;
					}

				}//PipeForLoop
			}//sLinkMain
			
			if(sItem.equals("MSISDN"))
			{                                         
				//find(By.xpath(sCustomisePath)).click(); 
				//VirtualLandCustomiseBtn.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				//VirtualLandCustomiseBtn.click();

				MSISDNTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				//MSISDNTextBox.click();   
				Common.WaitForClock(Clockobj);

				String OneNetMSISDN = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
				
				//String OneNetMSISDN = "44256584254";
				
				Thread.sleep(5000);
				//MSISDNTextBox.type(OneNetMSISDN);
				MSISDNTextBox.sendKeys(OneNetMSISDN);
				Thread.sleep(5000);
				//sikuliUtility.EnterMSISDN(SikulifilePath,OneNetMSISDN);

				MSISDNDoneBtn.click();
				Common.WaitForClock(Clockobj);

			}
			
			
		}//MainForLoop
		//Thread.sleep(5000);
		Common.waitForPageLoad(getDriver());
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		if (DoneButton.isCurrentlyVisible()){                                   
			DoneButton.waitUntilClickable();
			DoneButton.click();
			//LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();   
			Thread.sleep(2000);
			Common.WaitForClock(Clockobj);
			if(isAlertPresent(getDriver())&& !sPopup.equals("") ){
        		Alert alert = getDriver().switchTo().alert();
                String ActAlertText = alert.getText(); 
               sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                if (ActAlertText.contains(sPopup)){                    	
                	alert.accept();
                	report.Info("Popup occured : "+ActAlertText);
              		                	
                }                                 
            }
			else if (isAlertPresent(getDriver())) {
				Alert alert = getDriver().switchTo().alert();
                String ActAlertText = alert.getText(); 
                sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                alert.accept();
                report.Info("Popup occured : "+ActAlertText);
			}
			Thread.sleep(3000);
			Common.WaitForClock(Clockobj);
			
		}    

	}




	@FindBy(xpath=".//button[@title='Line Items:Customise']")
	WebElementFacade customiseButton;

	@FindBy(xpath=".//button[text()='Done']")
	WebElementFacade ss;

    @FindBy(xpath=".//*[@class='siebui-ctrl-btn appletButton'][contains(text(),'Add')]")
	WebElement EconfigDoneButtonSync;
	@Step
	public void CustomiseProduct(String Rownum) throws IOException, InterruptedException, AWTException{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "CustomiseProduct";
		//String applet = "//*[@title='Line Items List Applet']";
		//String table = "//table[@summary='Order Entry - Line Item List (Sales)']";	 

		String applet = "//*[contains(@class,'siebui-applet siebui-collapsible-applet siebui-list')]";
		String table = "//table[@class='ui-jqgrid-btable']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Rownum, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		//Thread.sleep(2000); 
		LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();


		LineItemsTab.click();//don't delete	   
		Thread.sleep(3000);//don't delete
		menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete

		for (int i = 0;i < tableMap.get("SelectItem").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			//String SelectItem = tableMap.get("SelectItem").get(i);
			String Index = tableMap.get("Index").get(i);

			if (Index.equals("")){
				Index = "0";
			}

			String LocateColMessage = sLocateCol+" Not Found";
			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true");
				report.Info(sLocateColValue+" found");
			}
			else 
			{
				Common.selectedRow = 1;
				report.Info(sLocateColValue+" found");
			}
			// customiseButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			//SessionVariableSetter CustomisestartTime = Serenity.setSessionVariable(System.currentTimeMillis());
			//Serenity.setSessionVariable("CustomisestartTime").to(System.currentTimeMillis());
			long startTime = System.currentTimeMillis();
			customiseButton.click();

			//Common.waitForElement(EconfigDoneButtonSync);
			Common.WaitForClock(Clockobj);

			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;

			Common.WritePerformanceOutput("Customise Clicked ,Total Time " + totalTime/1000);
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}



	@FindBy(xpath=".//*[@aria-labelledby='VF_Override_Credit_Vet_Label']")
	WebElementFacade CreditVettingCheckBox;
	@FindBy(xpath="//*[@aria-label='Line Details Selected']")
	WebElementFacade LineDetailsTab; 

	@Step
	public void CreditVettingResults() throws InterruptedException, IOException, AWTException{
		Common.waitForPageLoad(getDriver());
		
		Common.WaitForClock(Clockobj);
		LineItemsTab.click();
		Thread.sleep(2000);
		Common.WaitForClock(Clockobj);
		
		LineDetailsTab.click();
		Thread.sleep(2000);
		Common.WaitForClock(Clockobj);
		
		if (!CreditVettingCheckBox.isVisible()){
			LineItemsTab.click();
			//CreditVettingCheckBox.click();
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("arguments[0].click();", CreditVettingCheckBox); 
			
			getDriver().findElement(By.xpath(".//*[@aria-labelledby='VF_Override_Credit_Vet_Label']")).sendKeys(Keys.ALT,Keys.ENTER);
			//getDriver().navigate().refresh();
			Thread.sleep(1000);
			String CreditVettingChecked = CreditVettingCheckBox.getAttribute("aria-checked");
			if (CreditVettingChecked.equals("false")){
				//CreditVettingCheckBox.click(); 
				js.executeScript("arguments[0].click();", CreditVettingCheckBox); 
			}
			report.Info("CreditVettingCheckBox clicked");
		}
		else {
			CreditVettingCheckBox.withTimeoutOf(10, TimeUnit.SECONDS);
			//CreditVettingCheckBox.click();
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("arguments[0].click();", CreditVettingCheckBox); 
			report.Info("CreditVettingCheckBox clicked");
		}    		
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		  
	
		//second time check
		Common.WaitForClock(Clockobj);
		LineItemsTab.click();
		Thread.sleep(2000);
		Common.WaitForClock(Clockobj);
		
		LineDetailsTab.click();
		Thread.sleep(2000);
		Common.WaitForClock(Clockobj);
		
		if (CreditVettingCheckBox.isVisible()){
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			String CreditVettingChecked = CreditVettingCheckBox.getAttribute("aria-checked");
			if (CreditVettingChecked.equals("false")){
				//CreditVettingCheckBox.click(); 
				js.executeScript("arguments[0].click();", CreditVettingCheckBox); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			report.Info("CreditVettingCheckBox clicked");
		}
	
	}  
	
    @FindBy(xpath = "//li/a[text()='Credit Vetting']")
    WebElementFacade CreditVettingLink;

    @FindBy(xpath = "//button/span[text()='Create Order']")
    WebElementFacade CreditVetCreateOrderButton;

    @FindBy(xpath = "//li/a[text()='Line Items']")
    WebElementFacade LineItemsLink;

    @FindBy(xpath = "//button/span[text()='Credit Vet']")
    WebElementFacade CreditVetButtonOrderPage;

    @FindBy(xpath = "//input[@aria-label='Outcome']")
    WebElementFacade TransactOutcomeTextBox;

    // Performs E2E credit vet and Validates Transact OutCome
    @Step
    public void transactCreditVetAndValidateOutcome(String logicalName) throws Exception {
          Common.waitForPageLoad(getDriver());
          String filePath = "\\src\\test\\resources\\data\\Order.xls";
          String dataSheet = "TransactCreditVet";
          String SikulifilePath = "\\src\\test\\resources\\SikuliImages";

          Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(logicalName, filePath, dataSheet);
          readWorkbook.testData(tableMap);
          for (int i = 0; i < tableMap.get("RowNo").size(); i++) {
                // reads transact outcome value from excel- Accept , Refer Or Decline
                String sOutcome = tableMap.get("Outcome").get(i);

                if (!CreditVetButtonOrderPage.withTimeoutOf(10, TimeUnit.SECONDS).isCurrentlyVisible()) {
                      LineItemsLink.click();
                      sikuliUtility
                            .SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                }

                if (CreditVetButtonOrderPage.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilClickable()) {
                      CreditVetButtonOrderPage.click();
                      report.Info("Credit Vet Button Clicked");
                      sikuliUtility
                            .SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

                }

                String actualOutcome = "";
                actualOutcome = TransactOutcomeTextBox.getTextValue();

                if (actualOutcome.equalsIgnoreCase("")) {
                      Assert.assertFalse("Credit Vet Outcome is blank : Credit Vet Not Performed Successfully", false);
                } else {
                      Assert.assertTrue("Failed: Actual credit vet Outcome is " + actualOutcome,
                                  actualOutcome.equalsIgnoreCase(sOutcome));
                }

          }

    }

	

	@FindBy(xpath=".//*[@aria-label='Sales Order:Buyback']")
	WebElementFacade BuyBackButton;
	@FindBy(xpath=".//*[@aria-label='Terms and conditions']")
	WebElementFacade TandCheckBox;
	@FindBy(xpath=".//*[@aria-label='Sales Order:Verify']")
	WebElementFacade VerifyButton;
	@FindBy(xpath=".//*[@aria-labelledby='Message_Text_Label']")
	WebElementFacade VerifyMessage;
	@FindBy(xpath=".//*[@aria-label='Messages:Close']")
	WebElementFacade VerifyMessageCloseButton;
	@FindBy(xpath=".//*[@aria-label='Messages:Close']")
	WebElement VerifyMessageCloseButtonSync;
	@FindBy(xpath=".//*[@aria-labelledby='Verified_Label']")
	WebElementFacade VerifyCheckBox;
	@FindBy(xpath=".//*[@aria-label='Sales Order:Submit']")
	WebElementFacade SubmitButton;
	@FindBy(xpath=".//*[@aria-label='Return reason']")
	WebElementFacade ReturnReasonTextBox;
	@FindBy(xpath=".//*[@aria-label='Disconnection reason']")
	WebElementFacade DisconnectionReasonTextBox;
	@FindBy(xpath=".//*[@title='Sales Order:Show more']")
	WebElementFacade OrdersPageShowMoreButton;
	@FindBy(xpath=".//*[@aria-label='Verified']//preceding::*[@aria-label='Status']")
	WebElementFacade OrdersStatus;            
	@FindBy(xpath=".//*[@aria-label='Sales Order:Menu']")	
	WebElementFacade OrderHeaderMenuButton;
	@FindBy(xpath="//span/ul/li[9]/a")
	WebElementFacade RefreshMenuItem;
	@FindBy(xpath=".//*[@title='Sales Order:Asset All']")
	WebElementFacade AssetAllButton;
	@FindBy(xpath=".//*[@aria-label='Fulfillment status']")
	WebElementFacade FulFillmentStatusTextBox;


	@FindBy(xpath=".//*[@aria-label='Verified']")
	WebElementFacade VerifiedCheckBox;


	@Step
	public void OrderFormEntry(String Action) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, SQLException, AWTException{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "OrderFormEntry";
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		long SubmitOrderstartTime = 0l;
		for (int i = 0;i < tableMap.get("Popup").size();i++) {
			String sDisconnectionReason = tableMap.get("DisconnectionReason").get(i);
			String sReturnReason = tableMap.get("ReturnReason").get(i);
			String sJourney = tableMap.get("Journey").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sClickSubmit = tableMap.get("ClickSubmit").get(i);
			String sOrderStatusCheck = tableMap.get("OrderStatusCheck").get(i);
			String TCvalidaton = tableMap.get("TCvalidaton").get(i);
			String sClickVerify = tableMap.get("ClickVerify").get(i);
			String sReSendLabel = tableMap.get("ReSendLabel").get(i);
			Alert alert;
			String ActAlertText="";

			if (sPopup.equals("")){
				sPopup = "No";
			}
			/*if(!LineItemsApplet.isVisible()){
                          LineItemsTab.click();
                          Thread.sleep(3000);//don't delete
                  		menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete

                    }*/ 
			//   LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete
			Common.waitForElement(LineItemsTabWebElement);
			LineItemsTab.click();
			Thread.sleep(2000);//don't delete
			TandCheckBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete

			//For buy back scenario        
			if (sJourney.equalsIgnoreCase("Buyback")){
				BuyBackButton.waitUntilClickable();
				BuyBackButton.click();
				Common.waitForPageLoad(getDriver());
				report.Info("Buyback Button clicked");
				break;                              
			}

			//Click T&C
			//TandCheckBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			if(!TCvalidaton.equalsIgnoreCase("No")){
				   TandCheckBox.click();
				}

			if(TCvalidaton.equalsIgnoreCase("Yes")){
				TandCheckBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				//for uncheck TermsAndCheck box---don't delete
				TandCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			//For Disconnection scenario            
			if (!sDisconnectionReason.equals("")){
				if (DisconnectionReasonTextBox.isCurrentlyVisible()){                                  
					//DisconnectionReasonTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();    
					Common.waitForPageLoad(getDriver());
					DisconnectionReasonTextBox.type(sDisconnectionReason);
					report.Info("Disconnection Reason entered : "+sDisconnectionReason);
				}
				else if (!DisconnectionReasonTextBox.isCurrentlyVisible()) {
					Common.waitForPageLoad(getDriver());
					//OrdersPageShowMoreButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					OrdersPageShowMoreButton.click();
					Common.waitForPageLoad(getDriver());
					// DisconnectionReasonTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();
					DisconnectionReasonTextBox.type(sDisconnectionReason);
					report.Info("Disconnection Reason entered : "+sDisconnectionReason);
				}  

			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			//For Return scenario        
			if (!sReturnReason.equals("")){
				if (ReturnReasonTextBox.isCurrentlyVisible()){
					//ReturnReasonTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();
					Common.waitForPageLoad(getDriver());
					ReturnReasonTextBox.type(sReturnReason);
					report.Info("Return Reason entered : "+sReturnReason);
				}
				else if (!ReturnReasonTextBox.isCurrentlyVisible()){
					//OrdersPageShowMoreButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					Common.waitForPageLoad(getDriver());
					OrdersPageShowMoreButton.click();
					//ReturnReasonTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();
					Common.waitForPageLoad(getDriver());
					ReturnReasonTextBox.type(sReturnReason);
					report.Info("Return Reason entered : "+sReturnReason);
				}                             
			}
			
			if (sClickVerify.equalsIgnoreCase("")){
				
				VerifyButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				//commented as popup not handled   //   Common.waitForPageLoad(getDriver());
				
				
				VerifyButton.click();
				Thread.sleep(2000);
				if(isAlertPresent(getDriver())){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText(); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					if (ActAlertText.contains("Store and Email")){
						alert.accept();
						report.Info("alert messsage is"+ActAlertText);
					} 
				}
				Common.WaitForClock(Clockobj);
				
			}
			
			long startTime = System.currentTimeMillis();
			if (isAlertPresent(getDriver())){
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;

				Common.WritePerformanceOutput("Order Verified ,Total Time " + totalTime/1000);
			}
			else{
				Common.waitForElement(VerifyMessageCloseButtonSync);
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;

				Common.WritePerformanceOutput("Order Verified ,Total Time " + totalTime/1000);
			}
			
			
			Thread.sleep(2000);
			
			
			startTime = System.currentTimeMillis();

			if (sJourney.equalsIgnoreCase("Validation")){
				// sikuliUtility.ClickJILLPopUp(SikulifilePath);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(isAlertPresent(getDriver())){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText(); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					if (ActAlertText.contains("JILL")){
						alert.accept();
						report.Info("alert messsage is"+ActAlertText);
					} 

				}
				//VerifyMessage.withTimeoutOf(40, SECONDS).waitUntilPresent();

				Thread.sleep(5000);
				//commented as popup not handled  //Common.waitForPageLoad(getDriver());
				if(isAlertPresent(getDriver())&& (!sPopup.equalsIgnoreCase("No"))){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText();  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					String sPopup1=sPopup;
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
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					Assert.assertTrue(false);                                  
				}                                                      
			}

			
			Common.waitForElement(VerifyMessageCloseButtonSync);
			
			if (VerifyMessage.isCurrentlyVisible() ){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				VerifyMessageCloseButton.waitUntilClickable();
				VerifyMessageCloseButton.click();
				report.Info("Verify Message close button Clicked");                                
			}
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;

			Common.WritePerformanceOutput("Order Verified ,Total Time " + totalTime/1000);

			//Click Submit Button    
			if (!sClickSubmit.equals("N")){
				
				SubmitButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				
				SubmitOrderstartTime = System.currentTimeMillis();
				
				SubmitButton.click();
				Thread.sleep(1000);
				Common.WaitForClock(Clockobj);
				
				if (sReSendLabel.equals("Y")){
					//DeliveryTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
					Common.waitForElement(DeliveryTabSync);
					DeliveryTab.click();
					Thread.sleep(2000);
					ReSendLabel.click();
					if(SelectEmailAddressCancel.isVisible())
					{
						SelectEmailAddress.typeAndEnter("Account holder Email");
						Thread.sleep(3000);
						SelectEmailAddressOk.click();			   
						return;
					} 
				}
				
				if(isAlertPresent(getDriver())&& (!sPopup.equalsIgnoreCase("No"))){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText();  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					String sPopup1=sPopup;
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
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					Assert.assertTrue(false);                            
				}  
				report.Info("Submit button Clicked");
				endTime = System.currentTimeMillis();
				totalTime = endTime - SubmitOrderstartTime;    
				Common.WritePerformanceOutput("Order Submitted ,Total Time " + totalTime/1000);
				/*OrderDescriptionVerfy("PerformAboutRecord");
                      OrdermenuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                      OrdermenuItemIcon.click();
                      Thread.sleep(4000);
                      aboutRecord.click();
                      Thread.sleep(1000);
                      getAboutRecord();
                      Database.ExecuteDBQuery("CompleteTheOrder");
                      Database.ExecuteDBQuery("CompleteTheOrder1");*/
			}

			//To check OrderStatus  
			long OrderstatusstartTime = System.currentTimeMillis();
			if (!sOrderStatusCheck.equals("")){
				String Order = OrderNo.getTextValue();
				String Status = OrdersStatus.getTextValue();
				i = 0;

				do{
					Thread.sleep(2000);
					/* if (AssetAllButton.isVisible()){
                                    AssetAllButton.click();
                                    Thread.sleep(8000);
                              }*/                              
					//getDriver().findElement(By.xpath(".//*[@aria-label='Sales Order:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
					getDriver().findElement(By.xpath(".//*[@aria-label='Sales Order:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
					/* OrderHeaderMenuButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                              OrderHeaderMenuButton.click();
                              Thread.sleep(1000);
                              RefreshMenuItem.click();
                              Thread.sleep(1000);
					*/
					Thread.sleep(2000);
					Status = OrdersStatus.getTextValue();
					if(Status.equals("Complete")){


						break;                                          
					}
					/*					String sFulFillmentStatusTextBox = FulFillmentStatusTextBox.getTextValue();
					if(sFulFillmentStatusTextBox.equals("Failed"))
					{
						report.Info("Fulfillment status is Failed");
						Assert.assertTrue(false);						
						break;						
					}*/

					i++;
				}while(!Status.equals("Complete") && i <=150);                          
				Assert.assertTrue("Status of Order "+Order+ "is "+Status,Status.equals("Complete") );
				/*long OrderstatusendTime = System.currentTimeMillis();
                        long orderstatustotalTime = OrderstatusendTime - OrderstatusstartTime;
                        report.Info("Order Complete,Total Time " + orderstatustotalTime/1000); */

			}                       

			if(sJourney.equalsIgnoreCase("Verify Checked")){
				String VerifyCheckBoxValue = VerifiedCheckBox.getAttribute("value");
				Assert.assertTrue("Verified button is not checked after submission", VerifyCheckBoxValue.equalsIgnoreCase("Y"));
				report.Info("Verified button is checked after submission");
			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}
	}     


	@FindBy(xpath=".//*[@class='siebui-applet-title'][text()='Line Items']")
	WebElementFacade LineItemsApplet;

	@FindBy(xpath="//a[text()='Line Items']")
	WebElementFacade LineItemsTab;

	@FindBy(xpath="//a[text()='Line Items']")
	WebElement LineItemsTabWebElement;

	@FindBy(xpath="//input[@aria-label='Outcome']")
	WebElementFacade OutcomeTextBox;

	@FindBy(xpath=".//*[@aria-label='User account']")
	WebElementFacade UserAccountElement;
	
	@FindBy(xpath=".//*[@aria-label='User account']")
	WebElement UserAccountElementWebElement;

	@FindBy(xpath=".//*[@aria-label='User account']")
	WebElementFacade UserAccountTextBox;

	//@FindBy(xpath=".//*[@id='s_4_2_203_0_icon']")
	@FindBy(xpath=".//*[@aria-label='User account']/following-sibling::span")
	WebElementFacade UserAccountPopUp;
	
	@FindBy(xpath=".//*[@aria-label='User account']/following-sibling::span")
	WebElement UserAccountPopUpWebElement;

	@FindBy(xpath="//span[text()='Pick Account']")
	WebElementFacade PickAccountPopup;

	@FindBy(xpath=".//*[@title='Pick Account:OK']")
	WebElementFacade PickAccountOKButton;

	@FindBy(xpath=".//*[@id='1_s_4_l_Contact_Last_Name']")
	WebElementFacade LastNameElement;

	@FindBy(xpath=".//*[@id='1_s_4_l_Contact_Last_Name']")
	WebElement LastNameElementWebElement;
	
	@FindBy(xpath=".//*[@id='1_Contact_Last_Name']")
	WebElementFacade LastNameTextBox;

	//@FindBy(xpath=".//*[@id='s_4_2_110_0_icon']")
	@FindBy(xpath="(.//td[contains(@id,'Contact_Last_Name')])[1]/span")
	WebElementFacade LastNamePopup;
	
	@FindBy(xpath="(.//td[contains(@id,'Contact_Last_Name')])[1]/span")
	WebElement LastNamePopupWebElement;

	@FindBy(xpath="//span[text()='Pick Contact']")
	WebElementFacade PickContactPopup;

	@FindBy(xpath=".//*[@title='Pick Contact:OK']")
	WebElementFacade PickContactOKButton;

	@FindBy(xpath=".//*[@aria-label='Line Items:Menu']")
	WebElementFacade LineItemsMenuIcon;

	@FindBy(xpath=".//*[@aria-label='Line Items:Menu']")
	WebElement LineItemsMenuIconWebElement;
	
	@FindBy(xpath=".//*[@aria-label='Discount amount']")
	WebElementFacade DiscountAmount;
	@FindBy(xpath=".//*[@aria-label='Discount Reason']")
	WebElementFacade DiscountReason;
	@FindBy(xpath=".//*[(contains(text(),' Cost Override rather than Discount '))]")
	WebElementFacade ExpectedBlockingPopUp;
	@FindBy(xpath=".//*[@aria-label='Line Items:Delete']")
	WebElementFacade LineItemDeletebutton;

	@FindBy(xpath=".//input[@aria-label='Eligibility status']")
	WebElementFacade EligibilityStatus;



	@Step
	public void OrdersLineItemsVerify(String Action) throws IOException, InterruptedException, AWTException{

		//LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		Common.WaitForClock(Clockobj);
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "LineItems";
		//String applet = "//*[@title='Line Items List Applet']";
		// String table = "//table[@summary='Order Entry - Line Item List (Sales)']";
		String applet = "//*[contains(@class,'siebui-applet siebui-collapsible-applet siebui-list')]";
		String table = "//table[@class='ui-jqgrid-btable']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {
			if(!LineItemsApplet.isVisible()){
				LineItemsTab.click();
				Thread.sleep(3000);//don't delete
				Common.WaitForClock(Clockobj);
				menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete

			}      

			int LineItemListRowCount = findAll(By.xpath("//table[@class='ui-jqgrid-btable']/tbody/tr")).size();
			if(LineItemListRowCount>1){
				report.Info("Items are displayed successfully.");
			}
			else{
				Assert.assertTrue("Items are not displayed successfully.", LineItemListRowCount>1);
			}
			String sVerifyOutcome = tableMap.get("VerifyOutcome").get(i);
			String sLocateColExpand = tableMap.get("LocateColExpand").get(i);
			String sLocateColExpandValue = tableMap.get("LocateColExpandValue").get(i);         
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      
			String sExist = tableMap.get("Exist").get(i);
			String Index = tableMap.get("Index").get(i);
			String sCollapse = tableMap.get("Collapse").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);
			String ExpandIndex = tableMap.get("ExpandIndex").get(i);

			if (sLocateColExpandValue.equals("RootProduct0")){
				sLocateColExpandValue = Serenity.sessionVariableCalled("RootProduct0").toString();
			}

			if (sLocateColValue.contains("Promotion")){
				sLocateColValue = sLocateColValue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());    	  
			}

			if (sLocateColValue.contains("RootProduct0")){
				sLocateColValue = sLocateColValue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}
			if (Index.equals("")){
				Index = "0";
			}      
			if (ExpandIndex.equals("")){
				ExpandIndex = "0";
			}

			if(!sLocateColExpand.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateColExpand, sLocateColExpandValue, ExpandIndex).equals("true"));             
				//report.Info("found");
				Common.ExpandRow(applet,table);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else {
				Common.selectedRow = 1;
			}
			if(sVerifyOutcome.equalsIgnoreCase("RootProductExpand")){
				String prevRecord = "";
				String currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
				do{
					prevRecord = currRecord;
					getDriver().findElement(By.xpath(applet+"//*[@title='Next record set']")).click();
					currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				} while (!currRecord.equals(prevRecord));
			}
			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				String res  = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index);
				//Assert.assertTrue(sReturnVal, sReturnVal.equals("true"));
				
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
				Common.selectedRow = 1;
			}

			if (!sUIName.equals("")){ 
				String sValue =  (Common.updateSiebList(applet,table, sUIName, svalue)); 
				/*if (sUIName.contains("CaptureTextValue|Service_Id")){	
					Serenity.setSessionVariable("RECONNECTIONICCID").to(sValue);
				}*/
				/* if (sUIName.contains("CaptureTextValue|Service_Id")){	
            	   Serenity.setSessionVariable("RECONNECTIONMSISDN").to(sValue);
               }*/
				
				if (svalue.contains("RECONNECTIONICCID")){	
					Serenity.setSessionVariable("RECONNECTIONICCID").to(sValue);
				}
				
				
				if (svalue.contains("RECONNECTIONMSISDN")){	
					Serenity.setSessionVariable("RECONNECTIONMSISDN").to(sValue);
				} 
				
				report.Info("Row updated successfully"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			} 

			if(sVerifyOutcome.equalsIgnoreCase("GetRowID")){
				LineItemsMenuIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				LineItemsMenuIcon.click();
				Thread.sleep(2000);
				aboutRecord.click();
				report.Info("About Record Selected");
			}
			
			if(sVerifyOutcome.equalsIgnoreCase("EligibilityStatus")){
				String sEligibilityStatus = EligibilityStatus.getTextValue();
				EligibilityStatus.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Eligibility Status is Y", sEligibilityStatus.equalsIgnoreCase("N"));
				
					report.Info("As expected Eligibility Status is N");
				}
	

			//String sAction = "Run Query [Alt+ENTER]";

			if(!sCollapse.equals("")){
				//Common.waitForElement(LineItemsMenuIconWebElement);
				Common.WaitForClock(Clockobj);
				OrderNo.sendKeys(Keys.chord(Keys.ALT, Keys.ENTER));
				/*LineItemsMenuIcon.click();
				Thread.sleep(1000);
				RefreshRecord.click();
				Thread.sleep(1000);	*/			
			}

			if(sVerifyOutcome.equalsIgnoreCase("OneOffCostCheck")){
				DiscountAmount.typeAndEnter("100");
				Thread.sleep(3000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());    	   
				Thread.sleep(3000);
				getDriver().navigate().refresh();  

			}

			if(sVerifyOutcome.equals("BlockingErrorMsgForOffCost")){
				DiscountAmount.type("55");
				Thread.sleep(3000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());    	   
				Thread.sleep(3000);
				DiscountReason.click();
				if(ExpectedBlockingPopUp.isCurrentlyVisible()) {
					report.Info("Expected Popup occured : Please use Cost Override rather than Discount % or Discount Amount to change value of Credit Product.");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());    	   
				}
				else {
					Assert.assertTrue(false);
				}
				break;
			}			

			
			if(sVerifyOutcome.equalsIgnoreCase("Declined")||sVerifyOutcome.equalsIgnoreCase("Accept")){
				String sOutcomeActual=OutcomeTextBox.getTextValue();
				if((sOutcomeActual.trim()).equalsIgnoreCase(sVerifyOutcome.trim())){
					report.Info("Outcome is : "+sOutcomeActual);
				}
				else{
					String OutcomeResult = "Outcome is : " + sOutcomeActual;
					Assert.assertTrue(OutcomeResult, (sOutcomeActual.trim()).equalsIgnoreCase(sVerifyOutcome.trim())); 
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}

			if(sVerifyOutcome.equalsIgnoreCase("OneOffCostCheckForZeroDiscount")){
				Thread.sleep(3000);
				DiscountAmount.typeAndEnter("0");
				Thread.sleep(3000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());    	   
				getDriver().navigate().refresh();  

			}
			if(sVerifyOutcome.equalsIgnoreCase("ServiceAccountLastName")){
				Common.waitForElement(UserAccountElementWebElement);
				UserAccountElement.click();
				String UserAccountTextBoxReadOnly = UserAccountTextBox.getAttribute("readonly");
				if(UserAccountTextBoxReadOnly!=null){
					Assert.assertTrue("Service Account is not editable.", !UserAccountTextBoxReadOnly.equalsIgnoreCase("true"));
					break;

				}
				else{
					report.Info("Pass - Service Account is editable..");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				}
				//Common.waitForElement(UserAccountPopUpWebElement);
				Thread.sleep(4000);
				UserAccountPopUp.click();
				Thread.sleep(4000);
				PickAccountPopup.waitUntilVisible();
				if(PickAccountPopup.isVisible()){
					int PickAccountRowCount = findAll(By.xpath("//table[@summary='Pick Account']/tbody/tr")).size();
					if(PickAccountRowCount>1){
						report.Info("Pass - Rows are displayed. Service Account is editable..");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					}
					else{
						Assert.assertTrue("No rows displayed. Service Account is not editable.", PickAccountRowCount>1);
						break;
					}
					PickAccountOKButton.click();
				}

				Common.waitForElement(LastNameElementWebElement);
				LastNameElement.click();
				String LastNameTextBoxReadOnly = LastNameTextBox.getAttribute("readonly");
				if(LastNameTextBoxReadOnly!=null){

					Assert.assertTrue("Last Name is not editable.", !LastNameTextBoxReadOnly.equalsIgnoreCase("true"));
					break;
				}
				else{
					report.Info("Pass - Last Name is editable..");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				}
				//Common.waitForElement(LastNamePopupWebElement);
				Thread.sleep(4000);
				LastNamePopup.click();
				Common.WaitForClock(Clockobj);
				Thread.sleep(4000);
				PickContactPopup.waitUntilVisible();
				if(PickContactPopup.isVisible()){
					int PickContactRowCount = findAll(By.xpath("//table[@summary='Pick Contact']/tbody/tr")).size();
					if(PickContactRowCount>1){
						report.Info("Pass - Rows are displayed. Last Name is editable..");
					}
					else{
						Assert.assertTrue("No rows displayed. Last Name is not editable.", PickContactRowCount>1);
						break;
					}
					PickContactOKButton.click();

				}
			}
			
			if (sVerifyOutcome.contains("Delete")) {
				LineItemDeletebutton.isCurrentlyVisible();
				LineItemDeletebutton.click();
				
					Alert alert=getDriver().switchTo().alert();
					String ActAlertText=alert.getText();  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					                                                                              
					if (ActAlertText.contains("Are you sure you want to delete the")){                		
						alert.accept();
						report.Info("alert messsage is"+ActAlertText);
					} 
					
					getDriver().navigate().refresh();
					Thread.sleep(1000);
					Common.WaitForClock(Clockobj);
				
				
			}
		}
		Common.WaitForClock(Clockobj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}


	@FindBy(xpath=".//*[@aria-label='Find'][@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade SelectCategoryTextBox;

	@FindBy(xpath=".//*[@aria-label='Starting with'][@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElementFacade EnterProductTextBox;

	@FindBy(xpath=".//*[@title='Add Product:Go']")
	WebElementFacade GoButton;

	@FindBy(xpath=".//*[@title='Add Product:Select']")
	WebElementFacade AddButton;

	@FindBy(xpath=".//tr[@id='1']/td[contains(@id,'Product_Quantity')]")
	WebElementFacade ProductQuantityElement1;

	//.//input[contains(@aria-label,'Quantity')]
	//.//input[contains(@id,'Product_Quantity')]
	@FindBy(xpath=".//input[contains(@id,'Product_Quantity')]")
	WebElementFacade ProductQuantityTextBox1;
	@FindBy(xpath=".//*[@title='Edit Package:Done']")
	WebElementFacade EditpackageDoneButton;

	@FindBy(xpath=".//tr[@id='2']/td[contains(@id,'Product_Quantity')]")
	WebElementFacade ProductQuantityElement2;

	@FindBy(xpath=".//input[contains(@aria-label,'Quantity')]")
	WebElementFacade ProductQuantity;
	//.//*[@name='Product_Quantity']

	@FindBy(xpath=".//*[@id='2_Product_Quantity']")
	WebElementFacade ProductQuantityTextBox2; 

	@FindBy(xpath=".//table[@summary='Add-ons']/tbody/tr[2]/td/span")
	WebElementFacade SelectFirstApple; 

	@FindBy(xpath=".//table[@summary='Add-ons']/tbody/tr[2]/td/span")
	WebElement SelectFirstAppleWebElement; 
	@FindBy(xpath=".//div[text()='Add to the Plan']")
	WebElementFacade AddProductApplet;
	 @FindBy(xpath=".//div[contains(@class,'popup-info')]  ")
	  WebElementFacade ErrorMsg; 

	@Step
	public void AddProduct(String Product) throws IOException, InterruptedException, AWTException{  
		Common.waitForPageLoad(getDriver());
		Common.WaitForClock(Clockobj);

		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "AddProduct";
		String table = "//table[@summary='Add Product']";
		String applet = "//*[@title='Add Product List Applet']";
		Thread.sleep(5000);
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Product, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		long AddProductstartTime = 0l;
		for (int i = 0;i < tableMap.get("Row").size();i++) {
			String sAddProduct = tableMap.get("AddProduct").get(i);
			String sQuantity = tableMap.get("Quantity").get(i);
			String sProductName = tableMap.get("ProductName").get(i);
			String sMultiHandset = tableMap.get("MultiHandset").get(i);      
			//String indexValue = tableMap.get("Index").get(i);
			String sProductID = tableMap.get("ProductID").get(i);
			String sAddProduct2 = tableMap.get("AddProduct").get(i);
			String AddButtonXpath = "";  

			// AddProductApplet.withTimeoutOf(180,TimeUnit.SECONDS).isDisplayed();
			AddProductstartTime = System.currentTimeMillis();
			if(sAddProduct.contains("|")){
				String[] AddProduct1 = sAddProduct.split(Pattern.quote("|"));
				for (int k=0; k< AddProduct1.length; k++)
				{
					//String AddProductPath = ".//a[text()='"+AddProduct1[k]+"']";
					//String ProductWebElementXpath = ".//*[text()='"+AddProduct1[k]+"']/parent::span";
					String ProductWebElementXpath = ".//*[contains(text(),'"+AddProduct1[k]+"')]/parent::span";

					boolean recordindex1 = findBy(ProductWebElementXpath).isPresent();
					if(recordindex1 == true){
						report.Info(AddProduct1[k]+ " found"); 
						String recordindex = findBy(ProductWebElementXpath).getAttribute("recordindex");             
						AddButtonXpath = "//button[@recordindex='"+recordindex+"']";
						break;
					}                   
				}                         
			}
			else{
				String ProductWebElementXpath = ".//*[contains(text(),'"+sAddProduct+"')]/parent::span"; 

				if(!sAddProduct2.equals("")){
					ProductWebElementXpath = ".//*[contains(text(),'"+sAddProduct2+"')]/parent::span"; 
				}

				String recordindex = findBy(ProductWebElementXpath).getAttribute("recordindex");             
				AddButtonXpath = "//button[@recordindex='"+recordindex+"']";

			}


			if(findBy(AddButtonXpath).isVisible()){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				WebElement element3 = getDriver().findElement(By.xpath(AddButtonXpath));
	             JavascriptExecutor executor3 = (JavascriptExecutor)getDriver();
	             executor3.executeScript("arguments[0].click();", element3);
	             Common.WaitForClock(Clockobj);
				//findBy(AddButtonXpath).click();
			}
			else if (!findBy(AddButtonXpath).isVisible()) {           
				Assert.assertTrue("Fail, Product: "+sAddProduct+" is not available on page.", findBy(AddButtonXpath).isVisible());
			}
			Common.WaitForClock(Clockobj);

//For Insurance, Vodafone Insurance, Blank White Triple Sim
			if(sAddProduct.contains("Insurance")||sAddProduct.contains("insurance")||sAddProduct.contains("Vodafone")||sAddProduct.contains("Fixed Service")||sAddProduct.contains("Blank White Triple Format SIM")){
				//EditpackageDoneButton.withTimeoutOf(180,TimeUnit.SECONDS).waitUntilClickable();
				Common.waitForPageLoad(getDriver());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				long startTime = System.currentTimeMillis();
				Common.WaitForClock(Clockobj);
				Thread.sleep(5000);
				if(ErrorMsg.isCurrentlyVisible()) {
					String msg= ErrorMsg.getText();
					if(msg.contains("An end of file error has occurred")) {
						Robot robot = new Robot();	 
						robot.keyPress(KeyEvent.VK_F5);	
						robot.keyRelease(KeyEvent.VK_F5);
					}
					Common.waitForPageLoad(getDriver());
				}
						
				EditpackageDoneButton.click();
				Thread.sleep(15000);//please do not delete
				Common.WaitForClock(Clockobj);
				Common.waitForPageLoad(getDriver());
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				Common.WritePerformanceOutput("Edit Button clicked ,Total Login Time " + totalTime/1000);
				return; 
			}

//Adding Product Via Product Name
			if(!sProductName.equals("")){
					//SelectCategoryTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
					Common.waitForPageLoad(getDriver());
					Serenity.setSessionVariable("HandsetName").to(sProductName);
					//Thread.sleep(4000);
				/*	SelectCategoryTextBox.clear();
					SelectCategoryTextBox.type("Product name");*/
					
					//EnterProductTextBox.type(sProductName);
					Common.WaitForClock(Clockobj);
					EnterProductTextBox.sendKeys(sProductName);
					
					GoButton.click();
					Common.WaitForClock(Clockobj);
	
					Common.waitForElement(SelectFirstAppleWebElement);
					int AddProductTableSize= findAll(By.xpath("//table[@summary='Add-ons']/tbody/tr")).size();
					if(AddProductTableSize>1){                  
						//Thread.sleep(2000);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Common.waitForElement(SelectFirstAppleWebElement);
						SelectFirstApple.click();
						Thread.sleep(2000);   
						Common.WaitForClock(Clockobj);
						report.Info(sProductName+ "Added");        
					} 
					else{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						Assert.assertTrue("No rows displayed after clicking on Go button- Handset not available", AddProductTableSize>1);
					}                                                     
			}

//adding second product
			if(sMultiHandset.equalsIgnoreCase("Y")){
				
				Common.waitForPageLoad(getDriver());
				if(AddButton.isCurrentlyVisible())
				{
					AddButton.click();
					Common.WaitForClock(Clockobj);
				}
				Common.waitForPageLoad(getDriver());
				
					if(findBy(AddButtonXpath).isVisible()){
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						findBy(AddButtonXpath).click();
					}
					else if (!findBy(AddButtonXpath).isVisible()) {           
						Assert.assertTrue("Fail, Product: "+sAddProduct+" is not available on page.", findBy(AddButtonXpath).isVisible());
					}
					Common.WaitForClock(Clockobj);
	
					if(!sProductName.equals("")){
						//SelectCategoryTextBox.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
						Common.waitForPageLoad(getDriver());
						//Thread.sleep(4000);
						SelectCategoryTextBox.clear();
						SelectCategoryTextBox.type("Product name");
						
						//EnterProductTextBox.type(sProductName);
						EnterProductTextBox.sendKeys(sProductName);
						
						EnterProductTextBox.sendKeys(Keys.chord(Keys.ENTER));
						Common.WaitForClock(Clockobj);
						//GoButton.click();                                                                                  
	
					}           
			}
//Adding Product Via Product ID
			if(!sProductID.equals("")){
					Thread.sleep(2000);
					SelectCategoryTextBox.clear();
					Thread.sleep(1000);
					SelectCategoryTextBox.type("Product Id");
					Thread.sleep(1000);
					
					EnterProductTextBox.sendKeys(sProductID);
					
					EnterProductTextBox.sendKeys(Keys.chord(Keys.ENTER));
					Common.WaitForClock(Clockobj);
					//GoButton.click();
					                                                                                          
				
				Common.waitForElement(SelectFirstAppleWebElement);
				int AddProductTableSize= findAll(By.xpath("//table[@summary='Add-ons']/tbody/tr")).size();
				if(AddProductTableSize>1){                  
					//Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.waitForElement(SelectFirstAppleWebElement);
					SelectFirstApple.click();
					Thread.sleep(2000);                  
					report.Info(sProductID+ "Added");         
				} 
				else if (AddProductTableSize==1) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("No rows displayed after searching handset");
					Assert.assertTrue(false);
				} 
			}
			
			 long startTime = System.currentTimeMillis();
			 if(AddButton.isCurrentlyVisible())
				{
					 AddButton.click();
					 Common.WaitForClock(Clockobj);
				}
			Common.waitForPageLoad(getDriver());
			
			
			
			
			if(ErrorMsg.isCurrentlyVisible()) {
				String msg= ErrorMsg.getText();
				if(msg.contains("An end of file error has occurred")) {
					Robot robot = new Robot();	 
					robot.keyPress(KeyEvent.VK_F5);	
					robot.keyRelease(KeyEvent.VK_F5);
				}
				Common.waitForPageLoad(getDriver());
			}
					
			
    	   	long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			Common.WritePerformanceOutput("Add Button clicked,Total Time " + totalTime/1000);
			
			
			Thread.sleep(5000);
			Common.WaitForClock(Clockobj);
			Common.waitForPageLoad(getDriver());

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			EditpackageDoneButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
			EditpackageDoneButton.click();
			Thread.sleep(5000);
			Common.waitForElement(LineItemsTabWebElement);
			
			if(LineItemsTab.isCurrentlyEnabled())
			{
				LineItemsTab.click();
				Common.WaitForClock(Clockobj);
			}
			Common.waitForPageLoad(getDriver());
			String sErrorPopup="OPTIONAL:An error happened during";
			//Common.HandleErrorPopUp(sErrorPopup);
			
			if(isAlertPresent(getDriver())){
				Alert alert=getDriver().switchTo().alert();
				String ActAlertText=alert.getText();  
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				                                                                              
				if (ActAlertText.contains(sErrorPopup)){                		
					alert.accept();
					report.Info("alert messsage is"+ActAlertText);
				}                        
			}
			Common.WaitForClock(Clockobj);
		}

	}




	@FindBy(xpath=".//span[text()='Help']")
	WebElementFacade HelpMenu;

	@FindBy(xpath="//a[text()='About View...']")
	WebElementFacade AboutView;

	@FindBy(xpath="//*[@title='About View Form Applet']")
	WebElementFacade AboutViewApplet;

	@FindBy(xpath=".//*[@title='About View:OK']")
	WebElementFacade AboutViewOKButton;


	@Step
	public void VerifyOrdersAboutView() throws InterruptedException, IOException, AWTException{
		Common.waitForPageLoad(getDriver());
		Common.WaitForClock(Clockobj);
		Ordertab.click();
		OrderQuery.waitUntilPresent();

		HelpMenu.click();
		Thread.sleep(1000);
		AboutView.click();
		Thread.sleep(2000);
		if(AboutViewApplet.isDisplayed()){
			//report.Info("About View Applet Exists as Expected.");
			AboutViewOKButton.click();		
		}
		else{
			Assert.assertTrue("About View Applet does not Exists", AboutViewApplet.isDisplayed());

		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@FindBy(xpath=".//*[text()='Search for an Order']")
	WebElementFacade SearchOrderButton;

	@FindBy(xpath=".//*[@aria-label='Installed ID']")
	WebElementFacade InstalledIDTextBox;

	@FindBy(xpath=".//*[@title='Installed ID:Go']")
	WebElementFacade InstalledIDGoButton;

	@FindBy(xpath="//*[text()='Order Number']//following::*[text()='Order Type']")
	WebElementFacade OrderNumberBesidesOrderTypeColumn;

	@FindBy(xpath=".//*[text()='Order Type']//following::*[text()='Order Subtype']")
	WebElementFacade OrderSubtypeBesidesOrderTypeColumn;

	@Step
	public void VerifyColumnsOrderView() throws InterruptedException, IOException, AWTException{
		Ordertab.click();
		OrderQuery.waitUntilPresent();
		Thread.sleep(2000);
		SearchOrderButton.click();
		InstalledIDTextBox.waitUntilPresent();
		String sInstalledID = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
		InstalledIDTextBox.type(sInstalledID);
		InstalledIDGoButton.click();
		Thread.sleep(2000);
		if(OrderNumberBesidesOrderTypeColumn.isDisplayed()){
			//report.Info("Order Number is beside Order Type");
			System.out.println("p1");
		}
		else{

			Assert.assertTrue("Order Number is not beside Order Type", OrderNumberBesidesOrderTypeColumn.isDisplayed());
		}

		if(OrderSubtypeBesidesOrderTypeColumn.isDisplayed()){
			//report.Info("Order Subtype is beside Order Type");
			System.out.println("p2");
		}
		else{
			Assert.assertTrue("Order Subtype is not beside Order Type", OrderSubtypeBesidesOrderTypeColumn.isDisplayed());
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	//@FindBy(xpath=".//*[@title='Third Level View Bar']//child::a[text()='Fulfillment']")
	@FindBy(xpath=".//a[text()='Fulfilment']")
	WebElementFacade FulfillmentTab;

	@FindBy(xpath=".//*[@aria-label='Store address']/following::span[1]")
	WebElementFacade StoreAddressIcon;

	@FindBy(xpath=".//*[@class='siebui-popup-filter']/span[4]/input")
	WebElementFacade StoreIDTextBox;

	@FindBy(xpath=".//*[@class='siebui-popup-filter']/span[5]/button")
	WebElementFacade StorePopupGoButton;

	@FindBy(xpath=".//*[@title='Store code:OK']")
	WebElementFacade StoreOKButton;

	@FindBy(xpath=".//*[@aria-label='Stock Check']")
	WebElementFacade StoreCheck;

	@FindBy(xpath=".//*[@data-display='Check Stock']")
	WebElementFacade CheckStatus;

	@FindBy(xpath=".//*[@data-display='Reserve']")
	WebElementFacade ReserveButton;

	@FindBy(xpath=".//*[@aria-label='Store address']")
	WebElementFacade StoreAddress;

	@FindBy(xpath=".//a[text()='Fulfilment']")
	WebElement FulfillmentTabWebElement;

	@FindBy(xpath=".//*[@aria-label='Store address']/following::span[1]")
	WebElement StoreAddressIconWebElement;


	@FindBy(xpath=".//*[@class='siebui-popup-filter']/span[4]/input")
	WebElement StoreIDTextBoxWebElement;

	@FindBy(xpath=".//*[@aria-label='Stock Check']")
	WebElement StoreCheckWebElement;

	@FindBy(xpath=".//*[@title='Store code:OK']")
	WebElement StoreOKButtonWebElement;

	@Step
	public void OrdersFulfilmentTab(String Item) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "OrdersFulfilment";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Item, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("StockCheck").size();i++) {
			String sStockCheck = tableMap.get("StockCheck").get(i);
			String sReserve = tableMap.get("Reserve").get(i);
			String sStoreAddress = tableMap.get("StoreAddress").get(i);
			String sStoreID = tableMap.get("StoreID").get(i);
			String sPopUp = tableMap.get("Popup").get(i); 
			String sPopup2 = tableMap.get("Popup2").get(i);
			String sStockCheckTextBox = tableMap.get("StockCheckTextBox").get(i);
			//String sPopup3 = tableMap.get("Popup3").get(i);

			if (sPopUp.equals("")){
				sPopUp = "No";
			}
			if (sPopup2.equals("")){
				sPopup2 = "No";
			}
			
			/*if (sPopup3.equals("")){
				sPopup3 = "No";
			}*/
			
			Common.waitForElement(FulfillmentTabWebElement);
			FulfillmentTab.click();

			if(sStoreAddress.equalsIgnoreCase("Y")){    	 
				Common.waitForElement(StoreAddressIconWebElement);
				StoreAddressIcon.click();
				Thread.sleep(4000);

				if(Common.waitForElement(StoreIDTextBoxWebElement)){          					
					StoreIDTextBox.sendKeys(sStoreID);	
					Thread.sleep(3000);
					StoreIDTextBox.sendKeys(Keys.chord(Keys.ENTER));	
					Thread.sleep(3000);
					// StorePopupGoButton.click();

					Common.waitForElement(StoreOKButtonWebElement);
					Common.waitForElement(StoreOKButtonWebElement);
					long startTime = System.currentTimeMillis();
					StoreOKButton.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					/*if(!sPopup3.equalsIgnoreCase("No")){
						
						Alert alert;
						String ActAlertText="";
						
						if(isAlertPresent(getDriver())){
				        	  alert=getDriver().switchTo().alert();
				              ActAlertText=alert.getText();	                                                                              	
				            if (ActAlertText.contains("Deliver to Store is currently not available")){                		
				            		alert.accept();
				            		report.Info("Existence of popup as expected");
				            }      
				            else{
				            	 Assert.assertTrue("Incorrect Popup", ActAlertText.contains("Deliver to Store is currently not available"));
				            }
							}
				          else{
				        	  Assert.assertTrue("Popup not present", isAlertPresent(getDriver()));
				          }
						break;
						}*/
					
					Common.waitForPageLoad(getDriver());
					long endTime = System.currentTimeMillis();
					long totalTime = endTime - startTime;
					Common.WritePerformanceOutput("Store OK Button  ,Total Login Time " + totalTime/1000);
					Thread.sleep(4000);
					StoreAddress.sendKeys(Keys.chord(Keys.ALT,Keys.ENTER));
					report.Info("Successfully Selected Store Address");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				}
				else{
					Assert.assertTrue("Store Address Pop Up did not occur", StoreIDTextBox.isVisible());
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					break;
				}
			}


			if(!sStockCheck.equals("")){
				Common.waitForElement(StoreCheckWebElement);
				StoreCheck.clear();
				Thread.sleep(1000);
				StoreCheck.typeAndEnter(sStockCheck);
				CheckStatus.click();
				Common.WaitForClock(Clockobj);
				if(!sPopUp.equalsIgnoreCase("No")){
					Common.HandleErrorPopUp(sPopUp); 
					Thread.sleep(3000);
				}
				if(!sPopup2.equalsIgnoreCase("No")){
					Common.HandleErrorPopUp(sPopup2); 
					Thread.sleep(3000);
				}
				report.Info("Successfully clicked Check Status and selected StockCheck to : "+sStockCheck);
			}
			
			if(sStockCheckTextBox.equals("Warehouse")){
				Common.waitForElement(StoreCheckWebElement);
				StoreCheck.clear();
				Thread.sleep(1000);
				StoreCheck.typeAndEnter(sStockCheckTextBox);
				Thread.sleep(4000);
				//CheckStatus.click();(not require in this loop)
				Common.WaitForClock(Clockobj);
				report.Info("Successfully selected StockCheck to : "+sStockCheckTextBox);
			}

			Common.WaitForClock(Clockobj);
			if(sReserve.equalsIgnoreCase("Y")){
				ReserveButton.click();
				Thread.sleep(4000);
			}

		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}


	@FindBy(xpath=".//*[@aria-labelledby='Cancel_Reason_Label']")
	WebElementFacade CancelReasonTextBox;
	@FindBy(xpath=".//*[@aria-label='Discard Reason']")
	WebElementFacade DiscardReason;
	@FindBy(xpath=".//*[@aria-label='Sales Order:Discard Order']")
	WebElementFacade DiscardButton;
	@FindBy(xpath=".//*[@title='Discard Order:Go']")
	WebElementFacade DiscardGoButton;
	@FindBy(xpath=".//*[@data-display='Discard Order']")
	WebElementFacade CancelOrderButton;
	@FindBy(xpath="(.//*[@aria-label='Cancel reason'])[2]")
	WebElementFacade CancelReasonTextBox2;
	@FindBy(xpath=".//*[@title='Cancel reason:Go']")
	WebElementFacade CancelOkButton;
	public void CancelOrder() throws InterruptedException, IOException, AWTException{
		LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		LineItemsTab.click();
		Thread.sleep(3000);
		//CancelReasonTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
		String	sOrderStatus =OrderStatus.getTextValue();

		/*if(sOrderStatus.equalsIgnoreCase("Pending")){
			CancelReasonTextBox.typeAndEnter("No Reason");
			Thread.sleep(3000);
		}
		CancelOrderButton.click();*/
		if(sOrderStatus.equalsIgnoreCase("Pending")){
			DiscardButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			DiscardButton.click();
			Thread.sleep(2000);
			DiscardReason.sendKeys("No Reason");
			DiscardReason.sendKeys(Keys.ENTER);
			//DiscardReason.typeAndEnter("No Reason");
			Thread.sleep(2000);
			DiscardGoButton.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
		/*if(sOrderStatus.equalsIgnoreCase("Pending")){
		DiscardReason.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Thread.sleep(2000);
		DiscardReason.type("No Reason");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}*/

		if(sOrderStatus.equalsIgnoreCase("Open")){
			CancelReasonTextBox2.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Thread.sleep(2000);
			CancelReasonTextBox2.type("No Reason");
			//CancelReasonTextBox.selectByVisibleText("No Reason");
			Thread.sleep(2000);
			CancelOkButton.click();
		}
		Thread.sleep(12000);
		sOrderStatus =OrderStatus.getTextValue();
		OrderStatus.click();
		if(sOrderStatus.equalsIgnoreCase("Cancelled")){
			report.Info("Order is cancelled successfully.");
		}
		else{
			Assert.assertTrue("Fail: Order not cancelled" ,sOrderStatus.equalsIgnoreCase("Cancelled"));
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

	}

	@FindBy(xpath=".//a[text()='Continue to this website (not recommended).']")
	WebElementFacade ContinueToWebsiteLink;

	public void Buyback() throws InterruptedException, IOException, AWTException, FindFailed{
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		WebDriver driver =getDriver();
		String title="";
		Thread.sleep(5000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); 	  
		}

		if (ContinueToWebsiteLink.isVisible()) {
			ContinueToWebsiteLink.click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
		sikuliUtility.ClickTrustedPopUp(SikulifilePath);	
		driver.manage().window().maximize();
		title = driver.getTitle();

		if(title.contains("Retail Phone Shop")){
			report.Info("Page is displayed successfully after clicking on Buyback button.");
			Assert.assertTrue(true); 
		}
		else{
			report.Info("Page is not displayed successfully after clicking on Buyback button.");
			Assert.assertTrue(false);
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}
	@FindBy(xpath=".//*[@aria-label='Sales Order:Menu']")
	WebElementFacade OrdermenuItemIcon;
	@FindBy(xpath=".//textarea[@aria-label='Back office description']")
	WebElementFacade BackofficeTextBox;
	@FindBy(xpath=".//input[@aria-label='User account']")
	WebElementFacade UserAccountTextField;
	@FindBy(xpath=".//input[@aria-label='User account']/following-sibling::span")
	WebElementFacade UserAccountIcon;
	@FindBy(xpath=".//*[@title='Pick Account:OK']")
	WebElementFacade PickAccountOkbutton;
	@FindBy(xpath=".//*[@aria-label='Last name']")
	WebElementFacade LastNameTextField;
	@FindBy(xpath=".//*[@aria-label='Last name']/following-sibling::span")
	WebElementFacade LastNameIcon;
	@FindBy(xpath=".//*[@title='Pick Contact:OK']")
	WebElementFacade PickContactOkbutton;
	@FindBy(xpath=".//*[@aria-label='Order no.']")
	WebElementFacade OrderNoTextBox;
	@FindBy(xpath=".//*[@aria-label='Sales Order:Customer Account']")
	WebElementFacade CustomerAccountButton;
	@FindBy(xpath=".//*[@title='Sales Order:Show more']")
	WebElementFacade OrderpageShowMoreButton;

	@Step
	public void OrderDescriptionVerfy(String rowName) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "OrderDescriptionVerify";


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {

			String sExpectedOrderDescription = tableMap.get("ExpectedOrderDescription").get(i);
			String sAboutRecord = tableMap.get("AboutRecord").get(i);
			String sServiceAccountValidation = tableMap.get("ServiceAccountValidation").get(i);
			String sLastNameValidation = tableMap.get("LastNameValidation").get(i);
			
			 Common.WaitForClock(Clockobj);
			LineItemsTab.waitUntilClickable();
			LineItemsTab.click();
			
			Thread.sleep(2000);
			Common.WaitForClock(Clockobj);
			LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).isDisplayed();
			if(OrderpageShowMoreButton.isCurrentlyVisible()){
				OrderpageShowMoreButton.click();            	
			}

			if (sAboutRecord.equalsIgnoreCase("Y")){
				OrderNoTextBox.click();
				OrdermenuItemIcon.click();
				Thread.sleep(5000);
				aboutRecord.click();
				Thread.sleep(1000);
				//report.Info("About record is displayed successfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}

			if(!sExpectedOrderDescription.equals("")){
				Thread.sleep(1000);
				CustomerAccountButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable(); 
				BackofficeTextBox.isDisplayed();
				BackofficeTextBox.click();
				String ActOrderDescription=BackofficeTextBox.getValue();
				report.Info("ActOrderDescription is " +ActOrderDescription);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Fail: Existence Description is not matched to Actutal Description " , ActOrderDescription.contains(sExpectedOrderDescription));
				report.Info("Existence of text : " + ActOrderDescription + " as expected");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(sServiceAccountValidation.equalsIgnoreCase("NotReadOnly")){
				Thread.sleep(2000);
				UserAccountTextField.waitUntilVisible();
				Assert.assertTrue("Fail: Service Account is not editable",UserAccountTextField.isEnabled());
				report.Info("pass: Service Account is editable");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				UserAccountIcon.click();
				Thread.sleep(2000);
				int tablesize= findAll(By.xpath("//table[@summary='Pick Account']/tbody/tr")).size();
				if(tablesize>=1){
					report.Info("Pass: Rows are displayed. Service Account is editable");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}else{
					report.Info("Fail: No rows displayed. Service Account is not editable");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				PickAccountOkbutton.waitUntilClickable();
				PickAccountOkbutton.click();
			}

			if(sLastNameValidation.equalsIgnoreCase("NotReadOnly")){
				LastNameTextField.waitUntilVisible();
				Assert.assertTrue("Fail: Last Name is not editable",LastNameTextField.isEnabled());
				report.Info("pass: Last Name is editable");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				LastNameIcon.click();
				Thread.sleep(2000);
				int tablesize= findAll(By.xpath("//table[@summary='Pick Contact']/tbody/tr")).size();
				if(tablesize>=1){
					report.Info("Pass: Rows are displayed. Last Name is editable");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}else{
					report.Info("Fail: No rows displayed. Last Name is not editable");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				PickContactOkbutton.waitUntilClickable();
				PickContactOkbutton.click();
			}

			if(sServiceAccountValidation.equalsIgnoreCase("ReadOnly")){
				Thread.sleep(2000);
				UserAccountTextField.waitUntilVisible();
				UserAccountTextField.click();
				String  UserAccountTextFieldReadOnly = UserAccountTextField.getAttribute("readonly");
				Assert.assertFalse("Fail: Service Account is editable",!UserAccountTextFieldReadOnly.equalsIgnoreCase("true"));
				report.Info("Pass: Service Account is not editable");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(sLastNameValidation.equalsIgnoreCase("ReadOnly")){
				LastNameTextField.waitUntilVisible();
				LastNameTextField.click();
				String  LastNameTextFieldReadOnly = LastNameTextField.getAttribute("readonly");
				Assert.assertFalse("Fail: Last Name is editable",!LastNameTextFieldReadOnly.equalsIgnoreCase("true"));
				report.Info("Pass: Last Name is Not editable");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

		}
	}
	@FindBy(xpath=".//*[@data-tabindex='tabScreen4']")
	WebElementFacade Ordertab1;

	@FindBy(xpath=".//*[@data-tabindex='tabScreen5']")
	WebElementFacade Ordertab2;

	public void OrderListVerification(String rowname) throws IOException, InterruptedException, AWTException{

		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "OrderListVerification";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0  ;i < tableMap.get("LastNameValidation").size();i++){
			String sLastNameValidation = tableMap.get("LastNameValidation").get(i);
			//String sAccountSet= tableMap.get("AccountSet").get(i);

			String sOrderNumber = Serenity.sessionVariableCalled("OrderNo").toString();
			if(Ordertab.isPresent()){           
				String OrderTab2Value=Ordertab2.getTextValue();
				if(OrderTab2Value.equalsIgnoreCase("Orders")){
					Ordertab2.click();
				}
				else{
					Ordertab1.click();
				}
				Thread.sleep(2000);
				OrderQuery.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilPresent();
				OrderQuery.click();
				Thread.sleep(2000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				//OrderListAplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilPresent();
				//OrderListAplet.click();
				ListAplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilPresent();
				ListAplet.type(sOrderNumber);
				SalesOrderGo.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
				SalesOrderGo.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				ClickOnAccountname.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
				ClickOnAccountname.click();
				Thread.sleep(2000);
				ClickOnOrderNumber.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
				ClickOnOrderNumber.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(sLastNameValidation.equalsIgnoreCase("NotReadOnly")){

					LastNameTextField.waitUntilVisible();
					LastNameIcon.click();
					Thread.sleep(2000);
					int tablesize= findAll(By.xpath("//table[@summary='Pick Contact']/tbody/tr")).size();
					if(tablesize>1){
						report.Info("Pass: Rows are displayed. Last Name is editable");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}else{
						report.Info("Fail: No rows displayed. Last Name is not editable");
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
					PickContactOkbutton.waitUntilClickable();
					PickContactOkbutton.click();
				}
				if(sLastNameValidation.equalsIgnoreCase("ReadOnly")){
					Thread.sleep(5000);
					LastNameTextField.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
					LastNameTextField.click();
					String  LastNameTextFieldReadOnly = LastNameTextField.getAttribute("readonly");
					Assert.assertFalse("Fail: Last Name is editable",!LastNameTextFieldReadOnly.equalsIgnoreCase("true"));
					report.Info("Pass: Last Name is Not editable");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
			}else{
				report.Info("Fail: Orders Page is not displayed successfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
		}

	} 
	/*@FindBy(xpath=".//button[@aria-label='Line Items:Customise']]")
WebElementFacade CustomiseButton;

@FindBy(xpath="//span/ul/li[9]/a")
WebElementFacade RefreshRecord;

@FindBy(xpath=".//*[@aria-label='Pick Resource:OK']")
WebElementFacade PickMSISDNOKButton;
@FindBy(xpath=".//*[@title='Pick Promotion:OK']")
WebElementFacade PickpromotionOKButton;
	 */

	@Step
	public void AccountsPrePost(String LineItemEntry) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Accounts.xls";
		String dataSheet = "AccountsPrePost";
		String applet = "//*[@title='Line Items List Applet']";
		String table = "//table[@summary='Order Entry - Line Item List (Sales)']";   

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LineItemEntry, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
			String sClickNew = tableMap.get("ClickNew").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String value = tableMap.get("Value").get(i);
			String Index = tableMap.get("Index").get(i);	

			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info("Row explanded: "+sLocateCol);     
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  		   

			}
			else{
				Common.selectedRow = 1;
			}
			if (!UIName.equals("")){ 
				Thread.sleep(5000);
				Common.updateSiebList(applet,table, UIName, value);           
				Thread.sleep(2000);
				report.Info("Row updated successfully"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}

		}
	}

	public void OrderVerify() throws InterruptedException, IOException, AWTException{

		//LineItemsTab.click();

		//Alert alert;
		//String ActAlertText="";
		String sPopup= "The MSISDN you have entered";
		Common.HandleErrorPopUp(sPopup);
		/*if(isAlertPresent(getDriver())){
        	  alert=getDriver().switchTo().alert();
              ActAlertText=alert.getText();	                                                                              	
            if (ActAlertText.contains("The MSISDN you have entered")){                		
            		alert.accept();
            		report.Info("Existence of popup as expected");
            }      
            else{
            	 Assert.assertTrue("Incorrect Popup", ActAlertText.contains("The MSISDN you have entered"));
            }
			}
          else{
        	  Assert.assertTrue("Popup not present", isAlertPresent(getDriver()));
          }*/
	}

	@FindBy(xpath=".//*[@title='Line Items:Copy']")
	WebElementFacade lineitemsCopyButton;
	@FindBy(xpath=".//*[@aria-labelledby='Quantity_Label']")
	WebElementFacade BulkcopyQuantityTextBox;
	@FindBy(xpath=".//*[@title='Bulk Copy:OK']")
	WebElementFacade BulkcopyOkButton;
	@FindBy(xpath=".//*[@title='Line Items:Retrieve MSISDNs']")
	WebElementFacade RetriveMSISDNSButton;
	public void RetrieveBulkMSISDN() throws InterruptedException, IOException, AWTException{
		if(LineItemsTab.isVisible()){
			LineItemsTab.click();
			report.Info("lint items tab clicked sucessfully");
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
		
		lineitemsCopyButton.waitUntilClickable();
		lineitemsCopyButton.click();
		Common.waitForElement(BulkcopyQuantityTextBox);
		//BulkcopyQuantityTextBox.waitUntilPresent();
		BulkcopyQuantityTextBox.clear();
		BulkcopyQuantityTextBox.type("3");
		//BulkcopyOkButton.waitUntilClickable();
		Common.waitForElement(BulkcopyOkButton);
		BulkcopyOkButton.click();
		Thread.sleep(5000);
		Common.waitForElement(RetriveMSISDNSButton);
		RetriveMSISDNSButton.click();
			
	/*	
		lineitemsCopyButton.waitUntilClickable();
		lineitemsCopyButton.click();
		Thread.sleep(6000);
		BulkcopyQuantityTextBox.waitUntilPresent();
		BulkcopyQuantityTextBox.clear();
		BulkcopyQuantityTextBox.type("3");
		BulkcopyOkButton.waitUntilClickable();
		BulkcopyOkButton.click();
		Thread.sleep(2000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		RetriveMSISDNSButton.waitUntilClickable();
		RetriveMSISDNSButton.click();*/
		Thread.sleep(2000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		report.Info("Retrive MSISDNS updated successfully");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}
	@FindBy(xpath=".//*[@aria-labelledby='Billing_Profile_Name_Label']//following::*[@aria-label='Selection Field'][1]")
	WebElementFacade OpenBillProfilePopup;

	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElementFacade BillProfileTextBox;

	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade BillProfileList;

	@FindBy(xpath=".//*[contains(@aria-labelledby,'Payment_Type')]")            
	WebElementFacade BillProfileTypeElement;

	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade BillProfileTypeList;

	@FindBy(xpath=".//*[@title='Billing profile:OK']")
	WebElementFacade BillProfileOKButton;

	/*@FindBy(xpath="//span[5]/span/a/span")
   WebElementFacade OrdersPageShowMoreButton;*/

	@FindBy(xpath=".//*[@title='Billing profile:OK']")
	WebElement BillProfileOKButtonWebElement;


	@Step
	public void OrderBillingProfileSelection(String rowname) throws InterruptedException, IOException, AWTException {
		Common.waitForElement(LineItemsTabWebElement);
		LineItemsTab.click();
		//	OpenBillProfilePopup.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "BillingProfileSelection";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0  ;i < tableMap.get("BillingProfile").size();i++){
			String sBillingProfile = tableMap.get("BillingProfile").get(i);
			//String sAccountSet= tableMap.get("AccountSet").get(i);
			if (OpenBillProfilePopup.isCurrentlyVisible()){                  
				OpenBillProfilePopup.click();
				report.Info("Billing Account Popup is clicked successfully");
			}
			else if (!OpenBillProfilePopup.isCurrentlyVisible()) {
				OrdersPageShowMoreButton.click();
				Thread.sleep(3000);
				OpenBillProfilePopup.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

			}   

			/*BillProfileTextBox.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilEnabled();
               BillProfileList.typeAndEnter("Postpay/ Prepay");
               BillProfileTextBox.typeAndEnter(sBillingProfile);*/
			Common.waitForElement(BillProfileOKButtonWebElement);
			BillProfileOKButton.click();
			Common.waitForElement(LineItemsTabWebElement);               
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}


	@Step
	public void OrderStatusCheck() throws InterruptedException, IOException, AWTException {
		//To check OrderStatus  
		
		Common.WaitForClock(Clockobj);
		LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		LineItemsTab.click();
		
		Thread.sleep(1000);
		Common.WaitForClock(Clockobj);
		LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

		String Order = OrderNo.getTextValue();
		String Status = OrdersStatus.getTextValue();
		int i = 0;

		do{
			Thread.sleep(2000);                                                        
			//getDriver().findElement(By.xpath(".//*[@aria-label='Sales Order:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
			
			//getDriver().findElement(By.xpath(".//*[@aria-label='Sales Order:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
			 OrderHeaderMenuButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                     OrderHeaderMenuButton.click();
                     Thread.sleep(1000);
                     RefreshMenuItem.click();
                     Thread.sleep(1000);
                     
			Thread.sleep(2000);
			Status = OrdersStatus.getTextValue();
			if(Status.equals("Complete")){
				report.Info("Order "+Order+ "is Complete");
				break;                                          
			}

			i++;
		}while(!Status.equals("Complete") && i <=600);                    
		Assert.assertTrue("Status of Order "+Order+ "is "+Status,Status.equals("Complete") );                           
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
	}

	@FindBy(xpath=".//*[@aria-label='Sales Order:Credit Vet']")
	WebElementFacade CreditVetButton;


	@Step
	public void OneNetBusinessCreditVet(String Popup) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "CreditVetClick";



		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Popup, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Popup").size();i++) {
			String sPopup = tableMap.get("Popup").get(i);

			LineItemsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			LineItemsTab.click();		

			String ActAlertText="";
			Alert alert;
			Thread.sleep(5000);
			//CreditVetButton.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			CreditVetButton.click();
			Thread.sleep(10000);
			Common.HandleErrorPopUp(sPopup);
			/*if(isAlertPresent(getDriver())&& (!sPopup.equalsIgnoreCase("No"))){
	 		    	 alert=getDriver().switchTo().alert();
	                 ActAlertText=alert.getText();  

	              	if (ActAlertText.contains(sPopup)){                		
	              		alert.accept();
	              		report.Info("Accepted alert messsage is"+ActAlertText);
	              	}                        
	            }*/
			//sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  

		}
	} 
	@Step
	public void Delivery_Postcode_Populated() throws InterruptedException, IOException, AWTException{
		String sPostCode= null;
		DeliveryTab.click();
		Thread.sleep(6000);
		if(DeliveryAddressApplet.isVisible()){
			DeliveryAddressLinePopUp.click();
			Thread.sleep(4000);
			if(DeliveryAddressOKButton.isVisible()){
				DeliveryAddressOKButton.click();
				report.Info("Address is successfully selected");
			}
			else{
				Assert.assertTrue("Open Pop up is not clicked for Addressline 1.",DeliveryAddressOKButton.isVisible());

			}
		}
		else{
			Assert.assertTrue("Delivery tab is not clicked successfully.",DeliveryAddressApplet.isVisible());

		}

		if(DeliveryPostcode.isVisible()){
			sPostCode = DeliveryPostcode.getTextValue();
		}
		else{
			Assert.assertTrue("Post code is not populated automatically after selecting address from address line.",!sPostCode.equals(""));

		}

		if(!sPostCode.equals("")){
			report.Info("Post code is populated automatically after selecting address from address line 1 and is : "+sPostCode);
		}
		else{
			Assert.assertTrue("Delivery Page is not displayed successfully.",DeliveryPostcode.isVisible());

		}
		Thread.sleep(5000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


	} 

	@FindBy(xpath=".//*[@data-display='Remove Delivery']")
	WebElementFacade RemoveDeliveryButton;

	@FindBy(xpath=".//*[text()='Pack Instruction']")
	WebElementFacade PackInstructionElement;

	@FindBy(xpath=".//*[text()='Delivery Instruction']")
	WebElementFacade DeliveryInstructionElement;

	@FindBy(xpath=".//*[@aria-label='Deliver to store']")
	WebElementFacade DeliveryToStoreCheckBox;

	@FindBy(xpath=".//*[@aria-label='Delivery cost']")
	WebElementFacade DeliveryCostElement;

	@FindBy(xpath=".//*[@aria-label='Delivery method']")
	WebElementFacade DeliveryMethodElement;

	@FindBy(xpath=".//*[@aria-labelledby='Zip_Label']")
	WebElementFacade PostcodeTextBox;

	@FindBy(xpath=".//*[@aria-label='Delivery method']//following-sibling::span")
	WebElementFacade DeliveryMethodDropDown;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Delivery_Date_Label']")
	WebElementFacade DeliveryDateElement;

	@FindBy(xpath=".//*[@title='Shipment Details:Done']")
	WebElementFacade DeliveryDoneButton;

	@FindBy(xpath=".//*[@aria-label='Address line 1']//following-sibling::span")
	WebElementFacade DeliveryAddressPopUp;

	@FindBy(xpath=".//*[@title='VF Delivery Address Pick Applet:OK']")
	WebElementFacade AddrOKButton;

	@FindBy(xpath=".//*[@aria-label='Phone no.']")
	WebElementFacade PhoneNumber;

	@FindBy(xpath=".//*[@id='ui-id-894']/li[contains(text(),'Exchange')]")
	WebElementFacade ExchangeInDeliveryMethod;

	@FindBy(xpath=".//*[@id='ui-id-894']/li[contains(text(),'Return')]")
	WebElementFacade ReturnInDeliveryMethod;
	
	@FindBy(xpath=".//*[@aria-labelledby='VF_StoreCodePick_Label]")
	WebElementFacade DeliveryTabStoreCode;
	
	@FindBy(xpath=".//*[@aria-labelledby='VF_Store_Address_Label")
	WebElementFacade DeliveryTabStoreAddress;
	
	@FindBy(xpath="//a[text()='Delivery']")
	WebElement DeliveryTabSync;
	
	@FindBy(xpath=".//*[@data-licval='Week day 8am - 6pm']")
	WebElementFacade WeekDayTxt;
	
	@FindBy(xpath=".//*[@aria-label='Select Email Address:Cancel']")
	WebElementFacade SelectEmailAddressCancel;
	@FindBy(xpath=".//*[@aria-label='Select Email Address:OK']")
	WebElementFacade SelectEmailAddressOk;
	@FindBy(xpath=".//*[@aria-label='Shipment Details:Re-send Label']")
	WebElementFacade ReSendLabel;
	@FindBy(xpath=".//*[@aria-label='Select Email address']")
	WebElementFacade SelectEmailAddress;

	@Step
	public void OrdersDeliveryTab(String Validation) throws InterruptedException, IOException, AWTException{
		//Homepage.waitUntilPresent();

		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "Delivery";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Validation, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("RowNo").size();i++) { 	      	   
			String sDeliveryMethod = tableMap.get("DeliveryMethod").get(i);
			String sPostcode = tableMap.get("Postcode").get(i);
			String sPhoneNo = tableMap.get("PhoneNo").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			String sReserve = tableMap.get("Reserve").get(i);
			String sPopUp = tableMap.get("Popup").get(i);
			String sNoAdressValidation = tableMap.get("NoAdressValidation").get(i);
			String sSequence = tableMap.get("Sequence").get(i);
			String sNegativeVal = tableMap.get("NegativeVal").get(i);
			String sRemoveDelivery = tableMap.get("RemoveDelivery").get(i);
			String sDone = tableMap.get("Done").get(i);
			String sStoreCode = tableMap.get("StoreCode").get(i);
			String sStoreAddress = tableMap.get("StoreAddress").get(i);
			String sAddressNull = tableMap.get("AddressNull").get(i);
			String sDeliveryDone = tableMap.get("DeliveryDone").get(i);
			

			DeliveryTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
			Common.waitForElement(DeliveryTabSync);
			DeliveryTab.click();
			DeliveryAddressPopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

			if (sPopUp.equals("")){
				sPopUp = "No";
			}
			
			
			if(!sStoreCode.equalsIgnoreCase("")){

				String StoreCodeTextValue = DeliveryTabStoreCode.getTextValue();

				if(StoreCodeTextValue.equals(sStoreCode)) {
					report.Info("Store Code is as Expected");
				}
				else {
					report.Info("Store Code is not as Expected");
				}

				String StoreAddressTextValue = DeliveryTabStoreAddress.getTextValue();

				if(StoreAddressTextValue.equals(sStoreAddress)) {
					report.Info("Store Address is as Expected");
				}
				else {
					report.Info("Store Address is not  as Expected");
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				break;
			}

			if(sRemoveDelivery.equalsIgnoreCase("Y")){
				RemoveDeliveryButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			//add done button code

			if(sNegativeVal.equalsIgnoreCase("Y")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(!PackInstructionElement.isCurrentlyVisible()){
					report.Info("Pack Instruction is not present in the Delivery details tab.");
				}
				else{
					Assert.assertTrue("Pack Instruction is present in the Delivery details tab.", !PackInstructionElement.isVisible());
				}		
				if(!DeliveryInstructionElement.isCurrentlyVisible()){
					report.Info("Delivery Instruction is not present in the Delivery details tab.");
				}
				else{
					Assert.assertTrue("Delivery Instruction is present in the Delivery details tab.", !DeliveryInstructionElement.isVisible());
				}
				return;  
			}
			

			if(sSequence.equalsIgnoreCase("Y")){
				//code to be added

				if(DeliveryToStoreCheckBox.isCurrentlyVisible()){
					report.Info("Deliver to store is present in the tab");
				}
				else{
					Assert.assertTrue("Deliver to store is not  present in the tab", DeliveryToStoreCheckBox.isCurrentlyVisible());
				}

				if(DeliveryCostElement.isCurrentlyVisible()){
					report.Info("Delivery cost is present in the tab");
				}
				else{
					Assert.assertTrue("Delivery cost is not  present in the tab", DeliveryCostElement.isCurrentlyVisible());
				}

				if(DeliveryMethodElement.isCurrentlyVisible()){
					report.Info("Delivery method is present in the tab");
				}
				else{
					Assert.assertTrue("Delivery method is not  present in the tab", DeliveryMethodElement.isCurrentlyVisible());
				}
				if(DeliveryDateElement.isCurrentlyVisible()){
					report.Info("Delivery date is present in the tab");
				}
				else{
					Assert.assertTrue("Delivery date is not  present in the tab", DeliveryDateElement.isCurrentlyVisible());
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());  
				return;
			}
			
			if(!sAddressNull.equalsIgnoreCase("")){
				
				DeliveryMethodElement.clear();
				//DeliveryMethodElement.typeAndEnter(sDeliveryMethod);
				DeliveryMethodDropDown.click();
				Thread.sleep(2000);
				WeekDayTxt.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(!sPopUp.equalsIgnoreCase("No")){
					Common.HandleErrorPopUp(sPopUp); 
					break;
				}
			}
			
			
			if(!sDeliveryDone.equalsIgnoreCase("")){

				DeliveryMethodElement.clear();
				DeliveryMethodElement.typeAndEnter(sDeliveryMethod);
				DeliveryDoneButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(!sPopUp.equalsIgnoreCase("No")){
					Common.HandleErrorPopUp(sPopUp); 
					break;
				}

			}

			if(sDeliveryMethod.contains("Week day 8am - 6pm")){
				if(sNoAdressValidation.equalsIgnoreCase("Yes")){
					DeliveryAddressPopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					DeliveryAddressPopUp.click();	   
					AddrOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					AddrOKButton.click();
					Thread.sleep(2000);
					DeliveryMethodElement.clear();
					DeliveryMethodElement.typeAndEnter(sDeliveryMethod);
					PhoneNumber.typeAndEnter(sPhoneNo);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					DeliveryDoneButton.click();
					if(!sPopUp.equalsIgnoreCase("No")){
						Common.HandleErrorPopUp(sPopUp); 
					}
					return;
				}

			}


			if(sNoAdressValidation.equalsIgnoreCase("Yes")){
				DeliveryDoneButton.click(); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(!sPopUp.equalsIgnoreCase("No")){
					Common.HandleErrorPopUp(sPopUp); 
				}
				return;
			}
			Thread.sleep(2000);
			DeliveryAddressPopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			DeliveryAddressPopUp.click();	   
			AddrOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			AddrOKButton.click();
			Thread.sleep(2000);
			DeliveryMethodElement.clear();
			DeliveryMethodElement.typeAndEnter(sDeliveryMethod);
			PhoneNumber.typeAndEnter(sPhoneNo);


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
			DeliveryDateElement.clear();
			DeliveryDateElement.typeAndEnter(sDeliveryDate);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			//DeliveryDoneButton.click();
			
			if(sDone.equalsIgnoreCase("Yes")){
				DeliveryDoneButton.click();
			}
			
			if(SelectEmailAddressCancel.isVisible())
			{

				SelectEmailAddress.typeAndEnter("Account holder Email");
				Thread.sleep(3000);
				SelectEmailAddressOk.click();			   
				return;
			} 

			if(sValidation.equalsIgnoreCase("Yes")){
				DeliveryMethodDropDown.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(!ExchangeInDeliveryMethod.isPresent()){
					report.Info("Exchange delivery methods are NOT present");
				}
				else{
					Assert.assertTrue("Exchange delivery methods are present",!ExchangeInDeliveryMethod.isPresent());
				}

				if(!ReturnInDeliveryMethod.isPresent()){
					report.Info("Return delivery methods are NOT present");
				}
				else{
					Assert.assertTrue("Return delivery methods are present",!ReturnInDeliveryMethod.isPresent());
				}

				String postcodeStatus = PostcodeTextBox.getAttribute("readonly");
				if(postcodeStatus.equalsIgnoreCase("true")){
					report.Info("Postcode is NOT Editable");
				}
				else{
					Assert.assertTrue("Postcode is  Editable",postcodeStatus.equalsIgnoreCase("true"));
				}
			}
		}
	}

	@FindBy(xpath=".//*[@class='siebui-button-toolbar siebui-closed']")
	WebElementFacade SiteMapButton;
	//@FindBy(xpath="((.//*[@ name='Reports'])[1]")
	@FindBy(xpath="(.//*[@class='siebui-icon-tb-reports ToolbarButtonOn'])[1]")	
	WebElementFacade ReportButton;
	@FindBy(xpath=".//*[@title='Run Report:Submit']")
	WebElementFacade SubmitButtonReports;
	@FindBy(xpath=".//*[@aria-labelledby='Report_Name_Label']")
	WebElementFacade ReportNameList;
	@FindBy(xpath=".//*[@name='SiteMap']/span")
	WebElementFacade SiteMap;

	@FindBy(xpath=".//*[@class='siebui-button-toolbar siebui-closed']")
	WebElementFacade Iconbar;

	@Step
	public void GenerateContractReportSave() throws InterruptedException, IOException, FindFailed, AWTException{
		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		String SikulifilePathForSavingFile= Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();

		Common.waitForPageLoad(getDriver());
		LineItemsTab.click();

		Thread.sleep(4000);

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

		        //ReportNameList.selectByVisibleText("Generate Contract - Flexible Price Plan");
		ReportNameList.selectByVisibleText("Generate Contract");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Thread.sleep(1000);
		SubmitButtonReports.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Thread.sleep(30000);

		Screen s=new Screen();

		if(s.exists(SikulifilePath+"\\ContinuetoWebsite.png") != null)
			s.click(SikulifilePath+"\\ContinuetoWebsite.png");
		Thread.sleep(2000);

		sikuliUtility.SaveContractReport(SikulifilePath);

	}

	@FindBy(xpath=".//*[@title='Line Items:Copy']")
	WebElementFacade CopyButton;
	@FindBy(xpath=".//*[@aria-label='Quantity']")
	WebElementFacade QuantityTextBox;
	@FindBy(xpath=".//*[@aria-label='Bulk Copy:OK']")
	WebElementFacade BulkCopyOKButton;
	@FindBy(xpath=".//*[@aria-label='Sales Order:Customer Account']")
	WebElement CustomerAccountButtonSync;

	@Step
	public void CopyLineItemElements(String Action) throws InterruptedException, IOException, FindFailed, AWTException{
		Common.waitForPageLoad(getDriver());
		
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "OrderLineItemsCopy";
		String applet = "//*[contains(@class,'siebui-applet siebui-collapsible-applet siebui-list')]";
		String table = "//table[@class='ui-jqgrid-btable']";
		
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Count").size();i++) {
			String sCount = tableMap.get("Count").get(i);
			
			
			if(!LineItemsApplet.isVisible()){
				LineItemsTab.click();
				Thread.sleep(3000);//don't delete
				menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete           
			}      

			int LineItemListRowCount = findAll(By.xpath("//table[@class='ui-jqgrid-btable']/tbody/tr")).size();
			if(LineItemListRowCount>1){
				report.Info("Items are displayed successfully.");
			}
			else{
				Assert.assertTrue("Items are not displayed successfully.", LineItemListRowCount>1);
			}

		CopyButton.click();
		Thread.sleep(4000);

		
		//sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		BulkCopyOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		QuantityTextBox.clear();
		QuantityTextBox.type(sCount);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		BulkCopyOKButton.click();
		
		Thread.sleep(8000);
		menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForElement(CustomerAccountButtonSync);
		
		
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
	}


	@FindBy(xpath="(.//td[contains(@id,'Customer_Requested_Date')])[1]")
	WebElementFacade CustomerRequestedDateRow;
	@Step
	public void CheckCustomerRequestedDate(String Action ) throws IOException, InterruptedException, AWTException, ParseException{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "LineItems";
		String applet = "//*[contains(@class,'siebui-applet siebui-collapsible-applet siebui-list')]";
		String table = "//table[@class='ui-jqgrid-btable']";
		String CustomerRequestedDate="";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {
			if(!LineItemsApplet.isVisible()){
				LineItemsTab.click();
				Thread.sleep(3000);//don't delete
				menuItemIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete           
			}      

			int LineItemListRowCount = findAll(By.xpath("//table[@class='ui-jqgrid-btable']/tbody/tr")).size();
			if(LineItemListRowCount>1){
				report.Info("Items are displayed successfully.");
			}
			else{
				Assert.assertTrue("Items are not displayed successfully.", LineItemListRowCount>1);
			}


			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);           
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);
			String Index = tableMap.get("Index").get(i);
			String VerifyOutcome = tableMap.get("VerifyOutcome").get(i);

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
			if (!sUIName.equals("")){         		 
				CustomerRequestedDate =Common.updateSiebList(applet,table, sUIName, svalue); 
				Thread.sleep(2000);                       	              
				report.Info("Action : "+sUIName+" has perfomed "+svalue);                                                  
			}
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			CustomerRequestedDateRow.click();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MMM/yyyy");

			Date date = new Date();
			String dateFormatted= df.format(date);

			Date CutomerDate1= format1.parse(CustomerRequestedDate);
			String fetchedDate1=df.format(CutomerDate1);
			Date currentdate = df.parse(dateFormatted);
			Date fetchedDate = df.parse(fetchedDate1);
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(currentdate);
			cal2.setTime(fetchedDate);

			int ActualdayDifference = 0;
			while (cal1.before(cal2)) {
				if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
						&&(Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
					ActualdayDifference++;
				}
				cal1.add(Calendar.DATE,1);

			}

			int ExpectedDayDifference = Integer.parseInt(VerifyOutcome);
			report.Info("The Customer Requested date is: "+fetchedDate1);
			Assert.assertTrue("Fail:The difference between Customer requested date and current date is "+ActualdayDifference+" and expected is "+ExpectedDayDifference, ActualdayDifference==ExpectedDayDifference);
			report.Info("Pass:The difference between Customer requested date and current date is as expected i.e "+ActualdayDifference);

		}
	}
	@Step
	public void submitWithOutVerify(String Action) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, SQLException, AWTException{
		Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Order.xls";
		String dataSheet = "OrderFormEntry";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		
		for (int i = 0;i < tableMap.get("Popup").size();i++) {
			String sPopup = tableMap.get("Popup").get(i);
			String sClickSubmit = tableMap.get("ClickSubmit").get(i);
			
			Alert alert;
			String ActAlertText="";

			if (sPopup.equals("")){
				sPopup = "No";
			}
			Common.waitForElement(LineItemsTabWebElement);
			LineItemsTab.click();
			Thread.sleep(2000);//don't delete
			TandCheckBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();//don't delete
			TandCheckBox.click();
			if (!sClickSubmit.equals("N")){
				//Thread.sleep(2000);
				SubmitButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				// Thread.sleep(2000)
				SubmitButton.click();
				Thread.sleep(1000);
				if(isAlertPresent(getDriver())&& (!sPopup.equalsIgnoreCase("No"))){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText();  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					String sPopup1=sPopup;                                                                                      
					if (ActAlertText.contains(sPopup1)){                         
						alert.accept();
						report.Info("alert messsage is"+ActAlertText);
					}                        
				}
			}
           }
	   } 
	
	
	@Step
	public void TermsAndConditionCheckVerify() throws InterruptedException, IOException, AWTException{
		
	String TandCCheckbox = TandCheckBox.getAttribute("aria-checked");
	if(TandCCheckbox.equalsIgnoreCase("true")) {
		report.Info("Terms and Conditions Check box is Checked");                                                                                   
	}
	else {
		report.Info("Terms and Conditions Check box not is Checked");
	}
}



@FindBy(xpath=".//*[text()='Order Summary']")
WebElementFacade OrderSummary;

@FindBy(xpath="//*[@aria-label='Contract Details:Sign Contract']")
WebElementFacade SignContractButton;

@FindBy(xpath=".//canvas[@class='siebui-ctrl-pad vfoui-digital-signature-canvas']")
WebElementFacade SignatureCanvas;

@FindBy(xpath="//*[@aria-label='Customer Agreement:Save Signature']")
WebElementFacade SignContractSaveButton;

@FindBy(xpath="//*[@aria-label='Contract Details:Store and Email']")
WebElementFacade StoreandEmailButton;

@FindBy(xpath="//*[@aria-label='Third Level View Bar']")
WebElementFacade ThirdLevelViewBar;


@Step
public void OrderSummaryDigitalSignature(String rowname) throws InterruptedException, IOException, AWTException{

	String filePath = "\\src\\test\\resources\\data\\Order.xls";
	String dataSheet = "OrderSummary";
	Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
	readWorkbook.testData(tableMap);

	for (int i = 0;i < tableMap.get("StoreEmail").size();i++) {
		String sDigitalSign = tableMap.get("DigitalSign").get(i);
		String sStoreEmail = tableMap.get("StoreEmail").get(i);
		String sPopUp = tableMap.get("PopUp").get(i);
		
		/*if (OrderSummary.isDisplayed()){
			OrderSummary.click();
		}
		else {
			ThirdLevelViewBar.selectByVisibleText("Order Summary");
		}*/

		OrderSummary.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		OrderSummary.click();
		Thread.sleep(3000);
		Common.WaitForClock(Clockobj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		if(sDigitalSign.equalsIgnoreCase("PerformSign")){
			Thread.sleep(10000);
			SignContractButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			SignContractButton.click();
			Thread.sleep(2000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			SignatureCanvas.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Actions builder = new Actions(getDriver());
			builder.clickAndHold(SignatureCanvas).moveByOffset(10, 50).
			moveByOffset(50,10).
			moveByOffset(-10,-50).
			moveByOffset(-50,-10).release().perform();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			SignContractSaveButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			SignContractSaveButton.click();

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if(isAlertPresent(getDriver())){
				Alert alert = getDriver().switchTo().alert();
				String ActAlertText = alert.getText(); 

				if (ActAlertText.contains("For the next step, please generate contract and")){
					alert.accept();
					System.out.println("alert messsage is"+ActAlertText);
				}                                                                                       					                    
			}

			Thread.sleep(5000);
			Common.WaitForClock(Clockobj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}

		if(sStoreEmail.equalsIgnoreCase("Click")) {

			StoreandEmailButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			StoreandEmailButton.click();

			if(!sPopUp.equalsIgnoreCase("")) {
				Common.HandleErrorPopUp(sPopUp);
			}


			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}

		if(sDigitalSign.equalsIgnoreCase("CheckDisable")) {
			
			Assert.assertTrue("Fail, Sign ContractButton is Enabled", !SignContractButton.isEnabled());

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}	
		
		if(sStoreEmail.equalsIgnoreCase("CheckEnable")) {
			
			Assert.assertTrue("Fail, Store and Email button not is enabled", StoreandEmailButton.isEnabled());

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}

	}

}
}













