package com.coursera.org.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coursera.org.Base.Base;
import com.coursera.org.Functions.identifyCourses;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class identifyCoursesTest {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();

	public class validateIdentifyCourses extends Base {
		WebDriver driver = null;

		/******************
		 * This method is used to invoking driver
		 ***********************/
		@BeforeClass(groups = "Smoke Test")
		// This method is used to invoking driver
		public void initialiseSetUp() throws IOException {
			driver = Base.createDriver();
			driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		}

		/****************** This method is use to Search Course ***********************/
		@Test(priority = 1, groups = "Smoke Test")
		public void validateSearchCourse() throws Exception {
			try {
				identifyCourses homepage = new identifyCourses(driver);
				homepage.searchCourse();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Select Language ***********************/
		@Test(priority = 2, groups = { "Smoke" })
		public void validateSelectLanguage() {
			try {
				identifyCourses homepage = new identifyCourses(driver);
				homepage.selectLanguage();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Select Level ***********************/
		@Test(priority = 3, groups = { "Smoke" })
		public void validateSelectLevel() {
			try {
				identifyCourses homepage = new identifyCourses(driver);
				homepage.selectLevel();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Validate First Course ***********************/
		@Test(priority = 4, groups = { "Smoke" })
		public void validateFirstCourse() {
			try {
				identifyCourses homepage = new identifyCourses(driver);
				homepage.firstCourse();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Validate Second Course ***********************/
		@Test(priority = 5, groups = { "Smoke" }, dependsOnMethods = "validateFirstCourse")
		public void validateSecondCourse() {
			try {
				identifyCourses homepage = new identifyCourses(driver);
				homepage.secondCourse();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Screen Shot ***********************/
		@Test(priority = 6, groups = { "Smoke" })
		public void validateScreenShot() throws InterruptedException {
			try {
				hs.takeScreenshot("Smoke");
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Quit Driver ***********************/
		@AfterClass(groups = "Smoke Test")
		public void tearDown() {
			driver.quit();
		}
	}
}