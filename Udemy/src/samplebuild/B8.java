package samplebuild;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class B8 {
	static WebDriver driver;
	static String baseurl = "https://www.Udemy.com/";
	static String driverpath = "C:\\Softwares\\chromedriver_win32\\chromedriver.exe";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("D:\\COLLEGE\\SEM 6\\Test automation\\cred_sheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet loginDetailSheet = wb.getSheet("Login");

		String uname, pwd;

		for (int i = 1; i <= loginDetailSheet.getLastRowNum(); i++) {
			System.out.println("i=" + i);
			XSSFRow row = loginDetailSheet.getRow(i);

			if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				uname = row.getCell(0).getRawValue();
			} else {
				uname = row.getCell(0).toString(); // getStringCellValue();
			}
			pwd = row.getCell(1).toString();
			System.out.println(i + ") name: " + uname + ", password:" + pwd);
			runLoginTest(uname, pwd);
		}

	}

	public static void runLoginTest(String u, String p) {
		System.setProperty("webdriver.chrome.driver", driverpath);
		WebDriver driver = new ChromeDriver();
		driver.get(baseurl);

		driver.findElement(By.id("nav-signin-tooltip")).click();
		driver.findElement(By.id("ap_email")).sendKeys(u);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(p);
		driver.findElement(By.id("signInSubmit")).click();

	}

}