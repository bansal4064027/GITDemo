package jbehave.steps;



import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.jbehave.core.annotations.Given;
//import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;

import pages.OrdersPage;
import pages.AccountSummaryPage;
import pages.AccountsPage;
import pages.DatabasePage;

public class AccountSummary {
	@Steps
	private AccountSummaryPage AccountSummary;
	@Steps
	private OrdersPage Orderspage;
	@Steps
	private AccountsPage Accountspage;
	@Steps
	private DatabasePage Database;
	
	@Then("Perform the action '$action'")
	public void Perform_Action(String action) throws IOException, InterruptedException, FindFailed, AWTException{
		AccountSummary.UsedProductServices(action);
	}
	@When("Verify Contacts '$rowname'")
    public void Add_VerifyContacts(String rowname) throws InterruptedException, IOException, AWTException {
  	  AccountSummary.AddVerifyContacts(rowname);
    }
	@Then("Click on Profiles tab and check if Payment terms is editable")
	public void ChckPaymentTerms()  throws InterruptedException, IOException, AWTException{
		AccountSummary.PaymentTerms();
	}
	@Then("Verify if For The Attention is present in Account Addresses List")
	public void FortheAttention()  throws InterruptedException, IOException, AWTException{
		AccountSummary.AccountAddressesList();
	}
	@Then("Reset Customer Comms for scenario '$ResetAction'")
	public void ValidateOnlineFlagAccountSummary(String ResetAction)  throws InterruptedException, IOException, AWTException
	{
		AccountSummary.ResetCustomerComms(ResetAction);	
	}
	@Then("Validate the Customer Summary with'$rowname'")
	public void CustomerSummary(String rowname) throws IOException, InterruptedException, AWTException{
		AccountSummary.CustomerSummary(rowname);	
	}
	
	@When("select new Not-Validated address")
    public void NotValidatedAccounts_AddressLine() throws ClassNotFoundException, SQLException, IOException, InterruptedException{
          AccountSummary.NotValidatedAccounts_AddressLine();
    }

	@Then("Check Postcode in account summary after address updation for '$rowname'")
	public void CheckPostcode_AccountSummary(String rowname) throws IOException, InterruptedException, AWTException{
		AccountSummary.CheckPostcodeinAccountSummary(rowname);
	}


	@Then("Perform Validation for '$Editable'")
	public void Editable_annonymous(String Editable) throws InterruptedException, IOException, AWTException{
		AccountSummary.AddressEditable(Editable);
	}
	@Then ("Validate DOB Popup for '$rowname'" )
	public void Age_ID_Partner(String rowname)  throws InterruptedException, IOException, AWTException{
		AccountSummary.AgeIDVerification(rowname);
	}
	@Then("Verify Customer Comms Contacts '$rowname'")
    public void Verify_CustComContacts(String rowname) throws InterruptedException, IOException, AWTException {
  	  AccountSummary.VerifyCustComContacts(rowname);
    }
	@Then("Create Customer Comms '$CustComms'")
	public void Create_CustomerComms(String CustComms) throws InterruptedException, IOException, AWTException{
		AccountSummary.CreateCustComms(CustComms);
	}
	
	@When("Create Customer Comms '$CustComms'")
	public void Create_CustomerComms2(String CustComms) throws InterruptedException, IOException, AWTException{
		AccountSummary.CreateCustComms(CustComms);
	}
	
	
	@Then("Create Direct Debit for scenario '$DirectDebitAction'")
	public void CreateDirectDebit(String DirectDebitAction)  throws InterruptedException, IOException, AWTException
	{
		AccountSummary.DirectDebit(DirectDebitAction);
		
	}
	
