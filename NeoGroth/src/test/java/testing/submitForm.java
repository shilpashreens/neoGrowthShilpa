package testing;

import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genricLibrary.BaseTest;
import genricLibrary.CustomWait;
import genricLibrary.FileLib;
import genricLibrary.WebComLib;
import okio.Timeout;
import webPOM.FormPage;

public class submitForm extends BaseTest
{
	@Test
	public void submitFormSucc() throws Throwable
	{
		Thread.sleep(2000);
		test=extent.createTest("submitFormSuccessfully");
		SoftAssert softAssertions = new SoftAssert();

		FormPage formpage=new FormPage(driverWeb);
		CustomWait wait=new CustomWait();
		FileLib flib=new FileLib();
		WebComLib webcom=new WebComLib();
	
		formpage.accept().click();
		formpage.getfullName().sendKeys(flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 1));
		Thread.sleep(2000);
		
		formpage.selectCityDD().click();
		webcom.selectText(formpage.selectCityDD(), flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 2));
		Thread.sleep(2000);
		
		formpage.phnum().sendKeys(flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 3));
		Thread.sleep(2000);
		
		formpage.email().sendKeys(flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 4));
		Thread.sleep(2000);
		
		formpage.selectDDBE().click();
		webcom.selectText(formpage.selectDDBE(), flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 5));
		Thread.sleep(2000);
		
		formpage.avgSalDD().click();
		webcom.selectText(formpage.avgSalDD(), flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 6));
		Thread.sleep(2000);
		
		formpage.busIndstryDD().click();
		webcom.selectText(formpage.busIndstryDD(), flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 7));
		Thread.sleep(2000);
		
		formpage.yesButton().click();
		Thread.sleep(2000);
		
		formpage.monthlyCardAndDigiSale().click();
		webcom.selectText(formpage.monthlyCardAndDigiSale(), flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 8));
		Thread.sleep(2000);
		
		formpage.paymentDebitCreditCard().click();
		webcom.selectText(formpage.paymentDebitCreditCard(), flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 9));
		Thread.sleep(2000);
		

		//formpage.listOfAgreeCheckbox().get(0).click();
		Thread.sleep(2000);
		
		formpage.submit().click();
		Thread.sleep(2000);
		
		
		wait.visibilityOf_InWeb(formpage.popmsg(),90);
		
		System.out.println(formpage.thankMsg().getText());
		System.out.println(formpage.regardsMsg().getText());
		System.out.println(formpage.teamNeoGrowth().getText());
		
		if (formpage.popmsg().isDisplayed() && formpage.thankMsg().getText().equalsIgnoreCase(flib.getCellValue(EXCEL_PATH, "Sheet1", 2, 10)) ) 
		{
			softAssertions.assertTrue(true);
			test.info("Pass: Form is submitted successfully and popup message is displayed");
			
		}
		else 
		{
			softAssertions.assertFalse(true);
			test.info("Fail: Form is not submitted successfully and popup message is not displayed");
		}
		
		Thread.sleep(2000);
		formpage.closePopup().click();
		
		softAssertions.assertAll();
		driverWeb.quit();
	}

}
