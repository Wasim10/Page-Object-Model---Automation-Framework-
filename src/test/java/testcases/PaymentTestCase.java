package testcases;

import org.testng.annotations.Test;

import pages.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PaymentPage;
import utility.ReadExcelFile;

public class PaymentTestCase extends BaseTest {
	//Test
String fileName=System.getProperty("user.dir")+"\\TestData\\TestPortalData.xlsx";
	// All Tested 
	@Test(priority =1)
	void testcourses()
	{  // just changes 
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		lp.loginToPortal(username, password);
		
		DashboardPage dp = new DashboardPage(driver);
		
		dp.dashboardClick();
		
		PaymentPage pg= new PaymentPage(driver);
		String crdnum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 0);
		String expdate=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 1);
		String cvcnum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 2);
		
		pg.paymentOption(crdnum, expdate, cvcnum);
		
	}


}
