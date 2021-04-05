package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T2 {
	WebDriver driver;

	@BeforeClass
	public void openAmazon() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.Udemy.com/");
		Thread.sleep(5000);
	}

	@Test
	public void search() {
		WebElement searchbar = driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[3]/div[2]/form/input[2]"));
		searchbar.sendKeys("unreal engine");
		WebElement searchbutton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[2]/form/button"));
		searchbutton.click();
	}

	@AfterClass
	public void closeChromeWindow() {
		driver.quit();
	}
}
