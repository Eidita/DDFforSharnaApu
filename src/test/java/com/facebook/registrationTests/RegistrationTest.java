package com.facebook.registrationTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.BaseTest;
import com.facebook.registrationPages.RegistrationPage;
import com.facebook.utilities.ExcelReader;

public class RegistrationTest extends BaseTest {
	RegistrationPage regPage;
	ExcelReader exReader;// make instance
	String file = "src/test/resources/registration.xlsx";
	String sheetName = "Sheet1";

	@BeforeMethod
	public void openFacebook() {
		openApp();

	}

	@Test
	public void createRegistrationTest() {
		regPage = new RegistrationPage(driver);
		regPage.createNewAccountButton();
		exReader = new ExcelReader(file, sheetName);
		regPage.firstNameMethod(exReader.getStringCellValue(1, 0));
		regPage.lastNameMethod(exReader.getStringCellValue(1, 1));
		regPage.mobileOrEmailMethod(exReader.getStringCellValue(1, 2));
		regPage.mobileOrEmail1Method(exReader.getStringCellValue(1, 3));
		regPage.newPasswordMethod(exReader.getStringCellValue(1, 4));
		
		

	}

	// @AfterMethod
	public void closeFacebook() {
		closeApp();
	}

}
