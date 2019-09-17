package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import net.thucydides.core.annotations.Steps;
import pages.ServerManagementPage;
import org.jbehave.core.annotations.Then;
import pages.OrdersPage;


public class ServerManagementSteps {
	@Steps
    private ServerManagementPage Servermanagementpage;
	
	@Steps
    private OrdersPage ordersPage;
    
	
	@When("Navigate To All Templates and validate for template '$template'")
    public void Navigation(String Template) throws InterruptedException, IOException, AWTException {    
            Servermanagementpage.AllTemplatesValidation(Template);
    }
	
    @When("Navigate To Employees Tab")
    public void Navigation() throws InterruptedException {
                
            Servermanagementpage.NavigationToEmployees();
    }
    @Then("Capture Division value with '$Division'")
    public void AdminDiv(String Division) throws InterruptedException, IOException, AWTException{
                
             Servermanagementpage.AdministratorDivision(Division);
    }
    
    @When("Navigate To Jobs")
    public void NavigationToJobs() throws InterruptedException, IOException, AWTException {   
            Servermanagementpage.NavigationToJobs();
}
    
    @When("Create New Jobs '$JobType'")
    public void NewJobs(String UIName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.CreateNewJob(UIName);
            
    }
    @When("Perform scenario for '$RowName' in Jobs")
    public void PerforminJobs(String RowName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.CreateNewJob(RowName);
    }
    
    @When("Select the Jobs '$JobType'")
    public void SelectJob(String UIName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.SelectJob(UIName);
    }
    
    @When("Performs '$RowwId'")
    public void JobParameters(String UIName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.JobParameters(UIName);
    }
    @Then("Validate the Division Filter under ListOFValues '$RowName'")
    public void divisionFilter(String RowName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.divisionFilter(RowName);
    }
    @Then("Validate the Division Filter Monitoring '$RowName'")
    public void divisionFilterMonitoring(String RowName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.divisionFilterMonitoring(RowName);
    }
    @Then("Validate is View  mapped to VF_ADMIN '$RowName'")
    public void View_validation(String RowName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.View_validation(RowName);
    }
    @When("Search Account Via SiteMap for '$RowName'")
    public void SearchAccount_ViaSiteMap(String UIName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.SearchAccountViaSiteMap(UIName);
    }
    @Then("Validate the ListOFValues '$RowName'")
    public void valiateLOVvalues(String RowName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.divisionFilter(RowName);
    }
    @When("Validate All Responsibilities of VFPrimeServiceRequest '$RowName'")
    public void VFPrimeServiceRequestListView(String RowName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.View_validation(RowName);
    }
    @When("Validate the Saved Queris List")
    public void SavedQueiesListValidation() throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.SavedQueiesListValidation();
    }
    
    @Then("Select fields in SMS and Email Engine In SiteMap for '$RowName'")
    public void SMSandEmailEngine_In_SiteMap(String RowName) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.SMSandEmailEngineInSiteMap(RowName);
    }
    @Then("Customer Comm columns Validation '$row'")
    public void Customer_Comm_Validation(String row) throws InterruptedException, IOException, AWTException{ 
    	Servermanagementpage.CustomerCommValidation(row);
    }
    @When("Perform Business Process")
    public void BusinessProcess() throws InterruptedException, IOException{   
            Servermanagementpage.AdminBusinessProcess();
            ordersPage.getAboutRecord();
    }
    @When("Perform Check Division")
    public void CheckDivision() throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.CheckDivision(); 
            //servermngmnt age
    }
    @When("Get the SWI profile policy update '$rowname'")
    public void AdministraionBusinessProcess(String rowname) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.AdministraionBusinessProcess(rowname);
    }
    @When("Select SiteMap and Validate Administration Product fields '$rowname'")
    public void AdminProductValidation(String rowname) throws InterruptedException, IOException, AWTException{   
            Servermanagementpage.AdminProductValidation(rowname);
    }
}
