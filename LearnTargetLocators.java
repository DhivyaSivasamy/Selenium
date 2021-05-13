package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTargetLocators {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElementById("username").sendKeys("DemosalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Merge Leads").click();
		String parent = driver.getWindowHandle();
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		Set<String> first = driver.getWindowHandles();
		List<String> first2 = new ArrayList<String>(first);
		driver.switchTo().window(first2.get(1));
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").click();
		 driver.switchTo().window(parent);
		 
		 driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		 Set<String> second = driver.getWindowHandles();
			List<String> second2 = new ArrayList<String>(second);
			driver.switchTo().window(second2.get(1));
			driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").click();
			 driver.switchTo().window(parent);
	}

}
