package basePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testBasePractise {
	
	public static WebDriver driver = null;
	
	public testBasePractise() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:3000/auth/login");

	}

}
