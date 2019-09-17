package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.ScenarioType;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;

import pages.AccountsPage;
import pages.ServerManagementPage;
import utilities.ReadWorkbook;


public class Accounts {
	@Steps
	private AccountsPage Accountspage;
	
	@Steps
    private ReadWorkbook readWorkbook;
	
	@AfterScenario(uponType=ScenarioType.ANY, uponOutcome=AfterScenario.Outcome.SUCCESS)
    public void afterEachPassScenario() throws InterruptedException, IOException, AWTException{
        // Accountspage.CreateNewAccount("PrepaidConsumer");
        
         readWorkbook.writeOutputExcelFileTCPass();
    }
  
  @AfterScenario(uponType=ScenarioType.ANY,uponOutcome=AfterScenario.Outcome.FAILURE)
    public void afterEachFailScenario() throws InterruptedException, IOException, AWTException{
        // Accountspage.CreateNewAccount("PrepaidConsumer");
        
         readWorkbook.writeOutputExcelFileTCFail();
    }
  
   @BeforeStories
   public void beforeStory() throws InterruptedException, IOException, AWTException{
              // Accountspage.CreateNewAccount("PrepaidConsumer");
              readWorkbook.createOutputExcelFile();
   }
	
	/*@Steps
    private ReadWorkbook readWorkbook;
	
	@AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS)
    public void afterEachPassScenario() throws InterruptedException, IOException, AWTException{
        // Accountspage.CreateNewAccount("PrepaidConsumer");
        
         readWorkbook.writeOutputExcelFileTCPass();
    }
  
  @AfterScenario(uponOutcome=AfterScenario.Outcome.FAILURE)
    public void afterEachFailScenario() throws InterruptedException, IOException, AWTException{
        // Accountspage.CreateNewAccount("PrepaidConsumer");
        
         readWorkbook.writeOutputExcelFileTCFail();
    }
  
   @BeforeStories
   public void beforeStory() throws InterruptedException, IOException, AWTException{
              // Accountspage.CreateNewAccount("PrepaidConsumer");
              readWorkbook.createOutputExcelFile();
   }*/
	
