package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;

import pages.AccountsSecurityPageEnh;


public class AccountsSecurityEnh {
	@Steps
	private AccountsSecurityPageEnh AccountsSecurityenh;
	
		
		@Then("Perform DPA validation for '$accountType'")
		public void CreateOUIAccount(String accountType)  throws InterruptedException, IOException, AWTException{
			AccountsSecurityenh.CheckDPA(accountType);
			
		}	
		
		@Then("Perform changes in Contacts scenario for '$iRow'")
		public void ContactManagement(String iRow)  throws InterruptedException, IOException, AWTException, ParseException{
			AccountsSecurityenh.ContactManagement(iRow);
			
		}
		
		@Then("Perform Address Change in Address Tab for '$iRow'")
		public void AddressChange(String LogicalName)throws InterruptedException, IOException, AWTException{
			AccountsSecurityenh.AddressChange(LogicalName);
		}
		
		@Then("Navigate To Contact Tab and Check for Account Overview")
		public void NavigateToContactTab()  throws InterruptedException, IOException, AWTException{
			AccountsSecurityenh.NavigateToContactTab();
		}
		
		@Then("Validate NBA Offers Applet")
		public void ValidateNBAOffersApplet()  throws InterruptedException, IOException, AWTException{
			AccountsSecurityenh.ValidateNBAOffersApplet();
			
		}
		
		@Then("Check Third Party Social Marketing Permission for '$Row'")
		public void ThirdPartMP(String Row)  throws InterruptedException, IOException, AWTException{
			AccountsSecurityenh.MarketingPermissionContactsTabCheck(Row);
			
		}
		
		
}