	@When("Wait For 2 minutes")
	public void Wait() throws InterruptedException
	{
		AccountSummary.Wait();
	}
	
	
	@When("Change Payment for scenario '$logicalName'")
	public void Change_Payment(String logicalName)  throws InterruptedException, IOException, AWTException
	{
		AccountSummary.ChangePaymentMethod(logicalName);
		
	}
	@Then ("Validate Blocker Popup Occurs without entering Email '$rowname'" )
	public void BillsEmail(String rowname)  throws InterruptedException, IOException, AWTException{
		AccountSummary.BillsEmail(rowname);
	}
	@Given("About Record")
	    public void AboutRecordFn() throws InterruptedException  {
		  AccountSummary.AboutRecord();
	        
	}
	@Then("Validate Cust Comms Comments '$rowname'")
	public void captureComments(String rowname)  throws InterruptedException, IOException, AWTException
	{
		AccountSummary.captureComments_CustComms(rowname);
		
	} 
	@Then ("Validate the DD Transaction type" )
	public void Profiles_DirectDebit()  throws InterruptedException, IOException, AWTException{
		AccountSummary.Profiles_DirectDebit();
	}
	@Then("Validate the Account permission is full access '$ResetAction'")
	public void validateAccountPermission(String ResetAction) throws IOException, InterruptedException, AWTException{
		AccountSummary.ResetCustomerComms(ResetAction);
	}
	@Then("Validate fields under CustomerSummarry Applet '$rowname'")
	public void VerifyFields_CustomerSummaryApplet(String rowname) throws IOException, InterruptedException, AWTException{
		AccountSummary.VerifyCustomerSummary(rowname);
		}
	@When("Modify with owned product '$action'")
    public void OwnedProductServices(String action) throws InterruptedException, IOException, AWTException  {
         AccountSummary.OwnedProductServices(action);
    }
	
	@When("Create New '$BillingProfileType' and Perform '$MenuProfile' with About Record")     

    public void MenubillingprofileAboutRecord(String MenuProfile, String BillingProfileType) throws InterruptedException, IOException, AWTException{
           Accountspage.CreateNewBillingProfile(BillingProfileType);
           AccountSummary.MenuBillingProfile(MenuProfile);
           Orderspage.getAboutRecord();
      }     
	@When("Perform Tokenization '$AboutRecordOfMenuItemToeknization' with About Record")
	public void MenuBillingProfile(String MenuProfile) throws InterruptedException, IOException, ClassNotFoundException, SQLException, FindFailed, AWTException{
		AccountSummary.MenuBillingProfile(MenuProfile);
        Orderspage.getAboutRecord();
  }
      @When("Perform '$MenuProfile' and Execute query '$rowname' and Create New '$OrderType' Order")     

    public void Menubillingprofile(String MenuProfile,String rowname,String OrderType) throws InterruptedException, IOException, ClassNotFoundException, SQLException, FindFailed, AWTException{
            AccountSummary.MenuBillingProfile(MenuProfile);
            Database.ExecuteDBQuery(rowname);
            Accountspage.CreateNewOrder(OrderType);
      }
      
      @Then("Verify the Product and Services for '$Action'")
      public void Product_Services(String Action) throws InterruptedException, IOException, AWTException, ParseException  {
  	  AccountSummary.ProductServicesVerify(Action);          
      }
      @Then("Perform Migration")
      public void Perform_Migration() throws InterruptedException, IOException , AWTException {
  	  AccountSummary.PromotionUpgrade();
      }
  	@Then("Perform Transfer Of OwnerShip")
    public void PerformTOO() throws InterruptedException, AWTException, IOException {
	  AccountSummary.TransferOfOwnerShip();          
    }
  	@Then("Validate the Address applet")
    public void gotoAddreses() throws IOException, InterruptedException, AWTException{
  		AccountSummary.gotoAddresss();  
    }
	    @Then("Perform NLFL")
	    public void Perform_NLFL() throws InterruptedException, IOException, AWTException  {
	    AccountSummary.PackagesNLFL();
    }
	    @When("Perform the '$MenuProfile' with About Record")     

