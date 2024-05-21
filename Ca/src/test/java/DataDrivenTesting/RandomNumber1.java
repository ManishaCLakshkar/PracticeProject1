package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class RandomNumber1 {
				
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Random r = new Random();
		 int randomInt = r.nextInt();

		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\testscript1.xlsx");
	Workbook	wb=WorkbookFactory.create(fis);
	String data=wb.getSheet("org").getRow(1).getCell(2).getStringCellValue() + randomInt;
	System.out.println(data);
	}

}
