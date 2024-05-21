package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("org");
	Row row=sh.getRow(1);
     Cell cel=row.createCell(4);
        cel.setCellValue("pass");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\testscript1.xlsx");
        wb.write(fos);
        wb.close();
	}

}
