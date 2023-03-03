package com.assingment.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import accessibility.HomePage;
import base.Base;
import listeners.MyListener;

@Listeners(MyListener.class)
public class PlaintiffDefendantExtractor extends Base {
	HomePage home;

	@Test
	public void verifyText() {
		home = new HomePage();
		home.verifyText();
		driver.executeScript("window.scrollBy(0,250)");
		home.fetchPlaintiffDefendantText();

	}
}
