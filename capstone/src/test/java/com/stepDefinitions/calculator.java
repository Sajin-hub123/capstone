package com.stepDefinitions;

import java.net.MalformedURLException;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.handler.timeout.TimeoutException;
import pageObjects.BasePage;

import pageObjects.calculatorObjects;
import com.stepDefinitions.Hooks;

public class calculator extends Hooks {
	 private AppiumDriver driver;
	 private calculatorObjects calObj;
	 
	public calculator() {
       
        this.driver = Hooks.getDriver();
        if (driver == null) {
            System.out.println("Driver is null in LoginSteps constructor!");
            throw new RuntimeException("Driver is not initialized.");
        }
        this.calObj = new calculatorObjects(driver);
    }

	@Given("User is on calculator home screen")
	public void user_is_on_calculator_home_screen() throws MalformedURLException {
		setUp_app();
	}

	@When("User clicks on seven")
	public void user_clicks_on_seven() {
		//wait(By.xpath("//*[@text='7']"));
		wait(calObj.seven);
		driver.findElement(calObj.seven).click();
	}

	@When("User clicks on plus")
	public void user_clicks_on_plus() {
		WebElement plus = driver.findElement(calObj.plus);
		plus.click();
	}

	@When("User clicks on four")
	public void user_clicks_on_four() {
		WebElement eight = driver.findElement(calObj.four);
		eight.click();
	}

	@When("User clicks on equals")
	public void user_clicks_on_equals() {
		WebElement equals = driver.findElement(calObj.equals);
		equals.click();
	}

	@Then("User should see result")
	public void user_should_see_result_message() throws InterruptedException {
		wait(calObj.eleven);
		WebElement result = driver.findElement(calObj.eleven);
		boolean displayed = result.isDisplayed();
		if (displayed) {
			System.out.println("The result is 11");
		} else {
			System.out.println("The result is not 11");
		}
		tearDown();
	}

	public void wait(By byValue) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(byValue));
		} catch (TimeoutException e) 
		{
			System.out.println("Timed out");
		}
	}
}