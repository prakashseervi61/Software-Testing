import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.Level;
import org.testng.annotations.Test;

public class MouseClick {
    static Logger log = LogManager.getLogger(MouseClick.class);

    @Test
    public void click() throws InterruptedException{
        log.info("Chrome Driver is getting URL");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        Thread.sleep(3000);
        Actions action = new Actions(driver);

        log.trace("Double Click");
        action.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();
        Thread.sleep(2000);

        log.trace("Right Click");
        action.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
        Thread.sleep(2000);

        log.trace("Click");
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        Thread.sleep(2000);

        Configurator.setRootLevel(Level.OFF);
    }
}
