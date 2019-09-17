package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;

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

public class ProductAndServicePageEnh extends PageObject{

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

	@FindBy(xpath="(.//*[@title='VF OUI Dymanic Device BC List Applet:'])[1]")
	WebElementFacade SelectFirstApple; 	
	@FindBy(xpath="(.//*[@title='VF OUI Dymanic Device BC List Applet:'])[2]")
	WebElementFacade SelectFirstApplePrepaid; 	
	@FindBy(xpath="//*[@aria-label='Search A Plan:' and contains(@class,'siebui-ctrl-btn siebui-icon-showpopup')]")
	WebElementFacade SelectFirstPromotion; 
	@FindBy(xpath="(.//*[@title='Search A Plan:'])[2]")
	WebElementFacade SIMFirstPromotion; 
	@FindBy(xpath="//*[@aria-label='Search A Plan:' and @rn='Add2Basket']")
	WebElementFacade SoftwareFirstPromotion;

	@FindBy(xpath=".//span[text()='Existing Software & Services']/parent::div/following-sibling::div[2]//button")
    WebElementFacade ExistingSoftwareOKButton;
	
	//String SIMFirstPromotion = "(.//*[@title='Search A Plan:'])[2]";

	//find(By.xpath("//*[@aria-label='Search A Plan:' and contains(@class,'siebui-ctrl-btn siebui-icon-showpopup')]")).click();



	@FindBy(xpath="(.//*[@title='Search A Plan:'])[1]")
	WebElementFacade HandsetFirstPromotion; 	
	@FindBy(xpath="(.//*[@name='Search by SKU'])[1]")
	//@FindBy(xpath="(.//*[@placeholder='Search by Name...'])[1]")
	WebElementFacade SearchProduct;

	@FindBy(xpath="(.//*[@aria-label='Select a plan:'])[1]")
	WebElementFacade SearchPlanForPlan;
	@FindBy(xpath=".//*[text()='Select a device']")
	WebElementFacade SearchPlanForDevice;

	//@FindBy(xpath="(.//*[@ title='Close'][contains(@class,'ui-dialog-titlebar-close')])[3]")
	@FindBy(xpath="(.//*[@ title='Close'][contains(@class,'ui-dialog-titlebar-close')])/following-sibling::div")	
	WebElementFacade SearchPlanForDeviceClose;	

	@FindBy(xpath="(.//span[@class='icon icon-search'])[1]")
	WebElementFacade SearchIcon;

	@FindBy(xpath=".//*[text()='Apply filters']")
	WebElementFacade ApplyFiltersButton;
	@FindBy(xpath=".//label[text()='Apple']")
	WebElementFacade AppleCheckbox;
	@FindBy(xpath="(.//a[text()=' Show more'])[1]")
	WebElementFacade ShowMoreaHandsetLink;
	@FindBy(xpath="(.//*[@title='VF OUI Dymanic Device BC List Applet:'])[1]")
	WebElement SelectFirstAppleSync;
	@FindBy(xpath="(//*[contains(@class,'vf-sort-by-dropdown vf-oui-default-readonly-grey')])[1]")
	WebElement SortByDropDown;
	@FindBy(xpath="(.//*[text()='No Records'])[2]")
	WebElementFacade NoRecords;

	//@FindBy(xpath="(.//*[@aria-label='Basket:Next'])[1]")
	//WebElementFacade BasketNext;

	@FindBy(xpath=".//*[text()='Apply filters']")
	WebElementFacade ApplyFilterButtoninProdandSearch;
	/*@FindBy(xpath="(.//*[@title='Search A Plan:'])[2]")
	WebElementFacade SIMFirstPromotion; */
	@FindBy(xpath="//button/span[text()='Next']")
	WebElementFacade ProductandServicesNextButton; 
	
	@FindBy(xpath=".//*[@aria-label='First name']")
	WebElementFacade FirstNameTextBoxinAboutCustomer; 
	@FindBy(xpath=".//*[contains(text(),'Halo - please read')]")
	WebElementFacade ErrorTitleBox;  
	@FindBy(xpath=".//div[contains(@class,'popup-info')]")
	WebElementFacade ErrorMsg; 
	@FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
	WebElementFacade ErrorOkButton;
	@FindBy(xpath="(.//*[text()='Products & Services'])[2]")
	WebElementFacade ProductandServicesTab;
	@FindBy(xpath=".//*[text()='Pay monthly']")
	WebElementFacade PayMonthlyTab; 
	@FindBy(xpath=".//button[@title='Basket:Customise']")
	WebElementFacade customiseButtonEnh;
	@FindBy(xpath=".//*[@id='first_pager_s_3_1	']")
	WebElementFacade PreviousRecord;
	@FindBy(xpath=".//*[text()='Halo - Bill history']")
	WebElementFacade BillHistory;
	@FindBy(xpath=".//*[@id=\"gview_s_3_l\"]")
	WebElementFacade BillApplet;
	@FindBy(xpath=".//*[@aria-label='Billing profile:Customer account']")
	WebElementFacade BillingProfCustomerAccount;
	
	@FindBy(xpath=".//input[@value='Loan']")
	WebElementFacade LoanRadioButton;
	@FindBy(xpath=".//label[text()='Non-Loan']")
	WebElementFacade NonLoanRadioButton;
	@FindBy(xpath=".//button[text()='Apply filters']")
	WebElementFacade ApplyFilterButton;

	@Step
	public void ProductSearch(String ProductType) throws InterruptedException, IOException, AWTException{

		//Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Catalog_ENH.xls";
		String dataSheet = "CatalogueSearch";
		String ProductNumber = Serenity.sessionVariableCalled("PartNo").toString();
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(ProductType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("ProductType").size();i++) {
			String sProductCategory = tableMap.get("ProductCategory").get(i);
			String sProductType = tableMap.get("ProductType").get(i);
			String sSearchBy = tableMap.get("SearchBy").get(i);
			String sHandsetID = tableMap.get("HandsetID").get(i);
			String sNavigate = tableMap.get("Navigate").get(i);
			String sValidation = tableMap.get("Validation").get(i);

			String sProductCategoryPath = ".//*[text()='"+sProductCategory+"']";
			String sProductTypePath = ".//*[text()='"+sProductType+"']";    


			String sRadioButtonSKU = "(.//*[@type='radio'][@name='Name'][@value='SKU'])";
			String sRadioButtonNAME = "(.//*[@type='radio'][@name='Name'][@value='Name'])";
			String recordIndex="";

			Common.WaitForClock(ClockObj);
			find(By.xpath(sProductTypePath)).click();
			Common.WaitForClock(ClockObj);

			/*Assert.assertTrue("FAIL: Next Button is enabled even though product is not added",!ProductandServicesNextButton.isEnabled());
			report.Info("Next button is disabled as product is not added");
			*/
			
			if (!sProductCategory.equals("")){
				find(By.xpath(sProductCategoryPath)).withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				find(By.xpath(sProductCategoryPath)).click();
				Common.WaitForClock(ClockObj);
			}

			Common.WaitForClock(ClockObj);//Code to handle BINGO handset visibility
			if (NonLoanRadioButton.isCurrentlyVisible() ) {
				NonLoanRadioButton.click();
				ApplyFilterButton.click();
				Common.WaitForClock(ClockObj);
			}

			if(!sSearchBy.equals("")&&(!sSearchBy.equals("Search By SKU"))){
				String sSearchByPath = ".//*[text()='"+sSearchBy+"']"; 
				//Common.WaitForClock(ClockObj);
				find(By.xpath(sSearchByPath)).withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				find(By.xpath(sSearchByPath)).click(); 
				//    	CommonEnh.waitForPageLoad1(getDriver());// debug here

				Common.WaitForClock(ClockObj);
			}
			Common.WaitForClock(ClockObj);//Code to handle BINGO handset visibility
			if (NonLoanRadioButton.isCurrentlyVisible() ) {
				NonLoanRadioButton.click();
				ApplyFilterButton.click();
				Common.WaitForClock(ClockObj);
				}
			
			int CatalogRowCount = '0';

			//Unwanted popup workaround       
			if(ErrorTitleBox.isCurrentlyVisible()){
				String ErrorInfo= ErrorMsg.getText();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ErrorOkButton.click();
				report.Info("The alert meassage is:"+ErrorInfo);


			}

			PayMonthlyTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

			//  To Add Handset	
			if(sProductCategory.equals("Phone")||sProductCategory.equals("Tablet")||sProductCategory.equals("MBB")||sProductCategory.equals("Device & plan")||sProductCategory.equals("Device (keep plan)")||sProductCategory.equals("Device only")||sProductCategory.equals("Device & plan")||sProductCategory.equals("Device & plan (tablet)")){
				Common.WaitForClock(ClockObj);
				if(findBy(sRadioButtonSKU+"[1]").isCurrentlyVisible()){
					recordIndex="1";
					findBy(sRadioButtonSKU+"[1]").click();
				}
				else if(findBy(sRadioButtonSKU+"[2]").isCurrentlyVisible()){
					recordIndex="2"; 
					findBy(sRadioButtonSKU+"[2]").click();
				}
				else{
					report.Info("SKU Radio Button not found");
					Assert.assertTrue(false);

				}
				String SearchTextBox="(.//*[@type='radio'][@name='Name'][@value='SKU'])["+recordIndex+"]/parent::div/following-sibling::div/input";
				String SelectFirstAppleButton = "(.//*[@title='VF OUI Dymanic Device BC List Applet:'])["+recordIndex+"]";
				//  Search by device      
				if (sSearchBy.equals("Search by device")){
					//	 find(By.xpath(SearchTextBox)).clear();
					find(By.xpath(SearchTextBox)).sendKeys(sHandsetID);

					JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
					SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]"))); 

					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if(SelectFirstApple.isCurrentlyVisible()){
						SelectFirstApple.click();
						report.Info("HandSet found: "+sHandsetID);
						Common.WaitForClock(ClockObj);
					}
					else{
						report.Info("HandSet not found : "+sHandsetID);
						Assert.assertTrue(false);

					}
					//find(By.xpath(SelectFirstAppleButton)).click();


					SearchPlanForPlan.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyEnabled();
					Common.WaitForClock(ClockObj);
					/*int totalRows = findAll(By.xpath("//*[contains(@id,'S_A1') and contains(@class,'siebui-tile')]")).size();
					report.Info("Total: "+totalRows);
					for(int j=0;j<=totalRows;j++){
						Common.WaitForClock(ClockObj);
						String promo = find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//input[contains(@aria-labelledby,'VF_OUI_SKU_code_Label')]")).getAttribute("value");
						//String promo = find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//input[contains(@aria-labelledby,'VF_OUI_SKU_code_Label')]")).getTextValue();

						if (promo.equals(ProductNumber)){
							find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//button[@title='Select a plan:']")).click();
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							report.Info("Promotion found: "+ProductNumber);
							break;
						}
					}*/
					
					int totalRows = findAll(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'tile') and contains(@class,'siebui-tile')]")).size();
					String sId=find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_1') and contains(@class,'siebui-tile')]")).getAttribute("id");

					
					sId  = sId.replace("S_A","");
					sId  = sId.replace("_tile_1","");
					
					String NextSet = "//div[@id='a_"+sId+"']//button[contains(@class,'gotonextset')]";
					
					String Flag = "N";
					for (int x =0;x<=9;x++) {
						
					
						for(int j=0;j<totalRows;j++){
							Common.WaitForClock(ClockObj);
							String promo = find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//input[contains(@aria-labelledby,'VF_OUI_SKU_code_Label')]")).getAttribute("value");
							//String promo = find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//input[contains(@aria-labelledby,'VF_OUI_SKU_code_Label')]")).getTextValue();

							if (promo.equals(ProductNumber)){
								find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//button[@title='Select a plan:']")).click();
								sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
								report.Info("Promotion found: "+ProductNumber);
								Flag = "Y";
								break;
							}
						}
							if(Flag.equals("Y")) {
								break;
								
							}
							else {
								report.Info("Promotion not found, navigating to next set/page ");
								find(By.xpath(NextSet)).click();
							}
							
					}
					Assert.assertTrue("Promotion not found, in 6th pages", Flag.equals("Y"));
	                 Common.WaitForClock(ClockObj);
	                 Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}

				// 	Search by price plan
				if (sSearchBy.equals("Search by price plan")){
					// String SIMFirstPromotion = ".//*[@aria-label='Search A Plan:' And contains(@class,'siebui-ctrl-btn siebui-icon-showpopup')]";
					find(By.xpath(SearchTextBox)).sendKeys(ProductNumber);

					JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
					SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]"))); 
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if(SelectFirstPromotion.isCurrentlyVisible()){
						SelectFirstPromotion.click();
						report.Info("Promotion found: "+ProductNumber);
						Common.WaitForClock(ClockObj);
					}
					else{
						report.Info("Promotion not found : "+sHandsetID);
						Assert.assertTrue(false);

					}

					SearchPlanForDevice.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyEnabled();
					int totalRows = findAll(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'tile') and contains(@class,'siebui-tile')]")).size();
					String sId=find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_1') and contains(@class,'siebui-tile')]")).getAttribute("id");

					sId  = sId.replace("S_A","");
					sId  = sId.replace("_tile_1","");
					
					String NextSet = "//div[@id='a_"+sId+"']//button[contains(@class,'gotonextset')]";
					
					String Flag = "N";
					for (int x =0;x<=9;x++) {
						
					
							for(int j=0;j<totalRows;j++){
								String colour = find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//div[contains(@class,'vf-oui-in-stock vf-oui-color')]")).getAttribute("class");							
								if (colour.contains("green")){
									//find(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//button[contains(@aria-label,'Select a device:')]")).click();
									JavascriptExecutor GreenButton = (JavascriptExecutor)getDriver();
									GreenButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//*[contains(@id,'S_A1') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//button[contains(@aria-label,'Select a device:')]")));
									sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
									report.Info("Handset found: ");
									Flag = "Y";
									break;
								}
							}
							if(Flag.equals("Y")) {
								break;
								
							}
							else {
								report.Info("Handset not found, navigating to next set/page ");
								find(By.xpath(NextSet)).click();
							}
							
					}
					Assert.assertTrue("Handset not found, in 6th pages", Flag.equals("Y"));
	                 Common.WaitForClock(ClockObj);
					
