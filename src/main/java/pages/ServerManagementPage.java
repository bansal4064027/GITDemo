package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



public class ServerManagementPage extends PageObject {
	@Steps
	private ReadWorkbook readWorkbook;
	@Steps
	private common Common;
	@Steps
	ReportMessege report;
	@Steps
	private SikuliUtility sikuliUtility;
	
	@FindBy(xpath=".//div[contains(@style,'display: none;')][ @id='maskoverlay']")
    WebElement Clockobj; 

	@FindBy(xpath=".//*[@name='SiteMap']/span")
	WebElementFacade SiteMap;
	@FindBy(xpath=".//*[text()='My BIP Reports']//following::a[text()='Administration - User']")
	WebElementFacade AdministrationUser;
	//@FindBy(xpath=".//*[@id='_svf0']/div/ul/li[21]//.[text()='Employees']")
	//WebElementFacade EmployeesTab;
	@FindBy(xpath="(.//*[@aria-labelledby='QueryComboBox_Label'])[1]")
	WebElementFacade EmployeeDropDownTab;
	@FindBy(xpath=".//li[text()='User ID']")
	WebElementFacade EmployeeDropDownItem;
	@FindBy(xpath=".//a[text()='Employees']")
	WebElementFacade EmployeesTab;
	@FindBy(xpath=".//*[@id='a_1']/div/div/input[1]")         
	WebElementFacade EmployeeList;
	@FindBy(xpath="(.//*[@title='Employee Administration']//input[@aria-label='Starting with'])[1]")
	WebElementFacade UserIDTextBox;	
	@FindBy(xpath="(.//*[@title='Employee Administration']//button[@aria-label='Employees:Go'])[2]")
	WebElementFacade GoButton;
	@FindBy(xpath=".//td[contains(@id,'Position')]")
	WebElementFacade Position;


	@Step
	public void NavigationToEmployees() throws InterruptedException {
		if(SiteMap.isCurrentlyVisible()){
			//SiteMap.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			SiteMap.click();
			Thread.sleep(2000);

		}
		else
		{
			Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			Common.waitForPageLoad(getDriver());
			Iconbar.click();
			Thread.sleep(2000);

			SiteMap.click();
			AdministrationUser.click();
			//Thread.sleep(5000);
			Common.waitForPageLoad(getDriver());

		}
	}
	
	
	@FindBy(xpath="(.//a[text()='Administration - Communications'])[1]")
	WebElementFacade AdminCommunicationsLink;
	@FindBy(xpath="(.//a[text()='All Templates'])[2]")
	WebElementFacade AllTemplateLink;
	@FindBy(xpath="(.//*[@aria-label='Templates:Query'])[1]")
	WebElementFacade QueryButtoninAllTemplate;
	@FindBy(xpath="(.//*[@aria-label='Templates:Go'])[1]")
	WebElementFacade GoButtoninAllTemplate;
	@FindBy(xpath="//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	WebElementFacade TemplateText;
	@FindBy(xpath=".//a[text()='Simple']")
	WebElementFacade SimpleTab;
	@FindBy(xpath=".//a[text()='Simple']")
	WebElement SimpleTabSync;
	
	@FindBy(xpath="//iframe[contains(@class,'frame')]")
	WebElementFacade TemplateFrame;	


	@Step
	public void AllTemplatesValidation(String Template) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
	    String applet = "//*[@title='Templates List Applet']";
	    String table = "//table[@summary='Communication Package List']";
		String dataSheet = "AllTemplateValidation";
	   
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Template, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		Common.WaitForClock(Clockobj);
		for (int i = 0;i < tableMap.get("RowNo").size();i++) {
			 String sLocateCol = tableMap.get("LocateCol").get(i);
		     String sLocateColValue = tableMap.get("LocateColValue").get(i);
		     String UIName  = tableMap.get("UIName").get(i);
		     String value  = tableMap.get("Value").get(i);
		     String sTemplateMessage  = tableMap.get("TemplateMessage").get(i);
		     
		     String indexValue = "0";
	       
	       
		if(SiteMap.isCurrentlyVisible()){
			//SiteMap.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			SiteMap.click();
			Thread.sleep(2000);
			Common.WaitForClock(Clockobj);

		}
		else
		{
			Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			Common.waitForPageLoad(getDriver());
			Iconbar.click();
			Thread.sleep(2000);

			SiteMap.click();
			
		}
		
			Common.WaitForClock(Clockobj);
			AdminCommunicationsLink.click();
			Common.WaitForClock(Clockobj);
			//Thread.sleep(5000);
			Common.waitForPageLoad(getDriver());
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			AllTemplateLink.click();
			Common.WaitForClock(Clockobj);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			//
			boolean Tab = Common.waitForElement(SimpleTabSync);
			if (Tab== false){
				SimpleTab.click();
				
			}
			QueryButtoninAllTemplate.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			QueryButtoninAllTemplate.click();
		     Thread.sleep(4000);
		     Common.WaitForClock(Clockobj);
		     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		     //
		   Common.selectedRow = 1;
		   Common.updateSiebList(applet,table, UIName, value);
           Thread.sleep(1000);
           report.Info("Searched "+value+" successfully");
           sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
           
           GoButtoninAllTemplate.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
           GoButtoninAllTemplate.click();
           
           Thread.sleep(2000);
           Common.WaitForClock(Clockobj);
           sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
           //
           if(!sTemplateMessage.equals("")) {
        	  // getDriver().findElement(By.xpath("//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).click();
        	   getDriver().switchTo().frame(TemplateFrame);
        	  TemplateText.click();
               String ActualTemplateMessage = TemplateText.getTextValue();
                sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                Assert.assertTrue("Template not matching", ActualTemplateMessage.contains(sTemplateMessage));
                report.Info("Template matching. template is : "+ActualTemplateMessage); 
           }
          
		}	

	}
	
