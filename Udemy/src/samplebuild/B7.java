package samplebuild;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B7 {

	String baseUrl = "https://www.amazon.in/";
	String driverPath = "C:\\\\Softwares\\\\chromedriver_win32\\\\chromedriver.exe";
	WebDriver chromeDri; // these variables should be declared outside any test function to be accessible
							// everywhere in class

	// BeforeTest is executed before test cases
	@BeforeTest
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		chromeDri = new ChromeDriver();
		chromeDri.get(baseUrl);
		chromeDri.manage().window().maximize();
	}

	@Test(priority = 0)
	public void titleVerify() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = chromeDri.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void clickSignin() {
		chromeDri.findElement(By.id("nav-signin-tooltip")).click();
	}

	@Test(priority = 2)
	public void enterEmail() {
		chromeDri.findElement(By.id("ap_email")).sendKeys("--email--");
	}

	@Test(priority = 3)
	public void clickContinue() {
		chromeDri.findElement(By.id("continue")).click();
	}

	@Test(priority = 4)
	public void enterPassword() {
		chromeDri.findElement(By.id("ap_password")).sendKeys("--password--");
	}

	@Test(priority = 5)
	public void signin() {
		chromeDri.findElement(By.id("signInSubmit")).click();
	}

	@AfterTest
	public void destroySession() {
		chromeDri.close();
	}
}