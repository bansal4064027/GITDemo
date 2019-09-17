package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import pages.ConfirmOrderPageEnh;
import pages.DatabasePage;

public class ConfirmOrderEnh {
	
	@Steps
	private DatabasePage Database;
	@Steps
	private ConfirmOrderPageEnh ConfirmOrderpageEnh;
	
	@When("Perform payment with '$rowname' and Confirm Order")
	public void PaymentandConfirmOrder(String rowname) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		ConfirmOrderpageEnh.OrderPayment(rowname);
		ConfirmOrderpageEnh.ConfirmOrder();
	}
	
	@When("Confirm Order")
	public void ConfirmOrder() throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {		
		ConfirmOrderpageEnh.ConfirmOrder();
	}
	
	@When("Perform payment with '$rowname'")
	public void Payment(String rowname) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		ConfirmOrderpageEnh.OrderPayment(rowname);
	}

	@When("Navigate to Order Summary Page")
	public void Navigate_CompareLineItems()  throws InterruptedException, IOException, AWTException{
		ConfirmOrderpageEnh.NavigateToOrderSummaryPage();
	}
}
