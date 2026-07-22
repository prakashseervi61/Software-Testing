import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");

        WebElement frame = driver.findElement(By.id("singleframe"));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hrh");
        Thread.sleep(1000);
        driver.quit();

        driver.switchTo().defaultContent();
    }
}
