package com.practicetestautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn {
	
	@Test
	public void logIn() {
		//Create driver
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser started");
		sleep(1);
		
		//open URL
		String url = "https://practicetestautomation.com";
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Page is opened");
		sleep(1);
		
		//Click on practice
		WebElement practice = driver.findElement(By.xpath("//ul[@id='menu-primary-items']//a[@href='https://practicetestautomation.com/practice/']"));
		practice.click();
		sleep(1);
		
		//Click on TestLoginPage
		WebElement testLoginButton = driver.findElement(By.xpath("/html//div[@id='loop-container']//article/div[@class='post-content']/div[1]/div[1]//a[@href='https://practicetestautomation.com/practice-test-login/']"));
		testLoginButton.click();
		sleep(1);
		
		//Enter username
		WebElement username = driver.findElement(By.xpath("/html//input[@id='username']"));
		username.sendKeys("student");
		sleep(1);
		
		//Enter password
		WebElement password = driver.findElement(By.xpath("/html//input[@id='password']"));
		password.sendKeys("Password123");
		
		//Click on login 
		WebElement SubmitButton = driver.findElement(By.id("submit"));
		SubmitButton.click();	
		sleep(1);
		
		System.out.println(driver.getPageSource());
		
		//SuccesfulMessage
		WebElement succesfulMessage = driver.findElement(By.xpath("//div[@id='loop-container']//article//h1[@class='post-title']"));
		String actualMessage = succesfulMessage.getText();
		String ExpectedMessage = "Logged In Successfully";
		Assert.assertTrue(actualMessage.contains(ExpectedMessage),"Actual meesage doesn't match");
		sleep(1);
		
		
		//Click on Logout
		WebElement LogOutButton = driver.findElement(By.xpath("/html//div[@id='loop-container']/div/article//a[@href='https://practicetestautomation.com/practice-test-login/']"));
		LogOutButton.click();
		sleep(1);
		
		
		//Close driver
		driver.quit();
	}
	
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		}catch(InterruptedException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
