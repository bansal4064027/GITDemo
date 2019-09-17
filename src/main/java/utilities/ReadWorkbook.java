package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ReadWorkbook extends PageObject{
		//private static final String FILE_NAME = "C:\\VATS Automation\\Automation\\NewCo\\Data\\Account.xls";
		
	@Steps
	ReportMessege report;
	public static int rowNo = 1;
	public static String destPath = "";	
		
		
		
		public Map<String, Map<Integer, String>> readRow(String row, String filePath, String dataSheet) throws IOException{
		
		//public static void main(String[] args) throws IOException{
			 Map <String,Map<Integer, String>> tableMap = new HashMap<String, Map<Integer, String>>();

		try{
			//String filePath = "\\src\\test\\resources\\data\\Account.xls";
			//String dataSheet = "CreateNewAccount";
			//String excelFilePath = "Books.xlsx";
			String currentDir = System.getProperty("user.dir");
			filePath = currentDir.concat(filePath);
			 
	        FileInputStream inputStream = new FileInputStream(new File(filePath));
	         
	        Workbook workbook = new HSSFWorkbook(inputStream);
	        
		//FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
		//HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet datatypeSheet = (HSSFSheet) workbook.getSheet(dataSheet);
		
	        Iterator<Row> iterator = datatypeSheet.iterator();
		 //String row = "PostpaidConsumerdd";
		 
		 Row firstRow = iterator.next();
		 Iterator<Cell> firstRowCell = firstRow.iterator();
		 List<String> cellNames = new ArrayList<String>();
		 firstRowCell.next();
		 while (firstRowCell.hasNext()){
			 //
			 Cell cell = firstRowCell.next();
			 cellNames.add(cell.getStringCellValue());
		 }
		 List<Integer> totalRows = new ArrayList<Integer>();
		 String flag = "";
         while (iterator.hasNext()) {
        	 
             Row currentRow = iterator.next();
             //CellStyle currRow = currentRow.getCell(0).
             String currRow = currentRow.getCell(0).getStringCellValue();
              
             if (row.equals(currRow)){
            	 totalRows.add(currentRow.getRowNum());
            	 flag = "found";
             } else if (flag == "found"){
        		 break;
        	 }
              
         }
         if (!flag.equals("found")){
        	 report.Info("Logical Name " + row + " not found in the sheet " + dataSheet);
        	 Assert.assertTrue(false);        	 
         }
         
         int i = 1;
         for (String x : cellNames){
        	 int k = 0; 
        	 Map<Integer,String> entireRow = new HashMap<Integer,String>();
        	 for (Integer y : totalRows){
        		 Row currRow = datatypeSheet.getRow(y);
        		 String cellContent = "";
        		 if (currRow.getCell(i) == null){
        			 cellContent = "";
        		 }else if (currRow.getCell(i).getCellTypeEnum() == CellType.STRING){
        			 cellContent = currRow.getCell(i).getStringCellValue();
        		 }else if (currRow.getCell(i).getCellTypeEnum() == CellType.NUMERIC){
        			 cellContent = String.valueOf(currRow.getCell(i).getNumericCellValue());
        		 }
        		 else if (currRow.getCell(i).getCellTypeEnum() == CellType.BLANK){
        			 cellContent = "";
        		 }
        		 else if (currRow.getCell(i).getCellTypeEnum() == CellType.FORMULA){
        			 switch(currRow.getCell(i).getCachedFormulaResultTypeEnum()) {
        	            case NUMERIC:
        	            	Date date = currRow.getCell(i).getDateCellValue();
        	            	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        	            	cellContent = df.format(date);
        	                break;
        	            case STRING:
        	            	cellContent = currRow.getCell(i).getStringCellValue();
        	                break;
        	                 	        }
        			         		 }
        		 entireRow.put(k, cellContent);
        		 k = k + 1;
        	 }
        	 tableMap.put(x, entireRow);
        	 i =i +1;
        	 
         }
         
        
         //return tableMap;
        	// Map<String,Integer> cellValues = new HashMap<String,Integer>();
            // Iterator<Cell> cellIterator = currentRow.iterator();
            // int i =0;
           //  while (cellIterator.hasNext()) {

               //  Cell cell = cellIterator.next();
                 //getCellTypeEnum shown as deprecated for version 3.15
                 //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                // if (cell.getCellTypeEnum()==CellType.STRING){
              ///  	 cellValues.put(cell.getStringCellValue(), i);
              //   }
               //  i = i+1;
          //   }
            // System.out.println();
          

         
      
		}	catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (Exception e){
    	 e.printStackTrace();
     }
		return tableMap;
		

	
	}
		
	@Step
	public void testData(Map <String,Map<Integer, String>> tableMap){
		
		
	}
	
	public void createOutputExcelFile() throws IOException {
		String currentDir = System.getProperty("user.dir");
		FileSystem system = FileSystems.getDefault();
		String srcPath = currentDir.concat("\\OutputResults\\OutputSheet.xls");
		Path srcPath1 = system.getPath(srcPath);
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
	    Date now = new Date();   
	    String Randomno = Integer.toString((11111 + (int)(Math.random()*222222)));  
	    destPath = currentDir.concat("\\OutputResults\\"+sdfDate.format(now)+"\\OutputSheet"+Randomno+".xls");
	    System.out.println(destPath);
	    Path destPath1 = system.getPath(destPath);
	    Files.copy(srcPath1, destPath1, StandardCopyOption.REPLACE_EXISTING);
	    
	            
	    
	}
	
	public void writeOutputExcelFileTCPass() throws IOException{
		FileInputStream inputStream = new FileInputStream(new File(destPath));
        Workbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet datatypeSheet = (HSSFSheet) workbook.getSheet("Sheet1");
        
        Row currRow = datatypeSheet.createRow(rowNo);

        Cell cell = currRow.createCell(0);

        cell.setCellType(CellType.STRING);

        cell.setCellValue(Integer.toString(rowNo));
        
        cell = currRow.createCell(1);

        cell.setCellType(CellType.STRING);

        cell.setCellValue(Serenity.sessionVariableCalled("Env").toString());
        
        cell = currRow.createCell(3);

        cell.setCellType(CellType.STRING);

        cell.setCellValue(Serenity.sessionVariableCalled("Meta").toString());
        
        
        try{
        	cell = currRow.createCell(5);
        	
	        cell.setCellType(CellType.STRING);
	        cell.setCellValue(Serenity.sessionVariableCalled("AccountNo").toString());
	        
	        
        }catch (Exception e){}
        try{
        	cell = currRow.createCell(6);
        	
	        cell.setCellType(CellType.STRING);
	        cell.setCellValue(Serenity.sessionVariableCalled("OrderNo").toString());
	        
	        
        }catch (Exception e){}
        try{
        	cell = currRow.createCell(7);
	    	
	        cell.setCellType(CellType.STRING);
	        cell.setCellValue(Serenity.sessionVariableCalled("MSISDN").toString());
	        
    	}catch (Exception e){}
        
        cell = currRow.createCell(9);
    	
        cell.setCellType(CellType.STRING);
        
        cell.setCellValue("Pass");

        FileOutputStream fos = new FileOutputStream(destPath);

        workbook.write(fos);

        fos.close();
        rowNo = rowNo + 1;

	}
	
	public void writeOutputExcelFileTCFail() throws IOException{
		FileInputStream inputStream = new FileInputStream(new File(destPath));
        Workbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet datatypeSheet = (HSSFSheet) workbook.getSheet("Sheet1");
        
        Row currRow = datatypeSheet.createRow(rowNo);

        Cell cell = currRow.createCell(0);

        cell.setCellType(CellType.STRING);

        cell.setCellValue(Integer.toString(rowNo));
        
        cell = currRow.createCell(1);

        cell.setCellType(CellType.STRING);

        cell.setCellValue(Serenity.sessionVariableCalled("Env").toString());
        
        cell = currRow.createCell(3);

        cell.setCellType(CellType.STRING);

        cell.setCellValue(Serenity.sessionVariableCalled("Meta").toString());
        
        
        try{
        	cell = currRow.createCell(5);
        	
	        cell.setCellType(CellType.STRING);
	        cell.setCellValue(Serenity.sessionVariableCalled("AccountNo").toString());
	        
	        
        }catch (Exception e){}
        try{
        	cell = currRow.createCell(6);
        	
	        cell.setCellType(CellType.STRING);
	        cell.setCellValue(Serenity.sessionVariableCalled("OrderNo").toString());
	        
	        
        }catch (Exception e){}
        try{
        	cell = currRow.createCell(7);
	    	
	        cell.setCellType(CellType.STRING);
	        cell.setCellValue(Serenity.sessionVariableCalled("MSISDN").toString());
	        
    	}catch (Exception e){}
        
        cell = currRow.createCell(9);
    	
        cell.setCellType(CellType.STRING);
        
        cell.setCellValue("Fail");

        FileOutputStream fos = new FileOutputStream(destPath);

        workbook.write(fos);

        fos.close();
        rowNo = rowNo + 1;

	}
	
public Map<String, Map<Integer, String>> readMSISDNnICCICD (String filePath, String dataSheet){
		
		//DataType is "MSISDN" or "ICCID" depending on whether we want to fetch MSISDN or ICCID from excel
        //Map <String, String> tableMap = new HashMap<String, String>();
        
        try {
              String currentDir = System.getProperty("user.dir");
              filePath = currentDir.concat(filePath);
              FileInputStream inputStream = new FileInputStream(new File(filePath));

              Workbook workbook = new HSSFWorkbook(inputStream);

              //FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
              //HSSFWorkbook workbook = new HSSFWorkbook()p
              HSSFSheet datatypeSheet = (HSSFSheet) workbook.getSheet(dataSheet);
              Iterator<Row> iterator = datatypeSheet.iterator();
              //String row = "PostpaidConsumerdd";

              Row firstRow = iterator.next();
              
              //List<Integer> totalRows = new ArrayList<Integer>();
              int rowNo = -1;
              String flag = "";
              while (iterator.hasNext()) {

                     Row currentRow = iterator.next();
                     //CellStyle currRow = currentRow.getCell(0).
                     String currRow = currentRow.getCell(3).getStringCellValue();

                     if (currRow.equalsIgnoreCase("Y")){
                            rowNo = currentRow.getRowNum();
                            flag = "found";
                            break;
                     }

              }
              if (!flag.equals("found")){
                     report.Info("No available MSISDN/ICCID");
                     Assert.assertTrue(false);                
              }
              Row currRow = datatypeSheet.getRow(rowNo);
              String sMSISDN = currRow.getCell(1).getStringCellValue();
              String sICCID = currRow.getCell(2).getStringCellValue();
              Serenity.setSessionVariable("MSISDN").to(sMSISDN);
              Serenity.setSessionVariable("ICCID").to(sICCID);
              //Cell cell = currRow.get
              Cell cell = currRow.getCell(3);
              cell.setCellType(CellType.STRING);
              cell.setCellValue("N");
              FileOutputStream fos = new FileOutputStream(filePath);
              workbook.write(fos);
              fos.close();
        }
        catch(Exception e) {
              System.out.println(e.getMessage());
        }
        return null;
        
 }

public Map<String, Map<Integer, String>> MakeAddressReserved (String filePath, String dataSheet){
	//Map <String, String> tableMap = new HashMap<String, String>();
	
	try {
		String currentDir = System.getProperty("user.dir");
		filePath = currentDir.concat(filePath);
		FileInputStream inputStream = new FileInputStream(new File(filePath));

		Workbook workbook = new HSSFWorkbook(inputStream);

		//FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
		//HSSFWorkbook workbook = new HSSFWorkbook()p
		HSSFSheet datatypeSheet = (HSSFSheet) workbook.getSheet(dataSheet);
		Iterator<Row> iterator = datatypeSheet.iterator();
		//String row = "PostpaidConsumerdd";
		

		Row firstRow = iterator.next();
		
		//List<Integer> totalRows = new ArrayList<Integer>();
		int rowNo = -1;
		String flag = "";
		while (iterator.hasNext()) {

			Row currentRow = iterator.next();
			//CellStyle currRow = currentRow.getCell(0).
			String currRow = currentRow.getCell(10).getStringCellValue();


			if (currRow.equalsIgnoreCase("Available")){
				rowNo = currentRow.getRowNum();
				flag = "found";
				break;
			}
			
			
		}
		if (!flag.equals("found")){
			report.Info("No address Available");
			Assert.assertTrue(false);        	 
		}
		Row currRow = datatypeSheet.getRow(rowNo);
		String sActualAddress = currRow.getCell(2).getStringCellValue();
		//String sICCID = currRow.getCell(2).getStringCellValue();
		Serenity.setSessionVariable("ActualAddress").to(sActualAddress);
		Cell cell = currRow.getCell(10);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("Available");
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		fos.close();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return null;

}

}
