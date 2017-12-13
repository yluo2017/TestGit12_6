package Seleniumsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yluo2\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com/register/");
        
		//1.isDisplayed() method: applicable for all elements
		
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println(b1);//true
		
		//2.isEnabled() method:
        boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
        System.out.println(b2);//false
        
        //select I agree checkbox:
       driver.findElement(By.name("agreeTerms")).click();
        boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
        System.out.println(b3);//true
        
        //isSelected() method: only applicable for checkbox, dropdown,radiobutton
        boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
        System.out.println(b4);//true
        
        //de-select the checkbox
        driver.findElement(By.name("agreeTerms")).click();
        boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
        System.out.println(b5);//false
        
	}
	

}
