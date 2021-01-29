package testRunnerPractise;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import basePractice.testBasePractise;
import cucumber.api.junit.*;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featureFiles" },
		glue = "stepDefinitionPractise",
		plugin = {
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtentReport.html",
				"html:target/cucumber-html-report", // "json:target/cucumber.json",
		// "pretty:target/cucumber-pretty.txt", // "usage:target/cucumber-usage.json",
		// "junit:target/cucumber-results.xml"
		},

		monochrome = true, 
		strict = true,

		dryRun = false
)


public class testRunnerPractiseDemo extends testBasePractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/kunalshaha/personal/deepika/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

}
