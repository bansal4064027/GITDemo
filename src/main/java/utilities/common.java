package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.jbehave.core.annotations.Named;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import java.io.BufferedWriter;
import java.io.FileWriter;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import utilities.ReportMessege;

public class common extends PageObject{
	@Steps
	ReportMessege report;
	@Steps
	private SikuliUtility sikuliUtility;
	@Steps
	private common Common;
	int firstRow,lastRow;
	int totalRow = -1;
	public int selectedRow = -1;
	public static Map <String,String> DictionaryTest_G= new HashMap<String, String>();
	
	@Step
	public String locateColumn(String applet,String table,String sLocateCol,String sLocateColValue,String index){
		try{
			int parsedRows=0;
			int currParsedRows=0;
		//	withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(applet+table));
			if (sLocateColValue.contains("All|")){
				return locateColumnAll (applet,table,sLocateCol,sLocateColValue,index);
			}
			int i;
			String prevRecord = "";
			Map<String,String> map1 = new HashMap<String,String>();
			String[] arr1 = sLocateCol.split(Pattern.quote("|"));
			String[] arr2 = sLocateColValue.split(Pattern.quote("|"));
			
			int arrCnt1 = arr1.length;
			
			for (int k =0; k < arrCnt1; k++){
				map1.put(arr1[k], arr2[k]);
			}
			
			Map<String,String> map2 = new HashMap<String,String>();
			WebElement list = getDriver().findElement(By.xpath(applet+table));
			int cnt = list.findElements(By.tagName("tr")).size();
			//Assert.assertFalse("No columns found", cnt == 0);
			
			
			String[] arr = (String[]) map1.keySet().toArray(new String[map1.size()]);
			/*Iterator<String> iterator = arr.iterator();
			int k = 0;
			while(iterator.hasNext()){
				map2.put(iterator.next(), k);
			}*/
			//String currRecord = obj.findElement(By.xpath("//*[@class='siebui-row-counter']")).getText();
			String currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
			int actIndex = 0;
			do{
				this.getRowCount(currRecord);
				
				if (sLocateColValue.equals("Null")){                                                                         
                    if (totalRow == 0){
	                    report.Info("Pass :As expected no rows found");
	                    return "true";
                    }
                    else{
                    	report.Info("Fail : Rows found");
                    	return "false";
                    }
                    
				}
				else{
					Assert.assertTrue("No rows found",!(totalRow == 0));
					report.Info("Pass :As expected rows found");
				}
				if (currParsedRows> firstRow){
					currParsedRows = currParsedRows - firstRow;
				}
				else {
					currParsedRows = 0;
				}
				for (i = currParsedRows + 1;i <= lastRow+1-firstRow; i++){
					
					//getDriver().findElement(By.xpath(applet+table+"//tr[@id='"+i+"']")).click();
					((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", getDriver().findElement(By.xpath(applet+table+"//tr[@id='"+i+"']")));
					
					for (int j = 0; j < arr.length; j++){
						map2.put(arr[j], getDriver().findElement(By.xpath(applet+table+"//tr[@id='"+i+"']//td[contains(@id,'"+arr[j]+"')]")).getText());
					}
				
					boolean flag = false;
					for (int j = 0; j < arr.length; j++){
						flag = false;
						if (map1.get(arr[j]).contains("*")){
							String tempValue = map1.get(arr[j]).replace("*", "");
							try{
			            		
			            		String keyVal = Serenity.sessionVariableCalled(tempValue).toString();
			            		tempValue = tempValue.replace(tempValue, keyVal);
			            		
			            	}
			            	catch(NullPointerException e){}
							if (map2.get(arr[j]).contains(tempValue)){
								flag = true;
							}
							else if (tempValue.contains("&&")) {
								String[] tempValues = tempValue.split(Pattern.quote("&&"));
								if (tempValues[1].contains("NOT-")){
									if (map2.get(arr[j]).contains(tempValues[0]) && !(map2.get(arr[j]).contains(tempValues[1].replace("NOT-", "")))){
										flag = true;
									}
									else {
										flag = false;
										break;
									}
								}
								else {
									if (map2.get(arr[j]).contains(tempValues[0]) && (map2.get(arr[j]).contains(tempValues[1]))){
										flag = true;
									}
									else {
										flag = false;
										break;
									}
								}
							}
							else {
								flag = false;
								break;
							}
						}
						else {
							String tempValue = map1.get(arr[j]);

							try{

								String keyVal = Serenity.sessionVariableCalled(tempValue).toString();
								tempValue = tempValue.replace(tempValue, keyVal);

							}
							catch(NullPointerException e){}
							if (map2.get(arr[j]).equals(tempValue)){
								flag = true;
							}
							else if (tempValue.contains("&&")) {
								String[] tempValues = tempValue.split(Pattern.quote("&&"));
								if (tempValues[1].contains("NOT-")){
									if (map2.get(arr[j]).equalsIgnoreCase(tempValues[0]) && !(map2.get(arr[j]).contains(tempValues[1]))){
										flag = true;
									}
									else {
										flag = false;
										break;
									}
								}
								else {
									if (map2.get(arr[j]).equalsIgnoreCase(tempValues[0]) && (map2.get(arr[j]).equalsIgnoreCase(tempValues[1]))){
										flag = true;
									}
									else {
										flag = false;
										break;
									}
								}
							}
							else if (tempValue.contains("NOT-")){
								tempValue = tempValue.replace("NOT-", "");
								if (!map2.get(arr[j]).contains(tempValue)){
									flag = true;
								}
								else {
									flag = false;
									break;
								}

							}
							else {
								flag = false;
								break;
							}
						}
					}
	             if (flag == true){
						if (String.valueOf(actIndex).equals(index)){
							this.selectedRow = i;
							return "true";
							
						}
						else{
							actIndex = actIndex + 1;
						}
					}									
				}
				parsedRows = parsedRows + i;
				currParsedRows = parsedRows-1;
				prevRecord = currRecord;
				getDriver().findElement(By.xpath(applet+"//*[@title='Next record set']")).click();
				Thread.sleep(3000);
				currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
			} while (!currRecord.equals(prevRecord));
			return "False-Row Not Exist";
		}catch (Exception e){
			//System.out.println(e.getMessage());
			return e.getMessage();
		}
		//return "False";
	}
		

	@Step
	public String locateColumnAll(String applet,String table,String sLocateCol,String sLocateColValue,String index){
		try{
			int parsedRows=0;
			int currParsedRows=0;
			int i;
			String prevRecord = "";
			Map<String,String> map1 = new HashMap<String,String>();
			String[] arr1 = sLocateCol.split(Pattern.quote("|"));
			String[] arr2 = sLocateColValue.split(Pattern.quote("|"));
			
			int arrCnt1 = arr1.length;
			
			for (int k =0; k < arrCnt1; k++){
				map1.put(arr1[k], arr2[k]);
			}
			
			Map<String,String> map2 = new HashMap<String,String>();
			WebElement list = getDriver().findElement(By.xpath(applet+table));
			int cnt = list.findElements(By.tagName("tr")).size();
			//Assert.assertFalse("No columns found", cnt == 0);
			
			
			String[] arr = (String[]) map1.keySet().toArray(new String[map1.size()]);
			/*Iterator<String> iterator = arr.iterator();
			int k = 0;
			while(iterator.hasNext()){
				map2.put(iterator.next(), k);
			}*/
			//String currRecord = obj.findElement(By.xpath("//*[@class='siebui-row-counter']")).getText();
			String currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
			int actIndex = 0;
			do{
				this.getRowCount(currRecord);
				if (totalRow == 0){
					Assert.assertFalse("No rows found",totalRow == 0);
				}
				if (currParsedRows> firstRow){
					currParsedRows = currParsedRows - firstRow;
				}
				else {
					currParsedRows = 0;
				}
				for (i = currParsedRows + 1;i <= lastRow+1-firstRow; i++){
					
					getDriver().findElement(By.xpath(applet+table+"//tr[@id='"+i+"']")).click();
					
					for (int j = 0; j < arr.length; j++){
						map2.put(arr[j], getDriver().findElement(By.xpath(applet+table+"//tr[@id='"+i+"']//td[contains(@id,'"+arr[j]+"')]")).getText());
					}
				
					boolean flag = false;
					for (int j = 0; j < arr.length; j++){
						flag = false;
						
						String tempValue = map1.get(arr[j]);
						try{
		            		
		            		String keyVal = Serenity.sessionVariableCalled(tempValue).toString();
		            		tempValue = tempValue.replace(tempValue, keyVal);
		            		
		            	}
		            	catch(NullPointerException e){}
						if (map1.get(arr[j]).toUpperCase().equals("ALL")){
							flag = true;
						}
						else if (map1.get(arr[j]).toUpperCase().equals(map2.get(arr[j]).toUpperCase())){
							flag = true;
						}
						else {
							flag = false;
							break;
						}
					}
	
				}
				parsedRows = parsedRows + i;
				currParsedRows = parsedRows-1;
				prevRecord = currRecord;
				getDriver().findElement(By.xpath(applet+"//*[@title='Next record set']")).click();
				currRecord = getDriver().findElement(By.xpath(applet+"//*[@class='siebui-row-counter']")).getText();
			} while (!currRecord.equals(prevRecord));
			return "True";
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return "True";
	}

	
	public void getRowCount (String currRecord){
        if (currRecord.equals("No Records")){
                        totalRow = 0;
                        
        }
        else {
        //String totalRow1 = currRecord.split(Pattern.quote("of "))[1];
        	totalRow = -1;
                    firstRow = Integer.parseInt(currRecord.split(Pattern.quote(" - "))[0]);
                    lastRow = Integer.parseInt(currRecord.split(Pattern.quote("of "))[0].split(Pattern.quote(" - "))[1].trim());
        }
}
	
	public String updateSiebList(String applet,String table, String objDetails, String value1) throws InterruptedException{

		String[] objDetailsArray = objDetails.split(Pattern.quote("|"));
		String className = objDetailsArray[0];
		String uiName = objDetailsArray[1];
		int i = this.selectedRow;
		String cellPath = applet+table+"//tr[@id='"+i+"']//td[contains(@id,'"+uiName+"')]";
		String cellInputPath = applet+table+"//tr[@id='"+i+"']//td[contains(@id,'"+uiName+"')]//input";
		String cellInputPath1 = applet+table+"//tr[@id='"+i+"']//td[contains(@id,'"+uiName+"')]//span";
		String cellLinkPath = applet+table+"//tr[@id='"+i+"']//td[contains(@id,'"+uiName+"')]//a";
		String cellOpenUIPath = applet+table+"//tr[@id='"+i+"']//td[contains(@id,'"+uiName+"')]//span";
		String cellTextAreaPath = applet+table+"//tr[@id='"+i+"']//td[contains(@id,'"+uiName+"')]//textarea";
		
		if (className.equals("Click")){
			Common.waitForElement(By.xpath(cellPath));;
			find(By.xpath(cellPath)).click();
		}
		
		if (className.equals("DoubleClick")){
			Common.waitForElement(By.xpath(cellPath));
			find(By.xpath(cellPath)).click();
			Actions action = new Actions(getDriver());
			action.moveToElement(find(By.xpath(cellTextAreaPath))).doubleClick().perform();
		}
		
		if (className.equals("Text")){
			Common.WaitForObjectPresence(cellPath); 
			//	withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			//
			find(By.xpath(cellPath)).click();
			//
			find(By.xpath(cellInputPath)).sendKeys(value1);
			find(By.xpath(cellPath)).sendKeys(Keys.TAB);
		}
		if (className.equals("TextArea")){
			//	withTimeoutOf(140,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			Common.waitForElement(By.xpath(cellPath)); 
			//
			find(By.xpath(cellPath)).click();
			//
			find(By.xpath(cellTextAreaPath)).sendKeys(value1);

		}
		if (className.equals("Clear")){
			//withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			Common.waitForElement(By.xpath(cellPath)); 
			//
			find(By.xpath(cellPath)).click();
			//
			Thread.sleep(1000);
			find(By.xpath(cellInputPath)).click();
			getDriver().findElement(By.xpath(cellInputPath)).clear();

		}
		else if (className.equals("List1")){
			Common.waitForElement(By.xpath(cellPath));  //dont delete
			find(By.xpath(cellPath)).click();
			find(By.xpath(cellInputPath1)).click();

			find(By.xpath("//li[text()='"+value1+"']")).click();

		}  
		else if (className.equals("List2")){
			//withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			Common.waitForElement(By.xpath(cellPath)); 
			find(By.xpath(cellPath)).click();            
			find(By.xpath(cellInputPath)).sendKeys(Keys.CLEAR);
			find(By.xpath(cellInputPath)).sendKeys(value1);
		}
		
		else if (className.equals("List3")){			
			Common.waitForElement(By.xpath(cellPath)); 
			find(By.xpath(cellPath)).click();            
			find(By.xpath(cellInputPath)).typeAndEnter(value1);
		}

		else if (className.equals("List")){
			Common.waitForElement(By.xpath(cellPath));  //dont delete
			find(By.xpath(cellPath)).click();
			find(By.xpath(cellInputPath1)).click();

			find(By.xpath("//li[text()='"+value1+"']")).click();
		}   
		
/*		else if (className.equals("List")){
			//	withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			Common.waitForElement(By.xpath(cellPath)); 
			find(By.xpath(cellPath)).click();            
			find(By.xpath(cellInputPath)).typeAndEnter(value1);
		}*/
		else if (className.equals("CaptureTextValue")){
			withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			String capturedValue = find(By.xpath(cellPath)).getTextValue();
			return capturedValue;
			//Serenity.setSessionVariable("CapturedValue").to(CapturedValue);

		}
		else if (className.equals("CaptureCompareTextValue")){
			try{

				String keyVal = Serenity.sessionVariableCalled(value1).toString();
				value1 = value1.replace(value1, keyVal);

			}
			catch(NullPointerException e){}
			String flag ="N";
			try{
				withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			}
			catch(Exception e){

			}
			String capturedValue = find(By.xpath(cellPath)).getTextValue();
			if (value1.contains("*")){
				value1 = value1.replace("*", "");

				Assert.assertTrue("Expected value " + value1 + "* doesnot match with actual " + capturedValue, capturedValue.contains(value1));
				report.Info("Expected value " + value1 + " found");

			}
			else {
				Assert.assertTrue("Expected value " + value1 + "* doesnot match with actual " + capturedValue, capturedValue.equals(value1));
				report.Info("Expected value " + value1 + " found");
			}


		}
		else if (className.equals("CheckBox")){
			//withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			Common.waitForElement(By.xpath(cellPath)); 
			find(By.xpath(cellPath)).click();

			find(By.xpath(cellInputPath)).click();

		}
		else if (className.equals("CheckBoxStatusChecked")){
			try{
				withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			}
			catch(Exception e){

			}
			String ischecked = (find(By.xpath(cellPath)).getAttribute("title"));
			if (ischecked.equals("Checked")||ischecked.equals("Y")){
				return "true";            	  
			}
		}
		else if (className.equals("DrillDown")){
			//	withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellLinkPath));
			Common.waitForElement(By.xpath(cellLinkPath)); 
			getDriver().findElement(By.xpath(cellLinkPath)).click();                
		}
		else if (className.equals("OpenPopUp")){
			//withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			Common.waitForElement(By.xpath(cellPath)); 
			find(By.xpath(cellPath)).click();
			getDriver().findElement(By.xpath(cellOpenUIPath)).click();
		} 
		else if (className.equals("OpenPopUpUsingTAB")){
			//withTimeoutOf(120,TimeUnit.SECONDS).waitFor(By.xpath(cellPath));
			Common.waitForElement(By.xpath(cellPath)); 
			find(By.xpath(cellPath + "/preceding-sibling::td[1]")).click();
			find(By.xpath(cellPath + "/preceding-sibling::td[1]//input")).sendKeys(Keys.TAB);
			getDriver().findElement(By.xpath(cellOpenUIPath)).click();
		} 

		return null;



	}

	
	public void ExpandRow(String applet, String table){
		int i = this.selectedRow;
		try{
			getDriver().findElement(By.xpath(applet+table+"//tr[@id='"+i+"']//td[1]//*[contains(@class,'tree-plus treeclick')]")).click();
		}
		catch (Exception e){
		}
		
	}

	@FindBy(xpath=".//*[contains(text(),'Halo - please read')]")
	  WebElementFacade ErrorTitleBox;
	 @FindBy(xpath=".//div[contains(@class,'popup-info')]  ")
	  WebElementFacade ErrorMsg; 
	 @FindBy(xpath=".//button[contains(@class,'confirm-popup')]")
	  WebElementFacade ErrorOkButton;
	 
	 @FindBy(xpath=".//*[contains(text(),'Halo - please read')]")
	  WebElement ErrorTitleBoxSync;
	
	 public void HandleErrorPopUp(String sPopup) throws IOException, AWTException, InterruptedException{
		 Common.waitForElement(ErrorTitleBoxSync);
		 if(ErrorTitleBox.isCurrentlyVisible()&& (!sPopup.equalsIgnoreCase("No"))){
			 String ErrorInfo= ErrorMsg.getText();  

			 if (sPopup.contains("OPTIONAL:")){
				 sPopup= sPopup.substring(9);
			 }
			 if(ErrorInfo.contains(sPopup)){	
				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 ErrorOkButton.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable(); 
				 ErrorOkButton.click();
				 report.Info("The alert meaasage is:"+ErrorInfo);
			 }
			 else{
				 sikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
				 report.Info("UnExpected Pop did occured");
				 Assert.assertTrue(false);   
			 }

		 }
		 else if (!ErrorTitleBox.isCurrentlyVisible()&& (sPopup.contains("OPTIONAL:"))){ 
			 report.Info("OPTIONAL Pop did not occur");
			 Assert.assertTrue(true);                                      
		 }

		 else if (!ErrorTitleBox.isCurrentlyVisible()&& (!sPopup.equalsIgnoreCase("No"))){
			 report.Info("Expected Pop did not occur");
			 Assert.assertTrue(false);                                  
		 }
		 else if (ErrorTitleBox.isCurrentlyVisible()&& (sPopup.equalsIgnoreCase("No"))){
			 report.Info("UnExpected Pop did occured");
			 Assert.assertTrue(false);                                  
		 }
	 } 
		
	
	public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(pageLoadCondition);
    }
	
	public boolean waitForElement(WebElement w){
		try{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		 wait.until(ExpectedConditions.elementToBeClickable(w));
		 
		 return true;
		}
		catch (Exception e){
			return false;
		}

	}
	
	public boolean waitForElement30(WebElement w){
		try{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		 wait.until(ExpectedConditions.elementToBeClickable(w));
		 
		 return true;
		}
		catch (Exception e){
			return false;
		}

	}
	
	public boolean waitForElement(By w){
		try{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		 wait.until(ExpectedConditions.elementToBeClickable(w));
		 
		 return true;
		}
		catch (Exception e){
			return false;
		}

	}
	
	public boolean WaitForClock(WebElement Clockobj){
		try{
			WebDriverWait wait = new WebDriverWait(getDriver(), 120);			 
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@style,'display: none;')][ @id='maskoverlay']")));	
			return true;
		 
		}
		catch (Exception e){
			return false;
		}

	}
	
