package subhrajitbasakacademy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter (path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extents = new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Tester", "Subhrajit Basak");
		return extents;
	}
}
