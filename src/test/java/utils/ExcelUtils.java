package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<String[]> readLoginData(String filePath, int sheetIndex) throws Exception {
        List<String[]> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String username = formatter.formatCellValue(row.getCell(0));
            String password = formatter.formatCellValue(row.getCell(1));
            data.add(new String[]{username, password});
        }

        workbook.close();
        fis.close();
        return data;
    }
}
