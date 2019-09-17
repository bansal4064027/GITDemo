package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;
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
import pages.ConfirmOrderPageEnh;
import utilities.commonEnh;

public class ConfirmOrderPageEnh extends PageObject {
	
	@Steps
    private ReadWorkbook readWorkbook;
	
	@Steps
	private common Common;
	@Steps
	private commonEnh CommonEnh;

	@Steps
	private SikuliUtility sikuliUtility;
	
	@Steps
	AboutCustomerPageEnh aboutCustomerPageEnh;
	
	
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
	  
	  @FindBy(xpath=".//*[contains(@aria-label,'Up-front cost payment method(s):Add payment')]")
	    WebElementFacade AddPaymentButton;
	  @FindBy(xpath=".//td[contains(@aria-labelledby,'Payment_Method')]")
	    WebElementFacade PaymentMethodCell;
	  @FindBy(xpath="(.//input[contains(@aria-labelledby,'Payment_Method')])[2]")
	  WebElementFacade PaymentMethodTextBox;	  
	  @FindBy(xpath=".//*[contains(@aria-labelledby,'Billing_Profile')]")
	  WebElementFacade BillingProfileTextBox;
	  @FindBy(xpath=".//*[contains(@aria-labelledby,'Transaction_Amount')]")
	  WebElementFacade AmountTextBox;
	  @FindBy(xpath=".//*[@aria-label='Billing profile:OK']")
	  WebElementFacade BillingProfileOKButton;
		  
	  @FindBy(xpath="(.//button[@aria-label='Add card details'])")
	  WebElementFacade AddcardDetails;

	  @FindBy(xpath=".//*[@placeholder='Card Number (PAN)']")
	  WebElementFacade CardDetails;

	  @FindBy(xpath=".//*[text()='Submit']")
	  WebElementFacade SubmitButton;

	  @FindBy(xpath=".//*[@aria-label='Pre-authorise payment']")
	  WebElementFacade PreAuthorize;

	  @FindBy(xpath="(.//*[@placeholder='MMYY'])")
	  WebElementFacade AddMMYY;


	  @FindBy(xpath=".//*[@placeholder='CVV']")
	    WebElementFacade AddCV2;
	  @FindBy(xpath=".//*[contains(text(),'Card successfully captured')]")
		WebElementFacade PaymentConfirmation; 
	  @FindBy(xpath="(.//*[@placeholder='House Number'])")
	  WebElementFacade HouseNumber;

	  @FindBy(xpath="(.//*[@placeholder=''])")
	  WebElementFacade PostCode;

	  @FindBy(xpath=".//*[@aria-label='Pre-authorise payment']")
	  WebElementFacade PreAuthoriseButton;
	  
	  @FindBy(xpath=".//*[@aria-labelledby='VF_CV2_Label']")
	  WebElementFacade CVV;
	  @FindBy(xpath=".//*[@aria-label='CV2:Go']")
	  WebElementFacade CVVOKButton;
	  
