package com.discovery.go.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TvShowsPageObjects {
	
	public TvShowsPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Tv Shows')]")
	private WebElement TvShows_Header;

	@FindBy(how=How.XPATH,using="//div[@class='allShowsGrid__tile ']/div/a[contains(@href,'apollo')]")
	private List<WebElement> apolloTitles;
	
	public WebElement getTvShows_Header() {
		return TvShows_Header;
	}

	public List<WebElement> getApolloTitles() {
		return apolloTitles;
	}


	
}
