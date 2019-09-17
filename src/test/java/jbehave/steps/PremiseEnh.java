package jbehave.steps;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;
import pages.OrdersPage;
import pages.PremisePageEnh;

public class PremiseEnh {
	@Steps
	private PremisePageEnh PremisepageEnh;
	
	@When("Click on Fixed Line Check Avilibility for '$accountType'")
	public void CheckAvailibility(String accountType)  throws InterruptedException, IOException, AWTException{
		PremisepageEnh.CheckAvailibility(accountType);
		}
	
	@When("Click on Generate New Number")
	public void ClickOnGenerateNewNumberButton()  throws InterruptedException, IOException, AWTException{
		PremisepageEnh.ClickOnGenerateNewNumberButton();
		}
	
	@When("Click on Book Appointment")
	public void ClickOnBookAppointmentButton()  throws InterruptedException, IOException, AWTException{
		PremisepageEnh.ClickOnBookAppointmentButton();
		}
	
	@When("Click on Terms and Condition")
	public void ClickOnTermsAndConditionBox()  throws InterruptedException, IOException, AWTException{
		PremisepageEnh.ClickOnTermsAndConditionBox();
		}
	
	@When("Filter Promotion for Enhancement '$rowname'")
    public void  FilterPromotionEnh(String Action) throws InterruptedException, IOException, FindFailed, ClassNotFoundException, SQLException, AWTException {
		PremisepageEnh.FilterPromotionEnh(Action);

	}
	
}
