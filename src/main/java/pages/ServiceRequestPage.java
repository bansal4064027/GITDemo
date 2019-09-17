package pages;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import pages.DatabasePage;

public class ServiceRequestPage extends PageObject {
	private static final TimeUnit SECONDS = null;
	private static final WebElementState ErrorTitleBox2 = null;
	@Steps
    private ReadWorkbook readWorkbook;
	@Steps
	private common Common;
	@Steps
	private SikuliUtility SikuliUtility;
	@Steps
	private DatabasePage Database;	
	@Steps
	ReportMessege report;
	@Steps
	private ServiceRequestPage serviceRequest;	
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
	@FindBy(xpath=".//*[@title='Service Requests']/parent::a")
	  WebElementFacade ServiceRequestsTab;
	  
	  @FindBy(xpath=".//*[@aria-label='First Level View Bar']")
	  WebElementFacade HomepageTabDropdown;
	  
	  @FindBy(xpath="//select[@title='Visibility']")
	  WebElementFacade ServiceRequestList;
	  
	  @FindBy(xpath=".//*[@title='Service Requests List Applet']")
	  WebElementFacade ServiceRequestApplet;
	  
	 	@FindBy(xpath=".//*[@title='Service Requests:New']")
	    WebElementFacade NewServiceRequest;
	    
	    @FindBy(xpath=".//div[contains(@id,'INS_Product')]/following::td[contains(@id,'INS_Product')][1]")
	    WebElementFacade ServiceRequestTypeElement;
	    
	    @FindBy(xpath="(.//*[contains(@aria-labelledby,'INS_Product')])[1]/following-sibling::span")
	    WebElementFacade SRTypeDropDownIcon;
	    
	    @FindBy(xpath=".//div[contains(@id,'VF_SLA')]/following::td[contains(@id,'VF_SLA')][1]")
	    WebElementFacade SLAElement;
	    
	    @FindBy(xpath=".//div[contains(@id,'VF_SLA')]/following::td[contains(@id,'VF_SLA')][1]")
	    WebElement SLAElementWebElement;
	    
	    @FindBy(xpath=".//*[@title='Pick Contact:OK']")
	    WebElementFacade ContactOKButton;
	    
	    @FindBy(xpath=".//*[@title='Pick Account:OK']")
	    WebElementFacade AccountOKButton;
	    
	    @FindBy(xpath=".//*[@title='Pick Asset:OK']")
	    WebElementFacade AssetOKButton;
	    
	    @FindBy(xpath=".//input[@name='SR_Number']")
	    WebElementFacade IDTextBox;

	    @FindBy(xpath=".//*[@aria-label='Resolution Comment']")
	    WebElementFacade ResolutionCommentTextBox;
	    
	    @FindBy(xpath=".//*[@aria-label='SR Resolution Code']")
	    WebElementFacade ResolutionCodeTextBox;
	    
	    @FindBy(xpath=".//*[@title='Service Requests:SR Resolved']")
	    WebElementFacade SRResolvedButton;
	    
	    @FindBy(xpath=".//*[@title='Service Requests:Amend/Work SR']")
	    WebElementFacade SRAmmendButton;
	    
	    @FindBy(xpath=".//*[@title='Service Requests Menu']")
	    WebElementFacade SRMenuButton;
	    
	    @FindBy(xpath="//span/ul/li[9]/a")
	    WebElementFacade RefreshRecord;
	  
	    @FindBy(xpath="//span/ul/li[6]/a")
	    WebElementFacade SRSave;
	    	
	    @FindBy(xpath=".//*[@title='Service Requests Form Applet']")
	    WebElementFacade SRSavedApplet;
	    
	    @FindBy(xpath=".//div[contains(@id,'VF_SLA')]/following::td[contains(@id,'SR_Number')][1]")
	    WebElementFacade SRInstalledIDElement;  
	    
	    @FindBy(xpath=".//*[@title='Service Requests:New']//following::button[@title='Service Requests:Go'][1]")
	    WebElementFacade ServiceRequestGoButton;
	    
	    @FindBy(xpath="(.//*[@aria-label='Pick Contact:Go'])[2]")
	    WebElementFacade ContactGOButton;
	    
	    @FindBy(xpath=".//*[@aria-label='Pick Asset:OK']")
  		WebElementFacade OKButtonPickAssetApplet;
	    
	    @FindBy(xpath="(.//*[@aria-label='Find'])[2]")
  		WebElementFacade ContactAppletDropDown;
	    
	    @FindBy(xpath=".//*[@title='Pick Contact:Query']")
  		WebElementFacade QueryButtoninPickContact;
	    @FindBy(xpath="(.//*[@title='Pick Contact:Go'])[1]")
  		WebElementFacade GoButtoninPickContact;
	    @FindBy(xpath="//span/ul/li[1]/a")
	    WebElementFacade SRUndo;
	    
	    @FindBy(xpath=".//*[@aria-label='Pick Service Request Owner:OK']")
	    WebElementFacade OKButtoninPickOwner;
	    @FindBy(xpath="(.//*[@aria-label='Pick Service Request Owner:Go'])[1]")
	    WebElementFacade GoButtoninPickOwner;	    
	    @FindBy(xpath=".//*[@aria-label='Pick Service Request Owner:Query']")
	    WebElementFacade QueryButtoninPickOwner;
	    @FindBy(xpath=".//a[@name='Owner']")
	    WebElementFacade OwnerTextBox;
	    
	    @FindBy(xpath=".//*[contains(text(),'Halo - please read')]")
		  WebElementFacade ErrorTitleBox;
		 @FindBy(xpath=".//div[contains(@class,'popup-info')]  ")
		  WebElementFacade ErrorMsg; 
		 @FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
		  WebElementFacade ErrorOkButton;
		 @FindBy(xpath=".//*[text()='Service Requests List']")
		    WebElementFacade ServiceRequestListLink;
		 @FindBy(xpath=".//*[text()='Service Requests List']")
		    WebElement ServiceRequestListLinkWebElement;
		 
