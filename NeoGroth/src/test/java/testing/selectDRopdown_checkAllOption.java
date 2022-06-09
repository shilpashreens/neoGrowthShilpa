package testing;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genricLibrary.BaseTest;
import genricLibrary.FileLib;
import genricLibrary.WebComLib;
import webPOM.FormPage;

public class selectDRopdown_checkAllOption extends BaseTest
{
	@Test
	public void verifyAllOPtionBE() throws Throwable 
	{
		Thread.sleep(2000);
		test=extent.createTest("verify all dropdown option in Business Experience*");
		SoftAssert softAssertions = new SoftAssert();

		FormPage formpage=new FormPage(driverWeb);
		
		FileLib flib=new FileLib();
		WebComLib webcom=new WebComLib();
		formpage.accept().click();
		formpage.selectDDBE().click();
		Thread.sleep(2000);
		
		List<WebElement> optionsDD=webcom.displayAllDropdown(formpage.selectDDBE());
		System.out.println(optionsDD.size());
		int count=0;
		for (int i = 0; i < optionsDD.size(); i++)
		{
			String optionEXcel=flib.getCellValue(EXCEL_PATH, "Sheet1", 0, i+1);
			System.out.println(optionEXcel);
			String optionApp=optionsDD.get(i).getText();
			System.out.println(optionApp);
			
			if (optionEXcel.equalsIgnoreCase(optionApp))
			{
				count++;
				
			}
			
		}
		System.out.println(count);
		System.out.println(flib.getCellValue(EXCEL_PATH, "Sheet1", 1, 1));
	    String c = flib.getCellValue(EXCEL_PATH, "Sheet1", 1, 1);
		int a= Integer.parseInt(flib.getCellValue(EXCEL_PATH, "Sheet1", 1, 1));
		if (count==a)
		{
			
				softAssertions.assertTrue(true);
				test.info("Pass: All the options are displayed under Bussiness experience");
				System.out.println("Pass: All the options are displayed under Bussiness experience");
		}
		else 
		{
			softAssertions.assertFalse(true);
			test.info("Fail: All the options are not displayed under Bussiness experience");
			System.out.println("Fail: All the options are not displayed under Bussiness experience");
		}
		driverWeb.quit();
		softAssertions.assertAll();
		
	}

}
