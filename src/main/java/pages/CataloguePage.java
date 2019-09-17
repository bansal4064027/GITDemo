package pages;

import java.awt.AWTException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.common;
import utilities.SikuliUtility;

public class CataloguePage extends PageObject{
	private static final TimeUnit SECONDS = null;
	@Steps
    private ReadWorkbook readWorkbook;
	@Steps
	private common Common;
	@Steps
	private SikuliUtility sikuliUtility;
	@Steps
	private DatabasePage Database;
	
	@Steps
	ReportMessege report;

      
	@FindBy(xpath="//a[text()='Catalogue']")
    WebElementFacade CatalogueTab;
	
	@FindBy(xpath="//a[text()='Catalogue']")
    WebElement CatalogueTabWebElement;
    
    @FindBy(xpath="//a[text()='Search']")
    WebElementFacade CatalogueSearchTab;
    
    @FindBy(xpath="//input[@name='Product_20_ID']")
    WebElementFacade ProductIDTextBox;
    
    @FindBy(xpath="//input[@name='Product_20_ID']")
    WebElementFacade ProductIDTextBoxsync;
    
    @FindBy(xpath="//button[text()='Search']")
    WebElementFacade SearchButton;
    
    @FindBy(xpath="//button[@data-display='Add Item']")
    WebElementFacade AddItemButton;
    
    @FindBy(xpath="//button[@data-display='Add Item']")
    WebElementFacade AddItemButtonsync;
    
    @FindBy(xpath="//button[@title='Orders:New']")
    WebElementFacade NewOrder;
    
    @FindBy(xpath="//td[@id='1_s_4_l_Product']")
    WebElementFacade AfterProductAddLink;
    
    @FindBy(xpath="//a[text()='Line Items']")
    WebElementFacade LineItemsTab;
    @FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
    WebElement Clockobj; 
    
    @Step
    public void CatalogueSearch() throws InterruptedException, IOException, AWTException{
    		Common.waitForPageLoad(getDriver());
    		
    		int CatalogRowCount = '0';
    		
        	String ProductName = Serenity.sessionVariableCalled("PartNo").toString();
        	Common.waitForElement(CatalogueTabWebElement);
        	
           // CatalogueTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
            long startTime = System.currentTimeMillis();
            	  Thread.sleep(5000);	
            	  CatalogueTab.click();
                  
                  if (CatalogueSearchTab.isCurrentlyVisible()) {
                	  Thread.sleep(1000);
                	  WebElement element3 = getDriver().findElement(By.xpath("//a[text()='Search']"));
                	  JavascriptExecutor executor3 = (JavascriptExecutor)getDriver();
     	             executor3.executeScript("arguments[0].click();", element3);
                	  //Common.waitForElement(By.xpath("//a[text()='Search']"));
                	  //getDriver().findElement(By.xpath("//a[text()='Search']")).click();
                	  //CatalogueSearchTab.click();
                	  Thread.sleep(1000);
                  }
                  else if (!CatalogueSearchTab.isCurrentlyVisible()) {
                	  Thread.sleep(3000);
                	  CatalogueSearchTab.click();
                      }
                  
                  Common.WaitForClock(Clockobj);
                  Common.waitForElement(ProductIDTextBoxsync);
                  CatalogRowCount = findAll(By.xpath("//table[@summary='Shopping Cart']/tbody/tr")).size();
                  //String ProductIDTextBoxValue = getDriver().findElement(By.xpath("//input[@name='Product_20_ID']")).getText();
                  getDriver().findElement(By.xpath("//input[@name='Product_20_ID']")).clear();
                  getDriver().findElement(By.xpath("//input[@name='Product_20_ID']")).sendKeys(ProductName);
                  Thread.sleep(1000);
                  getDriver().findElement(By.xpath("//button[text()='Search']")).click();
                  Thread.sleep(2000);
                  if(!getDriver().findElement(By.xpath("//button[@data-display='Add Item']")).isDisplayed())
                  {
                	  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                	  report.Info("Promotion not found");
                	  return;
                  }
                                  
                  Thread.sleep(1000);
                  /*if (!ProductIDTextBoxValue.equals("")){
                	  getDriver().findElement(By.xpath("//input[@name='Product_20_ID']")).clear();
                  }*/
                 /* Thread.sleep(1000);
                  ProductIDTextBox.typeAndEnter(ProductName);*/
                  
                  
	  			  //Common.waitForElement(AddItemButtonsync);
	  			  startTime = System.currentTimeMillis();
	  			  
	  			  Common.WaitForClock(Clockobj);
	  			  
	  			WebElement element3 = getDriver().findElement(By.xpath("//button[@data-display='Add Item']"));
          	  JavascriptExecutor executor3 = (JavascriptExecutor)getDriver();
	             executor3.executeScript("arguments[0].click();", element3);
                  //AddItemButton.click();
                  Common.WaitForClock(Clockobj);
                                 
            int k = 0;
            if (CatalogRowCount < 3){
            do {        	
          	  CatalogRowCount = findAll(By.xpath("//table[@summary='Shopping Cart']/tbody/tr")).size();
          	  if (CatalogRowCount > 1){
          		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          		long endTime = System.currentTimeMillis();
          		long totalTime = endTime - startTime;
          		Common.WritePerformanceOutput("Product Added,Total Time " + totalTime/1000);
          		  break;
          	  }
          	  Thread.sleep(2000);
          	  k++;
            }while(CatalogRowCount<2 && k<80);
            
            if (CatalogRowCount < 2){
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
          	  report.Info("Product is not Added successfully.");
          	  Assert.assertTrue(false);
            } 
            
            if (!LineItemsTab.isDisplayed()){
                getDriver().navigate().refresh();
            }
            return;
            }
            
            do {        	
            	  CatalogRowCount = findAll(By.xpath("//table[@summary='Shopping Cart']/tbody/tr")).size();
            	  if (CatalogRowCount > 3){
            		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            
            		  break;
            	  }
            	  Thread.sleep(2000);
            	  k++;
              }while(CatalogRowCount<4 && k<60);
              
              if (CatalogRowCount < 4){
                sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            	  report.Info("Product is not Added successfully.");
            	  Assert.assertTrue(false);
              } 
              
              /*if (!LineItemsTab.isDisplayed()){
                  getDriver().navigate().refresh();
              } */            
                                       
        }
      
