package stepDefinitions;

import static org.junit.Assert.fail;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nasaTestSuite.Dehum;
import nasaTestSuite.FrigiDriver;
import nasaTestSuite.MyXPath;

public class StepDef_StartApp {
	
	FrigiDriver frigi = new FrigiDriver();
	Dehum dhum = null; 
	
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
		//this.frigi = new FrigiDriver(20); //David: param is implicit time THIS BROKE SO HARD  NULLPOINTER LATER ON AT SIGN IN CAUSE UNKNOWN
		frigi.startApp(20);
		dhum = frigi.dhum;
		System.out.println("1");
	}
	
	@Then("^this code updates the app$")
	public void this_code_updates_the_app() throws Exception {//David
		//frigi.UpdateApp();
		frigi.clickByXpath(MyXPath.updateButton, 240);
		System.out.println("PASS: Scenario - Start and update the app");
	}
	
	//SCENE TWO

	@Given("^App is updated$")
	public void app_is_updated() throws Exception {
		//write code here
		System.out.println("2");
	}

	@Given("^Welcome page is open$")
	public void welcome_page_is_open() throws Exception {
	    //CHECK THAT SIGN IN AND REGISTER BUTTONS ARE DISPLAYED
		System.out.println("3");
	}

	@Then("^Sign in button is pressed$")
	public void sign_in_button_is_pressed() throws Exception {
		System.out.println("4");
		frigi.clickSignIn1();
		System.out.println("PASS: Scenario - Sign In Button");
	}

	@Given("^The login page is open$")
	public void the_login_page_is_open() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^Email text box is clicked$")
	public void email_text_box_is_clicked() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^Email is typed$")
	public void email_is_typed() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^Password text box is clicked$")
	public void password_text_box_is_clicked() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^Password is typed$")
	public void password_is_typed() throws Exception {
	    frigi.typeSignIn();//TODO this needs to be split into 4 steps. Do after IDS work
	}
	
	@Then("^Sign in button is pressed again$")
	public void sign_in_button_is_pressed_again() throws Exception {
	    frigi.clickSignIn2();
	    // next time try List<WebElement> el = driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().text(\"MY_TEXT\")"));
	    System.out.println("PASS: Scenario - Type Username and Password");
	    
	}
	
	//humidscen

	@Given("^Dehumidifier control screen is open$")
	public void dehumidifier_control_screen_is_open() throws Exception {
		
	}
	
	@When("^Plus button is pressed$")
	public void plus_button_is_pressed() throws Exception {
		dhum.checkHumidity();
		dhum.clickHumidPlus();
	}
	
	@Then("^If the humidity is not (\\d+) or CONT it will increase by (\\d+)%$")
	public void if_the_humidity_is_not_or_CONT_it_will_increase_by(int arg1, int arg2) throws Exception {
		
	}
	
	@Then("^If the humidity is (\\d+)% it will become CONT$")
	public void if_the_humidity_is_it_will_become_CONT(int arg1) throws Exception {
		
	}
	
	@Then("^If the humidity is CONT it will become (\\d+)%$")
	public void if_the_humidity_is_CONT_it_will_become(int arg1) throws Exception {
		
	}
	

}
