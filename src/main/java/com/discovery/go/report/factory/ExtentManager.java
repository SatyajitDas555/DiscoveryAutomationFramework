package com.discovery.go.report.factory;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.discovery.go.common.utilities.PropertyHandler;


public class ExtentManager {

	private static PropertyHandler configurationManager;
	private static ExtentReports extent;
	static Date date = new Date() ;
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
	private static String filePath = System.getProperty("user.dir") + "/target/ExtentReports" + dateFormat.format(date)+".html";

	private static ExtentHtmlReporter getHtmlReporter() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);

		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/src/main/resources/extent.xml");
		htmlReporter.config().setDocumentTitle("Discovery Execution Report");
		htmlReporter.config().setReportName("Discovery Automation");
		htmlReporter.config().setTheme(Theme.STANDARD);
		return htmlReporter;
	}

	public static ExtentReports getExtent() {
		if (extent == null) {
			try {
				configurationManager = PropertyHandler.getInstance();
				extent = new ExtentReports();
				extent.attachReporter(getHtmlReporter());
				return extent;
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return extent;

	}
}
