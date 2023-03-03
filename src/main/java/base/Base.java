package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class Base {
	public static final String URL="https://www.accessibility.com/digital-lawsuits";
	public static RemoteWebDriver driver;
	@BeforeTest
	public void openBrowser() {
		driver= new ChromeDriver();
		driver.get(URL);
		

	}

}
