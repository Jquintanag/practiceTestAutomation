package com.practicetestautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Test
public class AddFood {
	public void addFood() {
		// Create driver
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser started");
		sleep(1);
		
		//Create wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		// open URL
		String url = "https://practicetestautomation.com";
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Page is opened");
		sleep(1);
		
		//Click on practice
		WebElement practice = driver.findElement(By.xpath("//ul[@id='menu-primary-items']//a[@href='https://practicetestautomation.com/practice/']"));
		practice.click();
		sleep(1);
		
		//Click on Test Exceptions
		WebElement testExceptionButton = driver.findElement(By.xpath("/html//div[@id='loop-container']//article/div[@class='post-content']/div[2]/div[1]//a[@href='https://practicetestautomation.com/practice-test-exceptions/']"));
		testExceptionButton.click();
		sleep(1);
		
		//Click on edit
		WebElement editButton = driver.findElement(By.id("edit_btn"));
		editButton.click();
		sleep(1);
		
		//enter food
		WebElement food = driver.findElement(By.xpath("//div[@id='row1']/input[@value='Pizza']"));
		food.clear();
		food.sendKeys("Hamburguesa");
		sleep(1);
		
		//click on Save
		WebElement saveButton = driver.findElement(By.id("save_btn"));
		saveButton.click();
		sleep(1);
		
		//Click on Add
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();
		sleep(1);
		
		//enter food
		WebElement enterFood = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='rows']/div[3]/div[@class='row']/input[@type='text']")));
        enterFood.sendKeys("Cereal");
		
        //Save food
        WebElement saveFood = driver.findElement(By.xpath("//div[@id='rows']/div[3]/div[@class='row']/button[@id='save_btn']"));
        saveFood.click();
        sleep(1);
        
        driver.quit();
	
	}
	
	
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
