	package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.sikuli.natives.SysUtil;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;


import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;
import net.serenitybdd.core.IgnoredStepException;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.PuttyCommon;
import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.SikuliUtility;
import utilities.common;
import pages.DatabasePage;


public class BRMPuttyPages extends PageObject{
                @Steps
                ReportMessege report;
                
                @Steps
                private ReadWorkbook readWorkbook;
                
                @Steps
            	private PuttyCommon puttyCommon;
                
                @Steps
            	private DatabasePage Database;
                
            	@Steps
            	private common common1;
            	@Steps
            	private SikuliUtility sikuliUtility;
            	
            	String SikulifilePath = "\\src\\test\\resources\\BRM_Snapshot";
            	String SikulifilePathForSavingFile = "";
            	Screen  s=new Screen();
            	
            	@Step
				public void CRMPuttyLogin(String PuttyLogFileName) throws FindFailed, InterruptedException, IOException, AWTException {
					 String filePath = "\\src\\test\\resources\\data\\Putty.xls";
					 String dataSheet = "LoginToPutty";
					//String filePath = "\\src\\test\\resources\\data\\Account.xls";
					///String dataSheet = "LoginToSiebel";
					//ReadWorkbook readWorkbook = new ReadWorkbook();
					/*Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow("PuttyLogFileName", filePath, dataSheet);
					readWorkbook.testData(tableMap);*/
					//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
					/*for (int i = 0  ;i < tableMap.get("Username").size();i++) {
						
						String BRMEnv = tableMap.get("EnvURL").get(i);
						System.out.println("BRMEnv is :- " +BRMEnv);
						Serenity.setSessionVariable("Environment").to(BRMEnv);
					}*/
				    Robot robot = new Robot();
				    robot.keyPress(KeyEvent.VK_WINDOWS);
				    robot.keyPress(KeyEvent.VK_D);
				    robot.keyRelease(KeyEvent.VK_D);
				    robot.keyRelease(KeyEvent.VK_WINDOWS);
				    report.Info("All Application minimized");
					//Serenity.setSessionVariable("SikulifilePathForSavingFile").to(SikulifilePathForSavingFile);
					
				    SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
					 //filePath = "\\src\\test\\resources\\data\\Putty.xls";
					// dataSheet = "LoginToPutty";
					 //Environment = c;
					 //Serenity.setSessionVariable("Env").to(Environment);
					 
					 //System.out.println("Environment is :- " +Environment);
				    Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(PuttyLogFileName, filePath, dataSheet);
					readWorkbook.testData(tableMap);
					getDriver().close();
					App.close("putty.exe");
					
					for (int i = 0  ;i < tableMap.get("RowN").size();i++) {
						String Port = tableMap.get("Port").get(i);
						String Number = tableMap.get("Number").get(i);
						String LogFileName = tableMap.get("LogFileName").get(i);
						Serenity.setSessionVariable("LogFileName").to(LogFileName);
						String RootUser = tableMap.get("RootUser").get(i);		
						String RootPassword = tableMap.get("RootPassword").get(i);
						String Passphrase="Passphrase"+Serenity.sessionVariableCalled("Env").toString();
						Thread.sleep(1000);
//						if(s.exists(SikulifilePath+"\\GoToDesktop.png",2) != null)
//		                	
//		                {
//		                  s.click(SikulifilePath+"\\GoToDesktop.png");                         
//		                  report.Info("All Application minimized");
//		                }
						//s.click(SikulifilePath+"\\GoToDesktop.png");
						Thread.sleep(1000);
                App.open("C:\\Program Files (x86)\\PuTTY\\putty.exe");
						
                Thread.sleep(1000);
                Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
                report.Info("Putty App Launched");
                String HostName="HostName"+Serenity.sessionVariableCalled("Env").toString();;
                s.type(tableMap.get(HostName).get(i));
                SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
                s.click(SikulifilePath+"\\PuttyLoginLogs.png");
                for(int loop=0;loop<2;loop++){
                    if(s.exists(SikulifilePath+"\\PuttyLoginLogs.png",2) != null){
                    	s.click(SikulifilePath+"\\PuttyLoginLogs.png");
                    }else
                    	break;
                    }
                s.click(SikulifilePath+"\\AllSessionOutputPutty.png");
             
                for(int loop=0;loop<2;loop++){
                if(s.exists(SikulifilePath+"\\AllSessionCheckboxverify.png",2) != null){
                	break;
                }
                else{
                	s.click(SikulifilePath+"\\AllSessionOutputPutty.png");
                	System.out.println("Clicked");
                }
                }
                s.doubleClick(SikulifilePath+"\\PuttyLogFilePath.png");
                s.type(Key.DELETE);
                s.doubleClick();
                s.type(Key.DELETE);
                s.type(SikulifilePathForSavingFile+"\\"+LogFileName);
                s.click(SikulifilePath+"\\AlwaysAppendPuttyLogs.png");
                for(int loop=0;loop<2;loop++){
                    if(s.exists(SikulifilePath+"\\VerifyAlwaysAppendPuttyLogs.png",2) != null){
                    	break;
                    }
                    else{
                    	 s.click(SikulifilePath+"\\AlwaysAppendPuttyLogs.png");
                    	System.out.println("Clicked");
                    }
                    }
               
                sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
                //s.doubleClick(SikulifilePath+"\\SSH.png");
               // if (s.exists(SikulifilePath+"\\Auth.png",2)== null)
                	//s.doubleClick(SikulifilePath+"\\ReclickSSH.png");                
             
               // s.click(SikulifilePath+"\\Auth.png");
               // s.click(SikulifilePath+"\\AllowAgentForwarding.png");
                //s.click(SikulifilePath+"\\AllowAttemptedChanges.png");               
                
                String UserName="UserName"+Serenity.sessionVariableCalled("Env").toString();
                //s.type(SikulifilePath+"\\PPKPath.png","C:/Users/"+(tableMap.get(UserName).get(i))+"/Putty/ssh_key_putty_newVo"+Environment+".ppk");
                //s.type(SikulifilePath+"\\PPKPath.png","C:/Users/"+(tableMap.get(UserName).get(i))+"/Putty/ssh_key_putty_newVo"+Environment+".ppk");
                Serenity.setSessionVariable("UserName").to(tableMap.get(UserName).get(i));
                Serenity.setSessionVariable("HostName").to(tableMap.get(HostName).get(i));
                Serenity.setSessionVariable("Passphrase").to(tableMap.get(Passphrase).get(i));
                sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
                s.click(SikulifilePath+"\\Open.png");
                //s.click(SikulifilePath+"\\Open.png");
                Thread.sleep(2000);
                for(int loop=0;loop<2;loop++){
                if(s.exists(SikulifilePath+"\\Open.png",2) != null)
                	
                {
                  s.click(SikulifilePath+"\\Open.png");                         
                  report.Info("Open Button clicked on second atempt");
                }
                else{
                	break;
                }
                }
         /* if(s.exists(SikulifilePath+"\\Yes.png",2) != null)
        	
                {
                  s.click(SikulifilePath+"\\Yes.png");                         
                  report.Info("Yes Exists, Clicked on Yes");
                }*/
                s.click(SikulifilePath+"\\MaximisePutty.png");
          for(int loop=0;loop<2;loop++){
          if(s.exists(SikulifilePath+"\\MaximisePutty.png",2) != null)
          	
          {	
        	  s.click(SikulifilePath+"\\MaximisePutty.png");  
        	  Thread.sleep(2000);
          }
          else{
        	  break;
          }
          
          }	
          		  puttyCommon.PuttyType("login as:", tableMap.get(UserName).get(i)); 
          		  puttyCommon.PuttyType("password:","P@ssw0rd");
                     
          		SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
                  
                  puttyCommon.PuttyType("$",RootUser);         
                  puttyCommon.PuttyType("Password:",RootPassword);
        
                  report.Info("Switch User to PIN Sucess");
                  SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
		}
	}
				@Step
				public void BulkCsv(String Type) throws Exception 
							{
								String filePath = "\\src\\test\\resources\\data\\Putty.xls";
								String dataSheet = "BulkCSV";     	
								   	
									Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Type, filePath, dataSheet);
									     for (int i = 0;i < tableMap.get("Type").size();i++) {   
								        	String  sType = tableMap.get("Type").get(i);                 	
								        	String sContent = tableMap.get("Content").get(i);  
								        	String  sFileName = tableMap.get("FileName").get(i);      
								        	String sPath = tableMap.get("Path").get(i);  
								        	String  sShellScript = tableMap.get("ShellScript").get(i); 
								        	//String sMSISDN = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
                                            String sMSISDN ="";
								        	
								        	try {
								        		sMSISDN = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
											} catch (Exception e) {
												sMSISDN = Serenity.sessionVariableCalled("MSISDN").toString();
											}
								        	
								        	
								        	
								        	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmss");
										    Date now = new Date();       		   
											
								        	sFileName=sFileName+sdfDate.format(now)+".csv";
								        	
								        	//String sNewContent = sContent.replace("MSISDN", "447350002166");
								        	String sNewContent = sContent.replace("MSISDN", sMSISDN);
								       		report.Info("New Contect :- "+sNewContent);
								       		
								    puttyCommon.PuttyType("$",sPath);				   
								    puttyCommon.PuttyType("$","echo '"+sNewContent+"' >"+sFileName);
								    SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
								    //s.type(Key.ENTER);
								    puttyCommon.PuttyType("$","cat "+sFileName);
								    SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
								    //s.type(Keys.chord(Keys.SHIFT,Keys.INSERT);
								    puttyCommon.PuttyType("$","cd /opt/SP/oracle/crm/batchfs/scripts");
				   				    puttyCommon.PuttyType("$",". ./Global_Variables.sh");
				   				    SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString(); 
				   				    boolean b=puttyCommon.ValidatePutty("Global_Variables.sh","1Pa55word");
									if (b==false){
										SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
										report.Info("GLobal Variables shell script not executed successfully");
										Assert.assertTrue(false);
									}
									report.Info("GLobal Variables shell script Executed successfully");
									SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
									puttyCommon.PuttyType("",sShellScript);
									//Thread.sleep(5000);
									//sValidatePutty = ValidatePutty (""&sShellScript,"FILE  '"&sFileName&"' COMPLETED")
								    
									//b=puttyCommon.ValidatePutty("EDWDiscon.sh","FILE "+"'"+sFileName+","+" COMPLETED");
									b=puttyCommon.ValidatePutty("EDWDiscon.sh","FILE  "+"'"+sFileName+"'"+" COMPLETED");
									if (b==false){
										SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
										report.Info("EDW Disconnection file completed Unsucessfully");
										Assert.assertTrue(false);
									}
									SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
									
								}
									}
