package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.LoginLogoutPage;
import com.cucumberFramework.testBase.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;


public class loginLogoutPageStepDefinitions extends TestBase {

	LoginLogoutPage loginPage = new LoginLogoutPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	
	@Given("^I am on the Login page URL \"([^\"]*)\"$")
	public void i_am_on_the_Login_page_URL(String url) throws Throwable {
		driver.get(url);
		log.info("Navigated to Home page");
	}

	@Then("^I click on Form Authendication and wait for login page$")
	public void i_click_on_form_Authendication_and_wait_for_log_in_page() throws Throwable {
		loginPage.clickFormAuthendication();
		waitHelper.WaitForElement(loginPage.userName, 20);
		log.info("Click Form Authendication");
	}

	@Then("^I should see LogIn Page$")
	public void i_should_see_LogIn_Page() throws Throwable {
		loginPage.userName.isDisplayed();
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String username) throws Throwable {
		loginPage.enterUserName(username);
		log.info("Entered Username successfully");
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pwd) throws Throwable {
		loginPage.enterPassword(pwd);
		log.info("Entered Password successfully");
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		loginPage.clickLoginButton();
		log.info("Clicked Login Button");
	}
	
	@When("^I am logged in$")
	public void i_am_already_logged_in() throws Throwable {
	    loginPage.logoutBtn.isDisplayed();
	}

	@When("^I Click on Sign out$")
	public void i_Click_on_Sign_out() throws Throwable {
	    loginPage.clickLogoutButton();
	    waitHelper.WaitForElement(loginPage.userName, 20);
		log.info("Clicked Loginout Button");
	}

	@Then("^I got log out from the application and land on home page$")
	public void i_got_log_out_from_the_application_and_land_on_home_page() throws Throwable {
		loginPage.userName.isDisplayed();
		log.info("Username field displayed successfully");
	}

	@When("^I got error message$")
	public void i_got_error_message() throws Throwable {
		loginPage.errorMsg.isDisplayed();
		log.info("Error message displayed successfully");
	}


	
}