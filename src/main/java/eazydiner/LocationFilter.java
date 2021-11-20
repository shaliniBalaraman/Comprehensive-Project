package eazydiner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocationFilter {
	@Test
	public void testLocationFilter() {

		// To disable notification
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");

		// We’ll start with initializing the browser driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(ch);

		// Maximise window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// load URL
		driver.get("https://www.eazydiner.com/");

		// click on location filter
		WebElement filter = driver.findElement(By.xpath("//a[@id='srchbar']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", filter);

		// Select Bengaluru in location filter
		WebElement location = driver.findElement(By.xpath("//div[text()='Bengaluru']"));
		executor.executeScript("arguments[0].click();", location);

		// Click on search button
		WebElement search = driver.findElement(By.xpath("//span[text()='Search']"));
		executor.executeScript("arguments[0].click();", search);

		// To verify that Bengaluru Restaurents are showed or not
		String getText = driver.findElement(By.xpath("//h1[@class='font-18 grey semi-bold']")).getText();
		System.out.println(getText);
		Assert.assertEquals("Bengaluru Restaurants", getText);

		// To close the window
		driver.close();
	}

}
