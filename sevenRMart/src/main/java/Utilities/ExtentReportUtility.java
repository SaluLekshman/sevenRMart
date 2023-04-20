package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	static ExtentReports extent;
    public synchronized static ExtentReports createExtentReports() 
    {
        
        String path =System.getProperty("user.dir")+"\\extent-reports\\extent-report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("SevenRMartSuperMarket Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "SALU");
	    extent.setSystemInfo("Blog Name", "SevenRmartSuperMarket");
		extent.setSystemInfo("purpose", "Online purchase");
		return extent;
        
		
}
}
