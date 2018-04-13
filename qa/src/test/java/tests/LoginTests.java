package tests;

import base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import static org.testng.Assert.*;

public class LoginTests extends TestBase {

    @DataProvider(name="userData")
    public Object[][] loginData() {
        Object[][] arrayObject = getExcelData("C:\\dev\\incomm\\exam\\qa\\src\\test\\resources\\testdata.xls","Sheet1");
        return arrayObject;
    }

        public String[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(fileName);
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet sh = wb.getSheet(sheetName);

            int totalNoOfCols = sh.getColumns();
            int totalNoOfRows = sh.getRows();

            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];

            for (int i= 1 ; i < totalNoOfRows; i++) {

                for (int j=0; j < totalNoOfCols; j++) {
                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }

    @Test(dataProvider = "userData")
    public void loginValid(String Username, String Password, String Expected){
        LoginPage l = new LoginPage(driver);
        assertEquals(l.testLogin(Username, Password), Expected);
    }
}