		 @FindBy(xpath="//span/ul/li[8]/a")
		    WebElementFacade SRQuery;
	    
	    
	     public void CreateServiceRequestViaServiceRequest(String rowname) throws InterruptedException, IOException, AWTException{

	      	  String filePath = "\\src\\test\\resources\\data\\Account.xls";
	   		  String dataSheet = "CreateNewServiceRequest";
	   		  String applet = "";
	            String table = "";
	            Robot robot = new Robot();   
	   		    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
	   		    readWorkbook.testData(tableMap);
	   		    
	   		 Common.WaitForClock(Clockobj);
	   		 
	   		    for (int i = 0;i < tableMap.get("Row").size();i++) {		    	
	   	            String sValue = tableMap.get("Value").get(i);
	   	            String sClickNew = tableMap.get("ClickNew").get(i);
	   	            String sUIName = tableMap.get("UIName").get(i);
	   	            String sSave = tableMap.get("Save").get(i);
	   	            String sButton = tableMap.get("Button").get(i);
	   	            String sClickQuery = tableMap.get("ClickQuery").get(i);
	   	            String sSelectMenu = tableMap.get("SelectMenu").get(i);
	   	            String sSelectView = tableMap.get("SelectView").get(i);
	   	            Boolean  flag = false;
	   	            Boolean  CustomerRelationFlag = false;
	   	            String InstalledId = "";
	   	            String sPopup = tableMap.get("Popup").get(i);
		   	        Alert alert;
	                String ActAlertText="";	
	                if(!sSelectView.equals("")){
	                	if(ServiceRequestsTab.isVisible()){
	                		ServiceRequestsTab.click();
	                	}
	                	else{
	                		HomepageTabDropdown.selectByVisibleText("Service Requests");
	                	}
	                	Thread.sleep(2000);
	                	Common.WaitForClock(Clockobj);
	                	Common.waitForElement(ServiceRequestListLinkWebElement);	
	                	
	                	if(ServiceRequestListLink.isCurrentlyEnabled()) {
	                		ServiceRequestListLink.click();
		                	Common.WaitForClock(Clockobj);
		                	Thread.sleep(2000);
		                	
	                	}

	                	String selectedValue = ServiceRequestList.getSelectedValue();
	                	//String SelectViewPath = "//option[text()='"+sSelectView+"']"; 
	                	String SelectViewPath = "//option[contains(text(),'"+sSelectView+"')]";
	                	
	                	if(!selectedValue.contains(sSelectView)){
	                		ServiceRequestList.click();
	                		find(By.xpath(SelectViewPath)).click();
	                		//ServiceRequestList.selectByVisibleText(sSelectView);
	                		Thread.sleep(2000);
	                		Common.WaitForClock(Clockobj);
	                		SRMenuButton.withTimeoutOf(220,TimeUnit.SECONDS).waitUntilClickable();
	                		
	                	}
	                	SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());


	                	if(ServiceRequestApplet.isPresent()){
	                		System.out.println("Service Request screen is displayed successfully for "+sSelectView+" view");
	                		report.Info("Service Request screen is displayed successfully for "+sSelectView+" view");
	                	}
	                	else{
	                		Assert.assertTrue("Service Request screen is not displayed successfully for "+sSelectView+" view", ServiceRequestApplet.isPresent());
	                		break;
	                	}
	                } 
	   	            
	   	            
	   	            if (sClickNew.equalsIgnoreCase("Yes")){	    	
	   			    	NewServiceRequest.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	   	           
	   		    		NewServiceRequest.click();
	   		    		Thread.sleep(4000);
	   		    		InstalledId=SRInstalledIDElement.getAttribute("title");
	   		    		Serenity.setSessionVariable("SRInstalledID").to(InstalledId);
	   		    		report.Info("SR ID Created : "+InstalledId);
	   		    		SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   		    		   if (sUIName.equals("")){
	   		    			   ServiceRequestTypeElement.click();	
	   					       SRTypeDropDownIcon.click();
	   					    SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   			          	   report.Info("Info, LOVs in SR Type drop down");
	   		    		   }    		
	   	            }
	   	       
	   	            
	   	         Common.WaitForClock(Clockobj);
	   	            if(sButton.equalsIgnoreCase("SR Tab")){
	   	            	if(ServiceRequestsTab.isVisible()){
	   			    		ServiceRequestsTab.click();
	   			    	}
	   			    	else{
	   			    		HomepageTabDropdown.selectByVisibleText("Service Requests");
	   			    	}
	   	            	Common.WaitForClock(Clockobj);
	   	            	Common.waitForElement(ServiceRequestListLinkWebElement);
	   	            	//ServiceRequestListLink.withTimeoutOf(220,TimeUnit.SECONDS).waitUntilClickable();
		   	        	ServiceRequestListLink.click();
		   	        	Common.WaitForClock(Clockobj);
		   	        	ServiceRequestList.withTimeoutOf(220,TimeUnit.SECONDS).isPresent();
	   	            }
	   	         if (sButton.equals("TypeDropDown")){
					       SRTypeDropDownIcon.click();
					       SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			          	   report.Info("Info, LOVs in SR Type drop down");
		    		   }
	   	            
	   	            Common.selectedRow = 1;
	   	            if (!sUIName.equals("")){
	   	            	
	   	            	SLAElement.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilClickable();
	   	            	 SLAElement.click();
	   	            	Thread.sleep(1000);
	   	            	applet = "//*[@title='Service Requests List Applet']";
	   		            table = "//table[contains(@summary,'Service Request')]";
	   	            	  if(sUIName.equalsIgnoreCase("Text|VF_Sla_Calculated")){
	   	            		GregorianCalendar calendar = new GregorianCalendar();
	   	      	            calendar.add(calendar.DAY_OF_MONTH, 1);
	   	      	            Date tomorrow = calendar.getTime();
	   	      	            DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");		        
	   	      	            String formattedDate = dateFormat.format(tomorrow);
	   	      	            sValue=formattedDate;
	   	            	  }
	   	            	  
	   	            	if (sSelectMenu.contains("All Service Requests")){
	   	            		applet = "//*[@title='Service Requests List Applet']";
	   	            		table = "//table[contains(@summary,'Service Request')]";
	   	            	  }
	   	            	  
	   	 	              String getText = Common.updateSiebList(applet,table, sUIName, sValue); 
	   	 	              Thread.sleep(4000);
	   	 	              
	   	 	              
	   	 	          if(sUIName.equalsIgnoreCase("OpenPopUp|Contact_Last_Name")){
	   	 	            	 ContactOKButton.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
		   	 	            	 if(sValue.equalsIgnoreCase("Account No")){
			   	 	            		applet = "//*[@title='Pick Contact List Applet']";
			   	 	            		table = "//table[contains(@summary,'Pick Contact')]";
		   	 	            	
				   	 	            	QueryButtoninPickContact.click();	
				   	 	            	String sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString();  
							        	Common.updateSiebList(applet,table, "Text|Account_Number", sAccountNo);
				   	 	            	GoButtoninPickContact.click();
				   	 	            	
				   	 	            	int PickContactTableSize= findAll(By.xpath("//table[@summary='Pick Contact']/tbody/tr")).size();
				   	 	            	if(PickContactTableSize>1){
								   	           	  report.Info("Account Number available: "+sAccountNo);
						   	                   }
						   	             else{
						   	            	SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						   	           	  Assert.assertTrue("No rows displayed after clicking on Go button- Account not "+sAccountNo+ "available", PickContactTableSize>1);
						   	             }
				   	 	            SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				   	 	            ContactOKButton.click();
		   	 	            	 	}
		   	 	            	
		   	 	            	 else{
		   	 	            		ContactOKButton.click();
		   	 	            	 }
	   	 	            	 
	   	 	              }
	   	 	          
	   	 	      if(sUIName.equalsIgnoreCase("OpenPopUp|Owner")){
 	 	    	  		QueryButtoninPickOwner.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
 	 	            	 
	   	 	            		applet = "//*[@title='Pick Service Request Owner List Applet']";
	   	 	            		table = "//table[contains(@summary,'Pick Service Request Owner')]";
 	 	            	
	   	 	            	QueryButtoninPickOwner.click();	
		   	 	            	Common.updateSiebList(applet,table, "Text|Last_Name",sValue);
		   	 	            GoButtoninPickOwner.click();
		   	 	            	
		   	 	            	int PickContactTableSize= findAll(By.xpath("//table[@summary='Pick Service Request Owner']/tbody/tr")).size();
		   	 	            	if(PickContactTableSize>1){
						   	           	  report.Info("Owner available: "+sValue);
				   	                   }
				   	             else{
				   	            	SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				   	           	    Assert.assertTrue("No rows displayed after clicking on Go button- Owner: "+sValue+ " not available", PickContactTableSize>1);
				   	             }
		   	 	            SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   	 	            OKButtoninPickOwner.click();
 	 	            	 	}
	   	 	              
	   	 	          if (sUIName.contains("CTN")){
		   	  	    		Thread.sleep(2000);
		   	  	    	    
		   	  	    		OKButtonPickAssetApplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		   	  	    		SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   	  	    		OKButtonPickAssetApplet.click();
	   	 	          }
	   	 	          
	   	 	             if(sUIName.equalsIgnoreCase("OpenPopUp|Account")){
	   	 	               
	   	 	            	AccountOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	   	 	            	SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   	 	            	AccountOKButton.click();
	   	 	              }
	   	 	            if(sUIName.equalsIgnoreCase("OpenPopUp|Asset_Number")){
	   	 	            	AssetOKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	   	 	              
	   	 	            	SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   	 	            	AssetOKButton.click();
	   	 	              }
	   	 	             
	   	 	            
	   	 	            if(sUIName.equalsIgnoreCase("CaptureTextValue|Status")){
	   	 	            	if(getText.equalsIgnoreCase(sValue)){
	   		 	            	report.Info("Status of SR is "+getText+" as expected");
	   		 	            }
	   	 	            	else{
	   	 	            		Assert.assertTrue("Status of SR "+getText+" does not match expected value",getText.equalsIgnoreCase(sValue));
	   	 	            	}
	   	 	            }
	   	 	           if(sUIName.equalsIgnoreCase("CaptureTextValue|Closed_Date")){
	   	 	        	   if(sValue.equalsIgnoreCase("Populated")){
	   		 	            	if(!getText.equals("")){
	   		 	            		report.Info("Closed date is populated as expected, closed date is"+getText);
	   		 	            	}
	   		 	            	else{
	   		 	            		Assert.assertTrue("Closed date is not populated as expected",!getText.equals(""));
	   		 	            	}
	   	 	        	   }
	   	 	            }
	   	 	      	 	             
	   	 	    	  }
	   	            else{
	   	            	if(!sValue.equals("")){
	   	            		List<WebElement> options = getDriver().findElements(By.xpath(".//div[@name='_sweview']/ul[@role='combobox']/li")); 	        
	   			 	        List<String> text = new ArrayList<String>();
	   		 	       
	   				 	        for(int j=0; j<options.size(); j++) {
	   				 	            text.add(options.get(j).getText());		 	            
	   				 	        } 
	   				 	       Iterator<String> itr = text.iterator();
	   				 	      
	   			 	            while(itr.hasNext()) {		 	            	
	   			 	             String currentValue= itr.next();		 	             	 	            	 
	   				 	            if(currentValue.equalsIgnoreCase(sValue)){
	   				 	            	flag=true;	
	   				 	            	report.Info(currentValue+" is present in SR Type drop down" );
	   				 	            	System.out.println(currentValue+" is present in SR Type drop down"); 
	   				 	            	break;
	   				 	            }
	   			 	            }
	   				 	            
			 	            	   			 	           
	   			 	          Assert.assertTrue(sValue+" is not present in SR Type drop down",flag==true);
	   			 	         
	   	            	}	         
	   	            }  
	   	         if(sSelectMenu.equalsIgnoreCase("Validate")){
	   	        	 	List<WebElement> options = getDriver().findElements(By.xpath(".//div[@name='_sweview']//ul[@role='combobox']/li")); 	        
			 	        List<String> text = new ArrayList<String>();
		 	       
				 	        for(int j=0; j<options.size(); j++) {
				 	            text.add(options.get(j).getText());		 	            
				 	        } 
				 	       Iterator<String> itr = text.iterator();
		 	            while(itr.hasNext()) {
		 	            	String currentValue= itr.next();
			 	            if(currentValue.equalsIgnoreCase("Customer Relations")){
			 	            	CustomerRelationFlag=true;
			 	            }
		 	            }
		 	           report.Info("Customer Relation is not present in SR Type drop down");
		 	           Assert.assertTrue("Customer Relation is present in SR Type drop down",CustomerRelationFlag==false); 
	 	            }	   	        
	   	         
	   	            if(sSave.equalsIgnoreCase("yes")){		            	
		   	        	 Thread.sleep(3000);	 
		   	        	 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   	        	 SRMenuButton.click();
		   	        	 Thread.sleep(1000);
		   	        	 SRSave.click();
		   	        	 Thread.sleep(3000);

		   	        	 if(isAlertPresent(getDriver())){
		   	        		 alert=getDriver().switchTo().alert();
		   	        		 ActAlertText=alert.getText(); 
		   	        		 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   	        		 if (ActAlertText.contains(sPopup)){                    	
		   	        			 alert.accept();
		   	        			 System.out.println("Message is: "+ActAlertText);
		   	        			 report.Info("alert messsage is"+ActAlertText);
		   	        			 System.out.println("Message is: "+ActAlertText);
		   	        		 }                                 
		   	        	 }  

		   	        	 if(ErrorTitleBox.isCurrentlyVisible()){
		   	        		 String ErrorInfo= ErrorMsg.getText();
		   	        		 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		   	        		 ErrorOkButton.click();
		   	        		 report.Info("The alert meassage is:"+ErrorInfo);
		   	        	 }

		   	        	 //SLsAElement.sendKeys(Keys.chord(Keys.CONTROL, "s"));
		   	         }
	   	            
	   	            if(sClickQuery.equalsIgnoreCase("Yes")){	            	
	   	            	Thread.sleep(3000);
	   	            	SRMenuButton.withTimeoutOf(220,TimeUnit.SECONDS).waitUntilClickable();
	   	                // Common.waitForPageLoad(getDriver());
	   	            	SRMenuButton.click();
	   	            	SRQuery.click();
	   	            	//SLAElement.sendKeys(Keys.chord(Keys.ALT, "q"));
	   	            	Thread.sleep(3000);
	   	            	report.Info("Search query clicked");
	   	        		String IDValue = Serenity.sessionVariableCalled("SRInstalledID").toString();
	   	        		IDTextBox.typeAndEnter(IDValue);
	   	        		if(IDTextBox.isCurrentlyVisible()) {
	   	        			IDTextBox.sendKeys(Keys.chord(Keys.ENTER));
	   	        		}
	   	        		
	   	        		SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   	        		Thread.sleep(1000);
	   	        		//ServiceRequestGoButton.click();	 
	   	        		report.Info("Go button clicked");
	   	        		SLAElement.click();
	   	            }
	   	            if(sButton.equalsIgnoreCase("SR Resolved")){
	   	            	ResolutionCodeTextBox.type("Answered Question");
	   	            	Thread.sleep(1000);
	   	            	ResolutionCommentTextBox.type("tested");
	   	            	report.Info("");
	   	            	SRResolvedButton.click();
	   	            	
	   	            	report.Info("SR Resolved button clicked");
	   	            	Thread.sleep(1000);
	   	            	SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   	            }
	   	         if(sButton.equalsIgnoreCase("SR Ammend")){	   	          
	   	            	SRAmmendButton.click();
	   	            	
	   	            	report.Info("SR Ammend button clicked");
	   	            	Thread.sleep(3000);
	   	            	SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
	   	            }  
	   	      if(isAlertPresent(getDriver())){
	               alert=getDriver().switchTo().alert();
                   ActAlertText=alert.getText(); 
                   SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                   if (ActAlertText.contains(sPopup)){                    	
	                   	alert.accept();
	                   	System.out.println("Message is: "+ActAlertText);
	                   	report.Info("alert messsage is"+ActAlertText);
	                   	System.out.println("Message is: "+ActAlertText);
                  	}                                 
	            }  
	           if(!sPopup.equals("")){
		   	      	if(ErrorTitleBox.isCurrentlyVisible()){
		    			String ErrorInfo= ErrorMsg.getText();
		    			if(ErrorInfo.contains(sPopup)){	
		    				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    				ErrorOkButton.click();
		    				report.Info("The alert meassage is:"+ErrorInfo);
		    			}
		    			else{
		    				report.Info("The alert meassage not found:"+ErrorInfo);
		    				Assert.assertTrue(false);
		    			}
		           	}
	            	
	          }
	           if (sButton.equalsIgnoreCase("Undo Button")){
	 	    		Thread.sleep(1000);
	 	    		SRMenuButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
	 	    		SRMenuButton.click();
	 	    		Thread.sleep(1000);
	 	    		SRUndo.click();
	 	    		report.Info("Info, Service Request deleted ");	    		
	           }
	   		    }

