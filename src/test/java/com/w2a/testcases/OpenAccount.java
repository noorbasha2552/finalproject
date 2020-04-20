package com.w2a.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;
import com.w2a.base.TestBase;
import com.w2a.utilities.ExcelReader;

public class OpenAccount extends TestBase{
	
	@Test(dataProvider="dat")
	public void open(String cust,String cur,String mode) throws InterruptedException {
		if(mode.equalsIgnoreCase("N")) {
			throw new SkipException ("We havent added the data related to"+cust);
		}
		click("openaccount_css");
		click("customer_css");
		Select s =new Select(driver.findElement(By.cssSelector(OR.getProperty("customer_css"))));
		s.selectByVisibleText(cust);
		click("customer_css");
		Select b =new Select(driver.findElement(By.cssSelector(OR.getProperty("currency_css"))));
		b.selectByVisibleText(cur);
		click("process_css");
		log.info("added account successfully");
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(5000);

}
	@DataProvider(name="dat")
	public String[][] dat(){
		String[][] account;
		account =ExcelReader.excel(1);
		return account;
	}}
