package TryTestNG.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class TakeScreenshotConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yluo2\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.amazon.com");
		
		//Take screenshot and store as a file format
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		 try{
		java.io.File src = scrShot.getScreenshotAs(OutputType.FILE);
		//now copy the screenshot to desired location using copyFile
		FileUtils.copyFile(src, new File("C:\\Users\\yluo2\\Downloads\\amazon.png"));
		
		 }
		 catch(Exception e){
             //if it fails to take screenshot then this block will execute
             System.out.println("Failure to take screenshot "+e);
      }  
	}

}
