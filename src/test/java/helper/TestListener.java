package helper;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import manager.TestManager;


public class TestListener implements ITestListener{

//	ExtentReports extent = ReportManager.getReportManager().getExtentReporter();
	public void onTestStart(ITestResult result) {
		TestManager.onTestStart( Thread.currentThread().threadId(), result);
	}
	public void onTestSuccess(ITestResult result) {
		TestManager.onTestSuccess(Thread.currentThread().threadId(), result);
	}
	public void onTestFailure(ITestResult result) {
		TestManager.onTestFailure(Thread.currentThread().threadId(), result);
	}

	public void onTestSkipped(ITestResult result) {
		TestManager.onTestSkipped(Thread.currentThread().threadId(), result);
	}
	public void onFinish(ITestContext context) {
		//writes/updates the test information of reporter to the destination type(HTML file) 
		System.out.println("onFinish");
		TestManager.onFinish();
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart");
	}

}
