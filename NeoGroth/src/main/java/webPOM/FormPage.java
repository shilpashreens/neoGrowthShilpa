package webPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage 
{
	@FindBy(xpath = "//form[@id='crm-form']//input[@name='first_name']")
	private WebElement fullName;
	
	public WebElement getfullName()
	{
		return fullName;
		
	}
	
	@FindBy(xpath = "//form[@id='crm-form']//input[@id='phone_mobile']")
	private WebElement phnum;
	
	public WebElement phnum()
	{
		return phnum;
		
	}
	
	@FindBy(xpath = "//a[@id='cn-accept-cookie']")
	private WebElement accept;
	public WebElement accept() 
	{
		return accept;
		
	}
	
	@FindBy(xpath = "//form[@id='crm-form']//input[@id='email1']")
	private WebElement email;
	
	public WebElement email()
	{
		return email;
		
	}
	
	@FindBy(xpath = "//form[@id='crm-form']//button[text()='Submit']")
	private WebElement submit;
	
	public WebElement submit()
	{
		return submit;
		
	}

	@FindBy(xpath = "//select[@class='form-control register-forms']")
	private WebElement selectCityDD;;
	
	public WebElement selectCityDD()
	{
		return selectCityDD;
		
	}
	

	@FindBy(xpath = "//select[@name='loan_amount_c']")
	private WebElement avgSalDD;;
	
	public WebElement avgSalDD()
	{
		return avgSalDD;
		
	}
	
	@FindBy(xpath = "//select[@class='form-control register-forms selectpicker' and @id='industry_select']")
	private WebElement busIndstryDD;;
	
	public WebElement busIndstryDD()
	{
		return busIndstryDD;
		
	}
	
	@FindBy(xpath = "//label[@class='form-check-label terms_blocks yes_loanamounts terms_checkbox f-small text-weight-bold']")
	private WebElement yesButton;
	
	public WebElement yesButton()
	{
		return yesButton;
		
	}
	
	@FindBy(xpath = "//label[@class=' align-items-center terms_blocks accept_terms']")
	private List<WebElement> listOfAgreeCheckbox;
	public List<WebElement> listOfAgreeCheckbox()
	{
		return listOfAgreeCheckbox;
		
	}

	
	@FindBy(xpath = "//select[@name='average_total_monthly_sales_c']")
	private WebElement monthlyCardAndDigiSale;
	public WebElement monthlyCardAndDigiSale()
	{
		return monthlyCardAndDigiSale;
		
	}
	
	@FindBy(xpath = "//select[@name='dsa_code_c']")
	private WebElement paymentDebitCreditCard;
	public WebElement paymentDebitCreditCard()
	{
		return paymentDebitCreditCard;
		
	}
	
	@FindBy(xpath = "//div[@class='modal-dialog p-3 modal-dialog-centered']")//modal-content border-0
	private WebElement popMsg;
	public WebElement popmsg()
	{
		return popMsg;
		
	}
	
	@FindBy(xpath = "//div[@class='font-18 pb-4']")
	private WebElement thankMsg;
	public WebElement thankMsg() 
	{
		return thankMsg;
		
	}
	@FindBy(xpath = "//div[@class='font-20']")
	private WebElement regardsMsg;
	public WebElement regardsMsg() 
	{
		return regardsMsg;
		
	}
	
	@FindBy(xpath = "//div[@class='font-20 font-weight-bold']")
	private WebElement teamNeoGrowth;
	public WebElement teamNeoGrowth()
	{
		return teamNeoGrowth;
		
	}
	
	
	@FindBy(xpath = "//button[@class='close p-0 m-0 text-white']")
	private WebElement	closePopup;
	public WebElement closePopup()
	{
		return closePopup;
		
	}
	@FindBy(xpath = "//em[@id='email1-error']")////em[@id='phone_mobile-error']
	private WebElement emMail;
	
	public WebElement emMail()
	{
		return emMail;
		
	}

	@FindBy(xpath = "//em[@id='phone_mobile-error']")////em[@id='phone_mobile-error']
	private WebElement emPhone;
	
	public WebElement emPhone()
	{
		return emPhone;
		
	}
	
	@FindBy(xpath = "//select[@name='business_vintage_years_c' and  @class='form-control register-forms selectpicker ']")
	private WebElement selectDDBE;
	public WebElement selectDDBE() 
	{
		return selectDDBE;
	}
	
	
	public FormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
