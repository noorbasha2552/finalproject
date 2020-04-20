package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;
public class LoginTest extends TestBase{
	
	@Test
	public void LoginAsBankManager() throws InterruptedException {	
		click("bmlbtn_css");
		log.debug("able to click on the linkadd user");
		Assert.assertTrue(IsElement(By.cssSelector(OR.getProperty("AddCust_css"))));
		Reporter.log("able to click on the add cust button");
		Thread.sleep(5000);
		
		
		

	}

}
