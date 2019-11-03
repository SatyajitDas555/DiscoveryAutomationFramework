package com.discovery.go.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Shows')]")
	private WebElement showsTab;

	@FindBy(how=How.LINK_TEXT,using="See All Shows")
	private WebElement SeeAllshowsButton;
	
	

	public WebElement getShowsTab() {
		return showsTab;
	}

	public WebElement getSeeAllshowsButton() {
		return SeeAllshowsButton;
	}

	
}


