package Seleniumsession;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yluo2\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("http://www.freecrm.com");
		driver.get("https://makemysushi.com/404");
        
		
//		driver.findElement(By.name("username")).sendKeys("naveenk");
//		driver.findElement(By.name("password")).sendKeys("test@123");
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//input[@type ='submit']")).click();
//		
//		driver.switchTo().frame("mainpanel");
		
		//links --//a href<http://www.google.com>
		//images -- //img href<http://www.test.com>
		
		//1. get the list of all the links and images:
		List<WebElement> LinksList = driver.findElements(By.tagName("a"));
		LinksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of active links and images--->" + LinksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2.iterate linksList:exclude all the links/images - doesn't have any href attribute
		for(int i=0; i<LinksList.size();i++) {
			System.out.println(LinksList.get(i).getAttribute("href"));
			if(LinksList.get(i).getAttribute("href")!=null& (!LinksList.get(i).getAttribute("href").contains("javascript"))){
				activeLinks.add(LinksList.get(i));
			}
		}
		
		//get the size of active links list:
		System.out.println("size of active links and images--->" + activeLinks.size());

		
		//3. check the href url, with httpconnection API:
		//200 -- ok
		//404 -- not found
		//500 -- internal error
		//400 -- bad request
		
		for (int j = 0; j<activeLinks.size(); j++)
		{
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();//ok
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href"+ "---->"+ response));
		}
	}

}
