package com.discovery.go.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyVideosPageObjects {

	public MyVideosPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'My Videos')]")
	private WebElement MyVideos_Link;
	
	@FindBy(how=How.XPATH,using ="(//section[contains(@class,'layout-section FavoriteShowsCarousel layoutSection__main')]//h3[contains(@class,'showTileSquare__title')]/div)")
	private List<WebElement> FavoriteVideoList;
	
	@FindBy(how=How.XPATH,using ="//li[@class='dscHeaderMain__hideMobile']")
	WebElement hamBurgerMenu;
	
	@FindBy(how=How.XPATH,using = "//h2[contains(text(),'Favorite Shows')]")
	public WebElement FavouriteShows_Header;
	
	public WebElement getMyVideos_Link() {
		return MyVideos_Link;
	}

	public List<WebElement> getFavoriteVideoList() {
		return FavoriteVideoList;
	}
	
	public WebElement getHamBurgerMenu() {
		return hamBurgerMenu;
	}
	
	public WebElement getFavouriteShows_Header() {
		return FavouriteShows_Header;
	}
	
}
