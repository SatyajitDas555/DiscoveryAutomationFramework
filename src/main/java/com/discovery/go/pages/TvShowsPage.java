package com.discovery.go.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.discovery.go.pageObjects.ShowsInfoPageObjects;
import com.discovery.go.pageObjects.TvShowsPageObjects;

public class TvShowsPage {

	WebDriver driver;
	Actions actions;
	WebDriverWait wait;

	public TvShowsPage(WebDriver driver) {
		this.driver = driver;
	}

	String apolloTitleObj = "(//div[@class='allShowsGrid__tile ']/div/a[contains(@href,'apollo')])";

	public Map<String, List<String>> performFavorite_unfavorite() throws InterruptedException{

		List<String> favList = new ArrayList<String>();
		List<String> unFavList = new ArrayList<String>();
		Map<String, List<String>> favUnfavDataMap = new HashMap<String, List<String>>();

		wait = new WebDriverWait(driver, 15);

		//To verify the attribute  of favorite icon(+/-)
		TvShowsPageObjects tvShowsPageObjects = new TvShowsPageObjects(driver);
		ShowsInfoPageObjects showsInfoPageObjects = new ShowsInfoPageObjects(driver);

		int apolloShowsSize = scrollToGetApollowShows(tvShowsPageObjects.getApolloTitles());

		for(int i=1; i <= apolloShowsSize; i++) {
			apolloTitleObj = "(//div[@class='allShowsGrid__tile ']/div/a[contains(@href,'apollo')])"+"["+i+"]";
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(apolloTitleObj)));
			driver.findElement(By.xpath(apolloTitleObj)).click();
			wait.until(ExpectedConditions.elementToBeClickable(showsInfoPageObjects.getFavoriteIcon()));
			String showTitle = showsInfoPageObjects.getShowsTitle().getAttribute("alt").toLowerCase();
			String favStatus = showsInfoPageObjects.getFavoriteIcon().getAttribute("class");

			if (favStatus.contains("icon-plus")) {
				showsInfoPageObjects.getFavoriteIcon().click();
				Thread.sleep(3000);
				String IconStatus = showsInfoPageObjects.getFavoriteIcon().getAttribute("class");

				System.out.println("status after click"
						+ IconStatus);
				favList.add(showTitle);
				//Assert.assertTrue(IconStatus.contains("icon-minus"), "Icon didn't change to '-' ");
			} else if(favStatus.contains("icon-minus")) {
				showsInfoPageObjects.getFavoriteIcon().click();
				Thread.sleep(3000);
				String IconStatus = showsInfoPageObjects.getFavoriteIcon().getAttribute("class");

				System.out.println("status after click"
						+ IconStatus);
				unFavList.add(showTitle);
				//Assert.assertTrue(IconStatus.contains("icon-plus"), "Icon didn't change to '+' ");
			} 
			System.out.println("Back Start");
			if(i < apolloShowsSize)
				driver.navigate().back();
			System.out.println("Back End");
		}

		favUnfavDataMap.put("favourites", favList);
		favUnfavDataMap.put("unFavourites",unFavList);
		System.out.println("performFavouriteUnfavouriteAction : ENDED");
		return favUnfavDataMap;
	}

	public void scrollToEnd() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void pageUp() {
		actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).perform();;
	}

	public int scrollToGetApollowShows(List<WebElement>elements) {
		while(elements.size() == 0) {
			scrollToEnd();
			System.out.println("Page Up");
			pageUp();
			pageUp();
			System.out.println("Page Up complete");
		}
		System.out.println("Element Size==="+elements.size());
		return elements.size();
	}

}
