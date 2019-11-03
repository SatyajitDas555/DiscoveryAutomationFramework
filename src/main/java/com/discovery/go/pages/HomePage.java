package com.discovery.go.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.discovery.go.pageObjects.HomePageObjects;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void scrollToDisplaySeeAllShowsButton(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void navigateToTvShowsPage(){
		HomePageObjects homePageObject = new HomePageObjects(driver);
		scrollToDisplaySeeAllShowsButton(driver);
		Reporter.log("==Scroll Page to display Show All button=====",true);
		homePageObject.getShowsTab().click();
		homePageObject.getSeeAllshowsButton().click();
		Reporter.log("=====Clicked Show All button=====",true);
	}

}

