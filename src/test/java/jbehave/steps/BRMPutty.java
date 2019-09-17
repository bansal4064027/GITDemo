package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.jbehave.core.annotations.Given;
//import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.BRMODILogin;
import pages.BRMODIPage;
import pages.BRMPuttyPages;
import pages.DatabasePage;
import utilities.SikuliUtility;
import utilities.common;

public class BRMPutty {
	@Steps
	private common common1;
	@Steps
	private SikuliUtility sikuliUtility;	
	@Steps
	private BRMPuttyPages BRMPuttyPages;

	@Steps
	private DatabasePage Database;
	
	@Steps
	private BRMODILogin BRMODILogin;
	@Steps
	private BRMODIPage BRMODIPage;
	
	@When("Login To Putty '$PuttyLogFileName' and run CSV '$BulkCsv'")

	@Step
	public void CRMPuttyLogin(String PuttyLogFileName,String BulkCsv) throws Exception{
		BRMPuttyPages.CRMPuttyLogin(PuttyLogFileName);
		BRMPuttyPages.BulkCsv(BulkCsv);
		
}
	
	@When("Login To Putty '$PuttyLogFileName' and run Bulk Migration CSV '$BulkCsv'")
	@Step
	public void CRMPuttyLoginMigrationCSV(String PuttyLogFileName,String BulkCsv) throws Exception{
		BRMPuttyPages.CRMPuttyLogin(PuttyLogFileName);
		BRMPuttyPages.BulkMigrationCsv(BulkCsv);
		
	}
	
	/*@Given("Login To Putty '$PuttyLogFileName' and perform Direct Debit")

	@Step
	public void DirectDebitForPutty(String PuttyLogFileName) throws Exception{
		BRMPuttyPages.CRMPuttyLogin(PuttyLogFileName);
		BRMPuttyPages.DirectDebitForPutty();
		
}*/
	@Given("Login To Putty '$PuttyLogFileName' in '$Env' and perform Direct Debit")

	@Step
	public void BRMPuttyLoginDD(String PuttyLogFileName,String Environment) throws Exception{
		BRMPuttyPages.BRMPuttyLogin(PuttyLogFileName,Environment);
		BRMPuttyPages.DirectDebitForPutty();
		
}
	
	@Then("Run ADDACS CSV file for Reason code '$ReasonCode'")
	@Step
	public void AddacsCSV(String ReasonCode) throws Exception{		
		BRMPuttyPages.Putty_Addacs_CSV(ReasonCode);		
	}
	
	@Given("Rate a '$RatingType' CDR")
	@Step
	public void Rating(String RatingType) throws Exception{
				//String SikulifilePath = "\\src\\test\\resources\\BRM_Snapshot";
				//String SikulifilePathForSavingFile = "";//\\target\\site\\serenity		
				BRMPuttyPages.PuttyRating(RatingType);
	}
	
	
	@Then("Run AUDDIS CSV file for Reason code '$ReasonCode'")

	@Step
	public void AuddisCSV(String ReasonCode) throws Exception{		
		BRMPuttyPages.Putty_Auddis_CSV(ReasonCode);		
	}
	
	@Given("Enter Docgen details '$rowname'")
	@Step
	public void Docgen(String Rowid) throws Exception {		
		BRMPuttyPages.Docgen(Rowid);
}
	
	@Given("Login to Putty '$PuttyFileName'")
	@Step
	public void LoginToPutty(String PuttyLogFileName) throws Exception{		
		BRMPuttyPages.CRMPuttyLogin(PuttyLogFileName);		
	}
	
	@Given("Login To Putty '$PuttyLogFileName' in '$Environment'")
	@Step
	public void BRMPuttyLogin(String PuttyLogFileName,String Environment) throws InterruptedException, IOException, FindFailed, AWTException {
		//String SikulifilePath = "\\src\\test\\resources\\BRM_Snapshot";
		//String SikulifilePathForSavingFile = "";//\\target\\site\\serenity
		BRMPuttyPages.BRMPuttyLogin(PuttyLogFileName,Environment);

	}
	@Given("Generate First Bill")

	@Step
	public void BillNow() throws Exception{		
		BRMPuttyPages.BillNow();
}
	
	@Then("Run ODI '$Login' '$Browse' '$Execute'")
	@Step
	public void RunODI(String Login, String Browse, String Execute) throws Exception{		
		BRMODILogin.LoginToODI(Login);
		BRMODIPage.BrowseScenarios_fn(Browse);
		BRMODILogin.ExecuteScenario_fn(Execute);
		BRMODIPage.SearchSessionStatus_fn();
	}
	
	@Given("Show All Purchase Products in the account '$Account_No'")
	@Step
	public void Purchase_Products(String Account_No) throws IOException, AWTException, InterruptedException, ClassNotFoundException, SQLException {
		BRMPuttyPages.Purchase_Products(Account_No);	
		
	}
	
	@Given("Generate Month End Invoice with Account '$Index'")
	@Step
	public void Invoice_fn(String Index) throws Exception {
		BRMPuttyPages.Invoice_fn(Index);
	}
	@Then("Click on View Bill and Save PDF")
	@Step
	public void SavePDF() throws Exception {
		BRMPuttyPages.SavePDF();
	}
	@Given("Generate Month End Bill with Account '$Index'")
	@Step
	public void Bill_fn(String Index) throws Exception {
		BRMPuttyPages.Bill_fn(Index);
		
	}
	@When("Make Payment for '$Index'")
	@Step
	public void PuttyPayment(String Index) throws Exception {
		BRMPuttyPages.PuttyPayment(Index);
	}

	
}
