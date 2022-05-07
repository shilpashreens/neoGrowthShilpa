package testing;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genricLibrary.BaseTest;
import genricLibrary.FileLib;
import okio.Timeout;
import webPOM.FormPage;

public class ValidationMobileNum_form extends BaseTest
{
	@Test
	public void validMobileNum() throws Throwable 
	{
		Thread.sleep(2000);
		test=extent.createTest("ValidationMobileNum_form");
		SoftAssert softAssertions = new SoftAssert();

		FormPage formpage=new FormPage(driverWeb);
		
		FileLib flib=new FileLib();
		formpage.phnum().sendKeys(flib.getKeyPropertyvalue(PROP_PATH, "PhoneNum"));
		formpage.submit().click();
		
		try {
			if (formpage.emPhone().isDisplayed() && formpage.emPhone().getText().equalsIgnoreCase(flib.getKeyPropertyvalue(PROP_PATH,"emphone")))
			{
				softAssertions.assertTrue(true);
				test.info("Pass: Not accepting inavalid data and respective error message is displayed");
				System.out.println("Pass: Not accepting inavalid data and respective error message is displayed");
				System.out.println(formpage.emPhone().getText());
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			softAssertions.assertFalse(true);
			test.info("Fail: inavalid data msg not displyed");
			System.out.println("Fail: inavalid data msg not displyed");
		}
		Thread.sleep(2000);
		driverWeb.quit();
		softAssertions.assertAll();
		
	}
}
