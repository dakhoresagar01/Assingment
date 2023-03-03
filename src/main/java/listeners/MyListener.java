package listeners;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import base.Base;

public class MyListener extends Base implements ITestListener {
	public void onTestFailure(ITestResult result) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File img = driver.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		File file = new File(path +"/ScreenShot/fail.jpg");
		try {
			FileUtils.copyFile(img, file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
