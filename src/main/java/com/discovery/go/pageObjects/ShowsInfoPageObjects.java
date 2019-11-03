package com.discovery.go.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShowsInfoPageObjects {
	
	public ShowsInfoPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how=How.XPATH, using ="//img[@class='showHero__showLogo']")
	private WebElement showsTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='showHero__main']//div[@class='my-favorites-button-container']/span/i")
	private WebElement FavoriteIcon;

	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Favorite Shows')]")
	public WebElement FavouriteShows_Header;
	
	
	public WebElement getFavoriteIcon() {
		return FavoriteIcon;
	}

	public WebElement getFavouriteShows_Header() {
		return FavouriteShows_Header;
	}
	
	public WebElement getShowsTitle() {
		return showsTitle;
	}
}
