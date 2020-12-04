package com.demo.selenium;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day6waits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		WebDriver driver= new ChromeDriver();
		//driver.get();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://in.yahoo.com/?p=us");
		driver.findElement(By.xpath("//a[@id='header-signin-link']")).click();
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("sakpal_deepika@yahoo.com");
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		System.out.println("enter passcode");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='code-box txt-align-center validation ']")).sendKeys("SKRQKHPV");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@name='verify']")).click();
		driver.findElement(By.xpath("//a[@id='header-mail-button']")).click();
		
		
		
		


	}

}
