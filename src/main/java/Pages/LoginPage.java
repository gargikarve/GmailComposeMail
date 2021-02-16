package Pages;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	private By emailId = By.xpath("//input[@id='identifierId']");
	private By nextBtnOnEmail = By.xpath("//div[@id='identifierNext']"); ////span[@class='VfPpkd-vQzf8d']
	private By passwd = By.xpath("//input[@name='password']");
	private By nextBtnOnPasswd= By.xpath("//div[@class='qhFLie']");

	// actions

	public String getTitleLoginPg() {
		return driver.getTitle();
	}
	
	public void enters_email(String email) {
		driver.findElement(emailId).sendKeys(email);

	}

	public void enters_password(String password) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(passwd).sendKeys(password);

	}

	public void click_NextEmail() {
		
		driver.findElement(nextBtnOnEmail).click();

	}
	public void click_NextPassword() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(passwd).sendKeys(Keys.ENTER);

	}

	public String login_Title() {

		String ttl = driver.getTitle();
		return ttl;
	}
	public ComposeMailPage doLogin(String em, String pwd) throws InterruptedException {
		driver.findElement(emailId).sendKeys(em);
		Thread.sleep(3000);
		driver.findElement(nextBtnOnEmail).click();
		Thread.sleep(3000);
		driver.findElement(passwd).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(passwd).sendKeys(Keys.ENTER);
		
		return new ComposeMailPage(driver);
		
	}

}