	     public void Menuprofile_aboutRecord(String MenuProfile) throws InterruptedException, IOException, AWTException{
	           AccountSummary.MenuBillingProfile(MenuProfile);
	           Orderspage.getAboutRecord();
	      } 
	    @When("Perform the CustomerAccount")     
	     public void CustomerAccount() throws InterruptedException, IOException, AWTException{
	           AccountSummary.CustomerAccount();
	           
	      } 
	    @Then("Validate the owned product and services '$action'")
	    public void ValidateOwnedProductServices(String action) throws InterruptedException, IOException, AWTException  {
	         AccountSummary.OwnedProductServices(action);
	    }
  
	    @When("Perform '$MenuProfile' and Execute query '$rowname'")     
	    public void MenuProfExecutequery(String MenuProfile,String rowname) throws InterruptedException, IOException, ClassNotFoundException, SQLException, FindFailed, AWTException{
	            AccountSummary.MenuBillingProfile(MenuProfile);
	            Database.ExecuteDBQuery(rowname);
	    }          
  
	    @When("Perform '$MenuProfile' with About Record")   

	    public void MenubillingprofAboutRecord(String MenuProfile) throws InterruptedException, IOException, AWTException{
	           
	           AccountSummary.MenuBillingProfile(MenuProfile);
	           Orderspage.getAboutRecord();
	      }
	    @When("Validate the BillingProfile status '$logicalName'")
		  public void BillingProfile(String logicalName) throws IOException, InterruptedException, AWTException{
		  
		  AccountSummary.ChangePaymentMethod(logicalName);
		  
	  }
	  @When("Execute DBQurey '$rowname'")
	  public void executeDBqurery(String rowname) throws ClassNotFoundException, SQLException, IOException{
	 
	  Database.ExecuteDBQuery(rowname);
     }
	  
