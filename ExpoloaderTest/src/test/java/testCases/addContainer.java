package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addContainer {
	public static WebDriver driver = mainTest.driver;

	public static void testSteps(String Name, String Width, String Length, String Height,String SafeWidth, String SafeLegnth, String SafeHeight, String MaxWeight) {



		//Name

		WebElement name = driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/input"));
		name.sendKeys(Name);

		//Width

		WebElement width = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div/div[2]/input"));
		width.sendKeys(Width);

		//Length

		WebElement length = driver.findElement(By.xpath("//div[3]/div/div[2]/div/div/div/div[2]/input"));
		length.sendKeys(Length);

		//Height

		WebElement height = driver.findElement(By.xpath("//div[4]/div/div[2]/div/div/div/div[2]/input"));
		height.sendKeys(Height);

		//Weight

		WebElement safeWidth = driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div/div[2]/input"));
		safeWidth.sendKeys(SafeWidth);

		//Sap ID

		WebElement safeLegnth = driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div/div[2]/input"));
		safeLegnth.sendKeys(SafeLegnth);

		//Max Level

		WebElement safeHeight = driver.findElement(By.xpath("//div[7]/div/div[2]/div/div/div/div[2]/input"));
		safeHeight.sendKeys(SafeHeight);
		
		//Max Level
		
		WebElement maxWeight = driver.findElement(By.xpath("//div[8]/div/div[2]/div/div/div/div[2]/input"));
		maxWeight.sendKeys(MaxWeight);



	}
	public static void redirectToContainerPage() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement clickOptions = mainTest.driver.findElement(By.xpath("//span[contains(text(),'Options')]"));
		clickOptions.click();
		WebElement clickSKUs = mainTest.driver.findElement(By.xpath("//li[3]/div/span"));
		clickSKUs.click();
	}
	public static void clickSubmit() {

		//Click Submit

		WebElement clickSubmit = driver.findElement(By.xpath("//div[9]/div/div/div/div/button"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", clickSubmit);
		clickSubmit.click();

	}

	public static void clickAdd() {

		//Click Add


		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement clickAdd = driver.findElement(By.xpath("//div[2]/div[1]/button"));
		clickAdd.click();
	}
	public static void clear() {

		//Name

				WebElement name = driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/input"));
				
				//Width

				WebElement width = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div/div[2]/input"));
				

				//Length

				WebElement length = driver.findElement(By.xpath("//div[3]/div/div[2]/div/div/div/div[2]/input"));
				

				//Height

				WebElement height = driver.findElement(By.xpath("//div[4]/div/div[2]/div/div/div/div[2]/input"));
				
				//Weight

				WebElement safeWidth = driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div/div[2]/input"));
				

				//Sap ID

				WebElement safeLegnth = driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div/div[2]/input"));
				

				//Max Level

				WebElement safeHeight = driver.findElement(By.xpath("//div[7]/div/div[2]/div/div/div/div[2]/input"));
				
				
				//Max Level
				
				WebElement maxWeight = driver.findElement(By.xpath("//div[8]/div/div[2]/div/div/div/div[2]/input"));
				

		name.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		width.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		length.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		height.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		safeWidth.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		safeLegnth.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		safeHeight.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		maxWeight.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);


	}
	public static void deleteAll() {
		try {


			if(driver.findElements(By.xpath("//span[contains(text(),'Delete All Records')]")).size() != 0) {
				Thread.sleep(4000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement delete = driver.findElement(By.xpath("//span[contains(text(),'Delete All Records')]"));
				delete.click();
				WebElement clickYes = driver.findElement(By.xpath("//div[2]/button[2]/span"));
				clickYes.click();
				Thread.sleep(2000);

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testCases() {

		//Test Suite
		System.out.println("Test Suite: addContainer");

		redirectToContainerPage();



		deleteAll();

		//validation messages
		String alreadyExist = "name Already Exist";            
		String legnthGreaterThanWidth = "Length must be greater or equal to width";
		String emptyName = "Please input NAME!";
		String emptywidth = "Please input WIDTH!";
		String emptylegnth = "Please input LENGTH!";
		String emptyheight = "Please input HEIGHT!";
		String emptysafewidth = "Please input SAFE WIDTH!";
		String emptysafelegnth = "Please input SAFE LENGTH!";
		String emptysafeheight = "Please input SAFE HEIGHT!";
		String emptymaxweight = "Please input MAX WEIGHT!";
		String success = "Added Successfully";



		//test cases

		//1. Empty container dimensions
		//2. Length greater than width
		//3. Nagative container dimensions
		//4. No floating dimension values
		//5. Input valid dimensions & parameeters 
	    //6. No duplicate container name
		

		//1. Empty container dimensions
		clickAdd();
		testSteps("","","","","","","","");
		clickSubmit();

		//validation locators
		WebElement vrfyName = driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptyNameVerify = vrfyName.getText();
		WebElement vrfyWidth = driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptyWidthVerify = vrfyWidth.getText();
		WebElement vrfyLegnth = driver.findElement(By.xpath("//div[3]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptyLegnthVerify = vrfyLegnth.getText();
		WebElement vrfyHeight = driver.findElement(By.xpath("//div[4]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptyHeightVerify = vrfyHeight.getText();
		WebElement vrfySafeWidth = driver.findElement(By.xpath("//div[5]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptySafeWidthVerify = vrfySafeWidth.getText();
		WebElement vrfySafeLegnth = driver.findElement(By.xpath("//div[6]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptySafelegnthVerify = vrfySafeLegnth.getText();
		WebElement vrfySafeHeight = driver.findElement(By.xpath("//div[7]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptySafeHeightVerify = vrfySafeHeight.getText();
		WebElement vrfyMaxWeight = driver.findElement(By.xpath("//div[8]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptyMaxWeightVerify = vrfyMaxWeight.getText();

		if(emptyNameVerify.equals(emptyName)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyNameVerify + " | Expected Result: \""+ emptyName +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyNameVerify + " | Expected Result: \""+ emptyName +"\" ");
		}
		if(emptyWidthVerify.equals(emptywidth)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyWidthVerify + " | Expected Result: \""+ emptywidth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyWidthVerify + " | Expected Result: \""+ emptywidth +"\" ");
		}
		if(emptyLegnthVerify.equals(emptylegnth)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyLegnthVerify + " | Expected Result: \""+ emptylegnth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyLegnthVerify + " | Expected Result: \""+ emptylegnth +"\" ");
		}
		if(emptyHeightVerify.equals(emptyheight)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyHeightVerify + " | Expected Result: \""+ emptyheight +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyHeightVerify + " | Expected Result: \""+ emptyheight +"\" ");
		}
		if(emptySafeWidthVerify.equals(emptysafewidth)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptySafeWidthVerify + " | Expected Result: \""+ emptysafewidth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty container dimensions\" | Actual Result: " + emptySafeWidthVerify + " | Expected Result: \""+ emptysafewidth +"\" ");
		}
		if(emptySafelegnthVerify.equals(emptysafelegnth)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptySafelegnthVerify + " | Expected Result: \""+ emptysafelegnth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptySafelegnthVerify + " | Expected Result: \""+ emptysafelegnth +"\" ");
		}
		if(emptySafeHeightVerify.equals(emptysafeheight)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptySafeHeightVerify + " | Expected Result: \""+ emptysafeheight +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptySafeHeightVerify + " | Expected Result: \""+ emptysafeheight +"\" ");
		}
		if(emptyMaxWeightVerify.equals(emptymaxweight)) {
			System.out.println("\nPASSED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyMaxWeightVerify + " | Expected Result: \""+ emptymaxweight +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyMaxWeightVerify + " | Expected Result: \""+ emptymaxweight +"\" ");
		}
		

		//2. Length less than width
		testSteps("20ft Standard Container","2348","2100","2392","0","0","0", "28230000");
		clickSubmit();
		WebElement vrfyLegnthGreaterThanWidth = driver.findElement(By.xpath("//div[contains(text(),'Length must be greater or equal to width')]"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String legnthGreaterVerify = vrfyLegnthGreaterThanWidth.getText();
		if(legnthGreaterVerify.equals(legnthGreaterThanWidth)) {
			System.out.println("\nPASSED | Test Case \"Length less than width\" | Actual Result: " + legnthGreaterVerify + " | Expected Result: \""+ legnthGreaterThanWidth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Length less than width\" | Actual Result: " + legnthGreaterVerify + " | Expected Result: \""+ legnthGreaterThanWidth +"\" ");
		}

		clear();


		//3. Nagative container dimensions
		testSteps("20ft Standard Container","-2348","-5900","-2392","-1","-1","-1", "-28230000");
		clickSubmit();
		clickAdd();


		//4. No floating dimension values
		testSteps("40ft Standard Container","2348.77","5900.45","2392.009","1.78","1.89","1.07", "28230000.743");
		clickSubmit();
		clickAdd();

		//5. Input valid dimensions & parameeters 
		testSteps("40ft Reefer Container","2348","5900","2392","0","0","0", "28230000");
		clickSubmit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement vrfySuccess = driver.findElement(By.xpath("//div[contains(text(),'Added Successfully')]"));
		
		String Addsuccess = vrfySuccess.getText();
		if(Addsuccess.equals(success)) {
			System.out.println("\nPASSED | Test Case \"Input valid dimensions & parameeters\" | Actual Result: " + Addsuccess + " | Expected Result: \""+ success +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"LInput valid dimensions & parameeters\" | Actual Result: " + Addsuccess + " | Expected Result: \""+ success +"\" ");
		}

		clickAdd();

		//6. No duplicate container name
		testSteps("40ft Reefer Container","2348","5900","2392","0","0","0", "28230000");
		clickSubmit();
		WebElement vrfyDuplicateName = driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[2]/div[1]/div"));
		String duplicate = vrfyDuplicateName.getText();

		if(duplicate.equals(alreadyExist)) {
			System.out.println("\nPASSED | Test Case \"Length less than width\" | Actual Result: " + duplicate + " | Expected Result: \""+ alreadyExist +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Length less than width\" | Actual Result: " + duplicate + " | Expected Result: \""+ alreadyExist +"\" ");
		}


	}

}
