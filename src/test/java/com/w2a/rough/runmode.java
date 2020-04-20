package com.w2a.rough;

import org.testng.SkipException;

import com.w2a.utilities.ExcelReader;

public class runmode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="AddCust";
		String[][] testcase =ExcelReader.excel(2);
		for(int i=0;i<=2;i++) {
			System.out.println(testcase[i][0]);
			System.out.println(testcase[i][1]);
			}

	}}

