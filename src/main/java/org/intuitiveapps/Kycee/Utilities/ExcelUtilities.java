package org.intuitiveapps.Kycee.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelUtilities {
	public static void main(String[] args) throws IOException {
		
	FileInputStream fis= new FileInputStream("C://Users//Intuitiveapps//eclipse-workspace//Kycee//src//main//java//org//intuitiveapps//Kycee//Utilities//DemoData.xlsx");
 XSSFWorkbook workbook= new XSSFWorkbook(fis);
int sheets=workbook.getNumberOfSheets();
 for (int i = 0; i < sheets; i++) {
	if(workbook.getSheetName(i).equalsIgnoreCase("DemoData")) {
		XSSFSheet sheet=workbook.getSheetAt(i);
		Iterator<Row> rows= sheet.rowIterator();
		Row firstrow= rows.next();
		Iterator<org.apache.poi.ss.usermodel.Cell>  ce=firstrow.cellIterator();
		int k=0;
		int column = 0;
		while (ce.hasNext()) {
			org.apache.poi.ss.usermodel.Cell value=ce.next();
			if (value.getStringCellValue().equalsIgnoreCase("phone")) {
				column=k;
			}
			k++;
		}
		System.out.println(column);
		while (rows.hasNext()) {
			Row r =rows.next();
			org.apache.poi.ss.usermodel.Cell cell= r.getCell(column);
			 if (cell != null) {
                 switch (cell.getCellType()) {
                     case STRING:
                         System.out.println(cell.getStringCellValue());
                         break;
                     case NUMERIC:
                         System.out.println(cell.getNumericCellValue());
                         
                         break;
                     case BOOLEAN:
                         System.out.println(cell.getBooleanCellValue());
                         break;
                     case BLANK:
                         System.out.println("Blank cell");
                         break;
                     default:
                         System.out.println("Unknown cell type");
                 }
             }
		}
	}
}
}
}
