package accessibility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.regex.*;

import base.Base;

public class HomePage extends Base {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Accept')]")
	private WebElement acceptButton;

	@FindBy(css = "div.mostrecent-list div.post-item div.equal_content")
	private List<WebElement> plaintiffText;

	public void verifyText() {
		acceptButton.click();
	}

	public void fetchPlaintiffDefendantText() {

		List<String> fetchPlaintiff = new ArrayList<String>();

		for (WebElement list1 : plaintiffText) {
			fetchPlaintiff.add(list1.getText());
		}
		String[] str = new String[fetchPlaintiff.size()];

		for (int i = 0; i < fetchPlaintiff.size(); i++) {
			str[i] = fetchPlaintiff.get(i);
		}
		String regex = "Plaintiff Name: (.*) Filing date:.*Defendant Name: (.*)\\.\\.\\.";
		Pattern pattern = Pattern.compile(regex);

		for (String caseString : str) {
			Matcher matcher = pattern.matcher(caseString);
			if (matcher.find()) {
				String plaintiffName = matcher.group(1);
				String defendantName = matcher.group(2);
				System.out.println("Plaintiff: " + plaintiffName);
				System.out.println("Defendant: " + defendantName);
				String d= "ANDREW TORO";
				Assert.assertEquals(d, plaintiffName);
			}
		}

	}

}