					if(HouseholdDiscountOkButton.isCurrentlyVisible()){
						HouseholdDiscountOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						HouseholdDiscountOkButton.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						
						LoyaltyOfferOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						LoyaltyOfferOkButton.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
					Common.WaitForClock(ClockObj);
					
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				///Search Prepay
				if (sSearchBy.equals("")){
					//find(By.xpath(SearchTextBox)).clear();
					find(By.xpath(SearchTextBox)).sendKeys(sHandsetID);

					JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
					SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]"))); 


					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if(SelectFirstApplePrepaid.isCurrentlyVisible()){
						SelectFirstApplePrepaid.click();
						//find(By.xpath(SelectFirstApple)).click();
						report.Info("HandSet found: "+sHandsetID);
						Common.WaitForClock(ClockObj);
					}
					else{
						report.Info("HandSet not found : "+sHandsetID);
						Assert.assertTrue(false);
					}


				}

			}

			if (sSearchBy.equals("Search By SKU")){

				int	AllRadioButtonSKU = findAll(By.xpath(sRadioButtonSKU)).size();
    			for(int j=1;j<=AllRadioButtonSKU;j++){
    				if(findBy(sRadioButtonSKU+"["+j+"]").isCurrentlyVisible()) {
    					findBy(sRadioButtonSKU+"["+j+"]").click();
    					String str1 = Integer.toString(j); 
    					recordIndex=str1;
    					report.Info("SKU Clicked");
    					break;
    				}
    			}
				
				Thread.sleep(2000);
				String SearchTextBox="(.//*[@type='radio'][@name='Name'][@value='SKU'])["+recordIndex+"]/parent::div/following-sibling::div/input";
				find(By.xpath(SearchTextBox)).sendKeys(sHandsetID);
				
				JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
				SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]"))); 

	
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(SIMFirstPromotion.isCurrentlyVisible()){
					SIMFirstPromotion.click();
					//find(By.xpath(SelectFirstApple)).click();
					report.Info("HandSet found: "+sHandsetID);
					Common.WaitForClock(ClockObj);
				}
				else{
					report.Info("HandSet not found : "+sHandsetID);
					Assert.assertTrue(false);
				}
				Common.WaitForObjectPresence(".//*[@title='Basket:Next' and @class='siebui-ctrl-btn siebui-icon-proceedwithproceed s_11_1_7_0 appletButton']");		
				Thread.sleep(3000);
				//ProductandServicesNextButton.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();  
				//ProductandServicesNextButton.click();
			}

			//  To Add Postpaid Promotions 	
			if(sProductCategory.equals("SIM only")){
				Common.WaitForClock(ClockObj);
				if (!sProductType.equals("Voxi")){
					PayMonthlyTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

					if(findBy(sRadioButtonSKU+"[1]").isCurrentlyVisible()){
						recordIndex="1";
						findBy(sRadioButtonSKU+"[1]").click();
					}
					else if(findBy(sRadioButtonSKU+"[2]").isCurrentlyVisible()){
						recordIndex="2"; 
						findBy(sRadioButtonSKU+"[2]").click();
					}
					else{
						report.Info("SKU Radio Button not found");
						Assert.assertTrue(false);
					}
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					String SearchTextBox="(.//*[@type='radio'][@name='Name'][@value='SKU'])["+recordIndex+"]/parent::div/following-sibling::div/input";


					//    find(By.xpath(SearchTextBox)).clear();
					find(By.xpath(SearchTextBox)).sendKeys(ProductNumber);

					JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
					SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]"))); 

					Thread.sleep(10000);
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}   
				if(SIMFirstPromotion.isCurrentlyVisible() ){
					SIMFirstPromotion.click();
					Common.WaitForClock(ClockObj);
					if(HouseholdDiscountOkButton.isCurrentlyVisible()){
						HouseholdDiscountOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						HouseholdDiscountOkButton.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

						LoyaltyOfferOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						LoyaltyOfferOkButton.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
					report.Info("Promotion found: "+ProductNumber);
				}
				else{
					report.Info("Promotion not found : "+ProductNumber);
					Assert.assertTrue(false);

				}     

			}

			if(sProductCategory.equals("Accessories")||sProductCategory.equals("Billing")){
				Common.WaitForClock(ClockObj);
				if(findBy(sRadioButtonSKU+"[1]").isCurrentlyVisible()){
					recordIndex="1";
					findBy(sRadioButtonSKU+"[1]").click();
				}
				else if(findBy(sRadioButtonSKU+"[2]").isCurrentlyVisible()){
					recordIndex="2"; 
					findBy(sRadioButtonSKU+"[2]").click();
				}
				else{
					report.Info("SKU Radio Button not found");
					Assert.assertTrue(false);
				}

				String SearchTextBox="(.//*[@type='radio'][@name='Name'][@value='SKU'])["+recordIndex+"]/parent::div/following-sibling::div/input";

				//  Search by device      
				if (sSearchBy.equals("")){
					//find(By.xpath(SearchTextBox)).clear();
					find(By.xpath(SearchTextBox)).sendKeys(sHandsetID);

					JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
					SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]"))); 

					Common.WaitForClock(ClockObj);

					SelectFirstApplePrepaid.click();
					report.Info("HandSet found: "+sHandsetID);
					Common.WaitForClock(ClockObj);
				}        	
			}
			
				if(sProductCategory.equals("Software")){
					Common.WaitForClock(ClockObj);
					int	AllRadioButtonSKU = findAll(By.xpath(sRadioButtonSKU)).size();
	    			for(int j=1;j<=AllRadioButtonSKU;j++){
	    				if(findBy(sRadioButtonSKU+"["+j+"]").isCurrentlyVisible()) {
	    					findBy(sRadioButtonSKU+"["+j+"]").click();
	    					String str1 = Integer.toString(j); 
	    					recordIndex=str1;
	    					report.Info("SKU Clicked");
	    					break;
	    				}
	    			}
	
					String SearchTextBox="(.//*[@type='radio'][@name='Name'][@value='SKU'])["+recordIndex+"]/parent::div/following-sibling::div/input";
					//SoftwareFirstPromotion
					//  Search by device      
					if (sSearchBy.equals("")){
						//find(By.xpath(SearchTextBox)).clear();
						find(By.xpath(SearchTextBox)).sendKeys(ProductNumber);
	
						JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
						SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]"))); 
	
						Common.WaitForClock(ClockObj);
	
						SoftwareFirstPromotion.click();
						report.Info("Promotion/Part Id found: "+ProductNumber);
						Common.WaitForClock(ClockObj);
						
						if(sValidation.equalsIgnoreCase("SecondAppDirectPopUp")) {
							Assert.assertTrue("FAIL, The customer already has an active Software & Services account popup is not displayed",ExistingSoftwareOKButton.isVisible());
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							ExistingSoftwareOKButton.click();
							Common.WaitForClock(ClockObj);

							if(sNavigate.equals("") ){
								return;
							}
						}
						
					}        	
				}
			
			
			if(sProductCategory.equals("Other")){
				Common.WaitForClock(ClockObj);
				if(findBy(sRadioButtonNAME).isCurrentlyVisible()){
					recordIndex="1";
					findBy(sRadioButtonNAME).click();
				}				
				String SearchTextBox="(.//*[@type='radio'][@name='Name'][@value='Name'])["+recordIndex+"]/parent::div/following-sibling::div/input";
      
				if (sSearchBy.equals("")){
					find(By.xpath(SearchTextBox)).sendKeys(sHandsetID);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
					SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]")));
					Common.WaitForClock(ClockObj);
					SelectFirstApplePrepaid.click();
					report.Info("HandSet found: "+sHandsetID);
					Common.WaitForClock(ClockObj);
				}      
				if(sValidation.equals("ApplyFilterDisabled")){
					Assert.assertTrue("FAIL, Apply Filters Button is Enabled",!ApplyFiltersButton.isCurrentlyEnabled());
					report.Info("Apply Filters Button is Disabled as Expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					return;
				}
				if(sValidation.equals("SortByDisabled")){
					Assert.assertTrue("FAIL, Sort By Button is Enabled",!SortByDropDown.isEnabled());
					report.Info("Sort By Drop Down is Disabled as Expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					return;
				}
				if(sValidation.equals("HandsetNotFound")){
					find(By.xpath(SearchTextBox)).sendKeys(sHandsetID);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
					SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]")));
					Common.WaitForClock(ClockObj);
					Assert.assertTrue("FAIL, Product is not sales expired",NoRecords.isCurrentlyVisible());
					report.Info("Sales Expired Product is not visible as Expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.WaitForClock(ClockObj);
					return;
				}
			}

			if(sValidation.equals("Customise")){
				Common.WaitForClock(ClockObj);
				if (!(customiseButtonEnh.isCurrentlyVisible())){
					report.Info("Customise Button is not visible");
					return;
				}
				else{
					report.Info("Customise Button is visible");
					Assert.assertTrue(false);
					return;
				}
			}

			//ProductandServicesNextButton.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
			Thread.sleep(5000);
			Common.WaitForClock(ClockObj);
			/*CatalogRowCount = findAll(By.xpath("//table[@summary='Basket']/tbody/tr")).size();
			int k = 0;
			if (CatalogRowCount < 3){
				do {        	
					CatalogRowCount = findAll(By.xpath("//table[@summary='Basket']/tbody/tr")).size();
					if (CatalogRowCount > 1){
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());          		
						break;
					}
					Common.WaitForClock(ClockObj);
					k++;
				}while(CatalogRowCount<2 && k<60);

				if (CatalogRowCount < 2){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Product is not Added successfully.");
					Assert.assertTrue(false);
				} 
				
			}
*/
			int k = 0;
			boolean productflag=false;
			do {
			CatalogRowCount = findAll(By.xpath("//table[@summary='Basket']/tbody/tr")).size();
			if (CatalogRowCount >=1 ){
				if(CatalogRowCount ==1 ) {
					String rowName= findBy("//table[@summary='Basket']/tbody/tr").getAttribute("class");
					if(rowName.contains("firstrow")) {
						Common.WaitForClock(ClockObj);
						k++;	
					}
					else {
						productflag=true;
					}
				}
				else {
					productflag=true;
				}
			}
			}while(productflag=false && k<60);
					
			if(!sNavigate.equals("") ){
				Common.WaitForClock(ClockObj);
				ProductandServicesNextButton.click();
				Common.WaitForClock(ClockObj);
			}
			else{
				Common.WaitForClock(ClockObj);			
				
				
				Robot robot = new Robot();	 
				robot.keyPress(KeyEvent.VK_F5);	
				robot.keyRelease(KeyEvent.VK_F5); 
				
				//ProductandServicesTab.click();
				Common.WaitForClock(ClockObj);
				PayMonthlyTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			}

		}


		;
		//FirstNameTextBoxinAboutCustomer.withTimeoutOf(300,TimeUnit.SECONDS).waitUntilClickable();
	}
	@FindBy(xpath="//*[text()='Previous bills']")
	WebElementFacade PreviousBillsApplet;

	@FindBy(xpath=".//*[text()='Halo - Service charges']/parent::li")
	WebElementFacade HaloServiceChargesTab;

	@FindBy(xpath=".//*[text()='Halo - Bill adjustments']")
	WebElementFacade BillAdjustmentsTab;

	@FindBy(xpath=".//*[text()='Payments']")
	WebElementFacade PaymentsTab;

	@FindBy(xpath=".//div[text()='Payments']")
	WebElementFacade PaymentsApplet;

	@FindBy(xpath=".//div[text()='Bill adjustments']")
	WebElementFacade BillAdjustmentsApplet;
	
	@FindBy(xpath=".//*[text()='Balance summary']")
	WebElementFacade BalanceSummaryTab;

	@Step
	public void OwnedProductServicesLineItems(String LogicalName) throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_Enh.xls";
		String dataSheet = "OwnedProductServicesLineItems";
		String applet = "";
		String table = "";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      				
			String Index = tableMap.get("Index").get(i);				
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);	
			String sView = tableMap.get("View").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sValidation = tableMap.get("Validation").get(i);

			Thread.sleep(3000);

			if (sLocateColValue.equals("BILLNUMBER")){
				sLocateColValue = Serenity.sessionVariableCalled("BILLNUMBER0").toString();
			}

			if (sLocateColValue.equals("BILLBALANCE")){
				sLocateColValue = Serenity.sessionVariableCalled("BILL_BALANCE0").toString();
				if(!sLocateColValue.contains("."))
				{
					sLocateColValue = "£"+sLocateColValue+".00";						
				}
				else if(!sLocateColValue.contains("£")) {
					sLocateColValue = "£"+sLocateColValue;
				}

			}

			if(sView.equalsIgnoreCase("Owned") || sView.equalsIgnoreCase("") ){
				OwnedButton.click();
				Common.WaitForClock(ClockObj);
				applet = "//*[contains(@title,'Owned line items List Applet')]";
				table = "//table[@summary='Owned line items']";
				report.Info("Owned view");
			}
			else if(sView.equalsIgnoreCase("Billed")){
				BilledButton.click();
				Common.WaitForClock(ClockObj);
				applet = "//*[contains(@title,'Billed line items List Applet')]";
				table = "//table[@summary='Billed line items']";
				report.Info("Billed View");

			}
			else if(sView.equalsIgnoreCase("Used")){
				UsedButton.click();
				Common.WaitForClock(ClockObj);
				applet = "//*[contains(@title,'Used line items List Applet')]";
				table = "//table[@summary='Used line items']";
				report.Info("Used View");

			}
			else if(sView.equalsIgnoreCase("Billing")){
				String IDValue = "";
				IDValue = find(By.xpath("//*[contains(@class,'-billing-master')]")).getAttribute("id");
				IDValue = IDValue.replace("S_A","");											
				applet = "//*[contains(@title,'Billing List Applet')][contains(@id,'"+IDValue+"')]";
				table = "//table[@summary='Billing'][contains(@id,'"+IDValue+"')]";				
				report.Info("Billing View");
			}

			else if(sView.equalsIgnoreCase("ProductandServices")){
				applet = "//*[contains(@title,'Products & services List Applet')]";
				table = "//table[@summary='Products & services']";
				report.Info("Billing View");
			}

			else if(sView.equalsIgnoreCase("PreviousBill")){
				applet = "//*[contains(@title,'Previous bills List Applet')]";
				table = "//table[@summary='Previous bills']";
				report.Info("Previous Bills View");
			}

			if (Index.equals("")){
				Index = "0";
			}      															

			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equalsIgnoreCase("true"));
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{               
				Common.selectedRow = 1;
			}

			if (!sUIName.equals("")){ 
				String sValue = CommonEnh.updateSiebList(applet,table, sUIName, svalue); 
				if (sUIName.contains("CaptureTextValue|Bill_Number")){	
					Serenity.setSessionVariable("CapturedBILLNumber").to(sValue);
				}
				if (sUIName.contains("CaptureTextValue|Bill_Charge")){	
					Serenity.setSessionVariable("CapturedBalance").to(sValue);
				}
				Common.WaitForClock(ClockObj);
				report.Info("Row updated successfully"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  				
			} 	

			if(sAction.equals("DrillOnNameandCheckBillNumber"))
			{
				String SiebBILLNUMBER = Serenity.sessionVariableCalled("CapturedBILLNumber").toString();
				String BRMBILLNUMBER = Serenity.sessionVariableCalled("BILLNUMBER0").toString();
				Assert.assertTrue("Bill Number is not similar to BRM", SiebBILLNUMBER.equalsIgnoreCase(BRMBILLNUMBER));
				report.Info("Bill Number : " +SiebBILLNUMBER + "matched with BRM Bill Number : " +BRMBILLNUMBER); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}	
			if(sAction.equals("DrillOnNameandCheckBillBalance"))
			{
				String SiebBILLBALANCE = Serenity.sessionVariableCalled("CapturedBalance").toString();
				String BRMBILLBALANCE = Serenity.sessionVariableCalled("BILL_BALANCE0").toString();
				Assert.assertTrue("Bill Balance is not similar to BRM", SiebBILLBALANCE.contains(BRMBILLBALANCE));
				report.Info("Bill Balance matched with BRM Bill Balance");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if(sAction.equals("DrillOnNameandCheckCutomerAccount"))
			{
				Common.WaitForClock(ClockObj);
				Assert.assertTrue("Customer Account Button is not Dispalyd after Clicking on Name", BillingProfCustomerAccount.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(sValidation.equals("PreviousBill"))
			{
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Previous Bills applet is not Displayed after Clicking on Billing Profile", PreviousBillsApplet.isCurrentlyVisible());
				report.Info("Previous Bills applet is Displayed after Clicking on Billing Profile"); 

			}
			if(sAction.equals("DrillOnNameandCheckBalanceSummary"))
			{
				Common.WaitForClock(ClockObj);
				Assert.assertTrue("Customer Account Button is not Dispalyd after Clicking on Name", BalanceSummaryTab.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if(sValidation.equals("DefaultIsServiceChargesTab"))
			{
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				String isSelected= HaloServiceChargesTab.getAttribute("aria-label");
				Assert.assertTrue("Halo Service Charges view is not Default view after selecting Bill No.", isSelected.contains("Selected"));
				report.Info("Halo Service Charges view is Default view after selecting Bill No."); 

			}

			if(sValidation.equals("BillAdjustments"))
			{
				Common.WaitForClock(ClockObj);
				BillAdjustmentsTab.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Bill Adjustments applet is not Displayed after Clicking on Bill Adjustments Tab", BillAdjustmentsApplet.isCurrentlyVisible());
				report.Info("Bill Adjustments applet is Displayed after Clicking on Bill Adjustments Tab"); 

			}

			if(sValidation.equals("Payments"))
			{
				Common.WaitForClock(ClockObj);
				PaymentsTab.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Payments applet is not Displayed after Clicking on Payments Tab", PaymentsApplet.isCurrentlyVisible());
				report.Info("Payments applet is Displayed after Clicking on Payments Tab"); 

			}
		}
	}	


	@FindBy(xpath=".//*[@class='ui-tabs-anchor'][text()='Owned']") 
	WebElementFacade OwnedButton;
	@FindBy(xpath=".//*[@class='ui-tabs-anchor'][text()='Billed']") 
	WebElementFacade BilledButton;
	@FindBy(xpath=".//*[@class='ui-tabs-anchor'][text()='Used']") 
	WebElementFacade UsedButton;

	@FindBy(xpath=".//*[@class='vfoui-select-options-div vfoui-ao-product-services-dropdown-enabled']//following-sibling::span[@class='icon icon-chevron-down vf-top-menu-itm']") 
	WebElementFacade SelectActionListButton;
	
	@FindBy(xpath="//div[@title='Service Requests Form Applet']")
	WebElementFacade SRApplet;
	
	@FindBy(xpath="//*[text()='SR request']/ancestor::div//span[text()='Ok']")
	WebElementFacade SRRaisePopupOkButton;
	
	@FindBy(xpath=".//li[contains(@data-caption,'Perform additional actions')]")
	WebElementFacade PerformAdditionalAction;	
	
	@FindBy(xpath=".//li[@data-caption='Customise']")
	WebElementFacade Customise;
	@FindBy(xpath=".//li[@data-caption='Check credit limit']")
	WebElementFacade CreditLimit;
	@FindBy(xpath=".//li[@data-caption='Disconnection/Fee calculator']")
	WebElementFacade DisconnectionFeeCalculator;

	@FindBy(xpath=".//*[@value='Immediate disconnection']")
	WebElementFacade ImmediateDisconnection;
	
	@FindBy(xpath=".//*[@aria-label='Disconnect service:Next']")
	WebElementFacade DisconnectNextButton;
	
	@FindBy(xpath=".//*[@aria-label='Customer details:Go to account']")
	WebElementFacade GoToAccount;
	
	@FindBy(xpath=".//*[contains(text(),'Reason')]")
	  WebElementFacade ReasonTitleBox;
	  @FindBy(xpath=".//div[contains(@class,'dialog-content vf-check-retention')]")
	  WebElementFacade ReasonMsg; 
	  @FindBy(xpath=".//*[contains(text(),'Reason')]//following::div[6]//button[contains(@class,'ui-button-text-only')]")
	  WebElementFacade ReasonOkButton;
	
	@FindBy(xpath=".//*[text()='Terminations']/ancestor::div[contains(@class,'activities-heading')]/preceding-sibling::div[contains(@class,'-type')]//a")
	WebElementFacade DisconnectionRowId;
	
	@FindBy(xpath=".//*[text()='Include']")
	WebElementFacade IncludeButton;
	
	@FindBy(xpath=".//*[text()='Ok']")
	WebElementFacade FutureDiscPopUpOkButton;	
	
	@FindBy(xpath=".//*[contains(text(),'future disconnection')]")
	WebElementFacade FutureDiscPopUp;
	
	@FindBy(xpath=".//*[@value='Future disconnection (raise service request)']")
	WebElementFacade FutureDisconnection;

	@FindBy(xpath="//*[text()='Account Summary']")
	WebElementFacade AccountSummaryTab;
	@FindBy(xpath=".//*[contains(@aria-label,'Include inactive')]")
	WebElementFacade IncludeInactiveButton;
	@FindBy(xpath=".//*[contains(@aria-label,'Exclude inactive')]")
	WebElementFacade ExcludeInactiveButton;

	@FindBy(xpath=".//*[@id='vf-viewall-btn']")
	WebElementFacade ViewAllButton;		
	@FindBy(xpath=".//*[@id='vf-showmre-btn']")
	WebElementFacade ShowMoreButton;

	@FindBy(xpath=".//*[@aria-labelledby='Credit_Limit_Label']")
	WebElementFacade CreditLimitTextBox;
	@FindBy(xpath=".//*[@aria-label='Credit Limit Management:Set Credit Limit']")
	WebElementFacade CreditLimitSetLimitButton;
	@FindBy(xpath=".//*[@aria-label='Credit Limit Management:Close']")
	WebElementFacade CreditLimitCloseButton;

	@FindBy(xpath="(.//*[@class='siebui-icon-dropdown applet-form-combo applet-list-combo'])[4]")
	WebElementFacade SearchByDropDown;

	@FindBy(xpath="(.//*[@aria-labelledby='QueryComboBox_Label'])[1]")
	WebElementFacade SearchByTextBox;

	@FindBy(xpath="(.//*[@aria-labelledby='QuerySrchSpec_Label'])[1]")
	WebElementFacade StartingWithTextBox;

	@FindBy(xpath="(.//*[@class='icon icon-search'])[1]")
	WebElementFacade SearchButton;

	//@FindBy(xpath=".//li[@rn='VF OUI Upgrade']")
	@FindBy(xpath=".//li[contains(@data-caption,'Upgrade') and @aria-disabled= 'false']")
	WebElementFacade Upgrade;
	
	@FindBy(xpath=".//li[@rn='VF OUI Edit package']")
	WebElementFacade EditPackage;

	@FindBy(xpath=".//li[@data-caption='Top up request /eSwipe']")
	WebElementFacade Topup;
	@FindBy(xpath=".//li[@data-caption='SIM activities']")
	WebElementFacade SIMActivities;

	@FindBy(xpath=".//*[contains(@placeholder,'Scan or type SIM number')]")
	WebElementFacade SIMNumber;
	@FindBy(xpath=".//*[contains(@class,'vf-oui-confirm-cncl')]")
	WebElementFacade SIMActivitiesCancelButton;
	@FindBy(xpath=".//*[@class='vfoui-button-width-192 ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	WebElementFacade SIMActivateOkButton;
	@FindBy(xpath=".//*[@for='activityType1']")
	WebElementFacade ActivateSim;

	@FindBy(xpath="//*[text()='Supply & Activate SIM']")
	WebElementFacade SupplyActivateSim;
	@FindBy(xpath=".//*[@for='activityType0']")
	WebElementFacade DispatchSIM;

	@FindBy(xpath=".//*[contains(@title,'Asset:ESwipe')]")
	WebElementFacade TopupPage;
	
	@FindBy(xpath=".//li[@data-caption='Exchange - Non like for like']")
	WebElementFacade ExchangeNonLikeforLike;
	
	@FindBy(xpath="(.//*[contains(text(),'Return/Exchange')])")
	WebElementFacade ReturnExchangeOutsidePolicy;
	
	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade ExchangePolicyOkButton;


	@FindBy(xpath=".//*[contains(text(),'Household discount')]/ancestor::div[contains(@id,'showAlert')]/following-sibling::div//button")
	WebElementFacade HouseholdDiscountOkButton;
			
	@FindBy(xpath=".//span[text()='Loyalty offer']/parent::div/following-sibling::div[2]//button/span[text()='Ok']")
	WebElementFacade LoyaltyOfferOkButton;
	
	@FindBy(xpath=".//*[contains(text(),'unblacklisting')]/ancestor::div[contains(@id,'showAlert')]/following-sibling::div//button")
	WebElementFacade UnblacklistPopupOkButton;
	
	@FindBy(xpath=".//*[contains(text(),'Fraud risk - please read')]")
	WebElementFacade FraudRiskTitleBox;  
	/*@FindBy(xpath=".//div[contains(@class,'popup-info')]")
		WebElementFacade ErrorMsg; */
	@FindBy(xpath=".//label[@for='checkbox_fraud_id']")
	WebElementFacade FraudCheckbox;
	@FindBy(xpath="(.//button[contains(@class,'ui-button-text-only')]/span[text()='Confirm'])")
	WebElementFacade FraudRiskOKbutton;

	@FindBy(xpath="(.//button[contains(@class,'siebui-ctrl-btn siebui-icon-gridtoggle')][contains(@title,':Grid')])[1]")
	WebElementFacade GridViewButton;

	@FindBy(xpath=".//*[contains(text(),'Before you continue')]/parent::div/following-sibling::div[2]//button")
	WebElementFacade WarningOKButton;
	@FindBy(xpath=".//button[text()='Proceed']")
	WebElementFacade ProceedButton; 
	@FindBy(xpath=".//*[@class='siebui-ctrl-btn appletButton'][contains(text(),'Cancel')]")
	WebElementFacade CancelButton; 

	@FindBy(xpath=".//a[@name='Billing profile']")
	WebElementFacade BillingProfileLink;

	@FindBy(xpath=".//a[text()='Real Time Balance']")
	WebElementFacade RealTimeBalanceTab;

	@FindBy(xpath=".//li[@data-caption='Modify payer and/or user account']")
	WebElementFacade ModifyPayerUser;
	
	@FindBy(xpath=".//li[@data-caption='IMEI history/(Un)Blacklist']")
	WebElementFacade IMEIhistory;
	@FindBy(xpath=".//*[@aria-label='IMEI:Blacklist']")
	WebElementFacade IMEIBlacklistButton;
	@FindBy(xpath=".//*[contains(text(),'Stolen bar')]")
	WebElementFacade BlacklistPopup;
	@FindBy(xpath=".//*[contains(@class,'ui-dialog-titlebar')]/following-sibling::div[contains(@class,'ui-dialog-content')]/div[2]/div")
	WebElementFacade BlacklistPopupMessage;
	@FindBy(xpath=".//button[contains(@class,'ui-button ui-widget')]/span[contains(text(),'Ok')]")
	WebElementFacade BlacklistPopupOKButton;
	
	@FindBy(xpath=".//li[@data-caption='Change plan']")
	WebElementFacade ChangePlan;
	@FindBy(xpath=".//*[contains(text(),'Pending orders')]")
	WebElementFacade PendingOrderPopUp;
	@FindBy(xpath=".//*[contains(@id,'confirm-dialog')]/div[2]/div[1]")
	WebElementFacade PopupMessage;
	@FindBy(xpath=".//*[contains(text(),'Pending orders')]/parent::div/following-sibling::div[2]//span[contains(text(),'Ok')]")
	WebElementFacade PendingOrderPopUpOKButton;
	@FindBy(xpath=".//a[text()='Modify payer and/or user account']")
	WebElementFacade ServiceHierarchyChange;
	
	@FindBy(xpath=".//*[@data-display='New payer']")
	WebElementFacade NewPayerButton;
	
	@FindBy(xpath=".//*[contains(text(),'Account name:')]")
	WebElementFacade AccountName;
		
	@FindBy(xpath=".//*[contains(text(),'Error message')]")
	WebElementFacade InsufficientFundErrorTitleBox;  
	@FindBy(xpath=".//*[contains(text(),'Insufficient permission')]")
	WebElementFacade InsufficientFundErrorMsg; 
	@FindBy(xpath=".//span[text()='Error message']/parent::div/following-sibling::div[2]//button/span[text()='Ok']")
	WebElementFacade InsufficientFundErrorOkButton;
	@FindBy(xpath=".//li[@data-caption='Port in/Change number']")
	WebElementFacade PortIn;
	@FindBy(xpath=".//*[@title='Blacklist history:Get blacklist history']")
	WebElementFacade GetBlackListHistory;
	@FindBy(xpath=".//*[@aria-label='Blacklist history:Unblacklist']")
	WebElementFacade UnblackListButton;
	@FindBy(xpath=".//*[contains(text(),'device was blacklisted')]/ancestor::div[contains(@id,'showAlert')]/following-sibling::div//button")
	WebElementFacade ContactInsuranceOkButton;
	@FindBy(xpath=".//*[contains(text(),'number change fee check the checkbox before you hit')]")
	WebElementFacade NumberChangePopup; 
	@FindBy(xpath=".//*[text()='Ok']")
	WebElementFacade NumberChangePopupOKButton;
	@FindBy(xpath=".//*[contains(text(),'port in or change number')]")
	WebElementFacade GenerateNewNumNotClickedPopup;	
	@FindBy(xpath=".//*[text()='Ok']")
	WebElementFacade GenerateNewNumNotClickedPopupOKButton;	
	@FindBy(xpath="(.//*[text()='Generate new number'])[1]")
	WebElementFacade GenerateNewNumberButton;
	@FindBy(xpath=".//*[@aria-label='Pick Resource:OK']")
	WebElementFacade GenerateNewNumberButtonOKButton;	
	//@FindBy(xpath=".//*[text()='Add administration fee']")
	@FindBy(xpath=".//*[@id='checkbox_adminfee_id']")
	WebElementFacade AddAdminFeeChckBox;
	@FindBy(xpath="(.//*[@aria-label='Basket:Next'])")
	 WebElementFacade NextButtoninConfigureOrder;
	/*@FindBy(xpath=".//*[contains(text(),'service currently has a pending')]")
	WebElementFacade PendingOrderMessagebox;
	
	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade PendingOrderMessageboxOKButton;*/
	@FindBy(xpath=".//*[@class='siebui-appletmenu ui-menu ui-widget ui-widget-content']/descendant::li[@data-caption='Exchange - Non like for like']")
	 WebElementFacade ExchangeNLFL;
	@FindBy(xpath=".//*[@aria-labelledby='s_16_l_Name']")
	WebElementFacade HandsetPresentForNLFL;
	@FindBy(xpath=".//*[@aria-label='Device list:Ok']")
	WebElementFacade ChooseHandsetOkButton;
	@FindBy(xpath=".//*[@class='nlfl_pcg_data cat_move_to_sim_only vfoui_icon_nlfl pcg_inactive']")
	WebElementFacade MoveToSimOnly;
	
	@FindBy(xpath=".//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons vfoui_box_shadow']/descendant::div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/descendant::div[@class='ui-dialog-buttonset']/button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	WebElementFacade ReturnPloicyOkButton;
	@FindBy(xpath=".//*[@title='Basket:Next' and @class='siebui-ctrl-btn siebui-icon-proceedwithproceed s_10_1_8_0 appletButton']")
	WebElementFacade ProductAndServicesNext;

	@FindBy(xpath=".//li[@data-caption='Return']")
	WebElementFacade Return; 
	
	@FindBy(xpath=".//*[contains(text(),'does not have a high enough level of permission')]")
	WebElementFacade InsufficientLevelPopup;
	
	@FindBy(xpath="(.//*[text()='Ok'])[2]")
	WebElementFacade InsufficientLevelPopupOkButton;
	
	@FindBy(xpath="//div[text()='Owned line items']/parent::div/following-sibling::div//span[contains(@class,'menu')]") 
	WebElementFacade SelecLineItemActionListButton;
	
	@FindBy(xpath=".//li[@data-caption='Exchange - Like for like']")
	WebElementFacade ExchangeLikeforLike;
	
	@FindBy(xpath=".//*[contains(text(),'service has an open return/exchange')]")
	WebElementFacade LFLErrorMessagePopup;
	
	@FindBy(xpath=".//span[text()='Damaged return charge']/parent::div/following-sibling::div[contains(@class,'ui-dialog-buttonpane')]//span[text()='Ok']")
	WebElementFacade DamagedReturnChargeOkButton;
	
	@FindBy(xpath=".//*[@aria-label='Return reason']")
	WebElementFacade ReturnReasonTextBox;
	
	
	
	@Step
	public void OwnedBilledLineItems(String LogicalName) throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_Enh.xls";
		String dataSheet = "OwnedLineItems";
		String applet = "";
		String table = "";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      				
			String Index = tableMap.get("Index").get(i);				
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);	
			String sView = tableMap.get("View").get(i);	
			String sAction = tableMap.get("Action").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			String sCheckLineItems = tableMap.get("CheckLineItems").get(i);
			String PopUp = tableMap.get("PopUp").get(i);
			if (sLocateColValue.contains("Promotion")){
				sLocateColValue = sLocateColValue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());

			} 

			if (sLocateColValue.contains("RootProduct0")){
				sLocateColValue = sLocateColValue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}
			if (sLocateColValue.contains("ACCNTMSISDN")){
				sLocateColValue = sLocateColValue.replace("ACCNTMSISDN", Serenity.sessionVariableCalled("ACCNTMSISDN").toString());    	  

			}
			if (svalue.contains("RootProduct0")){
				svalue = svalue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}
			if (svalue.contains("ACCNTMSISDN")){
				svalue = svalue.replace("ACCNTMSISDN", Serenity.sessionVariableCalled("ACCNTMSISDN").toString());    	  
			}			
			if (svalue.contains("Promotion")){
				svalue = svalue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());

			}

			Thread.sleep(3000);
			Common.WaitForClock(ClockObj);

			if(sView.equalsIgnoreCase("Owned")){
				OwnedButton.click();
				Common.WaitForClock(ClockObj);
				applet = "//*[contains(@title,'Owned products & services List Applet')]";
				table = "//table[@summary='Owned products & services']";
				report.Info("Owned view");
				if(sCheckLineItems.equalsIgnoreCase("Yes"))
				{
					applet = "//*[contains(@title,'Owned line items List Applet')]";
					table = "//table[@summary='Owned line items']";
					report.Info("Owned Line Items View");
				}

				if (sAction.equals("ExchangeLikeforLike")) {
					Thread.sleep(2000);
				     ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", SelecLineItemActionListButton); 
					SelecLineItemActionListButton.waitUntilClickable();
					SelecLineItemActionListButton.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(1000);
					ExchangeLikeforLike.click();
					report.Info("ExchangeLikeforLike is selected from Owned Line Items window");
					Thread.sleep(2000);
				}
				if (PendingOrderPopUpOKButton.isCurrentlyVisible()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					PendingOrderPopUpOKButton.waitUntilClickable();  
					PendingOrderPopUpOKButton.click();  
					Thread.sleep(2000);
				}

				if(DamagedReturnChargeOkButton.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					DamagedReturnChargeOkButton.click();
					Thread.sleep(2000);
				}
			  if (ReturnReasonTextBox.isVisible()){
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  Thread.sleep(1000);
				  ReturnReasonTextBox.sendKeys("Damaged in Transit");
				  report.Info("Damaged in Transit is selected from Owned product & services window");
				  Thread.sleep(2000);
				}
			}
		}
	}

	@Step
	public void OwnedBilledUsedProductServices(String LogicalName) throws InterruptedException, IOException, AWTException{
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_Enh.xls";
		String dataSheet = "OwnedProductServicesLineItems";
		String applet = "";
		String table = "";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      				
			String Index = tableMap.get("Index").get(i);				
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);	
			String sView = tableMap.get("View").get(i);	
			String sAction = tableMap.get("Action").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			String sCheckLineItems = tableMap.get("CheckLineItems").get(i);
			String PopUp = tableMap.get("PopUp").get(i);
			if (sLocateColValue.contains("Promotion")){
				sLocateColValue = sLocateColValue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());

			} 

			if (sLocateColValue.contains("RootProduct0")){
				sLocateColValue = sLocateColValue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}
			if (sLocateColValue.contains("ACCNTMSISDN")){
				sLocateColValue = sLocateColValue.replace("ACCNTMSISDN", Serenity.sessionVariableCalled("ACCNTMSISDN").toString());    	  

			}
			if (svalue.contains("RootProduct0")){
				svalue = svalue.replace("RootProduct0", Serenity.sessionVariableCalled("RootProduct0").toString());    	  
			}
			if (svalue.contains("ACCNTMSISDN")){
				svalue = svalue.replace("ACCNTMSISDN", Serenity.sessionVariableCalled("ACCNTMSISDN").toString());    	  
			}			
			if (svalue.contains("Promotion")){
				svalue = svalue.replace("Promotion", Serenity.sessionVariableCalled("ProductName").toString());

			}

			Thread.sleep(3000);
			Common.WaitForClock(ClockObj);

			if(sView.equalsIgnoreCase("Owned")){
				
				int	AllOwnedTabLink = findAll(By.xpath("//div[contains(@id,'_owned') and contains(text(),'Owned')]")).size();
				for(int j=1;j<=AllOwnedTabLink;j++){
					if(findBy("(//div[contains(@id,'_owned') and contains(text(),'Owned')])["+j+"]").isCurrentlyVisible()) {
						findBy("(//div[contains(@id,'_owned') and contains(text(),'Owned')])["+j+"]").click();
						report.Info("Owned Tab Clicked");
						break;
					}
				}			
				
				//OwnedButton.click();
				Common.WaitForClock(ClockObj);
				applet = "//*[contains(@title,'Owned products & services List Applet')]";
				table = "//table[@summary='Owned products & services']";
				report.Info("Owned view");
				if(sCheckLineItems.equalsIgnoreCase("Yes"))
				{
					applet = "//*[contains(@title,'Owned line items List Applet')]";
					table = "//table[@summary='Owned line items']";
					report.Info("Owned Line Items View");
				}
			}
			else if(sView.equalsIgnoreCase("Billed")){
				BilledButton.click();
				Common.WaitForClock(ClockObj);
				applet = "//*[contains(@title,'Billed products & services List Applet')]";
				table = "//table[@summary='Billed products & services']";
				report.Info("Billed View");
				if(sCheckLineItems.equalsIgnoreCase("Yes"))
				{
					applet = "//*[contains(@title,'Billed line items List Applet')]";
					table = "//table[@summary='Billed line items']";
					report.Info("Billed line items");
				}

			}
			else if(sView.equalsIgnoreCase("Used")){
				UsedButton.click();
				Common.WaitForClock(ClockObj);
				applet = "//*[contains(@title,'Used products & services List Applet')]";
				table = "//table[@summary='Used products & services']";
				report.Info("Used View");
				if(sCheckLineItems.equalsIgnoreCase("Yes"))
				{
					applet = "//*[contains(@title,'Used line items List Applet')]";
					table = "//table[@summary='Used line items']";
					report.Info("Used Line Items View");
				}

			}
			else if(sView.equalsIgnoreCase("BlackListHistory")) {
				applet = "//*[contains(@title,'Blacklist history List Applet')]";
				table = "//table[@summary='Blacklist history']";
				report.Info("BlackListHistory View");
			}
			if (sAction.equals("ValidateCorrectBillingProfle")){
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				BillingProfileLink.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				RealTimeBalanceTab.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				applet = "//*[contains(@title,'Product / Services List Applet')]";
				table = "//table[@summary='Product / Services']";
				report.Info("Billing Profile Drill Down View");
			}


			if (Index.equals("")){
				Index = "0";
			}      															

			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
			}
			else{               
				Common.selectedRow = 1;
			}

			if (!sUIName.equals("")){ 
				CommonEnh.updateSiebList(applet,table, sUIName, svalue); 
				report.Info("Row updated successfully"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}

			if (sAction.equals("PerformAdditionalAction")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

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

			if (sAction.equals("IncludeInactive")){	
				Common.WaitForClock(ClockObj);
				if(IncludeInactiveButton.isVisible()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					IncludeInactiveButton.click();
					Common.WaitForClock(ClockObj);
					report.Info("Include Inactive button is present as expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());						
				}
				else{
					report.Info("Include Inactive button is not present as expected");
					Assert.assertTrue(false);
					return;
				}
			}

			Common.WaitForClock(ClockObj);					
			if(sAction.equals("ClickViewallButton")) {
				if (ViewAllButton.isCurrentlyVisible()) {
					ViewAllButton.click();
					Thread.sleep(1000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());						
					report.Info("View all lbutton clicked successfully");	
				}
				else{
					report.Info("View all button is not present");
					Assert.assertTrue(false);
					return;
				}
			}

			if(sAction.equals("ClickShowMoreButton")) {
				if (ViewAllButton.isCurrentlyVisible()) {
					ShowMoreButton.isCurrentlyVisible();
					ShowMoreButton.click();	
					Thread.sleep(1000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());						
					report.Info("Show More Button button clicked successfully");	
				}
				else{
					report.Info("Show More  button is not present");
					Assert.assertTrue(false);
					return;
				}
			}


			if (sAction.equals("ExcludeInactive")){	
				Common.WaitForClock(ClockObj);

				if(ExcludeInactiveButton.isVisible()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ExcludeInactiveButton.click();
					Common.WaitForClock(ClockObj);
					report.Info("Excelude Inactive button is present as expected");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());						
				}
				else{
					report.Info("Excelude Inactive button is not present as expected");
					Assert.assertTrue(false);
					return;
				}
			}

			if (sAction.equals("CheckCreditLimit")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				///find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				CreditLimit.click();
				report.Info("Check CreditLimit is selected from  product & services window");
				Thread.sleep(10000);

				Common.WaitForClock(ClockObj);

				if(sValidation.equals("Yes")){
					if (CreditLimitSetLimitButton.isCurrentlyVisible()){
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("CreditLimit page is displayed after selecting Check CreditLimit from Owned product services window");    		   

						String Creditvalue = CreditLimitTextBox.getTextValue();
						Assert.assertTrue("Fail, Credit Limit value is not same as" +svalue+ " It is "+Creditvalue,Creditvalue.equals(svalue));
						report.Info("Check CreditLimit matches");

						CreditLimitCloseButton.click();
						Thread.sleep(2000);
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

						if(!svalue.equals("") ){
							CreditLimitTextBox.type(svalue);
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							CreditLimitSetLimitButton.click();
							Thread.sleep(30000);
							Common.WaitForClock(ClockObj);

						}
						if (CreditLimitCloseButton.isCurrentlyVisible()){
							CreditLimitCloseButton.click();
							Thread.sleep(2000);
						}

						Thread.sleep(2000);
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
				///find(By.xpath(sSelectActionListButton)).click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				SIMActivities.click();
				report.Info("SIM Activities is selected from Owned product & services window");
				Thread.sleep(2000);
				
				if (InsufficientFundErrorTitleBox.isCurrentlyVisible()){
					String ErrorInfo= InsufficientFundErrorMsg.getText();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());						
						Thread.sleep(1000);
						report.Info("The alert meassage is:"+ErrorInfo);
						return;
				}
				if(sValidation.equals("SimActivate"))
				{
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ActivateSim.click();
					Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(4000);
					String sICCID = Serenity.sessionVariableCalled("ICCID").toString();
					SIMNumber.sendKeys(sICCID);
					Thread.sleep(4000);
					SIMActivateOkButton.click();
					break;
				}
				if(sValidation.equals("SIMDispatch"))
				{
				
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					DispatchSIM.isPresent();
					Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(4000);
					String sICCID = Serenity.sessionVariableCalled("ICCID").toString();
					Thread.sleep(4000);
					SIMActivateOkButton.click();
					break;
				}
				if(sValidation.equals("SimSupplyActivate"))
				{
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					SupplyActivateSim.click();
					Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(2000);
					String sICCID = Serenity.sessionVariableCalled("ICCID").toString();
					SIMNumber.sendKeys(sICCID);
					Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					SIMActivateOkButton.click();
					break;
				}
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
			
			if (sAction.equals("ExchangeNonLikeforLike")||(sAction.equals("ExchangeLikeforLike"))) {
				  Thread.sleep(2000);
				  SelectActionListButton.waitUntilClickable();
				  SelectActionListButton.click();
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(1000);
					if(sAction.equals("ExchangeNonLikeforLike")) {
					ExchangeNonLikeforLike.click();
					report.Info("ExchangeNonLikeforLike is selected from Owned product & services window");
					Thread.sleep(2000);
					if(HandsetPresentForNLFL.isCurrentlyVisible())
					{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						ChooseHandsetOkButton.click();
					  Thread.sleep(1000);
					}
					if(ReturnExchangeOutsidePolicy.isCurrentlyVisible()) {
						  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						  ExchangePolicyOkButton.click();
						  Thread.sleep(1000);
						  Common.WaitForClock(ClockObj);
							
					}
					}
					else
						if(sAction.equals("ExchangeLikeforLike"))
					{
						Thread.sleep(1000);
						ExchangeLikeforLike.click();
						report.Info("ExchangeLikeforLike is selected from Owned product & services window");
						Thread.sleep(2000);
						if(sValidation.equalsIgnoreCase("ErroMsgPopUp"))
						  {
							  Assert.assertTrue("FAIL, Return Error message is not visible as expected", LFLErrorMessagePopup.isCurrentlyVisible());
							  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							  report.Info("LFL Error Message Popup message is displayed as expected");	
						  }
					}
					
			}

			if (sAction.equals("ModifyUserPayer")){															  
				Thread.sleep(2000);
				String sAccountName = AccountName.getTextValue();
				String[] arr1 = sAccountName.split("\\:");
				sAccountName= arr1[1].trim();
				Serenity.setSessionVariable("AccountName").to(sAccountName);	
				
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				ModifyPayerUser.click();
				report.Info("'Modify payer and/or user account' is selected from Owned product & services window");
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				if(sValidation.equals("Pending")){
					if (PendingOrderPopUp.isCurrentlyVisible()){
						String ErrorInfo= PopupMessage.getText();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						
						report.Info("The alert meassage is:"+ErrorInfo);
						PendingOrderPopUpOKButton.waitUntilClickable();  
						PendingOrderPopUpOKButton.click();  
						
					}
					else{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("PendingOrderPopUp did not occur");
						 Assert.assertTrue(false);              
					}
				}
				
				if(sValidation.equals("InsufficientFund")){
					if (InsufficientFundErrorTitleBox.isCurrentlyVisible()){
						String ErrorInfo= InsufficientFundErrorMsg.getText();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

						InsufficientFundErrorOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						InsufficientFundErrorOkButton.click(); 
						report.Info("The alert meassage is:"+ErrorInfo);
						return;
					}
					else{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("InsufficientFundPopUp did not occur");
						Assert.assertTrue(false);              
					}

				}
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				Assert.assertTrue("About the customer page is not displayed after selecting Modify payer and/or user account Actions from Owned proodcut services window",NewPayerButton.isDisplayed());
				report.Info("About the customer page is displayed after selecting Modify payer and/or user account Actions from Owned proodcut services window");    		   
				
			}
			
			
			if (sValidation.equals("ValidateModifyUserPayer")){														  
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Modify payer and/or user account' option is not present for Owned view",ModifyPayerUser.isCurrentlyVisible());
				report.Info("The 'Modify payer and/or user account' option is present for Owned view");
				
				BilledButton.click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Modify payer and/or user account' option is present for Billed view",!ModifyPayerUser.isCurrentlyVisible());
				report.Info("The 'Modify payer and/or user account' option is not present for Billed view");
				
				UsedButton.click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Modify payer and/or user account' option is present for Used view",!ModifyPayerUser.isCurrentlyVisible());
				report.Info("The 'Modify payer and/or user account' option is not present for Used view");
				
			}
			
			if (sValidation.equals("ValidateDisconnectionInViews")){														  
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Disconnection/ Fee Calculator' option is not present for Owned view",DisconnectionFeeCalculator.isCurrentlyVisible());
				report.Info("The 'Disconnection/ Fee Calculator' option is present for Owned view");
				
				BilledButton.click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Disconnection/ Fee Calculator' option is present for Billed view",!DisconnectionFeeCalculator.isCurrentlyVisible());
				report.Info("The 'Disconnection/ Fee Calculator' option is not present for Billed view");
				
				UsedButton.click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'Disconnection/ Fee Calculator' option is present for Used view",!DisconnectionFeeCalculator.isCurrentlyVisible());
				report.Info("The 'Disconnection/ Fee Calculator' option is not present for Used view");
				
			}
			
			if (sValidation.equals("ValidateSIMActivities")){														  
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'SIM Activities' option is not present for Owned view",SIMActivities.isCurrentlyVisible());
				report.Info("The 'SIM Activities' option is present for Owned view");
				
				BilledButton.click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'SIM Activities' option is present for Billed view",!SIMActivities.isCurrentlyVisible());
				report.Info("The 'SIM Activities' option is not present for Billed view");
				
				UsedButton.click();
				Common.WaitForClock(ClockObj);
				Thread.sleep(2000);
				SelectActionListButton.click();
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				Assert.assertTrue("The 'SIM Activities' option is present for Used view",!SIMActivities.isCurrentlyVisible());
				report.Info("The 'SIM Activities' option is not present for Used view");
				
			}
			
			if (sAction.equals("Topup")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				//find(By.xpath(sSelectActionListButton)).click();
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
					return;
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
				Thread.sleep(5000);
				Common.WaitForClock(ClockObj);
				
				if (WarningOKButton.isCurrentlyVisible()){
					WarningOKButton.waitUntilClickable();  
					WarningOKButton.click(); 
					Common.WaitForClock(ClockObj);
				}
				if (ProceedButton.isCurrentlyVisible()){
					ProceedButton.waitUntilClickable();
					ProceedButton.click();               
				}
				Thread.sleep(5000);
				Common.WaitForClock(ClockObj);
				
				if(sValidation.equals("Yes")){					
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					CancelButton.click();
					Thread.sleep(5000);
					Common.WaitForClock(ClockObj);
				}
			}
			
			if (sAction.equals("Return")){															  
				  Thread.sleep(2000);
				  SelectActionListButton.click();
				  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  Thread.sleep(1000);
				  Return.click(); 
				  Thread.sleep(2000);				  
				  Common.WaitForClock(ClockObj);
				  if(sValidation.equalsIgnoreCase("InsufficiantlevelPopupValidation"))
					{
						if (InsufficientLevelPopup.isCurrentlyVisible()){
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							InsufficientLevelPopupOkButton.waitUntilClickable();  
							InsufficientLevelPopupOkButton.click();    
							Common.WaitForClock(ClockObj);
							report.Info("Insufficient Permission popup came as expected");
							return;
						}
					}
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
			}
				
				if(sAction.contains("ImmediateDisconnection")){
					ImmediateDisconnection.click();
					Thread.sleep(2000);
					DisconnectNextButton.click();
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);
				}
				if(sValidation.contains("FutureDisconnection")){
					FutureDisconnection.click();
					Thread.sleep(2000);
					DisconnectNextButton.click();
					Thread.sleep(2000);
					Common.WaitForClock(ClockObj);
					
					if(FutureDiscPopUp.isCurrentlyVisible())
					{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						FutureDiscPopUpOkButton.click();    
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
				}
				
				if(IncludeButton.isCurrentlyVisible())
				{
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					IncludeButton.click();    
					Common.WaitForClock(ClockObj);
				}
				if(sCheckLineItems.equalsIgnoreCase("GoToAccount"))
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

			if (sAction.equals("Upgrade")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
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
			if (sAction.equals("Edit package")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				EditPackage.click();
				report.Info("Edit Package is selected from Owned product & services window");
				Thread.sleep(2000);
				Common.WaitForClock(ClockObj);
				if(sValidation.equals("Pending")){
					if (PendingOrderPopUp.isCurrentlyVisible()){
						String ErrorInfo= PopupMessage.getText();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						
						report.Info("The alert meassage is:"+ErrorInfo);
						PendingOrderPopUpOKButton.waitUntilClickable();  
						PendingOrderPopUpOKButton.click();  
						
					}
					else{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("PendingOrderPopUp did not occur");
						 Assert.assertTrue(false);              
					}
				}

			}
			if (sAction.equals("ServiceHierarchyChange")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				ServiceHierarchyChange.click();
				report.Info("Modify payer and/or user account is selected from Owned product & services window");
				Thread.sleep(5000);
				if(sValidation.equals("Yes")){
					Assert.assertTrue("FAIL, New Payer Button is Enabled", !NewPayerButton.isCurrentlyEnabled());
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
			}
			Alert alert;
			String ActAlertText="";
			if (sAction.equals("ChangePlan")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				ChangePlan.click();
				report.Info("ChangePlan is selected from Owned product & services window");
				Thread.sleep(2000);

				Common.WaitForClock(ClockObj);
				if(isAlertPresent(getDriver())&& (!PopUp.equalsIgnoreCase("No"))){
					alert=getDriver().switchTo().alert();
					ActAlertText=alert.getText();  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					if (PopUp.contains("OPTIONAL:")){
						PopUp= PopUp.substring(9);
					}	                                                                              	
					if (ActAlertText.contains(PopUp)){                		
						alert.accept();
						report.Info("alert messsage is"+ActAlertText);
					}                        
				}
				if(sValidation.equals("Pending")){
					if (PendingOrderPopUp.isCurrentlyVisible()){
						String ErrorInfo= PopupMessage.getText();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						
						PendingOrderPopUpOKButton.waitUntilClickable();  
						PendingOrderPopUpOKButton.click();  

						report.Info("The alert meassage is:"+ErrorInfo);
						return;
					}
					else{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("PendingOrderPopUp did not occur");
						 Assert.assertTrue(false);              
					}
				
				Common.waitForElement(PromotionSearchTextBoxWebElement);
				PromotionSearchTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				}
				
			}
			
			if (sAction.equals("ExchangeLFLPendingOrder")){
				if (PendingOrder.isCurrentlyVisible())
				{
				PendingOrder.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				}
				else
				{
					//report.Info("No Pending order is placed to perform the action");
					CompleteOrder.click();
					SelectAction.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(1000);
					ExchangeLFL.click();
					report.Info("Exchange LFL has been selected");
					Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				}
			}

			if (sAction.equals("ExchangeLFL")){
				if (PendingOrder.isCurrentlyVisible())
				{
				CompleteOrder.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(ClockObj);
				
				SelectAction.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				ExchangeLFL.click();
				report.Info("Exchange LFL has been selected");
				Thread.sleep(2000);
				
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				
				
				if(sValidation.equals("Pending")){
					if (PendingOrderPopUp.isCurrentlyVisible()){
						String ErrorInfo= PopupMessage.getText();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						
						report.Info("The alert meassage is:"+ErrorInfo);
						PendingOrderPopUpOKButton.waitUntilClickable();  
						PendingOrderPopUpOKButton.click();  
						return;
					}
					else{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("PendingOrderPopUp did not occur");
						 Assert.assertTrue(false);              
					}
				}
					}
				else {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 report.Info("No Pending order is placed to perform the action");
					 Assert.assertTrue(false);
					}
			}
              /*  if (sAction.equals("ExchangeNLFL")){
				
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				ExchangeNLFL.click();
				report.Info("ExchangeNLFL is selected from Owned product & services window");
				Thread.sleep(2000);
				HnadsetPresentForNLFL.isCurrentlyVisible();
				ChooseHandsetOkButton.click();
				if(ReturnPloicyOkButton.isCurrentlyVisible())
				{
					ReturnPloicyOkButton.click();
				}
				Thread.sleep(4000);
				Common.WaitForClock(ClockObj);
				MoveToSimOnly.click();
				Common.WaitForClock(ClockObj);
                //Common.WaitForObjectPresence(".//*[@title='Basket:Next' and @class='siebui-ctrl-btn siebui-icon-proceedwithproceed s_10_1_8_0 appletButton']");		
		      // ProductAndServicesNext.click();
		       
			  }*/
			
			
			if (sAction.equals("IMEI history/(Un)Blacklist")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				IMEIhistory.click();
				report.Info("IMEIhistory is selected from Owned product & services window");
				Thread.sleep(2000);
				if(sValidation.equals("CheckBlackListHistory")){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(1000);
					GetBlackListHistory.click();
					break;
				}
				Common.WaitForClock(ClockObj);
				IMEIBlacklistButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				
				if (IMEIBlacklistButton.isCurrentlyVisible()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					IMEIBlacklistButton.click();
					report.Info("IMEIBlacklistButton is clicked");
					
					Common.WaitForClock(ClockObj);
					
					if(BlacklistPopup.isCurrentlyVisible()){
						 String ErrorInfo= BlacklistPopupMessage.getText();  

						 if(ErrorInfo.contains("blacklisting a device")){	
							 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							 BlacklistPopupOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable(); 
							 BlacklistPopupOKButton.click();
							 report.Info("The alert meassage is:"+ErrorInfo);
						 }
						 else{
							 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							 report.Info("BlacklistPopup did not occur");
							 Assert.assertTrue(false);   
						 }
						 Common.WaitForClock(ClockObj);
				}
					
			    }
			}
			if(sCheckLineItems.equalsIgnoreCase("UnblackList"))
			{
				UnblackListButton.click();
				if(ContactInsuranceOkButton.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					ContactInsuranceOkButton.click();
				}
				
				if(UnblacklistPopupOkButton.isCurrentlyVisible()) {
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					UnblacklistPopupOkButton.click();
				}
				if(PopUp.equalsIgnoreCase("SRRaiseFRSPopup")) {
					Common.WaitForClock(ClockObj);
					 Assert.assertTrue("FAIL: The FRS raise SR popup didnt occur for non FRS login",SRRaisePopupOkButton.isVisible()); 
					 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 SRRaisePopupOkButton.click();
					 Common.WaitForClock(ClockObj);
					 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 Assert.assertTrue("FAIL: Service Request applet didnt occur",SRApplet.isVisible());
				}
			}
			if (sAction.equals("Port in/Change number")){															  
				Thread.sleep(2000);
				SelectActionListButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(1000);
				PortIn.click();
				report.Info("PortIn is selected from Owned product & services window");
				Thread.sleep(2000);

				Common.WaitForClock(ClockObj);
				
				if(sValidation.equals("Pending")){
					if (PendingOrderPopUp.isCurrentlyVisible()){
						String ErrorInfo= PopupMessage.getText();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						
						report.Info("The alert meassage is:"+ErrorInfo);
						PendingOrderPopUpOKButton.waitUntilClickable();  
						PendingOrderPopUpOKButton.click();  
						return;
					}
					else{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("PendingOrderPopUp did not occur");
						 Assert.assertTrue(false);              
					}
				
				Common.waitForElement(PromotionSearchTextBoxWebElement);
				PromotionSearchTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				}
				if(sValidation.equals("PendingContinueJourney")){
					if (PendingOrderPopUp.isCurrentlyVisible()){
						String ErrorInfo= PopupMessage.getText();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						
						report.Info("The alert meassage is:"+ErrorInfo);
						PendingOrderPopUpOKButton.waitUntilClickable();  
						PendingOrderPopUpOKButton.click();  
						
					}
				}
				if(sValidation.equals("GenerateNewNumNotClick")){
					if (NextButtoninConfigureOrder.isCurrentlyVisible()){
						NextButtoninConfigureOrder.click();  
						Common.WaitForClock(ClockObj);
						Assert.assertTrue("Generate new number not clicked popup did not occur", GenerateNewNumNotClickedPopup.isCurrentlyVisible());
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						GenerateNewNumNotClickedPopupOKButton.click();
						Common.WaitForClock(ClockObj);
					}
				}
				
				if(GenerateNewNumberButton.isCurrentlyVisible()) {
					GenerateNewNumberButton.click();
					Common.WaitForClock(ClockObj);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					GenerateNewNumberButtonOKButton.click();
					Common.WaitForClock(ClockObj);
					
				}
				if (NextButtoninConfigureOrder.isCurrentlyVisible()){
					NextButtoninConfigureOrder.click();  
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.WaitForClock(ClockObj);
					if (NumberChangePopup.isCurrentlyVisible())
					{
						if(sValidation.equals("AddAdministrationFee")){
							if (AddAdminFeeChckBox.isCurrentlyVisible()){
								sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
								AddAdminFeeChckBox.click();  
								Common.WaitForClock(ClockObj);
								}
						}
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						NumberChangePopupOKButton.click();
						Common.WaitForClock(ClockObj);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						//NextButtoninConfigureOrder.click();
						Common.WaitForClock(ClockObj);
					}
				}
								
				if(sValidation.equals("InsufficientFund")){
					if (InsufficientFundErrorTitleBox.isCurrentlyVisible()){
						String ErrorInfo= InsufficientFundErrorMsg.getText();
							sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							
							Thread.sleep(1000);
							InsufficientFundErrorOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();  
							InsufficientFundErrorOkButton.click(); 
							report.Info("The alert meassage is:"+ErrorInfo);
							return;
					}
					else{
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 report.Info("InsufficientFundPopUp did not occur");
						 Assert.assertTrue(false);              
					}
				
				Common.waitForElement(PromotionSearchTextBoxWebElement);
				PromotionSearchTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				}
				
			}

			int GetRowCount = 0;

			if (sAction.equals("Service type")){
				Thread.sleep(5000);
				SearchByDropDown.click();
				SearchByTextBox.sendKeys(sAction);
				//SearchByDropDown.selectByVisibleText(sAction);
				Thread.sleep(5000);
				StartingWithTextBox.sendKeys(svalue);
				Thread.sleep(5000);
				SearchButton.click();
				Thread.sleep(2000);
				GetRowCount = findAll(By.xpath("//table[@summary='Owned products & services']/tbody/tr")).size();
				Assert.assertTrue("FAIL, No Result Displayed", GetRowCount > 0);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if (sAction.equals("Name")){
				Thread.sleep(2000);
				SearchByDropDown.click();
				Thread.sleep(5000);
				SearchByTextBox.sendKeys(sAction);
				Thread.sleep(5000);
				StartingWithTextBox.sendKeys(svalue);
				Thread.sleep(2000);
				SearchButton.click();
				Thread.sleep(2000);
				GetRowCount = findAll(By.xpath("//table[@summary='Owned products & services']/tbody/tr")).size();
				Assert.assertTrue("FAIL, No Result Displayed", GetRowCount > 0);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if (sAction.equals("Installed ID")){
				Thread.sleep(2000);
				SearchByDropDown.click();
				Thread.sleep(5000);
				SearchByTextBox.sendKeys(sAction);
				Thread.sleep(5000);
				StartingWithTextBox.sendKeys(svalue);
				Thread.sleep(2000);
				SearchButton.click();
				Thread.sleep(2000);
				GetRowCount = findAll(By.xpath("//table[@summary='Owned products & services']/tbody/tr")).size();
				Assert.assertTrue("FAIL, No Result Displayed", GetRowCount > 0);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if (sAction.equals("Status")){
				Thread.sleep(2000);
				SearchByDropDown.click();
				Thread.sleep(5000);
				SearchByTextBox.sendKeys(sAction);
				Thread.sleep(5000);
				StartingWithTextBox.sendKeys(svalue);
				Thread.sleep(2000);
				SearchButton.click();
				Thread.sleep(2000);
				GetRowCount = findAll(By.xpath("//table[@summary='Owned products & services']/tbody/tr")).size();
				Assert.assertTrue("FAIL, No Result Displayed", GetRowCount > 0);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
		}
	}
	@FindBy(xpath=" .//button[contains(@class,'order-button')]")
	WebElementFacade CreateOrderButton;
	@FindBy(xpath=".//*[text()='Existing plan']")
	WebElementFacade ExistingPlanText;
	@FindBy(xpath=".//*[@aria-label='Existing plan:See plans']")
	WebElementFacade SeePlansButton;
	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade PromotionList;
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")	  
	WebElementFacade PromotionSearchTextBox;	  
	@FindBy(xpath=".//*[@class='siebui-appletmenu-item  ui-menu-item']//*[text()='Exchange - Like for like']")
	WebElementFacade ExchangeLFL; 
	@FindBy(xpath=".//*[@class='icon icon-chevron-down vf-btm-menu-itm']")
	WebElementFacade SelectAction; 
	@FindBy(xpath=".//*[@title='Complete']")
	WebElementFacade CompleteOrder;	
	@FindBy(xpath=".//*[@title='Pending']")
	WebElementFacade PendingOrder;	
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")	  
	WebElement PromotionSearchTextBoxWebElement;	

	@FindBy(xpath=".//*[@aria-labelledby='s_11_l_Target_Promotion_Name']")
	WebElementFacade TargetPromotion;
	@FindBy(xpath=".//*[@aria-label='Select a plan:Go']")
	WebElementFacade PromotionUpgradeGoButton;
	@FindBy(xpath=".//*[@aria-label='Select a plan:Add to basket']") 
	WebElementFacade PromotionUpgradeOKButton;

	@FindBy(xpath="(.//td[contains(@id,'Target_Promotion_Name')])[2]")
	WebElementFacade FirstPromotion;

	@Step
	public void PromotionSelect() throws InterruptedException, IOException, AWTException{

		String applet = "//*[@title='Existing plan List Applet']";
		String table = "//table[@summary='Existing plan']";
		String Index = "0";
		String sLocateColValue = Serenity.sessionVariableCalled("ProductName").toString();
		String sStartingWith = sLocateColValue;
		String sLocateCol = "Product_Name";

		Common.WaitForClock(ClockObj);
		ExistingPlanText.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable(); 

		String LocateColMessage = sLocateCol+" Not Found";

		CommonEnh.selectedRow = -1;
		Assert.assertTrue(LocateColMessage, CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
		report.Info(sLocateColValue+" found");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		SeePlansButton.click();
		Thread.sleep(5000);
		Common.WaitForClock(ClockObj);


	}
	@Step
	public void PromotionUpgrade(String LogicalName) throws InterruptedException, IOException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Catalog_ENH.xls";
		String dataSheet = "PromotionUpgrade";
		

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Journey").size();i++) {

			String sNavigate = tableMap.get("Navigate").get(i);
			String sPromotion = tableMap.get("Promotion").get(i);
			
			
			String Index = "0";
			String sStartingWith = "";
			if(!(Serenity.sessionVariableCalled("ProductName").toString()).equals(null)){
				 sStartingWith = Serenity.sessionVariableCalled("ProductName").toString();
			}
			String sLocateCol = "Product_N";
	
			Common.WaitForClock(ClockObj);
			Thread.sleep(3000);
	
	
			Common.waitForElement(PromotionSearchTextBoxWebElement);
	
			if(sPromotion.equals("")){
				PromotionSearchTextBox.click();
		
				PromotionSearchTextBox.sendKeys(sStartingWith);
				PromotionSearchTextBox.sendKeys(Keys.chord(Keys.ENTER));
				//PromotionUpgradeGoButton.click();
				report.Info("Promotion searched");
		
				Thread.sleep(1000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			int PromotionUpgardeTableSize= findAll(By.xpath("//table[@summary='Select a plan']/tbody/tr")).size();
	
			if(PromotionUpgardeTableSize>1){
	
				CommonEnh.selectedRow = 1;
				report.Info("Promotions are available");
			}
			else{
				Assert.assertTrue("No rows displayed after clicking on Go button- Promotions not available", PromotionUpgardeTableSize>1);
			}
	
			PromotionUpgradeOKButton.click();
	
			Thread.sleep(7000);
			Common.WaitForClock(ClockObj);
			Thread.sleep(7000);
	
			ProductandServicesNextButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			
			if(sNavigate.equalsIgnoreCase("Yes")){
				ProductandServicesNextButton.click();
				Common.WaitForClock(ClockObj);
			}

	}
}

	@Step
	public void PromotionUpgradeAddhandset() throws InterruptedException, IOException, AWTException{

		String Index = "0";
		String sStartingWith = Serenity.sessionVariableCalled("ProductName").toString();
		//String sStartingWith = sLocateColValue;
		String sLocateCol = "Product_Name";

		Common.WaitForClock(ClockObj);
		Thread.sleep(10000);


		Common.waitForElement(PromotionSearchTextBoxWebElement);

		PromotionSearchTextBox.click();
		FirstPromotion.click();
		Thread.sleep(2000);
		PromotionSearchTextBox.typeAndEnter("");
		PromotionSearchTextBox.typeAndEnter(sStartingWith);
		PromotionUpgradeGoButton.click();
		report.Info("Promotion searched");

		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		int PromotionUpgardeTableSize= findAll(By.xpath("//table[@summary='Select a plan']/tbody/tr")).size();


		if(PromotionUpgardeTableSize>1){

			CommonEnh.selectedRow = 1;
			report.Info("Promotions are available");
		}
		else{
			Assert.assertTrue("No rows displayed after clicking on Go button- Promotions not available", PromotionUpgardeTableSize>1);
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		PromotionUpgradeOKButton.click();

		Common.WaitForClock(ClockObj);
		Thread.sleep(5000);
		Common.WaitForClock(ClockObj);

		if (PromotionUpgradeOKButton.isCurrentlyVisible()){
			PromotionUpgradeOKButton.click();

			Common.WaitForClock(ClockObj);
			Thread.sleep(5000);
		}



		int totalRows = findAll(By.xpath("//*[contains(@id,'S_A') and contains(@class,'siebui-tile')]")).size();
		for (int x =0;x<=9;x++) {
			for(int j=0;j<=totalRows;j++){
				String flagcolour = "N";
				String colour = find(By.xpath("//*[contains(@id,'S_A') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//div[contains(@class,'vf-oui-in-stock vf-oui-color')]")).getAttribute("class");

				if (colour.contains("green")){
					String sHandsetName = find(By.xpath("//*[contains(@id,'S_A') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//input[contains(@aria-label,'VF Prod Name')]")).getTextValue() ;
					Serenity.setSessionVariable("Handset").to(sHandsetName);

					find(By.xpath("//*[contains(@id,'S_A') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//button[contains(@class,'add2basket')]")).click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					report.Info("Handset found: "+sHandsetName);
					Common.WaitForClock(ClockObj);
					flagcolour = "Y";
					break;
				}
				if(flagcolour.equals("Y")) {
					break;
					
				}
				else {
					report.Info("Handset not found, navigating to next set/page ");
					ProductServicesPromotionClickNext.click();
				}
			}
		}
		Thread.sleep(7000);
		Common.WaitForClock(ClockObj);
		Thread.sleep(7000);
		ProductandServicesNextButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		ProductandServicesNextButton.click();
		Common.WaitForClock(ClockObj);

	}

	@FindBy(xpath="//button[contains(@class,'gotonextset')]")
	WebElementFacade ProductServicesPromotionClickNext;	
	
	@FindBy(xpath=".//*[text()='Pay as you go']")
	WebElementFacade PayAsYouGoTab;	

	@Step
	public void ValidateCostToCorrectDecimal() throws InterruptedException, IOException, AWTException{

		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		PayAsYouGoTab.click();
		Thread.sleep(5000);
		Common.WaitForClock(ClockObj);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	 

		List<String> text = new ArrayList<String>();
		List<WebElementFacade> options = findAll(By.xpath(".//input[@aria-labelledby='VF_OUI_List_Price_Label']"));

		for(int j=0; j<options.size(); j++) {
			text.add(options.get(j).getTextValue());		 	            
		} 
		Iterator<String> itr = text.iterator();

		while(itr.hasNext()) {		 	            	
			String currentValue= itr.next();		 	             	 	            	 
			String[] arr1 = currentValue.split("\\.");
			String DecimalValues = arr1[1];
			int DecimalLength =DecimalValues.length();
			Assert.assertTrue("The price "+currentValue+" has incorrect decimal place, expected is 2 decimal place", DecimalLength==2);
			report.Info("The price "+currentValue+" has correct decimal place");
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}

	@FindBy(xpath=".//div[@class='vf-oui-pln-mnths']/input")
	WebElementFacade ContractDuration;

	@FindBy(xpath=".//div[@class='vf-pln-optn-column vf-oui-plan-mnths']/div[3]")
	WebElementFacade ContractDurationFootnote;


	public void CheckPromotionContractPeriod(String ProductType) throws IOException, AWTException, InterruptedException{
		String sProductCategoryPath = ".//*[text()='SIM only']";
		String sProductTypePath = ".//*[text()='Pay monthly']";  
		Common.WaitForClock(ClockObj);
		find(By.xpath(sProductTypePath)).click();
		Common.WaitForClock(ClockObj);


		find(By.xpath(sProductCategoryPath)).withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		find(By.xpath(sProductCategoryPath)).click();
		Common.WaitForClock(ClockObj);

		String sRadioButtonSKU = "(.//*[@type='radio'][@name='Name'][@value='SKU'])";
		String recordIndex="";
		ApplyFilterButtoninProdandSearch.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();

		if(findBy(sRadioButtonSKU+"[1]").isCurrentlyVisible()){
			recordIndex="1";
			findBy(sRadioButtonSKU+"[1]").click();
		}
		else if(findBy(sRadioButtonSKU+"[2]").isCurrentlyVisible()){
			recordIndex="2"; 
			findBy(sRadioButtonSKU+"[2]").click();
		}
		else{
			report.Info("SKU Radio Button not found");
			Assert.assertTrue(false);
		}
		Common.WaitForClock(ClockObj);
		Thread.sleep(1000);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		String SearchTextBox="(.//*[@type='radio'][@name='Name'][@value='SKU'])["+recordIndex+"]/parent::div/following-sibling::div/input";

		String filePath = "\\src\\test\\resources\\data\\Catalog_ENH.xls";
		String dataSheet = "ContractPeriodValidation";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(ProductType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("ProductID").size();i++) {
			String sProductID = tableMap.get("ProductID").get(i);
			String sDuration = tableMap.get("Duration").get(i);
			String sDurationLabel = tableMap.get("DurationLabel").get(i);
			Common.WaitForClock(ClockObj);
			Thread.sleep(4000);
			find(By.xpath(SearchTextBox)).clear();
			Thread.sleep(1000);
			find(By.xpath(SearchTextBox)).sendKeys(sProductID);
			Thread.sleep(1000);
			JavascriptExecutor SearchIconButton = (JavascriptExecutor)getDriver();
			SearchIconButton.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//span[@class='icon icon-search'])["+recordIndex+"]"))); 
			Thread.sleep(10000);
			Common.WaitForClock(ClockObj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			String sContractPeriod = ContractDuration.getAttribute("value");
			String sContractPeriodFootNote = ContractDurationFootnote.getTextValue();

			Assert.assertTrue("FAIL, The contract period for promotion "+sProductID+" is not as expected, actual is "+sContractPeriod,sContractPeriod.equalsIgnoreCase(sDuration));
			report.Info("The contract period for promotion "+sProductID+" is as expected i.e. "+sDuration);

			Assert.assertTrue("FAIL, The contract period for promotion "+sProductID+" is in "+sContractPeriodFootNote+" , but should be in "+sDurationLabel,sDurationLabel.equalsIgnoreCase(sContractPeriodFootNote));
			report.Info("The contract period label for promotion "+sProductID+" is displayed as expected i.e. "+sContractPeriodFootNote);


		}

	}


	@FindBy(xpath=".//div[contains(text(),'The cycle forward charge shows the line')]")
	WebElementFacade CycleForwardPopUp;

	@FindBy(xpath="//span[text()='Ok']")
	WebElementFacade CycleForwardOkButton;
	
	@FindBy(xpath=".//*[text()='Halo - Payments']")
	WebElementFacade HaloPaymentsTab;
	
	@FindBy(xpath=".//*[@aria-label='Payments:New payment']")
	WebElementFacade PaymentNewButton;
	
	@FindBy(xpath=".//a[text()='Billing profiles']")
	WebElementFacade BillingProfilesLink;
	
	@FindBy(xpath=".//div[@class='vfoui-bill-contact-address']")
	WebElementFacade BillingProfAddressCapture;
	
	@FindBy(xpath=".//*[@aria-label='Billing profiles:New billing profile']")
	WebElementFacade NewBillingProfilesButton;
	
	@FindBy(xpath=".//*[contains(text(),'Please confirm you need to create')]")
	WebElementFacade NewBillingProfilesButtonPopUp;
	
	@FindBy(xpath=".//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons vfoui_box_shadow']//*[text()='Ok']")
	WebElementFacade NewBillingProfilesButtonPopUpOKButton;
	
	@FindBy(xpath=".//*[@id='first_pager_s_1_l']")
	WebElementFacade PreviousRec;


	@FindBy(xpath=".//*[text()='Audit trail']")
	WebElementFacade AuditTrail;
	
	@FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Name_Label']")
    WebElementFacade BankName;

    @FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Branch_Label']")
    WebElementFacade BranchName;

    @FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Account_Name_Label']")
    WebElementFacade AccName;

    @FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Sort_Code_Label']")
    WebElementFacade SortCode;

    @FindBy(xpath=".//*[@aria-labelledby='VF_Bank_Account_Number_Label']")
    WebElementFacade AccountNumber;

    @FindBy(xpath=".//*[@aria-label='Siebel:OK']")
    WebElementFacade BankDetailsConfirm;

    @FindBy(xpath=".//*[@class='siebui-applet-content siebui-collapsible siebui-collapsible-applet-content']//button[@aria-label='Direct debit information:Validate bank details']")
    WebElementFacade ValidateBankDetails;

	@FindBy(xpath=".//button[text()='Change contact']")
	WebElementFacade ChangeContact;
	
	@FindBy(xpath=".//*[@id='last_pager_s_8_l']")
	WebElementFacade NextRecord;
	
	@FindBy(xpath=".//*[@aria-label='Select existing contact:Select']")
	WebElementFacade SelectRecord;
	
	@FindBy(xpath=".//*[text()='Billing contact details']")
	WebElementFacade BillingContactDetails;	
    
    @FindBy(xpath=".//*[@class='siebui-applet-content siebui-collapsible siebui-collapsible-applet-content']//button[@aria-label='Direct debit information:Update bank details']")
    WebElementFacade UpdateBankDetails;
  
    @FindBy(xpath=".//*[contains(text(),'Direct debit information')]")
    WebElementFacade DirectDebitInfo;
	
	@FindBy(xpath=".//*[contains(text(),'Please ensure you have selected')]")
	WebElementFacade PaymentTypeRequiredPopUp;
	
	@FindBy(xpath="(.//*[text()='Ok'])[3]")
	WebElementFacade PaymentTypeRequiredPopUpOKButton;
	
	@FindBy(xpath=".//*[@aria-label='Billing profile name']")
	WebElementFacade BillingProfileName;
	
	@FindBy(xpath=".//*[@aria-label='Profile type']")
	WebElementFacade ProfilesType;
	
	@FindBy(xpath=".//*[@aria-label='Payment term']")
	WebElementFacade PaymentTerm;
	
	@FindBy(xpath=".//*[@aria-label='Billing Selected']")
	WebElementFacade Billing;
	
	@FindBy(xpath=".//*[@aria-label='Bill type']")
	WebElementFacade BillType;
	
	@FindBy(xpath=".//*[@aria-label='Payment method']")
	WebElementFacade PaymentMethod;
	
	@FindBy(xpath="(.//*[text()='Active'])[2]")
	WebElementFacade ActiveStatus;
	
	@FindBy(xpath=".//*[@data-seq='0'] [@disabled='disabled']")
	WebElementFacade SMSCheckBox;
	
	@FindBy(xpath=".//*[@aria-label='Payment method']")
	WebElementFacade PaymentMethodTextBox;
	
	@FindBy(xpath=".//*[@data-display='Update card details']")
	WebElementFacade UpdateCardDetails;
	
	@FindBy(xpath=".//*[contains(text(),'Billing contact details')]")
	WebElementFacade BillingProfileDetail;
	
	@FindBy(xpath=".//*[@aria-label='Billing contact details:Update email']")
	WebElementFacade UpdateEmailID;
	
	
	@FindBy(xpath=".//*[@aria-labelledby='VFEmailAddress_Label']")
	WebElementFacade EmailId;
	
	@FindBy(xpath=".//*[@aria-labelledby='VFDomainAddress_Label']")
	WebElementFacade DomainId;
	
	@FindBy(xpath=".//*[@aria-labelledby='VFReTypeEmailAddress_Label']")
	WebElementFacade ReEnterEmailId;
	
	@FindBy(xpath=".//*[@aria-labelledby='VFReTypeDomainAddress_Label']")
	WebElementFacade ReEnterDomainId;
	
	
	@FindBy(xpath=".//*[@aria-label='Billing contact details:Remove email']")
	WebElementFacade RemoveEmailID;
	
	@FindBy(xpath=".//button[@aria-label='Previous bills:Email copy bill']")
	WebElementFacade EmailCopyBill;
	
	
	@FindBy(xpath=".//input[@aria-labelledby='Send_Email_Type_Label']")
	WebElementFacade SelectEmail;
	
	
	@FindBy(xpath=".//*[text()='Send Email']")
	WebElementFacade SendEmailButton;
	
	@FindBy(xpath=".//*[contains(text(),'Your request has been submitted for processing')]")
	WebElementFacade EmailSentVerify;
	
	@FindBy(xpath="(.//*[text()='Ok'])[3]")
	WebElementFacade EmailSentOkButton;
	
	

	@Step
	public void Billing(String LogicalName) throws InterruptedException, IOException, AWTException{

		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_Enh.xls";
		String dataSheet = "Billing";
		String applet = "";
		String table = "";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      				
			String Index = tableMap.get("Index").get(i);				
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);	
			String sView = tableMap.get("View").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			String sPaymentMethod = tableMap.get("PaymentMethod").get(i);

			Thread.sleep(3000);
			Common.WaitForClock(ClockObj);
			
			if (sLocateColValue.contains("Bill_Number")){
				sLocateColValue = sLocateColValue.replace("Bill_Number", Serenity.sessionVariableCalled("BILLNUMBER0").toString());    	  
			}

			if(sView.equalsIgnoreCase("Billing")){
				applet = "//div[contains(@class,'vfoui-account-overview-billing-master')]";
				table = "//table[@summary='Billing']";
				report.Info("Billing View");			
				/*
				applet = "//*[contains(@rn,'VF OUI Master Account Overview Billing Applet')]";
				table = "//table[@summary='Billing']";
				report.Info("Billing View");
			*/}
			else if(sView.equalsIgnoreCase("PreviousBill")){
				applet = "//*[contains(@title,'Previous bills List Applet')]";
				table = "//table[@summary='Previous bills']";
				report.Info("Previous Bills View");
			}
			else if(sView.equalsIgnoreCase("SummaryCharges")){
				applet = "//*[contains(@title,'Summary charges List Applet')]";
				table = "//table[@summary='Summary charges']";
				report.Info("Previous Bills View");
			}

			if (Index.equals("")){
				Index = "0";
			}   
			
			if (sAction.equalsIgnoreCase("CaptureBillingAddress")) {
				Common.WaitForClock(ClockObj);
				BillingProfilesLink.click();
				Thread.sleep(1000);
				
			     ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",BillingProfAddressCapture ); 
				
				if (BillingProfAddressCapture.isVisible()) {
					String BillingAddress= BillingProfAddressCapture.getTextValue();
					report.Info("Billing profile address is" +BillingAddress);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					
					String BillingAddressvalue1 = Serenity.sessionVariableCalled("Addressvalue").toString();
					String[] arr1 = BillingAddressvalue1.split(Pattern.quote(" "));
					String className = arr1[0];
					String BillingAddressvalue=className.replace(","," ");
					System.out.println(BillingAddressvalue);
					
					BillingAddress=BillingAddress.replace("Billing address\n","");
					BillingAddress=BillingAddress.replace("\n"," ");
					System.out.println(BillingAddress);
					
					Thread.sleep(1000);
					Assert.assertTrue("Billing address is ", BillingAddress.contains(BillingAddressvalue));
					
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

					}
				else {
					report.Info("Billing profile address is not visible");
					Assert.assertTrue(false);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						
					}
				break;
			}

			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equalsIgnoreCase("true"));
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{               
				Common.selectedRow = 1;
			}

			if (!sUIName.equals("")){ 
				CommonEnh.updateSiebList(applet,table, sUIName, svalue); 
				report.Info("Row updated successfully"); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
				Common.WaitForClock(ClockObj);
			} 	

			if(sValidation.equalsIgnoreCase("CycleForward")){
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("FAIL: Cycle Forward Popup is not displayed after clicking on it.", CycleForwardPopUp.isVisible());
				CycleForwardOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				CycleForwardOkButton.click();
			}
			
			if (sAction.equalsIgnoreCase("SecondaryBilling")) {
				Common.WaitForClock(ClockObj);
				if (BillingProfCustomerAccount.isCurrentlyVisible()) {
					BillingProfCustomerAccount.withTimeoutOf(120, TimeUnit.SECONDS).waitUntilClickable();
				//	BillingProfCustomerAccount.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					BillApplet.isCurrentlyVisible();
					BillApplet.click();
				//	PreviousRecord.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					BillingProfCustomerAccount.click();
				}
			}
			
			if (sAction.equalsIgnoreCase("BillHistory")) {
				BillHistory.click();
				Thread.sleep(3000);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			
				if (!sLocateCol.equals("")){
					CommonEnh.selectedRow = -1;
					Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equalsIgnoreCase("true"));
					report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
				else{               
					Common.selectedRow = 1;
				}
			
	}
			if(sAction.equalsIgnoreCase("ClickOnBillingProfile"))
			{
				BillingProfilesLink.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(ClockObj);
				NewBillingProfilesButton.click();
				Thread.sleep(2000);
				Assert.assertTrue("New Billing Profile's PopUp did not occur", NewBillingProfilesButtonPopUp.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				NewBillingProfilesButtonPopUpOKButton.click();
				Common.WaitForClock(ClockObj);
				BillingProfileName.click();
				Thread.sleep(2000);
				Robot robot = new Robot();  
				robot.keyPress(KeyEvent.VK_CONTROL);    
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_CONTROL);   
				robot.keyRelease(KeyEvent.VK_S);
				Thread.sleep(2000);
				Assert.assertTrue("Payment type required PopUp did not occur", PaymentTypeRequiredPopUp.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());				
				PaymentTypeRequiredPopUpOKButton.click();
				Thread.sleep(2000);
			}
			
			if (sAction.equalsIgnoreCase("EmailCopyBill")) {
				EmailCopyBill.click();
				if(SelectEmail.isCurrentlyVisible()){
					SelectEmail.clear();
					SelectEmail.sendKeys("Account holder Email");
					SendEmailButton.click();
					
					Assert.assertTrue("Expected popup did not occur", EmailSentVerify.containsText("Your request has been submitted for processing"));
					report.Info("Pass:Expected Popup did occur");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					EmailSentOkButton.click();
							
			}
			
			
		}
			if(!sPaymentMethod.equals("")){				
									
					BillingProfilesLink.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.WaitForClock(ClockObj);
					PaymentMethodTextBox.typeAndEnter(sPaymentMethod);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
				
			}

		}
	}
	
	@FindBy(xpath=".//*[@title='Billing details:Check payment date']")
	WebElementFacade CheckPaymentDate;
	@FindBy(xpath=".//*[@id='s_5_1_2_0_Ctrl']")
	WebElementFacade CheckAllBillProfiles;
	@FindBy(xpath=".//*[@class='ui-button-text' and text()='Ok']")
	WebElementFacade OkPaymentDate;
	@FindBy(xpath=".//*[@title='Billing profiles:New billing profile']")
	WebElementFacade NewBillingProfile;
	@FindBy(xpath=".//*[@class='vfoui-bill-format-sec']")
	WebElementFacade BillingFormatSection;
	
	@FindBy(xpath="//button/span[text()='Update card details']")
	WebElementFacade UpdateCardDetailsButton;
	
	@FindBy(xpath="//button/span[text()='Authorise card details']")
	WebElementFacade AuthoriseCardButton;
	
	@Step
	public void BillingProfiles(String LogicalName) throws InterruptedException, IOException, AWTException{

		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\Account_Enh.xls";
		String dataSheet = "BillingProfiles";
		String applet = "";
		String table = "";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {

			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);      				
			String Index = tableMap.get("Index").get(i);				
			String sUIName = tableMap.get("UIName").get(i);
			String svalue = tableMap.get("Value").get(i);	
			String sView = tableMap.get("View").get(i);
			String sAction = tableMap.get("Action").get(i);
			String sValidation = tableMap.get("Validation").get(i);
			String sPaymentType = tableMap.get("PaymentType").get(i);
			String sPaymentMethod = tableMap.get("PaymentMethod").get(i);
			String sExernaPaymentSystemWindow = tableMap.get("ExernaPaymentSystemWindow").get(i);
			
			if(sView.equalsIgnoreCase("Billing")){
				applet = "//*[contains(@rn,'VF OUI Master Account Overview Billing Applet')]";
				table = "//table[@summary='Billing']";
				report.Info("Billing View");
			}
			
			if(sView.equalsIgnoreCase("BillingProfiles")){
				applet = "//*[@title='Billing profiles List Applet']";
				table = "//table[@summary='Billing profiles']";
				report.Info("Billing Profiles View");
			}
			
			if (sExernaPaymentSystemWindow.equals("")){
				sExernaPaymentSystemWindow = "N";
			} 
			
			if (Index.equals("")){
				Index = "0";
			}      															

			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equalsIgnoreCase("true"));
				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{               
				Common.selectedRow = 1;
			}

			if (!sUIName.equals("")){ 		
				String sBilling = "";
				if (sView.equalsIgnoreCase("Billing")){	
					sBilling = CommonEnh.updateSiebList(applet,table, sUIName, svalue);
					Serenity.setSessionVariable("PaymentMethodBilling").to(sBilling);
				}					
				else if (sView.equalsIgnoreCase("BillingProfiles")){	
					/*BillingProfilesLink.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					Common.WaitForClock(ClockObj);*/
					String sBillingProfiles = CommonEnh.updateSiebList(applet,table, sUIName, svalue);
					Serenity.setSessionVariable("PaymentMethodBillingProfile").to(sBillingProfiles);
				}
				else
				{
					CommonEnh.updateSiebList(applet,table, sUIName, svalue);			
					report.Info("Row updated successfully"); 
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
					Common.WaitForClock(ClockObj);
				}
			}
			if(BillingProfilesLink.isCurrentlyVisible())
			{
				BillingProfilesLink.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(ClockObj);
			}
			if(sAction.equalsIgnoreCase("ClickOnNewBillingProfilesButton"))
			{
				Common.WaitForClock(ClockObj);
				NewBillingProfilesButton.click();
				Thread.sleep(2000);
				Assert.assertTrue("New Billing Profile's PopUp did not occur", NewBillingProfilesButtonPopUp.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Thread.sleep(2000);
				NewBillingProfilesButtonPopUpOKButton.click();
				Common.WaitForClock(ClockObj);
			}
			if(sAction.equalsIgnoreCase("AuditTrailValidation"))
			{
				AuditTrail.click();
				Common.WaitForClock(ClockObj);
				PreviousRec.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}			
			if(sValidation.equalsIgnoreCase("UpdateBankDetails"))
			{
				
				ProfilesType.sendKeys("Postpaid");
				Thread.sleep(2000);
				PaymentMethod.clear();
				PaymentMethod.sendKeys(sPaymentMethod);	
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				UpdateBankDetails.waitUntilClickable();
				UpdateBankDetails.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				BankName.type("UK Bank");
				BranchName.type("Vod_UK");
				AccName.type("acc_vodafone");
				SortCode.type("301215");
				AccountNumber.type("12341234");
				
				BankDetailsConfirm.waitUntilClickable();
				BankDetailsConfirm.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				ValidateBankDetails.waitUntilClickable();
				ValidateBankDetails.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			
			if(sExernaPaymentSystemWindow.equalsIgnoreCase("Y")) {
				UpdateCardDetailsButton.click();
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
				
                  driver.switchTo().window(initialWindow);
                  AuthoriseCardButton.click();
			}

			
			if(sAction.equalsIgnoreCase("UpdateContactForBillingProfile"))
			{
		
				BillingContactDetails.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				ChangeContact.waitUntilClickable();
				ChangeContact.click();
				Common.WaitForClock(ClockObj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		
				Thread.sleep(2000);
				SelectRecord.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Contact Updated Successfully");

			}
			
					
			if(sValidation.equalsIgnoreCase("SaveWithoutselectingBillingType"))
			{					
				BillingProfileName.click();
				Thread.sleep(2000);
				Robot robot = new Robot();  
				robot.keyPress(KeyEvent.VK_CONTROL);    
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_CONTROL);   
				robot.keyRelease(KeyEvent.VK_S);
				Thread.sleep(2000);
				Assert.assertTrue("Payment type required PopUp did not occur", PaymentTypeRequiredPopUp.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());				
				PaymentTypeRequiredPopUpOKButton.click();
				Thread.sleep(2000);
			}
			if(sValidation.equalsIgnoreCase("CompareValues"))
			{
				String BillingPaymentMethod = Serenity.sessionVariableCalled("PaymentMethodBilling").toString();
				String BillingProfilesPaymentmethod = Serenity.sessionVariableCalled("PaymentMethodBillingProfile").toString();
				Assert.assertTrue(BillingPaymentMethod + "Not Equals to" + BillingProfilesPaymentmethod, BillingPaymentMethod.equals(BillingProfilesPaymentmethod));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if(sPaymentType.equalsIgnoreCase("Postpaid"))
			{					
				ProfilesType.sendKeys("Postpaid");
				Thread.sleep(2000);
				/*PaymentTerm.sendKeys("7");
				Thread.sleep(2000);
				BillType.sendKeys("Itemised");
				Thread.sleep(2000);*/
				PaymentMethod.sendKeys(sPaymentMethod);	
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Billing.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}	
			if(sValidation.equalsIgnoreCase("Prepaid"))
			{					
				ProfilesType.sendKeys("Prepaid");
				Thread.sleep(2000);
				PaymentMethod.sendKeys(sPaymentMethod);		
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Billing.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}
			Common.WaitForClock(ClockObj);
			Robot robot = new Robot();  
			robot.keyPress(KeyEvent.VK_CONTROL);    
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);   
			robot.keyRelease(KeyEvent.VK_S);
			Thread.sleep(2000);
			
			if(sAction.equalsIgnoreCase("ValidateActiveStatus"))
			{					
				Assert.assertTrue("Status is not Active", ActiveStatus.isCurrentlyVisible());
				ActiveStatus.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		
				report.Info("Status has been successfully changed to active");

				if(BillingFormatSection.isCurrentlyVisible()){

					((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", BillingFormatSection);
					Thread.sleep(500);
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if(sAction.equalsIgnoreCase("ValidateSMSCheckBox"))
			{
				Assert.assertTrue("SMS Checkbox is not checked", SMSCheckBox.isCurrentlyVisible());
				//SMSCheckBox.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		
				report.Info("SMS Checkbox has been checked successfully");
			}
			
			if(sAction.equalsIgnoreCase("UpdateAndRemoveEmail"))
			{
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(ClockObj);
				//BillingProfileDetail.click();
			//	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				UpdateEmailID.waitUntilClickable();
				UpdateEmailID.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				EmailId.type("voda123");
				DomainId.type("gmail.com");
				Thread.sleep(2000);
				ReEnterEmailId.type("voda123");
				ReEnterDomainId.type("gmail.com");
												
				BankDetailsConfirm.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Email ID updated successfully"); 

				RemoveEmailID.waitUntilClickable();
				RemoveEmailID.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Email ID Removed successfully");
				}
			if(sAction.equalsIgnoreCase("ValidateActiveStatusNotPopulated"))
			{					
				Assert.assertTrue("Status is Active", !ActiveStatus.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		
				report.Info("Status has not been populated as expected");
				
				if(BillingFormatSection.isCurrentlyVisible()){
					
					((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", BillingFormatSection);
					Thread.sleep(500); 
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if(sAction.equalsIgnoreCase("ValidateSMSCheckBoxNotEnabled"))
			{
				Assert.assertTrue("SMS Checkbox is checked", !SMSCheckBox.isCurrentlyVisible());
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());		
				report.Info("SMS Checkbox has been not checked as expected");
			}
			if (sValidation.equals("CheckPaymentDate"))
	 		{
	    		Thread.sleep(2000);
	    		Assert.assertTrue("FAIL, Check Payment Date Button is Not Enabled", CheckPaymentDate.isEnabled());
	    		report.Info("Customer summary applet found using Locate Col");
	    		CheckPaymentDate.click();
	    		if(OkPaymentDate.isVisible())
	    		{
	    			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	    			OkPaymentDate.click();
	    		}
	    		
	    	}
			
			if(sValidation.equalsIgnoreCase("Bill Me"))
			{
				String BillingPaymentMethod = Serenity.sessionVariableCalled("PaymentMethodBilling").toString();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue(BillingPaymentMethod + "Not Equals to" + sValidation , BillingPaymentMethod.equals(sValidation));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			
			if(sValidation.equalsIgnoreCase("Cash"))
			{
				String BillingPaymentMethod = Serenity.sessionVariableCalled("PaymentMethodBilling").toString();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue(BillingPaymentMethod + "Not Equals to" + sValidation , BillingPaymentMethod.equals(sValidation));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			} 
			
		}
			
		}
	
	@FindBy(xpath="//a[@name = 'VFCustomerCode']")
	WebElementFacade AccNo;
	
	@FindBy(xpath="//li/a[text()='Billing profiles']")
	WebElementFacade BillingProfileTab;
	
	@FindBy(xpath="//button/span[text()='New billing profile']")
	WebElementFacade NewBillingProfileButton;
	
	@FindBy(xpath="//button/span[text()='Ok']")
	WebElementFacade NewBillingProfilePopUpOkButton;
	
	@FindBy(xpath="//input[@aria-label='Profile type']")
	WebElementFacade ProfileTypeInput;
	
	@FindBy(xpath="//input[@aria-label='Profile type']")
	WebElementFacade PaymentMethodInput;
	
	
	@Step
	public void BillingProfilesForPrepay(String logicalName) {
		
		if(logicalName.equalsIgnoreCase("Debit/Credit Card")) {
			AccNo.click();
			BillingProfileTab.click();
			NewBillingProfileButton.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ProfileTypeInput.typeAndEnter("Prepaid");
			PaymentMethodInput.typeAndEnter("Credit/Debit Card");
			
			
			
		}
		
	}
	
	@FindBy(xpath=".//input[@value='NewLine']")
	WebElementFacade NewLineRadioButton;
	
	@FindBy(xpath=".//button[@aria-label='Basket:Next']")
	WebElementFacade NextButton;
	

	@FindBy(xpath=".//*[contains(text(),'Before you continue')]/parent::div/following-sibling::div[2]//button")
	WebElementFacade WarningTitleBox;
	


	@Step
	public void CombiBundlePlansSelection(String LogicalName) throws IOException, InterruptedException, FindFailed, AWTException{
		
		Common.WaitForClock(ClockObj);
		String filePath = "\\src\\test\\resources\\data\\DataProxy.xls";
		String dataSheet = "CombiPlan";
		String applet = "";
		String table = "";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LogicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {

			String Offers = tableMap.get("Offers").get(i);
			String Speed = tableMap.get("Speed").get(i);
			String PartNo="";
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String UIName = tableMap.get("UIName").get(i);
			String Value = tableMap.get("Value").get(i);
			String Index = tableMap.get("Index").get(i);
			String AddPAYM = tableMap.get("AddPAYM").get(i);
			String ClickNext = tableMap.get("ClickNext").get(i);
			if (Index.equals("")){
				Index = "0";
			}      															

			if(Offers.equalsIgnoreCase("Yes")) {
				applet = "//*[@title='Select from available offers List Applet']";
				table = "//table[@summary='Select from available offers']";
				// sLocateColValue = "£"+sLocateColValue+"*";
				// sLocateColValue = sLocateColValue+"*";
			}
			
			if(Speed.equalsIgnoreCase("Yes")) {
				applet = "//*[@title='Choose your home broadband plan List Applet']";
				table = "//table[@summary='Choose your home broadband plan']";
				
			}
			
			String LocateColMessage = sLocateCol+" Not Found";
			
			if (!sLocateCol.equals("")){
				CommonEnh.selectedRow = -1;
				Assert.assertTrue(LocateColMessage, CommonEnh.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
				report.Info(sLocateColValue+" selected");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			
			
			if(AddPAYM.equalsIgnoreCase("Yes")) {
				PartNo= Serenity.sessionVariableCalled("PartNo").toString();
				int totalRows = findAll(By.xpath("//*[contains(@id,'S_A2') and contains(@class,'siebui-tile')]")).size();
				report.Info("Total: "+totalRows);
				for(int j=0;j<=totalRows;j++){
					CommonEnh.WaitForClock(ClockObj);
					String promo = find(By.xpath("//*[contains(@id,'S_A2') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//input[@aria-label='Product Part number']")).getAttribute("value");			

					if (promo.contains(PartNo)){
						find(By.xpath("//*[contains(@id,'S_A2') and contains(@id,'_"+j+"') and contains(@class,'siebui-tile')]//input[@class='tBtn']")).click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						report.Info("Part Number found: "+PartNo);
						break;
					}
				}
			}
			
			if (!UIName.equals("")){ 
				CommonEnh.updateSiebList(applet, table, UIName, Value);  
			}
			
			
			if(ClickNext.equalsIgnoreCase("Yes")) {
				NewLineRadioButton.click();
				Thread.sleep(2000);
				
				String ClickOnElementXPath = ".//button[contains(@class,'vf_combi_addbtn')]/span[contains(text(),'Add to basket')]";
				getDriver().findElement(By.xpath(ClickOnElementXPath)).click();
				//AddBasketButton.click();
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
				
				NextButton.click();
				CommonEnh.WaitForClock(ClockObj);
				if(WarningOKButton.isCurrentlyVisible()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					WarningOKButton.click();
					CommonEnh.WaitForClock(ClockObj);
				}  
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());	
						
			}			
		}	
	}	
	
	}
	

