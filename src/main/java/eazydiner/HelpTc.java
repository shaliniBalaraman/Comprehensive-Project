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

public class HelpTc {
	@Test
	public void testHelpTC() {

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

		// click on help 
		WebElement element = driver.findElement(By.xpath("//span[@id='help']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		// get the title
		String title = driver.getTitle();

		// verify that contact page is displayed or not
		Assert.assertEquals("Contact Us | EazyDiner", title);
		
		//To close the window
		driver.close();

	}

}
