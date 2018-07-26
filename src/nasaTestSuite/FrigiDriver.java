package nasaTestSuite;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import nasaTestSuite.TestCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import javax.swing.JOptionPane;
import io.appium.java_client.android.AndroidDriver;

public class FrigiDriver {

	private URL testServerAddress; 
	private static AndroidDriver driver; //David: why is this static?
	boolean boolAppStart = false;
	boolean boolAppUpdated = false;
	
	public void StartApp(int implicitTime) {
		TestCapabilities testCap = new TestCapabilities();
		testCap.AssignAppiumCapabilities();
		try 
		{
			testServerAddress = new URL("http://localhost:4723/wd/hub");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("StepDef StartApp() CAUGHT: Failed to load URL");
		}
		DesiredCapabilities appiumSettings = testCap.AssignAppiumCapabilities();
		try 
		{
			driver = new AndroidDriver<MobileElement>(testServerAddress, appiumSettings);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			driver.quit();
			System.out.println("StepDef StartApp() CAUGHT: Failed to initialize AndroidDriver driver");
		}
		
		driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
		boolAppStart = true;
	}
	
	public void UpdateApp() {
		Boolean looping = true;
		while(looping) { //David: removed wait time
			try {
				WebElement updateButton = driver.findElementById("android:id/button2");
				updateButton.click();
				looping = false;
			}catch(Exception e) {
				//David: This will loop for infinity if the update button never shows up
			}
		}
		
		boolAppUpdated = true;
	}
	public void clickSignIn1() {
		try {
			boolean looping = true;
			while(looping) {
				MobileElement result = GrabFromClass("android.widget.Button",0, driver);
				result.click();
				looping = false;
			}
		}catch(Exception e) {
			System.out.println("looking for sign in");
		}
	}
	//still needs work
	public void typeSignIn() {//David
		WebElement emailField = null;
		WebElement passField = null;
		
		boolean looping = true;
//		while(looping) {
//			try {
				emailField = FindByID("email", true, driver);
				passField = FindByID("password", true, driver);
//				looping = false;
//				System.out.println("ID SUCCESS!!! :D");
//			}catch(Exception e){
//				//David: Loops forever if sign in fails
//			}
//		}
		
		 
		if(emailField == null || passField == null)
		{
			List<MobileElement> editableFields = driver.findElementsByClassName("android.widget.EditText");
			Print("Result size " + editableFields.size());
			editableFields.get(0).sendKeys("eluxtester@gmail.com");
			editableFields.get(0).click();
			editableFields.get(1).click();
			editableFields.get(1).sendKeys("123456");
		}else{
			emailField.sendKeys("eluxtester@gmail.com");
			emailField.click();
			passField.sendKeys("123456");
			passField.click();

			System.out.println("Find By ID is working");
		}
	}
	
	public void clickSignIn2() {
		boolean looping = true;
		WebElement signInButton = null;
		try {
			signInButton = FindByID("sign-in--button", false, driver);
			signInButton.click();
			looping = false;
		}catch(Exception e) {
			System.out.println("Looking for signin2");
		}
	}
	
	//STEPDEF_RACFANSPEED
	
	public String checkScreen() {
		//NO APPLIANCES: add-appliance (ID)
		//RAC: 
		for(int i = 0; i < 100; i++) {
			WebElement element = null;
			try {//Mean no appliances added
				element = driver.findElementById("com.ELXSmart:id/add-appliance");
				return "ProvisionScreen";
			}catch(Exception e) {
				System.out.println("ProvisionScreen null");
			}
			try {//means we're on dehum screen
				element = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[1]");
				System.out.println("xpath works123");
				System.out.println("element get Text: " + element.getText());
				return "DehumScreen";
			}catch(Exception e) {
				System.out.println("DehumScreen null");
			}
			try {//means we're appliance list (after hitting back button)
				element = driver.findElementByXPath("	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.widget.ListView");
				System.out.println("xpath works123");
				System.out.println("element get Text: " + element.getText());
				return "ApplianceListScreen";
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("ApplianceListScreen null");
			}
		}
		//TODO add rac and strombo. try to decrease the i of for loop or replace with waitFor. Try to add navigate functionality
		return null;//shouldn't get here. 
	}
	//srt: JIHAD'S HELPER METHODS
	private MobileElement GrabFromClass(String className,int index, AndroidDriver d)
	{
		List<MobileElement> results = null;
		boolean looping = true;
		while(looping) {
			try {
				results = d.findElementsByClassName(className);
				if(results.size()>0) {

					Print("Size of " + className + " Elements: " + results.size());
					looping = false;
				}
			}catch(NullPointerException e) {
				Print("Looking for button by class: " + className);
				//loops forever if button isn't there
			}
		}
		return results.get(index);
	}
	private WebElement FindByID(String id, boolean looping, AndroidDriver d)
	{
		WebElement result = null;
		if(looping == true) {
			while(looping) {
				try
				{
					result = d.findElementById("com.ELXSmart:id/"+id);
				}
				catch(Exception e)
				{
					Print("Failed to find Element with ID:" + id);
				}
			}
		}else {
			try
			{
				result = d.findElementById("com.ELXSmart:id/"+id);
			}
			catch(Exception e)
			{
				Print("Failed to find Element with ID:" + id);
			}
		}
		return result;
		
	}
	private void SwitchWifi(String ssid)
	{
		String filePath = new File("").getAbsolutePath();
		filePath = filePath.concat("\\nasaTestSuite\\");
		//Print(filePath);
		
		String exeCommand = "cmd /c start WifiSwitcher.exe";
		String cmdLineArg = " \"" + ssid + "\"";
		String fullCommand = exeCommand + cmdLineArg;
		System.out.println(fullCommand);
		
		try 
		{	
			Runtime.getRuntime().exec(fullCommand, null, new File(filePath));
			System.out.println("Execute!");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void Sleep(int milli)
	{
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void Print(String msg)
	{
		System.out.println(msg);
	}
	//end: JIHAD'S HELPER METHODS
	
}
