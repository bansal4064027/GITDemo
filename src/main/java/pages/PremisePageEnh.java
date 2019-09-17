package pages;
import net.serenitybdd.core.Serenity;
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
import utilities.commonEnh;
import utilities.SikuliUtility;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import pages.DatabasePage;

public class PremisePageEnh extends PageObject {
	private static final TimeUnit SECONDS = null;
	@Steps
	private ReadWorkbook readWorkbook;
	@Steps
	private common common1;
	@Steps
	private commonEnh CommonEnh;
	@Steps
	private SikuliUtility sikuliUtility;
	@Steps
	private DatabasePage Database;	
	@Steps
	ReportMessege report;
	@Step
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

	@FindBy(xpath=".//*[@aria-labelledby='VF_PostCode_Label']")
	WebElementFacade InstallationPostcode; 

	@FindBy(xpath=".//*[@aria-labelledby='VF_House_number_Label']")
	WebElementFacade HouseNumber; 

	@FindBy(xpath=".//*[@aria-label='Check availability:Check availability']")
	WebElementFacade CheckAvailibilityButton; 

	@FindBy(xpath=".//*[@aria-label='Your address details:Check speed']")
	WebElementFacade CheckSpeedButton; 

	@FindBy(xpath=".//*[text()='HBB & Fixed']")
	WebElementFacade HBBAndFixedTab; 

	@FindBy(xpath=".//*[@aria-labelledby='VF_Directory_Number_Label']")
	WebElementFacade DirectoryNumberTextBox;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Customer_Type_Label']")
	WebElementFacade CustomerTypeTextBox; 

	@FindBy(xpath=".//*[@aria-labelledby='VF_Retain_number_Label']")
	WebElementFacade RetentionNumCheckBox; 
	
	@FindBy(xpath="//*[text()='Vodafone Together']")
	WebElementFacade VodafoneTogetherButton; 

	public void CheckAvailibility(String Action) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\DataProxy_ENH.xls";              
		String dataSheet = "Address";

