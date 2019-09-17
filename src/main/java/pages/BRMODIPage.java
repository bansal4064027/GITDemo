package pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import utilities.SikuliUtility;

import utilities.ReadWorkbook;
import utilities.ReportMessege;


import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


public class BRMODIPage  extends PageObject{
	private static final TimeUnit SECONDS = null;
	@Steps
	private ReadWorkbook readWorkbook;
	
	@Steps
	private SikuliUtility SikuliUtility;
	

	
	String SikulifilePath = "\\src\\test\\resources\\BRM_Snapshot";

	@Steps
	ReportMessege report;
   public static WebDriver driver = null;
	
   String SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
   
    @FindBy(xpath=".//*[@id='pt1:repository_alias::content']")
    WebElementFacade ODIRepository;
    
    @FindBy(xpath=".//*[@id='pt1:j_username::content']")
    WebElementFacade ODIUsername;
    
    @FindBy(xpath=".//*[@id='pt1:j_password::content']")
    WebElementFacade ODIPassword;
    
    @FindBy(xpath=".//*[@id='pt1:login']")
    WebElementFacade ODILoginButton;
    
    @FindBy(xpath=".//*[@id='shell:logout']")
    WebElementFacade LogoutButton;

    @Step
    public void LoginToODI(String rowName,String Environment) throws IOException, InterruptedException, AWTException, FindFailed {          

    	String filePath = "\\src\\test\\resources\\data\\Account.xls";
    	String dataSheet = "LoginToSiebel";
    	//ReadWorkbook readWorkbook = new ReadWorkbook();
    	Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Environment, filePath, dataSheet);
    	readWorkbook.testData(tableMap);
    	//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
    	for (int i = 0  ;i < tableMap.get("Username").size();i++) {

    		String BRMEnv = tableMap.get("EnvURL").get(i);
    		System.out.println("BRMEnv is :- " +BRMEnv);
    		Serenity.setSessionVariable("Environment").to(BRMEnv);
    	}

    	 filePath = "\\src\\test\\resources\\data\\ODI.xls";
    	 dataSheet = "LoginToODI";
        
