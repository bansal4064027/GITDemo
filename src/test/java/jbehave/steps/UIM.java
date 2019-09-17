package jbehave.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.thucydides.core.annotations.Steps;
import pages.LoginPage;
import pages.UIMPage;

public class UIM {
	
	@Steps
	UIMPage uimpage;
	
	@Steps
	LoginPage loginPage;
	
	@When("Validate If MSISDN '$MSISDN' is Present in UIM")
    public void Validte_UIM_Presence_In_UIM (String MSISDN) throws FindFailed, InterruptedException, IOException, AWTException  {
		loginPage.LoginToUIM();
		uimpage.validateMSISDNisPresentInUIM(MSISDN);
    	
    } 
	
	@When("Capture IMSI for ICCID '$ICCID'")
    public void Capture_IMSI(String ICCID) throws FindFailed, InterruptedException, IOException, AWTException  {
		loginPage.LoginToUIM();
		uimpage.captureIMSI(ICCID);
    	
    } 

}
