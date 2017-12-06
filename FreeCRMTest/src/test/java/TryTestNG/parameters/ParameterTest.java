package TryTestNG.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"env", "browser","url","emailId"})
	public void yahooLoginTest(String env, String browser, String url, String emailId,String passwd) {
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yluo2\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\yluo2\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		
		
		driver.findElement(By.xpath("//*[@id = 'login-username'] ")).clear();
		driver.findElement(By.xpath("//*[@id = 'login-username'] ")).sendKeys(emailId);
	
		driver.findElement(By.xpath("//*[@id='login-signin']")).click();
		
//		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'login-passwd'] ")));
//		driver.findElement(By.xpath("//*[@id = 'login-passwd'] ")).clear();
//		driver.findElement(By.xpath("//*[@id = 'login-passwd'] ")).sendKeys(passwd);
//		
//		driver.findElement(By.xpath("//*[@id='login-signin']")).click();
	}

}
