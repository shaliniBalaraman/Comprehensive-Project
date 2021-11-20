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
		
		//Click on delivery option
		WebElement clickDelivery = driver.findElement(By.xpath("//div[text()='Delivery']"));
		executor.executeScript("arguments[0].click();", clickDelivery);
		
		//Check the veg manu
		driver.findElement(By.xpath("(//div[@class='slider'])[3]")).click();
		
		//click on salads
		driver.findElement(By.xpath("//div[text()='Salads']")).click();
		
		//click to add the item to order
		WebElement addItem = driver.findElement(By.xpath("(//div[@class='flex allProd']/following::span[@class='addText'])[6]"));
		addItem.click();
		
		//Conform before add to order
		WebElement add = driver.findElement(By.xpath("//button[@class='addons-btn pointer']"));
		executor.executeScript("arguments[0].click();", add);
		
		//Print selected Item from order summary
		String selectedItem = driver.findElement(By.xpath("//h6[@class='grey-darker bold font-14']")).getText();
		System.out.println(selectedItem);
		String summary = driver.findElement(By.xpath("//div[@class='orderSum w-6-12 w-lg-4-12 bg-white margin-l-20 padding-15']")).getText();
		
		//Check whether the item is added in the order summary or not
		if(summary.contains("Snow Peas & Green Bean Salad")) {
			System.out.println("Item added successfully in the order summary");
		}else {
			System.out.println("Item not added in the order summary");
		}
		
		driver.close();
	}

}
