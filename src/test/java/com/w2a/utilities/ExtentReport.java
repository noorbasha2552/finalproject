package com.w2a.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport {

	public static ExtentReports extn;
	public static ExtentReports getInstance() {
	
	if(extn==null) {
		extn=new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\Extent.html",true,DisplayOrder.OLDEST_FIRST);
		extn.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Extent\\exconfig.xml"));
	}
	return extn;
}}
