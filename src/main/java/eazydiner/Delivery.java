package eazydiner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delivery {
	@Test
	public void testDeliveryFunctionality() {		

		//To disable notification
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
		
		//Javascript Executor
		JavascriptExecutor executor = (JavascriptExecutor)driver;

		//Click on Delivery Funtionality
		WebElement delivery = driver.findElement(By.xpath("//span[text()='Delivery']"));
		executor.executeScript("arguments[0].click();", delivery);
		
		//click on order now button
		WebElement order = driver.findElement(By.xpath("//a[@class='btn btn-primary height-40 block bold padding-10 font-14 apxor_click']"));
		executor.executeScript("arguments[0].click();", order);
		
		//select 10PM
		driver.findElement(By.xpath("//span[text()='10:00 PM']")).click();
		
		//click on continue button
		driver.findElement(By.xpath("//button[contains(text(),'Continue to book a table')]")).click();
		
		//Get the Booking summary details
		String bookingSummary = driver.findElement(By.xpath("//div[@class='bg-white bottom_content']")).getText();
		System.out.println(bookingSummary);
		
		//WebElement verifySelected = driver.findElement(By.xpath("//div[@class='flex flex-between font-15 grey-dark semi-bold']"));
		//Assert.assertEquals("Deal Selected", verifySelected);
		
		//To close the window
		driver.close();
	}

}
