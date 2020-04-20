package com.w2a.listeners;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.Screenshot;


public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
		
		test=rep.startTest(result.getName().toUpperCase());
		}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"pass");
		rep.endTest(test);
		rep.flush();
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.FAIL,result.getName().toUpperCase()+"fails");
		rep.endTest(test);
		rep.flush();
		
		try {
			Screenshot.screen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String path=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+Screenshot.screenname;
		Reporter.log("<a target=\"blank\" href="+Screenshot.screenname+"><img src="+Screenshot.screenname+" height=200 width=200></img></a>");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
