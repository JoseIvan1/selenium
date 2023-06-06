package Scripts;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GooglePage;
import Poms.TAP;

public class Sesion6 {

private WebDriver driver;
	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https:/www.google.com");
		GooglePage gp = new GooglePage(driver);
		TAP tap = new TAP(driver);
		Thread.sleep(3000);
		gp.typeOnSearchBar("Automation Testing Practice");
		Thread.sleep(1000);
		gp.clickResultById(0);
		
		Thread.sleep(1000);
		tap.clickOnWikipediaTesting();
		tap.clickOnWikipediaTesting();
		tap.clickOnWikipediaTesting();
		tap.clickOnWikipediaTesting();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(tabs2.get(1));
		driver.get("https://www.google.com.mx/");
		driver.switchTo().window(tabs2.get(2));
		driver.get("https://www.youtube.com/");
		driver.switchTo().window(tabs2.get(3));
		driver.get("https://www.amazon.com.mx/");
		driver.switchTo().window(tabs2.get(4));
		driver.get("https://www.mercadolibre.com.mx/");
		
		for(int i = 0; i < tabs2.size(); i++) {
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(i));
			if(driver.getTitle().equals("Google")) {
				System.out.println(driver.getTitle());
				break;
			}
		}
	}
	@After
	public void teardown() {
		
		//driver.quit();
	}
}