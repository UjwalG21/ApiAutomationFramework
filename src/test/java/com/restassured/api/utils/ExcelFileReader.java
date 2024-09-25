package com.restassured.api.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileReader {
	public static String filename = "/ApiAutomationFramework/Resources/Cred.xlsx";
	static Workbook workbook;
	static Sheet sheet;

	public static Object[][] readDataFromExcel(String sheetName) {
		FileInputStream inputStream = null;

		try {
			inputStream = new FileInputStream(filename);
		} catch (Exception e) {
			// TODO: handle exception

		}
		try {
			workbook = WorkbookFactory.create(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		return null;

	}

	public Object[][] getData(String sheetName) {

		return readDataFromExcel("Sheetname");

	}
}
