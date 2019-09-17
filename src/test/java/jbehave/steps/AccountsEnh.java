package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;

import pages.AccountsPageEnh;
import pages.ServerManagementPage;


public class AccountsEnh {
	@Steps
	private AccountsPageEnh AccountspageEnh;
	
		
		@When("Create OUI account type '$accountType'")
		public void CreateOUIAccount(String accountType)  throws InterruptedException, IOException, AWTException{
			AccountspageEnh.CreateNewOUIAccount(accountType);
			AccountspageEnh.VerifyOUIAccountSummary(accountType);	
		}	
		@When("Search The OUI Account '$Action' '$AccountNo'")
	    public void Search_The_AccountOUI(String Action, String AccountNo) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException  {
		   AccountspageEnh.SearchaccountOUI(Action, AccountNo);
		}
		
		@When("Search for CTI Toolbar for '$Action' '$AccountNo'")
	    public void SearchForToolbar(String Action, String AccountNo) throws InterruptedException, AWTException, IOException  {
		   AccountspageEnh.SearchForToolbar(Action, AccountNo);
		}
		
		@When("Change Payment method for '$accountType'")
		public void ChangePaymentMethod(String accountType)  throws InterruptedException, IOException, AWTException{
			AccountspageEnh.ChangePaymentMethod(accountType);
			}
		
		@Then("Perform Bill Copy for Scenario '$logicalName'")
		public void BillCopy(String logicalName)  throws InterruptedException, IOException, AWTException{
			AccountspageEnh.BillCopy(logicalName);
			}
		
		@When("Create OUI online account type '$accountType'")
		public void CreateOUIOnlineAccount(String accountType)  throws InterruptedException, IOException, AWTException{
			AccountspageEnh.CreateNewOUIAccount(accountType);	
		}
		
		@When("Select Action from Owned Product and Services (Account Overview)'$logicalName'")
		public void OwnedProductServices(String logicalName)  throws InterruptedException, IOException, AWTException, FindFailed{
			AccountspageEnh.OwnedProductServices(logicalName);	
		}
		
				
		@When("Select Action from Billed Product and Services (Account Overview)'$logicalName'")
		public void BilledProductServices(String logicalName)  throws InterruptedException, IOException, AWTException, FindFailed{
			AccountspageEnh.BilledProductServices(logicalName);	
		}	
		
		@When("Select Action from Used Product and Services (Account Overview) '$logicalName'")
		public void UsedProductServices(String logicalName)  throws InterruptedException, IOException, AWTException, FindFailed{
			AccountspageEnh.UsedProductServices(logicalName);	
		}
		
		@When("Create New OUI Order")
		public void CreateOrder()  throws InterruptedException, IOException, AWTException, FindFailed{
			AccountspageEnh.CreateOrder();	
		}
		

		@When("Check order in Account Overview Page for '$logicalName'")
		public void CheckOrder_AccountOverview(String logicalName)  throws InterruptedException, IOException, AWTException, FindFailed{
			AccountspageEnh.CheckOrderInAccountOverview(logicalName);	
		}
		@When("Validate Black tariff checkbox for '$logicalName'")
		public void BlackTariffValidation(String logicalName)  throws InterruptedException, IOException, AWTException{
			AccountspageEnh.BlackTariffValidation_AccDetails(logicalName);
				
		}
		
		@Then("Verify HALO Screen if VF Black Banner is visible")
		public void verify_VFBlack_Banner_Halo() {
			AccountspageEnh.verifyVFBlackBannerHalo();
		}
		
		@Then("Verify HALO Screen if VIP Customer Banner is visible")
		public void verify_VIP_Customer_Banner_Halo() {
			AccountspageEnh.verifyVIPCustomerBannerHalo();
		}
}