      @Then("Verify the Product and Services and Attribute for '$Action'")
      public void VerifyAttributesTab(String Action) throws InterruptedException, IOException, AWTException  {
  	  AccountSummary.VerifyAttributesTab(Action);          
      }
      @When("Perform BulkModify with '$rowname'")
      public void BulkMOdify(String rowname) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
            AccountSummary.BulkMOdify(rowname);
      
   }
      @When("Validate the Bulk Modify Target Device")
      public void BulkModify_TargetDevice_Handset() throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
            AccountSummary.BulkModify_TargetDevice_Handset();
      }
      
      @When("Perform BulkModify Acchierarchy with '$rowname'")
      public void BulkModifyAccounthierarchy(String rowname) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
            AccountSummary.BulkModifyAccounthierarchy(rowname);
      
   }
      
      @When("Add product via BulkModify with '$rowname'")
      public void BulkMOdifyAddProducts(String rowname) throws ClassNotFoundException, SQLException, IOException, InterruptedException, FindFailed, AWTException{
            AccountSummary.BulkMOdifyAddProducts(rowname);
      
   }
      @When("Perform Menu bulkmodify with '$rowname'")
      public void MenuBulkModify(String rowname) throws ClassNotFoundException, SQLException, IOException, InterruptedException, FindFailed, AWTException{
            AccountSummary.MenuBulkModify(rowname);
      
   }
      @When("Validate the Bulk view process status '$rowname'")
      public void BulkViewProcessStatusValidation(String rowname) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
            AccountSummary.BulkViewProcessStatusValidation(rowname);
      
   }
      @Then("Validate  the usedproduct services '$action'")
          public void UsedProductServices(String action) throws IOException, InterruptedException, FindFailed, AWTException{
                AccountSummary.UsedProductServices(action);
          }
      @When("Validate the Bulk Modify All Promotions")
      public void BulkModify_TargetPromotion_AllPromotions() throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
            AccountSummary.BulkModify_TargetPromotion_AllPromotions();
      
   }
      @When("perform BilkModify TargetPromotion import '$rowname'")
      public void BulkModify_TargetPromotionProcess_ImportDialog(String rowname) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
            AccountSummary.BulkModify_TargetPromotionProcess_ImportDialog(rowname);
      }
      @When("search the child account '$AccountNo'")
      public void SearchAccountPrePost(String AccountNo) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
            AccountSummary.SearchAccountPrePost(AccountNo);
      }
      @When("select new address")
      public void Accounts_AddressLine() throws ClassNotFoundException, SQLException, IOException, InterruptedException{
            AccountSummary.Accounts_AddressLine();
      }
      @When("Perform the upgrade")
      public void PrePost_Upgrade() throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException{
            AccountSummary.PrePost_Upgrade();
      }
      @When("create new child account '$rowname'")
      public void AccountsPrePost(String rowname) throws InterruptedException, IOException, AWTException {
    	  AccountSummary.AccountsPrePost(rowname);
      }
      
      @Then("Perform AddDeleteMedia '$mediatype'")
      public void MediaType(String LogicalName) throws InterruptedException, IOException, AWTException{
      AccountSummary.AddDeleteMedia(LogicalName);
      } 
      
      @When("Check Updated By field under customer comms '$rowname'")
      public void ValidateUpdatedByFeild(String rowname) throws InterruptedException, IOException, AWTException {
    	  AccountSummary.ValidateUpdatedByField(rowname);;
      }
      
      @Then("Validate the Billed product and services '$action'")
	    public void ValidateBilledProductServices(String action) throws InterruptedException, IOException, AWTException  {
	         AccountSummary.BilledProductServices(action);
	    }
		  @When("Check Customer Comms '$rowname'")
      public void ValidateCustComms(String rowname) throws InterruptedException, IOException, AWTException {
    	  AccountSummary.ValidateCustComms(rowname);
      }
		  
		 @Then("Verify SecureNet Care Portal is enabled")
         public void VerifySecureNetCarePortal() throws InterruptedException, IOException  {
		 }
		 @Then("Validate the secureNet Portal butoon")
		    public void SecureNetPortalValidation() throws InterruptedException, IOException, AWTException  {
		     AccountSummary.SecureNetPortalValidation();	 
		      }
		 @Then("Validate Service Request Type LOV for scenario '$Action' in Account Service Request path")
	      public void ValidateSRLOV(String Action) throws InterruptedException, IOException, AWTException {
	    	  AccountSummary.CreateServiceRequestviaAccount(Action);
	      }
		 @When("Create Service Request for scenario '$Action' in Account Summary view")
	      public void CreateSRinAccountSummaryView(String Action) throws InterruptedException, IOException, AWTException {
	    	  AccountSummary.CreateServiceRequestviaAccountSummary(Action);
	      }
		 
		 @When("Create Service Request Type LOV for scenario '$Action' in Account Service Request path")
	      public void CreateSRLOV(String Action) throws InterruptedException, IOException, AWTException {
	    	  AccountSummary.CreateServiceRequestviaAccount(Action);
	      }
		 
		 @Then("Validate Cust Comms Message '$VeifyMessage'")
	      public void CustCommsMsgVerify(String VeifyMessage) throws InterruptedException, IOException, AWTException {
			 AccountSummary.CustCommsMsgVerify(VeifyMessage);
	      }
		 @When("Anonymous Address validation for '$Action'")
	      public void AnonymousAddress(String Action) throws InterruptedException, IOException, AWTException {
	    	  AccountSummary.AnonymousAddress(Action);
	      }
		 
		 @Then("Validate the fiedls under customer comms after job success '$rowname'")
		    public void validateJobDetails(String rowname) throws InterruptedException, IOException, AWTException, FindFailed  {
		     AccountSummary.validateJobDetails(rowname); 
		      }
		
		 @When("Perform the '$MenuProfile' with about record '$MenuProfile' and Execute query '$rowname'")     
		    public void MenubillingprofileTokenization(String MenuProfile,String rowname) throws InterruptedException, IOException, ClassNotFoundException, SQLException, FindFailed, AWTException{
		    	  AccountSummary.MenuBillingProfile(MenuProfile);
		          Orderspage.getAboutRecord();    
		          AccountSummary.MenuBillingProfile(MenuProfile);
		          Database.ExecuteDBQuery(rowname);
		      } 
		 
		 @When("Owned modify product '$action' with econfig item '$EconfigItem'")
		    public void OwnedProductService(String action, String EconfigItem) throws InterruptedException, IOException, AWTException, FindFailed  {
		         AccountSummary.OwnedProductServices(action);
		         Orderspage.Econfig(EconfigItem);
		    }
		 @When("Set the Credit Limit Balance")
	      public void addCreditLimit() throws InterruptedException, IOException, AWTException {
	    	  AccountSummary.addCreditLimit();
	      }
		 
		 @When("Validate the rows in different views '$Rowno'")
	      public void Validations(String Rowno) throws InterruptedException, IOException, AWTException {
	    	  AccountSummary.Validations(Rowno);
	      }
		 @When("Perform the EmailEqipmentInvocie'$rowname'")
			public void EmailEqipmentInvoice(String rowname) throws IOException, InterruptedException, AWTException{
				AccountSummary.VerifyCustomerSummary(rowname);
				}
		 @Then("Validate the CustomerComss '$rowname'")
			public void Validate_customerComms(String rowname) throws IOException, InterruptedException, AWTException{
				AccountSummary.VerifyCustomerSummary(rowname);
				}
		 @When("Get Postcode from Address tab")
	      public void getPostcodeAddressTab() throws InterruptedException, IOException, AWTException {
	    	  AccountSummary.getPostcodeFromAddresssTab();
		 }
	    	  
    	  @Then("Capture Direct Debit screen")
			public void DirectDebitCapture()  throws InterruptedException, IOException, AWTException
			{
				AccountSummary.DirectDebitCaptureAndValidation();			
			}	
			 
		 @Then("Perfom Billing Profie Audit Trail Validation '$logicalName'")
			public void ProfilesBillingProfValidation(String logicalName)  throws InterruptedException, IOException, AWTException
			{
				AccountSummary.ProfilesBillingProfileAuditTrail(logicalName);			
			}
		 @When("Update the details in AccountAddressess with '$rowname'")
			public void accountAddressChange(String rowname) throws IOException, InterruptedException, AWTException{
				AccountSummary.accountAddressChange(rowname);
				}
		 @Then("Validate Billing Profile PaymentMethod '$DirectDebitAction'")
			public void DirectDebit(String DirectDebitAction)  throws InterruptedException, IOException, AWTException
			{
				AccountSummary.DirectDebit(DirectDebitAction);
				
			}
		 
		 @Then("Change the Product Service Date '$rowname'")
			public void DateChange(String rowname)  throws InterruptedException, IOException, AWTException
			{
				AccountSummary.ProductServiceDateChange(rowname);
				
			}
		 
		 @Then("Perform '$MenuProfile' with About Record and Perform '$MenuProfile' and Execute query '$rowname' for product and service")
			public void ProductServiceMenuBillingProfile(String rowname, String MenuProfile)  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException
			{
		    	AccountSummary.ProductServiceTabMenuBillingProfile(MenuProfile);
		    	Orderspage.getAboutRecord();
		    	AccountSummary.ProductServiceTabMenuBillingProfile(MenuProfile);
		        Database.ExecuteDBQuery(rowname);
				
			}
		 
		 @Then("Perform the Account Permission in Contacts tab '$rowname'")
			public void AccountPermission(String rowname)  throws InterruptedException, IOException, AWTException
			{
				AccountSummary.Contacts_AccountPermission_fn(rowname);
				
			}
		 
		 @Then("Perform action in diverts tab '$rowname'")
	      public void DivertsTab(String rowname) throws InterruptedException, IOException, AWTException {
	    	  AccountSummary.Diverts(rowname);
		 } 
		 
	      }
  
