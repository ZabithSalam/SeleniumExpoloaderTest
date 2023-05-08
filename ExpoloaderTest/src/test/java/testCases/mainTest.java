package testCases;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.propertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class mainTest {

	public static String browser;
	public static WebDriver driver;
	public static void main(String[] args) {

		propertiesFile.readPropertiesFile();
		setBrowserConfig();
		propertiesFile.writePropertiesFile();

		driver.manage().window().maximize();
		runTest();

		driver.quit();

	}

	//setBrowser
	//setBrowserConfig
	//runTest

	//this is for to configure browsers
	public static void setBrowserConfig(){

		if(browser.contains("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(browser.contains("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}

	public static void runTest() {
		//signIn
		signIn.testCases();
		//add SKU	
		addSKU.testCases();
		//add Container
		addContainer.testCases();
		//addPallet
		addPallet.testCases();

	}


}
