package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addPallet {
	public static WebDriver driver = mainTest.driver;

	public static void testSteps(String Name, String Width, String Length, String PalletHeight,String PalletWeight, String MaxWeight) {



		//Name

		WebElement name = driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/input"));
		name.sendKeys(Name);

		//Width

		WebElement width = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div/div[2]/input"));
		width.sendKeys(Width);

		//Length

		WebElement length = driver.findElement(By.xpath("//div[3]/div/div[2]/div/div/div/div[2]/input"));
		length.sendKeys(Length);

		//Pallet Height

		WebElement height = driver.findElement(By.xpath("//div[4]/div/div[2]/div/div/div/div[2]/input"));
		height.sendKeys(PalletHeight);

		//Pallet Weight

		WebElement weight = driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div/div[2]/input"));
		weight.sendKeys(PalletWeight);

		//Max Weight

		WebElement maxWeight = driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div/div[2]/input"));
		maxWeight.sendKeys(MaxWeight);



	}
	public static void redirectToContainerPage() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement clickOptions = mainTest.driver.findElement(By.xpath("//span[contains(text(),'Options')]"));
		clickOptions.click();
		WebElement clickSKUs = mainTest.driver.findElement(By.xpath("//li[4]/div/span"));
		clickSKUs.click();
	}
	public static void clickSubmit() {

		//Click Submit

		WebElement clickSubmit = driver.findElement(By.xpath("//div[7]/div/div/div/div/button"));
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
		

		//Pallet Height

		WebElement height = driver.findElement(By.xpath("//div[4]/div/div[2]/div/div/div/div[2]/input"));
		

		//Pallet Weight

		WebElement weight = driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div/div[2]/input"));
		

		//Max Weight

		WebElement maxWeight = driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div/div[2]/input"));
		


		name.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		width.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		length.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		height.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		weight.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
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
		System.out.println("Test Suite: addPallet");

		redirectToContainerPage();



		deleteAll();

		//validation messages
		String alreadyExist = "name Already Exist";            
		String legnthGreaterThanWidth = "Length must be greater or equal to width";
		String emptyName = "Please input NAME!";
		String emptywidth = "Please input WIDTH!";
		String emptylegnth = "Please input LENGTH!";
		String emptyheight = "Please input PALLET HEIGHT!";
		String emptyweight = "Please input PALLET WEIGHT!";
		String emptymaxweight = "Please input MAX WEIGHT!";
		String success = "Added Successfully";



		//test cases

		//1. Empty pallet dimensions
		//2. Length greater than width
		//3. Nagative pallet dimensions
		//4. No floating dimension values
		//5. Input valid dimensions & parameeters 
		//6. No duplicate pallet name


		//1. Empty pallet dimensions
		clickAdd();
		testSteps("","","","","","");
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
		WebElement vrfyWeight = driver.findElement(By.xpath("//div[5]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptyWeightVerify = vrfyWeight.getText();
		WebElement vrfyMaxWeight = driver.findElement(By.xpath("//div[6]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptyMaxWeightVerify = vrfyMaxWeight.getText();

		if(emptyNameVerify.equals(emptyName)) {
			System.out.println("\nPASSED | Test Case \"Empty pallet dimensions\" | Actual Result: " + emptyNameVerify + " | Expected Result: \""+ emptyName +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty pallet dimensions\" | Actual Result: " + emptyNameVerify + " | Expected Result: \""+ emptyName +"\" ");
		}
		if(emptyWidthVerify.equals(emptywidth)) {
			System.out.println("\nPASSED | Test Case \"Empty pallet dimensions\" | Actual Result: " + emptyWidthVerify + " | Expected Result: \""+ emptywidth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty pallet dimensions\" | Actual Result: " + emptyWidthVerify + " | Expected Result: \""+ emptywidth +"\" ");
		}
		if(emptyLegnthVerify.equals(emptylegnth)) {
			System.out.println("\nPASSED | Test Case \"Empty pallet dimensions\" | Actual Result: " + emptyLegnthVerify + " | Expected Result: \""+ emptylegnth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty pallet dimensions\" | Actual Result: " + emptyLegnthVerify + " | Expected Result: \""+ emptylegnth +"\" ");
		}
		if(emptyHeightVerify.equals(emptyheight)) {
			System.out.println("\nPASSED | Test Case \"Empty pallet dimensions\" | Actual Result: " + emptyHeightVerify + " | Expected Result: \""+ emptyheight +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty pallet dimensions\" | Actual Result: " + emptyHeightVerify + " | Expected Result: \""+ emptyheight +"\" ");
		}
		if(emptyWeightVerify.equals(emptyweight)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyWeightVerify + " | Expected Result: \""+ emptyweight +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyWeightVerify + " | Expected Result: \""+ emptyweight +"\" ");
		}
		if(emptyMaxWeightVerify.equals(emptymaxweight)) {
			System.out.println("\nPASSED | Test Case \"Empty container dimensions\" | Actual Result: " + emptyMaxWeightVerify + " | Expected Result: \""+ emptymaxweight +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyMaxWeightVerify + " | Expected Result: \""+ emptymaxweight +"\" ");
		}
		


		//2. Length less than width
		testSteps("Euro pallet","800","700","100","1000","10000");
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


		//3. Nagative pallet dimensions
		testSteps("Euro pallet","-800","-800","-100","-1000","-10000");
		clickSubmit();
		clickAdd();


		//4. No floating dimension values
		testSteps("Plastic pallet","800","1200","100","1000","10000");
		clickSubmit();
		clickAdd();

		//5. Input valid dimensions & parameeters 
		testSteps("Industrial Pallet 1","800","1200","100","1000","10000");
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

		//6. No duplicate pallet name
		testSteps("Industrial Pallet 1","800","700","100","1000","10000");
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
