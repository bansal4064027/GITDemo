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


public class BRMODILogin  extends PageObject{
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
    public void LoginToODI(String rowName) throws IOException, InterruptedException, AWTException, FindFailed {          

        String filePath = "\\src\\test\\resources\\data\\ODI.xls";
        String dataSheet = "LoginToODI";
        
        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowName, filePath, dataSheet);
        readWorkbook.testData(tableMap);
        for (int i = 0  ;i < tableMap.get("RowNo").size();i++) {
              String username = tableMap.get("Username").get(i);
              String password = tableMap.get("Password").get(i);    
              //Serenity.setSessionVariable("Environment").to("E7");
              String Environment = Serenity.sessionVariableCalled("Env").toString();   
              //String Environment = "E7";
              String URL = tableMap.get(Environment).get(i);  
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
      	String  sOfflinePaymentValue = tableMap.get("OfflinePaymentValue").get(i);
      	String Env = Serenity.sessionVariableCalled("Env").toString();
      	String ODIURL = "";
      	
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
      	if(sOfflinePaymentValue.equals("Y")){
      		if (Env.equals("E4")) {
      			ODIURL="http://extsoa-newvoe4.oracleoutsourcing.com/soa-infra/services/default/InvokeEIMOfflinePaymentsDataLoad/invokeeimofflinepaymentsdataload_client_ep?WSDL";
      		}
      		else if (Env.equals("E7")) {
      			ODIURL="http://extsoa-newvoe7.oracleoutsourcing.com/soa-infra/services/default/InvokeEIMOfflinePaymentsDataLoad/invokeeimofflinepaymentsdataload_client_ep?WSDL";
      		}
      		else if (Env.equals("SUP02")) {
      			ODIURL="http://extsoa-newvoesup02.oracleoutsourcing.com/soa-infra/services/default/InvokeEIMOfflinePaymentsDataLoad/invokeeimofflinepaymentsdataload_client_ep?WSDL";
      		}
      		
      		getDriver().findElement(By.xpath(".//input[@id='shell:dialogRegion:1:exescen_vars:0:it_varvalue::content']")).clear();
      		getDriver().findElement(By.xpath(".//input[@id='shell:dialogRegion:1:exescen_vars:0:it_varvalue::content']")).sendKeys(ODIURL);
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
	
	}
