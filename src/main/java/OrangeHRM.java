import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class OrangeHRM {

    public static void main(String[] args) throws Exception {

        // Create reports directory if it doesn't exist
        new File("reports").mkdirs();

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/a.html");

        extent.attachReporter(spark);

        ExtentTest test = extent.createTest("HR Management");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);

        capture(driver, test, "01_Home");

        driver.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);

        capture(driver, test, "02_Dashboard");

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(3000);

        capture(driver, test, "03_PIM");

        extent.flush();
        driver.quit();
    }

    public static void capture(WebDriver driver, ExtentTest test, String name) throws Exception {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("reports/" + name + ".png");

        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

        test.addScreenCaptureFromPath(name + ".png");
    }
}