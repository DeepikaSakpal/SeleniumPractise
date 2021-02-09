package stepDefinitionPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePractice.testBasePractise;
import cucumber.api.java.en.And;
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
	public void enter_the_email_id() throws Throwable {
	   driver.findElement(By.xpath("//input[@id=\"bootstrap-input\"]")).sendKeys("customer3@getnada.com");
	   System.out.println("emailid entered");
	}
	
	@Then("^click on Next$")
	public void click_on_Next() throws Throwable {
	    driver.findElement(By.xpath("//span[contains(text(),\"Next\")]")).click();
	    System.out.println("click on next");
	}
	@Then("^User is redirected to Recover Password page$")
	public void user_is_redirected_to_Recover_Password_page() throws Throwable {
		new WebDriverWait(driver, 60).until(ExpectedConditions.titleContains("Ad Giants > Recover Password"));
	    if(driver.getTitle().contains("Ad Giants > Recover Password")) {
	    	System.out.println("Correctly moved to Recover password page");
	    }
	    else {
	    	System.out.println("not correct page");
	    }
	}
	@Then("^User can see some instruction text$")
	public void user_can_see_some_instruction_text() throws Throwable {
	   // Boolean textvisible =driver.findElement(By.xpath("//p[@class=\"MuiTypography-root makeStyles-typography-79 MuiTypography-body2 MuiTypography-gutterBottom\"]")).isDisplayed();
	    Boolean textvisible =driver.findElement(By.xpath("//h2[@class=\"MuiTypography-root MuiTypography-h2 MuiTypography-gutterBottom\"]")).isDisplayed();
	  //h2[@class="MuiTypography-root MuiTypography-h2 MuiTypography-gutterBottom"]
	    //Boolean textvisible =driver.findElement(By.xpath(null))
		if(textvisible) {
	    	System.out.println("recover password text is visible");
	    }
	    else {
	    	System.out.println("text is not visible");
	    }
	}
	@Then("^user click on Click Here link$")
	public void user_click_on_Click_Here_link() throws Throwable {
	    driver.findElement(By.xpath("//a[@class=\"MuiTypography-root MuiLink-root MuiLink-underlineAlways MuiTypography-colorSecondary\"]")).click();
	    System.out.println("rediect to login page");
	    
	}
	
	

	@Then("^Click on Back$")
	public void click_on_Back() throws Throwable {
	   // driver.findElement(By.xpath("//span[contains(text(),\\\"Back\\\")]")).click();
	    driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-containedSizeLarge MuiButton-sizeLarge\"]")).click();
		 System.out.println("back button clicked"); 
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
	
	@And("^Browser close$")
	public void browser_close() throws Throwable {
		System.out.println("window gets closed");
	    driver.quit();
	}
	

}
