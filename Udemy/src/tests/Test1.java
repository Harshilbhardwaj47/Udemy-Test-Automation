package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\firefoxdriver\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.navigate().to(
				"https://www.udemy.com/join/signup-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2Flogout%2F");

		giveInput("id_fullname", "Harshil bhardwaj", driver);
		giveInput("email--1", "500068580@stu.upes.ac.in", driver);
		giveInput("password", "123456", driver);
		clickById("submit-id-submit", driver);

		// clickByXpath("/html/body/div[1]/div[1]/div[2]/div[7]/a/span", driver);
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