        tableMap = readWorkbook.readRow(rowName, filePath, dataSheet);
        readWorkbook.testData(tableMap);
        for (int i = 0  ;i < tableMap.get("RowNo").size();i++) {
              String username = tableMap.get("Username").get(i);
              String password = tableMap.get("Password").get(i);    
              //Serenity.setSessionVariable("Environment").to("E7");
              //Environment = Serenity.sessionVariableCalled("Environment").toString();   
              
              String URL = tableMap.get(Serenity.sessionVariableCalled("Environment").toString()).get(i);  
              String currentDir = System.getProperty("user.dir");
              getDriver().quit();
  			  openAt(URL);

  			getDriver().manage().window().maximize();
              /*driver = new FirefoxDriver();

              driver.get(URL);*/
   
  			getDriver().findElement(By.xpath(".//input[@id='pt1:j_username::content']")).click();
  			getDriver().findElement(By.xpath(".//input[@id='pt1:j_username::content']")).sendKeys(username);
  			getDriver().findElement(By.xpath(".//*[@id='pt1:j_password::content']")).sendKeys(password);
  			getDriver().findElement(By.xpath(".//*[@id='pt1:login']")).click();       
              Thread.sleep(5000);
              SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              report.Info("Login Button click");
                    Assert.assertTrue("Login Failed", getDriver().findElement(By.xpath(".//*[@id='shell:logout']")).isDisplayed());
                    report.Info("Login Page is displayed successfully");
        }

}


	@Step
	public void  ExecuteScenario_fn(String BillingProfileType) throws InterruptedException, IOException, AWTException{
	 	 
		String filePath = "\\src\\test\\resources\\data\\ODI.xls";
 	 	String dataSheet = "ExecuteScenario";  	 
 	 	Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
	     for (int i = 0;i < tableMap.get("RowNo").size();i++) {      	    	 
	    	                 	
      	String  sAgent = tableMap.get("Agent").get(i);  
      	String  sContext = tableMap.get("Context").get(i);
      	String  sLogLevel = tableMap.get("LogLevel").get(i);
      	String  sDocStoreValue = tableMap.get("DocStoreValue").get(i);
      	String  sSlot1 = tableMap.get("Slot1").get(i);
      	String  sSlot2 = tableMap.get("Slot2").get(i);
      	
      	WebDriverWait wait = new WebDriverWait(getDriver(),120);
       	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='shell:dialogRegion:1:execscen_agent::content']")));
       	Thread.sleep(2000);
 
       	getDriver().findElement(By.xpath(".//*[@id='shell:dialogRegion:1:execscen_agent::content']")).sendKeys(sAgent);
       	Thread.sleep(1000);
       	getDriver().findElement(By.xpath(".//*[@id='shell:dialogRegion:1:execscen_context::content']")).sendKeys(sContext);
       	Thread.sleep(1000);
       	getDriver().findElement(By.xpath(".//*[@id='shell:dialogRegion:1:execscen_loglevel::content']")).sendKeys(sLogLevel);
      	
      	if(sDocStoreValue.equals("Y")){
      		getDriver().findElement(By.xpath(".//*[@id='shell:dialogRegion:1:exescen_vars:0:it_varvalue::content']")).sendKeys(sSlot1);
      		getDriver().findElement(By.xpath(".//*[@id='shell:dialogRegion:1:exescen_vars:1:it_varvalue::content']")).sendKeys(sSlot2);   		
      	}
      	
      	report.Info("All details setup according to selected scenario");
      	SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
      	getDriver().findElement(By.xpath(".//*[@id='shell:dialogRegion:1:p_executeScenario']")).click();   	
      	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(text(),'Scenario submitted')]")));
      	if(getDriver().findElement(By.xpath(".//*[@id='shell:dialogRegion:1:p_executeScenario']")).isDisplayed()){      	
	      	String TextMassage = getDriver().findElement(By.xpath(".//*[contains(text(),'Scenario submitted successfully')]")).getText();
	      	String[] SessionId =TextMassage.split(":");
	      	Serenity.setSessionVariable("SessionId0").to(SessionId[1]);
	      	report.Info("Scenario submitted successfully. Created session with id: " +SessionId[1]);
	      	SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
	      	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='d1::msgDlg::cancel']")));
	      	getDriver().findElement(By.xpath(".//*[@id='d1::msgDlg::cancel']")).click();
	      	Thread.sleep(1000);
	      	getDriver().findElement(By.xpath(".//button[@id='shell:dialogRegion:1:execscen_cb11']")).click();
      	}
      	else{
      		report.Info("Scenario PopUp is not visible");
      		Assert.assertTrue(false);
      	}
  }     
	}
	
	
	@Step
	public void  BrowseScenarios_fn(String BillingProfileType) throws InterruptedException, IOException, AWTException{
	  	 
		String filePath = "\\src\\test\\resources\\data\\ODI.xls";
  	 	String dataSheet = "BrowseScenarios";  	 
  	 	Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
	     for (int i = 0;i < tableMap.get("RowNo").size();i++) {      	    	 
	    	                 	
       	String  sScenario = tableMap.get("Scenario").get(i);              	
       	WebDriverWait wait = new WebDriverWait(getDriver(),120);
       	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='shell:browse_region:0:browsertree:0::di']")));       	
       	
       	if(getDriver().findElement(By.xpath(".//*[@id='shell:browse_region:0:browsertree:0::di']")).isDisplayed()){       		
       		getDriver().findElement(By.xpath(".//*[@id='shell:browse_region:0:browsertree:0::di']")).click();
       	}
       	else{
       		report.Info("RunTimeExpand element not visisble");
       		SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
       		Assert.assertTrue(false);
       	}
       	
       	Thread.sleep(3000);
       	if (getDriver().findElement(By.xpath(".//*[@id='shell:browse_region:0:browsertree:3::di']")).isDisplayed()){       		
       		getDriver().findElement(By.xpath(".//*[@id='shell:browse_region:0:browsertree:3::di']")).click();
       	}
       	else{
       		report.Info("BrowseScenariosExpand element not visisble");
       		SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
       		Assert.assertTrue(false);
       	}
       	Thread.sleep(2000);
       	if (getDriver().findElement(By.xpath(".//*[@id='shell:browse_region:0:browsertree:5::di']")).isDisplayed()){       		
       		getDriver().findElement(By.xpath(".//*[@id='shell:browse_region:0:browsertree:5::di']")).click();
       		Thread.sleep(2000);
       	}    	
       	else{
       		report.Info("BrowseScenariosSelection element not visisble");
       		SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
       		Assert.assertTrue(false);
       	}
       	
       	if(sScenario.equals("CREDITALERTING - 002")){
    		if (getDriver().findElement(By.xpath(".//span[contains(text(),'CREDITALERTING - 002')]")).isDisplayed()){       		
    			getDriver().findElement(By.xpath(".//span[contains(text(),'CREDITALERTING - 002')]")).click();
           		Thread.sleep(2000);
           	} 
       	else{
       		report.Info("CREDITALERTING_002 element not visisble");
       		SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
       		Assert.assertTrue(false);
       	}
    	
    	}
    	if(sScenario.equals("DOCSTORE - 002")){
    		if (getDriver().findElement(By.xpath(".//span[contains(text(),'DOCSTORE - 002')]")).isDisplayed()){       		
    			getDriver().findElement(By.xpath(".//span[contains(text(),'DOCSTORE - 002')]")).click();
           		Thread.sleep(2000);
           	} 
           	else{
           		report.Info("DOCSTORE_002 element not visisble");
           		SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
           		Assert.assertTrue(false);
           	}        	
        	}
    	
    	if(sScenario.equals("ADDACS_SCEN")){
    		if (getDriver().findElement(By.xpath(".//span[contains(text(),'ADDACS_SCEN - 002')]")).isDisplayed()){       		
    			getDriver().findElement(By.xpath(".//span[contains(text(),'ADDACS_SCEN - 002')]")).click();
           		Thread.sleep(2000);
           	} 
       	else{
       		report.Info("ADDACS_SCEN element not visisble");
       		SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
       		Assert.assertTrue(false);
       	}
    	
    	}
    	if(sScenario.equals("AUDDIS_SCEN")){
    		if (getDriver().findElement(By.xpath(".//span[contains(text(),'AUDDIS_SCEN - 002')]")).isDisplayed()){       		
    			getDriver().findElement(By.xpath(".//span[contains(text(),'AUDDIS_SCEN - 002')]")).click();
           		Thread.sleep(2000);
           	} 
           	else{
           		report.Info("AUDDIS_SCEN element not visisble");
           		SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
           		Assert.assertTrue(false);
           	}        	
        	}
  
    	if (getDriver().findElement(By.xpath(".//*[@id='shell:browse_region:0:ctb8_mainTab::icon']")).isDisplayed()){       		
    		getDriver().findElement(By.xpath(".//*[@id='shell:browse_region:0:ctb8_mainTab::icon']")).click();
       		Thread.sleep(2000);
       	}    
       	else{
       		report.Info("ExecuteButton element not visisble");
       		SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
       		Assert.assertTrue(false);
       	}
   }
	}
	
	
	@FindBy(xpath=".//a[text()='Sessions']")
	WebElementFacade SessionTab;
	
	@FindBy(xpath=".//*[@id='shell:regtab1:0:sessionsearchbutton']")
	WebElementFacade SearchButton;
	
	@FindBy(xpath=".//*[@id='shell:regtab1:0:search_sessionId::content']")
	WebElementFacade SessionIdTextBox;
	
	@FindBy(xpath=".//*[@src='/odiconsole/resources/images/approved.png']")
	WebElementFacade SuccessImage;
	
	@FindBy(xpath=".//*[@title='Expand Search Form']']")
	WebElementFacade Expand_Search_Form;
	
	
	@SuppressWarnings("deprecation")
	@Step
	
	public void  SearchSessionStatus_fn() throws InterruptedException, IOException, AWTException, FindFailed{
		 
		String SessionIDCapture = Serenity.sessionVariableCalled("SessionId0").toString();
		Thread.sleep(4000);
		getDriver().findElement(By.xpath(".//a[text()='Sessions']")).click();
		Thread.sleep(3000);
		String Flag = "N";
		getDriver().findElement(By.xpath(".//*[@id='shell:regtab1:0:search_sessionId::content']")).click();
		Screen sc = new Screen();
		sc.type(SessionIDCapture);
		report.Info("Session id : "+SessionIDCapture);
		Thread.sleep(2000);
		getDriver().findElement(By.xpath(".//button[text()='Search']")).click();
		
		for (int i = 0; i < 10; i++) {
			Thread.sleep(2000);
			if (getDriver().findElement(By.xpath(".//img[@title='Done']")).isDisplayed()){
				SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
				Flag = "Y";
				break;
			}
			else {
				getDriver().findElement(By.xpath(".//*[@title='Expand Search Form']")).click();
				Thread.sleep(1000);
				getDriver().findElement(By.xpath(".//button[text()='Search']")).click();
			}			
		}
		
		if(Flag.equals("N")){
			report.Info("Session is not passed");
			SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
			Assert.assertTrue(false);
		}
		
	}
	
	
	@FindBy(xpath=".//*[@id='MENU_A_SEARCH']/a")
	WebElementFacade ClickOnSearch;
	
	@FindBy(linkText ="Invoices")
	WebElementFacade ClickOnInvoices;
	
	@FindBy(linkText ="Standard Search")
	WebElementFacade ClickOnStandardSearch;
	
	@FindBy(xpath=".//*[@name='xBillNo']")
	WebElementFacade BillNoSet;
	
	@FindBy(xpath="(.//*[@value='Search'])[2]")
	WebElementFacade InvoiceSearchButton;
	
	@FindBy(xpath=".//div[1]/a[contains(text(),'WCC')]")
	WebElementFacade InvoiceUploadValidation;
	
	@Step
	 public void  SearchInvoiceWCCfn() throws InterruptedException, IOException, AWTException{
	 
		String BillNo = Serenity.sessionVariableCalled("BILLNUMBER0").toString();
		//String BillNo ="B1-953812";
		
		/*if(ClickOnSearch.isDisplayed()){
		ClickOnSearch.click();
		ClickOnInvoices.withTimeoutOf(120, TimeUnit.SECONDS).isDisplayed();
		ClickOnInvoices.click();
		}
		else{
			report.Info("WCC Login is not done successfully");
			sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
			Assert.assertTrue(false);
		}*/
		
		if(ClickOnSearch.isDisplayed()){
			ClickOnSearch.click();
			ClickOnStandardSearch.withTimeoutOf(120, TimeUnit.SECONDS).isDisplayed();
			ClickOnStandardSearch.click();
			SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
			}
			else{
				report.Info("WCC Login is not done successfully");
				SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
				Assert.assertTrue(false);
			}
		
		
		if(BillNoSet.withTimeoutOf(120, TimeUnit.SECONDS).isDisplayed()){
			BillNoSet.type(BillNo);
			SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
			InvoiceSearchButton.click();
			report.Info("Bill Number : " + BillNo +" is entered successfully.");
			SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
		}
		else{
			report.Info("WCC Invoice Search is not done successfully");
			SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
			Assert.assertTrue(false);
		}
		
		if(InvoiceUploadValidation.withTimeoutOf(120, TimeUnit.SECONDS).isDisplayed()){
			InvoiceUploadValidation.click();
			Thread.sleep(2000);
			report.Info("WCC Invoice link is displayed successfully after entering Bill Number.");
			SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
		}
		else{
			report.Info("WCC Invoice link is not displayed after entering Bill Number.");
			SikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
			Assert.assertTrue(false);
		}
		
	}
	
	}
