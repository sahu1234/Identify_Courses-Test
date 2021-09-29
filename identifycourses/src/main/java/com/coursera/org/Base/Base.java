package com.coursera.org.Base;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

	public static WebDriver driver;

	/****** Invoke Browser *********/

	public static WebDriver createDriver() {

		driver = DriverSetup.setDriver();
		return driver;
	}

	/****** Open URL *********/
	public void openURL(String websiteURL) {
		driver.get(websiteURL);
	}

	/****** Refresh *********/
	public void refresh() {
		driver.navigate().refresh();
	}

	/****** Return Home *********/
	public void returnhome() {
		driver.navigate().to("https://www.coursera.org/in");
	}

	/****** Close Browser *********/
	public void tearDown() {
		driver.close();
	}

	/****** Quit Browser *********/
	public void quitBrowser() {
		driver.quit();
	}

	/****** Implicit Wait *********/
	public void implicitWait(int secs) {

		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
	/****** Finding WebElement *********/
	public WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/****** List To Map Conversion *********/
	public HashMap<String, String> convertListToString(List<String> field, List<String> count) {

		HashMap<String, String> fld_cnt = new HashMap<String, String>();

		for (int i = 0; i < field.size(); i++) {

			String fld = field.get(i);
			String cnt = count.get(i);
			fld_cnt.put(fld, cnt);
		}
		return fld_cnt;
	}

}