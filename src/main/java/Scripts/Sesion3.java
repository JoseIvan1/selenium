package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GooglePage;
import Poms.TAP;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Sesion3 {

	//public Sesion3() {
		
		
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
			gp.typeOnSearchBar("Test Automation Practice");
			
			//Click en primer resultado
			Thread.sleep(1000);
			gp.clickResultById(0);
			
			tap.clickAlertButton();
			Thread.sleep(1000);
			tap.acceptAlert();
			Thread.sleep(1000);
			tap.printText();
			
			tap.clickAlertButton();
			Thread.sleep(1000);
			tap.cancelAlert();
			Thread.sleep(1000);
			tap.printText();
			//gp.clickFirstResult();
			//gp.printFirstText();
			//Búsqueda en Google
		}
		
		@After
		public void teardown() {
			
			//driver.quit();
		}
	}