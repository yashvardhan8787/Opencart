package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseTest;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String reportFolder;

    public void onStart(ITestContext testContext) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        reportFolder = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Report_" + timeStamp;

        // Create the directory if it doesn't exist
        new File(reportFolder).mkdirs();

        sparkReporter = new ExtentSparkReporter(reportFolder + File.separator + "index.html");

        sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
        sparkReporter.config().setReportName("OpenCart Functional Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub-Module", "Customer");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        if (os != null) extent.setSystemInfo("Operating System", os);
        if (browser != null) extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " got successfully executed");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
        	String fullScreenshotPath = new BaseTest().captureScreen(result.getName());
        	test.addScreenCaptureFromPath(fullScreenshotPath.replace("\\", "/"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " got skipped");
        if (result.getThrowable() != null) {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();
        try {
            File htmlFile = new File(reportFolder + File.separator + "index.html");
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
