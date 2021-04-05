package samplebuild;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B9 {
	WebDriver driver;
	@BeforeClass
	public void openAmazon() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hridyanshu\\Desktop\\Study Material\\Semester 6\\Test Automation Lab\\ChromeDriver\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.in/");
	}
	@Test(priority=0)
	public void signInButton() {
		WebElement signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		assertTrue(signin.isEnabled());
		signin.click();
	}
	
	@Test(priority=1)
	public void input() {
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("hridyanshusharma@gmail.com");
		WebElement continueButton = driver.findElement(By.id("continue"));
		assertTrue(continueButton.isEnabled());
		continueButton.click();
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("******");
	}
	
	@Test(priority=2)
	public void loginButton() {
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
		assertTrue(loginButton.isEnabled());
		loginButton.click();
	}
  
	@AfterClass
	public void closeChromeWindow() {
		driver.close();
  }
}

