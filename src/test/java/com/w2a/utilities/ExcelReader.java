package com.w2a.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader<XSSFWrokbook> {
	
	public static String path=System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx";
	public static FileInputStream fl=null;
	public static FileOutputStream f2=null;
	public static XSSFWorkbook workbook =null;
	public static XSSFSheet xh=null;
		
	
	public static String[][] excel(int ind) {
		//this.path=path;
		
		try {
			fl= new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook =new XSSFWorkbook(fl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xh=workbook.getSheetAt(ind);
		int x=xh.getLastRowNum();
		int y=xh.getRow(0).getLastCellNum();
		String[][] data =new String[x][y];
			// TODO Auto-generated method stub
					
			//XSSFWorkbook workbook =new XSSFWorkbook(new File("C:\\Users\\hp\\regression\\src\\main\\java\\resource\\test.xlsx"));
			//XSSFSheet sheet =xh.getSheetAt(0);
			
			Iterator<Row> row =xh.iterator();
			int i=0;
			
			while(row.hasNext()) {
				if(i==0) {
					row.next();
				}
				Row r=row.next();
				Iterator<Cell> col=r.iterator();
				int j=0;
				while(col.hasNext()) {
					Cell c=col.next();
					if(c.getCellType()==Cell.CELL_TYPE_STRING) {
					 data[i][j]=c.getStringCellValue();}
					
					j=j+1;	}
					 
					 
					
				i=i+1;}
				
			
			
		/*for (int a=0;a<3;a++) {
			for(int j=0;j<3;j++) {
				System.out.println(data[a][j]);
			}
		}*/
			return data;
			

	}
		
		
	}