	@Step
	public void AdministratorDivision(String Division) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "Division";
		//ReadWorkbook readWorkbook = new ReadWorkbook();
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Division, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
		for (int i = 0  ;i < tableMap.get("User").size();i++){
			String Userfield = tableMap.get("User").get(i);
			String Divisionfield = tableMap.get("Division").get(i);
			//Thread.sleep(5000);
			Common.waitForPageLoad(getDriver());
			EmployeesTab.click();
			Thread.sleep(2000);
			EmployeeDropDownTab.sendKeys("User ID");
			//Thread.sleep(3000);
			Common.waitForPageLoad(getDriver());
			UserIDTextBox.sendKeys(Userfield);
			Thread.sleep(2000);
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			GoButton.click();
			//Thread.sleep(3000);
			Common.waitForPageLoad(getDriver());

			String actPostion_Verify=Position.getText();
			sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			Assert.assertTrue("Postion value is not as expected" ,Divisionfield.equals(actPostion_Verify));

		}

	}


	@FindBy(xpath="(.//a[text()='Administration - Server Management'])[1]")
	WebElementFacade AdminServerManagement;
	@FindBy(xpath=".//a[text()='Jobs']")
	WebElementFacade AdminServerManagementJob;
	@FindBy(xpath=".//*[@class='siebui-button-toolbar siebui-closed']")
	WebElementFacade Iconbar;




	@Step

	public void NavigationToJobs() throws InterruptedException {

		if(SiteMap.isCurrentlyVisible()){
			//SiteMap.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			SiteMap.click();
			Thread.sleep(2000);

		}else
		{
			//Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			Common.waitForPageLoad(getDriver());
			Iconbar.click();
			Thread.sleep(2000);

			SiteMap.click();
			Thread.sleep(2000);
		}
		Common.WaitForClock(Clockobj);
		
		AdminServerManagement.click();
		AdminServerManagementJob.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		AdminServerManagementJob.click();
	}        


	@FindBy(xpath=".//*[@aria-label='Jobs:New']")
	WebElementFacade NewJobcreate;

	@FindBy(xpath=".//*[@name='Job_Name']")
	WebElementFacade OpenPopUp;

	@FindBy(xpath=".//*[@title='Jobs Menu']")
	WebElementFacade JobMenu;
	@FindBy(xpath="//span/ul/li[10]/a")
	WebElementFacade RefineQuery ;
	@FindBy(xpath="(.//*[@title='Jobs:Go'])[1]")
	WebElementFacade Gobutton;
	@FindBy(xpath=".//*[@title='Jobs:Submit Job']")
	WebElementFacade SubmitJobButton;
	@FindBy(xpath=".//td[contains(@aria-labelledby,'Status_Displayed')]")
	WebElementFacade StatusField;
	@FindBy(xpath=".//*[@aria-label='Component/Job']")
	WebElementFacade ComponentTextBox;


	@Step
	public void CreateNewJob(String UIName) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "CreateNewJob";
		String table = "//table[@summary='Jobs']";
		String applet = "//*[@title='Jobs List Applet']";

		// if (Common.locateColumn(applet,table, "Product_Name", "Null", "0").equals("true")){
		//NewJobcreate.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible(); 			   	    
		//}

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		Common.WaitForClock(Clockobj);
		for (int i = 0;i < tableMap.get("UIName").size();i++) {
			String UIName1 = tableMap.get("UIName").get(i);
			String Query = tableMap.get("Query").get(i);
			String NewJob = tableMap.get("NewJob").get(i);
			String Go = tableMap.get("Go").get(i);
			String SubmitJob = tableMap.get("SubmitJob").get(i);   
			String Value = tableMap.get("Value").get(i);
			String Status = tableMap.get("Status").get(i);

			if  (NewJob.equals("Yes")){
				//NewJobcreate.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
				Common.waitForPageLoad(getDriver());
				NewJobcreate.waitUntilClickable();
				NewJobcreate.click();
				report.Info("Creating New Jobs");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(Clockobj);
			}

			if  (Query.equals("Yes")){
				JobMenu.click();
				Common.WaitForClock(Clockobj);
				RefineQuery.click();
				report.Info("Query Clicked successfully");
				Common.WaitForClock(Clockobj);
				if (Value.equalsIgnoreCase("JobID")){
					Value = Serenity.sessionVariableCalled("JobID").toString(); 
					// String JobID = Serenity.sessionVariableCalled("AccountNo").toString(); 
					//Value = JobID;
				}                        	
			}

			if (Value.equalsIgnoreCase("AgreementRowID")){
				Value = Value.replace("AgreementRowID", Serenity.sessionVariableCalled("AgreementRowID").toString());
				// report.Info("Query Clicked successfully");
			}
			if (Value.equalsIgnoreCase("ProductandServiceRowID")){
				Value = Value.replace("ProductandServiceRowID", Serenity.sessionVariableCalled("ProductandServiceRowID").toString()); 
			}
			
			if (Value.equalsIgnoreCase("ROWID")){
				Value = Value.replace("RowId", Serenity.sessionVariableCalled("RowId").toString());
			}

			Common.selectedRow = 1;

			if (!UIName1.equals("")){

				String IDvalue=Common.updateSiebList(applet,table, UIName1, Value);
				Serenity.setSessionVariable("ProductandServiceRowID").to(IDvalue);
				Robot robot = new Robot();
				if(Value.equalsIgnoreCase("VF Changes to disconnection"))
				{
				robot.keyPress(KeyEvent.VK_ENTER);     		
				robot.keyRelease(KeyEvent.VK_ENTER);
				}
				
			    //ComponentTextBox.click();
				Thread.sleep(2000);
				//do not delete	//	
				if(Value.equalsIgnoreCase("JobID")){
					Serenity.setSessionVariable("JobID").to(IDvalue);
					String ID = Serenity.sessionVariableCalled("JobID").toString();
					report.Info("Job ID is : "+IDvalue); 
					System.out.println(ID);
				}
				Thread.sleep(2000);
				report.Info("Row updated successfully"); 
				Common.WaitForClock(Clockobj);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                         
			}

			if  (Go.equals("Yes")){
				Gobutton.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
				Gobutton.click();
				report.Info("Go button Clicked successfully");
				Common.WaitForClock(Clockobj);

			}

			if  (SubmitJob.equals("Yes")){
				SubmitJobButton.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
				SubmitJobButton.click();
				report.Info("Submit button Clicked successfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				Common.WaitForClock(Clockobj);
			}

			if(Status.equalsIgnoreCase("Yes")){
				String ExpStatus=StatusField.getTextValue();
				i=0;
				do{
					Thread.sleep(2000);
					getDriver().findElement(By.xpath(".//*[@aria-label='Jobs:Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
					Thread.sleep(1000);
					Common.WaitForClock(Clockobj);
					ExpStatus=StatusField.getTextValue();
					if(ExpStatus.equals("Success")){
						report.Info("Job Status is Success");
						break;
					}
					i++;
				}while(!ExpStatus.equals("Success") && i<200);//do not change this counter as Post to pre Job takes time to complete
				Assert.assertTrue("Status is "+ExpStatus+ " ",ExpStatus.equals("Success")); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                    	  
			}                      
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}

	@FindBy(xpath=".//*[@name='popup']")
	WebElementFacade ComponentsJobPopUp;
	@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
	WebElementFacade ComponentsListApplet ;
	@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")
	WebElementFacade ComponentsListAppletvalue;
	@FindBy(xpath=".//*[@title='Components/Jobs:OK']")
	WebElementFacade ComponentOkButton;


	@Step
	public void SelectJob(String UIName) throws InterruptedException, IOException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "SelectJob";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Find").size();i++) {
			String sFind = tableMap.get("Find").get(i);
			String sStartWith = tableMap.get("StartWith").get(i);

			ComponentsJobPopUp.isCurrentlyVisible(); 
			ComponentsListApplet.clear();
			ComponentsListApplet.type(sFind);
			//ComponentsListAppletvalue.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			ComponentsListAppletvalue.typeAndEnter(sStartWith);
			//ComponentOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			//Common.waitForPageLoad(getDriver());
			ComponentOkButton.click();
		}
	}


	@Step
	public void JobParameters(String UIName) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "JobParameters";
		String table = "//table[@summary='Job Parameters']";
		String applet = "//*[@title='Job Parameters List Applet']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Size").size();i++) {
			String Size = tableMap.get("Size").get(i);
			String sValue = tableMap.get("Value").get(i);
			String UIName1 = tableMap.get("UIName").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);

			if (sValue.contains("[Id]='AgreementRowId'")){
				sValue = sValue.replace("AgreementRowId", Serenity.sessionVariableCalled("AgreementRowID").toString()); 
			}
			/*do not delete*/     else if (sValue.contains("[Id]='RowId'"));{
				sValue = sValue.replace("RowId", Serenity.sessionVariableCalled("RowId").toString());	  
			}


			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,"0" ).equals("true"));
			}
			else{
				Common.selectedRow = 1;
			}
			if (!UIName1.equals("")){                                              
				Common.updateSiebList(applet,table, UIName1, sValue);
				Thread.sleep(2000); 
				getDriver().findElement(By.xpath(".//*[@title='Jobs Menu']")).sendKeys(Keys.ALT,Keys.ENTER);
			}




		} 
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}


	@FindBy(xpath=".//span[@class='screenName1']/a[text()='Administration - Data']")
	WebElementFacade AdministrationDataLink;
	@FindBy(xpath="(.//span[@class='viewName']/a[text()='List of Values'])[2]")
	WebElementFacade ListOfValuesLink;
	@FindBy(xpath=".//*[@title='List of Values:Query']")
	WebElementFacade Query;
	@FindBy(xpath="(.//*[contains(@id,'VF_Division_Filter')]/span[1])[8]")
	WebElementFacade CheckBoxsss;
	//.//*[@id='10_s_1_l_VF_Division_Filter']/span[1]

	@Step
	public void divisionFilter(String UIName) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "DivisonFilter";
		String table = "//table[@summary='List of Values']";
		String applet = "//*[@title='List of Values List Applet']";

		if(SiteMap.isCurrentlyVisible()){
			//SiteMap.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			SiteMap.click();
			Thread.sleep(2000);

		}else
		{
			//Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			Common.waitForPageLoad(getDriver());
			Iconbar.click();
			Thread.sleep(2000);

			SiteMap.click();
			Thread.sleep(2000);
		}

		//AdministrationDataLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		AdministrationDataLink.click();
		//ListOfValuesLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		ListOfValuesLink.click();


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Size").size();i++) {
			String Size = tableMap.get("Size").get(i);
			String sValue = tableMap.get("Value").get(i);
			String UIName1 = tableMap.get("UIName").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String Index = tableMap.get("Index").get(i);
			String sQuery = tableMap.get("Query").get(i);
			//String sCheckBox = tableMap.get("CheckBox").get(i);

			if (Index.equals("")){
				Index = "0";
			}

			if(sQuery.equalsIgnoreCase("Yes")){
				//Query.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				Common.waitForPageLoad(getDriver());
				Query.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,Index ).equals("true"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{
				Common.selectedRow = 1;
			}
			if (!UIName1.equals("")&&!UIName1.equals("CheckBoxStatusChecked")){                                             
				Common.updateSiebList(applet,table, UIName1, sValue); 


				if (UIName1.contains("CheckBoxStatusChecked")){
					Assert.assertTrue(Common.updateSiebList(applet,table, UIName1, sValue).equals("true"));
					report.Info("Pass: Check Box is checekd as expected");
				}
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}

		} 
	}

	@FindBy(xpath=".//span[@class='screenName1']/a[text()='Administration NewCo']")
	WebElementFacade AdministrationNewcolink;
	@FindBy(xpath=".//span[@class='viewName']/a[text()='Division Filter Monitoring']")
	WebElementFacade DivisionFilterMonitoringLink;
	@FindBy(xpath=".//a[text()='Division Filter Monitoring']")
	WebElementFacade DivisionFilterMonitoring;
	@FindBy(xpath=".//*[@title='Query']")
	WebElementFacade TypeandValueQuery;
	@FindBy(xpath=".//*[@title='Division Name:Query']")
	WebElementFacade DivisionQuery;
	@FindBy(xpath=".//*[@title='Division Name:New']")
	WebElementFacade DivisionNewButton;
	@FindBy(xpath=".//*[@title='Division Name:Delete']")
	WebElementFacade DivisionDeleteButton;
	@Step
	public void divisionFilterMonitoring(String UIName) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "DivisonFilter";
		String table ="";
		String applet="";

		if(SiteMap.isCurrentlyVisible()){
			//SiteMap.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			SiteMap.click();
			Thread.sleep(2000);

		}else
		{
			//Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			Common.waitForPageLoad(getDriver());
			Iconbar.click();
			Thread.sleep(2000);

			SiteMap.click();
			Thread.sleep(2000);
		}

		// AdministrationNewcolink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		AdministrationNewcolink.click();
		//DivisionFilterMonitoringLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		DivisionFilterMonitoringLink.click();

		DivisionFilterMonitoring.isDisplayed();
		report.Info("Division Filter Monitoring is present on page");
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Size").size();i++) {
			String Size = tableMap.get("Size").get(i);
			String sValue = tableMap.get("Value").get(i);
			String UIName1 = tableMap.get("UIName").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String Index = tableMap.get("Index").get(i);
			String sQuery = tableMap.get("Query").get(i);
			String sView = tableMap.get("View").get(i);


			if (Index.equals("")){
				Index = "0";
			}

			if(sView.equalsIgnoreCase("TypeAndValue")){
				table = "//table[@summary='']";
				applet = "//*[@title='List Applet']";

			}else if(sView.equalsIgnoreCase("DivisionName"))
			{
				table = "//table[@summary='Division Name']";
				applet = "//*[@title='Division Name List Applet']";
			}


			if(sQuery.equalsIgnoreCase("TypeAndValueQuery")){
				//TypeandValueQuery.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				Common.waitForPageLoad(getDriver());
				TypeandValueQuery.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}else if(sQuery.equalsIgnoreCase("DivisionName")){
				//DivisionNewButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				Common.waitForPageLoad(getDriver());
				DivisionNewButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Division new button is clicakable successfully");
				//DivisionDeleteButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				Common.waitForPageLoad(getDriver());
				DivisionDeleteButton.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("Division Delete button is clicakable successfully");
				Thread.sleep(2000);
				Alert alert=getDriver().switchTo().alert();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				alert.accept();

				DivisionQuery.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				DivisionQuery.click();
				report.Info("Division Query button is clicakable successfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,Index ).equals("true"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{
				Common.selectedRow = 1;
			}
			if (!UIName1.equals("")){                                             
				Common.updateSiebList(applet,table, UIName1, sValue); 
				Thread.sleep(2000); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}

		} 
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}

	@FindBy(xpath=".//span[@class='screenName1']/a[text()='Administration - Application']")
	WebElementFacade AdministrationApplicationLink;
	@FindBy(xpath="(.//span[@class='viewName']/a[text()='Views'])[1]")
	WebElementFacade ViewsLink;
	@FindBy(xpath=".//*[@title='Views:Query']")
	WebElementFacade ViewsQuery;
	@Step
	public void View_validation(String UIName) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "DivisonFilter";
		String table ="";
		String applet="";

		if(SiteMap.isCurrentlyVisible()){
			//SiteMap.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			SiteMap.click();
			Thread.sleep(2000);

		}else
		{
			//Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
			Common.waitForPageLoad(getDriver());
			Iconbar.click();
			Thread.sleep(2000);

			SiteMap.click();
			Thread.sleep(2000);
		}

		AdministrationApplicationLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		AdministrationApplicationLink.click();
		//ViewsLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		Common.waitForPageLoad(getDriver());
		ViewsLink.click();

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Size").size();i++) {
			String Size = tableMap.get("Size").get(i);
			String sValue = tableMap.get("Value").get(i);
			String UIName1 = tableMap.get("UIName").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String Index = tableMap.get("Index").get(i);
			String sQuery = tableMap.get("Query").get(i);
			String sView = tableMap.get("View").get(i);
			String sExpandindex = tableMap.get("Expandindex").get(i);


			if (Index.equals("")){
				Index = "0";
			}

			if(sView.equalsIgnoreCase("Views")){
				table = "//table[@summary='Views']";
				applet = "//*[@title='Views List Applet']";

			}else if(sView.equalsIgnoreCase("Resposibililty"))
			{
				table = "//table[@summary='Responsibilities']";
				applet = "//*[@title='Responsibilities List Applet']";
			}


			if(sQuery.equalsIgnoreCase("Yes")){
				//ViewsQuery.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				Common.waitForPageLoad(getDriver());
				ViewsQuery.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}

			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,Index ).equals("true"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(sExpandindex.equalsIgnoreCase("Yes")){
					String prevRecord = "";
					String currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
					do{
						prevRecord = currRecord;
						getDriver().findElement(By.xpath(applet+"//*[@title='Next record set']")).click();
						currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
					} while (!currRecord.equals(prevRecord));
				}
			}
			else{
				Common.selectedRow = 1;
			}
			if (!UIName1.equals("")){                                             
				Common.updateSiebList(applet,table, UIName1, sValue); 
				Thread.sleep(2000); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}

		} 
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	}                  
	@FindBy(xpath=".//a[contains(@onclick,'Products & Services')][text()='Products & Services']")
	WebElementFacade ProductServicesTab;
	@FindBy(xpath=".//*[@title='Asset:Query']")
	WebElementFacade QueryButton;
	@FindBy(xpath=".//*[@aria-label='Part no.']")
	WebElementFacade PartNumberTextBox;
	@Step
	public void SearchAccountViaSiteMap(String UIName) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "JobParameters";
		String  table = "//table[@summary='Account Details']";
		String  applet = "//*[@title='Assets List Applet']";
		Common.waitForPageLoad(getDriver());
		if(SiteMap.isCurrentlyVisible()){                    
			SiteMap.click();
			Thread.sleep(2000);

		}else
		{                     	
			Common.waitForPageLoad(getDriver());
			Iconbar.click();
			Thread.sleep(2000);
			SiteMap.click();
			Thread.sleep(2000);
		}
		ProductServicesTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		ProductServicesTab.click();
		Thread.sleep(2000);
		QueryButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		QueryButton.click();  
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("RowNo").size();i++) {
			String sValue = tableMap.get("Value").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String Action = tableMap.get("Action").get(i);
			String Index = tableMap.get("Index").get(i);

			if(Action.equalsIgnoreCase("PartNumber")){
				PartNumberTextBox.typeAndEnter(sValue);                           	
				PartNumberTextBox.sendKeys(Keys.chord(Keys.ENTER));
			}

			if (Index.equals("")){
				Index = "0";
			}
			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,Index ).equals("true"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{
				Common.selectedRow = 1;
			}
			if (!sUIName.equals("")){                                             
				Common.updateSiebList(applet,table, sUIName, sValue); 
				Thread.sleep(2000); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

			}

		} 
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                          
	}

	@Step
	public void SavedQueiesListValidation() throws IOException, AWTException, InterruptedException{

		//String[] expOptions={"All Accounts","All Fraud Accounts","Available Offline","Candidate Accounts","Customer Accounts","INS All Agencies","PDA_AccountSyncFilter","PDA_High Mkt Potential Accounts","PDA_Hospital Accounts","PDA_Pharmacy Accounts","Red Flagged Accounts","SWLS"};
		String[] expOptions={"* Home *","Default","Default","Flagged","Forecasted","High Probability","High Quality","High Value","Home Page View PDQ","New","Pending"};
		getDriver().findElement(By.xpath(".//select[@title='Saved Queries']")).click();
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		List<WebElement> AllOptions=getDriver().findElements(By.xpath(".//select[@title='Saved Queries']/option"));

		if(expOptions.length != AllOptions.size()){

			report.Info("fail, wrong number of elements found");
		}
		if(expOptions.length == AllOptions.size()) {
			report.Info("Pass, coreect number of elements found");
		}
		for(int i=0;i<expOptions.length;i++){
			String optionValue=AllOptions.get(i).getAttribute("value");
			Assert.assertTrue("Fail: Expected value is not matched with actual valuew", optionValue.equals(expOptions[i]));
			report.Info("passed on: " + optionValue);


		}
	}

	@FindBy(xpath=".//span[@class='screenName1']/a[text()='Administration NewCo']")
	WebElement AdministrationNewcolinkWebElement;

	@FindBy(xpath=".//a[text()='SMS and Email Engine']")
	WebElementFacade SMSEmailEngineLink;

	@FindBy(xpath=".//a[text()='SMS and Email Engine']")
	WebElement SMSEmailEngineLinkWebElement;

	@FindBy(xpath=".//*[@title='Triggers:Query']")
	WebElementFacade TriggersQueryButton;

	@FindBy(xpath=".//*[@title='Triggers:Query']")
	WebElement TriggersQueryButtonWebElement;

	@FindBy(xpath=".//*[@aria-label='Triggers:Go']")
	WebElementFacade TriggersGoButton;

	@FindBy(xpath=".//*[text()='WIP']")
	WebElementFacade WIPField;

	@FindBy(xpath="(.//*[text()='Request Source'])[1]//following-sibling::td")
	WebElementFacade RequestSourceElement;

	@FindBy(xpath="(.//*[text()='Request Source'])[1]//following-sibling::td/span")
	WebElementFacade RequestSourceDropdown;

	@FindBy(xpath=".//li[text()='IN']")
	WebElementFacade INField;
	@FindBy(xpath=".//li[text()='NOT IN']")
	WebElementFacade NOTINField;
	@FindBy(xpath=".//li[text()='IS NULL']")
	WebElementFacade ISNULLField;
	@FindBy(xpath=".//li[text()='IS NOT NULL']")
	WebElementFacade ISNOTNULLField;

	@Step
	public void SMSandEmailEngineInSiteMap(String UIName) throws InterruptedException, IOException, AWTException {
		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
		String dataSheet = "DivisonFilter";
		String  table = "//table[@summary='Triggers']";
		String  applet = "//*[@title='Triggers List Applet']";

		Common.waitForPageLoad(getDriver());
		if(SiteMap.isCurrentlyVisible()){                  		
			SiteMap.click();
			Thread.sleep(2000);

		}else
		{                  		
			Iconbar.click();
			Thread.sleep(2000);
			SiteMap.click();
			Thread.sleep(2000);
		}
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		Common.waitForElement(SMSEmailEngineLinkWebElement);                   	
		SMSEmailEngineLink.click(); 
		sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Size").size();i++) {
			String sQuery = tableMap.get("Query").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);                        	 
			String Index = tableMap.get("Index").get(i);

			if(sQuery.equalsIgnoreCase("Yes")){
				Common.waitForElement(TriggersQueryButtonWebElement);   
				TriggersQueryButton.click();

			}

			if (Index.equals("")){
				Index = "0";
			}
			if (!sLocateCol.equals("")){
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,Index ).equals("true"));
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			else{
				Common.selectedRow = 1;
			}
			if (!sUIName.equals("")){                                             
				Common.updateSiebList(applet,table, sUIName, sValue); 
				Thread.sleep(2000); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
			if(sQuery.equalsIgnoreCase("GoButton")){
				TriggersGoButton.click();
				Thread.sleep(2000); 
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				Assert.assertTrue("Fail: WIP Field is not present as expected",WIPField.isCurrentlyVisible());
				report.Info("WIP Field is present as expected");

				RequestSourceElement.click();
				RequestSourceDropdown.click();
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

				Assert.assertTrue("Fail: IN Field is not present in Request Source dropdown",INField.isCurrentlyVisible());
				report.Info("IN Field is present in Request Source dropdown");

				Assert.assertTrue("Fail: NOT IN Field is not present in Request Source dropdown",NOTINField.isCurrentlyVisible());
				report.Info("NOT IN Field is present in Request Source dropdown");

				Assert.assertTrue("Fail: IS NULL Field is not present in Request Source dropdown",ISNULLField.isCurrentlyVisible());
				report.Info("IS NULL Field is present in Request Source dropdown");

				Assert.assertTrue("Fail: IS NOT NULL Field is not present in Request Source dropdown",ISNOTNULLField.isCurrentlyVisible());
				report.Info("IS NOT NULL Field is present in Request Source dropdown");
			}

		}
	}
	public void CustomerCommValidation(String Action) throws IOException, InterruptedException, AWTException{
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "CreateNewServiceRequest";
		String applet = "//*[@title='Customer Comms List List Applet']";
		String table = "//table[@summary='Customer Comms List']";

		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0;i < tableMap.get("Row").size();i++) {
			String sButton = tableMap.get("Button").get(i);
			String sPopup = tableMap.get("Popup").get(i);
			String sLocateCol = tableMap.get("LocateCol").get(i);
			String sLocateColValue = tableMap.get("LocateColValue").get(i);
			String indexValue = tableMap.get("Index").get(i);
			String sUIName = tableMap.get("UIName").get(i);
			String sValue = tableMap.get("Value").get(i);
			Alert alert;
			String ActAlertText="";	
			if(indexValue.equals("")){
				indexValue = "0";
			}
			if (sLocateColValue.equals("ID")){
				sLocateColValue = Serenity.sessionVariableCalled("InsatllID").toString();
			}
			if(!sLocateCol.equals("")) {
				getDriver().navigate().refresh();
				Thread.sleep(4000);
				Common.selectedRow = -1;
				Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue).equals("true"));
				report.Info(sLocateCol+"Value found");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());								  
			}
			else 
			{
				Common.selectedRow = 1;
			}
			if(!sUIName.equals("")) {
				Common.updateSiebList(applet,table, sUIName, sValue);
				Thread.sleep(2000);
				report.Info("Clicked sucessfully");
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(sUIName.contains("CaptureTextValue")) {
					String comments = 	Common.updateSiebList(applet,table, sUIName, sValue);
					Assert.assertTrue("Comment message do not match", comments.contains("Hello"));
					report.Info("Comment message matched");
					sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				}
			}

		}

	}
	
	@FindBy(xpath=".//*[@class='siebui-button-toolbar siebui-closed']")
    WebElementFacade SiteMapButton;
	 
    @FindBy(xpath=".//*[@class='siebui-icon-tb-sitemap ToolbarButtonOn']")
    WebElementFacade SiteMapIcon;
    
    @FindBy(xpath="(.//a[text()='Administration - Business Process'])[1]")
    WebElementFacade AdminBusinessProcessLink;
    
    @FindBy(xpath=".//input[@aria-labelledby='QueryComboBox_Label']")
    WebElementFacade PoliciesListDropdown;
    
    @FindBy(xpath=".//input[@aria-labelledby='QuerySrchSpec_Label']")
    WebElementFacade PoliciesListValue;
    
    @FindBy(xpath=".//button[@title='Policies List:Go']")
    WebElementFacade PoliciesListGoButton;
    
    @FindBy(xpath="(.//a[text()='Workflow Policies'])[1]")
    WebElementFacade WorkflowPolicyLink;
    
    @FindBy(xpath=".//*[@title='Policies List Menu']")
    WebElementFacade MenuIcon;
    
    @FindBy(xpath="//span/ul/li[12]/a")
    WebElementFacade aboutRecord;
        
     
    @Step
   
    public void AdminBusinessProcess() throws InterruptedException {
   	 
   	 String applet = "//*[@title='Policies List List Applet']";
	     String table = "//table[@summary='Policies List']";
	     SiteMapButton.click();
	     SiteMapIcon.click();
	     AdminBusinessProcessLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	     AdminBusinessProcessLink.click();
	     Thread.sleep(3000);
	     //WorkflowPolicyLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	     WorkflowPolicyLink.click();
	     Thread.sleep(3000);
	     //PoliciesListDropdown.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	     PoliciesListDropdown.type("Name");
	     Thread.sleep(2000);
	     PoliciesListValue.typeAndEnter("SWI Profile Update Policy");
	     //PoliciesListValue.type("SWI Profile Update Policy");
	     Thread.sleep(2000);
	     //PoliciesListGoButton.click();
	     
	     Common.selectedRow = -1;
        Assert.assertTrue(Common.locateColumn(applet,table, "Name", "SWI Profile Update Policy", "0").equals("true"));
        Thread.sleep(3000);
        MenuIcon.click();
        Thread.sleep(1000);
        aboutRecord.click();	     
    }
    
		    @FindBy(xpath=".//*[text()='Tools']")
			WebElementFacade ToolsButton;
			@FindBy(xpath=".//*[text()='User Preferences']")
			WebElementFacade UserPreferencesOption;
			@FindBy(xpath=".//*[@aria-labelledby='Position_Label']")
			WebElementFacade PostionLabel;
			@FindBy(xpath=".//*[@aria-labelledby='Division_Label']")
			WebElementFacade DivisionLabel;
			
			@Step
			public void CheckDivision() throws InterruptedException, IOException, AWTException {
				
				ToolsButton.click();
				UserPreferencesOption.click();
				String ActPosition=PostionLabel.getTextValue();
				
				Assert.assertTrue("Fail: Position is Customer Relations",!ActPosition.equalsIgnoreCase("Customer Relations"));
				report.Info("Position is not Customer Relations and is:"+ActPosition);
				
				String ActDivision=DivisionLabel.getTextValue();
				
				Assert.assertTrue("Fail: Division is Customer Relations",!ActDivision.equalsIgnoreCase("Customer Relations"));
				report.Info("Division is not Customer Relations and is:"+ActDivision);
				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
            @FindBy(xpath="(.//a[text()='Administration - Business Process'])[1]")
            WebElementFacade AdminiBusinessProcess;
            @FindBy(xpath=".//a[text()='Workflow Policies']")
            WebElementFacade WorkflowPolicies;
            @FindBy(xpath=".//*[@title='Policies List:Query']")
            WebElementFacade PoliciesQuery;
            @FindBy(xpath=".//button[@title='Policies List Menu']")
     	   WebElementFacade PoliciesListMenuList;
     	 		  
     	   @FindBy(xpath=".//span/ul/li[12]/a")
     	   WebElementFacade MenulistAboutRecord;

            @Step
            public void AdministraionBusinessProcess(String UIName) throws InterruptedException, IOException, AWTException {
                String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
                String dataSheet = "DivisonFilter";
                String table = "//table[@summary='Policies List']";
                String applet = "//*[@title='Policies List List Applet']";
                
                if(SiteMap.isCurrentlyVisible()){
                	//SiteMap.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                	Common.waitForPageLoad(getDriver());
                	SiteMap.click();
                	Thread.sleep(2000);
                	
                }else
                {
                //Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
                	Common.waitForPageLoad(getDriver());
                Iconbar.click();
                Thread.sleep(2000);

                SiteMap.click();
                Thread.sleep(2000);
                }
                
                //AdministrationDataLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                Common.waitForPageLoad(getDriver());
                AdminiBusinessProcess.click();
                //ListOfValuesLink.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                Common.waitForPageLoad(getDriver());
                WorkflowPolicies.click();
                
                
                Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(UIName, filePath, dataSheet);
                readWorkbook.testData(tableMap);
                
                for (int i = 0;i < tableMap.get("Size").size();i++) {
                  String Size = tableMap.get("Size").get(i);
                  String sValue = tableMap.get("Value").get(i);
                  String UIName1 = tableMap.get("UIName").get(i);
                  String sLocateCol = tableMap.get("LocateCol").get(i);
                  String sLocateColValue = tableMap.get("LocateColValue").get(i);
                  String Index = tableMap.get("Index").get(i);
                  String sQuery = tableMap.get("Query").get(i);
                  //String sCheckBox = tableMap.get("CheckBox").get(i);
                  
                  if (Index.equals("")){
                	  Index = "0";
	            }
                      
                 if(sQuery.equalsIgnoreCase("Yes")){
                	 //Query.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
                	 Common.waitForPageLoad(getDriver());
                	 PoliciesQuery.click();
                	 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                 }
                	if (!sLocateCol.equals("")){
                      Common.selectedRow = -1;
                     Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue,Index ).equals("true"));
                     sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                     if(sValue.equalsIgnoreCase("GetRecord")){
                     	
                    	 PoliciesListMenuList.click();
        	           	  Thread.sleep(1000);	
        	           	  MenulistAboutRecord.click();
        	           	  Thread.sleep(2000);
        	           	sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());

        	             }
                	}
                 else{
                       Common.selectedRow = 1;
                 }
                 if (!UIName1.equals("")&&!UIName1.equals("CheckBoxStatusChecked")){                                             
                    Common.updateSiebList(applet,table, UIName1, sValue);
                  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                 
                     }
           
                } 
            }
            

        	@FindBy(xpath="(.//a[text()='Administration - Server Management'])[1]")
        	WebElementFacade AdministrationValidationManagement;
        	
        	@FindBy(xpath=".//*[@id='j_s_sctrl_tabScreen']")
        	WebElementFacade FristLevelViewBar;

        	@FindBy(xpath=".//*[@aria-label='Products:Query']")
        	WebElementFacade ProductQueryButton;

        	@FindBy(xpath="(.//*[@aria-labelledby='Type_Label'])[1]")
        	WebElementFacade ProductTypeLabel;
        	
        	@FindBy(xpath=".//*[@aria-labelledby='FINS_Name_Label']")
        	WebElementFacade ProductsTextArea;
        	
        	@FindBy(xpath="(.//*[text()='Administration - Product'])[1]")
        	WebElement AdminProduct;
        	
        	@FindBy(xpath="(.//*[text()='Administration - Product'])[2]")
        	WebElement AdminProduct2;
        	
        	
            @Step
            public void Custom_XM(String UIName) throws InterruptedException, IOException, AWTException {
                
            	if(SiteMap.isCurrentlyVisible()){
            		Common.waitForPageLoad(getDriver());
            		SiteMap.click();
            		Thread.sleep(2000);

            	}else {
            		Common.waitForPageLoad(getDriver());
            		Iconbar.click();
            		Thread.sleep(2000);

            		SiteMap.click();
            		Thread.sleep(2000);
            	}

            	Common.waitForPageLoad(getDriver());
            	AdministrationNewcolink.click();
            	
            }
            @SuppressWarnings("unlikely-arg-type")
        	@Step
        	public void AdminProductValidation(String Template) throws InterruptedException, IOException, AWTException {
        		String filePath = "\\src\\test\\resources\\data\\ServerManagement.xls";
        		String applet = "//*[@title='Products List Applet']";
        		String table = "//table[@summary='Products']";
        		String dataSheet = "AdminProdValidation";

        		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Template, filePath, dataSheet);
        		readWorkbook.testData(tableMap);
        		Common.WaitForClock(Clockobj);
        		for (int i = 0;i < tableMap.get("RowNo").size();i++) {
        			String sLocateCol = tableMap.get("LocateCol").get(i);
        			String sLocateColValue = tableMap.get("LocateColValue").get(i);
        			String UIName  = tableMap.get("UIName").get(i);
        			String value  = tableMap.get("Value").get(i);
        			String sValidations  = tableMap.get("Validation").get(i);
        			String indexValue = "0";

        			if(SiteMap.isCurrentlyVisible()){
        				Common.waitForPageLoad(getDriver());
        				SiteMap.click();
        				Thread.sleep(2000);
        				Common.WaitForClock(Clockobj);
        			}
        			else
        			{
        				Iconbar.withTimeoutOf(120,TimeUnit.SECONDS).isCurrentlyVisible();
        				Common.waitForPageLoad(getDriver());
        				Iconbar.click();
        				Thread.sleep(2000);
        				SiteMap.click();
        				Common.WaitForClock(Clockobj);
        			}
        			if(AdminProduct.isDisplayed())
        			{
        				AdminProduct.click();
        				Common.WaitForClock(Clockobj);
        				AdminProduct2.click();
        				Common.WaitForClock(Clockobj);
        				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        			}
        			else
        			{
        				FristLevelViewBar.selectByVisibleText("Administration - Product");
        				Common.WaitForClock(Clockobj);
        				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        			}
        			if(ProductQueryButton.isCurrentlyVisible())
        			{
        				ProductQueryButton.click();
        				Thread.sleep(1000);
        				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        			}
        			if (!sLocateCol.equals("")){
        				Common.selectedRow = -1;
        				String sResult = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, indexValue);

        				Assert.assertTrue(sResult,sResult.equals("true")); 
        				report.Info("Row is selected successfully with column name: "+sLocateCol+ " and value: "+sLocateColValue);           

        			}
        			else{
        				Common.selectedRow = 1;
        			}
        			if (!UIName.equals("")){ 
        				Common.updateSiebList(applet,table, UIName, value);           
        				Thread.sleep(1000);
        				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        			}
        			if(sValidations.equalsIgnoreCase("ValidateTypeTBO"))
        			{
        				ProductsTextArea.typeAndEnter("VOXI 6GB Plan");
        				Thread.sleep(1000);
        				Assert.assertTrue("Type is not matching as expected", ProductTypeLabel.equals("VOXI TBO"));
        				Thread.sleep(1000);
        				sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
        			}
        		}
        	}
}

