package genricLibrary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebComLib extends BaseTest 
{
	public void selectIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	

	public void selectText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}
	public void selectValue(WebElement element,String value)
	{
		 Select sel =new Select(element);
		 sel.selectByValue(value);
		 
	}
	
	public List<WebElement> displayAllDropdown(WebElement element)
	{
		Select sel=new Select(element);
		return sel.getOptions();
		
	}
	
	public int getlistofOption(WebElement element)
	{
		Select sel=new Select(element);
		return sel.getOptions().size();
		
	}
	
}