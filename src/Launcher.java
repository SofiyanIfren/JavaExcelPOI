import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Launcher {

	public static void main(String[] args) {
		HashMap<String, Integer> listeCourses = new HashMap<String, Integer>();
		listeCourses.put("Patate douce", 3);
		listeCourses.put("Oignons", 5);
		listeCourses.put("Carottes", 7);
		listeCourses.put("Avocat", 2);
		listeCourses.put("Citron", 3);
		listeCourses.put("Poivrons", 2);
		listeCourses.put("Pommes", 4);
		listeCourses.put("Bananes", 10);
		listeCourses.put("Kiwi", 6);
		listeCourses.put("Citrouille", 1);
		
		String XLSX_FILE_PATH = "./src/ListeCourses.xlsx";
		try {
			FileOutputStream out = new FileOutputStream(new File(XLSX_FILE_PATH));
			
			XSSFWorkbook workbook = new XSSFWorkbook();
		    XSSFSheet sheet = workbook.createSheet("Liste");
		    
		    
		    
		    
		    int index = 0;
		    Sheet sheetListe = workbook.getSheet("Liste");
		    
			for (Entry<String, Integer> mapEntry : listeCourses.entrySet()) {
				System.out.println(mapEntry.getKey());
				System.out.println(mapEntry.getValue());
				sheetListe.createRow(index);
				Row row = sheetListe.getRow(index);
				
				Cell cell_key = row.createCell(0);
	            cell_key.setCellValue(mapEntry.getKey());
	            Cell cell_value = row.createCell(1);
	            cell_value.setCellValue(mapEntry.getValue());
	            
	            index++;
			}
			
		    workbook.write(out);
            out.close();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