      @FindBy(xpath=".//*[@id='j_s_vctrl_div_tabScreen']")
      WebElementFacade TabDropDown;

        @FindBy(xpath=".//a[text()='Billing profile']")
        WebElementFacade BillingProfilesTab;

    @FindBy(xpath=".//*[@title='Billing profile:Check Payment Date']")
    WebElementFacade checkpaymentDateButton;
    
    @FindBy(xpath=".//a[text()='Profiles']")
    WebElementFacade ProfilesTab;
    

@Step
public void CheckPaymentDate() throws InterruptedException, IOException, AWTException{
 Thread.sleep(5000);
 
 //TabDropDown.selectByVisibleText("Profiles");
 if (TabDropDown.containsText("Profiles")){
       TabDropDown.selectByVisibleText("Profiles");
       report.Info("Profile is Visible under Tab Drop Down");
   }
   else 
   {
	   ProfilesTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();      
       ProfilesTab.click();
       report.Info("Profile is Visible in Outer Tab");       
   }
		 BillingProfilesTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 BillingProfilesTab.click();
		 checkpaymentDateButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 checkpaymentDateButton.click();
		 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 Assert.assertTrue("FAIL, Payment button is disabled ",checkpaymentDateButton.isEnabled());
	}	

@FindBy(xpath=".//*[@id='j_s_vctrl_div_tabScreen']")
WebElementFacade AccountSummaryDropdown;
@FindBy(xpath=".//*[@title='Account Addresses:Delete']")
WebElementFacade AccountAddressDeleteIcon;



@Step
public void AddressesDeleteButtonCheck(String CheckAddressButton) throws InterruptedException, IOException, AWTException {

String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
String dataSheet = "AddressesDeleteButton";
//ReadWorkbook readWorkbook = new ReadWorkbook();
Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(CheckAddressButton, filePath, dataSheet);
readWorkbook.testData(tableMap);

 if (tableMap.get("User").size()==0){
		       	report.Info(CheckAddressButton+" logical name not found in sheet.");
		       	Assert.assertTrue(false);        	
		       }
			   
//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
for (int i = 0  ;i < tableMap.get("User").size();i++){
      String Userfield = tableMap.get("User").get(i);
      
      AccountSummaryDropdown.selectByVisibleText("Addresses");
      //AccountSummaryDropdown.selectByValue("Addresses");
         Thread.sleep(50000);
      
      //AccountAddressDeleteIcon.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();
      
      if (Userfield.equals("FIXED_LINE_1")){
            Assert.assertTrue("AccountAddressDeleteIcon is disabled for Fixed Line USer", AccountAddressDeleteIcon.isCurrentlyEnabled());
      }
      
      if (Userfield.equals("TEST_FRS")){
            Assert.assertTrue("AccountAddressDeleteIcon is disabled for FRS USer.", AccountAddressDeleteIcon.isCurrentlyEnabled());
      }
      
      if (Userfield.equals("TEST_RETAIL_1")){
            Assert.assertFalse("AccountAddressDeleteIcon is enabled for Retail User.", AccountAddressDeleteIcon.isCurrentlyEnabled());
      }
      sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

}
}     

@FindBy(xpath="(.//*[contains(@aria-label,'Selection Field') and (@class='siebui-icon-pick applet-form-pick applet-list-pick')])[8]")
WebElementFacade OpenUserAccountPopup;

@FindBy(xpath="(.//*[@aria-label='Selection Field'])[6]")
WebElementFacade OpenBillingAccountPopup;

@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
WebElementFacade EnterAccountName;

@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']//following-sibling::span")
WebElementFacade EnterAccountNameDropDwon;
@FindBy(xpath="(.//*[@data-lovtype='VF_Account_Pick_Applet:PopupQueryCombobox' and text()='Account name'])")            
WebElementFacade SelectAccountName;



@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")            
WebElementFacade EnterSearchBox;

@FindBy(xpath="//*[@class='siebui-popup-filter']//button[@title='Pick Account:Go']")
WebElementFacade EnterSearchBoxGobutton;

@FindBy(xpath=".//*[@title='Pick Account:OK']")
WebElementFacade EnterSearchBoxOKbutton;

@FindBy(xpath=".//*[@title='Sales Order:Show more']")
WebElementFacade OrdersPageShowMoreButton;

@FindBy(xpath=".//*[@title='Sales Order:Show less']")
WebElementFacade OrdersPageShowLess;

@FindBy(xpath=".//*[@title='Pick Account List Applet']")
WebElementFacade PickAccountlistApplet;

@FindBy(xpath=".//*[@aria-label='Pick Account:Cancel']")
WebElementFacade EnterSearchBoxCancelbutton;

@FindBy(xpath=".//*[@title='Pick Account:OK']")
WebElementFacade Okbutton;
@FindBy(xpath=".//*[@aria-label='Sales Order:Customer Account']")
WebElementFacade CustomerAccountButton;

@FindBy(xpath="(.//*[@aria-label='Selection Field'])[7]")
WebElementFacade OpenBillingProfilePopup;

@FindBy(xpath="(.//*[@title='Billing profile:Cancel'])[2]")
WebElementFacade BillingProfileCancelButton;

@FindBy(xpath=".//*[@title='Billing profile:OK']")
WebElementFacade BillingProfileSearchBoxOKbutton;

@Step
public void OrderBillingServiceAccountSelection(String Account) throws InterruptedException, IOException, AWTException {		      
    String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
    String dataSheet = "BillingServiceAccount";
    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Account, filePath, dataSheet);
    readWorkbook.testData(tableMap);
    
