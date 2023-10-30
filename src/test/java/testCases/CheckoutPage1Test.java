package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;

public class CheckoutPage1Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 check1;
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new CartPage();
		check1=new CheckoutPage1();
		login.LoginToApplication();
		invent.add6Products();
		invent.ClickcartCount();
		cart.clickCheckOutBtn();
	}
	@Test
	public void verifyURLOfCheckOutPage1Test() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,8);//https://www.saucedemo.com/checkout-step-one.html
		String actURL=check1.verifyURLOfCheckOutPage1();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of cart page = "+actURL);
	}
	@Test
	public void inputInfo() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,9);//https://www.saucedemo.com/checkout-step-two.html
		String actURL=check1.inputInfo();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of cart page = "+actURL);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
