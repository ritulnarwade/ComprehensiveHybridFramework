package Runner;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.mindtree.utilities.ExcelDataProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PageObject.BirthdayGifts;
import PageObject.HomeAndLifestyle;
import PageObject.SearchProduct;
import PageObject.ShopByCategory;
import PageObject.OfficialMerchandise;
import PageObject.*;
import Runner.BigSmall;
import Reusable.WebDriverHelper;

import Utility.ExcelDataProvider;
import Utility.ExtentLogUtilities;

public class BigSmall extends WebDriverHelper{
	
	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	//static DataDriven d;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\" + "ExtentReportResults-"
				+ System.currentTimeMillis() + "-.html");
		log = Logger.getLogger(BigSmall.class.getName());
		
		driver = initializedriver();
	//	log.info("Driver is initialized");
		test = report.startTest("Home Page");
	//	driver.get(config.geturl());
		
		ExtentLogUtilities.pass(driver, test, "Driver Initialized", log);
		report.endTest(test);
		report.flush();
		
	}
	@Test(priority=1)
	public void Allofit() throws IOException
	{
		test = report.startTest("Allofit page");
		driver.get(config.geturl());
		Allofit a = new Allofit(driver);
		a.allofit().click();
		a.allofitprod().click();
		if(a.gettext().getText().contains("Vintage Window Photo Frame"))
		{
			Assert.assertTrue(true);
			ExtentLogUtilities.pass(driver, test, "Text verified successfully", log);
		}
		else
		{
			Assert.assertFalse(false);
			ExtentLogUtilities.fail(driver, test, "Text unverified", log);
		}
		a.addtocart().click();
		
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=2)
	public void searchprod() throws IOException
	{
		excel = new ExcelDataProvider();
		test = report.startTest("Home Page");
		driver.get(config.geturl());
		SearchProduct sp = new SearchProduct(driver);
		sp.searchprod().sendKeys(excel.getStringdata("TestData", 0, 0));
		sp.searchprod().sendKeys(Keys.ENTER);
		sp.selectprod().click();
		sp.Addtocart().click();
		ExtentLogUtilities.pass(driver, test, "passed search product test case", log);
		report.endTest(test);
		report.flush();
		//driver.quit();
	}
	
	@Test(priority=3)
	public void birthdaygifts() throws IOException
	{
		test = report.startTest("BirthdayGifts Page");
		driver.get(config.geturl());
		BirthdayGifts bg = new BirthdayGifts(driver);
		WebElement ele= bg.hover();
    	Actions action = new Actions(driver);
    	action.moveToElement(ele).perform();
    	bg.gifts().click();
    	bg.mug().click();
    	bg.addtocart().click();
    	ExtentLogUtilities.pass(driver, test, "passed birthday gifts test cases", log);
		report.endTest(test);
		report.flush();
    	//driver.quit();
	}
	
	@Test(priority=4)
	public void shopbycategory() throws IOException
	{
		test = report.startTest("Shopbycategory Page");
		driver.get(config.geturl());
		ShopByCategory sb = new ShopByCategory(driver);
		WebElement ele= sb.ShopByhover();
    	Actions action = new Actions(driver);
    	action.moveToElement(ele).perform();
    	sb.facemasklink().click();
    	sb.facemaskprod().click();
    	sb.addtocart();
    	ExtentLogUtilities.pass(driver, test, "passed shopbycategory test case", log);
		report.endTest(test);
		report.flush();
    	
	}
	
	@Test(priority=5)
	public void Homeandlifestyle() throws IOException
	{
		test = report.startTest("Home and lifestyle Page");
		driver.get(config.geturl());
		HomeAndLifestyle hl = new HomeAndLifestyle(driver);
		WebElement ele= hl.lifestylehover();
    	Actions action = new Actions(driver);
    	action.moveToElement(ele).perform();
    	hl.lamplink().click();
    	hl.lampprod().click();
    	hl.addtocart().click();
    	ExtentLogUtilities.pass(driver, test, "passed lifestyle test case", log);
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=6)
	public void OfficialMerchandise() throws IOException
	{
		test = report.startTest("officialmerchandise Page");
		driver.get(config.geturl());
		OfficialMerchandise om = new OfficialMerchandise(driver);
		WebElement ele= om.merchandisehover();
    	Actions action = new Actions(driver);
    	action.moveToElement(ele).perform();
    	om.batmanlink().click();
    	om.batmanproduct().click();
    	ExtentLogUtilities.pass(driver, test, "passed Merchandise test case", log);
		report.endTest(test);
		report.flush();

	}
	
	
	
	@Test(priority=7)
	public void WhatsNew() throws IOException
	{
		test = report.startTest("Whatsnew Page");
		driver.get(config.geturl());
		WhatsNew w = new WhatsNew(driver);
		w.NewButton().click();
		w.Newproduct().click();
		w.addtocart().click();
		ExtentLogUtilities.pass(driver, test, "passed Whatsnew test case", log);
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=8)
	public void PersonalizedGifts() throws IOException
	{
		test = report.startTest("personalizedgifts Page");
		driver.get(config.geturl());
		PersonalizedGifts p = new PersonalizedGifts(driver);
		p.pgiftslink().click();
		p.productlink().click();
		p.addtocart().click();
		ExtentLogUtilities.pass(driver, test, "passed personalizedtestcase test case", log);
		report.endTest(test);
		report.flush();


	}
	@Test(priority=9)
	public void CorporateGifts() throws IOException
	{
		test = report.startTest("CorporateGifts Page");
		driver.get(config.geturl());
		CorporateGifts cg = new CorporateGifts(driver);
		cg.cglink().click();
		cg.getname().sendKeys("abc");
		cg.getemail().sendKeys("abc@gmail.com");
		cg.getphone().sendKeys("123456");
		cg.submit().click();
		ExtentLogUtilities.pass(driver, test, "passed corporategifts test case", log);
		report.endTest(test);
		report.flush();
		

	}
	
	@Test(priority=10)
	public void ChristmasGifts() throws IOException
	{
		test = report.startTest("ChristmasGifts page");
		driver.get(config.geturl());
		ChristmasGifts ch = new ChristmasGifts(driver);
		ch.chrisgifts().click();
		//ch.christproduct().click();
		Select featured = new Select(ch.dropdown());
		featured.selectByValue("title-ascending");
		ch.product().click();
		
		ExtentLogUtilities.pass(driver, test, "passed ChristmasGifts test case", log);
		report.endTest(test);
		report.flush();
		driver.quit();


	}

}
