package ExtentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ExtentReport {
    private ExtentSparkReporter HTMLReporter;
    private ExtentReports Extent;
    private ExtentTest TestReport;

    private final String PathToProject = System.getProperty("user.dir")+"/target/report/";

    public ExtentReport(String ReportName) {
        CreateDirectory();
        DeleteFiles();
        CreateReport(ReportName);

    }

    public ExtentReport() {
        CreateDirectory();
        DeleteFiles();
        CreateReport();

    }

    public void CreateDirectory(){
        File Directory = new File(PathToProject);
        if (!Directory.exists()){
            Directory.mkdirs();
        }
    }

    public void DeleteFiles(){
        File Directory = new File(PathToProject);
        File[] ListFiles = Directory.listFiles();
        for (Integer index=0; index<ListFiles.length; index++){
            ListFiles[index].delete();
        }
    }

    public void CreateReport(String ReportName){
        HTMLReporter = new ExtentSparkReporter("target/report/" +ReportName+ ".HTML");
        HTMLReporter.config().setTheme(Theme.DARK);
        Extent = new ExtentReports();
        Extent.attachReporter(HTMLReporter);
        TestReport = Extent.createTest(""+ReportName+"- Report");
        attachReport("Info", "---Start "+ReportName+" Report---");
    }

    public void CreateReport(){
        HTMLReporter = new ExtentSparkReporter("target/report/Report.HTML");
        HTMLReporter.config().setTheme(Theme.DARK);
        Extent = new ExtentReports();
        Extent.attachReporter(HTMLReporter);
    }


    public void attachReport(String entryType, String message){
        if (entryType.equals("Info")){
            TestReport.log(Status.INFO, message);
        }
        if (entryType.equals("Pass")) {
            TestReport.log(Status.PASS, message);
        }

    }

    //Implementam o logica care sa faca un screenshot
    public String getScreenshot(WebDriver driver, String reportName){
        String path = PathToProject+reportName+".png";
        byte [] imageBytes;
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
            imageBytes = IOUtils.toByteArray(Files.newInputStream(Paths.get(path)));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(imageBytes);

    }

    public void attachReport(String entryType, String message, WebDriver driver, String reportName){
        if (entryType.equals("Fail")){
            TestReport.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver, reportName)).build());
        }

    }

    public ExtentReports getExtent() {
        return Extent;
    }

    public ExtentTest getTestReport() {
        return TestReport;
    }
}
