package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Pages.ComposeMailPage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComposeSteps {
	private ComposeMailPage composePg;
	private LoginPage loginPg = new LoginPage(DriverFactory.getDriver());
	private static String title = "";
	
	@Given("I have logged into the gmail acoount with valid credentials")
	public void i_have_logged_into_the_gmail_acoount_with_valid_credentials(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>>mylist=dataTable.asMaps();
		String username=mylist.get(0).get("username");
		String passwd=mylist.get(0).get("password");
		DriverFactory.getDriver().get("https://mail.google.com/");
		composePg=loginPg.doLogin(username, passwd);
	}

	@Given("User is on gmail page")
	public void user_is_on_gmail_page() {
		String ttl=composePg.gmail_page_Title();
	}
	
	@Given("user clicks on plus icon")
	public void user_clicks_on_plus_icon() throws InterruptedException {
		  composePg.user_click_on_plus_icon(); 
	}
	@When("clicks on send button")
	public void clicks_on_send_button() throws InterruptedException {
		composePg.clicks_on_send_button();
	}
	
	
	@When("User click on Plus icon")
	public void user_click_on_plus_icon() throws InterruptedException {
	   composePg.user_click_on_plus_icon();
	}

	@Then("new message window in shown")
	public void new_message_window_in_shown() throws InterruptedException {
	  composePg.new_message_window_in_shown();
	}

	@Given("new message window is displayed")
	public void new_message_window_is_displayed() throws InterruptedException {
	   composePg.new_message_window_is_displayed();
	}

	@When("User enters valid email id,subject, msgbody , attachment")
	public void user_enters_valid_email_id_subject_msgbody_attachment() throws InterruptedException {
	    composePg.enter_validEmailid_Subject_Msgbody_Attachment();
	
	}

	@Then("Message sent text is shown to user along with view messages label")
	public void message_sent_text_is_shown_to_user_along_with_view_messages_label() throws InterruptedException {
	 composePg.message_sent_subject_text_verify();
	}


}
