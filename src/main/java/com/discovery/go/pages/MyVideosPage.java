package com.discovery.go.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.discovery.go.pageObjects.MyVideosPageObjects;

public class MyVideosPage {

	WebDriver driver;
	String favMyVideosObject = "(//section[contains(@class,'layout-section FavoriteShowsCarousel layoutSection__main')]//h3[contains(@class,'showTileSquare__title')]/div)[%d]";

	public MyVideosPage(WebDriver driver) {
		this.driver = driver;

	}

	public void myVedioPage() {

		MyVideosPageObjects myVideosPageObjects = new MyVideosPageObjects(driver);
		myVideosPageObjects.getHamBurgerMenu().click();
		myVideosPageObjects.getMyVideos_Link().click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(myVideosPageObjects.getFavouriteShows_Header()));
	}

	public List<String> getFavouriteVideoList() {

		MyVideosPageObjects myVideosPageObjects = new MyVideosPageObjects(driver);
		Actions actions = new Actions(driver);

		int numberOf_FavVideos = myVideosPageObjects.getFavoriteVideoList().size();
		List<String> favouriteMyVideosList = new ArrayList<String>();
		for (int i = 1; i <= numberOf_FavVideos; i++) {
			WebElement favouriteVideoElement = driver.findElement(By.xpath(favMyVideosObject.replace("%d", String.valueOf(i))));
			actions.moveToElement(favouriteVideoElement).perform();
			String favouriteMyVideoTitle = driver
					.findElement(By.xpath(favMyVideosObject.replace("%d", String.valueOf(i)))).getText().toLowerCase();
			favouriteMyVideosList.add(favouriteMyVideoTitle);
		}
		Reporter.log("==Getting Favorite Vedio List=====",true);
		System.out.println("Favourite Video List :" +favouriteMyVideosList);
		return favouriteMyVideosList;
	}

	public void validateFavAndUnfavVideos(Map<String, List<String>> favUnfavDataMap)throws Exception{
		SoftAssert softAssert = new SoftAssert();
		List<String> favouriteMyVideosList = getFavouriteVideoList();

		List<String> favList = favUnfavDataMap.get("favourites");
		System.out.println("Fav list===="+favList);
		softAssert.assertTrue(favouriteMyVideosList.containsAll(favList), "Favorite titles are not in \"FAVORITE SHOWS\" ");

		List<String> unFavList = favUnfavDataMap.get("unFavourites"); 
		System.out.println("Unfavlist====="+unFavList);
		for(String unfav: unFavList) {
			softAssert.assertFalse(favouriteMyVideosList.contains(unfav), "Unfavorite titles are in \"FAVORITE SHOWS\" ");
		}
		softAssert.assertAll();
	}
}


