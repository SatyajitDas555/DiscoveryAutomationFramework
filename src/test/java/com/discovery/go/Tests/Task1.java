package com.discovery.go.Tests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.discovery.go.base.UserBaseTest;
import com.discovery.go.pages.HomePage;
import com.discovery.go.pages.MyVideosPage;
import com.discovery.go.pages.TvShowsPage;
import com.relevantcodes.extentreports.LogStatus;

public class Task1 extends UserBaseTest{

	/**
	 * Test script for Task1
	 */
	@Test
	public void testTaskOne() throws Exception{
		HomePage homePage = new HomePage(driver);
		TvShowsPage tvShowsPage = new TvShowsPage(driver);
		MyVideosPage myVideoPage = new MyVideosPage(driver);
		
		homePage.navigateToTvShowsPage();
		report.info("Navigate to All Shows");
		Map<String, List<String>> map = tvShowsPage.performFavorite_unfavorite();
		report.info("Perform Fav and Unfav shows list");
		myVideoPage.myVedioPage();
		report.info("Navigate to MyVideos Page");
		myVideoPage.validateFavAndUnfavVideos(map);
		report.log(Status.PASS, "Fav and Unfav are validated");
	}
}