    if (tableMap.get("AccountSelection").size()==0){
       	report.Info(Account+" logical name not found in sheet.");
       	Assert.assertTrue(false);        	
       }
		for (int i = 0  ;i < tableMap.get("AccountSelection").size();i++){
		  String sAccountSelection = tableMap.get("AccountSelection").get(i);
		  String sAccountSet= tableMap.get("AccountSet").get(i);   
		  
		CustomerAccountButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
		if (sAccountSelection.equals("Billing Account")){
		     
			if (OrdersPageShowLess.isVisible() && OpenBillingAccountPopup.isVisible()){	               
		            OpenBillingAccountPopup.click();
		            Thread.sleep(1000);
		            report.Info("Billing Account Popup is clicked successfully");
		      }
		else if (OrdersPageShowMoreButton.isVisible() && !OpenBillingAccountPopup.isVisible()) {
		      OrdersPageShowMoreButton.click();
		      Thread.sleep(1000);
		      OpenBillingAccountPopup.click();                
		      }
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
		     
		if (sAccountSelection.equals("Service Account")){ 
		    if (OrdersPageShowLess.isVisible() && OpenUserAccountPopup.isVisible()){
		        OpenUserAccountPopup.click();
		        report.Info("User Account Popup is clicked successfully");
		    }
		 else if (OrdersPageShowMoreButton.isVisible() && !OpenUserAccountPopup.isVisible()) {
		        OrdersPageShowMoreButton.click();
		        OpenUserAccountPopup.click();                  
				  } 
		    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		 }
		if (PickAccountlistApplet.isCurrentlyVisible()){
			EnterAccountName.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();
			EnterAccountNameDropDwon.click();
			Thread.sleep(1000);
			SelectAccountName.click();
		   // EnterAccountName.sendKeys("Account name");
		    EnterSearchBox.sendKeys(sAccountSet);
		    EnterSearchBox.sendKeys(Keys.chord(Keys.ENTER));
		    //EnterSearchBoxGobutton.click();
		    Thread.sleep(1000);
		  	 //Okbutton.click();
		   // }
		    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
		else if (!PickAccountlistApplet.isCurrentlyVisible()){
			Thread.sleep(1000);
			  PickAccountlistApplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
			  EnterAccountName.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilEnabled();
				EnterAccountNameDropDwon.click();
				Thread.sleep(1000);
				SelectAccountName.click();
			   // EnterAccountName.sendKeys("Account name");
			    EnterSearchBox.sendKeys(sAccountSet);
			    EnterSearchBox.sendKeys(Keys.chord(Keys.ENTER));
			    //EnterSearchBoxGobutton.click();
			    Thread.sleep(1000);
			  	 //Okbutton.click();
		    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}                    
		}
		}
@Step
public void OrderSubAccountsBillingProfileSelection(String Account) throws InterruptedException, IOException, AWTException {
      
      String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
      String dataSheet = "BillingAccountEnableDisable";
      Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Account, filePath, dataSheet);
      readWorkbook.testData(tableMap);
	  
	  if (tableMap.get("Case").size()==0){
		       	report.Info(Account+" logical name not found in sheet.");
		       	Assert.assertTrue(false);        	
		       }
      
      for (int i = 0  ;i < tableMap.get("Case").size();i++){
            String sCase = tableMap.get("Case").get(i);
            
            

            if(sCase.equals("Enabled")) {
            	if (OrdersPageShowMoreButton.isVisible() && OpenBillingAccountPopup.isVisible()){
            		{
            			OpenBillingAccountPopup.click();
            			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            			Assert.assertTrue("Fail, OK Button is Disabled", EnterSearchBoxOKbutton.isEnabled());
            		}

            	}


            	else if (OrdersPageShowMoreButton.isVisible() && !OpenBillingAccountPopup.isVisible()) {
            		    OrdersPageShowMoreButton.click();
            			OpenBillingAccountPopup.click();
            			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            			Assert.assertTrue("Fail, OK Button is Disabled", EnterSearchBoxOKbutton.isEnabled());
            	}
            }
                  
            
            Thread.sleep(2000);
            if(sCase.equals("Disabled"))
            {
            	if (OrdersPageShowLess.isCurrentlyVisible() && OpenBillingAccountPopup.isCurrentlyVisible())
                {
                  Thread.sleep(3000);
                  OpenBillingAccountPopup.click();
                  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                  Assert.assertTrue("Fail, OK Button is Enabled", !EnterSearchBoxOKbutton.isEnabled());
                  Thread.sleep(2000);
                  EnterSearchBoxCancelbutton.click();
                }
              
            	if (OrdersPageShowLess.isCurrentlyVisible() && OpenBillingProfilePopup.isCurrentlyVisible())
                {
                    OpenBillingProfilePopup.click();
                    sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                    Assert.assertTrue("Fail, OK Button is Enabled", !BillingProfileSearchBoxOKbutton.isEnabled());
                    BillingProfileCancelButton.click();  
                }
            	
            else if (OrdersPageShowMoreButton.isCurrentlyVisible() && !OpenBillingAccountPopup.isCurrentlyVisible())                
                  
                  {
                	  	OrdersPageShowMoreButton.click();
                        OpenBillingAccountPopup.click();
                        sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                        Assert.assertTrue("Fail, OK Button is Enabled", !EnterSearchBoxOKbutton.isEnabled());
                  }
            	
            	
                 
              }
      }
}