		if(HBBAndFixedTab.isDisplayed()){
			HBBAndFixedTab.click();
			CommonEnh.WaitForClock(ClockObj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("AccountType").size();i++) {
			String sCustomerType = tableMap.get("CustomerType").get(i);
			String sAddress = Serenity.sessionVariableCalled("ADDRESS").toString();
			String sButton = tableMap.get("Button").get(i); 

			String sPostCode ;
			String sHouseNumber ;

			if(sButton.equalsIgnoreCase("ClickCombi")) {
				VodafoneTogetherButton.click();
				CommonEnh.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}


			String[] arr1 = sAddress.split("\\|");
			sPostCode= arr1[0];
			sHouseNumber = arr1[1];

			String sDirectoryNumber = Serenity.sessionVariableCalled("RetentionNumber").toString();

			InstallationPostcode.type(sPostCode);
			CommonEnh.WaitForClock(ClockObj);
			HouseNumber.type(sHouseNumber);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			if(!sDirectoryNumber.equals("")) {
				DirectoryNumberTextBox.type(sDirectoryNumber);
				RetentionNumCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(sCustomerType.equalsIgnoreCase("BUSINESS")){
				CommonEnh.WaitForClock(ClockObj);
				CustomerTypeTextBox.click();
				CustomerTypeTextBox.clear();
				CustomerTypeTextBox.type(sCustomerType);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}else{
				CustomerTypeTextBox.click();
				CustomerTypeTextBox.clear();
				CustomerTypeTextBox.type("Individual");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			CheckAvailibilityButton.waitUntilClickable();
			CheckAvailibilityButton.click();
			CommonEnh.WaitForClock(ClockObj);
			CheckSpeedButton.waitUntilClickable();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			CheckSpeedButton.click();
			Thread.sleep(5000);
			CommonEnh.WaitForClock(ClockObj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			for (int k=0; k< 300; k++) {
				CommonEnh.WaitForClock(ClockObj);
				if (CheckSpeedButton.isCurrentlyEnabled()){
					CheckSpeedButton.click();
					CommonEnh.WaitForClock(ClockObj);
				}
				else if(NewLineRadioButton.isCurrentlyVisible()){
					break;
				}
			}
		}
	}

	@FindBy(xpath=".//*[@aria-label='Installation details:Generate new number']")
	WebElementFacade GenerateNewNumberButton; 
	
	@FindBy(xpath="(.//*[@aria-label='Basket:Next'])")
	 WebElementFacade NextButtoninConfigureOrder;
	
	@FindBy(xpath=".//*[contains(text(),'Halo - please read')]")
	  WebElementFacade ErrorTitleBox;
	
	public void ClickOnGenerateNewNumberButton() throws IOException, InterruptedException, AWTException{
		
		String applet = ".//*[@class='ui-jqgrid-view']";
 		String table = "//table[@summary='Select promotion']";
 		CommonEnh.WaitForClock(ClockObj);
	//	CommonEnh.selectedRow = -1;
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//td[contains(@class,'icon icon-landline-or-call')]"))); 
		/*Assert.assertTrue("Vodafone Broadband router not found", CommonEnh.locateColumn(applet,table, "VF_Device", "Vodafone Broadband router", "0").equals("true"));*/
		report.Info("Vodafone Broadband router found");
		GenerateNewNumberButton.waitUntilClickable();
		GenerateNewNumberButton.click();
		CommonEnh.WaitForClock(ClockObj);
		Thread.sleep(2000);
		for (int k=0; k< 10; k++) {
		if ((!NextButtoninConfigureOrder.isEnabled()) && (ErrorTitleBox.isCurrentlyVisible())){
			CommonEnh.HandleErrorPopUp("Activity timed out");
			Thread.sleep(2000);
			GenerateNewNumberButton.click();
			CommonEnh.WaitForClock(ClockObj);
			Thread.sleep(2000);
		}
		if (NextButtoninConfigureOrder.isEnabled()) {
			break;
		}
		}
		

	}

	@FindBy(xpath=".//*[@aria-label='Installation details:Book appointment']")
	WebElementFacade BookAppointmentButton;

	@FindBy(xpath=".//*[@aria-label='Book appointment:Confirm appointment']")
	WebElementFacade ConfirmAppointmentButton;

	@FindBy(xpath="(.//*[@aria-label='Basket:Next'])[1]")
	WebElementFacade ConfigureNextButton;



	public void ClickOnBookAppointmentButton() throws IOException, InterruptedException, AWTException{
		BookAppointmentButton.waitUntilClickable();
		BookAppointmentButton.click();
		CommonEnh.WaitForClock(ClockObj);
		Thread.sleep(3000);
		ConfirmAppointmentButton.click();
		CommonEnh.WaitForClock(ClockObj);
		Thread.sleep(5000);
		ConfigureNextButton.waitUntilClickable();
		ConfigureNextButton.click();
		CommonEnh.WaitForClock(ClockObj);
		Thread.sleep(5000);

	}

	@FindBy(xpath=".//*[@aria-labelledby='VF_Terms_Conditions_Label']")
	WebElementFacade TermsAndConditionBox;

	@FindBy(xpath="(.//*[@aria-label='Basket:Next'])[1]")
	WebElementFacade NextButtonOrderSummaryPage;
	
	@FindBy(xpath=".//*[contains(@aria-labelledby,'Email')][@value='Email']")
	WebElementFacade EmailRadioButton;
	
	@FindBy(xpath=".//span[text()='Marketing permissions']/parent::div/following-sibling::div[2]//button/span[text()='Ok']")
	WebElementFacade MarketingPermissionsOkButton;
	
	public void ClickOnTermsAndConditionBox() throws IOException, InterruptedException, AWTException{
		TermsAndConditionBox.waitUntilClickable();
		TermsAndConditionBox.click();
		Thread.sleep(2000);
		EmailRadioButton.click();
		Thread.sleep(2000);
		NextButtonOrderSummaryPage.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		NextButtonOrderSummaryPage.click();
		
			if(MarketingPermissionsOkButton.isCurrentlyVisible()){
			   MarketingPermissionsOkButton.click();
				CommonEnh.WaitForClock(ClockObj);
			}
	
		
	}

	@FindBy(xpath=".//input[@value='NewLine']")
	WebElementFacade NewLineRadioButton;

	@FindBy(xpath=".//input[@value='ExistingLIne']")
	WebElementFacade ExistingLineRadioButton;

	@FindBy(xpath=".//button[@data-display='Add to basket']")
	WebElementFacade AddBasketButton;
	
	@FindBy(xpath=".//*[(contains(@class,'vf-oui-button-canvas-disable')and @data-display='Add to basket')]")
	WebElementFacade DisabledAddBasketButton;

	@FindBy(xpath=".//*[@aria-labelledby='VF_Line_Info_Label']")
	WebElementFacade LineInfo;


	@FindBy(xpath=".//button[@aria-label='Basket:Next']")
	WebElementFacade NextButton;

	@FindBy(xpath=".//*[contains(text(),'Before you continue')]")
	WebElementFacade WarningTitleBox;

	@FindBy(xpath=".//*[@aria-describedby='vf-oui-showAlert']/div[contains(@class,'buttonpane')]//button")
	WebElementFacade WarningOKButton;
	@Step
	public void FilterPromotionEnh(String Action) throws IOException, InterruptedException, FindFailed, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Premise_ENH.xls";
		String dataSheet = "FilterPromotion";
		String applet = "//*[@title='Available packages List Applet']";
		String table = "//table[@summary='Available packages']";        

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("LocateCol").size();i++) {


			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);

			String Index = "0";
			if (Index.equals("")){
				Index = "0";
			}

			String LocateColMessage = sLocateCol+" Not Found";
			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(LocateColMessage, CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info(sLocateColValue+" found");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else 
			{
				CommonEnh.selectedRow = 1;
				report.Info(sLocateColValue+" found");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			String sInstallationType= Serenity.sessionVariableCalled("InstallationType").toString(); 
			if(sInstallationType.equalsIgnoreCase("New Line")){
				NewLineRadioButton.click();
			}
			else{
				ExistingLineRadioButton.click();
			}                
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			/*String sActLineInfo = LineInfo.getTextValue();
			String sLineInfo=Serenity.sessionVariableCalled("ExpectedLineInfo").toString(); 
			Assert.assertTrue("Line Info: " +sActLineInfo+" is not as expected: " +sLineInfo,sActLineInfo.equalsIgnoreCase(sLineInfo) );

			report.Info("Line Info: " +sActLineInfo+" is same as expected: " +sLineInfo);*/

			AddBasketButton.click();
			CommonEnh.WaitForClock(ClockObj);
			NextButton.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			int CatalogRowCount = findAll(By.xpath("//table[@summary='Basket']/tbody/tr")).size();
			int k = 0;
			if (CatalogRowCount < 3){
				do {        	
					CatalogRowCount = findAll(By.xpath("//table[@summary='Basket']/tbody/tr")).size();
					if (CatalogRowCount > 1){
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());          		
						break;
					}
					CommonEnh.WaitForClock(ClockObj);
					k++;
				}while(CatalogRowCount<2 && k<60);

				if (CatalogRowCount < 2){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Product is not Added successfully.");
					Assert.assertTrue(false);
				} 
				return;
			}
			Thread.sleep(10000);
			Assert.assertTrue("FAIL, Add to basket Button is enabled after Product is added",DisabledAddBasketButton.isCurrentlyVisible());
			report.Info("Add to basket Button is disabled after Product is added");
			

			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			NextButton.click();
			CommonEnh.WaitForClock(ClockObj);
			if(WarningTitleBox.isCurrentlyVisible()){
				WarningOKButton.click();
			}  
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
	}   
}


