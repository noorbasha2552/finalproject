package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.base.TestBase;



public  class Screenshot extends TestBase{
	public static String screenname;
		
	public static void screen() throws IOException {
	Date d=new Date();		
	String screenname =d.toString().replace(":","_").replace(" ","_")+"error";
	File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(img, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenname+".jpg"));
	
	
	

}}
