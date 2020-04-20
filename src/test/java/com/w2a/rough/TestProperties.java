package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Properties config  =new Properties();
		FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		try {
			config.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//config.getProperty("browser");
		System.out.println(config.getProperty("browser"));
		Properties OR  =new Properties();
		FileInputStream fs2 =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		try {
			OR.load(fs2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(OR.getProperty("bmlbtn"));
	}

}
