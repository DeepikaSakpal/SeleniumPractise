package com.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Day3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Poco F1");
		List<WebElement> element = driver.findElements(By.className("nav-input"));
		System.out.println("elements" + element.size());
		element.get(1).click();
		driver.findElement(By.linkText("Oppo")).click();
		driver.navigate().to("https://www.guru99.com");
		driver.navigate().back();
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		String expected_title = "Amazon.in  Poco F1";

		if (actual_title.equalsIgnoreCase(expected_title)) {
			System.out.println("Test success");
		} else {
			System.out.println("test fail");
		}
		driver.close();
	}

}
