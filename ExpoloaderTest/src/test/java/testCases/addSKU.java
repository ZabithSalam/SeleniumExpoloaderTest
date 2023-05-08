package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addSKU {

	public static WebDriver driver = mainTest.driver;

	public static void testSteps(String Name, String Width, String Length, String Height, String Weight, String SapId, String MaxLevel) {



		//Name

		WebElement name = driver.findElement(By.xpath("//*[@id=\'Sku_name\']"));
		name.sendKeys(Name);

		//Width

		WebElement width = driver.findElement(By.xpath("//*[@id=\'Sku_width\']"));
		width.sendKeys(Width);

		//Length

		WebElement length = driver.findElement(By.xpath("//*[@id=\'Sku_length\']"));
		length.sendKeys(Length);

		//Height

		WebElement height = driver.findElement(By.xpath("//*[@id=\'Sku_height\']"));
		height.sendKeys(Height);

		//Weight

		WebElement weight = driver.findElement(By.xpath("//*[@id=\'Sku_weight\']"));
		weight.sendKeys(Weight);

		//Sap ID

		WebElement sapId = driver.findElement(By.xpath("//*[@id=\'Sku_sap_id\']"));
		sapId.sendKeys(SapId);

		//Max Level

		WebElement maxLevel = driver.findElement(By.xpath("//*[@id=\'Sku_max_level\']"));
		maxLevel.sendKeys(MaxLevel);



	}
	public static void redirectToSkuPage() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement clickOptions = mainTest.driver.findElement(By.xpath("//span[contains(text(),'Options')]"));
		clickOptions.click();
		WebElement clickSKUs = mainTest.driver.findElement(By.xpath("//li[2]/div/span"));
		clickSKUs.click();
	}
	public static void clickSubmit() {

		//Click Submit

		WebElement clickSubmit = driver.findElement(By.xpath("//div[8]/div/div/div/div/button"));
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

		WebElement name = driver.findElement(By.xpath("//*[@id=\'Sku_name\']"));

		//Width

		WebElement width = driver.findElement(By.xpath("//*[@id=\'Sku_width\']"));

		//Length

		WebElement length = driver.findElement(By.xpath("//*[@id=\'Sku_length\']"));

		//Height

		WebElement height = driver.findElement(By.xpath("//*[@id=\'Sku_height\']"));

		//Weight

		WebElement weight = driver.findElement(By.xpath("//*[@id=\'Sku_weight\']"));

		//Sap ID

		WebElement sapId = driver.findElement(By.xpath("//*[@id=\'Sku_sap_id\']"));

		//Max Level

		WebElement maxLevel = driver.findElement(By.xpath("//*[@id=\'Sku_max_level\']"));

		name.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		width.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		length.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		height.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		weight.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		sapId.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		maxLevel.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);


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
		System.out.println("Test Suite: addSKU");

		redirectToSkuPage();



		deleteAll();

		//validation messages
		String alreadyExist = "name Already Exist";            
		String legnthGreaterThanWidth = "Length must be greater or equal to width";
		String emptyName = "Please input NAME!";
		String emptywidth = "Please input WIDTH!";
		String emptylegnth = "Please input LENGTH!";
		String emptyheight = "Please input HEIGHT!";
		String emptyweight = "Please input WEIGHT!";
		String emptysapID = "Please input SAP ID!";
		String emptymaxLevel = "Please input MAX LEVEL!";
		String success = "Added Successfully";



		//test cases

		//1. Empty sku dimensions
		//2. Length greater than width
		//3. Input valid dimensions & parameeters 
		//4. Nagative sku dimensions
		//5. Input valid dimensions & parameeters 2
		//6. Enter name with white spaces
		//7. Enter width with white spaces
		//8. Enter length with white spaces
		//9. Enter height with white spaces
		//10. Enter SAPID with white spaces
		//11. Enter leading white spaces in name field
		//12. Enter leading white spaces in SAPID field
		//13. Enter trailing white spaces in name field
		//14. Enter trailing white spaces in SAPID field
		//15. No duplicate sku name
		//16. No floating dimension values


		//1. Empty sku dimensions
		clickAdd();
		testSteps("","","","","","","");
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
		WebElement vrfySapId = driver.findElement(By.xpath("//div[6]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptySapIdVerify = vrfySapId.getText();
		WebElement vrfyMaxLevel = driver.findElement(By.xpath("//div[7]/div[1]/div[2]/div[2]/div[1]/div"));
		String emptyMaxLevelVerify = vrfyMaxLevel.getText();

		if(emptyNameVerify.equals(emptyName)) {
			System.out.println("\nPASSED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyNameVerify + " | Expected Result: \""+ emptyName +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyNameVerify + " | Expected Result: \""+ emptyName +"\" ");
		}
		if(emptyWidthVerify.equals(emptywidth)) {
			System.out.println("\nPASSED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyWidthVerify + " | Expected Result: \""+ emptywidth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyWidthVerify + " | Expected Result: \""+ emptywidth +"\" ");
		}
		if(emptyLegnthVerify.equals(emptylegnth)) {
			System.out.println("\nPASSED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyLegnthVerify + " | Expected Result: \""+ emptylegnth +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyLegnthVerify + " | Expected Result: \""+ emptylegnth +"\" ");
		}
		if(emptyHeightVerify.equals(emptyheight)) {
			System.out.println("\nPASSED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyHeightVerify + " | Expected Result: \""+ emptyheight +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyHeightVerify + " | Expected Result: \""+ emptyheight +"\" ");
		}
		if(emptyWeightVerify.equals(emptyweight)) {
			System.out.println("\nPASSED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyWeightVerify + " | Expected Result: \""+ emptyweight +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyWeightVerify + " | Expected Result: \""+ emptyweight +"\" ");
		}
		if(emptySapIdVerify.equals(emptysapID)) {
			System.out.println("\nPASSED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptySapIdVerify + " | Expected Result: \""+ emptysapID +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptySapIdVerify + " | Expected Result: \""+ emptysapID +"\" ");
		}
		if(emptyMaxLevelVerify.equals(emptymaxLevel)) {
			System.out.println("\nPASSED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyMaxLevelVerify + " | Expected Result: \""+ emptymaxLevel +"\" ");
		}
		else {
			System.out.println("\nFAILED | Test Case \"Empty sku dimensions\" | Actual Result: " + emptyMaxLevelVerify + " | Expected Result: \""+ emptymaxLevel +"\" ");
		}
		

		//2. Length less than width
		testSteps("SKU_1_315_220_345","315","314","220","10650","CCX60048","100");
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


		//3. Nagative sku dimensions
		testSteps("SKU_2_315_220_345","-315","-315","-220","-10650","CCX60048","-100");
		clickSubmit();
		clickAdd();


		//4. No floating dimension values
		testSteps("SKU_3_315_220_345","310.500","310.500","220.00","10.650","CCX60048","100.0");
		clickSubmit();
		clickAdd();

		//5. Input valid dimensions & parameeters 
		testSteps("SKU_4_315_220_345","315","315","220","10650","CCX60048","100");
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

		//6. No duplicate sku name
		testSteps("SKU_4_315_220_345","315","315","220","10650","CCX60048","100");
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
