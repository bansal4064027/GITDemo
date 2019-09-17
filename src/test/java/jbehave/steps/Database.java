
package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import net.thucydides.core.annotations.Steps;
import pages.DatabasePage;
import pages.OrdersPage;

public class Database {
	@Steps
	private DatabasePage Database;
	@Steps
	private OrdersPage Orders;
	
	@When("Execute query '$rowname'")
	public void ExecuteQuery(String rowname) throws ClassNotFoundException, SQLException, IOException{
		Database.ExecuteDBQuery(rowname);
	}
	
	@When("Check if Order has reached Dispatch Shipping Task in OSM")
	public void Check_OSMShippingTask() throws ClassNotFoundException, SQLException, IOException, InterruptedException{
		Database.CheckOSMShippingTask();
	}
	
	@When("Update Multiple VSM")
	public void ExecuteQueryMultiVSM() throws Exception, SQLException {
		Database.UpdateVSMMultiple_fn();
	} 
	
	@When("RetriveICCIDMSISDN")
	public void RetriveICCID() throws ClassNotFoundException, SQLException, IOException{
		Database.TryReserveAvailableICCID();
		//Database.TryReserveAvailableMSISDN();
		Database.TryReserveAvailableMSISDNEVENorODD();
	}
	
	@When("Update Multiple MSISDNs")
	public void ExecuteQueryMultiMSIDNs() throws ClassNotFoundException, SQLException, IOException{
		Database.UpdateMSISDNMultiple_fn();
	}
	@When("Update Multiple ICCIDs")
	public void ExecuteQueryMultiICCID() throws ClassNotFoundException, SQLException, IOException{
		Database.UpdateICCIDMultiple_fn();
	}
	
	@When("Update Multiple IMEIs")
	public void ExecuteQueryMultiIMEI() throws ClassNotFoundException, SQLException, IOException{
		Database.UpdateIMEIMultiple_fn();
	}
	
	@When("Reserve Order")
	public void Reserve_Order() throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
		Orders.CaptureOrderDetails();
		Database.ExecuteDBQuery("ReserveOrder");
	}
	
	@When("Retrieve Promotion '$productKey'")
	public void Retrieve_Promotion(String productKey) throws ClassNotFoundException, SQLException, IOException, InterruptedException{
		Database.RetrievePromotionDetails(productKey);
	}
  
	@Given("Retrieve Account '$productKey'")
	public void Retrieve_Account(String productKey) throws ClassNotFoundException, SQLException, IOException, InterruptedException{
		Database.RetrieveAccount(productKey);
	}
	
	@Given("Retrieve OLD Account '$productKey'")
	public void Retrieve_AccountOLD(String productKey) throws ClassNotFoundException, SQLException, IOException, InterruptedException{
		Database.RetrieveAccountOLD(productKey);
	}
	
    @When("Get Address '$Address'")
	public void Get_Address(String Address) throws ClassNotFoundException, SQLException, IOException, InterruptedException{
		Database.GetAddress(Address);
	}
    @When("Get the Router Number")
   	public void TryReserveRouter() throws ClassNotFoundException, SQLException, IOException, InterruptedException{
   		Database.TryReserveRouter();
   	}
    
    
    @When("Execute BRM query '$rowname'")
	public void ExecuteBRMQuery(String rowname) throws ClassNotFoundException, SQLException, IOException, InterruptedException{
		Database.ExecuteBRMDBQuery(rowname);
	} 
	
	  @When("Execute Database query '$rowname' with query inputs '$hardcodedKeys'")
    public void ExecuteBRMQueryWithHardcodedKeys(String rowname,String hardcodedKeys) throws ClassNotFoundException, SQLException, IOException, InterruptedException{
		Database.ExecuteBRMDBQueryWithHardCodedKeys(rowname,hardcodedKeys);
	}

    @When("Get the BBIP Number")
    public void RetrieveBBIPNumber() throws ClassNotFoundException, SQLException, IOException, InterruptedException{
    	Database.RetrieveBBIPNumber();
    }
	

    @When("Get the Random IMEI Number")
    public void RetrieveRandomIMEI() throws ClassNotFoundException, SQLException, IOException, InterruptedException{
    	Database.RetrieveRandomIMEI();
    }
}
