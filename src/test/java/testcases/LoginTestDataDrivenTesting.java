package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BaseTest;
import pages.LoginPage;
import utility.ReadExcelFile;

public class LoginTestDataDrivenTesting extends BaseTest {

    // ✅ Fixed the file path construction
    String fileName = System.getProperty("user.dir") + "\\TestData\\TestInfo.xlsx";

    @Test(priority = 1, dataProvider = "LoginDataProvider")
    void verifyLogin(String userEmail, String userPwd) throws IOException {
        LoginPage Ip = new LoginPage(driver);
        Ip.loginToPortal(userEmail, userPwd);
       // Ip.logout();
        
        
        
        String email = userEmail.trim();
        String pwd = userPwd.trim();

        if(email.equals("Demo12") && pwd.equals("Test123456$")) {
            System.out.println("Test Passed");
            Assert.assertTrue(true);
            Ip.logout();
        } else {
            captureScreenShot(driver,"VerifyLogin");
            Assert.assertTrue(false);
        }

    }


    @DataProvider(name = "LoginDataProvider")
    public String[][] LoginDataProvider() {

        int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginData");
        int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginData");

        // ✅ Debug prints to check the data
        System.out.println("Reading Excel file: " + fileName);
        System.out.println("Sheet: LoginData, Rows: " + ttlRows + ", Columns: " + ttlColumns);

        // ✅ Safety check to avoid NegativeArraySizeException
        if (ttlRows <= 1 || ttlColumns <= 0) {
            throw new RuntimeException("Excel sheet 'LoginData' has insufficient data.");
        }

        String data[][] = new String[ttlRows - 1][ttlColumns];

        for (int i = 1; i < ttlRows; i++) {
            for (int j = 0; j < ttlColumns; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
            }
        }

        return data;
    }
}
