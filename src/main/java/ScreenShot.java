import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
public class ScreenShot {
    public static void main(String[] args) throws Exception{

        ExtentReports extent=new ExtentReports();
        extent.attachReporter(new ExtentSparkReporter("reports/a.html"));
        ExtentTest ss =extent.createTest("Sample test");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(
                src.toPath(),
                new File("reports/google.png").toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );
        ss.pass("Here is the Image").addScreenCaptureFromPath("google.png");
        driver.quit();
        extent.flush();
    }
}