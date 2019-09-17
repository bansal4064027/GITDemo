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
import pages.ConfigureOrderPageEnh;
import pages.DatabasePage;

public class ConfigureOrderEnh {

	@Steps
	private DatabasePage Database;
	@Steps
	private ConfigureOrderPageEnh ConfigureOrderPage;

	@When("Update ICCID and MSISDN in OUI by performing '$rowname' and Click Next")
	public void UpdateMSISDN(String MenuLineItem, String rowname) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		Database.TryReserveAvailableICCID();
		//Database.TryReserveAvailableMSISDN();
		Database.TryReserveAvailableMSISDNEVENorODD();
		ConfigureOrderPage.UpdateMSISDN();
		Database.ExecuteDBQuery(rowname);
		ConfigureOrderPage.UpdateICCID();
		ConfigureOrderPage.ConfigureOrderNext();
	}

	@When("Update ICCID and MSISDN in OUI by performing '$rowname'")
	public void UpdateMSISDNNandNotNavigate(String MenuLineItem, String rowname) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		Database.TryReserveAvailableICCID();
		//Database.TryReserveAvailableMSISDN();
		Database.TryReserveAvailableMSISDNEVENorODD();
		ConfigureOrderPage.UpdateMSISDN();
		Database.ExecuteDBQuery(rowname);
		ConfigureOrderPage.UpdateICCID();
	}


	@When("Update ICCID in OUI")
	public void UpdateICCID() throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		ConfigureOrderPage.UpdateICCID();
	}

	@When("Update ICCID  in OUI and Click Next")
	public void UpdateICCIDandNext() throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		Database.TryReserveAvailableICCID();
		ConfigureOrderPage.UpdateICCID();
		ConfigureOrderPage.ConfigureOrderNext();
	}

	@When("Update IMEI for '$scenario' in OUI")
	public void UpdateIMEI(String Action) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		ConfigureOrderPage.UpdateIMEI(Action);
	}

	@When("Update IMEI for '$scenario' in OUI and Click Next")
	public void UpdateIMEIandNext(String Action) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		ConfigureOrderPage.UpdateIMEI(Action);
		ConfigureOrderPage.ConfigureOrderNext();
	}

	@When("Update MSISDN in OUI by performing '$rowname' and Click Next")
	public void UpdateMSISDNOnly(String MenuLineItem, String rowname) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		Database.TryReserveAvailableMSISDN();
		ConfigureOrderPage.UpdateMSISDN();
		Database.ExecuteDBQuery(rowname);
		ConfigureOrderPage.ConfigureOrderNext();
	}

	@When("Update MSISDN in OUI by performing '$rowname'")
	public void UpdateMSISDNOnly_1(String MenuLineItem, String rowname) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		Database.TryReserveAvailableMSISDN();
		ConfigureOrderPage.UpdateMSISDN();
		Database.ExecuteDBQuery(rowname);
	}

	@When("Perform Validations of Add Serial Number for '$scenario' in OUI")
	public void AddSerialNumberValidation(String Action) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		ConfigureOrderPage.AddSerialNumberValidation(Action);
	}

	@When("Perform One Number Validation for '$scenario' in OUI and Click Next")
	public void OneNumberValidation(String Action) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		ConfigureOrderPage.OneNumberValidation(Action);
		ConfigureOrderPage.ConfigureOrderNext();
	}

	@When("Perform One Number Validation for '$scenario'")
	public void OneNumberValidationOnly(String Action) throws InterruptedException, IOException, ClassNotFoundException, SQLException, AWTException, FindFailed {
		ConfigureOrderPage.OneNumberValidation(Action);
	}
}
