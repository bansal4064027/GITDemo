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
import pages.BillingPageEnh;

public class BillingEnh {
	@Steps
	private BillingPageEnh BillingEnh;
	@Steps
	private DatabasePage Database;

		
   	
    
    @When("Perform '$logicalName' in Billing Details View")
   	public void BillingDetails(String logicalName)  throws InterruptedException, IOException, AWTException{
    	BillingEnh.BillingDetails(logicalName);		
   	}
    @Then("TopUp History Validation '$BillingProfileType'")
	public void TopUpHistoryCheck(String BillingProfileType) throws InterruptedException, IOException, FindFailed,AWTException {
    	BillingEnh.TopUpHistoryCheck(BillingProfileType);		
	}
}