package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		login.LoginToApplication();
	}
	@Test(enabled = true,groups = {"retest"})
	public void verifyProductLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(0,3);//Products
		String actLable=invent.verifyProductLabel();
		AssertJUnit.assertEquals(expLable,actLable);
		Reporter.log("applications Lable = "+actLable);
	}
	@Test(enabled = true,groups = {"regression"})
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		AssertJUnit.assertEquals(result,true);
		Reporter.log("Visibility of Twitter Logo ="+ result);
	}
	@Test(enabled = true,groups = {"retset","sanity"},invocationCount = 3)
	public void add6ProductsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,4);//6(0,4)
		String actCount=invent.add6Products();
		AssertJUnit.assertEquals(expCount, actCount);
		Reporter.log("Total products added in to the cart: "+ actCount);
	}
	@Test(enabled = true,groups = {"retset","sanity"})
	public void remove2ProductTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,5);//4(0,5)
		String actCount=invent.remove2Product();
		AssertJUnit.assertEquals(expCount, actCount);
		Reporter.log("Count of product after removing = "+actCount);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
}
