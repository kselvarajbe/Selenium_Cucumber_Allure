package com.cucumberFramework.pageObjects;

import com.cucumberFramework.helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLogoutPage {
	
	private WebDriver driver;

	@FindBy(xpath="//a[@href='/login']")
	WebElement formAuthendication;

	@FindBy(xpath="//input[@id='username']")
	public WebElement userName;

	@FindBy(xpath="//input[@type='password']")
	public WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//a[@href='/logout']")
	public WebElement logoutBtn;

	@FindBy(xpath="//div[@id='flash']")
	public WebElement errorMsg;



	
	
	WaitHelper waitHelper;
	
	public LoginLogoutPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void clickFormAuthendication(){
		Actions action = new Actions(driver);
		action.moveToElement(formAuthendication).perform();
		formAuthendication.click();
	}

	public void enterUserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton(){
		loginBtn.click();
	}

	public void clickLogoutButton(){
		logoutBtn.click();
	}

	public boolean IsLoginAvailable(){
		return loginBtn.isDisplayed();
	}

	public boolean IsLogOutAvailable(){
		return logoutBtn.isDisplayed();
	}
}