	   		    robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_ENTER);
	   		    /*SRMenuButton.click();
	   		    RefreshRecord.click();*/
	     }
	     
public void ServiceRequestFieldValidation(String rowname) throws IOException, AWTException, InterruptedException{
	 
	  String filePath = "\\src\\test\\resources\\data\\Account.xls";
		  String dataSheet = "CreateNewServiceRequest";
		  
		    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
		    readWorkbook.testData(tableMap);
		    
		    for (int i = 0;i < tableMap.get("Row").size();i++) {		    	
	            String Value = tableMap.get("Value").get(i);
	            String Validate = tableMap.get("Validate").get(i);
	            String FieldtoValidate = tableMap.get("UIName").get(i);
	            String EditableElementXpath = "//input[@aria-label='"+FieldtoValidate+"']";
	            
    			String ElementXpath = ".//div[contains(@id,'VF_SLA')]/following::td[contains(@id,'"+Value+"')][1]";
    			String TextXpath = ".//div[contains(@id,'VF_SLA')]/following::td[contains(@id,'"+Value+"')][1]/input";
    			
    			if(Validate.equalsIgnoreCase("Disabled")){
    				getDriver().findElement(By.xpath(ElementXpath)).click();
    				String readonlyValue =getDriver().findElement(By.xpath(TextXpath)).getAttribute("aria-readonly");
    				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    				if(readonlyValue.equalsIgnoreCase("true")){
    					report.Info("The field "+FieldtoValidate+"is disabled as expected");   					
    				}
    				else{
    					Assert.assertTrue("The field "+FieldtoValidate+"is not disabled as expected",readonlyValue.equalsIgnoreCase("true"));
    				}
    			}
    			
    		if(Validate.equalsIgnoreCase("Populated")){
    			getDriver().findElement(By.xpath(ElementXpath)).click();
				String getText =getDriver().findElement(By.xpath(ElementXpath)).getAttribute("title");
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(!getText.equals("")){
	            		report.Info(FieldtoValidate+" is populated as expected, value is"+getText);
	            	}
	            	else{
	            		Assert.assertTrue(FieldtoValidate+" is not populated as expected",!getText.equals(""));
	            	}
    		}
    		
    		if(Validate.equalsIgnoreCase("Closed")){    			
				String getText =getDriver().findElement(By.xpath(ElementXpath)).getText();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				if(getText.equals(Validate)){
	            		report.Info(FieldtoValidate+" is "+Validate+" as expected");
	            	}
	            	else{
	            		Assert.assertTrue(FieldtoValidate+" is not as expected, value is "+getText,getText.equals(Validate));
	            	}
    		}
    		
    		if(Validate.equalsIgnoreCase("Editable")){
    			SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
    			Assert.assertTrue("The field "+FieldtoValidate+" is not enabled as expected",getDriver().findElement(By.xpath(EditableElementXpath)).isEnabled());
    			report.Info("The field "+FieldtoValidate+" is enabled as expected"); 
    			getDriver().findElement(By.xpath(EditableElementXpath)).click();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				
    		}
    			
		    }
}

		@FindBy(xpath="//a[text()='Activity Plan']")
		WebElementFacade ActivityPlanTab; 
		@FindBy(xpath="//a[text()='Activities']")
		WebElementFacade ActivitiesTab; 
		@FindBy(xpath=".//*[@aria-labelledby='Owner_Group_Label']")
		WebElementFacade GroupTextBox;
		@FindBy(xpath=".//*[@aria-label='Service Requests:SR Resolved']")
		WebElementFacade SRResolveButton;
		@FindBy(xpath=".//*[@aria-labelledby='Status_Label']")
		WebElementFacade StatusTextBox;
		@FindBy(xpath=".//*[@aria-label='Service Requests:Customer Account']")
		WebElementFacade CustomerAccountButtoninSR;
		@FindBy(xpath=".//*[@aria-labelledby='Resolution_Comment_Label']")
		WebElementFacade ResolutionTextBox;
		@FindBy(xpath="(.//*[@data-tabindex='tabScreen4'])[2]")
		WebElementFacade MoreInfoTab;		
		@FindBy(xpath=".//*[@aria-label='HelpDesk Service Request:New Address']")
		WebElementFacade NewAddressButton;		
		@FindBy(xpath=".//*[@aria-describedby='s_3_l_Postal_Code']")
		WebElementFacade PostCodeElement;		
		@FindBy(xpath=".//*[@aria-labelledby='s_3_l_Postal_Code ']")
		WebElementFacade PostCodeTextBox;		
		@FindBy(xpath=".//*[@aria-label='Postcode']")
		WebElementFacade GetPostCodeValue;
		@FindBy(xpath=".//*[@aria-label='VF SR Address Association pick Applet:OK']")
		WebElementFacade OKButton;			
		@FindBy(xpath=".//*[@aria-label='Postcode']")
		WebElementFacade ComparePostCode;
		@FindBy(xpath=".//*[@aria-label='Activities:New']")
		WebElementFacade ActivitiesNewButton;
		@FindBy(xpath=".//*[@aria-label='Activities:Duplicate Activity']")
		WebElementFacade DuplicateActivityButton;
		@FindBy(xpath=".//*[@aria-labelledby='SRNumber_Label']")
		WebElementFacade SRIDTextBox;
		
		@FindBy(xpath=".//*[@aria-labelledby='Owner_Label']/following-sibling::span")
		WebElementFacade OwnerLabelOpenPopUpButton;
		@FindBy(xpath=".//*[@aria-labelledby='PopupQueryCombobox_Label']")
		WebElementFacade ProductDropdown;
		@FindBy(xpath=".//*[@aria-labelledby='PopupQuerySrchspec_Label']")
		WebElementFacade SearchText;
		@FindBy(xpath=".//*[@title='Pick Service Request Owner:OK']")
		WebElementFacade GoButtoninPickOwnerApplet;
		
		@FindBy(xpath=".//*[@aria-label='Service Requests:Menu']")
		WebElementFacade SRMenuItemIcon;
		@FindBy(xpath="//span/ul/li[6]/a")
		WebElementFacade SaveRecord;
		@FindBy(xpath=".//*[@aria-labelledby='Abstract_Label']")
		WebElementFacade DescrptionTextBox;
		@FindBy(xpath=".//*[@aria-label='Sub status']")
		WebElementFacade SubStatusTextBox;
		@FindBy(xpath=".//*[@aria-label='Service Requests:Submit SR']")
		WebElementFacade SubmitSRButton;
		 @FindBy(xpath="//span/ul/li[12]/a")
         WebElementFacade aboutRecord;
		 
		 @FindBy(xpath="(.//td[contains(@id,'Postal_Code')])[1]")
		 WebElementFacade PostCodeInAddress;
		 @FindBy(xpath="(.//td[contains(@id,'Postal_Code')])[1]")
		 WebElement PostCodeInAddressElement;
		 @FindBy(xpath=".//*[@aria-label='Third Level View Bar']")
		 WebElementFacade AccountSummaryDropdown;
		 
		 @FindBy(xpath=".//textarea[contains(@aria-label,'Note')]")
		 WebElementFacade NoteTextbox;
		 @FindBy(xpath="(.//td[contains(@id,'Alarm')])[2]")
		 WebElementFacade AlarmSecondCheckBox;
		 
		 @FindBy(xpath=".//*[@aria-label='WIP']")
		 WebElementFacade WIPTextBox;
		 @FindBy(xpath=".//*[@aria-label='Asset ID']/following-sibling::span")
		 WebElementFacade AssetIDOpenPopUp;
		 @FindBy(xpath=".//*[@aria-label='SLA date']")
		 WebElementFacade SLADateafterDrilldown;
		 @FindBy(xpath=".//*[@aria-label='Service Requests:Amend/Work SR']")
		 WebElementFacade AmmendButton;
		 
		 @FindBy(xpath=".//*[@aria-labelledby='CommitTime_Label']")
		 WebElementFacade SLADateTextBox;
		 
		 @FindBy(xpath=".//*[text()='Submit SR']")
		 WebElementFacade SubmitSR;
		 
		 
		 public void ServiceRequestValiadtionInServiceRequest(String Action) throws InterruptedException, IOException, AWTException, ParseException{

			 String filePath = "\\src\\test\\resources\\data\\Account.xls";
			 String dataSheet = "ServiceRequest_Activities";

			 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
			 readWorkbook.testData(tableMap);

			 String applet = "";
			 String table = "";

			 for (int i = 0;i < tableMap.get("Row").size();i++) {
				 String sValue = tableMap.get("Value").get(i);
				 String sUIName = tableMap.get("UIName").get(i);
				 String sLocateCol = tableMap.get("LocateCol").get(i);
				 String sLocateColValue = tableMap.get("LocateColValue").get(i);
				 String Index = tableMap.get("Index").get(i);   
				 String sGroupValidation = tableMap.get("GroupValidation").get(i);
				 String sStatusValidation = tableMap.get("StatusValidation").get(i);
				 String sNavigation = tableMap.get("Navigation").get(i);
				 String sActivityTemplateValidation = tableMap.get("ActivityTemplateValidation").get(i);
				 String sServiceRequestClick = tableMap.get("ServiceRequestClick").get(i);
				 String sClickNew = tableMap.get("ClickNew").get(i);
				 String sButtonValidation = tableMap.get("ButtonValidation").get(i);
				 String sPopup = tableMap.get("Popup").get(i);
				 String sSubStatus = tableMap.get("SubStatus").get(i);
				 String sNotesValidation = tableMap.get("NotesValidation").get(i);
				 String sSLADate = tableMap.get("SLADate").get(i);
				 Alert alert;
				 String ActAlertText=""; 
				 
				 Common.WaitForClock(Clockobj);
				 
				 
				 if(sSLADate.equalsIgnoreCase("Yes")){

					 DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
					 Date currentDate = new Date();
					 Calendar calendar = Calendar.getInstance();	      
					 @SuppressWarnings("deprecation")
					 int Day=currentDate.getDay();
					 String SLADate="";
					 if(sActivityTemplateValidation.equalsIgnoreCase("SameDay")) {
						 calendar.add(calendar.DAY_OF_MONTH, 0);	
						 calendar.add(Calendar.MINUTE,5);
						 SLADate=dateFormat.format(calendar.getTime());
						 SLADate = SLADate + " "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
					 }
					 else {
						 calendar.add(calendar.DAY_OF_MONTH, 30);	
						 SLADate=dateFormat.format(calendar.getTime());
						 SLADate = SLADate + " 14:57:04";
					 }
				

					 SLADateTextBox.type(SLADate);
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 if(SubmitSR.isEnabled()) {
						 SubmitSR.click();
						 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 }

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
					 }
					 return;
					 
				 } 
				 

				 if(sServiceRequestClick.equalsIgnoreCase("Yes"))
				 {
					 applet = "//*[@title='Service Requests List Applet']";
					 table = "//table[@summary='Service Request List']";
					 if(ServiceRequestsTab.isVisible()){
						 ServiceRequestsTab.click();
					 }
					 else{
						 HomepageTabDropdown.selectByVisibleText("Service Requests");
					 }
					 Common.WaitForClock(Clockobj);
					 ServiceRequestListLink.withTimeoutOf(220,TimeUnit.SECONDS).waitUntilClickable();
					 ServiceRequestListLink.click();
					 Thread.sleep(3000);

					 Common.selectedRow = -1;
				 }
				 
				 if (sServiceRequestClick.contains("AssetID")){
					    AssetIDOpenPopUp.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					    AssetIDOpenPopUp.click();
		  	    		Thread.sleep(2000);
		  	    		OKButtonPickAssetApplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		  	    		SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		  	    		OKButtonPickAssetApplet.click();
		  	    		report.Info("MSIDN selected");	  
						SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
		 	    	  }

				 if (!sGroupValidation.equals("")){
					 SRIDTextBox.click();
					 if (sButtonValidation.equalsIgnoreCase("SubmitSR")){
						 SubmitSRButton.click();
						 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						 report.Info("Submit SR Button clicked");	  
						 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 }
					 String InstalledId=SRIDTextBox.getTextValue();
					 Serenity.setSessionVariable("SRInstalledID").to(InstalledId);
					 report.Info("SR ID Created : "+InstalledId);
					 ResolutionTextBox.click();
					 String strGroup = GroupTextBox.getTextValue();
					 Assert.assertTrue("Current Group value is : "+strGroup+" and does not match the expected value  : "+sGroupValidation,strGroup.equals(sGroupValidation));				          	
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 report.Info("Pass, Current Group value is as expected : "+strGroup);	
				 } 

				 if (sClickNew.equalsIgnoreCase("Menu") ){
					 SRIDTextBox.click();
					 String InstalledId=SRIDTextBox.getTextValue();
					 Serenity.setSessionVariable("SRInstalledID").to(InstalledId);
					 report.Info("SR ID Created : "+InstalledId);
					 SRMenuItemIcon.click();
					 Thread.sleep(2000);                                        
					 aboutRecord.click();               
				 }

				 if (!sStatusValidation.equals("")){
					 SRIDTextBox.click();
					 String strStatus = StatusTextBox.getTextValue();
					 Assert.assertTrue("Current Status is : "+strStatus+" and does not match the expected value  : "+sStatusValidation,strStatus.equals(sStatusValidation));				          	
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 report.Info("Pass, Current Status is as expected : "+strStatus);	
				 }
				 if (!sSubStatus.equals("")){
					 SRIDTextBox.click();
					 String strStatus = SubStatusTextBox.getTextValue();
					 Assert.assertTrue("Current Status is : "+strStatus+" and does not match the expected value  : "+sSubStatus,strStatus.equals(sSubStatus));				          	
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 report.Info("Pass, Current Status is as expected : "+strStatus);	
				 }

				 if (sNavigation.equalsIgnoreCase("Activity plan")){	 
					 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 //Common.waitForPageLoad(getDriver());
					 applet = "//*[@title='Activity Plans List Applet']";
					 table = "//table[@summary='FS Template Activity Plan List']";

					 ActivityPlanTab.click();
					 Thread.sleep(2000);
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
					 }
					 Thread.sleep(2000);
					 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	
				 } 

				 if (sNavigation.equalsIgnoreCase("Activities")){	 
					 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 //Common.waitForPageLoad(getDriver());
					 applet = "//*[@title='Activities List Applet']";
					 table = "//table[@summary='Service Request Activity List']";

					 ActivitiesTab.click();
					 Thread.sleep(2000);
					// CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 Common.WaitForClock(Clockobj);

					 if (sClickNew.equalsIgnoreCase("Yes")){
						 ActivitiesNewButton.click();
						 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 }

					 Common.selectedRow = -1;//need this

					 if (sButtonValidation.equalsIgnoreCase("Duplicate Activity")){
						 DuplicateActivityButton.click();
						 Common.WaitForClock(Clockobj);
						 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						 report.Info("Duplicate Activity Button clicked");	  
						 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 }

				 } 

				 if (sActivityTemplateValidation.equalsIgnoreCase("No Mandatory")){	
					 ResolutionTextBox.type("Resolved");
					 SRResolveButton.click();
					 Common.WaitForClock(Clockobj);
					 Thread.sleep(4000);
					 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 String strStatus = StatusTextBox.getTextValue();
					 Assert.assertTrue("Current Status is : "+strStatus+" and does not match the expected value : CLOSED: ",strStatus.equals("Closed"));
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 report.Info("Pass, Current Status is as expected : "+strStatus);

				 }	

				 if (sActivityTemplateValidation.equalsIgnoreCase("Mandatory")){	
					 ResolutionTextBox.type("Resolved");
					 SRResolveButton.click();
					 Thread.sleep(2000);
					 Common.WaitForClock(Clockobj);
					 ErrorTitleBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
					 //Common.HandleErrorPopUp(sPopup);
					 if(ErrorTitleBox.isCurrentlyVisible()){
						 String ErrorInfo= ErrorMsg.getText();
						 if(ErrorInfo.contains(sPopup)){	
							 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
							 ErrorOkButton.click();
							 report.Info("The alert meassage is:"+ErrorInfo);
						 }
						 else{
							 report.Info("The alert meassage not found:"+ErrorInfo);
							 Assert.assertTrue(false);
						 }
					 }
				 }

				 if (sActivityTemplateValidation.equalsIgnoreCase("Disconnection Mobile")){
					 SRIDTextBox.click();
					 String InstalledId=SRIDTextBox.getTextValue();
					 Serenity.setSessionVariable("SRInstalledID").to(InstalledId);
					 report.Info("SR ID Created : "+InstalledId);
					 String ReadOnly = ResolutionTextBox.getAttribute("aria-readonly");
					 String ReadOnly1 = DescrptionTextBox.getAttribute("aria-readonly");
					 
					 if(sButtonValidation.equalsIgnoreCase("Ammend")){
						 AmmendButton.click();
						 Common.WaitForClock(Clockobj);
					}

					 if (ReadOnly.equals("false")){
						 ResolutionTextBox.type("Resolved"); 
					 }
					 if (ReadOnly1.equals("false")){
						 DescrptionTextBox.type("abcdef");
					 }

					 SRResolveButton.click();
					 Thread.sleep(4000);
					 Common.WaitForClock(Clockobj);
					 if (!sPopup.equals("")){
						 if(isAlertPresent(getDriver())){
							 alert=getDriver().switchTo().alert();
							 ActAlertText=alert.getText();  
							 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                                                
							 if (ActAlertText.contains(sPopup)){  

								 alert.accept();
							 }
							 else {
								 report.Info("Pop did not occur");
								 Assert.assertTrue(false);
							 }
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
						 }
					 }


					 if (!sServiceRequestClick.equalsIgnoreCase("Pick Owner")){
						 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						 SRIDTextBox.click();
						 String strStatus = StatusTextBox.getTextValue();
						 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 Assert.assertTrue("Current Status is : "+strStatus+" and does not match the expected value : CLOSED: ",strStatus.equals("Closed"));				          	
						 report.Info("Pass, Current Status is as expected : "+strStatus);
					 }
					 if (sServiceRequestClick.equalsIgnoreCase("Pick Owner")){
						 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						 OwnerLabelOpenPopUpButton.click();
						 Thread.sleep(2000);
						 Common.WaitForClock(Clockobj);
						 GoButtoninPickOwnerApplet.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilVisible();
						 //SearchText.typeAndEnter("TEST_AGENT_NBA_04");
						 SearchText.sendKeys("TEST_AGENT_NBA_04");
						 SearchText.sendKeys(Keys.chord(Keys.ENTER));

						 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
						 // GoButtoninPickOwnerApplet.click();	
						 Common.WaitForClock(Clockobj);
						 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
						 report.Info("TEST_AGENT_NBA_04 is selected for Last Name.");

						 SRMenuItemIcon.click();
						 Thread.sleep(2000);
						 SaveRecord.click();
						 Thread.sleep(2000);

						 if(isAlertPresent(getDriver())){
							 alert=getDriver().switchTo().alert();
							 ActAlertText=alert.getText();  
							 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());                                                                                
							 if (ActAlertText.contains("Please ensure the mobile number populated in the")){  

								 alert.accept();
							 }
							 else {
								 report.Info("Pop did not occur");
								 Assert.assertTrue(false);
							 }
						 }
					 }
				 }		  
				 if(sServiceRequestClick.equalsIgnoreCase("Close status")){
					 StatusTextBox.typeAndEnter("Cancelled");
					 Thread.sleep(2000);
					 String readonlyValue =StatusTextBox.getAttribute("aria-readonly");
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 if(readonlyValue.equalsIgnoreCase("true")){
						 report.Info("The Status field and SR are disabled after cancellation as expected");   					
					 }
					 else{
						 Assert.assertTrue("The Status field and SR are enabled after cancellation",readonlyValue.equalsIgnoreCase("true"));
					 }					   
				 }

				 if (sLocateColValue.equalsIgnoreCase("LastName")){
					 sLocateColValue = Serenity.sessionVariableCalled("LastName").toString(); 
					 report.Info("Last Name "+sLocateColValue+" is to be located.");
				 }
				 else 
					{
						Common.selectedRow = 1;
					}
				 if (Index.equals("")){
					 Index = "0";
				 }
				 if (!sLocateCol.equals("")){
					 Common.selectedRow = -1;
					 String LocateColMessege = Common.locateColumn(applet,table, sLocateCol, sLocateColValue, Index);
					 Assert.assertTrue(LocateColMessege, LocateColMessege.equals("true"));
				 	} 
				 else {
						Common.selectedRow = 1;
					}
				 if (!sUIName.equals("")){
					String fetchedValue= Common.updateSiebList(applet,table, sUIName, sValue); 
					 if(sUIName.equalsIgnoreCase("CaptureTextValue|Contact_Last_Name")){
						 Serenity.setSessionVariable("LastName").to(fetchedValue);
					 }
					 Thread.sleep(4000);
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 }
				 
				 if (sButtonValidation.equalsIgnoreCase("WIPNotCR56")){
					 WIPTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 WIPTextBox.click();
					 String WIP = WIPTextBox.getTextValue();
					 Assert.assertTrue("WIP status doesn't match : "+WIP,(!WIP.contains("CR - 56 day letter")||!WIP.contains("CR – Deadlock")) );
					 report.Info("WIP Status is : "+WIP);	  
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 }
				 
				 if (sButtonValidation.equalsIgnoreCase("WIPisCR56")){
					 WIPTextBox.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 WIPTextBox.click();
					 String WIP = WIPTextBox.getTextValue();
					 Assert.assertTrue("WIP status doesn't match : "+WIP,WIP.contains("CR - 56 day letter"));
					 report.Info("WIP Status is : "+WIP);
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 }
				 
				 if (sActivityTemplateValidation.equalsIgnoreCase("AlarmChecked")){
					String alarmStatus=AlarmSecondCheckBox.getAttribute("title");
					AlarmSecondCheckBox.click();
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 Assert.assertTrue("Fail:Alarm is not checked",alarmStatus.equalsIgnoreCase("Checked"));
					 report.Info("Alarm is Checked as expected");
				 }

				 if (sNavigation.equalsIgnoreCase("Activity plan")){
					 ActivitiesTab.click();
					 Thread.sleep(2000);
					 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();	

				 } 

				 if (sNavigation.equalsIgnoreCase("More Info")){	 			             
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 MoreInfoTab.click();
					 //AccountSummaryDropdown.selectByVisibleText("More Info");
					 Thread.sleep(2000);
					 NewAddressButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 NewAddressButton.click();

					 PostCodeElement.click();
					 PostCodeTextBox.typeAndEnter("NW6 2AL");
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 OKButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 OKButton.click();
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 String NewAddress = GetPostCodeValue.getTextValue();

					 ActivitiesTab.click();
					 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 CustomerAccountButtoninSR.click();
					 String PostCodeFromAddressTab="";
					 String PrimaryAddress="";
					 try{
						 PostCodeFromAddressTab=Serenity.sessionVariableCalled("PostCodefromAddressTab").toString();
					 }
					 catch(NullPointerException e){
					 }

					 if(!PostCodeFromAddressTab.equals(null)){
						 if(!PostCodeFromAddressTab.equals("")){
							 Thread.sleep(2000);
							 AccountSummaryDropdown.selectByVisibleText("Addresses");
							 Common.waitForElement(PostCodeInAddressElement);
							 Thread.sleep(2000);
							 PrimaryAddress=PostCodeInAddress.getText();
						 }
					 }		
					 else{
						 PrimaryAddress = ComparePostCode.getTextValue();
						 ComparePostCode.click(); 
					 }				
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 Assert.assertTrue("Fail, Primary address is same as New Address",!NewAddress.equals(PrimaryAddress));  
				 }

				 if(!sNotesValidation.equals("")){
					 String NoteMsg=NoteTextbox.getTextValue();
					 Assert.assertTrue("Fail: Actual Notes textbox value is: "+NoteMsg+" and not matches with expected i.e."+sNotesValidation,sNotesValidation.equalsIgnoreCase(NoteMsg)); 
					report.Info("Pass: Actual Notes textbox value is: "+NoteMsg+"and matches with expected");
					
				 }
				 if (sActivityTemplateValidation.equalsIgnoreCase("+30daysSLA")){
					 String actualSLADate=SLADateafterDrilldown.getTextValue();

					 DateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy"); 
					 Date actualdate = (Date)formatter.parse(actualSLADate);

					 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					 Date currentDate = new Date();
					 String scurrentDate = dateFormat.format(currentDate);
					 // convert date to calendar
					 Calendar cal = Calendar.getInstance();
					 cal.add(Calendar.DATE,+30);
					 Date futureDate = cal.getTime();
					 String sfutureDate = dateFormat.format(futureDate);
					 String sactualSLADate=dateFormat.format(actualdate);
					 report.Info("Expected SLA:"+sfutureDate);
					 report.Info("Actual SLA:"+sactualSLADate);
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
					 Assert.assertTrue("Fail:The actual SLA date is not as the date after 30 days",sactualSLADate.equalsIgnoreCase(sfutureDate));
					 report.Info("The actual SLA date is as the date after 30 days");
				 }
			 }

		 }	  
		  
