package nasaTestSuite;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Dehum extends FrigiDriver{
	Date timer;
	int humidity;//0 means cont
	int fanSpeed; //0 lo 1 hi
	String name;
	int notifications; //0 off 1 on
	String timeZone;
	AndroidDriver driver;
	

	public Dehum(AndroidDriver driver, int implicitTime) {
		this.driver = driver;
		// TODO do i need to update appstart boolean?
	}
	


	//Humidity PLUS
	public void clickHumidPlus() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyXPath.humidPlusButton)));
		WebElement humidPlusElm = findByXPath(MyXPath.humidPlusButton, false, driver);
		humidPlusElm.click();
	}
	
	//Humidity MINUS
	public void clickHumidMinus() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyXPath.humidMinusButton)));
		WebElement humidPlusElm = findByXPath(MyXPath.humidMinusButton, false, driver);
		humidPlusElm.click();
	}
	
	//Humidity Speed Down
	public void clickHumidSpeedUp() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyXPath.dSpeedUp)));
		WebElement humidPlusElm = findByXPath(MyXPath.dSpeedUp, false, driver);
		humidPlusElm.click();
	}
	
	//Humidity Speed Down
	public void clickHumidSpeedDown() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyXPath.dSpeedDown)));
		WebElement humidPlusElm = findByXPath(MyXPath.dSpeedDown, false, driver);
		humidPlusElm.click();
	}
	
	//State
	public void checkHumidity() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyXPath.targHumidity)));
		WebElement elem  = findByXPath(MyXPath.targHumidity, false, driver);
		System.out.println("Humidity: " + getText(elem));
		//TODO hi! add logic for CONT
		humidity = Integer.parseInt(getText(elem));
	}
	
}
