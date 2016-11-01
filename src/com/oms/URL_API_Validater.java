package com.oms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class URL_API_Validater {

	public static void main(String[] args) throws IOException {
		
		System.out.println("------------------URL's and API's Health checck Report-------------------");
	
		FileInputStream file = new FileInputStream(new File("ALLURL.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet Sheet = workbook.getSheet("Sheet1");
		for (int i=1;i<=Sheet.getLastRowNum();i++)
		{
			Row	 CurrentRow=Sheet.getRow(i);
			Cell URLcell =CurrentRow.getCell(1);

			String UrlString="";
			String responsecode="";

			if ( (URLcell==null) || (URLcell.getCellType()==Cell.CELL_TYPE_BLANK))
			{

				UrlString="";
				responsecode="Blank row in the input sheet";

			}
			else 
			{
				UrlString=URLcell.getStringCellValue();
				responsecode=LinkCheacker(UrlString);
				CurrentRow.createCell(2).setCellValue(responsecode);
				System.out.println(UrlString+"==>"+responsecode);
			}

			if ((i%100)==0)
			{
				FileOutputStream fos = new FileOutputStream(new File("ALLURL.xls"));
				workbook.write(fos);
				fos.close();
				System.out.println("------Finished ---------- : "+i+"-----------------------");
			}

		}
		FileOutputStream fos = new FileOutputStream(new File("ALLURL.xls"));
		workbook.write(fos);
		fos.close();
	}


	public static String LinkCheacker(String URLString) throws IOException
	{
		String Status;
		try
		{
			URL url = new URL(URLString);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.connect();
			Status =http.getResponseCode()+":"+http.getResponseMessage();
			http.disconnect();
		}
		catch(Exception e)
		{
			Status=":some error:"+e.getMessage();
		}
		return Status;
	}
}
