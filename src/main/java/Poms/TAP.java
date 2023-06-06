package Poms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TAP {
	
	WebDriver driver;
	String alertButtonXpath = "//button[text()='Click Me']";
	String text = "//*[@id='demo']";
	String filexXpath = "//select[@name='files']";
	String speedXpath = "//select[@name='speed']";
	String numberXpath = "//select[@name='number']";
	String buscarXpath = "//*[@id='twotabsearchtextbox']";
	

	public TAP(WebDriver driver) {
		
		super();
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void clickAlertButton() {
		
		WebElement button = this.driver.findElement(By.xpath(this.alertButtonXpath));
		button.click();
	}
	
	public void acceptAlert() {
		
		this.driver.switchTo().alert().accept();
	}
	
	public void cancelAlert() {
		
		this.driver.switchTo().alert().dismiss();
	}
	
public void printText() {
		
		WebElement fr = driver.findElement(By.xpath(text));
		System.out.println(fr.getText());
	}

public String selectCheckBoxByValue(String option) {
	
	String value = "";
	Select cb = new Select(this.driver.findElement(By.xpath(filexXpath)));
	List<WebElement> options = cb.getOptions();
	for(WebElement element:options) {
		String auxValue = element.getAttribute("value");
		if(auxValue.equals(option)) {
			value = element.getText();
		}
	}
	cb.selectByValue(option);
	return value;
}

public String selectCheckBoxByText(String option) {
	
	String value = "";
	Select cb = new Select(this.driver.findElement(By.xpath(speedXpath)));
	List<WebElement> options = cb.getOptions();
	for(WebElement element:options) {
		String auxValue = element.getAttribute("value");
		if(auxValue.equals(option)) {
			value = element.getText();
		}
	}
	cb.selectByVisibleText(option);
	return value;
}

public String selectCheckBoxByIndex(String option) {
	
	String value = "";
	Select cb = new Select(this.driver.findElement(By.xpath(numberXpath)));
	List<WebElement> options = cb.getOptions();
	for(WebElement element:options) {
		String auxValue = element.getAttribute("value");
		if(auxValue.equals(option)) {
			value = element.getText();
		}
	}
	cb.selectByVisibleText(option);
	return value;
}
/*
public void selectBuscadorByValue() {
	
	WebElement button = this.driver.findElement(By.xpath(this.buscarXpath));
	button.click();
	
}
*/
public void typeOnAmazonBar(String value) {
	
	String searchBarId = "twotabsearchtextbox";
	
	WebElement searchBar = driver.findElement(By.id(searchBarId));
	searchBar.sendKeys(value);
	searchBar.sendKeys(Keys.ENTER);
}

public void clickOnSamsung() {
	
	String SamsungXpath = "//*[@id=\"p_89/SAMSUNG\"]/span/a/span";	
	
	WebElement Sx = driver.findElement(By.xpath(SamsungXpath));
	Sx.click();
	
}

public void clickOnWikipediaTesting() {
	
	String TestingXpath = "//*[@id='Wikipedia1_wikipedia-search-form']/div/span[1]/a/img";
	
	WebElement Tx = driver.findElement(By.xpath(TestingXpath));
	Tx.click();
	
	}
}
