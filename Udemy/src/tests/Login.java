package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\firefoxdriver\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.navigate().to("https://www.udemy.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[6]/a")).click();

		giveInput("email--1", "500068580@stu.upes.ac.in", driver);
		giveInput("id_password", "123456", driver);
		clickById("submit-id-submit", driver);

		driver.quit();
	}

	static void giveInput(String id, String inputText, WebDriver driver) {
		WebElement inputTextBox = driver.findElement(By.id(id));
		inputTextBox.sendKeys(inputText);
		// give input through ID
	}

	static void clickById(String id, WebDriver driver) {
		WebElement button = driver.findElement(By.id(id));
		button.click();
		// Click through ID
	}
}
