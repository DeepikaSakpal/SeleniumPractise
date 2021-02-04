package stepDefinitionPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePractice.testBasePractise;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignoutPractiseSteps extends testBasePractise {

	WebDriver driver=null;
	
		
		@When("^user is logged in successfully and redirected to Dashboard$")
		public void user_is_logged_in_successfully_and_redirected_to_Dashboard() throws Throwable {
			System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.navigate().to("http://localhost:3000/auth/login");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id=\"bootstrap-input\"]")).sendKeys("customer3@getnada.com");    
			driver.findElement(By.xpath("//input[@class=\"MuiInputBase-input WithStyles(ForwardRef(InputBase))-input-23 MuiInputBase-inputAdornedEnd\"]")).sendKeys("Pass@1234");
			driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained makeStyles-submitButton-20 MuiButton-containedSecondary MuiButton-containedSizeLarge MuiButton-sizeLarge\"]")).click();
		        
		}

		@Then("^Profile icon should be shown to the top right corner$")
		public void profile_icon_should_be_shown_to_the_top_right_corner() throws Throwable {
		    driver.findElement(By.xpath("//img[@class=\"makeStyles-order-697\"]"));
		    if(driver.findElement(By.xpath("//img[@class=\"makeStyles-order-697\"]")).isDisplayed())
		    {
		    	System.out.println("Profile icon is displayed ");
		    }
		    else
		    {
		    	System.out.println("icon is not shown");
		    }
		}

		@When("^User click on profile icon$")
		public void user_click_on_profile_icon() throws Throwable {
			driver.findElement(By.xpath("//img[@class=\"makeStyles-order-697\"]")).click();
			
		}

		@And("^user click on Sign Out Link$")
		public void user_click_on_Sign_Out_Link() throws Throwable {
		    driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
		}

		@Then("^user is signed out from application successfully$")
		public void user_is_signed_out_from_application_successfully() throws Throwable {
			new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains("Ad Giants > Login"));
		    
			if(driver.getTitle().contains("Ad Giants > Login")) {
				System.out.println("title:"+driver.getTitle());
				   System.out.println("User moved to Login page");
			   }
			else {
				   System.out.println("something went wrong.");
			   }
		}
		@And("^Browser get close$")
		public void browser_get_close() throws Throwable {
		driver.close();
		}
		

	}

