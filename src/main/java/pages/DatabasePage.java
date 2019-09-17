/*package pages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.regex.Pattern;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.ReportMessege;

public class DatabasePage extends PageObject{
	@Steps
	ReportMessege report;
	@Steps
    private ReadWorkbook readWorkbook;
	
	String driverName = "oracle.jdbc.driver.OracleDriver";
	public String ConnectionDetails(String sEnv){
		
		
		String strConn = null;
		if (sEnv.equals("SUP02")){
			
			strConn = "jdbc:oracle:thin:@10.78.195.74:1522:DEVCRM" + "," + "siebel" + "," + "siebel";
		}
		return strConn;

		
	}
	
	@Step
	public void RetrieveMSISDNAndICCID () throws ClassNotFoundException, SQLException, IOException {
		Serenity.setSessionVariable("MSISDN").to("447356666641");
		//report.Info("MSISDN retried is:  447000002600");
		//System.out.println("Query2 is:  "+sQuery);   
       
			
	}
	
	@Step
	public void ExecuteDBQuery (String accountType) throws ClassNotFoundException, SQLException, IOException {
		
		//String sAccountNo = Serenity.sessionVariableCalled("AccountNo").toString();
		
		//Serenity.sessionVariableCalled("AccountNo").toString()
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//String strConn = this.ConnectionDetails("SUP02");		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.78.195.74:1522:DEVCRM","SIEBEL","SIEBEL");
		Statement stmt=con.createStatement();
		String filePath = "\\src\\test\\resources\\data\\Database.xls";
        String dataSheet = "ExecuteDBQuery";
        
        Map <String,Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
        readWorkbook.testData(tableMap);
        
        for (int i = 0;i < tableMap.get("DD").size();i++) {
        	String sDD = tableMap.get("DD").get(i);
            String sResult = tableMap.get("Result").get(i);
            String sKeys = tableMap.get("Keys").get(i);
            String[] sKeysArr = sKeys.split(Pattern.quote(";"));
            String sDB = tableMap.get("DB").get(i);
            String sAction = tableMap.get("Action").get(i);
            
            
            String filePath1 = "\\src\\test\\resources\\data\\Database.xls";
            String dataSheet1 = "Queries";
            
            Map <String,Map<Integer, String>> tableMap1 = readWorkbook.readRow(accountType, filePath1, dataSheet1);
            readWorkbook.testData(tableMap1);
            String sQuery = tableMap1.get("Query").get(0);
           // report.Info("Query2 is:  "+sQuery);
    		System.out.println("Query2 is:  "+sQuery);
            for (int j =0;j < sKeysArr.length; j++){
            	try{
            		int k = j+1;
            		String keyVal = Serenity.sessionVariableCalled(sKeysArr[j]).toString();
            		sQuery = sQuery.replace("Key" + k , keyVal);
            	//	report.Info("Query3 is:  "+sQuery);
            		System.out.println("Query3 is:  "+sQuery);
            	}
            	catch(NullPointerException e){
            	//	report.Info("Query4 NullPointerException:  "+sQuery);
            		System.out.println("Query4 NullPointerException:  "+sQuery);
            		
            	}
            }
            
           // report.Info(sQuery);
            System.out.println("Query5:  "+sQuery);
            ResultSet rs=stmt.executeQuery(sQuery); 
           
        	
        }
			
	}
}*/

package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.ReadWorkbook;
import utilities.ReportMessege;
import utilities.SikuliUtility;

public class DatabasePage extends PageObject {
	@Steps
	ReportMessege report;
	@Steps
	private ReadWorkbook readWorkbook;
	
	@Steps
	private SikuliUtility SikuliUtility;

	String driverName = "oracle.jdbc.driver.OracleDriver";

	public Connection ConnectionDetails(String sEnv) throws SQLException {

		String Env = Serenity.sessionVariableCalled("Env").toString();
		String sEnv1 = Env + sEnv;
		String strConn = null;
		Connection con = null;
		if (sEnv1.equals("E7")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.195.74:1522:DEVCRM", "SIEBEL", "SIEBEL");
		}
		if (sEnv1.equals("E4")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.193.202:1522:DEVCRM", "SIEBEL", "SIEBEL");
		}
		if (sEnv1.equals("C2")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.221.7:1522:DEVCRM", "SIEBEL", "SIEBEL");
		}
		if (sEnv1.equals("SUP02")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.196.94:1522:DEVCRM", "SIEBEL", "SIEBEL");
		}
		if (sEnv1.equals("C2BRM")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@NewVoC2-dbbrm01:1521:DEVBRM", "pin", "pin");
		}
		if (sEnv1.equals("E7BRM")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@NewVoE7-dbbrm01:1521:DEVBRM", "pin", "pin");
		}
		if (sEnv1.equals("E4BRM")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@NewVoE4-dbbrm01:1521:DEVBRM", "pin", "pin");
		}
		if (sEnv1.equals("SUP02BRM")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@NewVoSUP02-dbbrm01:1521:DEVBRM", "pin", "pin");
		}
		if (sEnv1.equals("E8")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.194.202:1522:DEVCRM", "SIEBEL", "SIEBEL");
		}

		if (sEnv1.equals("E10")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@100.66.64.101:1522:DEVCRM", "SIEBEL", "SIEBEL");
		}

		if (sEnv1.equals("E7OSM")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.195.93:1522:DEVOSM", "ordermgmt_e7",
					"password1");
		}

		if (sEnv1.equals("E7MZ")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.195.84:1521:MZAWS", "mzlookup", "mzlookup");
		}

		if (sEnv1.equals("E4MZ")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.193.203:1521:MZAWS", "mzlookup", "mzlookup");
		}
		if (sEnv1.equals("SUP02BRM")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@NewVoSUP02-dbbrm01:1521:DEVBRM", "pin", "pin");
		}

		if (sEnv1.equals("SUP02OSM")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@NewVoSUP02-dbosm212:1522:DEVOSM", "VFNEWCO_OSM", "ordermgmt");
		}
		

