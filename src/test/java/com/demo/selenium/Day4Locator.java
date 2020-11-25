package com.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4Locator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		WebElement useremail = driver.findElement(By.id("email"));
		useremail.sendKeys("deepikasakpal2387@yahoo.co.in");
		driver.findElement(By.name("pass")).sendKeys("dksmywish");
		driver.findElement(By.id("loginbutton")).click();
		//driver.findElement(By.linkText("Log In")).click();
		
		
		
		
		
		

	}

}
