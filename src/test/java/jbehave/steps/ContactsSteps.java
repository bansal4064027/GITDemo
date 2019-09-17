package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import net.thucydides.core.annotations.Steps;
import pages.ContactsPage;

public class ContactsSteps {
	@Steps
	private ContactsPage ContactsPage;
	
	
	@When("Validate Contacts tab for '$Validation'")
	public void CreateAccount(String Validation)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.Contacts_LastName(Validation);			
	}
	@When("Add Contact for '$Row'")
	public void Add_Contact(String Row)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.AddContactTab(Row);		
	}
	
	@When("Perform DOB validation '$Validation'")
	public void DOBValidation(String Validation)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.DOBValidation(Validation);			
	}
	
	@When("Validate AccountTab new&Delete Button under CustomerTab")
	public void account_CustomerTab()  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.account_CustomerTab();			
	}
	@When("Validate Marketing Permission Contacts tab for '$Validation'")
	public void Marketing_Permission(String Validation)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.Marketing_Permission(Validation);	
	
	}
	@When("Validate the Blocking message of contactTab '$Validation'")
	public void AddContactTab(String Validation)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.AddContactTab(Validation);			
	}
	@Then("Validate Account Drill down in Contacts tab")
	public void Contacts_AccountField () throws InterruptedException, IOException, AWTException
	{
	ContactsPage.Contacts_AccountField();
	}
	
	@Then("Validate Account from Main Contact")
	public void MainContacts_AccountField () throws InterruptedException, IOException, AWTException
	{
		ContactsPage.MainContacts_AccountField();
	}
	@Then("Validate DOB when Saving")
	public void Contacts_DOBValidation() throws InterruptedException, IOException, AWTException
	{
		ContactsPage.Contacts_DOBValidation();
	}
	@Then("Validate DOB while Saving Existing Account '$AccountNo', '$Rows'")
	 public void Account_DOBValidation(String AccountNo, String Rows) throws InterruptedException, IOException, AWTException{
		ContactsPage.Account_DOBValidation(AccountNo, Rows);
	}
	
	@Then("Division Filter Monitoring for '$Row'")
	public void Division_Filter_Monitoring(String Row)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.DivisionFilterMonitoring(Row);
	} 	
	
	@When("Contact List View Validation for '$Row'")
	public void Contact_ListView_Validation(String Row)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.ContactListViewValidation(Row);
	}
	

	@When("Add Contact in Contacts Screen for '$Row'")
	public void Add_Contact_ContactScreen(String Row)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.AddContactInContactScreen(Row);
		
	}	@When("Validate Contacts tab for FL'$Validation'")
	public void Contacts_LastNameFL(String Validation)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.Contacts_LastNameFL(Validation);			
	}
	
	@When("Clear DOB at Contacts Page")
	public void ClearDOB_Contacts()  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.Contacts_DOBClear();	
	}
	
	@When("Validate account added in contacts table for '$Row'")
	public void AddContact_Tab(String Row)  throws InterruptedException, IOException, AWTException
	{
		ContactsPage.AddContactTab(Row);			
	}
	
	@When("Search Username '$Row' on Outer Level Contact")
	public void Search_Username_Outer_Contact(String Row)  throws Exception
	{
		ContactsPage.searchWithUsernameInContactsOuterTab(Row);			
	}
	
	@When("Update Account Level Marketting Permission '$Row' from contact view")
	public void Update_Account_Level_Permission(String Row)  throws Exception
	{
		ContactsPage.checkUncheckGDPRPermission(Row);			
	}
}