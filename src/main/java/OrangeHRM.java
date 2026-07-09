import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class OrangeHRM {
    public static void main(String[] args) throws Exception{
        ExtentReports test = new ExtentReports();
        ExtentSparkReporter sp = new ExtentSparkReporter("reports/a.html");

        test.attachReporter(sp);

        ExtentTest tt = test.createTest("HR Management");

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);

        capture(driver,tt,"01_Home");

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        capture(driver,tt,"02_Dashboard");
    }

    public static void capture(WebDriver driver,ExtentTest test,String name) throws Exception{
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("reports" + name + ".png");

        Files.copy(src.toPath(),dest.toPath(),StandardCopyOption.REPLACE_EXISTING);

        test.addScreenCaptureFromPath(name + ".png");

    }

}
