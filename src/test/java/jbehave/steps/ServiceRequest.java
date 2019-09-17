package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;
import pages.ServerManagementPage;
import pages.ServiceRequestPage;
import pages.OrdersPage;
import org.jbehave.core.annotations.Then;


public class ServiceRequest {
	@Steps
    private ServiceRequestPage Servicerequestpage;
	@Steps
	private OrdersPage Orderspage;
                   
    @Then("Service Request Field Validation for '$row'")
    public void ServiceRequest_Field_Validation(String rowname) throws InterruptedException, IOException, AWTException{   
    	Servicerequestpage.ServiceRequestFieldValidation(rowname);
    }
    
    @Then("Service request Type validation '$rowname'")
	public void CreateServiceRequestVia_ServiceRequest(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
    	Servicerequestpage.CreateServiceRequestViaServiceRequest(rowname);
 }
    
    @Then("Perform validation in Service Request screen for scenario '$accountType'")
	public void CreateAccount(String accountType)  throws InterruptedException, IOException, AWTException, ParseException{
    	Servicerequestpage.ServiceRequestValiadtionInServiceRequest(accountType);
	}	
    
    @When("Create Service request for scenario '$rowname' in Service Request Applet")
	public void Create_ServiceRequestVia_ServiceRequest(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
    	Servicerequestpage.CreateServiceRequestViaServiceRequest(rowname);
 } 
   
    @When("SR Resolved Customer Account for '$rowname'")
	public void SR_Resolved_CustomerAccount(String rowname) throws InterruptedException, IOException, FindFailed, AWTException {
    	Servicerequestpage.SRResolved_CustomerAccount(rowname);
    } 
    @Then("Perform validation of Primecontact Agent Id '$accountType'")
   	public void ServiceRequestPrimeContactID(String accountType)  throws InterruptedException, IOException, AWTException{
       	Servicerequestpage.ServiceRequestPrimeContact(accountType);
   	}
    @Then("Perform for scenario '$rowname' and perform About Record")
   	public void SRABoutRowID(String rowname)  throws InterruptedException, IOException, AWTException, ParseException{
       	Servicerequestpage.ServiceRequestValiadtionInServiceRequest(rowname);
       	Orderspage.getAboutRecord();
   	}
    @When("Validate the MyPrime Service Requests Filed")
	public void PrimeContact_serviceRequest() throws InterruptedException, IOException, FindFailed, AWTException {
    	Servicerequestpage.PrimeContact_serviceRequest();
    } 
    @When("Create New Activities in SR '$row'")
    public void CreateActivitiesinSR(String row) throws InterruptedException, IOException, FindFailed, AWTException {
    	Servicerequestpage.CreateActivitiesinSR(row);
    }
    
    @Then("Set Intial Complaint date 56 days back")
    public void SetDate_56DaysBack() throws IOException, AWTException, InterruptedException{   
    	Servicerequestpage.SetDate56DaysBack();
    }
}
