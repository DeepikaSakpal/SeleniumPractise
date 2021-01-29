package stepDefinitionPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import basePractice.testBasePractise;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;


public class LoginPracticeSteps extends testBasePractise {
	
	WebDriver driver =null;
	

	@Given("^Launch the browser$")
	public void launch_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//System.out.println("opening browser");
		
	}	

	@When("^Application URL is open$")
	public void application_URL_is_open() throws Throwable {
		driver.navigate().to("http://localhost:3000/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.get();
		//System.out.println("URL opens");
	}

	@Then("^Logo is displayed on login page$")
	public void logo_is_displayed_on_login_page() throws Throwable {
		driver.findElement(By.xpath("//img[@class='MuiAvatar-img']"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("img[src='/static/media/ModifiedLogo.532d34de.png']")).isDisplayed();
		System.out.println("Logo is present");
	}
	
	@And("^slogan text displayed$")
	public void slogan_text_displayed() throws Throwable {
	    driver.findElement(By.xpath("//h2[contains(text(),'The Marketing Expert in Your Pocket.')]"));
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    if(driver.findElement(By.xpath("//h2[contains(text(),'The Marketing Expert in Your Pocket.')]")).isDisplayed())
	    	{
	    	System.out.println("slogan text is present");
	    	}
	    
	    }
	
	@Then("^Enter valid username and password$")
	public void enter_valid_username_and_password() throws Throwable {
	    driver.findElement(By.xpath("//input[@id=\"bootstrap-input\"]")).sendKeys("customer3@getnada.com");
	    
	    driver.findElement(By.xpath("//input[@class=\"MuiInputBase-input WithStyles(ForwardRef(InputBase))-input-23 MuiInputBase-inputAdornedEnd\"]")).sendKeys("Pass@1234");
	    
	}
	@Then("^User enters invalid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_invalid_and(String username, String password) throws Throwable {
       
		System.out.println("Email:"+username);
		System.out.println("Password:"+password);
		driver.findElement(By.xpath("//input[@id=\"bootstrap-input\"]")).sendKeys(username);
       
	   
	    driver.findElement(By.xpath("//input[@class=\"MuiInputBase-input WithStyles(ForwardRef(InputBase))-input-23 MuiInputBase-inputAdornedEnd\"]")).sendKeys(password);
	    
	    
	}
	
	@And("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {
		
		driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained makeStyles-submitButton-20 MuiButton-containedSecondary MuiButton-containedSizeLarge MuiButton-sizeLarge\"]")).click();
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	}
	
	@Then("^Login \"([^\"]*)\" displayed$")
	public void login_displayed(String errormessage) throws Throwable {
	   driver.findElement(By.xpath("//h6[contains(text(),\"Incorrect Email Address and/or Password\")]"));
	   String actual_error= driver.findElement(By.xpath("//h6[contains(text(),\"Incorrect Email Address and/or Password\")]")).getText();
	   System.out.println("actual error by driver:"+actual_error);
	   System.out.println("error message passed thru function:"+errormessage);
	   if(actual_error.equalsIgnoreCase(errormessage)) 
	   {
		   
		 System.out.println("Correct error message is shown.");  
	   }
	   else
	   {
		   System.out.println("something is wrong in error message.");
	   }
		   
	   
	}
	
	@When("^user enters blank email id and valid password$")
	public void user_enters_blank_email_id_and_valid_password() throws Throwable {
		 driver.findElement(By.xpath("//input[@id=\"bootstrap-input\"]")).sendKeys("");
		    
		    driver.findElement(By.xpath("//input[@class=\"MuiInputBase-input WithStyles(ForwardRef(InputBase))-input-23 MuiInputBase-inputAdornedEnd\"]")).sendKeys("Pass@1234");
		    
	}
	
	@When("^user enters valid email id and blank password$")
	public void user_enters_valid_email_id_and_blank_password() throws Throwable {
		 driver.findElement(By.xpath("//input[@id=\"bootstrap-input\"]")).sendKeys("customer3@getnada.com");
		    
		    driver.findElement(By.xpath("//input[@class=\"MuiInputBase-input WithStyles(ForwardRef(InputBase))-input-23 MuiInputBase-inputAdornedEnd\"]")).sendKeys("");
		    
	}
	
	@Then("^error message shown$")
	public void error_message_shown() throws Throwable {
		if(driver.findElement(By.xpath("//input[@id=\"bootstrap-input\"]")).getText().equalsIgnoreCase(""))
		{ 
			driver.findElement(By.xpath("//p[@class=\"MuiFormHelperText-root Mui-error\"]"));
		//	driver.findElement(By.xpath("//p[contains(text(),\"Email Address is required\")]"));
			System.out.println("Email Address is required.");
			}
		if(driver.findElement(By.xpath("//input[@class=\"MuiInputBase-input WithStyles(ForwardRef(InputBase))-input-23 MuiInputBase-inputAdornedEnd\"]")).getText().equalsIgnoreCase(""))
		{
			driver.findElement(By.xpath("//p[@class=\"MuiFormHelperText-root Mui-error\"]"));
		//driver.findElement(By.xpath("//p[contains(text(), \"Password is required\")]"));
		System.out.println("Password is required.");
		}
		
	}

	
	
	@And("^user navigates to dashboard screen$")
	public void user_navigates_to_dashboard_screen() throws Throwable {
		System.out.println("Before explicit wait");
	    System.out.println("title:"+ driver.getTitle());
	    new WebDriverWait(driver, 60).until(ExpectedConditions.titleContains("Ad Giants > Home"));
	    System.out.println("After explicit wait"+ driver.getTitle());
		if(driver.getTitle().contains("Ad Giants > Home")) {
			
			   System.out.println("User moved to dashboard page");
		   }
		   else {
			   System.out.println("error page");
		   }
		//driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained makeStyles-submitButton-20 MuiButton-containedSecondary MuiButton-containedSizeLarge MuiButton-sizeLarge\"]")).click();
		//System.out.println("Title:"+ driver.getTitle());
		   
	}
	
	@Then("^Click on forgot password link$")
	public void click_on_forgot_password_link() throws Throwable {
		
		 if(driver.findElement(By.linkText("Forgot Password?")).isDisplayed())
		    {
		    	
		    	System.out.println(" forgot password link is present");
		    	
		    }
		    else {
		    	System.out.println("Something is fishy.");
		    }
		 
		 driver.findElement(By.linkText("Forgot Password?")).click();
	    	System.out.println("clicked correctly on forgot password link");
	}
	
	@And("^Validate forgot password functionality$")
	public void validate_forgot_password_functionality() throws Throwable {
	    
	    	driver.findElement(By.linkText("Forgot Password")).click();
	    	System.out.println("clicked correctly on forgot password link");
	    	
	   
	    
	}
	
	@Then("^Page redirects to recovery screen$")
	public void page_redirects_to_recovery_screen() throws Throwable {
		
		if(driver.getTitle().contains("Ad Giants > Forgot Password")) {
	    	System.out.println("Correctly moved to recovery page.");	
	    	}
		else {
			System.out.println("fishy");
		}
	}
	
	

	
	@And("^Browser closes$")
	public void browser_closes() throws Throwable {
	driver.close();
	}

}
