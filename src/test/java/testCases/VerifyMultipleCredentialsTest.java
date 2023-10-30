package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class VerifyMultipleCredentialsTest extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun =true)
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	@Test
	public void LoginToApplicationTest() throws IOException
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.LoginToApplication();
		Assert.assertEquals(expURL,actURL);
	}
	@Test(dataProvider = "credentials")
	public void LoginToApplicationWithMultipleDataTest(String un,String pass) throws IOException
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.LoginToApplicationWithMultipleData(un, pass);
		s.assertEquals(expURL,actURL);
		s.assertAll();
	}
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[][]
			{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
			};
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShot.scrrenshot(it.getName());
		}
		report.flush();
		driver.close();
	}

}