		if (sEnv1.equals("SUP02MZ")) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.221.25:1521:MZAWS", "mzlookup", "mzlookup");
		}

		return con;

	}

	@Step
	public void CheckOSMShippingTask() throws ClassNotFoundException, SQLException, IOException, InterruptedException {

		String OrderNumber = Serenity.sessionVariableCalled("OrderNo").toString();
		String Count = "";
		int i = 0;
		do {
			this.ExecuteBRMDBQuery("CheckShippingTask");
			Count = Serenity.sessionVariableCalled("COUNT0").toString();
			Thread.sleep(30000);
			if (Count.equals("1")) {
				report.Info("Task for " + OrderNumber + " is : CompleteShippingFunctionSI Response Task");
				break;
			}
		} while (!Count.equals("1") && i <= 50);
		Assert.assertTrue(
				"Task for " + OrderNumber
						+ " is not CompleteShippingFunctionSI. Can not proceed to Dispatch. Please check OSM",
				Count.equals("1"));
	}

	@Step
	public void UpdateVSMMultiple_fn() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = this.ConnectionDetails("");
		Statement stmt = con.createStatement();
		Statement stmt1 = con.createStatement();

		ResultSet rs = null;
		String OrderRowId = Serenity.sessionVariableCalled("RowId").toString();

		String sQuery = "select i.row_id from s_order_item i, s_prod_int p where order_id='" + OrderRowId
				+ "' and p.row_id=i.prod_id and p.name='Vodafone Spend Manager'";

		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue("VSM not available.", false);

			} else {
				// display results
				// int i=1;
				do {
					String vRootProductRowId = rs.getString(1);
					// this.TryReserveAvailableICCID();
					// String ICCID = Serenity.sessionVariableCalled("ICCID").toString();
					String sQueryICCID = "update S_ORDER_ITEM_X set X_VF_VBC_SETTING = 'off' where row_id = '"
							+ vRootProductRowId + "'";

					ResultSet rs1 = null;
					rs1 = stmt1.executeQuery(sQueryICCID);

					if (!rs1.next()) {
						if (rs1 != null) {
							try {
								rs1.close();
							} catch (SQLException e) {
								/* ignored */}
						}
						if (stmt1 != null) {
							try {
								stmt1.close();
							} catch (SQLException e) {
								/* ignored */}
						}
						Assert.assertTrue("No VSM available", false);
					} else {
						// i= i+1;
						report.Info("VSM off for " + vRootProductRowId);
					}
				} while (rs.next());
			}

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

	}

	@Step
	public void ExecuteDBQuery(String accountType) throws ClassNotFoundException, SQLException, IOException {

		Connection con = null;
		String filePath = "\\src\\test\\resources\\data\\Database.xls";
		String dataSheet = "ExecuteDBQuery";

		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0; i < tableMap.get("DD").size(); i++) {
			String sDD = tableMap.get("DD").get(i);
			String sResult = tableMap.get("Result").get(i);
			String sKeys = tableMap.get("Keys").get(i);
			String[] sKeysArr = sKeys.split(Pattern.quote(";"));
			String sDB = tableMap.get("DB").get(i);
			String sAction = tableMap.get("Action").get(i);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = this.ConnectionDetails(sDB);
			// String strConn = this.ConnectionDetails("SUP02");
			// if (sDB.equals("") || sDB.equalsIgnoreCase("Siebel"))
			// con=DriverManager.getConnection("jdbc:oracle:thin:@10.78.195.74:1522:DEVCRM","SIEBEL","SIEBEL");
			//// else
			// con=DriverManager.getConnection("jdbc:oracle:thin:@NewVoE7-dbbrm01:1521:DEVBRM","pin","pin");
			// con=DriverManager.getConnection(strConn);
			Statement stmt = con.createStatement();

			ResultSet rs = null;

			String filePath1 = "\\src\\test\\resources\\data\\Database.xls";
			String dataSheet1 = "Queries";

			Map<String, Map<Integer, String>> tableMap1 = readWorkbook.readRow(accountType, filePath1, dataSheet1);
			readWorkbook.testData(tableMap1);
			String sQuery = tableMap1.get("Query").get(0);
			report.Info("Query is:  " + sQuery);
			for (int j = 0; j < sKeysArr.length; j++) {
				try {
					int k = j + 1;
					String keyVal = Serenity.sessionVariableCalled(sKeysArr[j]).toString();
					sQuery = sQuery.replace("Key" + k, keyVal);
					// report.Info("Query3 is: "+sQuery);
					report.Info("Query3 is:  " + sQuery);
				} catch (NullPointerException e) {
					report.Info("NullPointerException:  " + sQuery);

				}
			}

			try {
				rs = stmt.executeQuery(sQuery);
			} catch (SQLException ex) {
				report.Info("Failed while executing query");
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
			}

		}

	}

	public void TryReserveAvailableICCID() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// String strConn = this.ConnectionDetails("SUP02");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@qtp.cqrpvr4944ct.eu-west-1.rds.amazonaws.com:1521:QTP", "datamanagement",
				"D2tamanagement");
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		String sICCID = "";
		String Env = Serenity.sessionVariableCalled("Env").toString();
		String sQuery = "select ICCID from ICCID_Repository where status = 'Available' and Environment = '" + Env
				+ "' and rownum =1";
		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				Assert.assertTrue("No ICC ID available.", false);
			} else {
				// display results
				do {
					sICCID = rs.getString(1);
					Serenity.setSessionVariable("ICCID").to(sICCID);
					report.Info("ICCID :" + sICCID);
				} while (rs.next());
			}
			sQuery = "update ICCID_Repository set status = 'Reserved' where ICCID = '" + sICCID + "'";
			stmt.executeQuery(sQuery);
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

	}

	@Step
	public void TryReserveAvailableMSISDN() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// String strConn = this.ConnectionDetails("SUP02");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@qtp.cqrpvr4944ct.eu-west-1.rds.amazonaws.com:1521:QTP", "datamanagement",
				"D2tamanagement");
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		String sMSISDN = "";
		String Env = Serenity.sessionVariableCalled("Env").toString();
		String sQuery = "select MSISDN from MSISDN_Repository where status = 'Available' and Environment = '" + Env
				+ "' and rownum =1";
		try {
			rs = stmt.executeQuery(sQuery);
			if (!rs.next()) {
				Assert.assertTrue("No MSISDNS available", false);
			} else {
				// display results
				do {
					sMSISDN = rs.getString(1);
					Serenity.setSessionVariable("MSISDN").to(sMSISDN);
					report.Info("MSISDN :" + sMSISDN);

				} while (rs.next());
			}

			sQuery = "update MSISDN_Repository set status = 'Reserved' where MSISDN = '" + sMSISDN + "'";
			stmt.executeQuery(sQuery);
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
	}

	@Step
	public void RetrievePromotionDetails(String productKey) throws IOException, ClassNotFoundException, SQLException {
		String filePath = "\\src\\test\\resources\\data\\DataProxy.xls";
		String dataSheet = "RetrievePromotionDetails";

		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(productKey, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@qtp.cqrpvr4944ct.eu-west-1.rds.amazonaws.com:1521:QTP", "datamanagement",
				"D2tamanagement");
		Statement stmt = con.createStatement();
		ResultSet rs = null;

		String Env = Serenity.sessionVariableCalled("Env").toString();

		for (int i = 0; i < tableMap.get("Promotion").size(); i++) {
			String sPromotion = tableMap.get("Promotion").get(i);
			Serenity.setSessionVariable("PromotionDD").to(sPromotion);
			String sQuery = "SELECT PART_NUMBER FROM PRODUCT_DATA WHERE ENVIRONMENT='" + Env + "' AND KEY='"
					+ sPromotion + "'";
			String partNo = "";
			try {
				rs = stmt.executeQuery(sQuery);

				if (!rs.next()) {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							/* ignored */}
					}
					if (stmt != null) {
						try {
							stmt.close();
						} catch (SQLException e) {
							/* ignored */}
					}
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {
							/* ignored */}
					}
					Assert.assertTrue("Part number not found in Automation DB", false);
				} else {
					// display results
					do {
						partNo = rs.getString(1);
						Serenity.setSessionVariable("PartNo").to(partNo);
						report.Info("PartNo: " + partNo);

					} while (rs.next());
				}

			} catch (SQLException ex) {
				System.out.print(ex.getMessage());
				report.Info(ex.getMessage());
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
			}
			con = this.ConnectionDetails("");// to be left blank
			// String strConn = this.ConnectionDetails("");//to be left blank
			// con=DriverManager.getConnection(strConn);
			// con=DriverManager.getConnection("jdbc:oracle:thin:@10.78.193.202:1522:DEVCRM","SIEBEL","SIEBEL");
			stmt = con.createStatement();
			sQuery = "SELECT NAME FROM S_PROD_INT WHERE PART_NUM='" + partNo + "'";

			try {
				rs = stmt.executeQuery(sQuery);

				if (!rs.next()) {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							/* ignored */}
					}
					if (stmt != null) {
						try {
							stmt.close();
						} catch (SQLException e) {
							/* ignored */}
					}
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {
							/* ignored */}
					}
					Assert.assertTrue("Part Number not found in Siebel DB", false);

				} else {
					// display results
					do {
						String promotionName = rs.getString(1);
						Serenity.setSessionVariable("ProductName").to(promotionName);
						report.Info("ProductName: " + promotionName);

					} while (rs.next());
				}

			} catch (SQLException ex) {
				System.out.print(ex.getMessage());
				report.Info(ex.getMessage());
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}

			}

			sQuery = "select spi2.name from s_prom_item spm, s_prod_int spi, s_prod_int spi2 where spm.promotion_id = spi.row_id and "
					+ "spm.prod_id = spi2.row_id "
					+ "and spi2.name in ('Mobile phone service','Mobile broadband service','EBU Sharer','PAYM','CBU Sharer','VOXI Service','Fixed Service','One Net Fixed Data Service','Digital Voice Assistant Service','Vodafone Cloud Services Marketplace') "
					+
					// "and spi2.name in ('Mobile phone service','Mobile broadband service','Fixed
					// Service','One Net Fixed Data Service','Fixed Line Service','Fixed Broadband
					// Service','EBU Sharer','PAYM') " +
					// "and spi2.name in ('Mobile phone service','Mobile broadband service','Fixed
					// Service','One Net Fixed Data Service') " +
					"and spm.dflt_qty = '1' " + "and spi.part_num = '" + partNo + "'";

			try {
				rs = stmt.executeQuery(sQuery);

				// display results
				while (rs.next()) {
					String rootProduct = rs.getString(1);
					Serenity.setSessionVariable("RootProduct0").to(rootProduct);
					report.Info("RootProduct: " + rootProduct);

				}

			} catch (SQLException ex) {
				System.out.print(ex.getMessage());
				report.Info(ex.getMessage());
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
			}

		}

	}

	@Step
	public void RetrieveAccountOLD(String logicalName) throws IOException, ClassNotFoundException, SQLException {
		String filePath = "\\src\\test\\resources\\data\\DataProxy.xls";
		String dataSheet = "RetrieveAccount";

		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(logicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		String sDataDefinition = tableMap.get("DataDefinition").get(0);
		String sRootProduct = tableMap.get("RootProduct").get(0);

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@qtp.cqrpvr4944ct.eu-west-1.rds.amazonaws.com:1521:QTP", "datamanagement",
				"D2tamanagement");
		Statement stmt = con.createStatement();
		String Env = Serenity.sessionVariableCalled("Env").toString();

		ResultSet rs = null;

		String sQuery = "SELECT QUERY_SQL, QUERY_TYPE, PROMOTION_KEY FROM MINING_QUERY WHERE ENVIRONMENT='" + Env
				+ "'  AND QUERY_NAME='" + sDataDefinition + "'";
		String vQuerySQL = null;
		String vQueryType = null;
		String vPromotionKey = null;
		String accountNo = null;
		String accntMsisdn = null;
		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue("No Results returned in mining query table for " + sDataDefinition, false);
			} else {
				// display results
				do {
					vQuerySQL = rs.getString(1);
					vQueryType = rs.getString(2);
					vPromotionKey = rs.getString(3);
					// Serenity.setSessionVariable("PartNo").to(partNo);
					// report.Info("PartNo: " + partNo);

				} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
		if (vPromotionKey != null) {
			this.RetrievePromotionDetails(vPromotionKey);
			try {

				String keyVal = Serenity.sessionVariableCalled("RootProduct0").toString();
				vQuerySQL = vQuerySQL.replace("RootProduct", keyVal);

			} catch (NullPointerException e) {
			}

			vQuerySQL = vQuerySQL + " and exists (select 1 from s_asset sa, s_prod_int spi where spi.name = '"
					+ Serenity.sessionVariableCalled("ProductName").toString()
					+ "' and spi.row_id = sa.prod_id and sa.owner_accnt_id = soe.row_id and sa.status_cd = 'Active' and sip.row_id = sa.bill_profile_id) ";
		}
		vQuerySQL = vQuerySQL
				+ " AND ( ( soe.url NOT LIKE '#B')OR ( soe.url NOT LIKE '#D') OR ( soe.url IS NULL ) OR ( soe.url = 'Corrupt'))";
		vQuerySQL = vQuerySQL.replace("SELECT soe.row_id", "SELECT soe.x_vf_customer_code CUSTOMER_CODE");
		vQuerySQL = vQuerySQL.replace("and sip.CC_NUMBER is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.BANK_AUTHOR_FLG = 'N'", "");
		vQuerySQL = vQuerySQL.replace("and sip.CRDT_CRD_EXPT_DT is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.CRDT_CRD_EXP_MO_CD is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.CRDT_CRD_EXP_YR_CD is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.X_CC_ADDR is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.X_CC_POSTCODE is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.CCV_NUMBER is null", "");
		vQuerySQL = vQuerySQL.replace("and soex.X_VF_CREDIT_CLASS is null", "");
		vQuerySQL = vQuerySQL.replace("and soex.X_VET_REF_NO is null", "");
		vQuerySQL = vQuerySQL.replace("and soex.X_VF_OUTCOME_X is null", "");
		vQuerySQL = vQuerySQL.replace("and soex.X_VF_VET_RES_EXP_DATE is null", "");
		vQuerySQL = vQuerySQL.replace("and sc.email_addr like '%@sqcmail.uk'", "");
		vQuerySQL = vQuerySQL + " and rownum = 1 order by soe.created desc ";
		vQuerySQL = vQuerySQL
				+ " and sa2.created > sysdate-150 and soe.created < sysdate-60 and rownum = 1 order by soe.created desc ";
		con = this.ConnectionDetails("");// to be left blank

		// con=DriverManager.getConnection(strConn);
		stmt = con.createStatement();

		try {
			rs = stmt.executeQuery(vQuerySQL);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue("There are no clean source entities for this scenario.", false);

			} else {
				// display results
				do {
					accountNo = rs.getString(1);
					Serenity.setSessionVariable("AccountNo").to(accountNo);
					report.Info("AccountNo: " + accountNo);

				} while (rs.next());
			}

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}

		}

		sQuery = "select distinct z.service_num from s_org_ext soe , s_order o, s_order_item z where o.customer_id = soe.row_id and o.row_id = z.order_id and soe.x_vf_customer_code in ('"
				+ Serenity.sessionVariableCalled("AccountNo").toString() + "') and z.service_num like '4%'";

		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue(
						"MSISDN not found for account number " + Serenity.sessionVariableCalled("AccountNo").toString(),
						false);

			} else {
				// display results
				do {
					accntMsisdn = rs.getString(1);
					Serenity.setSessionVariable("ACCNTMSISDN").to(accntMsisdn);
					report.Info("ACCNTMSISDN: " + accntMsisdn);

				} while (rs.next());
			}

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}

		}
		vQuerySQL = "update s_org_ext soe set soe.url='#B' where soe.x_vf_customer_code ='"
				+ Serenity.sessionVariableCalled("AccountNo").toString() + "'";
		try {
			rs = stmt.executeQuery(vQuerySQL);

		} catch (SQLException ex) {

			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

	}

	@Step
	public void RetrieveAccount(String logicalName) throws IOException, ClassNotFoundException, SQLException {
		String filePath = "\\src\\test\\resources\\data\\DataProxy.xls";
		String dataSheet = "RetrieveAccount";

		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(logicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		String sDataDefinition = tableMap.get("DataDefinition").get(0);
		String sRootProduct = tableMap.get("RootProduct").get(0);

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@qtp.cqrpvr4944ct.eu-west-1.rds.amazonaws.com:1521:QTP", "datamanagement",
				"D2tamanagement");
		Statement stmt = con.createStatement();
		String Env = Serenity.sessionVariableCalled("Env").toString();

		ResultSet rs = null;

		String sQuery = "SELECT QUERY_SQL, QUERY_TYPE, PROMOTION_KEY FROM MINING_QUERY WHERE ENVIRONMENT='" + Env
				+ "'  AND QUERY_NAME='" + sDataDefinition + "'";
		String vQuerySQL = null;
		String vQueryType = null;
		String vPromotionKey = null;
		String accountNo = null;
		String accntMsisdn = null;
		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue("No Results returned in mining query table for " + sDataDefinition, false);
			} else {
				// display results
				do {
					vQuerySQL = rs.getString(1);
					vQueryType = rs.getString(2);
					vPromotionKey = rs.getString(3);
					// Serenity.setSessionVariable("PartNo").to(partNo);
					// report.Info("PartNo: " + partNo);

				} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
		if (vPromotionKey != null) {
			this.RetrievePromotionDetails(vPromotionKey);
			try {

				String keyVal = Serenity.sessionVariableCalled("RootProduct0").toString();
				vQuerySQL = vQuerySQL.replace("RootProduct", keyVal);

			} catch (NullPointerException e) {
			}

			vQuerySQL = vQuerySQL + " and exists (select 1 from s_asset sa, s_prod_int spi where spi.name = '"
					+ Serenity.sessionVariableCalled("ProductName").toString()
					+ "' and spi.row_id = sa.prod_id and sa.owner_accnt_id = soe.row_id and sa.status_cd = 'Active' and sip.row_id = sa.bill_profile_id) ";
		}
		vQuerySQL = vQuerySQL
				+ " AND ( ( soe.url NOT LIKE '#B')OR ( soe.url NOT LIKE '#D') OR ( soe.url IS NULL ) OR ( soe.url = 'Corrupt'))";
		vQuerySQL = vQuerySQL.replace("SELECT soe.row_id", "SELECT soe.x_vf_customer_code CUSTOMER_CODE");
		vQuerySQL = vQuerySQL.replace("and sip.CC_NUMBER is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.BANK_AUTHOR_FLG = 'N'", "");
		vQuerySQL = vQuerySQL.replace("and sip.CRDT_CRD_EXPT_DT is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.CRDT_CRD_EXP_MO_CD is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.CRDT_CRD_EXP_YR_CD is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.X_CC_ADDR is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.X_CC_POSTCODE is null", "");
		vQuerySQL = vQuerySQL.replace("and sip.CCV_NUMBER is null", "");
		vQuerySQL = vQuerySQL.replace("and soex.X_VF_CREDIT_CLASS is null", "");
		vQuerySQL = vQuerySQL.replace("and soex.X_VET_REF_NO is null", "");
		vQuerySQL = vQuerySQL.replace("and soex.X_VF_OUTCOME_X is null", "");
		vQuerySQL = vQuerySQL.replace("and soex.X_VF_VET_RES_EXP_DATE is null", "");
		vQuerySQL = vQuerySQL.replace("and sc.email_addr like '%@sqcmail.uk'", "");
		vQuerySQL = vQuerySQL + " and rownum = 1 order by soe.created desc ";

		con = this.ConnectionDetails("");// to be left blank

		// con=DriverManager.getConnection(strConn);
		stmt = con.createStatement();

		try {
			rs = stmt.executeQuery(vQuerySQL);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue("There are no clean source entities for this scenario.", false);

			} else {
				// display results
				do {
					accountNo = rs.getString(1);
					Serenity.setSessionVariable("AccountNo").to(accountNo);
					report.Info("AccountNo: " + accountNo);

				} while (rs.next());
			}

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}

		}

		sQuery = "select distinct z.service_num from s_org_ext soe , s_order o, s_order_item z where o.customer_id = soe.row_id and o.row_id = z.order_id and soe.x_vf_customer_code in ('"
				+ Serenity.sessionVariableCalled("AccountNo").toString() + "') and z.service_num like '4%'";

		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue(
						"MSISDN not found for account number " + Serenity.sessionVariableCalled("AccountNo").toString(),
						false);

			} else {
				// display results
				do {
					accntMsisdn = rs.getString(1);
					Serenity.setSessionVariable("ACCNTMSISDN").to(accntMsisdn);
					report.Info("ACCNTMSISDN: " + accntMsisdn);

				} while (rs.next());
			}

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}

		}
		vQuerySQL = "update s_org_ext soe set soe.url='#B' where soe.x_vf_customer_code ='"
				+ Serenity.sessionVariableCalled("AccountNo").toString() + "'";
		try {
			rs = stmt.executeQuery(vQuerySQL);

		} catch (SQLException ex) {

			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

	}

	// ---------
	@Step
	public void GetAddress(String logicalName) throws IOException, ClassNotFoundException, SQLException {
		String filePath = "\\src\\test\\resources\\data\\DataProxy.xls";
		String dataSheet = "Address";
		String sQuery = "";

		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(logicalName, filePath, dataSheet);
		readWorkbook.testData(tableMap);
		String sType = tableMap.get("Type").get(0);
		String sCustomerType = tableMap.get("CustomerType").get(0);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@qtp.cqrpvr4944ct.eu-west-1.rds.amazonaws.com:1521:QTP", "datamanagement",
				"D2tamanagement");
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		String sFULLADDRESS = "";
		// -=======
		if (!sCustomerType.equals("")) {
			sQuery += " and CUSTOMERTYPE = '" + sCustomerType + "'";
			Serenity.setSessionVariable("CustomerType").to(sCustomerType);
		}
		if (sType.equals("SPAREPAIR")) {
			sQuery = "Select FullAddress,id from Address where type like 'Spare Pair' and status = 'Available'  and CUSTOMERTYPE = '"
					+ sCustomerType + "' and rownum = 1";
			Serenity.setSessionVariable("InstallationType").to("New Line");
			Serenity.setSessionVariable("ExpectedLineInfo").to("Spare Pair");
		} else {
			if (sType.equals("BTWLTNUMRET")) {
				sQuery = "Select FullAddress, LANDLINE_NMBR, id  from Address where type like 'Working PSTN Line' and status = 'Available' and rownum = 1";
			} else if (sType.equals("BTWLTNONUMRET")) {
				sQuery = "Select FullAddress, id  from Address where type like 'Working PSTN Line' and status = 'Available' and rownum = 1";
			} else if (sType.equals("MPFWLTNUMRET")) {
				sQuery = "Select FullAddress, LANDLINE_NMBR, id  from Address where type like 'MPF Working Line' and status = 'Available' and rownum = 1";
			} else if (sType.equals("MPFWLTNONUMRET")) {
				sQuery = "Select FullAddress, id from Address where type like 'MPF Working Line' and status = 'Available' and rownum = 1";
			} else if (sType.equals("BTRESTARTSTOPPED")) {
				sQuery = "Select FullAddress, id from Address where type like 'PSTN Stopped Line' and status = 'Available' and rownum = 1";
			} else if (sType.equals("MPFRESTARTSTOPPED")) {
				sQuery = "Select FullAddress, id from Address where type like 'MPF Stopped Line' and status = 'Available' and rownum = 1";
			} else if (sType.equals("BTRESTARTSTOPPED") || sType.equals("BTWLTNUMRET") || sType.equals("BTWLTNUMRET")) {
				sQuery = "Select FullAddress, id from Address where type like 'Working PSTN Line PSTN Stopped Line' and status = 'Available' and rownum = 1";
			} else if (sType.equals("NOLINEPLANT")) {
				sQuery = "Select FullAddress, id from Address where type like 'No Spare pair' and status = 'Available' and rownum = 1";
			}

			else if (sType.equals("THROTTLEDFIBRE")) {
				sQuery = "Select FullAddress, id from Address where type like 'Spare pair - Only Fibre' and status = 'Available' and rownum = 1";
			}

			else if (sType.equals("PSTNWLNUMRET")) {

				sQuery = "Select FullAddress, LANDLINE_NMBR, id  from Address where type like 'PSTN Working Line Takeover' and status = 'Available' and rownum = 1";
			} else if (sType.equals("BTRESTARTSTOPPEDEBU")) {
				sQuery = "Select FullAddress, LANDLINE_NMBR, id from Address where type like 'PSTN Stopped Line' and status = 'Available' and rownum = 1";
			} else if (sType.equals("PreOrderStandardFTTH")) {
				sQuery = "Select FullAddress, id from Address where type like 'PreOrderStandardFTTH' and status = 'Available' and rownum = 1";
			} else if (sType.equals("PreOrderNonStandardFTTH")) {
				sQuery = "Select FullAddress, id from Address where type like 'PreOrderNonStandardFTTH' and status = 'Available' and rownum = 1";
			} else if (sType.equals("PreOrderExtendedStandardFTTH")) {
				sQuery = "Select FullAddress, id from Address where type like 'PreOrderExtendedStandardFTTH' and status = 'Available' and rownum = 1";
			} else if (sType.equals("BlankNonStandardFTTH")) {
				sQuery = "Select FullAddress, id from Address where type like 'BlankNonStandardFTTH' and status = 'Available' and rownum = 1";
			} else if (sType.equals("BlankExtendedStandardFTTH")) {
				sQuery = "Select FullAddress, id from Address where type like 'BlankExtendedStandardFTTH' and status = 'Available' and rownum = 1";
			}
		}
		String RetentionNumber = "";
		// =======
		// sQuery = "select FULLADDRESS from ADDRESS where STATUS = 'Available' and TYPE
		// =" + sType + "'";
		try {
			rs = stmt.executeQuery(sQuery);
			if (!rs.next()) {
				Assert.assertTrue("No Addresses available", false);
			} else {
				// display results
				do {
					sFULLADDRESS = rs.getString(1);
					String sLandLine = rs.getString(2);
					Serenity.setSessionVariable("ADDRESS").to(sFULLADDRESS);
					report.Info("ADDRESS :" + sFULLADDRESS);
					if (!sQuery.contains("LANDLINE_NMBR")) {
						Serenity.setSessionVariable("RetentionNumber").to("");
						RetentionNumber = Serenity.sessionVariableCalled("RetentionNumber").toString();
					} else if (sQuery.contains("LANDLINE_NMBR")) {

						Serenity.setSessionVariable("RetentionNumber").to(sLandLine);
						RetentionNumber = Serenity.sessionVariableCalled("RetentionNumber").toString();
					}

				} while (rs.next());
			}
			if (!sType.equals("SPAREPAIR")) {

				sQuery = "update ADDRESS set STATUS = 'Reserved' where FULLADDRESS = '" + sFULLADDRESS + "'";
				stmt.executeQuery(sQuery);
			}
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
	}

	@Step
	public void TryReserveRouter() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String Env = Serenity.sessionVariableCalled("Env").toString();
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@qtp.cqrpvr4944ct.eu-west-1.rds.amazonaws.com:1521:QTP", "datamanagement",
				"D2tamanagement");
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		String sROUTER = "";
		String sQuery = "select ROUTER from ROUTER_REPOSITORY where status = 'Available' and Environment = '" + Env
				+ "' and rownum =1";

		try {
			rs = stmt.executeQuery(sQuery);
			if (!rs.next()) {
				Assert.assertTrue("No ROUTERS available", false);
			} else {
				// display results
				do {
					sROUTER = rs.getString(1);
					Serenity.setSessionVariable("ROUTERNUMBER").to(sROUTER);
					report.Info("ROUTERNUMBER :" + sROUTER);

				} while (rs.next());
			}

			sQuery = "update ROUTER_REPOSITORY set status = 'Reserved' where ROUTER = '" + sROUTER + "'";
			stmt.executeQuery(sQuery);
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
	}

	@Step
	public void ExecuteBRMDBQuery(String accountType)
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		Connection con = null;
		String filePath = "\\src\\test\\resources\\data\\Database.xls";

		String dataSheet = "ExecuteDBQuery";
		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0; i < tableMap.get("DD").size(); i++) {
			String sDD = tableMap.get("DD").get(i);
			String sResult = tableMap.get("Result").get(i);
			String sKeys = tableMap.get("Keys").get(i);
			String[] sKeysArr = sKeys.split(Pattern.quote(";"));
			String sDB = tableMap.get("DB").get(i);
			String sAction = tableMap.get("Action").get(i);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = this.ConnectionDetails(sDB);
			Statement stmt = con.createStatement();
			ResultSet rs = null;

			String filePath1 = "\\src\\test\\resources\\data\\Database.xls";
			String dataSheet1 = "Queries";

			Map<String, Map<Integer, String>> tableMap1 = readWorkbook.readRow(sDD, filePath1, dataSheet1);
			readWorkbook.testData(tableMap1);
			String sQuery = tableMap1.get("Query").get(0);
			// report.Info("Query is: "+sQuery);
			for (int j = 0; j < sKeysArr.length; j++) {
				int k = j + 1;
				try {

					String keyVal = Serenity.sessionVariableCalled(sKeysArr[j]).toString();
					sQuery = sQuery.replace("Key" + k, keyVal);
					// report.Info("Query3 is: "+sQuery);
					// report.Info("Query3 is: "+sQuery);
				} catch (NullPointerException e) {
					sQuery = sQuery.replace("Key" + k, sKeysArr[j]);
					report.Info("NullPointerException:  " + sQuery);

				}
			}
			report.Info("Query is:  " + sQuery);
			try {
				rs = stmt.executeQuery(sQuery);

				int j = 0;
				if (sAction.equals("Capture")) {
					while (rs.next()) {
						int numCols = rs.getMetaData().getColumnCount();
						for (int i1 = 1; i1 <= numCols; i1++) {
							System.out.println(
									"Database reuslt" + rs.getMetaData().getColumnName(i1).concat(Integer.toString(j)));
							report.Info(
									"Database reuslt" + rs.getMetaData().getColumnName(i1).concat(Integer.toString(j))
											+ rs.getString(i1));
							Serenity.setSessionVariable(rs.getMetaData().getColumnName(i1).concat(Integer.toString(j)))
									.to(rs.getString(i1));

						}
						j = j + 1;

					}

					Assert.assertTrue("No rows returned", !(j == 0));

				} else if (sAction.equals("Add")) {
					double sActResult = 0;
					boolean flag1 = false;

					DecimalFormat df = new DecimalFormat("#.######");
					df.setRoundingMode(RoundingMode.HALF_EVEN);
					while (rs.next()) {
						int numCols = rs.getMetaData().getColumnCount();
						for (int i1 = 1; i1 <= numCols; i1++) {

							sActResult = Double.parseDouble(df.format(sActResult))
									+ Double.parseDouble(df.format(Double.parseDouble(rs.getString(i1))));
							sActResult = Double.parseDouble(df.format(sActResult));
						}
						j = j + 1;
						flag1 = true;
					}
					if (flag1 == false) {
						Assert.assertTrue("No rows found", false);
					}

					if (sActResult == Double.parseDouble(sResult)) {
						report.Info("Value is " + sResult + " as expected");
						Assert.assertTrue("Value is " + sResult + " as expected", true);
					} else {
						Assert.assertTrue("Actual value is " + sActResult + " but expected is " + sResult, false);
					}

				} else if (sAction.equals("Compare")) {
					String[] sResultArr = sResult.split(Pattern.quote("+"));
					while (rs.next()) {
						String[] sResultArr2 = sResultArr[j].split(Pattern.quote(";"));
						for ( int i1 = 0 ; i1 < sResultArr2.length ; i1++ ) {
							if (sResultArr2[i1].startsWith("-")){
								sResultArr2[i1] = sResultArr2[i1].replace("-", "");
								try{

									String keyVal = Serenity.sessionVariableCalled(sResultArr2[i1]).toString();
									sResultArr2[i1] = sResultArr2[i1].replace(sResultArr2[i1], keyVal);

								}
								catch(NullPointerException e){}
								sResultArr2[i1] = "-" + sResultArr2[i1];
							}
							// Special case for IMSIvalue replace for ISAAC testing

							if (sResultArr2[i1].contains("IMSI")) {
								sResultArr2[i1] = Serenity.sessionVariableCalled("IMSI").toString();
							}
							
							if (sResultArr2[i1].contains("MONTHLYCOST")) {
								sResultArr2[i1] = Serenity.sessionVariableCalled("MONTHLYCOST").toString();
							}
							try{

								String keyVal = Serenity.sessionVariableCalled(sResultArr2[i1]).toString();
								sResultArr2[i1] = sResultArr2[i1].replace(sResultArr2[i1], keyVal);

							}
							catch(NullPointerException e){}
							if (sResultArr2[i1].equals(rs.getString(i1+1))){
								report.Info("Value is " + sResultArr2[i1] + " as expected");
							}
							else{
								Assert.assertTrue("Actual value is " + rs.getString(i1+1) + " but expected is " + sResultArr2[i1], false);
							}
						}
							j = j + 1;
						
					}

					Assert.assertTrue("No rows returned", !(j == 0));

				}
			} catch (SQLException ex) {
				report.Info("Failed while executing query");
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
			}
		}

	}
	
	
	@Step
	public void ExecuteBRMDBQueryWithHardCodedKeys(String accountType, String hardcodedKeys)
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		Connection con = null;
		String filePath = "\\src\\test\\resources\\data\\Database.xls";

		String dataSheet = "ExecuteDBQuery";
		Map<String, Map<Integer, String>> tableMap = readWorkbook.readRow(accountType, filePath, dataSheet);
		readWorkbook.testData(tableMap);

		for (int i = 0; i < tableMap.get("DD").size(); i++) {
			String sDD = tableMap.get("DD").get(i);
			String sResult = tableMap.get("Result").get(i);
			String sKeys = hardcodedKeys;
			String[] sKeysArr = sKeys.split(Pattern.quote(";"));
			String sDB = tableMap.get("DB").get(i);
			String sAction = tableMap.get("Action").get(i);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = this.ConnectionDetails(sDB);
			Statement stmt = con.createStatement();
			ResultSet rs = null;

			String filePath1 = "\\src\\test\\resources\\data\\Database.xls";
			String dataSheet1 = "Queries";

			Map<String, Map<Integer, String>> tableMap1 = readWorkbook.readRow(sDD, filePath1, dataSheet1);
			readWorkbook.testData(tableMap1);
			String sQuery = tableMap1.get("Query").get(0);
			// report.Info("Query is: "+sQuery);
			for (int j = 0; j < sKeysArr.length; j++) {
				int k = j + 1;
				try {

					String keyVal = Serenity.sessionVariableCalled(sKeysArr[j]).toString();
					sQuery = sQuery.replace("Key" + k, keyVal);
					// report.Info("Query3 is: "+sQuery);
					// report.Info("Query3 is: "+sQuery);
				} catch (NullPointerException e) {
					sQuery = sQuery.replace("Key" + k, sKeysArr[j]);
					report.Info("NullPointerException:  " + sQuery);

				}
			}
			report.Info("Query is:  " + sQuery);
			try {
				rs = stmt.executeQuery(sQuery);

				int j = 0;
				if (sAction.equals("Capture")) {
					while (rs.next()) {
						int numCols = rs.getMetaData().getColumnCount();
						for (int i1 = 1; i1 <= numCols; i1++) {
							System.out.println(
									"Database reuslt" + rs.getMetaData().getColumnName(i1).concat(Integer.toString(j)));
							report.Info(
									"Database reuslt" + rs.getMetaData().getColumnName(i1).concat(Integer.toString(j))
											+ rs.getString(i1));
							Serenity.setSessionVariable(rs.getMetaData().getColumnName(i1).concat(Integer.toString(j)))
									.to(rs.getString(i1));

						}
						j = j + 1;

					}

					Assert.assertTrue("No rows returned", !(j == 0));

				} else if (sAction.equals("Add")) {
					double sActResult = 0;
					boolean flag1 = false;

					DecimalFormat df = new DecimalFormat("#.######");
					df.setRoundingMode(RoundingMode.HALF_EVEN);
					while (rs.next()) {
						int numCols = rs.getMetaData().getColumnCount();
						for (int i1 = 1; i1 <= numCols; i1++) {

							sActResult = Double.parseDouble(df.format(sActResult))
									+ Double.parseDouble(df.format(Double.parseDouble(rs.getString(i1))));
							sActResult = Double.parseDouble(df.format(sActResult));
						}
						j = j + 1;
						flag1 = true;
					}
					if (flag1 == false) {
						Assert.assertTrue("No rows found", false);
					}

					if (sActResult == Double.parseDouble(sResult)) {
						report.Info("Value is " + sResult + " as expected");
						Assert.assertTrue("Value is " + sResult + " as expected", true);
					} else {
						Assert.assertTrue("Actual value is " + sActResult + " but expected is " + sResult, false);
					}

				} else if (sAction.equals("Compare")) {
					String[] sResultArr = sResult.split(Pattern.quote("+"));
					while (rs.next()) {
						String[] sResultArr2 = sResultArr[j].split(Pattern.quote(";"));
						for ( int i1 = 0 ; i1 < sResultArr2.length ; i1++ ) {
							if (sResultArr2[i1].startsWith("-")){
								sResultArr2[i1] = sResultArr2[i1].replace("-", "");
								try{

									String keyVal = Serenity.sessionVariableCalled(sResultArr2[i1]).toString();
									sResultArr2[i1] = sResultArr2[i1].replace(sResultArr2[i1], keyVal);

								}
								catch(NullPointerException e){}
								sResultArr2[i1] = "-" + sResultArr2[i1];
							}
							// Special case for IMSIvalue replace for ISAAC testing

							if (sResultArr2[i1].contains("IMSI")) {
								sResultArr2[i1] = Serenity.sessionVariableCalled("IMSI").toString();
							}
							
							if (sResultArr2[i1].contains("MONTHLYCOST")) {
								sResultArr2[i1] = Serenity.sessionVariableCalled("MONTHLYCOST").toString();
							}
							try{

								String keyVal = Serenity.sessionVariableCalled(sResultArr2[i1]).toString();
								sResultArr2[i1] = sResultArr2[i1].replace(sResultArr2[i1], keyVal);

							}
							catch(NullPointerException e){}
							
							JavascriptExecutor jse = (JavascriptExecutor)getDriver();
							String alertText = "";
							
							if (sResultArr2[i1].equals(rs.getString(i1+1))){

								alertText = "alert('Actual Value is :" + sResultArr[j] + "')";
								jse.executeScript(alertText);
								Thread.sleep(2000);
								try {
									SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
								} catch (AWTException e) {
									e.printStackTrace();
								}
								getDriver().switchTo().alert().accept();
								report.Info("Value is " + sResultArr2[i1] + " as expected");
							}
							else{
								alertText = "alert('Actual Value is :" + rs.getString(i1) + " but expected is " + sResultArr[j] + "')";
								jse.executeScript(alertText);
								try {
									SikuliUtility.SikuliScreenShot(Serenity.sessionVariableCalled("SikulifilePathForSavingFile").toString());
								} catch (AWTException e) {
									e.printStackTrace();
								}
								getDriver().switchTo().alert().accept();
								Assert.assertTrue(
										"Actual value is " + rs.getString(i1) + " but expected is " + sResultArr[j],
										false);
							}
						}
							j = j + 1;
						
					}

					Assert.assertTrue("No rows returned", !(j == 0));

				}
			} catch (SQLException ex) {
				report.Info("Failed while executing query");
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
			}
		}

	}
	

	public void UpdateICCIDMultiple_fn() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = this.ConnectionDetails("");
		Statement stmt = con.createStatement();
		Statement stmt1 = con.createStatement();

		ResultSet rs = null;
		String OrderRowId = Serenity.sessionVariableCalled("RowId").toString();

		String sQuery = "select i.row_id from s_order_item i, s_prod_int p where order_id='" + OrderRowId
				+ "' and p.row_id=i.prod_id and p.name='Blank White Triple Format SIM'";

		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue("No SIM available.", false);

			} else {
				// display results
				// int i=1;
				do {
					String vRootProductRowId = rs.getString(1);
					this.TryReserveAvailableICCID();
					String ICCID = Serenity.sessionVariableCalled("ICCID").toString();
					String sQueryICCID = "update siebel.s_order_item set service_num = '" + ICCID + "' where row_id = '"
							+ vRootProductRowId + "'";

					ResultSet rs1 = null;
					rs1 = stmt1.executeQuery(sQueryICCID);

					if (!rs1.next()) {
						if (rs1 != null) {
							try {
								rs1.close();
							} catch (SQLException e) {
								/* ignored */}
						}
						if (stmt1 != null) {
							try {
								stmt1.close();
							} catch (SQLException e) {
								/* ignored */}
						}
						Assert.assertTrue("No ICCID available", false);
					} else {
						// i= i+1;
						report.Info("ICCID :" + ICCID + "for Row ID : " + vRootProductRowId);
					}
				} while (rs.next());
			}

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

	}

	public void UpdateMSISDNMultiple_fn() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = this.ConnectionDetails("");
		Statement stmt = con.createStatement();
		Statement stmt1 = con.createStatement();

		ResultSet rs = null;
		String RootProduct = Serenity.sessionVariableCalled("RootProduct0").toString();
		String OrderRowId = Serenity.sessionVariableCalled("RowId").toString();

		String sQuery = "select i.row_id from s_order_item i, s_prod_int p where order_id='" + OrderRowId
				+ "' and p.row_id=i.prod_id and p.name='" + RootProduct + "'";

		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue("No Root Product available.", false);

			} else {
				do {
					String vRootProductRowId = rs.getString(1);
					this.TryReserveAvailableMSISDN();
					String MSISDN = Serenity.sessionVariableCalled("MSISDN").toString();
					String sQueryMSISDN = "update siebel.s_order_item set service_num = '" + MSISDN
							+ "' where row_id = '" + vRootProductRowId + "'";

					ResultSet rs1 = null;
					rs1 = stmt1.executeQuery(sQueryMSISDN);

					if (!rs1.next()) {
						if (rs1 != null) {
							try {
								rs1.close();
							} catch (SQLException e) {
								/* ignored */}
						}
						if (stmt1 != null) {
							try {
								stmt1.close();
							} catch (SQLException e) {
								/* ignored */}
						}
						Assert.assertTrue("No MSISDNS available", false);
					} else {
						// i= i+1;
						report.Info("MSISDN :" + MSISDN + "for Row ID : " + vRootProductRowId);
					}

				} while (rs.next());

			}

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

	}

	public void UpdateIMEIMultiple_fn() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = this.ConnectionDetails("");
		Statement stmt = con.createStatement();
		Statement stmt1 = con.createStatement();

		ResultSet rs = null;
		String OrderRowId = Serenity.sessionVariableCalled("RowId").toString();
		String HandsetName = Serenity.sessionVariableCalled("HandsetName").toString();
		// String HandsetName ="BlackBerry Curve 9320 pink";
		String sQuery = "select i.row_id from s_order_item i, s_prod_int p where order_id='" + OrderRowId
				+ "' and p.row_id=i.prod_id and p.name='" + HandsetName + "'";

		try {
			rs = stmt.executeQuery(sQuery);

			if (!rs.next()) {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						/* ignored */}
				}
				Assert.assertTrue("No handset available.", false);

			} else {
				do {
					String vRootProductRowId = rs.getString(1);
					String sIMEI = "update siebel.s_order_item set service_num = '123456789123456' where row_id = '"
							+ vRootProductRowId + "'";

					ResultSet rs1 = null;
					rs1 = stmt1.executeQuery(sIMEI);

					if (!rs1.next()) {
						if (rs1 != null) {
							try {
								rs1.close();
							} catch (SQLException e) {
								/* ignored */}
						}
						if (stmt1 != null) {
							try {
								stmt1.close();
							} catch (SQLException e) {
								/* ignored */}
						}
						Assert.assertTrue("No handset row available", false);
					} else {
						// i= i+1;
						report.Info("IMEI updated for Row ID : " + vRootProductRowId);
					}

				} while (rs.next());

			}

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}

	}

	@Step
	public void RetrieveBBIPNumber() throws IOException, ClassNotFoundException, SQLException {

		String BBIP = "BBIP";

		long RandomNUM = 0;
		RandomNUM = (long) (Math.random() * 100000 + 33333000L);
		String StringRandomNumber = new Long(RandomNUM).toString();
		String BBIPNUM = BBIP + StringRandomNumber;
		report.Info("Random BBIP Number : " + BBIPNUM);

		Serenity.setSessionVariable("BBIPNUM").to(BBIPNUM);
	}

	@Step
	public void RetrieveRandomIMEI() throws IOException, ClassNotFoundException, SQLException {

		long RandomNUM = 0;
		RandomNUM = (long) (Math.random() * 100000 + 3333300000L);
		String StringRandomNumber1 = new Long(RandomNUM).toString();

		RandomNUM = (long) (Math.random() * 100000 + 3333300000L);
		String StringRandomNumber2 = new Long(RandomNUM).toString();

		String RandomIMEI = StringRandomNumber1 + StringRandomNumber2;
		report.Info("Random BBIP Number : " + RandomIMEI);

		Serenity.setSessionVariable("RandomIMEI").to(RandomIMEI);
	}

	@Step
	public void TryReserveAvailableMSISDNEVENorODD() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// String strConn = this.ConnectionDetails("SUP02");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@qtp.cqrpvr4944ct.eu-west-1.rds.amazonaws.com:1521:QTP", "datamanagement",
				"D2tamanagement");
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		String sMSISDN = "";
		String Env = Serenity.sessionVariableCalled("Env").toString();
		// String sQuery = "select MSISDN from MSISDN_Repository where status =
		// 'Available' and Environment = '"+Env+"' and rownum =1";
		String sQuery = "select MSISDN from MSISDN_Repository where status = 'Available' and Environment = '" + Env
				+ "' and mod (msisdn,2) =0 and rownum =1";
		// 0 = Even **** 1 = Odd
		try {
			rs = stmt.executeQuery(sQuery);
			if (!rs.next()) {
				Assert.assertTrue("No MSISDNS available", false);
			} else {
				// display results
				do {
					sMSISDN = rs.getString(1);
					Serenity.setSessionVariable("MSISDN").to(sMSISDN);
					report.Info("MSISDN :" + sMSISDN);

				} while (rs.next());
			}

			sQuery = "update MSISDN_Repository set status = 'Reserved' where MSISDN = '" + sMSISDN + "'";
			stmt.executeQuery(sQuery);
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
			report.Info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
			}
		}
	}
	
	@Step
    public void RetrieveMSSIDNFromExcel () throws ClassNotFoundException, SQLException, IOException {


            String filePath = "\\src\\test\\resources\\data\\MSISDN.xls";
            
            String dataSheet = "";
            
            dataSheet = Serenity.sessionVariableCalled("Env").toString();

            readWorkbook.readMSISDNnICCICD(filePath, dataSheet);
            //readWorkbook.testData(tableMap);
    

    }

}
