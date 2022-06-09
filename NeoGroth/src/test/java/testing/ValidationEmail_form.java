package testing;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genricLibrary.BaseTest;
import genricLibrary.CustomWait;
import genricLibrary.FileLib;
import webPOM.FormPage;

public class ValidationEmail_form extends BaseTest
{
	@Test
	public void validateEmail() throws Throwable
	{
		Thread.sleep(2000);
		test=extent.createTest("ValidationEmail_form");
		SoftAssert softAssertions = new SoftAssert();

		FormPage formpage=new FormPage(driverWeb);
		
		FileLib flib=new FileLib();
		CustomWait wait=new CustomWait();
		wait.visibilityOf_InWeb(formpage.accept(), 60);
		
		formpage.accept().click();
		Thread.sleep(3000);
		formpage.email().sendKeys(flib.getKeyPropertyvalue(PROP_PATH, "email"));
		
		formpage.submit().click();
		
		try {
			if (formpage.emMail().isDisplayed() && formpage.emMail().getText().equalsIgnoreCase(flib.getKeyPropertyvalue(PROP_PATH,"ememail")))
			{
				softAssertions.assertTrue(true);
				test.info("Pass: Not accepting inavalid email data and respective error message is displayed");
				System.out.println("Pass: Not accepting inavalid data and respective error message is displayed");
				System.out.println(formpage.emMail().getText());
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
