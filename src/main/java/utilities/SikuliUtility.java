package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import utilities.ReportMessege;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;


public class SikuliUtility extends PageObject{
      
      @Steps
    private ReadWorkbook readWorkbook;
      @Steps
      ReportMessege report;
      
        
      
      public void ErrorSubProcess(String SikulifilePath) throws FindFailed, InterruptedException, IOException {
          String currentDir = System.getProperty("user.dir");
          SikulifilePath = currentDir.concat(SikulifilePath);                                  
          Screen s=new Screen();
                  
          				Thread.sleep(3000);
                          if(s.exists(SikulifilePath+"\\ErrorSubProcesPopUp.png") != null)
                          {              
                            s.click(SikulifilePath+"\\ErrorSubProcesOKButton.png");
                              Thread.sleep(2000);                       
          
                          }

    }
      
      public void ClickModPromokAlert(String SikulifilePath) throws FindFailed, InterruptedException, IOException {
            String currentDir = System.getProperty("user.dir");
            SikulifilePath = currentDir.concat(SikulifilePath);                                  
        Screen s=new Screen();
                
        
                        /*if(s.exists(SikulifilePath+"\\ModifyPromoPopUp.png") != null)
                        {              
                              s.click(SikulifilePath+"\\ModPromoOKButton.png");
                            Thread.sleep(5000);                   
        
                        }*/
        
		        for(int loop=0;loop<3;loop++){
		        	//ModifyPromoPopUp
		            if(s.exists(SikulifilePath+"\\ModPromoOKButton.png",2) != null){
		            	s.click(SikulifilePath+"\\ModPromoOKButton.png");
		            	Thread.sleep(4000);
		            }else
		            	break;
		            } 
		      }
      
