package genricLibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

@SuppressWarnings("unchecked")
public class CustomWait extends BaseTest
{
	public void implicitWait(int sec) 
	{
		driverWeb.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public void visibilityOf(AndroidElement element,int sec ) 
	{
		wait=new WebDriverWait((AndroidDriver<AndroidElement>) driverWeb, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.vi));
	}
	
	
	public void textToBePresentInElement(AndroidElement element,int sec,String text ) 
	{
		wait=new WebDriverWait((AndroidDriver<AndroidElement>) driverWeb, sec);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		
	}
	
	public void visibilityOf_InWeb(WebElement element,int sec ) 
	{
		wait=new WebDriverWait(driverWeb, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public void textToBePresentInElement_InWeb(WebElement element,int sec,String text ) 
	{
		wait=new WebDriverWait( driverWeb, sec);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		
	}
	
	public void elementToBeClickable_Inweb(WebElement element,int sec) 
	{
		wait=new WebDriverWait( driverWeb, sec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	
	public void invisibilityOfElement(WebElement element,int sec) 
	{
		wait=new WebDriverWait(driverWeb, sec);
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	
	public void invisibilityOfElement_mobile(AndroidElement element,int sec) 
	{
		wait=new WebDriverWait(driverWeb, sec);
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	public void elementTobeClickable_In_mobile(AndroidElement element,int sec)
	{
		AndroidDriver<AndroidElement> driverMob = (AndroidDriver<AndroidElement>)driverWeb;
		
		WebDriverWait wait=new WebDriverWait(driverMob, sec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	
	
	
	
}
