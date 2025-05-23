package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestUtil {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports initExtentReport() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void logPass(String message) {
        test.pass(message);
    }

   
    public static void logFail(WebDriver driver, String message) {
        String screenshotName = "Failure_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        logFail(driver, message, screenshotName);
    }

    
    public static void logFail(WebDriver driver, String message, String screenshotName) {
        String path = captureScreenshot(driver, screenshotName);
        try {
            test.fail(message).addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logFailAndFailTest(WebDriver driver, String message) {
        logFail(driver, message);
        throw new AssertionError(message);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static String captureScreenshot(WebDriver driver, String name) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folderPath = "screenshots";
        String filePath = folderPath + "/" + name + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File screenshotFile = new File(filePath);
            new File(folderPath).mkdirs(); 
            FileUtils.copyFile(src, screenshotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
