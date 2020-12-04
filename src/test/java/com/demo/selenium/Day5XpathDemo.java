package com.demo.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day5XpathDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("boys haircut");
		//driver.findElement(By.xpath("//input[@name='btnK']")).click();
		//driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).click();
		List<WebElement> element = driver.findElements(By.xpath("//input[@name='btnK']"));
		element.get(1).click();
		driver.findElement(By.linkText("curly")).click();
		

	}

}
