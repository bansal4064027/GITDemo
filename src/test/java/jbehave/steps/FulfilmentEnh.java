package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;

import pages.AboutCustomerPageEnh;
import pages.FulfilmentPageEnh;
import pages.ServerManagementPage;
import pages.ProductAndServicePageEnh;

public class FulfilmentEnh {
	@Steps
	private FulfilmentPageEnh FulfilmentEnh;
	
	@When("Perform Fulfilment Status With '$DeliveryMethod'")
	public void FulfilmentStatus(String DeliveryMethod)  throws InterruptedException, IOException, AWTException{
		FulfilmentEnh.Fulfilment_Status(DeliveryMethod);
		}
	
	@When("Select Action from Return Exchange Info")
	public void ReturnExchangeInfo()  throws InterruptedException, IOException, AWTException{
		FulfilmentEnh.ReturnExchangeInfo();	
	}
	
	@When("Select Action from Return Exchange Info with '$Action'")
	public void ReturnExchangeInfoWith(String Action)  throws InterruptedException, IOException, AWTException{
		FulfilmentEnh.ReturnExchangeInfoWith(Action);
	}
	
}
