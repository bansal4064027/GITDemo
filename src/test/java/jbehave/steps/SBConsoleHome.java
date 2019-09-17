package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import net.thucydides.core.annotations.Steps;
import pages.SBConsoleHomePage;
import pages.DatabasePage;
//import pages.SBConsoleLoginPage;
import pages.LoginPage;

public class SBConsoleHome {
	
	@Steps
	private SBConsoleHomePage sBConsoleHomePage;
	@Steps
	private LoginPage sLoginPage;
	
	@Steps
	private DatabasePage Database;
	
	@When("Dispatch '$OrderType' order '$OrderID' via FMW XML")
    public void dispatch_order_via_FMW_injection(String OrderType,String OrderID) throws Exception  {
		sLoginPage.LoginToSBConsole();
		sBConsoleHomePage.selectService();
		Database.TryReserveAvailableICCID();
		sBConsoleHomePage.invokeService(OrderType,OrderID);
    }

}
