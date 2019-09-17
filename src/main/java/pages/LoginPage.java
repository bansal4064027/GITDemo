package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.openqa.selenium.JavascriptExecutor;

import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.SikuliUtility;
import utilities.common;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class LoginPage extends PageObject {
	private static final TimeUnit SECONDS = null;
	@Steps
	private ReadWorkbook readWorkbook;
	@Steps
	private SikuliUtility SikuliUtility;
	
	@Steps
	private common Common;
	
	@FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
    WebElement Clockobj; 
	
	@FindBy(name="SWEUserName")
	WebElementFacade userNameTextBox;

	@FindBy(name="SWEPassword")
	WebElementFacade passwordTextBox;

	@FindBy(id="s_swepi_22")
	WebElementFacade loginButton;
	
	@FindBy(id="s_swepi_22")
	WebElement loginButtonsync;

	@FindBy(xpath=".//a[text()='Customer Comm List']")
  	 WebElementFacade CustomerCommsList;
	
	@FindBy(xpath=".//a[text()='Continue to this website (not recommended).']")
 	 WebElementFacade ContinueToWebsiteLink;
	
	@FindBy(xpath=".//a[text()='Continue to this website (not recommended).']")
	 WebElement ContinueToWebsiteLinkWebElement;
	
	@FindBy(xpath=".//*[text()='My Homepage']")
	WebElementFacade Homepage;
	
	@FindBy(xpath=".//*[text()='My Homepage']")
	WebElement Homepage1;
	
	@FindBy(xpath=".//*[@data-tabindex='tabScreen1']")
	WebElement AccountsTabSync;
	
	@FindBy(xpath=".//*[text()='My Homepage']")
	WebElementFacade HomePageSync;
	
	@Steps
	ReportMessege report;
	
	@Step
	public void login(String username, String password) {
		userNameTextBox.type(username);		
		passwordTextBox.typeAndEnter(password);
		loginButton.click();
	}
	
	@Step
	public void Login(String rowName,String EnvURL) throws IOException, InterruptedException, AWTException, FindFailed {	
		//Common.WritePerformanceOutput("----------------------------------Selenium Performance Check----------------------------------",true);																	
		//Common.waitForPageLoad(getDriver());
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "LoginToSiebel";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowName, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		for (int i = 0  ;i < tableMap.get("Username").size();i++) {
			String username = tableMap.get("Username").get(i);
			String password = tableMap.get("Password").get(i);
			String sEnv = tableMap.get("EnvURL").get(i);
			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
			//String SikulifilePathForSavingFile = "";
			String URL = null ; 
			Serenity.setSessionVariable("Env").to(sEnv);

			if (sEnv.equalsIgnoreCase("E4"))
			{
				URL = "https://10.78.193.233:443/callcenterOUI_enu/start.swe?SWECmd=AutoOn";
			}
			if (sEnv.equalsIgnoreCase("E7"))
			{
				URL = "https://crm01-newvoe7.newvoe.eu/callcenterOUI_enu/start.swe?";
			}
			if (sEnv.equalsIgnoreCase("C2"))
			{
				URL = "https://10.78.221.37/callcenterOUI_enu/start.swe?SWECmd=AutoOn";
			}
			if (sEnv.equalsIgnoreCase("E8"))
			{
				URL = "https://10.78.195.233/callcenterOUI_enu/start.swe?SWECmd=AutoOn";
			}
			if (sEnv.equalsIgnoreCase("SUP02"))
			{
				URL = "https://crm01-newvoesup02.newvoe.eu/callcenterOUI_enu/start.swe?";
			}
			if (sEnv.equalsIgnoreCase("E10"))
			{
				URL = "https://100.66.64.93/callcenterOUI_enu/start.swe?SWECmd=AutoOn";
			}
			getDriver().quit();
			openAt(URL);

			getDriver().manage().window().maximize();
			//SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
			//System.out.println("Function is  :-"+SikulifilePathForSavingFile);
			//Thread.sleep(5000);

			/*	if (Common.waitForElement(ContinueToWebsiteLinkWebElement)) {
				ContinueToWebsiteLink.click();
			}*/
			Thread.sleep(2000);

			//SikuliUtility.ClickTrustedPopUp(SikulifilePath);	
			Common.waitForElement(loginButtonsync);
			//Assert.assertTrue("Login Button is not visible", loginButton.isVisible());
			//Assert.assertTrue("Login Button is not visible", loginButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible());
			userNameTextBox.type(username);	     		
			//passwordTextBox.type(password);	
			passwordTextBox.type(password);

			SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			long startTime = System.currentTimeMillis();
			loginButton.click();
			Common.WaitForClock(Clockobj);
			getDriver().navigate().refresh();
			Common.WaitForClock(Clockobj);
			boolean flag1 =HomePageSync.isCurrentlyVisible();
			//Common.waitForElement(AccountsTabSync);
			//Common.waitForPageLoad(getDriver());
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			Common.WritePerformanceOutput("Logged in ,Total Login Time " + totalTime/1000);
			//Thread.sleep(2000);

			//Common.waitForPageLoad(getDriver());
			//Homepage.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
			if (flag1==false) {
				for (int j = 0  ;j < 3;j++) {
					boolean flag=HomePageSync.isCurrentlyVisible();
					if (flag==false) {
						/**Robot robot = new Robot();	 
						robot.keyPress(KeyEvent.VK_F5);	
						robot.keyRelease(KeyEvent.VK_F5);*/
					//new code
						getDriver().navigate().refresh();
						Common.WaitForClock(Clockobj);
						SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					}
					else{
						SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						break;
					}				

					//Assert.assertTrue("Login Failed", Common.waitForElement(AccountsTabSync));

				}
			}
			SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		}
	}
		@Step
		public void ReLogin(String rowName,String EnvURL) throws IOException, InterruptedException, AWTException, FindFailed {

			String filePath = "\\src\\test\\resources\\data\\Account.xls";
			String dataSheet = "LoginToSiebel";

			Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowName, filePath, dataSheet);
			readWorkbook.testData(tableMap);

			for (int i = 0  ;i < tableMap.get("Username").size();i++) {
				String username = tableMap.get("Username").get(i);
				String password = tableMap.get("Password").get(i);
				String sEnv = tableMap.get("EnvURL").get(i);
				String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
				//String SikulifilePathForSavingFile = "";
				String URL = null ; 
				Serenity.setSessionVariable("Env").to(sEnv);

				if (sEnv.equalsIgnoreCase("E4"))
				{
					URL = "https://10.78.193.233:443/callcenterOUI_enu/start.swe?SWECmd=AutoOn";
				}
				if (sEnv.equalsIgnoreCase("E7"))
				{
					URL = "https://10.78.195.105/callcenterOUI_enu/start.swe?SWECmd=AutoOn";
				}
				if (sEnv.equalsIgnoreCase("C2"))
				{
					URL = "https://10.78.221.37/callcenterOUI_enu/start.swe?SWECmd=AutoOn";
				}
				if (sEnv.equalsIgnoreCase("E8"))
				{
					URL = "https://10.78.195.233/callcenterOUI_enu/start.swe?SWECmd=AutoOn";
				}
				if (sEnv.equalsIgnoreCase("SUP02"))
				{
					URL = "https://crm01-newvoesup02.newvoe.eu/callcenterOUI_enu/start.swe?";
				}
				getDriver().quit();
				openAt(URL);   
				getDriver().manage().window().maximize();


				/*if (Common.waitForElement(ContinueToWebsiteLinkWebElement)) {
					ContinueToWebsiteLink.click();
				}*/
				Thread.sleep(2000);
				//SikuliUtility.ClickTrustedPopUp(SikulifilePath);
				Thread.sleep(2000);
				Common.waitForElement(loginButtonsync);
				//Assert.assertTrue("Login Button is not visible", loginButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible());
				userNameTextBox.type(username);	     		
				passwordTextBox.type(password);	     	
				long startTime = System.currentTimeMillis();
				loginButton.click();
				Common.WaitForClock(Clockobj);
				getDriver().navigate().refresh();
				Common.WaitForClock(Clockobj);
				//Homepage.withTimeoutOf(120,TimeUnit.SECONDS).isVisible();
				for (int j = 0  ;j < 3;j++) {
					boolean flag=Common.waitForElement(Homepage1);
					if (flag==false) {
						getDriver().close();
						openAt(URL);

						getDriver().manage().window().maximize();


						if (Common.waitForElement(ContinueToWebsiteLinkWebElement)) {
							ContinueToWebsiteLink.click();
						}
						Thread.sleep(2000);
						Common.waitForElement(loginButtonsync);
						//Assert.assertTrue("Login Button is not visible", loginButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible());
						userNameTextBox.type(username);		
						passwordTextBox.type(password);

						report.Info("Login Button click");
						loginButton.click();
						Thread.sleep(2000);
					}
					else{
						break;
					}
				}
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			//	Assert.assertTrue("Login Failed", Common.waitForElement(AccountsTabSync));
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				report.Info("Logged in ,Total Login Time " + totalTime);
			}

		}



		@Step
		public boolean isLoginSuccessful() {
			return !containsElements("//input[@name='SWEUserName']");
		}

		//@FindBy(name="j_username")
		@FindBy(xpath = ".//input[@name='j_username']")
		WebElementFacade userNameTextBoxOSM;

		// @FindBy(name="j_password")
		@FindBy(xpath = ".//input[@name='j_password']")
		WebElementFacade passwordTextBoxOSM;

		// @FindBy(name="submit")
		@FindBy(xpath = ".//input[@name='submit']")
		WebElementFacade loginButtonOSM;

		@FindBy(xpath = ".//*[@id='Body']/form/p[1]/b")
		WebElementFacade HomepageOSM;

		@Step
		public void LoginToOSM(String rowName,String EnvURL) throws IOException, InterruptedException, AWTException {		



			String filePath = "\\src\\test\\resources\\data\\OSM.xls";
			String dataSheet = "LoginToOSM";
			// ReadWorkbook readWorkbook = new ReadWorkbook();
			Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(rowName, filePath, dataSheet);
			readWorkbook.testData(tableMap);
			// Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
			for (int i = 0; i < tableMap.get("UsernameE7").size(); i++) {
				String URL = null;

				String Environment = Serenity.sessionVariableCalled("Env").toString();
				String username = "Username" + Environment;
				String password = "Password" + Environment;

				username = tableMap.get(username).get(i);
				password = tableMap.get(password).get(i);
				

				if (Environment.contains("E7")) {
					URL = "http://10.78.195.118:7001/OrderManagement";
				}
				
				if (Environment.contains("E4")) {
					URL = "http://10.78.193.240:7001/OrderManagement";
				}
				
				if (Environment.contains("SUP02")) {
					URL = "http://10.78.199.143:7001/OrderManagement";
				}

				openAt(URL);
				getDriver().manage().window().maximize();

				// Assert.assertTrue("Login Button is not visible", loginButton.isVisible());
				Assert.assertTrue("Login Button is not visible",
						loginButtonOSM.withTimeoutOf(120, TimeUnit.SECONDS).isVisible());
				if (userNameTextBoxOSM.isCurrentlyVisible()) {
					userNameTextBoxOSM.type(username);
					passwordTextBoxOSM.type(password);

				loginButtonOSM.click();
				report.Info("Login Button click");
				// Thread.sleep(8000);
				HomepageOSM.withTimeoutOf(120, TimeUnit.SECONDS).isDisplayed();
				// Homepage.waitUntilVisible();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Assert.assertTrue("Login Failed", HomepageOSM.isDisplayed());
				report.Info("Login Page is displayed successfully");
				}
				else {
					report.Info("Login Page is not displayed successfully");
					Assert.assertTrue(false);
				}
				
			}

		}
		
		@FindBy(name="j_username")
		WebElementFacade SBConsoleuserNameTextBox;

		@FindBy(name="j_password")
		WebElementFacade SBConsolepasswordTextBox;

		@FindBy(name="login")
		WebElementFacade SBConsoleloginButton;
		
		
		@Step
		public void LoginToSBConsole() throws IOException, InterruptedException, AWTException {		
			String rowName = "testusr";
			String filePath = "\\src\\test\\resources\\data\\SBConsole.xls";
			String dataSheet = "LoginToSBConsole";
			//ReadWorkbook readWorkbook = new ReadWorkbook();
			Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowName, filePath, dataSheet);
			readWorkbook.testData(tableMap);
			//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
			for (int i = 0  ;i < tableMap.get("UsernameE7").size();i++) {
				//String username = tableMap.get("Username").get(i);
				//String password = tableMap.get("Password").get(i);
				//String Environment = tableMap.get("Env").get(i);
				String URL = null;
				
				String Environment = Serenity.sessionVariableCalled("Env").toString(); 
				String username="Username"+Environment;
				String password="Password"+Environment;
				
				
				username = tableMap.get(username).get(i);
				password = tableMap.get(password).get(i);
				
				
				if(Environment.contains("E7")) {
					URL = "http://extosb-newvoe7.oracleoutsourcing.com/sbconsole/";
				}

				openAt(URL);   
				getDriver().manage().window().maximize();


				//Assert.assertTrue("Login Button is not visible", loginButton.isVisible());
				Assert.assertTrue("Login Button is not visible", SBConsoleloginButton.withTimeoutOf(120,TimeUnit.SECONDS).isVisible());
				SBConsoleuserNameTextBox.type(username);	     		
				SBConsolepasswordTextBox.type(password);	     	

				SBConsoleloginButton.click();
				report.Info("Login Button click");
				//Thread.sleep(8000);
//				HomepageOSM.withTimeoutOf(120,TimeUnit.SECONDS).isDisplayed();
				//Homepage.waitUntilVisible();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
//				Assert.assertTrue("Login Failed", HomepageOSM.isDisplayed());
				report.Info("Login Page is displayed successfully");
			}
}
		

		@FindBy(xpath = "//table/tbody/tr/td/span[text()='Communications Unified Inventory Management']")
		WebElementFacade UIMHomePageHeading;
		
		@FindBy(xpath="//button[text()='Login']")
		WebElementFacade UIMLoginBtn;

		@Step
		public void LoginToUIM() throws IOException, InterruptedException, AWTException {
			String rowName = "testusr";
			String filePath = "\\src\\test\\resources\\data\\UIM.xls";
			String dataSheet = "LoginToUIM";
			Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(rowName, filePath, dataSheet);
			readWorkbook.testData(tableMap);
			// Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
			for (int i = 0; i < tableMap.get("UsernameE7").size(); i++) {
				// String username = tableMap.get("Username").get(i);
				// String password = tableMap.get("Password").get(i);
				// String Environment = tableMap.get("Env").get(i);
				String URL = null;

				String Environment = Serenity.sessionVariableCalled("Env").toString();
				String username = "Username" + Environment;
				String password = "Password" + Environment;

				username = tableMap.get(username).get(i);
				password = tableMap.get(password).get(i);

				if (Environment.contains("E7")) {
					URL = "http://newvoe7-uim23:7001/Inventory";
				}
				
				if (Environment.contains("E4")) {
					URL = "http://newvoe7-uim23:7001/Inventory";
				}
				
				if (Environment.contains("SUP02")) {
				//	URL = "http://newvoe7-uim23:7001/Inventory";
					URL = "http://newvosup02-uim23:7001/Inventory";

				}

				openAt(URL);
				getDriver().manage().window().maximize();

				// Assert.assertTrue("Login Button is not visible", loginButton.isVisible());
				Assert.assertTrue("Login Button is not visible",
						UIMLoginBtn.withTimeoutOf(120, TimeUnit.SECONDS).isVisible());
				SBConsoleuserNameTextBox.type(username);
				SBConsolepasswordTextBox.type(password);

				UIMLoginBtn.click();
				report.Info("Login Button click");
				// Thread.sleep(8000);
					UIMHomePageHeading.withTimeoutOf(120,TimeUnit.SECONDS).isDisplayed();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
//					Assert.assertTrue("Login Failed", HomepageOSM.isDisplayed());
				report.Info("Login Page is displayed successfully");
			}
		}

}
