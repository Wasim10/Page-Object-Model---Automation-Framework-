package testcases;

import org.testng.annotations.Test;

import pages.BaseTest;
import pages.LoginPage;
import pages.SearchPage;
import utility.ReadExcelFile;

public class SearchTestCase extends BaseTest {
	
	
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestPortalData.xlsx";
	
	@Test(priority =1)
	void searchCourseTest()
	{
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		lp.loginToPortal(username, password);
		
		SearchPage sp= new SearchPage(driver);
		String serachCourse=ReadExcelFile.getCellValue(fileName, "SearchCourse", 0, 0);
		sp.serachCourse(serachCourse);
	}



}
