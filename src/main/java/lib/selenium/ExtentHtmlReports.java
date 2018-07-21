package lib.selenium;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentHtmlReports {

	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter report = new ExtentHtmlReporter("./reports/report.html");
		report.setAppendExisting(true);
		
		ExtentReports extReport = new ExtentReports();
		extReport.attachReporter(report);
		
		ExtentTest test = extReport.createTest("TC001_Sample", "Sample test case for report generation");
		test.assignCategory("smoke");
		test.assignAuthor("Alexander");
		
		test.pass("Step1 passed", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		test.pass("Step2 passed", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap2.jpg").build());
		test.fail("Step3 failed", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap3.jpg").build());
		extReport.flush();
	}

}
