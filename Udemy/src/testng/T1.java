package testng;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T1 {
	WebDriver driver;

	@BeforeClass
	public void openAmazon() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.Udemy.com/");
		Thread.sleep(5000);
	}

	@Test(priority = 0)
	public void signInButton() {
		WebElement signin = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[7]/a"));
		assertTrue(signin.isEnabled());
		signin.click();
	}

	@Test(priority = 1)
	public void input() {
		WebElement name = driver.findElement(By.id("id_fullname"));
		name.sendKeys("Harshil Bhardwaj");
		WebElement email = driver.findElement(By.id("email--1"));
		email.sendKeys("500068580@stu.upes.ac.in");
		WebElement continueButton = driver.findElement(By.id("submit-id-submit"));
		assertTrue(continueButton.isEnabled());
		continueButton.click();
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
	}

	@Test(priority = 2)
	public void loginButton() {
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
		assertTrue(loginButton.isEnabled());
		loginButton.click();
	}

	@AfterClass
	public void closeChromeWindow() {
		driver.close();
		driver.quit();
	}
}
