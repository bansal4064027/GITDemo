package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;

import pages.AboutCustomerPageEnh;
import pages.OrdersPage;
import pages.ServerManagementPage;
import pages.ProductAndServicePageEnh;
import pages.DatabasePage;

public class AboutCustomerEnh {
	@Steps
	private AboutCustomerPageEnh AboutCustomerEnh;
	
	@Steps
	private OrdersPage Orderspage;
	
	@Steps
	private DatabasePage Database;
	
	@When("Fill the About the customer detail '$accountType'")
	public void fillAboutTheCustomerView(String accountType)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.AddPersonalDetails(accountType);
		}
	
	@When("Create Personal Detail and Adress for '$accountType'")
	public void CreateAdress(String account, String accountType)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.AddPersonalDetails(accountType);
		AboutCustomerEnh.AddAdress(accountType);
		}
	
	@When("Navigate to Product Services Page")
	public void NavigateToProductServices()  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.NavigateToProductandServicesTab();
	}
	
	@When("Validate Product in Basket for '$Product'")
	public void ValidateProduct_Basket(String Product)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.CustomiseProductEnh(Product);
	}
	

	@When("Perform '$Action' on Payment Method and Execute query '$DBQuery' and click on Save Button")
	public void BillingProfileSelectionAboutRecordOUI(String Action, String DBQuery)  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException{
		AboutCustomerEnh.BillingProfileSelectionOUI(Action);
		Database.ExecuteDBQuery(DBQuery);
	}
	
	@When("Check for Columns in '$Rownum'")	
    public void CheckForColumns(String Rownum) throws InterruptedException, IOException, AWTException, FindFailed{
		AboutCustomerEnh.CustomiseProductEnh(Rownum);				
	}
	

	@When("Validate PostCode Case Sensitive for '$accountType'")
	public void ValidatePostCodeCaseSensitive(String accountType)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.ValidatePostCodeCaseSensitive(accountType);	
		}
	
	@When("Create Adress for '$accountType'")
	public void CreateAdressOnly(String account, String accountType)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.AddAdress(accountType);
		}
	
	
	@When("Perform Credit Vet OUI for '$Action'")
	public void CreditVettingResultsOUI(String Action)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.CreditVettingResultsOUI(Action);
	}
	
	@When("Perform IDV Check and Credit Vet with Result '$Action'")
	public void CreditVettingWithIDVCheckAndResults(String Action)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.CreditVettingWithIDVCheckAndResults(Action);
	}
	
	@When("Click on Next Button")
	public void ClickNextButton()  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.ClickNextButton();
	}
	
	
	@When("Select Billing Profile '$Action' and click on Save Button")
	public void BillingProfileSelectionOUI(String Action)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.BillingProfileSelectionOUI(Action);
	}
	
	@When("Customise '$Rownum' with Econfig Item '$EconfigItem' in Enhancement")	
    public void EconfigItem(String EconfigItem,String Rownum) throws InterruptedException, IOException, AWTException, FindFailed{
		AboutCustomerEnh.CustomiseProductEnh(Rownum);
		Orderspage.Econfig(EconfigItem);
		
	}
	
	@When("Customise '$Rownum' with AddOn Item '$EconfigItem' in Enhancement")	
    public void AddOnItem(String EconfigItem,String Rownum) throws InterruptedException, IOException, AWTException, FindFailed{
		AboutCustomerEnh.CustomiseProductEnh(Rownum);
		Orderspage.AddProduct(EconfigItem);
		
	}
	
	@When("Create Service Hierarchy Account for '$Action'")
	public void Create_ServiceHierarchy_Account(String Action)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.CreateServiceHierarchyAccount(Action);
	}
	
	@When("Check LOV for dropdowns in About Customer Page")
	public void CheckLOVforDropdowns()  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.CheckLOVforDropdowns();
	}
	
	@When("Click on Confirm Payer/User Button")
	public void Click_ConfirmPayerUserButton()  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.ClickConfirmPayerUserButton();
	}
	
	@When("Click on Discard Changes Button")
	public void Click_DiscardChangesButton()  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.DiscardChanges();
	}
	
	@When("Select Identification Type as '$IdentificationCheckType'")
	public void selectIdentificationType(String IdentificationCheckType)  throws InterruptedException, IOException, AWTException{
		AboutCustomerEnh.identificationCheck(IdentificationCheckType);
	}

}
