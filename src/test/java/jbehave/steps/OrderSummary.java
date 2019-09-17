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
import pages.FulfilmentPageEnh;
import pages.OrderSummaryPageEnh;
import pages.ProductAndServicePageEnh;
import pages.DatabasePage;

public class OrderSummary {
	@Steps
	private OrderSummaryPageEnh OrderSummarypageEnh;
	@Steps
	private DatabasePage Database;
	
	@When("Order Details Capture in Order Summary page")
	public void FulfilmentStatus()  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException{
		OrderSummarypageEnh.CaptureOrderNumber();
		Database.ExecuteDBQuery("ReserveOrder");
		OrderSummarypageEnh.OrderSummaryPage();
		}
	
	@When("Reserve Order in Order Summary page")
	public void OrderReserve()  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException{
		OrderSummarypageEnh.CaptureOrderNumber();
		Database.ExecuteDBQuery("ReserveOrder");
		OrderSummarypageEnh.OrderSummaryPage();
		}
	
	@When("Discard Order")
	public void DiscardOrder()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.CancelOrder();
		}
	
	@When("Validate Disconnection Popup for no reason mentioned")
	public void ValidateDisconnectionPopup()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.ValidateDisconnectionPopUp();
		}
	
	
	@When("Compare Line Items '$LogicalName'")
	public void CompareLineItems(String LogicalName)  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.CompareLineItems(LogicalName);
	}
	
	@When("Perform activity '$LogicalName' in Compare Line Items")
	public void CompareLineItemsActivity(String LogicalName)  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.CompareLineItems(LogicalName);
	}
	
	@When("Enter Disconnection Reason And click Next")
	public void DisconnectionReason_Next()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.DisconnectionReasonAndNext();
		}
	
	@When("Notification check For Minor")
	public void NotificationCheckForMinor()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.NotificationCheckForMinor();
		}
	
	@When("Notification check For Major")
	public void NotificationCheckForMajor()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.NotificationCheckForMajor();
		}
	
	@When("Voxi Account Limit Cross")
	public void VoxiAccountLimit()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.VoxiAccountLimit();
		}
	
	@When("Validate Digital Signature Applet not present for Call Centre Agents")
	public void Validate_DigitalSignatureApplet()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.ValidateDigitalSignatureApplet();
		}
	
	@When("Override price discount for '$row'")
	public void OverridePriceDiscount(String iRowNo)  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.OverridePriceDiscount(iRowNo);
		}
	
	@When("Enter Digital Signature and Click on Next")
	public void Draw_DigitalSignature()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.CaptureOrderNumber();
		OrderSummarypageEnh.DrawDigitalSignature();
		}
	
	@When("Navigate to Compare Line Items Page")
	public void Navigate_CompareLineItems()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.NavigateToCompareLineItems();
	}

	@When("Submit the Changes and Capture Order Details")
	public void Submit_Changes()  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.SubmitChanges();
	}
	
	@When("Perform Validations in Order Summary page for '$LogicalName'")
	public void OrderSummary_Validation(String LogicalName)  throws InterruptedException, IOException, AWTException{
		OrderSummarypageEnh.OrderSummaryValidation(LogicalName);
	}
	@Then("Generate Contract Report in Halo")
    public void ContractReport_Halo() throws InterruptedException, IOException, AWTException, FindFailed{
		OrderSummarypageEnh.HaloGenerateContractReportSave();
    }
	@Then("Validate Decimal for Equipment Subsidy Price")
    public void ValidateDecimalForEquipmentSubsidy() throws InterruptedException, IOException, AWTException, FindFailed{
		OrderSummarypageEnh.ValidateDecimalForEquipmentSubsidy();
    }
}