		@When("Create the account type '$accountType'")
		public void CreateAccount(String accountType)  throws InterruptedException, IOException, AWTException{
			Accountspage.CreateNewAccount(accountType);
			Accountspage.VerifyAccountSummary(accountType);	
		}	
		@When("Create the transact account type '$accountType'")
		public void CreateNewAccountforTransactData(String accountType)  throws InterruptedException, IOException, AWTException{
			Accountspage.CreateNewAccountforTransactData(accountType);
			Accountspage.VerifyAccountSummaryforTransactData(accountType);	
		}		
		 @Then("Capture the Account Row ID in accountsummary page")
	        public void getAccount_Row_Id_AccoutSummary() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
	        	Accountspage.getAccount_Row_Id_AccoutSummary();
	        }
		
		@When("Create QAS account '$accountType'")
		public void Create_QAS_Account(String accountType)  throws InterruptedException, IOException, AWTException{			
			Accountspage.CreateQASAccount(accountType);			
		}		
		
		@When("Create only account type '$accountType'")
		public void CreateOnlyAccount(String accountType)  throws InterruptedException, IOException, AWTException{			
			Accountspage.CreateNewAccount(accountType);
			
		}
		@When("Create '$OrderType' '$BillingProfileType' Order")
		public void CreateNewBillingProfile(String OrderType,String BillingProfileType) throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.CreateNewBillingProfile(BillingProfileType);
			Accountspage.CreateNewOrder(OrderType);			
		}
		
		@When("Create New Billing Profile '$BillingProfileType'")
        public void CreateNewBillingProfile(String BillingProfileType) throws InterruptedException, IOException, AWTException {
              Accountspage.CreateNewBillingProfile(BillingProfileType);
     }
		@When("Create the Anonymous account type '$accountType'")
		public void CreateAnonymousAccount(String accountType)  throws InterruptedException, IOException, AWTException{
			Accountspage.AnonymousAccount(accountType);					
		}	
	 	@Then("validate the buttons on my customer comms")
	    public void validation() throws InterruptedException, IOException  {	    	
			Accountspage.CustomerCommsButtonsValidation();	   
		}
		@When("Validate Online Flag for scenario '$accountType'")
		public void ValidateOnlineFlag(String accountType)  throws InterruptedException, IOException, AWTException
		{
			Accountspage.OnlineAccountValidations(accountType);			
		}
		@Then("Validate Online Flag in Account,Account Summary,Contacts for scenario '$OnlineFlagValidation'")
		public void ValidateOnlineFlagAccountSummary(String OnlineFlagValidation)  throws InterruptedException, IOException, AWTException
		{
			Accountspage.VerifyOnlineAnonymousAccount(OnlineFlagValidation);
		}
		@Then("validate the Non validated address popup'$rowname'")
		public void NonValidatedAddress(String rowname) throws IOException, InterruptedException, AWTException{
			Accountspage.NonValidatedAddress(rowname); 
		}		
		 @When("Select '$rowname' AgreementId")
	    	public void SelectAgreementRowID(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
	    		Accountspage.SelectAgreementRowID(rowname);
	    	}
		 @When("Change the Date")
	        public void AgreementDateChange() throws InterruptedException, IOException, FindFailed, AWTException {
	        	Accountspage.AgreementDateChange();
		 }
		 @When("Change the Date by two days")
	        public void AgreementDateChangeByTwoDays() throws InterruptedException, IOException, FindFailed, AWTException {
	        	Accountspage.AgreementDateChangeByTwoDays();
		 }
		@Then("validate the Address Applet in all views")
	    public void validate_AddressApplet() throws InterruptedException, IOException, AWTException  {
	    
			Accountspage.AddressAppletValidation();	
	    }		
		@Then("Modify Details with '$rowname'")
	    public void email_Update(String rowname) throws IOException, InterruptedException, AWTException{
			Accountspage.ModifyDetails(rowname);
	    }				
	   @When("Search The Account '$AccountNo'")
	    public void Search_The_Account(String AccountNo) throws InterruptedException, AWTException, IOException  {
		   Accountspage.Searchaccount(AccountNo);
	    }	  
	    @When ("Create new Billing Profile via Profiles Tab '$rowname'" )
	    public void CreateNewProfilesBillingProfile(String rowname)  throws InterruptedException, IOException, AWTException{
	    	Accountspage.CreateNewProfilesBillingProfile(rowname);
	    }	
	    @Then("Perform Service Request Validation with '$rowname'")
	    public void Service_Request_Validation(String rowname) throws IOException, InterruptedException, AWTException{
			Accountspage.ServiceRequestColumnValidation(rowname);
	    }
        @Then ("Validate that Payment term is editable '$rowname'" )
        public void CreateNewProfilesBillingProfile_PaymentTerms(String rowname)  throws InterruptedException, IOException, AWTException{
          Accountspage.CreateNewProfilesBillingProfile(rowname);
        }
        @Then ("Perform Validation for Check Payment Date Button '$rowname'" )
        public void CreateNewProfilesBillingProfile_ChckPaymentDate(String rowname)  throws InterruptedException, IOException, AWTException{
          Accountspage.CreateNewProfilesBillingProfile(rowname);
        }
        
        @Then ("Perform validation for '$rowname' in Billing profile View" )
        public void CreateNewBillingProfile_RealTimeBalance(String rowname)  throws InterruptedException, IOException, AWTException{
          Accountspage.CreateNewBillingProfile(rowname);
        }  
        
        @Then ("Perform validation for '$rowname' in Profile's Tab Billing profile View" )
        public void CreateNewProfilesBillingProfile_RealTimeBalance(String rowname)  throws InterruptedException, IOException, AWTException{
          Accountspage.CreateNewProfilesBillingProfile(rowname);
        }
        
        @Then("Perform Services Validation for '$View'")
	    public void All_ProductServices_Validation(String View) throws IOException, InterruptedException, AWTException{
			Accountspage.AllProductServicesValidation(View);
	    }
	
        @When("Goto Account Summary")
	    public void Goto_AccountSummary() {
		   Accountspage.GotoAccountSummary();
	    }
        @Then("Verify Order page fields '$rowname'")
	    public void VerifyOrderDetails(String rowname) throws IOException, InterruptedException, AWTException{
			Accountspage.VerifyOrderDetails(rowname);
	    }
        @When("Create '$OrderType'Order")
    	public void Create_NewOrder(String Ordertype) throws InterruptedException, IOException, FindFailed, AWTException {
    		Accountspage.CreateNewOrder(Ordertype); 
        }
        @When("Goto Sub Account")
        public void Goto_SubAccount(){
            Accountspage.GotoSubAccount();
        }
        @When("Create New SubAccount Billing Profile '$BillingProfileType'")
        public void CreateNewBillingProfileSubAccounts(String BillingProfileType) throws InterruptedException, IOException, AWTException {
              Accountspage.CreateNewBillingProfileSubAccounts(BillingProfileType);
        }
        @When("Click New Billing Account")
        public void ClickNewBillingAccount() throws InterruptedException, IOException, FindFailed, AWTException {
            Accountspage.ClickNewBillingAccount();
}
        
        @When("Click New Service Account")
        public void ClickNewServiceAccount() throws InterruptedException, IOException, FindFailed, AWTException {
        	Accountspage.ClickNewServiceAccount();
        } 
        
        @When("Get agreement date for '$row'")
    	public void GetAgreementDate(String Row) throws InterruptedException, IOException, FindFailed, AWTException {
    		Accountspage.GetAgreementDate(Row);
        }
        @When("capture the Agreement ID '$rowname'")
    	public void SelectAgreementID(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
    		Accountspage.SelectAgreementRowID(rowname);
        }
        @Then("verify the Agreement ID '$rowname'")
    	public void VerifyAgreementRowID(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
    		Accountspage.SelectAgreementRowID(rowname); 
        }

		@When("Select ConditionalChargeRowID '$rowname'")
		public void ConditionalChargesRowID(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.ConditionalChargesRowID(rowname);
		}
		
		@When("Select ConditionalCharge '$rowname'")
		public void SelectConditionalChargesRow(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.SelectConditionalChargesRow(rowname);
		}
		
		@When("Retrieve Account Details")
		public void RetrieveAccountDetails() throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.RetrieveAccountDetails();
		}
		
		@Then("Perform Audit Trail for Account View '$rowname'")
		public void AuditTrailAccount(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.AuditTrailAccount(rowname);
		}
		
		@Then("Perform Audit Trail for Contact View '$rowname'")
		public void AuditTrailContact(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.AuditTrailContact(rowname);
		}
		@Then("Add Credit Balance for '$rowname'")
        public void AddCreditBalance(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
              Accountspage.AddCreditBalance(rowname);
        }
		
		@Then("Credit Vetting Tab Verification for '$rowname'")
        public void CreditVettingTabVerify(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
              Accountspage.CreditVettingTabVerify(rowname);
        }
		@Then("Validate the type of Account Alert '$Action'")
		public void AccountAlert(String Action) throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.AccountAlert(Action);
		}
		@When("Create New Account Alert '$rowname'")
		public void NewAccountAlert(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.AccountAlertAllField(rowname);
		}
		@When("Change Status of Account Alert '$rowname'")
		public void StatusExpired(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
			Accountspage.AccountAlertAllField(rowname);
		}
		@Then("validate the Premise page AddressPostcode Editable")
		public void VerifyAddressPostCodeEnabled() throws IOException, InterruptedException{
			Accountspage.VerifyAddressPostCodeEnabled();
		}
		@When("Clear DOB at Accounts Page")
		public void ClearDOB() throws InterruptedException, IOException, AWTException  {
			Accountspage.Account_DOBClear();
		}
        @When("Update Contact Number '$rowname'")
	    public void  UpdateContactPhoneNumber(String Action) throws InterruptedException, IOException, FindFailed, ClassNotFoundException {
			Accountspage.UpdateContactPhoneNumber(Action);
		}
        @When("About Record from User Preference")
        public void UserPreferences() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        	Accountspage.UserPreferences();
         }
        @When("Account Alert Audit Trail '$rowname'")
        public void AccountAlertAuditTrail(String rowname) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        	Accountspage.AccountAlertAuditTrail(rowname);
        }
        @Then("Click on Email Copy Bill for '$rowname'")
        public void Email_Copy_Bill(String rowname) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        	Accountspage.EmailCopyBillingBills(rowname);
        }
        @When("Update Email Account")
        public void Update_Email_Account() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        Accountspage.UpdateEmailAccount();
        }
        @Then("Verify Auto Asset '$rowname'")
        public void Verify_Auto_Asset(String rowname) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        Accountspage.VerifyAutoAsset(rowname);
        }
        @When("Edit Account")
        public void Edit_Account() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        Accountspage.EditAccount();
        }
        
        @When("Validate AgeIdVeification OutCome for Transact Data")
        public void AgeandIDVerificationTransact() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        	Accountspage.AgeVerificationOnly();
        	Accountspage.AgeandIDVerification();
         }
        
        @When("Validate AgeIdVeification OutCome")
        public void AgeandIDVerification() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        	Accountspage.AgeandIDVerification();
         }
        @When("Change Primary Address '$rowname'")
        public void ChangePrimaryAddress(String rowname) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        	Accountspage.ChangePrimaryAddress(rowname);
         }
        @Then("Verify Billing Profile Status")
        public void BillingProfileStatus() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        	Accountspage.BillingProfileStatus();
        }
        @Then("Capture the Billing profile id under accountsummary page")
        public void getBillingProfileId_AccoutSummary() throws InterruptedException, IOException, FindFailed, ClassNotFoundException, AWTException {
        	Accountspage.getBillingProfileId_AccoutSummary();
        }
        
        @Then("Perform Match Company Reg No '$rowname'")
		public void MatchComapny(String rowname)  throws InterruptedException, IOException, AWTException{			
			Accountspage.MatchCompany(rowname);			
		}
        
        @When("Validate the Postcode from Account Summary '$LogicalName'")
		public void ServiceRequestMoreInfo(String LogicalName)  throws InterruptedException, IOException, AWTException{			
			Accountspage.ServiceRequestMoreInfo(LogicalName);			
		}
        @When("Validate Marketing Permission for '$LogicalName'")
		public void MarketingPermissionValidation_AccountsContacView(String LogicalName)  throws InterruptedException, IOException, AWTException{			
			Accountspage.MarketingPermissionValidation_AccountsContacView(LogicalName);			
		}
}
