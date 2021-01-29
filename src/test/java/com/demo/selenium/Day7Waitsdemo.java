package com.demo.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day7Waitsdemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		WebDriver driver= new ChromeDriver();
		//driver.get();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[text()='Start']")).click();

	}

}
