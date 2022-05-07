package genricLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;


public class BaseTest implements AutoConst {
	
	public static WebDriver driverWeb;
	public FileLib flib = new FileLib();
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriverWait wait;
	
	@BeforeSuite
	public void setupReport()
	{
        // start reporters
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./reports/extent.html");
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
	}
	
	@AfterMethod
    public void getResult(ITestResult result) throws Throwable
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test method FAILED due to below issues:", ExtentColor.RED));
            TakesScreenshot ts=(TakesScreenshot) driverWeb;
    		File src=ts.getScreenshotAs(OutputType.FILE);
    	
    		File dest=new File("./reports/Screenshot/" + result.getName()+ ".png");
    		try 
    		{
    			Files.copy(src, dest);
    		
    		} 
    		catch (IOException e) 
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("./reports/Screenshot/"+result.getName()+".png").build());//not visible in local system but seen on other system
            // test with snapshot
            test.addScreenCaptureFromPath("../reports/Screenshot/"+result.getName()+".png");//visiable in local system but not on others system
    		test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
	

	@BeforeClass
	public void chooseBrowser() throws Throwable 
	{
		
			System.out.println("Enter the Required browser : Chrome/firefox???");
			//Scanner sc=new Scanner(System.in);
			//String str=sc.nextLine();
			String browser=flib.getKeyPropertyvalue(PROP_PATH, "BROWSER");
			System.out.println("wait...");
			if (browser.equalsIgnoreCase("chrome")) 
			{
				System.setProperty(CHROME_KEY, CHROME_PATH);
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--incognito");
				//driverWeb=new ChromeDriver(options);
				//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
				driverWeb=new ChromeDriver();
				
			}
			else if (browser.equalsIgnoreCase("firefox")) 
			{

				System.setProperty(FIREFOX_KEY, FIREFOX_PATH);
				
				driverWeb=new FirefoxDriver();
			}
			driverWeb.manage().deleteAllCookies();
			driverWeb.get(flib.getKeyPropertyvalue(PROP_PATH, "URL"));
			Thread.sleep(2000);
			driverWeb.manage().window().maximize();
	}
	

	//@BeforeMethod
	public void launchWebApp() throws Throwable
	{
		//login to application
		
	}
	
	
	public void logout_webApp() throws Throwable
	{
		
	}
	@AfterSuite
	public void teardownReport() throws Throwable 
	{
		 extent.flush();
	
	}
	

}