private String Replace(String sContent, String string, String sMSISDN) {
	// TODO Auto-generated method stub
	return null;
}	

@Step
public void BulkMigrationCsv(String Type) throws Exception 
			{
				String filePath = "\\src\\test\\resources\\data\\Putty.xls";
				String dataSheet = "BulkCSV";     	
				   	
					Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Type, filePath, dataSheet);
					     for (int i = 0;i < tableMap.get("Type").size();i++) {   
				        	String  sType = tableMap.get("Type").get(i);                 	
				        	String sContent = tableMap.get("Content").get(i);  
				        	String  sFileName = tableMap.get("FileName").get(i);      
				        	String sPath = tableMap.get("Path").get(i);  
				        	String  sShellScript = tableMap.get("ShellScript").get(i); 
				        	//String sMSISDN = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
                            String sMSISDN ="";
                            String sAccountNo="";
                            String sPlanName="";
                            String sPlanID="";
                            String sNewContent = sContent;
				        	
				        	try {
				        		sMSISDN = Serenity.sessionVariableCalled("ACCNTMSISDN").toString();
				        		sNewContent = sContent.replace("ACCNTMSISDN", sMSISDN);
							} catch (Exception e) {
								sMSISDN = Serenity.sessionVariableCalled("MSISDN").toString();
								sNewContent = sContent.replace("MSISDN", sMSISDN);
							}
				        	
				        	try {
				        		sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString();
				        		sNewContent = sContent.replace("AccountNo", sAccountNo);
							} catch (Exception e) {
								sAccountNo = "";
							}
				        	
				        	try {
				        		sPlanName = Serenity.sessionVariableCalled("ProductName").toString();
				        		sNewContent = sContent.replace("ProductName", sPlanName);
							} catch (Exception e) {
								sPlanName = "";
							}
				        	
				        	try {
				        		sPlanID = Serenity.sessionVariableCalled("PartNo").toString();
				        		sNewContent = sContent.replace("PartNo", sPlanID);
							} catch (Exception e) {
								sPlanID = "";
							}
				        	
				        	if(sContent.contains("NONEXISTENTACCOUNTNO")) {
				        		sAccountNo = "700012345";
				        	}
				        	
				        	
				        	
				        	
				        	SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMdd");
						    Date now = new Date();       		   
							
				        	sFileName=sFileName+sdfDate.format(now)+"_1_bhavya.csv";

				        	
				       		report.Info("New Content :- "+sNewContent);
				       		
				    puttyCommon.PuttyType("$",sPath);				   
				    puttyCommon.PuttyType("$","echo '"+sNewContent+"' >"+sFileName);
				    SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				    //s.type(Key.ENTER);
				    puttyCommon.PuttyType("$","cat "+sFileName);
				    SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				    //s.type(Keys.chord(Keys.SHIFT,Keys.INSERT);
				    puttyCommon.PuttyType("$","cd /opt/SP/oracle/crm/batchfs/scripts");
   				    puttyCommon.PuttyType("$",". ./Global_Variables.sh");
   				    SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString(); 
   				    boolean b=puttyCommon.ValidatePutty("Global_Variables.sh","1Pa55word");
					if (b==false){
						SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
						report.Info("GLobal Variables shell script not executed successfully");
						Assert.assertTrue(false);
					}
					report.Info("GLobal Variables shell script Executed successfully");
					SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
					puttyCommon.PuttyType("",sShellScript);
					//Thread.sleep(5000);
					//sValidatePutty = ValidatePutty (""&sShellScript,"FILE  '"&sFileName&"' COMPLETED")
				    
					//b=puttyCommon.ValidatePutty("EDWDiscon.sh","FILE "+"'"+sFileName+","+" COMPLETED");
					/*b=puttyCommon.ValidatePutty("EDWDiscon.sh","FILE  "+"'"+sFileName+"'"+" COMPLETED");
					if (b==false){
						SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
						report.Info("EDW Disconnection file completed Unsucessfully");
						Assert.assertTrue(false);
					}*/
					
				}
					     Thread.sleep(10000);
					}


		public void DirectDebitForPutty() throws InterruptedException, IOException, AWTException {
			
			
			puttyCommon.PuttyType("$","cd /opt/crm/siebel/batchfs/scripts");
			puttyCommon.PuttyType("scripts",". ./Global_Variables.sh");
			boolean b=puttyCommon.ValidatePutty("Global_Variables.sh","1Pa55word");
			if (b==true){
				SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				report.Info("GLobal Variables shell script executed successfully");
				
			}
			
			else{
				report.Info("");
			Assert.assertTrue(false);
			}
			
			puttyCommon.PuttyType("$",". ./VF_DirectDebit.sh");
			Thread.sleep(5000);
			b=puttyCommon.ValidatePutty("DirectDebit.sh","WORKFLOW  COMPLETED");
			if (b==true){
				SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				report.Info("Direct Debit Workflow  Completed Sucessfully");
				
		}
			
			else{
				report.Info("");
				Assert.assertTrue(false);
				}
}
			
			@Step
			public void Putty_Addacs_CSV(String ReasonCode) throws Exception 
				{
					String filePath = "\\src\\test\\resources\\data\\Putty.xls";
				String dataSheet = "Addacs_Auddis";     	
				   	
			Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(ReasonCode, filePath, dataSheet);
			     for (int i = 0;i < tableMap.get("CSV").size();i++) {   					        	             
		        	String sCSV = tableMap.get("CSV").get(i);
		        	String sPath = tableMap.get("Path").get(i);
		        	sCSV=sCSV.replace("Mandate_ID", Serenity.sessionVariableCalled("DirectDebitMandateId").toString());
		        	sCSV=sCSV.replace("account_name", Serenity.sessionVariableCalled("DirectDebitAccountName").toString());
		        	sCSV=sCSV.replace("sort_code", Serenity.sessionVariableCalled("SortCode").toString());
		        	sCSV=sCSV.replace("bank_num", Serenity.sessionVariableCalled("DirectDebitAccountNo").toString());
		        	//sCSV=sCSV.replace("bank_num", Serenity.sessionVariableCalled("DirectDebitAccountNo").toString());
		        	String Randomno = Integer.toString((11111 + (int)(Math.random()*222222)));
		        	SimpleDateFormat Format =new SimpleDateFormat("dd/MM/yyyy");
		        	Date date = new Date();
		        	sCSV=sCSV.replace("DATE", Format.format(date));
		        	puttyCommon.PuttyType("$",sPath);
		        	Format = new SimpleDateFormat("ddMMyyyy");
				    puttyCommon.PuttyType("$","echo '"+sCSV+"' > "+"ADDACS_"+Format.format(date)+"_"+Randomno+".csv");
				    sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
				    
				}
					}

		@Step
		public void Putty_Auddis_CSV(String ReasonCode) throws Exception 
			{
				String filePath = "\\src\\test\\resources\\data\\Putty.xls";
				String dataSheet = "Addacs_Auddis";     	
				   	
			Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(ReasonCode, filePath, dataSheet);
			     for (int i = 0;i < tableMap.get("CSV").size();i++) {   					        	             
		        	String sCSV = tableMap.get("CSV").get(i);
		        	String sPath = tableMap.get("Path").get(i);
		        	sCSV=sCSV.replace("Mandate_ID", Serenity.sessionVariableCalled("DirectDebitMandateId").toString());
		        	sCSV=sCSV.replace("Account_Name", Serenity.sessionVariableCalled("DirectDebitAccountName").toString());
		        	sCSV=sCSV.replace("sort_code", Serenity.sessionVariableCalled("SortCode").toString());
		        	sCSV=sCSV.replace("Account_no", Serenity.sessionVariableCalled("DirectDebitAccountNo").toString());
		        	//sCSV=sCSV.replace("bank_num", Serenity.sessionVariableCalled("DirectDebitAccountNo").toString());
		        	String Randomno = Integer.toString((11111 + (int)(Math.random()*222222)));
		        	SimpleDateFormat Format =new SimpleDateFormat("dd/MM/yyyy");
		        	Date date = new Date();
		        	sCSV=sCSV.replace("DATE", Format.format(date));
		        	puttyCommon.PuttyType("$",sPath);
		        	Format = new SimpleDateFormat("ddMMyyyy");
				    puttyCommon.PuttyType("$","echo '"+sCSV+"' > "+"AUDDIS_"+Format.format(date)+"_"+Randomno+".csv");
				    SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				    
				}
					}
					
				@Step
			    public void BillNow() throws Exception 
				{
				puttyCommon.PuttyType("$","cd /home/pin/opt/portal/7.5/automation/bill_invoice");
				puttyCommon.PuttyType("$","./bill_now.sh");
				SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				boolean b=puttyCommon.ValidatePutty("bill_now.sh","Bill now done");
				if (b==false){
					SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				Assert.assertTrue(false);
				}
				report.Info("Bill Now Done");
				SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
							
}
				@Step
				public void Docgen(String Rowid) throws Exception
					{
					String filePath = "\\src\\test\\resources\\data\\Putty.xls";
					String dataSheet = "Docgen";    	
					   	
				Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Rowid, filePath, dataSheet);
				     for (int i = 0;i < tableMap.get("Sequence").size();i++) {   
				    	 String sSequence = tableMap.get("Sequence").get(i);
			        	 String sIndex = tableMap.get("Index").get(i);
			        	 String sAccountNo = "";
			        	
			        	if (sIndex.equals("")){
							sIndex = "0";
						}
			        
			        sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString();

					puttyCommon.PuttyType("$","cd /home/pin/opt/portal/7.5/automation/bill_invoice");
					puttyCommon.PuttyType("$","./docgen.sh");
					sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
					puttyCommon.PuttyType("enter Account",sAccountNo);
					puttyCommon.PuttyType("enter sequence",sSequence);
					boolean b=puttyCommon.ValidatePutty("docgen.sh","Docgen completed successfully please check in WCC");
					if (b==false){
						SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
						Assert.assertTrue(false);
					}
						report.Info("Invoice uploaded on WCC");
						SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				     }		
		}
				
				@Step	                
				public void Purchase_Products(String Account_No) throws IOException, AWTException, InterruptedException, ClassNotFoundException, SQLException {

					if(!Account_No.equals(""))
					{		
						//String AccountNo = "7000383391";
						Serenity.setSessionVariable("AccountNo").to(Account_No);
						puttyCommon.PuttyType("$","cd /home/pin/opt/portal/7.5/automation/sql_query");		
						puttyCommon.PuttyType("$","./purchased_product.sh "+Account_No);
						Database.ExecuteBRMDBQuery("MSISDNFromAccount");
						String MSISDNFromAccount = Serenity.sessionVariableCalled("ACCNTMSISDN0").toString();
						Serenity.setSessionVariable("ACCNTMSISDN").to(MSISDNFromAccount);
						//String MSISDNFromAccount = "447389841133";
						report.Info("MSISDN From Account :- "+MSISDNFromAccount);
						System.out.println("MSISDN From Account :- "+MSISDNFromAccount);
					}
					else {

						//String MSISDNFromAccount = "447741728887";
						Account_No = Serenity.sessionVariableCalled("AccountNo").toString();
						puttyCommon.PuttyType("$","cd /home/pin/opt/portal/7.5/automation/sql_query");		
						puttyCommon.PuttyType("$","./purchased_product.sh "+Account_No);
						Database.ExecuteBRMDBQuery("MSISDNFromAccount");
						String MSISDNFromAccount = Serenity.sessionVariableCalled("ACCNTMSISDN0").toString();
						Serenity.setSessionVariable("ACCNTMSISDN").to(MSISDNFromAccount);
						report.Info("MSISDN From Account :- "+MSISDNFromAccount);
						System.out.println("MSISDN From Account :- "+MSISDNFromAccount);


					}
					SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				}


				@Step
				public void Invoice_fn(String Index) throws Exception 
				{
					String filePath = "\\src\\test\\resources\\data\\Putty.xls";
					String dataSheet = "Invoicing";  	

					Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Index, filePath, dataSheet);
					for (int i = 0;i < tableMap.get("Accnt").size();i++) {   
						String  sIndex = tableMap.get("Index").get(i);                 	
						String sAccnt = tableMap.get("Accnt").get(i);  
						String  sSequence = tableMap.get("Sequence").get(i);             	
						String  sInvoiceTimeSeq = tableMap.get("InvoiceTimeSeq").get(i);  
						if (sIndex.equals("")) 
							sIndex="0";        			

						if (sSequence.equals(""))
							sSequence="1";

						if (sInvoiceTimeSeq.equals("")) 
							sInvoiceTimeSeq="1;0";        			

						String Account_No = Serenity.sessionVariableCalled("AccountNo").toString();
						if (sAccnt.contains("ACCOUNTNO0"))
						{
							Account_No=Serenity.sessionVariableCalled("ACCOUNTNO0").toString();
						}
						if (sAccnt.contains("AccountNo1"))
						{
							Account_No=Serenity.sessionVariableCalled("AccountNo1").toString();
						}
						if (sAccnt.contains("AccountNo"))
						{
							Account_No=Serenity.sessionVariableCalled("AccountNo").toString();
						}
						puttyCommon.PuttyType("$","cd /home/pin/opt/portal/7.5/automation/bill_invoice");
						puttyCommon.PuttyType("bill_invoice","./invoicing.sh");
						puttyCommon.PuttyType("enter Account no for Invoicing",Account_No);
						puttyCommon.PuttyType("sequence",sSequence);
						puttyCommon.PuttyType("seq;sec",sInvoiceTimeSeq);
						//sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
						//Assert.assertTrue("Month End Invocing Failed",s.exists(SikulifilePath+"\\BillNowDone.png",15) != null);
						////if(s.exists(SikulifilePath+"\\BillNowDone.png", 15) != null){
						boolean b=puttyCommon.ValidatePutty("./invoicing.sh","Invoice poid is");
						if (b==false){
							SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
							Assert.assertTrue(false);
						}


						puttyCommon.CapturePuttyData("Invoice poid is", "PoidID", sIndex);
						String PoidID =Serenity.sessionVariableCalled("PoidID").toString().replace("Invoice poid is " , "");	
						report.Info("Month End Invocing Done :- Poid ID - "+PoidID);
						SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();


					}
				}
					
			@Step
	        public void BRMPuttyLogin(String PuttyLogFileName,String Environment ) throws FindFailed, InterruptedException, IOException, AWTException {
				
				
				String filePath = "\\src\\test\\resources\\data\\Account.xls";
				String dataSheet = "LoginToSiebel";
				//ReadWorkbook readWorkbook = new ReadWorkbook();
				Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Environment, filePath, dataSheet);
				readWorkbook.testData(tableMap);
				//Map <String,Map<Integer, String>> tableMap = this.testData(rowNo);
				for (int i = 0  ;i < tableMap.get("EnvURL").size();i++) {
					String BRMEnv = tableMap.get("EnvURL").get(i);
					System.out.println("BRMEnv is :- " +BRMEnv);
					Serenity.setSessionVariable("Environment").to(BRMEnv);
				}
			    Robot robot = new Robot();
			    robot.keyPress(KeyEvent.VK_WINDOWS);
			    robot.keyPress(KeyEvent.VK_D);
			    robot.keyRelease(KeyEvent.VK_D);
			    robot.keyRelease(KeyEvent.VK_WINDOWS);
			    report.Info("All Application minimized");
				//Serenity.setSessionVariable("SikulifilePathForSavingFile").to(SikulifilePathForSavingFile);
				
				
				 filePath = "\\src\\test\\resources\\data\\Putty.xls";
				 dataSheet = "LoginToPutty";
				 Environment = Serenity.sessionVariableCalled("Environment").toString();
				 Serenity.setSessionVariable("Env").to(Environment);
				 
				 System.out.println("Environment is :- " +Environment);
				 tableMap = readWorkbook.readRow(PuttyLogFileName, filePath, dataSheet);
				readWorkbook.testData(tableMap);
				getDriver().quit();
				App.close("putty.exe");
				String SikulifilePathForSavingfile= Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				
				
				for (int i = 0  ;i < tableMap.get("RowN").size();i++) {

					String Port = tableMap.get("Port").get(i);
					String Number = tableMap.get("Number").get(i);
					String LogFileName = tableMap.get("LogFileName").get(i);
					Serenity.setSessionVariable("LogFileName").to(LogFileName);
					String RootUser = tableMap.get("RootUser").get(i);		
					String RootPassword = tableMap.get("RootPassword").get(i);
					String Passphrase="Passphrase"+Environment;
					Thread.sleep(1000);
//							if(s.exists(SikulifilePath+"\\GoToDesktop.png",2) != null)
//			                	
//			                {
//			                  s.click(SikulifilePath+"\\GoToDesktop.png");                         
//			                  report.Info("All Application minimized");
//			                }
					//s.click(SikulifilePath+"\\GoToDesktop.png");
					Thread.sleep(1000);
            App.open("C:\\Program Files (x86)\\PuTTY\\putty.exe");
					
            Thread.sleep(1000);
            Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
            report.Info("Putty App Launched");
            String HostName="HostName"+Environment;
            s.type(tableMap.get(HostName).get(i));
            sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            //s.click(SikulifilePath+"\\PuttyLoginLogs.png");
            for(int loop=0;loop<3;loop++){
                if(s.exists(SikulifilePath+"\\PuttyLoginLogs.png",2) != null){
                	s.click(SikulifilePath+"\\PuttyLoginLogs.png");
                }else
                	break;
                }
            s.click(SikulifilePath+"\\AllSessionOutputPutty.png");
         
            for(int loop=0;loop<2;loop++){
            if(s.exists(SikulifilePath+"\\AllSessionCheckboxverify.png",2) != null){
            	break;
            }
            else{
            	s.click(SikulifilePath+"\\AllSessionOutputPutty.png");
            	System.out.println("Clicked");
            }
            }
            s.doubleClick(SikulifilePath+"\\PuttyLogFilePath.png");
            s.type(Key.DELETE);
            s.doubleClick();
            s.type(Key.DELETE);
            s.type(SikulifilePathForSavingfile+"\\"+LogFileName);
            s.click(SikulifilePath+"\\AlwaysAppendPuttyLogs.png");
            for(int loop=0;loop<2;loop++){
                if(s.exists(SikulifilePath+"\\VerifyAlwaysAppendPuttyLogs.png",2) != null){
                	break;
                }
                else{
                	 s.click(SikulifilePath+"\\AlwaysAppendPuttyLogs.png");
                	System.out.println("Clicked");
                }
                }
           
            sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
            //s.doubleClick(SikulifilePath+"\\SSH.png");
           // if (s.exists(SikulifilePath+"\\Auth.png",2)== null)
            	//s.doubleClick(SikulifilePath+"\\ReclickSSH.png");                
         
           // s.click(SikulifilePath+"\\Auth.png");
           // s.click(SikulifilePath+"\\AllowAgentForwarding.png");
            //s.click(SikulifilePath+"\\AllowAttemptedChanges.png");               
            
            String UserName="UserName"+Environment;
            //s.type(SikulifilePath+"\\PPKPath.png","C:/Users/"+(tableMap.get(UserName).get(i))+"/Putty/ssh_key_putty_newVo"+Environment+".ppk");
            //s.type(SikulifilePath+"\\PPKPath.png","C:/Users/"+(tableMap.get(UserName).get(i))+"/Putty/ssh_key_putty_newVo"+Environment+".ppk");
            Serenity.setSessionVariable("UserName").to(tableMap.get(UserName).get(i));
            Serenity.setSessionVariable("HostName").to(tableMap.get(HostName).get(i));
            Serenity.setSessionVariable("Passphrase").to(tableMap.get(Passphrase).get(i));
            sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
           // s.click(SikulifilePath+"\\Open.png");
            //s.click(SikulifilePath+"\\Open.png");
            Thread.sleep(2000);
            for(int loop=0;loop<3;loop++){
            if(s.exists(SikulifilePath+"\\Open.png",2) != null)
            	
            {
              s.click(SikulifilePath+"\\Open.png");                         
              report.Info("Open Button clicked on second atempt");
            }
            else{
            	break;
            }
            }
     /* if(s.exists(SikulifilePath+"\\Yes.png",2) != null)
    	
            {
              s.click(SikulifilePath+"\\Yes.png");                         
              report.Info("Yes Exists, Clicked on Yes");
            }*/
            //s.click(SikulifilePath+"\\MaximisePutty.png");
      for(int loop=0;loop<3;loop++){
      if(s.exists(SikulifilePath+"\\MaximisePutty.png",2) != null)
      	
      {	
    	  s.click(SikulifilePath+"\\MaximisePutty.png");  
    	  Thread.sleep(2000);
      }
      else{
    	  break;
      }
      
      }	
      		           		
      		  puttyCommon.PuttyType("login as:", tableMap.get(UserName).get(i)); 			
                  /*if(!Environment.equals("SUP01")){
                	  puttyCommon.PuttyType("enter a number","01");                      
                	  puttyCommon.PuttyType("Connect to","Y");
                  	}*/
      		  sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
              puttyCommon.PuttyType("password:", "P@ssw0rd");
              puttyCommon.PuttyType("$",RootUser);         
              puttyCommon.PuttyType("Password:",RootPassword);
    
              report.Info("Switch User to PIN Sucess");
              sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
			}
		}
			
			@Step
			public void Bill_fn(String Index) throws Exception 
				{
				String filePath = "\\src\\test\\resources\\data\\Putty.xls";
			   	String dataSheet = "Billing";     	
			   	
				Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(Index, filePath, dataSheet);
				     for (int i = 0;i < tableMap.get("Accnt").size();i++) {   
			        	String  sIndex = tableMap.get("Index").get(i);                 	
			        	String sAccnt = tableMap.get("Accnt").get(i);  
			        	String  sSequence = tableMap.get("Sequence").get(i);                 	
			        
			        		if (sIndex.equals("")) 
			        			sIndex="0";
			        			        		
			        		if (sSequence.equals(""))        		
			        			sSequence="1";
			        		        	
				String Account_No = Serenity.sessionVariableCalled("AccountNo").toString();
				if (sAccnt.contains("ACCOUNTNO0"))
				{
					Account_No=Serenity.sessionVariableCalled("ACCOUNTNO0").toString();
				}
				if (sAccnt.contains("AccountNo1"))
				{
					Account_No=Serenity.sessionVariableCalled("AccountNo1").toString();
				}
				if (sAccnt.contains("AccountNo"))
				{
					Account_No=Serenity.sessionVariableCalled("AccountNo").toString();
				}
				puttyCommon.PuttyType("$","cd /home/pin/opt/portal/7.5/automation/bill_invoice");
				puttyCommon.PuttyType("bill_invoice","./billing.sh");
				puttyCommon.PuttyType("enter Account no for billing",Account_No);
				puttyCommon.PuttyType("sequence",sSequence);
				boolean b=puttyCommon.ValidatePutty("./billing.sh","Bill_No");
				if (b==false){
					sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
					Assert.assertTrue(false);
				}
					b=puttyCommon.ValidatePutty("","Total number of records processed = 1");
					if (b==false){
						SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
						report.Info("Billing Failed");
						Assert.assertTrue(false);
					}
					puttyCommon.CapturePuttyData("LINEAFTER:Bill_No","BillNo",sIndex);			
					report.Info("Month End Billing Done :- BillNo - "+Serenity.sessionVariableCalled("BillNo").toString());
					SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
				
			}
				}
			
			@FindBy(xpath=".//*[text()='View Bill']")
			WebElementFacade ViewBill;
			
		    @FindBy(xpath=".//input[@name='j_username']")
		    WebElementFacade WCCUsername;
		    
		    @FindBy(xpath=".//input[@name='j_password']")
		    WebElementFacade WCCPassword;
		    
		    @FindBy(xpath=".//input[@value='Sign In']")
		    WebElementFacade WCCLogin;
		    
		    @FindBy(xpath=".//*[text()='View Bill']")
			WebElementFacade ViewPDFButton;
			
			
		    public void SavePDF() throws InterruptedException, IOException, FindFailed, AWTException{
				String SikulifilePath = "\\src\\test\\resources\\SikuliImages";
				String winHandleBefore = getDriver().getWindowHandle();
				Thread.sleep(5000);
				ViewPDFButton.click();
				Thread.sleep(5000);	
				for (String WinHandle : getDriver().getWindowHandles()){
					getDriver().switchTo().window(WinHandle);				
				}	
				getDriver().findElement(By.xpath(".//input[@name='j_username']")).sendKeys("ohsadmin");
				getDriver().findElement(By.xpath(".//input[@name='j_password']")).sendKeys("simple4u");
				getDriver().findElement(By.xpath(".//input[@name='j_password']")).sendKeys(Keys.chord(Keys.ENTER));
				Thread.sleep(5000);
				SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
			}
		    @Step
		    public void PuttyPayment(String BillingProfileType) throws Exception {
		                		
		    	String filePath = "\\src\\test\\resources\\data\\Putty.xls";
		       	String dataSheet = "Payment";     	
		       	
		    	Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(BillingProfileType, filePath, dataSheet);
		    	     for (int i = 0;i < tableMap.get("RowNo").size();i++) {   
		            	String  sPaymentType = tableMap.get("PaymentType").get(i);                 	
		            	String sAccountNo = tableMap.get("AccountNo").get(i);  
		            	String  sAmount = tableMap.get("Amount").get(i);                 	
		            	String sBillNoOption = tableMap.get("BillNoOption").get(i); 
		            	String sOverPayment = tableMap.get("OverPayment").get(i);
		            		
		            	if(sOverPayment.equals("")){
		            		sOverPayment = "N";
		            	}
		            	
		            	
		            	if(sPaymentType.equals("5")){            	        		
		            			Serenity.setSessionVariable("OverPayment").to(sAmount);
		            	}
		            	try{
		            	if(!Serenity.sessionVariableCalled("sAmount").toString().equalsIgnoreCase(null)){
		            		sAmount = Serenity.sessionVariableCalled("sAmount").toString();            	        	
		            	}
		            	}
		            	
		            	catch(Exception e){
		            		
		            	}
		            	if(sAmount.equals("AMOUNT0")){
		        			sAmount = Serenity.sessionVariableCalled("AMOUNT0").toString();
		        		}
		            		if(sAmount.equals("")){
		            			sAmount = "";
		            		}
		            		else{
		            			Serenity.setSessionVariable("AMOUNT0").to(sAmount);
		            			report.Info("AMOUNT0 is set to :- " +sAmount);
		            		}
		            	
		            	
		            	if(sAccountNo.equals("ACCNTMSISDN")){
		            		sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString();
		            	}
		            	
		            	if(sAccountNo.equals("ACCNTMSISDN0")){
		            		sAccountNo = Serenity.sessionVariableCalled("ACCOUNTNO0").toString();
		            	}
		            		 puttyCommon.PuttyType("$","cd /home/pin/opt/portal/7.5/automation/payment");         
		                     puttyCommon.PuttyType("payment","./payments.sh");
		                     puttyCommon.PuttyType("",sPaymentType);
		                     puttyCommon.PuttyType("",sAccountNo);
		                     
		          
		            	if (!(sPaymentType.equals("1")|| sPaymentType.equals("2") || sPaymentType.equals("3")))
		            	{
		            		puttyCommon.PuttyType("",sBillNoOption);
		            	}
		            	if(sPaymentType.equals("5"))  {
		            		long unixTime = System.currentTimeMillis() / 1000L;
		            		unixTime = unixTime - 86400;
		            		Serenity.setSessionVariable("UNIXTIME0").to(unixTime);
		            		Database.ExecuteDBQuery("UpdatePaymentDate");
		            		if(sBillNoOption.equals("N"))            	        			
		            			puttyCommon.PuttyType("",sAmount);
		            			puttyCommon.PuttyType("",sOverPayment);
		            	}
		    	       else             	        	
		            	puttyCommon.PuttyType("",sAmount);
		            	SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
		            	report.Info("sPaymentType :- "+sPaymentType +"  , sAccountNo :- "+sAccountNo +"  , sBillNoOption :- "+sBillNoOption +"  , sAmount :- "+sAmount +"  , sOverPayment :- "+sOverPayment);
		            
		            	boolean b=puttyCommon.ValidatePutty("./payments.sh","payment done");
		            	if (b==false){
		            		SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
		            		Assert.assertTrue(false);
		            	}
		            		report.Info("Payment Done");
		            		SikulifilePathForSavingFile = Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString();
		            		Serenity.setSessionVariable("AccountNo").to(sAccountNo);
		    	     }
		    }
		    @Step
		    public void PuttyRating(String RatingType) throws Exception {
		    		String filePath = "\\src\\test\\resources\\data\\Putty.xls";
		    	   	String dataSheet = "Rating";  
		    	   	Screen  s=new Screen();
		    	   	long TIMESTAMP0=0;
		    	   	 
		    		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(RatingType, filePath, dataSheet);
		    		     for (int i = 0;i < tableMap.get("RowNo").size();i++) {   
		    	        	String  sStreamChoice = tableMap.get("StreamChoice").get(i);                 	
		    	        	String sCDRType = tableMap.get("CDRType").get(i);  
		    	        	String  sNoEDR = tableMap.get("NoEDR").get(i);                 	
		    	        	String sDomesticRoaming = tableMap.get("Domestic/Roaming").get(i); 
		    	        	String sCr_Dr = tableMap.get("CrDr").get(i);
		    	        	String  sTax = tableMap.get("Tax").get(i);                 	
		    	        	String sDestination = tableMap.get("Destination").get(i); 
		    	        	String sBearerCapability= tableMap.get("BearerCapability").get(i);
		    	        	String sCountryCode= tableMap.get("CountryCode").get(i);
		    	        	String sCallingNo= tableMap.get("CallingNo").get(i);
		    	        	String sCalledNo= tableMap.get("CalledNo").get(i);
		    	        	String sTimestamp= tableMap.get("Timestamp").get(i);
		    	        	String sCnumber= tableMap.get("Cnumber").get(i);
		    	        	String sSMSQuantity= tableMap.get("SMSQuantity").get(i);
		    	        	String sGSM= tableMap.get("GSM").get(i);
		    	        	String sDuration= tableMap.get("Duration").get(i);            	        
		    	        	String sTariffClass= tableMap.get("TariffClass").get(i);
		    	        	String sSrcCountry= tableMap.get("SrcCountry").get(i);
		    	        	String sDetnCountry= tableMap.get("DetnCountry").get(i);
		    	        	String sRateGBP= tableMap.get("RateGBP").get(i);
		    	        	String iIndex= tableMap.get("Index").get(i);
		    	        	String sInOutPartial= tableMap.get("InOutPartial").get(i);
		    	        	String sTransactionType = tableMap.get("TransactionType").get(i);
		    	        	String sOldDayCDR =tableMap.get("OldDayCDR").get(i);
		    	        	//String sC_D =tableMap.get("CD").get(i);
		    	        	Serenity.setSessionVariable("RatingIndex").to(iIndex);
		    	        	//String MSISDNFromAccount = Serenity.sessionVariableCalled("ACCNTMSISDN0").toString();	     
		    	        	
		                    try {
		                    if(sCountryCode.equals("")){                                      
		                          sCountryCode = Serenity.sessionVariableCalled("CountryCode").toString();
		                    }}
		                    catch(Exception e){}                            
		                    try {
		                          if (sCallingNo.equals("ACCNTMSISDN")) {                     
		                    if(!Serenity.sessionVariableCalled("ACCNTMSISDN0").equals("")){ 
		                          
		                          sCallingNo = Serenity.sessionVariableCalled("ACCNTMSISDN0").toString();
		                }}
		                          else if (sCallingNo.equals("ACCNTMSISDN1"))     
		                          {
		                                if(!Serenity.sessionVariableCalled("ACCNTMSISDN1").equals("")){ 
		                                
		                                sCallingNo = Serenity.sessionVariableCalled("ACCNTMSISDN1").toString();
		                      }}
		                                else {System.out.println("Issue in ACCNT MSISDN ,please check the putty rating excel ");}
		                                
		                          
		                    }
		                    catch(Exception e){}                            
		                    
		                    try {
		                    if(!Serenity.sessionVariableCalled("sCalledNo").equals("")){
		                          sCalledNo = Serenity.sessionVariableCalled("sCalledNo").toString();
		               	        	
		    	        	}}
		            	catch(Exception e){}
		    	        	try {
		    	        	if(!Serenity.sessionVariableCalled("Cnumber").equals("")){
		    	        		sCnumber = Serenity.sessionVariableCalled("Cnumber").toString();            	        	
		    	        	}}
		    	        	catch(Exception e){}
		    	        	try {
		    	        	if(!sSMSQuantity.equals("")){
		    	        		Serenity.setSessionVariable("Duration_Quantity").to(sSMSQuantity);
		    	        	}}
		    	        	catch(Exception e){}
		    	        	try {
		    	        	if(sGSM.equals("")){            	        		
		    	        		sGSM = Serenity.sessionVariableCalled("GSM").toString();
		    	        	}}
		    	        	catch(Exception e){}
		    	        	try {
		    	        	if(!sDuration.equals("")){
		    	        		Serenity.setSessionVariable("Duration_Quantity").to(sDuration);
		    	        	}}
		    	        	catch(Exception e){}
		    	        	try {
		    	        	if(sTariffClass.equals("")){
		    	        		sTariffClass = Serenity.sessionVariableCalled("TariffClass").toString();
		    	        	}
		    	        	}
		    	        	catch(Exception e){}
		    	        	try {
		    	        	if(sSrcCountry.equals("")){
		    	        		sSrcCountry = Serenity.sessionVariableCalled("SrcCountry").toString();
		    	        	}}
		    	        	catch(Exception e){}
		    	        	try {
		    	        	if(sDetnCountry.equals("")){
		    	        		sDetnCountry = Serenity.sessionVariableCalled("DetnCountry").toString();
		    	        	}}
		    	        	catch(Exception e){}
		    	        	Serenity.setSessionVariable("RateGBP").to(sRateGBP);
		    	        	if(iIndex.equals("")){
		    	        		iIndex = "0";
		    	        	}
		            	        	
		        	if(sTimestamp.equals("")){
		        		
		        		long unixTimestamp = Instant.now().getEpochSecond();
		            	report.Info("Unix Time Stamp: "+unixTimestamp);
		            	
		      
		            	Database.ExecuteBRMDBQuery("AccountCreationTime");
		            	report.Info("AccountCreationTime    "+Serenity.sessionVariableCalled("MAXCREATED0").toString());
		            	long sAccountCreationTime = Integer.parseInt(Serenity.sessionVariableCalled("MAXCREATED0").toString()); 
		            	report.Info("sAccountCreationTime Time Stamp: "+sAccountCreationTime);
		            	if (sAccountCreationTime<=unixTimestamp){
		            		
		            		 TIMESTAMP0 = unixTimestamp+86400;
		            		 report.Info("Unix TIMESTAMP0 Stamp: "+TIMESTAMP0);
		            	}

		            	if (sAccountCreationTime==unixTimestamp) {
		            		TIMESTAMP0 = unixTimestamp+14400;
		            		report.Info("Unix TIMESTAMP0 Stamp: "+TIMESTAMP0);
		            	}
		            	if (sAccountCreationTime==0) {
		            		TIMESTAMP0 = unixTimestamp+86400;
		            		report.Info("Unix TIMESTAMP0 Stamp: "+TIMESTAMP0);
		            	}
		            	if (Long.toString(sAccountCreationTime)==sOldDayCDR) {
		            		TIMESTAMP0 = unixTimestamp-5270400;
		            		report.Info("Unix TIMESTAMP0 Stamp: "+TIMESTAMP0);
		            	}
		            	if (sAccountCreationTime>unixTimestamp){                                        
		                    report.Info("Account Creation Time :- "+sAccountCreationTime +"  , is greater than Unix time stamp :- "+unixTimestamp);
		                    Assert.assertTrue(false);     
		            		}
		            	
		        	}

		        	else {
		        		TIMESTAMP0 =Long.parseLong(Serenity.sessionVariableCalled("TIMESTAMP0").toString());
		        		report.Info("Time stamp extracted from DB :-  "+TIMESTAMP0);
		        	}
		    		puttyCommon.PuttyType("$","cd /home/pin/opt/portal/7.5/automation/rating");            	        	
		    		puttyCommon.PuttyType("rating","./rating.sh");
		    		puttyCommon.PuttyType("",sStreamChoice);
		    		puttyCommon.PuttyType("",sCDRType);
		    		puttyCommon.PuttyType("EDR",sNoEDR);
		    		puttyCommon.PuttyType("Domestic/Roaming",sDomesticRoaming);
		    		puttyCommon.PuttyType("code",sCountryCode);
		    		puttyCommon.PuttyType("In/Out/Partial",sInOutPartial);
		    		puttyCommon.PuttyType("A number",sCallingNo);
		    		puttyCommon.PuttyType("B number",sCalledNo);
		    		puttyCommon.PuttyType("C number",sCnumber);
		    		puttyCommon.PuttyType("credit/debit",sCr_Dr);
		    		puttyCommon.PuttyType("Duration",sDuration);
		    		puttyCommon.PuttyType("quantity",sSMSQuantity);
		    		puttyCommon.PuttyType("Rate in GBP",sRateGBP);
		    		puttyCommon.PuttyType("Transaction Type",sTransactionType);            	      
		    		puttyCommon.PuttyType("Timestamp",Long.toString(TIMESTAMP0));
		    		puttyCommon.PuttyType("Destination",sDestination);
		    		puttyCommon.PuttyType("Bearer",sBearerCapability);
		    		//puttyCommon.PuttyType("(C/D)",sC_D);
		    		puttyCommon.PuttyType("tax",sTax);
		    		puttyCommon.PuttyType("GSM",sGSM);
		    		puttyCommon.PuttyType("Tariff class",sTariffClass);
		    		puttyCommon.PuttyType("Source country",sSrcCountry);
		    		puttyCommon.PuttyType("Destination country",sDetnCountry);
		    		boolean b=puttyCommon.CapturePuttyData("LINEAFTER:Your CDR is", "CDRName", iIndex);
		    		if (b==false){
		    			sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
		    			Assert.assertTrue(false);
		    		}
		    		//puttyCommon.CapturePuttyData("LINEAFTER:Your CDR is", "CDRName", iIndex);
		    		
		    		String sCDR=Serenity.sessionVariableCalled("CDRName").toString();
		    		puttyCommon.PuttyType("$","cd /home/pin/opt/portal/var/brm/acrinput/router");            	        	
		    		puttyCommon.PuttyType("router","cat "+sCDR);
		    		Thread.sleep(1000);
		    		sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
		    		sCDR=sCDR.replace(".data", "");
		    		String[] sCDRs = sCDR.split("_");
		    		Serenity.setSessionVariable("CDRSeq").to(sCDRs[3]);
		    		//sCDR = sCDR.replace(sCDRs[0], "");
		    		if (sOldDayCDR.equals("Y"))
		    		{
		    			puttyCommon.PuttyType("$","cd /home/pin/opt/portal/var/brm/log/pin01/ifw/stream");	
		    			boolean sTypeCapturePuttyData = puttyCommon.TypeCapturePuttyData ("$","ls -1 *" + sCDR + "*",sCDR +".data.log","OutCDR");
		    			if (sTypeCapturePuttyData==false){
		    				sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
		    				Assert.assertTrue(false);
		    				//puttyCommon.TypeCapturePuttyData ("$","ls -1 *" + sCDR + "*",sCDR +".data.log","OutCDR");
		    			}
		    		}
		    		else 
		    			{
		    			puttyCommon.PuttyType("$","cd /home/pin/opt/portal/var/brm/ploutput/pin01/pin_rel_01/archive");
		    			boolean sTypeCapturePuttyData = puttyCommon.TypeCapturePuttyData ("$","ls -1 *" + sCDRs[3] + "*",sCDRs[3] +".out.bc","OutCDR");
		    			/*if (sTypeCapturePuttyData==false){
		    				sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
		    				Assert.assertTrue(false);   
		    				//puttyCommon.TypeCapturePuttyData ("$","ls -1 *" + sCDRs[3] + "*",sCDRs[3] +".out.bc","OutCDR");
		    			}*/
		    			}
		    			try {
		    			String sOutCDR=Serenity.sessionVariableCalled("OutCDR").toString();
		    			sOutCDR = sOutCDR.replace("[00m", "");
		    			puttyCommon.PuttyType("$","cat "+sOutCDR);
		    			}
		    		    catch(Exception e) {
		    		    	
		    		    }
		    			sikuliUtility.SikuliScreenShot(SikulifilePathForSavingFile);
		    		        		
		    		  }
		    			     
		    		}

}