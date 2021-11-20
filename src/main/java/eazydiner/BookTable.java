package eazydiner;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookTable {
	@Test
	public void bookTable() {

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

		// Javascript executor to run click operation
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		// Click on book table
		WebElement bookTable = driver.findElement(By.xpath("//span[text()='Book a Table']"));
		executor.executeScript("arguments[0].click();", bookTable);

		// click book table for the first restautent
		driver.findElement(By.xpath("//a[text()=' Book a table ']")).click();

		// Select guest 3
		driver.findElement(By.xpath("//option[text()='  3 Guests']")).click();

		// Click on continue button to book a table
		driver.findElement(By.xpath("//button[contains(text(),'Continue to book a table')]")).click();

		// Booking summary
		String summary = driver.findElement(By.xpath("//div[@id='checkout_right']")).getText();
		String guest = driver.findElement(By.xpath("//div[@class='margin-b-10 margin-t-10 text-center lh-25 flex-1']"))
				.getText();

		// Check whether the item is added in the booking summary or not
		if (summary.contains(guest)) {
			System.out.println("Item added successfully in the booking summary");
		} else {
			System.out.println("Item not added in the booking summary");
		}

		// To close the window
		driver.close();

	}

}
