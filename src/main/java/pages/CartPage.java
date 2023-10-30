package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	@FindBy(xpath="//span[@class='title']") WebElement titleOfCartPage;
	@FindBy(xpath="//button[@id='checkout']") WebElement checkOutBtn;
	public CartPage()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();	
	}
	public String verifyTitleCartPage()
	{
		return titleOfCartPage.getText();
	}
	public void clickCheckOutBtn()
	{
		checkOutBtn.click();
	}
}
