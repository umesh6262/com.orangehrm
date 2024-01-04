package manager;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.test.BaseTest;
import utility.Utility;

public class TestManager {

	private static ExtentReports extent = ReportManager.getReportManager().getExtentReporter();
	private static Map<Long, ExtentTest> testMapper = new HashMap<>();

	private static String getMethodName(ITestResult result) {
		// return current calling tests method name
		return result.getMethod().getConstructorOrMethod().getName();
	}

	public static void onTestStart(Long threadId, ITestResult result) {
		// adding test in mapper, //passing test name and test description to
		// createTest(name,description)
		
		ExtentTest test = extent.createTest( getMethodName(result), result.getMethod().getDescription());

		WebDriver driver = ((BaseTest) result.getInstance()).getWebDriver();
		RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;
		String platformName = remoteDriver.getCapabilities().getPlatformName().toString();

		test.assignDevice(platformName)
			.assignDevice(remoteDriver.getCapabilities().getBrowserName())
			.assignCategory(result.getMethod().getGroups()) // adding groups to the test cases
			.log(Status.INFO, "Execution Started ");

		testMapper.put(threadId, test);
		System.out.println(Thread.currentThread().threadId() + " : " + testMapper);
	}

	public static void onTestSuccess(Long threadId, ITestResult result) {
		if (testMapper.containsKey(threadId)) {
			ExtentTest test = testMapper.get(threadId);
			test.log(Status.PASS, "Test Passed ");
			removeTestFromTestMapper(threadId);
		}
//		test.pass("Test Passed ");
	}

	public static void onTestFailure(Long threadId, ITestResult result) {
		BaseTest testPage = (BaseTest) (result.getInstance());

		String imageBase64 = Utility.getScreenshotAsBase64(testPage.getWebDriver());

		String destinationFilePath = Utility.getScreenshotAsFile(testPage.getWebDriver(), result.getName());
		if (testMapper.containsKey(threadId)) {
			ExtentTest test = testMapper.get(threadId);
			test.log(Status.FAIL, result.getThrowable())
				.addScreenCaptureFromBase64String(imageBase64)
				.addScreenCaptureFromPath(destinationFilePath);
			
			removeTestFromTestMapper(threadId);
		}
	}

	public static void onTestSkipped(Long threadId, ITestResult result) {
		if (testMapper.containsKey(threadId)) {
			ExtentTest test = testMapper.get(threadId);
			test.log(Status.SKIP, result.getThrowable());
			removeTestFromTestMapper(threadId);
		}
	}

	public static synchronized void onFinish() {
		// writes/updates the test information of reporter to the destination type(HTML
		// file)
		extent.flush();
	}

	public static ExtentTest getExtentTest(Long threadId) {
		return testMapper.get(threadId);
	}

	public static void addLogToTest(Long threadId, String logMsg) {
		if (testMapper.containsKey(threadId)) {
			ExtentTest test = testMapper.get(threadId);
			test.log(Status.INFO, logMsg);
		}
	}

	public static void assignAuthorToTest(Long threadId, String authorName) {
		System.out.println("adding Author *TestManager* "+ testMapper + " : " + Thread.currentThread().threadId());
		
		Set<Entry<Long, ExtentTest>> mapIterator = testMapper.entrySet();
		
		for(Entry<Long, ExtentTest> entry :  mapIterator) {
			Long id = entry.getKey();
			System.out.println(id + " : " + threadId);
			if( id.equals(threadId)  ) {
				System.out.println("Adding Author "+ authorName);
				ExtentTest test = entry.getValue();
				test.assignAuthor(authorName);
			}
		}
		
	}

	private static void removeTestFromTestMapper(Long threadId) {
		extent.flush();
		testMapper.remove(threadId);
	}
}