@FindBy(xpath=".//*[@title='Service Requests:Customer Account']")
WebElementFacade CustomerAccount;

public void SRResolved_CustomerAccount(String Action) throws IOException, InterruptedException, AWTException{
	 String filePath = "\\src\\test\\resources\\data\\Account.xls";
	  String dataSheet = "CreateNewServiceRequest";
	  
	  Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Action, filePath, dataSheet);
	  readWorkbook.testData(tableMap);
	  
	  for (int i = 0;i < tableMap.get("Row").size();i++) {
		  	String sButton = tableMap.get("Button").get(i);
		  	String sPopup = tableMap.get("Popup").get(i);
		  	Alert alert;
            String ActAlertText="";	
            
		  	if(SRSavedApplet.isPresent()){		    		
		    		report.Info("SR Resolved page is displayed successfully.");
		    		SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    	}
		    else{
		    		SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		    		Assert.assertTrue("ID is not drilled down successfully and SR Resolved page is not displayed successfully.", SRSavedApplet.isPresent());
		    		break;
		    }  
		  	
		  	if(sButton.equalsIgnoreCase("Resolved")){
		  		SRResolvedButton.click();
		  		 Thread.sleep(3000);
		  	}
		  	if(sButton.equalsIgnoreCase("CustomerAccount")){
		  		CustomerAccount.click();
		  		// Common.waitForPageLoad(getDriver());
		  		 Thread.sleep(3000);
		  	}
		  
		  	 if(!sPopup.equals("")){
		  		 /*if(isAlertPresent(getDriver())){
		  			 alert=getDriver().switchTo().alert();
		  			 ActAlertText=alert.getText(); 
		  			 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		  			 if (ActAlertText.contains(sPopup)){                    	
		  				 alert.accept();
		  				 System.out.println("Message is: "+ActAlertText);
		  				 report.Info("alert messsage is"+ActAlertText);		                	
		  			 }                                 
		  		 }  
		  		 else{
		  			 Assert.assertTrue("Expected pop-up did not occur",isAlertPresent(getDriver()));
		  		 }*/
		  	//	ResolutionCodeTextBox.click();
		  		 Thread.sleep(1000);
		  		Common.HandleErrorPopUp(sPopup);
	        }
		  	 
		 	if(sButton.equalsIgnoreCase("Validation")){
		  		SRResolvedButton.click();
		  		 Thread.sleep(3000);		  
		         String sStatus = StatusTextBox.getTextValue();
		         SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
		         Assert.assertTrue("User is not able to click on SR Resolved button when logined from another user.",sStatus.equalsIgnoreCase("Closed"));				          					
		         report.Info("Pass,User is able to click on SR Resolved button when logined from another user and SR status is closed");	
		 	}
		  	
	  }
}
/*@FindBy(xpath=".//*[contains(text(),'Error message')]")
WebElementFacade ErrorTitleBox;
@FindBy(xpath=".//div[contains(@class,'popup-info')]  ")
WebElementFacade ErrorMsg; 
@FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
WebElementFacade ErrorOkButton; 

public void HandleErrorPopUp(String sPopup) throws IOException, AWTException, InterruptedException{
	if(ErrorTitleBox.isDisplayed()){
		String ErrorInfo= ErrorMsg.getText();
		if(ErrorInfo.contains(sPopup)){	
			SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			ErrorOkButton.click();
			report.Info("The alert meaasage is:"+ErrorInfo);
		}
	}
} */


