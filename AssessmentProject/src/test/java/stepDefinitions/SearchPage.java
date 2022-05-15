package stepDefinitions;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import io.cucumber.java.en.*;


public class SearchPage {
	
	WebDriver driver = null;
	
	
	@Given("User Go to Google page")
	public void user_go_to_google_page() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://google.com");
	}

	@When("user searches for Spark Networks")
	public void user_searches_for_spark_networks() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Spark Networks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("btnK")).click();
	}

	@Then("Spark networks homepage should be the first result")
	public void spark_networks_homepage_should_be_the_first_result() {
		String actualResultsText = null;
		String expectedResultsText = "Spark Networks SE | A global leading dating company";
		List<WebElement> resultsList = driver.findElements(By.xpath("//a//h3"));
		actualResultsText = resultsList.get(0).getText();
		Assert.assertEquals(actualResultsText, expectedResultsText);
		driver.quit();
	}
	
	@When("user searches for funny cat memes")
	public void user_searches_for_funny_cat_memes() {
		driver.findElement(By.name("q")).sendKeys("funny cat memes");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("btnK")).click();
	}

	@Then("results should be displayed")
	public void results_should_be_displayed() {
	    String browserURL = driver.getCurrentUrl();
	    if(browserURL.contains("search")) {
	    	Assert.assertTrue(true);
	    }else
	    {
	    	Assert.assertFalse(true);
	    }
	}

	@Then("screenshot should be taken")
	public void screenshot_should_be_taken() throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("target/homePageScreenshot.png"));
		driver.quit();
	}
}