	  @Step
		public void OrderPayment(String sPaymentMethod) throws InterruptedException, IOException, AWTException{
		  Common.waitForPageLoad(getDriver());
			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
		    String filePath = "\\src\\test\\resources\\data\\Order_Enh.xls";
		    String applet = "//*[@title='Up-front cost payment method(s) List Applet']";
		    String table = "//table[@summary='Up-front cost payment method(s)']";
		    String dataSheet = "Order_Payment";
		  
		    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(sPaymentMethod, filePath, dataSheet);
			  readWorkbook.testData(tableMap);
			 

			 /* if (!findBy(applet).isCurrentlyVisible()){
				  Common.waitForElement(PaymentsTabWebElement);	  
				  PaymentsTab.click();
				  Common.WaitForClock(ClockObj);
			  }//To check Payment Applet is already in View, then don't re click on Payment tab.Code takes time but this works.
				*/ 
			  //Common.WaitForClock(ClockObj);
			  for (int i = 0;i < tableMap.get("PaymentMethod").size();i++) {
			  
			   // TermsandConditionsCheckBox.click();    	     
			    String PaymentMethod =  tableMap.get("PaymentMethod").get(i);
			    String JourneyType =  tableMap.get("JourneyType").get(i);
			    String Authorize =  tableMap.get("Authorize").get(i);
			    String sCVV =  tableMap.get("CVV").get(i);
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
			    String sCardNumber = tableMap.get("CardNumber").get(i);
			    String sCV2 = tableMap.get("CV2").get(i);
			    String sExpiryDate = tableMap.get("ExpiryDate").get(i);
			    String sHouseNumber = tableMap.get("HouseNumber").get(i);
			    String sPostCode = tableMap.get("PostCode").get(i);
			    String sExernaPaymentSystemWindow = tableMap.get("ExernaPaymentSystemWindow").get(i);

			    if (sExernaPaymentSystemWindow.equals("")){
			    	sExernaPaymentSystemWindow = "No";
				    }
			    
			    if (sPopup.equals("")){
			  	  sPopup = "No";
			    }
			    
			    if (sPopup1.equals("")){
			  	  sPopup1 = "No";
			    }
			    
			    if (Index.equals("")){
			      	 Index = "0";
			     }
			  
			    BillingAccountTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			    if(AddPaymentButton.isEnabled()&& (sNewButton.equals("Y"))){
			    	AddPaymentButton.click();
			    	Common.WaitForClock(ClockObj);
				
		      } 
			    int tablesize= findAll(By.xpath("//table[@summary='Up-front cost payment method(s)']/tbody/tr")).size();

			    if(tablesize>1){
			      
			  	  if (!sLocateCol.equals("")){
			  		CommonEnh.selectedRow = -1;
			        Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
			        report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
			            }
			       else{               
			    	   CommonEnh.selectedRow = 1;
			       }
			  	  if (!UIName.equals("")){
			  		 // Common.selectedRow = 1;
			            CommonEnh.updateSiebList(applet,table, UIName, value); 
			            Common.WaitForClock(ClockObj);
			            
			  	  }
			  
			  	  if(UIName.contains("Billing_Profile")){
			  		  BillingProfileOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			  		  BillingProfileOKButton.click();
			  	  }
			  	  
			  	if(Authorize.contains("PreAuthorize")){
			  		Common.WaitForClock(ClockObj);
			  		PreAuthoriseButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			  		PreAuthoriseButton.click();
			  		Common.WaitForClock(ClockObj);
			  		CVV.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			  		CVV.type(sCVV);
			  		CVVOKButton.click();
			  		Common.WaitForClock(ClockObj);
			  	  }
			  	
			  	  
				  if(Authorize.contains("AuthorizeWIthCvv")){
					  AddcardDetails.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					  AddcardDetails.click();
					  Common.WaitForClock(ClockObj);
					  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					  WebDriver driver =getDriver();
					  String title="";
					  Thread.sleep(5000);
					  for (String winHandle : driver.getWindowHandles()) {
						  driver.switchTo().window(winHandle); 	  
					  }
					 
					  getDriver().manage().window().maximize();
					  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					  CardDetails.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					  CardDetails.sendKeys(sCardNumber);
					  AddMMYY.sendKeys(sExpiryDate);
					  AddCV2.sendKeys(sCV2);
					  HouseNumber.sendKeys(sHouseNumber);
					  PostCode.sendKeys(sPostCode);
					  
					  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					  
					  SubmitButton.waitUntilClickable();
					  SubmitButton.click();
					  PaymentConfirmation.waitUntilVisible();
					  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					  report.Info("The payment card has been captured. Please close this window");
					  Thread.sleep(5000);

					  driver =getDriver();
					  title="";
					  Thread.sleep(5000);
					  for (String winHandle : driver.getWindowHandles()) 
					  {
						  driver.switchTo().window(winHandle); 	  
						  PreAuthorize.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						  PreAuthorize.click();
						  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						  Thread.sleep(5000);
						  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

						  break;
					  }
					 
			  	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
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
	                    Set<String> winHandles = driver.getWindowHandles();
	                    for (String handle : winHandles) {
	        				if (!handle.equals(initialWindow)) {
	        					driver.switchTo().window(handle);
	        					Thread.sleep(1000);
	        					
								aboutCustomerPageEnh.enterAeirandiCardDetails("CreditCardVisa");
	        				}
	        			}
	                    driver.switchTo().window(initialWindow);
				  }
			    
			}
	  }}
	  
