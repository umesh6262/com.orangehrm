package manager;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.test.BaseTest;
import utility.CommonUtility;

public class TestManager {
	
	private static ExtentReports extent = ReportManager.getReportManager().getExtentReporter();
	private static Map<Long, ExtentTest> testMapper = new HashMap<>();
	
	private static String getMethodName(ITestResult result) {
		//return current calling tests method name
		 return result.getMethod().getConstructorOrMethod().getName();
	}
	public static  void onTestStart(Long threadId, ITestResult result) {
		//adding test in mapper, //passing test name to and test description to createTest(name,description)
		ExtentTest test = extent.createTest(getMethodName(result), result.getMethod().getDescription());
		test.assignDevice("LINUX").assignAuthor("Umesh Shelke");
		test.log(Status.INFO, "Execution Started " )
			.assignCategory(result.getMethod().getGroups()); //adding group info to the test
		//.assignAuthor(result.)
		testMapper.put(threadId, test);
		
	}
	
	public static  void onTestSuccess(Long threadId, ITestResult result) {
		ExtentTest test = testMapper.get(threadId);
		test.log(Status.PASS, "Test Passed ");
//		test.pass("Test Passed ");
	}
	
	public static  void onTestFailure(Long threadId, ITestResult result) {
		BaseTest testPage = (BaseTest) (result.getInstance());
		String imageBase64 = CommonUtility.getScreenshotAsBase64(testPage.getWebDriver());
		
		ExtentTest test = testMapper.get(threadId);
		test.log(Status.FAIL, result.getThrowable())
			.addScreenCaptureFromBase64String(imageBase64) ;
		
	}
	public static  void onTestSkipped(Long threadId, ITestResult result) {
		ExtentTest test = testMapper.get(threadId);
		test.log(Status.SKIP, result.getThrowable());
		
	}
	public static synchronized void onFinish() {
		//writes/updates the test information of reporter to the destination type(HTML file) 
		extent.flush();
	}
	
	public static ExtentTest getExtentTest(Long threadId) {
		return testMapper.get(threadId);
	}
	
	public static void addLogToTest(Long threadId, String logMsg) {
		ExtentTest test = testMapper.get(threadId);
		test.log(Status.INFO, logMsg);
	}
}
