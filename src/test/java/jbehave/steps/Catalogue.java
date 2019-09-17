package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import org.sikuli.script.FindFailed;

import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import pages.CataloguePage;
import pages.DatabasePage;

public class Catalogue extends PageObject {
	@Steps	
	private CataloguePage CataloguePage;
	@Steps	
	private DatabasePage Database;
	
	@When("Promotion is added with '$ProductName'")
	public void CatalogueSearch(String ProductName) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException {
		Database.RetrievePromotionDetails(ProductName);
		CataloguePage.CatalogueSearch();		
	}
	
	@Then("Check Payment Date and validate the Payment button")
    public void CheckPaymentDate()throws InterruptedException, IOException, AWTException {
          CataloguePage.CheckPaymentDate();
	}
	
	@Then("Validate Promotion Validation '$ProductName'")
	public void CatalogueSearchValidation(String ProductName) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException {
		Database.RetrievePromotionDetails(ProductName);
		CataloguePage.CatalogueSearchValidation();		
	}
	
	
    @Then("Validate Address Delete Button '$CheckAddressButton'")
    public void AddressesDeleteButtonCheck(String CheckAddressButton) throws InterruptedException, IOException, AWTException {
          CataloguePage.AddressesDeleteButtonCheck(CheckAddressButton);
    }
    @When("Select Billing Serviceaccount '$ProductName'")
    public void OrderBillingServiceAccountSelection(String Account) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException {
    CataloguePage.OrderBillingServiceAccountSelection(Account);
    }
    @When("Select Order SubAccount Bill Profile Selection '$ProductName'")
    public void OrderSubAccountsBillingProfileSelection(String Account) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException {
    CataloguePage.OrderSubAccountsBillingProfileSelection(Account);
    }
    
    @When("Click on '$AccountName'")
    public void SubAccountBillingAccountNameSelection(String Account) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException {
    CataloguePage.SubAccountBillingAccountNameSelection(Account);
    }
    @Then("Perform Add or Remove products via FastOrder for product '$Action'")
    public void FastOrdersProducts(String Action) throws InterruptedException, IOException, AWTException {
          CataloguePage.FastOrdersProducts(Action);
    }
    
    @When("Goto Profiles Tab and Select Billing Profile '$Action'")
    public void BillingProfileNameSelection(String Action) throws InterruptedException, IOException, AWTException {
          CataloguePage.BillingProfileNameSelection(Action);
    }

    @When("Validate Balanace Details '$Action'")
    public void MonetaryBalanceCheck(String Action) throws InterruptedException, IOException, AWTException {
          CataloguePage.MonetaryBalanceCheck(Action);
    }
    @When("Select Order Billing Profile '$ProductName'")
    public void OrderBillingProfileSelection(String Account) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException {
    CataloguePage.OrderBillingProfileSelection(Account);
    }
    @Then("Validate Balance Usage Details '$Action'")
    public void CheckUsage(String Action) throws InterruptedException, IOException, AWTException {
          CataloguePage.CheckUsage(Action);
    }
    
    @Then("Perform Bill Adjustment for Credit or Debit '$rowname'")
    public void BillAdjustment(String rowname) throws InterruptedException, IOException, AWTException {
          CataloguePage.CreditDebitAdjustments(rowname);
    }
    
    @Then("Unbilled Event Level Adjustment selection '$BillingProfileType'")
	public void Unbilled_event_level_selection(String OrderType) throws InterruptedException, IOException, FindFailed, AWTException {
    	CataloguePage.EventLevelMSISDNSelect_fn(OrderType);	
    }
    @Then("Unbilled Type of Usage Adjustment selection '$BillingProfileType'")
	public void Unbilled_event_typeof_usage(String OrderType) throws InterruptedException, IOException, FindFailed,AWTException {
    	CataloguePage.EventLevelAdjustment_fn(OrderType);		
	}
    @When("Event Level Adjustment selection '$BillingProfileType'")
	public void ItemisedListSelectionClickAdjust(String OrderType) throws InterruptedException, IOException, FindFailed ,AWTException{
    	CataloguePage.ItemisedListSelectionClickAdjust(OrderType);		
	}
    @Then("TopUpHistoryValidation '$BillingProfileType'")
	public void TopUp_History(String BillingProfileType) throws InterruptedException, IOException, FindFailed,AWTException {
    	CataloguePage.TopUpHistory(BillingProfileType);		
	}
    
}
