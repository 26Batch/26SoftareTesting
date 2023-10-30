package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage1  extends TestBase
{
	@FindBy(xpath="//input[@id='first-name']") WebElement firstnameTxtbox;
	@FindBy(xpath="//input[@id='last-name']") WebElement lastnameTxtbox;
	@FindBy(xpath="//input[@id='postal-code']") WebElement postalCodeTxtbox;
	@FindBy(xpath="//input[@id='continue']") WebElement continueBtn;
	public CheckoutPage1()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURLOfCheckOutPage1()
	{
		return driver.getCurrentUrl();
	}
	public String inputInfo()
	{
		firstnameTxtbox.sendKeys("Harry");
		lastnameTxtbox.sendKeys("Potter");
		postalCodeTxtbox.sendKeys("414001");
		continueBtn.click();
		return driver.getCurrentUrl();
		
	}

}
