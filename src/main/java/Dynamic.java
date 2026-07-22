import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.time.Duration;

public class Dynamic {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Dynamic.html");

        List<WebElement> images = driver.findElements(By.xpath("//img"));
        WebElement area = driver.findElement(By.id("droparea"));
        Actions act =new Actions(driver);

        for (WebElement image:images){
            act.dragAndDrop(image,area).perform();
            Thread.sleep(2000);

        }
    }
}
