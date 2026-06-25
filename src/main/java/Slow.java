import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Slow {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(3000);

        WebElement login = driver.findElement(By.id("submit"));
        login.click();
        Thread.sleep(3000);

        String title = driver.getTitle();
        System.out.println("Test"+title);

        driver.quit();
    }
}