        public void ClickJILLPopUp(String SikulifilePath) throws FindFailed, InterruptedException, IOException {
            String currentDir = System.getProperty("user.dir");
            SikulifilePath = currentDir.concat(SikulifilePath);                                  
            Screen s=new Screen();
                    
            
                            if(s.exists(SikulifilePath+"\\JILLPopUp.png") != null)
                            {              
                              s.click(SikulifilePath+"\\JILLOKButton.png");
                                Thread.sleep(2000);                       
            
                            }

      }

public void ClickReconnectionPopUp(String SikulifilePath) throws FindFailed, InterruptedException, IOException {
            String currentDir = System.getProperty("user.dir");
            SikulifilePath = currentDir.concat(SikulifilePath);                                  
            Screen s=new Screen();
                    
            
                            if(s.exists(SikulifilePath+"\\ReconnectionPopUp.png") != null)
                            {              
                              s.click(SikulifilePath+"\\ReconnectionOKButton.png");
                                Thread.sleep(2000);                       
            
                            }

      }
        

public void SaveProcessHistory(String SikulifilePath, String SikulifilePathForSavingFile, String ScriptNum) throws FindFailed, InterruptedException, IOException {
            String currentDir = System.getProperty("user.dir");
            SikulifilePath = currentDir.concat(SikulifilePath);   
            SikulifilePathForSavingFile = currentDir.concat(SikulifilePathForSavingFile); 
            Screen s=new Screen();
                    
            
                            if(s.exists(SikulifilePath+"\\SFP.png") != null)
                            {    
                            	s.click(SikulifilePath+"\\SFP.png");
                            	s.type(Key.DELETE);
                            	s.type(SikulifilePath+"\\SFP3.png",SikulifilePathForSavingFile);
                            	s.type(Key.ENTER);
                                Thread.sleep(2000);                       
            
                            }
                            if(s.exists(SikulifilePath+"\\FileNameatfirst.png") != null)
                            {  
                            	
                            	s.click(SikulifilePath+"\\FileNameatfirst.png");
                            	s.type(Key.DELETE);
                            	s.type(SikulifilePath+"\\FileName2.png",ScriptNum);
                                Thread.sleep(2000);                       
            
                            }
                            
                            if(s.exists(SikulifilePath+"\\SaveButton.png") != null)
                            {              
                              s.click(SikulifilePath+"\\SaveButton.png");
                                Thread.sleep(2000);                    
            
                            }
                            
                            if(s.exists(SikulifilePath+"\\SaveButton.png") != null)
                            {    Thread.sleep(2000);          
                            report.Info("File was not saved  successfully.");
                            Assert.assertTrue(false);
                                                     
            
                            }
        }

public void SaveFile(String SikulifilePath, String SikulifilePathForSavingFile) throws FindFailed, InterruptedException, IOException {
    String currentDir = System.getProperty("user.dir");
    SikulifilePath = currentDir.concat(SikulifilePath);   
    //SikulifilePathForSavingFile = currentDir.concat(SikulifilePathForSavingFile); 
    Screen s=new Screen();
    
				    if(s.exists(SikulifilePath+"\\SaveAsListNew.png") != null)
				    {    
				    	s.click(SikulifilePath+"\\SaveAsListNew.png");
				    	Thread.sleep(1000);
				    	if(s.exists(SikulifilePath+"\\Save As.png") != null) {
				    	 s.click(SikulifilePath+"\\Save As.png");
				    	
				        Thread.sleep(3000);                       
				        }
					 else
					 {
						 s.click(SikulifilePath+"\\SaveAsListNew.png");
						 Thread.sleep(1000);
						 s.click(SikulifilePath+"\\Save As.png");
						 report.Info("Clicked second time");
					 }
						
					 }
					 else
					 {
						 report.Info("Save As button is not present");
					 Assert.assertTrue(false);
					 }
            
    
                    if(s.exists(SikulifilePath+"\\SFP2.png") != null)
                    {    
                    	s.click(SikulifilePath+"\\SFP2.png");
                    	s.type(Key.DELETE);
                    	s.type(SikulifilePath+"\\SFP3.png",SikulifilePathForSavingFile);
                    	s.type(Key.ENTER);
                        Thread.sleep(2000);                       
    
                    }
                    
                    if(s.exists(SikulifilePath+"\\SaveButton.png") != null)
                    {              
                      s.click(SikulifilePath+"\\SaveButton.png");
                        Thread.sleep(2000);                    
    
                    }
                    
                    if(s.exists(SikulifilePath+"\\SaveButton.png") != null)
                    {    Thread.sleep(2000);          
                    report.Info("File was not saved  successfully.");
                    Assert.assertTrue(false);
                                             
    
                    }
}
        @FindBy(xpath=".//*[@title='View Report']")
   	    WebElementFacade ViewReportList;

public void InvoiceSave(String SikulifilePath, String SikulifilePathForSavingFile, String InvoiceName) throws FindFailed, InterruptedException, IOException, AWTException {
            
            Screen s=new Screen();
            
            if(s.exists(SikulifilePath+"\\InvoiceDownload.png") != null)
            { 
               Thread.sleep(3000);
               s.click(SikulifilePath+"\\InvoiceDownload.png");
               Thread.sleep(1000);
               s.type(Key.ESC);
               Thread.sleep(2000);
            
            }
                            if(s.exists(SikulifilePath+"\\SaveInvoiceButton.png") != null)
                            {  
                            	
                            	s.doubleClick(SikulifilePath+"\\SaveInvoiceButton.png");                            
                                Thread.sleep(3000);                       
                            }
                            else{
                            	report.Info("Image- SaveInvoiceButton.png is not available");
                            	Assert.assertTrue(false);
                            }
                            	s.type(Key.DELETE);
                            	s.type(SikulifilePathForSavingFile+"\\"+InvoiceName);
                                Thread.sleep(2000);                                                     
                                report.Info("Report Downloaded to path :-"+SikulifilePathForSavingFile+"\\"+InvoiceName);

                           /* if(s.exists(SikulifilePath+"\\BIPSaveButton.png") != null)
                            {    
                            	report.Info("Invoice is saved successfully");
                            	s.click(SikulifilePath+"\\BIPSaveButton.png");           
                            }   
                            
                            if(s.exists(SikulifilePath+"\\BIPSaveButton.png") != null)
                            {    
                            	report.Info("Invoice is saved successfully");
                            	s.click(SikulifilePath+"\\BIPSaveButton.png");           
                            }  
                            else{
                            	
                            	Thread.sleep(2000);
                                if(s.exists(SikulifilePath+"\\BIPSaveButton.png") != null)
                                {    
                                	report.Info("Invoice is saved successfully");
                                	s.click(SikulifilePath+"\\BIPSaveButton.png");           
                                }  
                                
                                else{
                            	report.Info("Image- BIPSaveButton.png is not available");
                            	Assert.assertTrue(false);
                                }*/
                                
                                for(int loop=0;loop<3;loop++){
                                	Thread.sleep(3000);
                                    if(s.exists(SikulifilePath+"\\BIPSaveButton.png",2) != null){
                                    	SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                                    	s.click(SikulifilePath+"\\BIPSaveButton.png");
                                    	}
                                    else {
                                    	report.Info("Invoice saved successfully");
                                    	break ;
                                    }
                            }
                            
                            
                            
        }

public void SikuliScreenShot(String SikulifilePathForSavingFile) throws IOException, AWTException, InterruptedException
    {
        System.out.println();
        Screen s2=new Screen();
        Robot robot = new Robot();
        Thread.sleep(2000);
        BufferedImage myScreenshot = robot.createScreenCapture(s2.getBounds());
        //report.Info(SikulifilePathForSavingFile);
        
        SimpleDateFormat dateformat= new SimpleDateFormat("ddMMyyHHmmss");
        Date date = new Date();

        ImageIO.write(myScreenshot, "jpg", new File(SikulifilePathForSavingFile+"\\"+dateformat.format(date)+".png")); //SikulifilePathForSavingFile+"\\"+FolderName+"\\"+ZonedDateTime.now())
        }
public void SaveContractReport(String SikulifilePath) throws FindFailed, InterruptedException, IOException, AWTException {
    String currentDir = System.getProperty("user.dir");
    SikulifilePath = currentDir.concat(SikulifilePath);   

    String SikulifilePathForSavingFile= Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
    Thread.sleep(35000); 
    Screen s=new Screen();

    			 /*if(s.exists(SikulifilePath+"\\SaveAsListNew.png") != null)
                 {    
                 	s.click(SikulifilePath+"\\SaveAsListNew.png");
                 	Thread.sleep(1000);
                 	if(s.exists(SikulifilePath+"\\Save As.png") != null) {
                 	 s.click(SikulifilePath+"\\Save As.png");
                 	
                     Thread.sleep(3000);                       
                     }
    			 else
    			 {
    				 s.click(SikulifilePath+"\\SaveAsListNew.png");
    				 Thread.sleep(1000);
    				 s.click(SikulifilePath+"\\Save As.png");
    				 report.Info("Clicked second time");
    			 }
    				
    			 }
    			 else
    			 {
    				 report.Info("Save As button is not present");
				 Assert.assertTrue(false);
    			 }
    			 

    			 String  filePath = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
                    if(s.exists(SikulifilePath+"\\FileNameOld.png") != null)
                    {                              	
                    	s.type(Key.DELETE);
                    	s.type(filePath+"\\Report");
                    	report.Info(" File is save at path : "+filePath+"Report" );
                        Thread.sleep(2000);                       
    
                    }
                    
                    if(s.exists(SikulifilePath+"\\SaveButton.png") != null)
                    {              
                      s.click(SikulifilePath+"\\SaveButton.png");
                        Thread.sleep(2000);                       
    
                    }
                    
                    if(s.exists(SikulifilePath+"\\SaveButton.png") != null)
                    {    Thread.sleep(2000);          
                    report.Info("File was not saved  successfully.");
                    Assert.assertTrue(false);
                                             
    
                    }*/
    
			    if(s.exists(SikulifilePath+"\\DownArrow.png") != null)
			    {    
			    	s.click(SikulifilePath+"\\DownArrow.png");
			    	Thread.sleep(2000);
			    	if(s.exists(SikulifilePath+"\\FilePathTextBox.png") != null) {
			    		s.click(SikulifilePath+"\\FilePathTextBox.png");
			    		Thread.sleep(2000);
			    		s.type(Key.DELETE);
			    		Thread.sleep(2000);                       
			    	}
			    }
			
			
			    String  filePath = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
			    if(s.exists(SikulifilePath+"\\FilePathType.png") != null)
			    {                              	
			
			    	s.type(filePath);
			    	Thread.sleep(1000);
			    	s.type(Key.ENTER);                    	
			    	Thread.sleep(3000);                       
			
			    }
			
			    if(s.exists(SikulifilePath+"\\SaveFileButton.png") != null)
			    {              
			    	s.click(SikulifilePath+"\\SaveFileButton.png");
			    	Thread.sleep(2000);  
			    	report.Info(" File is save at path : "+filePath+" "+"Report" );
			
			    }
}

public void ClickTrustedPopUp(String sikulifilePath) throws InterruptedException, FindFailed {
    String currentDir = System.getProperty("user.dir");
    sikulifilePath = currentDir.concat(sikulifilePath);                                  
Screen s=new Screen();
        
Thread.sleep(5000);  
                if(s.exists(sikulifilePath+"\\E7Trusted.png") != null)
                {              
                      s.click(sikulifilePath+"\\E7TrustedYes.png");
                      s.click(sikulifilePath+"\\E7TrustedYes.png");
                      
                    Thread.sleep(5000);                       

                }	
}

public void ClickFraudRiskAlert(String sikulifilePath) throws FindFailed, InterruptedException {
           String currentDir = System.getProperty("user.dir");
        sikulifilePath = currentDir.concat(sikulifilePath);                                  
    Screen s=new Screen();
            
    
                    if(s.exists(sikulifilePath+"\\FraudRiskPopUp.png") != null)
                    {              
                          s.click(sikulifilePath+"\\FraudRiskConfirmButton.png");
                        Thread.sleep(5000);                       
    
                    }

  }

public void EnterMSISDN(String SikulifilePath,String OneNetMSISDN) throws FindFailed, InterruptedException, IOException, AWTException {
    String currentDir = System.getProperty("user.dir");
    SikulifilePath = currentDir.concat(SikulifilePath);   
    //SikulifilePathForSavingFile = currentDir.concat(SikulifilePathForSavingFile); 
    String SikulifilePathForSavingFile= Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
    Thread.sleep(5000); 
    Screen s=new Screen();

    if(s.exists(SikulifilePath+"\\OneNetMSISDN.png") != null) {
		 //s.click(SikulifilePath+"\\OneNetMSISDN.png");
    	s.type(OneNetMSISDN);
    Thread.sleep(2000);

              
    }
}

public void HaloGenerateContractReport(String SikulifilePath) throws FindFailed, InterruptedException, IOException, AWTException {
    String currentDir = System.getProperty("user.dir");
    SikulifilePath = currentDir.concat(SikulifilePath);   
  
    Thread.sleep(35000); 
    Screen s=new Screen();
    String  filePath = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
    
			    if(s.exists(SikulifilePath+"\\ChromeArrow.png") != null)
			    {    
			    	s.click(SikulifilePath+"\\ChromeArrow.png");
			    	Thread.sleep(2000);
			    	if(s.exists(SikulifilePath+"\\ChromeOpen.png") != null) {
			    		s.click(SikulifilePath+"\\ChromeOpen.png");
			    		Thread.sleep(2000);
			    		SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			    	}
			    	WebDriver driver =getDriver();
					String title="";
					Thread.sleep(5000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle); 	  
					}
					title = driver.getCurrentUrl();
		    		if(title.contains("PDF")) {
		    			System.out.println("Pass");
		    			/*Robot robot = new Robot();
		    			robot.keyPress(KeyEvent.VK_CONTROL);     		
		    			robot.keyPress(KeyEvent.VK_S);*/
		    			 Actions actions;
		    			 actions = new Actions(driver);
		    			    actions.sendKeys(Keys.chord(Keys.CONTROL,"s")).build().perform();
		    		}
		    		
			    }
						  
			    if(s.exists(SikulifilePath+"\\ChromeFilePath.png") != null)
			    {    
			    	if(filePath.contains("Y\\")){
			    		filePath.replace("Y\\", "Y:\\");
			    	}
			    	s.type(Key.BACKSPACE);
			    	Thread.sleep(2000);
			    	s.type(filePath);
			    	Thread.sleep(1000);
			   	s.type(Key.ENTER);                    	
			    	Thread.sleep(3000);                       
			
			    }
			    Thread.sleep(3000);
			    if(s.exists(SikulifilePath+"\\ChromeSave.png") != null)
			    {              
			    	s.click(SikulifilePath+"\\ChromeSave.png");
			    	Thread.sleep(2000);  
			    	report.Info(" File is save at path : "+filePath+" "+"Report" );			
			    }
			    
}
	
}