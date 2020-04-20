package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;
import com.w2a.utilities.ExcelReader;

public class AddCust extends TestBase {
	
	@Test(dataProvider="data")
	public void add (String a,String b,String c) throws InterruptedException {
		click("AddCust_css");
		type("firstname_css",a);
		type("lastname_css",b);
		type("post_css",c);
		click("submit_css");
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		log.info("added customer successfully");
		Reporter.log("hi data related to"+a+"has been added");
		Thread.sleep(5000);
		//System.out.println("Groups:-"+a+"  "+b+" "+c);
			
	}
	
	@DataProvider(name="data")
	public String[][] data() {
		String [][] d= ExcelReader.excel(0);
		return d;
	}
	@Test
	public void check() {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Assert.fail("we make this test to faile");
	

}
}

