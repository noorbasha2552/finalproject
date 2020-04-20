package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExtentReport;

public class TestBase {
	
	/*webdriver
	 * Properties
	 * logs
	 * extentreports
	 * DB
	 * excel
	 * mail
	 * ReportNG
	 * ExtentREPORT
	 */
	public static WebDriver driver;
	public static Properties config  =new Properties();
	public static Properties OR  =new Properties();
	public static FileInputStream fs;
	public static WebDriverWait wait;
	public static ExtentReports rep =ExtentReport.getInstance();
	public static ExtentTest test;
	public static Logger log;
	
	
	
	@BeforeSuite
	public void setUp ()throws FileNotFoundException {
		if(driver==null) {
			FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			
			try {
				config.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//config.getProperty("browser");
			System.out.println(config.getProperty("browser"));
			
			FileInputStream fs2 =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			try {
				OR.load(fs2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(OR.getProperty("bmlbtn"));
			Logger log =Logger.getLogger(TestBase.class.getName());
			PropertyConfigurator.configure(".//src//test//resources//properties//log4j/properties");
			
		
		if(config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\exe\\chromedriver.exe");
			driver =new ChromeDriver();
			log.debug("chrome opened");
		}
		else if(config.getProperty("browser").equals("internet explorer")){
			System.out.println("you dont have it right now");
		}}
		driver.get(config.getProperty("url"));
		log.debug("open url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("wait")),TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,5);
	}
	
	public boolean IsElement(By by){
		try{
		 driver.findElement(by);
		 return true;
	}
		catch(ElementNotFoundException e)
		{
	return false;}
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
		driver.quit();
		
	}
}
	public static void click(String locator) {
		if(locator.endsWith("_css")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
	}else if(locator.endsWith("_xpath")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}
		test.log(LogStatus.INFO, "clicking on "+locator);
		
	}
	public static void type(String locator,String data) {
		if(locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(data);
		}else if(locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(data);
		}
		test.log(LogStatus.INFO, "entering "+data+" at "+locator);
	}
		
	}
