package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nasaTestSuite.FrigiDriver;

public class StepDef_StartApp {
	
	FrigiDriver frigi = new FrigiDriver();
	
	@Given("^Appium server is running$")
	public void appium_server_is_running()  {//David
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("^Phone or emulator are ready$")
	public void phone_or_emulator_are_ready()  {//David
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^This code opens the app$")
	public void this_code_opens_the_app() throws Exception {//David
		System.out.println("Begin StepDef_StartApp Testing");//delete later
//		try 
//		{
			frigi.StartApp(20); //David: param is implicit time
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			System.out.println("FAIL: StartApp - THEN This code runs without errors");
//		}
	}
	
	@Then("^this code updates the app$")
	public void this_code_updates_the_app() throws Exception {//David
		frigi.UpdateApp();
		System.out.println("PASS: Scenario - Start and update the app");
	}
	
	//SCENE TWO

	@Given("^App is updated$")
	public void app_is_updated() throws Exception {
		//write code here
	}

	@Given("^Welcome page is open$")
	public void welcome_page_is_open() throws Exception {
	    //CHECK THAT SIGN IN AND REGISTER BUTTONS ARE DISPLAYED
	}

	@Then("^Sign in button is pressed$")
	public void sign_in_button_is_pressed() throws Exception {
		frigi.clickSignIn1();
		System.out.println("PASS: Scenario - Sign In Button");
	}
//
//	@Given("^The login page is open$")
//	public void the_login_page_is_open() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	}
//
//	@Then("^Email text box is clicked$")
//	public void email_text_box_is_clicked() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	}
//
//	@Then("^Email is typed$")
//	public void email_is_typed() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	}
//
//	@Then("^Password text box is clicked$")
//	public void password_text_box_is_clicked() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	}
//
//	@Then("^Password is typed$")
//	public void password_is_typed() throws Exception {
//	    frigi.typeSignIn();//TODO this needs to be split into 4 steps. Do after IDS work
//	}
//	
//	@Then("^Sign in button is pressed again$")
//	public void sign_in_button_is_pressed_again() throws Exception {
//	    frigi.clickSignIn2();
//	    // next time try List<WebElement> el = driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().text(\"MY_TEXT\")"));
//	    System.out.println("PASS: Scenario - Type Username and Password");
//	    
//	    System.out.println("need to move this next part to other stepdef later.");
//	    //System.out.println(frigi.checkScreen());
//	}
}
