package TryTestNG.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	//Pre-conditions annotations -- starting with @Before
	
	@BeforeSuite
	public void setUp() {
		System.out.println("@BeforeSuite--setup system property for chrome");
	}
   
	@BeforeTest
	public void launchBrowser() {
		System.out.println("@BeforeTest -- launch Chrome Browser");
	}
	

	@BeforeClass
	public void login() {
		System.out.println("@BeforeClass -- login to app");
	}
	
	
	@BeforeMethod
	public void enterURL() {
		System.out.println("@BeforeMethod--Enter URL");
	}
  
  
	// test cases -- starting with @Test
	@Test
	public void SearchTest() {
		System.out.println("@Test--Search Test");
	}
	
	@Test
	public void googleTitleTest() {
		System.out.println("@Test -- Google Title Test");
	}
	@Test
	public void googleLogTest() {
		System.out.println("@Test -- Google Logo Test");
	}

	
	//post conditions -- starting with @After
	@AfterMethod
	public void LogOut() {
		System.out.println("@AfterMethod -- Logout from App");
	}
	
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("@AfterTest -- delete All Cookies");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("@AfterClass -- Close Browser");
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("@AfterSuite-- Generate Test Report");
	}
	
    
	

	
	
}
