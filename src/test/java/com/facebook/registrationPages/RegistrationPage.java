package com.facebook.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[starts-with(@id,'u_0_0_')]")
	public WebElement createNewAccount;

	public void createNewAccountButton() {
		createNewAccount.click();
	}

	@FindBy(how = How.NAME, using = "firstname")
	private WebElement firstNm;

	public WebElement firstNameMethod(String enterFirstName) {
		firstNm.sendKeys(enterFirstName);
		return createNewAccount;

	}

	@FindBy(how = How.NAME, using = "lastname")
	private WebElement lastNm;

	public WebElement lastNameMethod(String enterLastName) {
		lastNm.sendKeys(enterLastName);
		return lastNm;

	}

	@FindBy(how = How.NAME, using = "reg_email__")
	private WebElement mobileOrEmail;

	public WebElement mobileOrEmailMethod(String entermobileOrEmail) {
		mobileOrEmail.sendKeys(entermobileOrEmail);
		return mobileOrEmail;

	}

	
	  @FindBy(how = How.NAME, using = "reg_email_confirmation__") 
	  private WebElement mobileOrEmail1;
	  
	  public WebElement mobileOrEmail1Method(String entermobileOrEmail1) {
	  mobileOrEmail1.sendKeys(entermobileOrEmail1);
	  return mobileOrEmail1;
	  
	  }
	  

	@FindBy(how = How.NAME, using = "reg_passwd__")
	private WebElement newPassword;

	public WebElement newPasswordMethod(String enternewPassword) {
		newPassword.sendKeys(enternewPassword);
		return newPassword;

	}

}