	@FindBy(xpath=".//*[@aria-label='Installed Assets:Fast Orders']")
 WebElementFacade FastOrdersButton;
 
 @FindBy(xpath="//input[@aria-label='Product Type']")
 WebElementFacade ProductType;
 
 @FindBy(xpath=".//*[@aria-label='Add Remove Products:Go']")
 WebElementFacade ProductTypeGoButton;
 
 @FindBy(xpath=".//*[@aria-label='Add Remove Products:OK']")
 WebElementFacade AddRemoveProductsOKButton;


 
 @Step
 public void FastOrdersProducts(String LocateCol) throws InterruptedException, IOException, AWTException{        
      
       String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
       String dataSheet = "FastOrdersProducts";
       String applet = "//*[@title='Add Remove Products List Applet']";
       String table = "//table[@summary='Add Remove Products']";   
       
       Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(LocateCol, filePath, dataSheet);
       readWorkbook.testData(tableMap);
       Common.WaitForClock(Clockobj);
	          ProductTypeGoButton.withTimeoutOf(60,TimeUnit.SECONDS).waitUntilClickable();
	          String sProductType = tableMap.get("ProductType").get(0); 
	          ProductType.type(sProductType);
	          ProductTypeGoButton.click();
	          sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	          Common.WaitForClock(Clockobj);
       
       for (int i = 0;i < tableMap.get("LocateCol").size();i++) {
       	    	
   	   	String sLocateCol = tableMap.get("LocateCol").get(i);
   		String sLocateColValue = tableMap.get("LocateColValue").get(i);
   		String sUIName = tableMap.get("UIName").get(i);
   		String sValue = tableMap.get("Value").get(i);

   		String Index = "0";
   		
   	//NewOrder.click();
   		
   		
   		if (!sLocateCol.equals("")){
             Common.selectedRow = -1;
            Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
            report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           
            sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
             }
        else{
              Common.selectedRow = 1;
        }
         	if (!sUIName.equals("")){ 
             Common.updateSiebList(applet,table, sUIName, sValue);
             sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
             report.Info("Row updated successfully"); 
             }
       }
         	AddRemoveProductsOKButton.click();	
         	Common.WaitForClock(Clockobj);
       
   }
 
 
 @Step
 public void SubAccountBillingAccountNameSelection(String Account) throws InterruptedException, IOException, AWTException{        
      
       String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
       String dataSheet = "BillingAccountNameSelection";
       String applet = "//*[@title='User Accounts List Applet']";
       String table = "//table[@summary='User Accounts']";
       
       Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Account, filePath, dataSheet);
       readWorkbook.testData(tableMap);
       
       for (int i = 0;i < tableMap.get("LocateCol").size();i++) {    	
   	   	String sLocateCol = tableMap.get("LocateCol").get(i);
   		String sLocateColValue = tableMap.get("LocateColValue").get(i);
   		String sUIName = tableMap.get("UIName").get(i);
   		String sValue = tableMap.get("Value").get(i);
   		

   		String Index = "0";
   		
   		
   		/*if (!sLocateCol.equals("")){
             Common.selectedRow = -1;
            Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
            report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           

             }
        else{*/
              Common.selectedRow = 1;
       // }
         	if (!sUIName.equals("")){ 
             Common.updateSiebList(applet,table, sUIName, sValue);
             Thread.sleep(3000);
             report.Info("Row updated successfully"); 
             sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
             }
         
         	
         	
       }
   }
        @FindBy(xpath=".//*[@title='Billing profile:Check Payment Date']")
        WebElementFacade CheckPaymentDate;
 
 @Step
 public void BillingProfileNameSelection(String RowName) throws IOException, InterruptedException, AWTException{
 	String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
     String dataSheet = "BillingProfileNameSelection";
     String applet = "//*[@title='Billing profile List Applet']";
     String table = "//table[@summary='Billing profile']";  
     String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
    
     
     Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(RowName, filePath, dataSheet);
     readWorkbook.testData(tableMap);
     
     if (ProfilesTab.isPresent())
     {
     ProfilesTab.click();
     }
     else
     {
     TabDropDown.selectByVisibleText("Profiles");
     }
     
     BillingProfilesTab.click();
     
     
     for (int i = 0;i < tableMap.get("Row").size();i++) {
    	 
 	   	String sLocateCol = tableMap.get("LocateCol").get(i);
 		String sLocateColValue = tableMap.get("LocateColValue").get(i);
 		String UIName = tableMap.get("UIName").get(i);
 		String value = tableMap.get("Value").get(i);
 		String Index = tableMap.get("Index").get(i);
 		String sCheckPaymentDate = tableMap.get("CheckPaymentDate").get(i);
 		String sPopup =  tableMap.get("PopUp").get(i);
 
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
        	//Thread.sleep(5000);
            Common.updateSiebList(applet,table, UIName, value);           
             
            }
        	if  (!sCheckPaymentDate.equals("")){
             	 
             	CheckPaymentDate.click();
             	report.Info("Payment Date button clicked successfully");
             	if(!sPopup.equals("")){
             		    Common.HandleErrorPopUp(sPopup);                            
	            	}  
	            	else
	            		 Assert.assertTrue("Expected pop-up did not occur", false);        	                 
               }
     	}	
     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     
     
     
     
 }

 @FindBy(xpath="//a[text()='Real Time Balance']")
 WebElementFacade RealTimeBalanceTab;
