package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CkeckOutPage2 extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement checkOutpage2Lable;
	@FindBy(xpath="(//div[@class='summary_info_label'])[1]") private WebElement paymentInfoLable;
	@FindBy(xpath="(//div[@class='summary_info_label'])[2]") private WebElement shippingInfoLable;
	@FindBy(xpath="(//div[@class='summary_info_label'])[3]") private WebElement priceTotalLable;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	public CkeckOutPage2()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifycheckOutpage2Lable()
	{
		return checkOutpage2Lable.getText();	
	}
	public String verifypaymentInfoLable()
	{
		return paymentInfoLable.getText();
	}
	public String verifyshippingInfoLable()
	{
		return shippingInfoLable.getText();	
	}
	public String verifypriceTotalLable()
	{
		return priceTotalLable.getText();	
	}
	public void clickfinishBtn()
	{
		finishBtn.click();
	}
}
