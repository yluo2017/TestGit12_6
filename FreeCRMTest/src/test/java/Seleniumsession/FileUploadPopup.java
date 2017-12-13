package Seleniumsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup {
	
	//1. alerts - JavaScript Pop Up -- Alert API(accept, dismiss)
	//2. File Upload pop up == Browse button (type - file, sendKeys(path);
	//3. Browser Windows Popup - Advertisement popup (WindowHandler API - getWindowHandles())

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yluo2\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://html.com/input-type-file/");
		//do not click "Browse" as selenium can't handle windows popup
		//type = "file" should be present for Browse/AttachFile/UploadFile buttons
		driver.findElement(By.xpath(".//*[@id='fileupload']")).sendKeys("C:\\Users\\yluo2\\Downloads\\3-Learn-the-Tool-SWOT-Analysis.pdf");

        //handle alerts we use driver.switchTo().alert()
		
		//driver.switchTo().alert().dismiss();
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().getText();	
		//driver.switchTo().alert().sendKeys("Text");
		
	}

}