@FindBy(xpath=".//*[@title='Mobile phone service']")
WebElementFacade ProductValue;
@FindBy(xpath=".//*[@title='Balance Details:Full Balance']")
WebElementFacade FullBalanceButton;
@FindBy(xpath=".//*[@title='Balance Details:Monetary Balance']")
WebElementFacade MonetaryBalanceButton;

@Step
public void MonetaryBalanceCheck(String RowName) throws IOException, InterruptedException, AWTException{
	String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
 String dataSheet = "MonetaryBalance";
 String applet = "//*[@title='Balance Details List Applet']";
 String table = "//table[@summary='Balance Details']";


 
 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(RowName, filePath, dataSheet);
 readWorkbook.testData(tableMap);
 

 for (int i = 0;i < tableMap.get("Size").size();i++) {
 String sSelectItem = tableMap.get("SelectItem").get(i);
 String sPart = tableMap.get("Part").get(i);
 String sClickButton = tableMap.get("ClickButton").get(i);
 String sCheckProductName = tableMap.get("CheckProductName").get(i);
 
   	String sLocateCol = tableMap.get("LocateCol").get(i);
	String sLocateColValue = tableMap.get("LocateColValue").get(i);
	String UIName = tableMap.get("UIName").get(i);
	String value = tableMap.get("Value").get(i);
	String Index = tableMap.get("Index").get(i);
	

 if (Index.equals("")){
   	 Index = "0";
    }
    
 if (sSelectItem.equals("RootProduct0")){
	 sSelectItem = Serenity.sessionVariableCalled("RootProduct0").toString();
	     }

 RealTimeBalanceTab.click();
 
 int RowCount = findAll(By.xpath("//table[@summary='Product / Services']/tbody/tr")).size();
 
 if(RowCount>1){
	 Assert.assertTrue("fail - No rows displayed.Real Time Balance tab is not clicked successfully .", RowCount>1);
	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	report.Info("Pass - Rows are displayed.");
 }
 
 String StrValue=ProductValue.getTextValue();
 Assert.assertTrue("Fail: Item "+ sSelectItem +" is not present", sSelectItem.contains(StrValue));
 Common.locateColumn("//*[@title='Product / Services List Applet']","//table[@summary='Product / Services']","Product_Name", "Mobile phone service", Index);
 
 if(sClickButton.equalsIgnoreCase("FullBalance")){
	 FullBalanceButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	 FullBalanceButton.click();
	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 }
 if(sClickButton.equalsIgnoreCase("MonetaryBalance")){
	 MonetaryBalanceButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	 MonetaryBalanceButton.click();
 }
if(value.equalsIgnoreCase("Validation")){
	 String UsageBalance = "";
     Common.selectedRow = 1;
     UsageBalance=Common.updateSiebList(applet,table, "CaptureTextValue|Available_Quantity", UsageBalance);
     Assert.assertTrue("FAil: Balance not Present", !UsageBalance.equals(""));
     report.Info("Pass: Usage Balance Present ");
     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
     
	
      	 String prevRecord = "";
      	 String currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
			do{
				prevRecord = currRecord;
      	 getDriver().findElement(By.xpath(applet+"//*[@title='Next record set']")).click();
			currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
		} while (!currRecord.equals(prevRecord));
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
}
 if(sCheckProductName.equalsIgnoreCase("Yes")){
    if (!sLocateCol.equals("")){
        Common.selectedRow = -1;
        Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
        report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           

            }
       else{
             Common.selectedRow = 1;
       }
     }
 if (!UIName.equals("")){  
	 Common.selectedRow = 1; 
     Common.updateSiebList(applet,table, UIName, value);
     Thread.sleep(2000);
     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
 }

   }	
}
@FindBy(xpath="(.//div[contains(@title,'List Applet') and @class='siebui-applet siebui-collapsible-applet siebui-list Selected siebui-active siebui-applet-active siebui-hilight'])")
WebElementFacade PickAccountlistAppletNew;
@FindBy(xpath="(.//*[@aria-label='Selection Field'])[7]")
WebElementFacade BillingProfileOpenPopup;
@FindBy(xpath=".//button[@title='Billing profile:Query']")
WebElementFacade PickAccountQueryButton;
@FindBy(xpath="(.//*[@title='Billing profile:Go'])[1]")
WebElementFacade PickAccountSearchGoButton;

