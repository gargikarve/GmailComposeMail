package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposeMailPage {

	private WebDriver driver;
	private String subject="TestSubject";

	public ComposeMailPage(WebDriver driver) {
		this.driver = driver;
	}

	// locator
	private By composeLink = By.xpath("//div[@class='T-I T-I-KE L3']");
	private By toEmailId = By.xpath("//td[@class='eV']//div[@class='wO nr l1']/textarea");
	private By subjectEmail = By.xpath("//input[@name='subjectbox']");
	private By msgBody = By.xpath("//div[@class='Ar Au']/div");
	private By msgBodyText = By.cssSelector(".Am.Al.editable.LW-avf");
	private By attachment = By.xpath("//div//input[@type='file']");
	private By sendBtn = By.xpath("//td[@class='gU Up']");
	// actions

	public String gmail_page_Title() {
		return driver.getTitle();
	}

	public void user_click_on_plus_icon() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(composeLink).click();
	}

	public void new_message_window_in_shown() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='aYF']")).getText();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@class='gb_Da gbii']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		driver.quit();
	}

	public void new_message_window_is_displayed() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='aYF']")).isDisplayed();
	}

	public void enter_validEmailid_Subject_Msgbody_Attachment() throws InterruptedException {

		driver.findElement(toEmailId).sendKeys("testauto2104@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@class='eV']//div[@class='wO nr l1']/textarea")).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(subject);
		driver.findElement(By.xpath("//div[@class='Ar Au']/div")).click();
		driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf")).sendKeys("This is a test mail");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div//input[@type='file']")).sendKeys("D:\\TestInfo.txt");

	}

	public void clicks_on_send_button() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@class='gU Up']")).click();
	}

	public void message_sent_subject_text_verify() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@aria-label='Sent']")).click();
		Thread.sleep(5000);
		List<WebElement> email = driver.findElements(By.xpath("//div[@class='aeF']/div/div[2]/div[4]/div[2]/div//span[@class='bqe']"));
		for (WebElement e : email) {
			if(e.getText().contains(subject)) {
			System.out.println("Message sent");
			}
		}
		driver.findElement(By.xpath("//img[@class='gb_Da gbii']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		driver.quit();
	}

}
