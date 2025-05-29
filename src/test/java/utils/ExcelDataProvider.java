package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {

    DataFormatter dataFormatter = new DataFormatter();

    @Test(dataProvider = "driveTest")
    public void testCaseData(String str1,String str2,String i1){
        System.out.println(str1+str2+i1);
    }

    @DataProvider(name = "driveTest2")
    public Object [] [] getData2(){
        Object [] [] data = {{"hello","text","1"},{"bye","message","22"}};
        return data;
    }

    @DataProvider(name = "driveTest")
    public Object [] [] getData() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//test_data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getPhysicalNumberOfCells();
        Object [][] data = new Object[rowCount-1][colCount];
        for(int i=0;i<rowCount-1;i++){
            row = sheet.getRow(i+1);
            for(int j=0;j<colCount;j++){
                data[i][j] = dataFormatter.formatCellValue(row.getCell(j));
            }
        }
        workbook.close();
        return data;
    }
}
