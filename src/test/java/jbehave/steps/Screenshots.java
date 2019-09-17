package jbehave.steps;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
//import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.common;

import pages.Screenshot;

public class Screenshots {
	
	@Steps
	private Screenshot screenshots;
	@Steps
	private common Common;
	
	@Given("Place screenshots in Folder '$FolderName'")
	@Step
	public void Prerequisite1(@Named("FolderName")String FolderName) throws IOException{
		Serenity.setSessionVariable("Meta").to(FolderName);
		Common.Meta(FolderName);
		screenshots.Prerequisite(FolderName);
	}
}
