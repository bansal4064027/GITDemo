package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;

import org.sikuli.script.Screen;



import net.serenitybdd.core.Serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.SikuliUtility;
import utilities.common;
import pages.DatabasePage;

public class Screenshot {
	@Steps
	ReportMessege report;

	@Steps
	private ReadWorkbook readWorkbook;

	@Steps
	private DatabasePage Database;

	@Steps
	private common common1;
	@Steps
	private SikuliUtility sikuliUtility;
	
	String SikulifilePathForSavingFile = "";
	Screen  s=new Screen();
	
	public String FolderName ="";
	@Step
	public void Prerequisite(String FolderName) throws IOException{
		
		String filePath = "\\src\\test\\resources\\data\\Account.xls";
		String dataSheet = "LoginToSiebel";
		Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow("RETAIL", filePath, dataSheet);
		readWorkbook.testData(tableMap);
		for (int i = 0  ;i < tableMap.get("Username").size();i++) {			
			String sEnv = tableMap.get("EnvURL").get(i);
			
			Serenity.setSessionVariable("Env").to(sEnv);
		}
		Serenity.setSessionVariable("FolderName").to(FolderName);
	
		this.FolderName =FolderName;
		String currentDir = System.getProperty("user.dir");
	
		System.out.println("myCurrentDir" +currentDir);
		
		try{
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		    Date now = new Date();       		   

			File file =new File(currentDir+"\\OutputResults\\" +sdfDate.format(now));
		if(!file.exists()){		
			new File(currentDir+"\\OutputResults\\" +sdfDate.format(now)).mkdir();			
		}
		String Randomno = Integer.toString((11111 + (int)(Math.random()*222222)));  
		
		File ScriptFolder =new File(currentDir+"\\OutputResults\\" +sdfDate.format(now)+"\\"+FolderName+"_"+Randomno);
		if(!ScriptFolder.exists()){		
			
			System.out.println("Inside if " + currentDir+"\\OutputResults\\" +sdfDate.format(now));
			new File(currentDir+"\\OutputResults\\" +sdfDate.format(now)+"\\"+FolderName+"_"+Randomno).mkdir();	
			this.SikulifilePathForSavingFile = (currentDir+"\\OutputResults\\" +sdfDate.format(now)+"\\"+FolderName+"_"+Randomno);
		}
		else{			      						
			new File(currentDir+"\\OutputResults\\" +sdfDate.format(now)+"\\"+FolderName+"_"+Randomno).mkdir();
			this.SikulifilePathForSavingFile = (currentDir+"\\OutputResults\\" +sdfDate.format(now)+"\\"+FolderName+"_"+Randomno);
			}
		
		}
		
		catch(Exception e){
			
		}
		Serenity.setSessionVariable("SikulifilePathForSavingFile").to(this.SikulifilePathForSavingFile);
		
		  	}
	
}