	  @FindBy(xpath=".//*[contains(@aria-label,'Bill payer account')]")
	    WebElementFacade BillingAccountTextBox;
	  @FindBy(xpath=".//*[contains(@aria-label,'Monthly cost')]")
	    WebElementFacade MonthlyCostTextBox;
	  
	  @FindBy(xpath="(.//button[@aria-label='Basket:Next'])[2]")
	    WebElementFacade NextButtonConfirmOrderPage;
	  @FindBy(xpath=".//*[@aria-labelledby='Order_Number_Label']")
	    WebElementFacade OrderNumberinPopUp;
	  @FindBy(xpath=".//input[contains(@aria-labelledby,'Order_Status_Message_Calc2')]")
	    WebElementFacade OrderStatus;
	  @FindBy(xpath=".//*[@aria-label='Order status:Ok']")
	    WebElementFacade OrderStatusOKButton;
	  
		@FindBy(xpath="//button[text()='Order summary'] | //button[text()='Plan order summary'] | //button[text()='Plan summary']")
	    WebElementFacade OrderSummaryTab;
	  @FindBy(xpath="(.//*[@aria-label='Basket:Next'])[1]")
	    WebElementFacade NextButtonOrderSummaryPage;
	  @FindBy(xpath=".//*[contains(text(),'Insufficient permission')]")
		WebElementFacade InsufficientFundErrorMsg; 
	  @FindBy(xpath=".//*[contains(text(),'Error message')]")
		WebElementFacade InsufficientFundErrorTitleBox;	  
	  @FindBy(xpath="(.//*[text()='OneNumber - Set up'])[1]")
	  WebElementFacade OneNumberSetupErrorTitleBox;  
	  @FindBy(xpath="(.//*[text()='Ok'])[2]")
	  WebElementFacade OneNumberSetupErrorOkButton;
 	@Step
 	public void ConfirmOrder() throws InterruptedException, IOException, AWTException{

 		Alert alert;
 		String ActAlertText="";

 		BillingAccountTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		String BillingAccount = BillingAccountTextBox.getTextValue();
 		Assert.assertTrue("FAIL, Billing Account is blank",!BillingAccount.equals(""));

 		NextButtonConfirmOrderPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
 		NextButtonConfirmOrderPage.click();
 		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

 		if (InsufficientFundErrorTitleBox.isCurrentlyVisible()){
 			String ErrorInfo= InsufficientFundErrorMsg.getText();
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

 			Thread.sleep(1000);
 			report.Info("The alert meassage is:"+ErrorInfo);
 			return;
 		}

 		if (OneNumberSetupErrorTitleBox.isCurrentlyVisible()){
 			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 			OneNumberSetupErrorOkButton.click();
 			Common.WaitForClock(ClockObj);
 		}

 		OrderStatusOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

 		/*String Order_Number = OrderNumberinPopUp.getTextValue();
	 		report.Info("Order Number is : "+Order_Number);	*/	
 		String Order_Status = OrderStatus.getTextValue();
 		report.Info("Order Status is : "+Order_Status);	
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 		OrderStatusOKButton.click();

 		report.Info("Order is  created");
 		Common.WaitForClock(ClockObj);
 		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 	}
 	
 	@FindBy(xpath="//button[text()='Order summary'] | //button[text()='Plan order summary'] | //button[text()='Plan summary']")
	WebElementFacade OrderSummaryPage; 
	
	@Step
	public void NavigateToOrderSummaryPage() throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		OrderSummaryPage.click();
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}
 	
}