@FindBy(xpath = "(.//a[text()='Contacts'])[2]")
WebElementFacade ContactsTab;
@FindBy(xpath="(.//a[text()='Service Requests'])[2]")
WebElementFacade ServiceRequestsTab2;
@FindBy(xpath=".//*[@aria-label='Service Requests:Menu']")
WebElementFacade MenuButtonSR;
@FindBy(xpath=".//*[@aria-label='Third Level View Bar']")
WebElementFacade AccountTabsDRopDown;
@FindBy(xpath=".//*[@name='SR Number']")
WebElementFacade InstalledIds;
@FindBy(xpath=".//*[@aria-label='Owner']")
WebElementFacade Owner;
@FindBy(xpath=".//*[@aria-label='Prime Contact Agent Id']")
WebElementFacade PrimeContactAgentID;


public void ServiceRequestPrimeContact(String rowname) throws IOException, AWTException, InterruptedException{

			Common.waitForPageLoad(getDriver());
			//ContactsTab.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			if (ServiceRequestsTab2.isCurrentlyVisible()){
			ServiceRequestsTab2.click();
			//MenuButtonSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			}
			else {
			AccountTabsDRopDown.selectByVisibleText("Service Requests");
			//MenuButtonSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			}
			
			String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
			String filePath = "\\src\\test\\resources\\data\\Account.xls";
			String dataSheet = "ServiceRequestPCvalidation";
			
			Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(rowname, filePath, dataSheet);
			readWorkbook.testData(tableMap);
			
			for (int i = 0;i < tableMap.get("Row").size();i++) {
			String sOwnerValue = tableMap.get("OwnerValue").get(i);
			String sPrimeContactValue = tableMap.get("PrimeContactValue").get(i);
			
			
			if (tableMap.get("Row").size()==0){
				report.Info(rowname+" logical name not found in sheet.");
				Assert.assertTrue(false);        	
			}
			//InstalledIds.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
			Common.waitForPageLoad(getDriver());
			SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			InstalledIds.click();
			
			if(!sOwnerValue.equals("")){
				
				//Owner.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
				 Common.waitForPageLoad(getDriver());
				String ExpOwnerValue = Owner.getTextValue();
				Thread.sleep(2000);
				Assert.assertTrue("Fail: Owner valuew is not matched",sOwnerValue.equalsIgnoreCase(ExpOwnerValue) );
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				  report.Info(ExpOwnerValue+ "Owner Login Match");
			}
			if(!sPrimeContactValue.equals("")){
			PrimeContactAgentID.withTimeoutOf(120,TimeUnit.SECONDS).isPresent();
			String ExpPrimeContactValue = PrimeContactAgentID.getTextValue();
			Thread.sleep(2000);
			Assert.assertTrue("Fail",sPrimeContactValue.equalsIgnoreCase(ExpPrimeContactValue) );
			SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			report.Info(ExpPrimeContactValue+ "Owner Login Match");
			
			
			    }
			 }
	  		
	    }
			@FindBy(xpath=".//*[contains(text(),'My Prime Service Requests')]")
			WebElementFacade MyPrimeService;
			@FindBy(xpath=".//*[@title='Visibility']/select")
			WebElementFacade ServiceRequestDropdown;
			@FindBy(xpath=".//*[text()='My Prime Service Requests']")
			WebElementFacade MyPrimeServiceRequests;
			@FindBy(xpath=".//a[text()='Service Requests List']")
			WebElementFacade ServiceRequestListTab;
			@Step
			public void PrimeContact_serviceRequest() throws IOException, AWTException, InterruptedException{
				
				if(ServiceRequestsTab.isVisible()){
			   		ServiceRequestsTab.click();
			   	}
			   	else{
			   		HomepageTabDropdown.selectByVisibleText("Service Requests");
			   	}
				ServiceRequestListTab.click();
				Thread.sleep(2000);
				ServiceRequestDropdown.click();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				ServiceRequestDropdown.selectByVisibleText("My Prime Service Requests");
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				report.Info("My Prime Service Requests field is diplayed successfully");
				/*Actions action=new Actions(getDriver());
				//move to element
				action.moveToElement(MyPrimeServiceRequests).build().perform();
				SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());*/
				
	
}
			@FindBy(xpath=".//*[@name='Comment']")
			WebElementFacade Comment;
			@FindBy(xpath="(.//*[@title='Contacts:OK'])[1]")
			WebElementFacade OKa;
			@FindBy(xpath=".//*[@class='siebui-list-textareactrl-nofocus']")
			WebElementFacade comment;
			@FindBy(xpath="(.//*[contains(@id,'Contact_Last_Name')])[3]")
			WebElementFacade LastName;
			@FindBy(xpath=".//*[@class='siebui-icon-mvg']")
			WebElementFacade LastNameicon;
			
			@Step
         	public void CreateActivitiesinSR(String row) throws InterruptedException, IOException, FindFailed, AWTException{
         		//Homepage.waitUntilPresent();
         		String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
         		String filePath = "\\src\\test\\resources\\data\\Account.xls";
                 String dataSheet = "ServiceRequest_Activities";
                 String applet = "//*[@title='Activities List Applet']";
				 String table = "//table[@summary='Service Request Activity List']";
                 
                 Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(row, filePath, dataSheet);
                 readWorkbook.testData(tableMap);
                
                 for (int i = 0;i < tableMap.get("Row").size();i++) {
                       String sButtonValidation = tableMap.get("ButtonValidation").get(i);
                       String sNavigation = tableMap.get("Navigation").get(i);
                       String sClickNew = tableMap.get("ClickNew").get(i);
                       String sLocateCol = tableMap.get("LocateCol").get(i);
                       String sUIName = tableMap.get("UIName").get(i);
                       String sLocateColValue = tableMap.get("LocateColValue").get(i);
                       String sValue = tableMap.get("Value").get(i);
                       String sIndex = tableMap.get("Index").get(i);
                       
                       if (sIndex.equals("")){
                      	 sIndex = "0";
                       }
                if (sNavigation.equalsIgnoreCase("Activities")){	 
				 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
				 //Common.waitForPageLoad(getDriver());
				  ActivitiesTab.click();
				 Thread.sleep(2000);
			   }
				 if (sClickNew.equalsIgnoreCase("Yes")){
					 ActivitiesNewButton.click();
					 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 }
				 if (!sLocateCol.equals("")){
                      Common.selectedRow = -1;
                     Assert.assertTrue(Common.locateColumn(applet,table, sLocateCol, sLocateColValue, sIndex).equals("true"));
                     SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                      }
                 else{
                       Common.selectedRow = 1;
                 }
                 if (!sUIName.equals("")){                                              
                     Common.updateSiebList(applet,table, sUIName, sValue);
                     Thread.sleep(2000);
                     SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                 }
                  if(sUIName.equals("")) {
                     comment.click();
                     Thread.sleep(2000);
                     Comment.type("Do Not Use");
                     Thread.sleep(2000);
                     LastName.click();
                     Thread.sleep(1000);
                     LastNameicon.click();
                     Thread.sleep(2000);
                     OKa.click();
                     Thread.sleep(2000);
                      SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                  }
                 
                 if (sButtonValidation.equalsIgnoreCase("Duplicate Activity")){
					 DuplicateActivityButton.click();
					 CustomerAccountButtoninSR.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable();
					 report.Info("Duplicate Activity Button clicked");	  
					 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 }
} 
			}
			
			@FindBy(xpath=".//*[@aria-label='Initial complaint date']")
			WebElementFacade InitialComplaintDateTextBox;
			public void SetDate56DaysBack() throws IOException, AWTException, InterruptedException {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date currentDate = new Date();
				String scurrentDate = dateFormat.format(currentDate);
				// convert date to calendar
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE,-56);
				Date BackDate = cal.getTime();
				String sBackDate = dateFormat.format(BackDate);
				InitialComplaintDateTextBox.clear();
				InitialComplaintDateTextBox.typeAndEnter(sBackDate);
				 SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			} 
}