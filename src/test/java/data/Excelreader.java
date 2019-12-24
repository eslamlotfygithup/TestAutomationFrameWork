package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {


	static FileInputStream fs= null;


	public FileInputStream getFileInputStream() throws FileNotFoundException 
	{
		String path= System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.xlsx";
		File filesouce = new File(path);
		fs = new FileInputStream(filesouce);
		return fs;	
	}



	public Object [][] getExcelData() throws IOException{
		fs = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet =  wb.getSheetAt(0);
		int totalnumofrows= (sheet.getLastRowNum()+1);
		int totalnumofcols = 4;

		String [][] arraysExcelsData = new String [totalnumofrows][totalnumofcols];
		for (int i = 0; i <totalnumofrows; i++) {
			for (int j = 0; j < totalnumofcols; j++) {
				XSSFRow row = sheet.getRow(i);
				arraysExcelsData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arraysExcelsData;
	}
}