@FindBy(xpath=".//button[contains(@title,'OK') and contains(@class,'appletButton')]")
WebElementFacade EnterSearchGobutton;

@Step
public void OrderBillingProfileSelection(String Account) throws InterruptedException, IOException, AWTException {		      
    String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
    String dataSheet = "BillingServiceAccount";
    
    String applet = "//*[@title='Billing profile List Applet']";
    String table = "//table[@summary='Billing profile']";
    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Account, filePath, dataSheet);
    readWorkbook.testData(tableMap);
    
    if (tableMap.get("Size").size()==0){
       	report.Info(Account+" logical name not found in sheet.");
       	Assert.assertTrue(false);        	
       }
		for (int i = 0  ;i < tableMap.get("Size").size();i++){
		  
		 
	       String Index = tableMap.get("Index").get(i);
	       String sBillingProSelect = tableMap.get("BillingProSelect").get(i);
	       String UIName = tableMap.get("UIName").get(i);
			  String value = tableMap.get("Value").get(i);
		
          
          if (Index.equals("")){
        	  Index = "0";
        }
		 
		
		if(sBillingProSelect.equalsIgnoreCase("Yes")){
			if (OrdersPageShowLess.isDisplayed() && OpenBillingAccountPopup.isDisplayed()){	               
				BillingProfileOpenPopup.click();
	            Thread.sleep(1000);
	            report.Info("Billing Profile open Popup is clicked successfully");
	      }
			else if (OrdersPageShowMoreButton.isDisplayed() && !OpenBillingAccountPopup.isDisplayed()) {
			      OrdersPageShowMoreButton.click();
			      Thread.sleep(1000);
			      BillingProfileOpenPopup.click();                
			      }
			
			PickAccountlistAppletNew.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
			PickAccountQueryButton.click();
			Common.selectedRow = 1;
			if (!UIName.equals("")){ 
		    	Thread.sleep(2000);
		    	PickAccountSearchGoButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
		    	Common.updateSiebList(applet,table, UIName, value);           
		        Thread.sleep(1000);
		        PickAccountSearchGoButton.click();
		        Thread.sleep(2000);
		        sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		        EnterSearchGobutton.click();
		        Thread.sleep(1000);
		        CustomerAccountButton.withTimeoutOf(160,TimeUnit.SECONDS).waitUntilClickable();
				
			}  
			
		
	       /*if (!sLocateCol.equals("")){
	         Common.selectedRow = -1;
	         Assert.assertTrue(LocateColMessege, Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
	         report.Info(sLocateCol+"Billing profile applet found using Locate Col");
	         sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	       }
	       else 
	       {
	        Common.selectedRow = 1;
	        report.Info("Customer summary applet found");
	       }//report.Info(sLocateCol+" found");
	       Thread.sleep(2000);
	       //BillingProfileOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	       BillingProfileOkButton.click();*/
		}
		
		
		}
		}
		@FindBy(xpath=".//li/a[text()='Bundle Usage']")
		WebElementFacade BundleUsageTab;
		@Step
		public void CheckUsage(String rowname) throws IOException, AWTException, InterruptedException{
		String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
		String dataSheet = "MonetaryBalance";
		String applet = "//*[@title='Balance List Applet']";
		String table = "//table[@summary='Balance']";
		
		
		
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		
		
		for (int i = 0;i < tableMap.get("Size").size();i++) {
		String sSelectItem = tableMap.get("SelectItem").get(i);
		String sLocateCol = tableMap.get("LocateCol").get(i);
		String sLocateColValue = tableMap.get("LocateColValue").get(i);
		String value = tableMap.get("Value").get(i);
		String Index = tableMap.get("Index").get(i);
		String Usage = tableMap.get("Usage").get(i);
		
		if (Index.equals("")){
		Index = "0";
		}
		
		BundleUsageTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		BundleUsageTab.click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		
		int RowCount = findAll(By.xpath("//table[@summary='Balance']/tbody/tr")).size();
		
		if(RowCount>1){
		Assert.assertTrue("fail - No rows displayed, Bundle Usage tab is not clicked successfully .", RowCount>1);
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		report.Info("Pass - Rows are displayed.");
		}
		if(Usage.equalsIgnoreCase("Yes")){
		String UsageBalance = "";
		Common.selectedRow = 1;
		UsageBalance=Common.updateSiebList(applet,table, "CaptureTextValue|Usage", UsageBalance);
		Assert.assertTrue("FAil: Usage Balance not Present", !UsageBalance.equals(""));
		report.Info("Pass: Usage Balance Present ");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		
		}
		if(value.equalsIgnoreCase("Validation")){
		String prevRecord = "";
		String currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
		do{
		prevRecord = currRecord;
		getDriver().findElement(By.xpath(applet+"//*[@title='Next record set']")).click();
		currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
		} while (!currRecord.equals(prevRecord));
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
		}
		}
		
		
		@FindBy(xpath=".//*[text()='Adjustments']")
		WebElementFacade AdjustmentTab;
		
		@FindBy(xpath=".//*[@title='Product / Services:Credit Funds']")
		WebElementFacade CreditFunds;
		
		@FindBy(xpath=".//*[@title='Product / Services:Debit Funds']")
		WebElementFacade DebitFunds;
		
		@FindBy(xpath=".//*[@aria-label='Adjustment reason']")
		WebElementFacade Adjustmentreason;
		
		@FindBy(xpath=".//*[@aria-label='Authorisation amount']")
		WebElementFacade AuthorisationAmount;
		
		@FindBy(xpath=".//*[@aria-label='Adjustment Type']")
		WebElementFacade AdjustmentType;
		
		@FindBy(xpath=".//*[@title='Submit']")
		WebElementFacade AdjustmentSubmit;
		
		
		@Step
		public void CreditDebitAdjustments(String rowname) throws IOException, AWTException, InterruptedException{
			String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
			String dataSheet = "CreditDebitAdjustment";
			String applet = "//*[@title='Adjustment Activities List Applet']";
			String table = "//table[@summary='Adjustment Activities']";



			Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
			readWorkbook.testData(tableMap);


			for (int i = 0;i < tableMap.get("RowNo").size();i++) {
				String sAdjustmentType = tableMap.get("AdjustmentType").get(i);
				String sLocateCol = tableMap.get("LocateCol").get(i);
				String sLocateColValue = tableMap.get("LocateColValue").get(i);
				String value = tableMap.get("Value").get(i);
				String sAdjustmentReason = tableMap.get("AdjustmentReason").get(i);
				String sAdjustmentAmount = tableMap.get("AdjustmentAmount").get(i);
				String sPopup = tableMap.get("Popup").get(i);
				String UIName = tableMap.get("UIName").get(i);
				String Index = tableMap.get("Index").get(i);

				if (Index.equals("")){
					Index = "0";

				}

				if(AdjustmentTab.isVisible()){
					AdjustmentTab.click();	
					report.Info("Adjustment tab clicked successfully");
				}

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if(sAdjustmentType.equalsIgnoreCase("Credit")){
					CreditFunds.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					CreditFunds.click();
					report.Info("Credit Funds Button clicked successfully");
				}

				if(sAdjustmentType.equalsIgnoreCase("Debit")){
					DebitFunds.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					DebitFunds.click();
					report.Info("Debit Funds Button clicked successfully");
				}

				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				if(!sAdjustmentReason.equalsIgnoreCase("")){
					Adjustmentreason.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
					Adjustmentreason.type(sAdjustmentReason);
					AuthorisationAmount.type(sAdjustmentAmount);
					AdjustmentType.click();
					AdjustmentSubmit.click();
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}


				if(!sPopup.equalsIgnoreCase("")){
					Common.HandleErrorPopUp(sPopup); 
				}


				if (!sLocateCol.equals("")){
					Common.selectedRow = -1;
					Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index).equals("true"));
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				}
				else {
					Common.selectedRow = 1;
				}
				
				if (!UIName.equals("")){  
					//Common.selectedRow = 1;
					Common.updateSiebList(applet,table, UIName, value);
					//Thread.sleep(2000);
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				}
			}
		}
			@FindBy(linkText="Itemised Usage")
			WebElementFacade ItemisedUsageTab;
			@FindBy(xpath=".//*[text()=\'Unbilled Usage\']")
			WebElementFacade PrepayUnbilledUsageTab;

			@Step
			public void  EventLevelMSISDNSelect_fn(String BillingProfileType) throws InterruptedException, IOException, AWTException{

				String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
				String dataSheet = "Bills_Adjustments";
				String applet = "//*[@title='Services List Applet']";
				String table = "//table[@summary='Services']";

				Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				for (int i = 0;i < tableMap.get("RowNo").size();i++) {

					String sLocateCol = tableMap.get("LocateCol").get(i);
					String sPrepaidUsage = tableMap.get("PrepaidUsage").get(i);
					String iIndex = tableMap.get("Index").get(i);


					if(sPrepaidUsage.equals("")){
						ItemisedUsageTab.withTimeoutOf(120, TimeUnit.SECONDS).isVisible();
						ItemisedUsageTab.click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}

					else {
						PrepayUnbilledUsageTab.withTimeoutOf(120, TimeUnit.SECONDS).isVisible();
						PrepayUnbilledUsageTab.click();
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}

					if(iIndex.equals("")){

						iIndex = "0";
					}

					String sLocateColValue = Serenity.sessionVariableCalled("ACCNTMSISDN0").toString();

					if (!sLocateCol.equals("")){
						Common.selectedRow = -1;
						Common.locateColumn(applet,table, sLocateCol, sLocateColValue, iIndex);
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}                   	
				} 
			}

			@Step
			public void  EventLevelAdjustment_fn(String BillingProfileType) throws InterruptedException, IOException, AWTException{

				String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
				String dataSheet = "Bills_Adjustments";
				String applet = "//*[@title='Summary Charges List Applet']";
				String table = "//table[@summary='Summary Charges']";

				Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
				for (int i = 0;i < tableMap.get("RowNo").size();i++) {

					String sLocateColValue = tableMap.get("LocateColValue").get(i); 
					String sLocateCol = tableMap.get("LocateCol").get(i);
					String iIndex = tableMap.get("Index").get(i);
					String UIName = tableMap.get("UIName").get(i);
					String value = tableMap.get("Value").get(i);

					if(iIndex.equals("")){

						iIndex = "0";
					}

					if (!sLocateCol.equals("")){
						Common.selectedRow = -1;
						Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, iIndex).equals("true"));
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}

					if (!UIName.equals("")){   
						Common.updateSiebList(applet,table, UIName, value);
						Thread.sleep(4000); 

					}


				} 
			}
			@Step
			public void  ItemisedListSelectionClickAdjust(String BillingProfileType) throws InterruptedException, IOException, AWTException{

				String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
				String dataSheet = "Bills_Adjustments";
				String applet = "//*[@title='Itemised List List Applet']";
				String table = "//table[@summary='Itemised List']";

				Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
				for (int i = 0;i < tableMap.get("RowNo").size();i++) {

					String sLocateColValue = tableMap.get("LocateColValue").get(i); 
					String sLocateCol = tableMap.get("LocateCol").get(i);
					String iIndex = tableMap.get("Index").get(i);
					if(iIndex.equals("")){

						iIndex = "0";
					}

					if (!sLocateCol.equals("")){
						Common.selectedRow = -1;
						report.Info("Event View Shown");
						Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, iIndex).equals("true"));
						sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
					else{
						Common.selectedRow = 1;
					}
					
				} 
		}
			@FindBy(xpath=".//a[text()='TopUp History']")
			WebElementFacade TopUpHistoryTab;
			@FindBy(xpath=".//button[@title='TopUp History:Get Topups']")
			WebElementFacade GetTopUpButton;

			@Step
			public void  TopUpHistory(String BillingProfileType) throws InterruptedException, IOException, AWTException{
				String filePath = "\\src\\test\\resources\\data\\Catalog.xls";
				String dataSheet = "TopUpHistory";
				String table = "//table[@summary='TopUp History']";
				String applet = "//*[@title='TopUp History List Applet']";

				Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
				readWorkbook.testData(tableMap);
				Common.waitForPageLoad(getDriver());
				Thread.sleep(1000);
				if (TopUpHistoryTab.isCurrentlyVisible()){
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					TopUpHistoryTab.click();
				}
				else {
					report.Info("TopUp History tab is not displayed.");
					Assert.assertTrue(false);
				}

				Common.waitForPageLoad(getDriver());
				Thread.sleep(4000);

				if (GetTopUpButton.isCurrentlyVisible()){
					GetTopUpButton.click();
				}
				else{
					report.Info("TopUp History tab is not clicked successfully.");
					Assert.assertTrue(false);
				}
				for (int i = 0;i < tableMap.get("RowNo").size();i++) {
					String sLocateCol = tableMap.get("LocateCol").get(i);
					String sLocateColValue = tableMap.get("LocateColValue").get(i);
					String UIName = tableMap.get("UIName").get(i);
					String value = tableMap.get("Value").get(i);
					String Index = tableMap.get("Index").get(i);

					Thread.sleep(1000);
					//String LocateColMessege = sLocateCol+"Not Found";
					if (Index.equals("")){
						Index = "0";
					}
					if (value.equals("TOPUP")){
						value = Serenity.sessionVariableCalled("RateGBP").toString();

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
						Thread.sleep(2000);                                                                          
					}     


				}
			}
			
			@Step
		    public void CatalogueSearchValidation() throws InterruptedException, IOException, AWTException{
		    		Common.waitForPageLoad(getDriver());
		    		
		    		int CatalogRowCount = '0';
		    		
		        	String ProductName = Serenity.sessionVariableCalled("PartNo").toString();
		        	Common.waitForElement(CatalogueTabWebElement);
		        	
		           // CatalogueTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		            long startTime = System.currentTimeMillis();
		            	  Thread.sleep(5000);	
		            	  CatalogueTab.click();
		                  
		                  if (CatalogueSearchTab.isCurrentlyVisible()) {
		                	  Thread.sleep(1000);
		                	  WebElement element3 = getDriver().findElement(By.xpath("//a[text()='Search']"));
		                	  JavascriptExecutor executor3 = (JavascriptExecutor)getDriver();
		     	             executor3.executeScript("arguments[0].click();", element3);
		                	  //Common.waitForElement(By.xpath("//a[text()='Search']"));
		                	  //getDriver().findElement(By.xpath("//a[text()='Search']")).click();
		                	  //CatalogueSearchTab.click();
		                	  Thread.sleep(1000);
		                  }
		                  else if (!CatalogueSearchTab.isCurrentlyVisible()) {
		                	  Thread.sleep(3000);
		                	  CatalogueSearchTab.click();
		                      }
		                  
		                  Common.WaitForClock(Clockobj);
		                  Common.waitForElement(ProductIDTextBoxsync);
		                  CatalogRowCount = findAll(By.xpath("//table[@summary='Results']/tbody/tr")).size();
		                  //String ProductIDTextBoxValue = getDriver().findElement(By.xpath("//input[@name='Product_20_ID']")).getText();
		                  getDriver().findElement(By.xpath("//input[@name='Product_20_ID']")).clear();
		                  getDriver().findElement(By.xpath("//input[@name='Product_20_ID']")).sendKeys(ProductName);
		                  Thread.sleep(1000);
		                  getDriver().findElement(By.xpath("//button[text()='Search']")).click();
		                  Thread.sleep(2000);
		                  
		                  if (CatalogRowCount < 1){
		                      sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		                  	  report.Info("Promotion not found successfully from FUT Login");
		                  	  Assert.assertTrue(false);
		                    }
			}
}	
	