	public void PageRefresh(){
		try{
			Robot robot = new Robot();	 
			robot.keyPress(KeyEvent.VK_F5);	
			robot.keyRelease(KeyEvent.VK_F5); 
			WebDriverWait wait = new WebDriverWait(getDriver(), 150);			 
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@style,'display: none;')][ @id='maskoverlay']")));				 	
		}
		catch (Exception e){
			
		}
	}
	public boolean WaitForObjectPresence(String Object){
		try{
			WebDriverWait wait = new WebDriverWait(getDriver(), 120);			 
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Object)));	
			 return true;
		}
		catch (Exception e){
			return false;
			
		}
	}
	
	public void Meta(String Meta) throws IOException
	{
	String currentDir = System.getProperty("user.dir");
	FileWriter fr=new FileWriter(currentDir+"\\Performance.txt",true);
	BufferedWriter br=new BufferedWriter(fr);
	br.newLine();
	br.write("--------------------------------------------------------");
	br.newLine();
	br.write(Meta);
	br.newLine();	
	br.close();
	}
	public void WritePerformanceOutput(String sPerformance) throws IOException
	{
	String currentDir = System.getProperty("user.dir");
	FileWriter fr=new FileWriter(currentDir+"\\Performance.txt",true);
	BufferedWriter br=new BufferedWriter(fr);	
	br.newLine();
	br.write(sPerformance);
	br.close();
	}
	
	
	public String returnDispatchDate() {
		ZonedDateTime currentDate = ZonedDateTime.now(ZoneOffset.UTC ).minusDays(-1);
		return currentDate.toString().substring(0,19);
	}
	
	public String returnTodaysDate() {
		ZonedDateTime currentDate = ZonedDateTime.now(ZoneOffset.UTC );
		return currentDate.toString().substring(0,19)+"Z";
	}
	
	public String returnRandomIMEI() {
		Random random = new Random();
		StringBuffer updatedIMEI = new StringBuffer();
		
		for(int i=0 ; i<15 ; i++){
			int intIMEI = random.nextInt(10);
			updatedIMEI = updatedIMEI.append(Integer.valueOf(intIMEI).toString()); 
		}
		return updatedIMEI.toString();
	}
	
	
}
