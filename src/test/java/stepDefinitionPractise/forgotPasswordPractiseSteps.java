package stepDefinitionPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import basePractice.testBasePractise;
import cucumber.api.java.en.Then;

public class forgotPasswordPractiseSteps extends testBasePractise{
	WebDriver driver=null;
	
	@Then("^Click on Forgot password link$")
	public void click_on_Forgot_password_link() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:3000/auth/login");
	    driver.findElement(By.xpath("//h5[contains(text(),\"Forgot Password?\")]")).click();
	    System.out.println("Clicked on Forgot Password link");
	    
	}
	@Then("^Forgot password page gets open$")
	public void forgot_password_page_gets_open() throws Throwable {
	    if(driver.getTitle().contains("Ad Giants > Forgot Password")) {
	    	System.out.println("Correctly moved to forgot password page.");	
	    	}
		else {
			System.out.println("wrong page.");
		}
	}
	@Then("^Enter the email id$")
	public void enter_the_email_id(String emailid) throws Throwable {
	   driver.findElement(By.xpath("//input[@id=\"bootstrap-input\"]")).sendKeys(emailid);
	}
	
	@Then("^click on Next$")
	public void click_on_Next() throws Throwable {
	    driver.findElement(By.xpath("//span[contains(text(),\"Next\")]")).click();
	}
	@Then("^temparary password is sent to email id$")
	public void temparary_password_is_sent_to_email_id() throws Throwable {
	    
	}

	
	@Then("^Click on Back$")
	public void click_on_Back() throws Throwable {
	    driver.findElement(By.xpath("//span[contains(text(),\\\"Back\\\")]")).click();
	}
	@Then("^user is redirected to Login Page$")
	public void user_is_redirected_to_Login_Page() throws Throwable {
	   if(driver.getTitle().contains("Ad Giants > Login"))
	   {
		   System.out.println("Moved to login page");
	   }
	   else
	   {
		   System.out.println("wrong");
	   }
	}
	
	@Then("^Browser close$")
	public void browser_close() throws Throwable {
	    driver.close();
	}
	

}
