package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signin {
	@BeforeTest
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.udemy.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[7]/a")).click();

		giveInput("id_fullname", "Harshil bhardwaj", driver);
		giveInput("email--1", "500068580@stu.upes.ac.in", driver);
		giveInput("password", "123456", driver);
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

	static void clickByXpath(String xpath, WebDriver driver) {
		WebElement button = driver.findElement(By.xpath(xpath));
		button.click();
		// Click through x-path
	}
}

//This test will test the functionality of sign up 
