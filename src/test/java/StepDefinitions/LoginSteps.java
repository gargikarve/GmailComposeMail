package StepDefinitions;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

	private LoginPage loginPg = new LoginPage(DriverFactory.getDriver());
	private static String title = "";

	@Given("google sign in url is accessible")
	public void google_sign_in_url_is_accessible() {
		DriverFactory.getDriver().get("https://mail.google.com/");

	}

	@When("user enters email as {string}")
	public void user_enters_email_as(String email) {

		loginPg.enters_email(email);
	}
	
	@When("clicks on next buttom")
	public void clicks_on_next_buttom() {
	   loginPg.click_NextEmail();
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String passwd) throws InterruptedException {


		loginPg.enters_password(passwd);
	}
	

	@When("clicks on login")
	public void clicks_on_login() throws InterruptedException {
		
		loginPg.click_NextPassword();
	}

	@Then("User should login successfully with title as {string}")
	public void user_should_login_successfully_with_title_as(String expectedTitle) {

		title = loginPg.login_Title();
		Assert.assertTrue(title.contains(expectedTitle));
	}
}
