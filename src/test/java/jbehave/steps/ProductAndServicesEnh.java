package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;

import pages.ProductAndServicePageEnh;
import pages.AccountsPageEnh;
import pages.ServerManagementPage;
import pages.DatabasePage;

public class ProductAndServicesEnh {
	@Steps
	private ProductAndServicePageEnh ProductSearchEnh;
	@Steps
	private DatabasePage Database;

	
    @When("Add Promotion '$rowname' in OUI")
    public void ProductSearch(String rowname) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
    	ProductSearchEnh.ProductSearch(rowname);
    }
    
    @When("Update Promotion '$productKey' for '$row' in OUI")
    public void ProductNumberSearch(String productKey,String row) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	Database.RetrievePromotionDetails(productKey);
    	ProductSearchEnh.ProductSearch(row);
    }
    
    @When("Perform action for '$productKey' in OUI Product and Services page")
    public void ProductandServiceValidation(String row) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	ProductSearchEnh.ProductSearch(row);
    }
    @Then("Perform Product Services line items validation for Owned product Services '$logicalName'")
	public void OwnedProductServicesLineItems(String logicalName)  throws InterruptedException, IOException, AWTException{
    	ProductSearchEnh.OwnedProductServicesLineItems(logicalName);		
	}
    
    @Then("Select Action from Product&Services Overview for '$logicalName'")
    public void OwnedBilledUsedProdService(String Action) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	ProductSearchEnh.OwnedBilledUsedProductServices(Action);
    }
    
    @Then("Select Action from OwnedLineItems Overview for '$logicalName'")
    public void OwnedBilledLineItems(String Action) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	ProductSearchEnh.OwnedBilledLineItems(Action);
    }
    
    @When("Update Promotion for '$logicalName'")
    public void PromotionChange(String Action) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	ProductSearchEnh.PromotionUpgrade(Action);
    }
    
    @When("Update Promotion and add handset")
    public void PromotionChangeaddhandset() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	ProductSearchEnh.PromotionUpgradeAddhandset();
    }
    
    @When("Select Promotion")
    public void PromotionSelect() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	ProductSearchEnh.PromotionSelect();
    }
    
    @When("Validate Cost To Correct Decimal")
    public void ValidateCostToCorrectDecimal() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	ProductSearchEnh.ValidateCostToCorrectDecimal();
    }
    
    @When("Check Promotion Contract Period  for '$row' in OUI")
    public void CheckPromotionContractPeriod(String row) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException, SQLException {
    	ProductSearchEnh.CheckPromotionContractPeriod(row);
    }
    
    @Then("Bill Details validation for '$logicalName'")
   	public void Billing(String logicalName)  throws InterruptedException, IOException, AWTException{
       	ProductSearchEnh.Billing(logicalName);		
   	}
    
    @When("Perform '$logicalName' in Billing View")
   	public void BillingView(String logicalName)  throws InterruptedException, IOException, AWTException{
       	ProductSearchEnh.Billing(logicalName);		
   	}
    @When("Perform '$logicalName' in Previous Billing View")
   	public void BillingPreviousView(String logicalName)  throws InterruptedException, IOException, AWTException{
       	ProductSearchEnh.Billing(logicalName);		
   	}
    @Then("Billing Profiles validation for '$logicalName'")
   	public void BillingProfiles(String logicalName)  throws InterruptedException, IOException, AWTException{
       	ProductSearchEnh.BillingProfiles(logicalName);		
   	}

    @When("Create Prepaid Billing Profile with '$logicalName'")
    public void Prepaid_BillingProfile(String logicalName) throws InterruptedException, IOException, AWTException{
       	ProductSearchEnh.BillingProfilesForPrepay(logicalName);		
   	}
    
    @When("Add Combi Plan for '$logicalName'")
   	public void CombiBundlePlansSelectionEnh(String logicalName) throws IOException, InterruptedException, FindFailed, AWTException{
       	ProductSearchEnh.CombiBundlePlansSelection(logicalName);		
   	}
}
