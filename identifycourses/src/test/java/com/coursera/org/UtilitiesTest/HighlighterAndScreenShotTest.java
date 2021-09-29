package com.coursera.org.UtilitiesTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.coursera.org.Base.Base;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class HighlighterAndScreenShotTest {

	@Test
	public void hightlightAndTakeScreenShot() {

		try {
			Base base = new Base();
			HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();

			Base.createDriver();
			System.out.println("Browser opened and URL loaded");
			WebElement searchbox = base
					.findElementByXpath("//input[@type='text' and @placeholder='What do you want to learn?']");

			hs.highlighttElements(searchbox);
			System.out.println("Element Highlighted");
			hs.takeScreenshot("TestSS1");
			System.out.println("Screen shot taken");
			base.quitBrowser();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
