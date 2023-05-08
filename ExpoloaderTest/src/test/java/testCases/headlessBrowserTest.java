package testCases;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

public class headlessBrowserTest {

	public static void main(String[] args) {
		
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		
		driver.get("https://www.expoloader.com/");
		System.out.println("Title: "+driver.getTitle());
		
		WebClient client = new WebClient();
		
		System.out.println("\nBrowser version is: "+client.getBrowserVersion());
		System.out.println("Is browser Chrome: "+client.getBrowserVersion().isChrome());
		System.out.println("Is browser Edge: "+client.getBrowserVersion().isEdge());
		System.out.println("Is browser Firefox: "+client.getBrowserVersion().isFirefox());
		
		

		

		
		
		driver.quit();
	}

}
