package testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T3 {

	WebDriver driver;

	@BeforeClass
	public void openAmazon() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.udemy.com/");
		Thread.sleep(5000);
	}

	@Test(priority = 1, alwaysRun = true)
	public void search() {
		WebElement searchbar = driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[3]/div[2]/form/input[2]"));
		searchbar.sendKeys("unreal engine");
		WebElement searchbutton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[2]/form/button"));
		searchbutton.click();
	}

	@Test(priority = 2)
	public void nextTab() {
		WebElement course = driver.findElement(By.xpath(
				"/html/body/div[2]/div[3]/div/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/a/div/div[2]/div[1]"));
		assertTrue(course.isEnabled());
		course.click();
		ArrayList<String> Tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("no of Tabs " + Tabs);
		driver.switchTo().window(Tabs.get(1));
	}

	@Test(priority = 3)
	public void mrp() {
		WebElement mrpElement = driver.findElement(By.xpath(
				"/html/body/div[2]/div[3]/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div[1]/span[2]/span"));
		String text = mrpElement.getText();
		assertEquals(text, "M.R.P.:");
	}

	@Test(priority = 4, description = "Checking for the presence of add to cart button")
	public void addToCart() {
		assertTrue(driver.findElement(By.xpath(
				"/html/body/div[2]/div[3]/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div/div[1]/div/div[4]/div/button"))
				.isEnabled());
	}

	@AfterClass
	public void closeChromeWindow() {
		// driver.close();
		driver.quit();
	}
}
