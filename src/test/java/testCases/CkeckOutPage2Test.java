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
import pages.CkeckOutPage2;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;

public class CkeckOutPage2Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 check1;
	CkeckOutPage2 check2;
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new CartPage();
		check1=new CheckoutPage1();
		check2=new CkeckOutPage2();
		login.LoginToApplication();
		invent.add6Products();
		invent.ClickcartCount();
		cart.clickCheckOutBtn();
		check1.inputInfo();
	}
	@Test
	public void verifycheckOutpage2LableTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,10);//Checkout: Overview
		String actURL=check2.verifycheckOutpage2Lable();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of cart page = "+actURL);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
