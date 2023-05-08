package testCases;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * test: signIn
 * @author Zabith
 */
public class signIn {


	//to click the signin button
	public static void clickLoginButton() {
		WebElement loginButton = mainTest.driver.findElement(By.xpath("//div[4]/button"));
		loginButton.click();
	}

	//clear the text field
	public static void clear() {
		//Email
		WebElement emailField = mainTest.driver.findElement(By.xpath("//div[1]/div/div/input"));        

		//Password
		WebElement pswdField = mainTest.driver.findElement(By.xpath("//div[2]/div/div/input"));

		emailField.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		pswdField.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	}

	//test steps
	public static void testSteps(String email, String password) {

		WebElement emailField = mainTest.driver.findElement(By.xpath("//div[1]/div/div/input"));        

		//Password
		WebElement pswdField = mainTest.driver.findElement(By.xpath("//div[2]/div/div/input"));

		emailField.sendKeys(email);
		pswdField.sendKeys(password);
	}
	public static void testCases() {

		//navigate to sign in page
		mainTest.driver.get("https://app.expoloader.com/");
		
		//Test Suite
		System.out.println("Test Suite: signIn");


		//validation messages
		String emptyEmail = "Please enter Email Address!";            
		String emptyPswd = "Please enter Password!";
		String invalidEmail = "The Email you entered is not a valid format!";
		String numbersOnly = "Password should be at least One letter";
		String capital = "Password should be at least one capital letter";
		String shortPswd = "Password is too short - should be 6 characters minimum.";
		String special = "Need one special character";
		String simple = "Password should be at least one simple letter";
		String incorrectPswd = "Wrong Email or Password";

		//validation locators
		By vrfyEmailLocator = By.xpath("//div[1]/div/p");
		By vrfyPswdLocator = By.xpath("//div[2]/div/p");
		By pswdIncorrectLocator = By.xpath("//div[contains(text(),'Wrong Email or Password')]");
		By verifyLoggedIn = By.xpath("//div[3]/button/span");



		mainTest.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//test cases

		//1. Enter empty sign in credencials
		//2. Enter email in invalid format
		//5. Enter password (numbers only)
		//6. Enter short password (below 6 charactors)
		//7. Enter password without special charactors
		//8. Enter password without capital letter
		//9. Enter password without simple letter
		//10. Enter email with white spaces
		//11. Enter leading white spaces in email
		//12. Enter trailing white spaces in email       
		//13. Enter registered email and incorrect password
		//14. Correct signIn credentials

		//1. Enter empty sign in credencials
		testSteps("","");
		clickLoginButton();

		WebElement vrfyEmail = mainTest.driver.findElement(vrfyEmailLocator);
		WebElement vrfyPassword = mainTest.driver.findElement(vrfyPswdLocator);

		//getting text of the validation message to print
		String emailverify = vrfyEmail.getText();
		String pswdverify = vrfyPassword.getText();

		if(emailverify.equals(emptyEmail) && pswdverify.equals(emptyPswd)) {
			System.out.println("\nPASSED | Test Case \"Enter empty sign in credencials\" | Actual Result: " + emailverify + " | Expected Result: \""+ emptyEmail +"\"");
			System.out.println("PASSED | Test Case \"Enter empty sign in credencials\" | Actual Result: " + pswdverify + " | Expected Result: \""+ emptyPswd +"\"");
		}
		else if(emailverify.equals(emptyEmail) && !pswdverify.equals(emptyPswd)){
			System.out.println("\nPASSED | Test Case \"Enter empty sign in credencials\" | Actual Result: " + emailverify + " | Expected Result: \""+ emptyEmail +"\"");
			System.out.println("FAILED | Test Case \"Enter empty sign in credencials\" | Actual Result: " + pswdverify + " | Expected Result: \""+ emptyPswd +"\" ");
		}
		else if(!emailverify.equals(emptyEmail) && pswdverify.equals(emptyPswd)) {
			System.out.println("\nFAILED | Test Case \"Enter empty sign in credencials\" | Actual Result: " + emailverify + " | Expected Result: \""+ emptyEmail +"\" ");
			System.out.println("PASSED | Test Case \"Enter empty sign in credencials\" | Actual Result: " + pswdverify + " | Expected Result: \""+ emptyPswd +"\" ");
		}

		clear();

		//2. Enter invalid email
		testSteps("mohamedzabith3gmail.com", "Tv567567@");
		clickLoginButton();

		WebElement vrfyEmail2 = mainTest.driver.findElement(vrfyEmailLocator);
		//getting text of the validation message to print
		String emailverify2 = vrfyEmail2.getText();

		if(emailverify2.equals(invalidEmail)) {
			System.out.println("\nPASSED | Test Case \"Enter invalid email\" | Actual Result: " + emailverify2 + " | Expected Result: \""+ invalidEmail +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter invalid email\" | Actual Result: " + emailverify2 + " | Expected Result: \""+ invalidEmail +"\" ");
		}
		clear();

		//5. Enter password (numbers only)
		testSteps("mohamedzabith3@gmail.com", "123456");
		clickLoginButton();

		WebElement vrfyPassword2 = mainTest.driver.findElement(vrfyPswdLocator);
		//getting text of the validation message to print
		String pswdverify3 = vrfyPassword2.getText();

		if(pswdverify3.equals(numbersOnly)) {
			System.out.println("\nPASSED | Test Case \"Enter password (numbers only)\" | Actual Result: " + pswdverify3 + " | Expected Result: \""+ numbersOnly +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter password (numbers only)\" | Actual Result: " + pswdverify3 + " | Expected Result: \""+ numbersOnly +"\" ");
		}


		clear();

		//6. Enter short password (below 6 charactors)
		testSteps("mohamedzabith3@gmail.com", "Zab@2");
		clickLoginButton();

		WebElement vrfyPassword3 = mainTest.driver.findElement(vrfyPswdLocator);
		String pswdverify4 = vrfyPassword3.getText();
		if(pswdverify4.equals(shortPswd)) {
			System.out.println("\nPASSED | Test Case \"Enter short password (below 6 charactors)\" | Actual Result: " + pswdverify4 + " | Expected Result: \""+ shortPswd +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter short password (below 6 charactors)\" | Actual Result: " + pswdverify4 + " | Expected Result: \""+ shortPswd +"\" ");
		}


		clear();

		//7. Enter password without special charactors
		testSteps("mohamedzabith3@gmail.com", "Zabi20");
		clickLoginButton();
		WebElement vrfyPassword4 = mainTest.driver.findElement(vrfyPswdLocator);
		String pswdverify5 = vrfyPassword4.getText();
		if(pswdverify5.equals(special)) {
			System.out.println("\nPASSED | Test Case \"Enter password without special charactors\" | Actual Result: " + pswdverify5 + " | Expected Result: \""+ special +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter password without special charactors\" | Actual Result: " + pswdverify5 + " | Expected Result: \""+ special +"\" ");
		}


		clear();

		//8. Enter password without capital letter
		testSteps("mohamedzabith3@gmail.com", "zab@20");
		clickLoginButton();
		WebElement vrfyPassword5 = mainTest.driver.findElement(vrfyPswdLocator);
		String pswdverify6 = vrfyPassword5.getText();
		if(pswdverify6.equals(capital)) {
			System.out.println("\nPASSED | Test Case \"Enter password without capital letter\" | Actual Result: " + pswdverify6 + " | Expected Result: \""+ capital +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter password without capital letter\" | Actual Result: " + pswdverify6 + " | Expected Result: \""+ capital +"\" ");
		}


		clear();

		//9. Enter password without simple letter
		testSteps("mohamedzabith3@gmail.com", "ZAB@20");
		clickLoginButton();
		WebElement vrfyPassword6 = mainTest.driver.findElement(vrfyPswdLocator);
		String pswdverify7 = vrfyPassword6.getText();
		if(pswdverify7.equals(simple)) {
			System.out.println("\nPASSED | Test Case \"Enter password without simple letter\" | Actual Result: " + pswdverify7 + " | Expected Result: \""+ simple +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter password without simple letter\" | Actual Result: " + pswdverify7 + " | Expected Result: \""+ simple +"\" ");
		}

		clear();

		//10. Enter email with white spaces
		testSteps("mohamed zabith3@gmail.com", "Tv999999#");
		clickLoginButton();
		WebElement vrfyEmail3 = mainTest.driver.findElement(vrfyEmailLocator);
		String emailverify8 = vrfyEmail3.getText();
		if(emailverify8.equals(invalidEmail)) {
			System.out.println("\nPASSED | Test Case \"Enter email with white spaces\" | Actual Result: " + emailverify8 + " | Expected Result: \""+ invalidEmail +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter email with white spaces\" | Actual Result: " + emailverify8 + " | Expected Result: \""+ invalidEmail +"\" ");
		}

		clear();

		//11. Enter leading white spaces in email
		testSteps("  mohamedzabith3@gmail.com", "Tv999999#");
		clickLoginButton();
		WebElement vrfyEmail4 = mainTest.driver.findElement(vrfyEmailLocator);
		String emailverify9 = vrfyEmail4.getText();
		if(emailverify9.equals(invalidEmail)) {
			System.out.println("\nPASSED | Test Case \"Enter leading white spaces in email\" | Actual Result: " + emailverify9 + " | Expected Result: \""+ invalidEmail +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter leading white spaces in email\" | Actual Result: " + emailverify9 + " | Expected Result: \""+ invalidEmail +"\" ");
		}


		clear();

		//12. Enter trailing white spaces in email
		testSteps("mohamedzabith3@gmail.com    ", "Tv999999#");
		clickLoginButton();
		WebElement vrfyEmail5 = mainTest.driver.findElement(vrfyEmailLocator);
		String emailverify10 = vrfyEmail5.getText();
		if(emailverify10.equals(invalidEmail)) {
			System.out.println("\nPASSED | Test Case \"Enter trailing white spaces in email\" | Actual Result: " + emailverify10 + " | Expected Result: \""+ invalidEmail +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter trailing white spaces in email\" | Actual Result: " + emailverify10 + " | Expected Result: \""+ invalidEmail +"\" ");
		}


		clear();

		//13. Enter registered email  and incorrect password
		testSteps("mohamedzabith3@gmail.com", "Zabith@333");
		clickLoginButton();

		mainTest.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement vrfyIncorrectPswd = mainTest.driver.findElement(pswdIncorrectLocator);
		String pswdIncorrect = vrfyIncorrectPswd.getText();
		if(incorrectPswd.equals(pswdIncorrect)) {
			System.out.println("\nPASSED | Test Case \"Enter registered email  and incorrect password\" | Actual Result: " + incorrectPswd + " | Expected Result: \""+ pswdIncorrect +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter registered email  and incorrect password\" | Actual Result: " + incorrectPswd + " | Expected Result: \""+ pswdIncorrect +"\" ");
		}

		clear();

		//14. Correct signIn credentials
		testSteps("mohamedzabith3@gmail.com", "Zabith@123");
		clickLoginButton();

		mainTest.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement verifyLogin = mainTest.driver.findElement(pswdIncorrectLocator);
		String email = "mohamedzabith3@gmail.com";
		String loginVrfy = verifyLogin.getText();
		if(loginVrfy.equals(email)) {
			System.out.println("\nPASSED | Test Case \"Enter registered email  and incorrect password\" | Actual Result: " + loginVrfy + " | Expected Result: \""+ email +"\"");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Enter registered email  and incorrect password\" | Actual Result: " + loginVrfy + " | Expected Result: \""+ email +"\" ");
		}



	}




}
